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
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.repositories.InvoicePaymentInsuranceRepository;
import kmsweb.utils.InvoicePaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.InvoicePaymentInsuranceDatabasePopulator;
import kmsweb.entities.InvoicePaymentOtherEntity;
import kmsweb.repositories.InvoicePaymentOtherRepository;
import kmsweb.utils.InvoicePaymentOtherFactory;
import kmsweb.utils.DatabasePopulators.InvoicePaymentOtherDatabasePopulator;
import kmsweb.entities.InvoicePaymentSelfPayingEntity;
import kmsweb.repositories.InvoicePaymentSelfPayingRepository;
import kmsweb.utils.InvoicePaymentSelfPayingFactory;
import kmsweb.utils.DatabasePopulators.InvoicePaymentSelfPayingDatabasePopulator;
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.repositories.InvoiceSummaryRepository;
import kmsweb.utils.InvoiceSummaryFactory;
import kmsweb.utils.DatabasePopulators.InvoiceSummaryDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.entities.TariffSchemaEntity;
import kmsweb.repositories.TariffSchemaRepository;
import kmsweb.utils.TariffSchemaFactory;
import kmsweb.utils.DatabasePopulators.TariffSchemaDatabasePopulator;
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
public class InvoiceServiceIntegrationTest {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InvoiceService invoiceService;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

	@Autowired
	private InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository;

	@Autowired
	private InvoicePaymentInsuranceDatabasePopulator invoicePaymentInsuranceDatabasePopulator;

	private final InvoicePaymentInsuranceFactory invoicePaymentInsuranceFactory = new InvoicePaymentInsuranceFactory();

	@Autowired
	private InvoicePaymentOtherRepository invoicePaymentOtherRepository;

	@Autowired
	private InvoicePaymentOtherDatabasePopulator invoicePaymentOtherDatabasePopulator;

	private final InvoicePaymentOtherFactory invoicePaymentOtherFactory = new InvoicePaymentOtherFactory();

	@Autowired
	private InvoicePaymentSelfPayingRepository invoicePaymentSelfPayingRepository;

	@Autowired
	private InvoicePaymentSelfPayingDatabasePopulator invoicePaymentSelfPayingDatabasePopulator;

	private final InvoicePaymentSelfPayingFactory invoicePaymentSelfPayingFactory = new InvoicePaymentSelfPayingFactory();

	@Autowired
	private InvoiceSummaryRepository invoiceSummaryRepository;

	@Autowired
	private InvoiceSummaryDatabasePopulator invoiceSummaryDatabasePopulator;

	private final InvoiceSummaryFactory invoiceSummaryFactory = new InvoiceSummaryFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();

	@Autowired
	private TariffSchemaRepository tariffSchemaRepository;

	@Autowired
	private TariffSchemaDatabasePopulator tariffSchemaDatabasePopulator;

	private final TariffSchemaFactory tariffSchemaFactory = new TariffSchemaFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		invoiceService = new InvoiceService(
			bedFacilityRepository,
			diagnosesAndProceduresRepository,
			invoiceItemRepository,
			invoicePaymentInsuranceRepository,
			invoicePaymentOtherRepository,
			invoicePaymentSelfPayingRepository,
			invoiceSummaryRepository,
			medicationHeaderRepository,
			patientVisitRepository,
			prescriptionHeaderRepository,
			staffRepository,
			tariffSchemaRepository,
			validator,
			auditRepository,
			invoiceRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInvoiceEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InvoiceEntity invoiceEntity = invoiceFactory.getObject(false, false);

		InvoiceEntity updatedEntity = invoiceService.updateOldData(invoiceEntity);
		Assertions.assertEquals(invoiceEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewInvoiceEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		InvoiceEntity invoiceEntity = invoiceFactory.getObject(false, false);

		invoiceEntity.setDisplayDoctorOnPrint(null);
		Assertions.assertNull(invoiceEntity.getDisplayDoctorOnPrint());

		invoiceEntity.setDisplayICD10OnPrint(null);
		Assertions.assertNull(invoiceEntity.getDisplayICD10OnPrint());

		invoiceEntity.setDisplayICD9CMOnPrint(null);
		Assertions.assertNull(invoiceEntity.getDisplayICD9CMOnPrint());


		InvoiceEntity updatedEntity = invoiceService.updateOldData(invoiceEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getDisplayDoctorOnPrint());
		Assertions.assertFalse(updatedEntity.getDisplayDoctorOnPrint());

		Assertions.assertNotNull(updatedEntity.getDisplayICD10OnPrint());
		Assertions.assertFalse(updatedEntity.getDisplayICD10OnPrint());

		Assertions.assertNotNull(updatedEntity.getDisplayICD9CMOnPrint());
		Assertions.assertFalse(updatedEntity.getDisplayICD9CMOnPrint());

	}

	@Test
	public void updateOldDataWithExistingInvoiceEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceEntity invoiceEntity;
			InvoiceEntity entityWithUpdatedValues;

			try {
				invoiceEntity = invoiceFactory.getObject(false, false);
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = invoiceFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceEntity = invoiceService.create(invoiceEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(invoiceEntity.getId());

			InvoiceEntity updatedEntity = invoiceService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInvoiceEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InvoiceEntity invoiceEntity = invoiceFactory.getObject(false, false);
		invoiceEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			invoiceService.updateOldData(invoiceEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInvoiceEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceEntity invoiceEntity;
			InvoiceEntity updatedInvoiceEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			InvoicePaymentOtherEntity invoicePaymentOtherEntity;

			InvoicePaymentSelfPayingEntity invoicePaymentSelfPayingEntity;

			InvoiceSummaryEntity invoiceSummaryEntity;

			PrescriptionHeaderEntity prescriptionHeaderEntity;

			DiagnosesAndProceduresEntity icd10Entity;

			DiagnosesAndProceduresEntity icd9CMEntity;

			BedFacilityEntity bedFacilityEntity;

			PatientVisitEntity patientVisitEntity;

			TariffSchemaEntity tariffSchemaEntity;

			StaffEntity verifiedByEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurancesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoiceEntity = invoiceFactory.getObject(true, false);
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
			medicationHeaderEntity = invoiceEntity.getMedicationHeader();
			try {
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationHeaderEntity = medicationHeaderRepository.save(medicationHeaderEntity);
			invoiceEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			invoicePaymentOtherEntity = invoiceEntity.getInvoicePaymentOther();
			try {
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentOtherEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoicePaymentOtherEntity = invoicePaymentOtherRepository.save(invoicePaymentOtherEntity);
			invoiceEntity.setInvoicePaymentOtherId(invoicePaymentOtherEntity.getId());

			invoicePaymentSelfPayingEntity = invoiceEntity.getInvoicePaymentSelfPaying();
			try {
				invoicePaymentSelfPayingDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentSelfPayingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoicePaymentSelfPayingEntity = invoicePaymentSelfPayingRepository.save(invoicePaymentSelfPayingEntity);
			invoiceEntity.setInvoicePaymentSelfPayingId(invoicePaymentSelfPayingEntity.getId());

			invoiceSummaryEntity = invoiceEntity.getInvoiceSummary();
			try {
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceSummaryEntity = invoiceSummaryRepository.save(invoiceSummaryEntity);
			invoiceEntity.setInvoiceSummaryId(invoiceSummaryEntity.getId());

			prescriptionHeaderEntity = invoiceEntity.getPrescriptionHeader();
			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			prescriptionHeaderEntity = prescriptionHeaderRepository.save(prescriptionHeaderEntity);
			invoiceEntity.setPrescriptionHeaderId(prescriptionHeaderEntity.getId());

			icd10Entity = invoiceEntity.getIcd10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			icd10Entity = diagnosesAndProceduresRepository.save(icd10Entity);
			invoiceEntity.setIcd10Id(icd10Entity.getId());

			icd9CMEntity = invoiceEntity.getIcd9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			icd9CMEntity = diagnosesAndProceduresRepository.save(icd9CMEntity);
			invoiceEntity.setIcd9CMId(icd9CMEntity.getId());

			bedFacilityEntity = invoiceEntity.getBedFacility();
			try {
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bedFacilityEntity = bedFacilityRepository.save(bedFacilityEntity);
			invoiceEntity.setBedFacilityId(bedFacilityEntity.getId());

			patientVisitEntity = invoiceEntity.getPatientVisit();
			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitEntity = patientVisitRepository.save(patientVisitEntity);
			invoiceEntity.setPatientVisitId(patientVisitEntity.getId());

			tariffSchemaEntity = invoiceEntity.getTariffSchema();
			try {
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(tariffSchemaEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			tariffSchemaEntity = tariffSchemaRepository.save(tariffSchemaEntity);
			invoiceEntity.setTariffSchemaId(tariffSchemaEntity.getId());

			verifiedByEntity = invoiceEntity.getVerifiedBy();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(verifiedByEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			verifiedByEntity = staffRepository.save(verifiedByEntity);
			invoiceEntity.setVerifiedById(verifiedByEntity.getId());

			invoiceItemsEntities = invoiceEntity.getInvoiceItems();
			Set<UUID> invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : invoiceItemsEntities) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceItemsEntityIds.add(invoiceItemRepository.save(entity).getId());
			}
			invoiceEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			invoicePaymentInsurancesEntities = invoiceEntity.getInvoicePaymentInsurances();
			Set<UUID> invoicePaymentInsurancesEntityIds = new HashSet<>();
			for (InvoicePaymentInsuranceEntity entity : invoicePaymentInsurancesEntities) {
				try {
					invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicePaymentInsurancesEntityIds.add(invoicePaymentInsuranceRepository.save(entity).getId());
			}
			invoiceEntity.setInvoicePaymentInsurancesIds(invoicePaymentInsurancesEntityIds);


			invoiceEntity = invoiceService.create(invoiceEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(invoiceEntity.getMedicationHeader());
			invoiceEntity.setMedicationHeaderId(null);
			invoiceEntity.unsetMedicationHeader();

			Assertions.assertNotNull(invoiceEntity.getInvoicePaymentOther());
			invoiceEntity.setInvoicePaymentOtherId(null);
			invoiceEntity.unsetInvoicePaymentOther();

			Assertions.assertNotNull(invoiceEntity.getInvoicePaymentSelfPaying());
			invoiceEntity.setInvoicePaymentSelfPayingId(null);
			invoiceEntity.unsetInvoicePaymentSelfPaying();

			Assertions.assertNotNull(invoiceEntity.getInvoiceSummary());
			invoiceEntity.setInvoiceSummaryId(null);
			invoiceEntity.unsetInvoiceSummary();

			Assertions.assertNotNull(invoiceEntity.getPrescriptionHeader());
			invoiceEntity.setPrescriptionHeaderId(null);
			invoiceEntity.unsetPrescriptionHeader();

			Assertions.assertNotNull(invoiceEntity.getIcd10());
			invoiceEntity.setIcd10Id(null);
			invoiceEntity.unsetIcd10();

			Assertions.assertNotNull(invoiceEntity.getIcd9CM());
			invoiceEntity.setIcd9CMId(null);
			invoiceEntity.unsetIcd9CM();

			Assertions.assertNotNull(invoiceEntity.getBedFacility());
			invoiceEntity.setBedFacilityId(null);
			invoiceEntity.unsetBedFacility();

			Assertions.assertNotNull(invoiceEntity.getPatientVisit());
			invoiceEntity.setPatientVisitId(null);
			invoiceEntity.unsetPatientVisit();

			Assertions.assertNotNull(invoiceEntity.getTariffSchema());
			invoiceEntity.setTariffSchemaId(null);
			invoiceEntity.unsetTariffSchema();

			Assertions.assertNotNull(invoiceEntity.getVerifiedBy());
			invoiceEntity.setVerifiedById(null);
			invoiceEntity.unsetVerifiedBy();

			Assertions.assertTrue(invoiceEntity.getInvoiceItems().size() > 0);
			invoiceEntity.setInvoiceItemsIds(new HashSet<UUID>());
			invoiceEntity.unsetInvoiceItems();

			Assertions.assertTrue(invoiceEntity.getInvoicePaymentInsurances().size() > 0);
			invoiceEntity.setInvoicePaymentInsurancesIds(new HashSet<UUID>());
			invoiceEntity.unsetInvoicePaymentInsurances();


			updatedInvoiceEntity = invoiceService.updateOldData(invoiceEntity);

			Assertions.assertNull(updatedInvoiceEntity.getMedicationHeader());

			Assertions.assertNull(updatedInvoiceEntity.getInvoicePaymentOther());

			Assertions.assertNull(updatedInvoiceEntity.getInvoicePaymentSelfPaying());

			Assertions.assertNull(updatedInvoiceEntity.getInvoiceSummary());

			Assertions.assertNull(updatedInvoiceEntity.getPrescriptionHeader());

			Assertions.assertNull(updatedInvoiceEntity.getIcd10());

			Assertions.assertNull(updatedInvoiceEntity.getIcd9CM());

			Assertions.assertNull(updatedInvoiceEntity.getBedFacility());

			Assertions.assertNull(updatedInvoiceEntity.getPatientVisit());

			Assertions.assertNull(updatedInvoiceEntity.getTariffSchema());

			Assertions.assertNull(updatedInvoiceEntity.getVerifiedBy());

			Assertions.assertEquals(0, updatedInvoiceEntity.getInvoiceItems().size());

			Assertions.assertEquals(0, updatedInvoiceEntity.getInvoicePaymentInsurances().size());

		});
	}

	@Test
	public void updateOldDataWithInvoiceEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceEntity invoiceEntity;
			InvoiceEntity updatedInvoiceEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			InvoicePaymentOtherEntity invoicePaymentOtherEntity;

			InvoicePaymentSelfPayingEntity invoicePaymentSelfPayingEntity;

			InvoiceSummaryEntity invoiceSummaryEntity;

			PrescriptionHeaderEntity prescriptionHeaderEntity;

			DiagnosesAndProceduresEntity icd10Entity;

			DiagnosesAndProceduresEntity icd9CMEntity;

			BedFacilityEntity bedFacilityEntity;

			PatientVisitEntity patientVisitEntity;

			TariffSchemaEntity tariffSchemaEntity;

			StaffEntity verifiedByEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;

			Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurancesEntities;
			Set<UUID> invoicePaymentInsurancesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoiceEntity = invoiceFactory.getObject(true, false);
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
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getMedicationHeader(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Header relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationHeaderEntity = medicationHeaderRepository.findById(medicationHeaderRepository.save(invoiceEntity.getMedicationHeader()).getId()).get();
			invoiceEntity.unsetMedicationHeader();
			invoiceEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			try {
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getInvoicePaymentOther(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice Payment Other relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoicePaymentOtherEntity = invoicePaymentOtherRepository.findById(invoicePaymentOtherRepository.save(invoiceEntity.getInvoicePaymentOther()).getId()).get();
			invoiceEntity.unsetInvoicePaymentOther();
			invoiceEntity.setInvoicePaymentOtherId(invoicePaymentOtherEntity.getId());

			try {
				invoicePaymentSelfPayingDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getInvoicePaymentSelfPaying(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice Payment Self Paying relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoicePaymentSelfPayingEntity = invoicePaymentSelfPayingRepository.findById(invoicePaymentSelfPayingRepository.save(invoiceEntity.getInvoicePaymentSelfPaying()).getId()).get();
			invoiceEntity.unsetInvoicePaymentSelfPaying();
			invoiceEntity.setInvoicePaymentSelfPayingId(invoicePaymentSelfPayingEntity.getId());

			try {
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getInvoiceSummary(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice Summary relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceSummaryEntity = invoiceSummaryRepository.findById(invoiceSummaryRepository.save(invoiceEntity.getInvoiceSummary()).getId()).get();
			invoiceEntity.unsetInvoiceSummary();
			invoiceEntity.setInvoiceSummaryId(invoiceSummaryEntity.getId());

			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getPrescriptionHeader(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Prescription Header relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			prescriptionHeaderEntity = prescriptionHeaderRepository.findById(prescriptionHeaderRepository.save(invoiceEntity.getPrescriptionHeader()).getId()).get();
			invoiceEntity.unsetPrescriptionHeader();
			invoiceEntity.setPrescriptionHeaderId(prescriptionHeaderEntity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getIcd10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			icd10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(invoiceEntity.getIcd10()).getId()).get();
			invoiceEntity.unsetIcd10();
			invoiceEntity.setIcd10Id(icd10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getIcd9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			icd9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(invoiceEntity.getIcd9CM()).getId()).get();
			invoiceEntity.unsetIcd9CM();
			invoiceEntity.setIcd9CMId(icd9CMEntity.getId());

			try {
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getBedFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Bed Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bedFacilityEntity = bedFacilityRepository.findById(bedFacilityRepository.save(invoiceEntity.getBedFacility()).getId()).get();
			invoiceEntity.unsetBedFacility();
			invoiceEntity.setBedFacilityId(bedFacilityEntity.getId());

			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getPatientVisit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitEntity = patientVisitRepository.findById(patientVisitRepository.save(invoiceEntity.getPatientVisit()).getId()).get();
			invoiceEntity.unsetPatientVisit();
			invoiceEntity.setPatientVisitId(patientVisitEntity.getId());

			try {
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getTariffSchema(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Tariff Schema relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			tariffSchemaEntity = tariffSchemaRepository.findById(tariffSchemaRepository.save(invoiceEntity.getTariffSchema()).getId()).get();
			invoiceEntity.unsetTariffSchema();
			invoiceEntity.setTariffSchemaId(tariffSchemaEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity.getVerifiedBy(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Verified By relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			verifiedByEntity = staffRepository.findById(staffRepository.save(invoiceEntity.getVerifiedBy()).getId()).get();
			invoiceEntity.unsetVerifiedBy();
			invoiceEntity.setVerifiedById(verifiedByEntity.getId());

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : invoiceEntity.getInvoiceItems()) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceItemsEntities.add(invoiceItemRepository.findById(id).get());
				invoiceItemsEntityIds.add(id);
			}
			invoiceEntity.unsetInvoiceItems();
			invoiceEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			invoicePaymentInsurancesEntities = new HashSet<>();
			invoicePaymentInsurancesEntityIds = new HashSet<>();
			for (InvoicePaymentInsuranceEntity entity : invoiceEntity.getInvoicePaymentInsurances()) {
				try {
					invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Payment Insurances relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoicePaymentInsuranceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicePaymentInsurancesEntities.add(invoicePaymentInsuranceRepository.findById(id).get());
				invoicePaymentInsurancesEntityIds.add(id);
			}
			invoiceEntity.unsetInvoicePaymentInsurances();
			invoiceEntity.setInvoicePaymentInsurancesIds(invoicePaymentInsurancesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInvoiceEntity = invoiceService.updateOldData(invoiceEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicationHeaderEntity.unsetInvoice(false);
			updatedInvoiceEntity.getMedicationHeader().unsetInvoice(false);
			Assertions.assertEquals(medicationHeaderEntity, updatedInvoiceEntity.getMedicationHeader());

			invoicePaymentOtherEntity.unsetInvoice(false);
			updatedInvoiceEntity.getInvoicePaymentOther().unsetInvoice(false);
			Assertions.assertEquals(invoicePaymentOtherEntity, updatedInvoiceEntity.getInvoicePaymentOther());

			invoicePaymentSelfPayingEntity.unsetInvoice(false);
			updatedInvoiceEntity.getInvoicePaymentSelfPaying().unsetInvoice(false);
			Assertions.assertEquals(invoicePaymentSelfPayingEntity, updatedInvoiceEntity.getInvoicePaymentSelfPaying());

			invoiceSummaryEntity.unsetInvoice(false);
			updatedInvoiceEntity.getInvoiceSummary().unsetInvoice(false);
			Assertions.assertEquals(invoiceSummaryEntity, updatedInvoiceEntity.getInvoiceSummary());

			prescriptionHeaderEntity.unsetInvoice(false);
			updatedInvoiceEntity.getPrescriptionHeader().unsetInvoice(false);
			Assertions.assertEquals(prescriptionHeaderEntity, updatedInvoiceEntity.getPrescriptionHeader());

			icd10Entity.unsetInvoicesICD10(false);
			updatedInvoiceEntity.getIcd10().unsetInvoicesICD10(false);
			Assertions.assertEquals(icd10Entity, updatedInvoiceEntity.getIcd10());

			icd9CMEntity.unsetInvoicesICD9CM(false);
			updatedInvoiceEntity.getIcd9CM().unsetInvoicesICD9CM(false);
			Assertions.assertEquals(icd9CMEntity, updatedInvoiceEntity.getIcd9CM());

			bedFacilityEntity.unsetInvoices(false);
			updatedInvoiceEntity.getBedFacility().unsetInvoices(false);
			Assertions.assertEquals(bedFacilityEntity, updatedInvoiceEntity.getBedFacility());

			patientVisitEntity.unsetInvoices(false);
			updatedInvoiceEntity.getPatientVisit().unsetInvoices(false);
			Assertions.assertEquals(patientVisitEntity, updatedInvoiceEntity.getPatientVisit());

			tariffSchemaEntity.unsetInvoices(false);
			updatedInvoiceEntity.getTariffSchema().unsetInvoices(false);
			Assertions.assertEquals(tariffSchemaEntity, updatedInvoiceEntity.getTariffSchema());

			verifiedByEntity.unsetInvoices(false);
			updatedInvoiceEntity.getVerifiedBy().unsetInvoices(false);
			Assertions.assertEquals(verifiedByEntity, updatedInvoiceEntity.getVerifiedBy());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedInvoiceEntity.getInvoiceItems().size());

			Assertions.assertEquals(invoicePaymentInsurancesEntities.size(), updatedInvoiceEntity.getInvoicePaymentInsurances().size());

		});
	}

	@Test
	public void whenCreateInvoiceEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceEntity invoiceEntity;
			Optional<InvoiceEntity> fetchedInvoiceEntity;

			try {
				invoiceEntity = invoiceFactory.getObject(false, false);
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceEntity = invoiceService.create(invoiceEntity);

			Optional<TariffSchemaEntity> relatedTariffSchemaOptional = tariffSchemaRepository.findById(invoiceEntity.getTariffSchemaId());
			assert relatedTariffSchemaOptional.isPresent();
			TariffSchemaEntity relatedTariffSchema = relatedTariffSchemaOptional.get();
			// Required related entity has to be created without a reference to this parent entity as it doesn't exist yet.
			// Therefore we need to update the related entity to reference our parent entity for the later checks
			relatedTariffSchema.setInvoices(Collections.singletonList(invoiceEntity));
			tariffSchemaRepository.save(relatedTariffSchema);

			fetchedInvoiceEntity = invoiceService.findById(invoiceEntity.getId());

			Assertions.assertTrue(fetchedInvoiceEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInvoiceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(invoiceEntity, fetchedInvoiceEntity.get());
		});
	}

	@Test
	public void whenUpdateInvoiceEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceEntity invoiceEntity;
			InvoiceEntity updatedInvoiceEntity;
			Optional<InvoiceEntity> fetchedInvoiceEntity;

			try {
				invoiceEntity = invoiceFactory.getObject(false, false);
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, false);
				updatedInvoiceEntity = invoiceFactory.getObject(false, false);
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInvoiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceEntity = invoiceService.create(invoiceEntity);

			updatedInvoiceEntity.setId(invoiceEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInvoiceEntity.setCreated(invoiceEntity.getCreated());

			updatedInvoiceEntity = invoiceService.update(updatedInvoiceEntity);

			fetchedInvoiceEntity = invoiceService.findById(invoiceEntity.getId());

			Assertions.assertTrue(fetchedInvoiceEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInvoiceEntity_ThenEntityIsCreated
			fetchedInvoiceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInvoiceEntity, fetchedInvoiceEntity.get());
		});
	}

	@Test
	public void whenDeleteInvoiceEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceEntity invoiceEntity;
			Optional<InvoiceEntity> fetchedInvoiceEntity;

			try {
				invoiceEntity = invoiceFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceEntity = invoiceService.create(invoiceEntity);

			invoiceService.deleteById(invoiceEntity.getId());
			fetchedInvoiceEntity = invoiceService.findById(invoiceEntity.getId());

			Assertions.assertTrue(fetchedInvoiceEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
