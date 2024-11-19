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
 * Guice module for Medical Fee used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalFeeModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalFeeModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalFeeModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalFeeEntityFactory medicalFeeEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalFeeEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalFeeEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalFeeEntityFactory");

		// % protected region % [Apply any additional logic for medicalFeeEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntityFactory before the main body here] end

		MedicalFeeEntityFactory entityFactory = new MedicalFeeEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalFeeEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalFeeEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalFeeEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntityFactory after the main body here] end

		log.trace("Created MedicalFeeEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Fee entity with no references set.
	 */
	@Provides
	@Named("medicalFeeEntityWithNoRef")
	public MedicalFeeEntity medicalFeeEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalFeeEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalFeeEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalFeeEntity with no reference");

		// % protected region % [Apply any additional logic for medicalFeeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeWithNoRef before the main body here] end

		MedicalFeeEntity newEntity = new MedicalFeeEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringforTariffCode = mock
				.strings()
				.get();
		newEntity.setTariffCode(randomStringforTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Pharmacy Transaction Type here] off begin
		newEntity.setPharmacyTransactionType(PharmacyTypeEnum.MEDICATION);
		// % protected region % [Add customisation for Pharmacy Transaction Type here] end
		// % protected region % [Add customisation for Pharmacy Transaction Number here] off begin
		String randomStringforPharmacyTransactionNumber = mock
				.strings()
				.get();
		newEntity.setPharmacyTransactionNumber(randomStringforPharmacyTransactionNumber);
		// % protected region % [Add customisation for Pharmacy Transaction Number here] end
		// % protected region % [Add customisation for Medication Transaction Number here] off begin
		String randomStringforMedicationTransactionNumber = mock
				.strings()
				.get();
		newEntity.setMedicationTransactionNumber(randomStringforMedicationTransactionNumber);
		// % protected region % [Add customisation for Medication Transaction Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringforUnit = mock
				.strings()
				.get();
		newEntity.setUnit(randomStringforUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Hospital Price here] off begin
		newEntity.setHospitalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Hospital Price here] end
		// % protected region % [Add customisation for Other Component Price here] off begin
		newEntity.setOtherComponentPrice(mock.doubles().get());
		// % protected region % [Add customisation for Other Component Price here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringforMedicalStaffCode = mock
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringforMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for medical fee status here] off begin
		newEntity.setMedicalFeeStatus(MedicalFeeStatusEnum.OPEN);
		// % protected region % [Add customisation for medical fee status here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for medicalFeeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalFeeEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Fee entities with no reference at all.
	 */
	@Provides
	@Named("medicalFeeEntitiesWithNoRef")
	public Collection<MedicalFeeEntity> medicalFeeEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalFeeEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalFeeEntitiesWithNoRef here] end
		MedicalFeeEntityFactory medicalFeeEntityFactory
	) {
		log.trace("Creating entities of type MedicalFeeEntity with no reference");

		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithNoRef before the main body here] end

		Collection<MedicalFeeEntity> newEntities = medicalFeeEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalFeeEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Fee entity with all references set.
	 */
	@Provides
	@Named("medicalFeeEntityWithRefs")
	public MedicalFeeEntity medicalFeeEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalFeeEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalFeeEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalFeeEntity with references");

		// % protected region % [Apply any additional logic for medicalFeeEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntityWithRefs before the main body here] end

		MedicalFeeEntity medicalFeeEntity = injector.getInstance(Key.get(MedicalFeeEntity.class, Names.named("medicalFeeEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalFeeEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalFeeEntity with references");

		return medicalFeeEntity;
	}

	/**
	 * Return a collection of Medical Fee entities with all references set.
	 */
	@Provides
	@Named("medicalFeeEntitiesWithRefs")
	public Collection<MedicalFeeEntity> medicalFeeEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalFeeEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalFeeEntitiesWithRefs here] end
		MedicalFeeEntityFactory medicalFeeEntityFactory
	) {
		log.trace("Creating entities of type MedicalFeeEntity with references");

		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithRefs before the main body here] end

		Collection<MedicalFeeEntity> newEntities = medicalFeeEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalFeeEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
