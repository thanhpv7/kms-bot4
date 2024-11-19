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
import kmsweb.dtos.BpjsDoctorMappingEntityDto;
import kmsweb.entities.listeners.BpjsDoctorMappingEntityListener;
import kmsweb.serializers.BpjsDoctorMappingSerializer;
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
@EntityListeners({BpjsDoctorMappingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsDoctorMappingSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"ref_code"}, name = "ref_code"),
	}
)
public class BpjsDoctorMappingEntity extends AbstractEntity {

	/**
	 * Takes a BpjsDoctorMappingEntityDto and converts it into a BpjsDoctorMappingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsDoctorMappingEntityDto
	 */
	public BpjsDoctorMappingEntity(BpjsDoctorMappingEntityDto bpjsDoctorMappingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsDoctorMappingEntityDto.getId() != null) {
			this.setId(bpjsDoctorMappingEntityDto.getId());
		}

		if (bpjsDoctorMappingEntityDto.getRefCode() != null) {
			this.setRefCode(bpjsDoctorMappingEntityDto.getRefCode());
		}

		if (bpjsDoctorMappingEntityDto.getBpjsMedicalStaff() != null) {
			this.setBpjsMedicalStaff(bpjsDoctorMappingEntityDto.getBpjsMedicalStaff());
		}

		if (bpjsDoctorMappingEntityDto.getNotes() != null) {
			this.setNotes(bpjsDoctorMappingEntityDto.getNotes());
		}

		if (bpjsDoctorMappingEntityDto.getRefCodeService() != null) {
			this.setRefCodeService(bpjsDoctorMappingEntityDto.getRefCodeService());
		}

		if (bpjsDoctorMappingEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(bpjsDoctorMappingEntityDto.getBpjsClaimSubmissions());
		}

		if (bpjsDoctorMappingEntityDto.getBpjsControlPlans() != null) {
			this.setBpjsControlPlans(bpjsDoctorMappingEntityDto.getBpjsControlPlans());
		}

		if (bpjsDoctorMappingEntityDto.getBpjsPRBs() != null) {
			this.setBpjsPRBs(bpjsDoctorMappingEntityDto.getBpjsPRBs());
		}

		if (bpjsDoctorMappingEntityDto.getKodedokter() != null) {
			this.setKodedokter(bpjsDoctorMappingEntityDto.getKodedokter());
		}

		if (bpjsDoctorMappingEntityDto.getStaff() != null) {
			this.setStaff(bpjsDoctorMappingEntityDto.getStaff());
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
	@CsvBindByName(column = "REF_CODE", required = true)
	@NotNull(message = "Ref Code must not be empty")
	@Length(message = "Length must be less than or equal to 25", max = 25)
	@Column(name = "ref_code")
	@Schema(description = "The Ref Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Code here] end
	private String refCode;

	// % protected region % [Modify attribute annotation for BPJS Medical Staff here] off begin
	@CsvBindByName(column = "BPJS_MEDICAL_STAFF", required = true)
	@NotNull(message = "BPJS Medical Staff must not be empty")
	@Column(name = "bpjs_medical_staff")
	@Schema(description = "The BPJS Medical Staff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Medical Staff here] end
	private String bpjsMedicalStaff;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 1000", max = 1000)
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Ref Code Service here] off begin
	@CsvBindByName(column = "REF_CODE_SERVICE", required = false)
	@Nullable
	@Column(name = "ref_code_service")
	@Schema(description = "The Ref Code Service of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Code Service here] end
	private String refCodeService;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDoctorMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
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
	@OneToMany(mappedBy = "bpjsDoctorMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Control Plans here] end
	private Set<BpjsControlPlanEntity> bpjsControlPlans = new HashSet<>();

	// % protected region % [Update the annotation for bpjsControlPlansIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CONTROL_PLANS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsControlPlansIds here] end
	private Set<UUID> bpjsControlPlansIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS PRBs here] off begin
	@Schema(description = "The BPJS PRB entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDoctorMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS PRBs here] end
	private Set<BpjsPRBEntity> bpjsPRBs = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPRBsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PRBS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPRBsIds here] end
	private Set<UUID> bpjsPRBsIds = new HashSet<>();

	// % protected region % [Update the annotation for kodeDokter here] off begin
	@Schema(description = "The BPJS Hospitalization Plan entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDoctorMapping", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for kodeDokter here] end
	private Set<BpjsHospitalizationPlanEntity> kodedokter = new HashSet<>();

	// % protected region % [Update the annotation for kodedokterIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "KODEDOKTER_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for kodedokterIds here] end
	private Set<UUID> kodedokterIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

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
				entity.setBpjsDoctorMapping(this, false);
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
			entity.unsetBpjsDoctorMapping(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsDoctorMapping(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsDoctorMapping(false));
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
				entity.setBpjsDoctorMapping(this, false);
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
			entity.unsetBpjsDoctorMapping(false);
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
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.setBpjsDoctorMapping(this, false));
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
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.unsetBpjsDoctorMapping(false));
		}
		this.bpjsControlPlans.clear();
	}

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
				entity.setBpjsDoctorMapping(this, false);
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
			entity.unsetBpjsDoctorMapping(false);
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
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.setBpjsDoctorMapping(this, false));
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
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.unsetBpjsDoctorMapping(false));
		}
		this.bpjsPRBs.clear();
	}

/**
	 * Similar to {@link this#addKodedokter(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addKodedokter(@NotNull BpjsHospitalizationPlanEntity entity) {
		addKodedokter(entity, true);
	}

	/**
	 * Add a new BpjsHospitalizationPlanEntity to kodedokter in this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addKodedokter(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverseAdd) {
		if (!this.kodedokter.contains(entity)) {
			kodedokter.add(entity);
			if (reverseAdd) {
				entity.setBpjsDoctorMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addKodedokter(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addKodedokter(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		addKodedokter(entities, true);
	}

	/**
	 * Add a new collection of BpjsHospitalizationPlanEntity to kodeDokter in this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addKodedokter(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeKodedokter(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void removeKodedokter(@NotNull BpjsHospitalizationPlanEntity entity) {
		this.removeKodedokter(entity, true);
	}

	/**
	 * Remove the given BpjsHospitalizationPlanEntity from this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeKodedokter(@NotNull BpjsHospitalizationPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDoctorMapping(false);
		}
		this.kodedokter.remove(entity);
	}

	/**
	 * Similar to {@link this#removeKodedokter(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 */
	public void removeKodedokter(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		this.removeKodedokter(entities, true);
	}

	/**
	 * Remove the given collection of BpjsHospitalizationPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeKodedokter(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setKodedokter(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void setKodedokter(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		setKodedokter(entities, true);
	}

	/**
	 * Replace the current entities in kodeDokter with the given ones.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setKodedokter(@NotNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {

		this.unsetKodedokter();
		this.kodedokter = new HashSet<>(entities);
		if (reverseAdd) {
			this.kodedokter.forEach(kodedokterEntity -> kodedokterEntity.setBpjsDoctorMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetKodedokter(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetKodedokter() {
		this.unsetKodedokter(true);
	}

	/**
	 * Remove all the entities in kodeDokter from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetKodedokter(boolean doReverse) {
		if (doReverse) {
			this.kodedokter.forEach(kodedokterEntity -> kodedokterEntity.unsetBpjsDoctorMapping(false));
		}
		this.kodedokter.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.unsetBpjsDoctorMapping(false);
		}

		this.staff = entity;
		if (reverseAdd) {
			this.staff.setBpjsDoctorMapping(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove the StaffEntity of staff from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.unsetBpjsDoctorMapping();
		}
		this.staff = null;
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
		return "REF_CODE,BPJS_MEDICAL_STAFF,NOTES,REF_CODE_SERVICE,STAFF_ID,BPJS_CLAIM_SUBMISSIONS_IDS,BPJS_CONTROL_PLANS_IDS,BPJS_PRBS_IDS,KODEDOKTER_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		this.bpjsClaimSubmissionsIds = new HashSet<>();
		for (BpjsClaimSubmissionEntity bpjsClaimSubmissions: this.bpjsClaimSubmissions) {
			this.bpjsClaimSubmissionsIds.add(bpjsClaimSubmissions.getId());
		}

		this.bpjsControlPlansIds = new HashSet<>();
		for (BpjsControlPlanEntity bpjsControlPlans: this.bpjsControlPlans) {
			this.bpjsControlPlansIds.add(bpjsControlPlans.getId());
		}

		this.bpjsPRBsIds = new HashSet<>();
		for (BpjsPRBEntity bpjsPRBs: this.bpjsPRBs) {
			this.bpjsPRBsIds.add(bpjsPRBs.getId());
		}

		this.kodedokterIds = new HashSet<>();
		for (BpjsHospitalizationPlanEntity kodedokter: this.kodedokter) {
			this.kodedokterIds.add(kodedokter.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsDoctorMapping) {
		if (this == bpjsDoctorMapping) {
			return true;
		}
		if (bpjsDoctorMapping == null || this.getClass() != bpjsDoctorMapping.getClass()) {
			return false;
		}
		if (!super.equals(bpjsDoctorMapping)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsDoctorMappingEntity that = (BpjsDoctorMappingEntity) bpjsDoctorMapping;
		return
			Objects.equals(this.refCode, that.refCode) &&
			Objects.equals(this.bpjsMedicalStaff, that.bpjsMedicalStaff) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.refCodeService, that.refCodeService) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.bpjsControlPlansIds, that.bpjsControlPlansIds) &&
			Objects.equals(this.bpjsPRBsIds, that.bpjsPRBsIds) &&
			Objects.equals(this.kodedokterIds, that.kodedokterIds) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
