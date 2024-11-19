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

import kmsweb.entities.DeliveryProgressEntity;
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
public interface DeliveryProgressRepository extends AbstractRepository<DeliveryProgressEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Progress Date Time.
	 *
	 * @param progressDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Progress Date Time
	 */
	List<DeliveryProgressEntity> findByProgressDateTime(@NotNull OffsetDateTime progressDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute FHR Per Minute.
	 *
	 * @param fhrPerMinute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute FHR Per Minute
	 */
	List<DeliveryProgressEntity> findByFhrPerMinute(@NotNull Integer fhrPerMinute);
	/**
	 * Return an entity or a list of entities that have the given attribute Amniotic Fluid.
	 *
	 * @param amnioticFluid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Amniotic Fluid
	 */
	List<DeliveryProgressEntity> findByAmnioticFluid(@NotNull String amnioticFluid);
	/**
	 * Return an entity or a list of entities that have the given attribute Moulding.
	 *
	 * @param moulding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Moulding
	 */
	List<DeliveryProgressEntity> findByMoulding(@NotNull String moulding);
	/**
	 * Return an entity or a list of entities that have the given attribute Cervical Dilatation.
	 *
	 * @param cervicalDilatation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cervical Dilatation
	 */
	List<DeliveryProgressEntity> findByCervicalDilatation(@NotNull Integer cervicalDilatation);
	/**
	 * Return an entity or a list of entities that have the given attribute Fetal Head Descent.
	 *
	 * @param fetalHeadDescent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fetal Head Descent
	 */
	List<DeliveryProgressEntity> findByFetalHeadDescent(@NotNull String fetalHeadDescent);
	/**
	 * Return an entity or a list of entities that have the given attribute Contraction Qty.
	 *
	 * @param contractionQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contraction Qty
	 */
	List<DeliveryProgressEntity> findByContractionQty(@NotNull Integer contractionQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Contraction Mins.
	 *
	 * @param contractionMins the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contraction Mins
	 */
	List<DeliveryProgressEntity> findByContractionMins(@NotNull String contractionMins);
	/**
	 * Return an entity or a list of entities that have the given attribute Drip Strength.
	 *
	 * @param dripStrength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drip Strength
	 */
	List<DeliveryProgressEntity> findByDripStrength(@NotNull Integer dripStrength);
	/**
	 * Return an entity or a list of entities that have the given attribute Drip Number.
	 *
	 * @param dripNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drip Number
	 */
	List<DeliveryProgressEntity> findByDripNumber(@NotNull Integer dripNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Drug IV.
	 *
	 * @param drugIV the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drug IV
	 */
	List<DeliveryProgressEntity> findByDrugIV(@NotNull String drugIV);
	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	List<DeliveryProgressEntity> findBySystole(@NotNull Integer systole);
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<DeliveryProgressEntity> findByDiastole(@NotNull Integer diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	List<DeliveryProgressEntity> findByPulse(@NotNull Integer pulse);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	List<DeliveryProgressEntity> findByTemperature(@NotNull Double temperature);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature Unit.
	 *
	 * @param temperatureUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature Unit
	 */
	List<DeliveryProgressEntity> findByTemperatureUnit(@NotNull String temperatureUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Urine Protein.
	 *
	 * @param urineProtein the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine Protein
	 */
	List<DeliveryProgressEntity> findByUrineProtein(@NotNull String urineProtein);
	/**
	 * Return an entity or a list of entities that have the given attribute Urine Acetone.
	 *
	 * @param urineAcetone the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine Acetone
	 */
	List<DeliveryProgressEntity> findByUrineAcetone(@NotNull String urineAcetone);
	/**
	 * Return an entity or a list of entities that have the given attribute Urine Volume.
	 *
	 * @param urineVolume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine Volume
	 */
	List<DeliveryProgressEntity> findByUrineVolume(@NotNull Double urineVolume);
	/**
	 * Return an entity or a list of entities that have the given attribute Progress Notes.
	 *
	 * @param progressNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Progress Notes
	 */
	List<DeliveryProgressEntity> findByProgressNotes(@NotNull String progressNotes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DeliveryProgressEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DeliveryProgressEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}