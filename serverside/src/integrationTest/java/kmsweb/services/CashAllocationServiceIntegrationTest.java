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
import kmsweb.entities.CashAllocationEntity;
import kmsweb.repositories.CashAllocationRepository;
import kmsweb.utils.CashAllocationFactory;
import kmsweb.utils.DatabasePopulators.CashAllocationDatabasePopulator;
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
public class CashAllocationServiceIntegrationTest {

	@Autowired
	private CashAllocationRepository cashAllocationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private CashAllocationService cashAllocationService;

	private final CashAllocationFactory cashAllocationFactory = new CashAllocationFactory();

	@Autowired
	private CashAllocationDatabasePopulator cashAllocationDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		cashAllocationService = new CashAllocationService(
			validator,
			auditRepository,
			cashAllocationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewCashAllocationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		CashAllocationEntity cashAllocationEntity = cashAllocationFactory.getObject(false, false);

		CashAllocationEntity updatedEntity = cashAllocationService.updateOldData(cashAllocationEntity);
		Assertions.assertEquals(cashAllocationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingCashAllocationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			CashAllocationEntity cashAllocationEntity;
			CashAllocationEntity entityWithUpdatedValues;

			try {
				cashAllocationEntity = cashAllocationFactory.getObject(false, false);
				cashAllocationDatabasePopulator.populateRelatedEntitiesInDatabase(cashAllocationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = cashAllocationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashAllocationEntity = cashAllocationService.create(cashAllocationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(cashAllocationEntity.getId());

			CashAllocationEntity updatedEntity = cashAllocationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithCashAllocationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		CashAllocationEntity cashAllocationEntity = cashAllocationFactory.getObject(false, false);
		cashAllocationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			cashAllocationService.updateOldData(cashAllocationEntity);
		});
	}

	@Test
	public void whenCreateCashAllocationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			CashAllocationEntity cashAllocationEntity;
			Optional<CashAllocationEntity> fetchedCashAllocationEntity;

			try {
				cashAllocationEntity = cashAllocationFactory.getObject(false, false);
				cashAllocationDatabasePopulator.populateRelatedEntitiesInDatabase(cashAllocationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashAllocationEntity = cashAllocationService.create(cashAllocationEntity);

			fetchedCashAllocationEntity = cashAllocationService.findById(cashAllocationEntity.getId());

			Assertions.assertTrue(fetchedCashAllocationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedCashAllocationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(cashAllocationEntity, fetchedCashAllocationEntity.get());
		});
	}

	@Test
	public void whenUpdateCashAllocationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			CashAllocationEntity cashAllocationEntity;
			CashAllocationEntity updatedCashAllocationEntity;
			Optional<CashAllocationEntity> fetchedCashAllocationEntity;

			try {
				cashAllocationEntity = cashAllocationFactory.getObject(false, false);
				cashAllocationDatabasePopulator.populateRelatedEntitiesInDatabase(cashAllocationEntity, true, true, false);
				updatedCashAllocationEntity = cashAllocationFactory.getObject(false, false);
				cashAllocationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedCashAllocationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashAllocationEntity = cashAllocationService.create(cashAllocationEntity);

			updatedCashAllocationEntity.setId(cashAllocationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedCashAllocationEntity.setCreated(cashAllocationEntity.getCreated());

			updatedCashAllocationEntity = cashAllocationService.update(updatedCashAllocationEntity);

			fetchedCashAllocationEntity = cashAllocationService.findById(cashAllocationEntity.getId());

			Assertions.assertTrue(fetchedCashAllocationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateCashAllocationEntity_ThenEntityIsCreated
			fetchedCashAllocationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedCashAllocationEntity, fetchedCashAllocationEntity.get());
		});
	}

	@Test
	public void whenDeleteCashAllocationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			CashAllocationEntity cashAllocationEntity;
			Optional<CashAllocationEntity> fetchedCashAllocationEntity;

			try {
				cashAllocationEntity = cashAllocationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				cashAllocationDatabasePopulator.populateRelatedEntitiesInDatabase(cashAllocationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashAllocationEntity = cashAllocationService.create(cashAllocationEntity);

			cashAllocationService.deleteById(cashAllocationEntity.getId());
			fetchedCashAllocationEntity = cashAllocationService.findById(cashAllocationEntity.getId());

			Assertions.assertTrue(fetchedCashAllocationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
