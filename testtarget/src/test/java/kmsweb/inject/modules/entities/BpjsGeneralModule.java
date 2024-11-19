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
 * Guice module for BPJS General used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsGeneralModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsGeneralModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsGeneralModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsGeneralEntityFactory bpjsGeneralEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsGeneralEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsGeneralEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsGeneralEntityFactory");

		// % protected region % [Apply any additional logic for bpjsGeneralEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntityFactory before the main body here] end

		BpjsGeneralEntityFactory entityFactory = new BpjsGeneralEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsGeneralEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsGeneralEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsGeneralEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntityFactory after the main body here] end

		log.trace("Created BpjsGeneralEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS General entity with no references set.
	 */
	@Provides
	@Named("bpjsGeneralEntityWithNoRef")
	public BpjsGeneralEntity bpjsGeneralEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsGeneralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef before the main body here] end

		BpjsGeneralEntity newEntity = new BpjsGeneralEntity();
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
		// % protected region % [Add customisation for BPJS Web Service URL here] off begin
		String randomStringforBpjsWebServiceURL = mock
				.strings()
				.get();
		newEntity.setBpjsWebServiceURL(randomStringforBpjsWebServiceURL);
		// % protected region % [Add customisation for BPJS Web Service URL here] end
		// % protected region % [Add customisation for Aplicare Web Service URL here] off begin
		String randomStringforAplicareWebServiceURL = mock
				.strings()
				.get();
		newEntity.setAplicareWebServiceURL(randomStringforAplicareWebServiceURL);
		// % protected region % [Add customisation for Aplicare Web Service URL here] end
		// % protected region % [Add customisation for Health Facility Code here] off begin
		String randomStringforHealthFacilityCode = mock
				.strings()
				.size(25)
				.get();
		newEntity.setHealthFacilityCode(randomStringforHealthFacilityCode);
		// % protected region % [Add customisation for Health Facility Code here] end
		// % protected region % [Add customisation for Health Facility Name here] off begin
		String randomStringforHealthFacilityName = mock
				.strings()
				.size(100)
				.get();
		newEntity.setHealthFacilityName(randomStringforHealthFacilityName);
		// % protected region % [Add customisation for Health Facility Name here] end
		// % protected region % [Add customisation for MJKN WS BPJS URL here] off begin
		String randomStringforMjknWSBPJSURL = mock
				.strings()
				.get();
		newEntity.setMjknWSBPJSURL(randomStringforMjknWSBPJSURL);
		// % protected region % [Add customisation for MJKN WS BPJS URL here] end
		// % protected region % [Add customisation for MJKN WS BPJS User Key here] off begin
		String randomStringforMjknWSBPJSUserKey = mock
				.strings()
				.get();
		newEntity.setMjknWSBPJSUserKey(randomStringforMjknWSBPJSUserKey);
		// % protected region % [Add customisation for MJKN WS BPJS User Key here] end
		// % protected region % [Add customisation for Vclaim User Key here] off begin
		String randomStringforVclaimUserKey = mock
				.strings()
				.get();
		newEntity.setVclaimUserKey(randomStringforVclaimUserKey);
		// % protected region % [Add customisation for Vclaim User Key here] end
		// % protected region % [Add customisation for Connect To Other System here] off begin
		newEntity.setConnectToOtherSystem(mock.bools().get());
		// % protected region % [Add customisation for Connect To Other System here] end
		// % protected region % [Add customisation for IsMobileJKN here] off begin
		newEntity.setIsmobilejkn(mock.bools().get());
		// % protected region % [Add customisation for IsMobileJKN here] end
		// % protected region % [Add customisation for External System URL here] off begin
		String randomStringforExternalSystemURL = mock
				.strings()
				.get();
		newEntity.setExternalSystemURL(randomStringforExternalSystemURL);
		// % protected region % [Add customisation for External System URL here] end
		// % protected region % [Add customisation for Basic Auth here] off begin
		newEntity.setBasicAuth(mock.bools().get());
		// % protected region % [Add customisation for Basic Auth here] end
		// % protected region % [Add customisation for Basic Auth Username here] off begin
		String randomStringforBasicAuthUsername = mock
				.strings()
				.get();
		newEntity.setBasicAuthUsername(randomStringforBasicAuthUsername);
		// % protected region % [Add customisation for Basic Auth Username here] end
		// % protected region % [Add customisation for Basic Auth Password here] off begin
		String randomStringforBasicAuthPassword = mock
				.strings()
				.get();
		newEntity.setBasicAuthPassword(randomStringforBasicAuthPassword);
		// % protected region % [Add customisation for Basic Auth Password here] end
		// % protected region % [Add customisation for Bypass SSL Validation here] off begin
		newEntity.setBypassSSLValidation(mock.bools().get());
		// % protected region % [Add customisation for Bypass SSL Validation here] end
		// % protected region % [Add customisation for Claim Status here] off begin
		newEntity.setClaimStatus(mock.bools().get());
		// % protected region % [Add customisation for Claim Status here] end
		// % protected region % [Add customisation for Facility Type here] off begin
		String randomStringforFacilityType = mock
				.strings()
				.get();
		newEntity.setFacilityType(randomStringforFacilityType);
		// % protected region % [Add customisation for Facility Type here] end
		// % protected region % [Add customisation for Send Non JKN here] off begin
		newEntity.setSendNonJKN(mock.bools().get());
		// % protected region % [Add customisation for Send Non JKN here] end
		// % protected region % [Add customisation for Vclaim Integration here] off begin
		newEntity.setVclaimIntegration(mock.bools().get());
		// % protected region % [Add customisation for Vclaim Integration here] end
		// % protected region % [Add customisation for External Vclaim Service URL here] off begin
		String randomStringforExternalVclaimServiceURL = mock
				.strings()
				.get();
		newEntity.setExternalVclaimServiceURL(randomStringforExternalVclaimServiceURL);
		// % protected region % [Add customisation for External Vclaim Service URL here] end

		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsGeneralEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS General entities with no reference at all.
	 */
	@Provides
	@Named("bpjsGeneralEntitiesWithNoRef")
	public Collection<BpjsGeneralEntity> bpjsGeneralEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntitiesWithNoRef here] end
		BpjsGeneralEntityFactory bpjsGeneralEntityFactory
	) {
		log.trace("Creating entities of type BpjsGeneralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithNoRef before the main body here] end

		Collection<BpjsGeneralEntity> newEntities = bpjsGeneralEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsGeneralEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS General entity with all references set.
	 */
	@Provides
	@Named("bpjsGeneralEntityWithRefs")
	public BpjsGeneralEntity bpjsGeneralEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsGeneralEntity with references");

		// % protected region % [Apply any additional logic for bpjsGeneralEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntityWithRefs before the main body here] end

		BpjsGeneralEntity bpjsGeneralEntity = injector.getInstance(Key.get(BpjsGeneralEntity.class, Names.named("bpjsGeneralEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsGeneralEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsGeneralEntity with references");

		return bpjsGeneralEntity;
	}

	/**
	 * Return a collection of BPJS General entities with all references set.
	 */
	@Provides
	@Named("bpjsGeneralEntitiesWithRefs")
	public Collection<BpjsGeneralEntity> bpjsGeneralEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsGeneralEntitiesWithRefs here] end
		BpjsGeneralEntityFactory bpjsGeneralEntityFactory
	) {
		log.trace("Creating entities of type BpjsGeneralEntity with references");

		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithRefs before the main body here] end

		Collection<BpjsGeneralEntity> newEntities = bpjsGeneralEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsGeneralEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsGeneralEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
