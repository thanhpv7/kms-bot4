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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import lombok.*;
import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for ServiceEntity")
@EqualsAndHashCode(callSuper = false)
public class ServiceEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String serviceNumber;

	private String serviceName;

	private String sectionCode;

	private Boolean byPassDoctorAssignment;

	private Boolean hasExaminationItem;

	private String revenueCenter;

	private String serviceCode;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsPcarePoliEntity bpjsPcarePoli;

	private BpjsServiceMappingEntity bpjsServiceMapping;

	private Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();

	private Set<ExaminationGroupEntity> examinationGroups = new HashSet<>();

	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	private Set<RegistrationEntity> referringUnit = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	private Set<ServiceFacilityCategoryEntity> serviceFacilityCategories = new HashSet<>();

	private Set<ServiceItemEntity> serviceItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity defaultMedicalStaff;

	private Set<StaffEntity> assignedMedicalStaff = new HashSet<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
