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

import kmsweb.entities.GoodsReceiveNoteEntity;
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
public interface GoodsReceiveNoteRepository extends AbstractRepository<GoodsReceiveNoteEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Receive Number.
	 *
	 * @param receiveNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receive Number
	 */
	Optional<GoodsReceiveNoteEntity> findByReceiveNumber(@NotNull String receiveNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Document Type.
	 *
	 * @param sourceDocumentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Document Type
	 */
	List<GoodsReceiveNoteEntity> findBySourceDocumentType(@NotNull GrnSourceTypeEnum sourceDocumentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Document Number.
	 *
	 * @param sourceDocumentNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Document Number
	 */
	List<GoodsReceiveNoteEntity> findBySourceDocumentNumber(@NotNull String sourceDocumentNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Receive Date.
	 *
	 * @param receiveDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receive Date
	 */
	List<GoodsReceiveNoteEntity> findByReceiveDate(@NotNull OffsetDateTime receiveDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	List<GoodsReceiveNoteEntity> findByVoidDate(@NotNull OffsetDateTime voidDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<GoodsReceiveNoteEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<GoodsReceiveNoteEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Invoice Number.
	 *
	 * @param supplierInvoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Invoice Number
	 */
	List<GoodsReceiveNoteEntity> findBySupplierInvoiceNumber(@NotNull String supplierInvoiceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Method.
	 *
	 * @param shippingMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Method
	 */
	List<GoodsReceiveNoteEntity> findByShippingMethod(@NotNull String shippingMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Number.
	 *
	 * @param shippingNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Number
	 */
	List<GoodsReceiveNoteEntity> findByShippingNumber(@NotNull String shippingNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Date.
	 *
	 * @param shippingDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Date
	 */
	List<GoodsReceiveNoteEntity> findByShippingDate(@NotNull OffsetDateTime shippingDate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<GoodsReceiveNoteEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<GoodsReceiveNoteEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}