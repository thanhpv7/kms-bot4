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
import kmsweb.entities.SupplierEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class SupplierFactory implements FactoryBean<SupplierEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public SupplierEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public SupplierEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public SupplierEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for supplierWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierWithNoRef before the main body here] end

		SupplierEntity newEntity = new SupplierEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Supplier Number here] off begin
		String randomStringForSupplierNumber = mockNeat
				.strings()
				.get();
		newEntity.setSupplierNumber(randomStringForSupplierNumber);
		// % protected region % [Add customisation for Supplier Number here] end
		// % protected region % [Add customisation for Supplier Name here] off begin
		String randomStringForSupplierName = mockNeat
				.strings()
				.get();
		newEntity.setSupplierName(randomStringForSupplierName);
		// % protected region % [Add customisation for Supplier Name here] end
		// % protected region % [Add customisation for Tax ID here] off begin
		String randomStringForTaxID = mockNeat
				.strings()
				.get();
		newEntity.setTaxID(randomStringForTaxID);
		// % protected region % [Add customisation for Tax ID here] end
		// % protected region % [Add customisation for Supply Stock Group here] off begin
		String randomStringForSupplyStockGroup = mockNeat
				.strings()
				.get();
		newEntity.setSupplyStockGroup(randomStringForSupplyStockGroup);
		// % protected region % [Add customisation for Supply Stock Group here] end
		// % protected region % [Add customisation for Adress here] off begin
		String randomStringForAdress = mockNeat
				.strings()
				.get();
		newEntity.setAdress(randomStringForAdress);
		// % protected region % [Add customisation for Adress here] end
		// % protected region % [Add customisation for Country here] off begin
		String randomStringForCountry = mockNeat
				.strings()
				.get();
		newEntity.setCountry(randomStringForCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for State Province here] off begin
		String randomStringForStateProvince = mockNeat
				.strings()
				.get();
		newEntity.setStateProvince(randomStringForStateProvince);
		// % protected region % [Add customisation for State Province here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringForCity = mockNeat
				.strings()
				.get();
		newEntity.setCity(randomStringForCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Postal Code here] off begin
		String randomStringForPostalCode = mockNeat
				.strings()
				.get();
		newEntity.setPostalCode(randomStringForPostalCode);
		// % protected region % [Add customisation for Postal Code here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Other Phone Number here] off begin
		String randomStringForOtherPhoneNumber = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setOtherPhoneNumber(randomStringForOtherPhoneNumber);
		// % protected region % [Add customisation for Other Phone Number here] end
		// % protected region % [Add customisation for Fax here] off begin
		String randomStringForFax = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setFax(randomStringForFax);
		// % protected region % [Add customisation for Fax here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.emails()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Website here] off begin
		String randomStringForWebsite = mockNeat
				.strings()
				.get();
		newEntity.setWebsite(randomStringForWebsite);
		// % protected region % [Add customisation for Website here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Purchase Order Hold here] off begin
		newEntity.setPurchaseOrderHold(mockNeat.bools().get());
		// % protected region % [Add customisation for Purchase Order Hold here] end
		// % protected region % [Add customisation for Purchase Order Hold Reason here] off begin
		String randomStringForPurchaseOrderHoldReason = mockNeat
				.strings()
				.get();
		newEntity.setPurchaseOrderHoldReason(randomStringForPurchaseOrderHoldReason);
		// % protected region % [Add customisation for Purchase Order Hold Reason here] end
		// % protected region % [Add customisation for VAT Included here] off begin
		newEntity.setVatIncluded(mockNeat.bools().get());
		// % protected region % [Add customisation for VAT Included here] end
		// % protected region % [Add customisation for Shipping Method here] off begin
		String randomStringForShippingMethod = mockNeat
				.strings()
				.get();
		newEntity.setShippingMethod(randomStringForShippingMethod);
		// % protected region % [Add customisation for Shipping Method here] end
		// % protected region % [Add customisation for Lead Time Minimum here] off begin
		newEntity.setLeadTimeMinimum(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lead Time Minimum here] end
		// % protected region % [Add customisation for Lead Time Maximum here] off begin
		newEntity.setLeadTimeMaximum(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lead Time Maximum here] end
		// % protected region % [Add customisation for Last Purchase Date here] off begin
		newEntity.setLastPurchaseDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Last Purchase Date here] end
		// % protected region % [Add customisation for Last Purchase Order Number here] off begin
		String randomStringForLastPurchaseOrderNumber = mockNeat
				.strings()
				.get();
		newEntity.setLastPurchaseOrderNumber(randomStringForLastPurchaseOrderNumber);
		// % protected region % [Add customisation for Last Purchase Order Number here] end
		// % protected region % [Add customisation for Lead Time Measurement here] off begin
		String randomStringForLeadTimeMeasurement = mockNeat
				.strings()
				.get();
		newEntity.setLeadTimeMeasurement(randomStringForLeadTimeMeasurement);
		// % protected region % [Add customisation for Lead Time Measurement here] end

		// % protected region % [Apply any additional logic for supplierWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Notes here] off begin
			// Outgoing one to many reference
			var goodsReceiveNotesFactory = new GoodsReceiveNoteFactory();
			newEntity.setGoodsReceiveNotes(Collections.singletonList(goodsReceiveNotesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Notes here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Orders here] off begin
			// Outgoing one to many reference
			var purchaseOrdersFactory = new PurchaseOrderFactory();
			newEntity.setPurchaseOrders(Collections.singletonList(purchaseOrdersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Orders here] end

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

			// % protected region % [Override the reference inclusion for outgoingOneToMany Suplier Contact Details here] off begin
			// Outgoing one to many reference
			var suplierContactDetailsFactory = new SupplierContactDetailFactory();
			newEntity.setSuplierContactDetails(Collections.singletonList(suplierContactDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Suplier Contact Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Supplier Bank Accounts here] off begin
			// Outgoing one to many reference
			var supplierBankAccountsFactory = new SupplierBankAccountFactory();
			newEntity.setSupplierBankAccounts(Collections.singletonList(supplierBankAccountsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Supplier Bank Accounts here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Supplier Product Details here] off begin
			// Outgoing one to many reference
			var supplierProductDetailsFactory = new SupplierProductDetailFactory();
			newEntity.setSupplierProductDetails(Collections.singletonList(supplierProductDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Supplier Product Details here] end

		}

		// % protected region % [Apply any additional logic for supplier with ref here] off begin
		// % protected region % [Apply any additional logic for supplier with ref here] end

		return newEntity;
	}

	@Override
	public Class<SupplierEntity> getObjectType() {
		return SupplierEntity.class;
	}
}