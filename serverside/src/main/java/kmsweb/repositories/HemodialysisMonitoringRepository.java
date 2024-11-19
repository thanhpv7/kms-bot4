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

import kmsweb.entities.HemodialysisMonitoringEntity;
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
public interface HemodialysisMonitoringRepository extends AbstractRepository<HemodialysisMonitoringEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute DateTime.
	 *
	 * @param datetime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DateTime
	 */
	List<HemodialysisMonitoringEntity> findByDatetime(@NotNull OffsetDateTime datetime);
	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	List<HemodialysisMonitoringEntity> findBySystole(@NotNull Double systole);
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<HemodialysisMonitoringEntity> findByDiastole(@NotNull Double diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Heart Rate.
	 *
	 * @param heartRate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heart Rate
	 */
	List<HemodialysisMonitoringEntity> findByHeartRate(@NotNull Double heartRate);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	List<HemodialysisMonitoringEntity> findByTemperature(@NotNull Double temperature);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature Unit.
	 *
	 * @param temperatureUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature Unit
	 */
	List<HemodialysisMonitoringEntity> findByTemperatureUnit(@NotNull String temperatureUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory.
	 *
	 * @param respiratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory
	 */
	List<HemodialysisMonitoringEntity> findByRespiratory(@NotNull Double respiratory);
	/**
	 * Return an entity or a list of entities that have the given attribute QB.
	 *
	 * @param qb the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute QB
	 */
	List<HemodialysisMonitoringEntity> findByQb(@NotNull Double qb);
	/**
	 * Return an entity or a list of entities that have the given attribute QD.
	 *
	 * @param qd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute QD
	 */
	List<HemodialysisMonitoringEntity> findByQd(@NotNull Double qd);
	/**
	 * Return an entity or a list of entities that have the given attribute Venous Pressure.
	 *
	 * @param venousPressure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Venous Pressure
	 */
	List<HemodialysisMonitoringEntity> findByVenousPressure(@NotNull Double venousPressure);
	/**
	 * Return an entity or a list of entities that have the given attribute TMP.
	 *
	 * @param tmp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute TMP
	 */
	List<HemodialysisMonitoringEntity> findByTmp(@NotNull Double tmp);
	/**
	 * Return an entity or a list of entities that have the given attribute UFG.
	 *
	 * @param ufg the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UFG
	 */
	List<HemodialysisMonitoringEntity> findByUfg(@NotNull Double ufg);
	/**
	 * Return an entity or a list of entities that have the given attribute UFR.
	 *
	 * @param ufr the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UFR
	 */
	List<HemodialysisMonitoringEntity> findByUfr(@NotNull Double ufr);
	/**
	 * Return an entity or a list of entities that have the given attribute UF.
	 *
	 * @param uf the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UF
	 */
	List<HemodialysisMonitoringEntity> findByUf(@NotNull Double uf);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HemodialysisMonitoringEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HemodialysisMonitoringEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}