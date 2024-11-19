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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.GoodsReceiveNoteEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class GoodsReceiveNoteFactory implements FactoryBean<GoodsReceiveNoteEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public GoodsReceiveNoteEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public GoodsReceiveNoteEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public GoodsReceiveNoteEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef before the main body here] end

		GoodsReceiveNoteEntity newEntity = new GoodsReceiveNoteEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Receive Number here] off begin
		String randomStringForReceiveNumber = mockNeat
				.strings()
				.get();
		newEntity.setReceiveNumber(randomStringForReceiveNumber);
		// % protected region % [Add customisation for Receive Number here] end
		// % protected region % [Add customisation for Source Document Type here] off begin
		newEntity.setSourceDocumentType(GrnSourceTypeEnum.NONE);
		// % protected region % [Add customisation for Source Document Type here] end
		// % protected region % [Add customisation for Source Document Number here] off begin
		String randomStringForSourceDocumentNumber = mockNeat
				.strings()
				.get();
		newEntity.setSourceDocumentNumber(randomStringForSourceDocumentNumber);
		// % protected region % [Add customisation for Source Document Number here] end
		// % protected region % [Add customisation for Receive Date here] off begin
		newEntity.setReceiveDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Receive Date here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringForApprovalStatus = mockNeat
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringForApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Supplier Invoice Number here] off begin
		String randomStringForSupplierInvoiceNumber = mockNeat
				.strings()
				.get();
		newEntity.setSupplierInvoiceNumber(randomStringForSupplierInvoiceNumber);
		// % protected region % [Add customisation for Supplier Invoice Number here] end
		// % protected region % [Add customisation for Shipping Method here] off begin
		String randomStringForShippingMethod = mockNeat
				.strings()
				.get();
		newEntity.setShippingMethod(randomStringForShippingMethod);
		// % protected region % [Add customisation for Shipping Method here] end
		// % protected region % [Add customisation for Shipping Number here] off begin
		String randomStringForShippingNumber = mockNeat
				.strings()
				.get();
		newEntity.setShippingNumber(randomStringForShippingNumber);
		// % protected region % [Add customisation for Shipping Number here] end
		// % protected region % [Add customisation for Shipping Date here] off begin
		newEntity.setShippingDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Shipping Date here] end

		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySupplier here] off begin
			var supplierFactory = new SupplierFactory();
			newEntity.setSupplier(supplierFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySupplier here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Items here] off begin
			// Outgoing one to many reference
			var goodsReceiveNoteItemsFactory = new GoodsReceiveNoteItemFactory();
			newEntity.setGoodsReceiveNoteItems(Collections.singletonList(goodsReceiveNoteItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Orders here] off begin
			// Outgoing one to many reference
			var purchaseOrdersFactory = new PurchaseOrderFactory();
			newEntity.setPurchaseOrders(Collections.singletonList(purchaseOrdersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Orders here] end

		}

		// % protected region % [Apply any additional logic for goodsReceiveNote with ref here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNote with ref here] end

		return newEntity;
	}

	@Override
	public Class<GoodsReceiveNoteEntity> getObjectType() {
		return GoodsReceiveNoteEntity.class;
	}
}