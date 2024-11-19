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
import kmsweb.dtos.PatientPaymentBPJSEntityDto;
import kmsweb.entities.listeners.PatientPaymentBPJSEntityListener;
import kmsweb.serializers.PatientPaymentBPJSSerializer;
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
@EntityListeners({PatientPaymentBPJSEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientPaymentBPJSSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientPaymentBPJSEntity extends AbstractEntity {

	/**
	 * Takes a PatientPaymentBPJSEntityDto and converts it into a PatientPaymentBPJSEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientPaymentBPJSEntityDto
	 */
	public PatientPaymentBPJSEntity(PatientPaymentBPJSEntityDto patientPaymentBPJSEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientPaymentBPJSEntityDto.getId() != null) {
			this.setId(patientPaymentBPJSEntityDto.getId());
		}

		if (patientPaymentBPJSEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(patientPaymentBPJSEntityDto.getBpjsCardNo());
		}

		if (patientPaymentBPJSEntityDto.getNotes() != null) {
			this.setNotes(patientPaymentBPJSEntityDto.getNotes());
		}

		if (patientPaymentBPJSEntityDto.getBpjsAccidentMasters() != null) {
			this.setBpjsAccidentMasters(patientPaymentBPJSEntityDto.getBpjsAccidentMasters());
		}

		if (patientPaymentBPJSEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(patientPaymentBPJSEntityDto.getBpjsClaimSubmissions());
		}

		if (patientPaymentBPJSEntityDto.getBpjsHospitalizationPlans() != null) {
			this.setBpjsHospitalizationPlans(patientPaymentBPJSEntityDto.getBpjsHospitalizationPlans());
		}

		if (patientPaymentBPJSEntityDto.getBpjsJasaRaharjas() != null) {
			this.setBpjsJasaRaharjas(patientPaymentBPJSEntityDto.getBpjsJasaRaharjas());
		}

		if (patientPaymentBPJSEntityDto.getBpjsPatientReferrals() != null) {
			this.setBpjsPatientReferrals(patientPaymentBPJSEntityDto.getBpjsPatientReferrals());
		}

		if (patientPaymentBPJSEntityDto.getBpjsSEPSubmissions() != null) {
			this.setBpjsSEPSubmissions(patientPaymentBPJSEntityDto.getBpjsSEPSubmissions());
		}

		if (patientPaymentBPJSEntityDto.getBpjsSEPs() != null) {
			this.setBpjsSEPs(patientPaymentBPJSEntityDto.getBpjsSEPs());
		}

		if (patientPaymentBPJSEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(patientPaymentBPJSEntityDto.getPatientGeneralInfo());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Accident Masters here] off begin
	@Schema(description = "The BPJS Accident Master entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Accident Masters here] end
	private Set<BpjsAccidentMasterEntity> bpjsAccidentMasters = new HashSet<>();

	// % protected region % [Update the annotation for bpjsAccidentMastersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_ACCIDENT_MASTERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsAccidentMastersIds here] end
	private Set<UUID> bpjsAccidentMastersIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submissions here] end
	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] end
	private Set<UUID> bpjsClaimSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Hospitalization Plans here] off begin
	@Schema(description = "The BPJS Hospitalization Plan entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Hospitalization Plans here] end
	private Set<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlans = new HashSet<>();

	// % protected region % [Update the annotation for bpjsHospitalizationPlansIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_HOSPITALIZATION_PLANS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsHospitalizationPlansIds here] end
	private Set<UUID> bpjsHospitalizationPlansIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Jasa Raharjas here] off begin
	@Schema(description = "The BPJS Jasa Raharja entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Jasa Raharjas here] end
	private Set<BpjsJasaRaharjaEntity> bpjsJasaRaharjas = new HashSet<>();

	// % protected region % [Update the annotation for bpjsJasaRaharjasIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_JASA_RAHARJAS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsJasaRaharjasIds here] end
	private Set<UUID> bpjsJasaRaharjasIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Patient Referrals here] off begin
	@Schema(description = "The BPJS Patient Referral entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Patient Referrals here] end
	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PATIENT_REFERRALS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPatientReferralsIds here] end
	private Set<UUID> bpjsPatientReferralsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS SEP Submissions here] off begin
	@Schema(description = "The BPJS SEP Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS SEP Submissions here] end
	private Set<BpjsSEPSubmissionEntity> bpjsSEPSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsSEPSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_SEP_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsSEPSubmissionsIds here] end
	private Set<UUID> bpjsSEPSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS SEPs here] off begin
	@Schema(description = "The BPJS SEP entities that are related to this entity.")
	@OneToMany(mappedBy = "patientPaymentBPJS", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS SEPs here] end
	private Set<BpjsSEPEntity> bpjsSEPs = new HashSet<>();

	// % protected region % [Update the annotation for bpjsSEPsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_SEPS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsSEPsIds here] end
	private Set<UUID> bpjsSEPsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Patient General Info here] off begin
	@Schema(description = "The Patient General Info entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Info here] end
	private PatientGeneralInfoEntity patientGeneralInfo;

	// % protected region % [Update the annotation for patientGeneralInfoId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFO_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInfoId here] end
	private UUID patientGeneralInfoId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addBpjsAccidentMasters(BpjsAccidentMasterEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsAccidentMasterEntity to be added to this entity
	 */
	public void addBpjsAccidentMasters(@NotNull BpjsAccidentMasterEntity entity) {
		addBpjsAccidentMasters(entity, true);
	}

	/**
	 * Add a new BpjsAccidentMasterEntity to bpjsAccidentMasters in this entity.
	 *
	 * @param entity the given BpjsAccidentMasterEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsAccidentMasters(@NonNull BpjsAccidentMasterEntity entity, boolean reverseAdd) {
		if (!this.bpjsAccidentMasters.contains(entity)) {
			bpjsAccidentMasters.add(entity);
			if (reverseAdd) {
				entity.setPatientPaymentBPJS(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsAccidentMasters(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsAccidentMasterEntity to be added to this entity
	 */
	public void addBpjsAccidentMasters(@NotNull Collection<BpjsAccidentMasterEntity> entities) {
		addBpjsAccidentMasters(entities, true);
	}

	/**
	 * Add a new collection of BpjsAccidentMasterEntity to BPJS Accident Masters in this entity.
	 *
	 * @param entities the given collection of BpjsAccidentMasterEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsAccidentMasters(@NonNull Collection<BpjsAccidentMasterEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsAccidentMasters(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsAccidentMasters(BpjsAccidentMasterEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsAccidentMasterEntity to be set to this entity
	 */
	public void removeBpjsAccidentMasters(@NotNull BpjsAccidentMasterEntity entity) {
		this.removeBpjsAccidentMasters(entity, true);
	}

	/**
	 * Remove the given BpjsAccidentMasterEntity from this entity.
	 *
	 * @param entity the given BpjsAccidentMasterEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsAccidentMasters(@NotNull BpjsAccidentMasterEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientPaymentBPJS(false);
		}
		this.bpjsAccidentMasters.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsAccidentMasters(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsAccidentMasterEntity to be removed to this entity
	 */
	public void removeBpjsAccidentMasters(@NotNull Collection<BpjsAccidentMasterEntity> entities) {
		this.removeBpjsAccidentMasters(entities, true);
	}

	/**
	 * Remove the given collection of BpjsAccidentMasterEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsAccidentMasterEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsAccidentMasters(@NonNull Collection<BpjsAccidentMasterEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsAccidentMasters(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsAccidentMasters(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsAccidentMasterEntity to be set to this entity
	 */
	public void setBpjsAccidentMasters(@NotNull Collection<BpjsAccidentMasterEntity> entities) {
		setBpjsAccidentMasters(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Accident Masters with the given ones.
	 *
	 * @param entities the given collection of BpjsAccidentMasterEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsAccidentMasters(@NotNull Collection<BpjsAccidentMasterEntity> entities, boolean reverseAdd) {

		this.unsetBpjsAccidentMasters();
		this.bpjsAccidentMasters = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsAccidentMasters.forEach(bpjsAccidentMastersEntity -> bpjsAccidentMastersEntity.setPatientPaymentBPJS(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsAccidentMasters(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsAccidentMasters() {
		this.unsetBpjsAccidentMasters(true);
	}

	/**
	 * Remove all the entities in BPJS Accident Masters from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsAccidentMasters(boolean doReverse) {
		if (doReverse) {
			this.bpjsAccidentMasters.forEach(bpjsAccidentMastersEntity -> bpjsAccidentMastersEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsAccidentMasters.clear();
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
				entity.setPatientPaymentBPJS(this, false);
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
			entity.unsetPatientPaymentBPJS(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setPatientPaymentBPJS(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsHospitalizationPlans(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addBpjsHospitalizationPlans(@NotNull BpjsHospitalizationPlanEntity entity) {
		addBpjsHospitalizationPlans(entity, true);
	}

	/**
	 * Add a new BpjsHospitalizationPlanEntity to bpjsHospitalizationPlans in this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsHospitalizationPlans(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverseAdd) {
		if (!this.bpjsHospitalizationPlans.contains(entity)) {
			bpjsHospitalizationPlans.add(entity);
			if (reverseAdd) {
				entity.setPatientPaymentBPJS(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsHospitalizationPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addBpjsHospitalizationPlans(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		addBpjsHospitalizationPlans(entities, true);
	}

	/**
	 * Add a new collection of BpjsHospitalizationPlanEntity to BPJS Hospitalization Plans in this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsHospitalizationPlans(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsHospitalizationPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsHospitalizationPlans(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void removeBpjsHospitalizationPlans(@NotNull BpjsHospitalizationPlanEntity entity) {
		this.removeBpjsHospitalizationPlans(entity, true);
	}

	/**
	 * Remove the given BpjsHospitalizationPlanEntity from this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsHospitalizationPlans(@NotNull BpjsHospitalizationPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientPaymentBPJS(false);
		}
		this.bpjsHospitalizationPlans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsHospitalizationPlans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 */
	public void removeBpjsHospitalizationPlans(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		this.removeBpjsHospitalizationPlans(entities, true);
	}

	/**
	 * Remove the given collection of BpjsHospitalizationPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsHospitalizationPlans(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsHospitalizationPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsHospitalizationPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void setBpjsHospitalizationPlans(@NotNull Collection<BpjsHospitalizationPlanEntity> entities) {
		setBpjsHospitalizationPlans(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Hospitalization Plans with the given ones.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsHospitalizationPlans(@NotNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {

		this.unsetBpjsHospitalizationPlans();
		this.bpjsHospitalizationPlans = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsHospitalizationPlans.forEach(bpjsHospitalizationPlansEntity -> bpjsHospitalizationPlansEntity.setPatientPaymentBPJS(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsHospitalizationPlans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsHospitalizationPlans() {
		this.unsetBpjsHospitalizationPlans(true);
	}

	/**
	 * Remove all the entities in BPJS Hospitalization Plans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsHospitalizationPlans(boolean doReverse) {
		if (doReverse) {
			this.bpjsHospitalizationPlans.forEach(bpjsHospitalizationPlansEntity -> bpjsHospitalizationPlansEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsHospitalizationPlans.clear();
	}

/**
	 * Similar to {@link this#addBpjsJasaRaharjas(BpjsJasaRaharjaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsJasaRaharjaEntity to be added to this entity
	 */
	public void addBpjsJasaRaharjas(@NotNull BpjsJasaRaharjaEntity entity) {
		addBpjsJasaRaharjas(entity, true);
	}

	/**
	 * Add a new BpjsJasaRaharjaEntity to bpjsJasaRaharjas in this entity.
	 *
	 * @param entity the given BpjsJasaRaharjaEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsJasaRaharjas(@NonNull BpjsJasaRaharjaEntity entity, boolean reverseAdd) {
		if (!this.bpjsJasaRaharjas.contains(entity)) {
			bpjsJasaRaharjas.add(entity);
			if (reverseAdd) {
				entity.setPatientPaymentBPJS(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsJasaRaharjas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsJasaRaharjaEntity to be added to this entity
	 */
	public void addBpjsJasaRaharjas(@NotNull Collection<BpjsJasaRaharjaEntity> entities) {
		addBpjsJasaRaharjas(entities, true);
	}

	/**
	 * Add a new collection of BpjsJasaRaharjaEntity to BPJS Jasa Raharjas in this entity.
	 *
	 * @param entities the given collection of BpjsJasaRaharjaEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsJasaRaharjas(@NonNull Collection<BpjsJasaRaharjaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsJasaRaharjas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsJasaRaharjas(BpjsJasaRaharjaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsJasaRaharjaEntity to be set to this entity
	 */
	public void removeBpjsJasaRaharjas(@NotNull BpjsJasaRaharjaEntity entity) {
		this.removeBpjsJasaRaharjas(entity, true);
	}

	/**
	 * Remove the given BpjsJasaRaharjaEntity from this entity.
	 *
	 * @param entity the given BpjsJasaRaharjaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsJasaRaharjas(@NotNull BpjsJasaRaharjaEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientPaymentBPJS(false);
		}
		this.bpjsJasaRaharjas.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsJasaRaharjas(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsJasaRaharjaEntity to be removed to this entity
	 */
	public void removeBpjsJasaRaharjas(@NotNull Collection<BpjsJasaRaharjaEntity> entities) {
		this.removeBpjsJasaRaharjas(entities, true);
	}

	/**
	 * Remove the given collection of BpjsJasaRaharjaEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsJasaRaharjaEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsJasaRaharjas(@NonNull Collection<BpjsJasaRaharjaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsJasaRaharjas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsJasaRaharjas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsJasaRaharjaEntity to be set to this entity
	 */
	public void setBpjsJasaRaharjas(@NotNull Collection<BpjsJasaRaharjaEntity> entities) {
		setBpjsJasaRaharjas(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Jasa Raharjas with the given ones.
	 *
	 * @param entities the given collection of BpjsJasaRaharjaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsJasaRaharjas(@NotNull Collection<BpjsJasaRaharjaEntity> entities, boolean reverseAdd) {

		this.unsetBpjsJasaRaharjas();
		this.bpjsJasaRaharjas = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsJasaRaharjas.forEach(bpjsJasaRaharjasEntity -> bpjsJasaRaharjasEntity.setPatientPaymentBPJS(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsJasaRaharjas(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsJasaRaharjas() {
		this.unsetBpjsJasaRaharjas(true);
	}

	/**
	 * Remove all the entities in BPJS Jasa Raharjas from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsJasaRaharjas(boolean doReverse) {
		if (doReverse) {
			this.bpjsJasaRaharjas.forEach(bpjsJasaRaharjasEntity -> bpjsJasaRaharjasEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsJasaRaharjas.clear();
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
				entity.setPatientPaymentBPJS(this, false);
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
			entity.unsetPatientPaymentBPJS(false);
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setPatientPaymentBPJS(this, false));
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsPatientReferrals.clear();
	}

/**
	 * Similar to {@link this#addBpjsSEPSubmissions(BpjsSEPSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSEPSubmissionEntity to be added to this entity
	 */
	public void addBpjsSEPSubmissions(@NotNull BpjsSEPSubmissionEntity entity) {
		addBpjsSEPSubmissions(entity, true);
	}

	/**
	 * Add a new BpjsSEPSubmissionEntity to bpjsSEPSubmissions in this entity.
	 *
	 * @param entity the given BpjsSEPSubmissionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsSEPSubmissions(@NonNull BpjsSEPSubmissionEntity entity, boolean reverseAdd) {
		if (!this.bpjsSEPSubmissions.contains(entity)) {
			bpjsSEPSubmissions.add(entity);
			if (reverseAdd) {
				entity.setPatientPaymentBPJS(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsSEPSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSEPSubmissionEntity to be added to this entity
	 */
	public void addBpjsSEPSubmissions(@NotNull Collection<BpjsSEPSubmissionEntity> entities) {
		addBpjsSEPSubmissions(entities, true);
	}

	/**
	 * Add a new collection of BpjsSEPSubmissionEntity to BPJS SEP Submissions in this entity.
	 *
	 * @param entities the given collection of BpjsSEPSubmissionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsSEPSubmissions(@NonNull Collection<BpjsSEPSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsSEPSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsSEPSubmissions(BpjsSEPSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSEPSubmissionEntity to be set to this entity
	 */
	public void removeBpjsSEPSubmissions(@NotNull BpjsSEPSubmissionEntity entity) {
		this.removeBpjsSEPSubmissions(entity, true);
	}

	/**
	 * Remove the given BpjsSEPSubmissionEntity from this entity.
	 *
	 * @param entity the given BpjsSEPSubmissionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsSEPSubmissions(@NotNull BpjsSEPSubmissionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientPaymentBPJS(false);
		}
		this.bpjsSEPSubmissions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsSEPSubmissions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSEPSubmissionEntity to be removed to this entity
	 */
	public void removeBpjsSEPSubmissions(@NotNull Collection<BpjsSEPSubmissionEntity> entities) {
		this.removeBpjsSEPSubmissions(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSEPSubmissionEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSEPSubmissionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsSEPSubmissions(@NonNull Collection<BpjsSEPSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsSEPSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsSEPSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSEPSubmissionEntity to be set to this entity
	 */
	public void setBpjsSEPSubmissions(@NotNull Collection<BpjsSEPSubmissionEntity> entities) {
		setBpjsSEPSubmissions(entities, true);
	}

	/**
	 * Replace the current entities in BPJS SEP Submissions with the given ones.
	 *
	 * @param entities the given collection of BpjsSEPSubmissionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsSEPSubmissions(@NotNull Collection<BpjsSEPSubmissionEntity> entities, boolean reverseAdd) {

		this.unsetBpjsSEPSubmissions();
		this.bpjsSEPSubmissions = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsSEPSubmissions.forEach(bpjsSEPSubmissionsEntity -> bpjsSEPSubmissionsEntity.setPatientPaymentBPJS(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsSEPSubmissions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsSEPSubmissions() {
		this.unsetBpjsSEPSubmissions(true);
	}

	/**
	 * Remove all the entities in BPJS SEP Submissions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsSEPSubmissions(boolean doReverse) {
		if (doReverse) {
			this.bpjsSEPSubmissions.forEach(bpjsSEPSubmissionsEntity -> bpjsSEPSubmissionsEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsSEPSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsSEPs(BpjsSEPEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSEPEntity to be added to this entity
	 */
	public void addBpjsSEPs(@NotNull BpjsSEPEntity entity) {
		addBpjsSEPs(entity, true);
	}

	/**
	 * Add a new BpjsSEPEntity to bpjsSEPs in this entity.
	 *
	 * @param entity the given BpjsSEPEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsSEPs(@NonNull BpjsSEPEntity entity, boolean reverseAdd) {
		if (!this.bpjsSEPs.contains(entity)) {
			bpjsSEPs.add(entity);
			if (reverseAdd) {
				entity.setPatientPaymentBPJS(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsSEPs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSEPEntity to be added to this entity
	 */
	public void addBpjsSEPs(@NotNull Collection<BpjsSEPEntity> entities) {
		addBpjsSEPs(entities, true);
	}

	/**
	 * Add a new collection of BpjsSEPEntity to BPJS SEPs in this entity.
	 *
	 * @param entities the given collection of BpjsSEPEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsSEPs(@NonNull Collection<BpjsSEPEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsSEPs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsSEPs(BpjsSEPEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSEPEntity to be set to this entity
	 */
	public void removeBpjsSEPs(@NotNull BpjsSEPEntity entity) {
		this.removeBpjsSEPs(entity, true);
	}

	/**
	 * Remove the given BpjsSEPEntity from this entity.
	 *
	 * @param entity the given BpjsSEPEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsSEPs(@NotNull BpjsSEPEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientPaymentBPJS(false);
		}
		this.bpjsSEPs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsSEPs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSEPEntity to be removed to this entity
	 */
	public void removeBpjsSEPs(@NotNull Collection<BpjsSEPEntity> entities) {
		this.removeBpjsSEPs(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSEPEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSEPEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsSEPs(@NonNull Collection<BpjsSEPEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsSEPs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsSEPs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSEPEntity to be set to this entity
	 */
	public void setBpjsSEPs(@NotNull Collection<BpjsSEPEntity> entities) {
		setBpjsSEPs(entities, true);
	}

	/**
	 * Replace the current entities in BPJS SEPs with the given ones.
	 *
	 * @param entities the given collection of BpjsSEPEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsSEPs(@NotNull Collection<BpjsSEPEntity> entities, boolean reverseAdd) {

		this.unsetBpjsSEPs();
		this.bpjsSEPs = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsSEPs.forEach(bpjsSEPsEntity -> bpjsSEPsEntity.setPatientPaymentBPJS(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsSEPs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsSEPs() {
		this.unsetBpjsSEPs(true);
	}

	/**
	 * Remove all the entities in BPJS SEPs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsSEPs(boolean doReverse) {
		if (doReverse) {
			this.bpjsSEPs.forEach(bpjsSEPsEntity -> bpjsSEPsEntity.unsetPatientPaymentBPJS(false));
		}
		this.bpjsSEPs.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.unsetPatientPaymentBPJS(false);
		}

		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.setPatientPaymentBPJS(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInfo from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.unsetPatientPaymentBPJS();
		}
		this.patientGeneralInfo = null;
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
		return "BPJS_CARD_NO,NOTES,PATIENT_GENERAL_INFO_ID,BPJS_ACCIDENT_MASTERS_IDS,BPJS_CLAIM_SUBMISSIONS_IDS,BPJS_HOSPITALIZATION_PLANS_IDS,BPJS_JASA_RAHARJAS_IDS,BPJS_PATIENT_REFERRALS_IDS,BPJS_SEP_SUBMISSIONS_IDS,BPJS_SEPS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientGeneralInfoEntity> patientGeneralInfoRelation = Optional.ofNullable(this.patientGeneralInfo);
		patientGeneralInfoRelation.ifPresent(entity -> this.patientGeneralInfoId = entity.getId());

		this.bpjsAccidentMastersIds = new HashSet<>();
		for (BpjsAccidentMasterEntity bpjsAccidentMasters: this.bpjsAccidentMasters) {
			this.bpjsAccidentMastersIds.add(bpjsAccidentMasters.getId());
		}

		this.bpjsClaimSubmissionsIds = new HashSet<>();
		for (BpjsClaimSubmissionEntity bpjsClaimSubmissions: this.bpjsClaimSubmissions) {
			this.bpjsClaimSubmissionsIds.add(bpjsClaimSubmissions.getId());
		}

		this.bpjsHospitalizationPlansIds = new HashSet<>();
		for (BpjsHospitalizationPlanEntity bpjsHospitalizationPlans: this.bpjsHospitalizationPlans) {
			this.bpjsHospitalizationPlansIds.add(bpjsHospitalizationPlans.getId());
		}

		this.bpjsJasaRaharjasIds = new HashSet<>();
		for (BpjsJasaRaharjaEntity bpjsJasaRaharjas: this.bpjsJasaRaharjas) {
			this.bpjsJasaRaharjasIds.add(bpjsJasaRaharjas.getId());
		}

		this.bpjsPatientReferralsIds = new HashSet<>();
		for (BpjsPatientReferralEntity bpjsPatientReferrals: this.bpjsPatientReferrals) {
			this.bpjsPatientReferralsIds.add(bpjsPatientReferrals.getId());
		}

		this.bpjsSEPSubmissionsIds = new HashSet<>();
		for (BpjsSEPSubmissionEntity bpjsSEPSubmissions: this.bpjsSEPSubmissions) {
			this.bpjsSEPSubmissionsIds.add(bpjsSEPSubmissions.getId());
		}

		this.bpjsSEPsIds = new HashSet<>();
		for (BpjsSEPEntity bpjsSEPs: this.bpjsSEPs) {
			this.bpjsSEPsIds.add(bpjsSEPs.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientPaymentBPJS) {
		if (this == patientPaymentBPJS) {
			return true;
		}
		if (patientPaymentBPJS == null || this.getClass() != patientPaymentBPJS.getClass()) {
			return false;
		}
		if (!super.equals(patientPaymentBPJS)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientPaymentBPJSEntity that = (PatientPaymentBPJSEntity) patientPaymentBPJS;
		return
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.bpjsAccidentMastersIds, that.bpjsAccidentMastersIds) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.bpjsHospitalizationPlansIds, that.bpjsHospitalizationPlansIds) &&
			Objects.equals(this.bpjsJasaRaharjasIds, that.bpjsJasaRaharjasIds) &&
			Objects.equals(this.bpjsPatientReferralsIds, that.bpjsPatientReferralsIds) &&
			Objects.equals(this.bpjsSEPSubmissionsIds, that.bpjsSEPSubmissionsIds) &&
			Objects.equals(this.bpjsSEPsIds, that.bpjsSEPsIds) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
