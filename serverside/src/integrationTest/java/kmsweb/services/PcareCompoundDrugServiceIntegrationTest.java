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
import kmsweb.entities.PcareCompoundDrugEntity;
import kmsweb.repositories.PcareCompoundDrugRepository;
import kmsweb.utils.PcareCompoundDrugFactory;
import kmsweb.utils.DatabasePopulators.PcareCompoundDrugDatabasePopulator;
import kmsweb.entities.PcareCompoundDrugItemEntity;
import kmsweb.repositories.PcareCompoundDrugItemRepository;
import kmsweb.utils.PcareCompoundDrugItemFactory;
import kmsweb.utils.DatabasePopulators.PcareCompoundDrugItemDatabasePopulator;
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.repositories.PcareExaminationRepository;
import kmsweb.utils.PcareExaminationFactory;
import kmsweb.utils.DatabasePopulators.PcareExaminationDatabasePopulator;
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
public class PcareCompoundDrugServiceIntegrationTest {

	@Autowired
	private PcareCompoundDrugRepository pcareCompoundDrugRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PcareCompoundDrugService pcareCompoundDrugService;

	private final PcareCompoundDrugFactory pcareCompoundDrugFactory = new PcareCompoundDrugFactory();

	@Autowired
	private PcareCompoundDrugDatabasePopulator pcareCompoundDrugDatabasePopulator;

	@Autowired
	private PcareCompoundDrugItemRepository pcareCompoundDrugItemRepository;

	@Autowired
	private PcareCompoundDrugItemDatabasePopulator pcareCompoundDrugItemDatabasePopulator;

	private final PcareCompoundDrugItemFactory pcareCompoundDrugItemFactory = new PcareCompoundDrugItemFactory();

	@Autowired
	private PcareExaminationRepository pcareExaminationRepository;

	@Autowired
	private PcareExaminationDatabasePopulator pcareExaminationDatabasePopulator;

	private final PcareExaminationFactory pcareExaminationFactory = new PcareExaminationFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		pcareCompoundDrugService = new PcareCompoundDrugService(
			pcareCompoundDrugItemRepository,
			pcareExaminationRepository,
			validator,
			auditRepository,
			pcareCompoundDrugRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPcareCompoundDrugEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PcareCompoundDrugEntity pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);

		PcareCompoundDrugEntity updatedEntity = pcareCompoundDrugService.updateOldData(pcareCompoundDrugEntity);
		Assertions.assertEquals(pcareCompoundDrugEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPcareCompoundDrugEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PcareCompoundDrugEntity pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);

		pcareCompoundDrugEntity.setRacikan(null);
		Assertions.assertNull(pcareCompoundDrugEntity.getRacikan());


		PcareCompoundDrugEntity updatedEntity = pcareCompoundDrugService.updateOldData(pcareCompoundDrugEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getRacikan());
		Assertions.assertFalse(updatedEntity.getRacikan());

	}

	@Test
	public void updateOldDataWithExistingPcareCompoundDrugEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugEntity pcareCompoundDrugEntity;
			PcareCompoundDrugEntity entityWithUpdatedValues;

			try {
				pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = pcareCompoundDrugFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugEntity = pcareCompoundDrugService.create(pcareCompoundDrugEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(pcareCompoundDrugEntity.getId());

			PcareCompoundDrugEntity updatedEntity = pcareCompoundDrugService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPcareCompoundDrugEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PcareCompoundDrugEntity pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);
		pcareCompoundDrugEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			pcareCompoundDrugService.updateOldData(pcareCompoundDrugEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPcareCompoundDrugEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugEntity pcareCompoundDrugEntity;
			PcareCompoundDrugEntity updatedPcareCompoundDrugEntity;

			PcareExaminationEntity pcareExaminationEntity;

			Set<PcareCompoundDrugItemEntity> pcareCompoundDrugItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(true, false);
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
			pcareExaminationEntity = pcareCompoundDrugEntity.getPcareExamination();
			try {
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			pcareExaminationEntity = pcareExaminationRepository.save(pcareExaminationEntity);
			pcareCompoundDrugEntity.setPcareExaminationId(pcareExaminationEntity.getId());

			pcareCompoundDrugItemsEntities = pcareCompoundDrugEntity.getPcareCompoundDrugItems();
			Set<UUID> pcareCompoundDrugItemsEntityIds = new HashSet<>();
			for (PcareCompoundDrugItemEntity entity : pcareCompoundDrugItemsEntities) {
				try {
					pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				pcareCompoundDrugItemsEntityIds.add(pcareCompoundDrugItemRepository.save(entity).getId());
			}
			pcareCompoundDrugEntity.setPcareCompoundDrugItemsIds(pcareCompoundDrugItemsEntityIds);


			pcareCompoundDrugEntity = pcareCompoundDrugService.create(pcareCompoundDrugEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(pcareCompoundDrugEntity.getPcareExamination());
			pcareCompoundDrugEntity.setPcareExaminationId(null);
			pcareCompoundDrugEntity.unsetPcareExamination();

			Assertions.assertTrue(pcareCompoundDrugEntity.getPcareCompoundDrugItems().size() > 0);
			pcareCompoundDrugEntity.setPcareCompoundDrugItemsIds(new HashSet<UUID>());
			pcareCompoundDrugEntity.unsetPcareCompoundDrugItems();


			updatedPcareCompoundDrugEntity = pcareCompoundDrugService.updateOldData(pcareCompoundDrugEntity);

			Assertions.assertNull(updatedPcareCompoundDrugEntity.getPcareExamination());

			Assertions.assertEquals(0, updatedPcareCompoundDrugEntity.getPcareCompoundDrugItems().size());

		});
	}

	@Test
	public void updateOldDataWithPcareCompoundDrugEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugEntity pcareCompoundDrugEntity;
			PcareCompoundDrugEntity updatedPcareCompoundDrugEntity;

			PcareExaminationEntity pcareExaminationEntity;

			Set<PcareCompoundDrugItemEntity> pcareCompoundDrugItemsEntities;
			Set<UUID> pcareCompoundDrugItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(true, false);
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
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugEntity.getPcareExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the PCare Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			pcareExaminationEntity = pcareExaminationRepository.findById(pcareExaminationRepository.save(pcareCompoundDrugEntity.getPcareExamination()).getId()).get();
			pcareCompoundDrugEntity.unsetPcareExamination();
			pcareCompoundDrugEntity.setPcareExaminationId(pcareExaminationEntity.getId());

			pcareCompoundDrugItemsEntities = new HashSet<>();
			pcareCompoundDrugItemsEntityIds = new HashSet<>();
			for (PcareCompoundDrugItemEntity entity : pcareCompoundDrugEntity.getPcareCompoundDrugItems()) {
				try {
					pcareCompoundDrugItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the PCare Compound Drug Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = pcareCompoundDrugItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				pcareCompoundDrugItemsEntities.add(pcareCompoundDrugItemRepository.findById(id).get());
				pcareCompoundDrugItemsEntityIds.add(id);
			}
			pcareCompoundDrugEntity.unsetPcareCompoundDrugItems();
			pcareCompoundDrugEntity.setPcareCompoundDrugItemsIds(pcareCompoundDrugItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPcareCompoundDrugEntity = pcareCompoundDrugService.updateOldData(pcareCompoundDrugEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			pcareExaminationEntity.unsetPcareCompoundDrugs(false);
			updatedPcareCompoundDrugEntity.getPcareExamination().unsetPcareCompoundDrugs(false);
			Assertions.assertEquals(pcareExaminationEntity, updatedPcareCompoundDrugEntity.getPcareExamination());

			Assertions.assertEquals(pcareCompoundDrugItemsEntities.size(), updatedPcareCompoundDrugEntity.getPcareCompoundDrugItems().size());

		});
	}

	@Test
	public void whenCreatePcareCompoundDrugEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugEntity pcareCompoundDrugEntity;
			Optional<PcareCompoundDrugEntity> fetchedPcareCompoundDrugEntity;

			try {
				pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugEntity = pcareCompoundDrugService.create(pcareCompoundDrugEntity);

			fetchedPcareCompoundDrugEntity = pcareCompoundDrugService.findById(pcareCompoundDrugEntity.getId());

			Assertions.assertTrue(fetchedPcareCompoundDrugEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPcareCompoundDrugEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(pcareCompoundDrugEntity, fetchedPcareCompoundDrugEntity.get());
		});
	}

	@Test
	public void whenUpdatePcareCompoundDrugEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugEntity pcareCompoundDrugEntity;
			PcareCompoundDrugEntity updatedPcareCompoundDrugEntity;
			Optional<PcareCompoundDrugEntity> fetchedPcareCompoundDrugEntity;

			try {
				pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugEntity, true, true, false);
				updatedPcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPcareCompoundDrugEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugEntity = pcareCompoundDrugService.create(pcareCompoundDrugEntity);

			updatedPcareCompoundDrugEntity.setId(pcareCompoundDrugEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPcareCompoundDrugEntity.setCreated(pcareCompoundDrugEntity.getCreated());

			updatedPcareCompoundDrugEntity = pcareCompoundDrugService.update(updatedPcareCompoundDrugEntity);

			fetchedPcareCompoundDrugEntity = pcareCompoundDrugService.findById(pcareCompoundDrugEntity.getId());

			Assertions.assertTrue(fetchedPcareCompoundDrugEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePcareCompoundDrugEntity_ThenEntityIsCreated
			fetchedPcareCompoundDrugEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPcareCompoundDrugEntity, fetchedPcareCompoundDrugEntity.get());
		});
	}

	@Test
	public void whenDeletePcareCompoundDrugEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PcareCompoundDrugEntity pcareCompoundDrugEntity;
			Optional<PcareCompoundDrugEntity> fetchedPcareCompoundDrugEntity;

			try {
				pcareCompoundDrugEntity = pcareCompoundDrugFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(pcareCompoundDrugEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareCompoundDrugEntity = pcareCompoundDrugService.create(pcareCompoundDrugEntity);

			pcareCompoundDrugService.deleteById(pcareCompoundDrugEntity.getId());
			fetchedPcareCompoundDrugEntity = pcareCompoundDrugService.findById(pcareCompoundDrugEntity.getId());

			Assertions.assertTrue(fetchedPcareCompoundDrugEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
