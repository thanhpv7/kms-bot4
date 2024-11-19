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
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.utils.CashReceiptFactory;
import kmsweb.utils.DatabasePopulators.CashReceiptDatabasePopulator;
import kmsweb.entities.CashRefundEntity;
import kmsweb.repositories.CashRefundRepository;
import kmsweb.utils.CashRefundFactory;
import kmsweb.utils.DatabasePopulators.CashRefundDatabasePopulator;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.utils.InformedConsentFactory;
import kmsweb.utils.DatabasePopulators.InformedConsentDatabasePopulator;
import kmsweb.entities.PatientCaseHistoryEntity;
import kmsweb.repositories.PatientCaseHistoryRepository;
import kmsweb.utils.PatientCaseHistoryFactory;
import kmsweb.utils.DatabasePopulators.PatientCaseHistoryDatabasePopulator;
import kmsweb.entities.PatientConsentEntity;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.utils.PatientConsentFactory;
import kmsweb.utils.DatabasePopulators.PatientConsentDatabasePopulator;
import kmsweb.entities.PatientContactInfoEntity;
import kmsweb.repositories.PatientContactInfoRepository;
import kmsweb.utils.PatientContactInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientContactInfoDatabasePopulator;
import kmsweb.entities.PatientDetailEntity;
import kmsweb.repositories.PatientDetailRepository;
import kmsweb.utils.PatientDetailFactory;
import kmsweb.utils.DatabasePopulators.PatientDetailDatabasePopulator;
import kmsweb.entities.PatientDetailAddressEntity;
import kmsweb.repositories.PatientDetailAddressRepository;
import kmsweb.utils.PatientDetailAddressFactory;
import kmsweb.utils.DatabasePopulators.PatientDetailAddressDatabasePopulator;
import kmsweb.entities.PatientEmergencyContactDetailEntity;
import kmsweb.repositories.PatientEmergencyContactDetailRepository;
import kmsweb.utils.PatientEmergencyContactDetailFactory;
import kmsweb.utils.DatabasePopulators.PatientEmergencyContactDetailDatabasePopulator;
import kmsweb.entities.PatientEmploymentDetailEntity;
import kmsweb.repositories.PatientEmploymentDetailRepository;
import kmsweb.utils.PatientEmploymentDetailFactory;
import kmsweb.utils.DatabasePopulators.PatientEmploymentDetailDatabasePopulator;
import kmsweb.entities.PatientPaymentSelfPayingEntity;
import kmsweb.repositories.PatientPaymentSelfPayingRepository;
import kmsweb.utils.PatientPaymentSelfPayingFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentSelfPayingDatabasePopulator;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;
import kmsweb.utils.PatientPaymentBPJSFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentBPJSDatabasePopulator;
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientPaymentInsuranceRepository;
import kmsweb.utils.PatientPaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentInsuranceDatabasePopulator;
import kmsweb.entities.PatientPaymentOthersEntity;
import kmsweb.repositories.PatientPaymentOthersRepository;
import kmsweb.utils.PatientPaymentOthersFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentOthersDatabasePopulator;
import kmsweb.entities.PatientPersonalInfoEntity;
import kmsweb.repositories.PatientPersonalInfoRepository;
import kmsweb.utils.PatientPersonalInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientPersonalInfoDatabasePopulator;
import kmsweb.entities.PatientSupportingDocumentEntity;
import kmsweb.repositories.PatientSupportingDocumentRepository;
import kmsweb.utils.PatientSupportingDocumentFactory;
import kmsweb.utils.DatabasePopulators.PatientSupportingDocumentDatabasePopulator;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.utils.RetailPharmacyFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyDatabasePopulator;
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
public class PatientGeneralInfoServiceIntegrationTest {

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PatientGeneralInfoService patientGeneralInfoService;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private CashReceiptRepository cashReceiptRepository;

	@Autowired
	private CashReceiptDatabasePopulator cashReceiptDatabasePopulator;

	private final CashReceiptFactory cashReceiptFactory = new CashReceiptFactory();

	@Autowired
	private CashRefundRepository cashRefundRepository;

	@Autowired
	private CashRefundDatabasePopulator cashRefundDatabasePopulator;

	private final CashRefundFactory cashRefundFactory = new CashRefundFactory();

	@Autowired
	private InformedConsentRepository informedConsentRepository;

	@Autowired
	private InformedConsentDatabasePopulator informedConsentDatabasePopulator;

	private final InformedConsentFactory informedConsentFactory = new InformedConsentFactory();

	@Autowired
	private PatientCaseHistoryRepository patientCaseHistoryRepository;

	@Autowired
	private PatientCaseHistoryDatabasePopulator patientCaseHistoryDatabasePopulator;

	private final PatientCaseHistoryFactory patientCaseHistoryFactory = new PatientCaseHistoryFactory();

	@Autowired
	private PatientConsentRepository patientConsentRepository;

	@Autowired
	private PatientConsentDatabasePopulator patientConsentDatabasePopulator;

	private final PatientConsentFactory patientConsentFactory = new PatientConsentFactory();

	@Autowired
	private PatientContactInfoRepository patientContactInfoRepository;

	@Autowired
	private PatientContactInfoDatabasePopulator patientContactInfoDatabasePopulator;

	private final PatientContactInfoFactory patientContactInfoFactory = new PatientContactInfoFactory();

	@Autowired
	private PatientDetailRepository patientDetailRepository;

	@Autowired
	private PatientDetailDatabasePopulator patientDetailDatabasePopulator;

	private final PatientDetailFactory patientDetailFactory = new PatientDetailFactory();

	@Autowired
	private PatientDetailAddressRepository patientDetailAddressRepository;

	@Autowired
	private PatientDetailAddressDatabasePopulator patientDetailAddressDatabasePopulator;

	private final PatientDetailAddressFactory patientDetailAddressFactory = new PatientDetailAddressFactory();

	@Autowired
	private PatientEmergencyContactDetailRepository patientEmergencyContactDetailRepository;

	@Autowired
	private PatientEmergencyContactDetailDatabasePopulator patientEmergencyContactDetailDatabasePopulator;

	private final PatientEmergencyContactDetailFactory patientEmergencyContactDetailFactory = new PatientEmergencyContactDetailFactory();

	@Autowired
	private PatientEmploymentDetailRepository patientEmploymentDetailRepository;

	@Autowired
	private PatientEmploymentDetailDatabasePopulator patientEmploymentDetailDatabasePopulator;

	private final PatientEmploymentDetailFactory patientEmploymentDetailFactory = new PatientEmploymentDetailFactory();

	@Autowired
	private PatientPaymentSelfPayingRepository patientPaymentSelfPayingRepository;

	@Autowired
	private PatientPaymentSelfPayingDatabasePopulator patientPaymentSelfPayingDatabasePopulator;

	private final PatientPaymentSelfPayingFactory patientPaymentSelfPayingFactory = new PatientPaymentSelfPayingFactory();

	@Autowired
	private PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	@Autowired
	private PatientPaymentBPJSDatabasePopulator patientPaymentBPJSDatabasePopulator;

	private final PatientPaymentBPJSFactory patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();

	@Autowired
	private PatientPaymentInsuranceRepository patientPaymentInsuranceRepository;

	@Autowired
	private PatientPaymentInsuranceDatabasePopulator patientPaymentInsuranceDatabasePopulator;

	private final PatientPaymentInsuranceFactory patientPaymentInsuranceFactory = new PatientPaymentInsuranceFactory();

	@Autowired
	private PatientPaymentOthersRepository patientPaymentOthersRepository;

	@Autowired
	private PatientPaymentOthersDatabasePopulator patientPaymentOthersDatabasePopulator;

	private final PatientPaymentOthersFactory patientPaymentOthersFactory = new PatientPaymentOthersFactory();

	@Autowired
	private PatientPersonalInfoRepository patientPersonalInfoRepository;

	@Autowired
	private PatientPersonalInfoDatabasePopulator patientPersonalInfoDatabasePopulator;

	private final PatientPersonalInfoFactory patientPersonalInfoFactory = new PatientPersonalInfoFactory();

	@Autowired
	private PatientSupportingDocumentRepository patientSupportingDocumentRepository;

	@Autowired
	private PatientSupportingDocumentDatabasePopulator patientSupportingDocumentDatabasePopulator;

	private final PatientSupportingDocumentFactory patientSupportingDocumentFactory = new PatientSupportingDocumentFactory();

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();

	@Autowired
	private RetailPharmacyRepository retailPharmacyRepository;

	@Autowired
	private RetailPharmacyDatabasePopulator retailPharmacyDatabasePopulator;

	private final RetailPharmacyFactory retailPharmacyFactory = new RetailPharmacyFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		patientGeneralInfoService = new PatientGeneralInfoService(
			bpjsClaimSubmissionRepository,
			cashReceiptRepository,
			cashRefundRepository,
			informedConsentRepository,
			patientCaseHistoryRepository,
			patientConsentRepository,
			patientContactInfoRepository,
			patientDetailRepository,
			patientDetailAddressRepository,
			patientEmergencyContactDetailRepository,
			patientEmploymentDetailRepository,
			patientPaymentSelfPayingRepository,
			patientPaymentBPJSRepository,
			patientPaymentInsuranceRepository,
			patientPaymentOthersRepository,
			patientPersonalInfoRepository,
			patientSupportingDocumentRepository,
			patientVisitRepository,
			retailPharmacyRepository,
			validator,
			auditRepository,
			patientGeneralInfoRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPatientGeneralInfoEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PatientGeneralInfoEntity patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);

		PatientGeneralInfoEntity updatedEntity = patientGeneralInfoService.updateOldData(patientGeneralInfoEntity);
		Assertions.assertEquals(patientGeneralInfoEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPatientGeneralInfoEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PatientGeneralInfoEntity patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);

		patientGeneralInfoEntity.setHasOutstandingPayment(null);
		Assertions.assertNull(patientGeneralInfoEntity.getHasOutstandingPayment());


		PatientGeneralInfoEntity updatedEntity = patientGeneralInfoService.updateOldData(patientGeneralInfoEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getHasOutstandingPayment());
		Assertions.assertFalse(updatedEntity.getHasOutstandingPayment());

	}

	@Test
	public void updateOldDataWithExistingPatientGeneralInfoEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PatientGeneralInfoEntity patientGeneralInfoEntity;
			PatientGeneralInfoEntity entityWithUpdatedValues;

			try {
				patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = patientGeneralInfoFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientGeneralInfoEntity = patientGeneralInfoService.create(patientGeneralInfoEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(patientGeneralInfoEntity.getId());

			PatientGeneralInfoEntity updatedEntity = patientGeneralInfoService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPatientGeneralInfoEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PatientGeneralInfoEntity patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);
		patientGeneralInfoEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			patientGeneralInfoService.updateOldData(patientGeneralInfoEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPatientGeneralInfoEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientGeneralInfoEntity patientGeneralInfoEntity;
			PatientGeneralInfoEntity updatedPatientGeneralInfoEntity;

			PatientContactInfoEntity patientContactInformationEntity;

			PatientDetailAddressEntity patientDetailAddressEntity;

			PatientDetailEntity patientDetailEntity;

			PatientEmergencyContactDetailEntity patientEmergencyContactDetailEntity;

			PatientEmploymentDetailEntity patientEmploymentDetailEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			PatientPaymentInsuranceEntity patientPaymentTypeInsuranceEntity;

			PatientPaymentOthersEntity patientPaymentTypeOthersEntity;

			PatientPersonalInfoEntity patientPersonalInformationEntity;

			PatientPaymentSelfPayingEntity patientSelfPayingEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<CashRefundEntity> cashRefundsEntities;

			Set<InformedConsentEntity> informedConsentsEntities;

			Set<CashReceiptEntity> invoiceReceiptsEntities;

			Set<PatientCaseHistoryEntity> patientCaseHistoriesEntities;

			Set<PatientConsentEntity> patientConsentsEntities;

			Set<PatientSupportingDocumentEntity> patientFinalizeProfilesEntities;

			Set<RetailPharmacyEntity> retailPharmaciesEntities;

			Set<PatientVisitEntity> visitsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(true, false);
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
			patientContactInformationEntity = patientGeneralInfoEntity.getPatientContactInformation();
			try {
				patientContactInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientContactInformationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientContactInformationEntity = patientContactInfoRepository.save(patientContactInformationEntity);
			patientGeneralInfoEntity.setPatientContactInformationId(patientContactInformationEntity.getId());

			patientDetailAddressEntity = patientGeneralInfoEntity.getPatientDetailAddress();
			try {
				patientDetailAddressDatabasePopulator.populateRelatedEntitiesInDatabase(patientDetailAddressEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientDetailAddressEntity = patientDetailAddressRepository.save(patientDetailAddressEntity);
			patientGeneralInfoEntity.setPatientDetailAddressId(patientDetailAddressEntity.getId());

			patientDetailEntity = patientGeneralInfoEntity.getPatientDetail();
			try {
				patientDetailDatabasePopulator.populateRelatedEntitiesInDatabase(patientDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientDetailEntity = patientDetailRepository.save(patientDetailEntity);
			patientGeneralInfoEntity.setPatientDetailId(patientDetailEntity.getId());

			patientEmergencyContactDetailEntity = patientGeneralInfoEntity.getPatientEmergencyContactDetail();
			try {
				patientEmergencyContactDetailDatabasePopulator.populateRelatedEntitiesInDatabase(patientEmergencyContactDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientEmergencyContactDetailEntity = patientEmergencyContactDetailRepository.save(patientEmergencyContactDetailEntity);
			patientGeneralInfoEntity.setPatientEmergencyContactDetailId(patientEmergencyContactDetailEntity.getId());

			patientEmploymentDetailEntity = patientGeneralInfoEntity.getPatientEmploymentDetail();
			try {
				patientEmploymentDetailDatabasePopulator.populateRelatedEntitiesInDatabase(patientEmploymentDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientEmploymentDetailEntity = patientEmploymentDetailRepository.save(patientEmploymentDetailEntity);
			patientGeneralInfoEntity.setPatientEmploymentDetailId(patientEmploymentDetailEntity.getId());

			patientPaymentBPJSEntity = patientGeneralInfoEntity.getPatientPaymentBPJS();
			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.save(patientPaymentBPJSEntity);
			patientGeneralInfoEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			patientPaymentTypeInsuranceEntity = patientGeneralInfoEntity.getPatientPaymentTypeInsurance();
			try {
				patientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentTypeInsuranceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentTypeInsuranceEntity = patientPaymentInsuranceRepository.save(patientPaymentTypeInsuranceEntity);
			patientGeneralInfoEntity.setPatientPaymentTypeInsuranceId(patientPaymentTypeInsuranceEntity.getId());

			patientPaymentTypeOthersEntity = patientGeneralInfoEntity.getPatientPaymentTypeOthers();
			try {
				patientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentTypeOthersEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentTypeOthersEntity = patientPaymentOthersRepository.save(patientPaymentTypeOthersEntity);
			patientGeneralInfoEntity.setPatientPaymentTypeOthersId(patientPaymentTypeOthersEntity.getId());

			patientPersonalInformationEntity = patientGeneralInfoEntity.getPatientPersonalInformation();
			try {
				patientPersonalInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientPersonalInformationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPersonalInformationEntity = patientPersonalInfoRepository.save(patientPersonalInformationEntity);
			patientGeneralInfoEntity.setPatientPersonalInformationId(patientPersonalInformationEntity.getId());

			patientSelfPayingEntity = patientGeneralInfoEntity.getPatientSelfPaying();
			try {
				patientPaymentSelfPayingDatabasePopulator.populateRelatedEntitiesInDatabase(patientSelfPayingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientSelfPayingEntity = patientPaymentSelfPayingRepository.save(patientSelfPayingEntity);
			patientGeneralInfoEntity.setPatientSelfPayingId(patientSelfPayingEntity.getId());

			bpjsClaimSubmissionsEntities = patientGeneralInfoEntity.getBpjsClaimSubmissions();
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
			patientGeneralInfoEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			cashRefundsEntities = patientGeneralInfoEntity.getCashRefunds();
			Set<UUID> cashRefundsEntityIds = new HashSet<>();
			for (CashRefundEntity entity : cashRefundsEntities) {
				try {
					cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				cashRefundsEntityIds.add(cashRefundRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setCashRefundsIds(cashRefundsEntityIds);

			informedConsentsEntities = patientGeneralInfoEntity.getInformedConsents();
			Set<UUID> informedConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : informedConsentsEntities) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				informedConsentsEntityIds.add(informedConsentRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setInformedConsentsIds(informedConsentsEntityIds);

			invoiceReceiptsEntities = patientGeneralInfoEntity.getInvoiceReceipts();
			Set<UUID> invoiceReceiptsEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : invoiceReceiptsEntities) {
				try {
					cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceReceiptsEntityIds.add(cashReceiptRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setInvoiceReceiptsIds(invoiceReceiptsEntityIds);

			patientCaseHistoriesEntities = patientGeneralInfoEntity.getPatientCaseHistories();
			Set<UUID> patientCaseHistoriesEntityIds = new HashSet<>();
			for (PatientCaseHistoryEntity entity : patientCaseHistoriesEntities) {
				try {
					patientCaseHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientCaseHistoriesEntityIds.add(patientCaseHistoryRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setPatientCaseHistoriesIds(patientCaseHistoriesEntityIds);

			patientConsentsEntities = patientGeneralInfoEntity.getPatientConsents();
			Set<UUID> patientConsentsEntityIds = new HashSet<>();
			for (PatientConsentEntity entity : patientConsentsEntities) {
				try {
					patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientConsentsEntityIds.add(patientConsentRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setPatientConsentsIds(patientConsentsEntityIds);

			patientFinalizeProfilesEntities = patientGeneralInfoEntity.getPatientFinalizeProfiles();
			Set<UUID> patientFinalizeProfilesEntityIds = new HashSet<>();
			for (PatientSupportingDocumentEntity entity : patientFinalizeProfilesEntities) {
				try {
					patientSupportingDocumentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientFinalizeProfilesEntityIds.add(patientSupportingDocumentRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setPatientFinalizeProfilesIds(patientFinalizeProfilesEntityIds);

			retailPharmaciesEntities = patientGeneralInfoEntity.getRetailPharmacies();
			Set<UUID> retailPharmaciesEntityIds = new HashSet<>();
			for (RetailPharmacyEntity entity : retailPharmaciesEntities) {
				try {
					retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				retailPharmaciesEntityIds.add(retailPharmacyRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setRetailPharmaciesIds(retailPharmaciesEntityIds);

			visitsEntities = patientGeneralInfoEntity.getVisits();
			Set<UUID> visitsEntityIds = new HashSet<>();
			for (PatientVisitEntity entity : visitsEntities) {
				try {
					patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				visitsEntityIds.add(patientVisitRepository.save(entity).getId());
			}
			patientGeneralInfoEntity.setVisitsIds(visitsEntityIds);


			patientGeneralInfoEntity = patientGeneralInfoService.create(patientGeneralInfoEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientContactInformation());
			patientGeneralInfoEntity.setPatientContactInformationId(null);
			patientGeneralInfoEntity.unsetPatientContactInformation();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientDetailAddress());
			patientGeneralInfoEntity.setPatientDetailAddressId(null);
			patientGeneralInfoEntity.unsetPatientDetailAddress();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientDetail());
			patientGeneralInfoEntity.setPatientDetailId(null);
			patientGeneralInfoEntity.unsetPatientDetail();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientEmergencyContactDetail());
			patientGeneralInfoEntity.setPatientEmergencyContactDetailId(null);
			patientGeneralInfoEntity.unsetPatientEmergencyContactDetail();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientEmploymentDetail());
			patientGeneralInfoEntity.setPatientEmploymentDetailId(null);
			patientGeneralInfoEntity.unsetPatientEmploymentDetail();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientPaymentBPJS());
			patientGeneralInfoEntity.setPatientPaymentBPJSId(null);
			patientGeneralInfoEntity.unsetPatientPaymentBPJS();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientPaymentTypeInsurance());
			patientGeneralInfoEntity.setPatientPaymentTypeInsuranceId(null);
			patientGeneralInfoEntity.unsetPatientPaymentTypeInsurance();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientPaymentTypeOthers());
			patientGeneralInfoEntity.setPatientPaymentTypeOthersId(null);
			patientGeneralInfoEntity.unsetPatientPaymentTypeOthers();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientPersonalInformation());
			patientGeneralInfoEntity.setPatientPersonalInformationId(null);
			patientGeneralInfoEntity.unsetPatientPersonalInformation();

			Assertions.assertNotNull(patientGeneralInfoEntity.getPatientSelfPaying());
			patientGeneralInfoEntity.setPatientSelfPayingId(null);
			patientGeneralInfoEntity.unsetPatientSelfPaying();

			Assertions.assertTrue(patientGeneralInfoEntity.getBpjsClaimSubmissions().size() > 0);
			patientGeneralInfoEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(patientGeneralInfoEntity.getCashRefunds().size() > 0);
			patientGeneralInfoEntity.setCashRefundsIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetCashRefunds();

			Assertions.assertTrue(patientGeneralInfoEntity.getInformedConsents().size() > 0);
			patientGeneralInfoEntity.setInformedConsentsIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetInformedConsents();

			Assertions.assertTrue(patientGeneralInfoEntity.getInvoiceReceipts().size() > 0);
			patientGeneralInfoEntity.setInvoiceReceiptsIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetInvoiceReceipts();

			Assertions.assertTrue(patientGeneralInfoEntity.getPatientCaseHistories().size() > 0);
			patientGeneralInfoEntity.setPatientCaseHistoriesIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetPatientCaseHistories();

			Assertions.assertTrue(patientGeneralInfoEntity.getPatientConsents().size() > 0);
			patientGeneralInfoEntity.setPatientConsentsIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetPatientConsents();

			Assertions.assertTrue(patientGeneralInfoEntity.getPatientFinalizeProfiles().size() > 0);
			patientGeneralInfoEntity.setPatientFinalizeProfilesIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetPatientFinalizeProfiles();

			Assertions.assertTrue(patientGeneralInfoEntity.getRetailPharmacies().size() > 0);
			patientGeneralInfoEntity.setRetailPharmaciesIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetRetailPharmacies();

			Assertions.assertTrue(patientGeneralInfoEntity.getVisits().size() > 0);
			patientGeneralInfoEntity.setVisitsIds(new HashSet<UUID>());
			patientGeneralInfoEntity.unsetVisits();


			updatedPatientGeneralInfoEntity = patientGeneralInfoService.updateOldData(patientGeneralInfoEntity);

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientContactInformation());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientDetailAddress());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientDetail());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientEmergencyContactDetail());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientEmploymentDetail());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientPaymentBPJS());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientPaymentTypeInsurance());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientPaymentTypeOthers());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientPersonalInformation());

			Assertions.assertNull(updatedPatientGeneralInfoEntity.getPatientSelfPaying());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getCashRefunds().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getInformedConsents().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getInvoiceReceipts().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getPatientCaseHistories().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getPatientConsents().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getPatientFinalizeProfiles().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getRetailPharmacies().size());

			Assertions.assertEquals(0, updatedPatientGeneralInfoEntity.getVisits().size());

		});
	}

	@Test
	public void updateOldDataWithPatientGeneralInfoEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientGeneralInfoEntity patientGeneralInfoEntity;
			PatientGeneralInfoEntity updatedPatientGeneralInfoEntity;

			PatientContactInfoEntity patientContactInformationEntity;

			PatientDetailAddressEntity patientDetailAddressEntity;

			PatientDetailEntity patientDetailEntity;

			PatientEmergencyContactDetailEntity patientEmergencyContactDetailEntity;

			PatientEmploymentDetailEntity patientEmploymentDetailEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			PatientPaymentInsuranceEntity patientPaymentTypeInsuranceEntity;

			PatientPaymentOthersEntity patientPaymentTypeOthersEntity;

			PatientPersonalInfoEntity patientPersonalInformationEntity;

			PatientPaymentSelfPayingEntity patientSelfPayingEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<CashRefundEntity> cashRefundsEntities;
			Set<UUID> cashRefundsEntityIds;

			Set<InformedConsentEntity> informedConsentsEntities;
			Set<UUID> informedConsentsEntityIds;

			Set<CashReceiptEntity> invoiceReceiptsEntities;
			Set<UUID> invoiceReceiptsEntityIds;

			Set<PatientCaseHistoryEntity> patientCaseHistoriesEntities;
			Set<UUID> patientCaseHistoriesEntityIds;

			Set<PatientConsentEntity> patientConsentsEntities;
			Set<UUID> patientConsentsEntityIds;

			Set<PatientSupportingDocumentEntity> patientFinalizeProfilesEntities;
			Set<UUID> patientFinalizeProfilesEntityIds;

			Set<RetailPharmacyEntity> retailPharmaciesEntities;
			Set<UUID> retailPharmaciesEntityIds;

			Set<PatientVisitEntity> visitsEntities;
			Set<UUID> visitsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(true, false);
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
				patientContactInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientContactInformation(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Contact Information relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientContactInformationEntity = patientContactInfoRepository.findById(patientContactInfoRepository.save(patientGeneralInfoEntity.getPatientContactInformation()).getId()).get();
			patientGeneralInfoEntity.unsetPatientContactInformation();
			patientGeneralInfoEntity.setPatientContactInformationId(patientContactInformationEntity.getId());

			try {
				patientDetailAddressDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientDetailAddress(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Detail Address relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientDetailAddressEntity = patientDetailAddressRepository.findById(patientDetailAddressRepository.save(patientGeneralInfoEntity.getPatientDetailAddress()).getId()).get();
			patientGeneralInfoEntity.unsetPatientDetailAddress();
			patientGeneralInfoEntity.setPatientDetailAddressId(patientDetailAddressEntity.getId());

			try {
				patientDetailDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientDetailEntity = patientDetailRepository.findById(patientDetailRepository.save(patientGeneralInfoEntity.getPatientDetail()).getId()).get();
			patientGeneralInfoEntity.unsetPatientDetail();
			patientGeneralInfoEntity.setPatientDetailId(patientDetailEntity.getId());

			try {
				patientEmergencyContactDetailDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientEmergencyContactDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Emergency Contact Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientEmergencyContactDetailEntity = patientEmergencyContactDetailRepository.findById(patientEmergencyContactDetailRepository.save(patientGeneralInfoEntity.getPatientEmergencyContactDetail()).getId()).get();
			patientGeneralInfoEntity.unsetPatientEmergencyContactDetail();
			patientGeneralInfoEntity.setPatientEmergencyContactDetailId(patientEmergencyContactDetailEntity.getId());

			try {
				patientEmploymentDetailDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientEmploymentDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Employment Detail  relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientEmploymentDetailEntity = patientEmploymentDetailRepository.findById(patientEmploymentDetailRepository.save(patientGeneralInfoEntity.getPatientEmploymentDetail()).getId()).get();
			patientGeneralInfoEntity.unsetPatientEmploymentDetail();
			patientGeneralInfoEntity.setPatientEmploymentDetailId(patientEmploymentDetailEntity.getId());

			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientPaymentBPJS(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment BPJS relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.findById(patientPaymentBPJSRepository.save(patientGeneralInfoEntity.getPatientPaymentBPJS()).getId()).get();
			patientGeneralInfoEntity.unsetPatientPaymentBPJS();
			patientGeneralInfoEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			try {
				patientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientPaymentTypeInsurance(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment Type Insurance relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentTypeInsuranceEntity = patientPaymentInsuranceRepository.findById(patientPaymentInsuranceRepository.save(patientGeneralInfoEntity.getPatientPaymentTypeInsurance()).getId()).get();
			patientGeneralInfoEntity.unsetPatientPaymentTypeInsurance();
			patientGeneralInfoEntity.setPatientPaymentTypeInsuranceId(patientPaymentTypeInsuranceEntity.getId());

			try {
				patientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientPaymentTypeOthers(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment Type Others relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentTypeOthersEntity = patientPaymentOthersRepository.findById(patientPaymentOthersRepository.save(patientGeneralInfoEntity.getPatientPaymentTypeOthers()).getId()).get();
			patientGeneralInfoEntity.unsetPatientPaymentTypeOthers();
			patientGeneralInfoEntity.setPatientPaymentTypeOthersId(patientPaymentTypeOthersEntity.getId());

			try {
				patientPersonalInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientPersonalInformation(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Personal Information relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPersonalInformationEntity = patientPersonalInfoRepository.findById(patientPersonalInfoRepository.save(patientGeneralInfoEntity.getPatientPersonalInformation()).getId()).get();
			patientGeneralInfoEntity.unsetPatientPersonalInformation();
			patientGeneralInfoEntity.setPatientPersonalInformationId(patientPersonalInformationEntity.getId());

			try {
				patientPaymentSelfPayingDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity.getPatientSelfPaying(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Self Paying relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientSelfPayingEntity = patientPaymentSelfPayingRepository.findById(patientPaymentSelfPayingRepository.save(patientGeneralInfoEntity.getPatientSelfPaying()).getId()).get();
			patientGeneralInfoEntity.unsetPatientSelfPaying();
			patientGeneralInfoEntity.setPatientSelfPayingId(patientSelfPayingEntity.getId());

			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : patientGeneralInfoEntity.getBpjsClaimSubmissions()) {
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
			patientGeneralInfoEntity.unsetBpjsClaimSubmissions();
			patientGeneralInfoEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			cashRefundsEntities = new HashSet<>();
			cashRefundsEntityIds = new HashSet<>();
			for (CashRefundEntity entity : patientGeneralInfoEntity.getCashRefunds()) {
				try {
					cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Cash Refunds relation for this test: " + e.getCause());
					return;
				}
				UUID id = cashRefundRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				cashRefundsEntities.add(cashRefundRepository.findById(id).get());
				cashRefundsEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetCashRefunds();
			patientGeneralInfoEntity.setCashRefundsIds(cashRefundsEntityIds);

			informedConsentsEntities = new HashSet<>();
			informedConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : patientGeneralInfoEntity.getInformedConsents()) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Informed Consents relation for this test: " + e.getCause());
					return;
				}
				UUID id = informedConsentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				informedConsentsEntities.add(informedConsentRepository.findById(id).get());
				informedConsentsEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetInformedConsents();
			patientGeneralInfoEntity.setInformedConsentsIds(informedConsentsEntityIds);

			invoiceReceiptsEntities = new HashSet<>();
			invoiceReceiptsEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : patientGeneralInfoEntity.getInvoiceReceipts()) {
				try {
					cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Receipts relation for this test: " + e.getCause());
					return;
				}
				UUID id = cashReceiptRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceReceiptsEntities.add(cashReceiptRepository.findById(id).get());
				invoiceReceiptsEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetInvoiceReceipts();
			patientGeneralInfoEntity.setInvoiceReceiptsIds(invoiceReceiptsEntityIds);

			patientCaseHistoriesEntities = new HashSet<>();
			patientCaseHistoriesEntityIds = new HashSet<>();
			for (PatientCaseHistoryEntity entity : patientGeneralInfoEntity.getPatientCaseHistories()) {
				try {
					patientCaseHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Case Histories relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientCaseHistoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientCaseHistoriesEntities.add(patientCaseHistoryRepository.findById(id).get());
				patientCaseHistoriesEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetPatientCaseHistories();
			patientGeneralInfoEntity.setPatientCaseHistoriesIds(patientCaseHistoriesEntityIds);

			patientConsentsEntities = new HashSet<>();
			patientConsentsEntityIds = new HashSet<>();
			for (PatientConsentEntity entity : patientGeneralInfoEntity.getPatientConsents()) {
				try {
					patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Consents relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientConsentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientConsentsEntities.add(patientConsentRepository.findById(id).get());
				patientConsentsEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetPatientConsents();
			patientGeneralInfoEntity.setPatientConsentsIds(patientConsentsEntityIds);

			patientFinalizeProfilesEntities = new HashSet<>();
			patientFinalizeProfilesEntityIds = new HashSet<>();
			for (PatientSupportingDocumentEntity entity : patientGeneralInfoEntity.getPatientFinalizeProfiles()) {
				try {
					patientSupportingDocumentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Finalize Profiles relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientSupportingDocumentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientFinalizeProfilesEntities.add(patientSupportingDocumentRepository.findById(id).get());
				patientFinalizeProfilesEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetPatientFinalizeProfiles();
			patientGeneralInfoEntity.setPatientFinalizeProfilesIds(patientFinalizeProfilesEntityIds);

			retailPharmaciesEntities = new HashSet<>();
			retailPharmaciesEntityIds = new HashSet<>();
			for (RetailPharmacyEntity entity : patientGeneralInfoEntity.getRetailPharmacies()) {
				try {
					retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Retail Pharmacies relation for this test: " + e.getCause());
					return;
				}
				UUID id = retailPharmacyRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				retailPharmaciesEntities.add(retailPharmacyRepository.findById(id).get());
				retailPharmaciesEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetRetailPharmacies();
			patientGeneralInfoEntity.setRetailPharmaciesIds(retailPharmaciesEntityIds);

			visitsEntities = new HashSet<>();
			visitsEntityIds = new HashSet<>();
			for (PatientVisitEntity entity : patientGeneralInfoEntity.getVisits()) {
				try {
					patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Visits relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientVisitRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				visitsEntities.add(patientVisitRepository.findById(id).get());
				visitsEntityIds.add(id);
			}
			patientGeneralInfoEntity.unsetVisits();
			patientGeneralInfoEntity.setVisitsIds(visitsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPatientGeneralInfoEntity = patientGeneralInfoService.updateOldData(patientGeneralInfoEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientContactInformationEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientContactInformation().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientContactInformationEntity, updatedPatientGeneralInfoEntity.getPatientContactInformation());

			patientDetailAddressEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientDetailAddress().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientDetailAddressEntity, updatedPatientGeneralInfoEntity.getPatientDetailAddress());

			patientDetailEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientDetail().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientDetailEntity, updatedPatientGeneralInfoEntity.getPatientDetail());

			patientEmergencyContactDetailEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientEmergencyContactDetail().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientEmergencyContactDetailEntity, updatedPatientGeneralInfoEntity.getPatientEmergencyContactDetail());

			patientEmploymentDetailEntity.unsetPatientGeneralInfo(false);
			updatedPatientGeneralInfoEntity.getPatientEmploymentDetail().unsetPatientGeneralInfo(false);
			Assertions.assertEquals(patientEmploymentDetailEntity, updatedPatientGeneralInfoEntity.getPatientEmploymentDetail());

			patientPaymentBPJSEntity.unsetPatientGeneralInfo(false);
			updatedPatientGeneralInfoEntity.getPatientPaymentBPJS().unsetPatientGeneralInfo(false);
			Assertions.assertEquals(patientPaymentBPJSEntity, updatedPatientGeneralInfoEntity.getPatientPaymentBPJS());

			patientPaymentTypeInsuranceEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientPaymentTypeInsurance().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientPaymentTypeInsuranceEntity, updatedPatientGeneralInfoEntity.getPatientPaymentTypeInsurance());

			patientPaymentTypeOthersEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientPaymentTypeOthers().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientPaymentTypeOthersEntity, updatedPatientGeneralInfoEntity.getPatientPaymentTypeOthers());

			patientPersonalInformationEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientPersonalInformation().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientPersonalInformationEntity, updatedPatientGeneralInfoEntity.getPatientPersonalInformation());

			patientSelfPayingEntity.unsetPatientGeneralInformation(false);
			updatedPatientGeneralInfoEntity.getPatientSelfPaying().unsetPatientGeneralInformation(false);
			Assertions.assertEquals(patientSelfPayingEntity, updatedPatientGeneralInfoEntity.getPatientSelfPaying());

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedPatientGeneralInfoEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(cashRefundsEntities.size(), updatedPatientGeneralInfoEntity.getCashRefunds().size());

			Assertions.assertEquals(informedConsentsEntities.size(), updatedPatientGeneralInfoEntity.getInformedConsents().size());

			Assertions.assertEquals(invoiceReceiptsEntities.size(), updatedPatientGeneralInfoEntity.getInvoiceReceipts().size());

			Assertions.assertEquals(patientCaseHistoriesEntities.size(), updatedPatientGeneralInfoEntity.getPatientCaseHistories().size());

			Assertions.assertEquals(patientConsentsEntities.size(), updatedPatientGeneralInfoEntity.getPatientConsents().size());

			Assertions.assertEquals(patientFinalizeProfilesEntities.size(), updatedPatientGeneralInfoEntity.getPatientFinalizeProfiles().size());

			Assertions.assertEquals(retailPharmaciesEntities.size(), updatedPatientGeneralInfoEntity.getRetailPharmacies().size());

			Assertions.assertEquals(visitsEntities.size(), updatedPatientGeneralInfoEntity.getVisits().size());

		});
	}

	@Test
	public void whenCreatePatientGeneralInfoEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientGeneralInfoEntity patientGeneralInfoEntity;
			Optional<PatientGeneralInfoEntity> fetchedPatientGeneralInfoEntity;

			try {
				patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientGeneralInfoEntity = patientGeneralInfoService.create(patientGeneralInfoEntity);

			fetchedPatientGeneralInfoEntity = patientGeneralInfoService.findById(patientGeneralInfoEntity.getId());

			Assertions.assertTrue(fetchedPatientGeneralInfoEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPatientGeneralInfoEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(patientGeneralInfoEntity, fetchedPatientGeneralInfoEntity.get());
		});
	}

	@Test
	public void whenUpdatePatientGeneralInfoEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientGeneralInfoEntity patientGeneralInfoEntity;
			PatientGeneralInfoEntity updatedPatientGeneralInfoEntity;
			Optional<PatientGeneralInfoEntity> fetchedPatientGeneralInfoEntity;

			try {
				patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, false);
				updatedPatientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPatientGeneralInfoEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientGeneralInfoEntity = patientGeneralInfoService.create(patientGeneralInfoEntity);

			updatedPatientGeneralInfoEntity.setId(patientGeneralInfoEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPatientGeneralInfoEntity.setCreated(patientGeneralInfoEntity.getCreated());

			updatedPatientGeneralInfoEntity = patientGeneralInfoService.update(updatedPatientGeneralInfoEntity);

			fetchedPatientGeneralInfoEntity = patientGeneralInfoService.findById(patientGeneralInfoEntity.getId());

			Assertions.assertTrue(fetchedPatientGeneralInfoEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePatientGeneralInfoEntity_ThenEntityIsCreated
			fetchedPatientGeneralInfoEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPatientGeneralInfoEntity, fetchedPatientGeneralInfoEntity.get());
		});
	}

	@Test
	public void whenDeletePatientGeneralInfoEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PatientGeneralInfoEntity patientGeneralInfoEntity;
			Optional<PatientGeneralInfoEntity> fetchedPatientGeneralInfoEntity;

			try {
				patientGeneralInfoEntity = patientGeneralInfoFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientGeneralInfoEntity = patientGeneralInfoService.create(patientGeneralInfoEntity);

			patientGeneralInfoService.deleteById(patientGeneralInfoEntity.getId());
			fetchedPatientGeneralInfoEntity = patientGeneralInfoService.findById(patientGeneralInfoEntity.getId());

			Assertions.assertTrue(fetchedPatientGeneralInfoEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
