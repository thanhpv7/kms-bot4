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
 * Guice module for Patient Consent used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientConsentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientConsentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientConsentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientConsentEntityFactory patientConsentEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientConsentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientConsentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientConsentEntityFactory");

		// % protected region % [Apply any additional logic for patientConsentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntityFactory before the main body here] end

		PatientConsentEntityFactory entityFactory = new PatientConsentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientConsentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientConsentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientConsentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntityFactory after the main body here] end

		log.trace("Created PatientConsentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Consent entity with no references set.
	 */
	@Provides
	@Named("patientConsentEntityWithNoRef")
	public PatientConsentEntity patientConsentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientConsentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientConsentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientConsentEntity with no reference");

		// % protected region % [Apply any additional logic for patientConsentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentWithNoRef before the main body here] end

		PatientConsentEntity newEntity = new PatientConsentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Consent Date Time here] off begin
		newEntity.setConsentDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Consent Date Time here] end
		// % protected region % [Add customisation for Consent On Payment Terms here] off begin
		String randomStringforConsentOnPaymentTerms = mock
				.strings()
				.get();
		newEntity.setConsentOnPaymentTerms(randomStringforConsentOnPaymentTerms);
		// % protected region % [Add customisation for Consent On Payment Terms here] end
		// % protected region % [Add customisation for Consent On Rights And Obligations here] off begin
		String randomStringforConsentOnRightsAndObligations = mock
				.strings()
				.get();
		newEntity.setConsentOnRightsAndObligations(randomStringforConsentOnRightsAndObligations);
		// % protected region % [Add customisation for Consent On Rights And Obligations here] end
		// % protected region % [Add customisation for Consent On Hospital Regulations here] off begin
		String randomStringforConsentOnHospitalRegulations = mock
				.strings()
				.get();
		newEntity.setConsentOnHospitalRegulations(randomStringforConsentOnHospitalRegulations);
		// % protected region % [Add customisation for Consent On Hospital Regulations here] end
		// % protected region % [Add customisation for Need Interpreter here] off begin
		String randomStringforNeedInterpreter = mock
				.strings()
				.get();
		newEntity.setNeedInterpreter(randomStringforNeedInterpreter);
		// % protected region % [Add customisation for Need Interpreter here] end
		// % protected region % [Add customisation for Need Religious Counselor here] off begin
		String randomStringforNeedReligiousCounselor = mock
				.strings()
				.get();
		newEntity.setNeedReligiousCounselor(randomStringforNeedReligiousCounselor);
		// % protected region % [Add customisation for Need Religious Counselor here] end
		// % protected region % [Add customisation for Dgs Results Released To Insurer here] off begin
		String randomStringforDgsResultsReleasedToInsurer = mock
				.strings()
				.get();
		newEntity.setDgsResultsReleasedToInsurer(randomStringforDgsResultsReleasedToInsurer);
		// % protected region % [Add customisation for Dgs Results Released To Insurer here] end
		// % protected region % [Add customisation for Dgs Results Released To Students here] off begin
		String randomStringforDgsResultsReleasedToStudents = mock
				.strings()
				.get();
		newEntity.setDgsResultsReleasedToStudents(randomStringforDgsResultsReleasedToStudents);
		// % protected region % [Add customisation for Dgs Results Released To Students here] end
		// % protected region % [Add customisation for Record Released To Family Member here] off begin
		String randomStringforRecordReleasedToFamilyMember = mock
				.strings()
				.get();
		newEntity.setRecordReleasedToFamilyMember(randomStringforRecordReleasedToFamilyMember);
		// % protected region % [Add customisation for Record Released To Family Member here] end
		// % protected region % [Add customisation for Record Released To Certain Health Facilities here] off begin
		String randomStringforRecordReleasedToCertainHealthFacilities = mock
				.strings()
				.get();
		newEntity.setRecordReleasedToCertainHealthFacilities(randomStringforRecordReleasedToCertainHealthFacilities);
		// % protected region % [Add customisation for Record Released To Certain Health Facilities here] end
		// % protected region % [Add customisation for Staff Signature here] off begin
		String randomStringforStaffSignature = mock
				.strings()
				.get();
		newEntity.setStaffSignature(randomStringforStaffSignature);
		// % protected region % [Add customisation for Staff Signature here] end
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
		// % protected region % [Add customisation for Read And Sign Satusehat here] off begin
		newEntity.setReadAndSignSatusehat(mock.bools().get());
		// % protected region % [Add customisation for Read And Sign Satusehat here] end
		// % protected region % [Add customisation for Information Released To Satusehat here] off begin
		String randomStringforInformationReleasedToSatusehat = mock
				.strings()
				.get();
		newEntity.setInformationReleasedToSatusehat(randomStringforInformationReleasedToSatusehat);
		// % protected region % [Add customisation for Information Released To Satusehat here] end
		// % protected region % [Add customisation for Emr Released To Satusehat here] off begin
		String randomStringforEmrReleasedToSatusehat = mock
				.strings()
				.get();
		newEntity.setEmrReleasedToSatusehat(randomStringforEmrReleasedToSatusehat);
		// % protected region % [Add customisation for Emr Released To Satusehat here] end

		// % protected region % [Apply any additional logic for patientConsentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentWithNoRef after the main body here] end

		log.trace("Created entity of type PatientConsentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Consent entities with no reference at all.
	 */
	@Provides
	@Named("patientConsentEntitiesWithNoRef")
	public Collection<PatientConsentEntity> patientConsentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientConsentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientConsentEntitiesWithNoRef here] end
		PatientConsentEntityFactory patientConsentEntityFactory
	) {
		log.trace("Creating entities of type PatientConsentEntity with no reference");

		// % protected region % [Apply any additional logic for patientConsentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntitiesWithNoRef before the main body here] end

		Collection<PatientConsentEntity> newEntities = patientConsentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientConsentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientConsentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Consent entity with all references set.
	 */
	@Provides
	@Named("patientConsentEntityWithRefs")
	public PatientConsentEntity patientConsentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientConsentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientConsentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientConsentEntity with references");

		// % protected region % [Apply any additional logic for patientConsentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntityWithRefs before the main body here] end

		PatientConsentEntity patientConsentEntity = injector.getInstance(Key.get(PatientConsentEntity.class, Names.named("patientConsentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientConsentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientConsentEntity with references");

		return patientConsentEntity;
	}

	/**
	 * Return a collection of Patient Consent entities with all references set.
	 */
	@Provides
	@Named("patientConsentEntitiesWithRefs")
	public Collection<PatientConsentEntity> patientConsentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientConsentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientConsentEntitiesWithRefs here] end
		PatientConsentEntityFactory patientConsentEntityFactory
	) {
		log.trace("Creating entities of type PatientConsentEntity with references");

		// % protected region % [Apply any additional logic for patientConsentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntitiesWithRefs before the main body here] end

		Collection<PatientConsentEntity> newEntities = patientConsentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientConsentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientConsentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientConsentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
