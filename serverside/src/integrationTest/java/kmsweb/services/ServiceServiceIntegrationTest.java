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
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
import kmsweb.entities.BpjsPcarePoliEntity;
import kmsweb.repositories.BpjsPcarePoliRepository;
import kmsweb.utils.BpjsPcarePoliFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcarePoliDatabasePopulator;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.utils.BpjsServiceMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsServiceMappingDatabasePopulator;
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.utils.DoctorScheduleFactory;
import kmsweb.utils.DatabasePopulators.DoctorScheduleDatabasePopulator;
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.repositories.ExaminationGroupRepository;
import kmsweb.utils.ExaminationGroupFactory;
import kmsweb.utils.DatabasePopulators.ExaminationGroupDatabasePopulator;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.utils.McuPackageItemFactory;
import kmsweb.utils.DatabasePopulators.McuPackageItemDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.ServiceFacilityCategoryEntity;
import kmsweb.repositories.ServiceFacilityCategoryRepository;
import kmsweb.utils.ServiceFacilityCategoryFactory;
import kmsweb.utils.DatabasePopulators.ServiceFacilityCategoryDatabasePopulator;
import kmsweb.entities.ServiceItemEntity;
import kmsweb.repositories.ServiceItemRepository;
import kmsweb.utils.ServiceItemFactory;
import kmsweb.utils.DatabasePopulators.ServiceItemDatabasePopulator;
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
public class ServiceServiceIntegrationTest {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ServiceService serviceService;

	private final ServiceFactory serviceFactory = new ServiceFactory();

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	@Autowired
	private BpjsPcarePoliRepository bpjsPcarePoliRepository;

	@Autowired
	private BpjsPcarePoliDatabasePopulator bpjsPcarePoliDatabasePopulator;

	private final BpjsPcarePoliFactory bpjsPcarePoliFactory = new BpjsPcarePoliFactory();

	@Autowired
	private BpjsServiceMappingRepository bpjsServiceMappingRepository;

	@Autowired
	private BpjsServiceMappingDatabasePopulator bpjsServiceMappingDatabasePopulator;

	private final BpjsServiceMappingFactory bpjsServiceMappingFactory = new BpjsServiceMappingFactory();

	@Autowired
	private DoctorScheduleRepository doctorScheduleRepository;

	@Autowired
	private DoctorScheduleDatabasePopulator doctorScheduleDatabasePopulator;

	private final DoctorScheduleFactory doctorScheduleFactory = new DoctorScheduleFactory();

	@Autowired
	private ExaminationGroupRepository examinationGroupRepository;

	@Autowired
	private ExaminationGroupDatabasePopulator examinationGroupDatabasePopulator;

	private final ExaminationGroupFactory examinationGroupFactory = new ExaminationGroupFactory();

	@Autowired
	private McuPackageItemRepository mcuPackageItemRepository;

	@Autowired
	private McuPackageItemDatabasePopulator mcuPackageItemDatabasePopulator;

	private final McuPackageItemFactory mcuPackageItemFactory = new McuPackageItemFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private ServiceFacilityCategoryRepository serviceFacilityCategoryRepository;

	@Autowired
	private ServiceFacilityCategoryDatabasePopulator serviceFacilityCategoryDatabasePopulator;

	private final ServiceFacilityCategoryFactory serviceFacilityCategoryFactory = new ServiceFacilityCategoryFactory();

	@Autowired
	private ServiceItemRepository serviceItemRepository;

	@Autowired
	private ServiceItemDatabasePopulator serviceItemDatabasePopulator;

	private final ServiceItemFactory serviceItemFactory = new ServiceItemFactory();

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
		serviceService = new ServiceService(
			bpjsPcarePoliRepository,
			bpjsServiceMappingRepository,
			doctorScheduleRepository,
			examinationGroupRepository,
			mcuPackageItemRepository,
			registrationRepository,
			serviceFacilityCategoryRepository,
			serviceItemRepository,
			staffRepository,
			validator,
			auditRepository,
			serviceRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewServiceEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ServiceEntity serviceEntity = serviceFactory.getObject(false, false);

		ServiceEntity updatedEntity = serviceService.updateOldData(serviceEntity);
		Assertions.assertEquals(serviceEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewServiceEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		ServiceEntity serviceEntity = serviceFactory.getObject(false, false);

		serviceEntity.setByPassDoctorAssignment(null);
		Assertions.assertNull(serviceEntity.getByPassDoctorAssignment());

		serviceEntity.setHasExaminationItem(null);
		Assertions.assertNull(serviceEntity.getHasExaminationItem());


		ServiceEntity updatedEntity = serviceService.updateOldData(serviceEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getByPassDoctorAssignment());
		Assertions.assertFalse(updatedEntity.getByPassDoctorAssignment());

		Assertions.assertNotNull(updatedEntity.getHasExaminationItem());
		Assertions.assertFalse(updatedEntity.getHasExaminationItem());

	}

	@Test
	public void updateOldDataWithExistingServiceEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceEntity serviceEntity;
			ServiceEntity entityWithUpdatedValues;

			try {
				serviceEntity = serviceFactory.getObject(false, false);
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = serviceFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceEntity = serviceService.create(serviceEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(serviceEntity.getId());

			ServiceEntity updatedEntity = serviceService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithServiceEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ServiceEntity serviceEntity = serviceFactory.getObject(false, false);
		serviceEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			serviceService.updateOldData(serviceEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingServiceEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceEntity serviceEntity;
			ServiceEntity updatedServiceEntity;

			StaffEntity defaultMedicalStaffEntity;

			BpjsPcarePoliEntity bpjsPcarePoliEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			Set<DoctorScheduleEntity> doctorSchedulesEntities;

			Set<ExaminationGroupEntity> examinationGroupsEntities;

			Set<McuPackageItemEntity> mcuPackageItemsEntities;

			Set<RegistrationEntity> referringUnitEntities;

			Set<RegistrationEntity> registrationsEntities;

			Set<ServiceFacilityCategoryEntity> serviceFacilityCategoriesEntities;

			Set<ServiceItemEntity> serviceItemsEntities;

			Set<StaffEntity> assignedMedicalStaffEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				serviceEntity = serviceFactory.getObject(true, false);
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
			defaultMedicalStaffEntity = serviceEntity.getDefaultMedicalStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(defaultMedicalStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			defaultMedicalStaffEntity = staffRepository.save(defaultMedicalStaffEntity);
			serviceEntity.setDefaultMedicalStaffId(defaultMedicalStaffEntity.getId());

			bpjsPcarePoliEntity = serviceEntity.getBpjsPcarePoli();
			try {
				bpjsPcarePoliDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcarePoliEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsPcarePoliEntity = bpjsPcarePoliRepository.save(bpjsPcarePoliEntity);
			serviceEntity.setBpjsPcarePoliId(bpjsPcarePoliEntity.getId());

			bpjsServiceMappingEntity = serviceEntity.getBpjsServiceMapping();
			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.save(bpjsServiceMappingEntity);
			serviceEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			doctorSchedulesEntities = serviceEntity.getDoctorSchedules();
			Set<UUID> doctorSchedulesEntityIds = new HashSet<>();
			for (DoctorScheduleEntity entity : doctorSchedulesEntities) {
				try {
					doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				doctorSchedulesEntityIds.add(doctorScheduleRepository.save(entity).getId());
			}
			serviceEntity.setDoctorSchedulesIds(doctorSchedulesEntityIds);

			examinationGroupsEntities = serviceEntity.getExaminationGroups();
			Set<UUID> examinationGroupsEntityIds = new HashSet<>();
			for (ExaminationGroupEntity entity : examinationGroupsEntities) {
				try {
					examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				examinationGroupsEntityIds.add(examinationGroupRepository.save(entity).getId());
			}
			serviceEntity.setExaminationGroupsIds(examinationGroupsEntityIds);

			mcuPackageItemsEntities = serviceEntity.getMcuPackageItems();
			Set<UUID> mcuPackageItemsEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : mcuPackageItemsEntities) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				mcuPackageItemsEntityIds.add(mcuPackageItemRepository.save(entity).getId());
			}
			serviceEntity.setMcuPackageItemsIds(mcuPackageItemsEntityIds);

			referringUnitEntities = serviceEntity.getReferringUnit();
			Set<UUID> referringUnitEntityIds = new HashSet<>();
			for (RegistrationEntity entity : referringUnitEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				referringUnitEntityIds.add(registrationRepository.save(entity).getId());
			}
			serviceEntity.setReferringUnitIds(referringUnitEntityIds);

			registrationsEntities = serviceEntity.getRegistrations();
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
			serviceEntity.setRegistrationsIds(registrationsEntityIds);

			serviceFacilityCategoriesEntities = serviceEntity.getServiceFacilityCategories();
			Set<UUID> serviceFacilityCategoriesEntityIds = new HashSet<>();
			for (ServiceFacilityCategoryEntity entity : serviceFacilityCategoriesEntities) {
				try {
					serviceFacilityCategoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				serviceFacilityCategoriesEntityIds.add(serviceFacilityCategoryRepository.save(entity).getId());
			}
			serviceEntity.setServiceFacilityCategoriesIds(serviceFacilityCategoriesEntityIds);

			serviceItemsEntities = serviceEntity.getServiceItems();
			Set<UUID> serviceItemsEntityIds = new HashSet<>();
			for (ServiceItemEntity entity : serviceItemsEntities) {
				try {
					serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				serviceItemsEntityIds.add(serviceItemRepository.save(entity).getId());
			}
			serviceEntity.setServiceItemsIds(serviceItemsEntityIds);

			assignedMedicalStaffEntities = serviceEntity.getAssignedMedicalStaff();
			Set<UUID> assignedMedicalStaffEntityIds = new HashSet<>();
			for (StaffEntity entity : assignedMedicalStaffEntities) {
				try {
					staffDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				assignedMedicalStaffEntityIds.add(staffRepository.save(entity).getId());
			}
			serviceEntity.setAssignedMedicalStaffIds(assignedMedicalStaffEntityIds);

			serviceEntity = serviceService.create(serviceEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(serviceEntity.getDefaultMedicalStaff());
			serviceEntity.setDefaultMedicalStaffId(null);
			serviceEntity.unsetDefaultMedicalStaff();

			Assertions.assertNotNull(serviceEntity.getBpjsPcarePoli());
			serviceEntity.setBpjsPcarePoliId(null);
			serviceEntity.unsetBpjsPcarePoli();

			Assertions.assertNotNull(serviceEntity.getBpjsServiceMapping());
			serviceEntity.setBpjsServiceMappingId(null);
			serviceEntity.unsetBpjsServiceMapping();

			Assertions.assertTrue(serviceEntity.getDoctorSchedules().size() > 0);
			serviceEntity.setDoctorSchedulesIds(new HashSet<UUID>());
			serviceEntity.unsetDoctorSchedules();

			Assertions.assertTrue(serviceEntity.getExaminationGroups().size() > 0);
			serviceEntity.setExaminationGroupsIds(new HashSet<UUID>());
			serviceEntity.unsetExaminationGroups();

			Assertions.assertTrue(serviceEntity.getMcuPackageItems().size() > 0);
			serviceEntity.setMcuPackageItemsIds(new HashSet<UUID>());
			serviceEntity.unsetMcuPackageItems();

			Assertions.assertTrue(serviceEntity.getReferringUnit().size() > 0);
			serviceEntity.setReferringUnitIds(new HashSet<UUID>());
			serviceEntity.unsetReferringUnit();

			Assertions.assertTrue(serviceEntity.getRegistrations().size() > 0);
			serviceEntity.setRegistrationsIds(new HashSet<UUID>());
			serviceEntity.unsetRegistrations();

			Assertions.assertTrue(serviceEntity.getServiceFacilityCategories().size() > 0);
			serviceEntity.setServiceFacilityCategoriesIds(new HashSet<UUID>());
			serviceEntity.unsetServiceFacilityCategories();

			Assertions.assertTrue(serviceEntity.getServiceItems().size() > 0);
			serviceEntity.setServiceItemsIds(new HashSet<UUID>());
			serviceEntity.unsetServiceItems();

			Assertions.assertTrue(serviceEntity.getAssignedMedicalStaff().size() > 0);
			serviceEntity.setAssignedMedicalStaffIds(new HashSet<UUID>());
			serviceEntity.unsetAssignedMedicalStaff();


			updatedServiceEntity = serviceService.updateOldData(serviceEntity);

			Assertions.assertNull(updatedServiceEntity.getDefaultMedicalStaff());

			Assertions.assertNull(updatedServiceEntity.getBpjsPcarePoli());

			Assertions.assertNull(updatedServiceEntity.getBpjsServiceMapping());

			Assertions.assertEquals(0, updatedServiceEntity.getDoctorSchedules().size());

			Assertions.assertEquals(0, updatedServiceEntity.getExaminationGroups().size());

			Assertions.assertEquals(0, updatedServiceEntity.getMcuPackageItems().size());

			Assertions.assertEquals(0, updatedServiceEntity.getReferringUnit().size());

			Assertions.assertEquals(0, updatedServiceEntity.getRegistrations().size());

			Assertions.assertEquals(0, updatedServiceEntity.getServiceFacilityCategories().size());

			Assertions.assertEquals(0, updatedServiceEntity.getServiceItems().size());

			Assertions.assertEquals(0, updatedServiceEntity.getAssignedMedicalStaff().size());

		});
	}

	@Test
	public void updateOldDataWithServiceEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceEntity serviceEntity;
			ServiceEntity updatedServiceEntity;

			StaffEntity defaultMedicalStaffEntity;

			BpjsPcarePoliEntity bpjsPcarePoliEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			Set<DoctorScheduleEntity> doctorSchedulesEntities;
			Set<UUID> doctorSchedulesEntityIds;

			Set<ExaminationGroupEntity> examinationGroupsEntities;
			Set<UUID> examinationGroupsEntityIds;

			Set<McuPackageItemEntity> mcuPackageItemsEntities;
			Set<UUID> mcuPackageItemsEntityIds;

			Set<RegistrationEntity> referringUnitEntities;
			Set<UUID> referringUnitEntityIds;

			Set<RegistrationEntity> registrationsEntities;
			Set<UUID> registrationsEntityIds;

			Set<ServiceFacilityCategoryEntity> serviceFacilityCategoriesEntities;
			Set<UUID> serviceFacilityCategoriesEntityIds;

			Set<ServiceItemEntity> serviceItemsEntities;
			Set<UUID> serviceItemsEntityIds;

			Set<StaffEntity> assignedMedicalStaffEntities;
			Set<UUID> assignedMedicalStaffEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				serviceEntity = serviceFactory.getObject(true, false);
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
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity.getDefaultMedicalStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Default Medical Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			defaultMedicalStaffEntity = staffRepository.findById(staffRepository.save(serviceEntity.getDefaultMedicalStaff()).getId()).get();
			serviceEntity.unsetDefaultMedicalStaff();
			serviceEntity.setDefaultMedicalStaffId(defaultMedicalStaffEntity.getId());

			try {
				bpjsPcarePoliDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity.getBpjsPcarePoli(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Pcare Poli relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsPcarePoliEntity = bpjsPcarePoliRepository.findById(bpjsPcarePoliRepository.save(serviceEntity.getBpjsPcarePoli()).getId()).get();
			serviceEntity.unsetBpjsPcarePoli();
			serviceEntity.setBpjsPcarePoliId(bpjsPcarePoliEntity.getId());

			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity.getBpjsServiceMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Service Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.findById(bpjsServiceMappingRepository.save(serviceEntity.getBpjsServiceMapping()).getId()).get();
			serviceEntity.unsetBpjsServiceMapping();
			serviceEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			doctorSchedulesEntities = new HashSet<>();
			doctorSchedulesEntityIds = new HashSet<>();
			for (DoctorScheduleEntity entity : serviceEntity.getDoctorSchedules()) {
				try {
					doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Doctor Schedules relation for this test: " + e.getCause());
					return;
				}
				UUID id = doctorScheduleRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				doctorSchedulesEntities.add(doctorScheduleRepository.findById(id).get());
				doctorSchedulesEntityIds.add(id);
			}
			serviceEntity.unsetDoctorSchedules();
			serviceEntity.setDoctorSchedulesIds(doctorSchedulesEntityIds);

			examinationGroupsEntities = new HashSet<>();
			examinationGroupsEntityIds = new HashSet<>();
			for (ExaminationGroupEntity entity : serviceEntity.getExaminationGroups()) {
				try {
					examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Examination Groups relation for this test: " + e.getCause());
					return;
				}
				UUID id = examinationGroupRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				examinationGroupsEntities.add(examinationGroupRepository.findById(id).get());
				examinationGroupsEntityIds.add(id);
			}
			serviceEntity.unsetExaminationGroups();
			serviceEntity.setExaminationGroupsIds(examinationGroupsEntityIds);

			mcuPackageItemsEntities = new HashSet<>();
			mcuPackageItemsEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : serviceEntity.getMcuPackageItems()) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the MCU Package Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = mcuPackageItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				mcuPackageItemsEntities.add(mcuPackageItemRepository.findById(id).get());
				mcuPackageItemsEntityIds.add(id);
			}
			serviceEntity.unsetMcuPackageItems();
			serviceEntity.setMcuPackageItemsIds(mcuPackageItemsEntityIds);

			referringUnitEntities = new HashSet<>();
			referringUnitEntityIds = new HashSet<>();
			for (RegistrationEntity entity : serviceEntity.getReferringUnit()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Referring Unit relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				referringUnitEntities.add(registrationRepository.findById(id).get());
				referringUnitEntityIds.add(id);
			}
			serviceEntity.unsetReferringUnit();
			serviceEntity.setReferringUnitIds(referringUnitEntityIds);

			registrationsEntities = new HashSet<>();
			registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : serviceEntity.getRegistrations()) {
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
			serviceEntity.unsetRegistrations();
			serviceEntity.setRegistrationsIds(registrationsEntityIds);

			serviceFacilityCategoriesEntities = new HashSet<>();
			serviceFacilityCategoriesEntityIds = new HashSet<>();
			for (ServiceFacilityCategoryEntity entity : serviceEntity.getServiceFacilityCategories()) {
				try {
					serviceFacilityCategoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Service Facility Categories relation for this test: " + e.getCause());
					return;
				}
				UUID id = serviceFacilityCategoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				serviceFacilityCategoriesEntities.add(serviceFacilityCategoryRepository.findById(id).get());
				serviceFacilityCategoriesEntityIds.add(id);
			}
			serviceEntity.unsetServiceFacilityCategories();
			serviceEntity.setServiceFacilityCategoriesIds(serviceFacilityCategoriesEntityIds);

			serviceItemsEntities = new HashSet<>();
			serviceItemsEntityIds = new HashSet<>();
			for (ServiceItemEntity entity : serviceEntity.getServiceItems()) {
				try {
					serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Service Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = serviceItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				serviceItemsEntities.add(serviceItemRepository.findById(id).get());
				serviceItemsEntityIds.add(id);
			}
			serviceEntity.unsetServiceItems();
			serviceEntity.setServiceItemsIds(serviceItemsEntityIds);

			assignedMedicalStaffEntities = new HashSet<>();
			assignedMedicalStaffEntityIds = new HashSet<>();
			for (StaffEntity entity : serviceEntity.getAssignedMedicalStaff()) {
				try {
					staffDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Assigned Medical Staff relation for this test: " + e.getCause());
					return;
				}
				UUID id = staffRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				assignedMedicalStaffEntities.add(staffRepository.findById(id).get());
				assignedMedicalStaffEntityIds.add(id);
			}
			serviceEntity.unsetAssignedMedicalStaff();
			serviceEntity.setAssignedMedicalStaffIds(assignedMedicalStaffEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedServiceEntity = serviceService.updateOldData(serviceEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			defaultMedicalStaffEntity.unsetService(false);
			updatedServiceEntity.getDefaultMedicalStaff().unsetService(false);
			Assertions.assertEquals(defaultMedicalStaffEntity, updatedServiceEntity.getDefaultMedicalStaff());

			bpjsPcarePoliEntity.unsetService(false);
			updatedServiceEntity.getBpjsPcarePoli().unsetService(false);
			Assertions.assertEquals(bpjsPcarePoliEntity, updatedServiceEntity.getBpjsPcarePoli());

			bpjsServiceMappingEntity.unsetService(false);
			updatedServiceEntity.getBpjsServiceMapping().unsetService(false);
			Assertions.assertEquals(bpjsServiceMappingEntity, updatedServiceEntity.getBpjsServiceMapping());

			Assertions.assertEquals(doctorSchedulesEntities.size(), updatedServiceEntity.getDoctorSchedules().size());

			Assertions.assertEquals(examinationGroupsEntities.size(), updatedServiceEntity.getExaminationGroups().size());

			Assertions.assertEquals(mcuPackageItemsEntities.size(), updatedServiceEntity.getMcuPackageItems().size());

			Assertions.assertEquals(referringUnitEntities.size(), updatedServiceEntity.getReferringUnit().size());

			Assertions.assertEquals(registrationsEntities.size(), updatedServiceEntity.getRegistrations().size());

			Assertions.assertEquals(serviceFacilityCategoriesEntities.size(), updatedServiceEntity.getServiceFacilityCategories().size());

			Assertions.assertEquals(serviceItemsEntities.size(), updatedServiceEntity.getServiceItems().size());

			Assertions.assertEquals(assignedMedicalStaffEntities.size(), updatedServiceEntity.getAssignedMedicalStaff().size());

		});
	}

	@Test
	public void whenCreateServiceEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceEntity serviceEntity;
			Optional<ServiceEntity> fetchedServiceEntity;

			try {
				serviceEntity = serviceFactory.getObject(false, false);
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceEntity = serviceService.create(serviceEntity);

			fetchedServiceEntity = serviceService.findById(serviceEntity.getId());

			Assertions.assertTrue(fetchedServiceEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedServiceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(serviceEntity, fetchedServiceEntity.get());
		});
	}

	@Test
	public void whenUpdateServiceEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceEntity serviceEntity;
			ServiceEntity updatedServiceEntity;
			Optional<ServiceEntity> fetchedServiceEntity;

			try {
				serviceEntity = serviceFactory.getObject(false, false);
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, false);
				updatedServiceEntity = serviceFactory.getObject(false, false);
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(updatedServiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceEntity = serviceService.create(serviceEntity);

			updatedServiceEntity.setId(serviceEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedServiceEntity.setCreated(serviceEntity.getCreated());

			updatedServiceEntity = serviceService.update(updatedServiceEntity);

			fetchedServiceEntity = serviceService.findById(serviceEntity.getId());

			Assertions.assertTrue(fetchedServiceEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateServiceEntity_ThenEntityIsCreated
			fetchedServiceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedServiceEntity, fetchedServiceEntity.get());
		});
	}

	@Test
	public void whenDeleteServiceEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceEntity serviceEntity;
			Optional<ServiceEntity> fetchedServiceEntity;

			try {
				serviceEntity = serviceFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceEntity = serviceService.create(serviceEntity);

			serviceService.deleteById(serviceEntity.getId());
			fetchedServiceEntity = serviceService.findById(serviceEntity.getId());

			Assertions.assertTrue(fetchedServiceEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
