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
 * Guice module for BPJS Jasa Raharja Claim used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsJasaRaharjaClaimModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsJasaRaharjaClaimModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsJasaRaharjaClaimModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsJasaRaharjaClaimEntityFactory bpjsJasaRaharjaClaimEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsJasaRaharjaClaimEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsJasaRaharjaClaimEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsJasaRaharjaClaimEntityFactory");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityFactory before the main body here] end

		BpjsJasaRaharjaClaimEntityFactory entityFactory = new BpjsJasaRaharjaClaimEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsJasaRaharjaClaimEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsJasaRaharjaClaimEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityFactory after the main body here] end

		log.trace("Created BpjsJasaRaharjaClaimEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Jasa Raharja Claim entity with no references set.
	 */
	@Provides
	@Named("bpjsJasaRaharjaClaimEntityWithNoRef")
	public BpjsJasaRaharjaClaimEntity bpjsJasaRaharjaClaimEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsJasaRaharjaClaimEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimWithNoRef before the main body here] end

		BpjsJasaRaharjaClaimEntity newEntity = new BpjsJasaRaharjaClaimEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for No SEP here] off begin
		String randomStringforNoSEP = mock
				.strings()
				.get();
		newEntity.setNoSEP(randomStringforNoSEP);
		// % protected region % [Add customisation for No SEP here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		newEntity.setSepDate(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringforPatientID = mock
				.strings()
				.get();
		newEntity.setPatientID(randomStringforPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringforPolyclinic = mock
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringforPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Incident Date here] off begin
		newEntity.setIncidentDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Incident Date here] end

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsJasaRaharjaClaimEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Jasa Raharja Claim entities with no reference at all.
	 */
	@Provides
	@Named("bpjsJasaRaharjaClaimEntitiesWithNoRef")
	public Collection<BpjsJasaRaharjaClaimEntity> bpjsJasaRaharjaClaimEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntitiesWithNoRef here] end
		BpjsJasaRaharjaClaimEntityFactory bpjsJasaRaharjaClaimEntityFactory
	) {
		log.trace("Creating entities of type BpjsJasaRaharjaClaimEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithNoRef before the main body here] end

		Collection<BpjsJasaRaharjaClaimEntity> newEntities = bpjsJasaRaharjaClaimEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsJasaRaharjaClaimEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Jasa Raharja Claim entity with all references set.
	 */
	@Provides
	@Named("bpjsJasaRaharjaClaimEntityWithRefs")
	public BpjsJasaRaharjaClaimEntity bpjsJasaRaharjaClaimEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsJasaRaharjaClaimEntity with references");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityWithRefs before the main body here] end

		BpjsJasaRaharjaClaimEntity bpjsJasaRaharjaClaimEntity = injector.getInstance(Key.get(BpjsJasaRaharjaClaimEntity.class, Names.named("bpjsJasaRaharjaClaimEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsJasaRaharjaClaimEntity with references");

		return bpjsJasaRaharjaClaimEntity;
	}

	/**
	 * Return a collection of BPJS Jasa Raharja Claim entities with all references set.
	 */
	@Provides
	@Named("bpjsJasaRaharjaClaimEntitiesWithRefs")
	public Collection<BpjsJasaRaharjaClaimEntity> bpjsJasaRaharjaClaimEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsJasaRaharjaClaimEntitiesWithRefs here] end
		BpjsJasaRaharjaClaimEntityFactory bpjsJasaRaharjaClaimEntityFactory
	) {
		log.trace("Creating entities of type BpjsJasaRaharjaClaimEntity with references");

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithRefs before the main body here] end

		Collection<BpjsJasaRaharjaClaimEntity> newEntities = bpjsJasaRaharjaClaimEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsJasaRaharjaClaimEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsJasaRaharjaClaimEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
