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

import kmsweb.entities.InsuranceBenefitPlanEntity;
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
public interface InsuranceBenefitPlanRepository extends AbstractRepository<InsuranceBenefitPlanEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Benefit Plan No.
	 *
	 * @param benefitPlanNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Benefit Plan No
	 */
	Optional<InsuranceBenefitPlanEntity> findByBenefitPlanNo(@NotNull String benefitPlanNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Benefit Plan Name.
	 *
	 * @param benefitPlanName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Benefit Plan Name
	 */
	List<InsuranceBenefitPlanEntity> findByBenefitPlanName(@NotNull String benefitPlanName);
	/**
	 * Return an entity or a list of entities that have the given attribute Maximum Coverage per Treatment.
	 *
	 * @param maximumCoveragePerTreatment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maximum Coverage per Treatment
	 */
	List<InsuranceBenefitPlanEntity> findByMaximumCoveragePerTreatment(@NotNull Double maximumCoveragePerTreatment);
	/**
	 * Return an entity or a list of entities that have the given attribute Maximum Coverage per Year.
	 *
	 * @param maximumCoveragePerYear the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maximum Coverage per Year
	 */
	List<InsuranceBenefitPlanEntity> findByMaximumCoveragePerYear(@NotNull Double maximumCoveragePerYear);
	/**
	 * Return an entity or a list of entities that have the given attribute Created Date.
	 *
	 * @param createdDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Created Date
	 */
	List<InsuranceBenefitPlanEntity> findByCreatedDate(@NotNull OffsetDateTime createdDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Updated Date.
	 *
	 * @param updatedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Updated Date
	 */
	List<InsuranceBenefitPlanEntity> findByUpdatedDate(@NotNull OffsetDateTime updatedDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<InsuranceBenefitPlanEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InsuranceBenefitPlanEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InsuranceBenefitPlanEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}