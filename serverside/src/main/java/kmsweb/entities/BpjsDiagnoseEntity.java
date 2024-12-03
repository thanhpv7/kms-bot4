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
import kmsweb.dtos.BpjsDiagnoseEntityDto;
import kmsweb.entities.listeners.BpjsDiagnoseEntityListener;
import kmsweb.serializers.BpjsDiagnoseSerializer;
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
@EntityListeners({BpjsDiagnoseEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsDiagnoseSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsDiagnoseEntity extends AbstractEntity {

	/**
	 * Takes a BpjsDiagnoseEntityDto and converts it into a BpjsDiagnoseEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsDiagnoseEntityDto
	 */
	public BpjsDiagnoseEntity(BpjsDiagnoseEntityDto bpjsDiagnoseEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsDiagnoseEntityDto.getId() != null) {
			this.setId(bpjsDiagnoseEntityDto.getId());
		}

		if (bpjsDiagnoseEntityDto.getRefCode() != null) {
			this.setRefCode(bpjsDiagnoseEntityDto.getRefCode());
		}

		if (bpjsDiagnoseEntityDto.getRefName() != null) {
			this.setRefName(bpjsDiagnoseEntityDto.getRefName());
		}

		if (bpjsDiagnoseEntityDto.getAdditionalDiagnose() != null) {
			this.setAdditionalDiagnose(bpjsDiagnoseEntityDto.getAdditionalDiagnose());
		}

		if (bpjsDiagnoseEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(bpjsDiagnoseEntityDto.getBpjsClaimSubmissions());
		}

		if (bpjsDiagnoseEntityDto.getBpjsPatientReferrals() != null) {
			this.setBpjsPatientReferrals(bpjsDiagnoseEntityDto.getBpjsPatientReferrals());
		}

		if (bpjsDiagnoseEntityDto.getDiagnosesAndProcedures() != null) {
			this.setDiagnosesAndProcedures(bpjsDiagnoseEntityDto.getDiagnosesAndProcedures());
		}

		if (bpjsDiagnoseEntityDto.getPrimaryDiagnose() != null) {
			this.setPrimaryDiagnose(bpjsDiagnoseEntityDto.getPrimaryDiagnose());
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

	// % protected region % [Update the annotation for Additional Diagnose here] off begin
	@Schema(description = "The BPJS Special Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "additionalDiagnose", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Diagnose here] end
	private Set<BpjsSpecialReferralEntity> additionalDiagnose = new HashSet<>();

	// % protected region % [Update the annotation for additionalDiagnoseIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_DIAGNOSE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for additionalDiagnoseIds here] end
	private Set<UUID> additionalDiagnoseIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDiagnose", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submissions here] end
	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] end
	private Set<UUID> bpjsClaimSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Patient Referrals here] off begin
	@Schema(description = "The BPJS Patient Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDiagnose", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Patient Referrals here] end
	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PATIENT_REFERRALS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] end
	private Set<UUID> bpjsPatientReferralsIds = new HashSet<>();

	// % protected region % [Update the annotation for Diagnoses and Procedures here] off begin
	@Schema(description = "The Diagnoses and Procedures entities that are related to this entity.")
	@OneToOne(mappedBy = "bpjsDiagnose", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnoses and Procedures here] end
	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

	// % protected region % [Update the annotation for diagnosesAndProceduresId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSES_AND_PROCEDURES_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosesAndProceduresId here] end
	private UUID diagnosesAndProceduresId;

	// % protected region % [Update the annotation for Primary Diagnose here] off begin
	@Schema(description = "The BPJS Special Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "primaryDiagnose", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Primary Diagnose here] end
	private Set<BpjsSpecialReferralEntity> primaryDiagnose = new HashSet<>();

	// % protected region % [Update the annotation for primaryDiagnoseIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRIMARY_DIAGNOSE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for primaryDiagnoseIds here] end
	private Set<UUID> primaryDiagnoseIds = new HashSet<>();

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
	 * Similar to {@link this#addAdditionalDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalDiagnose(@NotNull BpjsSpecialReferralEntity entity) {
		addAdditionalDiagnose(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to additionalDiagnose in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalDiagnose(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.additionalDiagnose.contains(entity)) {
			additionalDiagnose.add(entity);
			if (reverseAdd) {
				entity.setAdditionalDiagnose(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		addAdditionalDiagnose(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Additional Diagnose in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removeAdditionalDiagnose(@NotNull BpjsSpecialReferralEntity entity) {
		this.removeAdditionalDiagnose(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalDiagnose(@NotNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalDiagnose(false);
		}
		this.additionalDiagnose.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalDiagnose(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removeAdditionalDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removeAdditionalDiagnose(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setAdditionalDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		setAdditionalDiagnose(entities, true);
	}

	/**
	 * Replace the current entities in Additional Diagnose with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalDiagnose();
		this.additionalDiagnose = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalDiagnose.forEach(additionalDiagnoseEntity -> additionalDiagnoseEntity.setAdditionalDiagnose(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalDiagnose(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalDiagnose() {
		this.unsetAdditionalDiagnose(true);
	}

	/**
	 * Remove all the entities in Additional Diagnose from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalDiagnose(boolean doReverse) {
		if (doReverse) {
			this.additionalDiagnose.forEach(additionalDiagnoseEntity -> additionalDiagnoseEntity.unsetAdditionalDiagnose(false));
		}
		this.additionalDiagnose.clear();
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
				entity.setBpjsDiagnose(this, false);
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
			entity.unsetBpjsDiagnose(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsDiagnose(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsDiagnose(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsPatientReferrals(BpjsPatientReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPatientReferralEntity to be added to this entity
	 */
	public void addBpjsPatientReferrals(@NotNull BpjsPatientReferralEntity entity) {
		addBpjsPatientReferrals(entity, true);
	}

	/**
	 * Add a new BpjsPatientReferralEntity to bpjsPatientReferrals in this entity.
	 *
	 * @param entity the given BpjsPatientReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPatientReferrals(@NonNull BpjsPatientReferralEntity entity, boolean reverseAdd) {
		if (!this.bpjsPatientReferrals.contains(entity)) {
			bpjsPatientReferrals.add(entity);
			if (reverseAdd) {
				entity.setBpjsDiagnose(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPatientReferrals(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be added to this entity
	 */
	public void addBpjsPatientReferrals(@NotNull Collection<BpjsPatientReferralEntity> entities) {
		addBpjsPatientReferrals(entities, true);
	}

	/**
	 * Add a new collection of BpjsPatientReferralEntity to BPJS Patient Referrals in this entity.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPatientReferrals(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPatientReferrals(BpjsPatientReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPatientReferralEntity to be set to this entity
	 */
	public void removeBpjsPatientReferrals(@NotNull BpjsPatientReferralEntity entity) {
		this.removeBpjsPatientReferrals(entity, true);
	}

	/**
	 * Remove the given BpjsPatientReferralEntity from this entity.
	 *
	 * @param entity the given BpjsPatientReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPatientReferrals(@NotNull BpjsPatientReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDiagnose(false);
		}
		this.bpjsPatientReferrals.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPatientReferrals(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be removed to this entity
	 */
	public void removeBpjsPatientReferrals(@NotNull Collection<BpjsPatientReferralEntity> entities) {
		this.removeBpjsPatientReferrals(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPatientReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPatientReferrals(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPatientReferrals(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be set to this entity
	 */
	public void setBpjsPatientReferrals(@NotNull Collection<BpjsPatientReferralEntity> entities) {
		setBpjsPatientReferrals(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Patient Referrals with the given ones.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPatientReferrals(@NotNull Collection<BpjsPatientReferralEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPatientReferrals();
		this.bpjsPatientReferrals = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setBpjsDiagnose(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPatientReferrals(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPatientReferrals() {
		this.unsetBpjsPatientReferrals(true);
	}

	/**
	 * Remove all the entities in BPJS Patient Referrals from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPatientReferrals(boolean doReverse) {
		if (doReverse) {
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetBpjsDiagnose(false));
		}
		this.bpjsPatientReferrals.clear();
	}

	/**
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(@NotNull DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update diagnosesAndProcedures with the given DiagnosesAndProceduresEntity.
	 *
	 * @param entity the BpjsDiagnoseEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnose();
		}

		this.diagnosesAndProcedures = entity;

		if (reverseAdd) {
			this.diagnosesAndProcedures.setBpjsDiagnose(this, false);
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
			this.diagnosesAndProcedures.unsetBpjsDiagnose(false);
		}
		this.diagnosesAndProcedures = null;
	}

/**
	 * Similar to {@link this#addPrimaryDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryDiagnose(@NotNull BpjsSpecialReferralEntity entity) {
		addPrimaryDiagnose(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to primaryDiagnose in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrimaryDiagnose(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.primaryDiagnose.contains(entity)) {
			primaryDiagnose.add(entity);
			if (reverseAdd) {
				entity.setPrimaryDiagnose(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrimaryDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		addPrimaryDiagnose(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Primary Diagnose in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrimaryDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrimaryDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removePrimaryDiagnose(@NotNull BpjsSpecialReferralEntity entity) {
		this.removePrimaryDiagnose(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrimaryDiagnose(@NotNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPrimaryDiagnose(false);
		}
		this.primaryDiagnose.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrimaryDiagnose(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removePrimaryDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removePrimaryDiagnose(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrimaryDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrimaryDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setPrimaryDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities) {
		setPrimaryDiagnose(entities, true);
	}

	/**
	 * Replace the current entities in Primary Diagnose with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrimaryDiagnose(@NotNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetPrimaryDiagnose();
		this.primaryDiagnose = new HashSet<>(entities);
		if (reverseAdd) {
			this.primaryDiagnose.forEach(primaryDiagnoseEntity -> primaryDiagnoseEntity.setPrimaryDiagnose(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrimaryDiagnose(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrimaryDiagnose() {
		this.unsetPrimaryDiagnose(true);
	}

	/**
	 * Remove all the entities in Primary Diagnose from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrimaryDiagnose(boolean doReverse) {
		if (doReverse) {
			this.primaryDiagnose.forEach(primaryDiagnoseEntity -> primaryDiagnoseEntity.unsetPrimaryDiagnose(false));
		}
		this.primaryDiagnose.clear();
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
		return "REF_CODE,REF_NAME,ADDITIONAL_DIAGNOSE_IDS,BPJS_CLAIM_SUBMISSIONS_IDS,BPJS_PATIENT_REFERRALS_IDS,DIAGNOSES_AND_PROCEDURES_ID,PRIMARY_DIAGNOSE_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.additionalDiagnoseIds = new HashSet<>();
		for (BpjsSpecialReferralEntity additionalDiagnose: this.additionalDiagnose) {
			this.additionalDiagnoseIds.add(additionalDiagnose.getId());
		}

		this.bpjsClaimSubmissionsIds = new HashSet<>();
		for (BpjsClaimSubmissionEntity bpjsClaimSubmissions: this.bpjsClaimSubmissions) {
			this.bpjsClaimSubmissionsIds.add(bpjsClaimSubmissions.getId());
		}

		this.bpjsPatientReferralsIds = new HashSet<>();
		for (BpjsPatientReferralEntity bpjsPatientReferrals: this.bpjsPatientReferrals) {
			this.bpjsPatientReferralsIds.add(bpjsPatientReferrals.getId());
		}

		Optional<DiagnosesAndProceduresEntity> diagnosesAndProceduresRelation = Optional.ofNullable(this.diagnosesAndProcedures);
		diagnosesAndProceduresRelation.ifPresent(entity -> this.diagnosesAndProceduresId = entity.getId());

		this.primaryDiagnoseIds = new HashSet<>();
		for (BpjsSpecialReferralEntity primaryDiagnose: this.primaryDiagnose) {
			this.primaryDiagnoseIds.add(primaryDiagnose.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsDiagnose) {
		if (this == bpjsDiagnose) {
			return true;
		}
		if (bpjsDiagnose == null || this.getClass() != bpjsDiagnose.getClass()) {
			return false;
		}
		if (!super.equals(bpjsDiagnose)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsDiagnoseEntity that = (BpjsDiagnoseEntity) bpjsDiagnose;
		return
			Objects.equals(this.refCode, that.refCode) &&
			Objects.equals(this.refName, that.refName) &&
			Objects.equals(this.additionalDiagnoseIds, that.additionalDiagnoseIds) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.bpjsPatientReferralsIds, that.bpjsPatientReferralsIds) &&
			Objects.equals(this.diagnosesAndProceduresId, that.diagnosesAndProceduresId) &&
			Objects.equals(this.primaryDiagnoseIds, that.primaryDiagnoseIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
