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
import kmsweb.entities.InsuranceBenefitPlanEntity;
import kmsweb.repositories.InsuranceBenefitPlanRepository;
import kmsweb.utils.InsuranceBenefitPlanFactory;
import kmsweb.utils.DatabasePopulators.InsuranceBenefitPlanDatabasePopulator;
import kmsweb.entities.InsuranceProviderEntity;
import kmsweb.repositories.InsuranceProviderRepository;
import kmsweb.utils.InsuranceProviderFactory;
import kmsweb.utils.DatabasePopulators.InsuranceProviderDatabasePopulator;
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.repositories.InvoicePaymentInsuranceRepository;
import kmsweb.utils.InvoicePaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.InvoicePaymentInsuranceDatabasePopulator;
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientPaymentInsuranceRepository;
import kmsweb.utils.PatientPaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentInsuranceDatabasePopulator;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientVisitPatientPaymentInsuranceRepository;
import kmsweb.utils.PatientVisitPatientPaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitPatientPaymentInsuranceDatabasePopulator;
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
public class InsuranceBenefitPlanServiceIntegrationTest {

	@Autowired
	private InsuranceBenefitPlanRepository insuranceBenefitPlanRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InsuranceBenefitPlanService insuranceBenefitPlanService;

	private final InsuranceBenefitPlanFactory insuranceBenefitPlanFactory = new InsuranceBenefitPlanFactory();

	@Autowired
	private InsuranceBenefitPlanDatabasePopulator insuranceBenefitPlanDatabasePopulator;

	@Autowired
	private InsuranceProviderRepository insuranceProviderRepository;

	@Autowired
	private InsuranceProviderDatabasePopulator insuranceProviderDatabasePopulator;

	private final InsuranceProviderFactory insuranceProviderFactory = new InsuranceProviderFactory();

	@Autowired
	private InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository;

	@Autowired
	private InvoicePaymentInsuranceDatabasePopulator invoicePaymentInsuranceDatabasePopulator;

	private final InvoicePaymentInsuranceFactory invoicePaymentInsuranceFactory = new InvoicePaymentInsuranceFactory();

	@Autowired
	private PatientPaymentInsuranceRepository patientPaymentInsuranceRepository;

	@Autowired
	private PatientPaymentInsuranceDatabasePopulator patientPaymentInsuranceDatabasePopulator;

	private final PatientPaymentInsuranceFactory patientPaymentInsuranceFactory = new PatientPaymentInsuranceFactory();

	@Autowired
	private PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository;

	@Autowired
	private PatientVisitPatientPaymentInsuranceDatabasePopulator patientVisitPatientPaymentInsuranceDatabasePopulator;

	private final PatientVisitPatientPaymentInsuranceFactory patientVisitPatientPaymentInsuranceFactory = new PatientVisitPatientPaymentInsuranceFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		insuranceBenefitPlanService = new InsuranceBenefitPlanService(
			insuranceProviderRepository,
			invoicePaymentInsuranceRepository,
			patientPaymentInsuranceRepository,
			patientVisitPatientPaymentInsuranceRepository,
			validator,
			auditRepository,
			insuranceBenefitPlanRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInsuranceBenefitPlanEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InsuranceBenefitPlanEntity insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);

		InsuranceBenefitPlanEntity updatedEntity = insuranceBenefitPlanService.updateOldData(insuranceBenefitPlanEntity);
		Assertions.assertEquals(insuranceBenefitPlanEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInsuranceBenefitPlanEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;
			InsuranceBenefitPlanEntity entityWithUpdatedValues;

			try {
				insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = insuranceBenefitPlanFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceBenefitPlanEntity = insuranceBenefitPlanService.create(insuranceBenefitPlanEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(insuranceBenefitPlanEntity.getId());

			InsuranceBenefitPlanEntity updatedEntity = insuranceBenefitPlanService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInsuranceBenefitPlanEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InsuranceBenefitPlanEntity insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);
		insuranceBenefitPlanEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			insuranceBenefitPlanService.updateOldData(insuranceBenefitPlanEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInsuranceBenefitPlanEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;
			InsuranceBenefitPlanEntity updatedInsuranceBenefitPlanEntity;

			InsuranceProviderEntity insuranceProviderEntity;

			Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurancesEntities;

			Set<PatientPaymentInsuranceEntity> patientPaymentInsurancesEntities;

			Set<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurancesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(true, false);
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
			insuranceProviderEntity = insuranceBenefitPlanEntity.getInsuranceProvider();
			try {
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceProviderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			insuranceProviderEntity = insuranceProviderRepository.save(insuranceProviderEntity);
			insuranceBenefitPlanEntity.setInsuranceProviderId(insuranceProviderEntity.getId());

			invoicePaymentInsurancesEntities = insuranceBenefitPlanEntity.getInvoicePaymentInsurances();
			Set<UUID> invoicePaymentInsurancesEntityIds = new HashSet<>();
			for (InvoicePaymentInsuranceEntity entity : invoicePaymentInsurancesEntities) {
				try {
					invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicePaymentInsurancesEntityIds.add(invoicePaymentInsuranceRepository.save(entity).getId());
			}
			insuranceBenefitPlanEntity.setInvoicePaymentInsurancesIds(invoicePaymentInsurancesEntityIds);

			patientPaymentInsurancesEntities = insuranceBenefitPlanEntity.getPatientPaymentInsurances();
			Set<UUID> patientPaymentInsurancesEntityIds = new HashSet<>();
			for (PatientPaymentInsuranceEntity entity : patientPaymentInsurancesEntities) {
				try {
					patientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientPaymentInsurancesEntityIds.add(patientPaymentInsuranceRepository.save(entity).getId());
			}
			insuranceBenefitPlanEntity.setPatientPaymentInsurancesIds(patientPaymentInsurancesEntityIds);

			patientVisitPatientPaymentInsurancesEntities = insuranceBenefitPlanEntity.getPatientVisitPatientPaymentInsurances();
			Set<UUID> patientVisitPatientPaymentInsurancesEntityIds = new HashSet<>();
			for (PatientVisitPatientPaymentInsuranceEntity entity : patientVisitPatientPaymentInsurancesEntities) {
				try {
					patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientVisitPatientPaymentInsurancesEntityIds.add(patientVisitPatientPaymentInsuranceRepository.save(entity).getId());
			}
			insuranceBenefitPlanEntity.setPatientVisitPatientPaymentInsurancesIds(patientVisitPatientPaymentInsurancesEntityIds);


			insuranceBenefitPlanEntity = insuranceBenefitPlanService.create(insuranceBenefitPlanEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(insuranceBenefitPlanEntity.getInsuranceProvider());
			insuranceBenefitPlanEntity.setInsuranceProviderId(null);
			insuranceBenefitPlanEntity.unsetInsuranceProvider();

			Assertions.assertTrue(insuranceBenefitPlanEntity.getInvoicePaymentInsurances().size() > 0);
			insuranceBenefitPlanEntity.setInvoicePaymentInsurancesIds(new HashSet<UUID>());
			insuranceBenefitPlanEntity.unsetInvoicePaymentInsurances();

			Assertions.assertTrue(insuranceBenefitPlanEntity.getPatientPaymentInsurances().size() > 0);
			insuranceBenefitPlanEntity.setPatientPaymentInsurancesIds(new HashSet<UUID>());
			insuranceBenefitPlanEntity.unsetPatientPaymentInsurances();

			Assertions.assertTrue(insuranceBenefitPlanEntity.getPatientVisitPatientPaymentInsurances().size() > 0);
			insuranceBenefitPlanEntity.setPatientVisitPatientPaymentInsurancesIds(new HashSet<UUID>());
			insuranceBenefitPlanEntity.unsetPatientVisitPatientPaymentInsurances();


			updatedInsuranceBenefitPlanEntity = insuranceBenefitPlanService.updateOldData(insuranceBenefitPlanEntity);

			Assertions.assertNull(updatedInsuranceBenefitPlanEntity.getInsuranceProvider());

			Assertions.assertEquals(0, updatedInsuranceBenefitPlanEntity.getInvoicePaymentInsurances().size());

			Assertions.assertEquals(0, updatedInsuranceBenefitPlanEntity.getPatientPaymentInsurances().size());

			Assertions.assertEquals(0, updatedInsuranceBenefitPlanEntity.getPatientVisitPatientPaymentInsurances().size());

		});
	}

	@Test
	public void updateOldDataWithInsuranceBenefitPlanEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;
			InsuranceBenefitPlanEntity updatedInsuranceBenefitPlanEntity;

			InsuranceProviderEntity insuranceProviderEntity;

			Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurancesEntities;
			Set<UUID> invoicePaymentInsurancesEntityIds;

			Set<PatientPaymentInsuranceEntity> patientPaymentInsurancesEntities;
			Set<UUID> patientPaymentInsurancesEntityIds;

			Set<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurancesEntities;
			Set<UUID> patientVisitPatientPaymentInsurancesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(true, false);
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
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity.getInsuranceProvider(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Insurance Provider relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			insuranceProviderEntity = insuranceProviderRepository.findById(insuranceProviderRepository.save(insuranceBenefitPlanEntity.getInsuranceProvider()).getId()).get();
			insuranceBenefitPlanEntity.unsetInsuranceProvider();
			insuranceBenefitPlanEntity.setInsuranceProviderId(insuranceProviderEntity.getId());

			invoicePaymentInsurancesEntities = new HashSet<>();
			invoicePaymentInsurancesEntityIds = new HashSet<>();
			for (InvoicePaymentInsuranceEntity entity : insuranceBenefitPlanEntity.getInvoicePaymentInsurances()) {
				try {
					invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Payment Insurances relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoicePaymentInsuranceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicePaymentInsurancesEntities.add(invoicePaymentInsuranceRepository.findById(id).get());
				invoicePaymentInsurancesEntityIds.add(id);
			}
			insuranceBenefitPlanEntity.unsetInvoicePaymentInsurances();
			insuranceBenefitPlanEntity.setInvoicePaymentInsurancesIds(invoicePaymentInsurancesEntityIds);

			patientPaymentInsurancesEntities = new HashSet<>();
			patientPaymentInsurancesEntityIds = new HashSet<>();
			for (PatientPaymentInsuranceEntity entity : insuranceBenefitPlanEntity.getPatientPaymentInsurances()) {
				try {
					patientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Payment Insurances relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientPaymentInsuranceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientPaymentInsurancesEntities.add(patientPaymentInsuranceRepository.findById(id).get());
				patientPaymentInsurancesEntityIds.add(id);
			}
			insuranceBenefitPlanEntity.unsetPatientPaymentInsurances();
			insuranceBenefitPlanEntity.setPatientPaymentInsurancesIds(patientPaymentInsurancesEntityIds);

			patientVisitPatientPaymentInsurancesEntities = new HashSet<>();
			patientVisitPatientPaymentInsurancesEntityIds = new HashSet<>();
			for (PatientVisitPatientPaymentInsuranceEntity entity : insuranceBenefitPlanEntity.getPatientVisitPatientPaymentInsurances()) {
				try {
					patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Visit Patient Payment Insurances relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientVisitPatientPaymentInsuranceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientVisitPatientPaymentInsurancesEntities.add(patientVisitPatientPaymentInsuranceRepository.findById(id).get());
				patientVisitPatientPaymentInsurancesEntityIds.add(id);
			}
			insuranceBenefitPlanEntity.unsetPatientVisitPatientPaymentInsurances();
			insuranceBenefitPlanEntity.setPatientVisitPatientPaymentInsurancesIds(patientVisitPatientPaymentInsurancesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInsuranceBenefitPlanEntity = insuranceBenefitPlanService.updateOldData(insuranceBenefitPlanEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			insuranceProviderEntity.unsetInsuranceBenefitPlans(false);
			updatedInsuranceBenefitPlanEntity.getInsuranceProvider().unsetInsuranceBenefitPlans(false);
			Assertions.assertEquals(insuranceProviderEntity, updatedInsuranceBenefitPlanEntity.getInsuranceProvider());

			Assertions.assertEquals(invoicePaymentInsurancesEntities.size(), updatedInsuranceBenefitPlanEntity.getInvoicePaymentInsurances().size());

			Assertions.assertEquals(patientPaymentInsurancesEntities.size(), updatedInsuranceBenefitPlanEntity.getPatientPaymentInsurances().size());

			Assertions.assertEquals(patientVisitPatientPaymentInsurancesEntities.size(), updatedInsuranceBenefitPlanEntity.getPatientVisitPatientPaymentInsurances().size());

		});
	}

	@Test
	public void whenCreateInsuranceBenefitPlanEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;
			Optional<InsuranceBenefitPlanEntity> fetchedInsuranceBenefitPlanEntity;

			try {
				insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceBenefitPlanEntity = insuranceBenefitPlanService.create(insuranceBenefitPlanEntity);

			fetchedInsuranceBenefitPlanEntity = insuranceBenefitPlanService.findById(insuranceBenefitPlanEntity.getId());

			Assertions.assertTrue(fetchedInsuranceBenefitPlanEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInsuranceBenefitPlanEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(insuranceBenefitPlanEntity, fetchedInsuranceBenefitPlanEntity.get());
		});
	}

	@Test
	public void whenUpdateInsuranceBenefitPlanEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;
			InsuranceBenefitPlanEntity updatedInsuranceBenefitPlanEntity;
			Optional<InsuranceBenefitPlanEntity> fetchedInsuranceBenefitPlanEntity;

			try {
				insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity, true, true, false);
				updatedInsuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInsuranceBenefitPlanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceBenefitPlanEntity = insuranceBenefitPlanService.create(insuranceBenefitPlanEntity);

			updatedInsuranceBenefitPlanEntity.setId(insuranceBenefitPlanEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInsuranceBenefitPlanEntity.setCreated(insuranceBenefitPlanEntity.getCreated());

			updatedInsuranceBenefitPlanEntity = insuranceBenefitPlanService.update(updatedInsuranceBenefitPlanEntity);

			fetchedInsuranceBenefitPlanEntity = insuranceBenefitPlanService.findById(insuranceBenefitPlanEntity.getId());

			Assertions.assertTrue(fetchedInsuranceBenefitPlanEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInsuranceBenefitPlanEntity_ThenEntityIsCreated
			fetchedInsuranceBenefitPlanEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInsuranceBenefitPlanEntity, fetchedInsuranceBenefitPlanEntity.get());
		});
	}

	@Test
	public void whenDeleteInsuranceBenefitPlanEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;
			Optional<InsuranceBenefitPlanEntity> fetchedInsuranceBenefitPlanEntity;

			try {
				insuranceBenefitPlanEntity = insuranceBenefitPlanFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceBenefitPlanEntity = insuranceBenefitPlanService.create(insuranceBenefitPlanEntity);

			insuranceBenefitPlanService.deleteById(insuranceBenefitPlanEntity.getId());
			fetchedInsuranceBenefitPlanEntity = insuranceBenefitPlanService.findById(insuranceBenefitPlanEntity.getId());

			Assertions.assertTrue(fetchedInsuranceBenefitPlanEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
