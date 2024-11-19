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
 * Guice module for Patient Employment Detail  used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientEmploymentDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientEmploymentDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientEmploymentDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientEmploymentDetailEntityFactory patientEmploymentDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientEmploymentDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientEmploymentDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientEmploymentDetailEntityFactory");

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityFactory before the main body here] end

		PatientEmploymentDetailEntityFactory entityFactory = new PatientEmploymentDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientEmploymentDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientEmploymentDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityFactory after the main body here] end

		log.trace("Created PatientEmploymentDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Employment Detail  entity with no references set.
	 */
	@Provides
	@Named("patientEmploymentDetailEntityWithNoRef")
	public PatientEmploymentDetailEntity patientEmploymentDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientEmploymentDetailEntity with no reference");

		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef before the main body here] end

		PatientEmploymentDetailEntity newEntity = new PatientEmploymentDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Employee ID here] off begin
		String randomStringforEmployeeID = mock
				.strings()
				.get();
		newEntity.setEmployeeID(randomStringforEmployeeID);
		// % protected region % [Add customisation for Employee ID here] end
		// % protected region % [Add customisation for Universal ID here] off begin
		String randomStringforUniversalID = mock
				.strings()
				.get();
		newEntity.setUniversalID(randomStringforUniversalID);
		// % protected region % [Add customisation for Universal ID here] end
		// % protected region % [Add customisation for Employee Type here] off begin
		String randomStringforEmployeeType = mock
				.strings()
				.get();
		newEntity.setEmployeeType(randomStringforEmployeeType);
		// % protected region % [Add customisation for Employee Type here] end
		// % protected region % [Add customisation for Onsite Status here] off begin
		String randomStringforOnsiteStatus = mock
				.strings()
				.get();
		newEntity.setOnsiteStatus(randomStringforOnsiteStatus);
		// % protected region % [Add customisation for Onsite Status here] end
		// % protected region % [Add customisation for Occupational Type here] off begin
		String randomStringforOccupationalType = mock
				.strings()
				.get();
		newEntity.setOccupationalType(randomStringforOccupationalType);
		// % protected region % [Add customisation for Occupational Type here] end
		// % protected region % [Add customisation for Dependant ID here] off begin
		String randomStringforDependantID = mock
				.strings()
				.get();
		newEntity.setDependantID(randomStringforDependantID);
		// % protected region % [Add customisation for Dependant ID here] end
		// % protected region % [Add customisation for Dependant Type here] off begin
		String randomStringforDependantType = mock
				.strings()
				.get();
		newEntity.setDependantType(randomStringforDependantType);
		// % protected region % [Add customisation for Dependant Type here] end
		// % protected region % [Add customisation for Sponsor here] off begin
		String randomStringforSponsor = mock
				.strings()
				.get();
		newEntity.setSponsor(randomStringforSponsor);
		// % protected region % [Add customisation for Sponsor here] end
		// % protected region % [Add customisation for Relationship here] off begin
		String randomStringforRelationship = mock
				.strings()
				.get();
		newEntity.setRelationship(randomStringforRelationship);
		// % protected region % [Add customisation for Relationship here] end
		// % protected region % [Add customisation for Company here] off begin
		String randomStringforCompany = mock
				.strings()
				.get();
		newEntity.setCompany(randomStringforCompany);
		// % protected region % [Add customisation for Company here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringforMedicalStaffCode = mock
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringforMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Department here] off begin
		String randomStringforDepartment = mock
				.strings()
				.get();
		newEntity.setDepartment(randomStringforDepartment);
		// % protected region % [Add customisation for Department here] end
		// % protected region % [Add customisation for Position here] off begin
		String randomStringforPosition = mock
				.strings()
				.get();
		newEntity.setPosition(randomStringforPosition);
		// % protected region % [Add customisation for Position here] end
		// % protected region % [Add customisation for Cost Center here] off begin
		String randomStringforCostCenter = mock
				.strings()
				.get();
		newEntity.setCostCenter(randomStringforCostCenter);
		// % protected region % [Add customisation for Cost Center here] end
		// % protected region % [Add customisation for District here] off begin
		String randomStringforDistrict = mock
				.strings()
				.get();
		newEntity.setDistrict(randomStringforDistrict);
		// % protected region % [Add customisation for District here] end
		// % protected region % [Add customisation for Designated Work Place here] off begin
		String randomStringforDesignatedWorkPlace = mock
				.strings()
				.get();
		newEntity.setDesignatedWorkPlace(randomStringforDesignatedWorkPlace);
		// % protected region % [Add customisation for Designated Work Place here] end
		// % protected region % [Add customisation for Bureau No here] off begin
		String randomStringforBureauNo = mock
				.strings()
				.get();
		newEntity.setBureauNo(randomStringforBureauNo);
		// % protected region % [Add customisation for Bureau No here] end
		// % protected region % [Add customisation for Industry No here] off begin
		String randomStringforIndustryNo = mock
				.strings()
				.get();
		newEntity.setIndustryNo(randomStringforIndustryNo);
		// % protected region % [Add customisation for Industry No here] end
		// % protected region % [Add customisation for Employment Start Date here] off begin
		newEntity.setEmploymentStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Employment Start Date here] end
		// % protected region % [Add customisation for Passport No here] off begin
		String randomStringforPassportNo = mock
				.strings()
				.get();
		newEntity.setPassportNo(randomStringforPassportNo);
		// % protected region % [Add customisation for Passport No here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Passport Country here] off begin
		String randomStringforPassportCountry = mock
				.strings()
				.get();
		newEntity.setPassportCountry(randomStringforPassportCountry);
		// % protected region % [Add customisation for Passport Country here] end
		// % protected region % [Add customisation for Postal Address here] off begin
		String randomStringforPostalAddress = mock
				.strings()
				.get();
		newEntity.setPostalAddress(randomStringforPostalAddress);
		// % protected region % [Add customisation for Postal Address here] end
		// % protected region % [Add customisation for Forwarding Address here] off begin
		String randomStringforForwardingAddress = mock
				.strings()
				.get();
		newEntity.setForwardingAddress(randomStringforForwardingAddress);
		// % protected region % [Add customisation for Forwarding Address here] end
		// % protected region % [Add customisation for Legal DIsability here] off begin
		String randomStringforLegalDIsability = mock
				.strings()
				.get();
		newEntity.setLegalDIsability(randomStringforLegalDIsability);
		// % protected region % [Add customisation for Legal DIsability here] end
		// % protected region % [Add customisation for Legal Disability Notes here] off begin
		String randomStringforLegalDisabilityNotes = mock
				.strings()
				.get();
		newEntity.setLegalDisabilityNotes(randomStringforLegalDisabilityNotes);
		// % protected region % [Add customisation for Legal Disability Notes here] end
		// % protected region % [Add customisation for Worker Insurance here] off begin
		String randomStringforWorkerInsurance = mock
				.strings()
				.get();
		newEntity.setWorkerInsurance(randomStringforWorkerInsurance);
		// % protected region % [Add customisation for Worker Insurance here] end
		// % protected region % [Add customisation for Worker Insurance No here] off begin
		String randomStringforWorkerInsuranceNo = mock
				.strings()
				.get();
		newEntity.setWorkerInsuranceNo(randomStringforWorkerInsuranceNo);
		// % protected region % [Add customisation for Worker Insurance No here] end

		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailWithNoRef after the main body here] end

		log.trace("Created entity of type PatientEmploymentDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Employment Detail  entities with no reference at all.
	 */
	@Provides
	@Named("patientEmploymentDetailEntitiesWithNoRef")
	public Collection<PatientEmploymentDetailEntity> patientEmploymentDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntitiesWithNoRef here] end
		PatientEmploymentDetailEntityFactory patientEmploymentDetailEntityFactory
	) {
		log.trace("Creating entities of type PatientEmploymentDetailEntity with no reference");

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithNoRef before the main body here] end

		Collection<PatientEmploymentDetailEntity> newEntities = patientEmploymentDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientEmploymentDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Employment Detail  entity with all references set.
	 */
	@Provides
	@Named("patientEmploymentDetailEntityWithRefs")
	public PatientEmploymentDetailEntity patientEmploymentDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientEmploymentDetailEntity with references");

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityWithRefs before the main body here] end

		PatientEmploymentDetailEntity patientEmploymentDetailEntity = injector.getInstance(Key.get(PatientEmploymentDetailEntity.class, Names.named("patientEmploymentDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientEmploymentDetailEntity with references");

		return patientEmploymentDetailEntity;
	}

	/**
	 * Return a collection of Patient Employment Detail  entities with all references set.
	 */
	@Provides
	@Named("patientEmploymentDetailEntitiesWithRefs")
	public Collection<PatientEmploymentDetailEntity> patientEmploymentDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientEmploymentDetailEntitiesWithRefs here] end
		PatientEmploymentDetailEntityFactory patientEmploymentDetailEntityFactory
	) {
		log.trace("Creating entities of type PatientEmploymentDetailEntity with references");

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithRefs before the main body here] end

		Collection<PatientEmploymentDetailEntity> newEntities = patientEmploymentDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmploymentDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientEmploymentDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
