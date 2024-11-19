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

import kmsweb.entities.InvoiceItemEntity;
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
public interface InvoiceItemRepository extends AbstractRepository<InvoiceItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<InvoiceItemEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	List<InvoiceItemEntity> findByTariffCode(@NotNull String tariffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	List<InvoiceItemEntity> findByTariffType(@NotNull TariffTypeEnum tariffType);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<InvoiceItemEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff Code.
	 *
	 * @param medicalStaffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff Code
	 */
	List<InvoiceItemEntity> findByMedicalStaffCode(@NotNull String medicalStaffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Price.
	 *
	 * @param price the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price
	 */
	List<InvoiceItemEntity> findByPrice(@NotNull Double price);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Price.
	 *
	 * @param hospitalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Price
	 */
	List<InvoiceItemEntity> findByHospitalPrice(@NotNull Double hospitalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Other Component Price.
	 *
	 * @param totalOtherComponentPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Other Component Price
	 */
	List<InvoiceItemEntity> findByTotalOtherComponentPrice(@NotNull Double totalOtherComponentPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity.
	 *
	 * @param quantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity
	 */
	List<InvoiceItemEntity> findByQuantity(@NotNull Double quantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit.
	 *
	 * @param unit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit
	 */
	List<InvoiceItemEntity> findByUnit(@NotNull String unit);
	/**
	 * Return an entity or a list of entities that have the given attribute Discount.
	 *
	 * @param discount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount
	 */
	List<InvoiceItemEntity> findByDiscount(@NotNull Double discount);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax.
	 *
	 * @param tax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax
	 */
	List<InvoiceItemEntity> findByTax(@NotNull Boolean tax);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Total.
	 *
	 * @param itemTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Total
	 */
	List<InvoiceItemEntity> findByItemTotal(@NotNull Double itemTotal);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<InvoiceItemEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<InvoiceItemEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InvoiceItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InvoiceItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}