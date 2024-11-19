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

import kmsweb.entities.RetailPharmacyInvoiceEntity;
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
public interface RetailPharmacyInvoiceRepository extends AbstractRepository<RetailPharmacyInvoiceEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Number.
	 *
	 * @param invoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Number
	 */
	List<RetailPharmacyInvoiceEntity> findByInvoiceNumber(@NotNull String invoiceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Revision Number.
	 *
	 * @param revisionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revision Number
	 */
	List<RetailPharmacyInvoiceEntity> findByRevisionNumber(@NotNull Integer revisionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Status.
	 *
	 * @param invoiceStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Status
	 */
	List<RetailPharmacyInvoiceEntity> findByInvoiceStatus(@NotNull String invoiceStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Date.
	 *
	 * @param invoiceDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Date
	 */
	List<RetailPharmacyInvoiceEntity> findByInvoiceDate(@NotNull OffsetDateTime invoiceDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Cancel Date.
	 *
	 * @param cancelDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cancel Date
	 */
	List<RetailPharmacyInvoiceEntity> findByCancelDate(@NotNull OffsetDateTime cancelDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Billing Location.
	 *
	 * @param billingLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Billing Location
	 */
	List<RetailPharmacyInvoiceEntity> findByBillingLocation(@NotNull String billingLocation);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<RetailPharmacyInvoiceEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Payment Type.
	 *
	 * @param patientPaymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Payment Type
	 */
	List<RetailPharmacyInvoiceEntity> findByPatientPaymentType(@NotNull String patientPaymentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Verification Date.
	 *
	 * @param verificationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verification Date
	 */
	List<RetailPharmacyInvoiceEntity> findByVerificationDate(@NotNull OffsetDateTime verificationDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Display Doctor on Print.
	 *
	 * @param displayDoctorOnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display Doctor on Print
	 */
	List<RetailPharmacyInvoiceEntity> findByDisplayDoctorOnPrint(@NotNull Boolean displayDoctorOnPrint);
	/**
	 * Return an entity or a list of entities that have the given attribute Claim No.
	 *
	 * @param claimNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim No
	 */
	List<RetailPharmacyInvoiceEntity> findByClaimNo(@NotNull String claimNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Status.
	 *
	 * @param paymentStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Status
	 */
	List<RetailPharmacyInvoiceEntity> findByPaymentStatus(@NotNull String paymentStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Amount.
	 *
	 * @param invoiceAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Amount
	 */
	List<RetailPharmacyInvoiceEntity> findByInvoiceAmount(@NotNull Double invoiceAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	List<RetailPharmacyInvoiceEntity> findByOutstandingAmount(@NotNull Double outstandingAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Customer Name.
	 *
	 * @param customerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Name
	 */
	List<RetailPharmacyInvoiceEntity> findByCustomerName(@NotNull String customerName);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RetailPharmacyInvoiceEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RetailPharmacyInvoiceEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}