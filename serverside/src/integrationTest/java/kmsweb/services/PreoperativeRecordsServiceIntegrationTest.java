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
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.utils.PreoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.PreoperativeRecordsDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.utils.CoTreatingDoctorFactory;
import kmsweb.utils.DatabasePopulators.CoTreatingDoctorDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.utils.OperatingTheaterMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.OperatingTheaterMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;
import kmsweb.utils.RoomFacilityFactory;
import kmsweb.utils.DatabasePopulators.RoomFacilityDatabasePopulator;
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
public class PreoperativeRecordsServiceIntegrationTest {

	@Autowired
	private PreoperativeRecordsRepository preoperativeRecordsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PreoperativeRecordsService preoperativeRecordsService;

	private final PreoperativeRecordsFactory preoperativeRecordsFactory = new PreoperativeRecordsFactory();

	@Autowired
	private PreoperativeRecordsDatabasePopulator preoperativeRecordsDatabasePopulator;

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private CoTreatingDoctorRepository coTreatingDoctorRepository;

	@Autowired
	private CoTreatingDoctorDatabasePopulator coTreatingDoctorDatabasePopulator;

	private final CoTreatingDoctorFactory coTreatingDoctorFactory = new CoTreatingDoctorFactory();

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	@Autowired
	private OperatingTheaterMedicalExaminationRecordDatabasePopulator operatingTheaterMedicalExaminationRecordDatabasePopulator;

	private final OperatingTheaterMedicalExaminationRecordFactory operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();

	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Autowired
	private RoomFacilityDatabasePopulator roomFacilityDatabasePopulator;

	private final RoomFacilityFactory roomFacilityFactory = new RoomFacilityFactory();

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
		preoperativeRecordsService = new PreoperativeRecordsService(
			bedFacilityRepository,
			coTreatingDoctorRepository,
			diagnosesAndProceduresRepository,
			operatingTheaterMedicalExaminationRecordRepository,
			roomFacilityRepository,
			staffRepository,
			validator,
			auditRepository,
			preoperativeRecordsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPreoperativeRecordsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PreoperativeRecordsEntity preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);

		PreoperativeRecordsEntity updatedEntity = preoperativeRecordsService.updateOldData(preoperativeRecordsEntity);
		Assertions.assertEquals(preoperativeRecordsEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPreoperativeRecordsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PreoperativeRecordsEntity preoperativeRecordsEntity;
			PreoperativeRecordsEntity entityWithUpdatedValues;

			try {
				preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = preoperativeRecordsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			preoperativeRecordsEntity = preoperativeRecordsService.create(preoperativeRecordsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(preoperativeRecordsEntity.getId());

			PreoperativeRecordsEntity updatedEntity = preoperativeRecordsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPreoperativeRecordsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PreoperativeRecordsEntity preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);
		preoperativeRecordsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			preoperativeRecordsService.updateOldData(preoperativeRecordsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPreoperativeRecordsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PreoperativeRecordsEntity preoperativeRecordsEntity;
			PreoperativeRecordsEntity updatedPreoperativeRecordsEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			StaffEntity anesthesiaMedicalTranscriberEntity;

			StaffEntity anesthesiologistEntity;

			StaffEntity anesthesiologyNurseEntity;

			DiagnosesAndProceduresEntity preSurgeryICD10Entity;

			DiagnosesAndProceduresEntity preSurgeryICD9CMEntity;

			RoomFacilityEntity preoperativeRoomsEntity;

			StaffEntity surgeonEntity;

			StaffEntity surgicalMedicalTranscriberEntity;

			StaffEntity surgicalNurseEntity;

			Set<CoTreatingDoctorEntity> additionalAnesthesiologistsEntities;

			Set<CoTreatingDoctorEntity> additionalSurgeryNursesEntities;

			Set<BedFacilityEntity> bedFacilitiesEntities;

			Set<CoTreatingDoctorEntity> coTreatingAnesthesiologistsEntities;

			Set<CoTreatingDoctorEntity> coTreatingSurgeonsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(true, false);
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
			operatingTheaterMedicalExaminationRecordEntity = preoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord();
			try {
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.save(operatingTheaterMedicalExaminationRecordEntity);
			preoperativeRecordsEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			anesthesiaMedicalTranscriberEntity = preoperativeRecordsEntity.getAnesthesiaMedicalTranscriber();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(anesthesiaMedicalTranscriberEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			anesthesiaMedicalTranscriberEntity = staffRepository.save(anesthesiaMedicalTranscriberEntity);
			preoperativeRecordsEntity.setAnesthesiaMedicalTranscriberId(anesthesiaMedicalTranscriberEntity.getId());

			anesthesiologistEntity = preoperativeRecordsEntity.getAnesthesiologist();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(anesthesiologistEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			anesthesiologistEntity = staffRepository.save(anesthesiologistEntity);
			preoperativeRecordsEntity.setAnesthesiologistId(anesthesiologistEntity.getId());

			anesthesiologyNurseEntity = preoperativeRecordsEntity.getAnesthesiologyNurse();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(anesthesiologyNurseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			anesthesiologyNurseEntity = staffRepository.save(anesthesiologyNurseEntity);
			preoperativeRecordsEntity.setAnesthesiologyNurseId(anesthesiologyNurseEntity.getId());

			preSurgeryICD10Entity = preoperativeRecordsEntity.getPreSurgeryICD10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(preSurgeryICD10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			preSurgeryICD10Entity = diagnosesAndProceduresRepository.save(preSurgeryICD10Entity);
			preoperativeRecordsEntity.setPreSurgeryICD10Id(preSurgeryICD10Entity.getId());

			preSurgeryICD9CMEntity = preoperativeRecordsEntity.getPreSurgeryICD9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(preSurgeryICD9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			preSurgeryICD9CMEntity = diagnosesAndProceduresRepository.save(preSurgeryICD9CMEntity);
			preoperativeRecordsEntity.setPreSurgeryICD9CMId(preSurgeryICD9CMEntity.getId());

			preoperativeRoomsEntity = preoperativeRecordsEntity.getPreoperativeRooms();
			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRoomsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			preoperativeRoomsEntity = roomFacilityRepository.save(preoperativeRoomsEntity);
			preoperativeRecordsEntity.setPreoperativeRoomsId(preoperativeRoomsEntity.getId());

			surgeonEntity = preoperativeRecordsEntity.getSurgeon();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(surgeonEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			surgeonEntity = staffRepository.save(surgeonEntity);
			preoperativeRecordsEntity.setSurgeonId(surgeonEntity.getId());

			surgicalMedicalTranscriberEntity = preoperativeRecordsEntity.getSurgicalMedicalTranscriber();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(surgicalMedicalTranscriberEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			surgicalMedicalTranscriberEntity = staffRepository.save(surgicalMedicalTranscriberEntity);
			preoperativeRecordsEntity.setSurgicalMedicalTranscriberId(surgicalMedicalTranscriberEntity.getId());

			surgicalNurseEntity = preoperativeRecordsEntity.getSurgicalNurse();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(surgicalNurseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			surgicalNurseEntity = staffRepository.save(surgicalNurseEntity);
			preoperativeRecordsEntity.setSurgicalNurseId(surgicalNurseEntity.getId());

			additionalAnesthesiologistsEntities = preoperativeRecordsEntity.getAdditionalAnesthesiologists();
			Set<UUID> additionalAnesthesiologistsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : additionalAnesthesiologistsEntities) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				additionalAnesthesiologistsEntityIds.add(coTreatingDoctorRepository.save(entity).getId());
			}
			preoperativeRecordsEntity.setAdditionalAnesthesiologistsIds(additionalAnesthesiologistsEntityIds);

			additionalSurgeryNursesEntities = preoperativeRecordsEntity.getAdditionalSurgeryNurses();
			Set<UUID> additionalSurgeryNursesEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : additionalSurgeryNursesEntities) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				additionalSurgeryNursesEntityIds.add(coTreatingDoctorRepository.save(entity).getId());
			}
			preoperativeRecordsEntity.setAdditionalSurgeryNursesIds(additionalSurgeryNursesEntityIds);

			bedFacilitiesEntities = preoperativeRecordsEntity.getBedFacilities();
			Set<UUID> bedFacilitiesEntityIds = new HashSet<>();
			for (BedFacilityEntity entity : bedFacilitiesEntities) {
				try {
					bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bedFacilitiesEntityIds.add(bedFacilityRepository.save(entity).getId());
			}
			preoperativeRecordsEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);

			coTreatingAnesthesiologistsEntities = preoperativeRecordsEntity.getCoTreatingAnesthesiologists();
			Set<UUID> coTreatingAnesthesiologistsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : coTreatingAnesthesiologistsEntities) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				coTreatingAnesthesiologistsEntityIds.add(coTreatingDoctorRepository.save(entity).getId());
			}
			preoperativeRecordsEntity.setCoTreatingAnesthesiologistsIds(coTreatingAnesthesiologistsEntityIds);

			coTreatingSurgeonsEntities = preoperativeRecordsEntity.getCoTreatingSurgeons();
			Set<UUID> coTreatingSurgeonsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : coTreatingSurgeonsEntities) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				coTreatingSurgeonsEntityIds.add(coTreatingDoctorRepository.save(entity).getId());
			}
			preoperativeRecordsEntity.setCoTreatingSurgeonsIds(coTreatingSurgeonsEntityIds);


			preoperativeRecordsEntity = preoperativeRecordsService.create(preoperativeRecordsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(preoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord());
			preoperativeRecordsEntity.setOperatingTheaterMedicalExaminationRecordId(null);
			preoperativeRecordsEntity.unsetOperatingTheaterMedicalExaminationRecord();

			Assertions.assertNotNull(preoperativeRecordsEntity.getAnesthesiaMedicalTranscriber());
			preoperativeRecordsEntity.setAnesthesiaMedicalTranscriberId(null);
			preoperativeRecordsEntity.unsetAnesthesiaMedicalTranscriber();

			Assertions.assertNotNull(preoperativeRecordsEntity.getAnesthesiologist());
			preoperativeRecordsEntity.setAnesthesiologistId(null);
			preoperativeRecordsEntity.unsetAnesthesiologist();

			Assertions.assertNotNull(preoperativeRecordsEntity.getAnesthesiologyNurse());
			preoperativeRecordsEntity.setAnesthesiologyNurseId(null);
			preoperativeRecordsEntity.unsetAnesthesiologyNurse();

			Assertions.assertNotNull(preoperativeRecordsEntity.getPreSurgeryICD10());
			preoperativeRecordsEntity.setPreSurgeryICD10Id(null);
			preoperativeRecordsEntity.unsetPreSurgeryICD10();

			Assertions.assertNotNull(preoperativeRecordsEntity.getPreSurgeryICD9CM());
			preoperativeRecordsEntity.setPreSurgeryICD9CMId(null);
			preoperativeRecordsEntity.unsetPreSurgeryICD9CM();

			Assertions.assertNotNull(preoperativeRecordsEntity.getPreoperativeRooms());
			preoperativeRecordsEntity.setPreoperativeRoomsId(null);
			preoperativeRecordsEntity.unsetPreoperativeRooms();

			Assertions.assertNotNull(preoperativeRecordsEntity.getSurgeon());
			preoperativeRecordsEntity.setSurgeonId(null);
			preoperativeRecordsEntity.unsetSurgeon();

			Assertions.assertNotNull(preoperativeRecordsEntity.getSurgicalMedicalTranscriber());
			preoperativeRecordsEntity.setSurgicalMedicalTranscriberId(null);
			preoperativeRecordsEntity.unsetSurgicalMedicalTranscriber();

			Assertions.assertNotNull(preoperativeRecordsEntity.getSurgicalNurse());
			preoperativeRecordsEntity.setSurgicalNurseId(null);
			preoperativeRecordsEntity.unsetSurgicalNurse();

			Assertions.assertTrue(preoperativeRecordsEntity.getAdditionalAnesthesiologists().size() > 0);
			preoperativeRecordsEntity.setAdditionalAnesthesiologistsIds(new HashSet<UUID>());
			preoperativeRecordsEntity.unsetAdditionalAnesthesiologists();

			Assertions.assertTrue(preoperativeRecordsEntity.getAdditionalSurgeryNurses().size() > 0);
			preoperativeRecordsEntity.setAdditionalSurgeryNursesIds(new HashSet<UUID>());
			preoperativeRecordsEntity.unsetAdditionalSurgeryNurses();

			Assertions.assertTrue(preoperativeRecordsEntity.getBedFacilities().size() > 0);
			preoperativeRecordsEntity.setBedFacilitiesIds(new HashSet<UUID>());
			preoperativeRecordsEntity.unsetBedFacilities();

			Assertions.assertTrue(preoperativeRecordsEntity.getCoTreatingAnesthesiologists().size() > 0);
			preoperativeRecordsEntity.setCoTreatingAnesthesiologistsIds(new HashSet<UUID>());
			preoperativeRecordsEntity.unsetCoTreatingAnesthesiologists();

			Assertions.assertTrue(preoperativeRecordsEntity.getCoTreatingSurgeons().size() > 0);
			preoperativeRecordsEntity.setCoTreatingSurgeonsIds(new HashSet<UUID>());
			preoperativeRecordsEntity.unsetCoTreatingSurgeons();


			updatedPreoperativeRecordsEntity = preoperativeRecordsService.updateOldData(preoperativeRecordsEntity);

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getAnesthesiaMedicalTranscriber());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getAnesthesiologist());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getAnesthesiologyNurse());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getPreSurgeryICD10());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getPreSurgeryICD9CM());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getPreoperativeRooms());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getSurgeon());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getSurgicalMedicalTranscriber());

			Assertions.assertNull(updatedPreoperativeRecordsEntity.getSurgicalNurse());

			Assertions.assertEquals(0, updatedPreoperativeRecordsEntity.getAdditionalAnesthesiologists().size());

			Assertions.assertEquals(0, updatedPreoperativeRecordsEntity.getAdditionalSurgeryNurses().size());

			Assertions.assertEquals(0, updatedPreoperativeRecordsEntity.getBedFacilities().size());

			Assertions.assertEquals(0, updatedPreoperativeRecordsEntity.getCoTreatingAnesthesiologists().size());

			Assertions.assertEquals(0, updatedPreoperativeRecordsEntity.getCoTreatingSurgeons().size());

		});
	}

	@Test
	public void updateOldDataWithPreoperativeRecordsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PreoperativeRecordsEntity preoperativeRecordsEntity;
			PreoperativeRecordsEntity updatedPreoperativeRecordsEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			StaffEntity anesthesiaMedicalTranscriberEntity;

			StaffEntity anesthesiologistEntity;

			StaffEntity anesthesiologyNurseEntity;

			DiagnosesAndProceduresEntity preSurgeryICD10Entity;

			DiagnosesAndProceduresEntity preSurgeryICD9CMEntity;

			RoomFacilityEntity preoperativeRoomsEntity;

			StaffEntity surgeonEntity;

			StaffEntity surgicalMedicalTranscriberEntity;

			StaffEntity surgicalNurseEntity;

			Set<CoTreatingDoctorEntity> additionalAnesthesiologistsEntities;
			Set<UUID> additionalAnesthesiologistsEntityIds;

			Set<CoTreatingDoctorEntity> additionalSurgeryNursesEntities;
			Set<UUID> additionalSurgeryNursesEntityIds;

			Set<BedFacilityEntity> bedFacilitiesEntities;
			Set<UUID> bedFacilitiesEntityIds;

			Set<CoTreatingDoctorEntity> coTreatingAnesthesiologistsEntities;
			Set<UUID> coTreatingAnesthesiologistsEntityIds;

			Set<CoTreatingDoctorEntity> coTreatingSurgeonsEntities;
			Set<UUID> coTreatingSurgeonsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(true, false);
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
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Operating Theater Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.findById(operatingTheaterMedicalExaminationRecordRepository.save(preoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord()).getId()).get();
			preoperativeRecordsEntity.unsetOperatingTheaterMedicalExaminationRecord();
			preoperativeRecordsEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getAnesthesiaMedicalTranscriber(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Anesthesia Medical Transcriber relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			anesthesiaMedicalTranscriberEntity = staffRepository.findById(staffRepository.save(preoperativeRecordsEntity.getAnesthesiaMedicalTranscriber()).getId()).get();
			preoperativeRecordsEntity.unsetAnesthesiaMedicalTranscriber();
			preoperativeRecordsEntity.setAnesthesiaMedicalTranscriberId(anesthesiaMedicalTranscriberEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getAnesthesiologist(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Anesthesiologist relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			anesthesiologistEntity = staffRepository.findById(staffRepository.save(preoperativeRecordsEntity.getAnesthesiologist()).getId()).get();
			preoperativeRecordsEntity.unsetAnesthesiologist();
			preoperativeRecordsEntity.setAnesthesiologistId(anesthesiologistEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getAnesthesiologyNurse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Anesthesiology Nurse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			anesthesiologyNurseEntity = staffRepository.findById(staffRepository.save(preoperativeRecordsEntity.getAnesthesiologyNurse()).getId()).get();
			preoperativeRecordsEntity.unsetAnesthesiologyNurse();
			preoperativeRecordsEntity.setAnesthesiologyNurseId(anesthesiologyNurseEntity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getPreSurgeryICD10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Pre Surgery ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			preSurgeryICD10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(preoperativeRecordsEntity.getPreSurgeryICD10()).getId()).get();
			preoperativeRecordsEntity.unsetPreSurgeryICD10();
			preoperativeRecordsEntity.setPreSurgeryICD10Id(preSurgeryICD10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getPreSurgeryICD9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Pre Surgery ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			preSurgeryICD9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(preoperativeRecordsEntity.getPreSurgeryICD9CM()).getId()).get();
			preoperativeRecordsEntity.unsetPreSurgeryICD9CM();
			preoperativeRecordsEntity.setPreSurgeryICD9CMId(preSurgeryICD9CMEntity.getId());

			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getPreoperativeRooms(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Preoperative Rooms relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			preoperativeRoomsEntity = roomFacilityRepository.findById(roomFacilityRepository.save(preoperativeRecordsEntity.getPreoperativeRooms()).getId()).get();
			preoperativeRecordsEntity.unsetPreoperativeRooms();
			preoperativeRecordsEntity.setPreoperativeRoomsId(preoperativeRoomsEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getSurgeon(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Surgeon relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			surgeonEntity = staffRepository.findById(staffRepository.save(preoperativeRecordsEntity.getSurgeon()).getId()).get();
			preoperativeRecordsEntity.unsetSurgeon();
			preoperativeRecordsEntity.setSurgeonId(surgeonEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getSurgicalMedicalTranscriber(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Surgical Medical Transcriber relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			surgicalMedicalTranscriberEntity = staffRepository.findById(staffRepository.save(preoperativeRecordsEntity.getSurgicalMedicalTranscriber()).getId()).get();
			preoperativeRecordsEntity.unsetSurgicalMedicalTranscriber();
			preoperativeRecordsEntity.setSurgicalMedicalTranscriberId(surgicalMedicalTranscriberEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity.getSurgicalNurse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Surgical Nurse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			surgicalNurseEntity = staffRepository.findById(staffRepository.save(preoperativeRecordsEntity.getSurgicalNurse()).getId()).get();
			preoperativeRecordsEntity.unsetSurgicalNurse();
			preoperativeRecordsEntity.setSurgicalNurseId(surgicalNurseEntity.getId());

			additionalAnesthesiologistsEntities = new HashSet<>();
			additionalAnesthesiologistsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : preoperativeRecordsEntity.getAdditionalAnesthesiologists()) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Additional Anesthesiologists relation for this test: " + e.getCause());
					return;
				}
				UUID id = coTreatingDoctorRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				additionalAnesthesiologistsEntities.add(coTreatingDoctorRepository.findById(id).get());
				additionalAnesthesiologistsEntityIds.add(id);
			}
			preoperativeRecordsEntity.unsetAdditionalAnesthesiologists();
			preoperativeRecordsEntity.setAdditionalAnesthesiologistsIds(additionalAnesthesiologistsEntityIds);

			additionalSurgeryNursesEntities = new HashSet<>();
			additionalSurgeryNursesEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : preoperativeRecordsEntity.getAdditionalSurgeryNurses()) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Additional Surgery Nurses relation for this test: " + e.getCause());
					return;
				}
				UUID id = coTreatingDoctorRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				additionalSurgeryNursesEntities.add(coTreatingDoctorRepository.findById(id).get());
				additionalSurgeryNursesEntityIds.add(id);
			}
			preoperativeRecordsEntity.unsetAdditionalSurgeryNurses();
			preoperativeRecordsEntity.setAdditionalSurgeryNursesIds(additionalSurgeryNursesEntityIds);

			bedFacilitiesEntities = new HashSet<>();
			bedFacilitiesEntityIds = new HashSet<>();
			for (BedFacilityEntity entity : preoperativeRecordsEntity.getBedFacilities()) {
				try {
					bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Bed Facilities relation for this test: " + e.getCause());
					return;
				}
				UUID id = bedFacilityRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bedFacilitiesEntities.add(bedFacilityRepository.findById(id).get());
				bedFacilitiesEntityIds.add(id);
			}
			preoperativeRecordsEntity.unsetBedFacilities();
			preoperativeRecordsEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);

			coTreatingAnesthesiologistsEntities = new HashSet<>();
			coTreatingAnesthesiologistsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : preoperativeRecordsEntity.getCoTreatingAnesthesiologists()) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Co Treating Anesthesiologists relation for this test: " + e.getCause());
					return;
				}
				UUID id = coTreatingDoctorRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				coTreatingAnesthesiologistsEntities.add(coTreatingDoctorRepository.findById(id).get());
				coTreatingAnesthesiologistsEntityIds.add(id);
			}
			preoperativeRecordsEntity.unsetCoTreatingAnesthesiologists();
			preoperativeRecordsEntity.setCoTreatingAnesthesiologistsIds(coTreatingAnesthesiologistsEntityIds);

			coTreatingSurgeonsEntities = new HashSet<>();
			coTreatingSurgeonsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : preoperativeRecordsEntity.getCoTreatingSurgeons()) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Co Treating Surgeons relation for this test: " + e.getCause());
					return;
				}
				UUID id = coTreatingDoctorRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				coTreatingSurgeonsEntities.add(coTreatingDoctorRepository.findById(id).get());
				coTreatingSurgeonsEntityIds.add(id);
			}
			preoperativeRecordsEntity.unsetCoTreatingSurgeons();
			preoperativeRecordsEntity.setCoTreatingSurgeonsIds(coTreatingSurgeonsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPreoperativeRecordsEntity = preoperativeRecordsService.updateOldData(preoperativeRecordsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			operatingTheaterMedicalExaminationRecordEntity.unsetPreoperativeRecords(false);
			updatedPreoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord().unsetPreoperativeRecords(false);
			Assertions.assertEquals(operatingTheaterMedicalExaminationRecordEntity, updatedPreoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord());

			anesthesiaMedicalTranscriberEntity.unsetAnesthesiaMedicalTranscriber(false);
			updatedPreoperativeRecordsEntity.getAnesthesiaMedicalTranscriber().unsetAnesthesiaMedicalTranscriber(false);
			Assertions.assertEquals(anesthesiaMedicalTranscriberEntity, updatedPreoperativeRecordsEntity.getAnesthesiaMedicalTranscriber());

			anesthesiologistEntity.unsetAnesthesiologist(false);
			updatedPreoperativeRecordsEntity.getAnesthesiologist().unsetAnesthesiologist(false);
			Assertions.assertEquals(anesthesiologistEntity, updatedPreoperativeRecordsEntity.getAnesthesiologist());

			anesthesiologyNurseEntity.unsetAnesthesiologyNurse(false);
			updatedPreoperativeRecordsEntity.getAnesthesiologyNurse().unsetAnesthesiologyNurse(false);
			Assertions.assertEquals(anesthesiologyNurseEntity, updatedPreoperativeRecordsEntity.getAnesthesiologyNurse());

			preSurgeryICD10Entity.unsetPreSurgeryICD10(false);
			updatedPreoperativeRecordsEntity.getPreSurgeryICD10().unsetPreSurgeryICD10(false);
			Assertions.assertEquals(preSurgeryICD10Entity, updatedPreoperativeRecordsEntity.getPreSurgeryICD10());

			preSurgeryICD9CMEntity.unsetPreSurgeryICD9CM(false);
			updatedPreoperativeRecordsEntity.getPreSurgeryICD9CM().unsetPreSurgeryICD9CM(false);
			Assertions.assertEquals(preSurgeryICD9CMEntity, updatedPreoperativeRecordsEntity.getPreSurgeryICD9CM());

			preoperativeRoomsEntity.unsetPreoperativeRooms(false);
			updatedPreoperativeRecordsEntity.getPreoperativeRooms().unsetPreoperativeRooms(false);
			Assertions.assertEquals(preoperativeRoomsEntity, updatedPreoperativeRecordsEntity.getPreoperativeRooms());

			surgeonEntity.unsetSurgeon(false);
			updatedPreoperativeRecordsEntity.getSurgeon().unsetSurgeon(false);
			Assertions.assertEquals(surgeonEntity, updatedPreoperativeRecordsEntity.getSurgeon());

			surgicalMedicalTranscriberEntity.unsetSurgicalMedicalTranscriber(false);
			updatedPreoperativeRecordsEntity.getSurgicalMedicalTranscriber().unsetSurgicalMedicalTranscriber(false);
			Assertions.assertEquals(surgicalMedicalTranscriberEntity, updatedPreoperativeRecordsEntity.getSurgicalMedicalTranscriber());

			surgicalNurseEntity.unsetSurgicalNurse(false);
			updatedPreoperativeRecordsEntity.getSurgicalNurse().unsetSurgicalNurse(false);
			Assertions.assertEquals(surgicalNurseEntity, updatedPreoperativeRecordsEntity.getSurgicalNurse());

			Assertions.assertEquals(additionalAnesthesiologistsEntities.size(), updatedPreoperativeRecordsEntity.getAdditionalAnesthesiologists().size());

			Assertions.assertEquals(additionalSurgeryNursesEntities.size(), updatedPreoperativeRecordsEntity.getAdditionalSurgeryNurses().size());

			Assertions.assertEquals(bedFacilitiesEntities.size(), updatedPreoperativeRecordsEntity.getBedFacilities().size());

			Assertions.assertEquals(coTreatingAnesthesiologistsEntities.size(), updatedPreoperativeRecordsEntity.getCoTreatingAnesthesiologists().size());

			Assertions.assertEquals(coTreatingSurgeonsEntities.size(), updatedPreoperativeRecordsEntity.getCoTreatingSurgeons().size());

		});
	}

	@Test
	public void whenCreatePreoperativeRecordsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PreoperativeRecordsEntity preoperativeRecordsEntity;
			Optional<PreoperativeRecordsEntity> fetchedPreoperativeRecordsEntity;

			try {
				preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			preoperativeRecordsEntity = preoperativeRecordsService.create(preoperativeRecordsEntity);

			fetchedPreoperativeRecordsEntity = preoperativeRecordsService.findById(preoperativeRecordsEntity.getId());

			Assertions.assertTrue(fetchedPreoperativeRecordsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPreoperativeRecordsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(preoperativeRecordsEntity, fetchedPreoperativeRecordsEntity.get());
		});
	}

	@Test
	public void whenUpdatePreoperativeRecordsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PreoperativeRecordsEntity preoperativeRecordsEntity;
			PreoperativeRecordsEntity updatedPreoperativeRecordsEntity;
			Optional<PreoperativeRecordsEntity> fetchedPreoperativeRecordsEntity;

			try {
				preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity, true, true, false);
				updatedPreoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPreoperativeRecordsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			preoperativeRecordsEntity = preoperativeRecordsService.create(preoperativeRecordsEntity);

			updatedPreoperativeRecordsEntity.setId(preoperativeRecordsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPreoperativeRecordsEntity.setCreated(preoperativeRecordsEntity.getCreated());

			updatedPreoperativeRecordsEntity = preoperativeRecordsService.update(updatedPreoperativeRecordsEntity);

			fetchedPreoperativeRecordsEntity = preoperativeRecordsService.findById(preoperativeRecordsEntity.getId());

			Assertions.assertTrue(fetchedPreoperativeRecordsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePreoperativeRecordsEntity_ThenEntityIsCreated
			fetchedPreoperativeRecordsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPreoperativeRecordsEntity, fetchedPreoperativeRecordsEntity.get());
		});
	}

	@Test
	public void whenDeletePreoperativeRecordsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PreoperativeRecordsEntity preoperativeRecordsEntity;
			Optional<PreoperativeRecordsEntity> fetchedPreoperativeRecordsEntity;

			try {
				preoperativeRecordsEntity = preoperativeRecordsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			preoperativeRecordsEntity = preoperativeRecordsService.create(preoperativeRecordsEntity);

			preoperativeRecordsService.deleteById(preoperativeRecordsEntity.getId());
			fetchedPreoperativeRecordsEntity = preoperativeRecordsService.findById(preoperativeRecordsEntity.getId());

			Assertions.assertTrue(fetchedPreoperativeRecordsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
