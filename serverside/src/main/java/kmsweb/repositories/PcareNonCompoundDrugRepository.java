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

import kmsweb.entities.PcareNonCompoundDrugEntity;
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
public interface PcareNonCompoundDrugRepository extends AbstractRepository<PcareNonCompoundDrugEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Drug Code.
	 *
	 * @param drugCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drug Code
	 */
	List<PcareNonCompoundDrugEntity> findByDrugCode(@NotNull String drugCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Drug Name.
	 *
	 * @param drugName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drug Name
	 */
	List<PcareNonCompoundDrugEntity> findByDrugName(@NotNull String drugName);
	/**
	 * Return an entity or a list of entities that have the given attribute Signa Days.
	 *
	 * @param signaDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Signa Days
	 */
	List<PcareNonCompoundDrugEntity> findBySignaDays(@NotNull Double signaDays);
	/**
	 * Return an entity or a list of entities that have the given attribute Signa Times.
	 *
	 * @param signaTimes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Signa Times
	 */
	List<PcareNonCompoundDrugEntity> findBySignaTimes(@NotNull Integer signaTimes);
	/**
	 * Return an entity or a list of entities that have the given attribute Drug Qty.
	 *
	 * @param drugQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drug Qty
	 */
	List<PcareNonCompoundDrugEntity> findByDrugQty(@NotNull Double drugQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Day.
	 *
	 * @param day the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Day
	 */
	List<PcareNonCompoundDrugEntity> findByDay(@NotNull Double day);
	/**
	 * Return an entity or a list of entities that have the given attribute Request Qty.
	 *
	 * @param requestQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Request Qty
	 */
	List<PcareNonCompoundDrugEntity> findByRequestQty(@NotNull Integer requestQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Kd Obat SK.
	 *
	 * @param kdObatSK the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kd Obat SK
	 */
	List<PcareNonCompoundDrugEntity> findByKdObatSK(@NotNull String kdObatSK);
	/**
	 * Return an entity or a list of entities that have the given attribute Racikan.
	 *
	 * @param racikan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Racikan
	 */
	List<PcareNonCompoundDrugEntity> findByRacikan(@NotNull Boolean racikan);
	/**
	 * Return an entity or a list of entities that have the given attribute Kd Racikan.
	 *
	 * @param kdRacikan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kd Racikan
	 */
	List<PcareNonCompoundDrugEntity> findByKdRacikan(@NotNull String kdRacikan);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareNonCompoundDrugEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareNonCompoundDrugEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}