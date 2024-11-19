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
import kmsweb.dtos.BpjsProcedureEntityDto;
import kmsweb.entities.listeners.BpjsProcedureEntityListener;
import kmsweb.serializers.BpjsProcedureSerializer;
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
@EntityListeners({BpjsProcedureEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsProcedureSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsProcedureEntity extends AbstractEntity {

	/**
	 * Takes a BpjsProcedureEntityDto and converts it into a BpjsProcedureEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsProcedureEntityDto
	 */
	public BpjsProcedureEntity(BpjsProcedureEntityDto bpjsProcedureEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsProcedureEntityDto.getId() != null) {
			this.setId(bpjsProcedureEntityDto.getId());
		}

		if (bpjsProcedureEntityDto.getProcedureCode() != null) {
			this.setProcedureCode(bpjsProcedureEntityDto.getProcedureCode());
		}

		if (bpjsProcedureEntityDto.getProcedureName() != null) {
			this.setProcedureName(bpjsProcedureEntityDto.getProcedureName());
		}

		if (bpjsProcedureEntityDto.getAdditionalProcedure() != null) {
			this.setAdditionalProcedure(bpjsProcedureEntityDto.getAdditionalProcedure());
		}

		if (bpjsProcedureEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(bpjsProcedureEntityDto.getBpjsClaimSubmissions());
		}

		if (bpjsProcedureEntityDto.getPrimaryProcedure() != null) {
			this.setPrimaryProcedure(bpjsProcedureEntityDto.getPrimaryProcedure());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Procedure Code here] off begin
	@CsvBindByName(column = "PROCEDURE_CODE", required = false)
	@Nullable
	@Column(name = "procedure_code")
	@Schema(description = "The Procedure Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Procedure Code here] end
	private String procedureCode;

	// % protected region % [Modify attribute annotation for Procedure Name here] off begin
	@CsvBindByName(column = "PROCEDURE_NAME", required = false)
	@Nullable
	@Column(name = "procedure_name")
	@Schema(description = "The Procedure Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Procedure Name here] end
	private String procedureName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Additional Procedure here] off begin
	@Schema(description = "The BPJS Special Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "additionalProcedure", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Procedure here] end
	private Set<BpjsSpecialReferralEntity> additionalProcedure = new HashSet<>();

	// % protected region % [Update the annotation for additionalProcedureIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_PROCEDURE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for additionalProcedureIds here] end
	private Set<UUID> additionalProcedureIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsProcedure", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submissions here] end
	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] end
	private Set<UUID> bpjsClaimSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for Primary Procedure here] off begin
	@Schema(description = "The BPJS Special Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "primaryProcedure", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Primary Procedure here] end
	private Set<BpjsSpecialReferralEntity> primaryProcedure = new HashSet<>();

	// % protected region % [Update the annotation for primaryProcedureIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRIMARY_PROCEDURE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for primaryProcedureIds here] end
	private Set<UUID> primaryProcedureIds = new HashSet<>();

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
	 * Similar to {@link this#addAdditionalProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalProcedure(@NotNull BpjsSpecialReferralEntity entity) {
		addAdditionalProcedure(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to additionalProcedure in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalProcedure(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.additionalProcedure.contains(entity)) {
			additionalProcedure.add(entity);
			if (reverseAdd) {
				entity.setAdditionalProcedure(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		addAdditionalProcedure(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Additional Procedure in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removeAdditionalProcedure(@NotNull BpjsSpecialReferralEntity entity) {
		this.removeAdditionalProcedure(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalProcedure(@NotNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalProcedure(false);
		}
		this.additionalProcedure.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalProcedure(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removeAdditionalProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removeAdditionalProcedure(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setAdditionalProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		setAdditionalProcedure(entities, true);
	}

	/**
	 * Replace the current entities in Additional Procedure with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalProcedure();
		this.additionalProcedure = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalProcedure.forEach(additionalProcedureEntity -> additionalProcedureEntity.setAdditionalProcedure(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalProcedure(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalProcedure() {
		this.unsetAdditionalProcedure(true);
	}

	/**
	 * Remove all the entities in Additional Procedure from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalProcedure(boolean doReverse) {
		if (doReverse) {
			this.additionalProcedure.forEach(additionalProcedureEntity -> additionalProcedureEntity.unsetAdditionalProcedure(false));
		}
		this.additionalProcedure.clear();
	}

/**
	 * Similar to {@link this#addBpjsClaimSubmissions(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be added to this entity
	 */
	public void addBpjsClaimSubmissions(@NotNull BpjsClaimSubmissionEntity entity) {
		addBpjsClaimSubmissions(entity, true);
	}

	/**
	 * Add a new BpjsClaimSubmissionEntity to bpjsClaimSubmissions in this entity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity, boolean reverseAdd) {
		if (!this.bpjsClaimSubmissions.contains(entity)) {
			bpjsClaimSubmissions.add(entity);
			if (reverseAdd) {
				entity.setBpjsProcedure(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be added to this entity
	 */
	public void addBpjsClaimSubmissions(@NotNull Collection<BpjsClaimSubmissionEntity> entities) {
		addBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Add a new collection of BpjsClaimSubmissionEntity to BPJS Claim Submissions in this entity.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsClaimSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsClaimSubmissions(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void removeBpjsClaimSubmissions(@NotNull BpjsClaimSubmissionEntity entity) {
		this.removeBpjsClaimSubmissions(entity, true);
	}

	/**
	 * Remove the given BpjsClaimSubmissionEntity from this entity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsClaimSubmissions(@NotNull BpjsClaimSubmissionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsProcedure(false);
		}
		this.bpjsClaimSubmissions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be removed to this entity
	 */
	public void removeBpjsClaimSubmissions(@NotNull Collection<BpjsClaimSubmissionEntity> entities) {
		this.removeBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Remove the given collection of BpjsClaimSubmissionEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsClaimSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void setBpjsClaimSubmissions(@NotNull Collection<BpjsClaimSubmissionEntity> entities) {
		setBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Claim Submissions with the given ones.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsClaimSubmissions(@NotNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {

		this.unsetBpjsClaimSubmissions();
		this.bpjsClaimSubmissions = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsProcedure(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsClaimSubmissions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsClaimSubmissions() {
		this.unsetBpjsClaimSubmissions(true);
	}

	/**
	 * Remove all the entities in BPJS Claim Submissions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsClaimSubmissions(boolean doReverse) {
		if (doReverse) {
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsProcedure(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addPrimaryProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryProcedure(@NotNull BpjsSpecialReferralEntity entity) {
		addPrimaryProcedure(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to primaryProcedure in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrimaryProcedure(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.primaryProcedure.contains(entity)) {
			primaryProcedure.add(entity);
			if (reverseAdd) {
				entity.setPrimaryProcedure(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrimaryProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		addPrimaryProcedure(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Primary Procedure in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrimaryProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrimaryProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removePrimaryProcedure(@NotNull BpjsSpecialReferralEntity entity) {
		this.removePrimaryProcedure(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrimaryProcedure(@NotNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPrimaryProcedure(false);
		}
		this.primaryProcedure.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrimaryProcedure(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removePrimaryProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removePrimaryProcedure(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrimaryProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrimaryProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setPrimaryProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		setPrimaryProcedure(entities, true);
	}

	/**
	 * Replace the current entities in Primary Procedure with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrimaryProcedure(@NotNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetPrimaryProcedure();
		this.primaryProcedure = new HashSet<>(entities);
		if (reverseAdd) {
			this.primaryProcedure.forEach(primaryProcedureEntity -> primaryProcedureEntity.setPrimaryProcedure(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrimaryProcedure(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrimaryProcedure() {
		this.unsetPrimaryProcedure(true);
	}

	/**
	 * Remove all the entities in Primary Procedure from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrimaryProcedure(boolean doReverse) {
		if (doReverse) {
			this.primaryProcedure.forEach(primaryProcedureEntity -> primaryProcedureEntity.unsetPrimaryProcedure(false));
		}
		this.primaryProcedure.clear();
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
		return "PROCEDURE_CODE,PROCEDURE_NAME,ADDITIONAL_PROCEDURE_IDS,BPJS_CLAIM_SUBMISSIONS_IDS,PRIMARY_PROCEDURE_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.additionalProcedureIds = new HashSet<>();
		for (BpjsSpecialReferralEntity additionalProcedure: this.additionalProcedure) {
			this.additionalProcedureIds.add(additionalProcedure.getId());
		}

		this.bpjsClaimSubmissionsIds = new HashSet<>();
		for (BpjsClaimSubmissionEntity bpjsClaimSubmissions: this.bpjsClaimSubmissions) {
			this.bpjsClaimSubmissionsIds.add(bpjsClaimSubmissions.getId());
		}

		this.primaryProcedureIds = new HashSet<>();
		for (BpjsSpecialReferralEntity primaryProcedure: this.primaryProcedure) {
			this.primaryProcedureIds.add(primaryProcedure.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsProcedure) {
		if (this == bpjsProcedure) {
			return true;
		}
		if (bpjsProcedure == null || this.getClass() != bpjsProcedure.getClass()) {
			return false;
		}
		if (!super.equals(bpjsProcedure)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsProcedureEntity that = (BpjsProcedureEntity) bpjsProcedure;
		return
			Objects.equals(this.procedureCode, that.procedureCode) &&
			Objects.equals(this.procedureName, that.procedureName) &&
			Objects.equals(this.additionalProcedureIds, that.additionalProcedureIds) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.primaryProcedureIds, that.primaryProcedureIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
