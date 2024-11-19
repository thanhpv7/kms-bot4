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

import kmsweb.entities.BpjsDoctorScheduleEntity;
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
public interface BpjsDoctorScheduleRepository extends AbstractRepository<BpjsDoctorScheduleEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Hari.
	 *
	 * @param hari the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hari
	 */
	List<BpjsDoctorScheduleEntity> findByHari(@NotNull Integer hari);
	/**
	 * Return an entity or a list of entities that have the given attribute Nama Hari.
	 *
	 * @param namaHari the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Hari
	 */
	List<BpjsDoctorScheduleEntity> findByNamaHari(@NotNull String namaHari);
	/**
	 * Return an entity or a list of entities that have the given attribute Kapasitas.
	 *
	 * @param kapasitas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kapasitas
	 */
	List<BpjsDoctorScheduleEntity> findByKapasitas(@NotNull Integer kapasitas);
	/**
	 * Return an entity or a list of entities that have the given attribute JKN Quota.
	 *
	 * @param jknQuota the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute JKN Quota
	 */
	List<BpjsDoctorScheduleEntity> findByJknQuota(@NotNull Integer jknQuota);
	/**
	 * Return an entity or a list of entities that have the given attribute JKN Non Quota.
	 *
	 * @param jknNonQuota the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute JKN Non Quota
	 */
	List<BpjsDoctorScheduleEntity> findByJknNonQuota(@NotNull Integer jknNonQuota);
	/**
	 * Return an entity or a list of entities that have the given attribute Interval.
	 *
	 * @param interval the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Interval
	 */
	List<BpjsDoctorScheduleEntity> findByInterval(@NotNull Integer interval);
	/**
	 * Return an entity or a list of entities that have the given attribute Libur.
	 *
	 * @param libur the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Libur
	 */
	List<BpjsDoctorScheduleEntity> findByLibur(@NotNull Boolean libur);
	/**
	 * Return an entity or a list of entities that have the given attribute Jam Buka.
	 *
	 * @param jamBuka the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Jam Buka
	 */
	List<BpjsDoctorScheduleEntity> findByJamBuka(@NotNull String jamBuka);
	/**
	 * Return an entity or a list of entities that have the given attribute Jam Tutup.
	 *
	 * @param jamTutup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Jam Tutup
	 */
	List<BpjsDoctorScheduleEntity> findByJamTutup(@NotNull String jamTutup);
	/**
	 * Return an entity or a list of entities that have the given attribute kodepoli.
	 *
	 * @param kodepoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodepoli
	 */
	List<BpjsDoctorScheduleEntity> findByKodepoli(@NotNull String kodepoli);
	/**
	 * Return an entity or a list of entities that have the given attribute namapoli.
	 *
	 * @param namapoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namapoli
	 */
	List<BpjsDoctorScheduleEntity> findByNamapoli(@NotNull String namapoli);
	/**
	 * Return an entity or a list of entities that have the given attribute kodesubspesialis.
	 *
	 * @param kodesubspesialis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodesubspesialis
	 */
	List<BpjsDoctorScheduleEntity> findByKodesubspesialis(@NotNull String kodesubspesialis);
	/**
	 * Return an entity or a list of entities that have the given attribute namasubspesialis.
	 *
	 * @param namasubspesialis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namasubspesialis
	 */
	List<BpjsDoctorScheduleEntity> findByNamasubspesialis(@NotNull String namasubspesialis);
	/**
	 * Return an entity or a list of entities that have the given attribute kodedokter.
	 *
	 * @param kodedokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodedokter
	 */
	List<BpjsDoctorScheduleEntity> findByKodedokter(@NotNull String kodedokter);
	/**
	 * Return an entity or a list of entities that have the given attribute namadokter.
	 *
	 * @param namadokter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namadokter
	 */
	List<BpjsDoctorScheduleEntity> findByNamadokter(@NotNull String namadokter);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsDoctorScheduleEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsDoctorScheduleEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}