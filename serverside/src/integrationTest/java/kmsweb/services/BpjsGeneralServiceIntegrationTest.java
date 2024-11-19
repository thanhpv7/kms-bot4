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
import kmsweb.entities.BpjsGeneralEntity;
import kmsweb.repositories.BpjsGeneralRepository;
import kmsweb.utils.BpjsGeneralFactory;
import kmsweb.utils.DatabasePopulators.BpjsGeneralDatabasePopulator;
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
public class BpjsGeneralServiceIntegrationTest {

	@Autowired
	private BpjsGeneralRepository bpjsGeneralRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsGeneralService bpjsGeneralService;

	private final BpjsGeneralFactory bpjsGeneralFactory = new BpjsGeneralFactory();

	@Autowired
	private BpjsGeneralDatabasePopulator bpjsGeneralDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsGeneralService = new BpjsGeneralService(
			validator,
			auditRepository,
			bpjsGeneralRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsGeneralEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsGeneralEntity bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);

		BpjsGeneralEntity updatedEntity = bpjsGeneralService.updateOldData(bpjsGeneralEntity);
		Assertions.assertEquals(bpjsGeneralEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewBpjsGeneralEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		BpjsGeneralEntity bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);

		bpjsGeneralEntity.setConnectToOtherSystem(null);
		Assertions.assertNull(bpjsGeneralEntity.getConnectToOtherSystem());

		bpjsGeneralEntity.setIsmobilejkn(null);
		Assertions.assertNull(bpjsGeneralEntity.getIsmobilejkn());

		bpjsGeneralEntity.setBasicAuth(null);
		Assertions.assertNull(bpjsGeneralEntity.getBasicAuth());

		bpjsGeneralEntity.setBypassSSLValidation(null);
		Assertions.assertNull(bpjsGeneralEntity.getBypassSSLValidation());

		bpjsGeneralEntity.setClaimStatus(null);
		Assertions.assertNull(bpjsGeneralEntity.getClaimStatus());

		bpjsGeneralEntity.setSendNonJKN(null);
		Assertions.assertNull(bpjsGeneralEntity.getSendNonJKN());

		bpjsGeneralEntity.setVclaimIntegration(null);
		Assertions.assertNull(bpjsGeneralEntity.getVclaimIntegration());


		BpjsGeneralEntity updatedEntity = bpjsGeneralService.updateOldData(bpjsGeneralEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getConnectToOtherSystem());
		Assertions.assertFalse(updatedEntity.getConnectToOtherSystem());

		Assertions.assertNotNull(updatedEntity.getIsmobilejkn());
		Assertions.assertFalse(updatedEntity.getIsmobilejkn());

		Assertions.assertNotNull(updatedEntity.getBasicAuth());
		Assertions.assertFalse(updatedEntity.getBasicAuth());

		Assertions.assertNotNull(updatedEntity.getBypassSSLValidation());
		Assertions.assertFalse(updatedEntity.getBypassSSLValidation());

		Assertions.assertNotNull(updatedEntity.getClaimStatus());
		Assertions.assertFalse(updatedEntity.getClaimStatus());

		Assertions.assertNotNull(updatedEntity.getSendNonJKN());
		Assertions.assertFalse(updatedEntity.getSendNonJKN());

		Assertions.assertNotNull(updatedEntity.getVclaimIntegration());
		Assertions.assertFalse(updatedEntity.getVclaimIntegration());

	}

	@Test
	public void updateOldDataWithExistingBpjsGeneralEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsGeneralEntity bpjsGeneralEntity;
			BpjsGeneralEntity entityWithUpdatedValues;

			try {
				bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);
				bpjsGeneralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsGeneralEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsGeneralFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsGeneralEntity = bpjsGeneralService.create(bpjsGeneralEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsGeneralEntity.getId());

			BpjsGeneralEntity updatedEntity = bpjsGeneralService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsGeneralEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsGeneralEntity bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);
		bpjsGeneralEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsGeneralService.updateOldData(bpjsGeneralEntity);
		});
	}

	@Test
	public void whenCreateBpjsGeneralEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsGeneralEntity bpjsGeneralEntity;
			Optional<BpjsGeneralEntity> fetchedBpjsGeneralEntity;

			try {
				bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);
				bpjsGeneralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsGeneralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsGeneralEntity = bpjsGeneralService.create(bpjsGeneralEntity);

			fetchedBpjsGeneralEntity = bpjsGeneralService.findById(bpjsGeneralEntity.getId());

			Assertions.assertTrue(fetchedBpjsGeneralEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsGeneralEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsGeneralEntity, fetchedBpjsGeneralEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsGeneralEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsGeneralEntity bpjsGeneralEntity;
			BpjsGeneralEntity updatedBpjsGeneralEntity;
			Optional<BpjsGeneralEntity> fetchedBpjsGeneralEntity;

			try {
				bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);
				bpjsGeneralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsGeneralEntity, true, true, false);
				updatedBpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);
				bpjsGeneralDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsGeneralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsGeneralEntity = bpjsGeneralService.create(bpjsGeneralEntity);

			updatedBpjsGeneralEntity.setId(bpjsGeneralEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsGeneralEntity.setCreated(bpjsGeneralEntity.getCreated());

			updatedBpjsGeneralEntity = bpjsGeneralService.update(updatedBpjsGeneralEntity);

			fetchedBpjsGeneralEntity = bpjsGeneralService.findById(bpjsGeneralEntity.getId());

			Assertions.assertTrue(fetchedBpjsGeneralEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsGeneralEntity_ThenEntityIsCreated
			fetchedBpjsGeneralEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsGeneralEntity, fetchedBpjsGeneralEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsGeneralEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsGeneralEntity bpjsGeneralEntity;
			Optional<BpjsGeneralEntity> fetchedBpjsGeneralEntity;

			try {
				bpjsGeneralEntity = bpjsGeneralFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsGeneralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsGeneralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsGeneralEntity = bpjsGeneralService.create(bpjsGeneralEntity);

			bpjsGeneralService.deleteById(bpjsGeneralEntity.getId());
			fetchedBpjsGeneralEntity = bpjsGeneralService.findById(bpjsGeneralEntity.getId());

			Assertions.assertTrue(fetchedBpjsGeneralEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
