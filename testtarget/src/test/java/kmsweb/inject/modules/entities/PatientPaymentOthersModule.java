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
 * Guice module for Patient Payment Others used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientPaymentOthersModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientPaymentOthersModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientPaymentOthersModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientPaymentOthersEntityFactory patientPaymentOthersEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientPaymentOthersEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientPaymentOthersEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientPaymentOthersEntityFactory");

		// % protected region % [Apply any additional logic for patientPaymentOthersEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntityFactory before the main body here] end

		PatientPaymentOthersEntityFactory entityFactory = new PatientPaymentOthersEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientPaymentOthersEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientPaymentOthersEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientPaymentOthersEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntityFactory after the main body here] end

		log.trace("Created PatientPaymentOthersEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Payment Others entity with no references set.
	 */
	@Provides
	@Named("patientPaymentOthersEntityWithNoRef")
	public PatientPaymentOthersEntity patientPaymentOthersEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientPaymentOthersEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentOthersWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersWithNoRef before the main body here] end

		PatientPaymentOthersEntity newEntity = new PatientPaymentOthersEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientPaymentOthersWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersWithNoRef after the main body here] end

		log.trace("Created entity of type PatientPaymentOthersEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Payment Others entities with no reference at all.
	 */
	@Provides
	@Named("patientPaymentOthersEntitiesWithNoRef")
	public Collection<PatientPaymentOthersEntity> patientPaymentOthersEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntitiesWithNoRef here] end
		PatientPaymentOthersEntityFactory patientPaymentOthersEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentOthersEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithNoRef before the main body here] end

		Collection<PatientPaymentOthersEntity> newEntities = patientPaymentOthersEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientPaymentOthersEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Payment Others entity with all references set.
	 */
	@Provides
	@Named("patientPaymentOthersEntityWithRefs")
	public PatientPaymentOthersEntity patientPaymentOthersEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientPaymentOthersEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentOthersEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntityWithRefs before the main body here] end

		PatientPaymentOthersEntity patientPaymentOthersEntity = injector.getInstance(Key.get(PatientPaymentOthersEntity.class, Names.named("patientPaymentOthersEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientPaymentOthersEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientPaymentOthersEntity with references");

		return patientPaymentOthersEntity;
	}

	/**
	 * Return a collection of Patient Payment Others entities with all references set.
	 */
	@Provides
	@Named("patientPaymentOthersEntitiesWithRefs")
	public Collection<PatientPaymentOthersEntity> patientPaymentOthersEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentOthersEntitiesWithRefs here] end
		PatientPaymentOthersEntityFactory patientPaymentOthersEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentOthersEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithRefs before the main body here] end

		Collection<PatientPaymentOthersEntity> newEntities = patientPaymentOthersEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentOthersEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientPaymentOthersEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
