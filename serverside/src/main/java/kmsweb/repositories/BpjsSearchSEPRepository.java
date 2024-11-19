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

import kmsweb.entities.BpjsSearchSEPEntity;
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
public interface BpjsSearchSEPRepository extends AbstractRepository<BpjsSearchSEPEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsSearchSEPEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	List<BpjsSearchSEPEntity> findBySepDate(@NotNull String sepDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	List<BpjsSearchSEPEntity> findByTreatmentType(@NotNull String treatmentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic.
	 *
	 * @param polyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic
	 */
	List<BpjsSearchSEPEntity> findByPolyclinic(@NotNull String polyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsSearchSEPEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<BpjsSearchSEPEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<BpjsSearchSEPEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	List<BpjsSearchSEPEntity> findByDateOfBirth(@NotNull String dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BpjsSearchSEPEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Provider.
	 *
	 * @param provider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider
	 */
	List<BpjsSearchSEPEntity> findByProvider(@NotNull String provider);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Provider.
	 *
	 * @param referralProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Provider
	 */
	List<BpjsSearchSEPEntity> findByReferralProvider(@NotNull String referralProvider);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Source.
	 *
	 * @param referralSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Source
	 */
	List<BpjsSearchSEPEntity> findByReferralSource(@NotNull String referralSource);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	List<BpjsSearchSEPEntity> findByReferralNo(@NotNull String referralNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Date.
	 *
	 * @param referralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Date
	 */
	List<BpjsSearchSEPEntity> findByReferralDate(@NotNull String referralDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	List<BpjsSearchSEPEntity> findByDiagnose(@NotNull String diagnose);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSearchSEPEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSearchSEPEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}