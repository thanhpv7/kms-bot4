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

package kmsweb.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;
import kmsweb.SpringTestConfiguration;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.utils.InformedConsentFactory;
import kmsweb.utils.DatabasePopulators.InformedConsentDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.repositories.auditing.AuditingRepository;

import javax.validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
// % protected region % [Add any additional class annotations here] off begin
// % protected region % [Add any additional class annotations here] end
public class InformedConsentServiceIntegrationTest {

	@Autowired
	private InformedConsentRepository informedConsentRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InformedConsentService informedConsentService;

	private final InformedConsentFactory informedConsentFactory = new InformedConsentFactory();

	@Autowired
	private InformedConsentDatabasePopulator informedConsentDatabasePopulator;

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		informedConsentService = new InformedConsentService(
			patientGeneralInfoRepository,
			registrationRepository,
			staffRepository,
			validator,
			auditRepository,
			informedConsentRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInformedConsentEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InformedConsentEntity informedConsentEntity = informedConsentFactory.getObject(false, false);

		InformedConsentEntity updatedEntity = informedConsentService.updateOldData(informedConsentEntity);
		Assertions.assertEquals(informedConsentEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInformedConsentEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InformedConsentEntity informedConsentEntity;
			InformedConsentEntity entityWithUpdatedValues;

			try {
				informedConsentEntity = informedConsentFactory.getObject(false, false);
				informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = informedConsentFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			informedConsentEntity = informedConsentService.create(informedConsentEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(informedConsentEntity.getId());

			InformedConsentEntity updatedEntity = informedConsentService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInformedConsentEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InformedConsentEntity informedConsentEntity = informedConsentFactory.getObject(false, false);
		informedConsentEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			informedConsentService.updateOldData(informedConsentEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInformedConsentEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InformedConsentEntity informedConsentEntity;
			InformedConsentEntity updatedInformedConsentEntity;

			StaffEntity accompanyingStaffEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			RegistrationEntity registrationEntity;

			StaffEntity informingStaffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				informedConsentEntity = informedConsentFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				As this test is checking that removing a reference entity works, we need to add the
				reference entities to the database
			 */
			accompanyingStaffEntity = informedConsentEntity.getAccompanyingStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(accompanyingStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			accompanyingStaffEntity = staffRepository.save(accompanyingStaffEntity);
			informedConsentEntity.setAccompanyingStaffId(accompanyingStaffEntity.getId());

			patientGeneralInfoEntity = informedConsentEntity.getPatientGeneralInfo();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientGeneralInfoEntity = patientGeneralInfoRepository.save(patientGeneralInfoEntity);
			informedConsentEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			registrationEntity = informedConsentEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			informedConsentEntity.setRegistrationId(registrationEntity.getId());

			informingStaffEntity = informedConsentEntity.getInformingStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(informingStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			informingStaffEntity = staffRepository.save(informingStaffEntity);
			informedConsentEntity.setInformingStaffId(informingStaffEntity.getId());


			informedConsentEntity = informedConsentService.create(informedConsentEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(informedConsentEntity.getAccompanyingStaff());
			informedConsentEntity.setAccompanyingStaffId(null);
			informedConsentEntity.unsetAccompanyingStaff();

			Assertions.assertNotNull(informedConsentEntity.getPatientGeneralInfo());
			informedConsentEntity.setPatientGeneralInfoId(null);
			informedConsentEntity.unsetPatientGeneralInfo();

			Assertions.assertNotNull(informedConsentEntity.getRegistration());
			informedConsentEntity.setRegistrationId(null);
			informedConsentEntity.unsetRegistration();

			Assertions.assertNotNull(informedConsentEntity.getInformingStaff());
			informedConsentEntity.setInformingStaffId(null);
			informedConsentEntity.unsetInformingStaff();


			updatedInformedConsentEntity = informedConsentService.updateOldData(informedConsentEntity);

			Assertions.assertNull(updatedInformedConsentEntity.getAccompanyingStaff());

			Assertions.assertNull(updatedInformedConsentEntity.getPatientGeneralInfo());

			Assertions.assertNull(updatedInformedConsentEntity.getRegistration());

			Assertions.assertNull(updatedInformedConsentEntity.getInformingStaff());

		});
	}

	@Test
	public void updateOldDataWithInformedConsentEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InformedConsentEntity informedConsentEntity;
			InformedConsentEntity updatedInformedConsentEntity;

			StaffEntity accompanyingStaffEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			RegistrationEntity registrationEntity;

			StaffEntity informingStaffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				informedConsentEntity = informedConsentFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				Expected state of the entity prior to updateOldData when trying to add a reference
				is that the reference id is set, but the reference entity is not set.  Therefore,
				we need to remove the reference entity and set the reference id, as this will set up
				the state we expect to see for this test.

				We also need to populate the required relations for all related entities, as creating any entities
				with required references will cause an error (and a subsequent test failure) if we do not
			 */
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity.getAccompanyingStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Accompanying Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			accompanyingStaffEntity = staffRepository.findById(staffRepository.save(informedConsentEntity.getAccompanyingStaff()).getId()).get();
			informedConsentEntity.unsetAccompanyingStaff();
			informedConsentEntity.setAccompanyingStaffId(accompanyingStaffEntity.getId());

			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity.getPatientGeneralInfo(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient General Info relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientGeneralInfoEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(informedConsentEntity.getPatientGeneralInfo()).getId()).get();
			informedConsentEntity.unsetPatientGeneralInfo();
			informedConsentEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(informedConsentEntity.getRegistration()).getId()).get();
			informedConsentEntity.unsetRegistration();
			informedConsentEntity.setRegistrationId(registrationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity.getInformingStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Informing Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			informingStaffEntity = staffRepository.findById(staffRepository.save(informedConsentEntity.getInformingStaff()).getId()).get();
			informedConsentEntity.unsetInformingStaff();
			informedConsentEntity.setInformingStaffId(informingStaffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInformedConsentEntity = informedConsentService.updateOldData(informedConsentEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			accompanyingStaffEntity.unsetAccompanyingConsents(false);
			updatedInformedConsentEntity.getAccompanyingStaff().unsetAccompanyingConsents(false);
			Assertions.assertEquals(accompanyingStaffEntity, updatedInformedConsentEntity.getAccompanyingStaff());

			patientGeneralInfoEntity.unsetInformedConsents(false);
			updatedInformedConsentEntity.getPatientGeneralInfo().unsetInformedConsents(false);
			Assertions.assertEquals(patientGeneralInfoEntity, updatedInformedConsentEntity.getPatientGeneralInfo());

			registrationEntity.unsetInformedConsents(false);
			updatedInformedConsentEntity.getRegistration().unsetInformedConsents(false);
			Assertions.assertEquals(registrationEntity, updatedInformedConsentEntity.getRegistration());

			informingStaffEntity.unsetInformingConsents(false);
			updatedInformedConsentEntity.getInformingStaff().unsetInformingConsents(false);
			Assertions.assertEquals(informingStaffEntity, updatedInformedConsentEntity.getInformingStaff());

		});
	}

	@Test
	public void whenCreateInformedConsentEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InformedConsentEntity informedConsentEntity;
			Optional<InformedConsentEntity> fetchedInformedConsentEntity;

			try {
				informedConsentEntity = informedConsentFactory.getObject(false, false);
				informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			informedConsentEntity = informedConsentService.create(informedConsentEntity);

			fetchedInformedConsentEntity = informedConsentService.findById(informedConsentEntity.getId());

			Assertions.assertTrue(fetchedInformedConsentEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInformedConsentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(informedConsentEntity, fetchedInformedConsentEntity.get());
		});
	}

	@Test
	public void whenUpdateInformedConsentEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InformedConsentEntity informedConsentEntity;
			InformedConsentEntity updatedInformedConsentEntity;
			Optional<InformedConsentEntity> fetchedInformedConsentEntity;

			try {
				informedConsentEntity = informedConsentFactory.getObject(false, false);
				informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity, true, true, false);
				updatedInformedConsentEntity = informedConsentFactory.getObject(false, false);
				informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInformedConsentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			informedConsentEntity = informedConsentService.create(informedConsentEntity);

			updatedInformedConsentEntity.setId(informedConsentEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInformedConsentEntity.setCreated(informedConsentEntity.getCreated());

			updatedInformedConsentEntity = informedConsentService.update(updatedInformedConsentEntity);

			fetchedInformedConsentEntity = informedConsentService.findById(informedConsentEntity.getId());

			Assertions.assertTrue(fetchedInformedConsentEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInformedConsentEntity_ThenEntityIsCreated
			fetchedInformedConsentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInformedConsentEntity, fetchedInformedConsentEntity.get());
		});
	}

	@Test
	public void whenDeleteInformedConsentEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InformedConsentEntity informedConsentEntity;
			Optional<InformedConsentEntity> fetchedInformedConsentEntity;

			try {
				informedConsentEntity = informedConsentFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(informedConsentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			informedConsentEntity = informedConsentService.create(informedConsentEntity);

			informedConsentService.deleteById(informedConsentEntity.getId());
			fetchedInformedConsentEntity = informedConsentService.findById(informedConsentEntity.getId());

			Assertions.assertTrue(fetchedInformedConsentEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
