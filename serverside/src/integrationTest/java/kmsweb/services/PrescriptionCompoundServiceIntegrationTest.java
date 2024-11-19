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
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.repositories.PrescriptionCompoundRepository;
import kmsweb.utils.PrescriptionCompoundFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionCompoundDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.utils.PrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionItemDatabasePopulator;
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
public class PrescriptionCompoundServiceIntegrationTest {

	@Autowired
	private PrescriptionCompoundRepository prescriptionCompoundRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PrescriptionCompoundService prescriptionCompoundService;

	private final PrescriptionCompoundFactory prescriptionCompoundFactory = new PrescriptionCompoundFactory();

	@Autowired
	private PrescriptionCompoundDatabasePopulator prescriptionCompoundDatabasePopulator;

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private PrescriptionItemRepository prescriptionItemRepository;

	@Autowired
	private PrescriptionItemDatabasePopulator prescriptionItemDatabasePopulator;

	private final PrescriptionItemFactory prescriptionItemFactory = new PrescriptionItemFactory();

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
		prescriptionCompoundService = new PrescriptionCompoundService(
			prescriptionHeaderRepository,
			prescriptionItemRepository,
			unitOfMeasurementRepository,
			validator,
			auditRepository,
			prescriptionCompoundRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPrescriptionCompoundEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PrescriptionCompoundEntity prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);

		PrescriptionCompoundEntity updatedEntity = prescriptionCompoundService.updateOldData(prescriptionCompoundEntity);
		Assertions.assertEquals(prescriptionCompoundEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPrescriptionCompoundEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PrescriptionCompoundEntity prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);

		prescriptionCompoundEntity.setIsDtd(null);
		Assertions.assertNull(prescriptionCompoundEntity.getIsDtd());


		PrescriptionCompoundEntity updatedEntity = prescriptionCompoundService.updateOldData(prescriptionCompoundEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsDtd());
		Assertions.assertFalse(updatedEntity.getIsDtd());

	}

	@Test
	public void updateOldDataWithExistingPrescriptionCompoundEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionCompoundEntity prescriptionCompoundEntity;
			PrescriptionCompoundEntity entityWithUpdatedValues;

			try {
				prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionCompoundEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = prescriptionCompoundFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionCompoundEntity = prescriptionCompoundService.create(prescriptionCompoundEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(prescriptionCompoundEntity.getId());

			PrescriptionCompoundEntity updatedEntity = prescriptionCompoundService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPrescriptionCompoundEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PrescriptionCompoundEntity prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);
		prescriptionCompoundEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			prescriptionCompoundService.updateOldData(prescriptionCompoundEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPrescriptionCompoundEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionCompoundEntity prescriptionCompoundEntity;
			PrescriptionCompoundEntity updatedPrescriptionCompoundEntity;

			UnitOfMeasurementEntity unitEntity;

			PrescriptionHeaderEntity prescriptionHeaderEntity;

			Set<PrescriptionItemEntity> compoundItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(true, false);
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
			unitEntity = prescriptionCompoundEntity.getUnit();
			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			unitEntity = unitOfMeasurementRepository.save(unitEntity);
			prescriptionCompoundEntity.setUnitId(unitEntity.getId());

			prescriptionHeaderEntity = prescriptionCompoundEntity.getPrescriptionHeader();
			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			prescriptionHeaderEntity = prescriptionHeaderRepository.save(prescriptionHeaderEntity);
			prescriptionCompoundEntity.setPrescriptionHeaderId(prescriptionHeaderEntity.getId());

			compoundItemsEntities = prescriptionCompoundEntity.getCompoundItems();
			Set<UUID> compoundItemsEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : compoundItemsEntities) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				compoundItemsEntityIds.add(prescriptionItemRepository.save(entity).getId());
			}
			prescriptionCompoundEntity.setCompoundItemsIds(compoundItemsEntityIds);


			prescriptionCompoundEntity = prescriptionCompoundService.create(prescriptionCompoundEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(prescriptionCompoundEntity.getUnit());
			prescriptionCompoundEntity.setUnitId(null);
			prescriptionCompoundEntity.unsetUnit();

			Assertions.assertNotNull(prescriptionCompoundEntity.getPrescriptionHeader());
			prescriptionCompoundEntity.setPrescriptionHeaderId(null);
			prescriptionCompoundEntity.unsetPrescriptionHeader();

			Assertions.assertTrue(prescriptionCompoundEntity.getCompoundItems().size() > 0);
			prescriptionCompoundEntity.setCompoundItemsIds(new HashSet<UUID>());
			prescriptionCompoundEntity.unsetCompoundItems();


			updatedPrescriptionCompoundEntity = prescriptionCompoundService.updateOldData(prescriptionCompoundEntity);

			Assertions.assertNull(updatedPrescriptionCompoundEntity.getUnit());

			Assertions.assertNull(updatedPrescriptionCompoundEntity.getPrescriptionHeader());

			Assertions.assertEquals(0, updatedPrescriptionCompoundEntity.getCompoundItems().size());

		});
	}

	@Test
	public void updateOldDataWithPrescriptionCompoundEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionCompoundEntity prescriptionCompoundEntity;
			PrescriptionCompoundEntity updatedPrescriptionCompoundEntity;

			UnitOfMeasurementEntity unitEntity;

			PrescriptionHeaderEntity prescriptionHeaderEntity;

			Set<PrescriptionItemEntity> compoundItemsEntities;
			Set<UUID> compoundItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(true, false);
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
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionCompoundEntity.getUnit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Unit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			unitEntity = unitOfMeasurementRepository.findById(unitOfMeasurementRepository.save(prescriptionCompoundEntity.getUnit()).getId()).get();
			prescriptionCompoundEntity.unsetUnit();
			prescriptionCompoundEntity.setUnitId(unitEntity.getId());

			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionCompoundEntity.getPrescriptionHeader(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Prescription Header relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			prescriptionHeaderEntity = prescriptionHeaderRepository.findById(prescriptionHeaderRepository.save(prescriptionCompoundEntity.getPrescriptionHeader()).getId()).get();
			prescriptionCompoundEntity.unsetPrescriptionHeader();
			prescriptionCompoundEntity.setPrescriptionHeaderId(prescriptionHeaderEntity.getId());

			compoundItemsEntities = new HashSet<>();
			compoundItemsEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : prescriptionCompoundEntity.getCompoundItems()) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Compound Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				compoundItemsEntities.add(prescriptionItemRepository.findById(id).get());
				compoundItemsEntityIds.add(id);
			}
			prescriptionCompoundEntity.unsetCompoundItems();
			prescriptionCompoundEntity.setCompoundItemsIds(compoundItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPrescriptionCompoundEntity = prescriptionCompoundService.updateOldData(prescriptionCompoundEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			unitEntity.unsetCompoundsUnit(false);
			updatedPrescriptionCompoundEntity.getUnit().unsetCompoundsUnit(false);
			Assertions.assertEquals(unitEntity, updatedPrescriptionCompoundEntity.getUnit());

			prescriptionHeaderEntity.unsetPrescriptionCompounds(false);
			updatedPrescriptionCompoundEntity.getPrescriptionHeader().unsetPrescriptionCompounds(false);
			Assertions.assertEquals(prescriptionHeaderEntity, updatedPrescriptionCompoundEntity.getPrescriptionHeader());

			Assertions.assertEquals(compoundItemsEntities.size(), updatedPrescriptionCompoundEntity.getCompoundItems().size());

		});
	}

	@Test
	public void whenCreatePrescriptionCompoundEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionCompoundEntity prescriptionCompoundEntity;
			Optional<PrescriptionCompoundEntity> fetchedPrescriptionCompoundEntity;

			try {
				prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionCompoundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionCompoundEntity = prescriptionCompoundService.create(prescriptionCompoundEntity);

			fetchedPrescriptionCompoundEntity = prescriptionCompoundService.findById(prescriptionCompoundEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionCompoundEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPrescriptionCompoundEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(prescriptionCompoundEntity, fetchedPrescriptionCompoundEntity.get());
		});
	}

	@Test
	public void whenUpdatePrescriptionCompoundEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionCompoundEntity prescriptionCompoundEntity;
			PrescriptionCompoundEntity updatedPrescriptionCompoundEntity;
			Optional<PrescriptionCompoundEntity> fetchedPrescriptionCompoundEntity;

			try {
				prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionCompoundEntity, true, true, false);
				updatedPrescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPrescriptionCompoundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionCompoundEntity = prescriptionCompoundService.create(prescriptionCompoundEntity);

			updatedPrescriptionCompoundEntity.setId(prescriptionCompoundEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPrescriptionCompoundEntity.setCreated(prescriptionCompoundEntity.getCreated());

			updatedPrescriptionCompoundEntity = prescriptionCompoundService.update(updatedPrescriptionCompoundEntity);

			fetchedPrescriptionCompoundEntity = prescriptionCompoundService.findById(prescriptionCompoundEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionCompoundEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePrescriptionCompoundEntity_ThenEntityIsCreated
			fetchedPrescriptionCompoundEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPrescriptionCompoundEntity, fetchedPrescriptionCompoundEntity.get());
		});
	}

	@Test
	public void whenDeletePrescriptionCompoundEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionCompoundEntity prescriptionCompoundEntity;
			Optional<PrescriptionCompoundEntity> fetchedPrescriptionCompoundEntity;

			try {
				prescriptionCompoundEntity = prescriptionCompoundFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionCompoundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionCompoundEntity = prescriptionCompoundService.create(prescriptionCompoundEntity);

			prescriptionCompoundService.deleteById(prescriptionCompoundEntity.getId());
			fetchedPrescriptionCompoundEntity = prescriptionCompoundService.findById(prescriptionCompoundEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionCompoundEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
