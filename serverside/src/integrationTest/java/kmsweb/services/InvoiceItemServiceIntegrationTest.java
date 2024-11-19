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
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.InvoiceItemComponentEntity;
import kmsweb.repositories.InvoiceItemComponentRepository;
import kmsweb.utils.InvoiceItemComponentFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemComponentDatabasePopulator;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.utils.MedicalFeeFactory;
import kmsweb.utils.DatabasePopulators.MedicalFeeDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.utils.RetailPharmacyInvoiceFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyInvoiceDatabasePopulator;
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
public class InvoiceItemServiceIntegrationTest {

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InvoiceItemService invoiceItemService;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private InvoiceItemComponentRepository invoiceItemComponentRepository;

	@Autowired
	private InvoiceItemComponentDatabasePopulator invoiceItemComponentDatabasePopulator;

	private final InvoiceItemComponentFactory invoiceItemComponentFactory = new InvoiceItemComponentFactory();

	@Autowired
	private MedicalFeeRepository medicalFeeRepository;

	@Autowired
	private MedicalFeeDatabasePopulator medicalFeeDatabasePopulator;

	private final MedicalFeeFactory medicalFeeFactory = new MedicalFeeFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	@Autowired
	private RetailPharmacyInvoiceDatabasePopulator retailPharmacyInvoiceDatabasePopulator;

	private final RetailPharmacyInvoiceFactory retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();

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
		invoiceItemService = new InvoiceItemService(
			invoiceRepository,
			invoiceItemComponentRepository,
			medicalFeeRepository,
			medicationHeaderRepository,
			prescriptionHeaderRepository,
			registrationRepository,
			retailPharmacyInvoiceRepository,
			tariffSchemaRepository,
			validator,
			auditRepository,
			invoiceItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInvoiceItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InvoiceItemEntity invoiceItemEntity = invoiceItemFactory.getObject(false, false);

		InvoiceItemEntity updatedEntity = invoiceItemService.updateOldData(invoiceItemEntity);
		Assertions.assertEquals(invoiceItemEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewInvoiceItemEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		InvoiceItemEntity invoiceItemEntity = invoiceItemFactory.getObject(false, false);

		invoiceItemEntity.setTax(null);
		Assertions.assertNull(invoiceItemEntity.getTax());


		InvoiceItemEntity updatedEntity = invoiceItemService.updateOldData(invoiceItemEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getTax());
		Assertions.assertFalse(updatedEntity.getTax());

	}

	@Test
	public void updateOldDataWithExistingInvoiceItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceItemEntity invoiceItemEntity;
			InvoiceItemEntity entityWithUpdatedValues;

			try {
				invoiceItemEntity = invoiceItemFactory.getObject(false, false);
				invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = invoiceItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceItemEntity = invoiceItemService.create(invoiceItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(invoiceItemEntity.getId());

			InvoiceItemEntity updatedEntity = invoiceItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInvoiceItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InvoiceItemEntity invoiceItemEntity = invoiceItemFactory.getObject(false, false);
		invoiceItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			invoiceItemService.updateOldData(invoiceItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInvoiceItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceItemEntity invoiceItemEntity;
			InvoiceItemEntity updatedInvoiceItemEntity;

			InvoiceEntity invoiceEntity;

			MedicalFeeEntity medicalFeeEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			PrescriptionHeaderEntity prescriptionEntity;

			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;

			RegistrationEntity serviceNumberEntity;

			TariffSchemaEntity tariffSchemaEntity;

			Set<InvoiceItemComponentEntity> invoiceItemComponentsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoiceItemEntity = invoiceItemFactory.getObject(true, false);
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
			invoiceEntity = invoiceItemEntity.getInvoice();
			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceEntity = invoiceRepository.save(invoiceEntity);
			invoiceItemEntity.setInvoiceId(invoiceEntity.getId());

			medicalFeeEntity = invoiceItemEntity.getMedicalFee();
			try {
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalFeeEntity = medicalFeeRepository.save(medicalFeeEntity);
			invoiceItemEntity.setMedicalFeeId(medicalFeeEntity.getId());

			medicationHeaderEntity = invoiceItemEntity.getMedicationHeader();
			try {
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationHeaderEntity = medicationHeaderRepository.save(medicationHeaderEntity);
			invoiceItemEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			prescriptionEntity = invoiceItemEntity.getPrescription();
			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			prescriptionEntity = prescriptionHeaderRepository.save(prescriptionEntity);
			invoiceItemEntity.setPrescriptionId(prescriptionEntity.getId());

			retailPharmacyInvoiceEntity = invoiceItemEntity.getRetailPharmacyInvoice();
			try {
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			retailPharmacyInvoiceEntity = retailPharmacyInvoiceRepository.save(retailPharmacyInvoiceEntity);
			invoiceItemEntity.setRetailPharmacyInvoiceId(retailPharmacyInvoiceEntity.getId());

			serviceNumberEntity = invoiceItemEntity.getServiceNumber();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(serviceNumberEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceNumberEntity = registrationRepository.save(serviceNumberEntity);
			invoiceItemEntity.setServiceNumberId(serviceNumberEntity.getId());

			tariffSchemaEntity = invoiceItemEntity.getTariffSchema();
			try {
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(tariffSchemaEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			tariffSchemaEntity = tariffSchemaRepository.save(tariffSchemaEntity);
			invoiceItemEntity.setTariffSchemaId(tariffSchemaEntity.getId());

			invoiceItemComponentsEntities = invoiceItemEntity.getInvoiceItemComponents();
			Set<UUID> invoiceItemComponentsEntityIds = new HashSet<>();
			for (InvoiceItemComponentEntity entity : invoiceItemComponentsEntities) {
				try {
					invoiceItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceItemComponentsEntityIds.add(invoiceItemComponentRepository.save(entity).getId());
			}
			invoiceItemEntity.setInvoiceItemComponentsIds(invoiceItemComponentsEntityIds);


			invoiceItemEntity = invoiceItemService.create(invoiceItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(invoiceItemEntity.getInvoice());
			invoiceItemEntity.setInvoiceId(null);
			invoiceItemEntity.unsetInvoice();

			Assertions.assertNotNull(invoiceItemEntity.getMedicalFee());
			invoiceItemEntity.setMedicalFeeId(null);
			invoiceItemEntity.unsetMedicalFee();

			Assertions.assertNotNull(invoiceItemEntity.getMedicationHeader());
			invoiceItemEntity.setMedicationHeaderId(null);
			invoiceItemEntity.unsetMedicationHeader();

			Assertions.assertNotNull(invoiceItemEntity.getPrescription());
			invoiceItemEntity.setPrescriptionId(null);
			invoiceItemEntity.unsetPrescription();

			Assertions.assertNotNull(invoiceItemEntity.getRetailPharmacyInvoice());
			invoiceItemEntity.setRetailPharmacyInvoiceId(null);
			invoiceItemEntity.unsetRetailPharmacyInvoice();

			Assertions.assertNotNull(invoiceItemEntity.getServiceNumber());
			invoiceItemEntity.setServiceNumberId(null);
			invoiceItemEntity.unsetServiceNumber();

			Assertions.assertNotNull(invoiceItemEntity.getTariffSchema());
			invoiceItemEntity.setTariffSchemaId(null);
			invoiceItemEntity.unsetTariffSchema();

			Assertions.assertTrue(invoiceItemEntity.getInvoiceItemComponents().size() > 0);
			invoiceItemEntity.setInvoiceItemComponentsIds(new HashSet<UUID>());
			invoiceItemEntity.unsetInvoiceItemComponents();


			updatedInvoiceItemEntity = invoiceItemService.updateOldData(invoiceItemEntity);

			Assertions.assertNull(updatedInvoiceItemEntity.getInvoice());

			Assertions.assertNull(updatedInvoiceItemEntity.getMedicalFee());

			Assertions.assertNull(updatedInvoiceItemEntity.getMedicationHeader());

			Assertions.assertNull(updatedInvoiceItemEntity.getPrescription());

			Assertions.assertNull(updatedInvoiceItemEntity.getRetailPharmacyInvoice());

			Assertions.assertNull(updatedInvoiceItemEntity.getServiceNumber());

			Assertions.assertNull(updatedInvoiceItemEntity.getTariffSchema());

			Assertions.assertEquals(0, updatedInvoiceItemEntity.getInvoiceItemComponents().size());

		});
	}

	@Test
	public void updateOldDataWithInvoiceItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceItemEntity invoiceItemEntity;
			InvoiceItemEntity updatedInvoiceItemEntity;

			InvoiceEntity invoiceEntity;

			MedicalFeeEntity medicalFeeEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			PrescriptionHeaderEntity prescriptionEntity;

			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;

			RegistrationEntity serviceNumberEntity;

			TariffSchemaEntity tariffSchemaEntity;

			Set<InvoiceItemComponentEntity> invoiceItemComponentsEntities;
			Set<UUID> invoiceItemComponentsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoiceItemEntity = invoiceItemFactory.getObject(true, false);
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
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceEntity = invoiceRepository.findById(invoiceRepository.save(invoiceItemEntity.getInvoice()).getId()).get();
			invoiceItemEntity.unsetInvoice();
			invoiceItemEntity.setInvoiceId(invoiceEntity.getId());

			try {
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getMedicalFee(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Fee relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalFeeEntity = medicalFeeRepository.findById(medicalFeeRepository.save(invoiceItemEntity.getMedicalFee()).getId()).get();
			invoiceItemEntity.unsetMedicalFee();
			invoiceItemEntity.setMedicalFeeId(medicalFeeEntity.getId());

			try {
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getMedicationHeader(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Header relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationHeaderEntity = medicationHeaderRepository.findById(medicationHeaderRepository.save(invoiceItemEntity.getMedicationHeader()).getId()).get();
			invoiceItemEntity.unsetMedicationHeader();
			invoiceItemEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getPrescription(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Prescription relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			prescriptionEntity = prescriptionHeaderRepository.findById(prescriptionHeaderRepository.save(invoiceItemEntity.getPrescription()).getId()).get();
			invoiceItemEntity.unsetPrescription();
			invoiceItemEntity.setPrescriptionId(prescriptionEntity.getId());

			try {
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getRetailPharmacyInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Retail Pharmacy Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			retailPharmacyInvoiceEntity = retailPharmacyInvoiceRepository.findById(retailPharmacyInvoiceRepository.save(invoiceItemEntity.getRetailPharmacyInvoice()).getId()).get();
			invoiceItemEntity.unsetRetailPharmacyInvoice();
			invoiceItemEntity.setRetailPharmacyInvoiceId(retailPharmacyInvoiceEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getServiceNumber(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service Number relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceNumberEntity = registrationRepository.findById(registrationRepository.save(invoiceItemEntity.getServiceNumber()).getId()).get();
			invoiceItemEntity.unsetServiceNumber();
			invoiceItemEntity.setServiceNumberId(serviceNumberEntity.getId());

			try {
				tariffSchemaDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity.getTariffSchema(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Tariff Schema relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			tariffSchemaEntity = tariffSchemaRepository.findById(tariffSchemaRepository.save(invoiceItemEntity.getTariffSchema()).getId()).get();
			invoiceItemEntity.unsetTariffSchema();
			invoiceItemEntity.setTariffSchemaId(tariffSchemaEntity.getId());

			invoiceItemComponentsEntities = new HashSet<>();
			invoiceItemComponentsEntityIds = new HashSet<>();
			for (InvoiceItemComponentEntity entity : invoiceItemEntity.getInvoiceItemComponents()) {
				try {
					invoiceItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Item Components relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceItemComponentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceItemComponentsEntities.add(invoiceItemComponentRepository.findById(id).get());
				invoiceItemComponentsEntityIds.add(id);
			}
			invoiceItemEntity.unsetInvoiceItemComponents();
			invoiceItemEntity.setInvoiceItemComponentsIds(invoiceItemComponentsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInvoiceItemEntity = invoiceItemService.updateOldData(invoiceItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			invoiceEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getInvoice().unsetInvoiceItems(false);
			Assertions.assertEquals(invoiceEntity, updatedInvoiceItemEntity.getInvoice());

			medicalFeeEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getMedicalFee().unsetInvoiceItems(false);
			Assertions.assertEquals(medicalFeeEntity, updatedInvoiceItemEntity.getMedicalFee());

			medicationHeaderEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getMedicationHeader().unsetInvoiceItems(false);
			Assertions.assertEquals(medicationHeaderEntity, updatedInvoiceItemEntity.getMedicationHeader());

			prescriptionEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getPrescription().unsetInvoiceItems(false);
			Assertions.assertEquals(prescriptionEntity, updatedInvoiceItemEntity.getPrescription());

			retailPharmacyInvoiceEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getRetailPharmacyInvoice().unsetInvoiceItems(false);
			Assertions.assertEquals(retailPharmacyInvoiceEntity, updatedInvoiceItemEntity.getRetailPharmacyInvoice());

			serviceNumberEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getServiceNumber().unsetInvoiceItems(false);
			Assertions.assertEquals(serviceNumberEntity, updatedInvoiceItemEntity.getServiceNumber());

			tariffSchemaEntity.unsetInvoiceItems(false);
			updatedInvoiceItemEntity.getTariffSchema().unsetInvoiceItems(false);
			Assertions.assertEquals(tariffSchemaEntity, updatedInvoiceItemEntity.getTariffSchema());

			Assertions.assertEquals(invoiceItemComponentsEntities.size(), updatedInvoiceItemEntity.getInvoiceItemComponents().size());

		});
	}

	@Test
	public void whenCreateInvoiceItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceItemEntity invoiceItemEntity;
			Optional<InvoiceItemEntity> fetchedInvoiceItemEntity;

			try {
				invoiceItemEntity = invoiceItemFactory.getObject(false, false);
				invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceItemEntity = invoiceItemService.create(invoiceItemEntity);

			fetchedInvoiceItemEntity = invoiceItemService.findById(invoiceItemEntity.getId());

			Assertions.assertTrue(fetchedInvoiceItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInvoiceItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(invoiceItemEntity, fetchedInvoiceItemEntity.get());
		});
	}

	@Test
	public void whenUpdateInvoiceItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceItemEntity invoiceItemEntity;
			InvoiceItemEntity updatedInvoiceItemEntity;
			Optional<InvoiceItemEntity> fetchedInvoiceItemEntity;

			try {
				invoiceItemEntity = invoiceItemFactory.getObject(false, false);
				invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity, true, true, false);
				updatedInvoiceItemEntity = invoiceItemFactory.getObject(false, false);
				invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInvoiceItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceItemEntity = invoiceItemService.create(invoiceItemEntity);

			updatedInvoiceItemEntity.setId(invoiceItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInvoiceItemEntity.setCreated(invoiceItemEntity.getCreated());

			updatedInvoiceItemEntity = invoiceItemService.update(updatedInvoiceItemEntity);

			fetchedInvoiceItemEntity = invoiceItemService.findById(invoiceItemEntity.getId());

			Assertions.assertTrue(fetchedInvoiceItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInvoiceItemEntity_ThenEntityIsCreated
			fetchedInvoiceItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInvoiceItemEntity, fetchedInvoiceItemEntity.get());
		});
	}

	@Test
	public void whenDeleteInvoiceItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceItemEntity invoiceItemEntity;
			Optional<InvoiceItemEntity> fetchedInvoiceItemEntity;

			try {
				invoiceItemEntity = invoiceItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceItemEntity = invoiceItemService.create(invoiceItemEntity);

			invoiceItemService.deleteById(invoiceItemEntity.getId());
			fetchedInvoiceItemEntity = invoiceItemService.findById(invoiceItemEntity.getId());

			Assertions.assertTrue(fetchedInvoiceItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
