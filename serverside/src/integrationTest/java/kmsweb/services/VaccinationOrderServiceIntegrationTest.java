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
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.repositories.VaccinationOrderRepository;
import kmsweb.utils.VaccinationOrderFactory;
import kmsweb.utils.DatabasePopulators.VaccinationOrderDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.repositories.VaccinationOrderDetailRepository;
import kmsweb.utils.VaccinationOrderDetailFactory;
import kmsweb.utils.DatabasePopulators.VaccinationOrderDetailDatabasePopulator;
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
public class VaccinationOrderServiceIntegrationTest {

	@Autowired
	private VaccinationOrderRepository vaccinationOrderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private VaccinationOrderService vaccinationOrderService;

	private final VaccinationOrderFactory vaccinationOrderFactory = new VaccinationOrderFactory();

	@Autowired
	private VaccinationOrderDatabasePopulator vaccinationOrderDatabasePopulator;

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();

	@Autowired
	private VaccinationOrderDetailRepository vaccinationOrderDetailRepository;

	@Autowired
	private VaccinationOrderDetailDatabasePopulator vaccinationOrderDetailDatabasePopulator;

	private final VaccinationOrderDetailFactory vaccinationOrderDetailFactory = new VaccinationOrderDetailFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		vaccinationOrderService = new VaccinationOrderService(
			registrationRepository,
			staffRepository,
			vaccinationOrderDetailRepository,
			validator,
			auditRepository,
			vaccinationOrderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewVaccinationOrderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		VaccinationOrderEntity vaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);

		VaccinationOrderEntity updatedEntity = vaccinationOrderService.updateOldData(vaccinationOrderEntity);
		Assertions.assertEquals(vaccinationOrderEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingVaccinationOrderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			VaccinationOrderEntity vaccinationOrderEntity;
			VaccinationOrderEntity entityWithUpdatedValues;

			try {
				vaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);
				vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(vaccinationOrderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = vaccinationOrderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vaccinationOrderEntity = vaccinationOrderService.create(vaccinationOrderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(vaccinationOrderEntity.getId());

			VaccinationOrderEntity updatedEntity = vaccinationOrderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithVaccinationOrderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		VaccinationOrderEntity vaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);
		vaccinationOrderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			vaccinationOrderService.updateOldData(vaccinationOrderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingVaccinationOrderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			VaccinationOrderEntity vaccinationOrderEntity;
			VaccinationOrderEntity updatedVaccinationOrderEntity;

			RegistrationEntity registrationEntity;

			StaffEntity staffEntity;

			Set<VaccinationOrderDetailEntity> vaccinationOrderDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				vaccinationOrderEntity = vaccinationOrderFactory.getObject(true, false);
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
			registrationEntity = vaccinationOrderEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			vaccinationOrderEntity.setRegistrationId(registrationEntity.getId());

			staffEntity = vaccinationOrderEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			vaccinationOrderEntity.setStaffId(staffEntity.getId());

			vaccinationOrderDetailsEntities = vaccinationOrderEntity.getVaccinationOrderDetails();
			Set<UUID> vaccinationOrderDetailsEntityIds = new HashSet<>();
			for (VaccinationOrderDetailEntity entity : vaccinationOrderDetailsEntities) {
				try {
					vaccinationOrderDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				vaccinationOrderDetailsEntityIds.add(vaccinationOrderDetailRepository.save(entity).getId());
			}
			vaccinationOrderEntity.setVaccinationOrderDetailsIds(vaccinationOrderDetailsEntityIds);


			vaccinationOrderEntity = vaccinationOrderService.create(vaccinationOrderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(vaccinationOrderEntity.getRegistration());
			vaccinationOrderEntity.setRegistrationId(null);
			vaccinationOrderEntity.unsetRegistration();

			Assertions.assertNotNull(vaccinationOrderEntity.getStaff());
			vaccinationOrderEntity.setStaffId(null);
			vaccinationOrderEntity.unsetStaff();

			Assertions.assertTrue(vaccinationOrderEntity.getVaccinationOrderDetails().size() > 0);
			vaccinationOrderEntity.setVaccinationOrderDetailsIds(new HashSet<UUID>());
			vaccinationOrderEntity.unsetVaccinationOrderDetails();


			updatedVaccinationOrderEntity = vaccinationOrderService.updateOldData(vaccinationOrderEntity);

			Assertions.assertNull(updatedVaccinationOrderEntity.getRegistration());

			Assertions.assertNull(updatedVaccinationOrderEntity.getStaff());

			Assertions.assertEquals(0, updatedVaccinationOrderEntity.getVaccinationOrderDetails().size());

		});
	}

	@Test
	public void updateOldDataWithVaccinationOrderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			VaccinationOrderEntity vaccinationOrderEntity;
			VaccinationOrderEntity updatedVaccinationOrderEntity;

			RegistrationEntity registrationEntity;

			StaffEntity staffEntity;

			Set<VaccinationOrderDetailEntity> vaccinationOrderDetailsEntities;
			Set<UUID> vaccinationOrderDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				vaccinationOrderEntity = vaccinationOrderFactory.getObject(true, false);
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
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(vaccinationOrderEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(vaccinationOrderEntity.getRegistration()).getId()).get();
			vaccinationOrderEntity.unsetRegistration();
			vaccinationOrderEntity.setRegistrationId(registrationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(vaccinationOrderEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(vaccinationOrderEntity.getStaff()).getId()).get();
			vaccinationOrderEntity.unsetStaff();
			vaccinationOrderEntity.setStaffId(staffEntity.getId());

			vaccinationOrderDetailsEntities = new HashSet<>();
			vaccinationOrderDetailsEntityIds = new HashSet<>();
			for (VaccinationOrderDetailEntity entity : vaccinationOrderEntity.getVaccinationOrderDetails()) {
				try {
					vaccinationOrderDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Vaccination Order Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = vaccinationOrderDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				vaccinationOrderDetailsEntities.add(vaccinationOrderDetailRepository.findById(id).get());
				vaccinationOrderDetailsEntityIds.add(id);
			}
			vaccinationOrderEntity.unsetVaccinationOrderDetails();
			vaccinationOrderEntity.setVaccinationOrderDetailsIds(vaccinationOrderDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedVaccinationOrderEntity = vaccinationOrderService.updateOldData(vaccinationOrderEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			registrationEntity.unsetVaccinationOrders(false);
			updatedVaccinationOrderEntity.getRegistration().unsetVaccinationOrders(false);
			Assertions.assertEquals(registrationEntity, updatedVaccinationOrderEntity.getRegistration());

			staffEntity.unsetVaccinationOrders(false);
			updatedVaccinationOrderEntity.getStaff().unsetVaccinationOrders(false);
			Assertions.assertEquals(staffEntity, updatedVaccinationOrderEntity.getStaff());

			Assertions.assertEquals(vaccinationOrderDetailsEntities.size(), updatedVaccinationOrderEntity.getVaccinationOrderDetails().size());

		});
	}

	@Test
	public void whenCreateVaccinationOrderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			VaccinationOrderEntity vaccinationOrderEntity;
			Optional<VaccinationOrderEntity> fetchedVaccinationOrderEntity;

			try {
				vaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);
				vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(vaccinationOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vaccinationOrderEntity = vaccinationOrderService.create(vaccinationOrderEntity);

			fetchedVaccinationOrderEntity = vaccinationOrderService.findById(vaccinationOrderEntity.getId());

			Assertions.assertTrue(fetchedVaccinationOrderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedVaccinationOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(vaccinationOrderEntity, fetchedVaccinationOrderEntity.get());
		});
	}

	@Test
	public void whenUpdateVaccinationOrderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			VaccinationOrderEntity vaccinationOrderEntity;
			VaccinationOrderEntity updatedVaccinationOrderEntity;
			Optional<VaccinationOrderEntity> fetchedVaccinationOrderEntity;

			try {
				vaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);
				vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(vaccinationOrderEntity, true, true, false);
				updatedVaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);
				vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedVaccinationOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vaccinationOrderEntity = vaccinationOrderService.create(vaccinationOrderEntity);

			updatedVaccinationOrderEntity.setId(vaccinationOrderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedVaccinationOrderEntity.setCreated(vaccinationOrderEntity.getCreated());

			updatedVaccinationOrderEntity = vaccinationOrderService.update(updatedVaccinationOrderEntity);

			fetchedVaccinationOrderEntity = vaccinationOrderService.findById(vaccinationOrderEntity.getId());

			Assertions.assertTrue(fetchedVaccinationOrderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateVaccinationOrderEntity_ThenEntityIsCreated
			fetchedVaccinationOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedVaccinationOrderEntity, fetchedVaccinationOrderEntity.get());
		});
	}

	@Test
	public void whenDeleteVaccinationOrderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			VaccinationOrderEntity vaccinationOrderEntity;
			Optional<VaccinationOrderEntity> fetchedVaccinationOrderEntity;

			try {
				vaccinationOrderEntity = vaccinationOrderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(vaccinationOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			vaccinationOrderEntity = vaccinationOrderService.create(vaccinationOrderEntity);

			vaccinationOrderService.deleteById(vaccinationOrderEntity.getId());
			fetchedVaccinationOrderEntity = vaccinationOrderService.findById(vaccinationOrderEntity.getId());

			Assertions.assertTrue(fetchedVaccinationOrderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
