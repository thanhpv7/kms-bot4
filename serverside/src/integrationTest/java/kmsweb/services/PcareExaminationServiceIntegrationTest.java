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
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.repositories.PcareExaminationRepository;
import kmsweb.utils.PcareExaminationFactory;
import kmsweb.utils.DatabasePopulators.PcareExaminationDatabasePopulator;
import kmsweb.entities.PcareActionExaminationEntity;
import kmsweb.repositories.PcareActionExaminationRepository;
import kmsweb.utils.PcareActionExaminationFactory;
import kmsweb.utils.DatabasePopulators.PcareActionExaminationDatabasePopulator;
import kmsweb.entities.PcareCompoundDrugEntity;
import kmsweb.repositories.PcareCompoundDrugRepository;
import kmsweb.utils.PcareCompoundDrugFactory;
import kmsweb.utils.DatabasePopulators.PcareCompoundDrugDatabasePopulator;
import kmsweb.entities.PcareNonCompoundDrugEntity;
import kmsweb.repositories.PcareNonCompoundDrugRepository;
import kmsweb.utils.PcareNonCompoundDrugFactory;
import kmsweb.utils.DatabasePopulators.PcareNonCompoundDrugDatabasePopulator;
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
public class PcareExaminationServiceIntegrationTest {

	@Autowired
	private PcareExaminationRepository pcareExaminationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PcareExaminationService pcareExaminationService;

	private final PcareExaminationFactory pcareExaminationFactory = new PcareExaminationFactory();

	@Autowired
	private PcareExaminationDatabasePopulator pcareExaminationDatabasePopulator;

	@Autowired
	private PcareActionExaminationRepository pcareActionExaminationRepository;

	@Autowired
	private PcareActionExaminationDatabasePopulator pcareActionExaminationDatabasePopulator;

	private final PcareActionExaminationFactory pcareActionExaminationFactory = new PcareActionExaminationFactory();

	@Autowired
	private PcareCompoundDrugRepository pcareCompoundDrugRepository;

	@Autowired
	private PcareCompoundDrugDatabasePopulator pcareCompoundDrugDatabasePopulator;

	private final PcareCompoundDrugFactory pcareCompoundDrugFactory = new PcareCompoundDrugFactory();

	@Autowired
	private PcareNonCompoundDrugRepository pcareNonCompoundDrugRepository;

	@Autowired
	private PcareNonCompoundDrugDatabasePopulator pcareNonCompoundDrugDatabasePopulator;

	private final PcareNonCompoundDrugFactory pcareNonCompoundDrugFactory = new PcareNonCompoundDrugFactory();

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
		pcareExaminationService = new PcareExaminationService(
			pcareActionExaminationRepository,
			pcareCompoundDrugRepository,
			pcareNonCompoundDrugRepository,
			registrationRepository,
			validator,
			auditRepository,
			pcareExaminationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPcareExaminationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PcareExaminationEntity pcareExaminationEntity = pcareExaminationFactory.getObject(false, false);

		PcareExaminationEntity updatedEntity = pcareExaminationService.updateOldData(pcareExaminationEntity);
		Assertions.assertEquals(pcareExaminationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPcareExaminationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PcareExaminationEntity pcareExaminationEntity;
			PcareExaminationEntity entityWithUpdatedValues;

			try {
				pcareExaminationEntity = pcareExaminationFactory.getObject(false, false);
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = pcareExaminationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareExaminationEntity = pcareExaminationService.create(pcareExaminationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(pcareExaminationEntity.getId());

			PcareExaminationEntity updatedEntity = pcareExaminationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPcareExaminationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PcareExaminationEntity pcareExaminationEntity = pcareExaminationFactory.getObject(false, false);
		pcareExaminationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			pcareExaminationService.updateOldData(pcareExaminationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPcareExaminationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PcareExaminationEntity pcareExaminationEntity;
			PcareExaminationEntity updatedPcareExaminationEntity;

			RegistrationEntity registrationEntity;

			Set<PcareActionExaminationEntity> pcareActionExaminationsEntities;

			Set<PcareCompoundDrugEntity> pcareCompoundDrugsEntities;

			Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				pcareExaminationEntity = pcareExaminationFactory.getObject(true, false);
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
			registrationEntity = pcareExaminationEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			pcareExaminationEntity.setRegistrationId(registrationEntity.getId());

			pcareActionExaminationsEntities = pcareExaminationEntity.getPcareActionExaminations();
			Set<UUID> pcareActionExaminationsEntityIds = new HashSet<>();
			for (PcareActionExaminationEntity entity : pcareActionExaminationsEntities) {
				try {
					pcareActionExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				pcareActionExaminationsEntityIds.add(pcareActionExaminationRepository.save(entity).getId());
			}
			pcareExaminationEntity.setPcareActionExaminationsIds(pcareActionExaminationsEntityIds);

			pcareCompoundDrugsEntities = pcareExaminationEntity.getPcareCompoundDrugs();
			Set<UUID> pcareCompoundDrugsEntityIds = new HashSet<>();
			for (PcareCompoundDrugEntity entity : pcareCompoundDrugsEntities) {
				try {
					pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				pcareCompoundDrugsEntityIds.add(pcareCompoundDrugRepository.save(entity).getId());
			}
			pcareExaminationEntity.setPcareCompoundDrugsIds(pcareCompoundDrugsEntityIds);

			pcareNonCompoundDrugsEntities = pcareExaminationEntity.getPcareNonCompoundDrugs();
			Set<UUID> pcareNonCompoundDrugsEntityIds = new HashSet<>();
			for (PcareNonCompoundDrugEntity entity : pcareNonCompoundDrugsEntities) {
				try {
					pcareNonCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				pcareNonCompoundDrugsEntityIds.add(pcareNonCompoundDrugRepository.save(entity).getId());
			}
			pcareExaminationEntity.setPcareNonCompoundDrugsIds(pcareNonCompoundDrugsEntityIds);


			pcareExaminationEntity = pcareExaminationService.create(pcareExaminationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(pcareExaminationEntity.getRegistration());
			pcareExaminationEntity.setRegistrationId(null);
			pcareExaminationEntity.unsetRegistration();

			Assertions.assertTrue(pcareExaminationEntity.getPcareActionExaminations().size() > 0);
			pcareExaminationEntity.setPcareActionExaminationsIds(new HashSet<UUID>());
			pcareExaminationEntity.unsetPcareActionExaminations();

			Assertions.assertTrue(pcareExaminationEntity.getPcareCompoundDrugs().size() > 0);
			pcareExaminationEntity.setPcareCompoundDrugsIds(new HashSet<UUID>());
			pcareExaminationEntity.unsetPcareCompoundDrugs();

			Assertions.assertTrue(pcareExaminationEntity.getPcareNonCompoundDrugs().size() > 0);
			pcareExaminationEntity.setPcareNonCompoundDrugsIds(new HashSet<UUID>());
			pcareExaminationEntity.unsetPcareNonCompoundDrugs();


			updatedPcareExaminationEntity = pcareExaminationService.updateOldData(pcareExaminationEntity);

			Assertions.assertNull(updatedPcareExaminationEntity.getRegistration());

			Assertions.assertEquals(0, updatedPcareExaminationEntity.getPcareActionExaminations().size());

			Assertions.assertEquals(0, updatedPcareExaminationEntity.getPcareCompoundDrugs().size());

			Assertions.assertEquals(0, updatedPcareExaminationEntity.getPcareNonCompoundDrugs().size());

		});
	}

	@Test
	public void updateOldDataWithPcareExaminationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PcareExaminationEntity pcareExaminationEntity;
			PcareExaminationEntity updatedPcareExaminationEntity;

			RegistrationEntity registrationEntity;

			Set<PcareActionExaminationEntity> pcareActionExaminationsEntities;
			Set<UUID> pcareActionExaminationsEntityIds;

			Set<PcareCompoundDrugEntity> pcareCompoundDrugsEntities;
			Set<UUID> pcareCompoundDrugsEntityIds;

			Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugsEntities;
			Set<UUID> pcareNonCompoundDrugsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				pcareExaminationEntity = pcareExaminationFactory.getObject(true, false);
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
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(pcareExaminationEntity.getRegistration()).getId()).get();
			pcareExaminationEntity.unsetRegistration();
			pcareExaminationEntity.setRegistrationId(registrationEntity.getId());

			pcareActionExaminationsEntities = new HashSet<>();
			pcareActionExaminationsEntityIds = new HashSet<>();
			for (PcareActionExaminationEntity entity : pcareExaminationEntity.getPcareActionExaminations()) {
				try {
					pcareActionExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the PCare Action Examinations relation for this test: " + e.getCause());
					return;
				}
				UUID id = pcareActionExaminationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				pcareActionExaminationsEntities.add(pcareActionExaminationRepository.findById(id).get());
				pcareActionExaminationsEntityIds.add(id);
			}
			pcareExaminationEntity.unsetPcareActionExaminations();
			pcareExaminationEntity.setPcareActionExaminationsIds(pcareActionExaminationsEntityIds);

			pcareCompoundDrugsEntities = new HashSet<>();
			pcareCompoundDrugsEntityIds = new HashSet<>();
			for (PcareCompoundDrugEntity entity : pcareExaminationEntity.getPcareCompoundDrugs()) {
				try {
					pcareCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the PCare Compound Drugs relation for this test: " + e.getCause());
					return;
				}
				UUID id = pcareCompoundDrugRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				pcareCompoundDrugsEntities.add(pcareCompoundDrugRepository.findById(id).get());
				pcareCompoundDrugsEntityIds.add(id);
			}
			pcareExaminationEntity.unsetPcareCompoundDrugs();
			pcareExaminationEntity.setPcareCompoundDrugsIds(pcareCompoundDrugsEntityIds);

			pcareNonCompoundDrugsEntities = new HashSet<>();
			pcareNonCompoundDrugsEntityIds = new HashSet<>();
			for (PcareNonCompoundDrugEntity entity : pcareExaminationEntity.getPcareNonCompoundDrugs()) {
				try {
					pcareNonCompoundDrugDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the PCare NonCompound Drugs relation for this test: " + e.getCause());
					return;
				}
				UUID id = pcareNonCompoundDrugRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				pcareNonCompoundDrugsEntities.add(pcareNonCompoundDrugRepository.findById(id).get());
				pcareNonCompoundDrugsEntityIds.add(id);
			}
			pcareExaminationEntity.unsetPcareNonCompoundDrugs();
			pcareExaminationEntity.setPcareNonCompoundDrugsIds(pcareNonCompoundDrugsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPcareExaminationEntity = pcareExaminationService.updateOldData(pcareExaminationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			registrationEntity.unsetPcareExamination(false);
			updatedPcareExaminationEntity.getRegistration().unsetPcareExamination(false);
			Assertions.assertEquals(registrationEntity, updatedPcareExaminationEntity.getRegistration());

			Assertions.assertEquals(pcareActionExaminationsEntities.size(), updatedPcareExaminationEntity.getPcareActionExaminations().size());

			Assertions.assertEquals(pcareCompoundDrugsEntities.size(), updatedPcareExaminationEntity.getPcareCompoundDrugs().size());

			Assertions.assertEquals(pcareNonCompoundDrugsEntities.size(), updatedPcareExaminationEntity.getPcareNonCompoundDrugs().size());

		});
	}

	@Test
	public void whenCreatePcareExaminationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareExaminationEntity pcareExaminationEntity;
			Optional<PcareExaminationEntity> fetchedPcareExaminationEntity;

			try {
				pcareExaminationEntity = pcareExaminationFactory.getObject(false, false);
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareExaminationEntity = pcareExaminationService.create(pcareExaminationEntity);

			fetchedPcareExaminationEntity = pcareExaminationService.findById(pcareExaminationEntity.getId());

			Assertions.assertTrue(fetchedPcareExaminationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPcareExaminationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(pcareExaminationEntity, fetchedPcareExaminationEntity.get());
		});
	}

	@Test
	public void whenUpdatePcareExaminationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PcareExaminationEntity pcareExaminationEntity;
			PcareExaminationEntity updatedPcareExaminationEntity;
			Optional<PcareExaminationEntity> fetchedPcareExaminationEntity;

			try {
				pcareExaminationEntity = pcareExaminationFactory.getObject(false, false);
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity, true, true, false);
				updatedPcareExaminationEntity = pcareExaminationFactory.getObject(false, false);
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPcareExaminationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareExaminationEntity = pcareExaminationService.create(pcareExaminationEntity);

			updatedPcareExaminationEntity.setId(pcareExaminationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPcareExaminationEntity.setCreated(pcareExaminationEntity.getCreated());

			updatedPcareExaminationEntity = pcareExaminationService.update(updatedPcareExaminationEntity);

			fetchedPcareExaminationEntity = pcareExaminationService.findById(pcareExaminationEntity.getId());

			Assertions.assertTrue(fetchedPcareExaminationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePcareExaminationEntity_ThenEntityIsCreated
			fetchedPcareExaminationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPcareExaminationEntity, fetchedPcareExaminationEntity.get());
		});
	}

	@Test
	public void whenDeletePcareExaminationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PcareExaminationEntity pcareExaminationEntity;
			Optional<PcareExaminationEntity> fetchedPcareExaminationEntity;

			try {
				pcareExaminationEntity = pcareExaminationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			pcareExaminationEntity = pcareExaminationService.create(pcareExaminationEntity);

			pcareExaminationService.deleteById(pcareExaminationEntity.getId());
			fetchedPcareExaminationEntity = pcareExaminationService.findById(pcareExaminationEntity.getId());

			Assertions.assertTrue(fetchedPcareExaminationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
