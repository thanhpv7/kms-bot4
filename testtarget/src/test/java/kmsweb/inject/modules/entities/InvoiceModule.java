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
 * Guice module for Invoice used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoiceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoiceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoiceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoiceEntityFactory invoiceEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoiceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoiceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoiceEntityFactory");

		// % protected region % [Apply any additional logic for invoiceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntityFactory before the main body here] end

		InvoiceEntityFactory entityFactory = new InvoiceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoiceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoiceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoiceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntityFactory after the main body here] end

		log.trace("Created InvoiceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice entity with no references set.
	 */
	@Provides
	@Named("invoiceEntityWithNoRef")
	public InvoiceEntity invoiceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoiceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoiceEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceWithNoRef before the main body here] end

		InvoiceEntity newEntity = new InvoiceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Number here] off begin
		String randomStringforInvoiceNumber = mock
				.strings()
				.get();
		newEntity.setInvoiceNumber(randomStringforInvoiceNumber);
		// % protected region % [Add customisation for Invoice Number here] end
		// % protected region % [Add customisation for Revision Number here] off begin
		newEntity.setRevisionNumber(mock.ints().get());
		// % protected region % [Add customisation for Revision Number here] end
		// % protected region % [Add customisation for Invoice Status here] off begin
		String randomStringforInvoiceStatus = mock
				.strings()
				.get();
		newEntity.setInvoiceStatus(randomStringforInvoiceStatus);
		// % protected region % [Add customisation for Invoice Status here] end
		// % protected region % [Add customisation for Invoice Type here] off begin
		newEntity.setInvoiceType(InvoiceTypeEnum.OUTPATIENT);
		// % protected region % [Add customisation for Invoice Type here] end
		// % protected region % [Add customisation for Invoice Date here] off begin
		newEntity.setInvoiceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Date here] end
		// % protected region % [Add customisation for Cancel Date here] off begin
		newEntity.setCancelDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Cancel Date here] end
		// % protected region % [Add customisation for Billing Location here] off begin
		String randomStringforBillingLocation = mock
				.strings()
				.size(20)
				.get();
		newEntity.setBillingLocation(randomStringforBillingLocation);
		// % protected region % [Add customisation for Billing Location here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.size(500)
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringforPatientPaymentType = mock
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringforPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Verification Date here] off begin
		newEntity.setVerificationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verification Date here] end
		// % protected region % [Add customisation for Display Doctor on Print here] off begin
		newEntity.setDisplayDoctorOnPrint(mock.bools().get());
		// % protected region % [Add customisation for Display Doctor on Print here] end
		// % protected region % [Add customisation for Display ICD 10 on Print here] off begin
		newEntity.setDisplayICD10OnPrint(mock.bools().get());
		// % protected region % [Add customisation for Display ICD 10 on Print here] end
		// % protected region % [Add customisation for Display ICD 9 CM on Print here] off begin
		newEntity.setDisplayICD9CMOnPrint(mock.bools().get());
		// % protected region % [Add customisation for Display ICD 9 CM on Print here] end
		// % protected region % [Add customisation for Doctor Code here] off begin
		String randomStringforDoctorCode = mock
				.strings()
				.get();
		newEntity.setDoctorCode(randomStringforDoctorCode);
		// % protected region % [Add customisation for Doctor Code here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Admission Date here] off begin
		newEntity.setAdmissionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date here] end
		// % protected region % [Add customisation for Discharged Date here] off begin
		newEntity.setDischargedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Discharged Date here] end
		// % protected region % [Add customisation for Claim No here] off begin
		String randomStringforClaimNo = mock
				.strings()
				.get();
		newEntity.setClaimNo(randomStringforClaimNo);
		// % protected region % [Add customisation for Claim No here] end

		// % protected region % [Apply any additional logic for invoiceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceWithNoRef after the main body here] end

		log.trace("Created entity of type InvoiceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice entities with no reference at all.
	 */
	@Provides
	@Named("invoiceEntitiesWithNoRef")
	public Collection<InvoiceEntity> invoiceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoiceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceEntitiesWithNoRef here] end
		InvoiceEntityFactory invoiceEntityFactory
	) {
		log.trace("Creating entities of type InvoiceEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntitiesWithNoRef before the main body here] end

		Collection<InvoiceEntity> newEntities = invoiceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoiceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoiceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice entity with all references set.
	 */
	@Provides
	@Named("invoiceEntityWithRefs")
	public InvoiceEntity invoiceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoiceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceEntityWithRefs here] end
			@Named("tariffSchemaEntityWithRefs") TariffSchemaEntity tariffSchema,
			Injector injector
	) {
		log.trace("Creating entity of type InvoiceEntity with references");

		// % protected region % [Apply any additional logic for invoiceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntityWithRefs before the main body here] end

		InvoiceEntity invoiceEntity = injector.getInstance(Key.get(InvoiceEntity.class, Names.named("invoiceEntityWithNoRef")));
		invoiceEntity.setTariffSchema(tariffSchema, true);

		// % protected region % [Apply any additional logic for invoiceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoiceEntity with references");

		return invoiceEntity;
	}

	/**
	 * Return a collection of Invoice entities with all references set.
	 */
	@Provides
	@Named("invoiceEntitiesWithRefs")
	public Collection<InvoiceEntity> invoiceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoiceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceEntitiesWithRefs here] end
		InvoiceEntityFactory invoiceEntityFactory
	) {
		log.trace("Creating entities of type InvoiceEntity with references");

		// % protected region % [Apply any additional logic for invoiceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntitiesWithRefs before the main body here] end

		Collection<InvoiceEntity> newEntities = invoiceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoiceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoiceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
