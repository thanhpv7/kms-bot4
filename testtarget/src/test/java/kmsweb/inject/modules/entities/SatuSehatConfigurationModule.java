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
 * Guice module for Satu Sehat Configuration used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SatuSehatConfigurationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SatuSehatConfigurationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SatuSehatConfigurationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SatuSehatConfigurationEntityFactory satuSehatConfigurationEntityFactory(
			// % protected region % [Apply any additional injected arguments for satuSehatConfigurationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for satuSehatConfigurationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SatuSehatConfigurationEntityFactory");

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityFactory before the main body here] end

		SatuSehatConfigurationEntityFactory entityFactory = new SatuSehatConfigurationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SatuSehatConfigurationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SatuSehatConfigurationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityFactory after the main body here] end

		log.trace("Created SatuSehatConfigurationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Satu Sehat Configuration entity with no references set.
	 */
	@Provides
	@Named("satuSehatConfigurationEntityWithNoRef")
	public SatuSehatConfigurationEntity satuSehatConfigurationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SatuSehatConfigurationEntity with no reference");

		// % protected region % [Apply any additional logic for satuSehatConfigurationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationWithNoRef before the main body here] end

		SatuSehatConfigurationEntity newEntity = new SatuSehatConfigurationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Organization ID here] off begin
		String randomStringforOrganizationID = mock
				.strings()
				.get();
		newEntity.setOrganizationID(randomStringforOrganizationID);
		// % protected region % [Add customisation for Organization ID here] end
		// % protected region % [Add customisation for Client ID here] off begin
		String randomStringforClientID = mock
				.strings()
				.size(1000)
				.get();
		newEntity.setClientID(randomStringforClientID);
		// % protected region % [Add customisation for Client ID here] end
		// % protected region % [Add customisation for Secret Key here] off begin
		String randomStringforSecretKey = mock
				.strings()
				.size(1000)
				.get();
		newEntity.setSecretKey(randomStringforSecretKey);
		// % protected region % [Add customisation for Secret Key here] end
		// % protected region % [Add customisation for Token Request here] off begin
		String randomStringforTokenRequest = mock
				.strings()
				.size(1000)
				.get();
		newEntity.setTokenRequest(randomStringforTokenRequest);
		// % protected region % [Add customisation for Token Request here] end
		// % protected region % [Add customisation for Base URL here] off begin
		String randomStringforBaseURL = mock
				.strings()
				.get();
		newEntity.setBaseURL(randomStringforBaseURL);
		// % protected region % [Add customisation for Base URL here] end

		// % protected region % [Apply any additional logic for satuSehatConfigurationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationWithNoRef after the main body here] end

		log.trace("Created entity of type SatuSehatConfigurationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Satu Sehat Configuration entities with no reference at all.
	 */
	@Provides
	@Named("satuSehatConfigurationEntitiesWithNoRef")
	public Collection<SatuSehatConfigurationEntity> satuSehatConfigurationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntitiesWithNoRef here] end
		SatuSehatConfigurationEntityFactory satuSehatConfigurationEntityFactory
	) {
		log.trace("Creating entities of type SatuSehatConfigurationEntity with no reference");

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithNoRef before the main body here] end

		Collection<SatuSehatConfigurationEntity> newEntities = satuSehatConfigurationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SatuSehatConfigurationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Satu Sehat Configuration entity with all references set.
	 */
	@Provides
	@Named("satuSehatConfigurationEntityWithRefs")
	public SatuSehatConfigurationEntity satuSehatConfigurationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SatuSehatConfigurationEntity with references");

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityWithRefs before the main body here] end

		SatuSehatConfigurationEntity satuSehatConfigurationEntity = injector.getInstance(Key.get(SatuSehatConfigurationEntity.class, Names.named("satuSehatConfigurationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntityWithRefs after the main body here] end

		log.trace("Created entity of type SatuSehatConfigurationEntity with references");

		return satuSehatConfigurationEntity;
	}

	/**
	 * Return a collection of Satu Sehat Configuration entities with all references set.
	 */
	@Provides
	@Named("satuSehatConfigurationEntitiesWithRefs")
	public Collection<SatuSehatConfigurationEntity> satuSehatConfigurationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for satuSehatConfigurationEntitiesWithRefs here] end
		SatuSehatConfigurationEntityFactory satuSehatConfigurationEntityFactory
	) {
		log.trace("Creating entities of type SatuSehatConfigurationEntity with references");

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithRefs before the main body here] end

		Collection<SatuSehatConfigurationEntity> newEntities = satuSehatConfigurationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for satuSehatConfigurationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SatuSehatConfigurationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
