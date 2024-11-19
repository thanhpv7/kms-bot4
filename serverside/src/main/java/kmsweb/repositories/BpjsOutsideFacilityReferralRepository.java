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

import kmsweb.entities.BpjsOutsideFacilityReferralEntity;
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
public interface BpjsOutsideFacilityReferralRepository extends AbstractRepository<BpjsOutsideFacilityReferralEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	List<BpjsOutsideFacilityReferralEntity> findByReferralNo(@NotNull String referralNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Date.
	 *
	 * @param referralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Date
	 */
	List<BpjsOutsideFacilityReferralEntity> findByReferralDate(@NotNull String referralDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	List<BpjsOutsideFacilityReferralEntity> findByTreatmentType(@NotNull String treatmentType);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsOutsideFacilityReferralEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<BpjsOutsideFacilityReferralEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute Referred PPK Code.
	 *
	 * @param referredPPKCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referred PPK Code
	 */
	List<BpjsOutsideFacilityReferralEntity> findByReferredPPKCode(@NotNull String referredPPKCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Referred PPK Name.
	 *
	 * @param referredPPKName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referred PPK Name
	 */
	List<BpjsOutsideFacilityReferralEntity> findByReferredPPKName(@NotNull String referredPPKName);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsOutsideFacilityReferralEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BpjsOutsideFacilityReferralEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	List<BpjsOutsideFacilityReferralEntity> findBySepDate(@NotNull String sepDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Visit Plan Date.
	 *
	 * @param visitPlanDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Plan Date
	 */
	List<BpjsOutsideFacilityReferralEntity> findByVisitPlanDate(@NotNull String visitPlanDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	List<BpjsOutsideFacilityReferralEntity> findByDiagnose(@NotNull String diagnose);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Type.
	 *
	 * @param referralType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Type
	 */
	List<BpjsOutsideFacilityReferralEntity> findByReferralType(@NotNull String referralType);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Polyclinic.
	 *
	 * @param referralPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Polyclinic
	 */
	List<BpjsOutsideFacilityReferralEntity> findByReferralPolyclinic(@NotNull String referralPolyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<BpjsOutsideFacilityReferralEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	List<BpjsOutsideFacilityReferralEntity> findByDateOfBirth(@NotNull String dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<BpjsOutsideFacilityReferralEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsOutsideFacilityReferralEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsOutsideFacilityReferralEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}