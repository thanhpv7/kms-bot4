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
 * Guice module for PCare Umum used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareUmumModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareUmumModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareUmumModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareUmumEntityFactory pcareUmumEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareUmumEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareUmumEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareUmumEntityFactory");

		// % protected region % [Apply any additional logic for pcareUmumEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntityFactory before the main body here] end

		PcareUmumEntityFactory entityFactory = new PcareUmumEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareUmumEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareUmumEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareUmumEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntityFactory after the main body here] end

		log.trace("Created PcareUmumEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Umum entity with no references set.
	 */
	@Provides
	@Named("pcareUmumEntityWithNoRef")
	public PcareUmumEntity pcareUmumEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareUmumEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareUmumEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareUmumEntity with no reference");

		// % protected region % [Apply any additional logic for pcareUmumWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumWithNoRef before the main body here] end

		PcareUmumEntity newEntity = new PcareUmumEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Cons ID here] off begin
		String randomStringforConsID = mock
				.strings()
				.size(15)
				.get();
		newEntity.setConsID(randomStringforConsID);
		// % protected region % [Add customisation for Cons ID here] end
		// % protected region % [Add customisation for Secret Key here] off begin
		String randomStringforSecretKey = mock
				.strings()
				.size(25)
				.get();
		newEntity.setSecretKey(randomStringforSecretKey);
		// % protected region % [Add customisation for Secret Key here] end
		// % protected region % [Add customisation for Web Service URL here] off begin
		String randomStringforWebServiceURL = mock
				.strings()
				.get();
		newEntity.setWebServiceURL(randomStringforWebServiceURL);
		// % protected region % [Add customisation for Web Service URL here] end
		// % protected region % [Add customisation for Auth Username here] off begin
		String randomStringforAuthUsername = mock
				.strings()
				.get();
		newEntity.setAuthUsername(randomStringforAuthUsername);
		// % protected region % [Add customisation for Auth Username here] end
		// % protected region % [Add customisation for Auth Password here] off begin
		String randomStringforAuthPassword = mock
				.strings()
				.get();
		newEntity.setAuthPassword(randomStringforAuthPassword);
		// % protected region % [Add customisation for Auth Password here] end
		// % protected region % [Add customisation for Kode Aplikasi here] off begin
		String randomStringforKodeAplikasi = mock
				.strings()
				.get();
		newEntity.setKodeAplikasi(randomStringforKodeAplikasi);
		// % protected region % [Add customisation for Kode Aplikasi here] end
		// % protected region % [Add customisation for User Key here] off begin
		String randomStringforUserKey = mock
				.strings()
				.get();
		newEntity.setUserKey(randomStringforUserKey);
		// % protected region % [Add customisation for User Key here] end
		// % protected region % [Add customisation for Regional Division here] off begin
		String randomStringforRegionalDivision = mock
				.strings()
				.get();
		newEntity.setRegionalDivision(randomStringforRegionalDivision);
		// % protected region % [Add customisation for Regional Division here] end
		// % protected region % [Add customisation for Branch Office here] off begin
		String randomStringforBranchOffice = mock
				.strings()
				.get();
		newEntity.setBranchOffice(randomStringforBranchOffice);
		// % protected region % [Add customisation for Branch Office here] end

		// % protected region % [Apply any additional logic for pcareUmumWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumWithNoRef after the main body here] end

		log.trace("Created entity of type PcareUmumEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Umum entities with no reference at all.
	 */
	@Provides
	@Named("pcareUmumEntitiesWithNoRef")
	public Collection<PcareUmumEntity> pcareUmumEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareUmumEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareUmumEntitiesWithNoRef here] end
		PcareUmumEntityFactory pcareUmumEntityFactory
	) {
		log.trace("Creating entities of type PcareUmumEntity with no reference");

		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithNoRef before the main body here] end

		Collection<PcareUmumEntity> newEntities = pcareUmumEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareUmumEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Umum entity with all references set.
	 */
	@Provides
	@Named("pcareUmumEntityWithRefs")
	public PcareUmumEntity pcareUmumEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareUmumEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareUmumEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareUmumEntity with references");

		// % protected region % [Apply any additional logic for pcareUmumEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntityWithRefs before the main body here] end

		PcareUmumEntity pcareUmumEntity = injector.getInstance(Key.get(PcareUmumEntity.class, Names.named("pcareUmumEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareUmumEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareUmumEntity with references");

		return pcareUmumEntity;
	}

	/**
	 * Return a collection of PCare Umum entities with all references set.
	 */
	@Provides
	@Named("pcareUmumEntitiesWithRefs")
	public Collection<PcareUmumEntity> pcareUmumEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareUmumEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareUmumEntitiesWithRefs here] end
		PcareUmumEntityFactory pcareUmumEntityFactory
	) {
		log.trace("Creating entities of type PcareUmumEntity with references");

		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithRefs before the main body here] end

		Collection<PcareUmumEntity> newEntities = pcareUmumEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareUmumEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareUmumEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
