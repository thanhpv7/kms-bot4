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

import kmsweb.entities.BpjsPatientReferralEntity;
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
public interface BpjsPatientReferralRepository extends AbstractRepository<BpjsPatientReferralEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute No SEP.
	 *
	 * @param noSEP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute No SEP
	 */
	List<BpjsPatientReferralEntity> findByNoSEP(@NotNull String noSEP);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	List<BpjsPatientReferralEntity> findByReferralNo(@NotNull String referralNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Referred Type.
	 *
	 * @param referredType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referred Type
	 */
	List<BpjsPatientReferralEntity> findByReferredType(@NotNull String referredType);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Date.
	 *
	 * @param referralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Date
	 */
	List<BpjsPatientReferralEntity> findByReferralDate(@NotNull OffsetDateTime referralDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Referal Date Plan.
	 *
	 * @param referalDatePlan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referal Date Plan
	 */
	List<BpjsPatientReferralEntity> findByReferalDatePlan(@NotNull OffsetDateTime referalDatePlan);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	List<BpjsPatientReferralEntity> findByTreatmentType(@NotNull String treatmentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<BpjsPatientReferralEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPatientReferralEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPatientReferralEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}