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
import kmsweb.entities.BpjsTreatmentHistoryEntity;
import kmsweb.repositories.BpjsTreatmentHistoryRepository;
import kmsweb.utils.BpjsTreatmentHistoryFactory;
import kmsweb.utils.DatabasePopulators.BpjsTreatmentHistoryDatabasePopulator;
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
public class BpjsTreatmentHistoryServiceIntegrationTest {

	@Autowired
	private BpjsTreatmentHistoryRepository bpjsTreatmentHistoryRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsTreatmentHistoryService bpjsTreatmentHistoryService;

	private final BpjsTreatmentHistoryFactory bpjsTreatmentHistoryFactory = new BpjsTreatmentHistoryFactory();

	@Autowired
	private BpjsTreatmentHistoryDatabasePopulator bpjsTreatmentHistoryDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsTreatmentHistoryService = new BpjsTreatmentHistoryService(
			validator,
			auditRepository,
			bpjsTreatmentHistoryRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsTreatmentHistoryEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);

		BpjsTreatmentHistoryEntity updatedEntity = bpjsTreatmentHistoryService.updateOldData(bpjsTreatmentHistoryEntity);
		Assertions.assertEquals(bpjsTreatmentHistoryEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsTreatmentHistoryEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity;
			BpjsTreatmentHistoryEntity entityWithUpdatedValues;

			try {
				bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);
				bpjsTreatmentHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsTreatmentHistoryEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsTreatmentHistoryFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.create(bpjsTreatmentHistoryEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsTreatmentHistoryEntity.getId());

			BpjsTreatmentHistoryEntity updatedEntity = bpjsTreatmentHistoryService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsTreatmentHistoryEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);
		bpjsTreatmentHistoryEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsTreatmentHistoryService.updateOldData(bpjsTreatmentHistoryEntity);
		});
	}

	@Test
	public void whenCreateBpjsTreatmentHistoryEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity;
			Optional<BpjsTreatmentHistoryEntity> fetchedBpjsTreatmentHistoryEntity;

			try {
				bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);
				bpjsTreatmentHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsTreatmentHistoryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.create(bpjsTreatmentHistoryEntity);

			fetchedBpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.findById(bpjsTreatmentHistoryEntity.getId());

			Assertions.assertTrue(fetchedBpjsTreatmentHistoryEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsTreatmentHistoryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsTreatmentHistoryEntity, fetchedBpjsTreatmentHistoryEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsTreatmentHistoryEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity;
			BpjsTreatmentHistoryEntity updatedBpjsTreatmentHistoryEntity;
			Optional<BpjsTreatmentHistoryEntity> fetchedBpjsTreatmentHistoryEntity;

			try {
				bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);
				bpjsTreatmentHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsTreatmentHistoryEntity, true, true, false);
				updatedBpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);
				bpjsTreatmentHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsTreatmentHistoryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.create(bpjsTreatmentHistoryEntity);

			updatedBpjsTreatmentHistoryEntity.setId(bpjsTreatmentHistoryEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsTreatmentHistoryEntity.setCreated(bpjsTreatmentHistoryEntity.getCreated());

			updatedBpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.update(updatedBpjsTreatmentHistoryEntity);

			fetchedBpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.findById(bpjsTreatmentHistoryEntity.getId());

			Assertions.assertTrue(fetchedBpjsTreatmentHistoryEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsTreatmentHistoryEntity_ThenEntityIsCreated
			fetchedBpjsTreatmentHistoryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsTreatmentHistoryEntity, fetchedBpjsTreatmentHistoryEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsTreatmentHistoryEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity;
			Optional<BpjsTreatmentHistoryEntity> fetchedBpjsTreatmentHistoryEntity;

			try {
				bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsTreatmentHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsTreatmentHistoryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.create(bpjsTreatmentHistoryEntity);

			bpjsTreatmentHistoryService.deleteById(bpjsTreatmentHistoryEntity.getId());
			fetchedBpjsTreatmentHistoryEntity = bpjsTreatmentHistoryService.findById(bpjsTreatmentHistoryEntity.getId());

			Assertions.assertTrue(fetchedBpjsTreatmentHistoryEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}