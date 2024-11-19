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
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.utils.HospitalBranchInformationFactory;
import kmsweb.utils.DatabasePopulators.HospitalBranchInformationDatabasePopulator;
import kmsweb.entities.HospitalGroupInformationEntity;
import kmsweb.repositories.HospitalGroupInformationRepository;
import kmsweb.utils.HospitalGroupInformationFactory;
import kmsweb.utils.DatabasePopulators.HospitalGroupInformationDatabasePopulator;
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
public class HospitalBranchInformationServiceIntegrationTest {

	@Autowired
	private HospitalBranchInformationRepository hospitalBranchInformationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private HospitalBranchInformationService hospitalBranchInformationService;

	private final HospitalBranchInformationFactory hospitalBranchInformationFactory = new HospitalBranchInformationFactory();

	@Autowired
	private HospitalBranchInformationDatabasePopulator hospitalBranchInformationDatabasePopulator;

	@Autowired
	private HospitalGroupInformationRepository hospitalGroupInformationRepository;

	@Autowired
	private HospitalGroupInformationDatabasePopulator hospitalGroupInformationDatabasePopulator;

	private final HospitalGroupInformationFactory hospitalGroupInformationFactory = new HospitalGroupInformationFactory();

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
		hospitalBranchInformationService = new HospitalBranchInformationService(
			hospitalGroupInformationRepository,
			staffRepository,
			validator,
			auditRepository,
			hospitalBranchInformationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewHospitalBranchInformationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		HospitalBranchInformationEntity hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);

		HospitalBranchInformationEntity updatedEntity = hospitalBranchInformationService.updateOldData(hospitalBranchInformationEntity);
		Assertions.assertEquals(hospitalBranchInformationEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewHospitalBranchInformationEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		HospitalBranchInformationEntity hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);

		hospitalBranchInformationEntity.setIsBPJSFacility(null);
		Assertions.assertNull(hospitalBranchInformationEntity.getIsBPJSFacility());

		hospitalBranchInformationEntity.setSatuSehatIntegration(null);
		Assertions.assertNull(hospitalBranchInformationEntity.getSatuSehatIntegration());


		HospitalBranchInformationEntity updatedEntity = hospitalBranchInformationService.updateOldData(hospitalBranchInformationEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsBPJSFacility());
		Assertions.assertFalse(updatedEntity.getIsBPJSFacility());

		Assertions.assertNotNull(updatedEntity.getSatuSehatIntegration());
		Assertions.assertFalse(updatedEntity.getSatuSehatIntegration());

	}

	@Test
	public void updateOldDataWithExistingHospitalBranchInformationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalBranchInformationEntity hospitalBranchInformationEntity;
			HospitalBranchInformationEntity entityWithUpdatedValues;

			try {
				hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);
				hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalBranchInformationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = hospitalBranchInformationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalBranchInformationEntity = hospitalBranchInformationService.create(hospitalBranchInformationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(hospitalBranchInformationEntity.getId());

			HospitalBranchInformationEntity updatedEntity = hospitalBranchInformationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithHospitalBranchInformationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		HospitalBranchInformationEntity hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);
		hospitalBranchInformationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			hospitalBranchInformationService.updateOldData(hospitalBranchInformationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingHospitalBranchInformationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalBranchInformationEntity hospitalBranchInformationEntity;
			HospitalBranchInformationEntity updatedHospitalBranchInformationEntity;

			HospitalGroupInformationEntity hospitalGroupEntity;

			StaffEntity staffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(true, false);
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
			hospitalGroupEntity = hospitalBranchInformationEntity.getHospitalGroup();
			try {
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalGroupEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			hospitalGroupEntity = hospitalGroupInformationRepository.save(hospitalGroupEntity);
			hospitalBranchInformationEntity.setHospitalGroupId(hospitalGroupEntity.getId());

			staffEntity = hospitalBranchInformationEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			hospitalBranchInformationEntity.setStaffId(staffEntity.getId());


			hospitalBranchInformationEntity = hospitalBranchInformationService.create(hospitalBranchInformationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(hospitalBranchInformationEntity.getHospitalGroup());
			hospitalBranchInformationEntity.setHospitalGroupId(null);
			hospitalBranchInformationEntity.unsetHospitalGroup();

			Assertions.assertNotNull(hospitalBranchInformationEntity.getStaff());
			hospitalBranchInformationEntity.setStaffId(null);
			hospitalBranchInformationEntity.unsetStaff();


			updatedHospitalBranchInformationEntity = hospitalBranchInformationService.updateOldData(hospitalBranchInformationEntity);

			Assertions.assertNull(updatedHospitalBranchInformationEntity.getHospitalGroup());

			Assertions.assertNull(updatedHospitalBranchInformationEntity.getStaff());

		});
	}

	@Test
	public void updateOldDataWithHospitalBranchInformationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalBranchInformationEntity hospitalBranchInformationEntity;
			HospitalBranchInformationEntity updatedHospitalBranchInformationEntity;

			HospitalGroupInformationEntity hospitalGroupEntity;

			StaffEntity staffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(true, false);
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
				hospitalGroupInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalBranchInformationEntity.getHospitalGroup(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Hospital Group relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			hospitalGroupEntity = hospitalGroupInformationRepository.findById(hospitalGroupInformationRepository.save(hospitalBranchInformationEntity.getHospitalGroup()).getId()).get();
			hospitalBranchInformationEntity.unsetHospitalGroup();
			hospitalBranchInformationEntity.setHospitalGroupId(hospitalGroupEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalBranchInformationEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(hospitalBranchInformationEntity.getStaff()).getId()).get();
			hospitalBranchInformationEntity.unsetStaff();
			hospitalBranchInformationEntity.setStaffId(staffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedHospitalBranchInformationEntity = hospitalBranchInformationService.updateOldData(hospitalBranchInformationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			hospitalGroupEntity.unsetHospitalBranchInformations(false);
			updatedHospitalBranchInformationEntity.getHospitalGroup().unsetHospitalBranchInformations(false);
			Assertions.assertEquals(hospitalGroupEntity, updatedHospitalBranchInformationEntity.getHospitalGroup());

			staffEntity.unsetHospitalBranchInformations(false);
			updatedHospitalBranchInformationEntity.getStaff().unsetHospitalBranchInformations(false);
			Assertions.assertEquals(staffEntity, updatedHospitalBranchInformationEntity.getStaff());

		});
	}

	@Test
	public void whenCreateHospitalBranchInformationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalBranchInformationEntity hospitalBranchInformationEntity;
			Optional<HospitalBranchInformationEntity> fetchedHospitalBranchInformationEntity;

			try {
				hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);
				hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalBranchInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalBranchInformationEntity = hospitalBranchInformationService.create(hospitalBranchInformationEntity);

			fetchedHospitalBranchInformationEntity = hospitalBranchInformationService.findById(hospitalBranchInformationEntity.getId());

			Assertions.assertTrue(fetchedHospitalBranchInformationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedHospitalBranchInformationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(hospitalBranchInformationEntity, fetchedHospitalBranchInformationEntity.get());
		});
	}

	@Test
	public void whenUpdateHospitalBranchInformationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalBranchInformationEntity hospitalBranchInformationEntity;
			HospitalBranchInformationEntity updatedHospitalBranchInformationEntity;
			Optional<HospitalBranchInformationEntity> fetchedHospitalBranchInformationEntity;

			try {
				hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);
				hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalBranchInformationEntity, true, true, false);
				updatedHospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);
				hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedHospitalBranchInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalBranchInformationEntity = hospitalBranchInformationService.create(hospitalBranchInformationEntity);

			updatedHospitalBranchInformationEntity.setId(hospitalBranchInformationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedHospitalBranchInformationEntity.setCreated(hospitalBranchInformationEntity.getCreated());

			updatedHospitalBranchInformationEntity = hospitalBranchInformationService.update(updatedHospitalBranchInformationEntity);

			fetchedHospitalBranchInformationEntity = hospitalBranchInformationService.findById(hospitalBranchInformationEntity.getId());

			Assertions.assertTrue(fetchedHospitalBranchInformationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateHospitalBranchInformationEntity_ThenEntityIsCreated
			fetchedHospitalBranchInformationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedHospitalBranchInformationEntity, fetchedHospitalBranchInformationEntity.get());
		});
	}

	@Test
	public void whenDeleteHospitalBranchInformationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			HospitalBranchInformationEntity hospitalBranchInformationEntity;
			Optional<HospitalBranchInformationEntity> fetchedHospitalBranchInformationEntity;

			try {
				hospitalBranchInformationEntity = hospitalBranchInformationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(hospitalBranchInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hospitalBranchInformationEntity = hospitalBranchInformationService.create(hospitalBranchInformationEntity);

			hospitalBranchInformationService.deleteById(hospitalBranchInformationEntity.getId());
			fetchedHospitalBranchInformationEntity = hospitalBranchInformationService.findById(hospitalBranchInformationEntity.getId());

			Assertions.assertTrue(fetchedHospitalBranchInformationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
