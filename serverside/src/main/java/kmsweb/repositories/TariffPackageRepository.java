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

import kmsweb.entities.TariffPackageEntity;
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
public interface TariffPackageRepository extends AbstractRepository<TariffPackageEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Code.
	 *
	 * @param tariffPackageCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Code
	 */
	Optional<TariffPackageEntity> findByTariffPackageCode(@NotNull String tariffPackageCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Name.
	 *
	 * @param tariffPackageName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Name
	 */
	List<TariffPackageEntity> findByTariffPackageName(@NotNull String tariffPackageName);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Classification.
	 *
	 * @param tariffPackageClassification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Classification
	 */
	List<TariffPackageEntity> findByTariffPackageClassification(@NotNull String tariffPackageClassification);
	/**
	 * Return an entity or a list of entities that have the given attribute COA Sell.
	 *
	 * @param coaSell the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Sell
	 */
	List<TariffPackageEntity> findByCoaSell(@NotNull String coaSell);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Description.
	 *
	 * @param tariffPackageDescription the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Description
	 */
	List<TariffPackageEntity> findByTariffPackageDescription(@NotNull String tariffPackageDescription);
	/**
	 * Return an entity or a list of entities that have the given attribute Apply To All Services.
	 *
	 * @param applyToAllServices the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Apply To All Services
	 */
	List<TariffPackageEntity> findByApplyToAllServices(@NotNull Boolean applyToAllServices);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TariffPackageEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TariffPackageEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}