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
import kmsweb.dtos.BpjsHealthFacilityEntityDto;
import kmsweb.entities.listeners.BpjsHealthFacilityEntityListener;
import kmsweb.serializers.BpjsHealthFacilitySerializer;
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
@EntityListeners({BpjsHealthFacilityEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsHealthFacilitySerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"ref_code"}, name = "ref_code"),
	}
)
public class BpjsHealthFacilityEntity extends AbstractEntity {

	/**
	 * Takes a BpjsHealthFacilityEntityDto and converts it into a BpjsHealthFacilityEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsHealthFacilityEntityDto
	 */
	public BpjsHealthFacilityEntity(BpjsHealthFacilityEntityDto bpjsHealthFacilityEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsHealthFacilityEntityDto.getId() != null) {
			this.setId(bpjsHealthFacilityEntityDto.getId());
		}

		if (bpjsHealthFacilityEntityDto.getRefCode() != null) {
			this.setRefCode(bpjsHealthFacilityEntityDto.getRefCode());
		}

		if (bpjsHealthFacilityEntityDto.getRefName() != null) {
			this.setRefName(bpjsHealthFacilityEntityDto.getRefName());
		}

		if (bpjsHealthFacilityEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(bpjsHealthFacilityEntityDto.getBpjsClaimSubmissions());
		}

		if (bpjsHealthFacilityEntityDto.getBpjsFacilityLists() != null) {
			this.setBpjsFacilityLists(bpjsHealthFacilityEntityDto.getBpjsFacilityLists());
		}

		if (bpjsHealthFacilityEntityDto.getBpjsPatientReferrals() != null) {
			this.setBpjsPatientReferrals(bpjsHealthFacilityEntityDto.getBpjsPatientReferrals());
		}

		if (bpjsHealthFacilityEntityDto.getBpjsReferralSpecialists() != null) {
			this.setBpjsReferralSpecialists(bpjsHealthFacilityEntityDto.getBpjsReferralSpecialists());
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

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsHealthFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submissions here] end
	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] end
	private Set<UUID> bpjsClaimSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Facility Lists here] off begin
	@Schema(description = "The BPJS Facility List entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsHealthFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Facility Lists here] end
	private Set<BpjsFacilityListEntity> bpjsFacilityLists = new HashSet<>();

	// % protected region % [Update the annotation for bpjsFacilityListsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_FACILITY_LISTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsFacilityListsIds here] end
	private Set<UUID> bpjsFacilityListsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Patient Referrals here] off begin
	@Schema(description = "The BPJS Patient Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsHealthFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Patient Referrals here] end
	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PATIENT_REFERRALS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] end
	private Set<UUID> bpjsPatientReferralsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Referral Specialists here] off begin
	@Schema(description = "The BPJS Referral Specialist entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsHealthFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Referral Specialists here] end
	private Set<BpjsReferralSpecialistEntity> bpjsReferralSpecialists = new HashSet<>();

	// % protected region % [Update the annotation for bpjsReferralSpecialistsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_REFERRAL_SPECIALISTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsReferralSpecialistsIds here] end
	private Set<UUID> bpjsReferralSpecialistsIds = new HashSet<>();

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
				entity.setBpjsHealthFacility(this, false);
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
			entity.unsetBpjsHealthFacility(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsHealthFacility(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsFacilityLists(BpjsFacilityListEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsFacilityListEntity to be added to this entity
	 */
	public void addBpjsFacilityLists(@NotNull BpjsFacilityListEntity entity) {
		addBpjsFacilityLists(entity, true);
	}

	/**
	 * Add a new BpjsFacilityListEntity to bpjsFacilityLists in this entity.
	 *
	 * @param entity the given BpjsFacilityListEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsFacilityLists(@NonNull BpjsFacilityListEntity entity, boolean reverseAdd) {
		if (!this.bpjsFacilityLists.contains(entity)) {
			bpjsFacilityLists.add(entity);
			if (reverseAdd) {
				entity.setBpjsHealthFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsFacilityLists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be added to this entity
	 */
	public void addBpjsFacilityLists(@NotNull Collection<BpjsFacilityListEntity> entities) {
		addBpjsFacilityLists(entities, true);
	}

	/**
	 * Add a new collection of BpjsFacilityListEntity to BPJS Facility Lists in this entity.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsFacilityLists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsFacilityLists(BpjsFacilityListEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsFacilityListEntity to be set to this entity
	 */
	public void removeBpjsFacilityLists(@NotNull BpjsFacilityListEntity entity) {
		this.removeBpjsFacilityLists(entity, true);
	}

	/**
	 * Remove the given BpjsFacilityListEntity from this entity.
	 *
	 * @param entity the given BpjsFacilityListEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsFacilityLists(@NotNull BpjsFacilityListEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsHealthFacility(false);
		}
		this.bpjsFacilityLists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsFacilityLists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be removed to this entity
	 */
	public void removeBpjsFacilityLists(@NotNull Collection<BpjsFacilityListEntity> entities) {
		this.removeBpjsFacilityLists(entities, true);
	}

	/**
	 * Remove the given collection of BpjsFacilityListEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsFacilityLists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsFacilityLists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be set to this entity
	 */
	public void setBpjsFacilityLists(@NotNull Collection<BpjsFacilityListEntity> entities) {
		setBpjsFacilityLists(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Facility Lists with the given ones.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsFacilityLists(@NotNull Collection<BpjsFacilityListEntity> entities, boolean reverseAdd) {

		this.unsetBpjsFacilityLists();
		this.bpjsFacilityLists = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsFacilityLists.forEach(bpjsFacilityListsEntity -> bpjsFacilityListsEntity.setBpjsHealthFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsFacilityLists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsFacilityLists() {
		this.unsetBpjsFacilityLists(true);
	}

	/**
	 * Remove all the entities in BPJS Facility Lists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsFacilityLists(boolean doReverse) {
		if (doReverse) {
			this.bpjsFacilityLists.forEach(bpjsFacilityListsEntity -> bpjsFacilityListsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsFacilityLists.clear();
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
				entity.setBpjsHealthFacility(this, false);
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
			entity.unsetBpjsHealthFacility(false);
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setBpjsHealthFacility(this, false));
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsPatientReferrals.clear();
	}

/**
	 * Similar to {@link this#addBpjsReferralSpecialists(BpjsReferralSpecialistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity to be added to this entity
	 */
	public void addBpjsReferralSpecialists(@NotNull BpjsReferralSpecialistEntity entity) {
		addBpjsReferralSpecialists(entity, true);
	}

	/**
	 * Add a new BpjsReferralSpecialistEntity to bpjsReferralSpecialists in this entity.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsReferralSpecialists(@NonNull BpjsReferralSpecialistEntity entity, boolean reverseAdd) {
		if (!this.bpjsReferralSpecialists.contains(entity)) {
			bpjsReferralSpecialists.add(entity);
			if (reverseAdd) {
				entity.setBpjsHealthFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsReferralSpecialists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be added to this entity
	 */
	public void addBpjsReferralSpecialists(@NotNull Collection<BpjsReferralSpecialistEntity> entities) {
		addBpjsReferralSpecialists(entities, true);
	}

	/**
	 * Add a new collection of BpjsReferralSpecialistEntity to BPJS Referral Specialists in this entity.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsReferralSpecialists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsReferralSpecialists(BpjsReferralSpecialistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity to be set to this entity
	 */
	public void removeBpjsReferralSpecialists(@NotNull BpjsReferralSpecialistEntity entity) {
		this.removeBpjsReferralSpecialists(entity, true);
	}

	/**
	 * Remove the given BpjsReferralSpecialistEntity from this entity.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsReferralSpecialists(@NotNull BpjsReferralSpecialistEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsHealthFacility(false);
		}
		this.bpjsReferralSpecialists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsReferralSpecialists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be removed to this entity
	 */
	public void removeBpjsReferralSpecialists(@NotNull Collection<BpjsReferralSpecialistEntity> entities) {
		this.removeBpjsReferralSpecialists(entities, true);
	}

	/**
	 * Remove the given collection of BpjsReferralSpecialistEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsReferralSpecialists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsReferralSpecialists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be set to this entity
	 */
	public void setBpjsReferralSpecialists(@NotNull Collection<BpjsReferralSpecialistEntity> entities) {
		setBpjsReferralSpecialists(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Referral Specialists with the given ones.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsReferralSpecialists(@NotNull Collection<BpjsReferralSpecialistEntity> entities, boolean reverseAdd) {

		this.unsetBpjsReferralSpecialists();
		this.bpjsReferralSpecialists = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsReferralSpecialists.forEach(bpjsReferralSpecialistsEntity -> bpjsReferralSpecialistsEntity.setBpjsHealthFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsReferralSpecialists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsReferralSpecialists() {
		this.unsetBpjsReferralSpecialists(true);
	}

	/**
	 * Remove all the entities in BPJS Referral Specialists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsReferralSpecialists(boolean doReverse) {
		if (doReverse) {
			this.bpjsReferralSpecialists.forEach(bpjsReferralSpecialistsEntity -> bpjsReferralSpecialistsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsReferralSpecialists.clear();
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
		return "REF_CODE,REF_NAME,BPJS_CLAIM_SUBMISSIONS_IDS,BPJS_FACILITY_LISTS_IDS,BPJS_PATIENT_REFERRALS_IDS,BPJS_REFERRAL_SPECIALISTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.bpjsClaimSubmissionsIds = new HashSet<>();
		for (BpjsClaimSubmissionEntity bpjsClaimSubmissions: this.bpjsClaimSubmissions) {
			this.bpjsClaimSubmissionsIds.add(bpjsClaimSubmissions.getId());
		}

		this.bpjsFacilityListsIds = new HashSet<>();
		for (BpjsFacilityListEntity bpjsFacilityLists: this.bpjsFacilityLists) {
			this.bpjsFacilityListsIds.add(bpjsFacilityLists.getId());
		}

		this.bpjsPatientReferralsIds = new HashSet<>();
		for (BpjsPatientReferralEntity bpjsPatientReferrals: this.bpjsPatientReferrals) {
			this.bpjsPatientReferralsIds.add(bpjsPatientReferrals.getId());
		}

		this.bpjsReferralSpecialistsIds = new HashSet<>();
		for (BpjsReferralSpecialistEntity bpjsReferralSpecialists: this.bpjsReferralSpecialists) {
			this.bpjsReferralSpecialistsIds.add(bpjsReferralSpecialists.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsHealthFacility) {
		if (this == bpjsHealthFacility) {
			return true;
		}
		if (bpjsHealthFacility == null || this.getClass() != bpjsHealthFacility.getClass()) {
			return false;
		}
		if (!super.equals(bpjsHealthFacility)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsHealthFacilityEntity that = (BpjsHealthFacilityEntity) bpjsHealthFacility;
		return
			Objects.equals(this.refCode, that.refCode) &&
			Objects.equals(this.refName, that.refName) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.bpjsFacilityListsIds, that.bpjsFacilityListsIds) &&
			Objects.equals(this.bpjsPatientReferralsIds, that.bpjsPatientReferralsIds) &&
			Objects.equals(this.bpjsReferralSpecialistsIds, that.bpjsReferralSpecialistsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
