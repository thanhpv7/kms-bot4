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
import kmsweb.entities.HealthFacilityEntity;
import kmsweb.repositories.HealthFacilityRepository;
import kmsweb.utils.HealthFacilityFactory;
import kmsweb.utils.DatabasePopulators.HealthFacilityDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
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
public class HealthFacilityServiceIntegrationTest {

	@Autowired
	private HealthFacilityRepository healthFacilityRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private HealthFacilityService healthFacilityService;

	private final HealthFacilityFactory healthFacilityFactory = new HealthFacilityFactory();

	@Autowired
	private HealthFacilityDatabasePopulator healthFacilityDatabasePopulator;

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		healthFacilityService = new HealthFacilityService(
			registrationRepository,
			validator,
			auditRepository,
			healthFacilityRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewHealthFacilityEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		HealthFacilityEntity healthFacilityEntity = healthFacilityFactory.getObject(false, false);

		HealthFacilityEntity updatedEntity = healthFacilityService.updateOldData(healthFacilityEntity);
		Assertions.assertEquals(healthFacilityEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingHealthFacilityEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			HealthFacilityEntity healthFacilityEntity;
			HealthFacilityEntity entityWithUpdatedValues;

			try {
				healthFacilityEntity = healthFacilityFactory.getObject(false, false);
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(healthFacilityEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = healthFacilityFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			healthFacilityEntity = healthFacilityService.create(healthFacilityEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(healthFacilityEntity.getId());

			HealthFacilityEntity updatedEntity = healthFacilityService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithHealthFacilityEntityWithNonExistentId_ShouldThrowException() throws Exception {
		HealthFacilityEntity healthFacilityEntity = healthFacilityFactory.getObject(false, false);
		healthFacilityEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			healthFacilityService.updateOldData(healthFacilityEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingHealthFacilityEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HealthFacilityEntity healthFacilityEntity;
			HealthFacilityEntity updatedHealthFacilityEntity;

			Set<RegistrationEntity> dismissalReferringFacilityEntities;

			Set<RegistrationEntity> referringFacilityEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				healthFacilityEntity = healthFacilityFactory.getObject(true, false);
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
			dismissalReferringFacilityEntities = healthFacilityEntity.getDismissalReferringFacility();
			Set<UUID> dismissalReferringFacilityEntityIds = new HashSet<>();
			for (RegistrationEntity entity : dismissalReferringFacilityEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dismissalReferringFacilityEntityIds.add(registrationRepository.save(entity).getId());
			}
			healthFacilityEntity.setDismissalReferringFacilityIds(dismissalReferringFacilityEntityIds);

			referringFacilityEntities = healthFacilityEntity.getReferringFacility();
			Set<UUID> referringFacilityEntityIds = new HashSet<>();
			for (RegistrationEntity entity : referringFacilityEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				referringFacilityEntityIds.add(registrationRepository.save(entity).getId());
			}
			healthFacilityEntity.setReferringFacilityIds(referringFacilityEntityIds);


			healthFacilityEntity = healthFacilityService.create(healthFacilityEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(healthFacilityEntity.getDismissalReferringFacility().size() > 0);
			healthFacilityEntity.setDismissalReferringFacilityIds(new HashSet<UUID>());
			healthFacilityEntity.unsetDismissalReferringFacility();

			Assertions.assertTrue(healthFacilityEntity.getReferringFacility().size() > 0);
			healthFacilityEntity.setReferringFacilityIds(new HashSet<UUID>());
			healthFacilityEntity.unsetReferringFacility();


			updatedHealthFacilityEntity = healthFacilityService.updateOldData(healthFacilityEntity);

			Assertions.assertEquals(0, updatedHealthFacilityEntity.getDismissalReferringFacility().size());

			Assertions.assertEquals(0, updatedHealthFacilityEntity.getReferringFacility().size());

		});
	}

	@Test
	public void updateOldDataWithHealthFacilityEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HealthFacilityEntity healthFacilityEntity;
			HealthFacilityEntity updatedHealthFacilityEntity;

			Set<RegistrationEntity> dismissalReferringFacilityEntities;
			Set<UUID> dismissalReferringFacilityEntityIds;

			Set<RegistrationEntity> referringFacilityEntities;
			Set<UUID> referringFacilityEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				healthFacilityEntity = healthFacilityFactory.getObject(true, false);
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
			dismissalReferringFacilityEntities = new HashSet<>();
			dismissalReferringFacilityEntityIds = new HashSet<>();
			for (RegistrationEntity entity : healthFacilityEntity.getDismissalReferringFacility()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Dismissal Referring Facility relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dismissalReferringFacilityEntities.add(registrationRepository.findById(id).get());
				dismissalReferringFacilityEntityIds.add(id);
			}
			healthFacilityEntity.unsetDismissalReferringFacility();
			healthFacilityEntity.setDismissalReferringFacilityIds(dismissalReferringFacilityEntityIds);

			referringFacilityEntities = new HashSet<>();
			referringFacilityEntityIds = new HashSet<>();
			for (RegistrationEntity entity : healthFacilityEntity.getReferringFacility()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Referring facility relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				referringFacilityEntities.add(registrationRepository.findById(id).get());
				referringFacilityEntityIds.add(id);
			}
			healthFacilityEntity.unsetReferringFacility();
			healthFacilityEntity.setReferringFacilityIds(referringFacilityEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedHealthFacilityEntity = healthFacilityService.updateOldData(healthFacilityEntity);

			Assertions.assertEquals(dismissalReferringFacilityEntities.size(), updatedHealthFacilityEntity.getDismissalReferringFacility().size());

			Assertions.assertEquals(referringFacilityEntities.size(), updatedHealthFacilityEntity.getReferringFacility().size());

		});
	}

	@Test
	public void whenCreateHealthFacilityEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			HealthFacilityEntity healthFacilityEntity;
			Optional<HealthFacilityEntity> fetchedHealthFacilityEntity;

			try {
				healthFacilityEntity = healthFacilityFactory.getObject(false, false);
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(healthFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			healthFacilityEntity = healthFacilityService.create(healthFacilityEntity);

			fetchedHealthFacilityEntity = healthFacilityService.findById(healthFacilityEntity.getId());

			Assertions.assertTrue(fetchedHealthFacilityEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedHealthFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(healthFacilityEntity, fetchedHealthFacilityEntity.get());
		});
	}

	@Test
	public void whenUpdateHealthFacilityEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			HealthFacilityEntity healthFacilityEntity;
			HealthFacilityEntity updatedHealthFacilityEntity;
			Optional<HealthFacilityEntity> fetchedHealthFacilityEntity;

			try {
				healthFacilityEntity = healthFacilityFactory.getObject(false, false);
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(healthFacilityEntity, true, true, false);
				updatedHealthFacilityEntity = healthFacilityFactory.getObject(false, false);
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(updatedHealthFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			healthFacilityEntity = healthFacilityService.create(healthFacilityEntity);

			updatedHealthFacilityEntity.setId(healthFacilityEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedHealthFacilityEntity.setCreated(healthFacilityEntity.getCreated());

			updatedHealthFacilityEntity = healthFacilityService.update(updatedHealthFacilityEntity);

			fetchedHealthFacilityEntity = healthFacilityService.findById(healthFacilityEntity.getId());

			Assertions.assertTrue(fetchedHealthFacilityEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateHealthFacilityEntity_ThenEntityIsCreated
			fetchedHealthFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedHealthFacilityEntity, fetchedHealthFacilityEntity.get());
		});
	}

	@Test
	public void whenDeleteHealthFacilityEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			HealthFacilityEntity healthFacilityEntity;
			Optional<HealthFacilityEntity> fetchedHealthFacilityEntity;

			try {
				healthFacilityEntity = healthFacilityFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(healthFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			healthFacilityEntity = healthFacilityService.create(healthFacilityEntity);

			healthFacilityService.deleteById(healthFacilityEntity.getId());
			fetchedHealthFacilityEntity = healthFacilityService.findById(healthFacilityEntity.getId());

			Assertions.assertTrue(fetchedHealthFacilityEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
