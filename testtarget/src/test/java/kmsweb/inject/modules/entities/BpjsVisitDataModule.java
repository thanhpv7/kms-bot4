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
 * Guice module for BPJS Visit Data used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsVisitDataModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsVisitDataModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsVisitDataModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsVisitDataEntityFactory bpjsVisitDataEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsVisitDataEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsVisitDataEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsVisitDataEntityFactory");

		// % protected region % [Apply any additional logic for bpjsVisitDataEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntityFactory before the main body here] end

		BpjsVisitDataEntityFactory entityFactory = new BpjsVisitDataEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsVisitDataEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsVisitDataEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsVisitDataEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntityFactory after the main body here] end

		log.trace("Created BpjsVisitDataEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Visit Data entity with no references set.
	 */
	@Provides
	@Named("bpjsVisitDataEntityWithNoRef")
	public BpjsVisitDataEntity bpjsVisitDataEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsVisitDataEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsVisitDataWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataWithNoRef before the main body here] end

		BpjsVisitDataEntity newEntity = new BpjsVisitDataEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringforDiagnose = mock
				.strings()
				.get();
		newEntity.setDiagnose(randomStringforDiagnose);
		// % protected region % [Add customisation for Diagnose here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringforPolyclinic = mock
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringforPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringforSepDate = mock
				.strings()
				.get();
		newEntity.setSepDate(randomStringforSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for SEP Dismissal Date here] off begin
		String randomStringforSepDismissalDate = mock
				.strings()
				.get();
		newEntity.setSepDismissalDate(randomStringforSepDismissalDate);
		// % protected region % [Add customisation for SEP Dismissal Date here] end
		// % protected region % [Add customisation for Json Insert here] off begin
		String randomStringforJsonInsert = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setJsonInsert(randomStringforJsonInsert);
		// % protected region % [Add customisation for Json Insert here] end
		// % protected region % [Add customisation for Json Update here] off begin
		String randomStringforJsonUpdate = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setJsonUpdate(randomStringforJsonUpdate);
		// % protected region % [Add customisation for Json Update here] end

		// % protected region % [Apply any additional logic for bpjsVisitDataWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsVisitDataEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Visit Data entities with no reference at all.
	 */
	@Provides
	@Named("bpjsVisitDataEntitiesWithNoRef")
	public Collection<BpjsVisitDataEntity> bpjsVisitDataEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntitiesWithNoRef here] end
		BpjsVisitDataEntityFactory bpjsVisitDataEntityFactory
	) {
		log.trace("Creating entities of type BpjsVisitDataEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithNoRef before the main body here] end

		Collection<BpjsVisitDataEntity> newEntities = bpjsVisitDataEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsVisitDataEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Visit Data entity with all references set.
	 */
	@Provides
	@Named("bpjsVisitDataEntityWithRefs")
	public BpjsVisitDataEntity bpjsVisitDataEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsVisitDataEntity with references");

		// % protected region % [Apply any additional logic for bpjsVisitDataEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntityWithRefs before the main body here] end

		BpjsVisitDataEntity bpjsVisitDataEntity = injector.getInstance(Key.get(BpjsVisitDataEntity.class, Names.named("bpjsVisitDataEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsVisitDataEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsVisitDataEntity with references");

		return bpjsVisitDataEntity;
	}

	/**
	 * Return a collection of BPJS Visit Data entities with all references set.
	 */
	@Provides
	@Named("bpjsVisitDataEntitiesWithRefs")
	public Collection<BpjsVisitDataEntity> bpjsVisitDataEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsVisitDataEntitiesWithRefs here] end
		BpjsVisitDataEntityFactory bpjsVisitDataEntityFactory
	) {
		log.trace("Creating entities of type BpjsVisitDataEntity with references");

		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithRefs before the main body here] end

		Collection<BpjsVisitDataEntity> newEntities = bpjsVisitDataEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsVisitDataEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsVisitDataEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
