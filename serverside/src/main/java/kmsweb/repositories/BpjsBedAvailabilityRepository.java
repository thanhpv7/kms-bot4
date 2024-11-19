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

import kmsweb.entities.BpjsBedAvailabilityEntity;
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
public interface BpjsBedAvailabilityRepository extends AbstractRepository<BpjsBedAvailabilityEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute koderuang.
	 *
	 * @param koderuang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute koderuang
	 */
	Optional<BpjsBedAvailabilityEntity> findByKoderuang(@NotNull String koderuang);
	/**
	 * Return an entity or a list of entities that have the given attribute namaruang.
	 *
	 * @param namaruang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namaruang
	 */
	List<BpjsBedAvailabilityEntity> findByNamaruang(@NotNull String namaruang);
	/**
	 * Return an entity or a list of entities that have the given attribute kodekelas.
	 *
	 * @param kodekelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodekelas
	 */
	List<BpjsBedAvailabilityEntity> findByKodekelas(@NotNull String kodekelas);
	/**
	 * Return an entity or a list of entities that have the given attribute namakelas.
	 *
	 * @param namakelas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute namakelas
	 */
	List<BpjsBedAvailabilityEntity> findByNamakelas(@NotNull String namakelas);
	/**
	 * Return an entity or a list of entities that have the given attribute lastupdate.
	 *
	 * @param lastupdate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute lastupdate
	 */
	List<BpjsBedAvailabilityEntity> findByLastupdate(@NotNull String lastupdate);
	/**
	 * Return an entity or a list of entities that have the given attribute kapasitas.
	 *
	 * @param kapasitas the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kapasitas
	 */
	List<BpjsBedAvailabilityEntity> findByKapasitas(@NotNull Integer kapasitas);
	/**
	 * Return an entity or a list of entities that have the given attribute tersedia.
	 *
	 * @param tersedia the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tersedia
	 */
	List<BpjsBedAvailabilityEntity> findByTersedia(@NotNull Integer tersedia);
	/**
	 * Return an entity or a list of entities that have the given attribute tersediapria.
	 *
	 * @param tersediapria the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tersediapria
	 */
	List<BpjsBedAvailabilityEntity> findByTersediapria(@NotNull Integer tersediapria);
	/**
	 * Return an entity or a list of entities that have the given attribute tersediawanita.
	 *
	 * @param tersediawanita the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tersediawanita
	 */
	List<BpjsBedAvailabilityEntity> findByTersediawanita(@NotNull Integer tersediawanita);
	/**
	 * Return an entity or a list of entities that have the given attribute tersediapriawanita.
	 *
	 * @param tersediapriawanita the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tersediapriawanita
	 */
	List<BpjsBedAvailabilityEntity> findByTersediapriawanita(@NotNull Integer tersediapriawanita);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsBedAvailabilityEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsBedAvailabilityEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}