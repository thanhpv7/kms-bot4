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

import kmsweb.entities.BpjsPcareKegiatanKelompokEntity;
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
public interface BpjsPcareKegiatanKelompokRepository extends AbstractRepository<BpjsPcareKegiatanKelompokEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute ketuaNama.
	 *
	 * @param ketuanama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketuaNama
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKetuanama(@NotNull String ketuanama);
	/**
	 * Return an entity or a list of entities that have the given attribute nama.
	 *
	 * @param nama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nama
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByNama(@NotNull String nama);
	/**
	 * Return an entity or a list of entities that have the given attribute eduId.
	 *
	 * @param eduid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute eduId
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByEduid(@NotNull String eduid);
	/**
	 * Return an entity or a list of entities that have the given attribute clubId.
	 *
	 * @param clubid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute clubId
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByClubid(@NotNull String clubid);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProgram.
	 *
	 * @param kdprogram the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProgram
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKdprogram(@NotNull String kdprogram);
	/**
	 * Return an entity or a list of entities that have the given attribute nmProgram.
	 *
	 * @param nmprogram the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute nmProgram
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByNmprogram(@NotNull String nmprogram);
	/**
	 * Return an entity or a list of entities that have the given attribute tglMulai.
	 *
	 * @param tglmulai the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglMulai
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByTglmulai(@NotNull String tglmulai);
	/**
	 * Return an entity or a list of entities that have the given attribute tglAkhir.
	 *
	 * @param tglakhir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglAkhir
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByTglakhir(@NotNull String tglakhir);
	/**
	 * Return an entity or a list of entities that have the given attribute alamat.
	 *
	 * @param alamat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute alamat
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByAlamat(@NotNull String alamat);
	/**
	 * Return an entity or a list of entities that have the given attribute ketuaNoHp.
	 *
	 * @param ketuanohp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketuaNoHp
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKetuanohp(@NotNull String ketuanohp);
	/**
	 * Return an entity or a list of entities that have the given attribute tglPelayanan.
	 *
	 * @param tglpelayanan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglPelayanan
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByTglpelayanan(@NotNull String tglpelayanan);
	/**
	 * Return an entity or a list of entities that have the given attribute kegiatanNama.
	 *
	 * @param kegiatannama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kegiatanNama
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKegiatannama(@NotNull String kegiatannama);
	/**
	 * Return an entity or a list of entities that have the given attribute kegiatanKode.
	 *
	 * @param kegiatankode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kegiatanKode
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKegiatankode(@NotNull String kegiatankode);
	/**
	 * Return an entity or a list of entities that have the given attribute kelompokNama.
	 *
	 * @param kelompoknama the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kelompokNama
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKelompoknama(@NotNull String kelompoknama);
	/**
	 * Return an entity or a list of entities that have the given attribute kelompokKode.
	 *
	 * @param kelompokkode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kelompokKode
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKelompokkode(@NotNull String kelompokkode);
	/**
	 * Return an entity or a list of entities that have the given attribute materi.
	 *
	 * @param materi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute materi
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByMateri(@NotNull String materi);
	/**
	 * Return an entity or a list of entities that have the given attribute pembicara.
	 *
	 * @param pembicara the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute pembicara
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByPembicara(@NotNull String pembicara);
	/**
	 * Return an entity or a list of entities that have the given attribute lokasi.
	 *
	 * @param lokasi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute lokasi
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByLokasi(@NotNull String lokasi);
	/**
	 * Return an entity or a list of entities that have the given attribute keterangan.
	 *
	 * @param keterangan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute keterangan
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByKeterangan(@NotNull String keterangan);
	/**
	 * Return an entity or a list of entities that have the given attribute biaya.
	 *
	 * @param biaya the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute biaya
	 */
	List<BpjsPcareKegiatanKelompokEntity> findByBiaya(@NotNull String biaya);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareKegiatanKelompokEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPcareKegiatanKelompokEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}