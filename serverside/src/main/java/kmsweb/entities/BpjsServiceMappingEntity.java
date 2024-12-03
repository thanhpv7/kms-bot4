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
import kmsweb.dtos.BpjsServiceMappingEntityDto;
import kmsweb.entities.listeners.BpjsServiceMappingEntityListener;
import kmsweb.serializers.BpjsServiceMappingSerializer;
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
@EntityListeners({BpjsServiceMappingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsServiceMappingSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"ref_code"}, name = "ref_code"),
	}
)
public class BpjsServiceMappingEntity extends AbstractEntity {

	/**
	 * Takes a BpjsServiceMappingEntityDto and converts it into a BpjsServiceMappingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsServiceMappingEntityDto
	 */
	public BpjsServiceMappingEntity(BpjsServiceMappingEntityDto bpjsServiceMappingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsServiceMappingEntityDto.getId() != null) {
			this.setId(bpjsServiceMappingEntityDto.getId());
		}

		if (bpjsServiceMappingEntityDto.getRefCode() != null) {
			this.setRefCode(bpjsServiceMappingEntityDto.getRefCode());
		}

		if (bpjsServiceMappingEntityDto.getRefService() != null) {
			this.setRefService(bpjsServiceMappingEntityDto.getRefService());
		}

		if (bpjsServiceMappingEntityDto.getKodeSubspesialis() != null) {
			this.setKodeSubspesialis(bpjsServiceMappingEntityDto.getKodeSubspesialis());
		}

		if (bpjsServiceMappingEntityDto.getNamaSubspesialis() != null) {
			this.setNamaSubspesialis(bpjsServiceMappingEntityDto.getNamaSubspesialis());
		}

		if (bpjsServiceMappingEntityDto.getCategorizedAsSurgery() != null) {
			this.setCategorizedAsSurgery(bpjsServiceMappingEntityDto.getCategorizedAsSurgery());
		}

		if (bpjsServiceMappingEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(bpjsServiceMappingEntityDto.getBpjsClaimSubmissions());
		}

		if (bpjsServiceMappingEntityDto.getBpjsControlPlans() != null) {
			this.setBpjsControlPlans(bpjsServiceMappingEntityDto.getBpjsControlPlans());
		}

		if (bpjsServiceMappingEntityDto.getBpjsPatientReferrals() != null) {
			this.setBpjsPatientReferrals(bpjsServiceMappingEntityDto.getBpjsPatientReferrals());
		}

		if (bpjsServiceMappingEntityDto.getPolikontrol() != null) {
			this.setPolikontrol(bpjsServiceMappingEntityDto.getPolikontrol());
		}

		if (bpjsServiceMappingEntityDto.getService() != null) {
			this.setService(bpjsServiceMappingEntityDto.getService());
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
	@Length(message = "Length must be less than or equal to 25", max = 25)
	@Column(name = "ref_code")
	@Schema(description = "The Ref Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Code here] end
	private String refCode;

	// % protected region % [Modify attribute annotation for Ref Service here] off begin
	@CsvBindByName(column = "REF_SERVICE", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 200", max = 200)
	@Column(name = "ref_service")
	@Schema(description = "The Ref Service of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Service here] end
	private String refService;

	// % protected region % [Modify attribute annotation for Kode Subspesialis here] off begin
	@CsvBindByName(column = "KODE_SUBSPESIALIS", required = false)
	@Nullable
	@Column(name = "kode_subspesialis")
	@Schema(description = "The Kode Subspesialis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Subspesialis here] end
	private String kodeSubspesialis;

	// % protected region % [Modify attribute annotation for Nama Subspesialis here] off begin
	@CsvBindByName(column = "NAMA_SUBSPESIALIS", required = false)
	@Nullable
	@Column(name = "nama_subspesialis")
	@Schema(description = "The Nama Subspesialis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Subspesialis here] end
	private String namaSubspesialis;

	// % protected region % [Modify attribute annotation for Categorized as Surgery here] off begin
	@CsvBindByName(column = "CATEGORIZED_AS_SURGERY", required = false)
	@Nullable
	@Column(name = "categorized_as_surgery")
	@Schema(description = "The Categorized as Surgery of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Categorized as Surgery here] end
	private Boolean categorizedAsSurgery = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsServiceMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submissions here] end
	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] end
	private Set<UUID> bpjsClaimSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Control Plans here] off begin
	@Schema(description = "The BPJS Control Plan entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsServiceMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Control Plans here] end
	private Set<BpjsControlPlanEntity> bpjsControlPlans = new HashSet<>();

	// % protected region % [Update the annotation for bpjsControlPlansIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CONTROL_PLANS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsControlPlansIds here] end
	private Set<UUID> bpjsControlPlansIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Patient Referrals here] off begin
	@Schema(description = "The BPJS Patient Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsServiceMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Patient Referrals here] end
	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PATIENT_REFERRALS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] end
	private Set<UUID> bpjsPatientReferralsIds = new HashSet<>();

	// % protected region % [Update the annotation for poliKontrol here] off begin
	@Schema(description = "The BPJS Hospitalization Plan entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsServiceMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for poliKontrol here] end
	private Set<BpjsHospitalizationPlanEntity> polikontrol = new HashSet<>();

	// % protected region % [Update the annotation for polikontrolIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "POLIKONTROL_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for polikontrolIds here] end
	private Set<UUID> polikontrolIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Service here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service here] end
	private ServiceEntity service;

	// % protected region % [Update the annotation for serviceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceId here] end
	private UUID serviceId;

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
				entity.setBpjsServiceMapping(this, false);
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
			entity.unsetBpjsServiceMapping(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsServiceMapping(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsServiceMapping(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsControlPlans(BpjsControlPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsControlPlanEntity to be added to this entity
	 */
	public void addBpjsControlPlans(@NotNull BpjsControlPlanEntity entity) {
		addBpjsControlPlans(entity, true);
	}

	/**
	 * Add a new BpjsControlPlanEntity to bpjsControlPlans in this entity.
	 *
	 * @param entity the given BpjsControlPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsControlPlans(@NonNull BpjsControlPlanEntity entity, boolean reverseAdd) {
		if (!this.bpjsControlPlans.contains(entity)) {
			bpjsControlPlans.add(entity);
			if (reverseAdd) {
				entity.setBpjsServiceMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsControlPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be added to this entity
	 */
	public void addBpjsControlPlans(@NotNull Collection<BpjsControlPlanEntity> entities) {
		addBpjsControlPlans(entities, true);
	}

	/**
	 * Add a new collection of BpjsControlPlanEntity to BPJS Control Plans in this entity.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsControlPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsControlPlans(BpjsControlPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsControlPlanEntity to be set to this entity
	 */
	public void removeBpjsControlPlans(@NotNull BpjsControlPlanEntity entity) {
		this.removeBpjsControlPlans(entity, true);
	}

	/**
	 * Remove the given BpjsControlPlanEntity from this entity.
	 *
	 * @param entity the given BpjsControlPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsControlPlans(@NotNull BpjsControlPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsServiceMapping(false);
		}
		this.bpjsControlPlans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsControlPlans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be removed to this entity
	 */
	public void removeBpjsControlPlans(@NotNull Collection<BpjsControlPlanEntity> entities) {
		this.removeBpjsControlPlans(entities, true);
	}

	/**
	 * Remove the given collection of BpjsControlPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsControlPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsControlPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be set to this entity
	 */
	public void setBpjsControlPlans(@NotNull Collection<BpjsControlPlanEntity> entities) {
		setBpjsControlPlans(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Control Plans with the given ones.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsControlPlans(@NotNull Collection<BpjsControlPlanEntity> entities, boolean reverseAdd) {

		this.unsetBpjsControlPlans();
		this.bpjsControlPlans = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.setBpjsServiceMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsControlPlans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsControlPlans() {
		this.unsetBpjsControlPlans(true);
	}

	/**
	 * Remove all the entities in BPJS Control Plans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsControlPlans(boolean doReverse) {
		if (doReverse) {
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.unsetBpjsServiceMapping(false));
		}
		this.bpjsControlPlans.clear();
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
				entity.setBpjsServiceMapping(this, false);
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
			entity.unsetBpjsServiceMapping(false);
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setBpjsServiceMapping(this, false));
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetBpjsServiceMapping(false));
		}
		this.bpjsPatientReferrals.clear();
	}

/**
	 * Similar to {@link this#addPolikontrol(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addPolikontrol(@NotNull BpjsHospitalizationPlanEntity entity) {
		addPolikontrol(entity, true);
	}

	/**
	 * Add a new BpjsHospitalizationPlanEntity to polikontrol in this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPolikontrol(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverseAdd) {
		if (!this.polikontrol.contains(entity)) {
			polikontrol.add(entity);
			if (reverseAdd) {
				entity.setBpjsServiceMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPolikontrol(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addPolikontrol(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		addPolikontrol(entities, true);
	}

	/**
	 * Add a new collection of BpjsHospitalizationPlanEntity to poliKontrol in this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPolikontrol(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePolikontrol(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void removePolikontrol(@NotNull BpjsHospitalizationPlanEntity entity) {
		this.removePolikontrol(entity, true);
	}

	/**
	 * Remove the given BpjsHospitalizationPlanEntity from this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePolikontrol(@NotNull BpjsHospitalizationPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsServiceMapping(false);
		}
		this.polikontrol.remove(entity);
	}

	/**
	 * Similar to {@link this#removePolikontrol(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 */
	public void removePolikontrol(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		this.removePolikontrol(entities, true);
	}

	/**
	 * Remove the given collection of BpjsHospitalizationPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePolikontrol(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPolikontrol(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void setPolikontrol(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		setPolikontrol(entities, true);
	}

	/**
	 * Replace the current entities in poliKontrol with the given ones.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPolikontrol(@NotNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {

		this.unsetPolikontrol();
		this.polikontrol = new HashSet<>(entities);
		if (reverseAdd) {
			this.polikontrol.forEach(polikontrolEntity -> polikontrolEntity.setBpjsServiceMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPolikontrol(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPolikontrol() {
		this.unsetPolikontrol(true);
	}

	/**
	 * Remove all the entities in poliKontrol from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPolikontrol(boolean doReverse) {
		if (doReverse) {
			this.polikontrol.forEach(polikontrolEntity -> polikontrolEntity.unsetBpjsServiceMapping(false));
		}
		this.polikontrol.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.unsetBpjsServiceMapping(false);
		}

		this.service = entity;
		if (reverseAdd) {
			this.service.setBpjsServiceMapping(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove the ServiceEntity of service from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.unsetBpjsServiceMapping();
		}
		this.service = null;
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
		return "REF_CODE,REF_SERVICE,KODE_SUBSPESIALIS,NAMA_SUBSPESIALIS,CATEGORIZED_AS_SURGERY,SERVICE_ID,BPJS_CLAIM_SUBMISSIONS_IDS,BPJS_CONTROL_PLANS_IDS,BPJS_PATIENT_REFERRALS_IDS,POLIKONTROL_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		this.bpjsClaimSubmissionsIds = new HashSet<>();
		for (BpjsClaimSubmissionEntity bpjsClaimSubmissions: this.bpjsClaimSubmissions) {
			this.bpjsClaimSubmissionsIds.add(bpjsClaimSubmissions.getId());
		}

		this.bpjsControlPlansIds = new HashSet<>();
		for (BpjsControlPlanEntity bpjsControlPlans: this.bpjsControlPlans) {
			this.bpjsControlPlansIds.add(bpjsControlPlans.getId());
		}

		this.bpjsPatientReferralsIds = new HashSet<>();
		for (BpjsPatientReferralEntity bpjsPatientReferrals: this.bpjsPatientReferrals) {
			this.bpjsPatientReferralsIds.add(bpjsPatientReferrals.getId());
		}

		this.polikontrolIds = new HashSet<>();
		for (BpjsHospitalizationPlanEntity polikontrol: this.polikontrol) {
			this.polikontrolIds.add(polikontrol.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsServiceMapping) {
		if (this == bpjsServiceMapping) {
			return true;
		}
		if (bpjsServiceMapping == null || this.getClass() != bpjsServiceMapping.getClass()) {
			return false;
		}
		if (!super.equals(bpjsServiceMapping)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsServiceMappingEntity that = (BpjsServiceMappingEntity) bpjsServiceMapping;
		return
			Objects.equals(this.refCode, that.refCode) &&
			Objects.equals(this.refService, that.refService) &&
			Objects.equals(this.kodeSubspesialis, that.kodeSubspesialis) &&
			Objects.equals(this.namaSubspesialis, that.namaSubspesialis) &&
			Objects.equals(this.categorizedAsSurgery, that.categorizedAsSurgery) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.bpjsControlPlansIds, that.bpjsControlPlansIds) &&
			Objects.equals(this.bpjsPatientReferralsIds, that.bpjsPatientReferralsIds) &&
			Objects.equals(this.polikontrolIds, that.polikontrolIds) &&
			Objects.equals(this.serviceId, that.serviceId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
