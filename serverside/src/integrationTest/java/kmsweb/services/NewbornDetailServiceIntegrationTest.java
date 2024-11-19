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
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.utils.NewbornDetailFactory;
import kmsweb.utils.DatabasePopulators.NewbornDetailDatabasePopulator;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.utils.DeliveryMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DeliveryMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.entities.VitalSignsEntity;
import kmsweb.repositories.VitalSignsRepository;
import kmsweb.utils.VitalSignsFactory;
import kmsweb.utils.DatabasePopulators.VitalSignsDatabasePopulator;
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
public class NewbornDetailServiceIntegrationTest {

	@Autowired
	private NewbornDetailRepository newbornDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private NewbornDetailService newbornDetailService;

	private final NewbornDetailFactory newbornDetailFactory = new NewbornDetailFactory();

	@Autowired
	private NewbornDetailDatabasePopulator newbornDetailDatabasePopulator;

	@Autowired
	private DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	@Autowired
	private DeliveryMedicalExaminationRecordDatabasePopulator deliveryMedicalExaminationRecordDatabasePopulator;

	private final DeliveryMedicalExaminationRecordFactory deliveryMedicalExaminationRecordFactory = new DeliveryMedicalExaminationRecordFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();

	@Autowired
	private VitalSignsRepository vitalSignsRepository;

	@Autowired
	private VitalSignsDatabasePopulator vitalSignsDatabasePopulator;

	private final VitalSignsFactory vitalSignsFactory = new VitalSignsFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		newbornDetailService = new NewbornDetailService(
			deliveryMedicalExaminationRecordRepository,
			staffRepository,
			vitalSignsRepository,
			validator,
			auditRepository,
			newbornDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewNewbornDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		NewbornDetailEntity newbornDetailEntity = newbornDetailFactory.getObject(false, false);

		NewbornDetailEntity updatedEntity = newbornDetailService.updateOldData(newbornDetailEntity);
		Assertions.assertEquals(newbornDetailEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingNewbornDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			NewbornDetailEntity newbornDetailEntity;
			NewbornDetailEntity entityWithUpdatedValues;

			try {
				newbornDetailEntity = newbornDetailFactory.getObject(false, false);
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = newbornDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			newbornDetailEntity = newbornDetailService.create(newbornDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(newbornDetailEntity.getId());

			NewbornDetailEntity updatedEntity = newbornDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithNewbornDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		NewbornDetailEntity newbornDetailEntity = newbornDetailFactory.getObject(false, false);
		newbornDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			newbornDetailService.updateOldData(newbornDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingNewbornDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			NewbornDetailEntity newbornDetailEntity;
			NewbornDetailEntity updatedNewbornDetailEntity;

			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;

			StaffEntity staffEntity;

			Set<VitalSignsEntity> vitalSignsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				newbornDetailEntity = newbornDetailFactory.getObject(true, false);
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
			deliveryMedicalExaminationRecordEntity = newbornDetailEntity.getDeliveryMedicalExaminationRecord();
			try {
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordRepository.save(deliveryMedicalExaminationRecordEntity);
			newbornDetailEntity.setDeliveryMedicalExaminationRecordId(deliveryMedicalExaminationRecordEntity.getId());

			staffEntity = newbornDetailEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			newbornDetailEntity.setStaffId(staffEntity.getId());

			vitalSignsEntities = newbornDetailEntity.getVitalSigns();
			Set<UUID> vitalSignsEntityIds = new HashSet<>();
			for (VitalSignsEntity entity : vitalSignsEntities) {
				try {
					vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				vitalSignsEntityIds.add(vitalSignsRepository.save(entity).getId());
			}
			newbornDetailEntity.setVitalSignsIds(vitalSignsEntityIds);


			newbornDetailEntity = newbornDetailService.create(newbornDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(newbornDetailEntity.getDeliveryMedicalExaminationRecord());
			newbornDetailEntity.setDeliveryMedicalExaminationRecordId(null);
			newbornDetailEntity.unsetDeliveryMedicalExaminationRecord();

			Assertions.assertNotNull(newbornDetailEntity.getStaff());
			newbornDetailEntity.setStaffId(null);
			newbornDetailEntity.unsetStaff();

			Assertions.assertTrue(newbornDetailEntity.getVitalSigns().size() > 0);
			newbornDetailEntity.setVitalSignsIds(new HashSet<UUID>());
			newbornDetailEntity.unsetVitalSigns();


			updatedNewbornDetailEntity = newbornDetailService.updateOldData(newbornDetailEntity);

			Assertions.assertNull(updatedNewbornDetailEntity.getDeliveryMedicalExaminationRecord());

			Assertions.assertNull(updatedNewbornDetailEntity.getStaff());

			Assertions.assertEquals(0, updatedNewbornDetailEntity.getVitalSigns().size());

		});
	}

	@Test
	public void updateOldDataWithNewbornDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			NewbornDetailEntity newbornDetailEntity;
			NewbornDetailEntity updatedNewbornDetailEntity;

			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;

			StaffEntity staffEntity;

			Set<VitalSignsEntity> vitalSignsEntities;
			Set<UUID> vitalSignsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				newbornDetailEntity = newbornDetailFactory.getObject(true, false);
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
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity.getDeliveryMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Delivery Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordRepository.findById(deliveryMedicalExaminationRecordRepository.save(newbornDetailEntity.getDeliveryMedicalExaminationRecord()).getId()).get();
			newbornDetailEntity.unsetDeliveryMedicalExaminationRecord();
			newbornDetailEntity.setDeliveryMedicalExaminationRecordId(deliveryMedicalExaminationRecordEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(newbornDetailEntity.getStaff()).getId()).get();
			newbornDetailEntity.unsetStaff();
			newbornDetailEntity.setStaffId(staffEntity.getId());

			vitalSignsEntities = new HashSet<>();
			vitalSignsEntityIds = new HashSet<>();
			for (VitalSignsEntity entity : newbornDetailEntity.getVitalSigns()) {
				try {
					vitalSignsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Vital Signs relation for this test: " + e.getCause());
					return;
				}
				UUID id = vitalSignsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				vitalSignsEntities.add(vitalSignsRepository.findById(id).get());
				vitalSignsEntityIds.add(id);
			}
			newbornDetailEntity.unsetVitalSigns();
			newbornDetailEntity.setVitalSignsIds(vitalSignsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedNewbornDetailEntity = newbornDetailService.updateOldData(newbornDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			deliveryMedicalExaminationRecordEntity.unsetNewbornDetails(false);
			updatedNewbornDetailEntity.getDeliveryMedicalExaminationRecord().unsetNewbornDetails(false);
			Assertions.assertEquals(deliveryMedicalExaminationRecordEntity, updatedNewbornDetailEntity.getDeliveryMedicalExaminationRecord());

			staffEntity.unsetPediatricianInCharge(false);
			updatedNewbornDetailEntity.getStaff().unsetPediatricianInCharge(false);
			Assertions.assertEquals(staffEntity, updatedNewbornDetailEntity.getStaff());

			Assertions.assertEquals(vitalSignsEntities.size(), updatedNewbornDetailEntity.getVitalSigns().size());

		});
	}

	@Test
	public void whenCreateNewbornDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			NewbornDetailEntity newbornDetailEntity;
			Optional<NewbornDetailEntity> fetchedNewbornDetailEntity;

			try {
				newbornDetailEntity = newbornDetailFactory.getObject(false, false);
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			newbornDetailEntity = newbornDetailService.create(newbornDetailEntity);

			fetchedNewbornDetailEntity = newbornDetailService.findById(newbornDetailEntity.getId());

			Assertions.assertTrue(fetchedNewbornDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedNewbornDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(newbornDetailEntity, fetchedNewbornDetailEntity.get());
		});
	}

	@Test
	public void whenUpdateNewbornDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			NewbornDetailEntity newbornDetailEntity;
			NewbornDetailEntity updatedNewbornDetailEntity;
			Optional<NewbornDetailEntity> fetchedNewbornDetailEntity;

			try {
				newbornDetailEntity = newbornDetailFactory.getObject(false, false);
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity, true, true, false);
				updatedNewbornDetailEntity = newbornDetailFactory.getObject(false, false);
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedNewbornDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			newbornDetailEntity = newbornDetailService.create(newbornDetailEntity);

			updatedNewbornDetailEntity.setId(newbornDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedNewbornDetailEntity.setCreated(newbornDetailEntity.getCreated());

			updatedNewbornDetailEntity = newbornDetailService.update(updatedNewbornDetailEntity);

			fetchedNewbornDetailEntity = newbornDetailService.findById(newbornDetailEntity.getId());

			Assertions.assertTrue(fetchedNewbornDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateNewbornDetailEntity_ThenEntityIsCreated
			fetchedNewbornDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedNewbornDetailEntity, fetchedNewbornDetailEntity.get());
		});
	}

	@Test
	public void whenDeleteNewbornDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			NewbornDetailEntity newbornDetailEntity;
			Optional<NewbornDetailEntity> fetchedNewbornDetailEntity;

			try {
				newbornDetailEntity = newbornDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(newbornDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			newbornDetailEntity = newbornDetailService.create(newbornDetailEntity);

			newbornDetailService.deleteById(newbornDetailEntity.getId());
			fetchedNewbornDetailEntity = newbornDetailService.findById(newbornDetailEntity.getId());

			Assertions.assertTrue(fetchedNewbornDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
