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

import kmsweb.entities.NhisMedicineEntity;
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
public interface NhisMedicineRepository extends AbstractRepository<NhisMedicineEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Medicine Code.
	 *
	 * @param medicineCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medicine Code
	 */
	List<NhisMedicineEntity> findByMedicineCode(@NotNull String medicineCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Medicine Name.
	 *
	 * @param medicineName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medicine Name
	 */
	List<NhisMedicineEntity> findByMedicineName(@NotNull String medicineName);
	/**
	 * Return an entity or a list of entities that have the given attribute Dose.
	 *
	 * @param dose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dose
	 */
	List<NhisMedicineEntity> findByDose(@NotNull Double dose);
	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	List<NhisMedicineEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Frequency.
	 *
	 * @param frequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Frequency
	 */
	List<NhisMedicineEntity> findByFrequency(@NotNull String frequency);
	/**
	 * Return an entity or a list of entities that have the given attribute Duration.
	 *
	 * @param duration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Duration
	 */
	List<NhisMedicineEntity> findByDuration(@NotNull Double duration);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	List<NhisMedicineEntity> findByUnitPrice(@NotNull Double unitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Dispensed Qty.
	 *
	 * @param dispensedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dispensed Qty
	 */
	List<NhisMedicineEntity> findByDispensedQty(@NotNull Double dispensedQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	List<NhisMedicineEntity> findByTotalCost(@NotNull Double totalCost);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Date.
	 *
	 * @param serviceDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Date
	 */
	List<NhisMedicineEntity> findByServiceDate(@NotNull OffsetDateTime serviceDate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NhisMedicineEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NhisMedicineEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}