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
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.utils.RetailPharmacyFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.utils.RetailPharmacyInvoiceFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyInvoiceDatabasePopulator;
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import kmsweb.repositories.RetailPharmacyStockDetailRepository;
import kmsweb.utils.RetailPharmacyStockDetailFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyStockDetailDatabasePopulator;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
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
public class RetailPharmacyServiceIntegrationTest {

	@Autowired
	private RetailPharmacyRepository retailPharmacyRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private RetailPharmacyService retailPharmacyService;

	private final RetailPharmacyFactory retailPharmacyFactory = new RetailPharmacyFactory();

	@Autowired
	private RetailPharmacyDatabasePopulator retailPharmacyDatabasePopulator;

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();

	@Autowired
	private RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	@Autowired
	private RetailPharmacyInvoiceDatabasePopulator retailPharmacyInvoiceDatabasePopulator;

	private final RetailPharmacyInvoiceFactory retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();

	@Autowired
	private RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository;

	@Autowired
	private RetailPharmacyStockDetailDatabasePopulator retailPharmacyStockDetailDatabasePopulator;

	private final RetailPharmacyStockDetailFactory retailPharmacyStockDetailFactory = new RetailPharmacyStockDetailFactory();

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		retailPharmacyService = new RetailPharmacyService(
			patientGeneralInfoRepository,
			retailPharmacyInvoiceRepository,
			retailPharmacyStockDetailRepository,
			warehouseRepository,
			validator,
			auditRepository,
			retailPharmacyRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewRetailPharmacyEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		RetailPharmacyEntity retailPharmacyEntity = retailPharmacyFactory.getObject(false, false);

		RetailPharmacyEntity updatedEntity = retailPharmacyService.updateOldData(retailPharmacyEntity);
		Assertions.assertEquals(retailPharmacyEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingRetailPharmacyEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyEntity retailPharmacyEntity;
			RetailPharmacyEntity entityWithUpdatedValues;

			try {
				retailPharmacyEntity = retailPharmacyFactory.getObject(false, false);
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = retailPharmacyFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyEntity = retailPharmacyService.create(retailPharmacyEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(retailPharmacyEntity.getId());

			RetailPharmacyEntity updatedEntity = retailPharmacyService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithRetailPharmacyEntityWithNonExistentId_ShouldThrowException() throws Exception {
		RetailPharmacyEntity retailPharmacyEntity = retailPharmacyFactory.getObject(false, false);
		retailPharmacyEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			retailPharmacyService.updateOldData(retailPharmacyEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingRetailPharmacyEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyEntity retailPharmacyEntity;
			RetailPharmacyEntity updatedRetailPharmacyEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			WarehouseEntity warehouseEntity;

			Set<RetailPharmacyInvoiceEntity> retailPharmacyInvoicesEntities;

			Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				retailPharmacyEntity = retailPharmacyFactory.getObject(true, false);
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
			patientGeneralInfoEntity = retailPharmacyEntity.getPatientGeneralInfo();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientGeneralInfoEntity = patientGeneralInfoRepository.save(patientGeneralInfoEntity);
			retailPharmacyEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			warehouseEntity = retailPharmacyEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			retailPharmacyEntity.setWarehouseId(warehouseEntity.getId());

			retailPharmacyInvoicesEntities = retailPharmacyEntity.getRetailPharmacyInvoices();
			Set<UUID> retailPharmacyInvoicesEntityIds = new HashSet<>();
			for (RetailPharmacyInvoiceEntity entity : retailPharmacyInvoicesEntities) {
				try {
					retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				retailPharmacyInvoicesEntityIds.add(retailPharmacyInvoiceRepository.save(entity).getId());
			}
			retailPharmacyEntity.setRetailPharmacyInvoicesIds(retailPharmacyInvoicesEntityIds);

			retailPharmacyStockDetailsEntities = retailPharmacyEntity.getRetailPharmacyStockDetails();
			Set<UUID> retailPharmacyStockDetailsEntityIds = new HashSet<>();
			for (RetailPharmacyStockDetailEntity entity : retailPharmacyStockDetailsEntities) {
				try {
					retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				retailPharmacyStockDetailsEntityIds.add(retailPharmacyStockDetailRepository.save(entity).getId());
			}
			retailPharmacyEntity.setRetailPharmacyStockDetailsIds(retailPharmacyStockDetailsEntityIds);


			retailPharmacyEntity = retailPharmacyService.create(retailPharmacyEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(retailPharmacyEntity.getPatientGeneralInfo());
			retailPharmacyEntity.setPatientGeneralInfoId(null);
			retailPharmacyEntity.unsetPatientGeneralInfo();

			Assertions.assertNotNull(retailPharmacyEntity.getWarehouse());
			retailPharmacyEntity.setWarehouseId(null);
			retailPharmacyEntity.unsetWarehouse();

			Assertions.assertTrue(retailPharmacyEntity.getRetailPharmacyInvoices().size() > 0);
			retailPharmacyEntity.setRetailPharmacyInvoicesIds(new HashSet<UUID>());
			retailPharmacyEntity.unsetRetailPharmacyInvoices();

			Assertions.assertTrue(retailPharmacyEntity.getRetailPharmacyStockDetails().size() > 0);
			retailPharmacyEntity.setRetailPharmacyStockDetailsIds(new HashSet<UUID>());
			retailPharmacyEntity.unsetRetailPharmacyStockDetails();


			updatedRetailPharmacyEntity = retailPharmacyService.updateOldData(retailPharmacyEntity);

			Assertions.assertNull(updatedRetailPharmacyEntity.getPatientGeneralInfo());

			Assertions.assertNull(updatedRetailPharmacyEntity.getWarehouse());

			Assertions.assertEquals(0, updatedRetailPharmacyEntity.getRetailPharmacyInvoices().size());

			Assertions.assertEquals(0, updatedRetailPharmacyEntity.getRetailPharmacyStockDetails().size());

		});
	}

	@Test
	public void updateOldDataWithRetailPharmacyEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyEntity retailPharmacyEntity;
			RetailPharmacyEntity updatedRetailPharmacyEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			WarehouseEntity warehouseEntity;

			Set<RetailPharmacyInvoiceEntity> retailPharmacyInvoicesEntities;
			Set<UUID> retailPharmacyInvoicesEntityIds;

			Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailsEntities;
			Set<UUID> retailPharmacyStockDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				retailPharmacyEntity = retailPharmacyFactory.getObject(true, false);
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
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity.getPatientGeneralInfo(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient General Info relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientGeneralInfoEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(retailPharmacyEntity.getPatientGeneralInfo()).getId()).get();
			retailPharmacyEntity.unsetPatientGeneralInfo();
			retailPharmacyEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(retailPharmacyEntity.getWarehouse()).getId()).get();
			retailPharmacyEntity.unsetWarehouse();
			retailPharmacyEntity.setWarehouseId(warehouseEntity.getId());

			retailPharmacyInvoicesEntities = new HashSet<>();
			retailPharmacyInvoicesEntityIds = new HashSet<>();
			for (RetailPharmacyInvoiceEntity entity : retailPharmacyEntity.getRetailPharmacyInvoices()) {
				try {
					retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Retail Pharmacy Invoices relation for this test: " + e.getCause());
					return;
				}
				UUID id = retailPharmacyInvoiceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				retailPharmacyInvoicesEntities.add(retailPharmacyInvoiceRepository.findById(id).get());
				retailPharmacyInvoicesEntityIds.add(id);
			}
			retailPharmacyEntity.unsetRetailPharmacyInvoices();
			retailPharmacyEntity.setRetailPharmacyInvoicesIds(retailPharmacyInvoicesEntityIds);

			retailPharmacyStockDetailsEntities = new HashSet<>();
			retailPharmacyStockDetailsEntityIds = new HashSet<>();
			for (RetailPharmacyStockDetailEntity entity : retailPharmacyEntity.getRetailPharmacyStockDetails()) {
				try {
					retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Retail Pharmacy Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = retailPharmacyStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				retailPharmacyStockDetailsEntities.add(retailPharmacyStockDetailRepository.findById(id).get());
				retailPharmacyStockDetailsEntityIds.add(id);
			}
			retailPharmacyEntity.unsetRetailPharmacyStockDetails();
			retailPharmacyEntity.setRetailPharmacyStockDetailsIds(retailPharmacyStockDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedRetailPharmacyEntity = retailPharmacyService.updateOldData(retailPharmacyEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientGeneralInfoEntity.unsetRetailPharmacies(false);
			updatedRetailPharmacyEntity.getPatientGeneralInfo().unsetRetailPharmacies(false);
			Assertions.assertEquals(patientGeneralInfoEntity, updatedRetailPharmacyEntity.getPatientGeneralInfo());

			warehouseEntity.unsetRetailPharmacies(false);
			updatedRetailPharmacyEntity.getWarehouse().unsetRetailPharmacies(false);
			Assertions.assertEquals(warehouseEntity, updatedRetailPharmacyEntity.getWarehouse());

			Assertions.assertEquals(retailPharmacyInvoicesEntities.size(), updatedRetailPharmacyEntity.getRetailPharmacyInvoices().size());

			Assertions.assertEquals(retailPharmacyStockDetailsEntities.size(), updatedRetailPharmacyEntity.getRetailPharmacyStockDetails().size());

		});
	}

	@Test
	public void whenCreateRetailPharmacyEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyEntity retailPharmacyEntity;
			Optional<RetailPharmacyEntity> fetchedRetailPharmacyEntity;

			try {
				retailPharmacyEntity = retailPharmacyFactory.getObject(false, false);
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyEntity = retailPharmacyService.create(retailPharmacyEntity);

			fetchedRetailPharmacyEntity = retailPharmacyService.findById(retailPharmacyEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedRetailPharmacyEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(retailPharmacyEntity, fetchedRetailPharmacyEntity.get());
		});
	}

	@Test
	public void whenUpdateRetailPharmacyEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyEntity retailPharmacyEntity;
			RetailPharmacyEntity updatedRetailPharmacyEntity;
			Optional<RetailPharmacyEntity> fetchedRetailPharmacyEntity;

			try {
				retailPharmacyEntity = retailPharmacyFactory.getObject(false, false);
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity, true, true, false);
				updatedRetailPharmacyEntity = retailPharmacyFactory.getObject(false, false);
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(updatedRetailPharmacyEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyEntity = retailPharmacyService.create(retailPharmacyEntity);

			updatedRetailPharmacyEntity.setId(retailPharmacyEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedRetailPharmacyEntity.setCreated(retailPharmacyEntity.getCreated());

			updatedRetailPharmacyEntity = retailPharmacyService.update(updatedRetailPharmacyEntity);

			fetchedRetailPharmacyEntity = retailPharmacyService.findById(retailPharmacyEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateRetailPharmacyEntity_ThenEntityIsCreated
			fetchedRetailPharmacyEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedRetailPharmacyEntity, fetchedRetailPharmacyEntity.get());
		});
	}

	@Test
	public void whenDeleteRetailPharmacyEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyEntity retailPharmacyEntity;
			Optional<RetailPharmacyEntity> fetchedRetailPharmacyEntity;

			try {
				retailPharmacyEntity = retailPharmacyFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyEntity = retailPharmacyService.create(retailPharmacyEntity);

			retailPharmacyService.deleteById(retailPharmacyEntity.getId());
			fetchedRetailPharmacyEntity = retailPharmacyService.findById(retailPharmacyEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
