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
import kmsweb.entities.BpjsDiagnosePRBEntity;
import kmsweb.repositories.BpjsDiagnosePRBRepository;
import kmsweb.utils.BpjsDiagnosePRBFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnosePRBDatabasePopulator;
import kmsweb.entities.BpjsPRBEntity;
import kmsweb.repositories.BpjsPRBRepository;
import kmsweb.utils.BpjsPRBFactory;
import kmsweb.utils.DatabasePopulators.BpjsPRBDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
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
public class BpjsDiagnosePRBServiceIntegrationTest {

	@Autowired
	private BpjsDiagnosePRBRepository bpjsDiagnosePRBRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsDiagnosePRBService bpjsDiagnosePRBService;

	private final BpjsDiagnosePRBFactory bpjsDiagnosePRBFactory = new BpjsDiagnosePRBFactory();

	@Autowired
	private BpjsDiagnosePRBDatabasePopulator bpjsDiagnosePRBDatabasePopulator;

	@Autowired
	private BpjsPRBRepository bpjsPRBRepository;

	@Autowired
	private BpjsPRBDatabasePopulator bpjsPRBDatabasePopulator;

	private final BpjsPRBFactory bpjsPRBFactory = new BpjsPRBFactory();

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsDiagnosePRBService = new BpjsDiagnosePRBService(
			bpjsPRBRepository,
			diagnosesAndProceduresRepository,
			validator,
			auditRepository,
			bpjsDiagnosePRBRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsDiagnosePRBEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);

		BpjsDiagnosePRBEntity updatedEntity = bpjsDiagnosePRBService.updateOldData(bpjsDiagnosePRBEntity);
		Assertions.assertEquals(bpjsDiagnosePRBEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsDiagnosePRBEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;
			BpjsDiagnosePRBEntity entityWithUpdatedValues;

			try {
				bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnosePRBEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsDiagnosePRBFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnosePRBEntity = bpjsDiagnosePRBService.create(bpjsDiagnosePRBEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsDiagnosePRBEntity.getId());

			BpjsDiagnosePRBEntity updatedEntity = bpjsDiagnosePRBService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsDiagnosePRBEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);
		bpjsDiagnosePRBEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsDiagnosePRBService.updateOldData(bpjsDiagnosePRBEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsDiagnosePRBEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;
			BpjsDiagnosePRBEntity updatedBpjsDiagnosePRBEntity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;

			Set<BpjsPRBEntity> bpjsPRBsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(true, false);
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
			diagnosesAndProceduresEntity = bpjsDiagnosePRBEntity.getDiagnosesAndProcedures();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.save(diagnosesAndProceduresEntity);
			bpjsDiagnosePRBEntity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());

			bpjsPRBsEntities = bpjsDiagnosePRBEntity.getBpjsPRBs();
			Set<UUID> bpjsPRBsEntityIds = new HashSet<>();
			for (BpjsPRBEntity entity : bpjsPRBsEntities) {
				try {
					bpjsPRBDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsPRBsEntityIds.add(bpjsPRBRepository.save(entity).getId());
			}
			bpjsDiagnosePRBEntity.setBpjsPRBsIds(bpjsPRBsEntityIds);


			bpjsDiagnosePRBEntity = bpjsDiagnosePRBService.create(bpjsDiagnosePRBEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsDiagnosePRBEntity.getDiagnosesAndProcedures());
			bpjsDiagnosePRBEntity.setDiagnosesAndProceduresId(null);
			bpjsDiagnosePRBEntity.unsetDiagnosesAndProcedures();

			Assertions.assertTrue(bpjsDiagnosePRBEntity.getBpjsPRBs().size() > 0);
			bpjsDiagnosePRBEntity.setBpjsPRBsIds(new HashSet<UUID>());
			bpjsDiagnosePRBEntity.unsetBpjsPRBs();


			updatedBpjsDiagnosePRBEntity = bpjsDiagnosePRBService.updateOldData(bpjsDiagnosePRBEntity);

			Assertions.assertNull(updatedBpjsDiagnosePRBEntity.getDiagnosesAndProcedures());

			Assertions.assertEquals(0, updatedBpjsDiagnosePRBEntity.getBpjsPRBs().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsDiagnosePRBEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;
			BpjsDiagnosePRBEntity updatedBpjsDiagnosePRBEntity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;

			Set<BpjsPRBEntity> bpjsPRBsEntities;
			Set<UUID> bpjsPRBsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(true, false);
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
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnosePRBEntity.getDiagnosesAndProcedures(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnoses and Procedures relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(bpjsDiagnosePRBEntity.getDiagnosesAndProcedures()).getId()).get();
			bpjsDiagnosePRBEntity.unsetDiagnosesAndProcedures();
			bpjsDiagnosePRBEntity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());

			bpjsPRBsEntities = new HashSet<>();
			bpjsPRBsEntityIds = new HashSet<>();
			for (BpjsPRBEntity entity : bpjsDiagnosePRBEntity.getBpjsPRBs()) {
				try {
					bpjsPRBDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS PRBs relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsPRBRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsPRBsEntities.add(bpjsPRBRepository.findById(id).get());
				bpjsPRBsEntityIds.add(id);
			}
			bpjsDiagnosePRBEntity.unsetBpjsPRBs();
			bpjsDiagnosePRBEntity.setBpjsPRBsIds(bpjsPRBsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsDiagnosePRBEntity = bpjsDiagnosePRBService.updateOldData(bpjsDiagnosePRBEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosesAndProceduresEntity.unsetBpjsDiagnosePRB(false);
			updatedBpjsDiagnosePRBEntity.getDiagnosesAndProcedures().unsetBpjsDiagnosePRB(false);
			Assertions.assertEquals(diagnosesAndProceduresEntity, updatedBpjsDiagnosePRBEntity.getDiagnosesAndProcedures());

			Assertions.assertEquals(bpjsPRBsEntities.size(), updatedBpjsDiagnosePRBEntity.getBpjsPRBs().size());

		});
	}

	@Test
	public void whenCreateBpjsDiagnosePRBEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;
			Optional<BpjsDiagnosePRBEntity> fetchedBpjsDiagnosePRBEntity;

			try {
				bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnosePRBEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnosePRBEntity = bpjsDiagnosePRBService.create(bpjsDiagnosePRBEntity);

			fetchedBpjsDiagnosePRBEntity = bpjsDiagnosePRBService.findById(bpjsDiagnosePRBEntity.getId());

			Assertions.assertTrue(fetchedBpjsDiagnosePRBEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsDiagnosePRBEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsDiagnosePRBEntity, fetchedBpjsDiagnosePRBEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsDiagnosePRBEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;
			BpjsDiagnosePRBEntity updatedBpjsDiagnosePRBEntity;
			Optional<BpjsDiagnosePRBEntity> fetchedBpjsDiagnosePRBEntity;

			try {
				bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnosePRBEntity, true, true, false);
				updatedBpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsDiagnosePRBEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnosePRBEntity = bpjsDiagnosePRBService.create(bpjsDiagnosePRBEntity);

			updatedBpjsDiagnosePRBEntity.setId(bpjsDiagnosePRBEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsDiagnosePRBEntity.setCreated(bpjsDiagnosePRBEntity.getCreated());

			updatedBpjsDiagnosePRBEntity = bpjsDiagnosePRBService.update(updatedBpjsDiagnosePRBEntity);

			fetchedBpjsDiagnosePRBEntity = bpjsDiagnosePRBService.findById(bpjsDiagnosePRBEntity.getId());

			Assertions.assertTrue(fetchedBpjsDiagnosePRBEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsDiagnosePRBEntity_ThenEntityIsCreated
			fetchedBpjsDiagnosePRBEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsDiagnosePRBEntity, fetchedBpjsDiagnosePRBEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsDiagnosePRBEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;
			Optional<BpjsDiagnosePRBEntity> fetchedBpjsDiagnosePRBEntity;

			try {
				bpjsDiagnosePRBEntity = bpjsDiagnosePRBFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnosePRBEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnosePRBEntity = bpjsDiagnosePRBService.create(bpjsDiagnosePRBEntity);

			bpjsDiagnosePRBService.deleteById(bpjsDiagnosePRBEntity.getId());
			fetchedBpjsDiagnosePRBEntity = bpjsDiagnosePRBService.findById(bpjsDiagnosePRBEntity.getId());

			Assertions.assertTrue(fetchedBpjsDiagnosePRBEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
