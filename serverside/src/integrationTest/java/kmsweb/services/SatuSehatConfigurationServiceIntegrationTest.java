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
import kmsweb.entities.SatuSehatConfigurationEntity;
import kmsweb.repositories.SatuSehatConfigurationRepository;
import kmsweb.utils.SatuSehatConfigurationFactory;
import kmsweb.utils.DatabasePopulators.SatuSehatConfigurationDatabasePopulator;
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
public class SatuSehatConfigurationServiceIntegrationTest {

	@Autowired
	private SatuSehatConfigurationRepository satuSehatConfigurationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private SatuSehatConfigurationService satuSehatConfigurationService;

	private final SatuSehatConfigurationFactory satuSehatConfigurationFactory = new SatuSehatConfigurationFactory();

	@Autowired
	private SatuSehatConfigurationDatabasePopulator satuSehatConfigurationDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		satuSehatConfigurationService = new SatuSehatConfigurationService(
			validator,
			auditRepository,
			satuSehatConfigurationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewSatuSehatConfigurationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		SatuSehatConfigurationEntity satuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);

		SatuSehatConfigurationEntity updatedEntity = satuSehatConfigurationService.updateOldData(satuSehatConfigurationEntity);
		Assertions.assertEquals(satuSehatConfigurationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingSatuSehatConfigurationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			SatuSehatConfigurationEntity satuSehatConfigurationEntity;
			SatuSehatConfigurationEntity entityWithUpdatedValues;

			try {
				satuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);
				satuSehatConfigurationDatabasePopulator.populateRelatedEntitiesInDatabase(satuSehatConfigurationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = satuSehatConfigurationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			satuSehatConfigurationEntity = satuSehatConfigurationService.create(satuSehatConfigurationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(satuSehatConfigurationEntity.getId());

			SatuSehatConfigurationEntity updatedEntity = satuSehatConfigurationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithSatuSehatConfigurationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		SatuSehatConfigurationEntity satuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);
		satuSehatConfigurationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			satuSehatConfigurationService.updateOldData(satuSehatConfigurationEntity);
		});
	}

	@Test
	public void whenCreateSatuSehatConfigurationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			SatuSehatConfigurationEntity satuSehatConfigurationEntity;
			Optional<SatuSehatConfigurationEntity> fetchedSatuSehatConfigurationEntity;

			try {
				satuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);
				satuSehatConfigurationDatabasePopulator.populateRelatedEntitiesInDatabase(satuSehatConfigurationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			satuSehatConfigurationEntity = satuSehatConfigurationService.create(satuSehatConfigurationEntity);

			fetchedSatuSehatConfigurationEntity = satuSehatConfigurationService.findById(satuSehatConfigurationEntity.getId());

			Assertions.assertTrue(fetchedSatuSehatConfigurationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedSatuSehatConfigurationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(satuSehatConfigurationEntity, fetchedSatuSehatConfigurationEntity.get());
		});
	}

	@Test
	public void whenUpdateSatuSehatConfigurationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			SatuSehatConfigurationEntity satuSehatConfigurationEntity;
			SatuSehatConfigurationEntity updatedSatuSehatConfigurationEntity;
			Optional<SatuSehatConfigurationEntity> fetchedSatuSehatConfigurationEntity;

			try {
				satuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);
				satuSehatConfigurationDatabasePopulator.populateRelatedEntitiesInDatabase(satuSehatConfigurationEntity, true, true, false);
				updatedSatuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);
				satuSehatConfigurationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedSatuSehatConfigurationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			satuSehatConfigurationEntity = satuSehatConfigurationService.create(satuSehatConfigurationEntity);

			updatedSatuSehatConfigurationEntity.setId(satuSehatConfigurationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedSatuSehatConfigurationEntity.setCreated(satuSehatConfigurationEntity.getCreated());

			updatedSatuSehatConfigurationEntity = satuSehatConfigurationService.update(updatedSatuSehatConfigurationEntity);

			fetchedSatuSehatConfigurationEntity = satuSehatConfigurationService.findById(satuSehatConfigurationEntity.getId());

			Assertions.assertTrue(fetchedSatuSehatConfigurationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateSatuSehatConfigurationEntity_ThenEntityIsCreated
			fetchedSatuSehatConfigurationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedSatuSehatConfigurationEntity, fetchedSatuSehatConfigurationEntity.get());
		});
	}

	@Test
	public void whenDeleteSatuSehatConfigurationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			SatuSehatConfigurationEntity satuSehatConfigurationEntity;
			Optional<SatuSehatConfigurationEntity> fetchedSatuSehatConfigurationEntity;

			try {
				satuSehatConfigurationEntity = satuSehatConfigurationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				satuSehatConfigurationDatabasePopulator.populateRelatedEntitiesInDatabase(satuSehatConfigurationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			satuSehatConfigurationEntity = satuSehatConfigurationService.create(satuSehatConfigurationEntity);

			satuSehatConfigurationService.deleteById(satuSehatConfigurationEntity.getId());
			fetchedSatuSehatConfigurationEntity = satuSehatConfigurationService.findById(satuSehatConfigurationEntity.getId());

			Assertions.assertTrue(fetchedSatuSehatConfigurationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
