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

import kmsweb.entities.VitalSignsEntity;
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
public interface VitalSignsRepository extends AbstractRepository<VitalSignsEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Time.
	 *
	 * @param time the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Time
	 */
	List<VitalSignsEntity> findByTime(@NotNull String time);
	/**
	 * Return an entity or a list of entities that have the given attribute HR.
	 *
	 * @param hr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HR
	 */
	List<VitalSignsEntity> findByHr(@NotNull String hr);
	/**
	 * Return an entity or a list of entities that have the given attribute RR.
	 *
	 * @param rr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute RR
	 */
	List<VitalSignsEntity> findByRr(@NotNull String rr);
	/**
	 * Return an entity or a list of entities that have the given attribute Temprature.
	 *
	 * @param temprature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temprature
	 */
	List<VitalSignsEntity> findByTemprature(@NotNull String temprature);
	/**
	 * Return an entity or a list of entities that have the given attribute O2 Saturation.
	 *
	 * @param o2Saturation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute O2 Saturation
	 */
	List<VitalSignsEntity> findByO2Saturation(@NotNull String o2Saturation);
	/**
	 * Return an entity or a list of entities that have the given attribute Remarks.
	 *
	 * @param remarks the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Remarks
	 */
	List<VitalSignsEntity> findByRemarks(@NotNull String remarks);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<VitalSignsEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<VitalSignsEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}