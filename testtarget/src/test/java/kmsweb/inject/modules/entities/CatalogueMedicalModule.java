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
 * Guice module for Catalogue Medical  used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CatalogueMedicalModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CatalogueMedicalModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CatalogueMedicalModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CatalogueMedicalEntityFactory catalogueMedicalEntityFactory(
			// % protected region % [Apply any additional injected arguments for catalogueMedicalEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for catalogueMedicalEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CatalogueMedicalEntityFactory");

		// % protected region % [Apply any additional logic for catalogueMedicalEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntityFactory before the main body here] end

		CatalogueMedicalEntityFactory entityFactory = new CatalogueMedicalEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CatalogueMedicalEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CatalogueMedicalEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for catalogueMedicalEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntityFactory after the main body here] end

		log.trace("Created CatalogueMedicalEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Catalogue Medical  entity with no references set.
	 */
	@Provides
	@Named("catalogueMedicalEntityWithNoRef")
	public CatalogueMedicalEntity catalogueMedicalEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CatalogueMedicalEntity with no reference");

		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef before the main body here] end

		CatalogueMedicalEntity newEntity = new CatalogueMedicalEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Composition here] off begin
		String randomStringforComposition = mock
				.strings()
				.get();
		newEntity.setComposition(randomStringforComposition);
		// % protected region % [Add customisation for Composition here] end
		// % protected region % [Add customisation for Can be prescribed here] off begin
		newEntity.setCanBePrescribed(mock.bools().get());
		// % protected region % [Add customisation for Can be prescribed here] end
		// % protected region % [Add customisation for Is Hospital Formulary here] off begin
		newEntity.setIsHospitalFormulary(mock.bools().get());
		// % protected region % [Add customisation for Is Hospital Formulary here] end
		// % protected region % [Add customisation for Approval Notes here] off begin
		String randomStringforApprovalNotes = mock
				.strings()
				.get();
		newEntity.setApprovalNotes(randomStringforApprovalNotes);
		// % protected region % [Add customisation for Approval Notes here] end
		// % protected region % [Add customisation for Is Generic here] off begin
		newEntity.setIsGeneric(mock.bools().get());
		// % protected region % [Add customisation for Is Generic here] end
		// % protected region % [Add customisation for Is Restricted here] off begin
		newEntity.setIsRestricted(mock.bools().get());
		// % protected region % [Add customisation for Is Restricted here] end
		// % protected region % [Add customisation for Is Vaccine here] off begin
		newEntity.setIsVaccine(mock.bools().get());
		// % protected region % [Add customisation for Is Vaccine here] end
		// % protected region % [Add customisation for Vaccine Type here] off begin
		String randomStringforVaccineType = mock
				.strings()
				.get();
		newEntity.setVaccineType(randomStringforVaccineType);
		// % protected region % [Add customisation for Vaccine Type here] end
		// % protected region % [Add customisation for Consumption Method here] off begin
		String randomStringforConsumptionMethod = mock
				.strings()
				.get();
		newEntity.setConsumptionMethod(randomStringforConsumptionMethod);
		// % protected region % [Add customisation for Consumption Method here] end
		// % protected region % [Add customisation for Consumption Unit here] off begin
		String randomStringforConsumptionUnit = mock
				.strings()
				.get();
		newEntity.setConsumptionUnit(randomStringforConsumptionUnit);
		// % protected region % [Add customisation for Consumption Unit here] end
		// % protected region % [Add customisation for Compound Charging Rounding here] off begin
		newEntity.setCompoundChargingRounding(mock.bools().get());
		// % protected region % [Add customisation for Compound Charging Rounding here] end
		// % protected region % [Add customisation for Compound Charging Rounding Amount here] off begin
		String randomStringforCompoundChargingRoundingAmount = mock
				.strings()
				.get();
		newEntity.setCompoundChargingRoundingAmount(randomStringforCompoundChargingRoundingAmount);
		// % protected region % [Add customisation for Compound Charging Rounding Amount here] end
		// % protected region % [Add customisation for Inventory Rounding here] off begin
		newEntity.setInventoryRounding(mock.bools().get());
		// % protected region % [Add customisation for Inventory Rounding here] end
		// % protected region % [Add customisation for Inventory Rounding Amount here] off begin
		newEntity.setInventoryRoundingAmount(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Amount here] end

		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalWithNoRef after the main body here] end

		log.trace("Created entity of type CatalogueMedicalEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Catalogue Medical  entities with no reference at all.
	 */
	@Provides
	@Named("catalogueMedicalEntitiesWithNoRef")
	public Collection<CatalogueMedicalEntity> catalogueMedicalEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntitiesWithNoRef here] end
		CatalogueMedicalEntityFactory catalogueMedicalEntityFactory
	) {
		log.trace("Creating entities of type CatalogueMedicalEntity with no reference");

		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithNoRef before the main body here] end

		Collection<CatalogueMedicalEntity> newEntities = catalogueMedicalEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CatalogueMedicalEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Catalogue Medical  entity with all references set.
	 */
	@Provides
	@Named("catalogueMedicalEntityWithRefs")
	public CatalogueMedicalEntity catalogueMedicalEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CatalogueMedicalEntity with references");

		// % protected region % [Apply any additional logic for catalogueMedicalEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntityWithRefs before the main body here] end

		CatalogueMedicalEntity catalogueMedicalEntity = injector.getInstance(Key.get(CatalogueMedicalEntity.class, Names.named("catalogueMedicalEntityWithNoRef")));

		// % protected region % [Apply any additional logic for catalogueMedicalEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntityWithRefs after the main body here] end

		log.trace("Created entity of type CatalogueMedicalEntity with references");

		return catalogueMedicalEntity;
	}

	/**
	 * Return a collection of Catalogue Medical  entities with all references set.
	 */
	@Provides
	@Named("catalogueMedicalEntitiesWithRefs")
	public Collection<CatalogueMedicalEntity> catalogueMedicalEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for catalogueMedicalEntitiesWithRefs here] end
		CatalogueMedicalEntityFactory catalogueMedicalEntityFactory
	) {
		log.trace("Creating entities of type CatalogueMedicalEntity with references");

		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithRefs before the main body here] end

		Collection<CatalogueMedicalEntity> newEntities = catalogueMedicalEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueMedicalEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CatalogueMedicalEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
