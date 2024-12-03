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
import kmsweb.dtos.BpjsClaimSubmissionEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.BpjsClaimSubmissionEntityListener;
import kmsweb.serializers.BpjsClaimSubmissionSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({BpjsClaimSubmissionEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsClaimSubmissionSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsClaimSubmissionEntity extends AbstractEntity {

	/**
	 * Takes a BpjsClaimSubmissionEntityDto and converts it into a BpjsClaimSubmissionEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsClaimSubmissionEntityDto
	 */
	public BpjsClaimSubmissionEntity(BpjsClaimSubmissionEntityDto bpjsClaimSubmissionEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsClaimSubmissionEntityDto.getId() != null) {
			this.setId(bpjsClaimSubmissionEntityDto.getId());
		}

		if (bpjsClaimSubmissionEntityDto.getSepNo() != null) {
			this.setSepNo(bpjsClaimSubmissionEntityDto.getSepNo());
		}

		if (bpjsClaimSubmissionEntityDto.getAdmissionDate() != null) {
			this.setAdmissionDate(bpjsClaimSubmissionEntityDto.getAdmissionDate());
		}

		if (bpjsClaimSubmissionEntityDto.getDismissalDate() != null) {
			this.setDismissalDate(bpjsClaimSubmissionEntityDto.getDismissalDate());
		}

		if (bpjsClaimSubmissionEntityDto.getInsuranceProvider() != null) {
			this.setInsuranceProvider(bpjsClaimSubmissionEntityDto.getInsuranceProvider());
		}

		if (bpjsClaimSubmissionEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsClaimSubmissionEntityDto.getTreatmentType());
		}

		if (bpjsClaimSubmissionEntityDto.getFollowUpPlan() != null) {
			this.setFollowUpPlan(bpjsClaimSubmissionEntityDto.getFollowUpPlan());
		}

		if (bpjsClaimSubmissionEntityDto.getControlDate() != null) {
			this.setControlDate(bpjsClaimSubmissionEntityDto.getControlDate());
		}

		if (bpjsClaimSubmissionEntityDto.getAdditionalDiagnosis() != null) {
			this.setAdditionalDiagnosis(bpjsClaimSubmissionEntityDto.getAdditionalDiagnosis());
		}

		if (bpjsClaimSubmissionEntityDto.getAdditionalProcedure() != null) {
			this.setAdditionalProcedure(bpjsClaimSubmissionEntityDto.getAdditionalProcedure());
		}

		if (bpjsClaimSubmissionEntityDto.getKelasRawat() != null) {
			this.setKelasRawat(bpjsClaimSubmissionEntityDto.getKelasRawat());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsDismissalConditions() != null) {
			this.setBpjsDismissalConditions(bpjsClaimSubmissionEntityDto.getBpjsDismissalConditions());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsDismissalMappings() != null) {
			this.setBpjsDismissalMappings(bpjsClaimSubmissionEntityDto.getBpjsDismissalMappings());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsTreatmentRooms() != null) {
			this.setBpjsTreatmentRooms(bpjsClaimSubmissionEntityDto.getBpjsTreatmentRooms());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsDiagnose() != null) {
			this.setBpjsDiagnose(bpjsClaimSubmissionEntityDto.getBpjsDiagnose());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsDoctorMapping() != null) {
			this.setBpjsDoctorMapping(bpjsClaimSubmissionEntityDto.getBpjsDoctorMapping());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsHealthFacility() != null) {
			this.setBpjsHealthFacility(bpjsClaimSubmissionEntityDto.getBpjsHealthFacility());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsProcedure() != null) {
			this.setBpjsProcedure(bpjsClaimSubmissionEntityDto.getBpjsProcedure());
		}

		if (bpjsClaimSubmissionEntityDto.getBpjsServiceMapping() != null) {
			this.setBpjsServiceMapping(bpjsClaimSubmissionEntityDto.getBpjsServiceMapping());
		}

		if (bpjsClaimSubmissionEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(bpjsClaimSubmissionEntityDto.getPatientGeneralInfo());
		}

		if (bpjsClaimSubmissionEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(bpjsClaimSubmissionEntityDto.getPatientPaymentBPJS());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@CsvBindByName(column = "SEP_NO", required = false)
	@Nullable
	@Column(name = "sep_no")
	@Schema(description = "The SEP No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Admission Date here] off begin

	@CsvCustomBindByName(column = "ADMISSION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "admission_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Admission Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Admission Date here] end
	private OffsetDateTime admissionDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin

	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Insurance Provider here] off begin
	@CsvBindByName(column = "INSURANCE_PROVIDER", required = false)
	@Nullable
	@Column(name = "insurance_provider")
	@Schema(description = "The Insurance Provider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Insurance Provider here] end
	private String insuranceProvider;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@CsvBindByName(column = "TREATMENT_TYPE", required = false)
	@Nullable
	@Column(name = "treatment_type")
	@Schema(description = "The Treatment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

	// % protected region % [Modify attribute annotation for Follow Up Plan here] off begin
	@CsvBindByName(column = "FOLLOW_UP_PLAN", required = false)
	@Nullable
	@Column(name = "follow_up_plan")
	@Schema(description = "The Follow Up Plan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Follow Up Plan here] end
	private String followUpPlan;

	// % protected region % [Modify attribute annotation for Control Date here] off begin

	@CsvCustomBindByName(column = "CONTROL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "control_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Control Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Control Date here] end
	private OffsetDateTime controlDate;

	// % protected region % [Modify attribute annotation for Additional Diagnosis here] off begin
	@CsvBindByName(column = "ADDITIONAL_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "additional_diagnosis")
	@Schema(description = "The Additional Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Additional Diagnosis here] end
	private String additionalDiagnosis;

	// % protected region % [Modify attribute annotation for Additional Procedure here] off begin
	@CsvBindByName(column = "ADDITIONAL_PROCEDURE", required = false)
	@Nullable
	@Column(name = "additional_procedure")
	@Schema(description = "The Additional Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Additional Procedure here] end
	private String additionalProcedure;

	// % protected region % [Modify attribute annotation for Kelas Rawat here] off begin
	@CsvCustomBindByName(column = "KELAS_RAWAT", required = false, converter = KelasRawatEnumConverter.class)
	@Nullable
	@Column(name = "kelas_rawat")
	@Schema(description = "The Kelas Rawat of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Kelas Rawat here] end
	private KelasRawatEnum kelasRawat;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Dismissal Conditions here] off begin
	@Schema(description = "The BPJS Dismissal Condition entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsClaimSubmission", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Dismissal Conditions here] end
	private Set<BpjsDismissalConditionEntity> bpjsDismissalConditions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsDismissalConditionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DISMISSAL_CONDITIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsDismissalConditionsIds here] end
	private Set<UUID> bpjsDismissalConditionsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Dismissal Mappings here] off begin
	@Schema(description = "The BPJS Dismissal Mapping entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsClaimSubmission", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Dismissal Mappings here] end
	private Set<BpjsDismissalMappingEntity> bpjsDismissalMappings = new HashSet<>();

	// % protected region % [Update the annotation for bpjsDismissalMappingsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DISMISSAL_MAPPINGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsDismissalMappingsIds here] end
	private Set<UUID> bpjsDismissalMappingsIds = new HashSet<>();

	// % protected region % [Update the annotation for BPJS Treatment Rooms here] off begin
	@Schema(description = "The BPJS Treatment Room entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsClaimSubmission", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Treatment Rooms here] end
	private Set<BpjsTreatmentRoomEntity> bpjsTreatmentRooms = new HashSet<>();

	// % protected region % [Update the annotation for bpjsTreatmentRoomsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_TREATMENT_ROOMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsTreatmentRoomsIds here] end
	private Set<UUID> bpjsTreatmentRoomsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Diagnose here] off begin
	@Schema(description = "The BPJS Diagnose entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Diagnose here] end
	private BpjsDiagnoseEntity bpjsDiagnose;

	// % protected region % [Update the annotation for bpjsDiagnoseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DIAGNOSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDiagnoseId here] end
	private UUID bpjsDiagnoseId;

	// % protected region % [Update the annotation for BPJS Doctor Mapping here] off begin
	@Schema(description = "The BPJS Doctor Mapping entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Doctor Mapping here] end
	private BpjsDoctorMappingEntity bpjsDoctorMapping;

	// % protected region % [Update the annotation for bpjsDoctorMappingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DOCTOR_MAPPING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDoctorMappingId here] end
	private UUID bpjsDoctorMappingId;

	// % protected region % [Update the annotation for BPJS Health Facility here] off begin
	@Schema(description = "The BPJS Health Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Health Facility here] end
	private BpjsHealthFacilityEntity bpjsHealthFacility;

	// % protected region % [Update the annotation for bpjsHealthFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_HEALTH_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsHealthFacilityId here] end
	private UUID bpjsHealthFacilityId;

	// % protected region % [Update the annotation for BPJS Procedure here] off begin
	@Schema(description = "The BPJS Procedure entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Procedure here] end
	private BpjsProcedureEntity bpjsProcedure;

	// % protected region % [Update the annotation for bpjsProcedureId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PROCEDURE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsProcedureId here] end
	private UUID bpjsProcedureId;

	// % protected region % [Update the annotation for BPJS Service Mapping here] off begin
	@Schema(description = "The BPJS Service Mapping entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Service Mapping here] end
	private BpjsServiceMappingEntity bpjsServiceMapping;

	// % protected region % [Update the annotation for bpjsServiceMappingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_SERVICE_MAPPING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsServiceMappingId here] end
	private UUID bpjsServiceMappingId;

	// % protected region % [Update the annotation for Patient General Info here] off begin
	@Schema(description = "The Patient General Info entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Info here] end
	private PatientGeneralInfoEntity patientGeneralInfo;

	// % protected region % [Update the annotation for patientGeneralInfoId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFO_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInfoId here] end
	private UUID patientGeneralInfoId;

	// % protected region % [Update the annotation for Patient Payment BPJS here] off begin
	@Schema(description = "The Patient Payment BPJS entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment BPJS here] end
	private PatientPaymentBPJSEntity patientPaymentBPJS;

	// % protected region % [Update the annotation for patientPaymentBPJSId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_BPJS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPaymentBPJSId here] end
	private UUID patientPaymentBPJSId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addBpjsDismissalConditions(BpjsDismissalConditionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalConditionEntity to be added to this entity
	 */
	public void addBpjsDismissalConditions(@NotNull BpjsDismissalConditionEntity entity) {
		addBpjsDismissalConditions(entity, true);
	}

	/**
	 * Add a new BpjsDismissalConditionEntity to bpjsDismissalConditions in this entity.
	 *
	 * @param entity the given BpjsDismissalConditionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsDismissalConditions(@NonNull BpjsDismissalConditionEntity entity, boolean reverseAdd) {
		if (!this.bpjsDismissalConditions.contains(entity)) {
			bpjsDismissalConditions.add(entity);
			if (reverseAdd) {
				entity.setBpjsClaimSubmission(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsDismissalConditions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be added to this entity
	 */
	public void addBpjsDismissalConditions(@NotNull Collection<BpjsDismissalConditionEntity> entities) {
		addBpjsDismissalConditions(entities, true);
	}

	/**
	 * Add a new collection of BpjsDismissalConditionEntity to BPJS Dismissal Conditions in this entity.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsDismissalConditions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalConditions(BpjsDismissalConditionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalConditionEntity to be set to this entity
	 */
	public void removeBpjsDismissalConditions(@NotNull BpjsDismissalConditionEntity entity) {
		this.removeBpjsDismissalConditions(entity, true);
	}

	/**
	 * Remove the given BpjsDismissalConditionEntity from this entity.
	 *
	 * @param entity the given BpjsDismissalConditionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsDismissalConditions(@NotNull BpjsDismissalConditionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsClaimSubmission(false);
		}
		this.bpjsDismissalConditions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalConditions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be removed to this entity
	 */
	public void removeBpjsDismissalConditions(@NotNull Collection<BpjsDismissalConditionEntity> entities) {
		this.removeBpjsDismissalConditions(entities, true);
	}

	/**
	 * Remove the given collection of BpjsDismissalConditionEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsDismissalConditions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsDismissalConditions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be set to this entity
	 */
	public void setBpjsDismissalConditions(@NotNull Collection<BpjsDismissalConditionEntity> entities) {
		setBpjsDismissalConditions(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Dismissal Conditions with the given ones.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsDismissalConditions(@NotNull Collection<BpjsDismissalConditionEntity> entities, boolean reverseAdd) {

		this.unsetBpjsDismissalConditions();
		this.bpjsDismissalConditions = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsDismissalConditions.forEach(bpjsDismissalConditionsEntity -> bpjsDismissalConditionsEntity.setBpjsClaimSubmission(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsDismissalConditions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsDismissalConditions() {
		this.unsetBpjsDismissalConditions(true);
	}

	/**
	 * Remove all the entities in BPJS Dismissal Conditions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsDismissalConditions(boolean doReverse) {
		if (doReverse) {
			this.bpjsDismissalConditions.forEach(bpjsDismissalConditionsEntity -> bpjsDismissalConditionsEntity.unsetBpjsClaimSubmission(false));
		}
		this.bpjsDismissalConditions.clear();
	}

/**
	 * Similar to {@link this#addBpjsDismissalMappings(BpjsDismissalMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalMappingEntity to be added to this entity
	 */
	public void addBpjsDismissalMappings(@NotNull BpjsDismissalMappingEntity entity) {
		addBpjsDismissalMappings(entity, true);
	}

	/**
	 * Add a new BpjsDismissalMappingEntity to bpjsDismissalMappings in this entity.
	 *
	 * @param entity the given BpjsDismissalMappingEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsDismissalMappings(@NonNull BpjsDismissalMappingEntity entity, boolean reverseAdd) {
		if (!this.bpjsDismissalMappings.contains(entity)) {
			bpjsDismissalMappings.add(entity);
			if (reverseAdd) {
				entity.setBpjsClaimSubmission(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsDismissalMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be added to this entity
	 */
	public void addBpjsDismissalMappings(@NotNull Collection<BpjsDismissalMappingEntity> entities) {
		addBpjsDismissalMappings(entities, true);
	}

	/**
	 * Add a new collection of BpjsDismissalMappingEntity to BPJS Dismissal Mappings in this entity.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsDismissalMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalMappings(BpjsDismissalMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalMappingEntity to be set to this entity
	 */
	public void removeBpjsDismissalMappings(@NotNull BpjsDismissalMappingEntity entity) {
		this.removeBpjsDismissalMappings(entity, true);
	}

	/**
	 * Remove the given BpjsDismissalMappingEntity from this entity.
	 *
	 * @param entity the given BpjsDismissalMappingEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsDismissalMappings(@NotNull BpjsDismissalMappingEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsClaimSubmission(false);
		}
		this.bpjsDismissalMappings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalMappings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be removed to this entity
	 */
	public void removeBpjsDismissalMappings(@NotNull Collection<BpjsDismissalMappingEntity> entities) {
		this.removeBpjsDismissalMappings(entities, true);
	}

	/**
	 * Remove the given collection of BpjsDismissalMappingEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsDismissalMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsDismissalMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be set to this entity
	 */
	public void setBpjsDismissalMappings(@NotNull Collection<BpjsDismissalMappingEntity> entities) {
		setBpjsDismissalMappings(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Dismissal Mappings with the given ones.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsDismissalMappings(@NotNull Collection<BpjsDismissalMappingEntity> entities, boolean reverseAdd) {

		this.unsetBpjsDismissalMappings();
		this.bpjsDismissalMappings = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsDismissalMappings.forEach(bpjsDismissalMappingsEntity -> bpjsDismissalMappingsEntity.setBpjsClaimSubmission(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsDismissalMappings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsDismissalMappings() {
		this.unsetBpjsDismissalMappings(true);
	}

	/**
	 * Remove all the entities in BPJS Dismissal Mappings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsDismissalMappings(boolean doReverse) {
		if (doReverse) {
			this.bpjsDismissalMappings.forEach(bpjsDismissalMappingsEntity -> bpjsDismissalMappingsEntity.unsetBpjsClaimSubmission(false));
		}
		this.bpjsDismissalMappings.clear();
	}

/**
	 * Similar to {@link this#addBpjsTreatmentRooms(BpjsTreatmentRoomEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity to be added to this entity
	 */
	public void addBpjsTreatmentRooms(@NotNull BpjsTreatmentRoomEntity entity) {
		addBpjsTreatmentRooms(entity, true);
	}

	/**
	 * Add a new BpjsTreatmentRoomEntity to bpjsTreatmentRooms in this entity.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsTreatmentRooms(@NonNull BpjsTreatmentRoomEntity entity, boolean reverseAdd) {
		if (!this.bpjsTreatmentRooms.contains(entity)) {
			bpjsTreatmentRooms.add(entity);
			if (reverseAdd) {
				entity.setBpjsClaimSubmission(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsTreatmentRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be added to this entity
	 */
	public void addBpjsTreatmentRooms(@NotNull Collection<BpjsTreatmentRoomEntity> entities) {
		addBpjsTreatmentRooms(entities, true);
	}

	/**
	 * Add a new collection of BpjsTreatmentRoomEntity to BPJS Treatment Rooms in this entity.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsTreatmentRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsTreatmentRooms(BpjsTreatmentRoomEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity to be set to this entity
	 */
	public void removeBpjsTreatmentRooms(@NotNull BpjsTreatmentRoomEntity entity) {
		this.removeBpjsTreatmentRooms(entity, true);
	}

	/**
	 * Remove the given BpjsTreatmentRoomEntity from this entity.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsTreatmentRooms(@NotNull BpjsTreatmentRoomEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsClaimSubmission(false);
		}
		this.bpjsTreatmentRooms.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsTreatmentRooms(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be removed to this entity
	 */
	public void removeBpjsTreatmentRooms(@NotNull Collection<BpjsTreatmentRoomEntity> entities) {
		this.removeBpjsTreatmentRooms(entities, true);
	}

	/**
	 * Remove the given collection of BpjsTreatmentRoomEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsTreatmentRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsTreatmentRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be set to this entity
	 */
	public void setBpjsTreatmentRooms(@NotNull Collection<BpjsTreatmentRoomEntity> entities) {
		setBpjsTreatmentRooms(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Treatment Rooms with the given ones.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsTreatmentRooms(@NotNull Collection<BpjsTreatmentRoomEntity> entities, boolean reverseAdd) {

		this.unsetBpjsTreatmentRooms();
		this.bpjsTreatmentRooms = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsTreatmentRooms.forEach(bpjsTreatmentRoomsEntity -> bpjsTreatmentRoomsEntity.setBpjsClaimSubmission(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsTreatmentRooms(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsTreatmentRooms() {
		this.unsetBpjsTreatmentRooms(true);
	}

	/**
	 * Remove all the entities in BPJS Treatment Rooms from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsTreatmentRooms(boolean doReverse) {
		if (doReverse) {
			this.bpjsTreatmentRooms.forEach(bpjsTreatmentRoomsEntity -> bpjsTreatmentRoomsEntity.unsetBpjsClaimSubmission(false));
		}
		this.bpjsTreatmentRooms.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setBpjsDiagnose(@NotNull BpjsDiagnoseEntity entity) {
		setBpjsDiagnose(entity, true);
	}

	/**
	 * Set or update the bpjsDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to bpjsDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDiagnose(@NotNull BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnose here] end

		if (sameAsFormer(this.bpjsDiagnose, entity)) {
			return;
		}

		if (this.bpjsDiagnose != null) {
			this.bpjsDiagnose.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDiagnose = entity;
		if (reverseAdd) {
			this.bpjsDiagnose.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnose incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnose incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDiagnose(boolean)} but default to true.
	 */
	public void unsetBpjsDiagnose() {
		this.unsetBpjsDiagnose(true);
	}

	/**
	 * Remove BPJS Diagnose in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDiagnose(boolean reverse) {
		if (reverse && this.bpjsDiagnose != null) {
			this.bpjsDiagnose.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDiagnose = null;
	}
	/**
	 * Similar to {@link this#setBpjsDoctorMapping(BpjsDoctorMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set to this entity
	 */
	public void setBpjsDoctorMapping(@NotNull BpjsDoctorMappingEntity entity) {
		setBpjsDoctorMapping(entity, true);
	}

	/**
	 * Set or update the bpjsDoctorMapping in this entity with single BpjsDoctorMappingEntity.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set or updated to bpjsDoctorMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDoctorMapping(@NotNull BpjsDoctorMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] end

		if (sameAsFormer(this.bpjsDoctorMapping, entity)) {
			return;
		}

		if (this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDoctorMapping = entity;
		if (reverseAdd) {
			this.bpjsDoctorMapping.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDoctorMapping(boolean)} but default to true.
	 */
	public void unsetBpjsDoctorMapping() {
		this.unsetBpjsDoctorMapping(true);
	}

	/**
	 * Remove BPJS Doctor Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDoctorMapping(boolean reverse) {
		if (reverse && this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDoctorMapping = null;
	}
	/**
	 * Similar to {@link this#setBpjsHealthFacility(BpjsHealthFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set to this entity
	 */
	public void setBpjsHealthFacility(@NotNull BpjsHealthFacilityEntity entity) {
		setBpjsHealthFacility(entity, true);
	}

	/**
	 * Set or update the bpjsHealthFacility in this entity with single BpjsHealthFacilityEntity.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set or updated to bpjsHealthFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsHealthFacility(@NotNull BpjsHealthFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] end

		if (sameAsFormer(this.bpjsHealthFacility, entity)) {
			return;
		}

		if (this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsHealthFacility = entity;
		if (reverseAdd) {
			this.bpjsHealthFacility.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsHealthFacility(boolean)} but default to true.
	 */
	public void unsetBpjsHealthFacility() {
		this.unsetBpjsHealthFacility(true);
	}

	/**
	 * Remove BPJS Health Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsHealthFacility(boolean reverse) {
		if (reverse && this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsHealthFacility = null;
	}
	/**
	 * Similar to {@link this#setBpjsProcedure(BpjsProcedureEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsProcedureEntity to be set to this entity
	 */
	public void setBpjsProcedure(@NotNull BpjsProcedureEntity entity) {
		setBpjsProcedure(entity, true);
	}

	/**
	 * Set or update the bpjsProcedure in this entity with single BpjsProcedureEntity.
	 *
	 * @param entity the given BpjsProcedureEntity to be set or updated to bpjsProcedure
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsProcedure(@NotNull BpjsProcedureEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsProcedure here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsProcedure here] end

		if (sameAsFormer(this.bpjsProcedure, entity)) {
			return;
		}

		if (this.bpjsProcedure != null) {
			this.bpjsProcedure.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsProcedure = entity;
		if (reverseAdd) {
			this.bpjsProcedure.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsProcedure incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsProcedure incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsProcedure(boolean)} but default to true.
	 */
	public void unsetBpjsProcedure() {
		this.unsetBpjsProcedure(true);
	}

	/**
	 * Remove BPJS Procedure in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsProcedure(boolean reverse) {
		if (reverse && this.bpjsProcedure != null) {
			this.bpjsProcedure.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsProcedure = null;
	}
	/**
	 * Similar to {@link this#setBpjsServiceMapping(BpjsServiceMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsServiceMappingEntity to be set to this entity
	 */
	public void setBpjsServiceMapping(@NotNull BpjsServiceMappingEntity entity) {
		setBpjsServiceMapping(entity, true);
	}

	/**
	 * Set or update the bpjsServiceMapping in this entity with single BpjsServiceMappingEntity.
	 *
	 * @param entity the given BpjsServiceMappingEntity to be set or updated to bpjsServiceMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsServiceMapping(@NotNull BpjsServiceMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] end

		if (sameAsFormer(this.bpjsServiceMapping, entity)) {
			return;
		}

		if (this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsServiceMapping = entity;
		if (reverseAdd) {
			this.bpjsServiceMapping.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsServiceMapping(boolean)} but default to true.
	 */
	public void unsetBpjsServiceMapping() {
		this.unsetBpjsServiceMapping(true);
	}

	/**
	 * Remove BPJS Service Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsServiceMapping(boolean reverse) {
		if (reverse && this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsServiceMapping = null;
	}
	/**
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(@NotNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeBpjsClaimSubmissions(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove Patient General Info in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeBpjsClaimSubmissions(this, false);
		}
		this.patientGeneralInfo = null;
	}
	/**
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update the patientPaymentBPJS in this entity with single PatientPaymentBPJSEntity.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set or updated to patientPaymentBPJS
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsClaimSubmissions(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove Patient Payment BPJS in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsClaimSubmissions(this, false);
		}
		this.patientPaymentBPJS = null;
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
		return "SEP_NO,ADMISSION_DATE,DISMISSAL_DATE,INSURANCE_PROVIDER,TREATMENT_TYPE,FOLLOW_UP_PLAN,CONTROL_DATE,ADDITIONAL_DIAGNOSIS,ADDITIONAL_PROCEDURE,KELAS_RAWAT,BPJS_DIAGNOSE_ID,BPJS_DOCTOR_MAPPING_ID,BPJS_HEALTH_FACILITY_ID,BPJS_PROCEDURE_ID,BPJS_SERVICE_MAPPING_ID,PATIENT_GENERAL_INFO_ID,PATIENT_PAYMENT_BPJS_ID,BPJS_DISMISSAL_CONDITIONS_IDS,BPJS_DISMISSAL_MAPPINGS_IDS,BPJS_TREATMENT_ROOMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<BpjsDiagnoseEntity> bpjsDiagnoseRelation = Optional.ofNullable(this.bpjsDiagnose);
		bpjsDiagnoseRelation.ifPresent(entity -> this.bpjsDiagnoseId = entity.getId());

		Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingRelation = Optional.ofNullable(this.bpjsDoctorMapping);
		bpjsDoctorMappingRelation.ifPresent(entity -> this.bpjsDoctorMappingId = entity.getId());

		Optional<BpjsHealthFacilityEntity> bpjsHealthFacilityRelation = Optional.ofNullable(this.bpjsHealthFacility);
		bpjsHealthFacilityRelation.ifPresent(entity -> this.bpjsHealthFacilityId = entity.getId());

		Optional<BpjsProcedureEntity> bpjsProcedureRelation = Optional.ofNullable(this.bpjsProcedure);
		bpjsProcedureRelation.ifPresent(entity -> this.bpjsProcedureId = entity.getId());

		Optional<BpjsServiceMappingEntity> bpjsServiceMappingRelation = Optional.ofNullable(this.bpjsServiceMapping);
		bpjsServiceMappingRelation.ifPresent(entity -> this.bpjsServiceMappingId = entity.getId());

		Optional<PatientGeneralInfoEntity> patientGeneralInfoRelation = Optional.ofNullable(this.patientGeneralInfo);
		patientGeneralInfoRelation.ifPresent(entity -> this.patientGeneralInfoId = entity.getId());

		Optional<PatientPaymentBPJSEntity> patientPaymentBPJSRelation = Optional.ofNullable(this.patientPaymentBPJS);
		patientPaymentBPJSRelation.ifPresent(entity -> this.patientPaymentBPJSId = entity.getId());

		this.bpjsDismissalConditionsIds = new HashSet<>();
		for (BpjsDismissalConditionEntity bpjsDismissalConditions: this.bpjsDismissalConditions) {
			this.bpjsDismissalConditionsIds.add(bpjsDismissalConditions.getId());
		}

		this.bpjsDismissalMappingsIds = new HashSet<>();
		for (BpjsDismissalMappingEntity bpjsDismissalMappings: this.bpjsDismissalMappings) {
			this.bpjsDismissalMappingsIds.add(bpjsDismissalMappings.getId());
		}

		this.bpjsTreatmentRoomsIds = new HashSet<>();
		for (BpjsTreatmentRoomEntity bpjsTreatmentRooms: this.bpjsTreatmentRooms) {
			this.bpjsTreatmentRoomsIds.add(bpjsTreatmentRooms.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsClaimSubmission) {
		if (this == bpjsClaimSubmission) {
			return true;
		}
		if (bpjsClaimSubmission == null || this.getClass() != bpjsClaimSubmission.getClass()) {
			return false;
		}
		if (!super.equals(bpjsClaimSubmission)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsClaimSubmissionEntity that = (BpjsClaimSubmissionEntity) bpjsClaimSubmission;
		return
			Objects.equals(this.sepNo, that.sepNo) &&
			Objects.equals(
			     this.admissionDate != null ? this.admissionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.admissionDate != null ? that.admissionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.insuranceProvider, that.insuranceProvider) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.followUpPlan, that.followUpPlan) &&
			Objects.equals(
			     this.controlDate != null ? this.controlDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.controlDate != null ? that.controlDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.additionalDiagnosis, that.additionalDiagnosis) &&
			Objects.equals(this.additionalProcedure, that.additionalProcedure) &&
			Objects.equals(this.kelasRawat, that.kelasRawat) &&
			Objects.equals(this.bpjsDismissalConditionsIds, that.bpjsDismissalConditionsIds) &&
			Objects.equals(this.bpjsDismissalMappingsIds, that.bpjsDismissalMappingsIds) &&
			Objects.equals(this.bpjsTreatmentRoomsIds, that.bpjsTreatmentRoomsIds) &&
			Objects.equals(this.bpjsDiagnoseId, that.bpjsDiagnoseId) &&
			Objects.equals(this.bpjsDoctorMappingId, that.bpjsDoctorMappingId) &&
			Objects.equals(this.bpjsHealthFacilityId, that.bpjsHealthFacilityId) &&
			Objects.equals(this.bpjsProcedureId, that.bpjsProcedureId) &&
			Objects.equals(this.bpjsServiceMappingId, that.bpjsServiceMappingId) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
