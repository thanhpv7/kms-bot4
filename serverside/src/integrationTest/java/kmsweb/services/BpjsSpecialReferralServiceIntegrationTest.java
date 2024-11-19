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
import kmsweb.entities.BpjsSpecialReferralEntity;
import kmsweb.repositories.BpjsSpecialReferralRepository;
import kmsweb.utils.BpjsSpecialReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsSpecialReferralDatabasePopulator;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.utils.BpjsDiagnoseFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnoseDatabasePopulator;
import kmsweb.entities.BpjsProcedureEntity;
import kmsweb.repositories.BpjsProcedureRepository;
import kmsweb.utils.BpjsProcedureFactory;
import kmsweb.utils.DatabasePopulators.BpjsProcedureDatabasePopulator;
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
public class BpjsSpecialReferralServiceIntegrationTest {

	@Autowired
	private BpjsSpecialReferralRepository bpjsSpecialReferralRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsSpecialReferralService bpjsSpecialReferralService;

	private final BpjsSpecialReferralFactory bpjsSpecialReferralFactory = new BpjsSpecialReferralFactory();

	@Autowired
	private BpjsSpecialReferralDatabasePopulator bpjsSpecialReferralDatabasePopulator;

	@Autowired
	private BpjsDiagnoseRepository bpjsDiagnoseRepository;

	@Autowired
	private BpjsDiagnoseDatabasePopulator bpjsDiagnoseDatabasePopulator;

	private final BpjsDiagnoseFactory bpjsDiagnoseFactory = new BpjsDiagnoseFactory();

	@Autowired
	private BpjsProcedureRepository bpjsProcedureRepository;

	@Autowired
	private BpjsProcedureDatabasePopulator bpjsProcedureDatabasePopulator;

	private final BpjsProcedureFactory bpjsProcedureFactory = new BpjsProcedureFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsSpecialReferralService = new BpjsSpecialReferralService(
			bpjsDiagnoseRepository,
			bpjsProcedureRepository,
			validator,
			auditRepository,
			bpjsSpecialReferralRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsSpecialReferralEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsSpecialReferralEntity bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);

		BpjsSpecialReferralEntity updatedEntity = bpjsSpecialReferralService.updateOldData(bpjsSpecialReferralEntity);
		Assertions.assertEquals(bpjsSpecialReferralEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsSpecialReferralEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSpecialReferralEntity bpjsSpecialReferralEntity;
			BpjsSpecialReferralEntity entityWithUpdatedValues;

			try {
				bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);
				bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsSpecialReferralFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSpecialReferralEntity = bpjsSpecialReferralService.create(bpjsSpecialReferralEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsSpecialReferralEntity.getId());

			BpjsSpecialReferralEntity updatedEntity = bpjsSpecialReferralService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsSpecialReferralEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsSpecialReferralEntity bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);
		bpjsSpecialReferralEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsSpecialReferralService.updateOldData(bpjsSpecialReferralEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsSpecialReferralEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSpecialReferralEntity bpjsSpecialReferralEntity;
			BpjsSpecialReferralEntity updatedBpjsSpecialReferralEntity;

			BpjsDiagnoseEntity additionalDiagnoseEntity;

			BpjsProcedureEntity additionalProcedureEntity;

			BpjsDiagnoseEntity primaryDiagnoseEntity;

			BpjsProcedureEntity primaryProcedureEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(true, false);
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
			additionalDiagnoseEntity = bpjsSpecialReferralEntity.getAdditionalDiagnose();
			try {
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(additionalDiagnoseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			additionalDiagnoseEntity = bpjsDiagnoseRepository.save(additionalDiagnoseEntity);
			bpjsSpecialReferralEntity.setAdditionalDiagnoseId(additionalDiagnoseEntity.getId());

			additionalProcedureEntity = bpjsSpecialReferralEntity.getAdditionalProcedure();
			try {
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(additionalProcedureEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			additionalProcedureEntity = bpjsProcedureRepository.save(additionalProcedureEntity);
			bpjsSpecialReferralEntity.setAdditionalProcedureId(additionalProcedureEntity.getId());

			primaryDiagnoseEntity = bpjsSpecialReferralEntity.getPrimaryDiagnose();
			try {
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(primaryDiagnoseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			primaryDiagnoseEntity = bpjsDiagnoseRepository.save(primaryDiagnoseEntity);
			bpjsSpecialReferralEntity.setPrimaryDiagnoseId(primaryDiagnoseEntity.getId());

			primaryProcedureEntity = bpjsSpecialReferralEntity.getPrimaryProcedure();
			try {
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(primaryProcedureEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			primaryProcedureEntity = bpjsProcedureRepository.save(primaryProcedureEntity);
			bpjsSpecialReferralEntity.setPrimaryProcedureId(primaryProcedureEntity.getId());


			bpjsSpecialReferralEntity = bpjsSpecialReferralService.create(bpjsSpecialReferralEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsSpecialReferralEntity.getAdditionalDiagnose());
			bpjsSpecialReferralEntity.setAdditionalDiagnoseId(null);
			bpjsSpecialReferralEntity.unsetAdditionalDiagnose();

			Assertions.assertNotNull(bpjsSpecialReferralEntity.getAdditionalProcedure());
			bpjsSpecialReferralEntity.setAdditionalProcedureId(null);
			bpjsSpecialReferralEntity.unsetAdditionalProcedure();

			Assertions.assertNotNull(bpjsSpecialReferralEntity.getPrimaryDiagnose());
			bpjsSpecialReferralEntity.setPrimaryDiagnoseId(null);
			bpjsSpecialReferralEntity.unsetPrimaryDiagnose();

			Assertions.assertNotNull(bpjsSpecialReferralEntity.getPrimaryProcedure());
			bpjsSpecialReferralEntity.setPrimaryProcedureId(null);
			bpjsSpecialReferralEntity.unsetPrimaryProcedure();


			updatedBpjsSpecialReferralEntity = bpjsSpecialReferralService.updateOldData(bpjsSpecialReferralEntity);

			Assertions.assertNull(updatedBpjsSpecialReferralEntity.getAdditionalDiagnose());

			Assertions.assertNull(updatedBpjsSpecialReferralEntity.getAdditionalProcedure());

			Assertions.assertNull(updatedBpjsSpecialReferralEntity.getPrimaryDiagnose());

			Assertions.assertNull(updatedBpjsSpecialReferralEntity.getPrimaryProcedure());

		});
	}

	@Test
	public void updateOldDataWithBpjsSpecialReferralEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSpecialReferralEntity bpjsSpecialReferralEntity;
			BpjsSpecialReferralEntity updatedBpjsSpecialReferralEntity;

			BpjsDiagnoseEntity additionalDiagnoseEntity;

			BpjsProcedureEntity additionalProcedureEntity;

			BpjsDiagnoseEntity primaryDiagnoseEntity;

			BpjsProcedureEntity primaryProcedureEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(true, false);
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
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity.getAdditionalDiagnose(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Additional Diagnose relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			additionalDiagnoseEntity = bpjsDiagnoseRepository.findById(bpjsDiagnoseRepository.save(bpjsSpecialReferralEntity.getAdditionalDiagnose()).getId()).get();
			bpjsSpecialReferralEntity.unsetAdditionalDiagnose();
			bpjsSpecialReferralEntity.setAdditionalDiagnoseId(additionalDiagnoseEntity.getId());

			try {
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity.getAdditionalProcedure(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Additional Procedure relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			additionalProcedureEntity = bpjsProcedureRepository.findById(bpjsProcedureRepository.save(bpjsSpecialReferralEntity.getAdditionalProcedure()).getId()).get();
			bpjsSpecialReferralEntity.unsetAdditionalProcedure();
			bpjsSpecialReferralEntity.setAdditionalProcedureId(additionalProcedureEntity.getId());

			try {
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity.getPrimaryDiagnose(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Primary Diagnose relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			primaryDiagnoseEntity = bpjsDiagnoseRepository.findById(bpjsDiagnoseRepository.save(bpjsSpecialReferralEntity.getPrimaryDiagnose()).getId()).get();
			bpjsSpecialReferralEntity.unsetPrimaryDiagnose();
			bpjsSpecialReferralEntity.setPrimaryDiagnoseId(primaryDiagnoseEntity.getId());

			try {
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity.getPrimaryProcedure(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Primary Procedure relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			primaryProcedureEntity = bpjsProcedureRepository.findById(bpjsProcedureRepository.save(bpjsSpecialReferralEntity.getPrimaryProcedure()).getId()).get();
			bpjsSpecialReferralEntity.unsetPrimaryProcedure();
			bpjsSpecialReferralEntity.setPrimaryProcedureId(primaryProcedureEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsSpecialReferralEntity = bpjsSpecialReferralService.updateOldData(bpjsSpecialReferralEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			additionalDiagnoseEntity.unsetAdditionalDiagnose(false);
			updatedBpjsSpecialReferralEntity.getAdditionalDiagnose().unsetAdditionalDiagnose(false);
			Assertions.assertEquals(additionalDiagnoseEntity, updatedBpjsSpecialReferralEntity.getAdditionalDiagnose());

			additionalProcedureEntity.unsetAdditionalProcedure(false);
			updatedBpjsSpecialReferralEntity.getAdditionalProcedure().unsetAdditionalProcedure(false);
			Assertions.assertEquals(additionalProcedureEntity, updatedBpjsSpecialReferralEntity.getAdditionalProcedure());

			primaryDiagnoseEntity.unsetPrimaryDiagnose(false);
			updatedBpjsSpecialReferralEntity.getPrimaryDiagnose().unsetPrimaryDiagnose(false);
			Assertions.assertEquals(primaryDiagnoseEntity, updatedBpjsSpecialReferralEntity.getPrimaryDiagnose());

			primaryProcedureEntity.unsetPrimaryProcedure(false);
			updatedBpjsSpecialReferralEntity.getPrimaryProcedure().unsetPrimaryProcedure(false);
			Assertions.assertEquals(primaryProcedureEntity, updatedBpjsSpecialReferralEntity.getPrimaryProcedure());

		});
	}

	@Test
	public void whenCreateBpjsSpecialReferralEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSpecialReferralEntity bpjsSpecialReferralEntity;
			Optional<BpjsSpecialReferralEntity> fetchedBpjsSpecialReferralEntity;

			try {
				bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);
				bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSpecialReferralEntity = bpjsSpecialReferralService.create(bpjsSpecialReferralEntity);

			fetchedBpjsSpecialReferralEntity = bpjsSpecialReferralService.findById(bpjsSpecialReferralEntity.getId());

			Assertions.assertTrue(fetchedBpjsSpecialReferralEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsSpecialReferralEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsSpecialReferralEntity, fetchedBpjsSpecialReferralEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsSpecialReferralEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSpecialReferralEntity bpjsSpecialReferralEntity;
			BpjsSpecialReferralEntity updatedBpjsSpecialReferralEntity;
			Optional<BpjsSpecialReferralEntity> fetchedBpjsSpecialReferralEntity;

			try {
				bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);
				bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity, true, true, false);
				updatedBpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);
				bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsSpecialReferralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSpecialReferralEntity = bpjsSpecialReferralService.create(bpjsSpecialReferralEntity);

			updatedBpjsSpecialReferralEntity.setId(bpjsSpecialReferralEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsSpecialReferralEntity.setCreated(bpjsSpecialReferralEntity.getCreated());

			updatedBpjsSpecialReferralEntity = bpjsSpecialReferralService.update(updatedBpjsSpecialReferralEntity);

			fetchedBpjsSpecialReferralEntity = bpjsSpecialReferralService.findById(bpjsSpecialReferralEntity.getId());

			Assertions.assertTrue(fetchedBpjsSpecialReferralEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsSpecialReferralEntity_ThenEntityIsCreated
			fetchedBpjsSpecialReferralEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsSpecialReferralEntity, fetchedBpjsSpecialReferralEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsSpecialReferralEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsSpecialReferralEntity bpjsSpecialReferralEntity;
			Optional<BpjsSpecialReferralEntity> fetchedBpjsSpecialReferralEntity;

			try {
				bpjsSpecialReferralEntity = bpjsSpecialReferralFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSpecialReferralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsSpecialReferralEntity = bpjsSpecialReferralService.create(bpjsSpecialReferralEntity);

			bpjsSpecialReferralService.deleteById(bpjsSpecialReferralEntity.getId());
			fetchedBpjsSpecialReferralEntity = bpjsSpecialReferralService.findById(bpjsSpecialReferralEntity.getId());

			Assertions.assertTrue(fetchedBpjsSpecialReferralEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
