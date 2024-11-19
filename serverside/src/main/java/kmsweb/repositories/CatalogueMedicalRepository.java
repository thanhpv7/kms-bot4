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

import kmsweb.entities.CatalogueMedicalEntity;
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
public interface CatalogueMedicalRepository extends AbstractRepository<CatalogueMedicalEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Composition.
	 *
	 * @param composition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Composition
	 */
	List<CatalogueMedicalEntity> findByComposition(@NotNull String composition);
	/**
	 * Return an entity or a list of entities that have the given attribute Can be prescribed.
	 *
	 * @param canBePrescribed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Can be prescribed
	 */
	List<CatalogueMedicalEntity> findByCanBePrescribed(@NotNull Boolean canBePrescribed);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Hospital Formulary.
	 *
	 * @param isHospitalFormulary the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Hospital Formulary
	 */
	List<CatalogueMedicalEntity> findByIsHospitalFormulary(@NotNull Boolean isHospitalFormulary);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Notes.
	 *
	 * @param approvalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Notes
	 */
	List<CatalogueMedicalEntity> findByApprovalNotes(@NotNull String approvalNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Generic.
	 *
	 * @param isGeneric the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Generic
	 */
	List<CatalogueMedicalEntity> findByIsGeneric(@NotNull Boolean isGeneric);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Restricted.
	 *
	 * @param isRestricted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Restricted
	 */
	List<CatalogueMedicalEntity> findByIsRestricted(@NotNull Boolean isRestricted);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Vaccine.
	 *
	 * @param isVaccine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Vaccine
	 */
	List<CatalogueMedicalEntity> findByIsVaccine(@NotNull Boolean isVaccine);
	/**
	 * Return an entity or a list of entities that have the given attribute Vaccine Type.
	 *
	 * @param vaccineType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vaccine Type
	 */
	List<CatalogueMedicalEntity> findByVaccineType(@NotNull String vaccineType);
	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	List<CatalogueMedicalEntity> findByConsumptionMethod(@NotNull String consumptionMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Unit.
	 *
	 * @param consumptionUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Unit
	 */
	List<CatalogueMedicalEntity> findByConsumptionUnit(@NotNull String consumptionUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Compound Charging Rounding.
	 *
	 * @param compoundChargingRounding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Charging Rounding
	 */
	List<CatalogueMedicalEntity> findByCompoundChargingRounding(@NotNull Boolean compoundChargingRounding);
	/**
	 * Return an entity or a list of entities that have the given attribute Compound Charging Rounding Amount.
	 *
	 * @param compoundChargingRoundingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Charging Rounding Amount
	 */
	List<CatalogueMedicalEntity> findByCompoundChargingRoundingAmount(@NotNull String compoundChargingRoundingAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding.
	 *
	 * @param inventoryRounding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding
	 */
	List<CatalogueMedicalEntity> findByInventoryRounding(@NotNull Boolean inventoryRounding);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Amount.
	 *
	 * @param inventoryRoundingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Amount
	 */
	List<CatalogueMedicalEntity> findByInventoryRoundingAmount(@NotNull Double inventoryRoundingAmount);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CatalogueMedicalEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CatalogueMedicalEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}