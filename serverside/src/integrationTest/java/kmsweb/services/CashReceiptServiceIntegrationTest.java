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
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.utils.CashReceiptFactory;
import kmsweb.utils.DatabasePopulators.CashReceiptDatabasePopulator;
import kmsweb.entities.MerchantEntity;
import kmsweb.repositories.MerchantRepository;
import kmsweb.utils.MerchantFactory;
import kmsweb.utils.DatabasePopulators.MerchantDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.utils.RetailPharmacyInvoiceFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyInvoiceDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
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
public class CashReceiptServiceIntegrationTest {

	@Autowired
	private CashReceiptRepository cashReceiptRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private CashReceiptService cashReceiptService;

	private final CashReceiptFactory cashReceiptFactory = new CashReceiptFactory();

	@Autowired
	private CashReceiptDatabasePopulator cashReceiptDatabasePopulator;

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private MerchantDatabasePopulator merchantDatabasePopulator;

	private final MerchantFactory merchantFactory = new MerchantFactory();

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
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		cashReceiptService = new CashReceiptService(
			merchantRepository,
			patientGeneralInfoRepository,
			retailPharmacyInvoiceRepository,
			staffRepository,
			validator,
			auditRepository,
			cashReceiptRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewCashReceiptEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		CashReceiptEntity cashReceiptEntity = cashReceiptFactory.getObject(false, false);

		CashReceiptEntity updatedEntity = cashReceiptService.updateOldData(cashReceiptEntity);
		Assertions.assertEquals(cashReceiptEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewCashReceiptEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		CashReceiptEntity cashReceiptEntity = cashReceiptFactory.getObject(false, false);

		cashReceiptEntity.setIsvoid(null);
		Assertions.assertNull(cashReceiptEntity.getIsvoid());


		CashReceiptEntity updatedEntity = cashReceiptService.updateOldData(cashReceiptEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsvoid());
		Assertions.assertFalse(updatedEntity.getIsvoid());

	}

	@Test
	public void updateOldDataWithExistingCashReceiptEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			CashReceiptEntity cashReceiptEntity;
			CashReceiptEntity entityWithUpdatedValues;

			try {
				cashReceiptEntity = cashReceiptFactory.getObject(false, false);
				cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = cashReceiptFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashReceiptEntity = cashReceiptService.create(cashReceiptEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(cashReceiptEntity.getId());

			CashReceiptEntity updatedEntity = cashReceiptService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithCashReceiptEntityWithNonExistentId_ShouldThrowException() throws Exception {
		CashReceiptEntity cashReceiptEntity = cashReceiptFactory.getObject(false, false);
		cashReceiptEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			cashReceiptService.updateOldData(cashReceiptEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingCashReceiptEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CashReceiptEntity cashReceiptEntity;
			CashReceiptEntity updatedCashReceiptEntity;

			MerchantEntity merchantEntity;

			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;

			StaffEntity cashierStaffEntity;

			PatientGeneralInfoEntity patientEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				cashReceiptEntity = cashReceiptFactory.getObject(true, false);
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
			merchantEntity = cashReceiptEntity.getMerchant();
			try {
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			merchantEntity = merchantRepository.save(merchantEntity);
			cashReceiptEntity.setMerchantId(merchantEntity.getId());

			retailPharmacyInvoiceEntity = cashReceiptEntity.getRetailPharmacyInvoice();
			try {
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			retailPharmacyInvoiceEntity = retailPharmacyInvoiceRepository.save(retailPharmacyInvoiceEntity);
			cashReceiptEntity.setRetailPharmacyInvoiceId(retailPharmacyInvoiceEntity.getId());

			cashierStaffEntity = cashReceiptEntity.getCashierStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(cashierStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			cashierStaffEntity = staffRepository.save(cashierStaffEntity);
			cashReceiptEntity.setCashierStaffId(cashierStaffEntity.getId());

			patientEntity = cashReceiptEntity.getPatient();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientEntity = patientGeneralInfoRepository.save(patientEntity);
			cashReceiptEntity.setPatientId(patientEntity.getId());


			cashReceiptEntity = cashReceiptService.create(cashReceiptEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(cashReceiptEntity.getMerchant());
			cashReceiptEntity.setMerchantId(null);
			cashReceiptEntity.unsetMerchant();

			Assertions.assertNotNull(cashReceiptEntity.getRetailPharmacyInvoice());
			cashReceiptEntity.setRetailPharmacyInvoiceId(null);
			cashReceiptEntity.unsetRetailPharmacyInvoice();

			Assertions.assertNotNull(cashReceiptEntity.getCashierStaff());
			cashReceiptEntity.setCashierStaffId(null);
			cashReceiptEntity.unsetCashierStaff();

			Assertions.assertNotNull(cashReceiptEntity.getPatient());
			cashReceiptEntity.setPatientId(null);
			cashReceiptEntity.unsetPatient();


			updatedCashReceiptEntity = cashReceiptService.updateOldData(cashReceiptEntity);

			Assertions.assertNull(updatedCashReceiptEntity.getMerchant());

			Assertions.assertNull(updatedCashReceiptEntity.getRetailPharmacyInvoice());

			Assertions.assertNull(updatedCashReceiptEntity.getCashierStaff());

			Assertions.assertNull(updatedCashReceiptEntity.getPatient());

		});
	}

	@Test
	public void updateOldDataWithCashReceiptEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CashReceiptEntity cashReceiptEntity;
			CashReceiptEntity updatedCashReceiptEntity;

			MerchantEntity merchantEntity;

			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;

			StaffEntity cashierStaffEntity;

			PatientGeneralInfoEntity patientEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				cashReceiptEntity = cashReceiptFactory.getObject(true, false);
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
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity.getMerchant(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Merchant relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			merchantEntity = merchantRepository.findById(merchantRepository.save(cashReceiptEntity.getMerchant()).getId()).get();
			cashReceiptEntity.unsetMerchant();
			cashReceiptEntity.setMerchantId(merchantEntity.getId());

			try {
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity.getRetailPharmacyInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Retail Pharmacy Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			retailPharmacyInvoiceEntity = retailPharmacyInvoiceRepository.findById(retailPharmacyInvoiceRepository.save(cashReceiptEntity.getRetailPharmacyInvoice()).getId()).get();
			cashReceiptEntity.unsetRetailPharmacyInvoice();
			cashReceiptEntity.setRetailPharmacyInvoiceId(retailPharmacyInvoiceEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity.getCashierStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Cashier Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			cashierStaffEntity = staffRepository.findById(staffRepository.save(cashReceiptEntity.getCashierStaff()).getId()).get();
			cashReceiptEntity.unsetCashierStaff();
			cashReceiptEntity.setCashierStaffId(cashierStaffEntity.getId());

			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity.getPatient(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(cashReceiptEntity.getPatient()).getId()).get();
			cashReceiptEntity.unsetPatient();
			cashReceiptEntity.setPatientId(patientEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedCashReceiptEntity = cashReceiptService.updateOldData(cashReceiptEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			merchantEntity.unsetCashReceipts(false);
			updatedCashReceiptEntity.getMerchant().unsetCashReceipts(false);
			Assertions.assertEquals(merchantEntity, updatedCashReceiptEntity.getMerchant());

			retailPharmacyInvoiceEntity.unsetCashReceipts(false);
			updatedCashReceiptEntity.getRetailPharmacyInvoice().unsetCashReceipts(false);
			Assertions.assertEquals(retailPharmacyInvoiceEntity, updatedCashReceiptEntity.getRetailPharmacyInvoice());

			cashierStaffEntity.unsetCashierStaff(false);
			updatedCashReceiptEntity.getCashierStaff().unsetCashierStaff(false);
			Assertions.assertEquals(cashierStaffEntity, updatedCashReceiptEntity.getCashierStaff());

			patientEntity.unsetInvoiceReceipts(false);
			updatedCashReceiptEntity.getPatient().unsetInvoiceReceipts(false);
			Assertions.assertEquals(patientEntity, updatedCashReceiptEntity.getPatient());

		});
	}

	@Test
	public void whenCreateCashReceiptEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			CashReceiptEntity cashReceiptEntity;
			Optional<CashReceiptEntity> fetchedCashReceiptEntity;

			try {
				cashReceiptEntity = cashReceiptFactory.getObject(false, false);
				cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashReceiptEntity = cashReceiptService.create(cashReceiptEntity);

			fetchedCashReceiptEntity = cashReceiptService.findById(cashReceiptEntity.getId());

			Assertions.assertTrue(fetchedCashReceiptEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedCashReceiptEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(cashReceiptEntity, fetchedCashReceiptEntity.get());
		});
	}

	@Test
	public void whenUpdateCashReceiptEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			CashReceiptEntity cashReceiptEntity;
			CashReceiptEntity updatedCashReceiptEntity;
			Optional<CashReceiptEntity> fetchedCashReceiptEntity;

			try {
				cashReceiptEntity = cashReceiptFactory.getObject(false, false);
				cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity, true, true, false);
				updatedCashReceiptEntity = cashReceiptFactory.getObject(false, false);
				cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(updatedCashReceiptEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashReceiptEntity = cashReceiptService.create(cashReceiptEntity);

			updatedCashReceiptEntity.setId(cashReceiptEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedCashReceiptEntity.setCreated(cashReceiptEntity.getCreated());

			updatedCashReceiptEntity = cashReceiptService.update(updatedCashReceiptEntity);

			fetchedCashReceiptEntity = cashReceiptService.findById(cashReceiptEntity.getId());

			Assertions.assertTrue(fetchedCashReceiptEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateCashReceiptEntity_ThenEntityIsCreated
			fetchedCashReceiptEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedCashReceiptEntity, fetchedCashReceiptEntity.get());
		});
	}

	@Test
	public void whenDeleteCashReceiptEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			CashReceiptEntity cashReceiptEntity;
			Optional<CashReceiptEntity> fetchedCashReceiptEntity;

			try {
				cashReceiptEntity = cashReceiptFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(cashReceiptEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashReceiptEntity = cashReceiptService.create(cashReceiptEntity);

			cashReceiptService.deleteById(cashReceiptEntity.getId());
			fetchedCashReceiptEntity = cashReceiptService.findById(cashReceiptEntity.getId());

			Assertions.assertTrue(fetchedCashReceiptEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
