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

import kmsweb.entities.InvoiceSummaryEntity;
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
public interface InvoiceSummaryRepository extends AbstractRepository<InvoiceSummaryEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Total.
	 *
	 * @param subTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Total
	 */
	List<InvoiceSummaryEntity> findBySubTotal(@NotNull Double subTotal);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax On Other Discount.
	 *
	 * @param taxOnOtherDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax On Other Discount
	 */
	List<InvoiceSummaryEntity> findByTaxOnOtherDiscount(@NotNull Boolean taxOnOtherDiscount);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Discount.
	 *
	 * @param otherDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Discount
	 */
	List<InvoiceSummaryEntity> findByOtherDiscount(@NotNull Double otherDiscount);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax On Other Fee.
	 *
	 * @param taxOnOtherFee the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax On Other Fee
	 */
	List<InvoiceSummaryEntity> findByTaxOnOtherFee(@NotNull Boolean taxOnOtherFee);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee.
	 *
	 * @param otherFee the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee
	 */
	List<InvoiceSummaryEntity> findByOtherFee(@NotNull Double otherFee);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax.
	 *
	 * @param tax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax
	 */
	List<InvoiceSummaryEntity> findByTax(@NotNull Double tax);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Invoice.
	 *
	 * @param totalInvoice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Invoice
	 */
	List<InvoiceSummaryEntity> findByTotalInvoice(@NotNull Double totalInvoice);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Down Payment.
	 *
	 * @param availableDownPayment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Down Payment
	 */
	List<InvoiceSummaryEntity> findByAvailableDownPayment(@NotNull Double availableDownPayment);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Coverage.
	 *
	 * @param totalCoverage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Coverage
	 */
	List<InvoiceSummaryEntity> findByTotalCoverage(@NotNull Double totalCoverage);
	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	List<InvoiceSummaryEntity> findByOutstandingAmount(@NotNull Double outstandingAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Coverage.
	 *
	 * @param bpjsCoverage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Coverage
	 */
	List<InvoiceSummaryEntity> findByBpjsCoverage(@NotNull Double bpjsCoverage);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InvoiceSummaryEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InvoiceSummaryEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}