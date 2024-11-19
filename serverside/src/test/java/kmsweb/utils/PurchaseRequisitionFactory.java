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
import kmsweb.entities.PurchaseRequisitionEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PurchaseRequisitionFactory implements FactoryBean<PurchaseRequisitionEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PurchaseRequisitionEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PurchaseRequisitionEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PurchaseRequisitionEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for purchaseRequisitionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionWithNoRef before the main body here] end

		PurchaseRequisitionEntity newEntity = new PurchaseRequisitionEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Purchase Requisition Number here] off begin
		String randomStringForPurchaseRequisitionNumber = mockNeat
				.strings()
				.get();
		newEntity.setPurchaseRequisitionNumber(randomStringForPurchaseRequisitionNumber);
		// % protected region % [Add customisation for Purchase Requisition Number here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringForTransactionStatus = mockNeat
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringForTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Reference Document here] off begin
		String randomStringForReferenceDocument = mockNeat
				.strings()
				.get();
		newEntity.setReferenceDocument(randomStringForReferenceDocument);
		// % protected region % [Add customisation for Reference Document here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Required Date here] off begin
		newEntity.setRequiredDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Required Date here] end
		// % protected region % [Add customisation for Total Estimation Order here] off begin
		newEntity.setTotalEstimationOrder(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Estimation Order here] end
		// % protected region % [Add customisation for Redrafting Date Time here] off begin
		newEntity.setRedraftingDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Redrafting Date Time here] end
		// % protected region % [Add customisation for Submission Date Time here] off begin
		newEntity.setSubmissionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Submission Date Time here] end
		// % protected region % [Add customisation for Approval Date Time here] off begin
		newEntity.setApprovalDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Approval Date Time here] end
		// % protected region % [Add customisation for Rejection Date Time here] off begin
		newEntity.setRejectionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Rejection Date Time here] end
		// % protected region % [Add customisation for Voiding Date Time here] off begin
		newEntity.setVoidingDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Voiding Date Time here] end

		// % protected region % [Apply any additional logic for purchaseRequisitionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Order here] off begin
			var purchaseOrderFactory = new PurchaseOrderFactory();
			newEntity.setPurchaseOrder(purchaseOrderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Order here] end

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

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisition Stock Details here] off begin
			// Outgoing one to many reference
			var purchaseRequisitionStockDetailsFactory = new PurchaseRequisitionStockDetailFactory();
			newEntity.setPurchaseRequisitionStockDetails(Collections.singletonList(purchaseRequisitionStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisition Stock Details here] end

		}

		// % protected region % [Apply any additional logic for purchaseRequisition with ref here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisition with ref here] end

		return newEntity;
	}

	@Override
	public Class<PurchaseRequisitionEntity> getObjectType() {
		return PurchaseRequisitionEntity.class;
	}
}