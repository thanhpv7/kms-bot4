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
 * Guice module for Patient Payment BPJS used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientPaymentBPJSModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientPaymentBPJSModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientPaymentBPJSModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientPaymentBPJSEntityFactory patientPaymentBPJSEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientPaymentBPJSEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientPaymentBPJSEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientPaymentBPJSEntityFactory");

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityFactory before the main body here] end

		PatientPaymentBPJSEntityFactory entityFactory = new PatientPaymentBPJSEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientPaymentBPJSEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientPaymentBPJSEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityFactory after the main body here] end

		log.trace("Created PatientPaymentBPJSEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Payment BPJS entity with no references set.
	 */
	@Provides
	@Named("patientPaymentBPJSEntityWithNoRef")
	public PatientPaymentBPJSEntity patientPaymentBPJSEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientPaymentBPJSEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef before the main body here] end

		PatientPaymentBPJSEntity newEntity = new PatientPaymentBPJSEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSWithNoRef after the main body here] end

		log.trace("Created entity of type PatientPaymentBPJSEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Payment BPJS entities with no reference at all.
	 */
	@Provides
	@Named("patientPaymentBPJSEntitiesWithNoRef")
	public Collection<PatientPaymentBPJSEntity> patientPaymentBPJSEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntitiesWithNoRef here] end
		PatientPaymentBPJSEntityFactory patientPaymentBPJSEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentBPJSEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithNoRef before the main body here] end

		Collection<PatientPaymentBPJSEntity> newEntities = patientPaymentBPJSEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientPaymentBPJSEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Payment BPJS entity with all references set.
	 */
	@Provides
	@Named("patientPaymentBPJSEntityWithRefs")
	public PatientPaymentBPJSEntity patientPaymentBPJSEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientPaymentBPJSEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityWithRefs before the main body here] end

		PatientPaymentBPJSEntity patientPaymentBPJSEntity = injector.getInstance(Key.get(PatientPaymentBPJSEntity.class, Names.named("patientPaymentBPJSEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientPaymentBPJSEntity with references");

		return patientPaymentBPJSEntity;
	}

	/**
	 * Return a collection of Patient Payment BPJS entities with all references set.
	 */
	@Provides
	@Named("patientPaymentBPJSEntitiesWithRefs")
	public Collection<PatientPaymentBPJSEntity> patientPaymentBPJSEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentBPJSEntitiesWithRefs here] end
		PatientPaymentBPJSEntityFactory patientPaymentBPJSEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentBPJSEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithRefs before the main body here] end

		Collection<PatientPaymentBPJSEntity> newEntities = patientPaymentBPJSEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentBPJSEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientPaymentBPJSEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
