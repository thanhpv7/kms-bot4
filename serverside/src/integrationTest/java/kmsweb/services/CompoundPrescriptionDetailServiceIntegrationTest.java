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
import kmsweb.entities.CompoundPrescriptionDetailEntity;
import kmsweb.repositories.CompoundPrescriptionDetailRepository;
import kmsweb.utils.CompoundPrescriptionDetailFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionDetailDatabasePopulator;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.utils.CompoundPrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionItemDatabasePopulator;
import kmsweb.entities.UnitOfMeasurementEntity;
import kmsweb.repositories.UnitOfMeasurementRepository;
import kmsweb.utils.UnitOfMeasurementFactory;
import kmsweb.utils.DatabasePopulators.UnitOfMeasurementDatabasePopulator;
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
public class CompoundPrescriptionDetailServiceIntegrationTest {

	@Autowired
	private CompoundPrescriptionDetailRepository compoundPrescriptionDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private CompoundPrescriptionDetailService compoundPrescriptionDetailService;

	private final CompoundPrescriptionDetailFactory compoundPrescriptionDetailFactory = new CompoundPrescriptionDetailFactory();

	@Autowired
	private CompoundPrescriptionDetailDatabasePopulator compoundPrescriptionDetailDatabasePopulator;

	@Autowired
	private CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	@Autowired
	private CompoundPrescriptionItemDatabasePopulator compoundPrescriptionItemDatabasePopulator;

	private final CompoundPrescriptionItemFactory compoundPrescriptionItemFactory = new CompoundPrescriptionItemFactory();

	@Autowired
	private UnitOfMeasurementRepository unitOfMeasurementRepository;

	@Autowired
	private UnitOfMeasurementDatabasePopulator unitOfMeasurementDatabasePopulator;

	private final UnitOfMeasurementFactory unitOfMeasurementFactory = new UnitOfMeasurementFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		compoundPrescriptionDetailService = new CompoundPrescriptionDetailService(
			compoundPrescriptionItemRepository,
			unitOfMeasurementRepository,
			validator,
			auditRepository,
			compoundPrescriptionDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewCompoundPrescriptionDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);

		CompoundPrescriptionDetailEntity updatedEntity = compoundPrescriptionDetailService.updateOldData(compoundPrescriptionDetailEntity);
		Assertions.assertEquals(compoundPrescriptionDetailEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewCompoundPrescriptionDetailEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);

		compoundPrescriptionDetailEntity.setIsDtd(null);
		Assertions.assertNull(compoundPrescriptionDetailEntity.getIsDtd());


		CompoundPrescriptionDetailEntity updatedEntity = compoundPrescriptionDetailService.updateOldData(compoundPrescriptionDetailEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsDtd());
		Assertions.assertFalse(updatedEntity.getIsDtd());

	}

	@Test
	public void updateOldDataWithExistingCompoundPrescriptionDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;
			CompoundPrescriptionDetailEntity entityWithUpdatedValues;

			try {
				compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = compoundPrescriptionDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionDetailEntity = compoundPrescriptionDetailService.create(compoundPrescriptionDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(compoundPrescriptionDetailEntity.getId());

			CompoundPrescriptionDetailEntity updatedEntity = compoundPrescriptionDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithCompoundPrescriptionDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);
		compoundPrescriptionDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			compoundPrescriptionDetailService.updateOldData(compoundPrescriptionDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingCompoundPrescriptionDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;
			CompoundPrescriptionDetailEntity updatedCompoundPrescriptionDetailEntity;

			UnitOfMeasurementEntity consumptionUnitEntity;

			Set<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(true, false);
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
			consumptionUnitEntity = compoundPrescriptionDetailEntity.getConsumptionUnit();
			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(consumptionUnitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			consumptionUnitEntity = unitOfMeasurementRepository.save(consumptionUnitEntity);
			compoundPrescriptionDetailEntity.setConsumptionUnitId(consumptionUnitEntity.getId());

			compoundPrescriptionItemsEntities = compoundPrescriptionDetailEntity.getCompoundPrescriptionItems();
			Set<UUID> compoundPrescriptionItemsEntityIds = new HashSet<>();
			for (CompoundPrescriptionItemEntity entity : compoundPrescriptionItemsEntities) {
				try {
					compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				compoundPrescriptionItemsEntityIds.add(compoundPrescriptionItemRepository.save(entity).getId());
			}
			compoundPrescriptionDetailEntity.setCompoundPrescriptionItemsIds(compoundPrescriptionItemsEntityIds);


			compoundPrescriptionDetailEntity = compoundPrescriptionDetailService.create(compoundPrescriptionDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(compoundPrescriptionDetailEntity.getConsumptionUnit());
			compoundPrescriptionDetailEntity.setConsumptionUnitId(null);
			compoundPrescriptionDetailEntity.unsetConsumptionUnit();

			Assertions.assertTrue(compoundPrescriptionDetailEntity.getCompoundPrescriptionItems().size() > 0);
			compoundPrescriptionDetailEntity.setCompoundPrescriptionItemsIds(new HashSet<UUID>());
			compoundPrescriptionDetailEntity.unsetCompoundPrescriptionItems();


			updatedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailService.updateOldData(compoundPrescriptionDetailEntity);

			Assertions.assertNull(updatedCompoundPrescriptionDetailEntity.getConsumptionUnit());

			Assertions.assertEquals(0, updatedCompoundPrescriptionDetailEntity.getCompoundPrescriptionItems().size());

		});
	}

	@Test
	public void updateOldDataWithCompoundPrescriptionDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;
			CompoundPrescriptionDetailEntity updatedCompoundPrescriptionDetailEntity;

			UnitOfMeasurementEntity consumptionUnitEntity;

			Set<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities;
			Set<UUID> compoundPrescriptionItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(true, false);
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
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionDetailEntity.getConsumptionUnit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Consumption Unit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			consumptionUnitEntity = unitOfMeasurementRepository.findById(unitOfMeasurementRepository.save(compoundPrescriptionDetailEntity.getConsumptionUnit()).getId()).get();
			compoundPrescriptionDetailEntity.unsetConsumptionUnit();
			compoundPrescriptionDetailEntity.setConsumptionUnitId(consumptionUnitEntity.getId());

			compoundPrescriptionItemsEntities = new HashSet<>();
			compoundPrescriptionItemsEntityIds = new HashSet<>();
			for (CompoundPrescriptionItemEntity entity : compoundPrescriptionDetailEntity.getCompoundPrescriptionItems()) {
				try {
					compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Compound Prescription Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = compoundPrescriptionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				compoundPrescriptionItemsEntities.add(compoundPrescriptionItemRepository.findById(id).get());
				compoundPrescriptionItemsEntityIds.add(id);
			}
			compoundPrescriptionDetailEntity.unsetCompoundPrescriptionItems();
			compoundPrescriptionDetailEntity.setCompoundPrescriptionItemsIds(compoundPrescriptionItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailService.updateOldData(compoundPrescriptionDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			consumptionUnitEntity.unsetCompoundPrescriptionDetails(false);
			updatedCompoundPrescriptionDetailEntity.getConsumptionUnit().unsetCompoundPrescriptionDetails(false);
			Assertions.assertEquals(consumptionUnitEntity, updatedCompoundPrescriptionDetailEntity.getConsumptionUnit());

			Assertions.assertEquals(compoundPrescriptionItemsEntities.size(), updatedCompoundPrescriptionDetailEntity.getCompoundPrescriptionItems().size());

		});
	}

	@Test
	public void whenCreateCompoundPrescriptionDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;
			Optional<CompoundPrescriptionDetailEntity> fetchedCompoundPrescriptionDetailEntity;

			try {
				compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionDetailEntity = compoundPrescriptionDetailService.create(compoundPrescriptionDetailEntity);

			fetchedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailService.findById(compoundPrescriptionDetailEntity.getId());

			Assertions.assertTrue(fetchedCompoundPrescriptionDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedCompoundPrescriptionDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(compoundPrescriptionDetailEntity, fetchedCompoundPrescriptionDetailEntity.get());
		});
	}

	@Test
	public void whenUpdateCompoundPrescriptionDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;
			CompoundPrescriptionDetailEntity updatedCompoundPrescriptionDetailEntity;
			Optional<CompoundPrescriptionDetailEntity> fetchedCompoundPrescriptionDetailEntity;

			try {
				compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionDetailEntity, true, true, false);
				updatedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedCompoundPrescriptionDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionDetailEntity = compoundPrescriptionDetailService.create(compoundPrescriptionDetailEntity);

			updatedCompoundPrescriptionDetailEntity.setId(compoundPrescriptionDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedCompoundPrescriptionDetailEntity.setCreated(compoundPrescriptionDetailEntity.getCreated());

			updatedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailService.update(updatedCompoundPrescriptionDetailEntity);

			fetchedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailService.findById(compoundPrescriptionDetailEntity.getId());

			Assertions.assertTrue(fetchedCompoundPrescriptionDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateCompoundPrescriptionDetailEntity_ThenEntityIsCreated
			fetchedCompoundPrescriptionDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedCompoundPrescriptionDetailEntity, fetchedCompoundPrescriptionDetailEntity.get());
		});
	}

	@Test
	public void whenDeleteCompoundPrescriptionDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;
			Optional<CompoundPrescriptionDetailEntity> fetchedCompoundPrescriptionDetailEntity;

			try {
				compoundPrescriptionDetailEntity = compoundPrescriptionDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionDetailEntity = compoundPrescriptionDetailService.create(compoundPrescriptionDetailEntity);

			compoundPrescriptionDetailService.deleteById(compoundPrescriptionDetailEntity.getId());
			fetchedCompoundPrescriptionDetailEntity = compoundPrescriptionDetailService.findById(compoundPrescriptionDetailEntity.getId());

			Assertions.assertTrue(fetchedCompoundPrescriptionDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
