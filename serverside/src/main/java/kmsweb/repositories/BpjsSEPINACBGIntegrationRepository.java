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

import kmsweb.entities.BpjsSEPINACBGIntegrationEntity;
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
public interface BpjsSEPINACBGIntegrationRepository extends AbstractRepository<BpjsSEPINACBGIntegrationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsSEPINACBGIntegrationEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByPatientID(@NotNull String patientID);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Name.
	 *
	 * @param patientName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Name
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByPatientName(@NotNull String patientName);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByReferralNo(@NotNull String referralNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByDateOfBirth(@NotNull String dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Visit Date.
	 *
	 * @param visitDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Date
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByVisitDate(@NotNull String visitDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Level.
	 *
	 * @param healthFacilityLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Level
	 */
	List<BpjsSEPINACBGIntegrationEntity> findByHealthFacilityLevel(@NotNull String healthFacilityLevel);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSEPINACBGIntegrationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSEPINACBGIntegrationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}