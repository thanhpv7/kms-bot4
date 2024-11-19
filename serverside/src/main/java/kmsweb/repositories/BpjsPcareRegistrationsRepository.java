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

import kmsweb.entities.BpjsPcareRegistrationsEntity;
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
public interface BpjsPcareRegistrationsRepository extends AbstractRepository<BpjsPcareRegistrationsEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute kdProviderPeserta.
	 *
	 * @param kdproviderpeserta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProviderPeserta
	 */
	List<BpjsPcareRegistrationsEntity> findByKdproviderpeserta(@NotNull String kdproviderpeserta);
	/**
	 * Return an entity or a list of entities that have the given attribute tglDaftar.
	 *
	 * @param tgldaftar the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglDaftar
	 */
	List<BpjsPcareRegistrationsEntity> findByTgldaftar(@NotNull String tgldaftar);
	/**
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	List<BpjsPcareRegistrationsEntity> findByNokartu(@NotNull String nokartu);
	/**
	 * Return an entity or a list of entities that have the given attribute kdPoli.
	 *
	 * @param kdpoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdPoli
	 */
	List<BpjsPcareRegistrationsEntity> findByKdpoli(@NotNull String kdpoli);
	/**
	 * Return an entity or a list of entities that have the given attribute keluhan.
	 *
	 * @param keluhan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keluhan
	 */
	List<BpjsPcareRegistrationsEntity> findByKeluhan(@NotNull String keluhan);
	/**
	 * Return an entity or a list of entities that have the given attribute kunjSakit.
	 *
	 * @param kunjsakit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kunjSakit
	 */
	List<BpjsPcareRegistrationsEntity> findByKunjsakit(@NotNull String kunjsakit);
	/**
	 * Return an entity or a list of entities that have the given attribute sistole.
	 *
	 * @param sistole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute sistole
	 */
	List<BpjsPcareRegistrationsEntity> findBySistole(@NotNull String sistole);
	/**
	 * Return an entity or a list of entities that have the given attribute diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diastole
	 */
	List<BpjsPcareRegistrationsEntity> findByDiastole(@NotNull String diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute beratBadan.
	 *
	 * @param beratbadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute beratBadan
	 */
	List<BpjsPcareRegistrationsEntity> findByBeratbadan(@NotNull String beratbadan);
	/**
	 * Return an entity or a list of entities that have the given attribute tinggiBadan.
	 *
	 * @param tinggibadan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tinggiBadan
	 */
	List<BpjsPcareRegistrationsEntity> findByTinggibadan(@NotNull String tinggibadan);
	/**
	 * Return an entity or a list of entities that have the given attribute respRate.
	 *
	 * @param resprate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute respRate
	 */
	List<BpjsPcareRegistrationsEntity> findByResprate(@NotNull String resprate);
	/**
	 * Return an entity or a list of entities that have the given attribute lingkarPerut.
	 *
	 * @param lingkarperut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute lingkarPerut
	 */
	List<BpjsPcareRegistrationsEntity> findByLingkarperut(@NotNull String lingkarperut);
	/**
	 * Return an entity or a list of entities that have the given attribute rujukInternal.
	 *
	 * @param rujukinternal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute rujukInternal
	 */
	List<BpjsPcareRegistrationsEntity> findByRujukinternal(@NotNull String rujukinternal);
	/**
	 * Return an entity or a list of entities that have the given attribute heartRate.
	 *
	 * @param heartrate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute heartRate
	 */
	List<BpjsPcareRegistrationsEntity> findByHeartrate(@NotNull String heartrate);
	/**
	 * Return an entity or a list of entities that have the given attribute rujukBalik.
	 *
	 * @param rujukbalik the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute rujukBalik
	 */
	List<BpjsPcareRegistrationsEntity> findByRujukbalik(@NotNull String rujukbalik);
	/**
	 * Return an entity or a list of entities that have the given attribute kdTkp.
	 *
	 * @param kdtkp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdTkp
	 */
	List<BpjsPcareRegistrationsEntity> findByKdtkp(@NotNull String kdtkp);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareRegistrationsEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareRegistrationsEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}