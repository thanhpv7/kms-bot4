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
import kmsweb.dtos.BpjsPatientReferralEntityDto;
import kmsweb.entities.listeners.BpjsPatientReferralEntityListener;
import kmsweb.serializers.BpjsPatientReferralSerializer;
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
@EntityListeners({BpjsPatientReferralEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPatientReferralSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPatientReferralEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPatientReferralEntityDto and converts it into a BpjsPatientReferralEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPatientReferralEntityDto
	 */
	public BpjsPatientReferralEntity(BpjsPatientReferralEntityDto bpjsPatientReferralEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPatientReferralEntityDto.getId() != null) {
			this.setId(bpjsPatientReferralEntityDto.getId());
		}

		if (bpjsPatientReferralEntityDto.getNoSEP() != null) {
			this.setNoSEP(bpjsPatientReferralEntityDto.getNoSEP());
		}

		if (bpjsPatientReferralEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsPatientReferralEntityDto.getReferralNo());
		}

		if (bpjsPatientReferralEntityDto.getReferredType() != null) {
			this.setReferredType(bpjsPatientReferralEntityDto.getReferredType());
		}

		if (bpjsPatientReferralEntityDto.getReferralDate() != null) {
			this.setReferralDate(bpjsPatientReferralEntityDto.getReferralDate());
		}

		if (bpjsPatientReferralEntityDto.getReferalDatePlan() != null) {
			this.setReferalDatePlan(bpjsPatientReferralEntityDto.getReferalDatePlan());
		}

		if (bpjsPatientReferralEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsPatientReferralEntityDto.getTreatmentType());
		}

		if (bpjsPatientReferralEntityDto.getNotes() != null) {
			this.setNotes(bpjsPatientReferralEntityDto.getNotes());
		}

		if (bpjsPatientReferralEntityDto.getBpjsDiagnose() != null) {
			this.setBpjsDiagnose(bpjsPatientReferralEntityDto.getBpjsDiagnose());
		}

		if (bpjsPatientReferralEntityDto.getBpjsHealthFacility() != null) {
			this.setBpjsHealthFacility(bpjsPatientReferralEntityDto.getBpjsHealthFacility());
		}

		if (bpjsPatientReferralEntityDto.getBpjsServiceMapping() != null) {
			this.setBpjsServiceMapping(bpjsPatientReferralEntityDto.getBpjsServiceMapping());
		}

		if (bpjsPatientReferralEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(bpjsPatientReferralEntityDto.getPatientPaymentBPJS());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for No SEP here] off begin
	@CsvBindByName(column = "NO_SEP", required = false)
	@Nullable
	@Column(name = "no_sep")
	@Schema(description = "The No SEP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for No SEP here] end
	private String noSEP;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@CsvBindByName(column = "REFERRAL_NO", required = false)
	@Nullable
	@Column(name = "referral_no")
	@Schema(description = "The Referral No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for Referred Type here] off begin
	@CsvBindByName(column = "REFERRED_TYPE", required = false)
	@Nullable
	@Column(name = "referred_type")
	@Schema(description = "The Referred Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referred Type here] end
	private String referredType;

	// % protected region % [Modify attribute annotation for Referral Date here] off begin
	@CsvCustomBindByName(column = "REFERRAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "referral_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Referral Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Date here] end
	private OffsetDateTime referralDate;

	// % protected region % [Modify attribute annotation for Referal Date Plan here] off begin
	@CsvCustomBindByName(column = "REFERAL_DATE_PLAN", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "referal_date_plan")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Referal Date Plan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referal Date Plan here] end
	private OffsetDateTime referalDatePlan;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@CsvBindByName(column = "TREATMENT_TYPE", required = false)
	@Nullable
	@Column(name = "treatment_type")
	@Schema(description = "The Treatment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

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
			this.bpjsDiagnose.removeBpjsPatientReferrals(this, false);
		}
		this.bpjsDiagnose = entity;
		if (reverseAdd) {
			this.bpjsDiagnose.addBpjsPatientReferrals(this, false);
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
			this.bpjsDiagnose.removeBpjsPatientReferrals(this, false);
		}
		this.bpjsDiagnose = null;
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
			this.bpjsHealthFacility.removeBpjsPatientReferrals(this, false);
		}
		this.bpjsHealthFacility = entity;
		if (reverseAdd) {
			this.bpjsHealthFacility.addBpjsPatientReferrals(this, false);
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
			this.bpjsHealthFacility.removeBpjsPatientReferrals(this, false);
		}
		this.bpjsHealthFacility = null;
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
			this.bpjsServiceMapping.removeBpjsPatientReferrals(this, false);
		}
		this.bpjsServiceMapping = entity;
		if (reverseAdd) {
			this.bpjsServiceMapping.addBpjsPatientReferrals(this, false);
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
			this.bpjsServiceMapping.removeBpjsPatientReferrals(this, false);
		}
		this.bpjsServiceMapping = null;
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
			this.patientPaymentBPJS.removeBpjsPatientReferrals(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsPatientReferrals(this, false);
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
			this.patientPaymentBPJS.removeBpjsPatientReferrals(this, false);
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
		return "NO_SEP,REFERRAL_NO,REFERRED_TYPE,REFERRAL_DATE,REFERAL_DATE_PLAN,TREATMENT_TYPE,NOTES,BPJS_DIAGNOSE_ID,BPJS_HEALTH_FACILITY_ID,BPJS_SERVICE_MAPPING_ID,PATIENT_PAYMENT_BPJS_ID,ID";
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

		Optional<BpjsHealthFacilityEntity> bpjsHealthFacilityRelation = Optional.ofNullable(this.bpjsHealthFacility);
		bpjsHealthFacilityRelation.ifPresent(entity -> this.bpjsHealthFacilityId = entity.getId());

		Optional<BpjsServiceMappingEntity> bpjsServiceMappingRelation = Optional.ofNullable(this.bpjsServiceMapping);
		bpjsServiceMappingRelation.ifPresent(entity -> this.bpjsServiceMappingId = entity.getId());

		Optional<PatientPaymentBPJSEntity> patientPaymentBPJSRelation = Optional.ofNullable(this.patientPaymentBPJS);
		patientPaymentBPJSRelation.ifPresent(entity -> this.patientPaymentBPJSId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPatientReferral) {
		if (this == bpjsPatientReferral) {
			return true;
		}
		if (bpjsPatientReferral == null || this.getClass() != bpjsPatientReferral.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPatientReferral)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPatientReferralEntity that = (BpjsPatientReferralEntity) bpjsPatientReferral;
		return
			Objects.equals(this.noSEP, that.noSEP) &&
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.referredType, that.referredType) &&
			Objects.equals(
			     this.referralDate != null ? this.referralDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.referralDate != null ? that.referralDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.referalDatePlan != null ? this.referalDatePlan.truncatedTo(ChronoUnit.DAYS) : null,
			     that.referalDatePlan != null ? that.referalDatePlan.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.bpjsDiagnoseId, that.bpjsDiagnoseId) &&
			Objects.equals(this.bpjsHealthFacilityId, that.bpjsHealthFacilityId) &&
			Objects.equals(this.bpjsServiceMappingId, that.bpjsServiceMappingId) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
