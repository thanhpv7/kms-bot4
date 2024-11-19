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
import kmsweb.entities.BpjsPcareKunjunganRujukanEntity;
import kmsweb.repositories.BpjsPcareKunjunganRujukanRepository;
import kmsweb.utils.BpjsPcareKunjunganRujukanFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcareKunjunganRujukanDatabasePopulator;
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
public class BpjsPcareKunjunganRujukanServiceIntegrationTest {

	@Autowired
	private BpjsPcareKunjunganRujukanRepository bpjsPcareKunjunganRujukanRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsPcareKunjunganRujukanService bpjsPcareKunjunganRujukanService;

	private final BpjsPcareKunjunganRujukanFactory bpjsPcareKunjunganRujukanFactory = new BpjsPcareKunjunganRujukanFactory();

	@Autowired
	private BpjsPcareKunjunganRujukanDatabasePopulator bpjsPcareKunjunganRujukanDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsPcareKunjunganRujukanService = new BpjsPcareKunjunganRujukanService(
			validator,
			auditRepository,
			bpjsPcareKunjunganRujukanRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsPcareKunjunganRujukanEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);

		BpjsPcareKunjunganRujukanEntity updatedEntity = bpjsPcareKunjunganRujukanService.updateOldData(bpjsPcareKunjunganRujukanEntity);
		Assertions.assertEquals(bpjsPcareKunjunganRujukanEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsPcareKunjunganRujukanEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity;
			BpjsPcareKunjunganRujukanEntity entityWithUpdatedValues;

			try {
				bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
				bpjsPcareKunjunganRujukanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareKunjunganRujukanEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.create(bpjsPcareKunjunganRujukanEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsPcareKunjunganRujukanEntity.getId());

			BpjsPcareKunjunganRujukanEntity updatedEntity = bpjsPcareKunjunganRujukanService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsPcareKunjunganRujukanEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
		bpjsPcareKunjunganRujukanEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsPcareKunjunganRujukanService.updateOldData(bpjsPcareKunjunganRujukanEntity);
		});
	}

	@Test
	public void whenCreateBpjsPcareKunjunganRujukanEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity;
			Optional<BpjsPcareKunjunganRujukanEntity> fetchedBpjsPcareKunjunganRujukanEntity;

			try {
				bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
				bpjsPcareKunjunganRujukanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareKunjunganRujukanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.create(bpjsPcareKunjunganRujukanEntity);

			fetchedBpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.findById(bpjsPcareKunjunganRujukanEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcareKunjunganRujukanEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsPcareKunjunganRujukanEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsPcareKunjunganRujukanEntity, fetchedBpjsPcareKunjunganRujukanEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsPcareKunjunganRujukanEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity;
			BpjsPcareKunjunganRujukanEntity updatedBpjsPcareKunjunganRujukanEntity;
			Optional<BpjsPcareKunjunganRujukanEntity> fetchedBpjsPcareKunjunganRujukanEntity;

			try {
				bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
				bpjsPcareKunjunganRujukanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareKunjunganRujukanEntity, true, true, false);
				updatedBpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
				bpjsPcareKunjunganRujukanDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsPcareKunjunganRujukanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.create(bpjsPcareKunjunganRujukanEntity);

			updatedBpjsPcareKunjunganRujukanEntity.setId(bpjsPcareKunjunganRujukanEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsPcareKunjunganRujukanEntity.setCreated(bpjsPcareKunjunganRujukanEntity.getCreated());

			updatedBpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.update(updatedBpjsPcareKunjunganRujukanEntity);

			fetchedBpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.findById(bpjsPcareKunjunganRujukanEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcareKunjunganRujukanEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsPcareKunjunganRujukanEntity_ThenEntityIsCreated
			fetchedBpjsPcareKunjunganRujukanEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsPcareKunjunganRujukanEntity, fetchedBpjsPcareKunjunganRujukanEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsPcareKunjunganRujukanEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareKunjunganRujukanEntity bpjsPcareKunjunganRujukanEntity;
			Optional<BpjsPcareKunjunganRujukanEntity> fetchedBpjsPcareKunjunganRujukanEntity;

			try {
				bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsPcareKunjunganRujukanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareKunjunganRujukanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.create(bpjsPcareKunjunganRujukanEntity);

			bpjsPcareKunjunganRujukanService.deleteById(bpjsPcareKunjunganRujukanEntity.getId());
			fetchedBpjsPcareKunjunganRujukanEntity = bpjsPcareKunjunganRujukanService.findById(bpjsPcareKunjunganRujukanEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcareKunjunganRujukanEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
