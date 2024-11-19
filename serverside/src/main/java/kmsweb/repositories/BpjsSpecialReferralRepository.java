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

import kmsweb.entities.BpjsSpecialReferralEntity;
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
public interface BpjsSpecialReferralRepository extends AbstractRepository<BpjsSpecialReferralEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Referral ID.
	 *
	 * @param referralID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral ID
	 */
	List<BpjsSpecialReferralEntity> findByReferralID(@NotNull String referralID);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	List<BpjsSpecialReferralEntity> findByReferralNo(@NotNull String referralNo);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsSpecialReferralEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<BpjsSpecialReferralEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute PPK Diagnose.
	 *
	 * @param ppkDiagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PPK Diagnose
	 */
	List<BpjsSpecialReferralEntity> findByPpkDiagnose(@NotNull String ppkDiagnose);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Start Date.
	 *
	 * @param referralStartDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Start Date
	 */
	List<BpjsSpecialReferralEntity> findByReferralStartDate(@NotNull String referralStartDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral End Date.
	 *
	 * @param referralEndDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral End Date
	 */
	List<BpjsSpecialReferralEntity> findByReferralEndDate(@NotNull String referralEndDate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSpecialReferralEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSpecialReferralEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}