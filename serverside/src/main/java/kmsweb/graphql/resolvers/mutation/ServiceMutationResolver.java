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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.ServiceEntity;
import kmsweb.services.ServiceService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsPcarePoliService;
import kmsweb.entities.BpjsPcarePoliEntity;
import kmsweb.services.BpjsServiceMappingService;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.services.DoctorScheduleService;
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.services.ExaminationGroupService;
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.services.McuPackageItemService;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.ServiceFacilityCategoryService;
import kmsweb.entities.ServiceFacilityCategoryEntity;
import kmsweb.services.ServiceItemService;
import kmsweb.entities.ServiceItemEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class ServiceMutationResolver implements GraphQLMutationResolver {

	private final ServiceService serviceService;

	private final BpjsPcarePoliService bpjsPcarePoliService;

	private final BpjsServiceMappingService bpjsServiceMappingService;

	private final DoctorScheduleService doctorScheduleService;

	private final ExaminationGroupService examinationGroupService;

	private final McuPackageItemService mcuPackageItemService;

	private final RegistrationService registrationService;

	private final ServiceFacilityCategoryService serviceFacilityCategoryService;

	private final ServiceItemService serviceItemService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ServiceMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsPcarePoliService bpjsPcarePoliService,
			BpjsServiceMappingService bpjsServiceMappingService,
			DoctorScheduleService doctorScheduleService,
			ExaminationGroupService examinationGroupService,
			McuPackageItemService mcuPackageItemService,
			RegistrationService registrationService,
			ServiceFacilityCategoryService serviceFacilityCategoryService,
			ServiceItemService serviceItemService,
			StaffService staffService,
			ServiceService serviceService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.serviceService = serviceService;

		this.bpjsPcarePoliService = bpjsPcarePoliService;

		this.bpjsServiceMappingService = bpjsServiceMappingService;

		this.doctorScheduleService = doctorScheduleService;

		this.examinationGroupService = examinationGroupService;

		this.mcuPackageItemService = mcuPackageItemService;

		this.registrationService = registrationService;

		this.serviceFacilityCategoryService = serviceFacilityCategoryService;

		this.serviceItemService = serviceItemService;

		this.staffService = staffService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'create')")
	public ServiceEntity createService(@NonNull ServiceEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDefaultMedicalStaff() != null) {
			rawEntity.setDefaultMedicalStaff(staffService.updateOldData(rawEntity.getDefaultMedicalStaff()));
		}

		if (rawEntity.getBpjsPcarePoli() != null) {
			rawEntity.setBpjsPcarePoli(bpjsPcarePoliService.updateOldData(rawEntity.getBpjsPcarePoli()));
		}

		if (rawEntity.getBpjsServiceMapping() != null) {
			rawEntity.setBpjsServiceMapping(bpjsServiceMappingService.updateOldData(rawEntity.getBpjsServiceMapping()));
		}

		Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();
		rawEntity.getDoctorSchedules().forEach(entity -> {
			doctorSchedules.add(doctorScheduleService.updateOldData(entity));
		});
		rawEntity.setDoctorSchedules(doctorSchedules);

		Set<ExaminationGroupEntity> examinationGroups = new HashSet<>();
		rawEntity.getExaminationGroups().forEach(entity -> {
			examinationGroups.add(examinationGroupService.updateOldData(entity));
		});
		rawEntity.setExaminationGroups(examinationGroups);

		Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();
		rawEntity.getMcuPackageItems().forEach(entity -> {
			mcuPackageItems.add(mcuPackageItemService.updateOldData(entity));
		});
		rawEntity.setMcuPackageItems(mcuPackageItems);

		Set<RegistrationEntity> referringUnit = new HashSet<>();
		rawEntity.getReferringUnit().forEach(entity -> {
			referringUnit.add(registrationService.updateOldData(entity));
		});
		rawEntity.setReferringUnit(referringUnit);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		Set<ServiceFacilityCategoryEntity> serviceFacilityCategories = new HashSet<>();
		rawEntity.getServiceFacilityCategories().forEach(entity -> {
			serviceFacilityCategories.add(serviceFacilityCategoryService.updateOldData(entity));
		});
		rawEntity.setServiceFacilityCategories(serviceFacilityCategories);

		Set<ServiceItemEntity> serviceItems = new HashSet<>();
		rawEntity.getServiceItems().forEach(entity -> {
			serviceItems.add(serviceItemService.updateOldData(entity));
		});
		rawEntity.setServiceItems(serviceItems);

		Set<StaffEntity> assignedMedicalStaff = new HashSet<>();
		rawEntity.getAssignedMedicalStaff().forEach(entity -> {
			assignedMedicalStaff.add(staffService.updateOldData(entity));
		});
		rawEntity.setAssignedMedicalStaff(assignedMedicalStaff);

		ServiceEntity newEntity = serviceService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ServiceMutationResolver#createService(ServiceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'create')")
	public List<ServiceEntity> createAllService(@NonNull List<ServiceEntity> rawEntities) {
		List<ServiceEntity> newEntities = Lists.newArrayList(serviceService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'update')")
	public ServiceEntity updateService(@NonNull ServiceEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDefaultMedicalStaff() != null) {
			rawEntity.setDefaultMedicalStaff(staffService.updateOldData(rawEntity.getDefaultMedicalStaff()));
		}

		if (rawEntity.getBpjsPcarePoli() != null) {
			rawEntity.setBpjsPcarePoli(bpjsPcarePoliService.updateOldData(rawEntity.getBpjsPcarePoli()));
		}

		if (rawEntity.getBpjsServiceMapping() != null) {
			rawEntity.setBpjsServiceMapping(bpjsServiceMappingService.updateOldData(rawEntity.getBpjsServiceMapping()));
		}

		Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();
		rawEntity.getDoctorSchedules().forEach(entity -> {
			doctorSchedules.add(doctorScheduleService.updateOldData(entity));
		});
		rawEntity.setDoctorSchedules(doctorSchedules);

		Set<ExaminationGroupEntity> examinationGroups = new HashSet<>();
		rawEntity.getExaminationGroups().forEach(entity -> {
			examinationGroups.add(examinationGroupService.updateOldData(entity));
		});
		rawEntity.setExaminationGroups(examinationGroups);

		Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();
		rawEntity.getMcuPackageItems().forEach(entity -> {
			mcuPackageItems.add(mcuPackageItemService.updateOldData(entity));
		});
		rawEntity.setMcuPackageItems(mcuPackageItems);

		Set<RegistrationEntity> referringUnit = new HashSet<>();
		rawEntity.getReferringUnit().forEach(entity -> {
			referringUnit.add(registrationService.updateOldData(entity));
		});
		rawEntity.setReferringUnit(referringUnit);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		Set<ServiceFacilityCategoryEntity> serviceFacilityCategories = new HashSet<>();
		rawEntity.getServiceFacilityCategories().forEach(entity -> {
			serviceFacilityCategories.add(serviceFacilityCategoryService.updateOldData(entity));
		});
		rawEntity.setServiceFacilityCategories(serviceFacilityCategories);

		Set<ServiceItemEntity> serviceItems = new HashSet<>();
		rawEntity.getServiceItems().forEach(entity -> {
			serviceItems.add(serviceItemService.updateOldData(entity));
		});
		rawEntity.setServiceItems(serviceItems);

		Set<StaffEntity> assignedMedicalStaff = new HashSet<>();
		rawEntity.getAssignedMedicalStaff().forEach(entity -> {
			assignedMedicalStaff.add(staffService.updateOldData(entity));
		});
		rawEntity.setAssignedMedicalStaff(assignedMedicalStaff);

		ServiceEntity entityFromDb = serviceService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		ServiceEntity newEntity = serviceService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ServiceMutationResolver#updateService(ServiceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'update')")
	public List<ServiceEntity> updateAllService(@NonNull List<ServiceEntity> rawEntities) {
		List<ServiceEntity> newEntities = Lists.newArrayList(serviceService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'delete')")
	public String deleteServiceById(@NonNull String id) {
		serviceService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link ServiceMutationResolver#deleteServiceById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'delete')")
	public List<String> deleteAllServiceByIds(@NonNull List<String> ids) {
		serviceService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('ServiceEntity', 'delete')")
	public List<String> deleteServiceExcludingIds(@NonNull List<String> ids) {
		serviceService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
