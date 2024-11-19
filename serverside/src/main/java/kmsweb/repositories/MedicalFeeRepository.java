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

import kmsweb.entities.MedicalFeeEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
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
public interface MedicalFeeRepository extends AbstractRepository<MedicalFeeEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	List<MedicalFeeEntity> findByTariffType(@NotNull TariffTypeEnum tariffType);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	List<MedicalFeeEntity> findByTariffCode(@NotNull String tariffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<MedicalFeeEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute Pharmacy Transaction Type.
	 *
	 * @param pharmacyTransactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pharmacy Transaction Type
	 */
	List<MedicalFeeEntity> findByPharmacyTransactionType(@NotNull PharmacyTypeEnum pharmacyTransactionType);
	/**
	 * Return an entity or a list of entities that have the given attribute Pharmacy Transaction Number.
	 *
	 * @param pharmacyTransactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pharmacy Transaction Number
	 */
	List<MedicalFeeEntity> findByPharmacyTransactionNumber(@NotNull String pharmacyTransactionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Medication Transaction Number.
	 *
	 * @param medicationTransactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Transaction Number
	 */
	List<MedicalFeeEntity> findByMedicationTransactionNumber(@NotNull String medicationTransactionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<MedicalFeeEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity.
	 *
	 * @param quantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity
	 */
	List<MedicalFeeEntity> findByQuantity(@NotNull Double quantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit.
	 *
	 * @param unit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit
	 */
	List<MedicalFeeEntity> findByUnit(@NotNull String unit);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	List<MedicalFeeEntity> findByUnitPrice(@NotNull Double unitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Price.
	 *
	 * @param hospitalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Price
	 */
	List<MedicalFeeEntity> findByHospitalPrice(@NotNull Double hospitalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Component Price.
	 *
	 * @param otherComponentPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Component Price
	 */
	List<MedicalFeeEntity> findByOtherComponentPrice(@NotNull Double otherComponentPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff Code.
	 *
	 * @param medicalStaffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff Code
	 */
	List<MedicalFeeEntity> findByMedicalStaffCode(@NotNull String medicalStaffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<MedicalFeeEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<MedicalFeeEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute medical fee status.
	 *
	 * @param medicalFeeStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute medical fee status
	 */
	List<MedicalFeeEntity> findByMedicalFeeStatus(@NotNull MedicalFeeStatusEnum medicalFeeStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<MedicalFeeEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalFeeEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalFeeEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}