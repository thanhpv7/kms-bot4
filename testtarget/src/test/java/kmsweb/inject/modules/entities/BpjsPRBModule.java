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
 * Guice module for BPJS PRB used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPRBModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPRBModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPRBModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPRBEntityFactory bpjsPRBEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPRBEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPRBEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPRBEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPRBEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntityFactory before the main body here] end

		BpjsPRBEntityFactory entityFactory = new BpjsPRBEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPRBEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPRBEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPRBEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntityFactory after the main body here] end

		log.trace("Created BpjsPRBEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS PRB entity with no references set.
	 */
	@Provides
	@Named("bpjsPRBEntityWithNoRef")
	public BpjsPRBEntity bpjsPRBEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPRBEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPRBEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPRBEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef before the main body here] end

		BpjsPRBEntity newEntity = new BpjsPRBEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SRB No here] off begin
		String randomStringforSrbNo = mock
				.strings()
				.get();
		newEntity.setSrbNo(randomStringforSrbNo);
		// % protected region % [Add customisation for SRB No here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for PRB Program Code here] off begin
		String randomStringforPrbProgramCode = mock
				.strings()
				.get();
		newEntity.setPrbProgramCode(randomStringforPrbProgramCode);
		// % protected region % [Add customisation for PRB Program Code here] end
		// % protected region % [Add customisation for PRB Program Name here] off begin
		String randomStringforPrbProgramName = mock
				.strings()
				.get();
		newEntity.setPrbProgramName(randomStringforPrbProgramName);
		// % protected region % [Add customisation for PRB Program Name here] end
		// % protected region % [Add customisation for Doctor Code here] off begin
		String randomStringforDoctorCode = mock
				.strings()
				.get();
		newEntity.setDoctorCode(randomStringforDoctorCode);
		// % protected region % [Add customisation for Doctor Code here] end
		// % protected region % [Add customisation for Doctor Name here] off begin
		String randomStringforDoctorName = mock
				.strings()
				.get();
		newEntity.setDoctorName(randomStringforDoctorName);
		// % protected region % [Add customisation for Doctor Name here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Recommendation here] off begin
		String randomStringforRecommendation = mock
				.strings()
				.get();
		newEntity.setRecommendation(randomStringforRecommendation);
		// % protected region % [Add customisation for Recommendation here] end

		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPRBEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS PRB entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPRBEntitiesWithNoRef")
	public Collection<BpjsPRBEntity> bpjsPRBEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPRBEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPRBEntitiesWithNoRef here] end
		BpjsPRBEntityFactory bpjsPRBEntityFactory
	) {
		log.trace("Creating entities of type BpjsPRBEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithNoRef before the main body here] end

		Collection<BpjsPRBEntity> newEntities = bpjsPRBEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPRBEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS PRB entity with all references set.
	 */
	@Provides
	@Named("bpjsPRBEntityWithRefs")
	public BpjsPRBEntity bpjsPRBEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPRBEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPRBEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPRBEntity with references");

		// % protected region % [Apply any additional logic for bpjsPRBEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntityWithRefs before the main body here] end

		BpjsPRBEntity bpjsPRBEntity = injector.getInstance(Key.get(BpjsPRBEntity.class, Names.named("bpjsPRBEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPRBEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPRBEntity with references");

		return bpjsPRBEntity;
	}

	/**
	 * Return a collection of BPJS PRB entities with all references set.
	 */
	@Provides
	@Named("bpjsPRBEntitiesWithRefs")
	public Collection<BpjsPRBEntity> bpjsPRBEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPRBEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPRBEntitiesWithRefs here] end
		BpjsPRBEntityFactory bpjsPRBEntityFactory
	) {
		log.trace("Creating entities of type BpjsPRBEntity with references");

		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithRefs before the main body here] end

		Collection<BpjsPRBEntity> newEntities = bpjsPRBEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPRBEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
