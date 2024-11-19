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
import kmsweb.dtos.DiagnosticStaffExaminationSummaryEntityDto;
import kmsweb.entities.listeners.DiagnosticStaffExaminationSummaryEntityListener;
import kmsweb.serializers.DiagnosticStaffExaminationSummarySerializer;
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
@EntityListeners({DiagnosticStaffExaminationSummaryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DiagnosticStaffExaminationSummarySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DiagnosticStaffExaminationSummaryEntity extends AbstractEntity {

	/**
	 * Takes a DiagnosticStaffExaminationSummaryEntityDto and converts it into a DiagnosticStaffExaminationSummaryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param diagnosticStaffExaminationSummaryEntityDto
	 */
	public DiagnosticStaffExaminationSummaryEntity(DiagnosticStaffExaminationSummaryEntityDto diagnosticStaffExaminationSummaryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (diagnosticStaffExaminationSummaryEntityDto.getId() != null) {
			this.setId(diagnosticStaffExaminationSummaryEntityDto.getId());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getResponsibleDoctor() != null) {
			this.setResponsibleDoctor(diagnosticStaffExaminationSummaryEntityDto.getResponsibleDoctor());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getMedicalTranscriber() != null) {
			this.setMedicalTranscriber(diagnosticStaffExaminationSummaryEntityDto.getMedicalTranscriber());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getReferringRoom() != null) {
			this.setReferringRoom(diagnosticStaffExaminationSummaryEntityDto.getReferringRoom());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getReferingUnit() != null) {
			this.setReferingUnit(diagnosticStaffExaminationSummaryEntityDto.getReferingUnit());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getExaminationLocation() != null) {
			this.setExaminationLocation(diagnosticStaffExaminationSummaryEntityDto.getExaminationLocation());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getAdditionalNotes() != null) {
			this.setAdditionalNotes(diagnosticStaffExaminationSummaryEntityDto.getAdditionalNotes());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getConclusion() != null) {
			this.setConclusion(diagnosticStaffExaminationSummaryEntityDto.getConclusion());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getRegistration() != null) {
			this.setRegistration(diagnosticStaffExaminationSummaryEntityDto.getRegistration());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getStaff() != null) {
			this.setStaff(diagnosticStaffExaminationSummaryEntityDto.getStaff());
		}

		if (diagnosticStaffExaminationSummaryEntityDto.getDiagnosisExaminationRecord() != null) {
			this.setDiagnosisExaminationRecord(diagnosticStaffExaminationSummaryEntityDto.getDiagnosisExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Responsible Doctor here] off begin
	@CsvBindByName(column = "RESPONSIBLE_DOCTOR", required = false)
	@Nullable
	@Column(name = "responsible_doctor")
	@Schema(description = "The Responsible Doctor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Responsible Doctor here] end
	private String responsibleDoctor;

	// % protected region % [Modify attribute annotation for Medical Transcriber here] off begin
	@CsvBindByName(column = "MEDICAL_TRANSCRIBER", required = false)
	@Nullable
	@Column(name = "medical_transcriber")
	@Schema(description = "The Medical Transcriber of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Transcriber here] end
	private String medicalTranscriber;

	// % protected region % [Modify attribute annotation for Referring Room here] off begin
	@CsvBindByName(column = "REFERRING_ROOM", required = false)
	@Nullable
	@Column(name = "referring_room")
	@Schema(description = "The Referring Room of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referring Room here] end
	private String referringRoom;

	// % protected region % [Modify attribute annotation for Refering Unit here] off begin
	@CsvBindByName(column = "REFERING_UNIT", required = false)
	@Nullable
	@Column(name = "refering_unit")
	@Schema(description = "The Refering Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Refering Unit here] end
	private String referingUnit;

	// % protected region % [Modify attribute annotation for Examination Location here] off begin
	@CsvBindByName(column = "EXAMINATION_LOCATION", required = false)
	@Nullable
	@Column(name = "examination_location")
	@Schema(description = "The Examination Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Examination Location here] end
	private String examinationLocation;

	// % protected region % [Modify attribute annotation for Additional Notes here] off begin
	@CsvBindByName(column = "ADDITIONAL_NOTES", required = false)
	@Nullable
	@Column(name = "additional_notes")
	@Schema(description = "The Additional Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Additional Notes here] end
	private String additionalNotes;

	// % protected region % [Modify attribute annotation for Conclusion here] off begin
	@CsvBindByName(column = "CONCLUSION", required = false)
	@Nullable
	@Column(name = "conclusion")
	@Schema(description = "The Conclusion of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Conclusion here] end
	private String conclusion;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToOne(mappedBy = "diagnosticStaffExaminationSummary", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Update the annotation for Diagnosis Examination Record here] off begin
	@Schema(description = "The Diagnosis Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnosis Examination Record here] end
	private DiagnosisExaminationRecordEntity diagnosisExaminationRecord;

	// % protected region % [Update the annotation for diagnosisExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSIS_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosisExaminationRecordId here] end
	private UUID diagnosisExaminationRecordId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update registration with the given RegistrationEntity.
	 *
	 * @param entity the DiagnosticStaffExaminationSummaryEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetDiagnosticStaffExaminationSummary();
		}

		this.registration = entity;

		if (reverseAdd) {
			this.registration.setDiagnosticStaffExaminationSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity in Registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetDiagnosticStaffExaminationSummary(false);
		}
		this.registration = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.staff.removeDiagnosticStaffExaminationSummaries(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addDiagnosticStaffExaminationSummaries(this, false);
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
			this.staff.removeDiagnosticStaffExaminationSummaries(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity entity) {
		setDiagnosisExaminationRecord(entity, true);
	}

	/**
	 * Set or update the diagnosisExaminationRecord in this entity with single DiagnosisExaminationRecordEntity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set or updated to diagnosisExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosisExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosisExaminationRecord here] end

		if (sameAsFormer(this.diagnosisExaminationRecord, entity)) {
			return;
		}

		if (this.diagnosisExaminationRecord != null) {
			this.diagnosisExaminationRecord.unsetDiagnosticStaffExaminationSummary(false);
		}

		this.diagnosisExaminationRecord = entity;
		if (reverseAdd) {
			this.diagnosisExaminationRecord.setDiagnosticStaffExaminationSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosisExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosisExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosisExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDiagnosisExaminationRecord() {
		this.unsetDiagnosisExaminationRecord(true);
	}

	/**
	 * Remove the DiagnosisExaminationRecordEntity of diagnosisExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosisExaminationRecord(boolean reverse) {
		if (reverse && this.diagnosisExaminationRecord != null) {
			this.diagnosisExaminationRecord.unsetDiagnosticStaffExaminationSummary();
		}
		this.diagnosisExaminationRecord = null;
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
		return "RESPONSIBLE_DOCTOR,MEDICAL_TRANSCRIBER,REFERRING_ROOM,REFERING_UNIT,EXAMINATION_LOCATION,ADDITIONAL_NOTES,CONCLUSION,STAFF_ID,DIAGNOSIS_EXAMINATION_RECORD_ID,REGISTRATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		Optional<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordRelation = Optional.ofNullable(this.diagnosisExaminationRecord);
		diagnosisExaminationRecordRelation.ifPresent(entity -> this.diagnosisExaminationRecordId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object diagnosticStaffExaminationSummary) {
		if (this == diagnosticStaffExaminationSummary) {
			return true;
		}
		if (diagnosticStaffExaminationSummary == null || this.getClass() != diagnosticStaffExaminationSummary.getClass()) {
			return false;
		}
		if (!super.equals(diagnosticStaffExaminationSummary)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DiagnosticStaffExaminationSummaryEntity that = (DiagnosticStaffExaminationSummaryEntity) diagnosticStaffExaminationSummary;
		return
			Objects.equals(this.responsibleDoctor, that.responsibleDoctor) &&
			Objects.equals(this.medicalTranscriber, that.medicalTranscriber) &&
			Objects.equals(this.referringRoom, that.referringRoom) &&
			Objects.equals(this.referingUnit, that.referingUnit) &&
			Objects.equals(this.examinationLocation, that.examinationLocation) &&
			Objects.equals(this.additionalNotes, that.additionalNotes) &&
			Objects.equals(this.conclusion, that.conclusion) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.staffId, that.staffId) &&
			Objects.equals(this.diagnosisExaminationRecordId, that.diagnosisExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
