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
 * Guice module for BPJS INACBG used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsINACBGModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsINACBGModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsINACBGModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsINACBGEntityFactory bpjsINACBGEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsINACBGEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsINACBGEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsINACBGEntityFactory");

		// % protected region % [Apply any additional logic for bpjsINACBGEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntityFactory before the main body here] end

		BpjsINACBGEntityFactory entityFactory = new BpjsINACBGEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsINACBGEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsINACBGEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsINACBGEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntityFactory after the main body here] end

		log.trace("Created BpjsINACBGEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS INACBG entity with no references set.
	 */
	@Provides
	@Named("bpjsINACBGEntityWithNoRef")
	public BpjsINACBGEntity bpjsINACBGEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsINACBGEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef before the main body here] end

		BpjsINACBGEntity newEntity = new BpjsINACBGEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for State Province here] off begin
		String randomStringforStateProvince = mock
				.strings()
				.size(50)
				.get();
		newEntity.setStateProvince(randomStringforStateProvince);
		// % protected region % [Add customisation for State Province here] end
		// % protected region % [Add customisation for City Regency here] off begin
		String randomStringforCityRegency = mock
				.strings()
				.size(50)
				.get();
		newEntity.setCityRegency(randomStringforCityRegency);
		// % protected region % [Add customisation for City Regency here] end
		// % protected region % [Add customisation for Regional here] off begin
		String randomStringforRegional = mock
				.strings()
				.size(50)
				.get();
		newEntity.setRegional(randomStringforRegional);
		// % protected region % [Add customisation for Regional here] end
		// % protected region % [Add customisation for Hospital Class here] off begin
		String randomStringforHospitalClass = mock
				.strings()
				.size(25)
				.get();
		newEntity.setHospitalClass(randomStringforHospitalClass);
		// % protected region % [Add customisation for Hospital Class here] end
		// % protected region % [Add customisation for INACBG Tariff 1 here] off begin
		String randomStringforInacbgTariff1 = mock
				.strings()
				.size(100)
				.get();
		newEntity.setInacbgTariff1(randomStringforInacbgTariff1);
		// % protected region % [Add customisation for INACBG Tariff 1 here] end
		// % protected region % [Add customisation for INACBG Tariff 2 here] off begin
		String randomStringforInacbgTariff2 = mock
				.strings()
				.size(100)
				.get();
		newEntity.setInacbgTariff2(randomStringforInacbgTariff2);
		// % protected region % [Add customisation for INACBG Tariff 2 here] end
		// % protected region % [Add customisation for Additional Upgrade VIP here] off begin
		String randomStringforAdditionalUpgradeVIP = mock
				.strings()
				.size(100)
				.get();
		newEntity.setAdditionalUpgradeVIP(randomStringforAdditionalUpgradeVIP);
		// % protected region % [Add customisation for Additional Upgrade VIP here] end
		// % protected region % [Add customisation for Payplan ID here] off begin
		String randomStringforPayplanID = mock
				.strings()
				.size(100)
				.get();
		newEntity.setPayplanID(randomStringforPayplanID);
		// % protected region % [Add customisation for Payplan ID here] end
		// % protected region % [Add customisation for Payment Plan Code here] off begin
		String randomStringforPaymentPlanCode = mock
				.strings()
				.size(100)
				.get();
		newEntity.setPaymentPlanCode(randomStringforPaymentPlanCode);
		// % protected region % [Add customisation for Payment Plan Code here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringforTariffCode = mock
				.strings()
				.size(50)
				.get();
		newEntity.setTariffCode(randomStringforTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for URL here] off begin
		String randomStringforUrl = mock
				.strings()
				.get();
		newEntity.setUrl(randomStringforUrl);
		// % protected region % [Add customisation for URL here] end
		// % protected region % [Add customisation for Username here] off begin
		String randomStringforUsername = mock
				.strings()
				.size(100)
				.get();
		newEntity.setUsername(randomStringforUsername);
		// % protected region % [Add customisation for Username here] end
		// % protected region % [Add customisation for Password here] off begin
		String randomStringforPassword = mock
				.strings()
				.size(100)
				.get();
		newEntity.setPassword(randomStringforPassword);
		// % protected region % [Add customisation for Password here] end
		// % protected region % [Add customisation for Secret Key here] off begin
		String randomStringforSecretKey = mock
				.strings()
				.size(225)
				.get();
		newEntity.setSecretKey(randomStringforSecretKey);
		// % protected region % [Add customisation for Secret Key here] end
		// % protected region % [Add customisation for Coder ID here] off begin
		String randomStringforCoderID = mock
				.strings()
				.size(100)
				.get();
		newEntity.setCoderID(randomStringforCoderID);
		// % protected region % [Add customisation for Coder ID here] end

		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsINACBGEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS INACBG entities with no reference at all.
	 */
	@Provides
	@Named("bpjsINACBGEntitiesWithNoRef")
	public Collection<BpjsINACBGEntity> bpjsINACBGEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntitiesWithNoRef here] end
		BpjsINACBGEntityFactory bpjsINACBGEntityFactory
	) {
		log.trace("Creating entities of type BpjsINACBGEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithNoRef before the main body here] end

		Collection<BpjsINACBGEntity> newEntities = bpjsINACBGEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsINACBGEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS INACBG entity with all references set.
	 */
	@Provides
	@Named("bpjsINACBGEntityWithRefs")
	public BpjsINACBGEntity bpjsINACBGEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsINACBGEntity with references");

		// % protected region % [Apply any additional logic for bpjsINACBGEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntityWithRefs before the main body here] end

		BpjsINACBGEntity bpjsINACBGEntity = injector.getInstance(Key.get(BpjsINACBGEntity.class, Names.named("bpjsINACBGEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsINACBGEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsINACBGEntity with references");

		return bpjsINACBGEntity;
	}

	/**
	 * Return a collection of BPJS INACBG entities with all references set.
	 */
	@Provides
	@Named("bpjsINACBGEntitiesWithRefs")
	public Collection<BpjsINACBGEntity> bpjsINACBGEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGEntitiesWithRefs here] end
		BpjsINACBGEntityFactory bpjsINACBGEntityFactory
	) {
		log.trace("Creating entities of type BpjsINACBGEntity with references");

		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithRefs before the main body here] end

		Collection<BpjsINACBGEntity> newEntities = bpjsINACBGEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsINACBGEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
