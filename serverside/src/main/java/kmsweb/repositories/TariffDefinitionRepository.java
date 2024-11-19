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

import kmsweb.entities.TariffDefinitionEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface TariffDefinitionRepository extends AbstractRepository<TariffDefinitionEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	List<TariffDefinitionEntity> findByTariffType(@NotNull TariffTypeEnum tariffType);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	List<TariffDefinitionEntity> findByTariffCode(@NotNull String tariffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Price.
	 *
	 * @param tariffPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Price
	 */
	List<TariffDefinitionEntity> findByTariffPrice(@NotNull Double tariffPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Price.
	 *
	 * @param hospitalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Price
	 */
	List<TariffDefinitionEntity> findByHospitalPrice(@NotNull Double hospitalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Component Price.
	 *
	 * @param otherComponentPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Component Price
	 */
	List<TariffDefinitionEntity> findByOtherComponentPrice(@NotNull Double otherComponentPrice);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TariffDefinitionEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TariffDefinitionEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}