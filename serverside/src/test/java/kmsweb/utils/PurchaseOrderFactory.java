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
import kmsweb.entities.PurchaseOrderEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PurchaseOrderFactory implements FactoryBean<PurchaseOrderEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PurchaseOrderEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PurchaseOrderEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PurchaseOrderEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef before the main body here] end

		PurchaseOrderEntity newEntity = new PurchaseOrderEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Purchase Order Type here] off begin
		String randomStringForPurchaseOrderType = mockNeat
				.strings()
				.get();
		newEntity.setPurchaseOrderType(randomStringForPurchaseOrderType);
		// % protected region % [Add customisation for Purchase Order Type here] end
		// % protected region % [Add customisation for Purchase Order Number here] off begin
		String randomStringForPurchaseOrderNumber = mockNeat
				.strings()
				.get();
		newEntity.setPurchaseOrderNumber(randomStringForPurchaseOrderNumber);
		// % protected region % [Add customisation for Purchase Order Number here] end
		// % protected region % [Add customisation for status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for status here] end
		// % protected region % [Add customisation for Supply Stock Group here] off begin
		String randomStringForSupplyStockGroup = mockNeat
				.strings()
				.get();
		newEntity.setSupplyStockGroup(randomStringForSupplyStockGroup);
		// % protected region % [Add customisation for Supply Stock Group here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Expected Date here] off begin
		newEntity.setExpectedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expected Date here] end
		// % protected region % [Add customisation for Price VAT Included here] off begin
		newEntity.setPriceVATIncluded(mockNeat.bools().get());
		// % protected region % [Add customisation for Price VAT Included here] end
		// % protected region % [Add customisation for Inventory VAT Included here] off begin
		newEntity.setInventoryVATIncluded(mockNeat.bools().get());
		// % protected region % [Add customisation for Inventory VAT Included here] end
		// % protected region % [Add customisation for Reference Document here] off begin
		String randomStringForReferenceDocument = mockNeat
				.strings()
				.get();
		newEntity.setReferenceDocument(randomStringForReferenceDocument);
		// % protected region % [Add customisation for Reference Document here] end
		// % protected region % [Add customisation for Supplier Reference Document here] off begin
		String randomStringForSupplierReferenceDocument = mockNeat
				.strings()
				.get();
		newEntity.setSupplierReferenceDocument(randomStringForSupplierReferenceDocument);
		// % protected region % [Add customisation for Supplier Reference Document here] end
		// % protected region % [Add customisation for Payment Terms here] off begin
		String randomStringForPaymentTerms = mockNeat
				.strings()
				.get();
		newEntity.setPaymentTerms(randomStringForPaymentTerms);
		// % protected region % [Add customisation for Payment Terms here] end
		// % protected region % [Add customisation for Shipping Method here] off begin
		String randomStringForShippingMethod = mockNeat
				.strings()
				.get();
		newEntity.setShippingMethod(randomStringForShippingMethod);
		// % protected region % [Add customisation for Shipping Method here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Sub Total here] off begin
		newEntity.setSubTotal(mockNeat.doubles().get());
		// % protected region % [Add customisation for Sub Total here] end
		// % protected region % [Add customisation for Extra Discount In Percent here] off begin
		newEntity.setExtraDiscountInPercent(mockNeat.bools().get());
		// % protected region % [Add customisation for Extra Discount In Percent here] end
		// % protected region % [Add customisation for Extra Discount Include Tax here] off begin
		newEntity.setExtraDiscountIncludeTax(mockNeat.bools().get());
		// % protected region % [Add customisation for Extra Discount Include Tax here] end
		// % protected region % [Add customisation for Extra Discount Value here] off begin
		newEntity.setExtraDiscountValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Extra Discount Value here] end
		// % protected region % [Add customisation for Freight Fee Include Tax here] off begin
		newEntity.setFreightFeeIncludeTax(mockNeat.bools().get());
		// % protected region % [Add customisation for Freight Fee Include Tax here] end
		// % protected region % [Add customisation for Freight Fee Value here] off begin
		newEntity.setFreightFeeValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Freight Fee Value here] end
		// % protected region % [Add customisation for Other Fee Include Tax here] off begin
		newEntity.setOtherFeeIncludeTax(mockNeat.bools().get());
		// % protected region % [Add customisation for Other Fee Include Tax here] end
		// % protected region % [Add customisation for Other Fee Value here] off begin
		newEntity.setOtherFeeValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Other Fee Value here] end
		// % protected region % [Add customisation for Tax Base here] off begin
		newEntity.setTaxBase(mockNeat.doubles().get());
		// % protected region % [Add customisation for Tax Base here] end
		// % protected region % [Add customisation for Tax Amount here] off begin
		newEntity.setTaxAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Tax Amount here] end
		// % protected region % [Add customisation for Total Amount here] off begin
		newEntity.setTotalAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Amount here] end

		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyGoods Receive Note here] off begin
			var goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();
			newEntity.setGoodsReceiveNote(goodsReceiveNoteFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyGoods Receive Note here] end

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

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Order Stock Details here] off begin
			// Outgoing one to many reference
			var purchaseOrderStockDetailsFactory = new PurchaseOrderStockDetailFactory();
			newEntity.setPurchaseOrderStockDetails(Collections.singletonList(purchaseOrderStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Order Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisitions here] off begin
			// Outgoing one to many reference
			var purchaseRequisitionsFactory = new PurchaseRequisitionFactory();
			newEntity.setPurchaseRequisitions(Collections.singletonList(purchaseRequisitionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisitions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Return Suppliers here] off begin
			// Outgoing one to many reference
			var returnSuppliersFactory = new ReturnSupplierFactory();
			newEntity.setReturnSuppliers(Collections.singletonList(returnSuppliersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Return Suppliers here] end

		}

		// % protected region % [Apply any additional logic for purchaseOrder with ref here] off begin
		// % protected region % [Apply any additional logic for purchaseOrder with ref here] end

		return newEntity;
	}

	@Override
	public Class<PurchaseOrderEntity> getObjectType() {
		return PurchaseOrderEntity.class;
	}
}