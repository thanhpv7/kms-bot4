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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class ServiceResolver implements GraphQLResolver<ServiceEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('BpjsPcarePoliEntity', 'read')")
	public BpjsPcarePoliEntity bpjsPcarePoli(ServiceEntity service) {
		return service.getBpjsPcarePoli();
	}

	@PreAuthorize("hasPermission('BpjsServiceMappingEntity', 'read')")
	public BpjsServiceMappingEntity bpjsServiceMapping(ServiceEntity service) {
		return service.getBpjsServiceMapping();
	}

	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	public Set<DoctorScheduleEntity> doctorSchedules(ServiceEntity service) {
		return service.getDoctorSchedules();
	}

	@PreAuthorize("hasPermission('ExaminationGroupEntity', 'read')")
	public Set<ExaminationGroupEntity> examinationGroups(ServiceEntity service) {
		return service.getExaminationGroups();
	}

	@PreAuthorize("hasPermission('McuPackageItemEntity', 'read')")
	public Set<McuPackageItemEntity> mcuPackageItems(ServiceEntity service) {
		return service.getMcuPackageItems();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> referringUnit(ServiceEntity service) {
		return service.getReferringUnit();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> registrations(ServiceEntity service) {
		return service.getRegistrations();
	}

	@PreAuthorize("hasPermission('ServiceFacilityCategoryEntity', 'read')")
	public Set<ServiceFacilityCategoryEntity> serviceFacilityCategories(ServiceEntity service) {
		return service.getServiceFacilityCategories();
	}

	@PreAuthorize("hasPermission('ServiceItemEntity', 'read')")
	public Set<ServiceItemEntity> serviceItems(ServiceEntity service) {
		return service.getServiceItems();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity defaultMedicalStaff(ServiceEntity service) {
		return service.getDefaultMedicalStaff();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public Set<StaffEntity> assignedMedicalStaff(ServiceEntity service) {
		return service.getAssignedMedicalStaff();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
