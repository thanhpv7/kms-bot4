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

import kmsweb.entities.BpjsUpdateDismissalDateEntity;
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
public interface BpjsUpdateDismissalDateRepository extends AbstractRepository<BpjsUpdateDismissalDateEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsUpdateDismissalDateEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Type.
	 *
	 * @param dismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Type
	 */
	List<BpjsUpdateDismissalDateEntity> findByDismissalType(@NotNull String dismissalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Death Certificate Letter No.
	 *
	 * @param deathCertificateLetterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Death Certificate Letter No
	 */
	List<BpjsUpdateDismissalDateEntity> findByDeathCertificateLetterNo(@NotNull String deathCertificateLetterNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Time Of Death.
	 *
	 * @param timeOfDeath the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Time Of Death
	 */
	List<BpjsUpdateDismissalDateEntity> findByTimeOfDeath(@NotNull OffsetDateTime timeOfDeath);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	List<BpjsUpdateDismissalDateEntity> findByDismissalDate(@NotNull OffsetDateTime dismissalDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Police Report No.
	 *
	 * @param policeReportNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Police Report No
	 */
	List<BpjsUpdateDismissalDateEntity> findByPoliceReportNo(@NotNull String policeReportNo);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsUpdateDismissalDateEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsUpdateDismissalDateEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}