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

import kmsweb.entities.BpjsSEPInternalDataEntity;
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
public interface BpjsSEPInternalDataRepository extends AbstractRepository<BpjsSEPInternalDataEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Referred Polyclinic.
	 *
	 * @param referredPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referred Polyclinic
	 */
	List<BpjsSEPInternalDataEntity> findByReferredPolyclinic(@NotNull String referredPolyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Referring Polyclinic.
	 *
	 * @param referringPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Polyclinic
	 */
	List<BpjsSEPInternalDataEntity> findByReferringPolyclinic(@NotNull String referringPolyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Internal Referral Date.
	 *
	 * @param internalReferralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Internal Referral Date
	 */
	List<BpjsSEPInternalDataEntity> findByInternalReferralDate(@NotNull String internalReferralDate);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsSEPInternalDataEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Ref SEP No.
	 *
	 * @param refSEPNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ref SEP No
	 */
	List<BpjsSEPInternalDataEntity> findByRefSEPNo(@NotNull String refSEPNo);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Health Facility.
	 *
	 * @param sepHealthFacility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Health Facility
	 */
	List<BpjsSEPInternalDataEntity> findBySepHealthFacility(@NotNull String sepHealthFacility);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsSEPInternalDataEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	List<BpjsSEPInternalDataEntity> findBySepDate(@NotNull String sepDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Letter No.
	 *
	 * @param letterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Letter No
	 */
	List<BpjsSEPInternalDataEntity> findByLetterNo(@NotNull String letterNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Internal.
	 *
	 * @param isInternal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Internal
	 */
	List<BpjsSEPInternalDataEntity> findByIsInternal(@NotNull String isInternal);
	/**
	 * Return an entity or a list of entities that have the given attribute Referring Polyclinic Code.
	 *
	 * @param referringPolyclinicCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Polyclinic Code
	 */
	List<BpjsSEPInternalDataEntity> findByReferringPolyclinicCode(@NotNull String referringPolyclinicCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnostic Support.
	 *
	 * @param diagnosticSupport the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnostic Support
	 */
	List<BpjsSEPInternalDataEntity> findByDiagnosticSupport(@NotNull String diagnosticSupport);
	/**
	 * Return an entity or a list of entities that have the given attribute Referring Diagnose.
	 *
	 * @param referringDiagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Diagnose
	 */
	List<BpjsSEPInternalDataEntity> findByReferringDiagnose(@NotNull String referringDiagnose);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor.
	 *
	 * @param doctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor
	 */
	List<BpjsSEPInternalDataEntity> findByDoctor(@NotNull String doctor);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSEPInternalDataEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSEPInternalDataEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}