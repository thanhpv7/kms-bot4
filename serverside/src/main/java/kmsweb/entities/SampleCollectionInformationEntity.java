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
import kmsweb.dtos.SampleCollectionInformationEntityDto;
import kmsweb.entities.listeners.SampleCollectionInformationEntityListener;
import kmsweb.serializers.SampleCollectionInformationSerializer;
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

import java.util.*;
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
@EntityListeners({SampleCollectionInformationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = SampleCollectionInformationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class SampleCollectionInformationEntity extends AbstractEntity {

	/**
	 * Takes a SampleCollectionInformationEntityDto and converts it into a SampleCollectionInformationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param sampleCollectionInformationEntityDto
	 */
	public SampleCollectionInformationEntity(SampleCollectionInformationEntityDto sampleCollectionInformationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (sampleCollectionInformationEntityDto.getId() != null) {
			this.setId(sampleCollectionInformationEntityDto.getId());
		}

		if (sampleCollectionInformationEntityDto.getPatientInformed() != null) {
			this.setPatientInformed(sampleCollectionInformationEntityDto.getPatientInformed());
		}

		if (sampleCollectionInformationEntityDto.getPatientConsented() != null) {
			this.setPatientConsented(sampleCollectionInformationEntityDto.getPatientConsented());
		}

		if (sampleCollectionInformationEntityDto.getPatientFastedEnough() != null) {
			this.setPatientFastedEnough(sampleCollectionInformationEntityDto.getPatientFastedEnough());
		}

		if (sampleCollectionInformationEntityDto.getMedicationTakenIn24Hours() != null) {
			this.setMedicationTakenIn24Hours(sampleCollectionInformationEntityDto.getMedicationTakenIn24Hours());
		}

		if (sampleCollectionInformationEntityDto.getMedicationTakenIn72Hours() != null) {
			this.setMedicationTakenIn72Hours(sampleCollectionInformationEntityDto.getMedicationTakenIn72Hours());
		}

		if (sampleCollectionInformationEntityDto.getSampleCollectionItems() != null) {
			this.setSampleCollectionItems(sampleCollectionInformationEntityDto.getSampleCollectionItems());
		}

		if (sampleCollectionInformationEntityDto.getDiagnosisExaminationRecord() != null) {
			this.setDiagnosisExaminationRecord(sampleCollectionInformationEntityDto.getDiagnosisExaminationRecord());
		}

		if (sampleCollectionInformationEntityDto.getRegistration() != null) {
			this.setRegistration(sampleCollectionInformationEntityDto.getRegistration());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Patient Informed here] off begin
	@CsvBindByName(column = "PATIENT_INFORMED", required = false)
	@Nullable
	@Column(name = "patient_informed")
	@Schema(description = "The Patient Informed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Informed here] end
	private Boolean patientInformed = false ;

	// % protected region % [Modify attribute annotation for Patient Consented here] off begin
	@CsvBindByName(column = "PATIENT_CONSENTED", required = false)
	@Nullable
	@Column(name = "patient_consented")
	@Schema(description = "The Patient Consented of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Consented here] end
	private Boolean patientConsented = false ;

	// % protected region % [Modify attribute annotation for Patient Fasted Enough here] off begin
	@CsvBindByName(column = "PATIENT_FASTED_ENOUGH", required = false)
	@Nullable
	@Column(name = "patient_fasted_enough")
	@Schema(description = "The Patient Fasted Enough of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Fasted Enough here] end
	private Boolean patientFastedEnough = false ;

	// % protected region % [Modify attribute annotation for Medication Taken In 24 Hours here] off begin
	@CsvBindByName(column = "MEDICATION_TAKEN_IN_24_HOURS", required = false)
	@Nullable
	@Column(name = "medication_taken_in_24_hours")
	@Schema(description = "The Medication Taken In 24 Hours of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medication Taken In 24 Hours here] end
	private Boolean medicationTakenIn24Hours = false ;

	// % protected region % [Modify attribute annotation for Medication Taken In 72 Hours here] off begin
	@CsvBindByName(column = "MEDICATION_TAKEN_IN_72_HOURS", required = false)
	@Nullable
	@Column(name = "medication_taken_in_72_hours")
	@Schema(description = "The Medication Taken In 72 Hours of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medication Taken In 72 Hours here] end
	private Boolean medicationTakenIn72Hours = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Sample Collection Items here] off begin
	@Schema(description = "The Sample Collection Items entities that are related to this entity.")
	@OneToMany(mappedBy = "sampleCollectionInformation", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Collection Items here] end
	private Set<SampleCollectionItemsEntity> sampleCollectionItems = new HashSet<>();

	// % protected region % [Update the annotation for sampleCollectionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for sampleCollectionItemsIds here] end
	private Set<UUID> sampleCollectionItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addSampleCollectionItems(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionItems(@NotNull SampleCollectionItemsEntity entity) {
		addSampleCollectionItems(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleCollectionItems in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleCollectionItems(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleCollectionItems.contains(entity)) {
			sampleCollectionItems.add(entity);
			if (reverseAdd) {
				entity.setSampleCollectionInformation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleCollectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionItems(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleCollectionItems(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Collection Items in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleCollectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleCollectionItems(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleCollectionItems(@NotNull SampleCollectionItemsEntity entity) {
		this.removeSampleCollectionItems(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleCollectionItems(@NotNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleCollectionInformation(false);
		}
		this.sampleCollectionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleCollectionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleCollectionItems(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleCollectionItems(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleCollectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleCollectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleCollectionItems(@NotNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleCollectionItems(entities, true);
	}

	/**
	 * Replace the current entities in Sample Collection Items with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleCollectionItems(@NotNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleCollectionItems();
		this.sampleCollectionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleCollectionItems.forEach(sampleCollectionItemsEntity -> sampleCollectionItemsEntity.setSampleCollectionInformation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleCollectionItems() {
		this.unsetSampleCollectionItems(true);
	}

	/**
	 * Remove all the entities in Sample Collection Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleCollectionItems(boolean doReverse) {
		if (doReverse) {
			this.sampleCollectionItems.forEach(sampleCollectionItemsEntity -> sampleCollectionItemsEntity.unsetSampleCollectionInformation(false));
		}
		this.sampleCollectionItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.diagnosisExaminationRecord.unsetSampleCollectionInformation(false);
		}

		this.diagnosisExaminationRecord = entity;
		if (reverseAdd) {
			this.diagnosisExaminationRecord.setSampleCollectionInformation(this, false);
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
			this.diagnosisExaminationRecord.unsetSampleCollectionInformation();
		}
		this.diagnosisExaminationRecord = null;
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
			this.registration.removeSampleCollectionInformations(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addSampleCollectionInformations(this, false);
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
			this.registration.removeSampleCollectionInformations(this, false);
		}
		this.registration = null;
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
		return "PATIENT_INFORMED,PATIENT_CONSENTED,PATIENT_FASTED_ENOUGH,MEDICATION_TAKEN_IN_24_HOURS,MEDICATION_TAKEN_IN_72_HOURS,DIAGNOSIS_EXAMINATION_RECORD_ID,REGISTRATION_ID,SAMPLE_COLLECTION_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordRelation = Optional.ofNullable(this.diagnosisExaminationRecord);
		diagnosisExaminationRecordRelation.ifPresent(entity -> this.diagnosisExaminationRecordId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		this.sampleCollectionItemsIds = new HashSet<>();
		for (SampleCollectionItemsEntity sampleCollectionItems: this.sampleCollectionItems) {
			this.sampleCollectionItemsIds.add(sampleCollectionItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object sampleCollectionInformation) {
		if (this == sampleCollectionInformation) {
			return true;
		}
		if (sampleCollectionInformation == null || this.getClass() != sampleCollectionInformation.getClass()) {
			return false;
		}
		if (!super.equals(sampleCollectionInformation)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		SampleCollectionInformationEntity that = (SampleCollectionInformationEntity) sampleCollectionInformation;
		return
			Objects.equals(this.patientInformed, that.patientInformed) &&
			Objects.equals(this.patientConsented, that.patientConsented) &&
			Objects.equals(this.patientFastedEnough, that.patientFastedEnough) &&
			Objects.equals(this.medicationTakenIn24Hours, that.medicationTakenIn24Hours) &&
			Objects.equals(this.medicationTakenIn72Hours, that.medicationTakenIn72Hours) &&
			Objects.equals(this.sampleCollectionItemsIds, that.sampleCollectionItemsIds) &&
			Objects.equals(this.diagnosisExaminationRecordId, that.diagnosisExaminationRecordId) &&
			Objects.equals(this.registrationId, that.registrationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
