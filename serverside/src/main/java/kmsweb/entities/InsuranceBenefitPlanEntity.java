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
import kmsweb.dtos.InsuranceBenefitPlanEntityDto;
import kmsweb.entities.listeners.InsuranceBenefitPlanEntityListener;
import kmsweb.serializers.InsuranceBenefitPlanSerializer;
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
@EntityListeners({InsuranceBenefitPlanEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InsuranceBenefitPlanSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"benefit_plan_no"}, name = "benefit_plan_no"),
	}
)
public class InsuranceBenefitPlanEntity extends AbstractEntity {

	/**
	 * Takes a InsuranceBenefitPlanEntityDto and converts it into a InsuranceBenefitPlanEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param insuranceBenefitPlanEntityDto
	 */
	public InsuranceBenefitPlanEntity(InsuranceBenefitPlanEntityDto insuranceBenefitPlanEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (insuranceBenefitPlanEntityDto.getId() != null) {
			this.setId(insuranceBenefitPlanEntityDto.getId());
		}

		if (insuranceBenefitPlanEntityDto.getBenefitPlanNo() != null) {
			this.setBenefitPlanNo(insuranceBenefitPlanEntityDto.getBenefitPlanNo());
		}

		if (insuranceBenefitPlanEntityDto.getBenefitPlanName() != null) {
			this.setBenefitPlanName(insuranceBenefitPlanEntityDto.getBenefitPlanName());
		}

		if (insuranceBenefitPlanEntityDto.getMaximumCoveragePerTreatment() != null) {
			this.setMaximumCoveragePerTreatment(insuranceBenefitPlanEntityDto.getMaximumCoveragePerTreatment());
		}

		if (insuranceBenefitPlanEntityDto.getMaximumCoveragePerYear() != null) {
			this.setMaximumCoveragePerYear(insuranceBenefitPlanEntityDto.getMaximumCoveragePerYear());
		}

		if (insuranceBenefitPlanEntityDto.getCreatedDate() != null) {
			this.setCreatedDate(insuranceBenefitPlanEntityDto.getCreatedDate());
		}

		if (insuranceBenefitPlanEntityDto.getUpdatedDate() != null) {
			this.setUpdatedDate(insuranceBenefitPlanEntityDto.getUpdatedDate());
		}

		if (insuranceBenefitPlanEntityDto.getNotes() != null) {
			this.setNotes(insuranceBenefitPlanEntityDto.getNotes());
		}

		if (insuranceBenefitPlanEntityDto.getInvoicePaymentInsurances() != null) {
			this.setInvoicePaymentInsurances(insuranceBenefitPlanEntityDto.getInvoicePaymentInsurances());
		}

		if (insuranceBenefitPlanEntityDto.getPatientPaymentInsurances() != null) {
			this.setPatientPaymentInsurances(insuranceBenefitPlanEntityDto.getPatientPaymentInsurances());
		}

		if (insuranceBenefitPlanEntityDto.getPatientVisitPatientPaymentInsurances() != null) {
			this.setPatientVisitPatientPaymentInsurances(insuranceBenefitPlanEntityDto.getPatientVisitPatientPaymentInsurances());
		}

		if (insuranceBenefitPlanEntityDto.getInsuranceProvider() != null) {
			this.setInsuranceProvider(insuranceBenefitPlanEntityDto.getInsuranceProvider());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Benefit Plan No here] off begin
	@CsvBindByName(column = "BENEFIT_PLAN_NO", required = true)
	@NotNull(message = "Benefit Plan No must not be empty")
	@Column(name = "benefit_plan_no")
	@Schema(description = "The Benefit Plan No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Benefit Plan No here] end
	private String benefitPlanNo;

	// % protected region % [Modify attribute annotation for Benefit Plan Name here] off begin
	@CsvBindByName(column = "BENEFIT_PLAN_NAME", required = false)
	@Nullable
	@Column(name = "benefit_plan_name")
	@Schema(description = "The Benefit Plan Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Benefit Plan Name here] end
	private String benefitPlanName;

	// % protected region % [Modify attribute annotation for Maximum Coverage per Treatment here] off begin
	@CsvBindByName(column = "MAXIMUM_COVERAGE_PER_TREATMENT", required = false)
	@Nullable
	@Column(name = "maximum_coverage_per_treatment")
	@Schema(description = "The Maximum Coverage per Treatment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maximum Coverage per Treatment here] end
	private Double maximumCoveragePerTreatment;

	// % protected region % [Modify attribute annotation for Maximum Coverage per Year here] off begin
	@CsvBindByName(column = "MAXIMUM_COVERAGE_PER_YEAR", required = false)
	@Nullable
	@Column(name = "maximum_coverage_per_year")
	@Schema(description = "The Maximum Coverage per Year of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maximum Coverage per Year here] end
	private Double maximumCoveragePerYear;

	// % protected region % [Modify attribute annotation for Created Date here] off begin
	@CsvCustomBindByName(column = "CREATED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "created_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Created Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Created Date here] end
	private OffsetDateTime createdDate;

	// % protected region % [Modify attribute annotation for Updated Date here] off begin
	@CsvCustomBindByName(column = "UPDATED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "updated_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Updated Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Updated Date here] end
	private OffsetDateTime updatedDate;

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

	// % protected region % [Update the annotation for Invoice Payment Insurances here] off begin
	@Schema(description = "The Invoice Payment Insurance entities that are related to this entity.")
	@OneToMany(mappedBy = "insuranceBenefitPlan", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Payment Insurances here] end
	private Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();

	// % protected region % [Update the annotation for invoicePaymentInsurancesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_PAYMENT_INSURANCES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoicePaymentInsurancesIds here] end
	private Set<UUID> invoicePaymentInsurancesIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Payment Insurances here] off begin
	@Schema(description = "The Patient Payment Insurance entities that are related to this entity.")
	@OneToMany(mappedBy = "insuranceBenefitPlan", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment Insurances here] end
	private Set<PatientPaymentInsuranceEntity> patientPaymentInsurances = new HashSet<>();

	// % protected region % [Update the annotation for patientPaymentInsurancesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_INSURANCES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientPaymentInsurancesIds here] end
	private Set<UUID> patientPaymentInsurancesIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Visit Patient Payment Insurances here] off begin
	@Schema(description = "The Patient Visit Patient Payment Insurance entities that are related to this entity.")
	@OneToMany(mappedBy = "insuranceBenefitPlan", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit Patient Payment Insurances here] end
	private Set<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurances = new HashSet<>();

	// % protected region % [Update the annotation for patientVisitPatientPaymentInsurancesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientVisitPatientPaymentInsurancesIds here] end
	private Set<UUID> patientVisitPatientPaymentInsurancesIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Insurance Provider here] off begin
	@Schema(description = "The Insurance Provider entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Insurance Provider here] end
	private InsuranceProviderEntity insuranceProvider;

	// % protected region % [Update the annotation for insuranceProviderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INSURANCE_PROVIDER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for insuranceProviderId here] end
	private UUID insuranceProviderId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addInvoicePaymentInsurances(InvoicePaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be added to this entity
	 */
	public void addInvoicePaymentInsurances(@NotNull InvoicePaymentInsuranceEntity entity) {
		addInvoicePaymentInsurances(entity, true);
	}

	/**
	 * Add a new InvoicePaymentInsuranceEntity to invoicePaymentInsurances in this entity.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.invoicePaymentInsurances.contains(entity)) {
			invoicePaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInsuranceBenefitPlan(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be added to this entity
	 */
	public void addInvoicePaymentInsurances(@NotNull Collection<InvoicePaymentInsuranceEntity> entities) {
		addInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of InvoicePaymentInsuranceEntity to Invoice Payment Insurances in this entity.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoicePaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoicePaymentInsurances(InvoicePaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be set to this entity
	 */
	public void removeInvoicePaymentInsurances(@NotNull InvoicePaymentInsuranceEntity entity) {
		this.removeInvoicePaymentInsurances(entity, true);
	}

	/**
	 * Remove the given InvoicePaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoicePaymentInsurances(@NotNull InvoicePaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceBenefitPlan(false);
		}
		this.invoicePaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be removed to this entity
	 */
	public void removeInvoicePaymentInsurances(@NotNull Collection<InvoicePaymentInsuranceEntity> entities) {
		this.removeInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of InvoicePaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoicePaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be set to this entity
	 */
	public void setInvoicePaymentInsurances(@NotNull Collection<InvoicePaymentInsuranceEntity> entities) {
		setInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoicePaymentInsurances(@NotNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetInvoicePaymentInsurances();
		this.invoicePaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.setInsuranceBenefitPlan(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoicePaymentInsurances() {
		this.unsetInvoicePaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Invoice Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoicePaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.unsetInsuranceBenefitPlan(false));
		}
		this.invoicePaymentInsurances.clear();
	}

/**
	 * Similar to {@link this#addPatientPaymentInsurances(PatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientPaymentInsurances(@NotNull PatientPaymentInsuranceEntity entity) {
		addPatientPaymentInsurances(entity, true);
	}

	/**
	 * Add a new PatientPaymentInsuranceEntity to patientPaymentInsurances in this entity.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientPaymentInsurances(@NonNull PatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.patientPaymentInsurances.contains(entity)) {
			patientPaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInsuranceBenefitPlan(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientPaymentInsurances(@NotNull Collection<PatientPaymentInsuranceEntity> entities) {
		addPatientPaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of PatientPaymentInsuranceEntity to Patient Payment Insurances in this entity.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientPaymentInsurances(PatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity to be set to this entity
	 */
	public void removePatientPaymentInsurances(@NotNull PatientPaymentInsuranceEntity entity) {
		this.removePatientPaymentInsurances(entity, true);
	}

	/**
	 * Remove the given PatientPaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientPaymentInsurances(@NotNull PatientPaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceBenefitPlan(false);
		}
		this.patientPaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be removed to this entity
	 */
	public void removePatientPaymentInsurances(@NotNull Collection<PatientPaymentInsuranceEntity> entities) {
		this.removePatientPaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of PatientPaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be set to this entity
	 */
	public void setPatientPaymentInsurances(@NotNull Collection<PatientPaymentInsuranceEntity> entities) {
		setPatientPaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Patient Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientPaymentInsurances(@NotNull Collection<PatientPaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetPatientPaymentInsurances();
		this.patientPaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientPaymentInsurances.forEach(patientPaymentInsurancesEntity -> patientPaymentInsurancesEntity.setInsuranceBenefitPlan(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientPaymentInsurances() {
		this.unsetPatientPaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Patient Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientPaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.patientPaymentInsurances.forEach(patientPaymentInsurancesEntity -> patientPaymentInsurancesEntity.unsetInsuranceBenefitPlan(false));
		}
		this.patientPaymentInsurances.clear();
	}

/**
	 * Similar to {@link this#addPatientVisitPatientPaymentInsurances(PatientVisitPatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientVisitPatientPaymentInsurances(@NotNull PatientVisitPatientPaymentInsuranceEntity entity) {
		addPatientVisitPatientPaymentInsurances(entity, true);
	}

	/**
	 * Add a new PatientVisitPatientPaymentInsuranceEntity to patientVisitPatientPaymentInsurances in this entity.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientVisitPatientPaymentInsurances(@NonNull PatientVisitPatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.patientVisitPatientPaymentInsurances.contains(entity)) {
			patientVisitPatientPaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInsuranceBenefitPlan(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientVisitPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientVisitPatientPaymentInsurances(@NotNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities) {
		addPatientVisitPatientPaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of PatientVisitPatientPaymentInsuranceEntity to Patient Visit Patient Payment Insurances in this entity.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientVisitPatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientVisitPatientPaymentInsurances(PatientVisitPatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity to be set to this entity
	 */
	public void removePatientVisitPatientPaymentInsurances(@NotNull PatientVisitPatientPaymentInsuranceEntity entity) {
		this.removePatientVisitPatientPaymentInsurances(entity, true);
	}

	/**
	 * Remove the given PatientVisitPatientPaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientVisitPatientPaymentInsurances(@NotNull PatientVisitPatientPaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceBenefitPlan(false);
		}
		this.patientVisitPatientPaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientVisitPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be removed to this entity
	 */
	public void removePatientVisitPatientPaymentInsurances(@NotNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities) {
		this.removePatientVisitPatientPaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of PatientVisitPatientPaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientVisitPatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientVisitPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be set to this entity
	 */
	public void setPatientVisitPatientPaymentInsurances(@NotNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities) {
		setPatientVisitPatientPaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Patient Visit Patient Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientVisitPatientPaymentInsurances(@NotNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetPatientVisitPatientPaymentInsurances();
		this.patientVisitPatientPaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientVisitPatientPaymentInsurances.forEach(patientVisitPatientPaymentInsurancesEntity -> patientVisitPatientPaymentInsurancesEntity.setInsuranceBenefitPlan(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPatientPaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientVisitPatientPaymentInsurances() {
		this.unsetPatientVisitPatientPaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Patient Visit Patient Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientVisitPatientPaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.patientVisitPatientPaymentInsurances.forEach(patientVisitPatientPaymentInsurancesEntity -> patientVisitPatientPaymentInsurancesEntity.unsetInsuranceBenefitPlan(false));
		}
		this.patientVisitPatientPaymentInsurances.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInsuranceProvider(InsuranceProviderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceProviderEntity to be set to this entity
	 */
	public void setInsuranceProvider(@NotNull InsuranceProviderEntity entity) {
		setInsuranceProvider(entity, true);
	}

	/**
	 * Set or update the insuranceProvider in this entity with single InsuranceProviderEntity.
	 *
	 * @param entity the given InsuranceProviderEntity to be set or updated to insuranceProvider
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInsuranceProvider(@NotNull InsuranceProviderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInsuranceProvider here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInsuranceProvider here] end

		if (sameAsFormer(this.insuranceProvider, entity)) {
			return;
		}

		if (this.insuranceProvider != null) {
			this.insuranceProvider.removeInsuranceBenefitPlans(this, false);
		}
		this.insuranceProvider = entity;
		if (reverseAdd) {
			this.insuranceProvider.addInsuranceBenefitPlans(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInsuranceProvider incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInsuranceProvider incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInsuranceProvider(boolean)} but default to true.
	 */
	public void unsetInsuranceProvider() {
		this.unsetInsuranceProvider(true);
	}

	/**
	 * Remove Insurance Provider in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInsuranceProvider(boolean reverse) {
		if (reverse && this.insuranceProvider != null) {
			this.insuranceProvider.removeInsuranceBenefitPlans(this, false);
		}
		this.insuranceProvider = null;
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
		return "BENEFIT_PLAN_NO,BENEFIT_PLAN_NAME,MAXIMUM_COVERAGE_PER_TREATMENT,MAXIMUM_COVERAGE_PER_YEAR,CREATED_DATE,UPDATED_DATE,NOTES,INSURANCE_PROVIDER_ID,INVOICE_PAYMENT_INSURANCES_IDS,PATIENT_PAYMENT_INSURANCES_IDS,PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InsuranceProviderEntity> insuranceProviderRelation = Optional.ofNullable(this.insuranceProvider);
		insuranceProviderRelation.ifPresent(entity -> this.insuranceProviderId = entity.getId());

		this.invoicePaymentInsurancesIds = new HashSet<>();
		for (InvoicePaymentInsuranceEntity invoicePaymentInsurances: this.invoicePaymentInsurances) {
			this.invoicePaymentInsurancesIds.add(invoicePaymentInsurances.getId());
		}

		this.patientPaymentInsurancesIds = new HashSet<>();
		for (PatientPaymentInsuranceEntity patientPaymentInsurances: this.patientPaymentInsurances) {
			this.patientPaymentInsurancesIds.add(patientPaymentInsurances.getId());
		}

		this.patientVisitPatientPaymentInsurancesIds = new HashSet<>();
		for (PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsurances: this.patientVisitPatientPaymentInsurances) {
			this.patientVisitPatientPaymentInsurancesIds.add(patientVisitPatientPaymentInsurances.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object insuranceBenefitPlan) {
		if (this == insuranceBenefitPlan) {
			return true;
		}
		if (insuranceBenefitPlan == null || this.getClass() != insuranceBenefitPlan.getClass()) {
			return false;
		}
		if (!super.equals(insuranceBenefitPlan)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InsuranceBenefitPlanEntity that = (InsuranceBenefitPlanEntity) insuranceBenefitPlan;
		return
			Objects.equals(this.benefitPlanNo, that.benefitPlanNo) &&
			Objects.equals(this.benefitPlanName, that.benefitPlanName) &&
			Objects.equals(this.maximumCoveragePerTreatment, that.maximumCoveragePerTreatment) &&
			Objects.equals(this.maximumCoveragePerYear, that.maximumCoveragePerYear) &&
			Objects.equals(
			     this.createdDate != null ? this.createdDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.createdDate != null ? that.createdDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.updatedDate != null ? this.updatedDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.updatedDate != null ? that.updatedDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.invoicePaymentInsurancesIds, that.invoicePaymentInsurancesIds) &&
			Objects.equals(this.patientPaymentInsurancesIds, that.patientPaymentInsurancesIds) &&
			Objects.equals(this.patientVisitPatientPaymentInsurancesIds, that.patientVisitPatientPaymentInsurancesIds) &&
			Objects.equals(this.insuranceProviderId, that.insuranceProviderId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
