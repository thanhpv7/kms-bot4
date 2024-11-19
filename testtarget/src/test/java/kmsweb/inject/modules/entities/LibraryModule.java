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
 * Guice module for Library used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class LibraryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring LibraryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured LibraryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public LibraryEntityFactory libraryEntityFactory(
			// % protected region % [Apply any additional injected arguments for libraryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for libraryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating LibraryEntityFactory");

		// % protected region % [Apply any additional logic for libraryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntityFactory before the main body here] end

		LibraryEntityFactory entityFactory = new LibraryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for LibraryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for LibraryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for libraryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntityFactory after the main body here] end

		log.trace("Created LibraryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Library entity with no references set.
	 */
	@Provides
	@Named("libraryEntityWithNoRef")
	public LibraryEntity libraryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for libraryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for libraryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type LibraryEntity with no reference");

		// % protected region % [Apply any additional logic for libraryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for libraryWithNoRef before the main body here] end

		LibraryEntity newEntity = new LibraryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Library Document here] off begin
		// % protected region % [Add customisation for Library Document here] end
		// % protected region % [Add customisation for Library Item Code here] off begin
		String randomStringforLibraryItemCode = mock
				.strings()
				.get();
		newEntity.setLibraryItemCode(randomStringforLibraryItemCode);
		// % protected region % [Add customisation for Library Item Code here] end
		// % protected region % [Add customisation for Library Item Description here] off begin
		String randomStringforLibraryItemDescription = mock
				.strings()
				.get();
		newEntity.setLibraryItemDescription(randomStringforLibraryItemDescription);
		// % protected region % [Add customisation for Library Item Description here] end
		// % protected region % [Add customisation for Classification here] off begin
		String randomStringforClassification = mock
				.strings()
				.get();
		newEntity.setClassification(randomStringforClassification);
		// % protected region % [Add customisation for Classification here] end
		// % protected region % [Add customisation for Author here] off begin
		String randomStringforAuthor = mock
				.strings()
				.get();
		newEntity.setAuthor(randomStringforAuthor);
		// % protected region % [Add customisation for Author here] end
		// % protected region % [Add customisation for Publisher here] off begin
		String randomStringforPublisher = mock
				.strings()
				.get();
		newEntity.setPublisher(randomStringforPublisher);
		// % protected region % [Add customisation for Publisher here] end

		// % protected region % [Apply any additional logic for libraryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for libraryWithNoRef after the main body here] end

		log.trace("Created entity of type LibraryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Library entities with no reference at all.
	 */
	@Provides
	@Named("libraryEntitiesWithNoRef")
	public Collection<LibraryEntity> libraryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for libraryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for libraryEntitiesWithNoRef here] end
		LibraryEntityFactory libraryEntityFactory
	) {
		log.trace("Creating entities of type LibraryEntity with no reference");

		// % protected region % [Apply any additional logic for libraryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntitiesWithNoRef before the main body here] end

		Collection<LibraryEntity> newEntities = libraryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for libraryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type LibraryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Library entity with all references set.
	 */
	@Provides
	@Named("libraryEntityWithRefs")
	public LibraryEntity libraryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for libraryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for libraryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type LibraryEntity with references");

		// % protected region % [Apply any additional logic for libraryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntityWithRefs before the main body here] end

		LibraryEntity libraryEntity = injector.getInstance(Key.get(LibraryEntity.class, Names.named("libraryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for libraryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntityWithRefs after the main body here] end

		log.trace("Created entity of type LibraryEntity with references");

		return libraryEntity;
	}

	/**
	 * Return a collection of Library entities with all references set.
	 */
	@Provides
	@Named("libraryEntitiesWithRefs")
	public Collection<LibraryEntity> libraryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for libraryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for libraryEntitiesWithRefs here] end
		LibraryEntityFactory libraryEntityFactory
	) {
		log.trace("Creating entities of type LibraryEntity with references");

		// % protected region % [Apply any additional logic for libraryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntitiesWithRefs before the main body here] end

		Collection<LibraryEntity> newEntities = libraryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for libraryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for libraryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type LibraryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
