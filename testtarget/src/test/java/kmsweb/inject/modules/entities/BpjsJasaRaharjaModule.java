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
 * Guice module for BPJS Jasa Raharja used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsJasaRaharjaModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsJasaRaharjaModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsJasaRaharjaModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsJasaRaharjaEntityFactory bpjsJasaRaharjaEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsJasaRaharjaEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsJasaRaharjaEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsJasaRaharjaEntityFactory");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityFactory before the main body here] end

		BpjsJasaRaharjaEntityFactory entityFactory = new BpjsJasaRaharjaEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsJasaRaharjaEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsJasaRaharjaEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityFactory after the main body here] end

		log.trace("Created BpjsJasaRaharjaEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Jasa Raharja entity with no references set.
	 */
	@Provides
	@Named("bpjsJasaRaharjaEntityWithNoRef")
	public BpjsJasaRaharjaEntity bpjsJasaRaharjaEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsJasaRaharjaEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaWithNoRef before the main body here] end

		BpjsJasaRaharjaEntity newEntity = new BpjsJasaRaharjaEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Initial SEP No here] off begin
		String randomStringforInitialSEPNo = mock
				.strings()
				.get();
		newEntity.setInitialSEPNo(randomStringforInitialSEPNo);
		// % protected region % [Add customisation for Initial SEP No here] end
		// % protected region % [Add customisation for Guarantee Letter No here] off begin
		String randomStringforGuaranteeLetterNo = mock
				.strings()
				.get();
		newEntity.setGuaranteeLetterNo(randomStringforGuaranteeLetterNo);
		// % protected region % [Add customisation for Guarantee Letter No here] end
		// % protected region % [Add customisation for Incident Date here] off begin
		newEntity.setIncidentDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Incident Date here] end
		// % protected region % [Add customisation for Registration No here] off begin
		String randomStringforRegistrationNo = mock
				.strings()
				.get();
		newEntity.setRegistrationNo(randomStringforRegistrationNo);
		// % protected region % [Add customisation for Registration No here] end
		// % protected region % [Add customisation for No SEP Suplesi here] off begin
		String randomStringforNoSEPSuplesi = mock
				.strings()
				.get();
		newEntity.setNoSEPSuplesi(randomStringforNoSEPSuplesi);
		// % protected region % [Add customisation for No SEP Suplesi here] end
		// % protected region % [Add customisation for Tanggal SEP Suplesi here] off begin
		newEntity.setTanggalSEPSuplesi(OffsetDateTime.now());
		// % protected region % [Add customisation for Tanggal SEP Suplesi here] end

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsJasaRaharjaEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Jasa Raharja entities with no reference at all.
	 */
	@Provides
	@Named("bpjsJasaRaharjaEntitiesWithNoRef")
	public Collection<BpjsJasaRaharjaEntity> bpjsJasaRaharjaEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntitiesWithNoRef here] end
		BpjsJasaRaharjaEntityFactory bpjsJasaRaharjaEntityFactory
	) {
		log.trace("Creating entities of type BpjsJasaRaharjaEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithNoRef before the main body here] end

		Collection<BpjsJasaRaharjaEntity> newEntities = bpjsJasaRaharjaEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsJasaRaharjaEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Jasa Raharja entity with all references set.
	 */
	@Provides
	@Named("bpjsJasaRaharjaEntityWithRefs")
	public BpjsJasaRaharjaEntity bpjsJasaRaharjaEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsJasaRaharjaEntity with references");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityWithRefs before the main body here] end

		BpjsJasaRaharjaEntity bpjsJasaRaharjaEntity = injector.getInstance(Key.get(BpjsJasaRaharjaEntity.class, Names.named("bpjsJasaRaharjaEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsJasaRaharjaEntity with references");

		return bpjsJasaRaharjaEntity;
	}

	/**
	 * Return a collection of BPJS Jasa Raharja entities with all references set.
	 */
	@Provides
	@Named("bpjsJasaRaharjaEntitiesWithRefs")
	public Collection<BpjsJasaRaharjaEntity> bpjsJasaRaharjaEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaEntitiesWithRefs here] end
		BpjsJasaRaharjaEntityFactory bpjsJasaRaharjaEntityFactory
	) {
		log.trace("Creating entities of type BpjsJasaRaharjaEntity with references");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithRefs before the main body here] end

		Collection<BpjsJasaRaharjaEntity> newEntities = bpjsJasaRaharjaEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsJasaRaharjaEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
