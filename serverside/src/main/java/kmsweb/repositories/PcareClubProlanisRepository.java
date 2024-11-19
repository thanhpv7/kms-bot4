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

import kmsweb.entities.PcareClubProlanisEntity;
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
public interface PcareClubProlanisRepository extends AbstractRepository<PcareClubProlanisEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Club ID.
	 *
	 * @param clubID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Club ID
	 */
	List<PcareClubProlanisEntity> findByClubID(@NotNull String clubID);
	/**
	 * Return an entity or a list of entities that have the given attribute Kode Program.
	 *
	 * @param kodeProgram the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kode Program
	 */
	List<PcareClubProlanisEntity> findByKodeProgram(@NotNull String kodeProgram);
	/**
	 * Return an entity or a list of entities that have the given attribute Nama Program.
	 *
	 * @param namaProgram the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Program
	 */
	List<PcareClubProlanisEntity> findByNamaProgram(@NotNull String namaProgram);
	/**
	 * Return an entity or a list of entities that have the given attribute Tanggal Mulai.
	 *
	 * @param tanggalMulai the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tanggal Mulai
	 */
	List<PcareClubProlanisEntity> findByTanggalMulai(@NotNull String tanggalMulai);
	/**
	 * Return an entity or a list of entities that have the given attribute Tanggal Akhir.
	 *
	 * @param tanggalAkhir the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tanggal Akhir
	 */
	List<PcareClubProlanisEntity> findByTanggalAkhir(@NotNull String tanggalAkhir);
	/**
	 * Return an entity or a list of entities that have the given attribute Alamat Club.
	 *
	 * @param alamatClub the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Alamat Club
	 */
	List<PcareClubProlanisEntity> findByAlamatClub(@NotNull String alamatClub);
	/**
	 * Return an entity or a list of entities that have the given attribute Nama Club.
	 *
	 * @param namaClub the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Club
	 */
	List<PcareClubProlanisEntity> findByNamaClub(@NotNull String namaClub);
	/**
	 * Return an entity or a list of entities that have the given attribute No HP Ketua.
	 *
	 * @param noHPKetua the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute No HP Ketua
	 */
	List<PcareClubProlanisEntity> findByNoHPKetua(@NotNull String noHPKetua);
	/**
	 * Return an entity or a list of entities that have the given attribute Nama Ketua.
	 *
	 * @param namaKetua the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Ketua
	 */
	List<PcareClubProlanisEntity> findByNamaKetua(@NotNull String namaKetua);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareClubProlanisEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareClubProlanisEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}