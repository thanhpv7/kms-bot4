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

import kmsweb.entities.BpjsINACBGEntity;
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
public interface BpjsINACBGRepository extends AbstractRepository<BpjsINACBGEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Code.
	 *
	 * @param healthFacilityCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Code
	 */
	List<BpjsINACBGEntity> findByHealthFacilityCode(@NotNull String healthFacilityCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Name.
	 *
	 * @param healthFacilityName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Name
	 */
	List<BpjsINACBGEntity> findByHealthFacilityName(@NotNull String healthFacilityName);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<BpjsINACBGEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute State Province.
	 *
	 * @param stateProvince the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute State Province
	 */
	List<BpjsINACBGEntity> findByStateProvince(@NotNull String stateProvince);
	/**
	 * Return an entity or a list of entities that have the given attribute City Regency.
	 *
	 * @param cityRegency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City Regency
	 */
	List<BpjsINACBGEntity> findByCityRegency(@NotNull String cityRegency);
	/**
	 * Return an entity or a list of entities that have the given attribute Regional.
	 *
	 * @param regional the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Regional
	 */
	List<BpjsINACBGEntity> findByRegional(@NotNull String regional);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Class.
	 *
	 * @param hospitalClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Class
	 */
	List<BpjsINACBGEntity> findByHospitalClass(@NotNull String hospitalClass);
	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Tariff 1.
	 *
	 * @param inacbgTariff1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Tariff 1
	 */
	List<BpjsINACBGEntity> findByInacbgTariff1(@NotNull String inacbgTariff1);
	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Tariff 2.
	 *
	 * @param inacbgTariff2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Tariff 2
	 */
	List<BpjsINACBGEntity> findByInacbgTariff2(@NotNull String inacbgTariff2);
	/**
	 * Return an entity or a list of entities that have the given attribute Additional Upgrade VIP.
	 *
	 * @param additionalUpgradeVIP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Upgrade VIP
	 */
	List<BpjsINACBGEntity> findByAdditionalUpgradeVIP(@NotNull String additionalUpgradeVIP);
	/**
	 * Return an entity or a list of entities that have the given attribute Payplan ID.
	 *
	 * @param payplanID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payplan ID
	 */
	List<BpjsINACBGEntity> findByPayplanID(@NotNull String payplanID);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Plan Code.
	 *
	 * @param paymentPlanCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Plan Code
	 */
	List<BpjsINACBGEntity> findByPaymentPlanCode(@NotNull String paymentPlanCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	List<BpjsINACBGEntity> findByTariffCode(@NotNull String tariffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute URL.
	 *
	 * @param url the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute URL
	 */
	List<BpjsINACBGEntity> findByUrl(@NotNull String url);
	/**
	 * Return an entity or a list of entities that have the given attribute Username.
	 *
	 * @param username the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Username
	 */
	List<BpjsINACBGEntity> findByUsername(@NotNull String username);
	/**
	 * Return an entity or a list of entities that have the given attribute Password.
	 *
	 * @param password the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Password
	 */
	List<BpjsINACBGEntity> findByPassword(@NotNull String password);
	/**
	 * Return an entity or a list of entities that have the given attribute Secret Key.
	 *
	 * @param secretKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Secret Key
	 */
	List<BpjsINACBGEntity> findBySecretKey(@NotNull String secretKey);
	/**
	 * Return an entity or a list of entities that have the given attribute Coder ID.
	 *
	 * @param coderID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Coder ID
	 */
	List<BpjsINACBGEntity> findByCoderID(@NotNull String coderID);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsINACBGEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsINACBGEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}