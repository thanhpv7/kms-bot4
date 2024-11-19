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
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.repositories.DiagnosticExaminationResultsRepository;
import kmsweb.utils.DiagnosticExaminationResultsFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticExaminationResultsDatabasePopulator;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
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
public class DiagnosticExaminationResultsServiceIntegrationTest {

	@Autowired
	private DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DiagnosticExaminationResultsService diagnosticExaminationResultsService;

	private final DiagnosticExaminationResultsFactory diagnosticExaminationResultsFactory = new DiagnosticExaminationResultsFactory();

	@Autowired
	private DiagnosticExaminationResultsDatabasePopulator diagnosticExaminationResultsDatabasePopulator;

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		diagnosticExaminationResultsService = new DiagnosticExaminationResultsService(
			examinationItemRepository,
			registrationRepository,
			validator,
			auditRepository,
			diagnosticExaminationResultsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDiagnosticExaminationResultsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);

		DiagnosticExaminationResultsEntity updatedEntity = diagnosticExaminationResultsService.updateOldData(diagnosticExaminationResultsEntity);
		Assertions.assertEquals(diagnosticExaminationResultsEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewDiagnosticExaminationResultsEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);

		diagnosticExaminationResultsEntity.setOutsideRange(null);
		Assertions.assertNull(diagnosticExaminationResultsEntity.getOutsideRange());

		diagnosticExaminationResultsEntity.setRepeated(null);
		Assertions.assertNull(diagnosticExaminationResultsEntity.getRepeated());


		DiagnosticExaminationResultsEntity updatedEntity = diagnosticExaminationResultsService.updateOldData(diagnosticExaminationResultsEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getOutsideRange());
		Assertions.assertFalse(updatedEntity.getOutsideRange());

		Assertions.assertNotNull(updatedEntity.getRepeated());
		Assertions.assertFalse(updatedEntity.getRepeated());

	}

	@Test
	public void updateOldDataWithExistingDiagnosticExaminationResultsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity;
			DiagnosticExaminationResultsEntity entityWithUpdatedValues;

			try {
				diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);
				diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticExaminationResultsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = diagnosticExaminationResultsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosticExaminationResultsEntity = diagnosticExaminationResultsService.create(diagnosticExaminationResultsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(diagnosticExaminationResultsEntity.getId());

			DiagnosticExaminationResultsEntity updatedEntity = diagnosticExaminationResultsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDiagnosticExaminationResultsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);
		diagnosticExaminationResultsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			diagnosticExaminationResultsService.updateOldData(diagnosticExaminationResultsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDiagnosticExaminationResultsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity;
			DiagnosticExaminationResultsEntity updatedDiagnosticExaminationResultsEntity;

			ExaminationItemEntity examinationItemEntity;

			RegistrationEntity registrationEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(true, false);
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
			examinationItemEntity = diagnosticExaminationResultsEntity.getExaminationItem();
			try {
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			examinationItemEntity = examinationItemRepository.save(examinationItemEntity);
			diagnosticExaminationResultsEntity.setExaminationItemId(examinationItemEntity.getId());

			registrationEntity = diagnosticExaminationResultsEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			diagnosticExaminationResultsEntity.setRegistrationId(registrationEntity.getId());


			diagnosticExaminationResultsEntity = diagnosticExaminationResultsService.create(diagnosticExaminationResultsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(diagnosticExaminationResultsEntity.getExaminationItem());
			diagnosticExaminationResultsEntity.setExaminationItemId(null);
			diagnosticExaminationResultsEntity.unsetExaminationItem();

			Assertions.assertNotNull(diagnosticExaminationResultsEntity.getRegistration());
			diagnosticExaminationResultsEntity.setRegistrationId(null);
			diagnosticExaminationResultsEntity.unsetRegistration();


			updatedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsService.updateOldData(diagnosticExaminationResultsEntity);

			Assertions.assertNull(updatedDiagnosticExaminationResultsEntity.getExaminationItem());

			Assertions.assertNull(updatedDiagnosticExaminationResultsEntity.getRegistration());

		});
	}

	@Test
	public void updateOldDataWithDiagnosticExaminationResultsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity;
			DiagnosticExaminationResultsEntity updatedDiagnosticExaminationResultsEntity;

			ExaminationItemEntity examinationItemEntity;

			RegistrationEntity registrationEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(true, false);
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
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticExaminationResultsEntity.getExaminationItem(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Examination Item relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			examinationItemEntity = examinationItemRepository.findById(examinationItemRepository.save(diagnosticExaminationResultsEntity.getExaminationItem()).getId()).get();
			diagnosticExaminationResultsEntity.unsetExaminationItem();
			diagnosticExaminationResultsEntity.setExaminationItemId(examinationItemEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticExaminationResultsEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(diagnosticExaminationResultsEntity.getRegistration()).getId()).get();
			diagnosticExaminationResultsEntity.unsetRegistration();
			diagnosticExaminationResultsEntity.setRegistrationId(registrationEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsService.updateOldData(diagnosticExaminationResultsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			examinationItemEntity.unsetDiagnosticExaminationResults(false);
			updatedDiagnosticExaminationResultsEntity.getExaminationItem().unsetDiagnosticExaminationResults(false);
			Assertions.assertEquals(examinationItemEntity, updatedDiagnosticExaminationResultsEntity.getExaminationItem());

			registrationEntity.unsetDiagnosticExaminationResults(false);
			updatedDiagnosticExaminationResultsEntity.getRegistration().unsetDiagnosticExaminationResults(false);
			Assertions.assertEquals(registrationEntity, updatedDiagnosticExaminationResultsEntity.getRegistration());

		});
	}

	@Test
	public void whenCreateDiagnosticExaminationResultsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity;
			Optional<DiagnosticExaminationResultsEntity> fetchedDiagnosticExaminationResultsEntity;

			try {
				diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);
				diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticExaminationResultsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosticExaminationResultsEntity = diagnosticExaminationResultsService.create(diagnosticExaminationResultsEntity);

			fetchedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsService.findById(diagnosticExaminationResultsEntity.getId());

			Assertions.assertTrue(fetchedDiagnosticExaminationResultsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDiagnosticExaminationResultsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(diagnosticExaminationResultsEntity, fetchedDiagnosticExaminationResultsEntity.get());
		});
	}

	@Test
	public void whenUpdateDiagnosticExaminationResultsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity;
			DiagnosticExaminationResultsEntity updatedDiagnosticExaminationResultsEntity;
			Optional<DiagnosticExaminationResultsEntity> fetchedDiagnosticExaminationResultsEntity;

			try {
				diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);
				diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticExaminationResultsEntity, true, true, false);
				updatedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);
				diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDiagnosticExaminationResultsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosticExaminationResultsEntity = diagnosticExaminationResultsService.create(diagnosticExaminationResultsEntity);

			updatedDiagnosticExaminationResultsEntity.setId(diagnosticExaminationResultsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDiagnosticExaminationResultsEntity.setCreated(diagnosticExaminationResultsEntity.getCreated());

			updatedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsService.update(updatedDiagnosticExaminationResultsEntity);

			fetchedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsService.findById(diagnosticExaminationResultsEntity.getId());

			Assertions.assertTrue(fetchedDiagnosticExaminationResultsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDiagnosticExaminationResultsEntity_ThenEntityIsCreated
			fetchedDiagnosticExaminationResultsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDiagnosticExaminationResultsEntity, fetchedDiagnosticExaminationResultsEntity.get());
		});
	}

	@Test
	public void whenDeleteDiagnosticExaminationResultsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity;
			Optional<DiagnosticExaminationResultsEntity> fetchedDiagnosticExaminationResultsEntity;

			try {
				diagnosticExaminationResultsEntity = diagnosticExaminationResultsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticExaminationResultsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosticExaminationResultsEntity = diagnosticExaminationResultsService.create(diagnosticExaminationResultsEntity);

			diagnosticExaminationResultsService.deleteById(diagnosticExaminationResultsEntity.getId());
			fetchedDiagnosticExaminationResultsEntity = diagnosticExaminationResultsService.findById(diagnosticExaminationResultsEntity.getId());

			Assertions.assertTrue(fetchedDiagnosticExaminationResultsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
