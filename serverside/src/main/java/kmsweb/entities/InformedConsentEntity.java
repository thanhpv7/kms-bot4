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
import kmsweb.dtos.InformedConsentEntityDto;
import kmsweb.entities.listeners.InformedConsentEntityListener;
import kmsweb.serializers.InformedConsentSerializer;
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
@EntityListeners({InformedConsentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InformedConsentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InformedConsentEntity extends AbstractEntity {

	/**
	 * Takes a InformedConsentEntityDto and converts it into a InformedConsentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param informedConsentEntityDto
	 */
	public InformedConsentEntity(InformedConsentEntityDto informedConsentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (informedConsentEntityDto.getId() != null) {
			this.setId(informedConsentEntityDto.getId());
		}

		if (informedConsentEntityDto.getPatientFamilyGuardianName() != null) {
			this.setPatientFamilyGuardianName(informedConsentEntityDto.getPatientFamilyGuardianName());
		}

		if (informedConsentEntityDto.getPatientFamilyGuardianRelationship() != null) {
			this.setPatientFamilyGuardianRelationship(informedConsentEntityDto.getPatientFamilyGuardianRelationship());
		}

		if (informedConsentEntityDto.getProcedureToBePerformed() != null) {
			this.setProcedureToBePerformed(informedConsentEntityDto.getProcedureToBePerformed());
		}

		if (informedConsentEntityDto.getConsequenceOfProcedure() != null) {
			this.setConsequenceOfProcedure(informedConsentEntityDto.getConsequenceOfProcedure());
		}

		if (informedConsentEntityDto.getConsentOnProcedure() != null) {
			this.setConsentOnProcedure(informedConsentEntityDto.getConsentOnProcedure());
		}

		if (informedConsentEntityDto.getConsentDateTime() != null) {
			this.setConsentDateTime(informedConsentEntityDto.getConsentDateTime());
		}

		if (informedConsentEntityDto.getInformingStaffSignature() != null) {
			this.setInformingStaffSignature(informedConsentEntityDto.getInformingStaffSignature());
		}

		if (informedConsentEntityDto.getConsentingPartySignature() != null) {
			this.setConsentingPartySignature(informedConsentEntityDto.getConsentingPartySignature());
		}

		if (informedConsentEntityDto.getConsentingPartyType() != null) {
			this.setConsentingPartyType(informedConsentEntityDto.getConsentingPartyType());
		}

		if (informedConsentEntityDto.getConsentingPartyName() != null) {
			this.setConsentingPartyName(informedConsentEntityDto.getConsentingPartyName());
		}

		if (informedConsentEntityDto.getWitnessSignature1() != null) {
			this.setWitnessSignature1(informedConsentEntityDto.getWitnessSignature1());
		}

		if (informedConsentEntityDto.getWitnessName1() != null) {
			this.setWitnessName1(informedConsentEntityDto.getWitnessName1());
		}

		if (informedConsentEntityDto.getWitnessSignature2() != null) {
			this.setWitnessSignature2(informedConsentEntityDto.getWitnessSignature2());
		}

		if (informedConsentEntityDto.getWitnessName2() != null) {
			this.setWitnessName2(informedConsentEntityDto.getWitnessName2());
		}

		if (informedConsentEntityDto.getNotes() != null) {
			this.setNotes(informedConsentEntityDto.getNotes());
		}

		if (informedConsentEntityDto.getAccompanyingStaff() != null) {
			this.setAccompanyingStaff(informedConsentEntityDto.getAccompanyingStaff());
		}

		if (informedConsentEntityDto.getPatientGeneralInfo() != null) {
			this.setPatientGeneralInfo(informedConsentEntityDto.getPatientGeneralInfo());
		}

		if (informedConsentEntityDto.getRegistration() != null) {
			this.setRegistration(informedConsentEntityDto.getRegistration());
		}

		if (informedConsentEntityDto.getInformingStaff() != null) {
			this.setInformingStaff(informedConsentEntityDto.getInformingStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Patient Family Guardian Name here] off begin
	@CsvBindByName(column = "PATIENT_FAMILY_GUARDIAN_NAME", required = false)
	@Nullable
	@Column(name = "patient_family_guardian_name")
	@Schema(description = "The Patient Family Guardian Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Family Guardian Name here] end
	private String patientFamilyGuardianName;

	// % protected region % [Modify attribute annotation for Patient Family Guardian Relationship here] off begin
	@CsvBindByName(column = "PATIENT_FAMILY_GUARDIAN_RELATIONSHIP", required = false)
	@Nullable
	@Column(name = "patient_family_guardian_relationship")
	@Schema(description = "The Patient Family Guardian Relationship of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Family Guardian Relationship here] end
	private String patientFamilyGuardianRelationship;

	// % protected region % [Modify attribute annotation for Procedure To Be Performed here] off begin
	@CsvBindByName(column = "PROCEDURE_TO_BE_PERFORMED", required = false)
	@Nullable
	@Lob
	@Column(name = "procedure_to_be_performed")
	@Schema(description = "The Procedure To Be Performed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Procedure To Be Performed here] end
	private String procedureToBePerformed;

	// % protected region % [Modify attribute annotation for Consequence Of Procedure here] off begin
	@CsvBindByName(column = "CONSEQUENCE_OF_PROCEDURE", required = false)
	@Nullable
	@Lob
	@Column(name = "consequence_of_procedure")
	@Schema(description = "The Consequence Of Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consequence Of Procedure here] end
	private String consequenceOfProcedure;

	// % protected region % [Modify attribute annotation for Consent On Procedure here] off begin
	@CsvBindByName(column = "CONSENT_ON_PROCEDURE", required = false)
	@Nullable
	@Column(name = "consent_on_procedure")
	@Schema(description = "The Consent On Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consent On Procedure here] end
	private String consentOnProcedure;

	// % protected region % [Modify attribute annotation for Consent Date Time here] off begin

	@CsvCustomBindByName(column = "CONSENT_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "consent_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Consent Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consent Date Time here] end
	private OffsetDateTime consentDateTime;

	// % protected region % [Modify attribute annotation for Informing Staff Signature here] off begin
	@CsvBindByName(column = "INFORMING_STAFF_SIGNATURE", required = false)
	@Nullable
	@Lob
	@Column(name = "informing_staff_signature")
	@Schema(description = "The Informing Staff Signature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Informing Staff Signature here] end
	private String informingStaffSignature;

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

	// % protected region % [Modify attribute annotation for Witness Signature 1 here] off begin
	@CsvBindByName(column = "WITNESS_SIGNATURE_1", required = false)
	@Nullable
	@Lob
	@Column(name = "witness_signature_1")
	@Schema(description = "The Witness Signature 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Witness Signature 1 here] end
	private String witnessSignature1;

	// % protected region % [Modify attribute annotation for Witness Name 1 here] off begin
	@CsvBindByName(column = "WITNESS_NAME_1", required = false)
	@Nullable
	@Column(name = "witness_name_1")
	@Schema(description = "The Witness Name 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Witness Name 1 here] end
	private String witnessName1;

	// % protected region % [Modify attribute annotation for Witness Signature 2 here] off begin
	@CsvBindByName(column = "WITNESS_SIGNATURE_2", required = false)
	@Nullable
	@Lob
	@Column(name = "witness_signature_2")
	@Schema(description = "The Witness Signature 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Witness Signature 2 here] end
	private String witnessSignature2;

	// % protected region % [Modify attribute annotation for Witness Name 2 here] off begin
	@CsvBindByName(column = "WITNESS_NAME_2", required = false)
	@Nullable
	@Column(name = "witness_name_2")
	@Schema(description = "The Witness Name 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Witness Name 2 here] end
	private String witnessName2;

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

	// % protected region % [Update the annotation for Accompanying Staff here] off begin
	@Schema(description = "The Accompanying Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Accompanying Staff here] end
	private StaffEntity accompanyingStaff;

	// % protected region % [Update the annotation for accompanyingStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ACCOMPANYING_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for accompanyingStaffId here] end
	private UUID accompanyingStaffId;

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

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	// % protected region % [Update the annotation for Informing Staff here] off begin
	@Schema(description = "The Informing Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Informing Staff here] end
	private StaffEntity informingStaff;

	// % protected region % [Update the annotation for informingStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INFORMING_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for informingStaffId here] end
	private UUID informingStaffId;

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
	 * Similar to {@link this#setAccompanyingStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAccompanyingStaff(@NotNull StaffEntity entity) {
		setAccompanyingStaff(entity, true);
	}

	/**
	 * Set or update the accompanyingStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to accompanyingStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAccompanyingStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAccompanyingStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAccompanyingStaff here] end

		if (sameAsFormer(this.accompanyingStaff, entity)) {
			return;
		}

		if (this.accompanyingStaff != null) {
			this.accompanyingStaff.removeAccompanyingConsents(this, false);
		}
		this.accompanyingStaff = entity;
		if (reverseAdd) {
			this.accompanyingStaff.addAccompanyingConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAccompanyingStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAccompanyingStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAccompanyingStaff(boolean)} but default to true.
	 */
	public void unsetAccompanyingStaff() {
		this.unsetAccompanyingStaff(true);
	}

	/**
	 * Remove Accompanying Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAccompanyingStaff(boolean reverse) {
		if (reverse && this.accompanyingStaff != null) {
			this.accompanyingStaff.removeAccompanyingConsents(this, false);
		}
		this.accompanyingStaff = null;
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
			this.patientGeneralInfo.removeInformedConsents(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addInformedConsents(this, false);
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
			this.patientGeneralInfo.removeInformedConsents(this, false);
		}
		this.patientGeneralInfo = null;
	}
	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeInformedConsents(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addInformedConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeInformedConsents(this, false);
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setInformingStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setInformingStaff(@NotNull StaffEntity entity) {
		setInformingStaff(entity, true);
	}

	/**
	 * Set or update the informingStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to informingStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInformingStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInformingStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInformingStaff here] end

		if (sameAsFormer(this.informingStaff, entity)) {
			return;
		}

		if (this.informingStaff != null) {
			this.informingStaff.removeInformingConsents(this, false);
		}
		this.informingStaff = entity;
		if (reverseAdd) {
			this.informingStaff.addInformingConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInformingStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInformingStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInformingStaff(boolean)} but default to true.
	 */
	public void unsetInformingStaff() {
		this.unsetInformingStaff(true);
	}

	/**
	 * Remove Informing Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInformingStaff(boolean reverse) {
		if (reverse && this.informingStaff != null) {
			this.informingStaff.removeInformingConsents(this, false);
		}
		this.informingStaff = null;
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
		return "PATIENT_FAMILY_GUARDIAN_NAME,PATIENT_FAMILY_GUARDIAN_RELATIONSHIP,PROCEDURE_TO_BE_PERFORMED,CONSEQUENCE_OF_PROCEDURE,CONSENT_ON_PROCEDURE,CONSENT_DATE_TIME,INFORMING_STAFF_SIGNATURE,CONSENTING_PARTY_SIGNATURE,CONSENTING_PARTY_TYPE,CONSENTING_PARTY_NAME,WITNESS_SIGNATURE_1,WITNESS_NAME_1,WITNESS_SIGNATURE_2,WITNESS_NAME_2,NOTES,ACCOMPANYING_STAFF_ID,PATIENT_GENERAL_INFO_ID,REGISTRATION_ID,INFORMING_STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<StaffEntity> accompanyingStaffRelation = Optional.ofNullable(this.accompanyingStaff);
		accompanyingStaffRelation.ifPresent(entity -> this.accompanyingStaffId = entity.getId());

		Optional<PatientGeneralInfoEntity> patientGeneralInfoRelation = Optional.ofNullable(this.patientGeneralInfo);
		patientGeneralInfoRelation.ifPresent(entity -> this.patientGeneralInfoId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<StaffEntity> informingStaffRelation = Optional.ofNullable(this.informingStaff);
		informingStaffRelation.ifPresent(entity -> this.informingStaffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object informedConsent) {
		if (this == informedConsent) {
			return true;
		}
		if (informedConsent == null || this.getClass() != informedConsent.getClass()) {
			return false;
		}
		if (!super.equals(informedConsent)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InformedConsentEntity that = (InformedConsentEntity) informedConsent;
		return
			Objects.equals(this.patientFamilyGuardianName, that.patientFamilyGuardianName) &&
			Objects.equals(this.patientFamilyGuardianRelationship, that.patientFamilyGuardianRelationship) &&
			Objects.equals(this.procedureToBePerformed, that.procedureToBePerformed) &&
			Objects.equals(this.consequenceOfProcedure, that.consequenceOfProcedure) &&
			Objects.equals(this.consentOnProcedure, that.consentOnProcedure) &&
			Objects.equals(
			     this.consentDateTime != null ? this.consentDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.consentDateTime != null ? that.consentDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.informingStaffSignature, that.informingStaffSignature) &&
			Objects.equals(this.consentingPartySignature, that.consentingPartySignature) &&
			Objects.equals(this.consentingPartyType, that.consentingPartyType) &&
			Objects.equals(this.consentingPartyName, that.consentingPartyName) &&
			Objects.equals(this.witnessSignature1, that.witnessSignature1) &&
			Objects.equals(this.witnessName1, that.witnessName1) &&
			Objects.equals(this.witnessSignature2, that.witnessSignature2) &&
			Objects.equals(this.witnessName2, that.witnessName2) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.accompanyingStaffId, that.accompanyingStaffId) &&
			Objects.equals(this.patientGeneralInfoId, that.patientGeneralInfoId) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.informingStaffId, that.informingStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
