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
import kmsweb.entities.TariffSchemaEntity;
import kmsweb.repositories.TariffSchemaRepository;
import kmsweb.utils.TariffSchemaFactory;
import kmsweb.utils.DatabasePopulators.TariffSchemaDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.TariffDefinitionEntity;
import kmsweb.repositories.TariffDefinitionRepository;
import kmsweb.utils.TariffDefinitionFactory;
import kmsweb.utils.DatabasePopulators.TariffDefinitionDatabasePopulator;
import kmsweb.entities.TariffFormulaEntity;
import kmsweb.repositories.TariffFormulaRepository;
import kmsweb.utils.TariffFormulaFactory;
import kmsweb.utils.DatabasePopulators.TariffFormulaDatabasePopulator;
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
public class TariffSchemaServiceIntegrationTest {

	@Autowired
	private TariffSchemaRepository tariffSchemaRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private TariffSchemaService tariffSchemaService;

	private final TariffSchemaFactory tariffSchemaFactory = new TariffSchemaFactory();

	@Autowired
	private TariffSchemaDatabasePopulator tariffSchemaDatabasePopulator;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

	@Autowired
	private TariffDefinitionRepository tariffDefinitionRepository;

	@Autowired
	private TariffDefinitionDatabasePopulator tariffDefinitionDatabasePopulator;

	private final TariffDefinitionFactory tariffDefinitionFactory = new TariffDefinitionFactory();

	@Autowired
	private TariffFormulaRepository tariffFormulaRepository;

	@Autowired
	private TariffFormulaDatabasePopulator tariffFormulaDatabasePopulator;

	private final TariffFormulaFactory tariffFormulaFactory = new TariffFormulaFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		tariffSchemaService = new TariffSchemaService(
			invoiceRepository,
			invoiceItemRepository,
			tariffDefinitionRepository,
			tariffFormulaRepository,
			validator,
			auditRepository,
			tariffSchemaRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewTariffSchemaEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		TariffSchemaEntity tariffSchemaEntity = tariffSchemaFactory.getObject(false, false);

		TariffSchemaEntity updatedEntity = tariffSchemaService.updateOldData(tariffSchemaEntity);
		Assertions.assertEquals(tariffSchemaEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingTariffSchemaEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			TariffSchemaEntity tariffSchemaEntity;
			TariffSchemaEntity entityWithUpdatedValues;

			try {
				tariffSchemaEntity = tariffSchemaFactory.getObject(false, false);
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(tariffSchemaEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = tariffSchemaFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffSchemaEntity = tariffSchemaService.create(tariffSchemaEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(tariffSchemaEntity.getId());

			TariffSchemaEntity updatedEntity = tariffSchemaService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithTariffSchemaEntityWithNonExistentId_ShouldThrowException() throws Exception {
		TariffSchemaEntity tariffSchemaEntity = tariffSchemaFactory.getObject(false, false);
		tariffSchemaEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			tariffSchemaService.updateOldData(tariffSchemaEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingTariffSchemaEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TariffSchemaEntity tariffSchemaEntity;
			TariffSchemaEntity updatedTariffSchemaEntity;

			Set<TariffFormulaEntity> baseSchemeEntities;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			Set<InvoiceEntity> invoicesEntities;

			Set<TariffDefinitionEntity> tariffDefinitionsEntities;

			Set<TariffFormulaEntity> tariffSchemeEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				tariffSchemaEntity = tariffSchemaFactory.getObject(true, false);
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
			baseSchemeEntities = tariffSchemaEntity.getBaseScheme();
			Set<UUID> baseSchemeEntityIds = new HashSet<>();
			for (TariffFormulaEntity entity : baseSchemeEntities) {
				try {
					tariffFormulaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				baseSchemeEntityIds.add(tariffFormulaRepository.save(entity).getId());
			}
			tariffSchemaEntity.setBaseSchemeIds(baseSchemeEntityIds);

			invoiceItemsEntities = tariffSchemaEntity.getInvoiceItems();
			Set<UUID> invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : invoiceItemsEntities) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceItemsEntityIds.add(invoiceItemRepository.save(entity).getId());
			}
			tariffSchemaEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			invoicesEntities = tariffSchemaEntity.getInvoices();
			Set<UUID> invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : invoicesEntities) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicesEntityIds.add(invoiceRepository.save(entity).getId());
			}
			tariffSchemaEntity.setInvoicesIds(invoicesEntityIds);

			tariffDefinitionsEntities = tariffSchemaEntity.getTariffDefinitions();
			Set<UUID> tariffDefinitionsEntityIds = new HashSet<>();
			for (TariffDefinitionEntity entity : tariffDefinitionsEntities) {
				try {
					tariffDefinitionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				tariffDefinitionsEntityIds.add(tariffDefinitionRepository.save(entity).getId());
			}
			tariffSchemaEntity.setTariffDefinitionsIds(tariffDefinitionsEntityIds);

			tariffSchemeEntities = tariffSchemaEntity.getTariffScheme();
			Set<UUID> tariffSchemeEntityIds = new HashSet<>();
			for (TariffFormulaEntity entity : tariffSchemeEntities) {
				try {
					tariffFormulaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				tariffSchemeEntityIds.add(tariffFormulaRepository.save(entity).getId());
			}
			tariffSchemaEntity.setTariffSchemeIds(tariffSchemeEntityIds);


			tariffSchemaEntity = tariffSchemaService.create(tariffSchemaEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(tariffSchemaEntity.getBaseScheme().size() > 0);
			tariffSchemaEntity.setBaseSchemeIds(new HashSet<UUID>());
			tariffSchemaEntity.unsetBaseScheme();

			Assertions.assertTrue(tariffSchemaEntity.getInvoiceItems().size() > 0);
			tariffSchemaEntity.setInvoiceItemsIds(new HashSet<UUID>());
			tariffSchemaEntity.unsetInvoiceItems();

			Assertions.assertTrue(tariffSchemaEntity.getInvoices().size() > 0);
			tariffSchemaEntity.setInvoicesIds(new HashSet<UUID>());
			tariffSchemaEntity.unsetInvoices();

			Assertions.assertTrue(tariffSchemaEntity.getTariffDefinitions().size() > 0);
			tariffSchemaEntity.setTariffDefinitionsIds(new HashSet<UUID>());
			tariffSchemaEntity.unsetTariffDefinitions();

			Assertions.assertTrue(tariffSchemaEntity.getTariffScheme().size() > 0);
			tariffSchemaEntity.setTariffSchemeIds(new HashSet<UUID>());
			tariffSchemaEntity.unsetTariffScheme();


			updatedTariffSchemaEntity = tariffSchemaService.updateOldData(tariffSchemaEntity);

			Assertions.assertEquals(0, updatedTariffSchemaEntity.getBaseScheme().size());

			Assertions.assertEquals(0, updatedTariffSchemaEntity.getInvoiceItems().size());

			Assertions.assertEquals(0, updatedTariffSchemaEntity.getInvoices().size());

			Assertions.assertEquals(0, updatedTariffSchemaEntity.getTariffDefinitions().size());

			Assertions.assertEquals(0, updatedTariffSchemaEntity.getTariffScheme().size());

		});
	}

	@Test
	public void updateOldDataWithTariffSchemaEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TariffSchemaEntity tariffSchemaEntity;
			TariffSchemaEntity updatedTariffSchemaEntity;

			Set<TariffFormulaEntity> baseSchemeEntities;
			Set<UUID> baseSchemeEntityIds;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;

			Set<InvoiceEntity> invoicesEntities;
			Set<UUID> invoicesEntityIds;

			Set<TariffDefinitionEntity> tariffDefinitionsEntities;
			Set<UUID> tariffDefinitionsEntityIds;

			Set<TariffFormulaEntity> tariffSchemeEntities;
			Set<UUID> tariffSchemeEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				tariffSchemaEntity = tariffSchemaFactory.getObject(true, false);
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
			baseSchemeEntities = new HashSet<>();
			baseSchemeEntityIds = new HashSet<>();
			for (TariffFormulaEntity entity : tariffSchemaEntity.getBaseScheme()) {
				try {
					tariffFormulaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Base Scheme relation for this test: " + e.getCause());
					return;
				}
				UUID id = tariffFormulaRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				baseSchemeEntities.add(tariffFormulaRepository.findById(id).get());
				baseSchemeEntityIds.add(id);
			}
			tariffSchemaEntity.unsetBaseScheme();
			tariffSchemaEntity.setBaseSchemeIds(baseSchemeEntityIds);

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : tariffSchemaEntity.getInvoiceItems()) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceItemsEntities.add(invoiceItemRepository.findById(id).get());
				invoiceItemsEntityIds.add(id);
			}
			tariffSchemaEntity.unsetInvoiceItems();
			tariffSchemaEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			invoicesEntities = new HashSet<>();
			invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : tariffSchemaEntity.getInvoices()) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoices relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicesEntities.add(invoiceRepository.findById(id).get());
				invoicesEntityIds.add(id);
			}
			tariffSchemaEntity.unsetInvoices();
			tariffSchemaEntity.setInvoicesIds(invoicesEntityIds);

			tariffDefinitionsEntities = new HashSet<>();
			tariffDefinitionsEntityIds = new HashSet<>();
			for (TariffDefinitionEntity entity : tariffSchemaEntity.getTariffDefinitions()) {
				try {
					tariffDefinitionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Tariff Definitions relation for this test: " + e.getCause());
					return;
				}
				UUID id = tariffDefinitionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				tariffDefinitionsEntities.add(tariffDefinitionRepository.findById(id).get());
				tariffDefinitionsEntityIds.add(id);
			}
			tariffSchemaEntity.unsetTariffDefinitions();
			tariffSchemaEntity.setTariffDefinitionsIds(tariffDefinitionsEntityIds);

			tariffSchemeEntities = new HashSet<>();
			tariffSchemeEntityIds = new HashSet<>();
			for (TariffFormulaEntity entity : tariffSchemaEntity.getTariffScheme()) {
				try {
					tariffFormulaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Tariff Scheme relation for this test: " + e.getCause());
					return;
				}
				UUID id = tariffFormulaRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				tariffSchemeEntities.add(tariffFormulaRepository.findById(id).get());
				tariffSchemeEntityIds.add(id);
			}
			tariffSchemaEntity.unsetTariffScheme();
			tariffSchemaEntity.setTariffSchemeIds(tariffSchemeEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedTariffSchemaEntity = tariffSchemaService.updateOldData(tariffSchemaEntity);

			Assertions.assertEquals(baseSchemeEntities.size(), updatedTariffSchemaEntity.getBaseScheme().size());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedTariffSchemaEntity.getInvoiceItems().size());

			Assertions.assertEquals(invoicesEntities.size(), updatedTariffSchemaEntity.getInvoices().size());

			Assertions.assertEquals(tariffDefinitionsEntities.size(), updatedTariffSchemaEntity.getTariffDefinitions().size());

			Assertions.assertEquals(tariffSchemeEntities.size(), updatedTariffSchemaEntity.getTariffScheme().size());

		});
	}

	@Test
	public void whenCreateTariffSchemaEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			TariffSchemaEntity tariffSchemaEntity;
			Optional<TariffSchemaEntity> fetchedTariffSchemaEntity;

			try {
				tariffSchemaEntity = tariffSchemaFactory.getObject(false, false);
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(tariffSchemaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffSchemaEntity = tariffSchemaService.create(tariffSchemaEntity);

			fetchedTariffSchemaEntity = tariffSchemaService.findById(tariffSchemaEntity.getId());

			Assertions.assertTrue(fetchedTariffSchemaEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedTariffSchemaEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(tariffSchemaEntity, fetchedTariffSchemaEntity.get());
		});
	}

	@Test
	public void whenUpdateTariffSchemaEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			TariffSchemaEntity tariffSchemaEntity;
			TariffSchemaEntity updatedTariffSchemaEntity;
			Optional<TariffSchemaEntity> fetchedTariffSchemaEntity;

			try {
				tariffSchemaEntity = tariffSchemaFactory.getObject(false, false);
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(tariffSchemaEntity, true, true, false);
				updatedTariffSchemaEntity = tariffSchemaFactory.getObject(false, false);
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(updatedTariffSchemaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffSchemaEntity = tariffSchemaService.create(tariffSchemaEntity);

			updatedTariffSchemaEntity.setId(tariffSchemaEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedTariffSchemaEntity.setCreated(tariffSchemaEntity.getCreated());

			updatedTariffSchemaEntity = tariffSchemaService.update(updatedTariffSchemaEntity);

			fetchedTariffSchemaEntity = tariffSchemaService.findById(tariffSchemaEntity.getId());

			Assertions.assertTrue(fetchedTariffSchemaEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateTariffSchemaEntity_ThenEntityIsCreated
			fetchedTariffSchemaEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedTariffSchemaEntity, fetchedTariffSchemaEntity.get());
		});
	}

	@Test
	public void whenDeleteTariffSchemaEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			TariffSchemaEntity tariffSchemaEntity;
			Optional<TariffSchemaEntity> fetchedTariffSchemaEntity;

			try {
				tariffSchemaEntity = tariffSchemaFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(tariffSchemaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffSchemaEntity = tariffSchemaService.create(tariffSchemaEntity);

			tariffSchemaService.deleteById(tariffSchemaEntity.getId());
			fetchedTariffSchemaEntity = tariffSchemaService.findById(tariffSchemaEntity.getId());

			Assertions.assertTrue(fetchedTariffSchemaEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
