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
import kmsweb.dtos.PatientGeneralInfoEntityDto;
import kmsweb.entities.listeners.PatientGeneralInfoEntityListener;
import kmsweb.serializers.PatientGeneralInfoSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import kmsweb.lib.file.models.FileEntity;
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
@EntityListeners({PatientGeneralInfoEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientGeneralInfoSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"patient_id"}, name = "patient_id"),
	}
)
public class PatientGeneralInfoEntity extends AbstractEntity {

	/**
	 * Takes a PatientGeneralInfoEntityDto and converts it into a PatientGeneralInfoEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientGeneralInfoEntityDto
	 */
	public PatientGeneralInfoEntity(PatientGeneralInfoEntityDto patientGeneralInfoEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientGeneralInfoEntityDto.getId() != null) {
			this.setId(patientGeneralInfoEntityDto.getId());
		}

		if (patientGeneralInfoEntityDto.getPatientID() != null) {
			this.setPatientID(patientGeneralInfoEntityDto.getPatientID());
		}

		if (patientGeneralInfoEntityDto.getTitle() != null) {
			this.setTitle(patientGeneralInfoEntityDto.getTitle());
		}

		if (patientGeneralInfoEntityDto.getGivenName() != null) {
			this.setGivenName(patientGeneralInfoEntityDto.getGivenName());
		}

		if (patientGeneralInfoEntityDto.getLastName() != null) {
			this.setLastName(patientGeneralInfoEntityDto.getLastName());
		}

		if (patientGeneralInfoEntityDto.getPlaceOfBirth() != null) {
			this.setPlaceOfBirth(patientGeneralInfoEntityDto.getPlaceOfBirth());
		}

		if (patientGeneralInfoEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(patientGeneralInfoEntityDto.getDateOfBirth());
		}

		if (patientGeneralInfoEntityDto.getGender() != null) {
			this.setGender(patientGeneralInfoEntityDto.getGender());
		}

		if (patientGeneralInfoEntityDto.getAddress() != null) {
			this.setAddress(patientGeneralInfoEntityDto.getAddress());
		}

		if (patientGeneralInfoEntityDto.getPatientPaymentType() != null) {
			this.setPatientPaymentType(patientGeneralInfoEntityDto.getPatientPaymentType());
		}

		if (patientGeneralInfoEntityDto.getImportantNotes() != null) {
			this.setImportantNotes(patientGeneralInfoEntityDto.getImportantNotes());
		}

		if (patientGeneralInfoEntityDto.getHasOutstandingPayment() != null) {
			this.setHasOutstandingPayment(patientGeneralInfoEntityDto.getHasOutstandingPayment());
		}

		if (patientGeneralInfoEntityDto.getBpjsClaimSubmissions() != null) {
			this.setBpjsClaimSubmissions(patientGeneralInfoEntityDto.getBpjsClaimSubmissions());
		}

		if (patientGeneralInfoEntityDto.getCashRefunds() != null) {
			this.setCashRefunds(patientGeneralInfoEntityDto.getCashRefunds());
		}

		if (patientGeneralInfoEntityDto.getInformedConsents() != null) {
			this.setInformedConsents(patientGeneralInfoEntityDto.getInformedConsents());
		}

		if (patientGeneralInfoEntityDto.getInvoiceReceipts() != null) {
			this.setInvoiceReceipts(patientGeneralInfoEntityDto.getInvoiceReceipts());
		}

		if (patientGeneralInfoEntityDto.getPatientCaseHistories() != null) {
			this.setPatientCaseHistories(patientGeneralInfoEntityDto.getPatientCaseHistories());
		}

		if (patientGeneralInfoEntityDto.getPatientConsents() != null) {
			this.setPatientConsents(patientGeneralInfoEntityDto.getPatientConsents());
		}

		if (patientGeneralInfoEntityDto.getPatientContactInformation() != null) {
			this.setPatientContactInformation(patientGeneralInfoEntityDto.getPatientContactInformation());
		}

		if (patientGeneralInfoEntityDto.getPatientDetailAddress() != null) {
			this.setPatientDetailAddress(patientGeneralInfoEntityDto.getPatientDetailAddress());
		}

		if (patientGeneralInfoEntityDto.getPatientDetail() != null) {
			this.setPatientDetail(patientGeneralInfoEntityDto.getPatientDetail());
		}

		if (patientGeneralInfoEntityDto.getPatientEmergencyContactDetail() != null) {
			this.setPatientEmergencyContactDetail(patientGeneralInfoEntityDto.getPatientEmergencyContactDetail());
		}

		if (patientGeneralInfoEntityDto.getPatientEmploymentDetail() != null) {
			this.setPatientEmploymentDetail(patientGeneralInfoEntityDto.getPatientEmploymentDetail());
		}

		if (patientGeneralInfoEntityDto.getPatientFinalizeProfiles() != null) {
			this.setPatientFinalizeProfiles(patientGeneralInfoEntityDto.getPatientFinalizeProfiles());
		}

		if (patientGeneralInfoEntityDto.getPatientPaymentBPJS() != null) {
			this.setPatientPaymentBPJS(patientGeneralInfoEntityDto.getPatientPaymentBPJS());
		}

		if (patientGeneralInfoEntityDto.getPatientPaymentTypeInsurance() != null) {
			this.setPatientPaymentTypeInsurance(patientGeneralInfoEntityDto.getPatientPaymentTypeInsurance());
		}

		if (patientGeneralInfoEntityDto.getPatientPaymentTypeOthers() != null) {
			this.setPatientPaymentTypeOthers(patientGeneralInfoEntityDto.getPatientPaymentTypeOthers());
		}

		if (patientGeneralInfoEntityDto.getPatientPersonalInformation() != null) {
			this.setPatientPersonalInformation(patientGeneralInfoEntityDto.getPatientPersonalInformation());
		}

		if (patientGeneralInfoEntityDto.getPatientSelfPaying() != null) {
			this.setPatientSelfPaying(patientGeneralInfoEntityDto.getPatientSelfPaying());
		}

		if (patientGeneralInfoEntityDto.getRetailPharmacies() != null) {
			this.setRetailPharmacies(patientGeneralInfoEntityDto.getRetailPharmacies());
		}

		if (patientGeneralInfoEntityDto.getVisits() != null) {
			this.setVisits(patientGeneralInfoEntityDto.getVisits());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@CsvBindByName(column = "PATIENT_ID", required = true)
	@NotNull(message = "Patient ID must not be empty")
	@Column(name = "patient_id")
	@Schema(description = "The Patient ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Title here] off begin
	@CsvBindByName(column = "TITLE", required = false)
	@Nullable
	@Column(name = "title")
	@Schema(description = "The Title of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Title here] end
	private String title;

	// % protected region % [Modify attribute annotation for Given Name here] off begin
	@CsvBindByName(column = "GIVEN_NAME", required = true)
	@NotNull(message = "Given Name must not be empty")
	@Column(name = "given_name")
	@Schema(description = "The Given Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Given Name here] end
	private String givenName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@CsvBindByName(column = "LAST_NAME", required = true)
	@NotNull(message = "Last Name must not be empty")
	@Column(name = "last_name")
	@Schema(description = "The Last Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Place of Birth here] off begin
	@CsvBindByName(column = "PLACE_OF_BIRTH", required = true)
	@NotNull(message = "Place of Birth must not be empty")
	@Column(name = "place_of_birth")
	@Schema(description = "The Place of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Place of Birth here] end
	private String placeOfBirth;

	// % protected region % [Modify attribute annotation for Date of Birth here] off begin
	@CsvCustomBindByName(column = "DATE_OF_BIRTH", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Date of Birth must not be empty")
	@Column(name = "date_of_birth")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = true)
	@NotNull(message = "Address must not be empty")
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@CsvBindByName(column = "PATIENT_PAYMENT_TYPE", required = false)
	@Nullable
	@Column(name = "patient_payment_type")
	@Schema(description = "The Patient Payment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Important Notes here] off begin
	@CsvBindByName(column = "IMPORTANT_NOTES", required = false)
	@Nullable
	@Column(name = "important_notes")
	@Schema(description = "The Important Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Important Notes here] end
	private String importantNotes;

	// % protected region % [Modify attribute annotation for Has Outstanding Payment here] off begin
	@CsvBindByName(column = "HAS_OUTSTANDING_PAYMENT", required = false)
	@Nullable
	@Column(name = "has_outstanding_payment")
	@Schema(description = "The Has Outstanding Payment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Has Outstanding Payment here] end
	private Boolean hasOutstandingPayment = false ;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> patientPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Claim Submissions here] off begin
	@Schema(description = "The BPJS Claim Submission entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Claim Submissions here] end
	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_CLAIM_SUBMISSIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsClaimSubmissionsIds here] end
	private Set<UUID> bpjsClaimSubmissionsIds = new HashSet<>();

	// % protected region % [Update the annotation for Cash Refunds here] off begin
	@Schema(description = "The Cash Refund entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Cash Refunds here] end
	private Set<CashRefundEntity> cashRefunds = new HashSet<>();

	// % protected region % [Update the annotation for cashRefundsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CASH_REFUNDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for cashRefundsIds here] end
	private Set<UUID> cashRefundsIds = new HashSet<>();

	// % protected region % [Update the annotation for Informed Consents here] off begin
	@Schema(description = "The Informed Consent entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Informed Consents here] end
	private Set<InformedConsentEntity> informedConsents = new HashSet<>();

	// % protected region % [Update the annotation for informedConsentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INFORMED_CONSENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for informedConsentsIds here] end
	private Set<UUID> informedConsentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Receipts here] off begin
	@Schema(description = "The Cash Receipt entities that are related to this entity.")
	@OneToMany(mappedBy = "patient", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Receipts here] end
	private Set<CashReceiptEntity> invoiceReceipts = new HashSet<>();

	// % protected region % [Update the annotation for invoiceReceiptsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_RECEIPTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceReceiptsIds here] end
	private Set<UUID> invoiceReceiptsIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Case Histories here] off begin
	@Schema(description = "The Patient Case History entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Case Histories here] end
	private Set<PatientCaseHistoryEntity> patientCaseHistories = new HashSet<>();

	// % protected region % [Update the annotation for patientCaseHistoriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_CASE_HISTORIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientCaseHistoriesIds here] end
	private Set<UUID> patientCaseHistoriesIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Consents here] off begin
	@Schema(description = "The Patient Consent entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Consents here] end
	private Set<PatientConsentEntity> patientConsents = new HashSet<>();

	// % protected region % [Update the annotation for patientConsentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_CONSENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientConsentsIds here] end
	private Set<UUID> patientConsentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Contact Information here] off begin
	@Schema(description = "The Patient Contact Info entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Contact Information here] end
	private PatientContactInfoEntity patientContactInformation;

	// % protected region % [Update the annotation for patientContactInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_CONTACT_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientContactInformationId here] end
	private UUID patientContactInformationId;

	// % protected region % [Update the annotation for Patient Detail Address here] off begin
	@Schema(description = "The Patient Detail Address entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Detail Address here] end
	private PatientDetailAddressEntity patientDetailAddress;

	// % protected region % [Update the annotation for patientDetailAddressId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_DETAIL_ADDRESS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientDetailAddressId here] end
	private UUID patientDetailAddressId;

	// % protected region % [Update the annotation for Patient Detail here] off begin
	@Schema(description = "The Patient Detail entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Detail here] end
	private PatientDetailEntity patientDetail;

	// % protected region % [Update the annotation for patientDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientDetailId here] end
	private UUID patientDetailId;

	// % protected region % [Update the annotation for Patient Emergency Contact Detail here] off begin
	@Schema(description = "The Patient Emergency Contact Detail entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Emergency Contact Detail here] end
	private PatientEmergencyContactDetailEntity patientEmergencyContactDetail;

	// % protected region % [Update the annotation for patientEmergencyContactDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_EMERGENCY_CONTACT_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientEmergencyContactDetailId here] end
	private UUID patientEmergencyContactDetailId;

	// % protected region % [Update the annotation for Patient Employment Detail  here] off begin
	@Schema(description = "The Patient Employment Detail  entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Employment Detail  here] end
	private PatientEmploymentDetailEntity patientEmploymentDetail;

	// % protected region % [Update the annotation for patientEmploymentDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_EMPLOYMENT_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientEmploymentDetailId here] end
	private UUID patientEmploymentDetailId;

	// % protected region % [Update the annotation for Patient Finalize Profiles here] off begin
	@Schema(description = "The Patient Supporting Document entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Finalize Profiles here] end
	private Set<PatientSupportingDocumentEntity> patientFinalizeProfiles = new HashSet<>();

	// % protected region % [Update the annotation for patientFinalizeProfilesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_FINALIZE_PROFILES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientFinalizeProfilesIds here] end
	private Set<UUID> patientFinalizeProfilesIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Payment BPJS here] off begin
	@Schema(description = "The Patient Payment BPJS entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment BPJS here] end
	private PatientPaymentBPJSEntity patientPaymentBPJS;

	// % protected region % [Update the annotation for patientPaymentBPJSId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_BPJS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPaymentBPJSId here] end
	private UUID patientPaymentBPJSId;

	// % protected region % [Update the annotation for Patient Payment Type Insurance here] off begin
	@Schema(description = "The Patient Payment Insurance entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment Type Insurance here] end
	private PatientPaymentInsuranceEntity patientPaymentTypeInsurance;

	// % protected region % [Update the annotation for patientPaymentTypeInsuranceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_TYPE_INSURANCE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPaymentTypeInsuranceId here] end
	private UUID patientPaymentTypeInsuranceId;

	// % protected region % [Update the annotation for Patient Payment Type Others here] off begin
	@Schema(description = "The Patient Payment Others entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Payment Type Others here] end
	private PatientPaymentOthersEntity patientPaymentTypeOthers;

	// % protected region % [Update the annotation for patientPaymentTypeOthersId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PAYMENT_TYPE_OTHERS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPaymentTypeOthersId here] end
	private UUID patientPaymentTypeOthersId;

	// % protected region % [Update the annotation for Patient Personal Information here] off begin
	@Schema(description = "The Patient Personal Info entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Personal Information here] end
	private PatientPersonalInfoEntity patientPersonalInformation;

	// % protected region % [Update the annotation for patientPersonalInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_PERSONAL_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientPersonalInformationId here] end
	private UUID patientPersonalInformationId;

	// % protected region % [Update the annotation for Patient Self Paying here] off begin
	@Schema(description = "The Patient Payment  Self Paying entities that are related to this entity.")
	@OneToOne(mappedBy = "patientGeneralInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Self Paying here] end
	private PatientPaymentSelfPayingEntity patientSelfPaying;

	// % protected region % [Update the annotation for patientSelfPayingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_SELF_PAYING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientSelfPayingId here] end
	private UUID patientSelfPayingId;

	// % protected region % [Update the annotation for Retail Pharmacies here] off begin
	@Schema(description = "The Retail Pharmacy entities that are related to this entity.")
	@OneToMany(mappedBy = "patientGeneralInfo", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacies here] end
	private Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();

	// % protected region % [Update the annotation for retailPharmaciesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for retailPharmaciesIds here] end
	private Set<UUID> retailPharmaciesIds = new HashSet<>();

	// % protected region % [Update the annotation for Visits here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@OneToMany(mappedBy = "patient", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Visits here] end
	private Set<PatientVisitEntity> visits = new HashSet<>();

	// % protected region % [Update the annotation for visitsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "VISITS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for visitsIds here] end
	private Set<UUID> visitsIds = new HashSet<>();

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
				entity.setPatientGeneralInfo(this, false);
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
			entity.unsetPatientGeneralInfo(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setPatientGeneralInfo(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetPatientGeneralInfo(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addCashRefunds(CashRefundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashRefundEntity to be added to this entity
	 */
	public void addCashRefunds(@NotNull CashRefundEntity entity) {
		addCashRefunds(entity, true);
	}

	/**
	 * Add a new CashRefundEntity to cashRefunds in this entity.
	 *
	 * @param entity the given CashRefundEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCashRefunds(@NonNull CashRefundEntity entity, boolean reverseAdd) {
		if (!this.cashRefunds.contains(entity)) {
			cashRefunds.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCashRefunds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashRefundEntity to be added to this entity
	 */
	public void addCashRefunds(@NotNull Collection<CashRefundEntity> entities) {
		addCashRefunds(entities, true);
	}

	/**
	 * Add a new collection of CashRefundEntity to Cash Refunds in this entity.
	 *
	 * @param entities the given collection of CashRefundEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCashRefunds(@NonNull Collection<CashRefundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCashRefunds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCashRefunds(CashRefundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashRefundEntity to be set to this entity
	 */
	public void removeCashRefunds(@NotNull CashRefundEntity entity) {
		this.removeCashRefunds(entity, true);
	}

	/**
	 * Remove the given CashRefundEntity from this entity.
	 *
	 * @param entity the given CashRefundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashRefunds(@NotNull CashRefundEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.cashRefunds.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCashRefunds(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashRefundEntity to be removed to this entity
	 */
	public void removeCashRefunds(@NotNull Collection<CashRefundEntity> entities) {
		this.removeCashRefunds(entities, true);
	}

	/**
	 * Remove the given collection of CashRefundEntity from  to this entity.
	 *
	 * @param entities the given collection of CashRefundEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCashRefunds(@NonNull Collection<CashRefundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCashRefunds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCashRefunds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashRefundEntity to be set to this entity
	 */
	public void setCashRefunds(@NotNull Collection<CashRefundEntity> entities) {
		setCashRefunds(entities, true);
	}

	/**
	 * Replace the current entities in Cash Refunds with the given ones.
	 *
	 * @param entities the given collection of CashRefundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashRefunds(@NotNull Collection<CashRefundEntity> entities, boolean reverseAdd) {

		this.unsetCashRefunds();
		this.cashRefunds = new HashSet<>(entities);
		if (reverseAdd) {
			this.cashRefunds.forEach(cashRefundsEntity -> cashRefundsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCashRefunds(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCashRefunds() {
		this.unsetCashRefunds(true);
	}

	/**
	 * Remove all the entities in Cash Refunds from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCashRefunds(boolean doReverse) {
		if (doReverse) {
			this.cashRefunds.forEach(cashRefundsEntity -> cashRefundsEntity.unsetPatientGeneralInfo(false));
		}
		this.cashRefunds.clear();
	}

/**
	 * Similar to {@link this#addInformedConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addInformedConsents(@NotNull InformedConsentEntity entity) {
		addInformedConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to informedConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInformedConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.informedConsents.contains(entity)) {
			informedConsents.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInformedConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addInformedConsents(@NotNull Collection<InformedConsentEntity> entities) {
		addInformedConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Informed Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInformedConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInformedConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeInformedConsents(@NotNull InformedConsentEntity entity) {
		this.removeInformedConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInformedConsents(@NotNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.informedConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInformedConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeInformedConsents(@NotNull Collection<InformedConsentEntity> entities) {
		this.removeInformedConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInformedConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInformedConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setInformedConsents(@NotNull Collection<InformedConsentEntity> entities) {
		setInformedConsents(entities, true);
	}

	/**
	 * Replace the current entities in Informed Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInformedConsents(@NotNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetInformedConsents();
		this.informedConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.informedConsents.forEach(informedConsentsEntity -> informedConsentsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInformedConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInformedConsents() {
		this.unsetInformedConsents(true);
	}

	/**
	 * Remove all the entities in Informed Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInformedConsents(boolean doReverse) {
		if (doReverse) {
			this.informedConsents.forEach(informedConsentsEntity -> informedConsentsEntity.unsetPatientGeneralInfo(false));
		}
		this.informedConsents.clear();
	}

/**
	 * Similar to {@link this#addInvoiceReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addInvoiceReceipts(@NotNull CashReceiptEntity entity) {
		addInvoiceReceipts(entity, true);
	}

	/**
	 * Add a new CashReceiptEntity to invoiceReceipts in this entity.
	 *
	 * @param entity the given CashReceiptEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceReceipts(@NonNull CashReceiptEntity entity, boolean reverseAdd) {
		if (!this.invoiceReceipts.contains(entity)) {
			invoiceReceipts.add(entity);
			if (reverseAdd) {
				entity.setPatient(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 */
	public void addInvoiceReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		addInvoiceReceipts(entities, true);
	}

	/**
	 * Add a new collection of CashReceiptEntity to Invoice Receipts in this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be set to this entity
	 */
	public void removeInvoiceReceipts(@NotNull CashReceiptEntity entity) {
		this.removeInvoiceReceipts(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceReceipts(@NotNull CashReceiptEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatient(false);
		}
		this.invoiceReceipts.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceReceipts(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 */
	public void removeInvoiceReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		this.removeInvoiceReceipts(entities, true);
	}

	/**
	 * Remove the given collection of CashReceiptEntity from  to this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be set to this entity
	 */
	public void setInvoiceReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		setInvoiceReceipts(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Receipts with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceReceipts(@NotNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceReceipts();
		this.invoiceReceipts = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceReceipts.forEach(invoiceReceiptsEntity -> invoiceReceiptsEntity.setPatient(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceReceipts(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceReceipts() {
		this.unsetInvoiceReceipts(true);
	}

	/**
	 * Remove all the entities in Invoice Receipts from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceReceipts(boolean doReverse) {
		if (doReverse) {
			this.invoiceReceipts.forEach(invoiceReceiptsEntity -> invoiceReceiptsEntity.unsetPatient(false));
		}
		this.invoiceReceipts.clear();
	}

/**
	 * Similar to {@link this#addPatientCaseHistories(PatientCaseHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientCaseHistoryEntity to be added to this entity
	 */
	public void addPatientCaseHistories(@NotNull PatientCaseHistoryEntity entity) {
		addPatientCaseHistories(entity, true);
	}

	/**
	 * Add a new PatientCaseHistoryEntity to patientCaseHistories in this entity.
	 *
	 * @param entity the given PatientCaseHistoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientCaseHistories(@NonNull PatientCaseHistoryEntity entity, boolean reverseAdd) {
		if (!this.patientCaseHistories.contains(entity)) {
			patientCaseHistories.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInformation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientCaseHistories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be added to this entity
	 */
	public void addPatientCaseHistories(@NotNull Collection<PatientCaseHistoryEntity> entities) {
		addPatientCaseHistories(entities, true);
	}

	/**
	 * Add a new collection of PatientCaseHistoryEntity to Patient Case Histories in this entity.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientCaseHistories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientCaseHistories(PatientCaseHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientCaseHistoryEntity to be set to this entity
	 */
	public void removePatientCaseHistories(@NotNull PatientCaseHistoryEntity entity) {
		this.removePatientCaseHistories(entity, true);
	}

	/**
	 * Remove the given PatientCaseHistoryEntity from this entity.
	 *
	 * @param entity the given PatientCaseHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientCaseHistories(@NotNull PatientCaseHistoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInformation(false);
		}
		this.patientCaseHistories.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientCaseHistories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be removed to this entity
	 */
	public void removePatientCaseHistories(@NotNull Collection<PatientCaseHistoryEntity> entities) {
		this.removePatientCaseHistories(entities, true);
	}

	/**
	 * Remove the given collection of PatientCaseHistoryEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientCaseHistories(@NonNull Collection<PatientCaseHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientCaseHistories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientCaseHistories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to be set to this entity
	 */
	public void setPatientCaseHistories(@NotNull Collection<PatientCaseHistoryEntity> entities) {
		setPatientCaseHistories(entities, true);
	}

	/**
	 * Replace the current entities in Patient Case Histories with the given ones.
	 *
	 * @param entities the given collection of PatientCaseHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientCaseHistories(@NotNull Collection<PatientCaseHistoryEntity> entities, boolean reverseAdd) {

		this.unsetPatientCaseHistories();
		this.patientCaseHistories = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientCaseHistories.forEach(patientCaseHistoriesEntity -> patientCaseHistoriesEntity.setPatientGeneralInformation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientCaseHistories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientCaseHistories() {
		this.unsetPatientCaseHistories(true);
	}

	/**
	 * Remove all the entities in Patient Case Histories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientCaseHistories(boolean doReverse) {
		if (doReverse) {
			this.patientCaseHistories.forEach(patientCaseHistoriesEntity -> patientCaseHistoriesEntity.unsetPatientGeneralInformation(false));
		}
		this.patientCaseHistories.clear();
	}

/**
	 * Similar to {@link this#addPatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NotNull PatientConsentEntity entity) {
		addPatientConsents(entity, true);
	}

	/**
	 * Add a new PatientConsentEntity to patientConsents in this entity.
	 *
	 * @param entity the given PatientConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientConsents(@NonNull PatientConsentEntity entity, boolean reverseAdd) {
		if (!this.patientConsents.contains(entity)) {
			patientConsents.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NotNull Collection<PatientConsentEntity> entities) {
		addPatientConsents(entities, true);
	}

	/**
	 * Add a new collection of PatientConsentEntity to Patient Consents in this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be set to this entity
	 */
	public void removePatientConsents(@NotNull PatientConsentEntity entity) {
		this.removePatientConsents(entity, true);
	}

	/**
	 * Remove the given PatientConsentEntity from this entity.
	 *
	 * @param entity the given PatientConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientConsents(@NotNull PatientConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.patientConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 */
	public void removePatientConsents(@NotNull Collection<PatientConsentEntity> entities) {
		this.removePatientConsents(entities, true);
	}

	/**
	 * Remove the given collection of PatientConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be set to this entity
	 */
	public void setPatientConsents(@NotNull Collection<PatientConsentEntity> entities) {
		setPatientConsents(entities, true);
	}

	/**
	 * Replace the current entities in Patient Consents with the given ones.
	 *
	 * @param entities the given collection of PatientConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientConsents(@NotNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {

		this.unsetPatientConsents();
		this.patientConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientConsents() {
		this.unsetPatientConsents(true);
	}

	/**
	 * Remove all the entities in Patient Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientConsents(boolean doReverse) {
		if (doReverse) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.unsetPatientGeneralInfo(false));
		}
		this.patientConsents.clear();
	}

	/**
	 * Similar to {@link this#setPatientContactInformation(PatientContactInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientContactInformation(@NotNull PatientContactInfoEntity entity) {
		setPatientContactInformation(entity, true);
	}

	/**
	 * Set or update patientContactInformation with the given PatientContactInfoEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientContactInformation(@NotNull PatientContactInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientContactInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientContactInformation here] end

		if (sameAsFormer(this.patientContactInformation, entity)) {
			return;
		}

		if (this.patientContactInformation != null) {
			this.patientContactInformation.unsetPatientGeneralInformation();
		}

		this.patientContactInformation = entity;

		if (reverseAdd) {
			this.patientContactInformation.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientContactInformation outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientContactInformation outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientContactInformation(boolean)} but default to true.
	 */
	public void unsetPatientContactInformation() {
		this.unsetPatientContactInformation(true);
	}

	/**
	 * Remove the PatientContactInfoEntity in Patient Contact Information from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientContactInformation(boolean reverse) {
		if (reverse && this.patientContactInformation != null) {
			this.patientContactInformation.unsetPatientGeneralInformation(false);
		}
		this.patientContactInformation = null;
	}

	/**
	 * Similar to {@link this#setPatientDetailAddress(PatientDetailAddressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientDetailAddress(@NotNull PatientDetailAddressEntity entity) {
		setPatientDetailAddress(entity, true);
	}

	/**
	 * Set or update patientDetailAddress with the given PatientDetailAddressEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientDetailAddress(@NotNull PatientDetailAddressEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientDetailAddress here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientDetailAddress here] end

		if (sameAsFormer(this.patientDetailAddress, entity)) {
			return;
		}

		if (this.patientDetailAddress != null) {
			this.patientDetailAddress.unsetPatientGeneralInformation();
		}

		this.patientDetailAddress = entity;

		if (reverseAdd) {
			this.patientDetailAddress.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientDetailAddress outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientDetailAddress outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientDetailAddress(boolean)} but default to true.
	 */
	public void unsetPatientDetailAddress() {
		this.unsetPatientDetailAddress(true);
	}

	/**
	 * Remove the PatientDetailAddressEntity in Patient Detail Address from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientDetailAddress(boolean reverse) {
		if (reverse && this.patientDetailAddress != null) {
			this.patientDetailAddress.unsetPatientGeneralInformation(false);
		}
		this.patientDetailAddress = null;
	}

	/**
	 * Similar to {@link this#setPatientDetail(PatientDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientDetail(@NotNull PatientDetailEntity entity) {
		setPatientDetail(entity, true);
	}

	/**
	 * Set or update patientDetail with the given PatientDetailEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientDetail(@NotNull PatientDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientDetail here] end

		if (sameAsFormer(this.patientDetail, entity)) {
			return;
		}

		if (this.patientDetail != null) {
			this.patientDetail.unsetPatientGeneralInformation();
		}

		this.patientDetail = entity;

		if (reverseAdd) {
			this.patientDetail.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientDetail(boolean)} but default to true.
	 */
	public void unsetPatientDetail() {
		this.unsetPatientDetail(true);
	}

	/**
	 * Remove the PatientDetailEntity in Patient Detail from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientDetail(boolean reverse) {
		if (reverse && this.patientDetail != null) {
			this.patientDetail.unsetPatientGeneralInformation(false);
		}
		this.patientDetail = null;
	}

	/**
	 * Similar to {@link this#setPatientEmergencyContactDetail(PatientEmergencyContactDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientEmergencyContactDetail(@NotNull PatientEmergencyContactDetailEntity entity) {
		setPatientEmergencyContactDetail(entity, true);
	}

	/**
	 * Set or update patientEmergencyContactDetail with the given PatientEmergencyContactDetailEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientEmergencyContactDetail(@NotNull PatientEmergencyContactDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientEmergencyContactDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientEmergencyContactDetail here] end

		if (sameAsFormer(this.patientEmergencyContactDetail, entity)) {
			return;
		}

		if (this.patientEmergencyContactDetail != null) {
			this.patientEmergencyContactDetail.unsetPatientGeneralInformation();
		}

		this.patientEmergencyContactDetail = entity;

		if (reverseAdd) {
			this.patientEmergencyContactDetail.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientEmergencyContactDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientEmergencyContactDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientEmergencyContactDetail(boolean)} but default to true.
	 */
	public void unsetPatientEmergencyContactDetail() {
		this.unsetPatientEmergencyContactDetail(true);
	}

	/**
	 * Remove the PatientEmergencyContactDetailEntity in Patient Emergency Contact Detail from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientEmergencyContactDetail(boolean reverse) {
		if (reverse && this.patientEmergencyContactDetail != null) {
			this.patientEmergencyContactDetail.unsetPatientGeneralInformation(false);
		}
		this.patientEmergencyContactDetail = null;
	}

	/**
	 * Similar to {@link this#setPatientEmploymentDetail(PatientEmploymentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientEmploymentDetail(@NotNull PatientEmploymentDetailEntity entity) {
		setPatientEmploymentDetail(entity, true);
	}

	/**
	 * Set or update patientEmploymentDetail with the given PatientEmploymentDetailEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientEmploymentDetail(@NotNull PatientEmploymentDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientEmploymentDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientEmploymentDetail here] end

		if (sameAsFormer(this.patientEmploymentDetail, entity)) {
			return;
		}

		if (this.patientEmploymentDetail != null) {
			this.patientEmploymentDetail.unsetPatientGeneralInfo();
		}

		this.patientEmploymentDetail = entity;

		if (reverseAdd) {
			this.patientEmploymentDetail.setPatientGeneralInfo(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientEmploymentDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientEmploymentDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientEmploymentDetail(boolean)} but default to true.
	 */
	public void unsetPatientEmploymentDetail() {
		this.unsetPatientEmploymentDetail(true);
	}

	/**
	 * Remove the PatientEmploymentDetailEntity in Patient Employment Detail  from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientEmploymentDetail(boolean reverse) {
		if (reverse && this.patientEmploymentDetail != null) {
			this.patientEmploymentDetail.unsetPatientGeneralInfo(false);
		}
		this.patientEmploymentDetail = null;
	}

/**
	 * Similar to {@link this#addPatientFinalizeProfiles(PatientSupportingDocumentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientSupportingDocumentEntity to be added to this entity
	 */
	public void addPatientFinalizeProfiles(@NotNull PatientSupportingDocumentEntity entity) {
		addPatientFinalizeProfiles(entity, true);
	}

	/**
	 * Add a new PatientSupportingDocumentEntity to patientFinalizeProfiles in this entity.
	 *
	 * @param entity the given PatientSupportingDocumentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientFinalizeProfiles(@NonNull PatientSupportingDocumentEntity entity, boolean reverseAdd) {
		if (!this.patientFinalizeProfiles.contains(entity)) {
			patientFinalizeProfiles.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInformation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientFinalizeProfiles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be added to this entity
	 */
	public void addPatientFinalizeProfiles(@NotNull Collection<PatientSupportingDocumentEntity> entities) {
		addPatientFinalizeProfiles(entities, true);
	}

	/**
	 * Add a new collection of PatientSupportingDocumentEntity to Patient Finalize Profiles in this entity.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientFinalizeProfiles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientFinalizeProfiles(PatientSupportingDocumentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientSupportingDocumentEntity to be set to this entity
	 */
	public void removePatientFinalizeProfiles(@NotNull PatientSupportingDocumentEntity entity) {
		this.removePatientFinalizeProfiles(entity, true);
	}

	/**
	 * Remove the given PatientSupportingDocumentEntity from this entity.
	 *
	 * @param entity the given PatientSupportingDocumentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientFinalizeProfiles(@NotNull PatientSupportingDocumentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInformation(false);
		}
		this.patientFinalizeProfiles.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientFinalizeProfiles(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be removed to this entity
	 */
	public void removePatientFinalizeProfiles(@NotNull Collection<PatientSupportingDocumentEntity> entities) {
		this.removePatientFinalizeProfiles(entities, true);
	}

	/**
	 * Remove the given collection of PatientSupportingDocumentEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientFinalizeProfiles(@NonNull Collection<PatientSupportingDocumentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientFinalizeProfiles(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientFinalizeProfiles(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to be set to this entity
	 */
	public void setPatientFinalizeProfiles(@NotNull Collection<PatientSupportingDocumentEntity> entities) {
		setPatientFinalizeProfiles(entities, true);
	}

	/**
	 * Replace the current entities in Patient Finalize Profiles with the given ones.
	 *
	 * @param entities the given collection of PatientSupportingDocumentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientFinalizeProfiles(@NotNull Collection<PatientSupportingDocumentEntity> entities, boolean reverseAdd) {

		this.unsetPatientFinalizeProfiles();
		this.patientFinalizeProfiles = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientFinalizeProfiles.forEach(patientFinalizeProfilesEntity -> patientFinalizeProfilesEntity.setPatientGeneralInformation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientFinalizeProfiles(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientFinalizeProfiles() {
		this.unsetPatientFinalizeProfiles(true);
	}

	/**
	 * Remove all the entities in Patient Finalize Profiles from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientFinalizeProfiles(boolean doReverse) {
		if (doReverse) {
			this.patientFinalizeProfiles.forEach(patientFinalizeProfilesEntity -> patientFinalizeProfilesEntity.unsetPatientGeneralInformation(false));
		}
		this.patientFinalizeProfiles.clear();
	}

	/**
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update patientPaymentBPJS with the given PatientPaymentBPJSEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NotNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.unsetPatientGeneralInfo();
		}

		this.patientPaymentBPJS = entity;

		if (reverseAdd) {
			this.patientPaymentBPJS.setPatientGeneralInfo(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove the PatientPaymentBPJSEntity in Patient Payment BPJS from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.unsetPatientGeneralInfo(false);
		}
		this.patientPaymentBPJS = null;
	}

	/**
	 * Similar to {@link this#setPatientPaymentTypeInsurance(PatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPaymentTypeInsurance(@NotNull PatientPaymentInsuranceEntity entity) {
		setPatientPaymentTypeInsurance(entity, true);
	}

	/**
	 * Set or update patientPaymentTypeInsurance with the given PatientPaymentInsuranceEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentTypeInsurance(@NotNull PatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeInsurance here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeInsurance here] end

		if (sameAsFormer(this.patientPaymentTypeInsurance, entity)) {
			return;
		}

		if (this.patientPaymentTypeInsurance != null) {
			this.patientPaymentTypeInsurance.unsetPatientGeneralInformation();
		}

		this.patientPaymentTypeInsurance = entity;

		if (reverseAdd) {
			this.patientPaymentTypeInsurance.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeInsurance outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeInsurance outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentTypeInsurance(boolean)} but default to true.
	 */
	public void unsetPatientPaymentTypeInsurance() {
		this.unsetPatientPaymentTypeInsurance(true);
	}

	/**
	 * Remove the PatientPaymentInsuranceEntity in Patient Payment Type Insurance from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentTypeInsurance(boolean reverse) {
		if (reverse && this.patientPaymentTypeInsurance != null) {
			this.patientPaymentTypeInsurance.unsetPatientGeneralInformation(false);
		}
		this.patientPaymentTypeInsurance = null;
	}

	/**
	 * Similar to {@link this#setPatientPaymentTypeOthers(PatientPaymentOthersEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPaymentTypeOthers(@NotNull PatientPaymentOthersEntity entity) {
		setPatientPaymentTypeOthers(entity, true);
	}

	/**
	 * Set or update patientPaymentTypeOthers with the given PatientPaymentOthersEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentTypeOthers(@NotNull PatientPaymentOthersEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeOthers here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentTypeOthers here] end

		if (sameAsFormer(this.patientPaymentTypeOthers, entity)) {
			return;
		}

		if (this.patientPaymentTypeOthers != null) {
			this.patientPaymentTypeOthers.unsetPatientGeneralInformation();
		}

		this.patientPaymentTypeOthers = entity;

		if (reverseAdd) {
			this.patientPaymentTypeOthers.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeOthers outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentTypeOthers outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentTypeOthers(boolean)} but default to true.
	 */
	public void unsetPatientPaymentTypeOthers() {
		this.unsetPatientPaymentTypeOthers(true);
	}

	/**
	 * Remove the PatientPaymentOthersEntity in Patient Payment Type Others from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentTypeOthers(boolean reverse) {
		if (reverse && this.patientPaymentTypeOthers != null) {
			this.patientPaymentTypeOthers.unsetPatientGeneralInformation(false);
		}
		this.patientPaymentTypeOthers = null;
	}

	/**
	 * Similar to {@link this#setPatientPersonalInformation(PatientPersonalInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientPersonalInformation(@NotNull PatientPersonalInfoEntity entity) {
		setPatientPersonalInformation(entity, true);
	}

	/**
	 * Set or update patientPersonalInformation with the given PatientPersonalInfoEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPersonalInformation(@NotNull PatientPersonalInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPersonalInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPersonalInformation here] end

		if (sameAsFormer(this.patientPersonalInformation, entity)) {
			return;
		}

		if (this.patientPersonalInformation != null) {
			this.patientPersonalInformation.unsetPatientGeneralInformation();
		}

		this.patientPersonalInformation = entity;

		if (reverseAdd) {
			this.patientPersonalInformation.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPersonalInformation outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPersonalInformation outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPersonalInformation(boolean)} but default to true.
	 */
	public void unsetPatientPersonalInformation() {
		this.unsetPatientPersonalInformation(true);
	}

	/**
	 * Remove the PatientPersonalInfoEntity in Patient Personal Information from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPersonalInformation(boolean reverse) {
		if (reverse && this.patientPersonalInformation != null) {
			this.patientPersonalInformation.unsetPatientGeneralInformation(false);
		}
		this.patientPersonalInformation = null;
	}

	/**
	 * Similar to {@link this#setPatientSelfPaying(PatientPaymentSelfPayingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientSelfPaying(@NotNull PatientPaymentSelfPayingEntity entity) {
		setPatientSelfPaying(entity, true);
	}

	/**
	 * Set or update patientSelfPaying with the given PatientPaymentSelfPayingEntity.
	 *
	 * @param entity the PatientGeneralInfoEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientSelfPaying(@NotNull PatientPaymentSelfPayingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientSelfPaying here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientSelfPaying here] end

		if (sameAsFormer(this.patientSelfPaying, entity)) {
			return;
		}

		if (this.patientSelfPaying != null) {
			this.patientSelfPaying.unsetPatientGeneralInformation();
		}

		this.patientSelfPaying = entity;

		if (reverseAdd) {
			this.patientSelfPaying.setPatientGeneralInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientSelfPaying outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientSelfPaying outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientSelfPaying(boolean)} but default to true.
	 */
	public void unsetPatientSelfPaying() {
		this.unsetPatientSelfPaying(true);
	}

	/**
	 * Remove the PatientPaymentSelfPayingEntity in Patient Self Paying from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientSelfPaying(boolean reverse) {
		if (reverse && this.patientSelfPaying != null) {
			this.patientSelfPaying.unsetPatientGeneralInformation(false);
		}
		this.patientSelfPaying = null;
	}

/**
	 * Similar to {@link this#addRetailPharmacies(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be added to this entity
	 */
	public void addRetailPharmacies(@NotNull RetailPharmacyEntity entity) {
		addRetailPharmacies(entity, true);
	}

	/**
	 * Add a new RetailPharmacyEntity to retailPharmacies in this entity.
	 *
	 * @param entity the given RetailPharmacyEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacies(@NonNull RetailPharmacyEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacies.contains(entity)) {
			retailPharmacies.add(entity);
			if (reverseAdd) {
				entity.setPatientGeneralInfo(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be added to this entity
	 */
	public void addRetailPharmacies(@NotNull Collection<RetailPharmacyEntity> entities) {
		addRetailPharmacies(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyEntity to Retail Pharmacies in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacies(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacies(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be set to this entity
	 */
	public void removeRetailPharmacies(@NotNull RetailPharmacyEntity entity) {
		this.removeRetailPharmacies(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacies(@NotNull RetailPharmacyEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientGeneralInfo(false);
		}
		this.retailPharmacies.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be removed to this entity
	 */
	public void removeRetailPharmacies(@NotNull Collection<RetailPharmacyEntity> entities) {
		this.removeRetailPharmacies(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacies(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be set to this entity
	 */
	public void setRetailPharmacies(@NotNull Collection<RetailPharmacyEntity> entities) {
		setRetailPharmacies(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacies with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacies(@NotNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacies();
		this.retailPharmacies = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacies.forEach(retailPharmaciesEntity -> retailPharmaciesEntity.setPatientGeneralInfo(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacies(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacies() {
		this.unsetRetailPharmacies(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacies from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacies(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacies.forEach(retailPharmaciesEntity -> retailPharmaciesEntity.unsetPatientGeneralInfo(false));
		}
		this.retailPharmacies.clear();
	}

/**
	 * Similar to {@link this#addVisits(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be added to this entity
	 */
	public void addVisits(@NotNull PatientVisitEntity entity) {
		addVisits(entity, true);
	}

	/**
	 * Add a new PatientVisitEntity to visits in this entity.
	 *
	 * @param entity the given PatientVisitEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVisits(@NonNull PatientVisitEntity entity, boolean reverseAdd) {
		if (!this.visits.contains(entity)) {
			visits.add(entity);
			if (reverseAdd) {
				entity.setPatient(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVisits(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitEntity to be added to this entity
	 */
	public void addVisits(@NotNull Collection<PatientVisitEntity> entities) {
		addVisits(entities, true);
	}

	/**
	 * Add a new collection of PatientVisitEntity to Visits in this entity.
	 *
	 * @param entities the given collection of PatientVisitEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVisits(@NonNull Collection<PatientVisitEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVisits(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVisits(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void removeVisits(@NotNull PatientVisitEntity entity) {
		this.removeVisits(entity, true);
	}

	/**
	 * Remove the given PatientVisitEntity from this entity.
	 *
	 * @param entity the given PatientVisitEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVisits(@NotNull PatientVisitEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatient(false);
		}
		this.visits.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVisits(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientVisitEntity to be removed to this entity
	 */
	public void removeVisits(@NotNull Collection<PatientVisitEntity> entities) {
		this.removeVisits(entities, true);
	}

	/**
	 * Remove the given collection of PatientVisitEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientVisitEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVisits(@NonNull Collection<PatientVisitEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVisits(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVisits(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitEntity to be set to this entity
	 */
	public void setVisits(@NotNull Collection<PatientVisitEntity> entities) {
		setVisits(entities, true);
	}

	/**
	 * Replace the current entities in Visits with the given ones.
	 *
	 * @param entities the given collection of PatientVisitEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVisits(@NotNull Collection<PatientVisitEntity> entities, boolean reverseAdd) {

		this.unsetVisits();
		this.visits = new HashSet<>(entities);
		if (reverseAdd) {
			this.visits.forEach(visitsEntity -> visitsEntity.setPatient(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVisits(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVisits() {
		this.unsetVisits(true);
	}

	/**
	 * Remove all the entities in Visits from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVisits(boolean doReverse) {
		if (doReverse) {
			this.visits.forEach(visitsEntity -> visitsEntity.unsetPatient(false));
		}
		this.visits.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public void addPatientPicture(FileEntity newFile) {
		patientPicture.add(newFile);
	}

	public void addAllPatientPicture(Collection<FileEntity> newFiles) {
		patientPicture.addAll(newFiles);
	}

	public void removePatientPicture(FileEntity newFile) {
		patientPicture.remove(newFile);
	}

	public boolean containsPatientPicture(FileEntity newFile) {
		return patientPicture.contains(newFile);
	}

	public void clearAllPatientPicture() {
		patientPicture.clear();
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
		return "PATIENT_ID,TITLE,GIVEN_NAME,LAST_NAME,PLACE_OF_BIRTH,DATE_OF_BIRTH,GENDER,ADDRESS,PATIENT_PAYMENT_TYPE,IMPORTANT_NOTES,HAS_OUTSTANDING_PAYMENT,BPJS_CLAIM_SUBMISSIONS_IDS,CASH_REFUNDS_IDS,INFORMED_CONSENTS_IDS,INVOICE_RECEIPTS_IDS,PATIENT_CASE_HISTORIES_IDS,PATIENT_CONSENTS_IDS,PATIENT_CONTACT_INFORMATION_ID,PATIENT_DETAIL_ADDRESS_ID,PATIENT_DETAIL_ID,PATIENT_EMERGENCY_CONTACT_DETAIL_ID,PATIENT_EMPLOYMENT_DETAIL_ID,PATIENT_FINALIZE_PROFILES_IDS,PATIENT_PAYMENT_BPJS_ID,PATIENT_PAYMENT_TYPE_INSURANCE_ID,PATIENT_PAYMENT_TYPE_OTHERS_ID,PATIENT_PERSONAL_INFORMATION_ID,PATIENT_SELF_PAYING_ID,RETAIL_PHARMACIES_IDS,VISITS_IDS,ID";
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

		this.cashRefundsIds = new HashSet<>();
		for (CashRefundEntity cashRefunds: this.cashRefunds) {
			this.cashRefundsIds.add(cashRefunds.getId());
		}

		this.informedConsentsIds = new HashSet<>();
		for (InformedConsentEntity informedConsents: this.informedConsents) {
			this.informedConsentsIds.add(informedConsents.getId());
		}

		this.invoiceReceiptsIds = new HashSet<>();
		for (CashReceiptEntity invoiceReceipts: this.invoiceReceipts) {
			this.invoiceReceiptsIds.add(invoiceReceipts.getId());
		}

		this.patientCaseHistoriesIds = new HashSet<>();
		for (PatientCaseHistoryEntity patientCaseHistories: this.patientCaseHistories) {
			this.patientCaseHistoriesIds.add(patientCaseHistories.getId());
		}

		this.patientConsentsIds = new HashSet<>();
		for (PatientConsentEntity patientConsents: this.patientConsents) {
			this.patientConsentsIds.add(patientConsents.getId());
		}

		Optional<PatientContactInfoEntity> patientContactInformationRelation = Optional.ofNullable(this.patientContactInformation);
		patientContactInformationRelation.ifPresent(entity -> this.patientContactInformationId = entity.getId());

		Optional<PatientDetailAddressEntity> patientDetailAddressRelation = Optional.ofNullable(this.patientDetailAddress);
		patientDetailAddressRelation.ifPresent(entity -> this.patientDetailAddressId = entity.getId());

		Optional<PatientDetailEntity> patientDetailRelation = Optional.ofNullable(this.patientDetail);
		patientDetailRelation.ifPresent(entity -> this.patientDetailId = entity.getId());

		Optional<PatientEmergencyContactDetailEntity> patientEmergencyContactDetailRelation = Optional.ofNullable(this.patientEmergencyContactDetail);
		patientEmergencyContactDetailRelation.ifPresent(entity -> this.patientEmergencyContactDetailId = entity.getId());

		Optional<PatientEmploymentDetailEntity> patientEmploymentDetailRelation = Optional.ofNullable(this.patientEmploymentDetail);
		patientEmploymentDetailRelation.ifPresent(entity -> this.patientEmploymentDetailId = entity.getId());

		this.patientFinalizeProfilesIds = new HashSet<>();
		for (PatientSupportingDocumentEntity patientFinalizeProfiles: this.patientFinalizeProfiles) {
			this.patientFinalizeProfilesIds.add(patientFinalizeProfiles.getId());
		}

		Optional<PatientPaymentBPJSEntity> patientPaymentBPJSRelation = Optional.ofNullable(this.patientPaymentBPJS);
		patientPaymentBPJSRelation.ifPresent(entity -> this.patientPaymentBPJSId = entity.getId());

		Optional<PatientPaymentInsuranceEntity> patientPaymentTypeInsuranceRelation = Optional.ofNullable(this.patientPaymentTypeInsurance);
		patientPaymentTypeInsuranceRelation.ifPresent(entity -> this.patientPaymentTypeInsuranceId = entity.getId());

		Optional<PatientPaymentOthersEntity> patientPaymentTypeOthersRelation = Optional.ofNullable(this.patientPaymentTypeOthers);
		patientPaymentTypeOthersRelation.ifPresent(entity -> this.patientPaymentTypeOthersId = entity.getId());

		Optional<PatientPersonalInfoEntity> patientPersonalInformationRelation = Optional.ofNullable(this.patientPersonalInformation);
		patientPersonalInformationRelation.ifPresent(entity -> this.patientPersonalInformationId = entity.getId());

		Optional<PatientPaymentSelfPayingEntity> patientSelfPayingRelation = Optional.ofNullable(this.patientSelfPaying);
		patientSelfPayingRelation.ifPresent(entity -> this.patientSelfPayingId = entity.getId());

		this.retailPharmaciesIds = new HashSet<>();
		for (RetailPharmacyEntity retailPharmacies: this.retailPharmacies) {
			this.retailPharmaciesIds.add(retailPharmacies.getId());
		}

		this.visitsIds = new HashSet<>();
		for (PatientVisitEntity visits: this.visits) {
			this.visitsIds.add(visits.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientGeneralInfo) {
		if (this == patientGeneralInfo) {
			return true;
		}
		if (patientGeneralInfo == null || this.getClass() != patientGeneralInfo.getClass()) {
			return false;
		}
		if (!super.equals(patientGeneralInfo)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientGeneralInfoEntity that = (PatientGeneralInfoEntity) patientGeneralInfo;
		return
			Objects.equals(this.patientID, that.patientID) &&
			Objects.equals(this.title, that.title) &&
			Objects.equals(this.givenName, that.givenName) &&
			Objects.equals(this.lastName, that.lastName) &&
			Objects.equals(this.placeOfBirth, that.placeOfBirth) &&
			Objects.equals(
			     this.dateOfBirth != null ? this.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateOfBirth != null ? that.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.patientPaymentType, that.patientPaymentType) &&
			Objects.equals(this.importantNotes, that.importantNotes) &&
			Objects.equals(this.hasOutstandingPayment, that.hasOutstandingPayment) &&
			Objects.equals(this.bpjsClaimSubmissionsIds, that.bpjsClaimSubmissionsIds) &&
			Objects.equals(this.cashRefundsIds, that.cashRefundsIds) &&
			Objects.equals(this.informedConsentsIds, that.informedConsentsIds) &&
			Objects.equals(this.invoiceReceiptsIds, that.invoiceReceiptsIds) &&
			Objects.equals(this.patientCaseHistoriesIds, that.patientCaseHistoriesIds) &&
			Objects.equals(this.patientConsentsIds, that.patientConsentsIds) &&
			Objects.equals(this.patientContactInformationId, that.patientContactInformationId) &&
			Objects.equals(this.patientDetailAddressId, that.patientDetailAddressId) &&
			Objects.equals(this.patientDetailId, that.patientDetailId) &&
			Objects.equals(this.patientEmergencyContactDetailId, that.patientEmergencyContactDetailId) &&
			Objects.equals(this.patientEmploymentDetailId, that.patientEmploymentDetailId) &&
			Objects.equals(this.patientFinalizeProfilesIds, that.patientFinalizeProfilesIds) &&
			Objects.equals(this.patientPaymentBPJSId, that.patientPaymentBPJSId) &&
			Objects.equals(this.patientPaymentTypeInsuranceId, that.patientPaymentTypeInsuranceId) &&
			Objects.equals(this.patientPaymentTypeOthersId, that.patientPaymentTypeOthersId) &&
			Objects.equals(this.patientPersonalInformationId, that.patientPersonalInformationId) &&
			Objects.equals(this.patientSelfPayingId, that.patientSelfPayingId) &&
			Objects.equals(this.retailPharmaciesIds, that.retailPharmaciesIds) &&
			Objects.equals(this.visitsIds, that.visitsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
