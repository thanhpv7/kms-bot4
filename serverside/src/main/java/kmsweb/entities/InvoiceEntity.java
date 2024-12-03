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
import kmsweb.dtos.InvoiceEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.InvoiceEntityListener;
import kmsweb.serializers.InvoiceSerializer;
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
@EntityListeners({InvoiceEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InvoiceSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InvoiceEntity extends AbstractEntity {

	/**
	 * Takes a InvoiceEntityDto and converts it into a InvoiceEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param invoiceEntityDto
	 */
	public InvoiceEntity(InvoiceEntityDto invoiceEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (invoiceEntityDto.getId() != null) {
			this.setId(invoiceEntityDto.getId());
		}

		if (invoiceEntityDto.getInvoiceNumber() != null) {
			this.setInvoiceNumber(invoiceEntityDto.getInvoiceNumber());
		}

		if (invoiceEntityDto.getRevisionNumber() != null) {
			this.setRevisionNumber(invoiceEntityDto.getRevisionNumber());
		}

		if (invoiceEntityDto.getInvoiceStatus() != null) {
			this.setInvoiceStatus(invoiceEntityDto.getInvoiceStatus());
		}

		if (invoiceEntityDto.getInvoiceType() != null) {
			this.setInvoiceType(invoiceEntityDto.getInvoiceType());
		}

		if (invoiceEntityDto.getInvoiceDate() != null) {
			this.setInvoiceDate(invoiceEntityDto.getInvoiceDate());
		}

		if (invoiceEntityDto.getCancelDate() != null) {
			this.setCancelDate(invoiceEntityDto.getCancelDate());
		}

		if (invoiceEntityDto.getBillingLocation() != null) {
			this.setBillingLocation(invoiceEntityDto.getBillingLocation());
		}

		if (invoiceEntityDto.getNotes() != null) {
			this.setNotes(invoiceEntityDto.getNotes());
		}

		if (invoiceEntityDto.getPatientPaymentType() != null) {
			this.setPatientPaymentType(invoiceEntityDto.getPatientPaymentType());
		}

		if (invoiceEntityDto.getVerificationDate() != null) {
			this.setVerificationDate(invoiceEntityDto.getVerificationDate());
		}

		if (invoiceEntityDto.getDisplayDoctorOnPrint() != null) {
			this.setDisplayDoctorOnPrint(invoiceEntityDto.getDisplayDoctorOnPrint());
		}

		if (invoiceEntityDto.getDisplayICD10OnPrint() != null) {
			this.setDisplayICD10OnPrint(invoiceEntityDto.getDisplayICD10OnPrint());
		}

		if (invoiceEntityDto.getDisplayICD9CMOnPrint() != null) {
			this.setDisplayICD9CMOnPrint(invoiceEntityDto.getDisplayICD9CMOnPrint());
		}

		if (invoiceEntityDto.getDoctorCode() != null) {
			this.setDoctorCode(invoiceEntityDto.getDoctorCode());
		}

		if (invoiceEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(invoiceEntityDto.getTreatmentClass());
		}

		if (invoiceEntityDto.getAdmissionDate() != null) {
			this.setAdmissionDate(invoiceEntityDto.getAdmissionDate());
		}

		if (invoiceEntityDto.getDischargedDate() != null) {
			this.setDischargedDate(invoiceEntityDto.getDischargedDate());
		}

		if (invoiceEntityDto.getClaimNo() != null) {
			this.setClaimNo(invoiceEntityDto.getClaimNo());
		}

		if (invoiceEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(invoiceEntityDto.getInvoiceItems());
		}

		if (invoiceEntityDto.getInvoicePaymentInsurances() != null) {
			this.setInvoicePaymentInsurances(invoiceEntityDto.getInvoicePaymentInsurances());
		}

		if (invoiceEntityDto.getInvoicePaymentOther() != null) {
			this.setInvoicePaymentOther(invoiceEntityDto.getInvoicePaymentOther());
		}

		if (invoiceEntityDto.getInvoicePaymentSelfPaying() != null) {
			this.setInvoicePaymentSelfPaying(invoiceEntityDto.getInvoicePaymentSelfPaying());
		}

		if (invoiceEntityDto.getInvoiceSummary() != null) {
			this.setInvoiceSummary(invoiceEntityDto.getInvoiceSummary());
		}

		if (invoiceEntityDto.getPrescriptionHeader() != null) {
			this.setPrescriptionHeader(invoiceEntityDto.getPrescriptionHeader());
		}

		if (invoiceEntityDto.getMedicationHeader() != null) {
			this.setMedicationHeader(invoiceEntityDto.getMedicationHeader());
		}

		if (invoiceEntityDto.getIcd10() != null) {
			this.setIcd10(invoiceEntityDto.getIcd10());
		}

		if (invoiceEntityDto.getIcd9CM() != null) {
			this.setIcd9CM(invoiceEntityDto.getIcd9CM());
		}

		if (invoiceEntityDto.getBedFacility() != null) {
			this.setBedFacility(invoiceEntityDto.getBedFacility());
		}

		if (invoiceEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(invoiceEntityDto.getPatientVisit());
		}

		if (invoiceEntityDto.getTariffSchema() != null) {
			this.setTariffSchema(invoiceEntityDto.getTariffSchema());
		}

		if (invoiceEntityDto.getVerifiedBy() != null) {
			this.setVerifiedBy(invoiceEntityDto.getVerifiedBy());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Invoice Number here] off begin
	@CsvBindByName(column = "INVOICE_NUMBER", required = false)
	@Nullable
	@Column(name = "invoice_number")
	@Schema(description = "The Invoice Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Number here] end
	private String invoiceNumber;

	// % protected region % [Modify attribute annotation for Revision Number here] off begin
	@CsvBindByName(column = "REVISION_NUMBER", required = false)
	@Nullable
	@Column(name = "revision_number")
	@Schema(description = "The Revision Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Revision Number here] end
	private Integer revisionNumber;

	// % protected region % [Modify attribute annotation for Invoice Status here] off begin
	@CsvBindByName(column = "INVOICE_STATUS", required = false)
	@Nullable
	@Column(name = "invoice_status")
	@Schema(description = "The Invoice Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Status here] end
	private String invoiceStatus;

	// % protected region % [Modify attribute annotation for Invoice Type here] off begin
	@CsvCustomBindByName(column = "INVOICE_TYPE", required = true, converter = InvoiceTypeEnumConverter.class)
	@NotNull(message = "Invoice Type must not be empty")
	@Column(name = "invoice_type")
	@Schema(description = "The Invoice Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Invoice Type here] end
	private InvoiceTypeEnum invoiceType;

	// % protected region % [Modify attribute annotation for Invoice Date here] off begin

	@CsvCustomBindByName(column = "INVOICE_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Invoice Date must not be empty")
	@Column(name = "invoice_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Invoice Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Date here] end
	private OffsetDateTime invoiceDate;

	// % protected region % [Modify attribute annotation for Cancel Date here] off begin

	@CsvCustomBindByName(column = "CANCEL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "cancel_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Cancel Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cancel Date here] end
	private OffsetDateTime cancelDate;

	// % protected region % [Modify attribute annotation for Billing Location here] off begin
	@CsvBindByName(column = "BILLING_LOCATION", required = true)
	@NotNull(message = "Billing Location must not be empty")
	@Length(message = "Length must be less than or equal to 20", max = 20)
	@Column(name = "billing_location")
	@Schema(description = "The Billing Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Billing Location here] end
	private String billingLocation;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 500", max = 500)
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@CsvBindByName(column = "PATIENT_PAYMENT_TYPE", required = true)
	@NotNull(message = "Patient Payment Type must not be empty")
	@Column(name = "patient_payment_type")
	@Schema(description = "The Patient Payment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Verification Date here] off begin

	@CsvCustomBindByName(column = "VERIFICATION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "verification_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Verification Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Verification Date here] end
	private OffsetDateTime verificationDate;

	// % protected region % [Modify attribute annotation for Display Doctor on Print here] off begin
	@CsvBindByName(column = "DISPLAY_DOCTOR_ON_PRINT", required = false)
	@Nullable
	@Column(name = "display_doctor_on_print")
	@Schema(description = "The Display Doctor on Print of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Display Doctor on Print here] end
	private Boolean displayDoctorOnPrint = false ;

	// % protected region % [Modify attribute annotation for Display ICD 10 on Print here] off begin
	@CsvBindByName(column = "DISPLAY_ICD_10_ON_PRINT", required = false)
	@Nullable
	@Column(name = "display_icd_10_on_print")
	@Schema(description = "The Display ICD 10 on Print of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Display ICD 10 on Print here] end
	private Boolean displayICD10OnPrint = false ;

	// % protected region % [Modify attribute annotation for Display ICD 9 CM on Print here] off begin
	@CsvBindByName(column = "DISPLAY_ICD_9_CM_ON_PRINT", required = false)
	@Nullable
	@Column(name = "display_icd_9_cm_on_print")
	@Schema(description = "The Display ICD 9 CM on Print of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Display ICD 9 CM on Print here] end
	private Boolean displayICD9CMOnPrint = false ;

	// % protected region % [Modify attribute annotation for Doctor Code here] off begin
	@CsvBindByName(column = "DOCTOR_CODE", required = false)
	@Nullable
	@Column(name = "doctor_code")
	@Schema(description = "The Doctor Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Code here] end
	private String doctorCode;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Admission Date here] off begin

	@CsvCustomBindByName(column = "ADMISSION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "admission_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Admission Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Admission Date here] end
	private OffsetDateTime admissionDate;

	// % protected region % [Modify attribute annotation for Discharged Date here] off begin

	@CsvCustomBindByName(column = "DISCHARGED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "discharged_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Discharged Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discharged Date here] end
	private OffsetDateTime dischargedDate;

	// % protected region % [Modify attribute annotation for Claim No here] off begin
	@CsvBindByName(column = "CLAIM_NO", required = false)
	@Nullable
	@Column(name = "claim_no")
	@Schema(description = "The Claim No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim No here] end
	private String claimNo;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "invoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Payment Insurances here] off begin
	@Schema(description = "The Invoice Payment Insurance entities that are related to this entity.")
	@OneToMany(mappedBy = "invoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Payment Insurances here] end
	private Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();

	// % protected region % [Update the annotation for invoicePaymentInsurancesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_PAYMENT_INSURANCES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoicePaymentInsurancesIds here] end
	private Set<UUID> invoicePaymentInsurancesIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Payment Other here] off begin
	@Schema(description = "The Invoice Payment Other entities that are related to this entity.")
	@OneToOne(mappedBy = "invoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Payment Other here] end
	private InvoicePaymentOtherEntity invoicePaymentOther;

	// % protected region % [Update the annotation for invoicePaymentOtherId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_PAYMENT_OTHER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoicePaymentOtherId here] end
	private UUID invoicePaymentOtherId;

	// % protected region % [Update the annotation for Invoice Payment Self Paying here] off begin
	@Schema(description = "The Invoice Payment Self Paying entities that are related to this entity.")
	@OneToOne(mappedBy = "invoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Payment Self Paying here] end
	private InvoicePaymentSelfPayingEntity invoicePaymentSelfPaying;

	// % protected region % [Update the annotation for invoicePaymentSelfPayingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_PAYMENT_SELF_PAYING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoicePaymentSelfPayingId here] end
	private UUID invoicePaymentSelfPayingId;

	// % protected region % [Update the annotation for Invoice Summary here] off begin
	@Schema(description = "The Invoice Summary entities that are related to this entity.")
	@OneToOne(mappedBy = "invoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Summary here] end
	private InvoiceSummaryEntity invoiceSummary;

	// % protected region % [Update the annotation for invoiceSummaryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_SUMMARY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoiceSummaryId here] end
	private UUID invoiceSummaryId;

	// % protected region % [Update the annotation for Prescription Header here] off begin
	@Schema(description = "The Prescription Header entities that are related to this entity.")
	@OneToOne(mappedBy = "invoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Header here] end
	private PrescriptionHeaderEntity prescriptionHeader;

	// % protected region % [Update the annotation for prescriptionHeaderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_HEADER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for prescriptionHeaderId here] end
	private UUID prescriptionHeaderId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medication Header here] off begin
	@Schema(description = "The Medication Header entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Header here] end
	private MedicationHeaderEntity medicationHeader;

	// % protected region % [Update the annotation for medicationHeaderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_HEADER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicationHeaderId here] end
	private UUID medicationHeaderId;

	// % protected region % [Update the annotation for ICD 10 here] off begin
	@Schema(description = "The ICD 10 entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for ICD 10 here] end
	private DiagnosesAndProceduresEntity icd10;

	// % protected region % [Update the annotation for icd10Id here] off begin
	@Transient
	@CsvCustomBindByName(column = "ICD_10_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for icd10Id here] end
	private UUID icd10Id;

	// % protected region % [Update the annotation for ICD 9 CM here] off begin
	@Schema(description = "The ICD 9 CM entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for ICD 9 CM here] end
	private DiagnosesAndProceduresEntity icd9CM;

	// % protected region % [Update the annotation for icd9CMId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ICD_9_CM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for icd9CMId here] end
	private UUID icd9CMId;

	// % protected region % [Update the annotation for Bed Facility here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facility here] end
	private BedFacilityEntity bedFacility;

	// % protected region % [Update the annotation for bedFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bedFacilityId here] end
	private UUID bedFacilityId;

	// % protected region % [Update the annotation for Patient Visit here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit here] end
	private PatientVisitEntity patientVisit;

	// % protected region % [Update the annotation for patientVisitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitId here] end
	private UUID patientVisitId;

	// % protected region % [Update the annotation for Tariff Schema here] off begin
	@Schema(description = "The Tariff Schema entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@NotNull(message = "Reference Tariff Schema is required")
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Schema here] end
	private TariffSchemaEntity tariffSchema;

	// % protected region % [Update the annotation for tariffSchemaId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_SCHEMA_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for tariffSchemaId here] end
	private UUID tariffSchemaId;

	// % protected region % [Update the annotation for Verified By here] off begin
	@Schema(description = "The Verified By entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Verified By here] end
	private StaffEntity verifiedBy;

	// % protected region % [Update the annotation for verifiedById here] off begin
	@Transient
	@CsvCustomBindByName(column = "VERIFIED_BY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for verifiedById here] end
	private UUID verifiedById;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull InvoiceItemEntity entity) {
		addInvoiceItems(entity, true);
	}

	/**
	 * Add a new InvoiceItemEntity to invoiceItems in this entity.
	 *
	 * @param entity the given InvoiceItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		if (!this.invoiceItems.contains(entity)) {
			invoiceItems.add(entity);
			if (reverseAdd) {
				entity.setInvoice(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		addInvoiceItems(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemEntity to Invoice Items in this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInvoice(false);
		}
		this.invoiceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 */
	public void removeInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		this.removeInvoiceItems(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItems();
		this.invoiceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setInvoice(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItems() {
		this.unsetInvoiceItems(true);
	}

	/**
	 * Remove all the entities in Invoice Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItems(boolean doReverse) {
		if (doReverse) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetInvoice(false));
		}
		this.invoiceItems.clear();
	}

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
				entity.setInvoice(this, false);
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
			entity.unsetInvoice(false);
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
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.setInvoice(this, false));
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
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.unsetInvoice(false));
		}
		this.invoicePaymentInsurances.clear();
	}

	/**
	 * Similar to {@link this#setInvoicePaymentOther(InvoicePaymentOtherEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoicePaymentOther(@NotNull InvoicePaymentOtherEntity entity) {
		setInvoicePaymentOther(entity, true);
	}

	/**
	 * Set or update invoicePaymentOther with the given InvoicePaymentOtherEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoicePaymentOther(@NotNull InvoicePaymentOtherEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentOther here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentOther here] end

		if (sameAsFormer(this.invoicePaymentOther, entity)) {
			return;
		}

		if (this.invoicePaymentOther != null) {
			this.invoicePaymentOther.unsetInvoice();
		}

		this.invoicePaymentOther = entity;

		if (reverseAdd) {
			this.invoicePaymentOther.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentOther outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentOther outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentOther(boolean)} but default to true.
	 */
	public void unsetInvoicePaymentOther() {
		this.unsetInvoicePaymentOther(true);
	}

	/**
	 * Remove the InvoicePaymentOtherEntity in Invoice Payment Other from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoicePaymentOther(boolean reverse) {
		if (reverse && this.invoicePaymentOther != null) {
			this.invoicePaymentOther.unsetInvoice(false);
		}
		this.invoicePaymentOther = null;
	}

	/**
	 * Similar to {@link this#setInvoicePaymentSelfPaying(InvoicePaymentSelfPayingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoicePaymentSelfPaying(@NotNull InvoicePaymentSelfPayingEntity entity) {
		setInvoicePaymentSelfPaying(entity, true);
	}

	/**
	 * Set or update invoicePaymentSelfPaying with the given InvoicePaymentSelfPayingEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoicePaymentSelfPaying(@NotNull InvoicePaymentSelfPayingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentSelfPaying here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoicePaymentSelfPaying here] end

		if (sameAsFormer(this.invoicePaymentSelfPaying, entity)) {
			return;
		}

		if (this.invoicePaymentSelfPaying != null) {
			this.invoicePaymentSelfPaying.unsetInvoice();
		}

		this.invoicePaymentSelfPaying = entity;

		if (reverseAdd) {
			this.invoicePaymentSelfPaying.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentSelfPaying outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoicePaymentSelfPaying outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentSelfPaying(boolean)} but default to true.
	 */
	public void unsetInvoicePaymentSelfPaying() {
		this.unsetInvoicePaymentSelfPaying(true);
	}

	/**
	 * Remove the InvoicePaymentSelfPayingEntity in Invoice Payment Self Paying from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoicePaymentSelfPaying(boolean reverse) {
		if (reverse && this.invoicePaymentSelfPaying != null) {
			this.invoicePaymentSelfPaying.unsetInvoice(false);
		}
		this.invoicePaymentSelfPaying = null;
	}

	/**
	 * Similar to {@link this#setInvoiceSummary(InvoiceSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoiceSummary(@NotNull InvoiceSummaryEntity entity) {
		setInvoiceSummary(entity, true);
	}

	/**
	 * Set or update invoiceSummary with the given InvoiceSummaryEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoiceSummary(@NotNull InvoiceSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoiceSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoiceSummary here] end

		if (sameAsFormer(this.invoiceSummary, entity)) {
			return;
		}

		if (this.invoiceSummary != null) {
			this.invoiceSummary.unsetInvoice();
		}

		this.invoiceSummary = entity;

		if (reverseAdd) {
			this.invoiceSummary.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoiceSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoiceSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoiceSummary(boolean)} but default to true.
	 */
	public void unsetInvoiceSummary() {
		this.unsetInvoiceSummary(true);
	}

	/**
	 * Remove the InvoiceSummaryEntity in Invoice Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoiceSummary(boolean reverse) {
		if (reverse && this.invoiceSummary != null) {
			this.invoiceSummary.unsetInvoice(false);
		}
		this.invoiceSummary = null;
	}

	/**
	 * Similar to {@link this#setPrescriptionHeader(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setPrescriptionHeader(@NotNull PrescriptionHeaderEntity entity) {
		setPrescriptionHeader(entity, true);
	}

	/**
	 * Set or update prescriptionHeader with the given PrescriptionHeaderEntity.
	 *
	 * @param entity the InvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescriptionHeader(@NotNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrescriptionHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrescriptionHeader here] end

		if (sameAsFormer(this.prescriptionHeader, entity)) {
			return;
		}

		if (this.prescriptionHeader != null) {
			this.prescriptionHeader.unsetInvoice();
		}

		this.prescriptionHeader = entity;

		if (reverseAdd) {
			this.prescriptionHeader.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrescriptionHeader outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrescriptionHeader outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPrescriptionHeader(boolean)} but default to true.
	 */
	public void unsetPrescriptionHeader() {
		this.unsetPrescriptionHeader(true);
	}

	/**
	 * Remove the PrescriptionHeaderEntity in Prescription Header from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrescriptionHeader(boolean reverse) {
		if (reverse && this.prescriptionHeader != null) {
			this.prescriptionHeader.unsetInvoice(false);
		}
		this.prescriptionHeader = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicationHeader(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeader(MedicationHeaderEntity entity) {
		setMedicationHeader(entity, true);
	}

	/**
	 * Set or update the medicationHeader in this entity with single MedicationHeaderEntity.
	 *
	 * @param entity the given MedicationHeaderEntity to be set or updated to medicationHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationHeader(MedicationHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] end

		if (sameAsFormer(this.medicationHeader, entity)) {
			return;
		}

		if (this.medicationHeader != null) {
			this.medicationHeader.unsetInvoice(false);
		}

		this.medicationHeader = entity;
		if (reverseAdd) {
			this.medicationHeader.setInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationHeader(boolean)} but default to true.
	 */
	public void unsetMedicationHeader() {
		this.unsetMedicationHeader(true);
	}

	/**
	 * Remove the MedicationHeaderEntity of medicationHeader from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationHeader(boolean reverse) {
		if (reverse && this.medicationHeader != null) {
			this.medicationHeader.unsetInvoice();
		}
		this.medicationHeader = null;
	}
	/**
	 * Similar to {@link this#setIcd10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setIcd10(@NotNull DiagnosesAndProceduresEntity entity) {
		setIcd10(entity, true);
	}

	/**
	 * Set or update the icd10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to icd10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIcd10(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIcd10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIcd10 here] end

		if (sameAsFormer(this.icd10, entity)) {
			return;
		}

		if (this.icd10 != null) {
			this.icd10.removeInvoicesICD10(this, false);
		}
		this.icd10 = entity;
		if (reverseAdd) {
			this.icd10.addInvoicesICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIcd10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIcd10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIcd10(boolean)} but default to true.
	 */
	public void unsetIcd10() {
		this.unsetIcd10(true);
	}

	/**
	 * Remove ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIcd10(boolean reverse) {
		if (reverse && this.icd10 != null) {
			this.icd10.removeInvoicesICD10(this, false);
		}
		this.icd10 = null;
	}
	/**
	 * Similar to {@link this#setIcd9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setIcd9CM(@NotNull DiagnosesAndProceduresEntity entity) {
		setIcd9CM(entity, true);
	}

	/**
	 * Set or update the icd9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to icd9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIcd9CM(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIcd9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIcd9CM here] end

		if (sameAsFormer(this.icd9CM, entity)) {
			return;
		}

		if (this.icd9CM != null) {
			this.icd9CM.removeInvoicesICD9CM(this, false);
		}
		this.icd9CM = entity;
		if (reverseAdd) {
			this.icd9CM.addInvoicesICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIcd9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIcd9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIcd9CM(boolean)} but default to true.
	 */
	public void unsetIcd9CM() {
		this.unsetIcd9CM(true);
	}

	/**
	 * Remove ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIcd9CM(boolean reverse) {
		if (reverse && this.icd9CM != null) {
			this.icd9CM.removeInvoicesICD9CM(this, false);
		}
		this.icd9CM = null;
	}
	/**
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeInvoices(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBedFacility(boolean)} but default to true.
	 */
	public void unsetBedFacility() {
		this.unsetBedFacility(true);
	}

	/**
	 * Remove Bed Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBedFacility(boolean reverse) {
		if (reverse && this.bedFacility != null) {
			this.bedFacility.removeInvoices(this, false);
		}
		this.bedFacility = null;
	}
	/**
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(@NotNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NotNull PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.removeInvoices(this, false);
		}
		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove Patient Visit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.removeInvoices(this, false);
		}
		this.patientVisit = null;
	}
	/**
	 * Similar to {@link this#setTariffSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setTariffSchema(@NotNull TariffSchemaEntity entity) {
		setTariffSchema(entity, true);
	}

	/**
	 * Set or update the tariffSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to tariffSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffSchema(@NotNull TariffSchemaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] end

		if (sameAsFormer(this.tariffSchema, entity)) {
			return;
		}

		if (this.tariffSchema != null) {
			this.tariffSchema.removeInvoices(this, false);
		}
		this.tariffSchema = entity;
		if (reverseAdd) {
			this.tariffSchema.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffSchema(boolean)} but default to true.
	 */
	public void unsetTariffSchema() {
		this.unsetTariffSchema(true);
	}

	/**
	 * Remove Tariff Schema in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffSchema(boolean reverse) {
		if (reverse && this.tariffSchema != null) {
			this.tariffSchema.removeInvoices(this, false);
		}
		this.tariffSchema = null;
	}
	/**
	 * Similar to {@link this#setVerifiedBy(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setVerifiedBy(@NotNull StaffEntity entity) {
		setVerifiedBy(entity, true);
	}

	/**
	 * Set or update the verifiedBy in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to verifiedBy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setVerifiedBy(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setVerifiedBy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setVerifiedBy here] end

		if (sameAsFormer(this.verifiedBy, entity)) {
			return;
		}

		if (this.verifiedBy != null) {
			this.verifiedBy.removeInvoices(this, false);
		}
		this.verifiedBy = entity;
		if (reverseAdd) {
			this.verifiedBy.addInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setVerifiedBy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setVerifiedBy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetVerifiedBy(boolean)} but default to true.
	 */
	public void unsetVerifiedBy() {
		this.unsetVerifiedBy(true);
	}

	/**
	 * Remove Verified By in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetVerifiedBy(boolean reverse) {
		if (reverse && this.verifiedBy != null) {
			this.verifiedBy.removeInvoices(this, false);
		}
		this.verifiedBy = null;
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
		return "INVOICE_NUMBER,REVISION_NUMBER,INVOICE_STATUS,INVOICE_TYPE,INVOICE_DATE,CANCEL_DATE,BILLING_LOCATION,NOTES,PATIENT_PAYMENT_TYPE,VERIFICATION_DATE,DISPLAY_DOCTOR_ON_PRINT,DISPLAY_ICD_10_ON_PRINT,DISPLAY_ICD_9_CM_ON_PRINT,DOCTOR_CODE,TREATMENT_CLASS,ADMISSION_DATE,DISCHARGED_DATE,CLAIM_NO,MEDICATION_HEADER_ID,ICD_10_ID,ICD_9_CM_ID,BED_FACILITY_ID,PATIENT_VISIT_ID,TARIFF_SCHEMA_ID,VERIFIED_BY_ID,INVOICE_ITEMS_IDS,INVOICE_PAYMENT_INSURANCES_IDS,INVOICE_PAYMENT_OTHER_ID,INVOICE_PAYMENT_SELF_PAYING_ID,INVOICE_SUMMARY_ID,PRESCRIPTION_HEADER_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<MedicationHeaderEntity> medicationHeaderRelation = Optional.ofNullable(this.medicationHeader);
		medicationHeaderRelation.ifPresent(entity -> this.medicationHeaderId = entity.getId());

		Optional<DiagnosesAndProceduresEntity> icd10Relation = Optional.ofNullable(this.icd10);
		icd10Relation.ifPresent(entity -> this.icd10Id = entity.getId());

		Optional<DiagnosesAndProceduresEntity> icd9CMRelation = Optional.ofNullable(this.icd9CM);
		icd9CMRelation.ifPresent(entity -> this.icd9CMId = entity.getId());

		Optional<BedFacilityEntity> bedFacilityRelation = Optional.ofNullable(this.bedFacility);
		bedFacilityRelation.ifPresent(entity -> this.bedFacilityId = entity.getId());

		Optional<PatientVisitEntity> patientVisitRelation = Optional.ofNullable(this.patientVisit);
		patientVisitRelation.ifPresent(entity -> this.patientVisitId = entity.getId());

		Optional<TariffSchemaEntity> tariffSchemaRelation = Optional.ofNullable(this.tariffSchema);
		tariffSchemaRelation.ifPresent(entity -> this.tariffSchemaId = entity.getId());

		Optional<StaffEntity> verifiedByRelation = Optional.ofNullable(this.verifiedBy);
		verifiedByRelation.ifPresent(entity -> this.verifiedById = entity.getId());

		this.invoiceItemsIds = new HashSet<>();
		for (InvoiceItemEntity invoiceItems: this.invoiceItems) {
			this.invoiceItemsIds.add(invoiceItems.getId());
		}

		this.invoicePaymentInsurancesIds = new HashSet<>();
		for (InvoicePaymentInsuranceEntity invoicePaymentInsurances: this.invoicePaymentInsurances) {
			this.invoicePaymentInsurancesIds.add(invoicePaymentInsurances.getId());
		}

		Optional<InvoicePaymentOtherEntity> invoicePaymentOtherRelation = Optional.ofNullable(this.invoicePaymentOther);
		invoicePaymentOtherRelation.ifPresent(entity -> this.invoicePaymentOtherId = entity.getId());

		Optional<InvoicePaymentSelfPayingEntity> invoicePaymentSelfPayingRelation = Optional.ofNullable(this.invoicePaymentSelfPaying);
		invoicePaymentSelfPayingRelation.ifPresent(entity -> this.invoicePaymentSelfPayingId = entity.getId());

		Optional<InvoiceSummaryEntity> invoiceSummaryRelation = Optional.ofNullable(this.invoiceSummary);
		invoiceSummaryRelation.ifPresent(entity -> this.invoiceSummaryId = entity.getId());

		Optional<PrescriptionHeaderEntity> prescriptionHeaderRelation = Optional.ofNullable(this.prescriptionHeader);
		prescriptionHeaderRelation.ifPresent(entity -> this.prescriptionHeaderId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object invoice) {
		if (this == invoice) {
			return true;
		}
		if (invoice == null || this.getClass() != invoice.getClass()) {
			return false;
		}
		if (!super.equals(invoice)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InvoiceEntity that = (InvoiceEntity) invoice;
		return
			Objects.equals(this.invoiceNumber, that.invoiceNumber) &&
			Objects.equals(this.revisionNumber, that.revisionNumber) &&
			Objects.equals(this.invoiceStatus, that.invoiceStatus) &&
			Objects.equals(this.invoiceType, that.invoiceType) &&
			Objects.equals(
			     this.invoiceDate != null ? this.invoiceDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.invoiceDate != null ? that.invoiceDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.cancelDate != null ? this.cancelDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.cancelDate != null ? that.cancelDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.billingLocation, that.billingLocation) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.patientPaymentType, that.patientPaymentType) &&
			Objects.equals(
			     this.verificationDate != null ? this.verificationDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.verificationDate != null ? that.verificationDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.displayDoctorOnPrint, that.displayDoctorOnPrint) &&
			Objects.equals(this.displayICD10OnPrint, that.displayICD10OnPrint) &&
			Objects.equals(this.displayICD9CMOnPrint, that.displayICD9CMOnPrint) &&
			Objects.equals(this.doctorCode, that.doctorCode) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(
			     this.admissionDate != null ? this.admissionDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.admissionDate != null ? that.admissionDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.dischargedDate != null ? this.dischargedDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dischargedDate != null ? that.dischargedDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.claimNo, that.claimNo) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.invoicePaymentInsurancesIds, that.invoicePaymentInsurancesIds) &&
			Objects.equals(this.invoicePaymentOtherId, that.invoicePaymentOtherId) &&
			Objects.equals(this.invoicePaymentSelfPayingId, that.invoicePaymentSelfPayingId) &&
			Objects.equals(this.invoiceSummaryId, that.invoiceSummaryId) &&
			Objects.equals(this.prescriptionHeaderId, that.prescriptionHeaderId) &&
			Objects.equals(this.medicationHeaderId, that.medicationHeaderId) &&
			Objects.equals(this.icd10Id, that.icd10Id) &&
			Objects.equals(this.icd9CMId, that.icd9CMId) &&
			Objects.equals(this.bedFacilityId, that.bedFacilityId) &&
			Objects.equals(this.patientVisitId, that.patientVisitId) &&
			Objects.equals(this.tariffSchemaId, that.tariffSchemaId) &&
			Objects.equals(this.verifiedById, that.verifiedById);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
