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
 * Guice module for Prescription Header used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PrescriptionHeaderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PrescriptionHeaderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PrescriptionHeaderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PrescriptionHeaderEntityFactory prescriptionHeaderEntityFactory(
			// % protected region % [Apply any additional injected arguments for prescriptionHeaderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for prescriptionHeaderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PrescriptionHeaderEntityFactory");

		// % protected region % [Apply any additional logic for prescriptionHeaderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntityFactory before the main body here] end

		PrescriptionHeaderEntityFactory entityFactory = new PrescriptionHeaderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PrescriptionHeaderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PrescriptionHeaderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for prescriptionHeaderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntityFactory after the main body here] end

		log.trace("Created PrescriptionHeaderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Prescription Header entity with no references set.
	 */
	@Provides
	@Named("prescriptionHeaderEntityWithNoRef")
	public PrescriptionHeaderEntity prescriptionHeaderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PrescriptionHeaderEntity with no reference");

		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef before the main body here] end

		PrescriptionHeaderEntity newEntity = new PrescriptionHeaderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Prescription Number here] off begin
		String randomStringforPrescriptionNumber = mock
				.strings()
				.get();
		newEntity.setPrescriptionNumber(randomStringforPrescriptionNumber);
		// % protected region % [Add customisation for Prescription Number here] end
		// % protected region % [Add customisation for Prescription Type here] off begin
		String randomStringforPrescriptionType = mock
				.strings()
				.get();
		newEntity.setPrescriptionType(randomStringforPrescriptionType);
		// % protected region % [Add customisation for Prescription Type here] end
		// % protected region % [Add customisation for Queue No here] off begin
		String randomStringforQueueNo = mock
				.strings()
				.get();
		newEntity.setQueueNo(randomStringforQueueNo);
		// % protected region % [Add customisation for Queue No here] end
		// % protected region % [Add customisation for Original Prescription Number here] off begin
		String randomStringforOriginalPrescriptionNumber = mock
				.strings()
				.get();
		newEntity.setOriginalPrescriptionNumber(randomStringforOriginalPrescriptionNumber);
		// % protected region % [Add customisation for Original Prescription Number here] end
		// % protected region % [Add customisation for Prescription Date here] off begin
		newEntity.setPrescriptionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Prescription Date here] end
		// % protected region % [Add customisation for Is Compound here] off begin
		newEntity.setIsCompound(mock.bools().get());
		// % protected region % [Add customisation for Is Compound here] end
		// % protected region % [Add customisation for Is Iteration here] off begin
		newEntity.setIsIteration(mock.bools().get());
		// % protected region % [Add customisation for Is Iteration here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Is Urgent here] off begin
		newEntity.setIsUrgent(mock.bools().get());
		// % protected region % [Add customisation for Is Urgent here] end
		// % protected region % [Add customisation for Restricted here] off begin
		newEntity.setRestricted(mock.bools().get());
		// % protected region % [Add customisation for Restricted here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Revision No here] off begin
		newEntity.setRevisionNo(mock.ints().get());
		// % protected region % [Add customisation for Revision No here] end
		// % protected region % [Add customisation for Copy No here] off begin
		newEntity.setCopyNo(mock.ints().get());
		// % protected region % [Add customisation for Copy No here] end
		// % protected region % [Add customisation for Is Invoiced here] off begin
		newEntity.setIsInvoiced(mock.bools().get());
		// % protected region % [Add customisation for Is Invoiced here] end
		// % protected region % [Add customisation for External Warehouse here] off begin
		newEntity.setExternalWarehouse(mock.bools().get());
		// % protected region % [Add customisation for External Warehouse here] end
		// % protected region % [Add customisation for Notes2 here] off begin
		String randomStringforNotes2 = mock
				.strings()
				.get();
		newEntity.setNotes2(randomStringforNotes2);
		// % protected region % [Add customisation for Notes2 here] end

		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderWithNoRef after the main body here] end

		log.trace("Created entity of type PrescriptionHeaderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Prescription Header entities with no reference at all.
	 */
	@Provides
	@Named("prescriptionHeaderEntitiesWithNoRef")
	public Collection<PrescriptionHeaderEntity> prescriptionHeaderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntitiesWithNoRef here] end
		PrescriptionHeaderEntityFactory prescriptionHeaderEntityFactory
	) {
		log.trace("Creating entities of type PrescriptionHeaderEntity with no reference");

		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithNoRef before the main body here] end

		Collection<PrescriptionHeaderEntity> newEntities = prescriptionHeaderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PrescriptionHeaderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Prescription Header entity with all references set.
	 */
	@Provides
	@Named("prescriptionHeaderEntityWithRefs")
	public PrescriptionHeaderEntity prescriptionHeaderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PrescriptionHeaderEntity with references");

		// % protected region % [Apply any additional logic for prescriptionHeaderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntityWithRefs before the main body here] end

		PrescriptionHeaderEntity prescriptionHeaderEntity = injector.getInstance(Key.get(PrescriptionHeaderEntity.class, Names.named("prescriptionHeaderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for prescriptionHeaderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntityWithRefs after the main body here] end

		log.trace("Created entity of type PrescriptionHeaderEntity with references");

		return prescriptionHeaderEntity;
	}

	/**
	 * Return a collection of Prescription Header entities with all references set.
	 */
	@Provides
	@Named("prescriptionHeaderEntitiesWithRefs")
	public Collection<PrescriptionHeaderEntity> prescriptionHeaderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for prescriptionHeaderEntitiesWithRefs here] end
		PrescriptionHeaderEntityFactory prescriptionHeaderEntityFactory
	) {
		log.trace("Creating entities of type PrescriptionHeaderEntity with references");

		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithRefs before the main body here] end

		Collection<PrescriptionHeaderEntity> newEntities = prescriptionHeaderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionHeaderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PrescriptionHeaderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
