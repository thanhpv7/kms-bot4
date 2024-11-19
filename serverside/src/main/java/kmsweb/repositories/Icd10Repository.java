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

import kmsweb.entities.Icd10Entity;
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
public interface Icd10Repository extends AbstractRepository<Icd10Entity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Disease.
	 *
	 * @param classificationDisease the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Disease
	 */
	List<Icd10Entity> findByClassificationDisease(@NotNull Boolean classificationDisease);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Infectious.
	 *
	 * @param classificationInfectious the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Infectious
	 */
	List<Icd10Entity> findByClassificationInfectious(@NotNull Boolean classificationInfectious);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Chronic.
	 *
	 * @param classificationChronic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Chronic
	 */
	List<Icd10Entity> findByClassificationChronic(@NotNull Boolean classificationChronic);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Top Disease.
	 *
	 * @param classificationTopDisease the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Top Disease
	 */
	List<Icd10Entity> findByClassificationTopDisease(@NotNull Boolean classificationTopDisease);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Restricted Case.
	 *
	 * @param classificationRestrictedCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Restricted Case
	 */
	List<Icd10Entity> findByClassificationRestrictedCase(@NotNull Boolean classificationRestrictedCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Reportable Case.
	 *
	 * @param classificationReportableCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Reportable Case
	 */
	List<Icd10Entity> findByClassificationReportableCase(@NotNull Boolean classificationReportableCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification Acute.
	 *
	 * @param classificationAcute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification Acute
	 */
	List<Icd10Entity> findByClassificationAcute(@NotNull Boolean classificationAcute);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	List<Icd10Entity> findByDismissalDate(@NotNull OffsetDateTime dismissalDate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<Icd10Entity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<Icd10Entity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}