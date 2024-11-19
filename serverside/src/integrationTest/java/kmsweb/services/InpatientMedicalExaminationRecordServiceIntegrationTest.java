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
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import kmsweb.repositories.InpatientMedicalExaminationRecordRepository;
import kmsweb.utils.InpatientMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.InpatientMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
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
public class InpatientMedicalExaminationRecordServiceIntegrationTest {

	@Autowired
	private InpatientMedicalExaminationRecordRepository inpatientMedicalExaminationRecordRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InpatientMedicalExaminationRecordService inpatientMedicalExaminationRecordService;

	private final InpatientMedicalExaminationRecordFactory inpatientMedicalExaminationRecordFactory = new InpatientMedicalExaminationRecordFactory();

	@Autowired
	private InpatientMedicalExaminationRecordDatabasePopulator inpatientMedicalExaminationRecordDatabasePopulator;

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		inpatientMedicalExaminationRecordService = new InpatientMedicalExaminationRecordService(
			bedFacilityRepository,
			medicalExaminationRecordRepository,
			validator,
			auditRepository,
			inpatientMedicalExaminationRecordRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInpatientMedicalExaminationRecordEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);

		InpatientMedicalExaminationRecordEntity updatedEntity = inpatientMedicalExaminationRecordService.updateOldData(inpatientMedicalExaminationRecordEntity);
		Assertions.assertEquals(inpatientMedicalExaminationRecordEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInpatientMedicalExaminationRecordEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;
			InpatientMedicalExaminationRecordEntity entityWithUpdatedValues;

			try {
				inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = inpatientMedicalExaminationRecordFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.create(inpatientMedicalExaminationRecordEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(inpatientMedicalExaminationRecordEntity.getId());

			InpatientMedicalExaminationRecordEntity updatedEntity = inpatientMedicalExaminationRecordService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInpatientMedicalExaminationRecordEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);
		inpatientMedicalExaminationRecordEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			inpatientMedicalExaminationRecordService.updateOldData(inpatientMedicalExaminationRecordEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInpatientMedicalExaminationRecordEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;
			InpatientMedicalExaminationRecordEntity updatedInpatientMedicalExaminationRecordEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			BedFacilityEntity bedFacilityEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = inpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			inpatientMedicalExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			bedFacilityEntity = inpatientMedicalExaminationRecordEntity.getBedFacility();
			try {
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bedFacilityEntity = bedFacilityRepository.save(bedFacilityEntity);
			inpatientMedicalExaminationRecordEntity.setBedFacilityId(bedFacilityEntity.getId());


			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.create(inpatientMedicalExaminationRecordEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(inpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord());
			inpatientMedicalExaminationRecordEntity.setMedicalExaminationRecordId(null);
			inpatientMedicalExaminationRecordEntity.unsetMedicalExaminationRecord();

			Assertions.assertNotNull(inpatientMedicalExaminationRecordEntity.getBedFacility());
			inpatientMedicalExaminationRecordEntity.setBedFacilityId(null);
			inpatientMedicalExaminationRecordEntity.unsetBedFacility();


			updatedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.updateOldData(inpatientMedicalExaminationRecordEntity);

			Assertions.assertNull(updatedInpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord());

			Assertions.assertNull(updatedInpatientMedicalExaminationRecordEntity.getBedFacility());

		});
	}

	@Test
	public void updateOldDataWithInpatientMedicalExaminationRecordEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;
			InpatientMedicalExaminationRecordEntity updatedInpatientMedicalExaminationRecordEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			BedFacilityEntity bedFacilityEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(inpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord()).getId()).get();
			inpatientMedicalExaminationRecordEntity.unsetMedicalExaminationRecord();
			inpatientMedicalExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			try {
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity.getBedFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Bed Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bedFacilityEntity = bedFacilityRepository.findById(bedFacilityRepository.save(inpatientMedicalExaminationRecordEntity.getBedFacility()).getId()).get();
			inpatientMedicalExaminationRecordEntity.unsetBedFacility();
			inpatientMedicalExaminationRecordEntity.setBedFacilityId(bedFacilityEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.updateOldData(inpatientMedicalExaminationRecordEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetInpatientMedicalExaminationRecord(false);
			updatedInpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord().unsetInpatientMedicalExaminationRecord(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedInpatientMedicalExaminationRecordEntity.getMedicalExaminationRecord());

			bedFacilityEntity.unsetInpatientMedicalExaminationRecords(false);
			updatedInpatientMedicalExaminationRecordEntity.getBedFacility().unsetInpatientMedicalExaminationRecords(false);
			Assertions.assertEquals(bedFacilityEntity, updatedInpatientMedicalExaminationRecordEntity.getBedFacility());

		});
	}

	@Test
	public void whenCreateInpatientMedicalExaminationRecordEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;
			Optional<InpatientMedicalExaminationRecordEntity> fetchedInpatientMedicalExaminationRecordEntity;

			try {
				inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.create(inpatientMedicalExaminationRecordEntity);

			fetchedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.findById(inpatientMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedInpatientMedicalExaminationRecordEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInpatientMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(inpatientMedicalExaminationRecordEntity, fetchedInpatientMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenUpdateInpatientMedicalExaminationRecordEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;
			InpatientMedicalExaminationRecordEntity updatedInpatientMedicalExaminationRecordEntity;
			Optional<InpatientMedicalExaminationRecordEntity> fetchedInpatientMedicalExaminationRecordEntity;

			try {
				inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity, true, true, false);
				updatedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInpatientMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.create(inpatientMedicalExaminationRecordEntity);

			updatedInpatientMedicalExaminationRecordEntity.setId(inpatientMedicalExaminationRecordEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInpatientMedicalExaminationRecordEntity.setCreated(inpatientMedicalExaminationRecordEntity.getCreated());

			updatedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.update(updatedInpatientMedicalExaminationRecordEntity);

			fetchedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.findById(inpatientMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedInpatientMedicalExaminationRecordEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInpatientMedicalExaminationRecordEntity_ThenEntityIsCreated
			fetchedInpatientMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInpatientMedicalExaminationRecordEntity, fetchedInpatientMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenDeleteInpatientMedicalExaminationRecordEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;
			Optional<InpatientMedicalExaminationRecordEntity> fetchedInpatientMedicalExaminationRecordEntity;

			try {
				inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.create(inpatientMedicalExaminationRecordEntity);

			inpatientMedicalExaminationRecordService.deleteById(inpatientMedicalExaminationRecordEntity.getId());
			fetchedInpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordService.findById(inpatientMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedInpatientMedicalExaminationRecordEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
