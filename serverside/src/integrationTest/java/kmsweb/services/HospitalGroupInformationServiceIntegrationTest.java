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
import kmsweb.entities.HospitalGroupInformationEntity;
import kmsweb.repositories.HospitalGroupInformationRepository;
import kmsweb.utils.HospitalGroupInformationFactory;
import kmsweb.utils.DatabasePopulators.HospitalGroupInformationDatabasePopulator;
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.utils.HospitalBranchInformationFactory;
import kmsweb.utils.DatabasePopulators.HospitalBranchInformationDatabasePopulator;
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
public class HospitalGroupInformationServiceIntegrationTest {

	@Autowired
	private HospitalGroupInformationRepository hospitalGroupInformationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private HospitalGroupInformationService hospitalGroupInformationService;

	private final HospitalGroupInformationFactory hospitalGroupInformationFactory = new HospitalGroupInformationFactory();

	@Autowired
	private HospitalGroupInformationDatabasePopulator hospitalGroupInformationDatabasePopulator;

	@Autowired
	private HospitalBranchInformationRepository hospitalBranchInformationRepository;

	@Autowired
	private HospitalBranchInformationDatabasePopulator hospitalBranchInformationDatabasePopulator;

	private final HospitalBranchInformationFactory hospitalBranchInformationFactory = new HospitalBranchInformationFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		hospitalGroupInformationService = new HospitalGroupInformationService(
			hospitalBranchInformationRepository,
			validator,
			auditRepository,
			hospitalGroupInformationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewHospitalGroupInformationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		HospitalGroupInformationEntity hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);

		HospitalGroupInformationEntity updatedEntity = hospitalGroupInformationService.updateOldData(hospitalGroupInformationEntity);
		Assertions.assertEquals(hospitalGroupInformationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingHospitalGroupInformationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalGroupInformationEntity hospitalGroupInformationEntity;
			HospitalGroupInformationEntity entityWithUpdatedValues;

			try {
				hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalGroupInformationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = hospitalGroupInformationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalGroupInformationEntity = hospitalGroupInformationService.create(hospitalGroupInformationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(hospitalGroupInformationEntity.getId());

			HospitalGroupInformationEntity updatedEntity = hospitalGroupInformationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithHospitalGroupInformationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		HospitalGroupInformationEntity hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);
		hospitalGroupInformationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			hospitalGroupInformationService.updateOldData(hospitalGroupInformationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingHospitalGroupInformationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalGroupInformationEntity hospitalGroupInformationEntity;
			HospitalGroupInformationEntity updatedHospitalGroupInformationEntity;

			Set<HospitalBranchInformationEntity> hospitalBranchInformationsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(true, false);
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
			hospitalBranchInformationsEntities = hospitalGroupInformationEntity.getHospitalBranchInformations();
			Set<UUID> hospitalBranchInformationsEntityIds = new HashSet<>();
			for (HospitalBranchInformationEntity entity : hospitalBranchInformationsEntities) {
				try {
					hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				hospitalBranchInformationsEntityIds.add(hospitalBranchInformationRepository.save(entity).getId());
			}
			hospitalGroupInformationEntity.setHospitalBranchInformationsIds(hospitalBranchInformationsEntityIds);


			hospitalGroupInformationEntity = hospitalGroupInformationService.create(hospitalGroupInformationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(hospitalGroupInformationEntity.getHospitalBranchInformations().size() > 0);
			hospitalGroupInformationEntity.setHospitalBranchInformationsIds(new HashSet<UUID>());
			hospitalGroupInformationEntity.unsetHospitalBranchInformations();


			updatedHospitalGroupInformationEntity = hospitalGroupInformationService.updateOldData(hospitalGroupInformationEntity);

			Assertions.assertEquals(0, updatedHospitalGroupInformationEntity.getHospitalBranchInformations().size());

		});
	}

	@Test
	public void updateOldDataWithHospitalGroupInformationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalGroupInformationEntity hospitalGroupInformationEntity;
			HospitalGroupInformationEntity updatedHospitalGroupInformationEntity;

			Set<HospitalBranchInformationEntity> hospitalBranchInformationsEntities;
			Set<UUID> hospitalBranchInformationsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(true, false);
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
			hospitalBranchInformationsEntities = new HashSet<>();
			hospitalBranchInformationsEntityIds = new HashSet<>();
			for (HospitalBranchInformationEntity entity : hospitalGroupInformationEntity.getHospitalBranchInformations()) {
				try {
					hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Hospital Branch Informations relation for this test: " + e.getCause());
					return;
				}
				UUID id = hospitalBranchInformationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				hospitalBranchInformationsEntities.add(hospitalBranchInformationRepository.findById(id).get());
				hospitalBranchInformationsEntityIds.add(id);
			}
			hospitalGroupInformationEntity.unsetHospitalBranchInformations();
			hospitalGroupInformationEntity.setHospitalBranchInformationsIds(hospitalBranchInformationsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedHospitalGroupInformationEntity = hospitalGroupInformationService.updateOldData(hospitalGroupInformationEntity);

			Assertions.assertEquals(hospitalBranchInformationsEntities.size(), updatedHospitalGroupInformationEntity.getHospitalBranchInformations().size());

		});
	}

	@Test
	public void whenCreateHospitalGroupInformationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalGroupInformationEntity hospitalGroupInformationEntity;
			Optional<HospitalGroupInformationEntity> fetchedHospitalGroupInformationEntity;

			try {
				hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalGroupInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalGroupInformationEntity = hospitalGroupInformationService.create(hospitalGroupInformationEntity);

			fetchedHospitalGroupInformationEntity = hospitalGroupInformationService.findById(hospitalGroupInformationEntity.getId());

			Assertions.assertTrue(fetchedHospitalGroupInformationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedHospitalGroupInformationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(hospitalGroupInformationEntity, fetchedHospitalGroupInformationEntity.get());
		});
	}

	@Test
	public void whenUpdateHospitalGroupInformationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalGroupInformationEntity hospitalGroupInformationEntity;
			HospitalGroupInformationEntity updatedHospitalGroupInformationEntity;
			Optional<HospitalGroupInformationEntity> fetchedHospitalGroupInformationEntity;

			try {
				hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalGroupInformationEntity, true, true, false);
				updatedHospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedHospitalGroupInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalGroupInformationEntity = hospitalGroupInformationService.create(hospitalGroupInformationEntity);

			updatedHospitalGroupInformationEntity.setId(hospitalGroupInformationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedHospitalGroupInformationEntity.setCreated(hospitalGroupInformationEntity.getCreated());

			updatedHospitalGroupInformationEntity = hospitalGroupInformationService.update(updatedHospitalGroupInformationEntity);

			fetchedHospitalGroupInformationEntity = hospitalGroupInformationService.findById(hospitalGroupInformationEntity.getId());

			Assertions.assertTrue(fetchedHospitalGroupInformationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateHospitalGroupInformationEntity_ThenEntityIsCreated
			fetchedHospitalGroupInformationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedHospitalGroupInformationEntity, fetchedHospitalGroupInformationEntity.get());
		});
	}

	@Test
	public void whenDeleteHospitalGroupInformationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalGroupInformationEntity hospitalGroupInformationEntity;
			Optional<HospitalGroupInformationEntity> fetchedHospitalGroupInformationEntity;

			try {
				hospitalGroupInformationEntity = hospitalGroupInformationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalGroupInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalGroupInformationEntity = hospitalGroupInformationService.create(hospitalGroupInformationEntity);

			hospitalGroupInformationService.deleteById(hospitalGroupInformationEntity.getId());
			fetchedHospitalGroupInformationEntity = hospitalGroupInformationService.findById(hospitalGroupInformationEntity.getId());

			Assertions.assertTrue(fetchedHospitalGroupInformationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
