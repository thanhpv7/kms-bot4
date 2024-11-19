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
import kmsweb.dtos.BpjsDiagnosePRBEntityDto;
import kmsweb.entities.listeners.BpjsDiagnosePRBEntityListener;
import kmsweb.serializers.BpjsDiagnosePRBSerializer;
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
@EntityListeners({BpjsDiagnosePRBEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsDiagnosePRBSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsDiagnosePRBEntity extends AbstractEntity {

	/**
	 * Takes a BpjsDiagnosePRBEntityDto and converts it into a BpjsDiagnosePRBEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsDiagnosePRBEntityDto
	 */
	public BpjsDiagnosePRBEntity(BpjsDiagnosePRBEntityDto bpjsDiagnosePRBEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsDiagnosePRBEntityDto.getId() != null) {
			this.setId(bpjsDiagnosePRBEntityDto.getId());
		}

		if (bpjsDiagnosePRBEntityDto.getRefCode() != null) {
			this.setRefCode(bpjsDiagnosePRBEntityDto.getRefCode());
		}

		if (bpjsDiagnosePRBEntityDto.getRefName() != null) {
			this.setRefName(bpjsDiagnosePRBEntityDto.getRefName());
		}

		if (bpjsDiagnosePRBEntityDto.getBpjsPRBs() != null) {
			this.setBpjsPRBs(bpjsDiagnosePRBEntityDto.getBpjsPRBs());
		}

		if (bpjsDiagnosePRBEntityDto.getDiagnosesAndProcedures() != null) {
			this.setDiagnosesAndProcedures(bpjsDiagnosePRBEntityDto.getDiagnosesAndProcedures());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Ref Code here] off begin
	@CsvBindByName(column = "REF_CODE", required = false)
	@Nullable
	@Column(name = "ref_code")
	@Schema(description = "The Ref Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Code here] end
	private String refCode;

	// % protected region % [Modify attribute annotation for Ref Name here] off begin
	@CsvBindByName(column = "REF_NAME", required = false)
	@Nullable
	@Column(name = "ref_name")
	@Schema(description = "The Ref Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Name here] end
	private String refName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS PRBs here] off begin
	@Schema(description = "The BPJS PRB entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDiagnosePRB", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS PRBs here] end
	private Set<BpjsPRBEntity> bpjsPRBs = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPRBsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PRBS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPRBsIds here] end
	private Set<UUID> bpjsPRBsIds = new HashSet<>();

	// % protected region % [Update the annotation for Diagnoses and Procedures here] off begin
	@Schema(description = "The Diagnoses and Procedures entities that are related to this entity.")
	@OneToOne(mappedBy = "bpjsDiagnosePRB", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnoses and Procedures here] end
	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

	// % protected region % [Update the annotation for diagnosesAndProceduresId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSES_AND_PROCEDURES_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosesAndProceduresId here] end
	private UUID diagnosesAndProceduresId;

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
	 * Similar to {@link this#addBpjsPRBs(BpjsPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBEntity to be added to this entity
	 */
	public void addBpjsPRBs(@NotNull BpjsPRBEntity entity) {
		addBpjsPRBs(entity, true);
	}

	/**
	 * Add a new BpjsPRBEntity to bpjsPRBs in this entity.
	 *
	 * @param entity the given BpjsPRBEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPRBs(@NonNull BpjsPRBEntity entity, boolean reverseAdd) {
		if (!this.bpjsPRBs.contains(entity)) {
			bpjsPRBs.add(entity);
			if (reverseAdd) {
				entity.setBpjsDiagnosePRB(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be added to this entity
	 */
	public void addBpjsPRBs(@NotNull Collection<BpjsPRBEntity> entities) {
		addBpjsPRBs(entities, true);
	}

	/**
	 * Add a new collection of BpjsPRBEntity to BPJS PRBs in this entity.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPRBs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPRBs(BpjsPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBEntity to be set to this entity
	 */
	public void removeBpjsPRBs(@NotNull BpjsPRBEntity entity) {
		this.removeBpjsPRBs(entity, true);
	}

	/**
	 * Remove the given BpjsPRBEntity from this entity.
	 *
	 * @param entity the given BpjsPRBEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPRBs(@NotNull BpjsPRBEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDiagnosePRB(false);
		}
		this.bpjsPRBs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be removed to this entity
	 */
	public void removeBpjsPRBs(@NotNull Collection<BpjsPRBEntity> entities) {
		this.removeBpjsPRBs(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPRBEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPRBs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be set to this entity
	 */
	public void setBpjsPRBs(@NotNull Collection<BpjsPRBEntity> entities) {
		setBpjsPRBs(entities, true);
	}

	/**
	 * Replace the current entities in BPJS PRBs with the given ones.
	 *
	 * @param entities the given collection of BpjsPRBEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPRBs(@NotNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPRBs();
		this.bpjsPRBs = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.setBpjsDiagnosePRB(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPRBs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPRBs() {
		this.unsetBpjsPRBs(true);
	}

	/**
	 * Remove all the entities in BPJS PRBs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPRBs(boolean doReverse) {
		if (doReverse) {
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.unsetBpjsDiagnosePRB(false));
		}
		this.bpjsPRBs.clear();
	}

	/**
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(@NotNull DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update diagnosesAndProcedures with the given DiagnosesAndProceduresEntity.
	 *
	 * @param entity the BpjsDiagnosePRBEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnosePRB();
		}

		this.diagnosesAndProcedures = entity;

		if (reverseAdd) {
			this.diagnosesAndProcedures.setBpjsDiagnosePRB(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosesAndProcedures(boolean)} but default to true.
	 */
	public void unsetDiagnosesAndProcedures() {
		this.unsetDiagnosesAndProcedures(true);
	}

	/**
	 * Remove the DiagnosesAndProceduresEntity in Diagnoses and Procedures from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosesAndProcedures(boolean reverse) {
		if (reverse && this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnosePRB(false);
		}
		this.diagnosesAndProcedures = null;
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
		return "REF_CODE,REF_NAME,BPJS_PRBS_IDS,DIAGNOSES_AND_PROCEDURES_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.bpjsPRBsIds = new HashSet<>();
		for (BpjsPRBEntity bpjsPRBs: this.bpjsPRBs) {
			this.bpjsPRBsIds.add(bpjsPRBs.getId());
		}

		Optional<DiagnosesAndProceduresEntity> diagnosesAndProceduresRelation = Optional.ofNullable(this.diagnosesAndProcedures);
		diagnosesAndProceduresRelation.ifPresent(entity -> this.diagnosesAndProceduresId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsDiagnosePRB) {
		if (this == bpjsDiagnosePRB) {
			return true;
		}
		if (bpjsDiagnosePRB == null || this.getClass() != bpjsDiagnosePRB.getClass()) {
			return false;
		}
		if (!super.equals(bpjsDiagnosePRB)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsDiagnosePRBEntity that = (BpjsDiagnosePRBEntity) bpjsDiagnosePRB;
		return
			Objects.equals(this.refCode, that.refCode) &&
			Objects.equals(this.refName, that.refName) &&
			Objects.equals(this.bpjsPRBsIds, that.bpjsPRBsIds) &&
			Objects.equals(this.diagnosesAndProceduresId, that.diagnosesAndProceduresId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
