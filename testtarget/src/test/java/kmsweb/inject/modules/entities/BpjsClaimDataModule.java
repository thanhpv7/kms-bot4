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
 * Guice module for BPJS Claim Data used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsClaimDataModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsClaimDataModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsClaimDataModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsClaimDataEntityFactory bpjsClaimDataEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsClaimDataEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsClaimDataEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsClaimDataEntityFactory");

		// % protected region % [Apply any additional logic for bpjsClaimDataEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntityFactory before the main body here] end

		BpjsClaimDataEntityFactory entityFactory = new BpjsClaimDataEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsClaimDataEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsClaimDataEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsClaimDataEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntityFactory after the main body here] end

		log.trace("Created BpjsClaimDataEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Claim Data entity with no references set.
	 */
	@Provides
	@Named("bpjsClaimDataEntityWithNoRef")
	public BpjsClaimDataEntity bpjsClaimDataEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsClaimDataEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsClaimDataWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataWithNoRef before the main body here] end

		BpjsClaimDataEntity newEntity = new BpjsClaimDataEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for INACBG Code here] off begin
		String randomStringforInacbgCode = mock
				.strings()
				.get();
		newEntity.setInacbgCode(randomStringforInacbgCode);
		// % protected region % [Add customisation for INACBG Code here] end
		// % protected region % [Add customisation for INACBG Name here] off begin
		String randomStringforInacbgName = mock
				.strings()
				.get();
		newEntity.setInacbgName(randomStringforInacbgName);
		// % protected region % [Add customisation for INACBG Name here] end
		// % protected region % [Add customisation for Submitted Tariff here] off begin
		String randomStringforSubmittedTariff = mock
				.strings()
				.get();
		newEntity.setSubmittedTariff(randomStringforSubmittedTariff);
		// % protected region % [Add customisation for Submitted Tariff here] end
		// % protected region % [Add customisation for Approval here] off begin
		String randomStringforApproval = mock
				.strings()
				.get();
		newEntity.setApproval(randomStringforApproval);
		// % protected region % [Add customisation for Approval here] end
		// % protected region % [Add customisation for Grouper Tariff here] off begin
		String randomStringforGrouperTariff = mock
				.strings()
				.get();
		newEntity.setGrouperTariff(randomStringforGrouperTariff);
		// % protected region % [Add customisation for Grouper Tariff here] end
		// % protected region % [Add customisation for Hospital Tariff here] off begin
		String randomStringforHospitalTariff = mock
				.strings()
				.get();
		newEntity.setHospitalTariff(randomStringforHospitalTariff);
		// % protected region % [Add customisation for Hospital Tariff here] end
		// % protected region % [Add customisation for Top Up here] off begin
		String randomStringforTopUp = mock
				.strings()
				.get();
		newEntity.setTopUp(randomStringforTopUp);
		// % protected region % [Add customisation for Top Up here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for FPK No here] off begin
		String randomStringforFpkNo = mock
				.strings()
				.get();
		newEntity.setFpkNo(randomStringforFpkNo);
		// % protected region % [Add customisation for FPK No here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
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
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringforPatientID = mock
				.strings()
				.get();
		newEntity.setPatientID(randomStringforPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringforPolyclinic = mock
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringforPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		newEntity.setSepDate(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP Date here] end

		// % protected region % [Apply any additional logic for bpjsClaimDataWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsClaimDataEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Claim Data entities with no reference at all.
	 */
	@Provides
	@Named("bpjsClaimDataEntitiesWithNoRef")
	public Collection<BpjsClaimDataEntity> bpjsClaimDataEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntitiesWithNoRef here] end
		BpjsClaimDataEntityFactory bpjsClaimDataEntityFactory
	) {
		log.trace("Creating entities of type BpjsClaimDataEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithNoRef before the main body here] end

		Collection<BpjsClaimDataEntity> newEntities = bpjsClaimDataEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsClaimDataEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Claim Data entity with all references set.
	 */
	@Provides
	@Named("bpjsClaimDataEntityWithRefs")
	public BpjsClaimDataEntity bpjsClaimDataEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsClaimDataEntity with references");

		// % protected region % [Apply any additional logic for bpjsClaimDataEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntityWithRefs before the main body here] end

		BpjsClaimDataEntity bpjsClaimDataEntity = injector.getInstance(Key.get(BpjsClaimDataEntity.class, Names.named("bpjsClaimDataEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsClaimDataEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsClaimDataEntity with references");

		return bpjsClaimDataEntity;
	}

	/**
	 * Return a collection of BPJS Claim Data entities with all references set.
	 */
	@Provides
	@Named("bpjsClaimDataEntitiesWithRefs")
	public Collection<BpjsClaimDataEntity> bpjsClaimDataEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsClaimDataEntitiesWithRefs here] end
		BpjsClaimDataEntityFactory bpjsClaimDataEntityFactory
	) {
		log.trace("Creating entities of type BpjsClaimDataEntity with references");

		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithRefs before the main body here] end

		Collection<BpjsClaimDataEntity> newEntities = bpjsClaimDataEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimDataEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsClaimDataEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
