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
import kmsweb.dtos.CoTreatingDoctorEntityDto;
import kmsweb.entities.listeners.CoTreatingDoctorEntityListener;
import kmsweb.serializers.CoTreatingDoctorSerializer;
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
@EntityListeners({CoTreatingDoctorEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CoTreatingDoctorSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CoTreatingDoctorEntity extends AbstractEntity {

	/**
	 * Takes a CoTreatingDoctorEntityDto and converts it into a CoTreatingDoctorEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param coTreatingDoctorEntityDto
	 */
	public CoTreatingDoctorEntity(CoTreatingDoctorEntityDto coTreatingDoctorEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (coTreatingDoctorEntityDto.getId() != null) {
			this.setId(coTreatingDoctorEntityDto.getId());
		}

		if (coTreatingDoctorEntityDto.getDoctorNotes() != null) {
			this.setDoctorNotes(coTreatingDoctorEntityDto.getDoctorNotes());
		}

		if (coTreatingDoctorEntityDto.getAdditionalAnesthesiologist() != null) {
			this.setAdditionalAnesthesiologist(coTreatingDoctorEntityDto.getAdditionalAnesthesiologist());
		}

		if (coTreatingDoctorEntityDto.getAdditionalMidwife() != null) {
			this.setAdditionalMidwife(coTreatingDoctorEntityDto.getAdditionalMidwife());
		}

		if (coTreatingDoctorEntityDto.getAdditionalSurgeryNurse() != null) {
			this.setAdditionalSurgeryNurse(coTreatingDoctorEntityDto.getAdditionalSurgeryNurse());
		}

		if (coTreatingDoctorEntityDto.getCoTreatingAnesthesiologist() != null) {
			this.setCoTreatingAnesthesiologist(coTreatingDoctorEntityDto.getCoTreatingAnesthesiologist());
		}

		if (coTreatingDoctorEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(coTreatingDoctorEntityDto.getMedicalExaminationRecord());
		}

		if (coTreatingDoctorEntityDto.getStaff() != null) {
			this.setStaff(coTreatingDoctorEntityDto.getStaff());
		}

		if (coTreatingDoctorEntityDto.getCoTreatingSurgeon() != null) {
			this.setCoTreatingSurgeon(coTreatingDoctorEntityDto.getCoTreatingSurgeon());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Doctor Notes here] off begin
	@CsvBindByName(column = "DOCTOR_NOTES", required = false)
	@Nullable
	@Lob
	@Column(name = "doctor_notes")
	@Schema(description = "The Doctor Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Doctor Notes here] end
	private String doctorNotes;

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

	// % protected region % [Update the annotation for Additional Anesthesiologist here] off begin
	@Schema(description = "The Additional Anesthesiologist entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Anesthesiologist here] end
	private PreoperativeRecordsEntity additionalAnesthesiologist;

	// % protected region % [Update the annotation for additionalAnesthesiologistId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_ANESTHESIOLOGIST_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for additionalAnesthesiologistId here] end
	private UUID additionalAnesthesiologistId;

	// % protected region % [Update the annotation for Additional Midwife here] off begin
	@Schema(description = "The Additional Midwife entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Midwife here] end
	private DeliveryMedicalExaminationRecordEntity additionalMidwife;

	// % protected region % [Update the annotation for additionalMidwifeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_MIDWIFE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for additionalMidwifeId here] end
	private UUID additionalMidwifeId;

	// % protected region % [Update the annotation for Additional Surgery Nurse here] off begin
	@Schema(description = "The Additional Surgery Nurse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Surgery Nurse here] end
	private PreoperativeRecordsEntity additionalSurgeryNurse;

	// % protected region % [Update the annotation for additionalSurgeryNurseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_SURGERY_NURSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for additionalSurgeryNurseId here] end
	private UUID additionalSurgeryNurseId;

	// % protected region % [Update the annotation for Co Treating Anesthesiologist here] off begin
	@Schema(description = "The Co Treating Anesthesiologist entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Co Treating Anesthesiologist here] end
	private PreoperativeRecordsEntity coTreatingAnesthesiologist;

	// % protected region % [Update the annotation for coTreatingAnesthesiologistId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CO_TREATING_ANESTHESIOLOGIST_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for coTreatingAnesthesiologistId here] end
	private UUID coTreatingAnesthesiologistId;

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

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

	// % protected region % [Update the annotation for Co Treating Surgeon here] off begin
	@Schema(description = "The Co Treating Surgeon entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Co Treating Surgeon here] end
	private PreoperativeRecordsEntity coTreatingSurgeon;

	// % protected region % [Update the annotation for coTreatingSurgeonId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CO_TREATING_SURGEON_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for coTreatingSurgeonId here] end
	private UUID coTreatingSurgeonId;

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
	 * Similar to {@link this#setAdditionalAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAdditionalAnesthesiologist(@NotNull PreoperativeRecordsEntity entity) {
		setAdditionalAnesthesiologist(entity, true);
	}

	/**
	 * Set or update the additionalAnesthesiologist in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to additionalAnesthesiologist
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalAnesthesiologist(@NotNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalAnesthesiologist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalAnesthesiologist here] end

		if (sameAsFormer(this.additionalAnesthesiologist, entity)) {
			return;
		}

		if (this.additionalAnesthesiologist != null) {
			this.additionalAnesthesiologist.removeAdditionalAnesthesiologists(this, false);
		}
		this.additionalAnesthesiologist = entity;
		if (reverseAdd) {
			this.additionalAnesthesiologist.addAdditionalAnesthesiologists(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalAnesthesiologist incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalAnesthesiologist incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalAnesthesiologist(boolean)} but default to true.
	 */
	public void unsetAdditionalAnesthesiologist() {
		this.unsetAdditionalAnesthesiologist(true);
	}

	/**
	 * Remove Additional Anesthesiologist in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalAnesthesiologist(boolean reverse) {
		if (reverse && this.additionalAnesthesiologist != null) {
			this.additionalAnesthesiologist.removeAdditionalAnesthesiologists(this, false);
		}
		this.additionalAnesthesiologist = null;
	}
	/**
	 * Similar to {@link this#setAdditionalMidwife(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setAdditionalMidwife(@NotNull DeliveryMedicalExaminationRecordEntity entity) {
		setAdditionalMidwife(entity, true);
	}

	/**
	 * Set or update the additionalMidwife in this entity with single DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set or updated to additionalMidwife
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalMidwife(@NotNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalMidwife here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalMidwife here] end

		if (sameAsFormer(this.additionalMidwife, entity)) {
			return;
		}

		if (this.additionalMidwife != null) {
			this.additionalMidwife.removeAdditionalMidwives(this, false);
		}
		this.additionalMidwife = entity;
		if (reverseAdd) {
			this.additionalMidwife.addAdditionalMidwives(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalMidwife incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalMidwife incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalMidwife(boolean)} but default to true.
	 */
	public void unsetAdditionalMidwife() {
		this.unsetAdditionalMidwife(true);
	}

	/**
	 * Remove Additional Midwife in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalMidwife(boolean reverse) {
		if (reverse && this.additionalMidwife != null) {
			this.additionalMidwife.removeAdditionalMidwives(this, false);
		}
		this.additionalMidwife = null;
	}
	/**
	 * Similar to {@link this#setAdditionalSurgeryNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAdditionalSurgeryNurse(@NotNull PreoperativeRecordsEntity entity) {
		setAdditionalSurgeryNurse(entity, true);
	}

	/**
	 * Set or update the additionalSurgeryNurse in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to additionalSurgeryNurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalSurgeryNurse(@NotNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalSurgeryNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalSurgeryNurse here] end

		if (sameAsFormer(this.additionalSurgeryNurse, entity)) {
			return;
		}

		if (this.additionalSurgeryNurse != null) {
			this.additionalSurgeryNurse.removeAdditionalSurgeryNurses(this, false);
		}
		this.additionalSurgeryNurse = entity;
		if (reverseAdd) {
			this.additionalSurgeryNurse.addAdditionalSurgeryNurses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalSurgeryNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalSurgeryNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalSurgeryNurse(boolean)} but default to true.
	 */
	public void unsetAdditionalSurgeryNurse() {
		this.unsetAdditionalSurgeryNurse(true);
	}

	/**
	 * Remove Additional Surgery Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalSurgeryNurse(boolean reverse) {
		if (reverse && this.additionalSurgeryNurse != null) {
			this.additionalSurgeryNurse.removeAdditionalSurgeryNurses(this, false);
		}
		this.additionalSurgeryNurse = null;
	}
	/**
	 * Similar to {@link this#setCoTreatingAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setCoTreatingAnesthesiologist(@NotNull PreoperativeRecordsEntity entity) {
		setCoTreatingAnesthesiologist(entity, true);
	}

	/**
	 * Set or update the coTreatingAnesthesiologist in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to coTreatingAnesthesiologist
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCoTreatingAnesthesiologist(@NotNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingAnesthesiologist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingAnesthesiologist here] end

		if (sameAsFormer(this.coTreatingAnesthesiologist, entity)) {
			return;
		}

		if (this.coTreatingAnesthesiologist != null) {
			this.coTreatingAnesthesiologist.removeCoTreatingAnesthesiologists(this, false);
		}
		this.coTreatingAnesthesiologist = entity;
		if (reverseAdd) {
			this.coTreatingAnesthesiologist.addCoTreatingAnesthesiologists(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCoTreatingAnesthesiologist incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCoTreatingAnesthesiologist incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCoTreatingAnesthesiologist(boolean)} but default to true.
	 */
	public void unsetCoTreatingAnesthesiologist() {
		this.unsetCoTreatingAnesthesiologist(true);
	}

	/**
	 * Remove Co Treating Anesthesiologist in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCoTreatingAnesthesiologist(boolean reverse) {
		if (reverse && this.coTreatingAnesthesiologist != null) {
			this.coTreatingAnesthesiologist.removeCoTreatingAnesthesiologists(this, false);
		}
		this.coTreatingAnesthesiologist = null;
	}
	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.removeCoTreatingDoctors(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addCoTreatingDoctors(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove Medical Examination Record in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.removeCoTreatingDoctors(this, false);
		}
		this.medicalExaminationRecord = null;
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
			this.staff.removeCoTreatingDoctors(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addCoTreatingDoctors(this, false);
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
			this.staff.removeCoTreatingDoctors(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setCoTreatingSurgeon(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setCoTreatingSurgeon(@NotNull PreoperativeRecordsEntity entity) {
		setCoTreatingSurgeon(entity, true);
	}

	/**
	 * Set or update the coTreatingSurgeon in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to coTreatingSurgeon
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCoTreatingSurgeon(@NotNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingSurgeon here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingSurgeon here] end

		if (sameAsFormer(this.coTreatingSurgeon, entity)) {
			return;
		}

		if (this.coTreatingSurgeon != null) {
			this.coTreatingSurgeon.removeCoTreatingSurgeons(this, false);
		}
		this.coTreatingSurgeon = entity;
		if (reverseAdd) {
			this.coTreatingSurgeon.addCoTreatingSurgeons(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCoTreatingSurgeon incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCoTreatingSurgeon incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCoTreatingSurgeon(boolean)} but default to true.
	 */
	public void unsetCoTreatingSurgeon() {
		this.unsetCoTreatingSurgeon(true);
	}

	/**
	 * Remove Co Treating Surgeon in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCoTreatingSurgeon(boolean reverse) {
		if (reverse && this.coTreatingSurgeon != null) {
			this.coTreatingSurgeon.removeCoTreatingSurgeons(this, false);
		}
		this.coTreatingSurgeon = null;
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
		return "DOCTOR_NOTES,ADDITIONAL_ANESTHESIOLOGIST_ID,ADDITIONAL_MIDWIFE_ID,ADDITIONAL_SURGERY_NURSE_ID,CO_TREATING_ANESTHESIOLOGIST_ID,MEDICAL_EXAMINATION_RECORD_ID,STAFF_ID,CO_TREATING_SURGEON_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PreoperativeRecordsEntity> additionalAnesthesiologistRelation = Optional.ofNullable(this.additionalAnesthesiologist);
		additionalAnesthesiologistRelation.ifPresent(entity -> this.additionalAnesthesiologistId = entity.getId());

		Optional<DeliveryMedicalExaminationRecordEntity> additionalMidwifeRelation = Optional.ofNullable(this.additionalMidwife);
		additionalMidwifeRelation.ifPresent(entity -> this.additionalMidwifeId = entity.getId());

		Optional<PreoperativeRecordsEntity> additionalSurgeryNurseRelation = Optional.ofNullable(this.additionalSurgeryNurse);
		additionalSurgeryNurseRelation.ifPresent(entity -> this.additionalSurgeryNurseId = entity.getId());

		Optional<PreoperativeRecordsEntity> coTreatingAnesthesiologistRelation = Optional.ofNullable(this.coTreatingAnesthesiologist);
		coTreatingAnesthesiologistRelation.ifPresent(entity -> this.coTreatingAnesthesiologistId = entity.getId());

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		Optional<PreoperativeRecordsEntity> coTreatingSurgeonRelation = Optional.ofNullable(this.coTreatingSurgeon);
		coTreatingSurgeonRelation.ifPresent(entity -> this.coTreatingSurgeonId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object coTreatingDoctor) {
		if (this == coTreatingDoctor) {
			return true;
		}
		if (coTreatingDoctor == null || this.getClass() != coTreatingDoctor.getClass()) {
			return false;
		}
		if (!super.equals(coTreatingDoctor)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CoTreatingDoctorEntity that = (CoTreatingDoctorEntity) coTreatingDoctor;
		return
			Objects.equals(this.doctorNotes, that.doctorNotes) &&
			Objects.equals(this.additionalAnesthesiologistId, that.additionalAnesthesiologistId) &&
			Objects.equals(this.additionalMidwifeId, that.additionalMidwifeId) &&
			Objects.equals(this.additionalSurgeryNurseId, that.additionalSurgeryNurseId) &&
			Objects.equals(this.coTreatingAnesthesiologistId, that.coTreatingAnesthesiologistId) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.staffId, that.staffId) &&
			Objects.equals(this.coTreatingSurgeonId, that.coTreatingSurgeonId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
