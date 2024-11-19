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
import kmsweb.dtos.MedicalCertificatePhysicalHealthEntityDto;
import kmsweb.entities.listeners.MedicalCertificatePhysicalHealthEntityListener;
import kmsweb.serializers.MedicalCertificatePhysicalHealthSerializer;
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
@EntityListeners({MedicalCertificatePhysicalHealthEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalCertificatePhysicalHealthSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalCertificatePhysicalHealthEntity extends AbstractEntity {

	/**
	 * Takes a MedicalCertificatePhysicalHealthEntityDto and converts it into a MedicalCertificatePhysicalHealthEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalCertificatePhysicalHealthEntityDto
	 */
	public MedicalCertificatePhysicalHealthEntity(MedicalCertificatePhysicalHealthEntityDto medicalCertificatePhysicalHealthEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalCertificatePhysicalHealthEntityDto.getId() != null) {
			this.setId(medicalCertificatePhysicalHealthEntityDto.getId());
		}

		if (medicalCertificatePhysicalHealthEntityDto.getExaminationDateTime() != null) {
			this.setExaminationDateTime(medicalCertificatePhysicalHealthEntityDto.getExaminationDateTime());
		}

		if (medicalCertificatePhysicalHealthEntityDto.getExaminationResult() != null) {
			this.setExaminationResult(medicalCertificatePhysicalHealthEntityDto.getExaminationResult());
		}

		if (medicalCertificatePhysicalHealthEntityDto.getNotes() != null) {
			this.setNotes(medicalCertificatePhysicalHealthEntityDto.getNotes());
		}

		if (medicalCertificatePhysicalHealthEntityDto.getPurpose() != null) {
			this.setPurpose(medicalCertificatePhysicalHealthEntityDto.getPurpose());
		}

		if (medicalCertificatePhysicalHealthEntityDto.getRegistration() != null) {
			this.setRegistration(medicalCertificatePhysicalHealthEntityDto.getRegistration());
		}

		if (medicalCertificatePhysicalHealthEntityDto.getMedicalStaff() != null) {
			this.setMedicalStaff(medicalCertificatePhysicalHealthEntityDto.getMedicalStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Examination Date Time here] off begin
	@CsvCustomBindByName(column = "EXAMINATION_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "examination_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Examination Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Examination Date Time here] end
	private OffsetDateTime examinationDateTime;

	// % protected region % [Modify attribute annotation for Examination Result here] off begin
	@CsvBindByName(column = "EXAMINATION_RESULT", required = false)
	@Nullable
	@Column(name = "examination_result")
	@Schema(description = "The Examination Result of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Examination Result here] end
	private Boolean examinationResult = false ;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@CsvBindByName(column = "PURPOSE", required = false)
	@Nullable
	@Column(name = "purpose")
	@Schema(description = "The Purpose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

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
			this.registration.unsetMedicalCertificatePhysicalHealth(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setMedicalCertificatePhysicalHealth(this, false);
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
			this.registration.unsetMedicalCertificatePhysicalHealth();
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
			this.medicalStaff.removeMedicalStaffOfPhysicalHealths(this, false);
		}
		this.medicalStaff = entity;
		if (reverseAdd) {
			this.medicalStaff.addMedicalStaffOfPhysicalHealths(this, false);
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
			this.medicalStaff.removeMedicalStaffOfPhysicalHealths(this, false);
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
		return "EXAMINATION_DATE_TIME,EXAMINATION_RESULT,NOTES,PURPOSE,REGISTRATION_ID,MEDICAL_STAFF_ID,ID";
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
	public boolean equals(Object medicalCertificatePhysicalHealth) {
		if (this == medicalCertificatePhysicalHealth) {
			return true;
		}
		if (medicalCertificatePhysicalHealth == null || this.getClass() != medicalCertificatePhysicalHealth.getClass()) {
			return false;
		}
		if (!super.equals(medicalCertificatePhysicalHealth)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalCertificatePhysicalHealthEntity that = (MedicalCertificatePhysicalHealthEntity) medicalCertificatePhysicalHealth;
		return
			Objects.equals(
			     this.examinationDateTime != null ? this.examinationDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.examinationDateTime != null ? that.examinationDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.examinationResult, that.examinationResult) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.purpose, that.purpose) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.medicalStaffId, that.medicalStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
