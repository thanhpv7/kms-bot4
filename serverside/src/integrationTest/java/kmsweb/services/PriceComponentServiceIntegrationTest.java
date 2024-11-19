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
import kmsweb.entities.PriceComponentEntity;
import kmsweb.repositories.PriceComponentRepository;
import kmsweb.utils.PriceComponentFactory;
import kmsweb.utils.DatabasePopulators.PriceComponentDatabasePopulator;
import kmsweb.entities.InvoiceItemComponentEntity;
import kmsweb.repositories.InvoiceItemComponentRepository;
import kmsweb.utils.InvoiceItemComponentFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemComponentDatabasePopulator;
import kmsweb.entities.MedicalFeeItemComponentEntity;
import kmsweb.repositories.MedicalFeeItemComponentRepository;
import kmsweb.utils.MedicalFeeItemComponentFactory;
import kmsweb.utils.DatabasePopulators.MedicalFeeItemComponentDatabasePopulator;
import kmsweb.entities.TariffDefinitionOtherComponentEntity;
import kmsweb.repositories.TariffDefinitionOtherComponentRepository;
import kmsweb.utils.TariffDefinitionOtherComponentFactory;
import kmsweb.utils.DatabasePopulators.TariffDefinitionOtherComponentDatabasePopulator;
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
public class PriceComponentServiceIntegrationTest {

	@Autowired
	private PriceComponentRepository priceComponentRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PriceComponentService priceComponentService;

	private final PriceComponentFactory priceComponentFactory = new PriceComponentFactory();

	@Autowired
	private PriceComponentDatabasePopulator priceComponentDatabasePopulator;

	@Autowired
	private InvoiceItemComponentRepository invoiceItemComponentRepository;

	@Autowired
	private InvoiceItemComponentDatabasePopulator invoiceItemComponentDatabasePopulator;

	private final InvoiceItemComponentFactory invoiceItemComponentFactory = new InvoiceItemComponentFactory();

	@Autowired
	private MedicalFeeItemComponentRepository medicalFeeItemComponentRepository;

	@Autowired
	private MedicalFeeItemComponentDatabasePopulator medicalFeeItemComponentDatabasePopulator;

	private final MedicalFeeItemComponentFactory medicalFeeItemComponentFactory = new MedicalFeeItemComponentFactory();

	@Autowired
	private TariffDefinitionOtherComponentRepository tariffDefinitionOtherComponentRepository;

	@Autowired
	private TariffDefinitionOtherComponentDatabasePopulator tariffDefinitionOtherComponentDatabasePopulator;

	private final TariffDefinitionOtherComponentFactory tariffDefinitionOtherComponentFactory = new TariffDefinitionOtherComponentFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		priceComponentService = new PriceComponentService(
			invoiceItemComponentRepository,
			medicalFeeItemComponentRepository,
			tariffDefinitionOtherComponentRepository,
			validator,
			auditRepository,
			priceComponentRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPriceComponentEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PriceComponentEntity priceComponentEntity = priceComponentFactory.getObject(false, false);

		PriceComponentEntity updatedEntity = priceComponentService.updateOldData(priceComponentEntity);
		Assertions.assertEquals(priceComponentEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPriceComponentEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PriceComponentEntity priceComponentEntity;
			PriceComponentEntity entityWithUpdatedValues;

			try {
				priceComponentEntity = priceComponentFactory.getObject(false, false);
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(priceComponentEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = priceComponentFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			priceComponentEntity = priceComponentService.create(priceComponentEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(priceComponentEntity.getId());

			PriceComponentEntity updatedEntity = priceComponentService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPriceComponentEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PriceComponentEntity priceComponentEntity = priceComponentFactory.getObject(false, false);
		priceComponentEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			priceComponentService.updateOldData(priceComponentEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPriceComponentEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PriceComponentEntity priceComponentEntity;
			PriceComponentEntity updatedPriceComponentEntity;

			Set<InvoiceItemComponentEntity> invoiceItemComponentsEntities;

			Set<MedicalFeeItemComponentEntity> medicalFeeItemComponentsEntities;

			Set<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponentsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				priceComponentEntity = priceComponentFactory.getObject(true, false);
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
			invoiceItemComponentsEntities = priceComponentEntity.getInvoiceItemComponents();
			Set<UUID> invoiceItemComponentsEntityIds = new HashSet<>();
			for (InvoiceItemComponentEntity entity : invoiceItemComponentsEntities) {
				try {
					invoiceItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceItemComponentsEntityIds.add(invoiceItemComponentRepository.save(entity).getId());
			}
			priceComponentEntity.setInvoiceItemComponentsIds(invoiceItemComponentsEntityIds);

			medicalFeeItemComponentsEntities = priceComponentEntity.getMedicalFeeItemComponents();
			Set<UUID> medicalFeeItemComponentsEntityIds = new HashSet<>();
			for (MedicalFeeItemComponentEntity entity : medicalFeeItemComponentsEntities) {
				try {
					medicalFeeItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalFeeItemComponentsEntityIds.add(medicalFeeItemComponentRepository.save(entity).getId());
			}
			priceComponentEntity.setMedicalFeeItemComponentsIds(medicalFeeItemComponentsEntityIds);

			tariffDefinitionOtherComponentsEntities = priceComponentEntity.getTariffDefinitionOtherComponents();
			Set<UUID> tariffDefinitionOtherComponentsEntityIds = new HashSet<>();
			for (TariffDefinitionOtherComponentEntity entity : tariffDefinitionOtherComponentsEntities) {
				try {
					tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				tariffDefinitionOtherComponentsEntityIds.add(tariffDefinitionOtherComponentRepository.save(entity).getId());
			}
			priceComponentEntity.setTariffDefinitionOtherComponentsIds(tariffDefinitionOtherComponentsEntityIds);


			priceComponentEntity = priceComponentService.create(priceComponentEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(priceComponentEntity.getInvoiceItemComponents().size() > 0);
			priceComponentEntity.setInvoiceItemComponentsIds(new HashSet<UUID>());
			priceComponentEntity.unsetInvoiceItemComponents();

			Assertions.assertTrue(priceComponentEntity.getMedicalFeeItemComponents().size() > 0);
			priceComponentEntity.setMedicalFeeItemComponentsIds(new HashSet<UUID>());
			priceComponentEntity.unsetMedicalFeeItemComponents();

			Assertions.assertTrue(priceComponentEntity.getTariffDefinitionOtherComponents().size() > 0);
			priceComponentEntity.setTariffDefinitionOtherComponentsIds(new HashSet<UUID>());
			priceComponentEntity.unsetTariffDefinitionOtherComponents();


			updatedPriceComponentEntity = priceComponentService.updateOldData(priceComponentEntity);

			Assertions.assertEquals(0, updatedPriceComponentEntity.getInvoiceItemComponents().size());

			Assertions.assertEquals(0, updatedPriceComponentEntity.getMedicalFeeItemComponents().size());

			Assertions.assertEquals(0, updatedPriceComponentEntity.getTariffDefinitionOtherComponents().size());

		});
	}

	@Test
	public void updateOldDataWithPriceComponentEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PriceComponentEntity priceComponentEntity;
			PriceComponentEntity updatedPriceComponentEntity;

			Set<InvoiceItemComponentEntity> invoiceItemComponentsEntities;
			Set<UUID> invoiceItemComponentsEntityIds;

			Set<MedicalFeeItemComponentEntity> medicalFeeItemComponentsEntities;
			Set<UUID> medicalFeeItemComponentsEntityIds;

			Set<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponentsEntities;
			Set<UUID> tariffDefinitionOtherComponentsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				priceComponentEntity = priceComponentFactory.getObject(true, false);
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
			invoiceItemComponentsEntities = new HashSet<>();
			invoiceItemComponentsEntityIds = new HashSet<>();
			for (InvoiceItemComponentEntity entity : priceComponentEntity.getInvoiceItemComponents()) {
				try {
					invoiceItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Item Components relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceItemComponentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceItemComponentsEntities.add(invoiceItemComponentRepository.findById(id).get());
				invoiceItemComponentsEntityIds.add(id);
			}
			priceComponentEntity.unsetInvoiceItemComponents();
			priceComponentEntity.setInvoiceItemComponentsIds(invoiceItemComponentsEntityIds);

			medicalFeeItemComponentsEntities = new HashSet<>();
			medicalFeeItemComponentsEntityIds = new HashSet<>();
			for (MedicalFeeItemComponentEntity entity : priceComponentEntity.getMedicalFeeItemComponents()) {
				try {
					medicalFeeItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Fee Item Components relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalFeeItemComponentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalFeeItemComponentsEntities.add(medicalFeeItemComponentRepository.findById(id).get());
				medicalFeeItemComponentsEntityIds.add(id);
			}
			priceComponentEntity.unsetMedicalFeeItemComponents();
			priceComponentEntity.setMedicalFeeItemComponentsIds(medicalFeeItemComponentsEntityIds);

			tariffDefinitionOtherComponentsEntities = new HashSet<>();
			tariffDefinitionOtherComponentsEntityIds = new HashSet<>();
			for (TariffDefinitionOtherComponentEntity entity : priceComponentEntity.getTariffDefinitionOtherComponents()) {
				try {
					tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Tariff Definition Other Components relation for this test: " + e.getCause());
					return;
				}
				UUID id = tariffDefinitionOtherComponentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				tariffDefinitionOtherComponentsEntities.add(tariffDefinitionOtherComponentRepository.findById(id).get());
				tariffDefinitionOtherComponentsEntityIds.add(id);
			}
			priceComponentEntity.unsetTariffDefinitionOtherComponents();
			priceComponentEntity.setTariffDefinitionOtherComponentsIds(tariffDefinitionOtherComponentsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPriceComponentEntity = priceComponentService.updateOldData(priceComponentEntity);

			Assertions.assertEquals(invoiceItemComponentsEntities.size(), updatedPriceComponentEntity.getInvoiceItemComponents().size());

			Assertions.assertEquals(medicalFeeItemComponentsEntities.size(), updatedPriceComponentEntity.getMedicalFeeItemComponents().size());

			Assertions.assertEquals(tariffDefinitionOtherComponentsEntities.size(), updatedPriceComponentEntity.getTariffDefinitionOtherComponents().size());

		});
	}

	@Test
	public void whenCreatePriceComponentEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PriceComponentEntity priceComponentEntity;
			Optional<PriceComponentEntity> fetchedPriceComponentEntity;

			try {
				priceComponentEntity = priceComponentFactory.getObject(false, false);
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(priceComponentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			priceComponentEntity = priceComponentService.create(priceComponentEntity);

			fetchedPriceComponentEntity = priceComponentService.findById(priceComponentEntity.getId());

			Assertions.assertTrue(fetchedPriceComponentEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPriceComponentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(priceComponentEntity, fetchedPriceComponentEntity.get());
		});
	}

	@Test
	public void whenUpdatePriceComponentEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PriceComponentEntity priceComponentEntity;
			PriceComponentEntity updatedPriceComponentEntity;
			Optional<PriceComponentEntity> fetchedPriceComponentEntity;

			try {
				priceComponentEntity = priceComponentFactory.getObject(false, false);
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(priceComponentEntity, true, true, false);
				updatedPriceComponentEntity = priceComponentFactory.getObject(false, false);
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPriceComponentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			priceComponentEntity = priceComponentService.create(priceComponentEntity);

			updatedPriceComponentEntity.setId(priceComponentEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPriceComponentEntity.setCreated(priceComponentEntity.getCreated());

			updatedPriceComponentEntity = priceComponentService.update(updatedPriceComponentEntity);

			fetchedPriceComponentEntity = priceComponentService.findById(priceComponentEntity.getId());

			Assertions.assertTrue(fetchedPriceComponentEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePriceComponentEntity_ThenEntityIsCreated
			fetchedPriceComponentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPriceComponentEntity, fetchedPriceComponentEntity.get());
		});
	}

	@Test
	public void whenDeletePriceComponentEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PriceComponentEntity priceComponentEntity;
			Optional<PriceComponentEntity> fetchedPriceComponentEntity;

			try {
				priceComponentEntity = priceComponentFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(priceComponentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			priceComponentEntity = priceComponentService.create(priceComponentEntity);

			priceComponentService.deleteById(priceComponentEntity.getId());
			fetchedPriceComponentEntity = priceComponentService.findById(priceComponentEntity.getId());

			Assertions.assertTrue(fetchedPriceComponentEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
