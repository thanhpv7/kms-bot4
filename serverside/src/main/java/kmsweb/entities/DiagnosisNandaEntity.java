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
import kmsweb.dtos.DiagnosisNandaEntityDto;
import kmsweb.entities.listeners.DiagnosisNandaEntityListener;
import kmsweb.serializers.DiagnosisNandaSerializer;
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
@EntityListeners({DiagnosisNandaEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DiagnosisNandaSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DiagnosisNandaEntity extends AbstractEntity {

	/**
	 * Takes a DiagnosisNandaEntityDto and converts it into a DiagnosisNandaEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param diagnosisNandaEntityDto
	 */
	public DiagnosisNandaEntity(DiagnosisNandaEntityDto diagnosisNandaEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (diagnosisNandaEntityDto.getId() != null) {
			this.setId(diagnosisNandaEntityDto.getId());
		}

		if (diagnosisNandaEntityDto.getNursingNotes() != null) {
			this.setNursingNotes(diagnosisNandaEntityDto.getNursingNotes());
		}

		if (diagnosisNandaEntityDto.getSequence() != null) {
			this.setSequence(diagnosisNandaEntityDto.getSequence());
		}

		if (diagnosisNandaEntityDto.getNursingAnesthesiaDetail() != null) {
			this.setNursingAnesthesiaDetail(diagnosisNandaEntityDto.getNursingAnesthesiaDetail());
		}

		if (diagnosisNandaEntityDto.getNursingSurgicalDetail() != null) {
			this.setNursingSurgicalDetail(diagnosisNandaEntityDto.getNursingSurgicalDetail());
		}

		if (diagnosisNandaEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(diagnosisNandaEntityDto.getMedicalExaminationRecord());
		}

		if (diagnosisNandaEntityDto.getNursing() != null) {
			this.setNursing(diagnosisNandaEntityDto.getNursing());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Nursing Notes here] off begin
	@CsvBindByName(column = "NURSING_NOTES", required = false)
	@Nullable
	@Column(name = "nursing_notes")
	@Schema(description = "The Nursing Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nursing Notes here] end
	private String nursingNotes;

	// % protected region % [Modify attribute annotation for Sequence here] off begin
	@CsvBindByName(column = "SEQUENCE", required = false)
	@Nullable
	@Column(name = "sequence")
	@Schema(description = "The Sequence of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sequence here] end
	private Integer sequence;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Nursing Anesthesia Detail here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "nursingAnesthesiaDetail", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Anesthesia Detail here] end
	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingAnesthesiaDetail = new HashSet<>();

	// % protected region % [Update the annotation for nursingAnesthesiaDetailIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_ANESTHESIA_DETAIL_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for nursingAnesthesiaDetailIds here] end
	private Set<UUID> nursingAnesthesiaDetailIds = new HashSet<>();

	// % protected region % [Update the annotation for Nursing Surgical Detail here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "nursingSurgicalDetail", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Surgical Detail here] end
	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingSurgicalDetail = new HashSet<>();

	// % protected region % [Update the annotation for nursingSurgicalDetailIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_SURGICAL_DETAIL_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for nursingSurgicalDetailIds here] end
	private Set<UUID> nursingSurgicalDetailIds = new HashSet<>();

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

	// % protected region % [Update the annotation for NURSING here] off begin
	@Schema(description = "The NURSING entities that are related to this entity.")
	@ManyToMany(mappedBy = "diagnosisNandas", fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for NURSING here] end
	private Set<DiagnosesAndProceduresEntity> nursing = new HashSet<>();

	// % protected region % [Update the annotation for nursingIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for nursingIds here] end
	private Set<UUID> nursingIds = new HashSet<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addNursingAnesthesiaDetail(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingAnesthesiaDetail(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		addNursingAnesthesiaDetail(entity, true);
	}

	/**
	 * Add a new OperatingTheaterMedicalExaminationRecordEntity to nursingAnesthesiaDetail in this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursingAnesthesiaDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nursingAnesthesiaDetail.contains(entity)) {
			nursingAnesthesiaDetail.add(entity);
			if (reverseAdd) {
				entity.setNursingAnesthesiaDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursingAnesthesiaDetail(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingAnesthesiaDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		addNursingAnesthesiaDetail(entities, true);
	}

	/**
	 * Add a new collection of OperatingTheaterMedicalExaminationRecordEntity to Nursing Anesthesia Detail in this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursingAnesthesiaDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNursingAnesthesiaDetail(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursingAnesthesiaDetail(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNursingAnesthesiaDetail(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingAnesthesiaDetail(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingAnesthesiaDetail(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNursingAnesthesiaDetail(false);
		}
		this.nursingAnesthesiaDetail.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursingAnesthesiaDetail(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNursingAnesthesiaDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		this.removeNursingAnesthesiaDetail(entities, true);
	}

	/**
	 * Remove the given collection of OperatingTheaterMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNursingAnesthesiaDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNursingAnesthesiaDetail(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNursingAnesthesiaDetail(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNursingAnesthesiaDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingAnesthesiaDetail(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Anesthesia Detail with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingAnesthesiaDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNursingAnesthesiaDetail();
		this.nursingAnesthesiaDetail = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursingAnesthesiaDetail.forEach(nursingAnesthesiaDetailEntity -> nursingAnesthesiaDetailEntity.setNursingAnesthesiaDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNursingAnesthesiaDetail(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNursingAnesthesiaDetail() {
		this.unsetNursingAnesthesiaDetail(true);
	}

	/**
	 * Remove all the entities in Nursing Anesthesia Detail from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNursingAnesthesiaDetail(boolean doReverse) {
		if (doReverse) {
			this.nursingAnesthesiaDetail.forEach(nursingAnesthesiaDetailEntity -> nursingAnesthesiaDetailEntity.unsetNursingAnesthesiaDetail(false));
		}
		this.nursingAnesthesiaDetail.clear();
	}

/**
	 * Similar to {@link this#addNursingSurgicalDetail(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingSurgicalDetail(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		addNursingSurgicalDetail(entity, true);
	}

	/**
	 * Add a new OperatingTheaterMedicalExaminationRecordEntity to nursingSurgicalDetail in this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursingSurgicalDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nursingSurgicalDetail.contains(entity)) {
			nursingSurgicalDetail.add(entity);
			if (reverseAdd) {
				entity.setNursingSurgicalDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursingSurgicalDetail(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingSurgicalDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		addNursingSurgicalDetail(entities, true);
	}

	/**
	 * Add a new collection of OperatingTheaterMedicalExaminationRecordEntity to Nursing Surgical Detail in this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursingSurgicalDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNursingSurgicalDetail(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursingSurgicalDetail(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNursingSurgicalDetail(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingSurgicalDetail(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingSurgicalDetail(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNursingSurgicalDetail(false);
		}
		this.nursingSurgicalDetail.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursingSurgicalDetail(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNursingSurgicalDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		this.removeNursingSurgicalDetail(entities, true);
	}

	/**
	 * Remove the given collection of OperatingTheaterMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNursingSurgicalDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNursingSurgicalDetail(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNursingSurgicalDetail(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNursingSurgicalDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingSurgicalDetail(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Surgical Detail with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingSurgicalDetail(@NotNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNursingSurgicalDetail();
		this.nursingSurgicalDetail = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursingSurgicalDetail.forEach(nursingSurgicalDetailEntity -> nursingSurgicalDetailEntity.setNursingSurgicalDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNursingSurgicalDetail(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNursingSurgicalDetail() {
		this.unsetNursingSurgicalDetail(true);
	}

	/**
	 * Remove all the entities in Nursing Surgical Detail from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNursingSurgicalDetail(boolean doReverse) {
		if (doReverse) {
			this.nursingSurgicalDetail.forEach(nursingSurgicalDetailEntity -> nursingSurgicalDetailEntity.unsetNursingSurgicalDetail(false));
		}
		this.nursingSurgicalDetail.clear();
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
			this.medicalExaminationRecord.removeDiagnosisNandas(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addDiagnosisNandas(this, false);
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
			this.medicalExaminationRecord.removeDiagnosisNandas(this, false);
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#addNursing(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be added to nursing
	 */
	public void addNursing(@NotNull DiagnosesAndProceduresEntity entity) {
		this.addNursing(entity, true);
	}

	/**
	 * Add a new DiagnosesAndProceduresEntity to nursing in this entity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be added to nursing
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursing(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		if (!this.nursing.contains(entity)) {
			this.nursing.add(entity);
			if (reverseAdd) {
				entity.addDiagnosisNandas(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to be added into nursing
	 */
	public void addNursing(@NotNull Collection<DiagnosesAndProceduresEntity> entities) {
		this.addNursing(entities, true);
	}

	/**
	 * Add new collection of DiagnosesAndProceduresEntity to nursing in this entity.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to be added into nursing in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursing(@NonNull Collection<DiagnosesAndProceduresEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursing(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to nursing in this entity
	 */
	public void removeNursing(@NotNull DiagnosesAndProceduresEntity entity) {
		this.removeNursing(entity, true);
	}

	/**
	 * Remove the given DiagnosesAndProceduresEntity from nursing in this entity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be removed from nursing
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursing(@NotNull DiagnosesAndProceduresEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeDiagnosisNandas(this, false);
		}
		this.nursing.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to be removed from nursing in this entity
	 */
	public void removeNursing(@NotNull Collection<DiagnosesAndProceduresEntity> entities) {
		this.removeNursing(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosesAndProceduresEntity from nursing in this entity.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to be removed from nursing
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeNursing(@NonNull Collection<DiagnosesAndProceduresEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeNursing(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to replace the old ones in nursing
	 */
	public void setNursing(@NotNull Collection<DiagnosesAndProceduresEntity> entities) {
		this.setNursing(entities, true);
	}

	/**
	 * Replace the current collection of DiagnosesAndProceduresEntity in nursing with the given ones.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to replace the old ones in nursing
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursing(@NotNull Collection<DiagnosesAndProceduresEntity> entities, boolean reverseAdd) {
		unsetNursing();
		this.nursing = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursing.forEach(nursingEntity -> nursingEntity.addDiagnosisNandas(this, false));
		}
	}

	/**
	 * Remove all entities in NURSING from this entity.
	 */
	public void unsetNursing() {
		this.nursing.forEach(entity -> entity.removeDiagnosisNandas(this, false));
		this.nursing.clear();
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
		return "NURSING_NOTES,SEQUENCE,MEDICAL_EXAMINATION_RECORD_ID,NURSING_IDS,NURSING_ANESTHESIA_DETAIL_IDS,NURSING_SURGICAL_DETAIL_IDS,ID";
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

		this.nursingIds = new HashSet<>();
		for (DiagnosesAndProceduresEntity nursing: this.nursing) {
			this.nursingIds.add(nursing.getId());
		}

		this.nursingAnesthesiaDetailIds = new HashSet<>();
		for (OperatingTheaterMedicalExaminationRecordEntity nursingAnesthesiaDetail: this.nursingAnesthesiaDetail) {
			this.nursingAnesthesiaDetailIds.add(nursingAnesthesiaDetail.getId());
		}

		this.nursingSurgicalDetailIds = new HashSet<>();
		for (OperatingTheaterMedicalExaminationRecordEntity nursingSurgicalDetail: this.nursingSurgicalDetail) {
			this.nursingSurgicalDetailIds.add(nursingSurgicalDetail.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object diagnosisNanda) {
		if (this == diagnosisNanda) {
			return true;
		}
		if (diagnosisNanda == null || this.getClass() != diagnosisNanda.getClass()) {
			return false;
		}
		if (!super.equals(diagnosisNanda)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DiagnosisNandaEntity that = (DiagnosisNandaEntity) diagnosisNanda;
		return
			Objects.equals(this.nursingNotes, that.nursingNotes) &&
			Objects.equals(this.sequence, that.sequence) &&
			Objects.equals(this.nursingAnesthesiaDetailIds, that.nursingAnesthesiaDetailIds) &&
			Objects.equals(this.nursingSurgicalDetailIds, that.nursingSurgicalDetailIds) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
