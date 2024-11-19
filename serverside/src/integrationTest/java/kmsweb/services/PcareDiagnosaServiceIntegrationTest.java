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
import kmsweb.entities.PcareDiagnosaEntity;
import kmsweb.repositories.PcareDiagnosaRepository;
import kmsweb.utils.PcareDiagnosaFactory;
import kmsweb.utils.DatabasePopulators.PcareDiagnosaDatabasePopulator;
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
public class PcareDiagnosaServiceIntegrationTest {

	@Autowired
	private PcareDiagnosaRepository pcareDiagnosaRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PcareDiagnosaService pcareDiagnosaService;

	private final PcareDiagnosaFactory pcareDiagnosaFactory = new PcareDiagnosaFactory();

	@Autowired
	private PcareDiagnosaDatabasePopulator pcareDiagnosaDatabasePopulator;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		pcareDiagnosaService = new PcareDiagnosaService(
			validator,
			auditRepository,
			pcareDiagnosaRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPcareDiagnosaEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PcareDiagnosaEntity pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);

		PcareDiagnosaEntity updatedEntity = pcareDiagnosaService.updateOldData(pcareDiagnosaEntity);
		Assertions.assertEquals(pcareDiagnosaEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPcareDiagnosaEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PcareDiagnosaEntity pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);

		pcareDiagnosaEntity.setNonSpesialis(null);
		Assertions.assertNull(pcareDiagnosaEntity.getNonSpesialis());


		PcareDiagnosaEntity updatedEntity = pcareDiagnosaService.updateOldData(pcareDiagnosaEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getNonSpesialis());
		Assertions.assertFalse(updatedEntity.getNonSpesialis());

	}

	@Test
	public void updateOldDataWithExistingPcareDiagnosaEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PcareDiagnosaEntity pcareDiagnosaEntity;
			PcareDiagnosaEntity entityWithUpdatedValues;

			try {
				pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);
				pcareDiagnosaDatabasePopulator.populateRelatedEntitiesInDatabase(pcareDiagnosaEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = pcareDiagnosaFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareDiagnosaEntity = pcareDiagnosaService.create(pcareDiagnosaEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(pcareDiagnosaEntity.getId());

			PcareDiagnosaEntity updatedEntity = pcareDiagnosaService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPcareDiagnosaEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PcareDiagnosaEntity pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);
		pcareDiagnosaEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			pcareDiagnosaService.updateOldData(pcareDiagnosaEntity);
		});
	}

	@Test
	public void whenCreatePcareDiagnosaEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareDiagnosaEntity pcareDiagnosaEntity;
			Optional<PcareDiagnosaEntity> fetchedPcareDiagnosaEntity;

			try {
				pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);
				pcareDiagnosaDatabasePopulator.populateRelatedEntitiesInDatabase(pcareDiagnosaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareDiagnosaEntity = pcareDiagnosaService.create(pcareDiagnosaEntity);

			fetchedPcareDiagnosaEntity = pcareDiagnosaService.findById(pcareDiagnosaEntity.getId());

			Assertions.assertTrue(fetchedPcareDiagnosaEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPcareDiagnosaEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(pcareDiagnosaEntity, fetchedPcareDiagnosaEntity.get());
		});
	}

	@Test
	public void whenUpdatePcareDiagnosaEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareDiagnosaEntity pcareDiagnosaEntity;
			PcareDiagnosaEntity updatedPcareDiagnosaEntity;
			Optional<PcareDiagnosaEntity> fetchedPcareDiagnosaEntity;

			try {
				pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);
				pcareDiagnosaDatabasePopulator.populateRelatedEntitiesInDatabase(pcareDiagnosaEntity, true, true, false);
				updatedPcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);
				pcareDiagnosaDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPcareDiagnosaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareDiagnosaEntity = pcareDiagnosaService.create(pcareDiagnosaEntity);

			updatedPcareDiagnosaEntity.setId(pcareDiagnosaEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPcareDiagnosaEntity.setCreated(pcareDiagnosaEntity.getCreated());

			updatedPcareDiagnosaEntity = pcareDiagnosaService.update(updatedPcareDiagnosaEntity);

			fetchedPcareDiagnosaEntity = pcareDiagnosaService.findById(pcareDiagnosaEntity.getId());

			Assertions.assertTrue(fetchedPcareDiagnosaEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePcareDiagnosaEntity_ThenEntityIsCreated
			fetchedPcareDiagnosaEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPcareDiagnosaEntity, fetchedPcareDiagnosaEntity.get());
		});
	}

	@Test
	public void whenDeletePcareDiagnosaEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PcareDiagnosaEntity pcareDiagnosaEntity;
			Optional<PcareDiagnosaEntity> fetchedPcareDiagnosaEntity;

			try {
				pcareDiagnosaEntity = pcareDiagnosaFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				pcareDiagnosaDatabasePopulator.populateRelatedEntitiesInDatabase(pcareDiagnosaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareDiagnosaEntity = pcareDiagnosaService.create(pcareDiagnosaEntity);

			pcareDiagnosaService.deleteById(pcareDiagnosaEntity.getId());
			fetchedPcareDiagnosaEntity = pcareDiagnosaService.findById(pcareDiagnosaEntity.getId());

			Assertions.assertTrue(fetchedPcareDiagnosaEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
