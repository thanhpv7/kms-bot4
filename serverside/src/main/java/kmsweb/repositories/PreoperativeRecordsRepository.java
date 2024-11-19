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
package kmsweb.repositories;

import kmsweb.entities.PreoperativeRecordsEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface PreoperativeRecordsRepository extends AbstractRepository<PreoperativeRecordsEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Start Date Time.
	 *
	 * @param startDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date Time
	 */
	List<PreoperativeRecordsEntity> findByStartDateTime(@NotNull OffsetDateTime startDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute End Date Time.
	 *
	 * @param endDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date Time
	 */
	List<PreoperativeRecordsEntity> findByEndDateTime(@NotNull OffsetDateTime endDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Physical Status Evaluation.
	 *
	 * @param physicalStatusEvaluation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physical Status Evaluation
	 */
	List<PreoperativeRecordsEntity> findByPhysicalStatusEvaluation(@NotNull String physicalStatusEvaluation);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Risk.
	 *
	 * @param surgeryRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Risk
	 */
	List<PreoperativeRecordsEntity> findBySurgeryRisk(@NotNull String surgeryRisk);
	/**
	 * Return an entity or a list of entities that have the given attribute Psychological State.
	 *
	 * @param psychologicalState the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Psychological State
	 */
	List<PreoperativeRecordsEntity> findByPsychologicalState(@NotNull String psychologicalState);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Surgery Risk.
	 *
	 * @param anesthesiaSurgeryRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Surgery Risk
	 */
	List<PreoperativeRecordsEntity> findByAnesthesiaSurgeryRisk(@NotNull String anesthesiaSurgeryRisk);
	/**
	 * Return an entity or a list of entities that have the given attribute Preoperative Evaluation.
	 *
	 * @param preoperativeEvaluation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preoperative Evaluation
	 */
	List<PreoperativeRecordsEntity> findByPreoperativeEvaluation(@NotNull String preoperativeEvaluation);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Notes.
	 *
	 * @param anesthesiaNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Notes
	 */
	List<PreoperativeRecordsEntity> findByAnesthesiaNotes(@NotNull String anesthesiaNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgical Specialty.
	 *
	 * @param surgicalSpecialty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgical Specialty
	 */
	List<PreoperativeRecordsEntity> findBySurgicalSpecialty(@NotNull String surgicalSpecialty);
	/**
	 * Return an entity or a list of entities that have the given attribute Antibiotic Prophylaxis Given.
	 *
	 * @param antibioticProphylaxisGiven the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Antibiotic Prophylaxis Given
	 */
	List<PreoperativeRecordsEntity> findByAntibioticProphylaxisGiven(@NotNull String antibioticProphylaxisGiven);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Type.
	 *
	 * @param surgeryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Type
	 */
	List<PreoperativeRecordsEntity> findBySurgeryType(@NotNull String surgeryType);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Class.
	 *
	 * @param surgeryClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Class
	 */
	List<PreoperativeRecordsEntity> findBySurgeryClass(@NotNull String surgeryClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgical Surgery Risk.
	 *
	 * @param surgicalSurgeryRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgical Surgery Risk
	 */
	List<PreoperativeRecordsEntity> findBySurgicalSurgeryRisk(@NotNull String surgicalSurgeryRisk);
	/**
	 * Return an entity or a list of entities that have the given attribute Physical Status Classification.
	 *
	 * @param physicalStatusClassification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physical Status Classification
	 */
	List<PreoperativeRecordsEntity> findByPhysicalStatusClassification(@NotNull String physicalStatusClassification);
	/**
	 * Return an entity or a list of entities that have the given attribute Pre Surgery Diagnosis.
	 *
	 * @param preSurgeryDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pre Surgery Diagnosis
	 */
	List<PreoperativeRecordsEntity> findByPreSurgeryDiagnosis(@NotNull String preSurgeryDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute Preoperative Instructions.
	 *
	 * @param preoperativeInstructions the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preoperative Instructions
	 */
	List<PreoperativeRecordsEntity> findByPreoperativeInstructions(@NotNull String preoperativeInstructions);
	/**
	 * Return an entity or a list of entities that have the given attribute Preoperative Surgical Notes.
	 *
	 * @param preoperativeSurgicalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preoperative Surgical Notes
	 */
	List<PreoperativeRecordsEntity> findByPreoperativeSurgicalNotes(@NotNull String preoperativeSurgicalNotes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PreoperativeRecordsEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PreoperativeRecordsEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}