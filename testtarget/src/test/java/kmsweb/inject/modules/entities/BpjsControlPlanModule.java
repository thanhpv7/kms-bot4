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
 * Guice module for BPJS Control Plan used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsControlPlanModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsControlPlanModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsControlPlanModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsControlPlanEntityFactory bpjsControlPlanEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsControlPlanEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsControlPlanEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsControlPlanEntityFactory");

		// % protected region % [Apply any additional logic for bpjsControlPlanEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntityFactory before the main body here] end

		BpjsControlPlanEntityFactory entityFactory = new BpjsControlPlanEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsControlPlanEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsControlPlanEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsControlPlanEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntityFactory after the main body here] end

		log.trace("Created BpjsControlPlanEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Control Plan entity with no references set.
	 */
	@Provides
	@Named("bpjsControlPlanEntityWithNoRef")
	public BpjsControlPlanEntity bpjsControlPlanEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsControlPlanEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef before the main body here] end

		BpjsControlPlanEntity newEntity = new BpjsControlPlanEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for No SEP here] off begin
		String randomStringforNoSEP = mock
				.strings()
				.get();
		newEntity.setNoSEP(randomStringforNoSEP);
		// % protected region % [Add customisation for No SEP here] end
		// % protected region % [Add customisation for Control Letter No here] off begin
		String randomStringforControlLetterNo = mock
				.strings()
				.get();
		newEntity.setControlLetterNo(randomStringforControlLetterNo);
		// % protected region % [Add customisation for Control Letter No here] end
		// % protected region % [Add customisation for Control Plan Date here] off begin
		String randomStringforControlPlanDate = mock
				.strings()
				.get();
		newEntity.setControlPlanDate(randomStringforControlPlanDate);
		// % protected region % [Add customisation for Control Plan Date here] end
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
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Date Of Birth here] off begin
		String randomStringforDateOfBirth = mock
				.strings()
				.get();
		newEntity.setDateOfBirth(randomStringforDateOfBirth);
		// % protected region % [Add customisation for Date Of Birth here] end
		// % protected region % [Add customisation for Doctor Code here] off begin
		String randomStringforDoctorCode = mock
				.strings()
				.get();
		newEntity.setDoctorCode(randomStringforDoctorCode);
		// % protected region % [Add customisation for Doctor Code here] end
		// % protected region % [Add customisation for Polyclinic Code here] off begin
		String randomStringforPolyclinicCode = mock
				.strings()
				.get();
		newEntity.setPolyclinicCode(randomStringforPolyclinicCode);
		// % protected region % [Add customisation for Polyclinic Code here] end

		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsControlPlanEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Control Plan entities with no reference at all.
	 */
	@Provides
	@Named("bpjsControlPlanEntitiesWithNoRef")
	public Collection<BpjsControlPlanEntity> bpjsControlPlanEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntitiesWithNoRef here] end
		BpjsControlPlanEntityFactory bpjsControlPlanEntityFactory
	) {
		log.trace("Creating entities of type BpjsControlPlanEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithNoRef before the main body here] end

		Collection<BpjsControlPlanEntity> newEntities = bpjsControlPlanEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsControlPlanEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Control Plan entity with all references set.
	 */
	@Provides
	@Named("bpjsControlPlanEntityWithRefs")
	public BpjsControlPlanEntity bpjsControlPlanEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsControlPlanEntity with references");

		// % protected region % [Apply any additional logic for bpjsControlPlanEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntityWithRefs before the main body here] end

		BpjsControlPlanEntity bpjsControlPlanEntity = injector.getInstance(Key.get(BpjsControlPlanEntity.class, Names.named("bpjsControlPlanEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsControlPlanEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsControlPlanEntity with references");

		return bpjsControlPlanEntity;
	}

	/**
	 * Return a collection of BPJS Control Plan entities with all references set.
	 */
	@Provides
	@Named("bpjsControlPlanEntitiesWithRefs")
	public Collection<BpjsControlPlanEntity> bpjsControlPlanEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsControlPlanEntitiesWithRefs here] end
		BpjsControlPlanEntityFactory bpjsControlPlanEntityFactory
	) {
		log.trace("Creating entities of type BpjsControlPlanEntity with references");

		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithRefs before the main body here] end

		Collection<BpjsControlPlanEntity> newEntities = bpjsControlPlanEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlPlanEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsControlPlanEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
