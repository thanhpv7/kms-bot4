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

import kmsweb.entities.InvoiceEntity;
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
public interface InvoiceRepository extends AbstractRepository<InvoiceEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Number.
	 *
	 * @param invoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Number
	 */
	List<InvoiceEntity> findByInvoiceNumber(@NotNull String invoiceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Revision Number.
	 *
	 * @param revisionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revision Number
	 */
	List<InvoiceEntity> findByRevisionNumber(@NotNull Integer revisionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Status.
	 *
	 * @param invoiceStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Status
	 */
	List<InvoiceEntity> findByInvoiceStatus(@NotNull String invoiceStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Type.
	 *
	 * @param invoiceType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Type
	 */
	List<InvoiceEntity> findByInvoiceType(@NotNull InvoiceTypeEnum invoiceType);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Date.
	 *
	 * @param invoiceDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Date
	 */
	List<InvoiceEntity> findByInvoiceDate(@NotNull OffsetDateTime invoiceDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Cancel Date.
	 *
	 * @param cancelDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cancel Date
	 */
	List<InvoiceEntity> findByCancelDate(@NotNull OffsetDateTime cancelDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Billing Location.
	 *
	 * @param billingLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Billing Location
	 */
	List<InvoiceEntity> findByBillingLocation(@NotNull String billingLocation);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<InvoiceEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Payment Type.
	 *
	 * @param patientPaymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Payment Type
	 */
	List<InvoiceEntity> findByPatientPaymentType(@NotNull String patientPaymentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Verification Date.
	 *
	 * @param verificationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verification Date
	 */
	List<InvoiceEntity> findByVerificationDate(@NotNull OffsetDateTime verificationDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Display Doctor on Print.
	 *
	 * @param displayDoctorOnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display Doctor on Print
	 */
	List<InvoiceEntity> findByDisplayDoctorOnPrint(@NotNull Boolean displayDoctorOnPrint);
	/**
	 * Return an entity or a list of entities that have the given attribute Display ICD 10 on Print.
	 *
	 * @param displayICD10OnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display ICD 10 on Print
	 */
	List<InvoiceEntity> findByDisplayICD10OnPrint(@NotNull Boolean displayICD10OnPrint);
	/**
	 * Return an entity or a list of entities that have the given attribute Display ICD 9 CM on Print.
	 *
	 * @param displayICD9CMOnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display ICD 9 CM on Print
	 */
	List<InvoiceEntity> findByDisplayICD9CMOnPrint(@NotNull Boolean displayICD9CMOnPrint);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Code.
	 *
	 * @param doctorCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Code
	 */
	List<InvoiceEntity> findByDoctorCode(@NotNull String doctorCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<InvoiceEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Admission Date.
	 *
	 * @param admissionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Date
	 */
	List<InvoiceEntity> findByAdmissionDate(@NotNull OffsetDateTime admissionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Discharged Date.
	 *
	 * @param dischargedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharged Date
	 */
	List<InvoiceEntity> findByDischargedDate(@NotNull OffsetDateTime dischargedDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Claim No.
	 *
	 * @param claimNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim No
	 */
	List<InvoiceEntity> findByClaimNo(@NotNull String claimNo);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InvoiceEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InvoiceEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}