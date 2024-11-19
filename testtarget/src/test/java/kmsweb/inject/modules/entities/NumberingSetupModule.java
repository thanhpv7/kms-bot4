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
 * Guice module for Numbering Setup used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NumberingSetupModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NumberingSetupModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NumberingSetupModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NumberingSetupEntityFactory numberingSetupEntityFactory(
			// % protected region % [Apply any additional injected arguments for numberingSetupEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for numberingSetupEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NumberingSetupEntityFactory");

		// % protected region % [Apply any additional logic for numberingSetupEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntityFactory before the main body here] end

		NumberingSetupEntityFactory entityFactory = new NumberingSetupEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NumberingSetupEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NumberingSetupEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for numberingSetupEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntityFactory after the main body here] end

		log.trace("Created NumberingSetupEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Numbering Setup entity with no references set.
	 */
	@Provides
	@Named("numberingSetupEntityWithNoRef")
	public NumberingSetupEntity numberingSetupEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for numberingSetupEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for numberingSetupEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NumberingSetupEntity with no reference");

		// % protected region % [Apply any additional logic for numberingSetupWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupWithNoRef before the main body here] end

		NumberingSetupEntity newEntity = new NumberingSetupEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Numbering Type here] off begin
		newEntity.setNumberingType(NumberingTypeEnum.PRESCRIPTION_NON_COMPOUND);
		// % protected region % [Add customisation for Numbering Type here] end
		// % protected region % [Add customisation for Prefix here] off begin
		String randomStringforPrefix = mock
				.strings()
				.get();
		newEntity.setPrefix(randomStringforPrefix);
		// % protected region % [Add customisation for Prefix here] end
		// % protected region % [Add customisation for Date Format here] off begin
		newEntity.setDateFormat(DateFormatEnum.YYYYMMDD);
		// % protected region % [Add customisation for Date Format here] end
		// % protected region % [Add customisation for Sufix here] off begin
		String randomStringforSufix = mock
				.strings()
				.get();
		newEntity.setSufix(randomStringforSufix);
		// % protected region % [Add customisation for Sufix here] end
		// % protected region % [Add customisation for Last Counter here] off begin
		newEntity.setLastCounter(mock.ints().get());
		// % protected region % [Add customisation for Last Counter here] end
		// % protected region % [Add customisation for Editable here] off begin
		newEntity.setEditable(mock.bools().get());
		// % protected region % [Add customisation for Editable here] end
		// % protected region % [Add customisation for Reset per Day here] off begin
		newEntity.setResetPerDay(mock.bools().get());
		// % protected region % [Add customisation for Reset per Day here] end
		// % protected region % [Add customisation for Counter Length here] off begin
		newEntity.setCounterLength(mock.ints().get());
		// % protected region % [Add customisation for Counter Length here] end
		// % protected region % [Add customisation for Last Updated here] off begin
		newEntity.setLastUpdated(OffsetDateTime.now());
		// % protected region % [Add customisation for Last Updated here] end
		// % protected region % [Add customisation for Preview here] off begin
		String randomStringforPreview = mock
				.strings()
				.get();
		newEntity.setPreview(randomStringforPreview);
		// % protected region % [Add customisation for Preview here] end

		// % protected region % [Apply any additional logic for numberingSetupWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupWithNoRef after the main body here] end

		log.trace("Created entity of type NumberingSetupEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Numbering Setup entities with no reference at all.
	 */
	@Provides
	@Named("numberingSetupEntitiesWithNoRef")
	public Collection<NumberingSetupEntity> numberingSetupEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for numberingSetupEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for numberingSetupEntitiesWithNoRef here] end
		NumberingSetupEntityFactory numberingSetupEntityFactory
	) {
		log.trace("Creating entities of type NumberingSetupEntity with no reference");

		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithNoRef before the main body here] end

		Collection<NumberingSetupEntity> newEntities = numberingSetupEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NumberingSetupEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Numbering Setup entity with all references set.
	 */
	@Provides
	@Named("numberingSetupEntityWithRefs")
	public NumberingSetupEntity numberingSetupEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for numberingSetupEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for numberingSetupEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NumberingSetupEntity with references");

		// % protected region % [Apply any additional logic for numberingSetupEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntityWithRefs before the main body here] end

		NumberingSetupEntity numberingSetupEntity = injector.getInstance(Key.get(NumberingSetupEntity.class, Names.named("numberingSetupEntityWithNoRef")));

		// % protected region % [Apply any additional logic for numberingSetupEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntityWithRefs after the main body here] end

		log.trace("Created entity of type NumberingSetupEntity with references");

		return numberingSetupEntity;
	}

	/**
	 * Return a collection of Numbering Setup entities with all references set.
	 */
	@Provides
	@Named("numberingSetupEntitiesWithRefs")
	public Collection<NumberingSetupEntity> numberingSetupEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for numberingSetupEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for numberingSetupEntitiesWithRefs here] end
		NumberingSetupEntityFactory numberingSetupEntityFactory
	) {
		log.trace("Creating entities of type NumberingSetupEntity with references");

		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithRefs before the main body here] end

		Collection<NumberingSetupEntity> newEntities = numberingSetupEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for numberingSetupEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NumberingSetupEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
