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
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.utils.BpjsDiagnoseFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnoseDatabasePopulator;
import kmsweb.entities.BpjsDiagnosePRBEntity;
import kmsweb.repositories.BpjsDiagnosePRBRepository;
import kmsweb.utils.BpjsDiagnosePRBFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnosePRBDatabasePopulator;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.repositories.DailyCareCPPTRepository;
import kmsweb.utils.DailyCareCPPTFactory;
import kmsweb.utils.DatabasePopulators.DailyCareCPPTDatabasePopulator;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.utils.DiagnosisExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisExaminationRecordDatabasePopulator;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.repositories.DiagnosisNandaRepository;
import kmsweb.utils.DiagnosisNandaFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisNandaDatabasePopulator;
import kmsweb.entities.Icd10Entity;
import kmsweb.repositories.Icd10Repository;
import kmsweb.utils.Icd10Factory;
import kmsweb.utils.DatabasePopulators.Icd10DatabasePopulator;
import kmsweb.entities.Icd9CMEntity;
import kmsweb.repositories.Icd9CMRepository;
import kmsweb.utils.Icd9CMFactory;
import kmsweb.utils.DatabasePopulators.Icd9CMDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.repositories.MedicalCertificateDischargeResumeRepository;
import kmsweb.utils.MedicalCertificateDischargeResumeFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateDischargeResumeDatabasePopulator;
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
public class DiagnosesAndProceduresServiceIntegrationTest {

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DiagnosesAndProceduresService diagnosesAndProceduresService;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	@Autowired
	private BpjsDiagnoseRepository bpjsDiagnoseRepository;

	@Autowired
	private BpjsDiagnoseDatabasePopulator bpjsDiagnoseDatabasePopulator;

	private final BpjsDiagnoseFactory bpjsDiagnoseFactory = new BpjsDiagnoseFactory();

	@Autowired
	private BpjsDiagnosePRBRepository bpjsDiagnosePRBRepository;

	@Autowired
	private BpjsDiagnosePRBDatabasePopulator bpjsDiagnosePRBDatabasePopulator;

	private final BpjsDiagnosePRBFactory bpjsDiagnosePRBFactory = new BpjsDiagnosePRBFactory();

	@Autowired
	private DailyCareCPPTRepository dailyCareCPPTRepository;

	@Autowired
	private DailyCareCPPTDatabasePopulator dailyCareCPPTDatabasePopulator;

	private final DailyCareCPPTFactory dailyCareCPPTFactory = new DailyCareCPPTFactory();

	@Autowired
	private DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	@Autowired
	private DiagnosisExaminationRecordDatabasePopulator diagnosisExaminationRecordDatabasePopulator;

	private final DiagnosisExaminationRecordFactory diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();

	@Autowired
	private DiagnosisNandaRepository diagnosisNandaRepository;

	@Autowired
	private DiagnosisNandaDatabasePopulator diagnosisNandaDatabasePopulator;

	private final DiagnosisNandaFactory diagnosisNandaFactory = new DiagnosisNandaFactory();

	@Autowired
	private Icd10Repository icd10Repository;

	@Autowired
	private Icd10DatabasePopulator icd10DatabasePopulator;

	private final Icd10Factory icd10Factory = new Icd10Factory();

	@Autowired
	private Icd9CMRepository icd9CMRepository;

	@Autowired
	private Icd9CMDatabasePopulator icd9CMDatabasePopulator;

	private final Icd9CMFactory icd9CMFactory = new Icd9CMFactory();

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository;

	@Autowired
	private MedicalCertificateDischargeResumeDatabasePopulator medicalCertificateDischargeResumeDatabasePopulator;

	private final MedicalCertificateDischargeResumeFactory medicalCertificateDischargeResumeFactory = new MedicalCertificateDischargeResumeFactory();

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


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		diagnosesAndProceduresService = new DiagnosesAndProceduresService(
			bpjsDiagnoseRepository,
			bpjsDiagnosePRBRepository,
			dailyCareCPPTRepository,
			diagnosisExaminationRecordRepository,
			diagnosisNandaRepository,
			icd10Repository,
			icd9CMRepository,
			invoiceRepository,
			medicalCertificateDischargeResumeRepository,
			postOperativeDetailsRepository,
			preoperativeRecordsRepository,
			registrationRepository,
			validator,
			auditRepository,
			diagnosesAndProceduresRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDiagnosesAndProceduresEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DiagnosesAndProceduresEntity diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);

		DiagnosesAndProceduresEntity updatedEntity = diagnosesAndProceduresService.updateOldData(diagnosesAndProceduresEntity);
		Assertions.assertEquals(diagnosesAndProceduresEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingDiagnosesAndProceduresEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;
			DiagnosesAndProceduresEntity entityWithUpdatedValues;

			try {
				diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = diagnosesAndProceduresFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosesAndProceduresEntity = diagnosesAndProceduresService.create(diagnosesAndProceduresEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(diagnosesAndProceduresEntity.getId());

			DiagnosesAndProceduresEntity updatedEntity = diagnosesAndProceduresService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDiagnosesAndProceduresEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DiagnosesAndProceduresEntity diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);
		diagnosesAndProceduresEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			diagnosesAndProceduresService.updateOldData(diagnosesAndProceduresEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDiagnosesAndProceduresEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;
			DiagnosesAndProceduresEntity updatedDiagnosesAndProceduresEntity;

			BpjsDiagnoseEntity bpjsDiagnoseEntity;

			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;

			Icd10Entity masterICD10Entity;

			Icd9CMEntity masterICD9CMEntity;

			Set<RegistrationEntity> admissionICD10Entities;

			Set<RegistrationEntity> admissionICD9CMEntities;

			Set<DailyCareCPPTEntity> cpptICD10Entities;

			Set<DailyCareCPPTEntity> cpptICD9CMEntities;

			Set<MedicalCertificateDischargeResumeEntity> dischargeICD10Entities;

			Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CMEntities;

			Set<DiagnosisExaminationRecordEntity> icd10Entities;

			Set<DiagnosisExaminationRecordEntity> icd9CMEntities;

			Set<InvoiceEntity> invoicesICD10Entities;

			Set<InvoiceEntity> invoicesICD9CMEntities;

			Set<PostOperativeDetailsEntity> postOperativeICD10Entities;

			Set<PostOperativeDetailsEntity> postOperativeICD9CMEntities;

			Set<PreoperativeRecordsEntity> preSurgeryICD10Entities;

			Set<PreoperativeRecordsEntity> preSurgeryICD9CMEntities;

			Set<DiagnosisNandaEntity> diagnosisNandasEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(true, false);
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
			bpjsDiagnoseEntity = diagnosesAndProceduresEntity.getBpjsDiagnose();
			try {
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDiagnoseEntity = bpjsDiagnoseRepository.save(bpjsDiagnoseEntity);
			diagnosesAndProceduresEntity.setBpjsDiagnoseId(bpjsDiagnoseEntity.getId());

			bpjsDiagnosePRBEntity = diagnosesAndProceduresEntity.getBpjsDiagnosePRB();
			try {
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnosePRBEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDiagnosePRBEntity = bpjsDiagnosePRBRepository.save(bpjsDiagnosePRBEntity);
			diagnosesAndProceduresEntity.setBpjsDiagnosePRBId(bpjsDiagnosePRBEntity.getId());

			masterICD10Entity = diagnosesAndProceduresEntity.getMasterICD10();
			try {
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(masterICD10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			masterICD10Entity = icd10Repository.save(masterICD10Entity);
			diagnosesAndProceduresEntity.setMasterICD10Id(masterICD10Entity.getId());

			masterICD9CMEntity = diagnosesAndProceduresEntity.getMasterICD9CM();
			try {
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(masterICD9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			masterICD9CMEntity = icd9CMRepository.save(masterICD9CMEntity);
			diagnosesAndProceduresEntity.setMasterICD9CMId(masterICD9CMEntity.getId());

			admissionICD10Entities = diagnosesAndProceduresEntity.getAdmissionICD10();
			Set<UUID> admissionICD10EntityIds = new HashSet<>();
			for (RegistrationEntity entity : admissionICD10Entities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				admissionICD10EntityIds.add(registrationRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setAdmissionICD10Ids(admissionICD10EntityIds);

			admissionICD9CMEntities = diagnosesAndProceduresEntity.getAdmissionICD9CM();
			Set<UUID> admissionICD9CMEntityIds = new HashSet<>();
			for (RegistrationEntity entity : admissionICD9CMEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				admissionICD9CMEntityIds.add(registrationRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setAdmissionICD9CMIds(admissionICD9CMEntityIds);

			cpptICD10Entities = diagnosesAndProceduresEntity.getCpptICD10();
			Set<UUID> cpptICD10EntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : cpptICD10Entities) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				cpptICD10EntityIds.add(dailyCareCPPTRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setCpptICD10Ids(cpptICD10EntityIds);

			cpptICD9CMEntities = diagnosesAndProceduresEntity.getCpptICD9CM();
			Set<UUID> cpptICD9CMEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : cpptICD9CMEntities) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				cpptICD9CMEntityIds.add(dailyCareCPPTRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setCpptICD9CMIds(cpptICD9CMEntityIds);

			dischargeICD10Entities = diagnosesAndProceduresEntity.getDischargeICD10();
			Set<UUID> dischargeICD10EntityIds = new HashSet<>();
			for (MedicalCertificateDischargeResumeEntity entity : dischargeICD10Entities) {
				try {
					medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dischargeICD10EntityIds.add(medicalCertificateDischargeResumeRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setDischargeICD10Ids(dischargeICD10EntityIds);

			dischargeICD9CMEntities = diagnosesAndProceduresEntity.getDischargeICD9CM();
			Set<UUID> dischargeICD9CMEntityIds = new HashSet<>();
			for (MedicalCertificateDischargeResumeEntity entity : dischargeICD9CMEntities) {
				try {
					medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dischargeICD9CMEntityIds.add(medicalCertificateDischargeResumeRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setDischargeICD9CMIds(dischargeICD9CMEntityIds);

			icd10Entities = diagnosesAndProceduresEntity.getIcd10();
			Set<UUID> icd10EntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : icd10Entities) {
				try {
					diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				icd10EntityIds.add(diagnosisExaminationRecordRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setIcd10Ids(icd10EntityIds);

			icd9CMEntities = diagnosesAndProceduresEntity.getIcd9CM();
			Set<UUID> icd9CMEntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : icd9CMEntities) {
				try {
					diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				icd9CMEntityIds.add(diagnosisExaminationRecordRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setIcd9CMIds(icd9CMEntityIds);

			invoicesICD10Entities = diagnosesAndProceduresEntity.getInvoicesICD10();
			Set<UUID> invoicesICD10EntityIds = new HashSet<>();
			for (InvoiceEntity entity : invoicesICD10Entities) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicesICD10EntityIds.add(invoiceRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setInvoicesICD10Ids(invoicesICD10EntityIds);

			invoicesICD9CMEntities = diagnosesAndProceduresEntity.getInvoicesICD9CM();
			Set<UUID> invoicesICD9CMEntityIds = new HashSet<>();
			for (InvoiceEntity entity : invoicesICD9CMEntities) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicesICD9CMEntityIds.add(invoiceRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setInvoicesICD9CMIds(invoicesICD9CMEntityIds);

			postOperativeICD10Entities = diagnosesAndProceduresEntity.getPostOperativeICD10();
			Set<UUID> postOperativeICD10EntityIds = new HashSet<>();
			for (PostOperativeDetailsEntity entity : postOperativeICD10Entities) {
				try {
					postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				postOperativeICD10EntityIds.add(postOperativeDetailsRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setPostOperativeICD10Ids(postOperativeICD10EntityIds);

			postOperativeICD9CMEntities = diagnosesAndProceduresEntity.getPostOperativeICD9CM();
			Set<UUID> postOperativeICD9CMEntityIds = new HashSet<>();
			for (PostOperativeDetailsEntity entity : postOperativeICD9CMEntities) {
				try {
					postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				postOperativeICD9CMEntityIds.add(postOperativeDetailsRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setPostOperativeICD9CMIds(postOperativeICD9CMEntityIds);

			preSurgeryICD10Entities = diagnosesAndProceduresEntity.getPreSurgeryICD10();
			Set<UUID> preSurgeryICD10EntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : preSurgeryICD10Entities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				preSurgeryICD10EntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setPreSurgeryICD10Ids(preSurgeryICD10EntityIds);

			preSurgeryICD9CMEntities = diagnosesAndProceduresEntity.getPreSurgeryICD9CM();
			Set<UUID> preSurgeryICD9CMEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : preSurgeryICD9CMEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				preSurgeryICD9CMEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setPreSurgeryICD9CMIds(preSurgeryICD9CMEntityIds);

			diagnosisNandasEntities = diagnosesAndProceduresEntity.getDiagnosisNandas();
			Set<UUID> diagnosisNandasEntityIds = new HashSet<>();
			for (DiagnosisNandaEntity entity : diagnosisNandasEntities) {
				try {
					diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				diagnosisNandasEntityIds.add(diagnosisNandaRepository.save(entity).getId());
			}
			diagnosesAndProceduresEntity.setDiagnosisNandasIds(diagnosisNandasEntityIds);


			diagnosesAndProceduresEntity = diagnosesAndProceduresService.create(diagnosesAndProceduresEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(diagnosesAndProceduresEntity.getBpjsDiagnose());
			diagnosesAndProceduresEntity.setBpjsDiagnoseId(null);
			diagnosesAndProceduresEntity.unsetBpjsDiagnose();

			Assertions.assertNotNull(diagnosesAndProceduresEntity.getBpjsDiagnosePRB());
			diagnosesAndProceduresEntity.setBpjsDiagnosePRBId(null);
			diagnosesAndProceduresEntity.unsetBpjsDiagnosePRB();

			Assertions.assertNotNull(diagnosesAndProceduresEntity.getMasterICD10());
			diagnosesAndProceduresEntity.setMasterICD10Id(null);
			diagnosesAndProceduresEntity.unsetMasterICD10();

			Assertions.assertNotNull(diagnosesAndProceduresEntity.getMasterICD9CM());
			diagnosesAndProceduresEntity.setMasterICD9CMId(null);
			diagnosesAndProceduresEntity.unsetMasterICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getAdmissionICD10().size() > 0);
			diagnosesAndProceduresEntity.setAdmissionICD10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetAdmissionICD10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getAdmissionICD9CM().size() > 0);
			diagnosesAndProceduresEntity.setAdmissionICD9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetAdmissionICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getCpptICD10().size() > 0);
			diagnosesAndProceduresEntity.setCpptICD10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetCpptICD10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getCpptICD9CM().size() > 0);
			diagnosesAndProceduresEntity.setCpptICD9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetCpptICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getDischargeICD10().size() > 0);
			diagnosesAndProceduresEntity.setDischargeICD10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetDischargeICD10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getDischargeICD9CM().size() > 0);
			diagnosesAndProceduresEntity.setDischargeICD9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetDischargeICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getIcd10().size() > 0);
			diagnosesAndProceduresEntity.setIcd10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetIcd10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getIcd9CM().size() > 0);
			diagnosesAndProceduresEntity.setIcd9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetIcd9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getInvoicesICD10().size() > 0);
			diagnosesAndProceduresEntity.setInvoicesICD10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetInvoicesICD10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getInvoicesICD9CM().size() > 0);
			diagnosesAndProceduresEntity.setInvoicesICD9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetInvoicesICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getPostOperativeICD10().size() > 0);
			diagnosesAndProceduresEntity.setPostOperativeICD10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetPostOperativeICD10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getPostOperativeICD9CM().size() > 0);
			diagnosesAndProceduresEntity.setPostOperativeICD9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetPostOperativeICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getPreSurgeryICD10().size() > 0);
			diagnosesAndProceduresEntity.setPreSurgeryICD10Ids(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetPreSurgeryICD10();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getPreSurgeryICD9CM().size() > 0);
			diagnosesAndProceduresEntity.setPreSurgeryICD9CMIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetPreSurgeryICD9CM();

			Assertions.assertTrue(diagnosesAndProceduresEntity.getDiagnosisNandas().size() > 0);
			diagnosesAndProceduresEntity.setDiagnosisNandasIds(new HashSet<UUID>());
			diagnosesAndProceduresEntity.unsetDiagnosisNandas();


			updatedDiagnosesAndProceduresEntity = diagnosesAndProceduresService.updateOldData(diagnosesAndProceduresEntity);

			Assertions.assertNull(updatedDiagnosesAndProceduresEntity.getBpjsDiagnose());

			Assertions.assertNull(updatedDiagnosesAndProceduresEntity.getBpjsDiagnosePRB());

			Assertions.assertNull(updatedDiagnosesAndProceduresEntity.getMasterICD10());

			Assertions.assertNull(updatedDiagnosesAndProceduresEntity.getMasterICD9CM());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getAdmissionICD10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getAdmissionICD9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getCpptICD10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getCpptICD9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getDischargeICD10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getDischargeICD9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getIcd10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getIcd9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getInvoicesICD10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getInvoicesICD9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getPostOperativeICD10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getPostOperativeICD9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getPreSurgeryICD10().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getPreSurgeryICD9CM().size());

			Assertions.assertEquals(0, updatedDiagnosesAndProceduresEntity.getDiagnosisNandas().size());

		});
	}

	@Test
	public void updateOldDataWithDiagnosesAndProceduresEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;
			DiagnosesAndProceduresEntity updatedDiagnosesAndProceduresEntity;

			BpjsDiagnoseEntity bpjsDiagnoseEntity;

			BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity;

			Icd10Entity masterICD10Entity;

			Icd9CMEntity masterICD9CMEntity;

			Set<RegistrationEntity> admissionICD10Entities;
			Set<UUID> admissionICD10EntityIds;

			Set<RegistrationEntity> admissionICD9CMEntities;
			Set<UUID> admissionICD9CMEntityIds;

			Set<DailyCareCPPTEntity> cpptICD10Entities;
			Set<UUID> cpptICD10EntityIds;

			Set<DailyCareCPPTEntity> cpptICD9CMEntities;
			Set<UUID> cpptICD9CMEntityIds;

			Set<MedicalCertificateDischargeResumeEntity> dischargeICD10Entities;
			Set<UUID> dischargeICD10EntityIds;

			Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CMEntities;
			Set<UUID> dischargeICD9CMEntityIds;

			Set<DiagnosisExaminationRecordEntity> icd10Entities;
			Set<UUID> icd10EntityIds;

			Set<DiagnosisExaminationRecordEntity> icd9CMEntities;
			Set<UUID> icd9CMEntityIds;

			Set<InvoiceEntity> invoicesICD10Entities;
			Set<UUID> invoicesICD10EntityIds;

			Set<InvoiceEntity> invoicesICD9CMEntities;
			Set<UUID> invoicesICD9CMEntityIds;

			Set<PostOperativeDetailsEntity> postOperativeICD10Entities;
			Set<UUID> postOperativeICD10EntityIds;

			Set<PostOperativeDetailsEntity> postOperativeICD9CMEntities;
			Set<UUID> postOperativeICD9CMEntityIds;

			Set<PreoperativeRecordsEntity> preSurgeryICD10Entities;
			Set<UUID> preSurgeryICD10EntityIds;

			Set<PreoperativeRecordsEntity> preSurgeryICD9CMEntities;
			Set<UUID> preSurgeryICD9CMEntityIds;

			Set<DiagnosisNandaEntity> diagnosisNandasEntities;
			Set<UUID> diagnosisNandasEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(true, false);
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
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity.getBpjsDiagnose(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Diagnose relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDiagnoseEntity = bpjsDiagnoseRepository.findById(bpjsDiagnoseRepository.save(diagnosesAndProceduresEntity.getBpjsDiagnose()).getId()).get();
			diagnosesAndProceduresEntity.unsetBpjsDiagnose();
			diagnosesAndProceduresEntity.setBpjsDiagnoseId(bpjsDiagnoseEntity.getId());

			try {
				bpjsDiagnosePRBDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity.getBpjsDiagnosePRB(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Diagnose PRB relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDiagnosePRBEntity = bpjsDiagnosePRBRepository.findById(bpjsDiagnosePRBRepository.save(diagnosesAndProceduresEntity.getBpjsDiagnosePRB()).getId()).get();
			diagnosesAndProceduresEntity.unsetBpjsDiagnosePRB();
			diagnosesAndProceduresEntity.setBpjsDiagnosePRBId(bpjsDiagnosePRBEntity.getId());

			try {
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity.getMasterICD10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Master ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			masterICD10Entity = icd10Repository.findById(icd10Repository.save(diagnosesAndProceduresEntity.getMasterICD10()).getId()).get();
			diagnosesAndProceduresEntity.unsetMasterICD10();
			diagnosesAndProceduresEntity.setMasterICD10Id(masterICD10Entity.getId());

			try {
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity.getMasterICD9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Master ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			masterICD9CMEntity = icd9CMRepository.findById(icd9CMRepository.save(diagnosesAndProceduresEntity.getMasterICD9CM()).getId()).get();
			diagnosesAndProceduresEntity.unsetMasterICD9CM();
			diagnosesAndProceduresEntity.setMasterICD9CMId(masterICD9CMEntity.getId());

			admissionICD10Entities = new HashSet<>();
			admissionICD10EntityIds = new HashSet<>();
			for (RegistrationEntity entity : diagnosesAndProceduresEntity.getAdmissionICD10()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Admission ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				admissionICD10Entities.add(registrationRepository.findById(id).get());
				admissionICD10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetAdmissionICD10();
			diagnosesAndProceduresEntity.setAdmissionICD10Ids(admissionICD10EntityIds);

			admissionICD9CMEntities = new HashSet<>();
			admissionICD9CMEntityIds = new HashSet<>();
			for (RegistrationEntity entity : diagnosesAndProceduresEntity.getAdmissionICD9CM()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Admission ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				admissionICD9CMEntities.add(registrationRepository.findById(id).get());
				admissionICD9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetAdmissionICD9CM();
			diagnosesAndProceduresEntity.setAdmissionICD9CMIds(admissionICD9CMEntityIds);

			cpptICD10Entities = new HashSet<>();
			cpptICD10EntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : diagnosesAndProceduresEntity.getCpptICD10()) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the CPPT ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = dailyCareCPPTRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				cpptICD10Entities.add(dailyCareCPPTRepository.findById(id).get());
				cpptICD10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetCpptICD10();
			diagnosesAndProceduresEntity.setCpptICD10Ids(cpptICD10EntityIds);

			cpptICD9CMEntities = new HashSet<>();
			cpptICD9CMEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : diagnosesAndProceduresEntity.getCpptICD9CM()) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the CPPT ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = dailyCareCPPTRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				cpptICD9CMEntities.add(dailyCareCPPTRepository.findById(id).get());
				cpptICD9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetCpptICD9CM();
			diagnosesAndProceduresEntity.setCpptICD9CMIds(cpptICD9CMEntityIds);

			dischargeICD10Entities = new HashSet<>();
			dischargeICD10EntityIds = new HashSet<>();
			for (MedicalCertificateDischargeResumeEntity entity : diagnosesAndProceduresEntity.getDischargeICD10()) {
				try {
					medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Discharge ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateDischargeResumeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dischargeICD10Entities.add(medicalCertificateDischargeResumeRepository.findById(id).get());
				dischargeICD10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetDischargeICD10();
			diagnosesAndProceduresEntity.setDischargeICD10Ids(dischargeICD10EntityIds);

			dischargeICD9CMEntities = new HashSet<>();
			dischargeICD9CMEntityIds = new HashSet<>();
			for (MedicalCertificateDischargeResumeEntity entity : diagnosesAndProceduresEntity.getDischargeICD9CM()) {
				try {
					medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Discharge ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateDischargeResumeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dischargeICD9CMEntities.add(medicalCertificateDischargeResumeRepository.findById(id).get());
				dischargeICD9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetDischargeICD9CM();
			diagnosesAndProceduresEntity.setDischargeICD9CMIds(dischargeICD9CMEntityIds);

			icd10Entities = new HashSet<>();
			icd10EntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : diagnosesAndProceduresEntity.getIcd10()) {
				try {
					diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosisExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				icd10Entities.add(diagnosisExaminationRecordRepository.findById(id).get());
				icd10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetIcd10();
			diagnosesAndProceduresEntity.setIcd10Ids(icd10EntityIds);

			icd9CMEntities = new HashSet<>();
			icd9CMEntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : diagnosesAndProceduresEntity.getIcd9CM()) {
				try {
					diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosisExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				icd9CMEntities.add(diagnosisExaminationRecordRepository.findById(id).get());
				icd9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetIcd9CM();
			diagnosesAndProceduresEntity.setIcd9CMIds(icd9CMEntityIds);

			invoicesICD10Entities = new HashSet<>();
			invoicesICD10EntityIds = new HashSet<>();
			for (InvoiceEntity entity : diagnosesAndProceduresEntity.getInvoicesICD10()) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoices ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicesICD10Entities.add(invoiceRepository.findById(id).get());
				invoicesICD10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetInvoicesICD10();
			diagnosesAndProceduresEntity.setInvoicesICD10Ids(invoicesICD10EntityIds);

			invoicesICD9CMEntities = new HashSet<>();
			invoicesICD9CMEntityIds = new HashSet<>();
			for (InvoiceEntity entity : diagnosesAndProceduresEntity.getInvoicesICD9CM()) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoices ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicesICD9CMEntities.add(invoiceRepository.findById(id).get());
				invoicesICD9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetInvoicesICD9CM();
			diagnosesAndProceduresEntity.setInvoicesICD9CMIds(invoicesICD9CMEntityIds);

			postOperativeICD10Entities = new HashSet<>();
			postOperativeICD10EntityIds = new HashSet<>();
			for (PostOperativeDetailsEntity entity : diagnosesAndProceduresEntity.getPostOperativeICD10()) {
				try {
					postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Post Operative ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = postOperativeDetailsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				postOperativeICD10Entities.add(postOperativeDetailsRepository.findById(id).get());
				postOperativeICD10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetPostOperativeICD10();
			diagnosesAndProceduresEntity.setPostOperativeICD10Ids(postOperativeICD10EntityIds);

			postOperativeICD9CMEntities = new HashSet<>();
			postOperativeICD9CMEntityIds = new HashSet<>();
			for (PostOperativeDetailsEntity entity : diagnosesAndProceduresEntity.getPostOperativeICD9CM()) {
				try {
					postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Post Operative ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = postOperativeDetailsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				postOperativeICD9CMEntities.add(postOperativeDetailsRepository.findById(id).get());
				postOperativeICD9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetPostOperativeICD9CM();
			diagnosesAndProceduresEntity.setPostOperativeICD9CMIds(postOperativeICD9CMEntityIds);

			preSurgeryICD10Entities = new HashSet<>();
			preSurgeryICD10EntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : diagnosesAndProceduresEntity.getPreSurgeryICD10()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Pre Surgery ICD 10 relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				preSurgeryICD10Entities.add(preoperativeRecordsRepository.findById(id).get());
				preSurgeryICD10EntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetPreSurgeryICD10();
			diagnosesAndProceduresEntity.setPreSurgeryICD10Ids(preSurgeryICD10EntityIds);

			preSurgeryICD9CMEntities = new HashSet<>();
			preSurgeryICD9CMEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : diagnosesAndProceduresEntity.getPreSurgeryICD9CM()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Pre Surgery ICD 9 CM relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				preSurgeryICD9CMEntities.add(preoperativeRecordsRepository.findById(id).get());
				preSurgeryICD9CMEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetPreSurgeryICD9CM();
			diagnosesAndProceduresEntity.setPreSurgeryICD9CMIds(preSurgeryICD9CMEntityIds);

			diagnosisNandasEntities = new HashSet<>();
			diagnosisNandasEntityIds = new HashSet<>();
			for (DiagnosisNandaEntity entity : diagnosesAndProceduresEntity.getDiagnosisNandas()) {
				try {
					diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Diagnosis Nandas relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosisNandaRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				diagnosisNandasEntities.add(diagnosisNandaRepository.findById(id).get());
				diagnosisNandasEntityIds.add(id);
			}
			diagnosesAndProceduresEntity.unsetDiagnosisNandas();
			diagnosesAndProceduresEntity.setDiagnosisNandasIds(diagnosisNandasEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDiagnosesAndProceduresEntity = diagnosesAndProceduresService.updateOldData(diagnosesAndProceduresEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			bpjsDiagnoseEntity.unsetDiagnosesAndProcedures(false);
			updatedDiagnosesAndProceduresEntity.getBpjsDiagnose().unsetDiagnosesAndProcedures(false);
			Assertions.assertEquals(bpjsDiagnoseEntity, updatedDiagnosesAndProceduresEntity.getBpjsDiagnose());

			bpjsDiagnosePRBEntity.unsetDiagnosesAndProcedures(false);
			updatedDiagnosesAndProceduresEntity.getBpjsDiagnosePRB().unsetDiagnosesAndProcedures(false);
			Assertions.assertEquals(bpjsDiagnosePRBEntity, updatedDiagnosesAndProceduresEntity.getBpjsDiagnosePRB());

			masterICD10Entity.unsetDiagnosesAndProcedures(false);
			updatedDiagnosesAndProceduresEntity.getMasterICD10().unsetDiagnosesAndProcedures(false);
			Assertions.assertEquals(masterICD10Entity, updatedDiagnosesAndProceduresEntity.getMasterICD10());

			masterICD9CMEntity.unsetDiagnosesAndProcedures(false);
			updatedDiagnosesAndProceduresEntity.getMasterICD9CM().unsetDiagnosesAndProcedures(false);
			Assertions.assertEquals(masterICD9CMEntity, updatedDiagnosesAndProceduresEntity.getMasterICD9CM());

			Assertions.assertEquals(admissionICD10Entities.size(), updatedDiagnosesAndProceduresEntity.getAdmissionICD10().size());

			Assertions.assertEquals(admissionICD9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getAdmissionICD9CM().size());

			Assertions.assertEquals(cpptICD10Entities.size(), updatedDiagnosesAndProceduresEntity.getCpptICD10().size());

			Assertions.assertEquals(cpptICD9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getCpptICD9CM().size());

			Assertions.assertEquals(dischargeICD10Entities.size(), updatedDiagnosesAndProceduresEntity.getDischargeICD10().size());

			Assertions.assertEquals(dischargeICD9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getDischargeICD9CM().size());

			Assertions.assertEquals(icd10Entities.size(), updatedDiagnosesAndProceduresEntity.getIcd10().size());

			Assertions.assertEquals(icd9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getIcd9CM().size());

			Assertions.assertEquals(invoicesICD10Entities.size(), updatedDiagnosesAndProceduresEntity.getInvoicesICD10().size());

			Assertions.assertEquals(invoicesICD9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getInvoicesICD9CM().size());

			Assertions.assertEquals(postOperativeICD10Entities.size(), updatedDiagnosesAndProceduresEntity.getPostOperativeICD10().size());

			Assertions.assertEquals(postOperativeICD9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getPostOperativeICD9CM().size());

			Assertions.assertEquals(preSurgeryICD10Entities.size(), updatedDiagnosesAndProceduresEntity.getPreSurgeryICD10().size());

			Assertions.assertEquals(preSurgeryICD9CMEntities.size(), updatedDiagnosesAndProceduresEntity.getPreSurgeryICD9CM().size());

			Assertions.assertEquals(diagnosisNandasEntities.size(), updatedDiagnosesAndProceduresEntity.getDiagnosisNandas().size());

		});
	}

	@Test
	public void whenCreateDiagnosesAndProceduresEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;
			Optional<DiagnosesAndProceduresEntity> fetchedDiagnosesAndProceduresEntity;

			try {
				diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosesAndProceduresEntity = diagnosesAndProceduresService.create(diagnosesAndProceduresEntity);

			fetchedDiagnosesAndProceduresEntity = diagnosesAndProceduresService.findById(diagnosesAndProceduresEntity.getId());

			Assertions.assertTrue(fetchedDiagnosesAndProceduresEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDiagnosesAndProceduresEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(diagnosesAndProceduresEntity, fetchedDiagnosesAndProceduresEntity.get());
		});
	}

	@Test
	public void whenUpdateDiagnosesAndProceduresEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;
			DiagnosesAndProceduresEntity updatedDiagnosesAndProceduresEntity;
			Optional<DiagnosesAndProceduresEntity> fetchedDiagnosesAndProceduresEntity;

			try {
				diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, false);
				updatedDiagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDiagnosesAndProceduresEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosesAndProceduresEntity = diagnosesAndProceduresService.create(diagnosesAndProceduresEntity);

			updatedDiagnosesAndProceduresEntity.setId(diagnosesAndProceduresEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDiagnosesAndProceduresEntity.setCreated(diagnosesAndProceduresEntity.getCreated());

			updatedDiagnosesAndProceduresEntity = diagnosesAndProceduresService.update(updatedDiagnosesAndProceduresEntity);

			fetchedDiagnosesAndProceduresEntity = diagnosesAndProceduresService.findById(diagnosesAndProceduresEntity.getId());

			Assertions.assertTrue(fetchedDiagnosesAndProceduresEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDiagnosesAndProceduresEntity_ThenEntityIsCreated
			fetchedDiagnosesAndProceduresEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDiagnosesAndProceduresEntity, fetchedDiagnosesAndProceduresEntity.get());
		});
	}

	@Test
	public void whenDeleteDiagnosesAndProceduresEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;
			Optional<DiagnosesAndProceduresEntity> fetchedDiagnosesAndProceduresEntity;

			try {
				diagnosesAndProceduresEntity = diagnosesAndProceduresFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosesAndProceduresEntity = diagnosesAndProceduresService.create(diagnosesAndProceduresEntity);

			diagnosesAndProceduresService.deleteById(diagnosesAndProceduresEntity.getId());
			fetchedDiagnosesAndProceduresEntity = diagnosesAndProceduresService.findById(diagnosesAndProceduresEntity.getId());

			Assertions.assertTrue(fetchedDiagnosesAndProceduresEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
