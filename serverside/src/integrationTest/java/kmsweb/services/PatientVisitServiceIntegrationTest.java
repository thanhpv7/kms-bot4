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
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.repositories.BpjsPcareRegistrationsRepository;
import kmsweb.utils.BpjsPcareRegistrationsFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcareRegistrationsDatabasePopulator;
import kmsweb.entities.BpjsVisitDataEntity;
import kmsweb.repositories.BpjsVisitDataRepository;
import kmsweb.utils.BpjsVisitDataFactory;
import kmsweb.utils.DatabasePopulators.BpjsVisitDataDatabasePopulator;
import kmsweb.entities.BpjsPcarePendaftaranEntity;
import kmsweb.repositories.BpjsPcarePendaftaranRepository;
import kmsweb.utils.BpjsPcarePendaftaranFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcarePendaftaranDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientVisitPatientPaymentInsuranceRepository;
import kmsweb.utils.PatientVisitPatientPaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitPatientPaymentInsuranceDatabasePopulator;
import kmsweb.entities.PatientVisitPatientPaymentOthersEntity;
import kmsweb.repositories.PatientVisitPatientPaymentOthersRepository;
import kmsweb.utils.PatientVisitPatientPaymentOthersFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitPatientPaymentOthersDatabasePopulator;
import kmsweb.entities.PatientVisitPaymentSelfPayingEntity;
import kmsweb.repositories.PatientVisitPaymentSelfPayingRepository;
import kmsweb.utils.PatientVisitPaymentSelfPayingFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitPaymentSelfPayingDatabasePopulator;
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
public class PatientVisitServiceIntegrationTest {

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PatientVisitService patientVisitService;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	@Autowired
	private BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository;

	@Autowired
	private BpjsPcareRegistrationsDatabasePopulator bpjsPcareRegistrationsDatabasePopulator;

	private final BpjsPcareRegistrationsFactory bpjsPcareRegistrationsFactory = new BpjsPcareRegistrationsFactory();

	@Autowired
	private BpjsVisitDataRepository bpjsVisitDataRepository;

	@Autowired
	private BpjsVisitDataDatabasePopulator bpjsVisitDataDatabasePopulator;

	private final BpjsVisitDataFactory bpjsVisitDataFactory = new BpjsVisitDataFactory();

	@Autowired
	private BpjsPcarePendaftaranRepository bpjsPcarePendaftaranRepository;

	@Autowired
	private BpjsPcarePendaftaranDatabasePopulator bpjsPcarePendaftaranDatabasePopulator;

	private final BpjsPcarePendaftaranFactory bpjsPcarePendaftaranFactory = new BpjsPcarePendaftaranFactory();

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();

	@Autowired
	private PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository;

	@Autowired
	private PatientVisitPatientPaymentInsuranceDatabasePopulator patientVisitPatientPaymentInsuranceDatabasePopulator;

	private final PatientVisitPatientPaymentInsuranceFactory patientVisitPatientPaymentInsuranceFactory = new PatientVisitPatientPaymentInsuranceFactory();

	@Autowired
	private PatientVisitPatientPaymentOthersRepository patientVisitPatientPaymentOthersRepository;

	@Autowired
	private PatientVisitPatientPaymentOthersDatabasePopulator patientVisitPatientPaymentOthersDatabasePopulator;

	private final PatientVisitPatientPaymentOthersFactory patientVisitPatientPaymentOthersFactory = new PatientVisitPatientPaymentOthersFactory();

	@Autowired
	private PatientVisitPaymentSelfPayingRepository patientVisitPaymentSelfPayingRepository;

	@Autowired
	private PatientVisitPaymentSelfPayingDatabasePopulator patientVisitPaymentSelfPayingDatabasePopulator;

	private final PatientVisitPaymentSelfPayingFactory patientVisitPaymentSelfPayingFactory = new PatientVisitPaymentSelfPayingFactory();

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
		patientVisitService = new PatientVisitService(
			bpjsPcareRegistrationsRepository,
			bpjsVisitDataRepository,
			bpjsPcarePendaftaranRepository,
			invoiceRepository,
			patientGeneralInfoRepository,
			patientVisitPatientPaymentInsuranceRepository,
			patientVisitPatientPaymentOthersRepository,
			patientVisitPaymentSelfPayingRepository,
			registrationRepository,
			validator,
			auditRepository,
			patientVisitRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPatientVisitEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PatientVisitEntity patientVisitEntity = patientVisitFactory.getObject(false, false);

		PatientVisitEntity updatedEntity = patientVisitService.updateOldData(patientVisitEntity);
		Assertions.assertEquals(patientVisitEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPatientVisitEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitEntity patientVisitEntity;
			PatientVisitEntity entityWithUpdatedValues;

			try {
				patientVisitEntity = patientVisitFactory.getObject(false, false);
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = patientVisitFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitEntity = patientVisitService.create(patientVisitEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(patientVisitEntity.getId());

			PatientVisitEntity updatedEntity = patientVisitService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPatientVisitEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PatientVisitEntity patientVisitEntity = patientVisitFactory.getObject(false, false);
		patientVisitEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			patientVisitService.updateOldData(patientVisitEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPatientVisitEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitEntity patientVisitEntity;
			PatientVisitEntity updatedPatientVisitEntity;

			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;

			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;

			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;

			PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPayingEntity;

			PatientGeneralInfoEntity patientEntity;

			Set<BpjsVisitDataEntity> bpjsVisitDatasEntities;

			Set<BpjsPcarePendaftaranEntity> bpjsPcarePendaftaransEntities;

			Set<InvoiceEntity> invoicesEntities;

			Set<RegistrationEntity> registrationsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientVisitEntity = patientVisitFactory.getObject(true, false);
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
			bpjsPcareRegistrationsEntity = patientVisitEntity.getBpjsPcareRegistrations();
			try {
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsRepository.save(bpjsPcareRegistrationsEntity);
			patientVisitEntity.setBpjsPcareRegistrationsId(bpjsPcareRegistrationsEntity.getId());

			patientVisitPatientPaymentInsuranceEntity = patientVisitEntity.getPatientVisitPatientPaymentInsurance();
			try {
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceRepository.save(patientVisitPatientPaymentInsuranceEntity);
			patientVisitEntity.setPatientVisitPatientPaymentInsuranceId(patientVisitPatientPaymentInsuranceEntity.getId());

			patientVisitPatientPaymentOthersEntity = patientVisitEntity.getPatientVisitPatientPaymentOthers();
			try {
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentOthersEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersRepository.save(patientVisitPatientPaymentOthersEntity);
			patientVisitEntity.setPatientVisitPatientPaymentOthersId(patientVisitPatientPaymentOthersEntity.getId());

			patientVisitPaymentSelfPayingEntity = patientVisitEntity.getPatientVisitPaymentSelfPaying();
			try {
				patientVisitPaymentSelfPayingDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPaymentSelfPayingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitPaymentSelfPayingEntity = patientVisitPaymentSelfPayingRepository.save(patientVisitPaymentSelfPayingEntity);
			patientVisitEntity.setPatientVisitPaymentSelfPayingId(patientVisitPaymentSelfPayingEntity.getId());

			patientEntity = patientVisitEntity.getPatient();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientEntity = patientGeneralInfoRepository.save(patientEntity);
			patientVisitEntity.setPatientId(patientEntity.getId());

			bpjsVisitDatasEntities = patientVisitEntity.getBpjsVisitDatas();
			Set<UUID> bpjsVisitDatasEntityIds = new HashSet<>();
			for (BpjsVisitDataEntity entity : bpjsVisitDatasEntities) {
				try {
					bpjsVisitDataDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsVisitDatasEntityIds.add(bpjsVisitDataRepository.save(entity).getId());
			}
			patientVisitEntity.setBpjsVisitDatasIds(bpjsVisitDatasEntityIds);

			bpjsPcarePendaftaransEntities = patientVisitEntity.getBpjsPcarePendaftarans();
			Set<UUID> bpjsPcarePendaftaransEntityIds = new HashSet<>();
			for (BpjsPcarePendaftaranEntity entity : bpjsPcarePendaftaransEntities) {
				try {
					bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsPcarePendaftaransEntityIds.add(bpjsPcarePendaftaranRepository.save(entity).getId());
			}
			patientVisitEntity.setBpjsPcarePendaftaransIds(bpjsPcarePendaftaransEntityIds);

			invoicesEntities = patientVisitEntity.getInvoices();
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
			patientVisitEntity.setInvoicesIds(invoicesEntityIds);

			registrationsEntities = patientVisitEntity.getRegistrations();
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
			patientVisitEntity.setRegistrationsIds(registrationsEntityIds);


			patientVisitEntity = patientVisitService.create(patientVisitEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(patientVisitEntity.getBpjsPcareRegistrations());
			patientVisitEntity.setBpjsPcareRegistrationsId(null);
			patientVisitEntity.unsetBpjsPcareRegistrations();

			Assertions.assertNotNull(patientVisitEntity.getPatientVisitPatientPaymentInsurance());
			patientVisitEntity.setPatientVisitPatientPaymentInsuranceId(null);
			patientVisitEntity.unsetPatientVisitPatientPaymentInsurance();

			Assertions.assertNotNull(patientVisitEntity.getPatientVisitPatientPaymentOthers());
			patientVisitEntity.setPatientVisitPatientPaymentOthersId(null);
			patientVisitEntity.unsetPatientVisitPatientPaymentOthers();

			Assertions.assertNotNull(patientVisitEntity.getPatientVisitPaymentSelfPaying());
			patientVisitEntity.setPatientVisitPaymentSelfPayingId(null);
			patientVisitEntity.unsetPatientVisitPaymentSelfPaying();

			Assertions.assertNotNull(patientVisitEntity.getPatient());
			patientVisitEntity.setPatientId(null);
			patientVisitEntity.unsetPatient();

			Assertions.assertTrue(patientVisitEntity.getBpjsVisitDatas().size() > 0);
			patientVisitEntity.setBpjsVisitDatasIds(new HashSet<UUID>());
			patientVisitEntity.unsetBpjsVisitDatas();

			Assertions.assertTrue(patientVisitEntity.getBpjsPcarePendaftarans().size() > 0);
			patientVisitEntity.setBpjsPcarePendaftaransIds(new HashSet<UUID>());
			patientVisitEntity.unsetBpjsPcarePendaftarans();

			Assertions.assertTrue(patientVisitEntity.getInvoices().size() > 0);
			patientVisitEntity.setInvoicesIds(new HashSet<UUID>());
			patientVisitEntity.unsetInvoices();

			Assertions.assertTrue(patientVisitEntity.getRegistrations().size() > 0);
			patientVisitEntity.setRegistrationsIds(new HashSet<UUID>());
			patientVisitEntity.unsetRegistrations();


			updatedPatientVisitEntity = patientVisitService.updateOldData(patientVisitEntity);

			Assertions.assertNull(updatedPatientVisitEntity.getBpjsPcareRegistrations());

			Assertions.assertNull(updatedPatientVisitEntity.getPatientVisitPatientPaymentInsurance());

			Assertions.assertNull(updatedPatientVisitEntity.getPatientVisitPatientPaymentOthers());

			Assertions.assertNull(updatedPatientVisitEntity.getPatientVisitPaymentSelfPaying());

			Assertions.assertNull(updatedPatientVisitEntity.getPatient());

			Assertions.assertEquals(0, updatedPatientVisitEntity.getBpjsVisitDatas().size());

			Assertions.assertEquals(0, updatedPatientVisitEntity.getBpjsPcarePendaftarans().size());

			Assertions.assertEquals(0, updatedPatientVisitEntity.getInvoices().size());

			Assertions.assertEquals(0, updatedPatientVisitEntity.getRegistrations().size());

		});
	}

	@Test
	public void updateOldDataWithPatientVisitEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitEntity patientVisitEntity;
			PatientVisitEntity updatedPatientVisitEntity;

			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;

			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;

			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;

			PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPayingEntity;

			PatientGeneralInfoEntity patientEntity;

			Set<BpjsVisitDataEntity> bpjsVisitDatasEntities;
			Set<UUID> bpjsVisitDatasEntityIds;

			Set<BpjsPcarePendaftaranEntity> bpjsPcarePendaftaransEntities;
			Set<UUID> bpjsPcarePendaftaransEntityIds;

			Set<InvoiceEntity> invoicesEntities;
			Set<UUID> invoicesEntityIds;

			Set<RegistrationEntity> registrationsEntities;
			Set<UUID> registrationsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientVisitEntity = patientVisitFactory.getObject(true, false);
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
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity.getBpjsPcareRegistrations(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Pcare Registrations relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsRepository.findById(bpjsPcareRegistrationsRepository.save(patientVisitEntity.getBpjsPcareRegistrations()).getId()).get();
			patientVisitEntity.unsetBpjsPcareRegistrations();
			patientVisitEntity.setBpjsPcareRegistrationsId(bpjsPcareRegistrationsEntity.getId());

			try {
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity.getPatientVisitPatientPaymentInsurance(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit Patient Payment Insurance relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceRepository.findById(patientVisitPatientPaymentInsuranceRepository.save(patientVisitEntity.getPatientVisitPatientPaymentInsurance()).getId()).get();
			patientVisitEntity.unsetPatientVisitPatientPaymentInsurance();
			patientVisitEntity.setPatientVisitPatientPaymentInsuranceId(patientVisitPatientPaymentInsuranceEntity.getId());

			try {
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity.getPatientVisitPatientPaymentOthers(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit Patient Payment Others relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersRepository.findById(patientVisitPatientPaymentOthersRepository.save(patientVisitEntity.getPatientVisitPatientPaymentOthers()).getId()).get();
			patientVisitEntity.unsetPatientVisitPatientPaymentOthers();
			patientVisitEntity.setPatientVisitPatientPaymentOthersId(patientVisitPatientPaymentOthersEntity.getId());

			try {
				patientVisitPaymentSelfPayingDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity.getPatientVisitPaymentSelfPaying(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit Payment Self Paying relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitPaymentSelfPayingEntity = patientVisitPaymentSelfPayingRepository.findById(patientVisitPaymentSelfPayingRepository.save(patientVisitEntity.getPatientVisitPaymentSelfPaying()).getId()).get();
			patientVisitEntity.unsetPatientVisitPaymentSelfPaying();
			patientVisitEntity.setPatientVisitPaymentSelfPayingId(patientVisitPaymentSelfPayingEntity.getId());

			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity.getPatient(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(patientVisitEntity.getPatient()).getId()).get();
			patientVisitEntity.unsetPatient();
			patientVisitEntity.setPatientId(patientEntity.getId());

			bpjsVisitDatasEntities = new HashSet<>();
			bpjsVisitDatasEntityIds = new HashSet<>();
			for (BpjsVisitDataEntity entity : patientVisitEntity.getBpjsVisitDatas()) {
				try {
					bpjsVisitDataDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Visit Datas relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsVisitDataRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsVisitDatasEntities.add(bpjsVisitDataRepository.findById(id).get());
				bpjsVisitDatasEntityIds.add(id);
			}
			patientVisitEntity.unsetBpjsVisitDatas();
			patientVisitEntity.setBpjsVisitDatasIds(bpjsVisitDatasEntityIds);

			bpjsPcarePendaftaransEntities = new HashSet<>();
			bpjsPcarePendaftaransEntityIds = new HashSet<>();
			for (BpjsPcarePendaftaranEntity entity : patientVisitEntity.getBpjsPcarePendaftarans()) {
				try {
					bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Bpjs Pcare Pendaftarans relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsPcarePendaftaranRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsPcarePendaftaransEntities.add(bpjsPcarePendaftaranRepository.findById(id).get());
				bpjsPcarePendaftaransEntityIds.add(id);
			}
			patientVisitEntity.unsetBpjsPcarePendaftarans();
			patientVisitEntity.setBpjsPcarePendaftaransIds(bpjsPcarePendaftaransEntityIds);

			invoicesEntities = new HashSet<>();
			invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : patientVisitEntity.getInvoices()) {
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
			patientVisitEntity.unsetInvoices();
			patientVisitEntity.setInvoicesIds(invoicesEntityIds);

			registrationsEntities = new HashSet<>();
			registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : patientVisitEntity.getRegistrations()) {
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
			patientVisitEntity.unsetRegistrations();
			patientVisitEntity.setRegistrationsIds(registrationsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPatientVisitEntity = patientVisitService.updateOldData(patientVisitEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			bpjsPcareRegistrationsEntity.unsetPatientVisit(false);
			updatedPatientVisitEntity.getBpjsPcareRegistrations().unsetPatientVisit(false);
			Assertions.assertEquals(bpjsPcareRegistrationsEntity, updatedPatientVisitEntity.getBpjsPcareRegistrations());

			patientVisitPatientPaymentInsuranceEntity.unsetPatientVisit(false);
			updatedPatientVisitEntity.getPatientVisitPatientPaymentInsurance().unsetPatientVisit(false);
			Assertions.assertEquals(patientVisitPatientPaymentInsuranceEntity, updatedPatientVisitEntity.getPatientVisitPatientPaymentInsurance());

			patientVisitPatientPaymentOthersEntity.unsetPatientVisit(false);
			updatedPatientVisitEntity.getPatientVisitPatientPaymentOthers().unsetPatientVisit(false);
			Assertions.assertEquals(patientVisitPatientPaymentOthersEntity, updatedPatientVisitEntity.getPatientVisitPatientPaymentOthers());

			patientVisitPaymentSelfPayingEntity.unsetPatientVisit(false);
			updatedPatientVisitEntity.getPatientVisitPaymentSelfPaying().unsetPatientVisit(false);
			Assertions.assertEquals(patientVisitPaymentSelfPayingEntity, updatedPatientVisitEntity.getPatientVisitPaymentSelfPaying());

			patientEntity.unsetVisits(false);
			updatedPatientVisitEntity.getPatient().unsetVisits(false);
			Assertions.assertEquals(patientEntity, updatedPatientVisitEntity.getPatient());

			Assertions.assertEquals(bpjsVisitDatasEntities.size(), updatedPatientVisitEntity.getBpjsVisitDatas().size());

			Assertions.assertEquals(bpjsPcarePendaftaransEntities.size(), updatedPatientVisitEntity.getBpjsPcarePendaftarans().size());

			Assertions.assertEquals(invoicesEntities.size(), updatedPatientVisitEntity.getInvoices().size());

			Assertions.assertEquals(registrationsEntities.size(), updatedPatientVisitEntity.getRegistrations().size());

		});
	}

	@Test
	public void whenCreatePatientVisitEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitEntity patientVisitEntity;
			Optional<PatientVisitEntity> fetchedPatientVisitEntity;

			try {
				patientVisitEntity = patientVisitFactory.getObject(false, false);
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitEntity = patientVisitService.create(patientVisitEntity);

			fetchedPatientVisitEntity = patientVisitService.findById(patientVisitEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPatientVisitEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(patientVisitEntity, fetchedPatientVisitEntity.get());
		});
	}

	@Test
	public void whenUpdatePatientVisitEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitEntity patientVisitEntity;
			PatientVisitEntity updatedPatientVisitEntity;
			Optional<PatientVisitEntity> fetchedPatientVisitEntity;

			try {
				patientVisitEntity = patientVisitFactory.getObject(false, false);
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, false);
				updatedPatientVisitEntity = patientVisitFactory.getObject(false, false);
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPatientVisitEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitEntity = patientVisitService.create(patientVisitEntity);

			updatedPatientVisitEntity.setId(patientVisitEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPatientVisitEntity.setCreated(patientVisitEntity.getCreated());

			updatedPatientVisitEntity = patientVisitService.update(updatedPatientVisitEntity);

			fetchedPatientVisitEntity = patientVisitService.findById(patientVisitEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePatientVisitEntity_ThenEntityIsCreated
			fetchedPatientVisitEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPatientVisitEntity, fetchedPatientVisitEntity.get());
		});
	}

	@Test
	public void whenDeletePatientVisitEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitEntity patientVisitEntity;
			Optional<PatientVisitEntity> fetchedPatientVisitEntity;

			try {
				patientVisitEntity = patientVisitFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitEntity = patientVisitService.create(patientVisitEntity);

			patientVisitService.deleteById(patientVisitEntity.getId());
			fetchedPatientVisitEntity = patientVisitService.findById(patientVisitEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
