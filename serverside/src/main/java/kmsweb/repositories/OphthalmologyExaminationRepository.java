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

import kmsweb.entities.OphthalmologyExaminationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface OphthalmologyExaminationRepository extends AbstractRepository<OphthalmologyExaminationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Right Eyelid Subjective.
	 *
	 * @param rightEyelidSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Eyelid Subjective
	 */
	List<OphthalmologyExaminationEntity> findByRightEyelidSubjective(@NotNull String rightEyelidSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Eyelid Objective.
	 *
	 * @param rightEyelidObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Eyelid Objective
	 */
	List<OphthalmologyExaminationEntity> findByRightEyelidObjective(@NotNull String rightEyelidObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Pupil Subjective.
	 *
	 * @param rightPupilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Pupil Subjective
	 */
	List<OphthalmologyExaminationEntity> findByRightPupilSubjective(@NotNull String rightPupilSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Pupil Objective.
	 *
	 * @param rightPupilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Pupil Objective
	 */
	List<OphthalmologyExaminationEntity> findByRightPupilObjective(@NotNull String rightPupilObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Sclera Subjective.
	 *
	 * @param rightScleraSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Sclera Subjective
	 */
	List<OphthalmologyExaminationEntity> findByRightScleraSubjective(@NotNull String rightScleraSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Sclera Objective.
	 *
	 * @param rightScleraObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Sclera Objective
	 */
	List<OphthalmologyExaminationEntity> findByRightScleraObjective(@NotNull String rightScleraObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Iris Subjective.
	 *
	 * @param rightIrisSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Iris Subjective
	 */
	List<OphthalmologyExaminationEntity> findByRightIrisSubjective(@NotNull String rightIrisSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Iris Objective.
	 *
	 * @param rightIrisObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Iris Objective
	 */
	List<OphthalmologyExaminationEntity> findByRightIrisObjective(@NotNull String rightIrisObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Eyelid Subjective.
	 *
	 * @param leftEyelidSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Eyelid Subjective
	 */
	List<OphthalmologyExaminationEntity> findByLeftEyelidSubjective(@NotNull String leftEyelidSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Eyelid Objective.
	 *
	 * @param leftEyelidObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Eyelid Objective
	 */
	List<OphthalmologyExaminationEntity> findByLeftEyelidObjective(@NotNull String leftEyelidObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Pupil Subjective.
	 *
	 * @param leftPupilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Pupil Subjective
	 */
	List<OphthalmologyExaminationEntity> findByLeftPupilSubjective(@NotNull String leftPupilSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Pupil Objective.
	 *
	 * @param leftPupilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Pupil Objective
	 */
	List<OphthalmologyExaminationEntity> findByLeftPupilObjective(@NotNull String leftPupilObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Sclera Subjective.
	 *
	 * @param leftScleraSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Sclera Subjective
	 */
	List<OphthalmologyExaminationEntity> findByLeftScleraSubjective(@NotNull String leftScleraSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Sclera Objective.
	 *
	 * @param leftScleraObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Sclera Objective
	 */
	List<OphthalmologyExaminationEntity> findByLeftScleraObjective(@NotNull String leftScleraObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Iris Subjective.
	 *
	 * @param leftIrisSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Iris Subjective
	 */
	List<OphthalmologyExaminationEntity> findByLeftIrisSubjective(@NotNull String leftIrisSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Iris Objective.
	 *
	 * @param leftIrisObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Iris Objective
	 */
	List<OphthalmologyExaminationEntity> findByLeftIrisObjective(@NotNull String leftIrisObjective);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<OphthalmologyExaminationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<OphthalmologyExaminationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}