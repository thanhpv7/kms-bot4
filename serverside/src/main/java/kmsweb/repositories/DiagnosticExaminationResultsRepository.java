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

import kmsweb.entities.DiagnosticExaminationResultsEntity;
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
public interface DiagnosticExaminationResultsRepository extends AbstractRepository<DiagnosticExaminationResultsEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Result.
	 *
	 * @param result the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result
	 */
	List<DiagnosticExaminationResultsEntity> findByResult(@NotNull String result);
	/**
	 * Return an entity or a list of entities that have the given attribute Outside Range.
	 *
	 * @param outsideRange the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outside Range
	 */
	List<DiagnosticExaminationResultsEntity> findByOutsideRange(@NotNull Boolean outsideRange);
	/**
	 * Return an entity or a list of entities that have the given attribute Low.
	 *
	 * @param low the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Low
	 */
	List<DiagnosticExaminationResultsEntity> findByLow(@NotNull Double low);
	/**
	 * Return an entity or a list of entities that have the given attribute High.
	 *
	 * @param high the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute High
	 */
	List<DiagnosticExaminationResultsEntity> findByHigh(@NotNull Double high);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit.
	 *
	 * @param unit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit
	 */
	List<DiagnosticExaminationResultsEntity> findByUnit(@NotNull String unit);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample No.
	 *
	 * @param sampleNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample No
	 */
	List<DiagnosticExaminationResultsEntity> findBySampleNo(@NotNull String sampleNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Type.
	 *
	 * @param sampleType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Type
	 */
	List<DiagnosticExaminationResultsEntity> findBySampleType(@NotNull String sampleType);
	/**
	 * Return an entity or a list of entities that have the given attribute repeated.
	 *
	 * @param repeated the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute repeated
	 */
	List<DiagnosticExaminationResultsEntity> findByRepeated(@NotNull Boolean repeated);
	/**
	 * Return an entity or a list of entities that have the given attribute status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute status
	 */
	List<DiagnosticExaminationResultsEntity> findByStatus(@NotNull String status);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DiagnosticExaminationResultsEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DiagnosticExaminationResultsEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}