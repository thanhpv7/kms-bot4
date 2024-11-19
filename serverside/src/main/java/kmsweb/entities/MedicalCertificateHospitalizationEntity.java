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
import kmsweb.dtos.MedicalCertificateHospitalizationEntityDto;
import kmsweb.entities.listeners.MedicalCertificateHospitalizationEntityListener;
import kmsweb.serializers.MedicalCertificateHospitalizationSerializer;
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
@EntityListeners({MedicalCertificateHospitalizationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalCertificateHospitalizationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalCertificateHospitalizationEntity extends AbstractEntity {

	/**
	 * Takes a MedicalCertificateHospitalizationEntityDto and converts it into a MedicalCertificateHospitalizationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalCertificateHospitalizationEntityDto
	 */
	public MedicalCertificateHospitalizationEntity(MedicalCertificateHospitalizationEntityDto medicalCertificateHospitalizationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalCertificateHospitalizationEntityDto.getId() != null) {
			this.setId(medicalCertificateHospitalizationEntityDto.getId());
		}

		if (medicalCertificateHospitalizationEntityDto.getAdmissionDateTime() != null) {
			this.setAdmissionDateTime(medicalCertificateHospitalizationEntityDto.getAdmissionDateTime());
		}

		if (medicalCertificateHospitalizationEntityDto.getDischargeDateTime() != null) {
			this.setDischargeDateTime(medicalCertificateHospitalizationEntityDto.getDischargeDateTime());
		}

		if (medicalCertificateHospitalizationEntityDto.getNotes() != null) {
			this.setNotes(medicalCertificateHospitalizationEntityDto.getNotes());
		}

		if (medicalCertificateHospitalizationEntityDto.getRegistration() != null) {
			this.setRegistration(medicalCertificateHospitalizationEntityDto.getRegistration());
		}

		if (medicalCertificateHospitalizationEntityDto.getMedicalStaff() != null) {
			this.setMedicalStaff(medicalCertificateHospitalizationEntityDto.getMedicalStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Admission Date Time here] off begin
	@CsvCustomBindByName(column = "ADMISSION_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "admission_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Admission Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Admission Date Time here] end
	private OffsetDateTime admissionDateTime;

	// % protected region % [Modify attribute annotation for Discharge Date Time here] off begin
	@CsvCustomBindByName(column = "DISCHARGE_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "discharge_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Discharge Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discharge Date Time here] end
	private OffsetDateTime dischargeDateTime;

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

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	// % protected region % [Update the annotation for Medical Staff here] off begin
	@Schema(description = "The Medical Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff here] end
	private StaffEntity medicalStaff;

	// % protected region % [Update the annotation for medicalStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalStaffId here] end
	private UUID medicalStaffId;

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
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetMedicalCertificateHospitalization(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setMedicalCertificateHospitalization(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetMedicalCertificateHospitalization();
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalStaff(@NotNull StaffEntity entity) {
		setMedicalStaff(entity, true);
	}

	/**
	 * Set or update the medicalStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] end

		if (sameAsFormer(this.medicalStaff, entity)) {
			return;
		}

		if (this.medicalStaff != null) {
			this.medicalStaff.removeMedicalCertificateHospitalizations(this, false);
		}
		this.medicalStaff = entity;
		if (reverseAdd) {
			this.medicalStaff.addMedicalCertificateHospitalizations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalStaff(boolean)} but default to true.
	 */
	public void unsetMedicalStaff() {
		this.unsetMedicalStaff(true);
	}

	/**
	 * Remove Medical Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalStaff(boolean reverse) {
		if (reverse && this.medicalStaff != null) {
			this.medicalStaff.removeMedicalCertificateHospitalizations(this, false);
		}
		this.medicalStaff = null;
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
		return "ADMISSION_DATE_TIME,DISCHARGE_DATE_TIME,NOTES,REGISTRATION_ID,MEDICAL_STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<StaffEntity> medicalStaffRelation = Optional.ofNullable(this.medicalStaff);
		medicalStaffRelation.ifPresent(entity -> this.medicalStaffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicalCertificateHospitalization) {
		if (this == medicalCertificateHospitalization) {
			return true;
		}
		if (medicalCertificateHospitalization == null || this.getClass() != medicalCertificateHospitalization.getClass()) {
			return false;
		}
		if (!super.equals(medicalCertificateHospitalization)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalCertificateHospitalizationEntity that = (MedicalCertificateHospitalizationEntity) medicalCertificateHospitalization;
		return
			Objects.equals(
			     this.admissionDateTime != null ? this.admissionDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.admissionDateTime != null ? that.admissionDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.dischargeDateTime != null ? this.dischargeDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dischargeDateTime != null ? that.dischargeDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.medicalStaffId, that.medicalStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
