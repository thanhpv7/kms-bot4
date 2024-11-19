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
import kmsweb.dtos.OphthalmologyExaminationEntityDto;
import kmsweb.entities.listeners.OphthalmologyExaminationEntityListener;
import kmsweb.serializers.OphthalmologyExaminationSerializer;
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
@EntityListeners({OphthalmologyExaminationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = OphthalmologyExaminationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class OphthalmologyExaminationEntity extends AbstractEntity {

	/**
	 * Takes a OphthalmologyExaminationEntityDto and converts it into a OphthalmologyExaminationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param ophthalmologyExaminationEntityDto
	 */
	public OphthalmologyExaminationEntity(OphthalmologyExaminationEntityDto ophthalmologyExaminationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (ophthalmologyExaminationEntityDto.getId() != null) {
			this.setId(ophthalmologyExaminationEntityDto.getId());
		}

		if (ophthalmologyExaminationEntityDto.getRightEyelidSubjective() != null) {
			this.setRightEyelidSubjective(ophthalmologyExaminationEntityDto.getRightEyelidSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightEyelidObjective() != null) {
			this.setRightEyelidObjective(ophthalmologyExaminationEntityDto.getRightEyelidObjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightPupilSubjective() != null) {
			this.setRightPupilSubjective(ophthalmologyExaminationEntityDto.getRightPupilSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightPupilObjective() != null) {
			this.setRightPupilObjective(ophthalmologyExaminationEntityDto.getRightPupilObjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightScleraSubjective() != null) {
			this.setRightScleraSubjective(ophthalmologyExaminationEntityDto.getRightScleraSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightScleraObjective() != null) {
			this.setRightScleraObjective(ophthalmologyExaminationEntityDto.getRightScleraObjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightIrisSubjective() != null) {
			this.setRightIrisSubjective(ophthalmologyExaminationEntityDto.getRightIrisSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getRightIrisObjective() != null) {
			this.setRightIrisObjective(ophthalmologyExaminationEntityDto.getRightIrisObjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftEyelidSubjective() != null) {
			this.setLeftEyelidSubjective(ophthalmologyExaminationEntityDto.getLeftEyelidSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftEyelidObjective() != null) {
			this.setLeftEyelidObjective(ophthalmologyExaminationEntityDto.getLeftEyelidObjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftPupilSubjective() != null) {
			this.setLeftPupilSubjective(ophthalmologyExaminationEntityDto.getLeftPupilSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftPupilObjective() != null) {
			this.setLeftPupilObjective(ophthalmologyExaminationEntityDto.getLeftPupilObjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftScleraSubjective() != null) {
			this.setLeftScleraSubjective(ophthalmologyExaminationEntityDto.getLeftScleraSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftScleraObjective() != null) {
			this.setLeftScleraObjective(ophthalmologyExaminationEntityDto.getLeftScleraObjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftIrisSubjective() != null) {
			this.setLeftIrisSubjective(ophthalmologyExaminationEntityDto.getLeftIrisSubjective());
		}

		if (ophthalmologyExaminationEntityDto.getLeftIrisObjective() != null) {
			this.setLeftIrisObjective(ophthalmologyExaminationEntityDto.getLeftIrisObjective());
		}

		if (ophthalmologyExaminationEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(ophthalmologyExaminationEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Right Eyelid Subjective here] off begin
	@CsvBindByName(column = "RIGHT_EYELID_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_eyelid_subjective")
	@Schema(description = "The Right Eyelid Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Eyelid Subjective here] end
	private String rightEyelidSubjective;

	// % protected region % [Modify attribute annotation for Right Eyelid Objective here] off begin
	@CsvBindByName(column = "RIGHT_EYELID_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_eyelid_objective")
	@Schema(description = "The Right Eyelid Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Eyelid Objective here] end
	private String rightEyelidObjective;

	// % protected region % [Modify attribute annotation for Right Pupil Subjective here] off begin
	@CsvBindByName(column = "RIGHT_PUPIL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_pupil_subjective")
	@Schema(description = "The Right Pupil Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Pupil Subjective here] end
	private String rightPupilSubjective;

	// % protected region % [Modify attribute annotation for Right Pupil Objective here] off begin
	@CsvBindByName(column = "RIGHT_PUPIL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_pupil_objective")
	@Schema(description = "The Right Pupil Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Pupil Objective here] end
	private String rightPupilObjective;

	// % protected region % [Modify attribute annotation for Right Sclera Subjective here] off begin
	@CsvBindByName(column = "RIGHT_SCLERA_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_sclera_subjective")
	@Schema(description = "The Right Sclera Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Sclera Subjective here] end
	private String rightScleraSubjective;

	// % protected region % [Modify attribute annotation for Right Sclera Objective here] off begin
	@CsvBindByName(column = "RIGHT_SCLERA_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_sclera_objective")
	@Schema(description = "The Right Sclera Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Sclera Objective here] end
	private String rightScleraObjective;

	// % protected region % [Modify attribute annotation for Right Iris Subjective here] off begin
	@CsvBindByName(column = "RIGHT_IRIS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_iris_subjective")
	@Schema(description = "The Right Iris Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Iris Subjective here] end
	private String rightIrisSubjective;

	// % protected region % [Modify attribute annotation for Right Iris Objective here] off begin
	@CsvBindByName(column = "RIGHT_IRIS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "right_iris_objective")
	@Schema(description = "The Right Iris Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Right Iris Objective here] end
	private String rightIrisObjective;

	// % protected region % [Modify attribute annotation for Left Eyelid Subjective here] off begin
	@CsvBindByName(column = "LEFT_EYELID_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_eyelid_subjective")
	@Schema(description = "The Left Eyelid Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Eyelid Subjective here] end
	private String leftEyelidSubjective;

	// % protected region % [Modify attribute annotation for Left Eyelid Objective here] off begin
	@CsvBindByName(column = "LEFT_EYELID_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_eyelid_objective")
	@Schema(description = "The Left Eyelid Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Eyelid Objective here] end
	private String leftEyelidObjective;

	// % protected region % [Modify attribute annotation for Left Pupil Subjective here] off begin
	@CsvBindByName(column = "LEFT_PUPIL_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_pupil_subjective")
	@Schema(description = "The Left Pupil Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Pupil Subjective here] end
	private String leftPupilSubjective;

	// % protected region % [Modify attribute annotation for Left Pupil Objective here] off begin
	@CsvBindByName(column = "LEFT_PUPIL_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_pupil_objective")
	@Schema(description = "The Left Pupil Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Pupil Objective here] end
	private String leftPupilObjective;

	// % protected region % [Modify attribute annotation for Left Sclera Subjective here] off begin
	@CsvBindByName(column = "LEFT_SCLERA_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_sclera_subjective")
	@Schema(description = "The Left Sclera Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Sclera Subjective here] end
	private String leftScleraSubjective;

	// % protected region % [Modify attribute annotation for Left Sclera Objective here] off begin
	@CsvBindByName(column = "LEFT_SCLERA_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_sclera_objective")
	@Schema(description = "The Left Sclera Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Sclera Objective here] end
	private String leftScleraObjective;

	// % protected region % [Modify attribute annotation for Left Iris Subjective here] off begin
	@CsvBindByName(column = "LEFT_IRIS_SUBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_iris_subjective")
	@Schema(description = "The Left Iris Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Iris Subjective here] end
	private String leftIrisSubjective;

	// % protected region % [Modify attribute annotation for Left Iris Objective here] off begin
	@CsvBindByName(column = "LEFT_IRIS_OBJECTIVE", required = false)
	@Nullable
	@Column(name = "left_iris_objective")
	@Schema(description = "The Left Iris Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Left Iris Objective here] end
	private String leftIrisObjective;

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

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
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
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetOphthalmologyExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setOphthalmologyExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetOphthalmologyExamination();
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
		return "RIGHT_EYELID_SUBJECTIVE,RIGHT_EYELID_OBJECTIVE,RIGHT_PUPIL_SUBJECTIVE,RIGHT_PUPIL_OBJECTIVE,RIGHT_SCLERA_SUBJECTIVE,RIGHT_SCLERA_OBJECTIVE,RIGHT_IRIS_SUBJECTIVE,RIGHT_IRIS_OBJECTIVE,LEFT_EYELID_SUBJECTIVE,LEFT_EYELID_OBJECTIVE,LEFT_PUPIL_SUBJECTIVE,LEFT_PUPIL_OBJECTIVE,LEFT_SCLERA_SUBJECTIVE,LEFT_SCLERA_OBJECTIVE,LEFT_IRIS_SUBJECTIVE,LEFT_IRIS_OBJECTIVE,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object ophthalmologyExamination) {
		if (this == ophthalmologyExamination) {
			return true;
		}
		if (ophthalmologyExamination == null || this.getClass() != ophthalmologyExamination.getClass()) {
			return false;
		}
		if (!super.equals(ophthalmologyExamination)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		OphthalmologyExaminationEntity that = (OphthalmologyExaminationEntity) ophthalmologyExamination;
		return
			Objects.equals(this.rightEyelidSubjective, that.rightEyelidSubjective) &&
			Objects.equals(this.rightEyelidObjective, that.rightEyelidObjective) &&
			Objects.equals(this.rightPupilSubjective, that.rightPupilSubjective) &&
			Objects.equals(this.rightPupilObjective, that.rightPupilObjective) &&
			Objects.equals(this.rightScleraSubjective, that.rightScleraSubjective) &&
			Objects.equals(this.rightScleraObjective, that.rightScleraObjective) &&
			Objects.equals(this.rightIrisSubjective, that.rightIrisSubjective) &&
			Objects.equals(this.rightIrisObjective, that.rightIrisObjective) &&
			Objects.equals(this.leftEyelidSubjective, that.leftEyelidSubjective) &&
			Objects.equals(this.leftEyelidObjective, that.leftEyelidObjective) &&
			Objects.equals(this.leftPupilSubjective, that.leftPupilSubjective) &&
			Objects.equals(this.leftPupilObjective, that.leftPupilObjective) &&
			Objects.equals(this.leftScleraSubjective, that.leftScleraSubjective) &&
			Objects.equals(this.leftScleraObjective, that.leftScleraObjective) &&
			Objects.equals(this.leftIrisSubjective, that.leftIrisSubjective) &&
			Objects.equals(this.leftIrisObjective, that.leftIrisObjective) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
