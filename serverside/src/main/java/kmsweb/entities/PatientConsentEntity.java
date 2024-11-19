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
import kmsweb.dtos.PatientConsentEntityDto;
import kmsweb.entities.listeners.PatientConsentEntityListener;
import kmsweb.serializers.PatientConsentSerializer;
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
@EntityListeners({PatientConsentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientConsentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientConsentEntity extends AbstractEntity {

	/**
	 * Takes a PatientConsentEntityDto and converts it into a PatientConsentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientConsentEntityDto
	 */
	public PatientConsentEntity(PatientConsentEntityDto patientConsentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientConsentEntityDto.getId() != null) {
			this.setId(patientConsentEntityDto.getId());
		}

		if (patientConsentEntityDto.getConsentDateTime() != null) {
			this.setConsentDateTime(patientConsentEntityDto.getConsentDateTime());
		}

		if (patientConsentEntityDto.getConsentOnPaymentTerms() != null) {
			this.setConsentOnPaymentTerms(patientConsentEntityDto.getConsentOnPaymentTerms());
		}

		if (patientConsentEntityDto.getConsentOnRightsAndObligations() != null) {
			this.setConsentOnRightsAndObligations(patientConsentEntityDto.getConsentOnRightsAndObligations());
		}

		if (patientConsentEntityDto.getConsentOnHospitalRegulations() != null) {
			this.setConsentOnHospitalRegulations(patientConsentEntityDto.getConsentOnHospitalRegulations());
		}

		if (patientConsentEntityDto.getNeedInterpreter() != null) {
			this.setNeedInterpreter(patientConsentEntityDto.getNeedInterpreter());
		}

		if (patientConsentEntityDto.getNeedReligiousCounselor() != null) {
			this.setNeedReligiousCounselor(patientConsentEntityDto.getNeedReligiousCounselor());
		}

		if (patientConsentEntityDto.getDgsResultsReleasedToInsurer() != null) {
			this.setDgsResultsReleasedToInsurer(patientConsentEntityDto.getDgsResultsReleasedToInsurer());
		}

		if (patientConsentEntityDto.getDgsResultsReleasedToStudents() != null) {
			this.setDgsResultsReleasedToStudents(patientConsentEntityDto.getDgsResultsReleasedToStudents());
		}

		if (patientConsentEntityDto.getRecordReleasedToFamilyMember() != null) {
			this.setRecordReleasedToFamilyMember(patientConsentEntityDto.getRecordReleasedToFamilyMember());
		}

		if (patientConsentEntityDto.getRecordReleasedToCertainHealthFacilities() != null) {
			this.setRecordReleasedToCertainHealthFacilities(patientConsentEntityDto.getRecordReleasedToCertainHealthFacilities());
		}

		if (patientConsentEntityDto.getStaffSignature() != null) {
			this.setStaffSignature(patientConsentEntityDto.getStaffSignature());
		}

		if (patientConsentEntityDto.getConsentingPartySignature() != null) {
			this.setConsentingPartySignature(patientConsentEntityDto.getConsentingPartySignature());
		}

		if (patientConsentEntityDto.getConsentingPartyType() != null) {
			this.setConsentingPartyType(patientConsentEntityDto.getConsentingPartyType());
		}

		if (patientConsentEntityDto.getConsentingPartyName() != null) {
			this.setConsentingPartyName(patientConsentEntityDto.getConsentingPartyName());
		}

		if (patientConsentEntityDto.getReadAndSignSatusehat() != null) {
			this.setReadAndSignSatusehat(patientConsentEntityDto.getReadAndSignSatusehat());
		}

		if (patientConsentEntityDto.getInformationReleasedToSatusehat() != null) {
			this.setInformationReleasedToSatusehat(patientConsentEntityDto.getInformationReleasedToSatusehat());
		}

		if (patientConsentEntityDto.getEmrReleasedToSatusehat() != null) {
			this.setEmrReleasedToSatusehat(patientConsentEntityDto.getEmrReleasedToSatusehat());
		}

		if (patientConsentEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(patientConsentEntityDto.getPatientGeneralInfo());
		}

		if (patientConsentEntityDto.getStaff() != null) {
			this.setStaff(patientConsentEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Consent Date Time here] off begin
	@CsvCustomBindByName(column = "CONSENT_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "consent_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Consent Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consent Date Time here] end
	private OffsetDateTime consentDateTime;

	// % protected region % [Modify attribute annotation for Consent On Payment Terms here] off begin
	@CsvBindByName(column = "CONSENT_ON_PAYMENT_TERMS", required = false)
	@Nullable
	@Column(name = "consent_on_payment_terms")
	@Schema(description = "The Consent On Payment Terms of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consent On Payment Terms here] end
	private String consentOnPaymentTerms;

	// % protected region % [Modify attribute annotation for Consent On Rights And Obligations here] off begin
	@CsvBindByName(column = "CONSENT_ON_RIGHTS_AND_OBLIGATIONS", required = false)
	@Nullable
	@Column(name = "consent_on_rights_and_obligations")
	@Schema(description = "The Consent On Rights And Obligations of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consent On Rights And Obligations here] end
	private String consentOnRightsAndObligations;

	// % protected region % [Modify attribute annotation for Consent On Hospital Regulations here] off begin
	@CsvBindByName(column = "CONSENT_ON_HOSPITAL_REGULATIONS", required = false)
	@Nullable
	@Column(name = "consent_on_hospital_regulations")
	@Schema(description = "The Consent On Hospital Regulations of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consent On Hospital Regulations here] end
	private String consentOnHospitalRegulations;

	// % protected region % [Modify attribute annotation for Need Interpreter here] off begin
	@CsvBindByName(column = "NEED_INTERPRETER", required = false)
	@Nullable
	@Column(name = "need_interpreter")
	@Schema(description = "The Need Interpreter of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Need Interpreter here] end
	private String needInterpreter;

	// % protected region % [Modify attribute annotation for Need Religious Counselor here] off begin
	@CsvBindByName(column = "NEED_RELIGIOUS_COUNSELOR", required = false)
	@Nullable
	@Column(name = "need_religious_counselor")
	@Schema(description = "The Need Religious Counselor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Need Religious Counselor here] end
	private String needReligiousCounselor;

	// % protected region % [Modify attribute annotation for Dgs Results Released To Insurer here] off begin
	@CsvBindByName(column = "DGS_RESULTS_RELEASED_TO_INSURER", required = false)
	@Nullable
	@Column(name = "dgs_results_released_to_insurer")
	@Schema(description = "The Dgs Results Released To Insurer of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dgs Results Released To Insurer here] end
	private String dgsResultsReleasedToInsurer;

	// % protected region % [Modify attribute annotation for Dgs Results Released To Students here] off begin
	@CsvBindByName(column = "DGS_RESULTS_RELEASED_TO_STUDENTS", required = false)
	@Nullable
	@Column(name = "dgs_results_released_to_students")
	@Schema(description = "The Dgs Results Released To Students of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dgs Results Released To Students here] end
	private String dgsResultsReleasedToStudents;

	// % protected region % [Modify attribute annotation for Record Released To Family Member here] off begin
	@CsvBindByName(column = "RECORD_RELEASED_TO_FAMILY_MEMBER", required = false)
	@Nullable
	@Column(name = "record_released_to_family_member")
	@Schema(description = "The Record Released To Family Member of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Record Released To Family Member here] end
	private String recordReleasedToFamilyMember;

	// % protected region % [Modify attribute annotation for Record Released To Certain Health Facilities here] off begin
	@CsvBindByName(column = "RECORD_RELEASED_TO_CERTAIN_HEALTH_FACILITIES", required = false)
	@Nullable
	@Column(name = "record_released_to_certain_health_facilities")
	@Schema(description = "The Record Released To Certain Health Facilities of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Record Released To Certain Health Facilities here] end
	private String recordReleasedToCertainHealthFacilities;

	// % protected region % [Modify attribute annotation for Staff Signature here] off begin
	@CsvBindByName(column = "STAFF_SIGNATURE", required = false)
	@Nullable
	@Lob
	@Column(name = "staff_signature")
	@Schema(description = "The Staff Signature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Staff Signature here] end
	private String staffSignature;

	// % protected region % [Modify attribute annotation for Consenting Party Signature here] off begin
	@CsvBindByName(column = "CONSENTING_PARTY_SIGNATURE", required = false)
	@Nullable
	@Lob
	@Column(name = "consenting_party_signature")
	@Schema(description = "The Consenting Party Signature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consenting Party Signature here] end
	private String consentingPartySignature;

	// % protected region % [Modify attribute annotation for Consenting Party Type here] off begin
	@CsvBindByName(column = "CONSENTING_PARTY_TYPE", required = false)
	@Nullable
	@Column(name = "consenting_party_type")
	@Schema(description = "The Consenting Party Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consenting Party Type here] end
	private String consentingPartyType;

	// % protected region % [Modify attribute annotation for Consenting Party Name here] off begin
	@CsvBindByName(column = "CONSENTING_PARTY_NAME", required = false)
	@Nullable
	@Column(name = "consenting_party_name")
	@Schema(description = "The Consenting Party Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consenting Party Name here] end
	private String consentingPartyName;

	// % protected region % [Modify attribute annotation for Read And Sign Satusehat here] off begin
	@CsvBindByName(column = "READ_AND_SIGN_SATUSEHAT", required = false)
	@Nullable
	@Column(name = "read_and_sign_satusehat")
	@Schema(description = "The Read And Sign Satusehat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Read And Sign Satusehat here] end
	private Boolean readAndSignSatusehat = false ;

	// % protected region % [Modify attribute annotation for Information Released To Satusehat here] off begin
	@CsvBindByName(column = "INFORMATION_RELEASED_TO_SATUSEHAT", required = false)
	@Nullable
	@Column(name = "information_released_to_satusehat")
	@Schema(description = "The Information Released To Satusehat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Information Released To Satusehat here] end
	private String informationReleasedToSatusehat;

	// % protected region % [Modify attribute annotation for Emr Released To Satusehat here] off begin
	@CsvBindByName(column = "EMR_RELEASED_TO_SATUSEHAT", required = false)
	@Nullable
	@Column(name = "emr_released_to_satusehat")
	@Schema(description = "The Emr Released To Satusehat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Emr Released To Satusehat here] end
	private String emrReleasedToSatusehat;

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

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
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
			this.patientGeneralInfo.removePatientConsents(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addPatientConsents(this, false);
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
			this.patientGeneralInfo.removePatientConsents(this, false);
		}
		this.patientGeneralInfo = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removePatientConsents(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addPatientConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removePatientConsents(this, false);
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
		return "CONSENT_DATE_TIME,CONSENT_ON_PAYMENT_TERMS,CONSENT_ON_RIGHTS_AND_OBLIGATIONS,CONSENT_ON_HOSPITAL_REGULATIONS,NEED_INTERPRETER,NEED_RELIGIOUS_COUNSELOR,DGS_RESULTS_RELEASED_TO_INSURER,DGS_RESULTS_RELEASED_TO_STUDENTS,RECORD_RELEASED_TO_FAMILY_MEMBER,RECORD_RELEASED_TO_CERTAIN_HEALTH_FACILITIES,STAFF_SIGNATURE,CONSENTING_PARTY_SIGNATURE,CONSENTING_PARTY_TYPE,CONSENTING_PARTY_NAME,READ_AND_SIGN_SATUSEHAT,INFORMATION_RELEASED_TO_SATUSEHAT,EMR_RELEASED_TO_SATUSEHAT,PATIENT_GENERAL_INFO_ID,STAFF_ID,ID";
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

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientConsent) {
		if (this == patientConsent) {
			return true;
		}
		if (patientConsent == null || this.getClass() != patientConsent.getClass()) {
			return false;
		}
		if (!super.equals(patientConsent)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientConsentEntity that = (PatientConsentEntity) patientConsent;
		return
			Objects.equals(
			     this.consentDateTime != null ? this.consentDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.consentDateTime != null ? that.consentDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.consentOnPaymentTerms, that.consentOnPaymentTerms) &&
			Objects.equals(this.consentOnRightsAndObligations, that.consentOnRightsAndObligations) &&
			Objects.equals(this.consentOnHospitalRegulations, that.consentOnHospitalRegulations) &&
			Objects.equals(this.needInterpreter, that.needInterpreter) &&
			Objects.equals(this.needReligiousCounselor, that.needReligiousCounselor) &&
			Objects.equals(this.dgsResultsReleasedToInsurer, that.dgsResultsReleasedToInsurer) &&
			Objects.equals(this.dgsResultsReleasedToStudents, that.dgsResultsReleasedToStudents) &&
			Objects.equals(this.recordReleasedToFamilyMember, that.recordReleasedToFamilyMember) &&
			Objects.equals(this.recordReleasedToCertainHealthFacilities, that.recordReleasedToCertainHealthFacilities) &&
			Objects.equals(this.staffSignature, that.staffSignature) &&
			Objects.equals(this.consentingPartySignature, that.consentingPartySignature) &&
			Objects.equals(this.consentingPartyType, that.consentingPartyType) &&
			Objects.equals(this.consentingPartyName, that.consentingPartyName) &&
			Objects.equals(this.readAndSignSatusehat, that.readAndSignSatusehat) &&
			Objects.equals(this.informationReleasedToSatusehat, that.informationReleasedToSatusehat) &&
			Objects.equals(this.emrReleasedToSatusehat, that.emrReleasedToSatusehat) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
