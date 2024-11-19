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
import kmsweb.entities.VitalSignsEntity;
import kmsweb.repositories.VitalSignsRepository;
import kmsweb.utils.VitalSignsFactory;
import kmsweb.utils.DatabasePopulators.VitalSignsDatabasePopulator;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.utils.NewbornDetailFactory;
import kmsweb.utils.DatabasePopulators.NewbornDetailDatabasePopulator;
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
public class VitalSignsServiceIntegrationTest {

	@Autowired
	private VitalSignsRepository vitalSignsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private VitalSignsService vitalSignsService;

	private final VitalSignsFactory vitalSignsFactory = new VitalSignsFactory();

	@Autowired
	private VitalSignsDatabasePopulator vitalSignsDatabasePopulator;

	@Autowired
	private NewbornDetailRepository newbornDetailRepository;

	@Autowired
	private NewbornDetailDatabasePopulator newbornDetailDatabasePopulator;

	private final NewbornDetailFactory newbornDetailFactory = new NewbornDetailFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		vitalSignsService = new VitalSignsService(
			newbornDetailRepository,
			validator,
			auditRepository,
			vitalSignsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewVitalSignsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		VitalSignsEntity vitalSignsEntity = vitalSignsFactory.getObject(false, false);

		VitalSignsEntity updatedEntity = vitalSignsService.updateOldData(vitalSignsEntity);
		Assertions.assertEquals(vitalSignsEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingVitalSignsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			VitalSignsEntity vitalSignsEntity;
			VitalSignsEntity entityWithUpdatedValues;

			try {
				vitalSignsEntity = vitalSignsFactory.getObject(false, false);
				vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(vitalSignsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = vitalSignsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vitalSignsEntity = vitalSignsService.create(vitalSignsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(vitalSignsEntity.getId());

			VitalSignsEntity updatedEntity = vitalSignsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithVitalSignsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		VitalSignsEntity vitalSignsEntity = vitalSignsFactory.getObject(false, false);
		vitalSignsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			vitalSignsService.updateOldData(vitalSignsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingVitalSignsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			VitalSignsEntity vitalSignsEntity;
			VitalSignsEntity updatedVitalSignsEntity;

			NewbornDetailEntity newbornDetailEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				vitalSignsEntity = vitalSignsFactory.getObject(true, false);
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
			newbornDetailEntity = vitalSignsEntity.getNewbornDetail();
			try {
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			newbornDetailEntity = newbornDetailRepository.save(newbornDetailEntity);
			vitalSignsEntity.setNewbornDetailId(newbornDetailEntity.getId());


			vitalSignsEntity = vitalSignsService.create(vitalSignsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(vitalSignsEntity.getNewbornDetail());
			vitalSignsEntity.setNewbornDetailId(null);
			vitalSignsEntity.unsetNewbornDetail();


			updatedVitalSignsEntity = vitalSignsService.updateOldData(vitalSignsEntity);

			Assertions.assertNull(updatedVitalSignsEntity.getNewbornDetail());

		});
	}

	@Test
	public void updateOldDataWithVitalSignsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			VitalSignsEntity vitalSignsEntity;
			VitalSignsEntity updatedVitalSignsEntity;

			NewbornDetailEntity newbornDetailEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				vitalSignsEntity = vitalSignsFactory.getObject(true, false);
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
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(vitalSignsEntity.getNewbornDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Newborn Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			newbornDetailEntity = newbornDetailRepository.findById(newbornDetailRepository.save(vitalSignsEntity.getNewbornDetail()).getId()).get();
			vitalSignsEntity.unsetNewbornDetail();
			vitalSignsEntity.setNewbornDetailId(newbornDetailEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedVitalSignsEntity = vitalSignsService.updateOldData(vitalSignsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			newbornDetailEntity.unsetVitalSigns(false);
			updatedVitalSignsEntity.getNewbornDetail().unsetVitalSigns(false);
			Assertions.assertEquals(newbornDetailEntity, updatedVitalSignsEntity.getNewbornDetail());

		});
	}

	@Test
	public void whenCreateVitalSignsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			VitalSignsEntity vitalSignsEntity;
			Optional<VitalSignsEntity> fetchedVitalSignsEntity;

			try {
				vitalSignsEntity = vitalSignsFactory.getObject(false, false);
				vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(vitalSignsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vitalSignsEntity = vitalSignsService.create(vitalSignsEntity);

			fetchedVitalSignsEntity = vitalSignsService.findById(vitalSignsEntity.getId());

			Assertions.assertTrue(fetchedVitalSignsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedVitalSignsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(vitalSignsEntity, fetchedVitalSignsEntity.get());
		});
	}

	@Test
	public void whenUpdateVitalSignsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			VitalSignsEntity vitalSignsEntity;
			VitalSignsEntity updatedVitalSignsEntity;
			Optional<VitalSignsEntity> fetchedVitalSignsEntity;

			try {
				vitalSignsEntity = vitalSignsFactory.getObject(false, false);
				vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(vitalSignsEntity, true, true, false);
				updatedVitalSignsEntity = vitalSignsFactory.getObject(false, false);
				vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedVitalSignsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vitalSignsEntity = vitalSignsService.create(vitalSignsEntity);

			updatedVitalSignsEntity.setId(vitalSignsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedVitalSignsEntity.setCreated(vitalSignsEntity.getCreated());

			updatedVitalSignsEntity = vitalSignsService.update(updatedVitalSignsEntity);

			fetchedVitalSignsEntity = vitalSignsService.findById(vitalSignsEntity.getId());

			Assertions.assertTrue(fetchedVitalSignsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateVitalSignsEntity_ThenEntityIsCreated
			fetchedVitalSignsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedVitalSignsEntity, fetchedVitalSignsEntity.get());
		});
	}

	@Test
	public void whenDeleteVitalSignsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			VitalSignsEntity vitalSignsEntity;
			Optional<VitalSignsEntity> fetchedVitalSignsEntity;

			try {
				vitalSignsEntity = vitalSignsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(vitalSignsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vitalSignsEntity = vitalSignsService.create(vitalSignsEntity);

			vitalSignsService.deleteById(vitalSignsEntity.getId());
			fetchedVitalSignsEntity = vitalSignsService.findById(vitalSignsEntity.getId());

			Assertions.assertTrue(fetchedVitalSignsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
