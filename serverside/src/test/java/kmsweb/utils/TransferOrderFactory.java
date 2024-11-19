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
import kmsweb.entities.TransferOrderEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class TransferOrderFactory implements FactoryBean<TransferOrderEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public TransferOrderEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public TransferOrderEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public TransferOrderEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for transferOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderWithNoRef before the main body here] end

		TransferOrderEntity newEntity = new TransferOrderEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transfer Order Number here] off begin
		String randomStringForTransferOrderNumber = mockNeat
				.strings()
				.get();
		newEntity.setTransferOrderNumber(randomStringForTransferOrderNumber);
		// % protected region % [Add customisation for Transfer Order Number here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringForTransactionStatus = mockNeat
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringForTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringForApprovalStatus = mockNeat
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringForApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Expected Date here] off begin
		newEntity.setExpectedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expected Date here] end
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
		// % protected region % [Add customisation for Reference Document here] off begin
		String randomStringForReferenceDocument = mockNeat
				.strings()
				.get();
		newEntity.setReferenceDocument(randomStringForReferenceDocument);
		// % protected region % [Add customisation for Reference Document here] end
		// % protected region % [Add customisation for Required Date here] off begin
		newEntity.setRequiredDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Required Date here] end
		// % protected region % [Add customisation for Issued Date Time here] off begin
		newEntity.setIssuedDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Issued Date Time here] end
		// % protected region % [Add customisation for Received Date Time here] off begin
		newEntity.setReceivedDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Received Date Time here] end

		// % protected region % [Apply any additional logic for transferOrderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDestination Warehouse here] off begin
			var destinationWarehouseFactory = new WarehouseFactory();
			newEntity.setDestinationWarehouse(destinationWarehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDestination Warehouse here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySource Warehouse here] off begin
			var sourceWarehouseFactory = new WarehouseFactory();
			newEntity.setSourceWarehouse(sourceWarehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySource Warehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Transfer Order Stock Details here] off begin
			// Outgoing one to many reference
			var transferOrderStockDetailsFactory = new TransferOrderStockDetailFactory();
			newEntity.setTransferOrderStockDetails(Collections.singletonList(transferOrderStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Transfer Order Stock Details here] end

		}

		// % protected region % [Apply any additional logic for transferOrder with ref here] off begin
		// % protected region % [Apply any additional logic for transferOrder with ref here] end

		return newEntity;
	}

	@Override
	public Class<TransferOrderEntity> getObjectType() {
		return TransferOrderEntity.class;
	}
}