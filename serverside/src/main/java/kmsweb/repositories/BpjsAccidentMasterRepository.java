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

import kmsweb.entities.BpjsAccidentMasterEntity;
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
public interface BpjsAccidentMasterRepository extends AbstractRepository<BpjsAccidentMasterEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute noSEP.
	 *
	 * @param nosep the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noSEP
	 */
	List<BpjsAccidentMasterEntity> findByNosep(@NotNull String nosep);
	/**
	 * Return an entity or a list of entities that have the given attribute tglKejadian.
	 *
	 * @param tglkejadian the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglKejadian
	 */
	List<BpjsAccidentMasterEntity> findByTglkejadian(@NotNull String tglkejadian);
	/**
	 * Return an entity or a list of entities that have the given attribute ppkPelSEP.
	 *
	 * @param ppkpelsep the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ppkPelSEP
	 */
	List<BpjsAccidentMasterEntity> findByPpkpelsep(@NotNull String ppkpelsep);
	/**
	 * Return an entity or a list of entities that have the given attribute kdProp.
	 *
	 * @param kdprop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdProp
	 */
	List<BpjsAccidentMasterEntity> findByKdprop(@NotNull String kdprop);
	/**
	 * Return an entity or a list of entities that have the given attribute kdKab.
	 *
	 * @param kdkab the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdKab
	 */
	List<BpjsAccidentMasterEntity> findByKdkab(@NotNull String kdkab);
	/**
	 * Return an entity or a list of entities that have the given attribute kdKec.
	 *
	 * @param kdkec the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdKec
	 */
	List<BpjsAccidentMasterEntity> findByKdkec(@NotNull String kdkec);
	/**
	 * Return an entity or a list of entities that have the given attribute ketKejadian.
	 *
	 * @param ketkejadian the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ketKejadian
	 */
	List<BpjsAccidentMasterEntity> findByKetkejadian(@NotNull String ketkejadian);
	/**
	 * Return an entity or a list of entities that have the given attribute noSEPSuplesi.
	 *
	 * @param nosepsuplesi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noSEPSuplesi
	 */
	List<BpjsAccidentMasterEntity> findByNosepsuplesi(@NotNull String nosepsuplesi);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsAccidentMasterEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsAccidentMasterEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}