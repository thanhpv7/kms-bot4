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
 * Guice module for Formulir Konseling Tes Hiv used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class FormulirKonselingTesHivModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring FormulirKonselingTesHivModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured FormulirKonselingTesHivModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public FormulirKonselingTesHivEntityFactory formulirKonselingTesHivEntityFactory(
			// % protected region % [Apply any additional injected arguments for formulirKonselingTesHivEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for formulirKonselingTesHivEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating FormulirKonselingTesHivEntityFactory");

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityFactory before the main body here] end

		FormulirKonselingTesHivEntityFactory entityFactory = new FormulirKonselingTesHivEntityFactory(
				// % protected region % [Apply any additional constructor arguments for FormulirKonselingTesHivEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for FormulirKonselingTesHivEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityFactory after the main body here] end

		log.trace("Created FormulirKonselingTesHivEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Formulir Konseling Tes Hiv entity with no references set.
	 */
	@Provides
	@Named("formulirKonselingTesHivEntityWithNoRef")
	public FormulirKonselingTesHivEntity formulirKonselingTesHivEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type FormulirKonselingTesHivEntity with no reference");

		// % protected region % [Apply any additional logic for formulirKonselingTesHivWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivWithNoRef before the main body here] end

		FormulirKonselingTesHivEntity newEntity = new FormulirKonselingTesHivEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Form Data here] off begin
		String randomStringforFormData = mock
				.strings()
				.get();
		newEntity.setFormData(randomStringforFormData);
		// % protected region % [Add customisation for Form Data here] end

		// % protected region % [Apply any additional logic for formulirKonselingTesHivWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivWithNoRef after the main body here] end

		log.trace("Created entity of type FormulirKonselingTesHivEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Formulir Konseling Tes Hiv entities with no reference at all.
	 */
	@Provides
	@Named("formulirKonselingTesHivEntitiesWithNoRef")
	public Collection<FormulirKonselingTesHivEntity> formulirKonselingTesHivEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntitiesWithNoRef here] end
		FormulirKonselingTesHivEntityFactory formulirKonselingTesHivEntityFactory
	) {
		log.trace("Creating entities of type FormulirKonselingTesHivEntity with no reference");

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithNoRef before the main body here] end

		Collection<FormulirKonselingTesHivEntity> newEntities = formulirKonselingTesHivEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type FormulirKonselingTesHivEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Formulir Konseling Tes Hiv entity with all references set.
	 */
	@Provides
	@Named("formulirKonselingTesHivEntityWithRefs")
	public FormulirKonselingTesHivEntity formulirKonselingTesHivEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type FormulirKonselingTesHivEntity with references");

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityWithRefs before the main body here] end

		FormulirKonselingTesHivEntity formulirKonselingTesHivEntity = injector.getInstance(Key.get(FormulirKonselingTesHivEntity.class, Names.named("formulirKonselingTesHivEntityWithNoRef")));

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntityWithRefs after the main body here] end

		log.trace("Created entity of type FormulirKonselingTesHivEntity with references");

		return formulirKonselingTesHivEntity;
	}

	/**
	 * Return a collection of Formulir Konseling Tes Hiv entities with all references set.
	 */
	@Provides
	@Named("formulirKonselingTesHivEntitiesWithRefs")
	public Collection<FormulirKonselingTesHivEntity> formulirKonselingTesHivEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for formulirKonselingTesHivEntitiesWithRefs here] end
		FormulirKonselingTesHivEntityFactory formulirKonselingTesHivEntityFactory
	) {
		log.trace("Creating entities of type FormulirKonselingTesHivEntity with references");

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithRefs before the main body here] end

		Collection<FormulirKonselingTesHivEntity> newEntities = formulirKonselingTesHivEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for formulirKonselingTesHivEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type FormulirKonselingTesHivEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
