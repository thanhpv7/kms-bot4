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
 * Guice module for Informed Consent used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InformedConsentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InformedConsentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InformedConsentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InformedConsentEntityFactory informedConsentEntityFactory(
			// % protected region % [Apply any additional injected arguments for informedConsentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for informedConsentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InformedConsentEntityFactory");

		// % protected region % [Apply any additional logic for informedConsentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntityFactory before the main body here] end

		InformedConsentEntityFactory entityFactory = new InformedConsentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InformedConsentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InformedConsentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for informedConsentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntityFactory after the main body here] end

		log.trace("Created InformedConsentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Informed Consent entity with no references set.
	 */
	@Provides
	@Named("informedConsentEntityWithNoRef")
	public InformedConsentEntity informedConsentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for informedConsentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for informedConsentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InformedConsentEntity with no reference");

		// % protected region % [Apply any additional logic for informedConsentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentWithNoRef before the main body here] end

		InformedConsentEntity newEntity = new InformedConsentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Patient Family Guardian Name here] off begin
		String randomStringforPatientFamilyGuardianName = mock
				.strings()
				.get();
		newEntity.setPatientFamilyGuardianName(randomStringforPatientFamilyGuardianName);
		// % protected region % [Add customisation for Patient Family Guardian Name here] end
		// % protected region % [Add customisation for Patient Family Guardian Relationship here] off begin
		String randomStringforPatientFamilyGuardianRelationship = mock
				.strings()
				.get();
		newEntity.setPatientFamilyGuardianRelationship(randomStringforPatientFamilyGuardianRelationship);
		// % protected region % [Add customisation for Patient Family Guardian Relationship here] end
		// % protected region % [Add customisation for Procedure To Be Performed here] off begin
		String randomStringforProcedureToBePerformed = mock
				.strings()
				.get();
		newEntity.setProcedureToBePerformed(randomStringforProcedureToBePerformed);
		// % protected region % [Add customisation for Procedure To Be Performed here] end
		// % protected region % [Add customisation for Consequence Of Procedure here] off begin
		String randomStringforConsequenceOfProcedure = mock
				.strings()
				.get();
		newEntity.setConsequenceOfProcedure(randomStringforConsequenceOfProcedure);
		// % protected region % [Add customisation for Consequence Of Procedure here] end
		// % protected region % [Add customisation for Consent On Procedure here] off begin
		String randomStringforConsentOnProcedure = mock
				.strings()
				.get();
		newEntity.setConsentOnProcedure(randomStringforConsentOnProcedure);
		// % protected region % [Add customisation for Consent On Procedure here] end
		// % protected region % [Add customisation for Consent Date Time here] off begin
		newEntity.setConsentDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Consent Date Time here] end
		// % protected region % [Add customisation for Informing Staff Signature here] off begin
		String randomStringforInformingStaffSignature = mock
				.strings()
				.get();
		newEntity.setInformingStaffSignature(randomStringforInformingStaffSignature);
		// % protected region % [Add customisation for Informing Staff Signature here] end
		// % protected region % [Add customisation for Consenting Party Signature here] off begin
		String randomStringforConsentingPartySignature = mock
				.strings()
				.get();
		newEntity.setConsentingPartySignature(randomStringforConsentingPartySignature);
		// % protected region % [Add customisation for Consenting Party Signature here] end
		// % protected region % [Add customisation for Consenting Party Type here] off begin
		String randomStringforConsentingPartyType = mock
				.strings()
				.get();
		newEntity.setConsentingPartyType(randomStringforConsentingPartyType);
		// % protected region % [Add customisation for Consenting Party Type here] end
		// % protected region % [Add customisation for Consenting Party Name here] off begin
		String randomStringforConsentingPartyName = mock
				.strings()
				.get();
		newEntity.setConsentingPartyName(randomStringforConsentingPartyName);
		// % protected region % [Add customisation for Consenting Party Name here] end
		// % protected region % [Add customisation for Witness Signature 1 here] off begin
		String randomStringforWitnessSignature1 = mock
				.strings()
				.get();
		newEntity.setWitnessSignature1(randomStringforWitnessSignature1);
		// % protected region % [Add customisation for Witness Signature 1 here] end
		// % protected region % [Add customisation for Witness Name 1 here] off begin
		String randomStringforWitnessName1 = mock
				.strings()
				.get();
		newEntity.setWitnessName1(randomStringforWitnessName1);
		// % protected region % [Add customisation for Witness Name 1 here] end
		// % protected region % [Add customisation for Witness Signature 2 here] off begin
		String randomStringforWitnessSignature2 = mock
				.strings()
				.get();
		newEntity.setWitnessSignature2(randomStringforWitnessSignature2);
		// % protected region % [Add customisation for Witness Signature 2 here] end
		// % protected region % [Add customisation for Witness Name 2 here] off begin
		String randomStringforWitnessName2 = mock
				.strings()
				.get();
		newEntity.setWitnessName2(randomStringforWitnessName2);
		// % protected region % [Add customisation for Witness Name 2 here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for informedConsentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentWithNoRef after the main body here] end

		log.trace("Created entity of type InformedConsentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Informed Consent entities with no reference at all.
	 */
	@Provides
	@Named("informedConsentEntitiesWithNoRef")
	public Collection<InformedConsentEntity> informedConsentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for informedConsentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for informedConsentEntitiesWithNoRef here] end
		InformedConsentEntityFactory informedConsentEntityFactory
	) {
		log.trace("Creating entities of type InformedConsentEntity with no reference");

		// % protected region % [Apply any additional logic for informedConsentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntitiesWithNoRef before the main body here] end

		Collection<InformedConsentEntity> newEntities = informedConsentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for informedConsentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InformedConsentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Informed Consent entity with all references set.
	 */
	@Provides
	@Named("informedConsentEntityWithRefs")
	public InformedConsentEntity informedConsentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for informedConsentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for informedConsentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InformedConsentEntity with references");

		// % protected region % [Apply any additional logic for informedConsentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntityWithRefs before the main body here] end

		InformedConsentEntity informedConsentEntity = injector.getInstance(Key.get(InformedConsentEntity.class, Names.named("informedConsentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for informedConsentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntityWithRefs after the main body here] end

		log.trace("Created entity of type InformedConsentEntity with references");

		return informedConsentEntity;
	}

	/**
	 * Return a collection of Informed Consent entities with all references set.
	 */
	@Provides
	@Named("informedConsentEntitiesWithRefs")
	public Collection<InformedConsentEntity> informedConsentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for informedConsentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for informedConsentEntitiesWithRefs here] end
		InformedConsentEntityFactory informedConsentEntityFactory
	) {
		log.trace("Creating entities of type InformedConsentEntity with references");

		// % protected region % [Apply any additional logic for informedConsentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntitiesWithRefs before the main body here] end

		Collection<InformedConsentEntity> newEntities = informedConsentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for informedConsentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for informedConsentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InformedConsentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
