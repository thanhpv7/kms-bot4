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
import kmsweb.entities.UnitOfMeasurementEntity;
import kmsweb.repositories.UnitOfMeasurementRepository;
import kmsweb.utils.UnitOfMeasurementFactory;
import kmsweb.utils.DatabasePopulators.UnitOfMeasurementDatabasePopulator;
import kmsweb.entities.CatalogueUOMEntity;
import kmsweb.repositories.CatalogueUOMRepository;
import kmsweb.utils.CatalogueUOMFactory;
import kmsweb.utils.DatabasePopulators.CatalogueUOMDatabasePopulator;
import kmsweb.entities.CompoundPrescriptionDetailEntity;
import kmsweb.repositories.CompoundPrescriptionDetailRepository;
import kmsweb.utils.CompoundPrescriptionDetailFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionDetailDatabasePopulator;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.utils.CompoundPrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionItemDatabasePopulator;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.utils.MedicationCompoundFactory;
import kmsweb.utils.DatabasePopulators.MedicationCompoundDatabasePopulator;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.utils.MedicationItemFactory;
import kmsweb.utils.DatabasePopulators.MedicationItemDatabasePopulator;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.repositories.PrescriptionCompoundRepository;
import kmsweb.utils.PrescriptionCompoundFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionCompoundDatabasePopulator;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.utils.PrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionItemDatabasePopulator;
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
public class UnitOfMeasurementServiceIntegrationTest {

	@Autowired
	private UnitOfMeasurementRepository unitOfMeasurementRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private UnitOfMeasurementService unitOfMeasurementService;

	private final UnitOfMeasurementFactory unitOfMeasurementFactory = new UnitOfMeasurementFactory();

	@Autowired
	private UnitOfMeasurementDatabasePopulator unitOfMeasurementDatabasePopulator;

	@Autowired
	private CatalogueUOMRepository catalogueUOMRepository;

	@Autowired
	private CatalogueUOMDatabasePopulator catalogueUOMDatabasePopulator;

	private final CatalogueUOMFactory catalogueUOMFactory = new CatalogueUOMFactory();

	@Autowired
	private CompoundPrescriptionDetailRepository compoundPrescriptionDetailRepository;

	@Autowired
	private CompoundPrescriptionDetailDatabasePopulator compoundPrescriptionDetailDatabasePopulator;

	private final CompoundPrescriptionDetailFactory compoundPrescriptionDetailFactory = new CompoundPrescriptionDetailFactory();

	@Autowired
	private CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	@Autowired
	private CompoundPrescriptionItemDatabasePopulator compoundPrescriptionItemDatabasePopulator;

	private final CompoundPrescriptionItemFactory compoundPrescriptionItemFactory = new CompoundPrescriptionItemFactory();

	@Autowired
	private MedicationCompoundRepository medicationCompoundRepository;

	@Autowired
	private MedicationCompoundDatabasePopulator medicationCompoundDatabasePopulator;

	private final MedicationCompoundFactory medicationCompoundFactory = new MedicationCompoundFactory();

	@Autowired
	private MedicationItemRepository medicationItemRepository;

	@Autowired
	private MedicationItemDatabasePopulator medicationItemDatabasePopulator;

	private final MedicationItemFactory medicationItemFactory = new MedicationItemFactory();

	@Autowired
	private PrescriptionCompoundRepository prescriptionCompoundRepository;

	@Autowired
	private PrescriptionCompoundDatabasePopulator prescriptionCompoundDatabasePopulator;

	private final PrescriptionCompoundFactory prescriptionCompoundFactory = new PrescriptionCompoundFactory();

	@Autowired
	private PrescriptionItemRepository prescriptionItemRepository;

	@Autowired
	private PrescriptionItemDatabasePopulator prescriptionItemDatabasePopulator;

	private final PrescriptionItemFactory prescriptionItemFactory = new PrescriptionItemFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		unitOfMeasurementService = new UnitOfMeasurementService(
			catalogueUOMRepository,
			compoundPrescriptionDetailRepository,
			compoundPrescriptionItemRepository,
			medicationCompoundRepository,
			medicationItemRepository,
			prescriptionCompoundRepository,
			prescriptionItemRepository,
			validator,
			auditRepository,
			unitOfMeasurementRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewUnitOfMeasurementEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		UnitOfMeasurementEntity unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);

		UnitOfMeasurementEntity updatedEntity = unitOfMeasurementService.updateOldData(unitOfMeasurementEntity);
		Assertions.assertEquals(unitOfMeasurementEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewUnitOfMeasurementEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		UnitOfMeasurementEntity unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);

		unitOfMeasurementEntity.setConsumptionUnit(null);
		Assertions.assertNull(unitOfMeasurementEntity.getConsumptionUnit());


		UnitOfMeasurementEntity updatedEntity = unitOfMeasurementService.updateOldData(unitOfMeasurementEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getConsumptionUnit());
		Assertions.assertFalse(updatedEntity.getConsumptionUnit());

	}

	@Test
	public void updateOldDataWithExistingUnitOfMeasurementEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			UnitOfMeasurementEntity unitOfMeasurementEntity;
			UnitOfMeasurementEntity entityWithUpdatedValues;

			try {
				unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = unitOfMeasurementFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			unitOfMeasurementEntity = unitOfMeasurementService.create(unitOfMeasurementEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(unitOfMeasurementEntity.getId());

			UnitOfMeasurementEntity updatedEntity = unitOfMeasurementService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithUnitOfMeasurementEntityWithNonExistentId_ShouldThrowException() throws Exception {
		UnitOfMeasurementEntity unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);
		unitOfMeasurementEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			unitOfMeasurementService.updateOldData(unitOfMeasurementEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingUnitOfMeasurementEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			UnitOfMeasurementEntity unitOfMeasurementEntity;
			UnitOfMeasurementEntity updatedUnitOfMeasurementEntity;

			CatalogueUOMEntity catalogueUOMEntity;

			Set<CompoundPrescriptionDetailEntity> compoundPrescriptionDetailsEntities;

			Set<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities;

			Set<PrescriptionCompoundEntity> compoundsUnitEntities;

			Set<MedicationCompoundEntity> medicationCompoundsEntities;

			Set<MedicationItemEntity> medicationItemsEntities;

			Set<PrescriptionItemEntity> prescriptionItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(true, false);
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
			catalogueUOMEntity = unitOfMeasurementEntity.getCatalogueUOM();
			try {
				catalogueUOMDatabasePopulator.populateRelatedEntitiesInDatabase(catalogueUOMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			catalogueUOMEntity = catalogueUOMRepository.save(catalogueUOMEntity);
			unitOfMeasurementEntity.setCatalogueUOMId(catalogueUOMEntity.getId());

			compoundPrescriptionDetailsEntities = unitOfMeasurementEntity.getCompoundPrescriptionDetails();
			Set<UUID> compoundPrescriptionDetailsEntityIds = new HashSet<>();
			for (CompoundPrescriptionDetailEntity entity : compoundPrescriptionDetailsEntities) {
				try {
					compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				compoundPrescriptionDetailsEntityIds.add(compoundPrescriptionDetailRepository.save(entity).getId());
			}
			unitOfMeasurementEntity.setCompoundPrescriptionDetailsIds(compoundPrescriptionDetailsEntityIds);

			compoundPrescriptionItemsEntities = unitOfMeasurementEntity.getCompoundPrescriptionItems();
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
			unitOfMeasurementEntity.setCompoundPrescriptionItemsIds(compoundPrescriptionItemsEntityIds);

			compoundsUnitEntities = unitOfMeasurementEntity.getCompoundsUnit();
			Set<UUID> compoundsUnitEntityIds = new HashSet<>();
			for (PrescriptionCompoundEntity entity : compoundsUnitEntities) {
				try {
					prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				compoundsUnitEntityIds.add(prescriptionCompoundRepository.save(entity).getId());
			}
			unitOfMeasurementEntity.setCompoundsUnitIds(compoundsUnitEntityIds);

			medicationCompoundsEntities = unitOfMeasurementEntity.getMedicationCompounds();
			Set<UUID> medicationCompoundsEntityIds = new HashSet<>();
			for (MedicationCompoundEntity entity : medicationCompoundsEntities) {
				try {
					medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationCompoundsEntityIds.add(medicationCompoundRepository.save(entity).getId());
			}
			unitOfMeasurementEntity.setMedicationCompoundsIds(medicationCompoundsEntityIds);

			medicationItemsEntities = unitOfMeasurementEntity.getMedicationItems();
			Set<UUID> medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : medicationItemsEntities) {
				try {
					medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationItemsEntityIds.add(medicationItemRepository.save(entity).getId());
			}
			unitOfMeasurementEntity.setMedicationItemsIds(medicationItemsEntityIds);

			prescriptionItemsEntities = unitOfMeasurementEntity.getPrescriptionItems();
			Set<UUID> prescriptionItemsEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : prescriptionItemsEntities) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				prescriptionItemsEntityIds.add(prescriptionItemRepository.save(entity).getId());
			}
			unitOfMeasurementEntity.setPrescriptionItemsIds(prescriptionItemsEntityIds);


			unitOfMeasurementEntity = unitOfMeasurementService.create(unitOfMeasurementEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(unitOfMeasurementEntity.getCatalogueUOM());
			unitOfMeasurementEntity.setCatalogueUOMId(null);
			unitOfMeasurementEntity.unsetCatalogueUOM();

			Assertions.assertTrue(unitOfMeasurementEntity.getCompoundPrescriptionDetails().size() > 0);
			unitOfMeasurementEntity.setCompoundPrescriptionDetailsIds(new HashSet<UUID>());
			unitOfMeasurementEntity.unsetCompoundPrescriptionDetails();

			Assertions.assertTrue(unitOfMeasurementEntity.getCompoundPrescriptionItems().size() > 0);
			unitOfMeasurementEntity.setCompoundPrescriptionItemsIds(new HashSet<UUID>());
			unitOfMeasurementEntity.unsetCompoundPrescriptionItems();

			Assertions.assertTrue(unitOfMeasurementEntity.getCompoundsUnit().size() > 0);
			unitOfMeasurementEntity.setCompoundsUnitIds(new HashSet<UUID>());
			unitOfMeasurementEntity.unsetCompoundsUnit();

			Assertions.assertTrue(unitOfMeasurementEntity.getMedicationCompounds().size() > 0);
			unitOfMeasurementEntity.setMedicationCompoundsIds(new HashSet<UUID>());
			unitOfMeasurementEntity.unsetMedicationCompounds();

			Assertions.assertTrue(unitOfMeasurementEntity.getMedicationItems().size() > 0);
			unitOfMeasurementEntity.setMedicationItemsIds(new HashSet<UUID>());
			unitOfMeasurementEntity.unsetMedicationItems();

			Assertions.assertTrue(unitOfMeasurementEntity.getPrescriptionItems().size() > 0);
			unitOfMeasurementEntity.setPrescriptionItemsIds(new HashSet<UUID>());
			unitOfMeasurementEntity.unsetPrescriptionItems();


			updatedUnitOfMeasurementEntity = unitOfMeasurementService.updateOldData(unitOfMeasurementEntity);

			Assertions.assertNull(updatedUnitOfMeasurementEntity.getCatalogueUOM());

			Assertions.assertEquals(0, updatedUnitOfMeasurementEntity.getCompoundPrescriptionDetails().size());

			Assertions.assertEquals(0, updatedUnitOfMeasurementEntity.getCompoundPrescriptionItems().size());

			Assertions.assertEquals(0, updatedUnitOfMeasurementEntity.getCompoundsUnit().size());

			Assertions.assertEquals(0, updatedUnitOfMeasurementEntity.getMedicationCompounds().size());

			Assertions.assertEquals(0, updatedUnitOfMeasurementEntity.getMedicationItems().size());

			Assertions.assertEquals(0, updatedUnitOfMeasurementEntity.getPrescriptionItems().size());

		});
	}

	@Test
	public void updateOldDataWithUnitOfMeasurementEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			UnitOfMeasurementEntity unitOfMeasurementEntity;
			UnitOfMeasurementEntity updatedUnitOfMeasurementEntity;

			CatalogueUOMEntity catalogueUOMEntity;

			Set<CompoundPrescriptionDetailEntity> compoundPrescriptionDetailsEntities;
			Set<UUID> compoundPrescriptionDetailsEntityIds;

			Set<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities;
			Set<UUID> compoundPrescriptionItemsEntityIds;

			Set<PrescriptionCompoundEntity> compoundsUnitEntities;
			Set<UUID> compoundsUnitEntityIds;

			Set<MedicationCompoundEntity> medicationCompoundsEntities;
			Set<UUID> medicationCompoundsEntityIds;

			Set<MedicationItemEntity> medicationItemsEntities;
			Set<UUID> medicationItemsEntityIds;

			Set<PrescriptionItemEntity> prescriptionItemsEntities;
			Set<UUID> prescriptionItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(true, false);
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
				catalogueUOMDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity.getCatalogueUOM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Catalogue UOM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			catalogueUOMEntity = catalogueUOMRepository.findById(catalogueUOMRepository.save(unitOfMeasurementEntity.getCatalogueUOM()).getId()).get();
			unitOfMeasurementEntity.unsetCatalogueUOM();
			unitOfMeasurementEntity.setCatalogueUOMId(catalogueUOMEntity.getId());

			compoundPrescriptionDetailsEntities = new HashSet<>();
			compoundPrescriptionDetailsEntityIds = new HashSet<>();
			for (CompoundPrescriptionDetailEntity entity : unitOfMeasurementEntity.getCompoundPrescriptionDetails()) {
				try {
					compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Compound Prescription Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = compoundPrescriptionDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				compoundPrescriptionDetailsEntities.add(compoundPrescriptionDetailRepository.findById(id).get());
				compoundPrescriptionDetailsEntityIds.add(id);
			}
			unitOfMeasurementEntity.unsetCompoundPrescriptionDetails();
			unitOfMeasurementEntity.setCompoundPrescriptionDetailsIds(compoundPrescriptionDetailsEntityIds);

			compoundPrescriptionItemsEntities = new HashSet<>();
			compoundPrescriptionItemsEntityIds = new HashSet<>();
			for (CompoundPrescriptionItemEntity entity : unitOfMeasurementEntity.getCompoundPrescriptionItems()) {
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
			unitOfMeasurementEntity.unsetCompoundPrescriptionItems();
			unitOfMeasurementEntity.setCompoundPrescriptionItemsIds(compoundPrescriptionItemsEntityIds);

			compoundsUnitEntities = new HashSet<>();
			compoundsUnitEntityIds = new HashSet<>();
			for (PrescriptionCompoundEntity entity : unitOfMeasurementEntity.getCompoundsUnit()) {
				try {
					prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Compounds Unit relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionCompoundRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				compoundsUnitEntities.add(prescriptionCompoundRepository.findById(id).get());
				compoundsUnitEntityIds.add(id);
			}
			unitOfMeasurementEntity.unsetCompoundsUnit();
			unitOfMeasurementEntity.setCompoundsUnitIds(compoundsUnitEntityIds);

			medicationCompoundsEntities = new HashSet<>();
			medicationCompoundsEntityIds = new HashSet<>();
			for (MedicationCompoundEntity entity : unitOfMeasurementEntity.getMedicationCompounds()) {
				try {
					medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Compounds relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationCompoundRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationCompoundsEntities.add(medicationCompoundRepository.findById(id).get());
				medicationCompoundsEntityIds.add(id);
			}
			unitOfMeasurementEntity.unsetMedicationCompounds();
			unitOfMeasurementEntity.setMedicationCompoundsIds(medicationCompoundsEntityIds);

			medicationItemsEntities = new HashSet<>();
			medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : unitOfMeasurementEntity.getMedicationItems()) {
				try {
					medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationItemsEntities.add(medicationItemRepository.findById(id).get());
				medicationItemsEntityIds.add(id);
			}
			unitOfMeasurementEntity.unsetMedicationItems();
			unitOfMeasurementEntity.setMedicationItemsIds(medicationItemsEntityIds);

			prescriptionItemsEntities = new HashSet<>();
			prescriptionItemsEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : unitOfMeasurementEntity.getPrescriptionItems()) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Prescription Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				prescriptionItemsEntities.add(prescriptionItemRepository.findById(id).get());
				prescriptionItemsEntityIds.add(id);
			}
			unitOfMeasurementEntity.unsetPrescriptionItems();
			unitOfMeasurementEntity.setPrescriptionItemsIds(prescriptionItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedUnitOfMeasurementEntity = unitOfMeasurementService.updateOldData(unitOfMeasurementEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			catalogueUOMEntity.unsetUnitOfMeasurement(false);
			updatedUnitOfMeasurementEntity.getCatalogueUOM().unsetUnitOfMeasurement(false);
			Assertions.assertEquals(catalogueUOMEntity, updatedUnitOfMeasurementEntity.getCatalogueUOM());

			Assertions.assertEquals(compoundPrescriptionDetailsEntities.size(), updatedUnitOfMeasurementEntity.getCompoundPrescriptionDetails().size());

			Assertions.assertEquals(compoundPrescriptionItemsEntities.size(), updatedUnitOfMeasurementEntity.getCompoundPrescriptionItems().size());

			Assertions.assertEquals(compoundsUnitEntities.size(), updatedUnitOfMeasurementEntity.getCompoundsUnit().size());

			Assertions.assertEquals(medicationCompoundsEntities.size(), updatedUnitOfMeasurementEntity.getMedicationCompounds().size());

			Assertions.assertEquals(medicationItemsEntities.size(), updatedUnitOfMeasurementEntity.getMedicationItems().size());

			Assertions.assertEquals(prescriptionItemsEntities.size(), updatedUnitOfMeasurementEntity.getPrescriptionItems().size());

		});
	}

	@Test
	public void whenCreateUnitOfMeasurementEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			UnitOfMeasurementEntity unitOfMeasurementEntity;
			Optional<UnitOfMeasurementEntity> fetchedUnitOfMeasurementEntity;

			try {
				unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			unitOfMeasurementEntity = unitOfMeasurementService.create(unitOfMeasurementEntity);

			fetchedUnitOfMeasurementEntity = unitOfMeasurementService.findById(unitOfMeasurementEntity.getId());

			Assertions.assertTrue(fetchedUnitOfMeasurementEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedUnitOfMeasurementEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(unitOfMeasurementEntity, fetchedUnitOfMeasurementEntity.get());
		});
	}

	@Test
	public void whenUpdateUnitOfMeasurementEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			UnitOfMeasurementEntity unitOfMeasurementEntity;
			UnitOfMeasurementEntity updatedUnitOfMeasurementEntity;
			Optional<UnitOfMeasurementEntity> fetchedUnitOfMeasurementEntity;

			try {
				unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity, true, true, false);
				updatedUnitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(updatedUnitOfMeasurementEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			unitOfMeasurementEntity = unitOfMeasurementService.create(unitOfMeasurementEntity);

			updatedUnitOfMeasurementEntity.setId(unitOfMeasurementEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedUnitOfMeasurementEntity.setCreated(unitOfMeasurementEntity.getCreated());

			updatedUnitOfMeasurementEntity = unitOfMeasurementService.update(updatedUnitOfMeasurementEntity);

			fetchedUnitOfMeasurementEntity = unitOfMeasurementService.findById(unitOfMeasurementEntity.getId());

			Assertions.assertTrue(fetchedUnitOfMeasurementEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateUnitOfMeasurementEntity_ThenEntityIsCreated
			fetchedUnitOfMeasurementEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedUnitOfMeasurementEntity, fetchedUnitOfMeasurementEntity.get());
		});
	}

	@Test
	public void whenDeleteUnitOfMeasurementEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			UnitOfMeasurementEntity unitOfMeasurementEntity;
			Optional<UnitOfMeasurementEntity> fetchedUnitOfMeasurementEntity;

			try {
				unitOfMeasurementEntity = unitOfMeasurementFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			unitOfMeasurementEntity = unitOfMeasurementService.create(unitOfMeasurementEntity);

			unitOfMeasurementService.deleteById(unitOfMeasurementEntity.getId());
			fetchedUnitOfMeasurementEntity = unitOfMeasurementService.findById(unitOfMeasurementEntity.getId());

			Assertions.assertTrue(fetchedUnitOfMeasurementEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
