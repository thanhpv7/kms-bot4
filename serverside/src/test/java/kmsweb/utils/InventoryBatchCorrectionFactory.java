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
import kmsweb.entities.InventoryBatchCorrectionEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InventoryBatchCorrectionFactory implements FactoryBean<InventoryBatchCorrectionEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InventoryBatchCorrectionEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InventoryBatchCorrectionEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InventoryBatchCorrectionEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef before the main body here] end

		InventoryBatchCorrectionEntity newEntity = new InventoryBatchCorrectionEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Batch Correction Number here] off begin
		String randomStringForBatchCorrectionNumber = mockNeat
				.strings()
				.get();
		newEntity.setBatchCorrectionNumber(randomStringForBatchCorrectionNumber);
		// % protected region % [Add customisation for Batch Correction Number here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringForApprovalStatus = mockNeat
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringForApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Transaction Type here] off begin
		newEntity.setTransactionType(BatchCorrectionTypeEnum.ADJUSTMENT_BATCH);
		// % protected region % [Add customisation for Transaction Type here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringForReferenceNumber = mockNeat
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringForReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Void Reason here] off begin
		String randomStringForVoidReason = mockNeat
				.strings()
				.get();
		newEntity.setVoidReason(randomStringForVoidReason);
		// % protected region % [Add customisation for Void Reason here] end

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Batch Correction Items here] off begin
			// Outgoing one to many reference
			var inventoryBatchCorrectionItemsFactory = new InventoryBatchCorrectionItemFactory();
			newEntity.setInventoryBatchCorrectionItems(Collections.singletonList(inventoryBatchCorrectionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Batch Correction Items here] end

		}

		// % protected region % [Apply any additional logic for inventoryBatchCorrection with ref here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrection with ref here] end

		return newEntity;
	}

	@Override
	public Class<InventoryBatchCorrectionEntity> getObjectType() {
		return InventoryBatchCorrectionEntity.class;
	}
}