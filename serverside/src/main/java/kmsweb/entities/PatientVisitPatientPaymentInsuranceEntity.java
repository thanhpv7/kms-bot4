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
import kmsweb.dtos.PatientVisitPatientPaymentInsuranceEntityDto;
import kmsweb.entities.listeners.PatientVisitPatientPaymentInsuranceEntityListener;
import kmsweb.serializers.PatientVisitPatientPaymentInsuranceSerializer;
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
@EntityListeners({PatientVisitPatientPaymentInsuranceEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientVisitPatientPaymentInsuranceSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientVisitPatientPaymentInsuranceEntity extends AbstractEntity {

	/**
	 * Takes a PatientVisitPatientPaymentInsuranceEntityDto and converts it into a PatientVisitPatientPaymentInsuranceEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientVisitPatientPaymentInsuranceEntityDto
	 */
	public PatientVisitPatientPaymentInsuranceEntity(PatientVisitPatientPaymentInsuranceEntityDto patientVisitPatientPaymentInsuranceEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientVisitPatientPaymentInsuranceEntityDto.getId() != null) {
			this.setId(patientVisitPatientPaymentInsuranceEntityDto.getId());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getMemberNo() != null) {
			this.setMemberNo(patientVisitPatientPaymentInsuranceEntityDto.getMemberNo());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getPolicyHolderNo() != null) {
			this.setPolicyHolderNo(patientVisitPatientPaymentInsuranceEntityDto.getPolicyHolderNo());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getEligilityVerification() != null) {
			this.setEligilityVerification(patientVisitPatientPaymentInsuranceEntityDto.getEligilityVerification());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getGuaranteeLetterNo() != null) {
			this.setGuaranteeLetterNo(patientVisitPatientPaymentInsuranceEntityDto.getGuaranteeLetterNo());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getCoverageBalance() != null) {
			this.setCoverageBalance(patientVisitPatientPaymentInsuranceEntityDto.getCoverageBalance());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getNotes() != null) {
			this.setNotes(patientVisitPatientPaymentInsuranceEntityDto.getNotes());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(patientVisitPatientPaymentInsuranceEntityDto.getPatientVisit());
		}

		if (patientVisitPatientPaymentInsuranceEntityDto.getInsuranceBenefitPlan() != null) {
			this.setInsuranceBenefitPlan(patientVisitPatientPaymentInsuranceEntityDto.getInsuranceBenefitPlan());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Member No here] off begin
	@CsvBindByName(column = "MEMBER_NO", required = false)
	@Nullable
	@Column(name = "member_no")
	@Schema(description = "The Member No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Member No here] end
	private String memberNo;

	// % protected region % [Modify attribute annotation for Policy Holder No here] off begin
	@CsvBindByName(column = "POLICY_HOLDER_NO", required = false)
	@Nullable
	@Column(name = "policy_holder_no")
	@Schema(description = "The Policy Holder No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Policy Holder No here] end
	private String policyHolderNo;

	// % protected region % [Modify attribute annotation for Eligility Verification here] off begin
	@CsvBindByName(column = "ELIGILITY_VERIFICATION", required = false)
	@Nullable
	@Column(name = "eligility_verification")
	@Schema(description = "The Eligility Verification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Eligility Verification here] end
	private String eligilityVerification;

	// % protected region % [Modify attribute annotation for Guarantee Letter No here] off begin
	@CsvBindByName(column = "GUARANTEE_LETTER_NO", required = false)
	@Nullable
	@Column(name = "guarantee_letter_no")
	@Schema(description = "The Guarantee Letter No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Guarantee Letter No here] end
	private String guaranteeLetterNo;

	// % protected region % [Modify attribute annotation for Coverage Balance here] off begin
	@CsvBindByName(column = "COVERAGE_BALANCE", required = false)
	@Nullable
	@Column(name = "coverage_balance")
	@Schema(description = "The Coverage Balance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Coverage Balance here] end
	private Double coverageBalance;

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

	// % protected region % [Update the annotation for Patient Visit here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit here] end
	private PatientVisitEntity patientVisit;

	// % protected region % [Update the annotation for patientVisitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitId here] end
	private UUID patientVisitId;

	// % protected region % [Update the annotation for Insurance Benefit Plan here] off begin
	@Schema(description = "The Insurance Benefit Plan entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Insurance Benefit Plan here] end
	private InsuranceBenefitPlanEntity insuranceBenefitPlan;

	// % protected region % [Update the annotation for insuranceBenefitPlanId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INSURANCE_BENEFIT_PLAN_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for insuranceBenefitPlanId here] end
	private UUID insuranceBenefitPlanId;

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
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.unsetPatientVisitPatientPaymentInsurance(false);
		}

		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.setPatientVisitPatientPaymentInsurance(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove the PatientVisitEntity of patientVisit from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.unsetPatientVisitPatientPaymentInsurance();
		}
		this.patientVisit = null;
	}
	/**
	 * Similar to {@link this#setInsuranceBenefitPlan(InsuranceBenefitPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be set to this entity
	 */
	public void setInsuranceBenefitPlan(@NotNull InsuranceBenefitPlanEntity entity) {
		setInsuranceBenefitPlan(entity, true);
	}

	/**
	 * Set or update the insuranceBenefitPlan in this entity with single InsuranceBenefitPlanEntity.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be set or updated to insuranceBenefitPlan
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInsuranceBenefitPlan(@NotNull InsuranceBenefitPlanEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInsuranceBenefitPlan here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInsuranceBenefitPlan here] end

		if (sameAsFormer(this.insuranceBenefitPlan, entity)) {
			return;
		}

		if (this.insuranceBenefitPlan != null) {
			this.insuranceBenefitPlan.removePatientVisitPatientPaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = entity;
		if (reverseAdd) {
			this.insuranceBenefitPlan.addPatientVisitPatientPaymentInsurances(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInsuranceBenefitPlan incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInsuranceBenefitPlan incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInsuranceBenefitPlan(boolean)} but default to true.
	 */
	public void unsetInsuranceBenefitPlan() {
		this.unsetInsuranceBenefitPlan(true);
	}

	/**
	 * Remove Insurance Benefit Plan in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInsuranceBenefitPlan(boolean reverse) {
		if (reverse && this.insuranceBenefitPlan != null) {
			this.insuranceBenefitPlan.removePatientVisitPatientPaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = null;
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
		return "MEMBER_NO,POLICY_HOLDER_NO,ELIGILITY_VERIFICATION,GUARANTEE_LETTER_NO,COVERAGE_BALANCE,NOTES,PATIENT_VISIT_ID,INSURANCE_BENEFIT_PLAN_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientVisitEntity> patientVisitRelation = Optional.ofNullable(this.patientVisit);
		patientVisitRelation.ifPresent(entity -> this.patientVisitId = entity.getId());

		Optional<InsuranceBenefitPlanEntity> insuranceBenefitPlanRelation = Optional.ofNullable(this.insuranceBenefitPlan);
		insuranceBenefitPlanRelation.ifPresent(entity -> this.insuranceBenefitPlanId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientVisitPatientPaymentInsurance) {
		if (this == patientVisitPatientPaymentInsurance) {
			return true;
		}
		if (patientVisitPatientPaymentInsurance == null || this.getClass() != patientVisitPatientPaymentInsurance.getClass()) {
			return false;
		}
		if (!super.equals(patientVisitPatientPaymentInsurance)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientVisitPatientPaymentInsuranceEntity that = (PatientVisitPatientPaymentInsuranceEntity) patientVisitPatientPaymentInsurance;
		return
			Objects.equals(this.memberNo, that.memberNo) &&
			Objects.equals(this.policyHolderNo, that.policyHolderNo) &&
			Objects.equals(this.eligilityVerification, that.eligilityVerification) &&
			Objects.equals(this.guaranteeLetterNo, that.guaranteeLetterNo) &&
			Objects.equals(this.coverageBalance, that.coverageBalance) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.patientVisitId, that.patientVisitId) &&
			Objects.equals(this.insuranceBenefitPlanId, that.insuranceBenefitPlanId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
