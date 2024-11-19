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
 * Guice module for BPJS Doctor Mapping used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDoctorMappingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDoctorMappingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDoctorMappingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDoctorMappingEntityFactory bpjsDoctorMappingEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDoctorMappingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDoctorMappingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDoctorMappingEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityFactory before the main body here] end

		BpjsDoctorMappingEntityFactory entityFactory = new BpjsDoctorMappingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDoctorMappingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDoctorMappingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityFactory after the main body here] end

		log.trace("Created BpjsDoctorMappingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Doctor Mapping entity with no references set.
	 */
	@Provides
	@Named("bpjsDoctorMappingEntityWithNoRef")
	public BpjsDoctorMappingEntity bpjsDoctorMappingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDoctorMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef before the main body here] end

		BpjsDoctorMappingEntity newEntity = new BpjsDoctorMappingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Code here] off begin
		String randomStringforRefCode = mock
				.strings()
				.size(25)
				.get();
		newEntity.setRefCode(randomStringforRefCode);
		// % protected region % [Add customisation for Ref Code here] end
		// % protected region % [Add customisation for BPJS Medical Staff here] off begin
		String randomStringforBpjsMedicalStaff = mock
				.strings()
				.get();
		newEntity.setBpjsMedicalStaff(randomStringforBpjsMedicalStaff);
		// % protected region % [Add customisation for BPJS Medical Staff here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.size(1000)
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Ref Code Service here] off begin
		String randomStringforRefCodeService = mock
				.strings()
				.get();
		newEntity.setRefCodeService(randomStringforRefCodeService);
		// % protected region % [Add customisation for Ref Code Service here] end

		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDoctorMappingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Doctor Mapping entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDoctorMappingEntitiesWithNoRef")
	public Collection<BpjsDoctorMappingEntity> bpjsDoctorMappingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntitiesWithNoRef here] end
		BpjsDoctorMappingEntityFactory bpjsDoctorMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsDoctorMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithNoRef before the main body here] end

		Collection<BpjsDoctorMappingEntity> newEntities = bpjsDoctorMappingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDoctorMappingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Doctor Mapping entity with all references set.
	 */
	@Provides
	@Named("bpjsDoctorMappingEntityWithRefs")
	public BpjsDoctorMappingEntity bpjsDoctorMappingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDoctorMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityWithRefs before the main body here] end

		BpjsDoctorMappingEntity bpjsDoctorMappingEntity = injector.getInstance(Key.get(BpjsDoctorMappingEntity.class, Names.named("bpjsDoctorMappingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDoctorMappingEntity with references");

		return bpjsDoctorMappingEntity;
	}

	/**
	 * Return a collection of BPJS Doctor Mapping entities with all references set.
	 */
	@Provides
	@Named("bpjsDoctorMappingEntitiesWithRefs")
	public Collection<BpjsDoctorMappingEntity> bpjsDoctorMappingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorMappingEntitiesWithRefs here] end
		BpjsDoctorMappingEntityFactory bpjsDoctorMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsDoctorMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithRefs before the main body here] end

		Collection<BpjsDoctorMappingEntity> newEntities = bpjsDoctorMappingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorMappingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDoctorMappingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
