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
import kmsweb.entities.BpjsSEPINACBGIntegrationEntity;
import kmsweb.repositories.BpjsSEPINACBGIntegrationRepository;
import kmsweb.utils.BpjsSEPINACBGIntegrationFactory;
import kmsweb.utils.DatabasePopulators.BpjsSEPINACBGIntegrationDatabasePopulator;
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
public class BpjsSEPINACBGIntegrationServiceIntegrationTest {

	@Autowired
	private BpjsSEPINACBGIntegrationRepository bpjsSEPINACBGIntegrationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsSEPINACBGIntegrationService bpjsSEPINACBGIntegrationService;

	private final BpjsSEPINACBGIntegrationFactory bpjsSEPINACBGIntegrationFactory = new BpjsSEPINACBGIntegrationFactory();

	@Autowired
	private BpjsSEPINACBGIntegrationDatabasePopulator bpjsSEPINACBGIntegrationDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsSEPINACBGIntegrationService = new BpjsSEPINACBGIntegrationService(
			validator,
			auditRepository,
			bpjsSEPINACBGIntegrationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsSEPINACBGIntegrationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);

		BpjsSEPINACBGIntegrationEntity updatedEntity = bpjsSEPINACBGIntegrationService.updateOldData(bpjsSEPINACBGIntegrationEntity);
		Assertions.assertEquals(bpjsSEPINACBGIntegrationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsSEPINACBGIntegrationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity;
			BpjsSEPINACBGIntegrationEntity entityWithUpdatedValues;

			try {
				bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
				bpjsSEPINACBGIntegrationDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSEPINACBGIntegrationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.create(bpjsSEPINACBGIntegrationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsSEPINACBGIntegrationEntity.getId());

			BpjsSEPINACBGIntegrationEntity updatedEntity = bpjsSEPINACBGIntegrationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsSEPINACBGIntegrationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
		bpjsSEPINACBGIntegrationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsSEPINACBGIntegrationService.updateOldData(bpjsSEPINACBGIntegrationEntity);
		});
	}

	@Test
	public void whenCreateBpjsSEPINACBGIntegrationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity;
			Optional<BpjsSEPINACBGIntegrationEntity> fetchedBpjsSEPINACBGIntegrationEntity;

			try {
				bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
				bpjsSEPINACBGIntegrationDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSEPINACBGIntegrationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.create(bpjsSEPINACBGIntegrationEntity);

			fetchedBpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.findById(bpjsSEPINACBGIntegrationEntity.getId());

			Assertions.assertTrue(fetchedBpjsSEPINACBGIntegrationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsSEPINACBGIntegrationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsSEPINACBGIntegrationEntity, fetchedBpjsSEPINACBGIntegrationEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsSEPINACBGIntegrationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity;
			BpjsSEPINACBGIntegrationEntity updatedBpjsSEPINACBGIntegrationEntity;
			Optional<BpjsSEPINACBGIntegrationEntity> fetchedBpjsSEPINACBGIntegrationEntity;

			try {
				bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
				bpjsSEPINACBGIntegrationDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSEPINACBGIntegrationEntity, true, true, false);
				updatedBpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
				bpjsSEPINACBGIntegrationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsSEPINACBGIntegrationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.create(bpjsSEPINACBGIntegrationEntity);

			updatedBpjsSEPINACBGIntegrationEntity.setId(bpjsSEPINACBGIntegrationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsSEPINACBGIntegrationEntity.setCreated(bpjsSEPINACBGIntegrationEntity.getCreated());

			updatedBpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.update(updatedBpjsSEPINACBGIntegrationEntity);

			fetchedBpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.findById(bpjsSEPINACBGIntegrationEntity.getId());

			Assertions.assertTrue(fetchedBpjsSEPINACBGIntegrationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsSEPINACBGIntegrationEntity_ThenEntityIsCreated
			fetchedBpjsSEPINACBGIntegrationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsSEPINACBGIntegrationEntity, fetchedBpjsSEPINACBGIntegrationEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsSEPINACBGIntegrationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity;
			Optional<BpjsSEPINACBGIntegrationEntity> fetchedBpjsSEPINACBGIntegrationEntity;

			try {
				bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsSEPINACBGIntegrationDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSEPINACBGIntegrationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.create(bpjsSEPINACBGIntegrationEntity);

			bpjsSEPINACBGIntegrationService.deleteById(bpjsSEPINACBGIntegrationEntity.getId());
			fetchedBpjsSEPINACBGIntegrationEntity = bpjsSEPINACBGIntegrationService.findById(bpjsSEPINACBGIntegrationEntity.getId());

			Assertions.assertTrue(fetchedBpjsSEPINACBGIntegrationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
