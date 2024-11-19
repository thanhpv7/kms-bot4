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
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.BedReserveEntity;
import kmsweb.repositories.BedReserveRepository;
import kmsweb.utils.BedReserveFactory;
import kmsweb.utils.DatabasePopulators.BedReserveDatabasePopulator;
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import kmsweb.repositories.InpatientMedicalExaminationRecordRepository;
import kmsweb.utils.InpatientMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.InpatientMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.utils.IntraoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.IntraoperativeRecordsDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.utils.PostOperativeDetailsFactory;
import kmsweb.utils.DatabasePopulators.PostOperativeDetailsDatabasePopulator;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.utils.PreoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.PreoperativeRecordsDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;
import kmsweb.utils.RoomFacilityFactory;
import kmsweb.utils.DatabasePopulators.RoomFacilityDatabasePopulator;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.repositories.RoomTransferRepository;
import kmsweb.utils.RoomTransferFactory;
import kmsweb.utils.DatabasePopulators.RoomTransferDatabasePopulator;
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
public class BedFacilityServiceIntegrationTest {

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BedFacilityService bedFacilityService;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	@Autowired
	private BedReserveRepository bedReserveRepository;

	@Autowired
	private BedReserveDatabasePopulator bedReserveDatabasePopulator;

	private final BedReserveFactory bedReserveFactory = new BedReserveFactory();

	@Autowired
	private InpatientMedicalExaminationRecordRepository inpatientMedicalExaminationRecordRepository;

	@Autowired
	private InpatientMedicalExaminationRecordDatabasePopulator inpatientMedicalExaminationRecordDatabasePopulator;

	private final InpatientMedicalExaminationRecordFactory inpatientMedicalExaminationRecordFactory = new InpatientMedicalExaminationRecordFactory();

	@Autowired
	private IntraoperativeRecordsRepository intraoperativeRecordsRepository;

	@Autowired
	private IntraoperativeRecordsDatabasePopulator intraoperativeRecordsDatabasePopulator;

	private final IntraoperativeRecordsFactory intraoperativeRecordsFactory = new IntraoperativeRecordsFactory();

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private PostOperativeDetailsRepository postOperativeDetailsRepository;

	@Autowired
	private PostOperativeDetailsDatabasePopulator postOperativeDetailsDatabasePopulator;

	private final PostOperativeDetailsFactory postOperativeDetailsFactory = new PostOperativeDetailsFactory();

	@Autowired
	private PreoperativeRecordsRepository preoperativeRecordsRepository;

	@Autowired
	private PreoperativeRecordsDatabasePopulator preoperativeRecordsDatabasePopulator;

	private final PreoperativeRecordsFactory preoperativeRecordsFactory = new PreoperativeRecordsFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Autowired
	private RoomFacilityDatabasePopulator roomFacilityDatabasePopulator;

	private final RoomFacilityFactory roomFacilityFactory = new RoomFacilityFactory();

	@Autowired
	private RoomTransferRepository roomTransferRepository;

	@Autowired
	private RoomTransferDatabasePopulator roomTransferDatabasePopulator;

	private final RoomTransferFactory roomTransferFactory = new RoomTransferFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bedFacilityService = new BedFacilityService(
			bedReserveRepository,
			inpatientMedicalExaminationRecordRepository,
			intraoperativeRecordsRepository,
			invoiceRepository,
			postOperativeDetailsRepository,
			preoperativeRecordsRepository,
			registrationRepository,
			roomFacilityRepository,
			roomTransferRepository,
			validator,
			auditRepository,
			bedFacilityRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBedFacilityEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BedFacilityEntity bedFacilityEntity = bedFacilityFactory.getObject(false, false);

		BedFacilityEntity updatedEntity = bedFacilityService.updateOldData(bedFacilityEntity);
		Assertions.assertEquals(bedFacilityEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBedFacilityEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BedFacilityEntity bedFacilityEntity;
			BedFacilityEntity entityWithUpdatedValues;

			try {
				bedFacilityEntity = bedFacilityFactory.getObject(false, false);
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bedFacilityFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bedFacilityEntity = bedFacilityService.create(bedFacilityEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bedFacilityEntity.getId());

			BedFacilityEntity updatedEntity = bedFacilityService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBedFacilityEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BedFacilityEntity bedFacilityEntity = bedFacilityFactory.getObject(false, false);
		bedFacilityEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bedFacilityService.updateOldData(bedFacilityEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBedFacilityEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BedFacilityEntity bedFacilityEntity;
			BedFacilityEntity updatedBedFacilityEntity;

			IntraoperativeRecordsEntity intraoperativeRecordsEntity;

			PostOperativeDetailsEntity postOperativeDetailsEntity;

			PreoperativeRecordsEntity preoperativeRecordsEntity;

			RoomFacilityEntity roomFacilityEntity;

			Set<BedReserveEntity> bedReservesEntities;

			Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecordsEntities;

			Set<InvoiceEntity> invoicesEntities;

			Set<RegistrationEntity> registrationsEntities;

			Set<RoomTransferEntity> roomTransfersEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bedFacilityEntity = bedFacilityFactory.getObject(true, false);
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
			intraoperativeRecordsEntity = bedFacilityEntity.getIntraoperativeRecords();
			try {
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			intraoperativeRecordsEntity = intraoperativeRecordsRepository.save(intraoperativeRecordsEntity);
			bedFacilityEntity.setIntraoperativeRecordsId(intraoperativeRecordsEntity.getId());

			postOperativeDetailsEntity = bedFacilityEntity.getPostOperativeDetails();
			try {
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			postOperativeDetailsEntity = postOperativeDetailsRepository.save(postOperativeDetailsEntity);
			bedFacilityEntity.setPostOperativeDetailsId(postOperativeDetailsEntity.getId());

			preoperativeRecordsEntity = bedFacilityEntity.getPreoperativeRecords();
			try {
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			preoperativeRecordsEntity = preoperativeRecordsRepository.save(preoperativeRecordsEntity);
			bedFacilityEntity.setPreoperativeRecordsId(preoperativeRecordsEntity.getId());

			roomFacilityEntity = bedFacilityEntity.getRoomFacility();
			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(roomFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			roomFacilityEntity = roomFacilityRepository.save(roomFacilityEntity);
			bedFacilityEntity.setRoomFacilityId(roomFacilityEntity.getId());

			bedReservesEntities = bedFacilityEntity.getBedReserves();
			Set<UUID> bedReservesEntityIds = new HashSet<>();
			for (BedReserveEntity entity : bedReservesEntities) {
				try {
					bedReserveDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bedReservesEntityIds.add(bedReserveRepository.save(entity).getId());
			}
			bedFacilityEntity.setBedReservesIds(bedReservesEntityIds);

			inpatientMedicalExaminationRecordsEntities = bedFacilityEntity.getInpatientMedicalExaminationRecords();
			Set<UUID> inpatientMedicalExaminationRecordsEntityIds = new HashSet<>();
			for (InpatientMedicalExaminationRecordEntity entity : inpatientMedicalExaminationRecordsEntities) {
				try {
					inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inpatientMedicalExaminationRecordsEntityIds.add(inpatientMedicalExaminationRecordRepository.save(entity).getId());
			}
			bedFacilityEntity.setInpatientMedicalExaminationRecordsIds(inpatientMedicalExaminationRecordsEntityIds);

			invoicesEntities = bedFacilityEntity.getInvoices();
			Set<UUID> invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : invoicesEntities) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicesEntityIds.add(invoiceRepository.save(entity).getId());
			}
			bedFacilityEntity.setInvoicesIds(invoicesEntityIds);

			registrationsEntities = bedFacilityEntity.getRegistrations();
			Set<UUID> registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : registrationsEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				registrationsEntityIds.add(registrationRepository.save(entity).getId());
			}
			bedFacilityEntity.setRegistrationsIds(registrationsEntityIds);

			roomTransfersEntities = bedFacilityEntity.getRoomTransfers();
			Set<UUID> roomTransfersEntityIds = new HashSet<>();
			for (RoomTransferEntity entity : roomTransfersEntities) {
				try {
					roomTransferDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				roomTransfersEntityIds.add(roomTransferRepository.save(entity).getId());
			}
			bedFacilityEntity.setRoomTransfersIds(roomTransfersEntityIds);


			bedFacilityEntity = bedFacilityService.create(bedFacilityEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bedFacilityEntity.getIntraoperativeRecords());
			bedFacilityEntity.setIntraoperativeRecordsId(null);
			bedFacilityEntity.unsetIntraoperativeRecords();

			Assertions.assertNotNull(bedFacilityEntity.getPostOperativeDetails());
			bedFacilityEntity.setPostOperativeDetailsId(null);
			bedFacilityEntity.unsetPostOperativeDetails();

			Assertions.assertNotNull(bedFacilityEntity.getPreoperativeRecords());
			bedFacilityEntity.setPreoperativeRecordsId(null);
			bedFacilityEntity.unsetPreoperativeRecords();

			Assertions.assertNotNull(bedFacilityEntity.getRoomFacility());
			bedFacilityEntity.setRoomFacilityId(null);
			bedFacilityEntity.unsetRoomFacility();

			Assertions.assertTrue(bedFacilityEntity.getBedReserves().size() > 0);
			bedFacilityEntity.setBedReservesIds(new HashSet<UUID>());
			bedFacilityEntity.unsetBedReserves();

			Assertions.assertTrue(bedFacilityEntity.getInpatientMedicalExaminationRecords().size() > 0);
			bedFacilityEntity.setInpatientMedicalExaminationRecordsIds(new HashSet<UUID>());
			bedFacilityEntity.unsetInpatientMedicalExaminationRecords();

			Assertions.assertTrue(bedFacilityEntity.getInvoices().size() > 0);
			bedFacilityEntity.setInvoicesIds(new HashSet<UUID>());
			bedFacilityEntity.unsetInvoices();

			Assertions.assertTrue(bedFacilityEntity.getRegistrations().size() > 0);
			bedFacilityEntity.setRegistrationsIds(new HashSet<UUID>());
			bedFacilityEntity.unsetRegistrations();

			Assertions.assertTrue(bedFacilityEntity.getRoomTransfers().size() > 0);
			bedFacilityEntity.setRoomTransfersIds(new HashSet<UUID>());
			bedFacilityEntity.unsetRoomTransfers();


			updatedBedFacilityEntity = bedFacilityService.updateOldData(bedFacilityEntity);

			Assertions.assertNull(updatedBedFacilityEntity.getIntraoperativeRecords());

			Assertions.assertNull(updatedBedFacilityEntity.getPostOperativeDetails());

			Assertions.assertNull(updatedBedFacilityEntity.getPreoperativeRecords());

			Assertions.assertNull(updatedBedFacilityEntity.getRoomFacility());

			Assertions.assertEquals(0, updatedBedFacilityEntity.getBedReserves().size());

			Assertions.assertEquals(0, updatedBedFacilityEntity.getInpatientMedicalExaminationRecords().size());

			Assertions.assertEquals(0, updatedBedFacilityEntity.getInvoices().size());

			Assertions.assertEquals(0, updatedBedFacilityEntity.getRegistrations().size());

			Assertions.assertEquals(0, updatedBedFacilityEntity.getRoomTransfers().size());

		});
	}

	@Test
	public void updateOldDataWithBedFacilityEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BedFacilityEntity bedFacilityEntity;
			BedFacilityEntity updatedBedFacilityEntity;

			IntraoperativeRecordsEntity intraoperativeRecordsEntity;

			PostOperativeDetailsEntity postOperativeDetailsEntity;

			PreoperativeRecordsEntity preoperativeRecordsEntity;

			RoomFacilityEntity roomFacilityEntity;

			Set<BedReserveEntity> bedReservesEntities;
			Set<UUID> bedReservesEntityIds;

			Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecordsEntities;
			Set<UUID> inpatientMedicalExaminationRecordsEntityIds;

			Set<InvoiceEntity> invoicesEntities;
			Set<UUID> invoicesEntityIds;

			Set<RegistrationEntity> registrationsEntities;
			Set<UUID> registrationsEntityIds;

			Set<RoomTransferEntity> roomTransfersEntities;
			Set<UUID> roomTransfersEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bedFacilityEntity = bedFacilityFactory.getObject(true, false);
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
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity.getIntraoperativeRecords(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Intraoperative Records relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			intraoperativeRecordsEntity = intraoperativeRecordsRepository.findById(intraoperativeRecordsRepository.save(bedFacilityEntity.getIntraoperativeRecords()).getId()).get();
			bedFacilityEntity.unsetIntraoperativeRecords();
			bedFacilityEntity.setIntraoperativeRecordsId(intraoperativeRecordsEntity.getId());

			try {
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity.getPostOperativeDetails(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Post Operative Details relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			postOperativeDetailsEntity = postOperativeDetailsRepository.findById(postOperativeDetailsRepository.save(bedFacilityEntity.getPostOperativeDetails()).getId()).get();
			bedFacilityEntity.unsetPostOperativeDetails();
			bedFacilityEntity.setPostOperativeDetailsId(postOperativeDetailsEntity.getId());

			try {
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity.getPreoperativeRecords(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Preoperative Records relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			preoperativeRecordsEntity = preoperativeRecordsRepository.findById(preoperativeRecordsRepository.save(bedFacilityEntity.getPreoperativeRecords()).getId()).get();
			bedFacilityEntity.unsetPreoperativeRecords();
			bedFacilityEntity.setPreoperativeRecordsId(preoperativeRecordsEntity.getId());

			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity.getRoomFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Room Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			roomFacilityEntity = roomFacilityRepository.findById(roomFacilityRepository.save(bedFacilityEntity.getRoomFacility()).getId()).get();
			bedFacilityEntity.unsetRoomFacility();
			bedFacilityEntity.setRoomFacilityId(roomFacilityEntity.getId());

			bedReservesEntities = new HashSet<>();
			bedReservesEntityIds = new HashSet<>();
			for (BedReserveEntity entity : bedFacilityEntity.getBedReserves()) {
				try {
					bedReserveDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Bed Reserves relation for this test: " + e.getCause());
					return;
				}
				UUID id = bedReserveRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bedReservesEntities.add(bedReserveRepository.findById(id).get());
				bedReservesEntityIds.add(id);
			}
			bedFacilityEntity.unsetBedReserves();
			bedFacilityEntity.setBedReservesIds(bedReservesEntityIds);

			inpatientMedicalExaminationRecordsEntities = new HashSet<>();
			inpatientMedicalExaminationRecordsEntityIds = new HashSet<>();
			for (InpatientMedicalExaminationRecordEntity entity : bedFacilityEntity.getInpatientMedicalExaminationRecords()) {
				try {
					inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inpatient Medical Examination Records relation for this test: " + e.getCause());
					return;
				}
				UUID id = inpatientMedicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inpatientMedicalExaminationRecordsEntities.add(inpatientMedicalExaminationRecordRepository.findById(id).get());
				inpatientMedicalExaminationRecordsEntityIds.add(id);
			}
			bedFacilityEntity.unsetInpatientMedicalExaminationRecords();
			bedFacilityEntity.setInpatientMedicalExaminationRecordsIds(inpatientMedicalExaminationRecordsEntityIds);

			invoicesEntities = new HashSet<>();
			invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : bedFacilityEntity.getInvoices()) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoices relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicesEntities.add(invoiceRepository.findById(id).get());
				invoicesEntityIds.add(id);
			}
			bedFacilityEntity.unsetInvoices();
			bedFacilityEntity.setInvoicesIds(invoicesEntityIds);

			registrationsEntities = new HashSet<>();
			registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : bedFacilityEntity.getRegistrations()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Registrations relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				registrationsEntities.add(registrationRepository.findById(id).get());
				registrationsEntityIds.add(id);
			}
			bedFacilityEntity.unsetRegistrations();
			bedFacilityEntity.setRegistrationsIds(registrationsEntityIds);

			roomTransfersEntities = new HashSet<>();
			roomTransfersEntityIds = new HashSet<>();
			for (RoomTransferEntity entity : bedFacilityEntity.getRoomTransfers()) {
				try {
					roomTransferDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Room Transfers relation for this test: " + e.getCause());
					return;
				}
				UUID id = roomTransferRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				roomTransfersEntities.add(roomTransferRepository.findById(id).get());
				roomTransfersEntityIds.add(id);
			}
			bedFacilityEntity.unsetRoomTransfers();
			bedFacilityEntity.setRoomTransfersIds(roomTransfersEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBedFacilityEntity = bedFacilityService.updateOldData(bedFacilityEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			intraoperativeRecordsEntity.unsetBedFacilities(false);
			updatedBedFacilityEntity.getIntraoperativeRecords().unsetBedFacilities(false);
			Assertions.assertEquals(intraoperativeRecordsEntity, updatedBedFacilityEntity.getIntraoperativeRecords());

			postOperativeDetailsEntity.unsetBedFacilities(false);
			updatedBedFacilityEntity.getPostOperativeDetails().unsetBedFacilities(false);
			Assertions.assertEquals(postOperativeDetailsEntity, updatedBedFacilityEntity.getPostOperativeDetails());

			preoperativeRecordsEntity.unsetBedFacilities(false);
			updatedBedFacilityEntity.getPreoperativeRecords().unsetBedFacilities(false);
			Assertions.assertEquals(preoperativeRecordsEntity, updatedBedFacilityEntity.getPreoperativeRecords());

			roomFacilityEntity.unsetBedFacilities(false);
			updatedBedFacilityEntity.getRoomFacility().unsetBedFacilities(false);
			Assertions.assertEquals(roomFacilityEntity, updatedBedFacilityEntity.getRoomFacility());

			Assertions.assertEquals(bedReservesEntities.size(), updatedBedFacilityEntity.getBedReserves().size());

			Assertions.assertEquals(inpatientMedicalExaminationRecordsEntities.size(), updatedBedFacilityEntity.getInpatientMedicalExaminationRecords().size());

			Assertions.assertEquals(invoicesEntities.size(), updatedBedFacilityEntity.getInvoices().size());

			Assertions.assertEquals(registrationsEntities.size(), updatedBedFacilityEntity.getRegistrations().size());

			Assertions.assertEquals(roomTransfersEntities.size(), updatedBedFacilityEntity.getRoomTransfers().size());

		});
	}

	@Test
	public void whenCreateBedFacilityEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BedFacilityEntity bedFacilityEntity;
			Optional<BedFacilityEntity> fetchedBedFacilityEntity;

			try {
				bedFacilityEntity = bedFacilityFactory.getObject(false, false);
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bedFacilityEntity = bedFacilityService.create(bedFacilityEntity);

			fetchedBedFacilityEntity = bedFacilityService.findById(bedFacilityEntity.getId());

			Assertions.assertTrue(fetchedBedFacilityEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBedFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bedFacilityEntity, fetchedBedFacilityEntity.get());
		});
	}

	@Test
	public void whenUpdateBedFacilityEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BedFacilityEntity bedFacilityEntity;
			BedFacilityEntity updatedBedFacilityEntity;
			Optional<BedFacilityEntity> fetchedBedFacilityEntity;

			try {
				bedFacilityEntity = bedFacilityFactory.getObject(false, false);
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, false);
				updatedBedFacilityEntity = bedFacilityFactory.getObject(false, false);
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBedFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bedFacilityEntity = bedFacilityService.create(bedFacilityEntity);

			updatedBedFacilityEntity.setId(bedFacilityEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBedFacilityEntity.setCreated(bedFacilityEntity.getCreated());

			updatedBedFacilityEntity = bedFacilityService.update(updatedBedFacilityEntity);

			fetchedBedFacilityEntity = bedFacilityService.findById(bedFacilityEntity.getId());

			Assertions.assertTrue(fetchedBedFacilityEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBedFacilityEntity_ThenEntityIsCreated
			fetchedBedFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBedFacilityEntity, fetchedBedFacilityEntity.get());
		});
	}

	@Test
	public void whenDeleteBedFacilityEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BedFacilityEntity bedFacilityEntity;
			Optional<BedFacilityEntity> fetchedBedFacilityEntity;

			try {
				bedFacilityEntity = bedFacilityFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bedFacilityEntity = bedFacilityService.create(bedFacilityEntity);

			bedFacilityService.deleteById(bedFacilityEntity.getId());
			fetchedBedFacilityEntity = bedFacilityService.findById(bedFacilityEntity.getId());

			Assertions.assertTrue(fetchedBedFacilityEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
