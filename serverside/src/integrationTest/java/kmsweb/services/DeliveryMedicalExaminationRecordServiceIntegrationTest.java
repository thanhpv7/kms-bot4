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
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.utils.DeliveryMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DeliveryMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.utils.CoTreatingDoctorFactory;
import kmsweb.utils.DatabasePopulators.CoTreatingDoctorDatabasePopulator;
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.repositories.DeliveryProgressRepository;
import kmsweb.utils.DeliveryProgressFactory;
import kmsweb.utils.DatabasePopulators.DeliveryProgressDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.utils.NewbornDetailFactory;
import kmsweb.utils.DatabasePopulators.NewbornDetailDatabasePopulator;
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
public class DeliveryMedicalExaminationRecordServiceIntegrationTest {

	@Autowired
	private DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final DeliveryMedicalExaminationRecordFactory deliveryMedicalExaminationRecordFactory = new DeliveryMedicalExaminationRecordFactory();

	@Autowired
	private DeliveryMedicalExaminationRecordDatabasePopulator deliveryMedicalExaminationRecordDatabasePopulator;

	@Autowired
	private CoTreatingDoctorRepository coTreatingDoctorRepository;

	@Autowired
	private CoTreatingDoctorDatabasePopulator coTreatingDoctorDatabasePopulator;

	private final CoTreatingDoctorFactory coTreatingDoctorFactory = new CoTreatingDoctorFactory();

	@Autowired
	private DeliveryProgressRepository deliveryProgressRepository;

	@Autowired
	private DeliveryProgressDatabasePopulator deliveryProgressDatabasePopulator;

	private final DeliveryProgressFactory deliveryProgressFactory = new DeliveryProgressFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

	@Autowired
	private NewbornDetailRepository newbornDetailRepository;

	@Autowired
	private NewbornDetailDatabasePopulator newbornDetailDatabasePopulator;

	private final NewbornDetailFactory newbornDetailFactory = new NewbornDetailFactory();

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
		deliveryMedicalExaminationRecordService = new DeliveryMedicalExaminationRecordService(
			coTreatingDoctorRepository,
			deliveryProgressRepository,
			medicalExaminationRecordRepository,
			newbornDetailRepository,
			staffRepository,
			validator,
			auditRepository,
			deliveryMedicalExaminationRecordRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDeliveryMedicalExaminationRecordEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);

		DeliveryMedicalExaminationRecordEntity updatedEntity = deliveryMedicalExaminationRecordService.updateOldData(deliveryMedicalExaminationRecordEntity);
		Assertions.assertEquals(deliveryMedicalExaminationRecordEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewDeliveryMedicalExaminationRecordEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);

		deliveryMedicalExaminationRecordEntity.setTetanusVaccine1(null);
		Assertions.assertNull(deliveryMedicalExaminationRecordEntity.getTetanusVaccine1());

		deliveryMedicalExaminationRecordEntity.setTetanusVaccine2(null);
		Assertions.assertNull(deliveryMedicalExaminationRecordEntity.getTetanusVaccine2());

		deliveryMedicalExaminationRecordEntity.setNormalDeliveryCase(null);
		Assertions.assertNull(deliveryMedicalExaminationRecordEntity.getNormalDeliveryCase());

		deliveryMedicalExaminationRecordEntity.setPerineumInfection(null);
		Assertions.assertNull(deliveryMedicalExaminationRecordEntity.getPerineumInfection());

		deliveryMedicalExaminationRecordEntity.setEarlyBreastfeedingIntiation(null);
		Assertions.assertNull(deliveryMedicalExaminationRecordEntity.getEarlyBreastfeedingIntiation());


		DeliveryMedicalExaminationRecordEntity updatedEntity = deliveryMedicalExaminationRecordService.updateOldData(deliveryMedicalExaminationRecordEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getTetanusVaccine1());
		Assertions.assertFalse(updatedEntity.getTetanusVaccine1());

		Assertions.assertNotNull(updatedEntity.getTetanusVaccine2());
		Assertions.assertFalse(updatedEntity.getTetanusVaccine2());

		Assertions.assertNotNull(updatedEntity.getNormalDeliveryCase());
		Assertions.assertFalse(updatedEntity.getNormalDeliveryCase());

		Assertions.assertNotNull(updatedEntity.getPerineumInfection());
		Assertions.assertFalse(updatedEntity.getPerineumInfection());

		Assertions.assertNotNull(updatedEntity.getEarlyBreastfeedingIntiation());
		Assertions.assertFalse(updatedEntity.getEarlyBreastfeedingIntiation());

	}

	@Test
	public void updateOldDataWithExistingDeliveryMedicalExaminationRecordEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;
			DeliveryMedicalExaminationRecordEntity entityWithUpdatedValues;

			try {
				deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = deliveryMedicalExaminationRecordFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.create(deliveryMedicalExaminationRecordEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(deliveryMedicalExaminationRecordEntity.getId());

			DeliveryMedicalExaminationRecordEntity updatedEntity = deliveryMedicalExaminationRecordService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDeliveryMedicalExaminationRecordEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);
		deliveryMedicalExaminationRecordEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			deliveryMedicalExaminationRecordService.updateOldData(deliveryMedicalExaminationRecordEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDeliveryMedicalExaminationRecordEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;
			DeliveryMedicalExaminationRecordEntity updatedDeliveryMedicalExaminationRecordEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			StaffEntity midwifeEntity;

			Set<CoTreatingDoctorEntity> additionalMidwivesEntities;

			Set<DeliveryProgressEntity> deliveryProgressesEntities;

			Set<NewbornDetailEntity> newbornDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = deliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			deliveryMedicalExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			midwifeEntity = deliveryMedicalExaminationRecordEntity.getMidwife();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(midwifeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			midwifeEntity = staffRepository.save(midwifeEntity);
			deliveryMedicalExaminationRecordEntity.setMidwifeId(midwifeEntity.getId());

			additionalMidwivesEntities = deliveryMedicalExaminationRecordEntity.getAdditionalMidwives();
			Set<UUID> additionalMidwivesEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : additionalMidwivesEntities) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				additionalMidwivesEntityIds.add(coTreatingDoctorRepository.save(entity).getId());
			}
			deliveryMedicalExaminationRecordEntity.setAdditionalMidwivesIds(additionalMidwivesEntityIds);

			deliveryProgressesEntities = deliveryMedicalExaminationRecordEntity.getDeliveryProgresses();
			Set<UUID> deliveryProgressesEntityIds = new HashSet<>();
			for (DeliveryProgressEntity entity : deliveryProgressesEntities) {
				try {
					deliveryProgressDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				deliveryProgressesEntityIds.add(deliveryProgressRepository.save(entity).getId());
			}
			deliveryMedicalExaminationRecordEntity.setDeliveryProgressesIds(deliveryProgressesEntityIds);

			newbornDetailsEntities = deliveryMedicalExaminationRecordEntity.getNewbornDetails();
			Set<UUID> newbornDetailsEntityIds = new HashSet<>();
			for (NewbornDetailEntity entity : newbornDetailsEntities) {
				try {
					newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				newbornDetailsEntityIds.add(newbornDetailRepository.save(entity).getId());
			}
			deliveryMedicalExaminationRecordEntity.setNewbornDetailsIds(newbornDetailsEntityIds);


			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.create(deliveryMedicalExaminationRecordEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(deliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord());
			deliveryMedicalExaminationRecordEntity.setMedicalExaminationRecordId(null);
			deliveryMedicalExaminationRecordEntity.unsetMedicalExaminationRecord();

			Assertions.assertNotNull(deliveryMedicalExaminationRecordEntity.getMidwife());
			deliveryMedicalExaminationRecordEntity.setMidwifeId(null);
			deliveryMedicalExaminationRecordEntity.unsetMidwife();

			Assertions.assertTrue(deliveryMedicalExaminationRecordEntity.getAdditionalMidwives().size() > 0);
			deliveryMedicalExaminationRecordEntity.setAdditionalMidwivesIds(new HashSet<UUID>());
			deliveryMedicalExaminationRecordEntity.unsetAdditionalMidwives();

			Assertions.assertTrue(deliveryMedicalExaminationRecordEntity.getDeliveryProgresses().size() > 0);
			deliveryMedicalExaminationRecordEntity.setDeliveryProgressesIds(new HashSet<UUID>());
			deliveryMedicalExaminationRecordEntity.unsetDeliveryProgresses();

			Assertions.assertTrue(deliveryMedicalExaminationRecordEntity.getNewbornDetails().size() > 0);
			deliveryMedicalExaminationRecordEntity.setNewbornDetailsIds(new HashSet<UUID>());
			deliveryMedicalExaminationRecordEntity.unsetNewbornDetails();


			updatedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.updateOldData(deliveryMedicalExaminationRecordEntity);

			Assertions.assertNull(updatedDeliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord());

			Assertions.assertNull(updatedDeliveryMedicalExaminationRecordEntity.getMidwife());

			Assertions.assertEquals(0, updatedDeliveryMedicalExaminationRecordEntity.getAdditionalMidwives().size());

			Assertions.assertEquals(0, updatedDeliveryMedicalExaminationRecordEntity.getDeliveryProgresses().size());

			Assertions.assertEquals(0, updatedDeliveryMedicalExaminationRecordEntity.getNewbornDetails().size());

		});
	}

	@Test
	public void updateOldDataWithDeliveryMedicalExaminationRecordEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;
			DeliveryMedicalExaminationRecordEntity updatedDeliveryMedicalExaminationRecordEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			StaffEntity midwifeEntity;

			Set<CoTreatingDoctorEntity> additionalMidwivesEntities;
			Set<UUID> additionalMidwivesEntityIds;

			Set<DeliveryProgressEntity> deliveryProgressesEntities;
			Set<UUID> deliveryProgressesEntityIds;

			Set<NewbornDetailEntity> newbornDetailsEntities;
			Set<UUID> newbornDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(deliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord()).getId()).get();
			deliveryMedicalExaminationRecordEntity.unsetMedicalExaminationRecord();
			deliveryMedicalExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity.getMidwife(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Midwife relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			midwifeEntity = staffRepository.findById(staffRepository.save(deliveryMedicalExaminationRecordEntity.getMidwife()).getId()).get();
			deliveryMedicalExaminationRecordEntity.unsetMidwife();
			deliveryMedicalExaminationRecordEntity.setMidwifeId(midwifeEntity.getId());

			additionalMidwivesEntities = new HashSet<>();
			additionalMidwivesEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : deliveryMedicalExaminationRecordEntity.getAdditionalMidwives()) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Additional Midwives relation for this test: " + e.getCause());
					return;
				}
				UUID id = coTreatingDoctorRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				additionalMidwivesEntities.add(coTreatingDoctorRepository.findById(id).get());
				additionalMidwivesEntityIds.add(id);
			}
			deliveryMedicalExaminationRecordEntity.unsetAdditionalMidwives();
			deliveryMedicalExaminationRecordEntity.setAdditionalMidwivesIds(additionalMidwivesEntityIds);

			deliveryProgressesEntities = new HashSet<>();
			deliveryProgressesEntityIds = new HashSet<>();
			for (DeliveryProgressEntity entity : deliveryMedicalExaminationRecordEntity.getDeliveryProgresses()) {
				try {
					deliveryProgressDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Delivery Progresses relation for this test: " + e.getCause());
					return;
				}
				UUID id = deliveryProgressRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				deliveryProgressesEntities.add(deliveryProgressRepository.findById(id).get());
				deliveryProgressesEntityIds.add(id);
			}
			deliveryMedicalExaminationRecordEntity.unsetDeliveryProgresses();
			deliveryMedicalExaminationRecordEntity.setDeliveryProgressesIds(deliveryProgressesEntityIds);

			newbornDetailsEntities = new HashSet<>();
			newbornDetailsEntityIds = new HashSet<>();
			for (NewbornDetailEntity entity : deliveryMedicalExaminationRecordEntity.getNewbornDetails()) {
				try {
					newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Newborn Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = newbornDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				newbornDetailsEntities.add(newbornDetailRepository.findById(id).get());
				newbornDetailsEntityIds.add(id);
			}
			deliveryMedicalExaminationRecordEntity.unsetNewbornDetails();
			deliveryMedicalExaminationRecordEntity.setNewbornDetailsIds(newbornDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.updateOldData(deliveryMedicalExaminationRecordEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetDeliveryMedicalExaminationRecord(false);
			updatedDeliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord().unsetDeliveryMedicalExaminationRecord(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedDeliveryMedicalExaminationRecordEntity.getMedicalExaminationRecord());

			midwifeEntity.unsetMidwives(false);
			updatedDeliveryMedicalExaminationRecordEntity.getMidwife().unsetMidwives(false);
			Assertions.assertEquals(midwifeEntity, updatedDeliveryMedicalExaminationRecordEntity.getMidwife());

			Assertions.assertEquals(additionalMidwivesEntities.size(), updatedDeliveryMedicalExaminationRecordEntity.getAdditionalMidwives().size());

			Assertions.assertEquals(deliveryProgressesEntities.size(), updatedDeliveryMedicalExaminationRecordEntity.getDeliveryProgresses().size());

			Assertions.assertEquals(newbornDetailsEntities.size(), updatedDeliveryMedicalExaminationRecordEntity.getNewbornDetails().size());

		});
	}

	@Test
	public void whenCreateDeliveryMedicalExaminationRecordEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;
			Optional<DeliveryMedicalExaminationRecordEntity> fetchedDeliveryMedicalExaminationRecordEntity;

			try {
				deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.create(deliveryMedicalExaminationRecordEntity);

			fetchedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.findById(deliveryMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedDeliveryMedicalExaminationRecordEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDeliveryMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(deliveryMedicalExaminationRecordEntity, fetchedDeliveryMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenUpdateDeliveryMedicalExaminationRecordEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;
			DeliveryMedicalExaminationRecordEntity updatedDeliveryMedicalExaminationRecordEntity;
			Optional<DeliveryMedicalExaminationRecordEntity> fetchedDeliveryMedicalExaminationRecordEntity;

			try {
				deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity, true, true, false);
				updatedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDeliveryMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.create(deliveryMedicalExaminationRecordEntity);

			updatedDeliveryMedicalExaminationRecordEntity.setId(deliveryMedicalExaminationRecordEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDeliveryMedicalExaminationRecordEntity.setCreated(deliveryMedicalExaminationRecordEntity.getCreated());

			updatedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.update(updatedDeliveryMedicalExaminationRecordEntity);

			fetchedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.findById(deliveryMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedDeliveryMedicalExaminationRecordEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDeliveryMedicalExaminationRecordEntity_ThenEntityIsCreated
			fetchedDeliveryMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDeliveryMedicalExaminationRecordEntity, fetchedDeliveryMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenDeleteDeliveryMedicalExaminationRecordEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;
			Optional<DeliveryMedicalExaminationRecordEntity> fetchedDeliveryMedicalExaminationRecordEntity;

			try {
				deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.create(deliveryMedicalExaminationRecordEntity);

			deliveryMedicalExaminationRecordService.deleteById(deliveryMedicalExaminationRecordEntity.getId());
			fetchedDeliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordService.findById(deliveryMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedDeliveryMedicalExaminationRecordEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
