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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Transfer Order used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TransferOrderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TransferOrderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TransferOrderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TransferOrderEntityFactory transferOrderEntityFactory(
			// % protected region % [Apply any additional injected arguments for transferOrderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for transferOrderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TransferOrderEntityFactory");

		// % protected region % [Apply any additional logic for transferOrderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntityFactory before the main body here] end

		TransferOrderEntityFactory entityFactory = new TransferOrderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TransferOrderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TransferOrderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for transferOrderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntityFactory after the main body here] end

		log.trace("Created TransferOrderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Transfer Order entity with no references set.
	 */
	@Provides
	@Named("transferOrderEntityWithNoRef")
	public TransferOrderEntity transferOrderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for transferOrderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for transferOrderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TransferOrderEntity with no reference");

		// % protected region % [Apply any additional logic for transferOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderWithNoRef before the main body here] end

		TransferOrderEntity newEntity = new TransferOrderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transfer Order Number here] off begin
		String randomStringforTransferOrderNumber = mock
				.strings()
				.get();
		newEntity.setTransferOrderNumber(randomStringforTransferOrderNumber);
		// % protected region % [Add customisation for Transfer Order Number here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringforTransactionStatus = mock
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringforTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Expected Date here] off begin
		newEntity.setExpectedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expected Date here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringforReferenceNumber = mock
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringforReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Reference Document here] off begin
		String randomStringforReferenceDocument = mock
				.strings()
				.get();
		newEntity.setReferenceDocument(randomStringforReferenceDocument);
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

		log.trace("Created entity of type TransferOrderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Transfer Order entities with no reference at all.
	 */
	@Provides
	@Named("transferOrderEntitiesWithNoRef")
	public Collection<TransferOrderEntity> transferOrderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for transferOrderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for transferOrderEntitiesWithNoRef here] end
		TransferOrderEntityFactory transferOrderEntityFactory
	) {
		log.trace("Creating entities of type TransferOrderEntity with no reference");

		// % protected region % [Apply any additional logic for transferOrderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntitiesWithNoRef before the main body here] end

		Collection<TransferOrderEntity> newEntities = transferOrderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for transferOrderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TransferOrderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Transfer Order entity with all references set.
	 */
	@Provides
	@Named("transferOrderEntityWithRefs")
	public TransferOrderEntity transferOrderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for transferOrderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for transferOrderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TransferOrderEntity with references");

		// % protected region % [Apply any additional logic for transferOrderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntityWithRefs before the main body here] end

		TransferOrderEntity transferOrderEntity = injector.getInstance(Key.get(TransferOrderEntity.class, Names.named("transferOrderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for transferOrderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntityWithRefs after the main body here] end

		log.trace("Created entity of type TransferOrderEntity with references");

		return transferOrderEntity;
	}

	/**
	 * Return a collection of Transfer Order entities with all references set.
	 */
	@Provides
	@Named("transferOrderEntitiesWithRefs")
	public Collection<TransferOrderEntity> transferOrderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for transferOrderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for transferOrderEntitiesWithRefs here] end
		TransferOrderEntityFactory transferOrderEntityFactory
	) {
		log.trace("Creating entities of type TransferOrderEntity with references");

		// % protected region % [Apply any additional logic for transferOrderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntitiesWithRefs before the main body here] end

		Collection<TransferOrderEntity> newEntities = transferOrderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for transferOrderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TransferOrderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
