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
import kmsweb.entities.ExaminationItemDetailEntity;
import kmsweb.repositories.ExaminationItemDetailRepository;
import kmsweb.utils.ExaminationItemDetailFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDetailDatabasePopulator;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
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
public class ExaminationItemDetailServiceIntegrationTest {

	@Autowired
	private ExaminationItemDetailRepository examinationItemDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ExaminationItemDetailService examinationItemDetailService;

	private final ExaminationItemDetailFactory examinationItemDetailFactory = new ExaminationItemDetailFactory();

	@Autowired
	private ExaminationItemDetailDatabasePopulator examinationItemDetailDatabasePopulator;

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		examinationItemDetailService = new ExaminationItemDetailService(
			examinationItemRepository,
			validator,
			auditRepository,
			examinationItemDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewExaminationItemDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ExaminationItemDetailEntity examinationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);

		ExaminationItemDetailEntity updatedEntity = examinationItemDetailService.updateOldData(examinationItemDetailEntity);
		Assertions.assertEquals(examinationItemDetailEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingExaminationItemDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemDetailEntity examinationItemDetailEntity;
			ExaminationItemDetailEntity entityWithUpdatedValues;

			try {
				examinationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);
				examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = examinationItemDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemDetailEntity = examinationItemDetailService.create(examinationItemDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(examinationItemDetailEntity.getId());

			ExaminationItemDetailEntity updatedEntity = examinationItemDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithExaminationItemDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ExaminationItemDetailEntity examinationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);
		examinationItemDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			examinationItemDetailService.updateOldData(examinationItemDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingExaminationItemDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemDetailEntity examinationItemDetailEntity;
			ExaminationItemDetailEntity updatedExaminationItemDetailEntity;

			ExaminationItemEntity examinationItemEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				examinationItemDetailEntity = examinationItemDetailFactory.getObject(true, false);
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
			examinationItemEntity = examinationItemDetailEntity.getExaminationItem();
			try {
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			examinationItemEntity = examinationItemRepository.save(examinationItemEntity);
			examinationItemDetailEntity.setExaminationItemId(examinationItemEntity.getId());


			examinationItemDetailEntity = examinationItemDetailService.create(examinationItemDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(examinationItemDetailEntity.getExaminationItem());
			examinationItemDetailEntity.setExaminationItemId(null);
			examinationItemDetailEntity.unsetExaminationItem();


			updatedExaminationItemDetailEntity = examinationItemDetailService.updateOldData(examinationItemDetailEntity);

			Assertions.assertNull(updatedExaminationItemDetailEntity.getExaminationItem());

		});
	}

	@Test
	public void updateOldDataWithExaminationItemDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemDetailEntity examinationItemDetailEntity;
			ExaminationItemDetailEntity updatedExaminationItemDetailEntity;

			ExaminationItemEntity examinationItemEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				examinationItemDetailEntity = examinationItemDetailFactory.getObject(true, false);
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
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemDetailEntity.getExaminationItem(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Examination Item relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			examinationItemEntity = examinationItemRepository.findById(examinationItemRepository.save(examinationItemDetailEntity.getExaminationItem()).getId()).get();
			examinationItemDetailEntity.unsetExaminationItem();
			examinationItemDetailEntity.setExaminationItemId(examinationItemEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedExaminationItemDetailEntity = examinationItemDetailService.updateOldData(examinationItemDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			examinationItemEntity.unsetExaminationItemDetails(false);
			updatedExaminationItemDetailEntity.getExaminationItem().unsetExaminationItemDetails(false);
			Assertions.assertEquals(examinationItemEntity, updatedExaminationItemDetailEntity.getExaminationItem());

		});
	}

	@Test
	public void whenCreateExaminationItemDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemDetailEntity examinationItemDetailEntity;
			Optional<ExaminationItemDetailEntity> fetchedExaminationItemDetailEntity;

			try {
				examinationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);
				examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemDetailEntity = examinationItemDetailService.create(examinationItemDetailEntity);

			fetchedExaminationItemDetailEntity = examinationItemDetailService.findById(examinationItemDetailEntity.getId());

			Assertions.assertTrue(fetchedExaminationItemDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedExaminationItemDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(examinationItemDetailEntity, fetchedExaminationItemDetailEntity.get());
		});
	}

	@Test
	public void whenUpdateExaminationItemDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemDetailEntity examinationItemDetailEntity;
			ExaminationItemDetailEntity updatedExaminationItemDetailEntity;
			Optional<ExaminationItemDetailEntity> fetchedExaminationItemDetailEntity;

			try {
				examinationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);
				examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemDetailEntity, true, true, false);
				updatedExaminationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);
				examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedExaminationItemDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemDetailEntity = examinationItemDetailService.create(examinationItemDetailEntity);

			updatedExaminationItemDetailEntity.setId(examinationItemDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedExaminationItemDetailEntity.setCreated(examinationItemDetailEntity.getCreated());

			updatedExaminationItemDetailEntity = examinationItemDetailService.update(updatedExaminationItemDetailEntity);

			fetchedExaminationItemDetailEntity = examinationItemDetailService.findById(examinationItemDetailEntity.getId());

			Assertions.assertTrue(fetchedExaminationItemDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateExaminationItemDetailEntity_ThenEntityIsCreated
			fetchedExaminationItemDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedExaminationItemDetailEntity, fetchedExaminationItemDetailEntity.get());
		});
	}

	@Test
	public void whenDeleteExaminationItemDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemDetailEntity examinationItemDetailEntity;
			Optional<ExaminationItemDetailEntity> fetchedExaminationItemDetailEntity;

			try {
				examinationItemDetailEntity = examinationItemDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemDetailEntity = examinationItemDetailService.create(examinationItemDetailEntity);

			examinationItemDetailService.deleteById(examinationItemDetailEntity.getId());
			fetchedExaminationItemDetailEntity = examinationItemDetailService.findById(examinationItemDetailEntity.getId());

			Assertions.assertTrue(fetchedExaminationItemDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
