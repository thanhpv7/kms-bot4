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
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.utils.BpjsDiagnoseFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnoseDatabasePopulator;
import kmsweb.entities.BpjsDismissalConditionEntity;
import kmsweb.repositories.BpjsDismissalConditionRepository;
import kmsweb.utils.BpjsDismissalConditionFactory;
import kmsweb.utils.DatabasePopulators.BpjsDismissalConditionDatabasePopulator;
import kmsweb.entities.BpjsDismissalMappingEntity;
import kmsweb.repositories.BpjsDismissalMappingRepository;
import kmsweb.utils.BpjsDismissalMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsDismissalMappingDatabasePopulator;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.utils.BpjsDoctorMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsDoctorMappingDatabasePopulator;
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.repositories.BpjsHealthFacilityRepository;
import kmsweb.utils.BpjsHealthFacilityFactory;
import kmsweb.utils.DatabasePopulators.BpjsHealthFacilityDatabasePopulator;
import kmsweb.entities.BpjsProcedureEntity;
import kmsweb.repositories.BpjsProcedureRepository;
import kmsweb.utils.BpjsProcedureFactory;
import kmsweb.utils.DatabasePopulators.BpjsProcedureDatabasePopulator;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.utils.BpjsServiceMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsServiceMappingDatabasePopulator;
import kmsweb.entities.BpjsTreatmentRoomEntity;
import kmsweb.repositories.BpjsTreatmentRoomRepository;
import kmsweb.utils.BpjsTreatmentRoomFactory;
import kmsweb.utils.DatabasePopulators.BpjsTreatmentRoomDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;
import kmsweb.utils.PatientPaymentBPJSFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentBPJSDatabasePopulator;
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
public class BpjsClaimSubmissionServiceIntegrationTest {

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsClaimSubmissionService bpjsClaimSubmissionService;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	@Autowired
	private BpjsDiagnoseRepository bpjsDiagnoseRepository;

	@Autowired
	private BpjsDiagnoseDatabasePopulator bpjsDiagnoseDatabasePopulator;

	private final BpjsDiagnoseFactory bpjsDiagnoseFactory = new BpjsDiagnoseFactory();

	@Autowired
	private BpjsDismissalConditionRepository bpjsDismissalConditionRepository;

	@Autowired
	private BpjsDismissalConditionDatabasePopulator bpjsDismissalConditionDatabasePopulator;

	private final BpjsDismissalConditionFactory bpjsDismissalConditionFactory = new BpjsDismissalConditionFactory();

	@Autowired
	private BpjsDismissalMappingRepository bpjsDismissalMappingRepository;

	@Autowired
	private BpjsDismissalMappingDatabasePopulator bpjsDismissalMappingDatabasePopulator;

	private final BpjsDismissalMappingFactory bpjsDismissalMappingFactory = new BpjsDismissalMappingFactory();

	@Autowired
	private BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	@Autowired
	private BpjsDoctorMappingDatabasePopulator bpjsDoctorMappingDatabasePopulator;

	private final BpjsDoctorMappingFactory bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();

	@Autowired
	private BpjsHealthFacilityRepository bpjsHealthFacilityRepository;

	@Autowired
	private BpjsHealthFacilityDatabasePopulator bpjsHealthFacilityDatabasePopulator;

	private final BpjsHealthFacilityFactory bpjsHealthFacilityFactory = new BpjsHealthFacilityFactory();

	@Autowired
	private BpjsProcedureRepository bpjsProcedureRepository;

	@Autowired
	private BpjsProcedureDatabasePopulator bpjsProcedureDatabasePopulator;

	private final BpjsProcedureFactory bpjsProcedureFactory = new BpjsProcedureFactory();

	@Autowired
	private BpjsServiceMappingRepository bpjsServiceMappingRepository;

	@Autowired
	private BpjsServiceMappingDatabasePopulator bpjsServiceMappingDatabasePopulator;

	private final BpjsServiceMappingFactory bpjsServiceMappingFactory = new BpjsServiceMappingFactory();

	@Autowired
	private BpjsTreatmentRoomRepository bpjsTreatmentRoomRepository;

	@Autowired
	private BpjsTreatmentRoomDatabasePopulator bpjsTreatmentRoomDatabasePopulator;

	private final BpjsTreatmentRoomFactory bpjsTreatmentRoomFactory = new BpjsTreatmentRoomFactory();

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();

	@Autowired
	private PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	@Autowired
	private PatientPaymentBPJSDatabasePopulator patientPaymentBPJSDatabasePopulator;

	private final PatientPaymentBPJSFactory patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsClaimSubmissionService = new BpjsClaimSubmissionService(
			bpjsDiagnoseRepository,
			bpjsDismissalConditionRepository,
			bpjsDismissalMappingRepository,
			bpjsDoctorMappingRepository,
			bpjsHealthFacilityRepository,
			bpjsProcedureRepository,
			bpjsServiceMappingRepository,
			bpjsTreatmentRoomRepository,
			patientGeneralInfoRepository,
			patientPaymentBPJSRepository,
			validator,
			auditRepository,
			bpjsClaimSubmissionRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsClaimSubmissionEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);

		BpjsClaimSubmissionEntity updatedEntity = bpjsClaimSubmissionService.updateOldData(bpjsClaimSubmissionEntity);
		Assertions.assertEquals(bpjsClaimSubmissionEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsClaimSubmissionEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity;
			BpjsClaimSubmissionEntity entityWithUpdatedValues;

			try {
				bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);
				bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsClaimSubmissionFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsClaimSubmissionEntity = bpjsClaimSubmissionService.create(bpjsClaimSubmissionEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsClaimSubmissionEntity.getId());

			BpjsClaimSubmissionEntity updatedEntity = bpjsClaimSubmissionService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsClaimSubmissionEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);
		bpjsClaimSubmissionEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsClaimSubmissionService.updateOldData(bpjsClaimSubmissionEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsClaimSubmissionEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity;
			BpjsClaimSubmissionEntity updatedBpjsClaimSubmissionEntity;

			BpjsDiagnoseEntity bpjsDiagnoseEntity;

			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;

			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;

			BpjsProcedureEntity bpjsProcedureEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			Set<BpjsDismissalConditionEntity> bpjsDismissalConditionsEntities;

			Set<BpjsDismissalMappingEntity> bpjsDismissalMappingsEntities;

			Set<BpjsTreatmentRoomEntity> bpjsTreatmentRoomsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(true, false);
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
			bpjsDiagnoseEntity = bpjsClaimSubmissionEntity.getBpjsDiagnose();
			try {
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDiagnoseEntity = bpjsDiagnoseRepository.save(bpjsDiagnoseEntity);
			bpjsClaimSubmissionEntity.setBpjsDiagnoseId(bpjsDiagnoseEntity.getId());

			bpjsDoctorMappingEntity = bpjsClaimSubmissionEntity.getBpjsDoctorMapping();
			try {
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDoctorMappingEntity = bpjsDoctorMappingRepository.save(bpjsDoctorMappingEntity);
			bpjsClaimSubmissionEntity.setBpjsDoctorMappingId(bpjsDoctorMappingEntity.getId());

			bpjsHealthFacilityEntity = bpjsClaimSubmissionEntity.getBpjsHealthFacility();
			try {
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHealthFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsHealthFacilityEntity = bpjsHealthFacilityRepository.save(bpjsHealthFacilityEntity);
			bpjsClaimSubmissionEntity.setBpjsHealthFacilityId(bpjsHealthFacilityEntity.getId());

			bpjsProcedureEntity = bpjsClaimSubmissionEntity.getBpjsProcedure();
			try {
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsProcedureEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsProcedureEntity = bpjsProcedureRepository.save(bpjsProcedureEntity);
			bpjsClaimSubmissionEntity.setBpjsProcedureId(bpjsProcedureEntity.getId());

			bpjsServiceMappingEntity = bpjsClaimSubmissionEntity.getBpjsServiceMapping();
			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.save(bpjsServiceMappingEntity);
			bpjsClaimSubmissionEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			patientGeneralInfoEntity = bpjsClaimSubmissionEntity.getPatientGeneralInfo();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientGeneralInfoEntity = patientGeneralInfoRepository.save(patientGeneralInfoEntity);
			bpjsClaimSubmissionEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			patientPaymentBPJSEntity = bpjsClaimSubmissionEntity.getPatientPaymentBPJS();
			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.save(patientPaymentBPJSEntity);
			bpjsClaimSubmissionEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			bpjsDismissalConditionsEntities = bpjsClaimSubmissionEntity.getBpjsDismissalConditions();
			Set<UUID> bpjsDismissalConditionsEntityIds = new HashSet<>();
			for (BpjsDismissalConditionEntity entity : bpjsDismissalConditionsEntities) {
				try {
					bpjsDismissalConditionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsDismissalConditionsEntityIds.add(bpjsDismissalConditionRepository.save(entity).getId());
			}
			bpjsClaimSubmissionEntity.setBpjsDismissalConditionsIds(bpjsDismissalConditionsEntityIds);

			bpjsDismissalMappingsEntities = bpjsClaimSubmissionEntity.getBpjsDismissalMappings();
			Set<UUID> bpjsDismissalMappingsEntityIds = new HashSet<>();
			for (BpjsDismissalMappingEntity entity : bpjsDismissalMappingsEntities) {
				try {
					bpjsDismissalMappingDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsDismissalMappingsEntityIds.add(bpjsDismissalMappingRepository.save(entity).getId());
			}
			bpjsClaimSubmissionEntity.setBpjsDismissalMappingsIds(bpjsDismissalMappingsEntityIds);

			bpjsTreatmentRoomsEntities = bpjsClaimSubmissionEntity.getBpjsTreatmentRooms();
			Set<UUID> bpjsTreatmentRoomsEntityIds = new HashSet<>();
			for (BpjsTreatmentRoomEntity entity : bpjsTreatmentRoomsEntities) {
				try {
					bpjsTreatmentRoomDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsTreatmentRoomsEntityIds.add(bpjsTreatmentRoomRepository.save(entity).getId());
			}
			bpjsClaimSubmissionEntity.setBpjsTreatmentRoomsIds(bpjsTreatmentRoomsEntityIds);


			bpjsClaimSubmissionEntity = bpjsClaimSubmissionService.create(bpjsClaimSubmissionEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getBpjsDiagnose());
			bpjsClaimSubmissionEntity.setBpjsDiagnoseId(null);
			bpjsClaimSubmissionEntity.unsetBpjsDiagnose();

			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getBpjsDoctorMapping());
			bpjsClaimSubmissionEntity.setBpjsDoctorMappingId(null);
			bpjsClaimSubmissionEntity.unsetBpjsDoctorMapping();

			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getBpjsHealthFacility());
			bpjsClaimSubmissionEntity.setBpjsHealthFacilityId(null);
			bpjsClaimSubmissionEntity.unsetBpjsHealthFacility();

			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getBpjsProcedure());
			bpjsClaimSubmissionEntity.setBpjsProcedureId(null);
			bpjsClaimSubmissionEntity.unsetBpjsProcedure();

			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getBpjsServiceMapping());
			bpjsClaimSubmissionEntity.setBpjsServiceMappingId(null);
			bpjsClaimSubmissionEntity.unsetBpjsServiceMapping();

			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getPatientGeneralInfo());
			bpjsClaimSubmissionEntity.setPatientGeneralInfoId(null);
			bpjsClaimSubmissionEntity.unsetPatientGeneralInfo();

			Assertions.assertNotNull(bpjsClaimSubmissionEntity.getPatientPaymentBPJS());
			bpjsClaimSubmissionEntity.setPatientPaymentBPJSId(null);
			bpjsClaimSubmissionEntity.unsetPatientPaymentBPJS();

			Assertions.assertTrue(bpjsClaimSubmissionEntity.getBpjsDismissalConditions().size() > 0);
			bpjsClaimSubmissionEntity.setBpjsDismissalConditionsIds(new HashSet<UUID>());
			bpjsClaimSubmissionEntity.unsetBpjsDismissalConditions();

			Assertions.assertTrue(bpjsClaimSubmissionEntity.getBpjsDismissalMappings().size() > 0);
			bpjsClaimSubmissionEntity.setBpjsDismissalMappingsIds(new HashSet<UUID>());
			bpjsClaimSubmissionEntity.unsetBpjsDismissalMappings();

			Assertions.assertTrue(bpjsClaimSubmissionEntity.getBpjsTreatmentRooms().size() > 0);
			bpjsClaimSubmissionEntity.setBpjsTreatmentRoomsIds(new HashSet<UUID>());
			bpjsClaimSubmissionEntity.unsetBpjsTreatmentRooms();


			updatedBpjsClaimSubmissionEntity = bpjsClaimSubmissionService.updateOldData(bpjsClaimSubmissionEntity);

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getBpjsDiagnose());

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getBpjsDoctorMapping());

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getBpjsHealthFacility());

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getBpjsProcedure());

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getBpjsServiceMapping());

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getPatientGeneralInfo());

			Assertions.assertNull(updatedBpjsClaimSubmissionEntity.getPatientPaymentBPJS());

			Assertions.assertEquals(0, updatedBpjsClaimSubmissionEntity.getBpjsDismissalConditions().size());

			Assertions.assertEquals(0, updatedBpjsClaimSubmissionEntity.getBpjsDismissalMappings().size());

			Assertions.assertEquals(0, updatedBpjsClaimSubmissionEntity.getBpjsTreatmentRooms().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsClaimSubmissionEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity;
			BpjsClaimSubmissionEntity updatedBpjsClaimSubmissionEntity;

			BpjsDiagnoseEntity bpjsDiagnoseEntity;

			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;

			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;

			BpjsProcedureEntity bpjsProcedureEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			Set<BpjsDismissalConditionEntity> bpjsDismissalConditionsEntities;
			Set<UUID> bpjsDismissalConditionsEntityIds;

			Set<BpjsDismissalMappingEntity> bpjsDismissalMappingsEntities;
			Set<UUID> bpjsDismissalMappingsEntityIds;

			Set<BpjsTreatmentRoomEntity> bpjsTreatmentRoomsEntities;
			Set<UUID> bpjsTreatmentRoomsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(true, false);
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
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getBpjsDiagnose(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Diagnose relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDiagnoseEntity = bpjsDiagnoseRepository.findById(bpjsDiagnoseRepository.save(bpjsClaimSubmissionEntity.getBpjsDiagnose()).getId()).get();
			bpjsClaimSubmissionEntity.unsetBpjsDiagnose();
			bpjsClaimSubmissionEntity.setBpjsDiagnoseId(bpjsDiagnoseEntity.getId());

			try {
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getBpjsDoctorMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Doctor Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDoctorMappingEntity = bpjsDoctorMappingRepository.findById(bpjsDoctorMappingRepository.save(bpjsClaimSubmissionEntity.getBpjsDoctorMapping()).getId()).get();
			bpjsClaimSubmissionEntity.unsetBpjsDoctorMapping();
			bpjsClaimSubmissionEntity.setBpjsDoctorMappingId(bpjsDoctorMappingEntity.getId());

			try {
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getBpjsHealthFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Health Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsHealthFacilityEntity = bpjsHealthFacilityRepository.findById(bpjsHealthFacilityRepository.save(bpjsClaimSubmissionEntity.getBpjsHealthFacility()).getId()).get();
			bpjsClaimSubmissionEntity.unsetBpjsHealthFacility();
			bpjsClaimSubmissionEntity.setBpjsHealthFacilityId(bpjsHealthFacilityEntity.getId());

			try {
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getBpjsProcedure(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Procedure relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsProcedureEntity = bpjsProcedureRepository.findById(bpjsProcedureRepository.save(bpjsClaimSubmissionEntity.getBpjsProcedure()).getId()).get();
			bpjsClaimSubmissionEntity.unsetBpjsProcedure();
			bpjsClaimSubmissionEntity.setBpjsProcedureId(bpjsProcedureEntity.getId());

			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getBpjsServiceMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Service Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.findById(bpjsServiceMappingRepository.save(bpjsClaimSubmissionEntity.getBpjsServiceMapping()).getId()).get();
			bpjsClaimSubmissionEntity.unsetBpjsServiceMapping();
			bpjsClaimSubmissionEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getPatientGeneralInfo(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient General Info relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientGeneralInfoEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(bpjsClaimSubmissionEntity.getPatientGeneralInfo()).getId()).get();
			bpjsClaimSubmissionEntity.unsetPatientGeneralInfo();
			bpjsClaimSubmissionEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity.getPatientPaymentBPJS(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment BPJS relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.findById(patientPaymentBPJSRepository.save(bpjsClaimSubmissionEntity.getPatientPaymentBPJS()).getId()).get();
			bpjsClaimSubmissionEntity.unsetPatientPaymentBPJS();
			bpjsClaimSubmissionEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			bpjsDismissalConditionsEntities = new HashSet<>();
			bpjsDismissalConditionsEntityIds = new HashSet<>();
			for (BpjsDismissalConditionEntity entity : bpjsClaimSubmissionEntity.getBpjsDismissalConditions()) {
				try {
					bpjsDismissalConditionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Dismissal Conditions relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsDismissalConditionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsDismissalConditionsEntities.add(bpjsDismissalConditionRepository.findById(id).get());
				bpjsDismissalConditionsEntityIds.add(id);
			}
			bpjsClaimSubmissionEntity.unsetBpjsDismissalConditions();
			bpjsClaimSubmissionEntity.setBpjsDismissalConditionsIds(bpjsDismissalConditionsEntityIds);

			bpjsDismissalMappingsEntities = new HashSet<>();
			bpjsDismissalMappingsEntityIds = new HashSet<>();
			for (BpjsDismissalMappingEntity entity : bpjsClaimSubmissionEntity.getBpjsDismissalMappings()) {
				try {
					bpjsDismissalMappingDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Dismissal Mappings relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsDismissalMappingRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsDismissalMappingsEntities.add(bpjsDismissalMappingRepository.findById(id).get());
				bpjsDismissalMappingsEntityIds.add(id);
			}
			bpjsClaimSubmissionEntity.unsetBpjsDismissalMappings();
			bpjsClaimSubmissionEntity.setBpjsDismissalMappingsIds(bpjsDismissalMappingsEntityIds);

			bpjsTreatmentRoomsEntities = new HashSet<>();
			bpjsTreatmentRoomsEntityIds = new HashSet<>();
			for (BpjsTreatmentRoomEntity entity : bpjsClaimSubmissionEntity.getBpjsTreatmentRooms()) {
				try {
					bpjsTreatmentRoomDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Treatment Rooms relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsTreatmentRoomRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsTreatmentRoomsEntities.add(bpjsTreatmentRoomRepository.findById(id).get());
				bpjsTreatmentRoomsEntityIds.add(id);
			}
			bpjsClaimSubmissionEntity.unsetBpjsTreatmentRooms();
			bpjsClaimSubmissionEntity.setBpjsTreatmentRoomsIds(bpjsTreatmentRoomsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsClaimSubmissionEntity = bpjsClaimSubmissionService.updateOldData(bpjsClaimSubmissionEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			bpjsDiagnoseEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getBpjsDiagnose().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(bpjsDiagnoseEntity, updatedBpjsClaimSubmissionEntity.getBpjsDiagnose());

			bpjsDoctorMappingEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getBpjsDoctorMapping().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(bpjsDoctorMappingEntity, updatedBpjsClaimSubmissionEntity.getBpjsDoctorMapping());

			bpjsHealthFacilityEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getBpjsHealthFacility().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(bpjsHealthFacilityEntity, updatedBpjsClaimSubmissionEntity.getBpjsHealthFacility());

			bpjsProcedureEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getBpjsProcedure().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(bpjsProcedureEntity, updatedBpjsClaimSubmissionEntity.getBpjsProcedure());

			bpjsServiceMappingEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getBpjsServiceMapping().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(bpjsServiceMappingEntity, updatedBpjsClaimSubmissionEntity.getBpjsServiceMapping());

			patientGeneralInfoEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getPatientGeneralInfo().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(patientGeneralInfoEntity, updatedBpjsClaimSubmissionEntity.getPatientGeneralInfo());

			patientPaymentBPJSEntity.unsetBpjsClaimSubmissions(false);
			updatedBpjsClaimSubmissionEntity.getPatientPaymentBPJS().unsetBpjsClaimSubmissions(false);
			Assertions.assertEquals(patientPaymentBPJSEntity, updatedBpjsClaimSubmissionEntity.getPatientPaymentBPJS());

			Assertions.assertEquals(bpjsDismissalConditionsEntities.size(), updatedBpjsClaimSubmissionEntity.getBpjsDismissalConditions().size());

			Assertions.assertEquals(bpjsDismissalMappingsEntities.size(), updatedBpjsClaimSubmissionEntity.getBpjsDismissalMappings().size());

			Assertions.assertEquals(bpjsTreatmentRoomsEntities.size(), updatedBpjsClaimSubmissionEntity.getBpjsTreatmentRooms().size());

		});
	}

	@Test
	public void whenCreateBpjsClaimSubmissionEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity;
			Optional<BpjsClaimSubmissionEntity> fetchedBpjsClaimSubmissionEntity;

			try {
				bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);
				bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsClaimSubmissionEntity = bpjsClaimSubmissionService.create(bpjsClaimSubmissionEntity);

			fetchedBpjsClaimSubmissionEntity = bpjsClaimSubmissionService.findById(bpjsClaimSubmissionEntity.getId());

			Assertions.assertTrue(fetchedBpjsClaimSubmissionEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsClaimSubmissionEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsClaimSubmissionEntity, fetchedBpjsClaimSubmissionEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsClaimSubmissionEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity;
			BpjsClaimSubmissionEntity updatedBpjsClaimSubmissionEntity;
			Optional<BpjsClaimSubmissionEntity> fetchedBpjsClaimSubmissionEntity;

			try {
				bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);
				bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity, true, true, false);
				updatedBpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);
				bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsClaimSubmissionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsClaimSubmissionEntity = bpjsClaimSubmissionService.create(bpjsClaimSubmissionEntity);

			updatedBpjsClaimSubmissionEntity.setId(bpjsClaimSubmissionEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsClaimSubmissionEntity.setCreated(bpjsClaimSubmissionEntity.getCreated());

			updatedBpjsClaimSubmissionEntity = bpjsClaimSubmissionService.update(updatedBpjsClaimSubmissionEntity);

			fetchedBpjsClaimSubmissionEntity = bpjsClaimSubmissionService.findById(bpjsClaimSubmissionEntity.getId());

			Assertions.assertTrue(fetchedBpjsClaimSubmissionEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsClaimSubmissionEntity_ThenEntityIsCreated
			fetchedBpjsClaimSubmissionEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsClaimSubmissionEntity, fetchedBpjsClaimSubmissionEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsClaimSubmissionEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity;
			Optional<BpjsClaimSubmissionEntity> fetchedBpjsClaimSubmissionEntity;

			try {
				bpjsClaimSubmissionEntity = bpjsClaimSubmissionFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsClaimSubmissionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsClaimSubmissionEntity = bpjsClaimSubmissionService.create(bpjsClaimSubmissionEntity);

			bpjsClaimSubmissionService.deleteById(bpjsClaimSubmissionEntity.getId());
			fetchedBpjsClaimSubmissionEntity = bpjsClaimSubmissionService.findById(bpjsClaimSubmissionEntity.getId());

			Assertions.assertTrue(fetchedBpjsClaimSubmissionEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
