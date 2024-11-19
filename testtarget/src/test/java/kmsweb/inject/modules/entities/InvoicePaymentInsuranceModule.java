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
 * Guice module for Invoice Payment Insurance used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoicePaymentInsuranceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoicePaymentInsuranceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoicePaymentInsuranceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoicePaymentInsuranceEntityFactory invoicePaymentInsuranceEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoicePaymentInsuranceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoicePaymentInsuranceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoicePaymentInsuranceEntityFactory");

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityFactory before the main body here] end

		InvoicePaymentInsuranceEntityFactory entityFactory = new InvoicePaymentInsuranceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoicePaymentInsuranceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoicePaymentInsuranceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityFactory after the main body here] end

		log.trace("Created InvoicePaymentInsuranceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice Payment Insurance entity with no references set.
	 */
	@Provides
	@Named("invoicePaymentInsuranceEntityWithNoRef")
	public InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoicePaymentInsuranceEntity with no reference");

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef before the main body here] end

		InvoicePaymentInsuranceEntity newEntity = new InvoicePaymentInsuranceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Member No here] off begin
		String randomStringforMemberNo = mock
				.strings()
				.get();
		newEntity.setMemberNo(randomStringforMemberNo);
		// % protected region % [Add customisation for Member No here] end
		// % protected region % [Add customisation for Policy Holder No here] off begin
		String randomStringforPolicyHolderNo = mock
				.strings()
				.get();
		newEntity.setPolicyHolderNo(randomStringforPolicyHolderNo);
		// % protected region % [Add customisation for Policy Holder No here] end
		// % protected region % [Add customisation for Eligility Verification here] off begin
		String randomStringforEligilityVerification = mock
				.strings()
				.get();
		newEntity.setEligilityVerification(randomStringforEligilityVerification);
		// % protected region % [Add customisation for Eligility Verification here] end
		// % protected region % [Add customisation for Verification Date here] off begin
		newEntity.setVerificationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verification Date here] end
		// % protected region % [Add customisation for Guarantee Letter No here] off begin
		String randomStringforGuaranteeLetterNo = mock
				.strings()
				.get();
		newEntity.setGuaranteeLetterNo(randomStringforGuaranteeLetterNo);
		// % protected region % [Add customisation for Guarantee Letter No here] end
		// % protected region % [Add customisation for Coverage Balance here] off begin
		newEntity.setCoverageBalance(mock.doubles().get());
		// % protected region % [Add customisation for Coverage Balance here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Main Insurance here] off begin
		newEntity.setMainInsurance(mock.bools().get());
		// % protected region % [Add customisation for Main Insurance here] end

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceWithNoRef after the main body here] end

		log.trace("Created entity of type InvoicePaymentInsuranceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice Payment Insurance entities with no reference at all.
	 */
	@Provides
	@Named("invoicePaymentInsuranceEntitiesWithNoRef")
	public Collection<InvoicePaymentInsuranceEntity> invoicePaymentInsuranceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntitiesWithNoRef here] end
		InvoicePaymentInsuranceEntityFactory invoicePaymentInsuranceEntityFactory
	) {
		log.trace("Creating entities of type InvoicePaymentInsuranceEntity with no reference");

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithNoRef before the main body here] end

		Collection<InvoicePaymentInsuranceEntity> newEntities = invoicePaymentInsuranceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoicePaymentInsuranceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice Payment Insurance entity with all references set.
	 */
	@Provides
	@Named("invoicePaymentInsuranceEntityWithRefs")
	public InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InvoicePaymentInsuranceEntity with references");

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityWithRefs before the main body here] end

		InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity = injector.getInstance(Key.get(InvoicePaymentInsuranceEntity.class, Names.named("invoicePaymentInsuranceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoicePaymentInsuranceEntity with references");

		return invoicePaymentInsuranceEntity;
	}

	/**
	 * Return a collection of Invoice Payment Insurance entities with all references set.
	 */
	@Provides
	@Named("invoicePaymentInsuranceEntitiesWithRefs")
	public Collection<InvoicePaymentInsuranceEntity> invoicePaymentInsuranceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoicePaymentInsuranceEntitiesWithRefs here] end
		InvoicePaymentInsuranceEntityFactory invoicePaymentInsuranceEntityFactory
	) {
		log.trace("Creating entities of type InvoicePaymentInsuranceEntity with references");

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithRefs before the main body here] end

		Collection<InvoicePaymentInsuranceEntity> newEntities = invoicePaymentInsuranceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentInsuranceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoicePaymentInsuranceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
