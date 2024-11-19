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
import kmsweb.entities.PcareCompoundDrugItemEntity;
import kmsweb.repositories.PcareCompoundDrugItemRepository;
import kmsweb.utils.PcareCompoundDrugItemFactory;
import kmsweb.utils.DatabasePopulators.PcareCompoundDrugItemDatabasePopulator;
import kmsweb.entities.PcareCompoundDrugEntity;
import kmsweb.repositories.PcareCompoundDrugRepository;
import kmsweb.utils.PcareCompoundDrugFactory;
import kmsweb.utils.DatabasePopulators.PcareCompoundDrugDatabasePopulator;
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
public class PcareCompoundDrugItemServiceIntegrationTest {

	@Autowired
	private PcareCompoundDrugItemRepository pcareCompoundDrugItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PcareCompoundDrugItemService pcareCompoundDrugItemService;

	private final PcareCompoundDrugItemFactory pcareCompoundDrugItemFactory = new PcareCompoundDrugItemFactory();

	@Autowired
	private PcareCompoundDrugItemDatabasePopulator pcareCompoundDrugItemDatabasePopulator;

	@Autowired
	private PcareCompoundDrugRepository pcareCompoundDrugRepository;

	@Autowired
	private PcareCompoundDrugDatabasePopulator pcareCompoundDrugDatabasePopulator;

	private final PcareCompoundDrugFactory pcareCompoundDrugFactory = new PcareCompoundDrugFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		pcareCompoundDrugItemService = new PcareCompoundDrugItemService(
			pcareCompoundDrugRepository,
			validator,
			auditRepository,
			pcareCompoundDrugItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPcareCompoundDrugItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);

		PcareCompoundDrugItemEntity updatedEntity = pcareCompoundDrugItemService.updateOldData(pcareCompoundDrugItemEntity);
		Assertions.assertEquals(pcareCompoundDrugItemEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPcareCompoundDrugItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity;
			PcareCompoundDrugItemEntity entityWithUpdatedValues;

			try {
				pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);
				pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = pcareCompoundDrugItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugItemEntity = pcareCompoundDrugItemService.create(pcareCompoundDrugItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(pcareCompoundDrugItemEntity.getId());

			PcareCompoundDrugItemEntity updatedEntity = pcareCompoundDrugItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPcareCompoundDrugItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);
		pcareCompoundDrugItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			pcareCompoundDrugItemService.updateOldData(pcareCompoundDrugItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPcareCompoundDrugItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity;
			PcareCompoundDrugItemEntity updatedPcareCompoundDrugItemEntity;

			PcareCompoundDrugEntity pcareCompoundDrugEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(true, false);
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
			pcareCompoundDrugEntity = pcareCompoundDrugItemEntity.getPcareCompoundDrug();
			try {
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			pcareCompoundDrugEntity = pcareCompoundDrugRepository.save(pcareCompoundDrugEntity);
			pcareCompoundDrugItemEntity.setPcareCompoundDrugId(pcareCompoundDrugEntity.getId());


			pcareCompoundDrugItemEntity = pcareCompoundDrugItemService.create(pcareCompoundDrugItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(pcareCompoundDrugItemEntity.getPcareCompoundDrug());
			pcareCompoundDrugItemEntity.setPcareCompoundDrugId(null);
			pcareCompoundDrugItemEntity.unsetPcareCompoundDrug();


			updatedPcareCompoundDrugItemEntity = pcareCompoundDrugItemService.updateOldData(pcareCompoundDrugItemEntity);

			Assertions.assertNull(updatedPcareCompoundDrugItemEntity.getPcareCompoundDrug());

		});
	}

	@Test
	public void updateOldDataWithPcareCompoundDrugItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity;
			PcareCompoundDrugItemEntity updatedPcareCompoundDrugItemEntity;

			PcareCompoundDrugEntity pcareCompoundDrugEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(true, false);
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
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugItemEntity.getPcareCompoundDrug(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the PCare Compound Drug relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			pcareCompoundDrugEntity = pcareCompoundDrugRepository.findById(pcareCompoundDrugRepository.save(pcareCompoundDrugItemEntity.getPcareCompoundDrug()).getId()).get();
			pcareCompoundDrugItemEntity.unsetPcareCompoundDrug();
			pcareCompoundDrugItemEntity.setPcareCompoundDrugId(pcareCompoundDrugEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPcareCompoundDrugItemEntity = pcareCompoundDrugItemService.updateOldData(pcareCompoundDrugItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			pcareCompoundDrugEntity.unsetPcareCompoundDrugItems(false);
			updatedPcareCompoundDrugItemEntity.getPcareCompoundDrug().unsetPcareCompoundDrugItems(false);
			Assertions.assertEquals(pcareCompoundDrugEntity, updatedPcareCompoundDrugItemEntity.getPcareCompoundDrug());

		});
	}

	@Test
	public void whenCreatePcareCompoundDrugItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity;
			Optional<PcareCompoundDrugItemEntity> fetchedPcareCompoundDrugItemEntity;

			try {
				pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);
				pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugItemEntity = pcareCompoundDrugItemService.create(pcareCompoundDrugItemEntity);

			fetchedPcareCompoundDrugItemEntity = pcareCompoundDrugItemService.findById(pcareCompoundDrugItemEntity.getId());

			Assertions.assertTrue(fetchedPcareCompoundDrugItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPcareCompoundDrugItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(pcareCompoundDrugItemEntity, fetchedPcareCompoundDrugItemEntity.get());
		});
	}

	@Test
	public void whenUpdatePcareCompoundDrugItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity;
			PcareCompoundDrugItemEntity updatedPcareCompoundDrugItemEntity;
			Optional<PcareCompoundDrugItemEntity> fetchedPcareCompoundDrugItemEntity;

			try {
				pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);
				pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugItemEntity, true, true, false);
				updatedPcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);
				pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPcareCompoundDrugItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugItemEntity = pcareCompoundDrugItemService.create(pcareCompoundDrugItemEntity);

			updatedPcareCompoundDrugItemEntity.setId(pcareCompoundDrugItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPcareCompoundDrugItemEntity.setCreated(pcareCompoundDrugItemEntity.getCreated());

			updatedPcareCompoundDrugItemEntity = pcareCompoundDrugItemService.update(updatedPcareCompoundDrugItemEntity);

			fetchedPcareCompoundDrugItemEntity = pcareCompoundDrugItemService.findById(pcareCompoundDrugItemEntity.getId());

			Assertions.assertTrue(fetchedPcareCompoundDrugItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePcareCompoundDrugItemEntity_ThenEntityIsCreated
			fetchedPcareCompoundDrugItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPcareCompoundDrugItemEntity, fetchedPcareCompoundDrugItemEntity.get());
		});
	}

	@Test
	public void whenDeletePcareCompoundDrugItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity;
			Optional<PcareCompoundDrugItemEntity> fetchedPcareCompoundDrugItemEntity;

			try {
				pcareCompoundDrugItemEntity = pcareCompoundDrugItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugItemEntity = pcareCompoundDrugItemService.create(pcareCompoundDrugItemEntity);

			pcareCompoundDrugItemService.deleteById(pcareCompoundDrugItemEntity.getId());
			fetchedPcareCompoundDrugItemEntity = pcareCompoundDrugItemService.findById(pcareCompoundDrugItemEntity.getId());

			Assertions.assertTrue(fetchedPcareCompoundDrugItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
