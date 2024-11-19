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
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;
import kmsweb.utils.PatientPaymentBPJSFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentBPJSDatabasePopulator;
import kmsweb.entities.BpjsAccidentMasterEntity;
import kmsweb.repositories.BpjsAccidentMasterRepository;
import kmsweb.utils.BpjsAccidentMasterFactory;
import kmsweb.utils.DatabasePopulators.BpjsAccidentMasterDatabasePopulator;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.BpjsHospitalizationPlanEntity;
import kmsweb.repositories.BpjsHospitalizationPlanRepository;
import kmsweb.utils.BpjsHospitalizationPlanFactory;
import kmsweb.utils.DatabasePopulators.BpjsHospitalizationPlanDatabasePopulator;
import kmsweb.entities.BpjsJasaRaharjaEntity;
import kmsweb.repositories.BpjsJasaRaharjaRepository;
import kmsweb.utils.BpjsJasaRaharjaFactory;
import kmsweb.utils.DatabasePopulators.BpjsJasaRaharjaDatabasePopulator;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.utils.BpjsPatientReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsPatientReferralDatabasePopulator;
import kmsweb.entities.BpjsSEPEntity;
import kmsweb.repositories.BpjsSEPRepository;
import kmsweb.utils.BpjsSEPFactory;
import kmsweb.utils.DatabasePopulators.BpjsSEPDatabasePopulator;
import kmsweb.entities.BpjsSEPSubmissionEntity;
import kmsweb.repositories.BpjsSEPSubmissionRepository;
import kmsweb.utils.BpjsSEPSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsSEPSubmissionDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
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
public class PatientPaymentBPJSServiceIntegrationTest {

	@Autowired
	private PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PatientPaymentBPJSService patientPaymentBPJSService;

	private final PatientPaymentBPJSFactory patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();

	@Autowired
	private PatientPaymentBPJSDatabasePopulator patientPaymentBPJSDatabasePopulator;

	@Autowired
	private BpjsAccidentMasterRepository bpjsAccidentMasterRepository;

	@Autowired
	private BpjsAccidentMasterDatabasePopulator bpjsAccidentMasterDatabasePopulator;

	private final BpjsAccidentMasterFactory bpjsAccidentMasterFactory = new BpjsAccidentMasterFactory();

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private BpjsHospitalizationPlanRepository bpjsHospitalizationPlanRepository;

	@Autowired
	private BpjsHospitalizationPlanDatabasePopulator bpjsHospitalizationPlanDatabasePopulator;

	private final BpjsHospitalizationPlanFactory bpjsHospitalizationPlanFactory = new BpjsHospitalizationPlanFactory();

	@Autowired
	private BpjsJasaRaharjaRepository bpjsJasaRaharjaRepository;

	@Autowired
	private BpjsJasaRaharjaDatabasePopulator bpjsJasaRaharjaDatabasePopulator;

	private final BpjsJasaRaharjaFactory bpjsJasaRaharjaFactory = new BpjsJasaRaharjaFactory();

	@Autowired
	private BpjsPatientReferralRepository bpjsPatientReferralRepository;

	@Autowired
	private BpjsPatientReferralDatabasePopulator bpjsPatientReferralDatabasePopulator;

	private final BpjsPatientReferralFactory bpjsPatientReferralFactory = new BpjsPatientReferralFactory();

	@Autowired
	private BpjsSEPRepository bpjsSEPRepository;

	@Autowired
	private BpjsSEPDatabasePopulator bpjsSEPDatabasePopulator;

	private final BpjsSEPFactory bpjsSEPFactory = new BpjsSEPFactory();

	@Autowired
	private BpjsSEPSubmissionRepository bpjsSEPSubmissionRepository;

	@Autowired
	private BpjsSEPSubmissionDatabasePopulator bpjsSEPSubmissionDatabasePopulator;

	private final BpjsSEPSubmissionFactory bpjsSEPSubmissionFactory = new BpjsSEPSubmissionFactory();

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		patientPaymentBPJSService = new PatientPaymentBPJSService(
			bpjsAccidentMasterRepository,
			bpjsClaimSubmissionRepository,
			bpjsHospitalizationPlanRepository,
			bpjsJasaRaharjaRepository,
			bpjsPatientReferralRepository,
			bpjsSEPRepository,
			bpjsSEPSubmissionRepository,
			patientGeneralInfoRepository,
			validator,
			auditRepository,
			patientPaymentBPJSRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPatientPaymentBPJSEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PatientPaymentBPJSEntity patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);

		PatientPaymentBPJSEntity updatedEntity = patientPaymentBPJSService.updateOldData(patientPaymentBPJSEntity);
		Assertions.assertEquals(patientPaymentBPJSEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPatientPaymentBPJSEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PatientPaymentBPJSEntity patientPaymentBPJSEntity;
			PatientPaymentBPJSEntity entityWithUpdatedValues;

			try {
				patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = patientPaymentBPJSFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientPaymentBPJSEntity = patientPaymentBPJSService.create(patientPaymentBPJSEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(patientPaymentBPJSEntity.getId());

			PatientPaymentBPJSEntity updatedEntity = patientPaymentBPJSService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPatientPaymentBPJSEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PatientPaymentBPJSEntity patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);
		patientPaymentBPJSEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			patientPaymentBPJSService.updateOldData(patientPaymentBPJSEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPatientPaymentBPJSEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientPaymentBPJSEntity patientPaymentBPJSEntity;
			PatientPaymentBPJSEntity updatedPatientPaymentBPJSEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			Set<BpjsAccidentMasterEntity> bpjsAccidentMastersEntities;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlansEntities;

			Set<BpjsJasaRaharjaEntity> bpjsJasaRaharjasEntities;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;

			Set<BpjsSEPSubmissionEntity> bpjsSEPSubmissionsEntities;

			Set<BpjsSEPEntity> bpjsSEPsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(true, false);
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
			patientGeneralInfoEntity = patientPaymentBPJSEntity.getPatientGeneralInfo();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientGeneralInfoEntity = patientGeneralInfoRepository.save(patientGeneralInfoEntity);
			patientPaymentBPJSEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			bpjsAccidentMastersEntities = patientPaymentBPJSEntity.getBpjsAccidentMasters();
			Set<UUID> bpjsAccidentMastersEntityIds = new HashSet<>();
			for (BpjsAccidentMasterEntity entity : bpjsAccidentMastersEntities) {
				try {
					bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsAccidentMastersEntityIds.add(bpjsAccidentMasterRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsAccidentMastersIds(bpjsAccidentMastersEntityIds);

			bpjsClaimSubmissionsEntities = patientPaymentBPJSEntity.getBpjsClaimSubmissions();
			Set<UUID> bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsClaimSubmissionsEntities) {
				try {
					bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsClaimSubmissionsEntityIds.add(bpjsClaimSubmissionRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsHospitalizationPlansEntities = patientPaymentBPJSEntity.getBpjsHospitalizationPlans();
			Set<UUID> bpjsHospitalizationPlansEntityIds = new HashSet<>();
			for (BpjsHospitalizationPlanEntity entity : bpjsHospitalizationPlansEntities) {
				try {
					bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsHospitalizationPlansEntityIds.add(bpjsHospitalizationPlanRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsHospitalizationPlansIds(bpjsHospitalizationPlansEntityIds);

			bpjsJasaRaharjasEntities = patientPaymentBPJSEntity.getBpjsJasaRaharjas();
			Set<UUID> bpjsJasaRaharjasEntityIds = new HashSet<>();
			for (BpjsJasaRaharjaEntity entity : bpjsJasaRaharjasEntities) {
				try {
					bpjsJasaRaharjaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsJasaRaharjasEntityIds.add(bpjsJasaRaharjaRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsJasaRaharjasIds(bpjsJasaRaharjasEntityIds);

			bpjsPatientReferralsEntities = patientPaymentBPJSEntity.getBpjsPatientReferrals();
			Set<UUID> bpjsPatientReferralsEntityIds = new HashSet<>();
			for (BpjsPatientReferralEntity entity : bpjsPatientReferralsEntities) {
				try {
					bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsPatientReferralsEntityIds.add(bpjsPatientReferralRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			bpjsSEPSubmissionsEntities = patientPaymentBPJSEntity.getBpjsSEPSubmissions();
			Set<UUID> bpjsSEPSubmissionsEntityIds = new HashSet<>();
			for (BpjsSEPSubmissionEntity entity : bpjsSEPSubmissionsEntities) {
				try {
					bpjsSEPSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsSEPSubmissionsEntityIds.add(bpjsSEPSubmissionRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsSEPSubmissionsIds(bpjsSEPSubmissionsEntityIds);

			bpjsSEPsEntities = patientPaymentBPJSEntity.getBpjsSEPs();
			Set<UUID> bpjsSEPsEntityIds = new HashSet<>();
			for (BpjsSEPEntity entity : bpjsSEPsEntities) {
				try {
					bpjsSEPDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsSEPsEntityIds.add(bpjsSEPRepository.save(entity).getId());
			}
			patientPaymentBPJSEntity.setBpjsSEPsIds(bpjsSEPsEntityIds);


			patientPaymentBPJSEntity = patientPaymentBPJSService.create(patientPaymentBPJSEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(patientPaymentBPJSEntity.getPatientGeneralInfo());
			patientPaymentBPJSEntity.setPatientGeneralInfoId(null);
			patientPaymentBPJSEntity.unsetPatientGeneralInfo();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsAccidentMasters().size() > 0);
			patientPaymentBPJSEntity.setBpjsAccidentMastersIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsAccidentMasters();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsClaimSubmissions().size() > 0);
			patientPaymentBPJSEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsHospitalizationPlans().size() > 0);
			patientPaymentBPJSEntity.setBpjsHospitalizationPlansIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsHospitalizationPlans();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsJasaRaharjas().size() > 0);
			patientPaymentBPJSEntity.setBpjsJasaRaharjasIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsJasaRaharjas();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsPatientReferrals().size() > 0);
			patientPaymentBPJSEntity.setBpjsPatientReferralsIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsPatientReferrals();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsSEPSubmissions().size() > 0);
			patientPaymentBPJSEntity.setBpjsSEPSubmissionsIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsSEPSubmissions();

			Assertions.assertTrue(patientPaymentBPJSEntity.getBpjsSEPs().size() > 0);
			patientPaymentBPJSEntity.setBpjsSEPsIds(new HashSet<UUID>());
			patientPaymentBPJSEntity.unsetBpjsSEPs();


			updatedPatientPaymentBPJSEntity = patientPaymentBPJSService.updateOldData(patientPaymentBPJSEntity);

			Assertions.assertNull(updatedPatientPaymentBPJSEntity.getPatientGeneralInfo());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsAccidentMasters().size());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsHospitalizationPlans().size());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsJasaRaharjas().size());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsSEPSubmissions().size());

			Assertions.assertEquals(0, updatedPatientPaymentBPJSEntity.getBpjsSEPs().size());

		});
	}

	@Test
	public void updateOldDataWithPatientPaymentBPJSEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientPaymentBPJSEntity patientPaymentBPJSEntity;
			PatientPaymentBPJSEntity updatedPatientPaymentBPJSEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			Set<BpjsAccidentMasterEntity> bpjsAccidentMastersEntities;
			Set<UUID> bpjsAccidentMastersEntityIds;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlansEntities;
			Set<UUID> bpjsHospitalizationPlansEntityIds;

			Set<BpjsJasaRaharjaEntity> bpjsJasaRaharjasEntities;
			Set<UUID> bpjsJasaRaharjasEntityIds;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;
			Set<UUID> bpjsPatientReferralsEntityIds;

			Set<BpjsSEPSubmissionEntity> bpjsSEPSubmissionsEntities;
			Set<UUID> bpjsSEPSubmissionsEntityIds;

			Set<BpjsSEPEntity> bpjsSEPsEntities;
			Set<UUID> bpjsSEPsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(true, false);
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
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity.getPatientGeneralInfo(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient General Info relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientGeneralInfoEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(patientPaymentBPJSEntity.getPatientGeneralInfo()).getId()).get();
			patientPaymentBPJSEntity.unsetPatientGeneralInfo();
			patientPaymentBPJSEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			bpjsAccidentMastersEntities = new HashSet<>();
			bpjsAccidentMastersEntityIds = new HashSet<>();
			for (BpjsAccidentMasterEntity entity : patientPaymentBPJSEntity.getBpjsAccidentMasters()) {
				try {
					bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Accident Masters relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsAccidentMasterRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsAccidentMastersEntities.add(bpjsAccidentMasterRepository.findById(id).get());
				bpjsAccidentMastersEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsAccidentMasters();
			patientPaymentBPJSEntity.setBpjsAccidentMastersIds(bpjsAccidentMastersEntityIds);

			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : patientPaymentBPJSEntity.getBpjsClaimSubmissions()) {
				try {
					bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Claim Submissions relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsClaimSubmissionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsClaimSubmissionsEntities.add(bpjsClaimSubmissionRepository.findById(id).get());
				bpjsClaimSubmissionsEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsClaimSubmissions();
			patientPaymentBPJSEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsHospitalizationPlansEntities = new HashSet<>();
			bpjsHospitalizationPlansEntityIds = new HashSet<>();
			for (BpjsHospitalizationPlanEntity entity : patientPaymentBPJSEntity.getBpjsHospitalizationPlans()) {
				try {
					bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Hospitalization Plans relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsHospitalizationPlanRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsHospitalizationPlansEntities.add(bpjsHospitalizationPlanRepository.findById(id).get());
				bpjsHospitalizationPlansEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsHospitalizationPlans();
			patientPaymentBPJSEntity.setBpjsHospitalizationPlansIds(bpjsHospitalizationPlansEntityIds);

			bpjsJasaRaharjasEntities = new HashSet<>();
			bpjsJasaRaharjasEntityIds = new HashSet<>();
			for (BpjsJasaRaharjaEntity entity : patientPaymentBPJSEntity.getBpjsJasaRaharjas()) {
				try {
					bpjsJasaRaharjaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Jasa Raharjas relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsJasaRaharjaRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsJasaRaharjasEntities.add(bpjsJasaRaharjaRepository.findById(id).get());
				bpjsJasaRaharjasEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsJasaRaharjas();
			patientPaymentBPJSEntity.setBpjsJasaRaharjasIds(bpjsJasaRaharjasEntityIds);

			bpjsPatientReferralsEntities = new HashSet<>();
			bpjsPatientReferralsEntityIds = new HashSet<>();
			for (BpjsPatientReferralEntity entity : patientPaymentBPJSEntity.getBpjsPatientReferrals()) {
				try {
					bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Patient Referrals relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsPatientReferralRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsPatientReferralsEntities.add(bpjsPatientReferralRepository.findById(id).get());
				bpjsPatientReferralsEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsPatientReferrals();
			patientPaymentBPJSEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			bpjsSEPSubmissionsEntities = new HashSet<>();
			bpjsSEPSubmissionsEntityIds = new HashSet<>();
			for (BpjsSEPSubmissionEntity entity : patientPaymentBPJSEntity.getBpjsSEPSubmissions()) {
				try {
					bpjsSEPSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS SEP Submissions relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsSEPSubmissionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsSEPSubmissionsEntities.add(bpjsSEPSubmissionRepository.findById(id).get());
				bpjsSEPSubmissionsEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsSEPSubmissions();
			patientPaymentBPJSEntity.setBpjsSEPSubmissionsIds(bpjsSEPSubmissionsEntityIds);

			bpjsSEPsEntities = new HashSet<>();
			bpjsSEPsEntityIds = new HashSet<>();
			for (BpjsSEPEntity entity : patientPaymentBPJSEntity.getBpjsSEPs()) {
				try {
					bpjsSEPDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS SEPs relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsSEPRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsSEPsEntities.add(bpjsSEPRepository.findById(id).get());
				bpjsSEPsEntityIds.add(id);
			}
			patientPaymentBPJSEntity.unsetBpjsSEPs();
			patientPaymentBPJSEntity.setBpjsSEPsIds(bpjsSEPsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPatientPaymentBPJSEntity = patientPaymentBPJSService.updateOldData(patientPaymentBPJSEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientGeneralInfoEntity.unsetPatientPaymentBPJS(false);
			updatedPatientPaymentBPJSEntity.getPatientGeneralInfo().unsetPatientPaymentBPJS(false);
			Assertions.assertEquals(patientGeneralInfoEntity, updatedPatientPaymentBPJSEntity.getPatientGeneralInfo());

			Assertions.assertEquals(bpjsAccidentMastersEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsAccidentMasters().size());

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(bpjsHospitalizationPlansEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsHospitalizationPlans().size());

			Assertions.assertEquals(bpjsJasaRaharjasEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsJasaRaharjas().size());

			Assertions.assertEquals(bpjsPatientReferralsEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(bpjsSEPSubmissionsEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsSEPSubmissions().size());

			Assertions.assertEquals(bpjsSEPsEntities.size(), updatedPatientPaymentBPJSEntity.getBpjsSEPs().size());

		});
	}

	@Test
	public void whenCreatePatientPaymentBPJSEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientPaymentBPJSEntity patientPaymentBPJSEntity;
			Optional<PatientPaymentBPJSEntity> fetchedPatientPaymentBPJSEntity;

			try {
				patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientPaymentBPJSEntity = patientPaymentBPJSService.create(patientPaymentBPJSEntity);

			fetchedPatientPaymentBPJSEntity = patientPaymentBPJSService.findById(patientPaymentBPJSEntity.getId());

			Assertions.assertTrue(fetchedPatientPaymentBPJSEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPatientPaymentBPJSEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(patientPaymentBPJSEntity, fetchedPatientPaymentBPJSEntity.get());
		});
	}

	@Test
	public void whenUpdatePatientPaymentBPJSEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientPaymentBPJSEntity patientPaymentBPJSEntity;
			PatientPaymentBPJSEntity updatedPatientPaymentBPJSEntity;
			Optional<PatientPaymentBPJSEntity> fetchedPatientPaymentBPJSEntity;

			try {
				patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, false);
				updatedPatientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPatientPaymentBPJSEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientPaymentBPJSEntity = patientPaymentBPJSService.create(patientPaymentBPJSEntity);

			updatedPatientPaymentBPJSEntity.setId(patientPaymentBPJSEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPatientPaymentBPJSEntity.setCreated(patientPaymentBPJSEntity.getCreated());

			updatedPatientPaymentBPJSEntity = patientPaymentBPJSService.update(updatedPatientPaymentBPJSEntity);

			fetchedPatientPaymentBPJSEntity = patientPaymentBPJSService.findById(patientPaymentBPJSEntity.getId());

			Assertions.assertTrue(fetchedPatientPaymentBPJSEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePatientPaymentBPJSEntity_ThenEntityIsCreated
			fetchedPatientPaymentBPJSEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPatientPaymentBPJSEntity, fetchedPatientPaymentBPJSEntity.get());
		});
	}

	@Test
	public void whenDeletePatientPaymentBPJSEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PatientPaymentBPJSEntity patientPaymentBPJSEntity;
			Optional<PatientPaymentBPJSEntity> fetchedPatientPaymentBPJSEntity;

			try {
				patientPaymentBPJSEntity = patientPaymentBPJSFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientPaymentBPJSEntity = patientPaymentBPJSService.create(patientPaymentBPJSEntity);

			patientPaymentBPJSService.deleteById(patientPaymentBPJSEntity.getId());
			fetchedPatientPaymentBPJSEntity = patientPaymentBPJSService.findById(patientPaymentBPJSEntity.getId());

			Assertions.assertTrue(fetchedPatientPaymentBPJSEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
