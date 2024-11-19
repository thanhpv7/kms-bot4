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
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.repositories.SampleCollectionItemsRepository;
import kmsweb.utils.SampleCollectionItemsFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionItemsDatabasePopulator;
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.repositories.SampleCollectionInformationRepository;
import kmsweb.utils.SampleCollectionInformationFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionInformationDatabasePopulator;
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
public class SampleCollectionItemsServiceIntegrationTest {

	@Autowired
	private SampleCollectionItemsRepository sampleCollectionItemsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private SampleCollectionItemsService sampleCollectionItemsService;

	private final SampleCollectionItemsFactory sampleCollectionItemsFactory = new SampleCollectionItemsFactory();

	@Autowired
	private SampleCollectionItemsDatabasePopulator sampleCollectionItemsDatabasePopulator;

	@Autowired
	private SampleCollectionInformationRepository sampleCollectionInformationRepository;

	@Autowired
	private SampleCollectionInformationDatabasePopulator sampleCollectionInformationDatabasePopulator;

	private final SampleCollectionInformationFactory sampleCollectionInformationFactory = new SampleCollectionInformationFactory();

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
		sampleCollectionItemsService = new SampleCollectionItemsService(
			sampleCollectionInformationRepository,
			staffRepository,
			validator,
			auditRepository,
			sampleCollectionItemsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewSampleCollectionItemsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		SampleCollectionItemsEntity sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);

		SampleCollectionItemsEntity updatedEntity = sampleCollectionItemsService.updateOldData(sampleCollectionItemsEntity);
		Assertions.assertEquals(sampleCollectionItemsEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingSampleCollectionItemsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionItemsEntity sampleCollectionItemsEntity;
			SampleCollectionItemsEntity entityWithUpdatedValues;

			try {
				sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);
				sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = sampleCollectionItemsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionItemsEntity = sampleCollectionItemsService.create(sampleCollectionItemsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(sampleCollectionItemsEntity.getId());

			SampleCollectionItemsEntity updatedEntity = sampleCollectionItemsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithSampleCollectionItemsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		SampleCollectionItemsEntity sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);
		sampleCollectionItemsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			sampleCollectionItemsService.updateOldData(sampleCollectionItemsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingSampleCollectionItemsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionItemsEntity sampleCollectionItemsEntity;
			SampleCollectionItemsEntity updatedSampleCollectionItemsEntity;

			SampleCollectionInformationEntity sampleCollectionInformationEntity;

			StaffEntity sampleCollectionStaffEntity;

			StaffEntity sampleDeliveryStaffEntity;

			StaffEntity sampleProcessingStaffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(true, false);
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
			sampleCollectionInformationEntity = sampleCollectionItemsEntity.getSampleCollectionInformation();
			try {
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sampleCollectionInformationEntity = sampleCollectionInformationRepository.save(sampleCollectionInformationEntity);
			sampleCollectionItemsEntity.setSampleCollectionInformationId(sampleCollectionInformationEntity.getId());

			sampleCollectionStaffEntity = sampleCollectionItemsEntity.getSampleCollectionStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sampleCollectionStaffEntity = staffRepository.save(sampleCollectionStaffEntity);
			sampleCollectionItemsEntity.setSampleCollectionStaffId(sampleCollectionStaffEntity.getId());

			sampleDeliveryStaffEntity = sampleCollectionItemsEntity.getSampleDeliveryStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(sampleDeliveryStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sampleDeliveryStaffEntity = staffRepository.save(sampleDeliveryStaffEntity);
			sampleCollectionItemsEntity.setSampleDeliveryStaffId(sampleDeliveryStaffEntity.getId());

			sampleProcessingStaffEntity = sampleCollectionItemsEntity.getSampleProcessingStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(sampleProcessingStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sampleProcessingStaffEntity = staffRepository.save(sampleProcessingStaffEntity);
			sampleCollectionItemsEntity.setSampleProcessingStaffId(sampleProcessingStaffEntity.getId());


			sampleCollectionItemsEntity = sampleCollectionItemsService.create(sampleCollectionItemsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(sampleCollectionItemsEntity.getSampleCollectionInformation());
			sampleCollectionItemsEntity.setSampleCollectionInformationId(null);
			sampleCollectionItemsEntity.unsetSampleCollectionInformation();

			Assertions.assertNotNull(sampleCollectionItemsEntity.getSampleCollectionStaff());
			sampleCollectionItemsEntity.setSampleCollectionStaffId(null);
			sampleCollectionItemsEntity.unsetSampleCollectionStaff();

			Assertions.assertNotNull(sampleCollectionItemsEntity.getSampleDeliveryStaff());
			sampleCollectionItemsEntity.setSampleDeliveryStaffId(null);
			sampleCollectionItemsEntity.unsetSampleDeliveryStaff();

			Assertions.assertNotNull(sampleCollectionItemsEntity.getSampleProcessingStaff());
			sampleCollectionItemsEntity.setSampleProcessingStaffId(null);
			sampleCollectionItemsEntity.unsetSampleProcessingStaff();


			updatedSampleCollectionItemsEntity = sampleCollectionItemsService.updateOldData(sampleCollectionItemsEntity);

			Assertions.assertNull(updatedSampleCollectionItemsEntity.getSampleCollectionInformation());

			Assertions.assertNull(updatedSampleCollectionItemsEntity.getSampleCollectionStaff());

			Assertions.assertNull(updatedSampleCollectionItemsEntity.getSampleDeliveryStaff());

			Assertions.assertNull(updatedSampleCollectionItemsEntity.getSampleProcessingStaff());

		});
	}

	@Test
	public void updateOldDataWithSampleCollectionItemsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionItemsEntity sampleCollectionItemsEntity;
			SampleCollectionItemsEntity updatedSampleCollectionItemsEntity;

			SampleCollectionInformationEntity sampleCollectionInformationEntity;

			StaffEntity sampleCollectionStaffEntity;

			StaffEntity sampleDeliveryStaffEntity;

			StaffEntity sampleProcessingStaffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(true, false);
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
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity.getSampleCollectionInformation(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Sample Collection Information relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sampleCollectionInformationEntity = sampleCollectionInformationRepository.findById(sampleCollectionInformationRepository.save(sampleCollectionItemsEntity.getSampleCollectionInformation()).getId()).get();
			sampleCollectionItemsEntity.unsetSampleCollectionInformation();
			sampleCollectionItemsEntity.setSampleCollectionInformationId(sampleCollectionInformationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity.getSampleCollectionStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Sample Collection Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sampleCollectionStaffEntity = staffRepository.findById(staffRepository.save(sampleCollectionItemsEntity.getSampleCollectionStaff()).getId()).get();
			sampleCollectionItemsEntity.unsetSampleCollectionStaff();
			sampleCollectionItemsEntity.setSampleCollectionStaffId(sampleCollectionStaffEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity.getSampleDeliveryStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Sample Delivery Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sampleDeliveryStaffEntity = staffRepository.findById(staffRepository.save(sampleCollectionItemsEntity.getSampleDeliveryStaff()).getId()).get();
			sampleCollectionItemsEntity.unsetSampleDeliveryStaff();
			sampleCollectionItemsEntity.setSampleDeliveryStaffId(sampleDeliveryStaffEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity.getSampleProcessingStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Sample Processing Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sampleProcessingStaffEntity = staffRepository.findById(staffRepository.save(sampleCollectionItemsEntity.getSampleProcessingStaff()).getId()).get();
			sampleCollectionItemsEntity.unsetSampleProcessingStaff();
			sampleCollectionItemsEntity.setSampleProcessingStaffId(sampleProcessingStaffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedSampleCollectionItemsEntity = sampleCollectionItemsService.updateOldData(sampleCollectionItemsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			sampleCollectionInformationEntity.unsetSampleCollectionItems(false);
			updatedSampleCollectionItemsEntity.getSampleCollectionInformation().unsetSampleCollectionItems(false);
			Assertions.assertEquals(sampleCollectionInformationEntity, updatedSampleCollectionItemsEntity.getSampleCollectionInformation());

			sampleCollectionStaffEntity.unsetSampleCollectionStaffs(false);
			updatedSampleCollectionItemsEntity.getSampleCollectionStaff().unsetSampleCollectionStaffs(false);
			Assertions.assertEquals(sampleCollectionStaffEntity, updatedSampleCollectionItemsEntity.getSampleCollectionStaff());

			sampleDeliveryStaffEntity.unsetSampleDeliveryStaffs(false);
			updatedSampleCollectionItemsEntity.getSampleDeliveryStaff().unsetSampleDeliveryStaffs(false);
			Assertions.assertEquals(sampleDeliveryStaffEntity, updatedSampleCollectionItemsEntity.getSampleDeliveryStaff());

			sampleProcessingStaffEntity.unsetSampleProcessingStaffs(false);
			updatedSampleCollectionItemsEntity.getSampleProcessingStaff().unsetSampleProcessingStaffs(false);
			Assertions.assertEquals(sampleProcessingStaffEntity, updatedSampleCollectionItemsEntity.getSampleProcessingStaff());

		});
	}

	@Test
	public void whenCreateSampleCollectionItemsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionItemsEntity sampleCollectionItemsEntity;
			Optional<SampleCollectionItemsEntity> fetchedSampleCollectionItemsEntity;

			try {
				sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);
				sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionItemsEntity = sampleCollectionItemsService.create(sampleCollectionItemsEntity);

			fetchedSampleCollectionItemsEntity = sampleCollectionItemsService.findById(sampleCollectionItemsEntity.getId());

			Assertions.assertTrue(fetchedSampleCollectionItemsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedSampleCollectionItemsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(sampleCollectionItemsEntity, fetchedSampleCollectionItemsEntity.get());
		});
	}

	@Test
	public void whenUpdateSampleCollectionItemsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionItemsEntity sampleCollectionItemsEntity;
			SampleCollectionItemsEntity updatedSampleCollectionItemsEntity;
			Optional<SampleCollectionItemsEntity> fetchedSampleCollectionItemsEntity;

			try {
				sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);
				sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity, true, true, false);
				updatedSampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);
				sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedSampleCollectionItemsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionItemsEntity = sampleCollectionItemsService.create(sampleCollectionItemsEntity);

			updatedSampleCollectionItemsEntity.setId(sampleCollectionItemsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedSampleCollectionItemsEntity.setCreated(sampleCollectionItemsEntity.getCreated());

			updatedSampleCollectionItemsEntity = sampleCollectionItemsService.update(updatedSampleCollectionItemsEntity);

			fetchedSampleCollectionItemsEntity = sampleCollectionItemsService.findById(sampleCollectionItemsEntity.getId());

			Assertions.assertTrue(fetchedSampleCollectionItemsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateSampleCollectionItemsEntity_ThenEntityIsCreated
			fetchedSampleCollectionItemsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedSampleCollectionItemsEntity, fetchedSampleCollectionItemsEntity.get());
		});
	}

	@Test
	public void whenDeleteSampleCollectionItemsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionItemsEntity sampleCollectionItemsEntity;
			Optional<SampleCollectionItemsEntity> fetchedSampleCollectionItemsEntity;

			try {
				sampleCollectionItemsEntity = sampleCollectionItemsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionItemsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionItemsEntity = sampleCollectionItemsService.create(sampleCollectionItemsEntity);

			sampleCollectionItemsService.deleteById(sampleCollectionItemsEntity.getId());
			fetchedSampleCollectionItemsEntity = sampleCollectionItemsService.findById(sampleCollectionItemsEntity.getId());

			Assertions.assertTrue(fetchedSampleCollectionItemsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
