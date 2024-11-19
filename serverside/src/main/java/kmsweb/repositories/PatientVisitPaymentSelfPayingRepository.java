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

import kmsweb.entities.PatientVisitPaymentSelfPayingEntity;
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
public interface PatientVisitPaymentSelfPayingRepository extends AbstractRepository<PatientVisitPaymentSelfPayingEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Sponsor Name.
	 *
	 * @param sponsorName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sponsor Name
	 */
	List<PatientVisitPaymentSelfPayingEntity> findBySponsorName(@NotNull String sponsorName);
	/**
	 * Return an entity or a list of entities that have the given attribute Sponsor Address.
	 *
	 * @param sponsorAddress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sponsor Address
	 */
	List<PatientVisitPaymentSelfPayingEntity> findBySponsorAddress(@NotNull String sponsorAddress);
	/**
	 * Return an entity or a list of entities that have the given attribute Sponsor Phone No.
	 *
	 * @param sponsorPhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sponsor Phone No
	 */
	List<PatientVisitPaymentSelfPayingEntity> findBySponsorPhoneNo(@NotNull String sponsorPhoneNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Sponsorship.
	 *
	 * @param sponsorship the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sponsorship
	 */
	List<PatientVisitPaymentSelfPayingEntity> findBySponsorship(@NotNull String sponsorship);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientVisitPaymentSelfPayingEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientVisitPaymentSelfPayingEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}