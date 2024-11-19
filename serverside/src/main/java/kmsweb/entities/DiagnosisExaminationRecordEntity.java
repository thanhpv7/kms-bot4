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
import kmsweb.dtos.DiagnosisExaminationRecordEntityDto;
import kmsweb.entities.listeners.DiagnosisExaminationRecordEntityListener;
import kmsweb.serializers.DiagnosisExaminationRecordSerializer;
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
@EntityListeners({DiagnosisExaminationRecordEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DiagnosisExaminationRecordSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DiagnosisExaminationRecordEntity extends AbstractEntity {

	/**
	 * Takes a DiagnosisExaminationRecordEntityDto and converts it into a DiagnosisExaminationRecordEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param diagnosisExaminationRecordEntityDto
	 */
	public DiagnosisExaminationRecordEntity(DiagnosisExaminationRecordEntityDto diagnosisExaminationRecordEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (diagnosisExaminationRecordEntityDto.getId() != null) {
			this.setId(diagnosisExaminationRecordEntityDto.getId());
		}

		if (diagnosisExaminationRecordEntityDto.getDiagnosisSequence() != null) {
			this.setDiagnosisSequence(diagnosisExaminationRecordEntityDto.getDiagnosisSequence());
		}

		if (diagnosisExaminationRecordEntityDto.getDiagnosisNotes() != null) {
			this.setDiagnosisNotes(diagnosisExaminationRecordEntityDto.getDiagnosisNotes());
		}

		if (diagnosisExaminationRecordEntityDto.getActionNotes() != null) {
			this.setActionNotes(diagnosisExaminationRecordEntityDto.getActionNotes());
		}

		if (diagnosisExaminationRecordEntityDto.getNewCase() != null) {
			this.setNewCase(diagnosisExaminationRecordEntityDto.getNewCase());
		}

		if (diagnosisExaminationRecordEntityDto.getPrintingNumber() != null) {
			this.setPrintingNumber(diagnosisExaminationRecordEntityDto.getPrintingNumber());
		}

		if (diagnosisExaminationRecordEntityDto.getDiagnosticStaffExaminationSummary() != null) {
			this.setDiagnosticStaffExaminationSummary(diagnosisExaminationRecordEntityDto.getDiagnosticStaffExaminationSummary());
		}

		if (diagnosisExaminationRecordEntityDto.getSampleCollectionInformation() != null) {
			this.setSampleCollectionInformation(diagnosisExaminationRecordEntityDto.getSampleCollectionInformation());
		}

		if (diagnosisExaminationRecordEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(diagnosisExaminationRecordEntityDto.getMedicalExaminationRecord());
		}

		if (diagnosisExaminationRecordEntityDto.getMedicalExaminationRecordDischargeSummary() != null) {
			this.setMedicalExaminationRecordDischargeSummary(diagnosisExaminationRecordEntityDto.getMedicalExaminationRecordDischargeSummary());
		}

		if (diagnosisExaminationRecordEntityDto.getIcd10() != null) {
			this.setIcd10(diagnosisExaminationRecordEntityDto.getIcd10());
		}

		if (diagnosisExaminationRecordEntityDto.getIcd9CM() != null) {
			this.setIcd9CM(diagnosisExaminationRecordEntityDto.getIcd9CM());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diagnosis Sequence here] off begin
	@CsvBindByName(column = "DIAGNOSIS_SEQUENCE", required = false)
	@Nullable
	@Column(name = "diagnosis_sequence")
	@Schema(description = "The Diagnosis Sequence of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnosis Sequence here] end
	private Integer diagnosisSequence;

	// % protected region % [Modify attribute annotation for Diagnosis Notes here] off begin
	@CsvBindByName(column = "DIAGNOSIS_NOTES", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "diagnosis_notes")
	@Schema(description = "The Diagnosis Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnosis Notes here] end
	private String diagnosisNotes;

	// % protected region % [Modify attribute annotation for Action Notes here] off begin
	@CsvBindByName(column = "ACTION_NOTES", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "action_notes")
	@Schema(description = "The Action Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Action Notes here] end
	private String actionNotes;

	// % protected region % [Modify attribute annotation for New Case here] off begin
	@CsvBindByName(column = "NEW_CASE", required = false)
	@Nullable
	@Column(name = "new_case")
	@Schema(description = "The New Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for New Case here] end
	private Boolean newCase = false ;

	// % protected region % [Modify attribute annotation for Printing Number here] off begin
	@CsvBindByName(column = "PRINTING_NUMBER", required = false)
	@Nullable
	@Column(name = "printing_number")
	@Schema(description = "The Printing Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Printing Number here] end
	private Integer printingNumber;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Diagnostic Staff Examination Summary here] off begin
	@Schema(description = "The Diagnostic Staff Examination Summary entities that are related to this entity.")
	@OneToOne(mappedBy = "diagnosisExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnostic Staff Examination Summary here] end
	private DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummary;

	// % protected region % [Update the annotation for diagnosticStaffExaminationSummaryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosticStaffExaminationSummaryId here] end
	private UUID diagnosticStaffExaminationSummaryId;

	// % protected region % [Update the annotation for Sample Collection Information here] off begin
	@Schema(description = "The Sample Collection Information entities that are related to this entity.")
	@OneToOne(mappedBy = "diagnosisExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Collection Information here] end
	private SampleCollectionInformationEntity sampleCollectionInformation;

	// % protected region % [Update the annotation for sampleCollectionInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sampleCollectionInformationId here] end
	private UUID sampleCollectionInformationId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Update the annotation for Medical Examination Record Discharge Summary here] off begin
	@Schema(description = "The Medical Examination Record Discharge Summary entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record Discharge Summary here] end
	private MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummary;

	// % protected region % [Update the annotation for medicalExaminationRecordDischargeSummaryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordDischargeSummaryId here] end
	private UUID medicalExaminationRecordDischargeSummaryId;

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

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDiagnosticStaffExaminationSummary(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosticStaffExaminationSummary(@NotNull DiagnosticStaffExaminationSummaryEntity entity) {
		setDiagnosticStaffExaminationSummary(entity, true);
	}

	/**
	 * Set or update diagnosticStaffExaminationSummary with the given DiagnosticStaffExaminationSummaryEntity.
	 *
	 * @param entity the DiagnosisExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosticStaffExaminationSummary(@NotNull DiagnosticStaffExaminationSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticStaffExaminationSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticStaffExaminationSummary here] end

		if (sameAsFormer(this.diagnosticStaffExaminationSummary, entity)) {
			return;
		}

		if (this.diagnosticStaffExaminationSummary != null) {
			this.diagnosticStaffExaminationSummary.unsetDiagnosisExaminationRecord();
		}

		this.diagnosticStaffExaminationSummary = entity;

		if (reverseAdd) {
			this.diagnosticStaffExaminationSummary.setDiagnosisExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosticStaffExaminationSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosticStaffExaminationSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosticStaffExaminationSummary(boolean)} but default to true.
	 */
	public void unsetDiagnosticStaffExaminationSummary() {
		this.unsetDiagnosticStaffExaminationSummary(true);
	}

	/**
	 * Remove the DiagnosticStaffExaminationSummaryEntity in Diagnostic Staff Examination Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosticStaffExaminationSummary(boolean reverse) {
		if (reverse && this.diagnosticStaffExaminationSummary != null) {
			this.diagnosticStaffExaminationSummary.unsetDiagnosisExaminationRecord(false);
		}
		this.diagnosticStaffExaminationSummary = null;
	}

	/**
	 * Similar to {@link this#setSampleCollectionInformation(SampleCollectionInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setSampleCollectionInformation(@NotNull SampleCollectionInformationEntity entity) {
		setSampleCollectionInformation(entity, true);
	}

	/**
	 * Set or update sampleCollectionInformation with the given SampleCollectionInformationEntity.
	 *
	 * @param entity the DiagnosisExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleCollectionInformation(@NotNull SampleCollectionInformationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionInformation here] end

		if (sameAsFormer(this.sampleCollectionInformation, entity)) {
			return;
		}

		if (this.sampleCollectionInformation != null) {
			this.sampleCollectionInformation.unsetDiagnosisExaminationRecord();
		}

		this.sampleCollectionInformation = entity;

		if (reverseAdd) {
			this.sampleCollectionInformation.setDiagnosisExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionInformation outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionInformation outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionInformation(boolean)} but default to true.
	 */
	public void unsetSampleCollectionInformation() {
		this.unsetSampleCollectionInformation(true);
	}

	/**
	 * Remove the SampleCollectionInformationEntity in Sample Collection Information from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSampleCollectionInformation(boolean reverse) {
		if (reverse && this.sampleCollectionInformation != null) {
			this.sampleCollectionInformation.unsetDiagnosisExaminationRecord(false);
		}
		this.sampleCollectionInformation = null;
	}
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
			this.medicalExaminationRecord.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addDiagnosisExaminationRecords(this, false);
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
			this.medicalExaminationRecord.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setMedicalExaminationRecordDischargeSummary(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be set to this entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		setMedicalExaminationRecordDischargeSummary(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecordDischargeSummary in this entity with single MedicalExaminationRecordDischargeSummaryEntity.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be set or updated to medicalExaminationRecordDischargeSummary
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] end

		if (sameAsFormer(this.medicalExaminationRecordDischargeSummary, entity)) {
			return;
		}

		if (this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecordDischargeSummary = entity;
		if (reverseAdd) {
			this.medicalExaminationRecordDischargeSummary.addDiagnosisExaminationRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecordDischargeSummary(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecordDischargeSummary() {
		this.unsetMedicalExaminationRecordDischargeSummary(true);
	}

	/**
	 * Remove Medical Examination Record Discharge Summary in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecordDischargeSummary(boolean reverse) {
		if (reverse && this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecordDischargeSummary = null;
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
			this.icd10.removeIcd10(this, false);
		}
		this.icd10 = entity;
		if (reverseAdd) {
			this.icd10.addIcd10(this, false);
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
			this.icd10.removeIcd10(this, false);
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
			this.icd9CM.removeIcd9CM(this, false);
		}
		this.icd9CM = entity;
		if (reverseAdd) {
			this.icd9CM.addIcd9CM(this, false);
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
			this.icd9CM.removeIcd9CM(this, false);
		}
		this.icd9CM = null;
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
		return "DIAGNOSIS_SEQUENCE,DIAGNOSIS_NOTES,ACTION_NOTES,NEW_CASE,PRINTING_NUMBER,MEDICAL_EXAMINATION_RECORD_ID,MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ID,ICD_10_ID,ICD_9_CM_ID,DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ID,SAMPLE_COLLECTION_INFORMATION_ID,ID";
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

		Optional<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummaryRelation = Optional.ofNullable(this.medicalExaminationRecordDischargeSummary);
		medicalExaminationRecordDischargeSummaryRelation.ifPresent(entity -> this.medicalExaminationRecordDischargeSummaryId = entity.getId());

		Optional<DiagnosesAndProceduresEntity> icd10Relation = Optional.ofNullable(this.icd10);
		icd10Relation.ifPresent(entity -> this.icd10Id = entity.getId());

		Optional<DiagnosesAndProceduresEntity> icd9CMRelation = Optional.ofNullable(this.icd9CM);
		icd9CMRelation.ifPresent(entity -> this.icd9CMId = entity.getId());

		Optional<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaryRelation = Optional.ofNullable(this.diagnosticStaffExaminationSummary);
		diagnosticStaffExaminationSummaryRelation.ifPresent(entity -> this.diagnosticStaffExaminationSummaryId = entity.getId());

		Optional<SampleCollectionInformationEntity> sampleCollectionInformationRelation = Optional.ofNullable(this.sampleCollectionInformation);
		sampleCollectionInformationRelation.ifPresent(entity -> this.sampleCollectionInformationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object diagnosisExaminationRecord) {
		if (this == diagnosisExaminationRecord) {
			return true;
		}
		if (diagnosisExaminationRecord == null || this.getClass() != diagnosisExaminationRecord.getClass()) {
			return false;
		}
		if (!super.equals(diagnosisExaminationRecord)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DiagnosisExaminationRecordEntity that = (DiagnosisExaminationRecordEntity) diagnosisExaminationRecord;
		return
			Objects.equals(this.diagnosisSequence, that.diagnosisSequence) &&
			Objects.equals(this.diagnosisNotes, that.diagnosisNotes) &&
			Objects.equals(this.actionNotes, that.actionNotes) &&
			Objects.equals(this.newCase, that.newCase) &&
			Objects.equals(this.printingNumber, that.printingNumber) &&
			Objects.equals(this.diagnosticStaffExaminationSummaryId, that.diagnosticStaffExaminationSummaryId) &&
			Objects.equals(this.sampleCollectionInformationId, that.sampleCollectionInformationId) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.medicalExaminationRecordDischargeSummaryId, that.medicalExaminationRecordDischargeSummaryId) &&
			Objects.equals(this.icd10Id, that.icd10Id) &&
			Objects.equals(this.icd9CMId, that.icd9CMId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
