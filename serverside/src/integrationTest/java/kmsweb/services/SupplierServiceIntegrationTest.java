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
import kmsweb.entities.SupplierEntity;
import kmsweb.repositories.SupplierRepository;
import kmsweb.utils.SupplierFactory;
import kmsweb.utils.DatabasePopulators.SupplierDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.utils.GoodsReceiveNoteFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteDatabasePopulator;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.utils.PurchaseRequisitionFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionDatabasePopulator;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.utils.ReturnSupplierFactory;
import kmsweb.utils.DatabasePopulators.ReturnSupplierDatabasePopulator;
import kmsweb.entities.SupplierBankAccountEntity;
import kmsweb.repositories.SupplierBankAccountRepository;
import kmsweb.utils.SupplierBankAccountFactory;
import kmsweb.utils.DatabasePopulators.SupplierBankAccountDatabasePopulator;
import kmsweb.entities.SupplierContactDetailEntity;
import kmsweb.repositories.SupplierContactDetailRepository;
import kmsweb.utils.SupplierContactDetailFactory;
import kmsweb.utils.DatabasePopulators.SupplierContactDetailDatabasePopulator;
import kmsweb.entities.SupplierProductDetailEntity;
import kmsweb.repositories.SupplierProductDetailRepository;
import kmsweb.utils.SupplierProductDetailFactory;
import kmsweb.utils.DatabasePopulators.SupplierProductDetailDatabasePopulator;
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
public class SupplierServiceIntegrationTest {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private SupplierService supplierService;

	private final SupplierFactory supplierFactory = new SupplierFactory();

	@Autowired
	private SupplierDatabasePopulator supplierDatabasePopulator;

	@Autowired
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	@Autowired
	private GoodsReceiveNoteDatabasePopulator goodsReceiveNoteDatabasePopulator;

	private final GoodsReceiveNoteFactory goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private PurchaseRequisitionRepository purchaseRequisitionRepository;

	@Autowired
	private PurchaseRequisitionDatabasePopulator purchaseRequisitionDatabasePopulator;

	private final PurchaseRequisitionFactory purchaseRequisitionFactory = new PurchaseRequisitionFactory();

	@Autowired
	private ReturnSupplierRepository returnSupplierRepository;

	@Autowired
	private ReturnSupplierDatabasePopulator returnSupplierDatabasePopulator;

	private final ReturnSupplierFactory returnSupplierFactory = new ReturnSupplierFactory();

	@Autowired
	private SupplierBankAccountRepository supplierBankAccountRepository;

	@Autowired
	private SupplierBankAccountDatabasePopulator supplierBankAccountDatabasePopulator;

	private final SupplierBankAccountFactory supplierBankAccountFactory = new SupplierBankAccountFactory();

	@Autowired
	private SupplierContactDetailRepository supplierContactDetailRepository;

	@Autowired
	private SupplierContactDetailDatabasePopulator supplierContactDetailDatabasePopulator;

	private final SupplierContactDetailFactory supplierContactDetailFactory = new SupplierContactDetailFactory();

	@Autowired
	private SupplierProductDetailRepository supplierProductDetailRepository;

	@Autowired
	private SupplierProductDetailDatabasePopulator supplierProductDetailDatabasePopulator;

	private final SupplierProductDetailFactory supplierProductDetailFactory = new SupplierProductDetailFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		supplierService = new SupplierService(
			goodsReceiveNoteRepository,
			purchaseOrderRepository,
			purchaseRequisitionRepository,
			returnSupplierRepository,
			supplierBankAccountRepository,
			supplierContactDetailRepository,
			supplierProductDetailRepository,
			validator,
			auditRepository,
			supplierRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewSupplierEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		SupplierEntity supplierEntity = supplierFactory.getObject(false, false);

		SupplierEntity updatedEntity = supplierService.updateOldData(supplierEntity);
		Assertions.assertEquals(supplierEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewSupplierEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		SupplierEntity supplierEntity = supplierFactory.getObject(false, false);

		supplierEntity.setPurchaseOrderHold(null);
		Assertions.assertNull(supplierEntity.getPurchaseOrderHold());

		supplierEntity.setVatIncluded(null);
		Assertions.assertNull(supplierEntity.getVatIncluded());


		SupplierEntity updatedEntity = supplierService.updateOldData(supplierEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getPurchaseOrderHold());
		Assertions.assertFalse(updatedEntity.getPurchaseOrderHold());

		Assertions.assertNotNull(updatedEntity.getVatIncluded());
		Assertions.assertFalse(updatedEntity.getVatIncluded());

	}

	@Test
	public void updateOldDataWithExistingSupplierEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierEntity supplierEntity;
			SupplierEntity entityWithUpdatedValues;

			try {
				supplierEntity = supplierFactory.getObject(false, false);
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = supplierFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierEntity = supplierService.create(supplierEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(supplierEntity.getId());

			SupplierEntity updatedEntity = supplierService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithSupplierEntityWithNonExistentId_ShouldThrowException() throws Exception {
		SupplierEntity supplierEntity = supplierFactory.getObject(false, false);
		supplierEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			supplierService.updateOldData(supplierEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingSupplierEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierEntity supplierEntity;
			SupplierEntity updatedSupplierEntity;

			Set<GoodsReceiveNoteEntity> goodsReceiveNotesEntities;

			Set<PurchaseOrderEntity> purchaseOrdersEntities;

			Set<PurchaseRequisitionEntity> purchaseRequisitionsEntities;

			Set<ReturnSupplierEntity> returnSuppliersEntities;

			Set<SupplierContactDetailEntity> suplierContactDetailsEntities;

			Set<SupplierBankAccountEntity> supplierBankAccountsEntities;

			Set<SupplierProductDetailEntity> supplierProductDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				supplierEntity = supplierFactory.getObject(true, false);
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
			goodsReceiveNotesEntities = supplierEntity.getGoodsReceiveNotes();
			Set<UUID> goodsReceiveNotesEntityIds = new HashSet<>();
			for (GoodsReceiveNoteEntity entity : goodsReceiveNotesEntities) {
				try {
					goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				goodsReceiveNotesEntityIds.add(goodsReceiveNoteRepository.save(entity).getId());
			}
			supplierEntity.setGoodsReceiveNotesIds(goodsReceiveNotesEntityIds);

			purchaseOrdersEntities = supplierEntity.getPurchaseOrders();
			Set<UUID> purchaseOrdersEntityIds = new HashSet<>();
			for (PurchaseOrderEntity entity : purchaseOrdersEntities) {
				try {
					purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				purchaseOrdersEntityIds.add(purchaseOrderRepository.save(entity).getId());
			}
			supplierEntity.setPurchaseOrdersIds(purchaseOrdersEntityIds);

			purchaseRequisitionsEntities = supplierEntity.getPurchaseRequisitions();
			Set<UUID> purchaseRequisitionsEntityIds = new HashSet<>();
			for (PurchaseRequisitionEntity entity : purchaseRequisitionsEntities) {
				try {
					purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				purchaseRequisitionsEntityIds.add(purchaseRequisitionRepository.save(entity).getId());
			}
			supplierEntity.setPurchaseRequisitionsIds(purchaseRequisitionsEntityIds);

			returnSuppliersEntities = supplierEntity.getReturnSuppliers();
			Set<UUID> returnSuppliersEntityIds = new HashSet<>();
			for (ReturnSupplierEntity entity : returnSuppliersEntities) {
				try {
					returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				returnSuppliersEntityIds.add(returnSupplierRepository.save(entity).getId());
			}
			supplierEntity.setReturnSuppliersIds(returnSuppliersEntityIds);

			suplierContactDetailsEntities = supplierEntity.getSuplierContactDetails();
			Set<UUID> suplierContactDetailsEntityIds = new HashSet<>();
			for (SupplierContactDetailEntity entity : suplierContactDetailsEntities) {
				try {
					supplierContactDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				suplierContactDetailsEntityIds.add(supplierContactDetailRepository.save(entity).getId());
			}
			supplierEntity.setSuplierContactDetailsIds(suplierContactDetailsEntityIds);

			supplierBankAccountsEntities = supplierEntity.getSupplierBankAccounts();
			Set<UUID> supplierBankAccountsEntityIds = new HashSet<>();
			for (SupplierBankAccountEntity entity : supplierBankAccountsEntities) {
				try {
					supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				supplierBankAccountsEntityIds.add(supplierBankAccountRepository.save(entity).getId());
			}
			supplierEntity.setSupplierBankAccountsIds(supplierBankAccountsEntityIds);

			supplierProductDetailsEntities = supplierEntity.getSupplierProductDetails();
			Set<UUID> supplierProductDetailsEntityIds = new HashSet<>();
			for (SupplierProductDetailEntity entity : supplierProductDetailsEntities) {
				try {
					supplierProductDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				supplierProductDetailsEntityIds.add(supplierProductDetailRepository.save(entity).getId());
			}
			supplierEntity.setSupplierProductDetailsIds(supplierProductDetailsEntityIds);


			supplierEntity = supplierService.create(supplierEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(supplierEntity.getGoodsReceiveNotes().size() > 0);
			supplierEntity.setGoodsReceiveNotesIds(new HashSet<UUID>());
			supplierEntity.unsetGoodsReceiveNotes();

			Assertions.assertTrue(supplierEntity.getPurchaseOrders().size() > 0);
			supplierEntity.setPurchaseOrdersIds(new HashSet<UUID>());
			supplierEntity.unsetPurchaseOrders();

			Assertions.assertTrue(supplierEntity.getPurchaseRequisitions().size() > 0);
			supplierEntity.setPurchaseRequisitionsIds(new HashSet<UUID>());
			supplierEntity.unsetPurchaseRequisitions();

			Assertions.assertTrue(supplierEntity.getReturnSuppliers().size() > 0);
			supplierEntity.setReturnSuppliersIds(new HashSet<UUID>());
			supplierEntity.unsetReturnSuppliers();

			Assertions.assertTrue(supplierEntity.getSuplierContactDetails().size() > 0);
			supplierEntity.setSuplierContactDetailsIds(new HashSet<UUID>());
			supplierEntity.unsetSuplierContactDetails();

			Assertions.assertTrue(supplierEntity.getSupplierBankAccounts().size() > 0);
			supplierEntity.setSupplierBankAccountsIds(new HashSet<UUID>());
			supplierEntity.unsetSupplierBankAccounts();

			Assertions.assertTrue(supplierEntity.getSupplierProductDetails().size() > 0);
			supplierEntity.setSupplierProductDetailsIds(new HashSet<UUID>());
			supplierEntity.unsetSupplierProductDetails();


			updatedSupplierEntity = supplierService.updateOldData(supplierEntity);

			Assertions.assertEquals(0, updatedSupplierEntity.getGoodsReceiveNotes().size());

			Assertions.assertEquals(0, updatedSupplierEntity.getPurchaseOrders().size());

			Assertions.assertEquals(0, updatedSupplierEntity.getPurchaseRequisitions().size());

			Assertions.assertEquals(0, updatedSupplierEntity.getReturnSuppliers().size());

			Assertions.assertEquals(0, updatedSupplierEntity.getSuplierContactDetails().size());

			Assertions.assertEquals(0, updatedSupplierEntity.getSupplierBankAccounts().size());

			Assertions.assertEquals(0, updatedSupplierEntity.getSupplierProductDetails().size());

		});
	}

	@Test
	public void updateOldDataWithSupplierEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierEntity supplierEntity;
			SupplierEntity updatedSupplierEntity;

			Set<GoodsReceiveNoteEntity> goodsReceiveNotesEntities;
			Set<UUID> goodsReceiveNotesEntityIds;

			Set<PurchaseOrderEntity> purchaseOrdersEntities;
			Set<UUID> purchaseOrdersEntityIds;

			Set<PurchaseRequisitionEntity> purchaseRequisitionsEntities;
			Set<UUID> purchaseRequisitionsEntityIds;

			Set<ReturnSupplierEntity> returnSuppliersEntities;
			Set<UUID> returnSuppliersEntityIds;

			Set<SupplierContactDetailEntity> suplierContactDetailsEntities;
			Set<UUID> suplierContactDetailsEntityIds;

			Set<SupplierBankAccountEntity> supplierBankAccountsEntities;
			Set<UUID> supplierBankAccountsEntityIds;

			Set<SupplierProductDetailEntity> supplierProductDetailsEntities;
			Set<UUID> supplierProductDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				supplierEntity = supplierFactory.getObject(true, false);
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
			goodsReceiveNotesEntities = new HashSet<>();
			goodsReceiveNotesEntityIds = new HashSet<>();
			for (GoodsReceiveNoteEntity entity : supplierEntity.getGoodsReceiveNotes()) {
				try {
					goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Goods Receive Notes relation for this test: " + e.getCause());
					return;
				}
				UUID id = goodsReceiveNoteRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				goodsReceiveNotesEntities.add(goodsReceiveNoteRepository.findById(id).get());
				goodsReceiveNotesEntityIds.add(id);
			}
			supplierEntity.unsetGoodsReceiveNotes();
			supplierEntity.setGoodsReceiveNotesIds(goodsReceiveNotesEntityIds);

			purchaseOrdersEntities = new HashSet<>();
			purchaseOrdersEntityIds = new HashSet<>();
			for (PurchaseOrderEntity entity : supplierEntity.getPurchaseOrders()) {
				try {
					purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Purchase Orders relation for this test: " + e.getCause());
					return;
				}
				UUID id = purchaseOrderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				purchaseOrdersEntities.add(purchaseOrderRepository.findById(id).get());
				purchaseOrdersEntityIds.add(id);
			}
			supplierEntity.unsetPurchaseOrders();
			supplierEntity.setPurchaseOrdersIds(purchaseOrdersEntityIds);

			purchaseRequisitionsEntities = new HashSet<>();
			purchaseRequisitionsEntityIds = new HashSet<>();
			for (PurchaseRequisitionEntity entity : supplierEntity.getPurchaseRequisitions()) {
				try {
					purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Purchase Requisitions relation for this test: " + e.getCause());
					return;
				}
				UUID id = purchaseRequisitionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				purchaseRequisitionsEntities.add(purchaseRequisitionRepository.findById(id).get());
				purchaseRequisitionsEntityIds.add(id);
			}
			supplierEntity.unsetPurchaseRequisitions();
			supplierEntity.setPurchaseRequisitionsIds(purchaseRequisitionsEntityIds);

			returnSuppliersEntities = new HashSet<>();
			returnSuppliersEntityIds = new HashSet<>();
			for (ReturnSupplierEntity entity : supplierEntity.getReturnSuppliers()) {
				try {
					returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Return Suppliers relation for this test: " + e.getCause());
					return;
				}
				UUID id = returnSupplierRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				returnSuppliersEntities.add(returnSupplierRepository.findById(id).get());
				returnSuppliersEntityIds.add(id);
			}
			supplierEntity.unsetReturnSuppliers();
			supplierEntity.setReturnSuppliersIds(returnSuppliersEntityIds);

			suplierContactDetailsEntities = new HashSet<>();
			suplierContactDetailsEntityIds = new HashSet<>();
			for (SupplierContactDetailEntity entity : supplierEntity.getSuplierContactDetails()) {
				try {
					supplierContactDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Suplier Contact Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = supplierContactDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				suplierContactDetailsEntities.add(supplierContactDetailRepository.findById(id).get());
				suplierContactDetailsEntityIds.add(id);
			}
			supplierEntity.unsetSuplierContactDetails();
			supplierEntity.setSuplierContactDetailsIds(suplierContactDetailsEntityIds);

			supplierBankAccountsEntities = new HashSet<>();
			supplierBankAccountsEntityIds = new HashSet<>();
			for (SupplierBankAccountEntity entity : supplierEntity.getSupplierBankAccounts()) {
				try {
					supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Supplier Bank Accounts relation for this test: " + e.getCause());
					return;
				}
				UUID id = supplierBankAccountRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				supplierBankAccountsEntities.add(supplierBankAccountRepository.findById(id).get());
				supplierBankAccountsEntityIds.add(id);
			}
			supplierEntity.unsetSupplierBankAccounts();
			supplierEntity.setSupplierBankAccountsIds(supplierBankAccountsEntityIds);

			supplierProductDetailsEntities = new HashSet<>();
			supplierProductDetailsEntityIds = new HashSet<>();
			for (SupplierProductDetailEntity entity : supplierEntity.getSupplierProductDetails()) {
				try {
					supplierProductDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Supplier Product Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = supplierProductDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				supplierProductDetailsEntities.add(supplierProductDetailRepository.findById(id).get());
				supplierProductDetailsEntityIds.add(id);
			}
			supplierEntity.unsetSupplierProductDetails();
			supplierEntity.setSupplierProductDetailsIds(supplierProductDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedSupplierEntity = supplierService.updateOldData(supplierEntity);

			Assertions.assertEquals(goodsReceiveNotesEntities.size(), updatedSupplierEntity.getGoodsReceiveNotes().size());

			Assertions.assertEquals(purchaseOrdersEntities.size(), updatedSupplierEntity.getPurchaseOrders().size());

			Assertions.assertEquals(purchaseRequisitionsEntities.size(), updatedSupplierEntity.getPurchaseRequisitions().size());

			Assertions.assertEquals(returnSuppliersEntities.size(), updatedSupplierEntity.getReturnSuppliers().size());

			Assertions.assertEquals(suplierContactDetailsEntities.size(), updatedSupplierEntity.getSuplierContactDetails().size());

			Assertions.assertEquals(supplierBankAccountsEntities.size(), updatedSupplierEntity.getSupplierBankAccounts().size());

			Assertions.assertEquals(supplierProductDetailsEntities.size(), updatedSupplierEntity.getSupplierProductDetails().size());

		});
	}

	@Test
	public void whenCreateSupplierEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierEntity supplierEntity;
			Optional<SupplierEntity> fetchedSupplierEntity;

			try {
				supplierEntity = supplierFactory.getObject(false, false);
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierEntity = supplierService.create(supplierEntity);

			fetchedSupplierEntity = supplierService.findById(supplierEntity.getId());

			Assertions.assertTrue(fetchedSupplierEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedSupplierEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(supplierEntity, fetchedSupplierEntity.get());
		});
	}

	@Test
	public void whenUpdateSupplierEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierEntity supplierEntity;
			SupplierEntity updatedSupplierEntity;
			Optional<SupplierEntity> fetchedSupplierEntity;

			try {
				supplierEntity = supplierFactory.getObject(false, false);
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, false);
				updatedSupplierEntity = supplierFactory.getObject(false, false);
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(updatedSupplierEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierEntity = supplierService.create(supplierEntity);

			updatedSupplierEntity.setId(supplierEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedSupplierEntity.setCreated(supplierEntity.getCreated());

			updatedSupplierEntity = supplierService.update(updatedSupplierEntity);

			fetchedSupplierEntity = supplierService.findById(supplierEntity.getId());

			Assertions.assertTrue(fetchedSupplierEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateSupplierEntity_ThenEntityIsCreated
			fetchedSupplierEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedSupplierEntity, fetchedSupplierEntity.get());
		});
	}

	@Test
	public void whenDeleteSupplierEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierEntity supplierEntity;
			Optional<SupplierEntity> fetchedSupplierEntity;

			try {
				supplierEntity = supplierFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierEntity = supplierService.create(supplierEntity);

			supplierService.deleteById(supplierEntity.getId());
			fetchedSupplierEntity = supplierService.findById(supplierEntity.getId());

			Assertions.assertTrue(fetchedSupplierEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
