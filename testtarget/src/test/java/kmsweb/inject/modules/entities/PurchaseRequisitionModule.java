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
 * Guice module for Purchase Requisition used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PurchaseRequisitionModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PurchaseRequisitionModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PurchaseRequisitionModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PurchaseRequisitionEntityFactory purchaseRequisitionEntityFactory(
			// % protected region % [Apply any additional injected arguments for purchaseRequisitionEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for purchaseRequisitionEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PurchaseRequisitionEntityFactory");

		// % protected region % [Apply any additional logic for purchaseRequisitionEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntityFactory before the main body here] end

		PurchaseRequisitionEntityFactory entityFactory = new PurchaseRequisitionEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PurchaseRequisitionEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PurchaseRequisitionEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for purchaseRequisitionEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntityFactory after the main body here] end

		log.trace("Created PurchaseRequisitionEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Purchase Requisition entity with no references set.
	 */
	@Provides
	@Named("purchaseRequisitionEntityWithNoRef")
	public PurchaseRequisitionEntity purchaseRequisitionEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PurchaseRequisitionEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseRequisitionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionWithNoRef before the main body here] end

		PurchaseRequisitionEntity newEntity = new PurchaseRequisitionEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Purchase Requisition Number here] off begin
		String randomStringforPurchaseRequisitionNumber = mock
				.strings()
				.get();
		newEntity.setPurchaseRequisitionNumber(randomStringforPurchaseRequisitionNumber);
		// % protected region % [Add customisation for Purchase Requisition Number here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringforTransactionStatus = mock
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringforTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Reference Document here] off begin
		String randomStringforReferenceDocument = mock
				.strings()
				.get();
		newEntity.setReferenceDocument(randomStringforReferenceDocument);
		// % protected region % [Add customisation for Reference Document here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Required Date here] off begin
		newEntity.setRequiredDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Required Date here] end
		// % protected region % [Add customisation for Total Estimation Order here] off begin
		newEntity.setTotalEstimationOrder(mock.doubles().get());
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

		log.trace("Created entity of type PurchaseRequisitionEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Purchase Requisition entities with no reference at all.
	 */
	@Provides
	@Named("purchaseRequisitionEntitiesWithNoRef")
	public Collection<PurchaseRequisitionEntity> purchaseRequisitionEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntitiesWithNoRef here] end
		PurchaseRequisitionEntityFactory purchaseRequisitionEntityFactory
	) {
		log.trace("Creating entities of type PurchaseRequisitionEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithNoRef before the main body here] end

		Collection<PurchaseRequisitionEntity> newEntities = purchaseRequisitionEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PurchaseRequisitionEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Purchase Requisition entity with all references set.
	 */
	@Provides
	@Named("purchaseRequisitionEntityWithRefs")
	public PurchaseRequisitionEntity purchaseRequisitionEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PurchaseRequisitionEntity with references");

		// % protected region % [Apply any additional logic for purchaseRequisitionEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntityWithRefs before the main body here] end

		PurchaseRequisitionEntity purchaseRequisitionEntity = injector.getInstance(Key.get(PurchaseRequisitionEntity.class, Names.named("purchaseRequisitionEntityWithNoRef")));

		// % protected region % [Apply any additional logic for purchaseRequisitionEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntityWithRefs after the main body here] end

		log.trace("Created entity of type PurchaseRequisitionEntity with references");

		return purchaseRequisitionEntity;
	}

	/**
	 * Return a collection of Purchase Requisition entities with all references set.
	 */
	@Provides
	@Named("purchaseRequisitionEntitiesWithRefs")
	public Collection<PurchaseRequisitionEntity> purchaseRequisitionEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionEntitiesWithRefs here] end
		PurchaseRequisitionEntityFactory purchaseRequisitionEntityFactory
	) {
		log.trace("Creating entities of type PurchaseRequisitionEntity with references");

		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithRefs before the main body here] end

		Collection<PurchaseRequisitionEntity> newEntities = purchaseRequisitionEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PurchaseRequisitionEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
