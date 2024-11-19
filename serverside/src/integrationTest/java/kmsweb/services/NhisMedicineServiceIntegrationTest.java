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
import kmsweb.entities.NhisMedicineEntity;
import kmsweb.repositories.NhisMedicineRepository;
import kmsweb.utils.NhisMedicineFactory;
import kmsweb.utils.DatabasePopulators.NhisMedicineDatabasePopulator;
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
public class NhisMedicineServiceIntegrationTest {

	@Autowired
	private NhisMedicineRepository nhisMedicineRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private NhisMedicineService nhisMedicineService;

	private final NhisMedicineFactory nhisMedicineFactory = new NhisMedicineFactory();

	@Autowired
	private NhisMedicineDatabasePopulator nhisMedicineDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		nhisMedicineService = new NhisMedicineService(
			validator,
			auditRepository,
			nhisMedicineRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewNhisMedicineEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		NhisMedicineEntity nhisMedicineEntity = nhisMedicineFactory.getObject(false, false);

		NhisMedicineEntity updatedEntity = nhisMedicineService.updateOldData(nhisMedicineEntity);
		Assertions.assertEquals(nhisMedicineEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingNhisMedicineEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			NhisMedicineEntity nhisMedicineEntity;
			NhisMedicineEntity entityWithUpdatedValues;

			try {
				nhisMedicineEntity = nhisMedicineFactory.getObject(false, false);
				nhisMedicineDatabasePopulator.populateRelatedEntitiesInDatabase(nhisMedicineEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = nhisMedicineFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nhisMedicineEntity = nhisMedicineService.create(nhisMedicineEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(nhisMedicineEntity.getId());

			NhisMedicineEntity updatedEntity = nhisMedicineService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithNhisMedicineEntityWithNonExistentId_ShouldThrowException() throws Exception {
		NhisMedicineEntity nhisMedicineEntity = nhisMedicineFactory.getObject(false, false);
		nhisMedicineEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			nhisMedicineService.updateOldData(nhisMedicineEntity);
		});
	}

	@Test
	public void whenCreateNhisMedicineEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			NhisMedicineEntity nhisMedicineEntity;
			Optional<NhisMedicineEntity> fetchedNhisMedicineEntity;

			try {
				nhisMedicineEntity = nhisMedicineFactory.getObject(false, false);
				nhisMedicineDatabasePopulator.populateRelatedEntitiesInDatabase(nhisMedicineEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nhisMedicineEntity = nhisMedicineService.create(nhisMedicineEntity);

			fetchedNhisMedicineEntity = nhisMedicineService.findById(nhisMedicineEntity.getId());

			Assertions.assertTrue(fetchedNhisMedicineEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedNhisMedicineEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(nhisMedicineEntity, fetchedNhisMedicineEntity.get());
		});
	}

	@Test
	public void whenUpdateNhisMedicineEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			NhisMedicineEntity nhisMedicineEntity;
			NhisMedicineEntity updatedNhisMedicineEntity;
			Optional<NhisMedicineEntity> fetchedNhisMedicineEntity;

			try {
				nhisMedicineEntity = nhisMedicineFactory.getObject(false, false);
				nhisMedicineDatabasePopulator.populateRelatedEntitiesInDatabase(nhisMedicineEntity, true, true, false);
				updatedNhisMedicineEntity = nhisMedicineFactory.getObject(false, false);
				nhisMedicineDatabasePopulator.populateRelatedEntitiesInDatabase(updatedNhisMedicineEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nhisMedicineEntity = nhisMedicineService.create(nhisMedicineEntity);

			updatedNhisMedicineEntity.setId(nhisMedicineEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedNhisMedicineEntity.setCreated(nhisMedicineEntity.getCreated());

			updatedNhisMedicineEntity = nhisMedicineService.update(updatedNhisMedicineEntity);

			fetchedNhisMedicineEntity = nhisMedicineService.findById(nhisMedicineEntity.getId());

			Assertions.assertTrue(fetchedNhisMedicineEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateNhisMedicineEntity_ThenEntityIsCreated
			fetchedNhisMedicineEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedNhisMedicineEntity, fetchedNhisMedicineEntity.get());
		});
	}

	@Test
	public void whenDeleteNhisMedicineEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			NhisMedicineEntity nhisMedicineEntity;
			Optional<NhisMedicineEntity> fetchedNhisMedicineEntity;

			try {
				nhisMedicineEntity = nhisMedicineFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				nhisMedicineDatabasePopulator.populateRelatedEntitiesInDatabase(nhisMedicineEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nhisMedicineEntity = nhisMedicineService.create(nhisMedicineEntity);

			nhisMedicineService.deleteById(nhisMedicineEntity.getId());
			fetchedNhisMedicineEntity = nhisMedicineService.findById(nhisMedicineEntity.getId());

			Assertions.assertTrue(fetchedNhisMedicineEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
