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
import kmsweb.dtos.PatientPaymentInsuranceEntityDto;
import kmsweb.entities.listeners.PatientPaymentInsuranceEntityListener;
import kmsweb.serializers.PatientPaymentInsuranceSerializer;
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
@EntityListeners({PatientPaymentInsuranceEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientPaymentInsuranceSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientPaymentInsuranceEntity extends AbstractEntity {

	/**
	 * Takes a PatientPaymentInsuranceEntityDto and converts it into a PatientPaymentInsuranceEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientPaymentInsuranceEntityDto
	 */
	public PatientPaymentInsuranceEntity(PatientPaymentInsuranceEntityDto patientPaymentInsuranceEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientPaymentInsuranceEntityDto.getId() != null) {
			this.setId(patientPaymentInsuranceEntityDto.getId());
		}

		if (patientPaymentInsuranceEntityDto.getMemberNo() != null) {
			this.setMemberNo(patientPaymentInsuranceEntityDto.getMemberNo());
		}

		if (patientPaymentInsuranceEntityDto.getPolicyHolderNo() != null) {
			this.setPolicyHolderNo(patientPaymentInsuranceEntityDto.getPolicyHolderNo());
		}

		if (patientPaymentInsuranceEntityDto.getEligilityVerification() != null) {
			this.setEligilityVerification(patientPaymentInsuranceEntityDto.getEligilityVerification());
		}

		if (patientPaymentInsuranceEntityDto.getGuaranteeLetterNo() != null) {
			this.setGuaranteeLetterNo(patientPaymentInsuranceEntityDto.getGuaranteeLetterNo());
		}

		if (patientPaymentInsuranceEntityDto.getCoverageBalance() != null) {
			this.setCoverageBalance(patientPaymentInsuranceEntityDto.getCoverageBalance());
		}

		if (patientPaymentInsuranceEntityDto.getNotes() != null) {
			this.setNotes(patientPaymentInsuranceEntityDto.getNotes());
		}

		if (patientPaymentInsuranceEntityDto.getInsuranceBenefitPlan() != null) {
			this.setInsuranceBenefitPlan(patientPaymentInsuranceEntityDto.getInsuranceBenefitPlan());
		}

		if (patientPaymentInsuranceEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientPaymentInsuranceEntityDto.getPatientGeneralInformation());
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

	// % protected region % [Update the annotation for Patient General Information here] off begin
	@Schema(description = "The Patient General Information entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Information here] end
	private PatientGeneralInfoEntity patientGeneralInformation;

	// % protected region % [Update the annotation for patientGeneralInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInformationId here] end
	private UUID patientGeneralInformationId;

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
			this.insuranceBenefitPlan.removePatientPaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = entity;
		if (reverseAdd) {
			this.insuranceBenefitPlan.addPatientPaymentInsurances(this, false);
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
			this.insuranceBenefitPlan.removePatientPaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = null;
	}
	/**
	 * Similar to {@link this#setPatientGeneralInformation(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientPaymentTypeInsurance(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientPaymentTypeInsurance(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInformation from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientPaymentTypeInsurance();
		}
		this.patientGeneralInformation = null;
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
		return "MEMBER_NO,POLICY_HOLDER_NO,ELIGILITY_VERIFICATION,GUARANTEE_LETTER_NO,COVERAGE_BALANCE,NOTES,INSURANCE_BENEFIT_PLAN_ID,PATIENT_GENERAL_INFORMATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<InsuranceBenefitPlanEntity> insuranceBenefitPlanRelation = Optional.ofNullable(this.insuranceBenefitPlan);
		insuranceBenefitPlanRelation.ifPresent(entity -> this.insuranceBenefitPlanId = entity.getId());

		Optional<PatientGeneralInfoEntity> patientGeneralInformationRelation = Optional.ofNullable(this.patientGeneralInformation);
		patientGeneralInformationRelation.ifPresent(entity -> this.patientGeneralInformationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientPaymentInsurance) {
		if (this == patientPaymentInsurance) {
			return true;
		}
		if (patientPaymentInsurance == null || this.getClass() != patientPaymentInsurance.getClass()) {
			return false;
		}
		if (!super.equals(patientPaymentInsurance)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientPaymentInsuranceEntity that = (PatientPaymentInsuranceEntity) patientPaymentInsurance;
		return
			Objects.equals(this.memberNo, that.memberNo) &&
			Objects.equals(this.policyHolderNo, that.policyHolderNo) &&
			Objects.equals(this.eligilityVerification, that.eligilityVerification) &&
			Objects.equals(this.guaranteeLetterNo, that.guaranteeLetterNo) &&
			Objects.equals(this.coverageBalance, that.coverageBalance) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.insuranceBenefitPlanId, that.insuranceBenefitPlanId) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
