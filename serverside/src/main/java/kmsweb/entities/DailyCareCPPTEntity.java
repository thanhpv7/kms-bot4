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
import kmsweb.dtos.DailyCareCPPTEntityDto;
import kmsweb.entities.listeners.DailyCareCPPTEntityListener;
import kmsweb.serializers.DailyCareCPPTSerializer;
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
@EntityListeners({DailyCareCPPTEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DailyCareCPPTSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DailyCareCPPTEntity extends AbstractEntity {

	/**
	 * Takes a DailyCareCPPTEntityDto and converts it into a DailyCareCPPTEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param dailyCareCPPTEntityDto
	 */
	public DailyCareCPPTEntity(DailyCareCPPTEntityDto dailyCareCPPTEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (dailyCareCPPTEntityDto.getId() != null) {
			this.setId(dailyCareCPPTEntityDto.getId());
		}

		if (dailyCareCPPTEntityDto.getSubjective() != null) {
			this.setSubjective(dailyCareCPPTEntityDto.getSubjective());
		}

		if (dailyCareCPPTEntityDto.getObjective() != null) {
			this.setObjective(dailyCareCPPTEntityDto.getObjective());
		}

		if (dailyCareCPPTEntityDto.getDiagnose() != null) {
			this.setDiagnose(dailyCareCPPTEntityDto.getDiagnose());
		}

		if (dailyCareCPPTEntityDto.getPlan() != null) {
			this.setPlan(dailyCareCPPTEntityDto.getPlan());
		}

		if (dailyCareCPPTEntityDto.getInstruction() != null) {
			this.setInstruction(dailyCareCPPTEntityDto.getInstruction());
		}

		if (dailyCareCPPTEntityDto.getVerifiedDate() != null) {
			this.setVerifiedDate(dailyCareCPPTEntityDto.getVerifiedDate());
		}

		if (dailyCareCPPTEntityDto.getVerifiedBy() != null) {
			this.setVerifiedBy(dailyCareCPPTEntityDto.getVerifiedBy());
		}

		if (dailyCareCPPTEntityDto.getCanceledDate() != null) {
			this.setCanceledDate(dailyCareCPPTEntityDto.getCanceledDate());
		}

		if (dailyCareCPPTEntityDto.getCanceledBy() != null) {
			this.setCanceledBy(dailyCareCPPTEntityDto.getCanceledBy());
		}

		if (dailyCareCPPTEntityDto.getStatus() != null) {
			this.setStatus(dailyCareCPPTEntityDto.getStatus());
		}

		if (dailyCareCPPTEntityDto.getCpptDateTime() != null) {
			this.setCpptDateTime(dailyCareCPPTEntityDto.getCpptDateTime());
		}

		if (dailyCareCPPTEntityDto.getIcd10() != null) {
			this.setIcd10(dailyCareCPPTEntityDto.getIcd10());
		}

		if (dailyCareCPPTEntityDto.getIcd9CM() != null) {
			this.setIcd9CM(dailyCareCPPTEntityDto.getIcd9CM());
		}

		if (dailyCareCPPTEntityDto.getCreatedByStaff() != null) {
			this.setCreatedByStaff(dailyCareCPPTEntityDto.getCreatedByStaff());
		}

		if (dailyCareCPPTEntityDto.getDoctorInCharge() != null) {
			this.setDoctorInCharge(dailyCareCPPTEntityDto.getDoctorInCharge());
		}

		if (dailyCareCPPTEntityDto.getMedicalTranscriber() != null) {
			this.setMedicalTranscriber(dailyCareCPPTEntityDto.getMedicalTranscriber());
		}

		if (dailyCareCPPTEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(dailyCareCPPTEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Subjective here] off begin
	@CsvBindByName(column = "SUBJECTIVE", required = true)
	@NotNull(message = "Subjective must not be empty")
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "subjective")
	@Schema(description = "The Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Subjective here] end
	private String subjective;

	// % protected region % [Modify attribute annotation for Objective here] off begin
	@CsvBindByName(column = "OBJECTIVE", required = true)
	@NotNull(message = "Objective must not be empty")
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "objective")
	@Schema(description = "The Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Objective here] end
	private String objective;

	// % protected region % [Modify attribute annotation for Diagnose here] off begin
	@CsvBindByName(column = "DIAGNOSE", required = true)
	@NotNull(message = "Diagnose must not be empty")
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "diagnose")
	@Schema(description = "The Diagnose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnose here] end
	private String diagnose;

	// % protected region % [Modify attribute annotation for Plan here] off begin
	@CsvBindByName(column = "PLAN", required = true)
	@NotNull(message = "Plan must not be empty")
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "plan")
	@Schema(description = "The Plan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Plan here] end
	private String plan;

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@CsvBindByName(column = "INSTRUCTION", required = true)
	@NotNull(message = "Instruction must not be empty")
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "instruction")
	@Schema(description = "The Instruction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

	// % protected region % [Modify attribute annotation for Verified Date here] off begin

	@CsvCustomBindByName(column = "VERIFIED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "verified_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Verified Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Verified Date here] end
	private OffsetDateTime verifiedDate;

	// % protected region % [Modify attribute annotation for Verified By here] off begin
	@CsvBindByName(column = "VERIFIED_BY", required = false)
	@Nullable
	@Column(name = "verified_by")
	@Schema(description = "The Verified By of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Verified By here] end
	private String verifiedBy;

	// % protected region % [Modify attribute annotation for Canceled Date here] off begin

	@CsvCustomBindByName(column = "CANCELED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "canceled_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Canceled Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Canceled Date here] end
	private OffsetDateTime canceledDate;

	// % protected region % [Modify attribute annotation for Canceled By here] off begin
	@CsvBindByName(column = "CANCELED_BY", required = false)
	@Nullable
	@Column(name = "canceled_by")
	@Schema(description = "The Canceled By of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Canceled By here] end
	private String canceledBy;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for CPPT Date Time here] off begin

	@CsvCustomBindByName(column = "CPPT_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "cppt_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The CPPT Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for CPPT Date Time here] end
	private OffsetDateTime cpptDateTime;

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

	// % protected region % [Update the annotation for Created By Staff here] off begin
	@Schema(description = "The Created By Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Created By Staff here] end
	private StaffEntity createdByStaff;

	// % protected region % [Update the annotation for createdByStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CREATED_BY_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for createdByStaffId here] end
	private UUID createdByStaffId;

	// % protected region % [Update the annotation for Doctor in Charge here] off begin
	@Schema(description = "The Doctor in Charge entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Doctor in Charge here] end
	private StaffEntity doctorInCharge;

	// % protected region % [Update the annotation for doctorInChargeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DOCTOR_IN_CHARGE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for doctorInChargeId here] end
	private UUID doctorInChargeId;

	// % protected region % [Update the annotation for Medical Transcriber here] off begin
	@Schema(description = "The Medical Transcriber entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Transcriber here] end
	private StaffEntity medicalTranscriber;

	// % protected region % [Update the annotation for medicalTranscriberId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_TRANSCRIBER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalTranscriberId here] end
	private UUID medicalTranscriberId;

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
			this.icd10.removeCpptICD10(this, false);
		}
		this.icd10 = entity;
		if (reverseAdd) {
			this.icd10.addCpptICD10(this, false);
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
			this.icd10.removeCpptICD10(this, false);
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
			this.icd9CM.removeCpptICD9CM(this, false);
		}
		this.icd9CM = entity;
		if (reverseAdd) {
			this.icd9CM.addCpptICD9CM(this, false);
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
			this.icd9CM.removeCpptICD9CM(this, false);
		}
		this.icd9CM = null;
	}
	/**
	 * Similar to {@link this#setCreatedByStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setCreatedByStaff(@NotNull StaffEntity entity) {
		setCreatedByStaff(entity, true);
	}

	/**
	 * Set or update the createdByStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to createdByStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCreatedByStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCreatedByStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCreatedByStaff here] end

		if (sameAsFormer(this.createdByStaff, entity)) {
			return;
		}

		if (this.createdByStaff != null) {
			this.createdByStaff.removeDailyCareCPPTsCreatedByStaff(this, false);
		}
		this.createdByStaff = entity;
		if (reverseAdd) {
			this.createdByStaff.addDailyCareCPPTsCreatedByStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCreatedByStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCreatedByStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCreatedByStaff(boolean)} but default to true.
	 */
	public void unsetCreatedByStaff() {
		this.unsetCreatedByStaff(true);
	}

	/**
	 * Remove Created By Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCreatedByStaff(boolean reverse) {
		if (reverse && this.createdByStaff != null) {
			this.createdByStaff.removeDailyCareCPPTsCreatedByStaff(this, false);
		}
		this.createdByStaff = null;
	}
	/**
	 * Similar to {@link this#setDoctorInCharge(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDoctorInCharge(@NotNull StaffEntity entity) {
		setDoctorInCharge(entity, true);
	}

	/**
	 * Set or update the doctorInCharge in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to doctorInCharge
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDoctorInCharge(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDoctorInCharge here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDoctorInCharge here] end

		if (sameAsFormer(this.doctorInCharge, entity)) {
			return;
		}

		if (this.doctorInCharge != null) {
			this.doctorInCharge.removeDailyCareCPPTsDoctorInCharge(this, false);
		}
		this.doctorInCharge = entity;
		if (reverseAdd) {
			this.doctorInCharge.addDailyCareCPPTsDoctorInCharge(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDoctorInCharge incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDoctorInCharge incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDoctorInCharge(boolean)} but default to true.
	 */
	public void unsetDoctorInCharge() {
		this.unsetDoctorInCharge(true);
	}

	/**
	 * Remove Doctor in Charge in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDoctorInCharge(boolean reverse) {
		if (reverse && this.doctorInCharge != null) {
			this.doctorInCharge.removeDailyCareCPPTsDoctorInCharge(this, false);
		}
		this.doctorInCharge = null;
	}
	/**
	 * Similar to {@link this#setMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalTranscriber(@NotNull StaffEntity entity) {
		setMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the medicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalTranscriber(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] end

		if (sameAsFormer(this.medicalTranscriber, entity)) {
			return;
		}

		if (this.medicalTranscriber != null) {
			this.medicalTranscriber.removeDailyCareCPPTsMedicalTranscriber(this, false);
		}
		this.medicalTranscriber = entity;
		if (reverseAdd) {
			this.medicalTranscriber.addDailyCareCPPTsMedicalTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetMedicalTranscriber() {
		this.unsetMedicalTranscriber(true);
	}

	/**
	 * Remove Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalTranscriber(boolean reverse) {
		if (reverse && this.medicalTranscriber != null) {
			this.medicalTranscriber.removeDailyCareCPPTsMedicalTranscriber(this, false);
		}
		this.medicalTranscriber = null;
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
			this.medicalExaminationRecord.removeDailyCareCPPTs(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addDailyCareCPPTs(this, false);
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
			this.medicalExaminationRecord.removeDailyCareCPPTs(this, false);
		}
		this.medicalExaminationRecord = null;
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
		return "SUBJECTIVE,OBJECTIVE,DIAGNOSE,PLAN,INSTRUCTION,VERIFIED_DATE,VERIFIED_BY,CANCELED_DATE,CANCELED_BY,STATUS,CPPT_DATE_TIME,ICD_10_ID,ICD_9_CM_ID,CREATED_BY_STAFF_ID,DOCTOR_IN_CHARGE_ID,MEDICAL_TRANSCRIBER_ID,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<DiagnosesAndProceduresEntity> icd10Relation = Optional.ofNullable(this.icd10);
		icd10Relation.ifPresent(entity -> this.icd10Id = entity.getId());

		Optional<DiagnosesAndProceduresEntity> icd9CMRelation = Optional.ofNullable(this.icd9CM);
		icd9CMRelation.ifPresent(entity -> this.icd9CMId = entity.getId());

		Optional<StaffEntity> createdByStaffRelation = Optional.ofNullable(this.createdByStaff);
		createdByStaffRelation.ifPresent(entity -> this.createdByStaffId = entity.getId());

		Optional<StaffEntity> doctorInChargeRelation = Optional.ofNullable(this.doctorInCharge);
		doctorInChargeRelation.ifPresent(entity -> this.doctorInChargeId = entity.getId());

		Optional<StaffEntity> medicalTranscriberRelation = Optional.ofNullable(this.medicalTranscriber);
		medicalTranscriberRelation.ifPresent(entity -> this.medicalTranscriberId = entity.getId());

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object dailyCareCPPT) {
		if (this == dailyCareCPPT) {
			return true;
		}
		if (dailyCareCPPT == null || this.getClass() != dailyCareCPPT.getClass()) {
			return false;
		}
		if (!super.equals(dailyCareCPPT)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DailyCareCPPTEntity that = (DailyCareCPPTEntity) dailyCareCPPT;
		return
			Objects.equals(this.subjective, that.subjective) &&
			Objects.equals(this.objective, that.objective) &&
			Objects.equals(this.diagnose, that.diagnose) &&
			Objects.equals(this.plan, that.plan) &&
			Objects.equals(this.instruction, that.instruction) &&
			Objects.equals(
			     this.verifiedDate != null ? this.verifiedDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.verifiedDate != null ? that.verifiedDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.verifiedBy, that.verifiedBy) &&
			Objects.equals(
			     this.canceledDate != null ? this.canceledDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.canceledDate != null ? that.canceledDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.canceledBy, that.canceledBy) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(
			     this.cpptDateTime != null ? this.cpptDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.cpptDateTime != null ? that.cpptDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.icd10Id, that.icd10Id) &&
			Objects.equals(this.icd9CMId, that.icd9CMId) &&
			Objects.equals(this.createdByStaffId, that.createdByStaffId) &&
			Objects.equals(this.doctorInChargeId, that.doctorInChargeId) &&
			Objects.equals(this.medicalTranscriberId, that.medicalTranscriberId) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
