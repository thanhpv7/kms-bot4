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

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class DiagnosisNandaEntity extends AbstractEntity {

	public DiagnosisNandaEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneMany = new EntityReference();
			MedicalExaminationRecordOneMany.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.name = "DiagnosisNandas";
			MedicalExaminationRecordOneMany.optional = true;
			MedicalExaminationRecordOneMany.type = "One";
			MedicalExaminationRecordOneMany.oppositeType = "Many";

		References.add(MedicalExaminationRecordOneMany);

		var NursingManyMany = new EntityReference();
			NursingManyMany.entityName = "DiagnosesAndProcedures";
			NursingManyMany.oppositeName = "Nursing";
			NursingManyMany.name = "DiagnosisNandas";
			NursingManyMany.optional = true;
			NursingManyMany.type = "Many";
			NursingManyMany.oppositeType = "Many";

		References.add(NursingManyMany);

		var NursingAnesthesiaDetailOneMany = new EntityReference();
			NursingAnesthesiaDetailOneMany.entityName = "OperatingTheaterMedicalExaminationRecord";
			NursingAnesthesiaDetailOneMany.oppositeName = "NursingAnesthesiaDetail";
			NursingAnesthesiaDetailOneMany.name = "NursingAnesthesiaDetail";
			NursingAnesthesiaDetailOneMany.optional = true;
			NursingAnesthesiaDetailOneMany.type = "One";
			NursingAnesthesiaDetailOneMany.oppositeType = "Many";

		References.add(NursingAnesthesiaDetailOneMany);

		var NursingSurgicalDetailOneMany = new EntityReference();
			NursingSurgicalDetailOneMany.entityName = "OperatingTheaterMedicalExaminationRecord";
			NursingSurgicalDetailOneMany.oppositeName = "NursingSurgicalDetail";
			NursingSurgicalDetailOneMany.name = "NursingSurgicalDetail";
			NursingSurgicalDetailOneMany.optional = true;
			NursingSurgicalDetailOneMany.type = "One";
			NursingSurgicalDetailOneMany.oppositeType = "Many";

		References.add(NursingSurgicalDetailOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Nursing Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nursing Notes here] end
	private String nursingNotes;

	// % protected region % [Modify attribute annotation for Sequence here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sequence here] end
	private Integer sequence;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingAnesthesiaDetail = new HashSet<>();

	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingSurgicalDetail = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<DiagnosesAndProceduresEntity> nursing = new HashSet<>();

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
	public void addNursingAnesthesiaDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
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
	public void addNursingAnesthesiaDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
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
	public void removeNursingAnesthesiaDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingAnesthesiaDetail(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingAnesthesiaDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
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
	public void removeNursingAnesthesiaDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
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
	public void setNursingAnesthesiaDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingAnesthesiaDetail(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Anesthesia Detail with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingAnesthesiaDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

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
	public void addNursingSurgicalDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
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
	public void addNursingSurgicalDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
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
	public void removeNursingSurgicalDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingSurgicalDetail(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingSurgicalDetail(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
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
	public void removeNursingSurgicalDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
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
	public void setNursingSurgicalDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingSurgicalDetail(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Surgical Detail with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingSurgicalDetail(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

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
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
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
	public void addNursing(@NonNull DiagnosesAndProceduresEntity entity) {
		this.addNursing(entity, true);
	}

	/**
	 * Add a new DiagnosesAndProceduresEntity to nursing in this entity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be added to nursing
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursing(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
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
	public void addNursing(@NonNull Collection<DiagnosesAndProceduresEntity> entities) {
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
	public void removeNursing(@NonNull DiagnosesAndProceduresEntity entity) {
		this.removeNursing(entity, true);
	}

	/**
	 * Remove the given DiagnosesAndProceduresEntity from nursing in this entity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be removed from nursing
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursing(@NonNull DiagnosesAndProceduresEntity entity, boolean reverse) {
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
	public void removeNursing(@NonNull Collection<DiagnosesAndProceduresEntity> entities) {
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
	public void setNursing(@NonNull Collection<DiagnosesAndProceduresEntity> entities) {
		this.setNursing(entities, true);
	}

	/**
	 * Replace the current collection of DiagnosesAndProceduresEntity in nursing with the given ones.
	 *
	 * @param entities the given collection of DiagnosesAndProceduresEntity to replace the old ones in nursing
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursing(@NonNull Collection<DiagnosesAndProceduresEntity> entities, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
