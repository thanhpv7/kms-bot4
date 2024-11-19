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
import kmsweb.dtos.PreoperativeRecordsEntityDto;
import kmsweb.entities.listeners.PreoperativeRecordsEntityListener;
import kmsweb.serializers.PreoperativeRecordsSerializer;
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
@EntityListeners({PreoperativeRecordsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PreoperativeRecordsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PreoperativeRecordsEntity extends AbstractEntity {

	/**
	 * Takes a PreoperativeRecordsEntityDto and converts it into a PreoperativeRecordsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param preoperativeRecordsEntityDto
	 */
	public PreoperativeRecordsEntity(PreoperativeRecordsEntityDto preoperativeRecordsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (preoperativeRecordsEntityDto.getId() != null) {
			this.setId(preoperativeRecordsEntityDto.getId());
		}

		if (preoperativeRecordsEntityDto.getStartDateTime() != null) {
			this.setStartDateTime(preoperativeRecordsEntityDto.getStartDateTime());
		}

		if (preoperativeRecordsEntityDto.getEndDateTime() != null) {
			this.setEndDateTime(preoperativeRecordsEntityDto.getEndDateTime());
		}

		if (preoperativeRecordsEntityDto.getPhysicalStatusEvaluation() != null) {
			this.setPhysicalStatusEvaluation(preoperativeRecordsEntityDto.getPhysicalStatusEvaluation());
		}

		if (preoperativeRecordsEntityDto.getSurgeryRisk() != null) {
			this.setSurgeryRisk(preoperativeRecordsEntityDto.getSurgeryRisk());
		}

		if (preoperativeRecordsEntityDto.getPsychologicalState() != null) {
			this.setPsychologicalState(preoperativeRecordsEntityDto.getPsychologicalState());
		}

		if (preoperativeRecordsEntityDto.getAnesthesiaSurgeryRisk() != null) {
			this.setAnesthesiaSurgeryRisk(preoperativeRecordsEntityDto.getAnesthesiaSurgeryRisk());
		}

		if (preoperativeRecordsEntityDto.getPreoperativeEvaluation() != null) {
			this.setPreoperativeEvaluation(preoperativeRecordsEntityDto.getPreoperativeEvaluation());
		}

		if (preoperativeRecordsEntityDto.getAnesthesiaNotes() != null) {
			this.setAnesthesiaNotes(preoperativeRecordsEntityDto.getAnesthesiaNotes());
		}

		if (preoperativeRecordsEntityDto.getSurgicalSpecialty() != null) {
			this.setSurgicalSpecialty(preoperativeRecordsEntityDto.getSurgicalSpecialty());
		}

		if (preoperativeRecordsEntityDto.getAntibioticProphylaxisGiven() != null) {
			this.setAntibioticProphylaxisGiven(preoperativeRecordsEntityDto.getAntibioticProphylaxisGiven());
		}

		if (preoperativeRecordsEntityDto.getSurgeryType() != null) {
			this.setSurgeryType(preoperativeRecordsEntityDto.getSurgeryType());
		}

		if (preoperativeRecordsEntityDto.getSurgeryClass() != null) {
			this.setSurgeryClass(preoperativeRecordsEntityDto.getSurgeryClass());
		}

		if (preoperativeRecordsEntityDto.getSurgicalSurgeryRisk() != null) {
			this.setSurgicalSurgeryRisk(preoperativeRecordsEntityDto.getSurgicalSurgeryRisk());
		}

		if (preoperativeRecordsEntityDto.getPhysicalStatusClassification() != null) {
			this.setPhysicalStatusClassification(preoperativeRecordsEntityDto.getPhysicalStatusClassification());
		}

		if (preoperativeRecordsEntityDto.getPreSurgeryDiagnosis() != null) {
			this.setPreSurgeryDiagnosis(preoperativeRecordsEntityDto.getPreSurgeryDiagnosis());
		}

		if (preoperativeRecordsEntityDto.getPreoperativeInstructions() != null) {
			this.setPreoperativeInstructions(preoperativeRecordsEntityDto.getPreoperativeInstructions());
		}

		if (preoperativeRecordsEntityDto.getPreoperativeSurgicalNotes() != null) {
			this.setPreoperativeSurgicalNotes(preoperativeRecordsEntityDto.getPreoperativeSurgicalNotes());
		}

		if (preoperativeRecordsEntityDto.getAdditionalAnesthesiologists() != null) {
			this.setAdditionalAnesthesiologists(preoperativeRecordsEntityDto.getAdditionalAnesthesiologists());
		}

		if (preoperativeRecordsEntityDto.getAdditionalSurgeryNurses() != null) {
			this.setAdditionalSurgeryNurses(preoperativeRecordsEntityDto.getAdditionalSurgeryNurses());
		}

		if (preoperativeRecordsEntityDto.getBedFacilities() != null) {
			this.setBedFacilities(preoperativeRecordsEntityDto.getBedFacilities());
		}

		if (preoperativeRecordsEntityDto.getCoTreatingAnesthesiologists() != null) {
			this.setCoTreatingAnesthesiologists(preoperativeRecordsEntityDto.getCoTreatingAnesthesiologists());
		}

		if (preoperativeRecordsEntityDto.getCoTreatingSurgeons() != null) {
			this.setCoTreatingSurgeons(preoperativeRecordsEntityDto.getCoTreatingSurgeons());
		}

		if (preoperativeRecordsEntityDto.getAnesthesiaMedicalTranscriber() != null) {
			this.setAnesthesiaMedicalTranscriber(preoperativeRecordsEntityDto.getAnesthesiaMedicalTranscriber());
		}

		if (preoperativeRecordsEntityDto.getAnesthesiologist() != null) {
			this.setAnesthesiologist(preoperativeRecordsEntityDto.getAnesthesiologist());
		}

		if (preoperativeRecordsEntityDto.getAnesthesiologyNurse() != null) {
			this.setAnesthesiologyNurse(preoperativeRecordsEntityDto.getAnesthesiologyNurse());
		}

		if (preoperativeRecordsEntityDto.getPreSurgeryICD10() != null) {
			this.setPreSurgeryICD10(preoperativeRecordsEntityDto.getPreSurgeryICD10());
		}

		if (preoperativeRecordsEntityDto.getPreSurgeryICD9CM() != null) {
			this.setPreSurgeryICD9CM(preoperativeRecordsEntityDto.getPreSurgeryICD9CM());
		}

		if (preoperativeRecordsEntityDto.getOperatingTheaterMedicalExaminationRecord() != null) {
			this.setOperatingTheaterMedicalExaminationRecord(preoperativeRecordsEntityDto.getOperatingTheaterMedicalExaminationRecord());
		}

		if (preoperativeRecordsEntityDto.getPreoperativeRooms() != null) {
			this.setPreoperativeRooms(preoperativeRecordsEntityDto.getPreoperativeRooms());
		}

		if (preoperativeRecordsEntityDto.getSurgeon() != null) {
			this.setSurgeon(preoperativeRecordsEntityDto.getSurgeon());
		}

		if (preoperativeRecordsEntityDto.getSurgicalMedicalTranscriber() != null) {
			this.setSurgicalMedicalTranscriber(preoperativeRecordsEntityDto.getSurgicalMedicalTranscriber());
		}

		if (preoperativeRecordsEntityDto.getSurgicalNurse() != null) {
			this.setSurgicalNurse(preoperativeRecordsEntityDto.getSurgicalNurse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Start Date Time here] off begin
	@CsvCustomBindByName(column = "START_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "start_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Start Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Start Date Time here] end
	private OffsetDateTime startDateTime;

	// % protected region % [Modify attribute annotation for End Date Time here] off begin
	@CsvCustomBindByName(column = "END_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "end_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The End Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for End Date Time here] end
	private OffsetDateTime endDateTime;

	// % protected region % [Modify attribute annotation for Physical Status Evaluation here] off begin
	@CsvBindByName(column = "PHYSICAL_STATUS_EVALUATION", required = false)
	@Nullable
	@Column(name = "physical_status_evaluation")
	@Schema(description = "The Physical Status Evaluation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Physical Status Evaluation here] end
	private String physicalStatusEvaluation;

	// % protected region % [Modify attribute annotation for Surgery Risk here] off begin
	@CsvBindByName(column = "SURGERY_RISK", required = false)
	@Nullable
	@Column(name = "surgery_risk")
	@Schema(description = "The Surgery Risk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery Risk here] end
	private String surgeryRisk;

	// % protected region % [Modify attribute annotation for Psychological State here] off begin
	@CsvBindByName(column = "PSYCHOLOGICAL_STATE", required = false)
	@Nullable
	@Column(name = "psychological_state")
	@Schema(description = "The Psychological State of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Psychological State here] end
	private String psychologicalState;

	// % protected region % [Modify attribute annotation for Anesthesia Surgery Risk here] off begin
	@CsvBindByName(column = "ANESTHESIA_SURGERY_RISK", required = false)
	@Nullable
	@Column(name = "anesthesia_surgery_risk")
	@Schema(description = "The Anesthesia Surgery Risk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Surgery Risk here] end
	private String anesthesiaSurgeryRisk;

	// % protected region % [Modify attribute annotation for Preoperative Evaluation here] off begin
	@CsvBindByName(column = "PREOPERATIVE_EVALUATION", required = false)
	@Nullable
	@Column(name = "preoperative_evaluation")
	@Schema(description = "The Preoperative Evaluation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Preoperative Evaluation here] end
	private String preoperativeEvaluation;

	// % protected region % [Modify attribute annotation for Anesthesia Notes here] off begin
	@CsvBindByName(column = "ANESTHESIA_NOTES", required = false)
	@Nullable
	@Column(name = "anesthesia_notes")
	@Schema(description = "The Anesthesia Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Notes here] end
	private String anesthesiaNotes;

	// % protected region % [Modify attribute annotation for Surgical Specialty here] off begin
	@CsvBindByName(column = "SURGICAL_SPECIALTY", required = false)
	@Nullable
	@Column(name = "surgical_specialty")
	@Schema(description = "The Surgical Specialty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgical Specialty here] end
	private String surgicalSpecialty;

	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] off begin
	@CsvBindByName(column = "ANTIBIOTIC_PROPHYLAXIS_GIVEN", required = false)
	@Nullable
	@Column(name = "antibiotic_prophylaxis_given")
	@Schema(description = "The Antibiotic Prophylaxis Given of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] end
	private String antibioticProphylaxisGiven;

	// % protected region % [Modify attribute annotation for Surgery Type here] off begin
	@CsvBindByName(column = "SURGERY_TYPE", required = false)
	@Nullable
	@Column(name = "surgery_type")
	@Schema(description = "The Surgery Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery Type here] end
	private String surgeryType;

	// % protected region % [Modify attribute annotation for Surgery Class here] off begin
	@CsvBindByName(column = "SURGERY_CLASS", required = false)
	@Nullable
	@Column(name = "surgery_class")
	@Schema(description = "The Surgery Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgery Class here] end
	private String surgeryClass;

	// % protected region % [Modify attribute annotation for Surgical Surgery Risk here] off begin
	@CsvBindByName(column = "SURGICAL_SURGERY_RISK", required = false)
	@Nullable
	@Column(name = "surgical_surgery_risk")
	@Schema(description = "The Surgical Surgery Risk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgical Surgery Risk here] end
	private String surgicalSurgeryRisk;

	// % protected region % [Modify attribute annotation for Physical Status Classification here] off begin
	@CsvBindByName(column = "PHYSICAL_STATUS_CLASSIFICATION", required = false)
	@Nullable
	@Column(name = "physical_status_classification")
	@Schema(description = "The Physical Status Classification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Physical Status Classification here] end
	private String physicalStatusClassification;

	// % protected region % [Modify attribute annotation for Pre Surgery Diagnosis here] off begin
	@CsvBindByName(column = "PRE_SURGERY_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "pre_surgery_diagnosis")
	@Schema(description = "The Pre Surgery Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pre Surgery Diagnosis here] end
	private String preSurgeryDiagnosis;

	// % protected region % [Modify attribute annotation for Preoperative Instructions here] off begin
	@CsvBindByName(column = "PREOPERATIVE_INSTRUCTIONS", required = false)
	@Nullable
	@Column(name = "preoperative_instructions")
	@Schema(description = "The Preoperative Instructions of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Preoperative Instructions here] end
	private String preoperativeInstructions;

	// % protected region % [Modify attribute annotation for Preoperative Surgical Notes here] off begin
	@CsvBindByName(column = "PREOPERATIVE_SURGICAL_NOTES", required = false)
	@Nullable
	@Column(name = "preoperative_surgical_notes")
	@Schema(description = "The Preoperative Surgical Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Preoperative Surgical Notes here] end
	private String preoperativeSurgicalNotes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Additional Anesthesiologists here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "additionalAnesthesiologist", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Anesthesiologists here] end
	private Set<CoTreatingDoctorEntity> additionalAnesthesiologists = new HashSet<>();

	// % protected region % [Update the annotation for additionalAnesthesiologistsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_ANESTHESIOLOGISTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for additionalAnesthesiologistsIds here] end
	private Set<UUID> additionalAnesthesiologistsIds = new HashSet<>();

	// % protected region % [Update the annotation for Additional Surgery Nurses here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "additionalSurgeryNurse", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Surgery Nurses here] end
	private Set<CoTreatingDoctorEntity> additionalSurgeryNurses = new HashSet<>();

	// % protected region % [Update the annotation for additionalSurgeryNursesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_SURGERY_NURSES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for additionalSurgeryNursesIds here] end
	private Set<UUID> additionalSurgeryNursesIds = new HashSet<>();

	// % protected region % [Update the annotation for Bed Facilities here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@OneToMany(mappedBy = "preoperativeRecords", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facilities here] end
	private Set<BedFacilityEntity> bedFacilities = new HashSet<>();

	// % protected region % [Update the annotation for bedFacilitiesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bedFacilitiesIds here] end
	private Set<UUID> bedFacilitiesIds = new HashSet<>();

	// % protected region % [Update the annotation for Co Treating Anesthesiologists here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "coTreatingAnesthesiologist", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Co Treating Anesthesiologists here] end
	private Set<CoTreatingDoctorEntity> coTreatingAnesthesiologists = new HashSet<>();

	// % protected region % [Update the annotation for coTreatingAnesthesiologistsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CO_TREATING_ANESTHESIOLOGISTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for coTreatingAnesthesiologistsIds here] end
	private Set<UUID> coTreatingAnesthesiologistsIds = new HashSet<>();

	// % protected region % [Update the annotation for Co Treating Surgeons here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "coTreatingSurgeon", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Co Treating Surgeons here] end
	private Set<CoTreatingDoctorEntity> coTreatingSurgeons = new HashSet<>();

	// % protected region % [Update the annotation for coTreatingSurgeonsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CO_TREATING_SURGEONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for coTreatingSurgeonsIds here] end
	private Set<UUID> coTreatingSurgeonsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Anesthesia Medical Transcriber here] off begin
	@Schema(description = "The Anesthesia Medical Transcriber entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Anesthesia Medical Transcriber here] end
	private StaffEntity anesthesiaMedicalTranscriber;

	// % protected region % [Update the annotation for anesthesiaMedicalTranscriberId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ANESTHESIA_MEDICAL_TRANSCRIBER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for anesthesiaMedicalTranscriberId here] end
	private UUID anesthesiaMedicalTranscriberId;

	// % protected region % [Update the annotation for Anesthesiologist here] off begin
	@Schema(description = "The Anesthesiologist entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Anesthesiologist here] end
	private StaffEntity anesthesiologist;

	// % protected region % [Update the annotation for anesthesiologistId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ANESTHESIOLOGIST_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for anesthesiologistId here] end
	private UUID anesthesiologistId;

	// % protected region % [Update the annotation for Anesthesiology Nurse here] off begin
	@Schema(description = "The Anesthesiology Nurse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Anesthesiology Nurse here] end
	private StaffEntity anesthesiologyNurse;

	// % protected region % [Update the annotation for anesthesiologyNurseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ANESTHESIOLOGY_NURSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for anesthesiologyNurseId here] end
	private UUID anesthesiologyNurseId;

	// % protected region % [Update the annotation for Pre Surgery ICD 10 here] off begin
	@Schema(description = "The Pre Surgery ICD 10 entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Pre Surgery ICD 10 here] end
	private DiagnosesAndProceduresEntity preSurgeryICD10;

	// % protected region % [Update the annotation for preSurgeryICD10Id here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRE_SURGERY_ICD_10_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for preSurgeryICD10Id here] end
	private UUID preSurgeryICD10Id;

	// % protected region % [Update the annotation for Pre Surgery ICD 9 CM here] off begin
	@Schema(description = "The Pre Surgery ICD 9 CM entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Pre Surgery ICD 9 CM here] end
	private DiagnosesAndProceduresEntity preSurgeryICD9CM;

	// % protected region % [Update the annotation for preSurgeryICD9CMId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRE_SURGERY_ICD_9_CM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for preSurgeryICD9CMId here] end
	private UUID preSurgeryICD9CMId;

	// % protected region % [Update the annotation for Operating Theater Medical Examination Record here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Operating Theater Medical Examination Record here] end
	private OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord;

	// % protected region % [Update the annotation for operatingTheaterMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for operatingTheaterMedicalExaminationRecordId here] end
	private UUID operatingTheaterMedicalExaminationRecordId;

	// % protected region % [Update the annotation for Preoperative Rooms here] off begin
	@Schema(description = "The Preoperative Rooms entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Preoperative Rooms here] end
	private RoomFacilityEntity preoperativeRooms;

	// % protected region % [Update the annotation for preoperativeRoomsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PREOPERATIVE_ROOMS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for preoperativeRoomsId here] end
	private UUID preoperativeRoomsId;

	// % protected region % [Update the annotation for Surgeon here] off begin
	@Schema(description = "The Surgeon entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Surgeon here] end
	private StaffEntity surgeon;

	// % protected region % [Update the annotation for surgeonId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SURGEON_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for surgeonId here] end
	private UUID surgeonId;

	// % protected region % [Update the annotation for Surgical Medical Transcriber here] off begin
	@Schema(description = "The Surgical Medical Transcriber entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Surgical Medical Transcriber here] end
	private StaffEntity surgicalMedicalTranscriber;

	// % protected region % [Update the annotation for surgicalMedicalTranscriberId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SURGICAL_MEDICAL_TRANSCRIBER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for surgicalMedicalTranscriberId here] end
	private UUID surgicalMedicalTranscriberId;

	// % protected region % [Update the annotation for Surgical Nurse here] off begin
	@Schema(description = "The Surgical Nurse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Surgical Nurse here] end
	private StaffEntity surgicalNurse;

	// % protected region % [Update the annotation for surgicalNurseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SURGICAL_NURSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for surgicalNurseId here] end
	private UUID surgicalNurseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addAdditionalAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalAnesthesiologists(@NotNull CoTreatingDoctorEntity entity) {
		addAdditionalAnesthesiologists(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to additionalAnesthesiologists in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalAnesthesiologists(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.additionalAnesthesiologists.contains(entity)) {
			additionalAnesthesiologists.add(entity);
			if (reverseAdd) {
				entity.setAdditionalAnesthesiologist(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addAdditionalAnesthesiologists(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Additional Anesthesiologists in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeAdditionalAnesthesiologists(@NotNull CoTreatingDoctorEntity entity) {
		this.removeAdditionalAnesthesiologists(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalAnesthesiologists(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalAnesthesiologist(false);
		}
		this.additionalAnesthesiologists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeAdditionalAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeAdditionalAnesthesiologists(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setAdditionalAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setAdditionalAnesthesiologists(entities, true);
	}

	/**
	 * Replace the current entities in Additional Anesthesiologists with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalAnesthesiologists();
		this.additionalAnesthesiologists = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalAnesthesiologists.forEach(additionalAnesthesiologistsEntity -> additionalAnesthesiologistsEntity.setAdditionalAnesthesiologist(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalAnesthesiologists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalAnesthesiologists() {
		this.unsetAdditionalAnesthesiologists(true);
	}

	/**
	 * Remove all the entities in Additional Anesthesiologists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalAnesthesiologists(boolean doReverse) {
		if (doReverse) {
			this.additionalAnesthesiologists.forEach(additionalAnesthesiologistsEntity -> additionalAnesthesiologistsEntity.unsetAdditionalAnesthesiologist(false));
		}
		this.additionalAnesthesiologists.clear();
	}

/**
	 * Similar to {@link this#addAdditionalSurgeryNurses(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalSurgeryNurses(@NotNull CoTreatingDoctorEntity entity) {
		addAdditionalSurgeryNurses(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to additionalSurgeryNurses in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalSurgeryNurses(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.additionalSurgeryNurses.contains(entity)) {
			additionalSurgeryNurses.add(entity);
			if (reverseAdd) {
				entity.setAdditionalSurgeryNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalSurgeryNurses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalSurgeryNurses(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addAdditionalSurgeryNurses(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Additional Surgery Nurses in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalSurgeryNurses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalSurgeryNurses(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeAdditionalSurgeryNurses(@NotNull CoTreatingDoctorEntity entity) {
		this.removeAdditionalSurgeryNurses(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalSurgeryNurses(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalSurgeryNurse(false);
		}
		this.additionalSurgeryNurses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalSurgeryNurses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeAdditionalSurgeryNurses(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeAdditionalSurgeryNurses(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalSurgeryNurses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalSurgeryNurses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setAdditionalSurgeryNurses(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setAdditionalSurgeryNurses(entities, true);
	}

	/**
	 * Replace the current entities in Additional Surgery Nurses with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalSurgeryNurses(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalSurgeryNurses();
		this.additionalSurgeryNurses = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalSurgeryNurses.forEach(additionalSurgeryNursesEntity -> additionalSurgeryNursesEntity.setAdditionalSurgeryNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalSurgeryNurses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalSurgeryNurses() {
		this.unsetAdditionalSurgeryNurses(true);
	}

	/**
	 * Remove all the entities in Additional Surgery Nurses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalSurgeryNurses(boolean doReverse) {
		if (doReverse) {
			this.additionalSurgeryNurses.forEach(additionalSurgeryNursesEntity -> additionalSurgeryNursesEntity.unsetAdditionalSurgeryNurse(false));
		}
		this.additionalSurgeryNurses.clear();
	}

/**
	 * Similar to {@link this#addBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NotNull BedFacilityEntity entity) {
		addBedFacilities(entity, true);
	}

	/**
	 * Add a new BedFacilityEntity to bedFacilities in this entity.
	 *
	 * @param entity the given BedFacilityEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBedFacilities(@NonNull BedFacilityEntity entity, boolean reverseAdd) {
		if (!this.bedFacilities.contains(entity)) {
			bedFacilities.add(entity);
			if (reverseAdd) {
				entity.setPreoperativeRecords(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBedFacilities(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NotNull Collection<BedFacilityEntity> entities) {
		addBedFacilities(entities, true);
	}

	/**
	 * Add a new collection of BedFacilityEntity to Bed Facilities in this entity.
	 *
	 * @param entities the given collection of BedFacilityEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBedFacilities(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void removeBedFacilities(@NotNull BedFacilityEntity entity) {
		this.removeBedFacilities(entity, true);
	}

	/**
	 * Remove the given BedFacilityEntity from this entity.
	 *
	 * @param entity the given BedFacilityEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedFacilities(@NotNull BedFacilityEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPreoperativeRecords(false);
		}
		this.bedFacilities.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBedFacilities(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BedFacilityEntity to be removed to this entity
	 */
	public void removeBedFacilities(@NotNull Collection<BedFacilityEntity> entities) {
		this.removeBedFacilities(entities, true);
	}

	/**
	 * Remove the given collection of BedFacilityEntity from  to this entity.
	 *
	 * @param entities the given collection of BedFacilityEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBedFacilities(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBedFacilities(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedFacilityEntity to be set to this entity
	 */
	public void setBedFacilities(@NotNull Collection<BedFacilityEntity> entities) {
		setBedFacilities(entities, true);
	}

	/**
	 * Replace the current entities in Bed Facilities with the given ones.
	 *
	 * @param entities the given collection of BedFacilityEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedFacilities(@NotNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {

		this.unsetBedFacilities();
		this.bedFacilities = new HashSet<>(entities);
		if (reverseAdd) {
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.setPreoperativeRecords(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBedFacilities(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBedFacilities() {
		this.unsetBedFacilities(true);
	}

	/**
	 * Remove all the entities in Bed Facilities from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBedFacilities(boolean doReverse) {
		if (doReverse) {
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.unsetPreoperativeRecords(false));
		}
		this.bedFacilities.clear();
	}

/**
	 * Similar to {@link this#addCoTreatingAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingAnesthesiologists(@NotNull CoTreatingDoctorEntity entity) {
		addCoTreatingAnesthesiologists(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingAnesthesiologists in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingAnesthesiologists(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingAnesthesiologists.contains(entity)) {
			coTreatingAnesthesiologists.add(entity);
			if (reverseAdd) {
				entity.setCoTreatingAnesthesiologist(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingAnesthesiologists(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Anesthesiologists in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingAnesthesiologists(@NotNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingAnesthesiologists(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingAnesthesiologists(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCoTreatingAnesthesiologist(false);
		}
		this.coTreatingAnesthesiologists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingAnesthesiologists(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingAnesthesiologists(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Anesthesiologists with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingAnesthesiologists(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingAnesthesiologists();
		this.coTreatingAnesthesiologists = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingAnesthesiologists.forEach(coTreatingAnesthesiologistsEntity -> coTreatingAnesthesiologistsEntity.setCoTreatingAnesthesiologist(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingAnesthesiologists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingAnesthesiologists() {
		this.unsetCoTreatingAnesthesiologists(true);
	}

	/**
	 * Remove all the entities in Co Treating Anesthesiologists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingAnesthesiologists(boolean doReverse) {
		if (doReverse) {
			this.coTreatingAnesthesiologists.forEach(coTreatingAnesthesiologistsEntity -> coTreatingAnesthesiologistsEntity.unsetCoTreatingAnesthesiologist(false));
		}
		this.coTreatingAnesthesiologists.clear();
	}

/**
	 * Similar to {@link this#addCoTreatingSurgeons(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingSurgeons(@NotNull CoTreatingDoctorEntity entity) {
		addCoTreatingSurgeons(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingSurgeons in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingSurgeons(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingSurgeons.contains(entity)) {
			coTreatingSurgeons.add(entity);
			if (reverseAdd) {
				entity.setCoTreatingSurgeon(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingSurgeons(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingSurgeons(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingSurgeons(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Surgeons in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingSurgeons(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingSurgeons(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingSurgeons(@NotNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingSurgeons(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingSurgeons(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCoTreatingSurgeon(false);
		}
		this.coTreatingSurgeons.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingSurgeons(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingSurgeons(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingSurgeons(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingSurgeons(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingSurgeons(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingSurgeons(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingSurgeons(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Surgeons with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingSurgeons(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingSurgeons();
		this.coTreatingSurgeons = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingSurgeons.forEach(coTreatingSurgeonsEntity -> coTreatingSurgeonsEntity.setCoTreatingSurgeon(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingSurgeons(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingSurgeons() {
		this.unsetCoTreatingSurgeons(true);
	}

	/**
	 * Remove all the entities in Co Treating Surgeons from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingSurgeons(boolean doReverse) {
		if (doReverse) {
			this.coTreatingSurgeons.forEach(coTreatingSurgeonsEntity -> coTreatingSurgeonsEntity.unsetCoTreatingSurgeon(false));
		}
		this.coTreatingSurgeons.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setAnesthesiaMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAnesthesiaMedicalTranscriber(@NotNull StaffEntity entity) {
		setAnesthesiaMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the anesthesiaMedicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to anesthesiaMedicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAnesthesiaMedicalTranscriber(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiaMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiaMedicalTranscriber here] end

		if (sameAsFormer(this.anesthesiaMedicalTranscriber, entity)) {
			return;
		}

		if (this.anesthesiaMedicalTranscriber != null) {
			this.anesthesiaMedicalTranscriber.removeAnesthesiaMedicalTranscriber(this, false);
		}
		this.anesthesiaMedicalTranscriber = entity;
		if (reverseAdd) {
			this.anesthesiaMedicalTranscriber.addAnesthesiaMedicalTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAnesthesiaMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAnesthesiaMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAnesthesiaMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetAnesthesiaMedicalTranscriber() {
		this.unsetAnesthesiaMedicalTranscriber(true);
	}

	/**
	 * Remove Anesthesia Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAnesthesiaMedicalTranscriber(boolean reverse) {
		if (reverse && this.anesthesiaMedicalTranscriber != null) {
			this.anesthesiaMedicalTranscriber.removeAnesthesiaMedicalTranscriber(this, false);
		}
		this.anesthesiaMedicalTranscriber = null;
	}
	/**
	 * Similar to {@link this#setAnesthesiologist(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAnesthesiologist(@NotNull StaffEntity entity) {
		setAnesthesiologist(entity, true);
	}

	/**
	 * Set or update the anesthesiologist in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to anesthesiologist
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAnesthesiologist(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologist here] end

		if (sameAsFormer(this.anesthesiologist, entity)) {
			return;
		}

		if (this.anesthesiologist != null) {
			this.anesthesiologist.removeAnesthesiologist(this, false);
		}
		this.anesthesiologist = entity;
		if (reverseAdd) {
			this.anesthesiologist.addAnesthesiologist(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologist incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologist incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologist(boolean)} but default to true.
	 */
	public void unsetAnesthesiologist() {
		this.unsetAnesthesiologist(true);
	}

	/**
	 * Remove Anesthesiologist in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAnesthesiologist(boolean reverse) {
		if (reverse && this.anesthesiologist != null) {
			this.anesthesiologist.removeAnesthesiologist(this, false);
		}
		this.anesthesiologist = null;
	}
	/**
	 * Similar to {@link this#setAnesthesiologyNurse(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAnesthesiologyNurse(@NotNull StaffEntity entity) {
		setAnesthesiologyNurse(entity, true);
	}

	/**
	 * Set or update the anesthesiologyNurse in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to anesthesiologyNurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAnesthesiologyNurse(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologyNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologyNurse here] end

		if (sameAsFormer(this.anesthesiologyNurse, entity)) {
			return;
		}

		if (this.anesthesiologyNurse != null) {
			this.anesthesiologyNurse.removeAnesthesiologyNurse(this, false);
		}
		this.anesthesiologyNurse = entity;
		if (reverseAdd) {
			this.anesthesiologyNurse.addAnesthesiologyNurse(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologyNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologyNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologyNurse(boolean)} but default to true.
	 */
	public void unsetAnesthesiologyNurse() {
		this.unsetAnesthesiologyNurse(true);
	}

	/**
	 * Remove Anesthesiology Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAnesthesiologyNurse(boolean reverse) {
		if (reverse && this.anesthesiologyNurse != null) {
			this.anesthesiologyNurse.removeAnesthesiologyNurse(this, false);
		}
		this.anesthesiologyNurse = null;
	}
	/**
	 * Similar to {@link this#setPreSurgeryICD10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setPreSurgeryICD10(@NotNull DiagnosesAndProceduresEntity entity) {
		setPreSurgeryICD10(entity, true);
	}

	/**
	 * Set or update the preSurgeryICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to preSurgeryICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreSurgeryICD10(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD10 here] end

		if (sameAsFormer(this.preSurgeryICD10, entity)) {
			return;
		}

		if (this.preSurgeryICD10 != null) {
			this.preSurgeryICD10.removePreSurgeryICD10(this, false);
		}
		this.preSurgeryICD10 = entity;
		if (reverseAdd) {
			this.preSurgeryICD10.addPreSurgeryICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreSurgeryICD10(boolean)} but default to true.
	 */
	public void unsetPreSurgeryICD10() {
		this.unsetPreSurgeryICD10(true);
	}

	/**
	 * Remove Pre Surgery ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreSurgeryICD10(boolean reverse) {
		if (reverse && this.preSurgeryICD10 != null) {
			this.preSurgeryICD10.removePreSurgeryICD10(this, false);
		}
		this.preSurgeryICD10 = null;
	}
	/**
	 * Similar to {@link this#setPreSurgeryICD9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setPreSurgeryICD9CM(@NotNull DiagnosesAndProceduresEntity entity) {
		setPreSurgeryICD9CM(entity, true);
	}

	/**
	 * Set or update the preSurgeryICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to preSurgeryICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreSurgeryICD9CM(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD9CM here] end

		if (sameAsFormer(this.preSurgeryICD9CM, entity)) {
			return;
		}

		if (this.preSurgeryICD9CM != null) {
			this.preSurgeryICD9CM.removePreSurgeryICD9CM(this, false);
		}
		this.preSurgeryICD9CM = entity;
		if (reverseAdd) {
			this.preSurgeryICD9CM.addPreSurgeryICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreSurgeryICD9CM(boolean)} but default to true.
	 */
	public void unsetPreSurgeryICD9CM() {
		this.unsetPreSurgeryICD9CM(true);
	}

	/**
	 * Remove Pre Surgery ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreSurgeryICD9CM(boolean reverse) {
		if (reverse && this.preSurgeryICD9CM != null) {
			this.preSurgeryICD9CM.removePreSurgeryICD9CM(this, false);
		}
		this.preSurgeryICD9CM = null;
	}
	/**
	 * Similar to {@link this#setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity entity) {
		setOperatingTheaterMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the operatingTheaterMedicalExaminationRecord in this entity with single OperatingTheaterMedicalExaminationRecordEntity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set or updated to operatingTheaterMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] end

		if (sameAsFormer(this.operatingTheaterMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetPreoperativeRecords(false);
		}

		this.operatingTheaterMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.operatingTheaterMedicalExaminationRecord.setPreoperativeRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOperatingTheaterMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord() {
		this.unsetOperatingTheaterMedicalExaminationRecord(true);
	}

	/**
	 * Remove the OperatingTheaterMedicalExaminationRecordEntity of operatingTheaterMedicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetPreoperativeRecords();
		}
		this.operatingTheaterMedicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setPreoperativeRooms(RoomFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomFacilityEntity to be set to this entity
	 */
	public void setPreoperativeRooms(@NotNull RoomFacilityEntity entity) {
		setPreoperativeRooms(entity, true);
	}

	/**
	 * Set or update the preoperativeRooms in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to preoperativeRooms
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreoperativeRooms(@NotNull RoomFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRooms here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRooms here] end

		if (sameAsFormer(this.preoperativeRooms, entity)) {
			return;
		}

		if (this.preoperativeRooms != null) {
			this.preoperativeRooms.removePreoperativeRooms(this, false);
		}
		this.preoperativeRooms = entity;
		if (reverseAdd) {
			this.preoperativeRooms.addPreoperativeRooms(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRooms incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRooms incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreoperativeRooms(boolean)} but default to true.
	 */
	public void unsetPreoperativeRooms() {
		this.unsetPreoperativeRooms(true);
	}

	/**
	 * Remove Preoperative Rooms in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreoperativeRooms(boolean reverse) {
		if (reverse && this.preoperativeRooms != null) {
			this.preoperativeRooms.removePreoperativeRooms(this, false);
		}
		this.preoperativeRooms = null;
	}
	/**
	 * Similar to {@link this#setSurgeon(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSurgeon(@NotNull StaffEntity entity) {
		setSurgeon(entity, true);
	}

	/**
	 * Set or update the surgeon in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to surgeon
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSurgeon(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSurgeon here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSurgeon here] end

		if (sameAsFormer(this.surgeon, entity)) {
			return;
		}

		if (this.surgeon != null) {
			this.surgeon.removeSurgeon(this, false);
		}
		this.surgeon = entity;
		if (reverseAdd) {
			this.surgeon.addSurgeon(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSurgeon incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSurgeon incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSurgeon(boolean)} but default to true.
	 */
	public void unsetSurgeon() {
		this.unsetSurgeon(true);
	}

	/**
	 * Remove Surgeon in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSurgeon(boolean reverse) {
		if (reverse && this.surgeon != null) {
			this.surgeon.removeSurgeon(this, false);
		}
		this.surgeon = null;
	}
	/**
	 * Similar to {@link this#setSurgicalMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSurgicalMedicalTranscriber(@NotNull StaffEntity entity) {
		setSurgicalMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the surgicalMedicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to surgicalMedicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSurgicalMedicalTranscriber(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSurgicalMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSurgicalMedicalTranscriber here] end

		if (sameAsFormer(this.surgicalMedicalTranscriber, entity)) {
			return;
		}

		if (this.surgicalMedicalTranscriber != null) {
			this.surgicalMedicalTranscriber.removeSurgicalMedicalTranscriber(this, false);
		}
		this.surgicalMedicalTranscriber = entity;
		if (reverseAdd) {
			this.surgicalMedicalTranscriber.addSurgicalMedicalTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSurgicalMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSurgicalMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSurgicalMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetSurgicalMedicalTranscriber() {
		this.unsetSurgicalMedicalTranscriber(true);
	}

	/**
	 * Remove Surgical Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSurgicalMedicalTranscriber(boolean reverse) {
		if (reverse && this.surgicalMedicalTranscriber != null) {
			this.surgicalMedicalTranscriber.removeSurgicalMedicalTranscriber(this, false);
		}
		this.surgicalMedicalTranscriber = null;
	}
	/**
	 * Similar to {@link this#setSurgicalNurse(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSurgicalNurse(@NotNull StaffEntity entity) {
		setSurgicalNurse(entity, true);
	}

	/**
	 * Set or update the surgicalNurse in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to surgicalNurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSurgicalNurse(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSurgicalNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSurgicalNurse here] end

		if (sameAsFormer(this.surgicalNurse, entity)) {
			return;
		}

		if (this.surgicalNurse != null) {
			this.surgicalNurse.removeSurgicalNurse(this, false);
		}
		this.surgicalNurse = entity;
		if (reverseAdd) {
			this.surgicalNurse.addSurgicalNurse(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSurgicalNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSurgicalNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSurgicalNurse(boolean)} but default to true.
	 */
	public void unsetSurgicalNurse() {
		this.unsetSurgicalNurse(true);
	}

	/**
	 * Remove Surgical Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSurgicalNurse(boolean reverse) {
		if (reverse && this.surgicalNurse != null) {
			this.surgicalNurse.removeSurgicalNurse(this, false);
		}
		this.surgicalNurse = null;
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
		return "START_DATE_TIME,END_DATE_TIME,PHYSICAL_STATUS_EVALUATION,SURGERY_RISK,PSYCHOLOGICAL_STATE,ANESTHESIA_SURGERY_RISK,PREOPERATIVE_EVALUATION,ANESTHESIA_NOTES,SURGICAL_SPECIALTY,ANTIBIOTIC_PROPHYLAXIS_GIVEN,SURGERY_TYPE,SURGERY_CLASS,SURGICAL_SURGERY_RISK,PHYSICAL_STATUS_CLASSIFICATION,PRE_SURGERY_DIAGNOSIS,PREOPERATIVE_INSTRUCTIONS,PREOPERATIVE_SURGICAL_NOTES,ANESTHESIA_MEDICAL_TRANSCRIBER_ID,ANESTHESIOLOGIST_ID,ANESTHESIOLOGY_NURSE_ID,PRE_SURGERY_ICD_10_ID,PRE_SURGERY_ICD_9_CM_ID,OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID,PREOPERATIVE_ROOMS_ID,SURGEON_ID,SURGICAL_MEDICAL_TRANSCRIBER_ID,SURGICAL_NURSE_ID,ADDITIONAL_ANESTHESIOLOGISTS_IDS,ADDITIONAL_SURGERY_NURSES_IDS,BED_FACILITIES_IDS,CO_TREATING_ANESTHESIOLOGISTS_IDS,CO_TREATING_SURGEONS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<StaffEntity> anesthesiaMedicalTranscriberRelation = Optional.ofNullable(this.anesthesiaMedicalTranscriber);
		anesthesiaMedicalTranscriberRelation.ifPresent(entity -> this.anesthesiaMedicalTranscriberId = entity.getId());

		Optional<StaffEntity> anesthesiologistRelation = Optional.ofNullable(this.anesthesiologist);
		anesthesiologistRelation.ifPresent(entity -> this.anesthesiologistId = entity.getId());

		Optional<StaffEntity> anesthesiologyNurseRelation = Optional.ofNullable(this.anesthesiologyNurse);
		anesthesiologyNurseRelation.ifPresent(entity -> this.anesthesiologyNurseId = entity.getId());

		Optional<DiagnosesAndProceduresEntity> preSurgeryICD10Relation = Optional.ofNullable(this.preSurgeryICD10);
		preSurgeryICD10Relation.ifPresent(entity -> this.preSurgeryICD10Id = entity.getId());

		Optional<DiagnosesAndProceduresEntity> preSurgeryICD9CMRelation = Optional.ofNullable(this.preSurgeryICD9CM);
		preSurgeryICD9CMRelation.ifPresent(entity -> this.preSurgeryICD9CMId = entity.getId());

		Optional<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordRelation = Optional.ofNullable(this.operatingTheaterMedicalExaminationRecord);
		operatingTheaterMedicalExaminationRecordRelation.ifPresent(entity -> this.operatingTheaterMedicalExaminationRecordId = entity.getId());

		Optional<RoomFacilityEntity> preoperativeRoomsRelation = Optional.ofNullable(this.preoperativeRooms);
		preoperativeRoomsRelation.ifPresent(entity -> this.preoperativeRoomsId = entity.getId());

		Optional<StaffEntity> surgeonRelation = Optional.ofNullable(this.surgeon);
		surgeonRelation.ifPresent(entity -> this.surgeonId = entity.getId());

		Optional<StaffEntity> surgicalMedicalTranscriberRelation = Optional.ofNullable(this.surgicalMedicalTranscriber);
		surgicalMedicalTranscriberRelation.ifPresent(entity -> this.surgicalMedicalTranscriberId = entity.getId());

		Optional<StaffEntity> surgicalNurseRelation = Optional.ofNullable(this.surgicalNurse);
		surgicalNurseRelation.ifPresent(entity -> this.surgicalNurseId = entity.getId());

		this.additionalAnesthesiologistsIds = new HashSet<>();
		for (CoTreatingDoctorEntity additionalAnesthesiologists: this.additionalAnesthesiologists) {
			this.additionalAnesthesiologistsIds.add(additionalAnesthesiologists.getId());
		}

		this.additionalSurgeryNursesIds = new HashSet<>();
		for (CoTreatingDoctorEntity additionalSurgeryNurses: this.additionalSurgeryNurses) {
			this.additionalSurgeryNursesIds.add(additionalSurgeryNurses.getId());
		}

		this.bedFacilitiesIds = new HashSet<>();
		for (BedFacilityEntity bedFacilities: this.bedFacilities) {
			this.bedFacilitiesIds.add(bedFacilities.getId());
		}

		this.coTreatingAnesthesiologistsIds = new HashSet<>();
		for (CoTreatingDoctorEntity coTreatingAnesthesiologists: this.coTreatingAnesthesiologists) {
			this.coTreatingAnesthesiologistsIds.add(coTreatingAnesthesiologists.getId());
		}

		this.coTreatingSurgeonsIds = new HashSet<>();
		for (CoTreatingDoctorEntity coTreatingSurgeons: this.coTreatingSurgeons) {
			this.coTreatingSurgeonsIds.add(coTreatingSurgeons.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object preoperativeRecords) {
		if (this == preoperativeRecords) {
			return true;
		}
		if (preoperativeRecords == null || this.getClass() != preoperativeRecords.getClass()) {
			return false;
		}
		if (!super.equals(preoperativeRecords)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PreoperativeRecordsEntity that = (PreoperativeRecordsEntity) preoperativeRecords;
		return
			Objects.equals(
			     this.startDateTime != null ? this.startDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.startDateTime != null ? that.startDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.endDateTime != null ? this.endDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.endDateTime != null ? that.endDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.physicalStatusEvaluation, that.physicalStatusEvaluation) &&
			Objects.equals(this.surgeryRisk, that.surgeryRisk) &&
			Objects.equals(this.psychologicalState, that.psychologicalState) &&
			Objects.equals(this.anesthesiaSurgeryRisk, that.anesthesiaSurgeryRisk) &&
			Objects.equals(this.preoperativeEvaluation, that.preoperativeEvaluation) &&
			Objects.equals(this.anesthesiaNotes, that.anesthesiaNotes) &&
			Objects.equals(this.surgicalSpecialty, that.surgicalSpecialty) &&
			Objects.equals(this.antibioticProphylaxisGiven, that.antibioticProphylaxisGiven) &&
			Objects.equals(this.surgeryType, that.surgeryType) &&
			Objects.equals(this.surgeryClass, that.surgeryClass) &&
			Objects.equals(this.surgicalSurgeryRisk, that.surgicalSurgeryRisk) &&
			Objects.equals(this.physicalStatusClassification, that.physicalStatusClassification) &&
			Objects.equals(this.preSurgeryDiagnosis, that.preSurgeryDiagnosis) &&
			Objects.equals(this.preoperativeInstructions, that.preoperativeInstructions) &&
			Objects.equals(this.preoperativeSurgicalNotes, that.preoperativeSurgicalNotes) &&
			Objects.equals(this.additionalAnesthesiologistsIds, that.additionalAnesthesiologistsIds) &&
			Objects.equals(this.additionalSurgeryNursesIds, that.additionalSurgeryNursesIds) &&
			Objects.equals(this.bedFacilitiesIds, that.bedFacilitiesIds) &&
			Objects.equals(this.coTreatingAnesthesiologistsIds, that.coTreatingAnesthesiologistsIds) &&
			Objects.equals(this.coTreatingSurgeonsIds, that.coTreatingSurgeonsIds) &&
			Objects.equals(this.anesthesiaMedicalTranscriberId, that.anesthesiaMedicalTranscriberId) &&
			Objects.equals(this.anesthesiologistId, that.anesthesiologistId) &&
			Objects.equals(this.anesthesiologyNurseId, that.anesthesiologyNurseId) &&
			Objects.equals(this.preSurgeryICD10Id, that.preSurgeryICD10Id) &&
			Objects.equals(this.preSurgeryICD9CMId, that.preSurgeryICD9CMId) &&
			Objects.equals(this.operatingTheaterMedicalExaminationRecordId, that.operatingTheaterMedicalExaminationRecordId) &&
			Objects.equals(this.preoperativeRoomsId, that.preoperativeRoomsId) &&
			Objects.equals(this.surgeonId, that.surgeonId) &&
			Objects.equals(this.surgicalMedicalTranscriberId, that.surgicalMedicalTranscriberId) &&
			Objects.equals(this.surgicalNurseId, that.surgicalNurseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
