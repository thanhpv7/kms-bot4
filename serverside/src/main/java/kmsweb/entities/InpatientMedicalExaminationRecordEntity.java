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
import kmsweb.dtos.InpatientMedicalExaminationRecordEntityDto;
import kmsweb.entities.listeners.InpatientMedicalExaminationRecordEntityListener;
import kmsweb.serializers.InpatientMedicalExaminationRecordSerializer;
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
@EntityListeners({InpatientMedicalExaminationRecordEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InpatientMedicalExaminationRecordSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InpatientMedicalExaminationRecordEntity extends AbstractEntity {

	/**
	 * Takes a InpatientMedicalExaminationRecordEntityDto and converts it into a InpatientMedicalExaminationRecordEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param inpatientMedicalExaminationRecordEntityDto
	 */
	public InpatientMedicalExaminationRecordEntity(InpatientMedicalExaminationRecordEntityDto inpatientMedicalExaminationRecordEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (inpatientMedicalExaminationRecordEntityDto.getId() != null) {
			this.setId(inpatientMedicalExaminationRecordEntityDto.getId());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getStartDateTime() != null) {
			this.setStartDateTime(inpatientMedicalExaminationRecordEntityDto.getStartDateTime());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getEndDateTime() != null) {
			this.setEndDateTime(inpatientMedicalExaminationRecordEntityDto.getEndDateTime());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(inpatientMedicalExaminationRecordEntityDto.getTreatmentClass());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getInpatientCase() != null) {
			this.setInpatientCase(inpatientMedicalExaminationRecordEntityDto.getInpatientCase());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getServiceCase() != null) {
			this.setServiceCase(inpatientMedicalExaminationRecordEntityDto.getServiceCase());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getDependencyLevel() != null) {
			this.setDependencyLevel(inpatientMedicalExaminationRecordEntityDto.getDependencyLevel());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getCurrentDependency() != null) {
			this.setCurrentDependency(inpatientMedicalExaminationRecordEntityDto.getCurrentDependency());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getInfantCondition() != null) {
			this.setInfantCondition(inpatientMedicalExaminationRecordEntityDto.getInfantCondition());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getNeonatalCase() != null) {
			this.setNeonatalCase(inpatientMedicalExaminationRecordEntityDto.getNeonatalCase());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(inpatientMedicalExaminationRecordEntityDto.getMedicalExaminationRecord());
		}

		if (inpatientMedicalExaminationRecordEntityDto.getBedFacility() != null) {
			this.setBedFacility(inpatientMedicalExaminationRecordEntityDto.getBedFacility());
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

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Inpatient Case here] off begin
	@CsvBindByName(column = "INPATIENT_CASE", required = false)
	@Nullable
	@Column(name = "inpatient_case")
	@Schema(description = "The Inpatient Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inpatient Case here] end
	private String inpatientCase;

	// % protected region % [Modify attribute annotation for Service Case here] off begin
	@CsvBindByName(column = "SERVICE_CASE", required = false)
	@Nullable
	@Column(name = "service_case")
	@Schema(description = "The Service Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Case here] end
	private String serviceCase;

	// % protected region % [Modify attribute annotation for Dependency Level here] off begin
	@CsvBindByName(column = "DEPENDENCY_LEVEL", required = false)
	@Nullable
	@Column(name = "dependency_level")
	@Schema(description = "The Dependency Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dependency Level here] end
	private String dependencyLevel;

	// % protected region % [Modify attribute annotation for Current Dependency here] off begin
	@CsvBindByName(column = "CURRENT_DEPENDENCY", required = false)
	@Nullable
	@Column(name = "current_dependency")
	@Schema(description = "The Current Dependency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Current Dependency here] end
	private String currentDependency;

	// % protected region % [Modify attribute annotation for Infant Condition here] off begin
	@CsvBindByName(column = "INFANT_CONDITION", required = false)
	@Nullable
	@Column(name = "infant_condition")
	@Schema(description = "The Infant Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Infant Condition here] end
	private String infantCondition;

	// % protected region % [Modify attribute annotation for Neonatal Case here] off begin
	@CsvBindByName(column = "NEONATAL_CASE", required = false)
	@Nullable
	@Column(name = "neonatal_case")
	@Schema(description = "The Neonatal Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Neonatal Case here] end
	private String neonatalCase;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(mappedBy = "inpatientMedicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Bed Facility here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facility here] end
	private BedFacilityEntity bedFacility;

	// % protected region % [Update the annotation for bedFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bedFacilityId here] end
	private UUID bedFacilityId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update medicalExaminationRecord with the given MedicalExaminationRecordEntity.
	 *
	 * @param entity the InpatientMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetInpatientMedicalExaminationRecord();
		}

		this.medicalExaminationRecord = entity;

		if (reverseAdd) {
			this.medicalExaminationRecord.setInpatientMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity in Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetInpatientMedicalExaminationRecord(false);
		}
		this.medicalExaminationRecord = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeInpatientMedicalExaminationRecords(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addInpatientMedicalExaminationRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBedFacility(boolean)} but default to true.
	 */
	public void unsetBedFacility() {
		this.unsetBedFacility(true);
	}

	/**
	 * Remove Bed Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBedFacility(boolean reverse) {
		if (reverse && this.bedFacility != null) {
			this.bedFacility.removeInpatientMedicalExaminationRecords(this, false);
		}
		this.bedFacility = null;
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
		return "START_DATE_TIME,END_DATE_TIME,TREATMENT_CLASS,INPATIENT_CASE,SERVICE_CASE,DEPENDENCY_LEVEL,CURRENT_DEPENDENCY,INFANT_CONDITION,NEONATAL_CASE,BED_FACILITY_ID,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BedFacilityEntity> bedFacilityRelation = Optional.ofNullable(this.bedFacility);
		bedFacilityRelation.ifPresent(entity -> this.bedFacilityId = entity.getId());

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object inpatientMedicalExaminationRecord) {
		if (this == inpatientMedicalExaminationRecord) {
			return true;
		}
		if (inpatientMedicalExaminationRecord == null || this.getClass() != inpatientMedicalExaminationRecord.getClass()) {
			return false;
		}
		if (!super.equals(inpatientMedicalExaminationRecord)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InpatientMedicalExaminationRecordEntity that = (InpatientMedicalExaminationRecordEntity) inpatientMedicalExaminationRecord;
		return
			Objects.equals(
			     this.startDateTime != null ? this.startDateTime.truncatedTo(ChronoUnit.DAYS) : null,
			     that.startDateTime != null ? that.startDateTime.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.endDateTime != null ? this.endDateTime.truncatedTo(ChronoUnit.DAYS) : null,
			     that.endDateTime != null ? that.endDateTime.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.inpatientCase, that.inpatientCase) &&
			Objects.equals(this.serviceCase, that.serviceCase) &&
			Objects.equals(this.dependencyLevel, that.dependencyLevel) &&
			Objects.equals(this.currentDependency, that.currentDependency) &&
			Objects.equals(this.infantCondition, that.infantCondition) &&
			Objects.equals(this.neonatalCase, that.neonatalCase) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.bedFacilityId, that.bedFacilityId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
