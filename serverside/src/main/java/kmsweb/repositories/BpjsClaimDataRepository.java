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

import kmsweb.entities.BpjsClaimDataEntity;
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
public interface BpjsClaimDataRepository extends AbstractRepository<BpjsClaimDataEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Code.
	 *
	 * @param inacbgCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Code
	 */
	List<BpjsClaimDataEntity> findByInacbgCode(@NotNull String inacbgCode);
	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Name.
	 *
	 * @param inacbgName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Name
	 */
	List<BpjsClaimDataEntity> findByInacbgName(@NotNull String inacbgName);
	/**
	 * Return an entity or a list of entities that have the given attribute Submitted Tariff.
	 *
	 * @param submittedTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Submitted Tariff
	 */
	List<BpjsClaimDataEntity> findBySubmittedTariff(@NotNull String submittedTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval.
	 *
	 * @param approval the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval
	 */
	List<BpjsClaimDataEntity> findByApproval(@NotNull String approval);
	/**
	 * Return an entity or a list of entities that have the given attribute Grouper Tariff.
	 *
	 * @param grouperTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Grouper Tariff
	 */
	List<BpjsClaimDataEntity> findByGrouperTariff(@NotNull String grouperTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Tariff.
	 *
	 * @param hospitalTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Tariff
	 */
	List<BpjsClaimDataEntity> findByHospitalTariff(@NotNull String hospitalTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Top Up.
	 *
	 * @param topUp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Top Up
	 */
	List<BpjsClaimDataEntity> findByTopUp(@NotNull String topUp);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BpjsClaimDataEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute FPK No.
	 *
	 * @param fpkNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute FPK No
	 */
	List<BpjsClaimDataEntity> findByFpkNo(@NotNull String fpkNo);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsClaimDataEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<BpjsClaimDataEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsClaimDataEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	List<BpjsClaimDataEntity> findByPatientID(@NotNull String patientID);
	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic.
	 *
	 * @param polyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic
	 */
	List<BpjsClaimDataEntity> findByPolyclinic(@NotNull String polyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	List<BpjsClaimDataEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	List<BpjsClaimDataEntity> findByDismissalDate(@NotNull OffsetDateTime dismissalDate);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	List<BpjsClaimDataEntity> findBySepDate(@NotNull OffsetDateTime sepDate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsClaimDataEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsClaimDataEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}