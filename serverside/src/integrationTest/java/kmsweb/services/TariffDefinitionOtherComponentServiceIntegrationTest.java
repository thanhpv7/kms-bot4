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
import kmsweb.entities.TariffDefinitionOtherComponentEntity;
import kmsweb.repositories.TariffDefinitionOtherComponentRepository;
import kmsweb.utils.TariffDefinitionOtherComponentFactory;
import kmsweb.utils.DatabasePopulators.TariffDefinitionOtherComponentDatabasePopulator;
import kmsweb.entities.PriceComponentEntity;
import kmsweb.repositories.PriceComponentRepository;
import kmsweb.utils.PriceComponentFactory;
import kmsweb.utils.DatabasePopulators.PriceComponentDatabasePopulator;
import kmsweb.entities.TariffDefinitionEntity;
import kmsweb.repositories.TariffDefinitionRepository;
import kmsweb.utils.TariffDefinitionFactory;
import kmsweb.utils.DatabasePopulators.TariffDefinitionDatabasePopulator;
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
public class TariffDefinitionOtherComponentServiceIntegrationTest {

	@Autowired
	private TariffDefinitionOtherComponentRepository tariffDefinitionOtherComponentRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private TariffDefinitionOtherComponentService tariffDefinitionOtherComponentService;

	private final TariffDefinitionOtherComponentFactory tariffDefinitionOtherComponentFactory = new TariffDefinitionOtherComponentFactory();

	@Autowired
	private TariffDefinitionOtherComponentDatabasePopulator tariffDefinitionOtherComponentDatabasePopulator;

	@Autowired
	private PriceComponentRepository priceComponentRepository;

	@Autowired
	private PriceComponentDatabasePopulator priceComponentDatabasePopulator;

	private final PriceComponentFactory priceComponentFactory = new PriceComponentFactory();

	@Autowired
	private TariffDefinitionRepository tariffDefinitionRepository;

	@Autowired
	private TariffDefinitionDatabasePopulator tariffDefinitionDatabasePopulator;

	private final TariffDefinitionFactory tariffDefinitionFactory = new TariffDefinitionFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		tariffDefinitionOtherComponentService = new TariffDefinitionOtherComponentService(
			priceComponentRepository,
			tariffDefinitionRepository,
			validator,
			auditRepository,
			tariffDefinitionOtherComponentRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewTariffDefinitionOtherComponentEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);

		TariffDefinitionOtherComponentEntity updatedEntity = tariffDefinitionOtherComponentService.updateOldData(tariffDefinitionOtherComponentEntity);
		Assertions.assertEquals(tariffDefinitionOtherComponentEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingTariffDefinitionOtherComponentEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity;
			TariffDefinitionOtherComponentEntity entityWithUpdatedValues;

			try {
				tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);
				tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(tariffDefinitionOtherComponentEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = tariffDefinitionOtherComponentFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.create(tariffDefinitionOtherComponentEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(tariffDefinitionOtherComponentEntity.getId());

			TariffDefinitionOtherComponentEntity updatedEntity = tariffDefinitionOtherComponentService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithTariffDefinitionOtherComponentEntityWithNonExistentId_ShouldThrowException() throws Exception {
		TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);
		tariffDefinitionOtherComponentEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			tariffDefinitionOtherComponentService.updateOldData(tariffDefinitionOtherComponentEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingTariffDefinitionOtherComponentEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity;
			TariffDefinitionOtherComponentEntity updatedTariffDefinitionOtherComponentEntity;

			PriceComponentEntity priceComponentEntity;

			TariffDefinitionEntity priceDefinitionEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(true, false);
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
			priceComponentEntity = tariffDefinitionOtherComponentEntity.getPriceComponent();
			try {
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(priceComponentEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			priceComponentEntity = priceComponentRepository.save(priceComponentEntity);
			tariffDefinitionOtherComponentEntity.setPriceComponentId(priceComponentEntity.getId());

			priceDefinitionEntity = tariffDefinitionOtherComponentEntity.getPriceDefinition();
			try {
				tariffDefinitionDatabasePopulator.populateRelatedEntitiesInDatabase(priceDefinitionEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			priceDefinitionEntity = tariffDefinitionRepository.save(priceDefinitionEntity);
			tariffDefinitionOtherComponentEntity.setPriceDefinitionId(priceDefinitionEntity.getId());


			tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.create(tariffDefinitionOtherComponentEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(tariffDefinitionOtherComponentEntity.getPriceComponent());
			tariffDefinitionOtherComponentEntity.setPriceComponentId(null);
			tariffDefinitionOtherComponentEntity.unsetPriceComponent();

			Assertions.assertNotNull(tariffDefinitionOtherComponentEntity.getPriceDefinition());
			tariffDefinitionOtherComponentEntity.setPriceDefinitionId(null);
			tariffDefinitionOtherComponentEntity.unsetPriceDefinition();


			updatedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.updateOldData(tariffDefinitionOtherComponentEntity);

			Assertions.assertNull(updatedTariffDefinitionOtherComponentEntity.getPriceComponent());

			Assertions.assertNull(updatedTariffDefinitionOtherComponentEntity.getPriceDefinition());

		});
	}

	@Test
	public void updateOldDataWithTariffDefinitionOtherComponentEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity;
			TariffDefinitionOtherComponentEntity updatedTariffDefinitionOtherComponentEntity;

			PriceComponentEntity priceComponentEntity;

			TariffDefinitionEntity priceDefinitionEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(true, false);
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
				priceComponentDatabasePopulator.populateRelatedEntitiesInDatabase(tariffDefinitionOtherComponentEntity.getPriceComponent(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Price Component relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			priceComponentEntity = priceComponentRepository.findById(priceComponentRepository.save(tariffDefinitionOtherComponentEntity.getPriceComponent()).getId()).get();
			tariffDefinitionOtherComponentEntity.unsetPriceComponent();
			tariffDefinitionOtherComponentEntity.setPriceComponentId(priceComponentEntity.getId());

			try {
				tariffDefinitionDatabasePopulator.populateRelatedEntitiesInDatabase(tariffDefinitionOtherComponentEntity.getPriceDefinition(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Price Definition relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			priceDefinitionEntity = tariffDefinitionRepository.findById(tariffDefinitionRepository.save(tariffDefinitionOtherComponentEntity.getPriceDefinition()).getId()).get();
			tariffDefinitionOtherComponentEntity.unsetPriceDefinition();
			tariffDefinitionOtherComponentEntity.setPriceDefinitionId(priceDefinitionEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.updateOldData(tariffDefinitionOtherComponentEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			priceComponentEntity.unsetTariffDefinitionOtherComponents(false);
			updatedTariffDefinitionOtherComponentEntity.getPriceComponent().unsetTariffDefinitionOtherComponents(false);
			Assertions.assertEquals(priceComponentEntity, updatedTariffDefinitionOtherComponentEntity.getPriceComponent());

			priceDefinitionEntity.unsetTariffDefinitionOtherComponents(false);
			updatedTariffDefinitionOtherComponentEntity.getPriceDefinition().unsetTariffDefinitionOtherComponents(false);
			Assertions.assertEquals(priceDefinitionEntity, updatedTariffDefinitionOtherComponentEntity.getPriceDefinition());

		});
	}

	@Test
	public void whenCreateTariffDefinitionOtherComponentEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity;
			Optional<TariffDefinitionOtherComponentEntity> fetchedTariffDefinitionOtherComponentEntity;

			try {
				tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);
				tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(tariffDefinitionOtherComponentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.create(tariffDefinitionOtherComponentEntity);

			fetchedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.findById(tariffDefinitionOtherComponentEntity.getId());

			Assertions.assertTrue(fetchedTariffDefinitionOtherComponentEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedTariffDefinitionOtherComponentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(tariffDefinitionOtherComponentEntity, fetchedTariffDefinitionOtherComponentEntity.get());
		});
	}

	@Test
	public void whenUpdateTariffDefinitionOtherComponentEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity;
			TariffDefinitionOtherComponentEntity updatedTariffDefinitionOtherComponentEntity;
			Optional<TariffDefinitionOtherComponentEntity> fetchedTariffDefinitionOtherComponentEntity;

			try {
				tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);
				tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(tariffDefinitionOtherComponentEntity, true, true, false);
				updatedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);
				tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(updatedTariffDefinitionOtherComponentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.create(tariffDefinitionOtherComponentEntity);

			updatedTariffDefinitionOtherComponentEntity.setId(tariffDefinitionOtherComponentEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedTariffDefinitionOtherComponentEntity.setCreated(tariffDefinitionOtherComponentEntity.getCreated());

			updatedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.update(updatedTariffDefinitionOtherComponentEntity);

			fetchedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.findById(tariffDefinitionOtherComponentEntity.getId());

			Assertions.assertTrue(fetchedTariffDefinitionOtherComponentEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateTariffDefinitionOtherComponentEntity_ThenEntityIsCreated
			fetchedTariffDefinitionOtherComponentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedTariffDefinitionOtherComponentEntity, fetchedTariffDefinitionOtherComponentEntity.get());
		});
	}

	@Test
	public void whenDeleteTariffDefinitionOtherComponentEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity;
			Optional<TariffDefinitionOtherComponentEntity> fetchedTariffDefinitionOtherComponentEntity;

			try {
				tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				tariffDefinitionOtherComponentDatabasePopulator.populateRelatedEntitiesInDatabase(tariffDefinitionOtherComponentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.create(tariffDefinitionOtherComponentEntity);

			tariffDefinitionOtherComponentService.deleteById(tariffDefinitionOtherComponentEntity.getId());
			fetchedTariffDefinitionOtherComponentEntity = tariffDefinitionOtherComponentService.findById(tariffDefinitionOtherComponentEntity.getId());

			Assertions.assertTrue(fetchedTariffDefinitionOtherComponentEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
