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
import kmsweb.dtos.BpjsTreatmentRoomEntityDto;
import kmsweb.entities.listeners.BpjsTreatmentRoomEntityListener;
import kmsweb.serializers.BpjsTreatmentRoomSerializer;
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
@EntityListeners({BpjsTreatmentRoomEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsTreatmentRoomSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsTreatmentRoomEntity extends AbstractEntity {

	/**
	 * Takes a BpjsTreatmentRoomEntityDto and converts it into a BpjsTreatmentRoomEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsTreatmentRoomEntityDto
	 */
	public BpjsTreatmentRoomEntity(BpjsTreatmentRoomEntityDto bpjsTreatmentRoomEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsTreatmentRoomEntityDto.getId() != null) {
			this.setId(bpjsTreatmentRoomEntityDto.getId());
		}

		if (bpjsTreatmentRoomEntityDto.getKode() != null) {
			this.setKode(bpjsTreatmentRoomEntityDto.getKode());
		}

		if (bpjsTreatmentRoomEntityDto.getNama() != null) {
			this.setNama(bpjsTreatmentRoomEntityDto.getNama());
		}

		if (bpjsTreatmentRoomEntityDto.getBpjsClaimSubmission() != null) {
			this.setBpjsClaimSubmission(bpjsTreatmentRoomEntityDto.getBpjsClaimSubmission());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for kode here] off begin
	@CsvBindByName(column = "KODE", required = false)
	@Nullable
	@Column(name = "kode")
	@Schema(description = "The kode of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kode here] end
	private String kode;

	// % protected region % [Modify attribute annotation for nama here] off begin
	@CsvBindByName(column = "NAMA", required = false)
	@Nullable
	@Column(name = "nama")
	@Schema(description = "The nama of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nama here] end
	private String nama;

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

	// % protected region % [Update the annotation for BPJS Claim Submission here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submission here] end
	private BpjsClaimSubmissionEntity bpjsClaimSubmission;

	// % protected region % [Update the annotation for bpjsClaimSubmissionId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionId here] end
	private UUID bpjsClaimSubmissionId;

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
	 * Similar to {@link this#setBpjsClaimSubmission(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void setBpjsClaimSubmission(@NotNull BpjsClaimSubmissionEntity entity) {
		setBpjsClaimSubmission(entity, true);
	}

	/**
	 * Set or update the bpjsClaimSubmission in this entity with single BpjsClaimSubmissionEntity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set or updated to bpjsClaimSubmission
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsClaimSubmission(@NotNull BpjsClaimSubmissionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsClaimSubmission here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsClaimSubmission here] end

		if (sameAsFormer(this.bpjsClaimSubmission, entity)) {
			return;
		}

		if (this.bpjsClaimSubmission != null) {
			this.bpjsClaimSubmission.removeBpjsTreatmentRooms(this, false);
		}
		this.bpjsClaimSubmission = entity;
		if (reverseAdd) {
			this.bpjsClaimSubmission.addBpjsTreatmentRooms(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsClaimSubmission incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsClaimSubmission incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsClaimSubmission(boolean)} but default to true.
	 */
	public void unsetBpjsClaimSubmission() {
		this.unsetBpjsClaimSubmission(true);
	}

	/**
	 * Remove BPJS Claim Submission in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsClaimSubmission(boolean reverse) {
		if (reverse && this.bpjsClaimSubmission != null) {
			this.bpjsClaimSubmission.removeBpjsTreatmentRooms(this, false);
		}
		this.bpjsClaimSubmission = null;
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
		return "KODE,NAMA,BPJS_CLAIM_SUBMISSION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<BpjsClaimSubmissionEntity> bpjsClaimSubmissionRelation = Optional.ofNullable(this.bpjsClaimSubmission);
		bpjsClaimSubmissionRelation.ifPresent(entity -> this.bpjsClaimSubmissionId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsTreatmentRoom) {
		if (this == bpjsTreatmentRoom) {
			return true;
		}
		if (bpjsTreatmentRoom == null || this.getClass() != bpjsTreatmentRoom.getClass()) {
			return false;
		}
		if (!super.equals(bpjsTreatmentRoom)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsTreatmentRoomEntity that = (BpjsTreatmentRoomEntity) bpjsTreatmentRoom;
		return
			Objects.equals(this.kode, that.kode) &&
			Objects.equals(this.nama, that.nama) &&
			Objects.equals(this.bpjsClaimSubmissionId, that.bpjsClaimSubmissionId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
