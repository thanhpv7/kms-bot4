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
 * Guice module for BPJS INACBG Variable used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsINACBGVariableModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsINACBGVariableModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsINACBGVariableModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsINACBGVariableEntityFactory bpjsINACBGVariableEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsINACBGVariableEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsINACBGVariableEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsINACBGVariableEntityFactory");

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityFactory before the main body here] end

		BpjsINACBGVariableEntityFactory entityFactory = new BpjsINACBGVariableEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsINACBGVariableEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsINACBGVariableEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityFactory after the main body here] end

		log.trace("Created BpjsINACBGVariableEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS INACBG Variable entity with no references set.
	 */
	@Provides
	@Named("bpjsINACBGVariableEntityWithNoRef")
	public BpjsINACBGVariableEntity bpjsINACBGVariableEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsINACBGVariableEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsINACBGVariableWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableWithNoRef before the main body here] end

		BpjsINACBGVariableEntity newEntity = new BpjsINACBGVariableEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Variable Code here] off begin
		String randomStringforVariableCode = mock
				.strings()
				.get();
		newEntity.setVariableCode(randomStringforVariableCode);
		// % protected region % [Add customisation for Variable Code here] end
		// % protected region % [Add customisation for English here] off begin
		String randomStringforEnglish = mock
				.strings()
				.get();
		newEntity.setEnglish(randomStringforEnglish);
		// % protected region % [Add customisation for English here] end
		// % protected region % [Add customisation for Indonesian here] off begin
		String randomStringforIndonesian = mock
				.strings()
				.get();
		newEntity.setIndonesian(randomStringforIndonesian);
		// % protected region % [Add customisation for Indonesian here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for bpjsINACBGVariableWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsINACBGVariableEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS INACBG Variable entities with no reference at all.
	 */
	@Provides
	@Named("bpjsINACBGVariableEntitiesWithNoRef")
	public Collection<BpjsINACBGVariableEntity> bpjsINACBGVariableEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntitiesWithNoRef here] end
		BpjsINACBGVariableEntityFactory bpjsINACBGVariableEntityFactory
	) {
		log.trace("Creating entities of type BpjsINACBGVariableEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithNoRef before the main body here] end

		Collection<BpjsINACBGVariableEntity> newEntities = bpjsINACBGVariableEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsINACBGVariableEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS INACBG Variable entity with all references set.
	 */
	@Provides
	@Named("bpjsINACBGVariableEntityWithRefs")
	public BpjsINACBGVariableEntity bpjsINACBGVariableEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsINACBGVariableEntity with references");

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityWithRefs before the main body here] end

		BpjsINACBGVariableEntity bpjsINACBGVariableEntity = injector.getInstance(Key.get(BpjsINACBGVariableEntity.class, Names.named("bpjsINACBGVariableEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsINACBGVariableEntity with references");

		return bpjsINACBGVariableEntity;
	}

	/**
	 * Return a collection of BPJS INACBG Variable entities with all references set.
	 */
	@Provides
	@Named("bpjsINACBGVariableEntitiesWithRefs")
	public Collection<BpjsINACBGVariableEntity> bpjsINACBGVariableEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGVariableEntitiesWithRefs here] end
		BpjsINACBGVariableEntityFactory bpjsINACBGVariableEntityFactory
	) {
		log.trace("Creating entities of type BpjsINACBGVariableEntity with references");

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithRefs before the main body here] end

		Collection<BpjsINACBGVariableEntity> newEntities = bpjsINACBGVariableEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGVariableEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsINACBGVariableEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
