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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class ServiceEntity extends AbstractEntity {

	public ServiceEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsPcarePoliOneOne = new EntityReference();
			BpjsPcarePoliOneOne.entityName = "BpjsPcarePoli";
			BpjsPcarePoliOneOne.oppositeName = "Service";
			BpjsPcarePoliOneOne.name = "BpjsPcarePoli";
			BpjsPcarePoliOneOne.optional = true;
			BpjsPcarePoliOneOne.type = "One";
			BpjsPcarePoliOneOne.oppositeType = "One";

		References.add(BpjsPcarePoliOneOne);

		var BpjsServiceMappingOneOne = new EntityReference();
			BpjsServiceMappingOneOne.entityName = "BpjsServiceMapping";
			BpjsServiceMappingOneOne.oppositeName = "Service";
			BpjsServiceMappingOneOne.name = "BpjsServiceMapping";
			BpjsServiceMappingOneOne.optional = true;
			BpjsServiceMappingOneOne.type = "One";
			BpjsServiceMappingOneOne.oppositeType = "One";

		References.add(BpjsServiceMappingOneOne);

		var DoctorSchedulesOneMany = new EntityReference();
			DoctorSchedulesOneMany.entityName = "DoctorSchedule";
			DoctorSchedulesOneMany.oppositeName = "Service";
			DoctorSchedulesOneMany.name = "DoctorSchedules";
			DoctorSchedulesOneMany.optional = true;
			DoctorSchedulesOneMany.type = "One";
			DoctorSchedulesOneMany.oppositeType = "Many";

		References.add(DoctorSchedulesOneMany);

		var ExaminationGroupsOneMany = new EntityReference();
			ExaminationGroupsOneMany.entityName = "ExaminationGroup";
			ExaminationGroupsOneMany.oppositeName = "Service";
			ExaminationGroupsOneMany.name = "ExaminationGroups";
			ExaminationGroupsOneMany.optional = true;
			ExaminationGroupsOneMany.type = "One";
			ExaminationGroupsOneMany.oppositeType = "Many";

		References.add(ExaminationGroupsOneMany);

		var McuPackageItemsOneMany = new EntityReference();
			McuPackageItemsOneMany.entityName = "McuPackageItem";
			McuPackageItemsOneMany.oppositeName = "Service";
			McuPackageItemsOneMany.name = "McuPackageItems";
			McuPackageItemsOneMany.optional = true;
			McuPackageItemsOneMany.type = "One";
			McuPackageItemsOneMany.oppositeType = "Many";

		References.add(McuPackageItemsOneMany);

		var ReferringUnitOneMany = new EntityReference();
			ReferringUnitOneMany.entityName = "Registration";
			ReferringUnitOneMany.oppositeName = "ReferringUnit";
			ReferringUnitOneMany.name = "ReferringUnit";
			ReferringUnitOneMany.optional = true;
			ReferringUnitOneMany.type = "One";
			ReferringUnitOneMany.oppositeType = "Many";

		References.add(ReferringUnitOneMany);

		var RegistrationsOneMany = new EntityReference();
			RegistrationsOneMany.entityName = "Registration";
			RegistrationsOneMany.oppositeName = "Service";
			RegistrationsOneMany.name = "Registrations";
			RegistrationsOneMany.optional = true;
			RegistrationsOneMany.type = "One";
			RegistrationsOneMany.oppositeType = "Many";

		References.add(RegistrationsOneMany);

		var ServiceFacilityCategoriesOneMany = new EntityReference();
			ServiceFacilityCategoriesOneMany.entityName = "ServiceFacilityCategory";
			ServiceFacilityCategoriesOneMany.oppositeName = "Service";
			ServiceFacilityCategoriesOneMany.name = "ServiceFacilityCategories";
			ServiceFacilityCategoriesOneMany.optional = true;
			ServiceFacilityCategoriesOneMany.type = "One";
			ServiceFacilityCategoriesOneMany.oppositeType = "Many";

		References.add(ServiceFacilityCategoriesOneMany);

		var ServiceItemsManyMany = new EntityReference();
			ServiceItemsManyMany.entityName = "ServiceItem";
			ServiceItemsManyMany.oppositeName = "Services";
			ServiceItemsManyMany.name = "ServiceItems";
			ServiceItemsManyMany.optional = true;
			ServiceItemsManyMany.type = "Many";
			ServiceItemsManyMany.oppositeType = "Many";

		References.add(ServiceItemsManyMany);

		var DefaultMedicalStaffOneOne = new EntityReference();
			DefaultMedicalStaffOneOne.entityName = "Staff";
			DefaultMedicalStaffOneOne.oppositeName = "DefaultMedicalStaff";
			DefaultMedicalStaffOneOne.name = "Service";
			DefaultMedicalStaffOneOne.optional = true;
			DefaultMedicalStaffOneOne.type = "One";
			DefaultMedicalStaffOneOne.oppositeType = "One";

		References.add(DefaultMedicalStaffOneOne);

		var AssignedMedicalStaffManyMany = new EntityReference();
			AssignedMedicalStaffManyMany.entityName = "Staff";
			AssignedMedicalStaffManyMany.oppositeName = "AssignedMedicalStaff";
			AssignedMedicalStaffManyMany.name = "Services";
			AssignedMedicalStaffManyMany.optional = true;
			AssignedMedicalStaffManyMany.type = "Many";
			AssignedMedicalStaffManyMany.oppositeType = "Many";

		References.add(AssignedMedicalStaffManyMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Service Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Number here] end
	private String serviceNumber;

	// % protected region % [Modify attribute annotation for Service Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Name here] end
	private String serviceName;

	// % protected region % [Modify attribute annotation for Section Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Section Code here] end
	private String sectionCode;

	// % protected region % [Modify attribute annotation for By pass Doctor Assignment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for By pass Doctor Assignment here] end
	private Boolean byPassDoctorAssignment;

	// % protected region % [Modify attribute annotation for Has Examination Item here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Has Examination Item here] end
	private Boolean hasExaminationItem;

	// % protected region % [Modify attribute annotation for Revenue Center here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revenue Center here] end
	private String revenueCenter;

	// % protected region % [Modify attribute annotation for Service Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Code here] end
	private String serviceCode;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsPcarePoliEntity bpjsPcarePoli;

	private BpjsServiceMappingEntity bpjsServiceMapping;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity defaultMedicalStaff;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();

	private Set<ExaminationGroupEntity> examinationGroups = new HashSet<>();

	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	private Set<RegistrationEntity> referringUnit = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	private Set<ServiceFacilityCategoryEntity> serviceFacilityCategories = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<ServiceItemEntity> serviceItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<StaffEntity> assignedMedicalStaff = new HashSet<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsPcarePoli(BpjsPcarePoliEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setBpjsPcarePoli(@NonNull BpjsPcarePoliEntity entity) {
		setBpjsPcarePoli(entity, true);
	}

	/**
	 * Set or update bpjsPcarePoli with the given BpjsPcarePoliEntity.
	 *
	 * @param entity the ServiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcarePoli(@NonNull BpjsPcarePoliEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcarePoli here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcarePoli here] end

		if (sameAsFormer(this.bpjsPcarePoli, entity)) {
			return;
		}

		if (this.bpjsPcarePoli != null) {
			this.bpjsPcarePoli.unsetService();
		}

		this.bpjsPcarePoli = entity;

		if (reverseAdd) {
			this.bpjsPcarePoli.setService(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPcarePoli outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPcarePoli outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPcarePoli(boolean)} but default to true.
	 */
	public void unsetBpjsPcarePoli() {
		this.unsetBpjsPcarePoli(true);
	}

	/**
	 * Remove the BpjsPcarePoliEntity in BPJS Pcare Poli from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPcarePoli(boolean reverse) {
		if (reverse && this.bpjsPcarePoli != null) {
			this.bpjsPcarePoli.unsetService(false);
		}
		this.bpjsPcarePoli = null;
	}

	/**
	 * Similar to {@link this#setBpjsServiceMapping(BpjsServiceMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setBpjsServiceMapping(@NonNull BpjsServiceMappingEntity entity) {
		setBpjsServiceMapping(entity, true);
	}

	/**
	 * Set or update bpjsServiceMapping with the given BpjsServiceMappingEntity.
	 *
	 * @param entity the ServiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsServiceMapping(@NonNull BpjsServiceMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] end

		if (sameAsFormer(this.bpjsServiceMapping, entity)) {
			return;
		}

		if (this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.unsetService();
		}

		this.bpjsServiceMapping = entity;

		if (reverseAdd) {
			this.bpjsServiceMapping.setService(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsServiceMapping(boolean)} but default to true.
	 */
	public void unsetBpjsServiceMapping() {
		this.unsetBpjsServiceMapping(true);
	}

	/**
	 * Remove the BpjsServiceMappingEntity in BPJS Service Mapping from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsServiceMapping(boolean reverse) {
		if (reverse && this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.unsetService(false);
		}
		this.bpjsServiceMapping = null;
	}

/**
	 * Similar to {@link this#addDoctorSchedules(DoctorScheduleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorScheduleEntity to be added to this entity
	 */
	public void addDoctorSchedules(@NonNull DoctorScheduleEntity entity) {
		addDoctorSchedules(entity, true);
	}

	/**
	 * Add a new DoctorScheduleEntity to doctorSchedules in this entity.
	 *
	 * @param entity the given DoctorScheduleEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDoctorSchedules(@NonNull DoctorScheduleEntity entity, boolean reverseAdd) {
		if (!this.doctorSchedules.contains(entity)) {
			doctorSchedules.add(entity);
			if (reverseAdd) {
				entity.setService(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be added to this entity
	 */
	public void addDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities) {
		addDoctorSchedules(entities, true);
	}

	/**
	 * Add a new collection of DoctorScheduleEntity to Doctor Schedules in this entity.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDoctorSchedules(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDoctorSchedules(DoctorScheduleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorScheduleEntity to be set to this entity
	 */
	public void removeDoctorSchedules(@NonNull DoctorScheduleEntity entity) {
		this.removeDoctorSchedules(entity, true);
	}

	/**
	 * Remove the given DoctorScheduleEntity from this entity.
	 *
	 * @param entity the given DoctorScheduleEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDoctorSchedules(@NonNull DoctorScheduleEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetService(false);
		}
		this.doctorSchedules.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be removed to this entity
	 */
	public void removeDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities) {
		this.removeDoctorSchedules(entities, true);
	}

	/**
	 * Remove the given collection of DoctorScheduleEntity from  to this entity.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDoctorSchedules(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be set to this entity
	 */
	public void setDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities) {
		setDoctorSchedules(entities, true);
	}

	/**
	 * Replace the current entities in Doctor Schedules with the given ones.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {

		this.unsetDoctorSchedules();
		this.doctorSchedules = new HashSet<>(entities);
		if (reverseAdd) {
			this.doctorSchedules.forEach(doctorSchedulesEntity -> doctorSchedulesEntity.setService(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDoctorSchedules(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDoctorSchedules() {
		this.unsetDoctorSchedules(true);
	}

	/**
	 * Remove all the entities in Doctor Schedules from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDoctorSchedules(boolean doReverse) {
		if (doReverse) {
			this.doctorSchedules.forEach(doctorSchedulesEntity -> doctorSchedulesEntity.unsetService(false));
		}
		this.doctorSchedules.clear();
	}

/**
	 * Similar to {@link this#addExaminationGroups(ExaminationGroupEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationGroupEntity to be added to this entity
	 */
	public void addExaminationGroups(@NonNull ExaminationGroupEntity entity) {
		addExaminationGroups(entity, true);
	}

	/**
	 * Add a new ExaminationGroupEntity to examinationGroups in this entity.
	 *
	 * @param entity the given ExaminationGroupEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationGroups(@NonNull ExaminationGroupEntity entity, boolean reverseAdd) {
		if (!this.examinationGroups.contains(entity)) {
			examinationGroups.add(entity);
			if (reverseAdd) {
				entity.setService(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationGroups(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to be added to this entity
	 */
	public void addExaminationGroups(@NonNull Collection<ExaminationGroupEntity> entities) {
		addExaminationGroups(entities, true);
	}

	/**
	 * Add a new collection of ExaminationGroupEntity to Examination Groups in this entity.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationGroups(@NonNull Collection<ExaminationGroupEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addExaminationGroups(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationGroups(ExaminationGroupEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationGroupEntity to be set to this entity
	 */
	public void removeExaminationGroups(@NonNull ExaminationGroupEntity entity) {
		this.removeExaminationGroups(entity, true);
	}

	/**
	 * Remove the given ExaminationGroupEntity from this entity.
	 *
	 * @param entity the given ExaminationGroupEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationGroups(@NonNull ExaminationGroupEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetService(false);
		}
		this.examinationGroups.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationGroups(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to be removed to this entity
	 */
	public void removeExaminationGroups(@NonNull Collection<ExaminationGroupEntity> entities) {
		this.removeExaminationGroups(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationGroupEntity from  to this entity.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeExaminationGroups(@NonNull Collection<ExaminationGroupEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeExaminationGroups(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setExaminationGroups(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to be set to this entity
	 */
	public void setExaminationGroups(@NonNull Collection<ExaminationGroupEntity> entities) {
		setExaminationGroups(entities, true);
	}

	/**
	 * Replace the current entities in Examination Groups with the given ones.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationGroups(@NonNull Collection<ExaminationGroupEntity> entities, boolean reverseAdd) {

		this.unsetExaminationGroups();
		this.examinationGroups = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationGroups.forEach(examinationGroupsEntity -> examinationGroupsEntity.setService(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetExaminationGroups(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetExaminationGroups() {
		this.unsetExaminationGroups(true);
	}

	/**
	 * Remove all the entities in Examination Groups from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetExaminationGroups(boolean doReverse) {
		if (doReverse) {
			this.examinationGroups.forEach(examinationGroupsEntity -> examinationGroupsEntity.unsetService(false));
		}
		this.examinationGroups.clear();
	}

/**
	 * Similar to {@link this#addMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity) {
		addMcuPackageItems(entity, true);
	}

	/**
	 * Add a new McuPackageItemEntity to mcuPackageItems in this entity.
	 *
	 * @param entity the given McuPackageItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverseAdd) {
		if (!this.mcuPackageItems.contains(entity)) {
			mcuPackageItems.add(entity);
			if (reverseAdd) {
				entity.setService(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		addMcuPackageItems(entities, true);
	}

	/**
	 * Add a new collection of McuPackageItemEntity to MCU Package Items in this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be set to this entity
	 */
	public void removeMcuPackageItems(@NonNull McuPackageItemEntity entity) {
		this.removeMcuPackageItems(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the given McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetService(false);
		}
		this.mcuPackageItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		this.removeMcuPackageItems(entities, true);
	}

	/**
	 * Remove the given collection of McuPackageItemEntity from  to this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be set to this entity
	 */
	public void setMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		setMcuPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in MCU Package Items with the given ones.
	 *
	 * @param entities the given collection of McuPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {

		this.unsetMcuPackageItems();
		this.mcuPackageItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.setService(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMcuPackageItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMcuPackageItems() {
		this.unsetMcuPackageItems(true);
	}

	/**
	 * Remove all the entities in MCU Package Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMcuPackageItems(boolean doReverse) {
		if (doReverse) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.unsetService(false));
		}
		this.mcuPackageItems.clear();
	}

/**
	 * Similar to {@link this#addReferringUnit(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addReferringUnit(@NonNull RegistrationEntity entity) {
		addReferringUnit(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to referringUnit in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReferringUnit(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.referringUnit.contains(entity)) {
			referringUnit.add(entity);
			if (reverseAdd) {
				entity.setReferringUnit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReferringUnit(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addReferringUnit(@NonNull Collection<RegistrationEntity> entities) {
		addReferringUnit(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Referring Unit in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReferringUnit(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReferringUnit(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReferringUnit(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeReferringUnit(@NonNull RegistrationEntity entity) {
		this.removeReferringUnit(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReferringUnit(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetReferringUnit(false);
		}
		this.referringUnit.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReferringUnit(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeReferringUnit(@NonNull Collection<RegistrationEntity> entities) {
		this.removeReferringUnit(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReferringUnit(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReferringUnit(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReferringUnit(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setReferringUnit(@NonNull Collection<RegistrationEntity> entities) {
		setReferringUnit(entities, true);
	}

	/**
	 * Replace the current entities in Referring Unit with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReferringUnit(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetReferringUnit();
		this.referringUnit = new HashSet<>(entities);
		if (reverseAdd) {
			this.referringUnit.forEach(referringUnitEntity -> referringUnitEntity.setReferringUnit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReferringUnit(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReferringUnit() {
		this.unsetReferringUnit(true);
	}

	/**
	 * Remove all the entities in Referring Unit from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReferringUnit(boolean doReverse) {
		if (doReverse) {
			this.referringUnit.forEach(referringUnitEntity -> referringUnitEntity.unsetReferringUnit(false));
		}
		this.referringUnit.clear();
	}

/**
	 * Similar to {@link this#addRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity) {
		addRegistrations(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to registrations in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.registrations.contains(entity)) {
			registrations.add(entity);
			if (reverseAdd) {
				entity.setService(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		addRegistrations(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Registrations in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetService(false);
		}
		this.registrations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRegistrations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		this.removeRegistrations(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRegistrations();
		this.registrations = new HashSet<>(entities);
		if (reverseAdd) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.setService(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRegistrations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRegistrations() {
		this.unsetRegistrations(true);
	}

	/**
	 * Remove all the entities in Registrations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRegistrations(boolean doReverse) {
		if (doReverse) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.unsetService(false));
		}
		this.registrations.clear();
	}

/**
	 * Similar to {@link this#addServiceFacilityCategories(ServiceFacilityCategoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceFacilityCategoryEntity to be added to this entity
	 */
	public void addServiceFacilityCategories(@NonNull ServiceFacilityCategoryEntity entity) {
		addServiceFacilityCategories(entity, true);
	}

	/**
	 * Add a new ServiceFacilityCategoryEntity to serviceFacilityCategories in this entity.
	 *
	 * @param entity the given ServiceFacilityCategoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServiceFacilityCategories(@NonNull ServiceFacilityCategoryEntity entity, boolean reverseAdd) {
		if (!this.serviceFacilityCategories.contains(entity)) {
			serviceFacilityCategories.add(entity);
			if (reverseAdd) {
				entity.setService(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServiceFacilityCategories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to be added to this entity
	 */
	public void addServiceFacilityCategories(@NonNull Collection<ServiceFacilityCategoryEntity> entities) {
		addServiceFacilityCategories(entities, true);
	}

	/**
	 * Add a new collection of ServiceFacilityCategoryEntity to Service Facility Categories in this entity.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServiceFacilityCategories(@NonNull Collection<ServiceFacilityCategoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addServiceFacilityCategories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServiceFacilityCategories(ServiceFacilityCategoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceFacilityCategoryEntity to be set to this entity
	 */
	public void removeServiceFacilityCategories(@NonNull ServiceFacilityCategoryEntity entity) {
		this.removeServiceFacilityCategories(entity, true);
	}

	/**
	 * Remove the given ServiceFacilityCategoryEntity from this entity.
	 *
	 * @param entity the given ServiceFacilityCategoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServiceFacilityCategories(@NonNull ServiceFacilityCategoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetService(false);
		}
		this.serviceFacilityCategories.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServiceFacilityCategories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to be removed to this entity
	 */
	public void removeServiceFacilityCategories(@NonNull Collection<ServiceFacilityCategoryEntity> entities) {
		this.removeServiceFacilityCategories(entities, true);
	}

	/**
	 * Remove the given collection of ServiceFacilityCategoryEntity from  to this entity.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeServiceFacilityCategories(@NonNull Collection<ServiceFacilityCategoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeServiceFacilityCategories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setServiceFacilityCategories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to be set to this entity
	 */
	public void setServiceFacilityCategories(@NonNull Collection<ServiceFacilityCategoryEntity> entities) {
		setServiceFacilityCategories(entities, true);
	}

	/**
	 * Replace the current entities in Service Facility Categories with the given ones.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServiceFacilityCategories(@NonNull Collection<ServiceFacilityCategoryEntity> entities, boolean reverseAdd) {

		this.unsetServiceFacilityCategories();
		this.serviceFacilityCategories = new HashSet<>(entities);
		if (reverseAdd) {
			this.serviceFacilityCategories.forEach(serviceFacilityCategoriesEntity -> serviceFacilityCategoriesEntity.setService(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetServiceFacilityCategories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetServiceFacilityCategories() {
		this.unsetServiceFacilityCategories(true);
	}

	/**
	 * Remove all the entities in Service Facility Categories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetServiceFacilityCategories(boolean doReverse) {
		if (doReverse) {
			this.serviceFacilityCategories.forEach(serviceFacilityCategoriesEntity -> serviceFacilityCategoriesEntity.unsetService(false));
		}
		this.serviceFacilityCategories.clear();
	}

	/**
	 * Similar to {@link this#addServiceItems(ServiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemEntity to be added to this entity
	 */
	public void addServiceItems(@NonNull ServiceItemEntity entity) {
		addServiceItems(entity, true);
	}

	/**
	 * Add a new ServiceItemEntity to Service Items in this entity.
	 *
	 * @param entity the given ServiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServiceItems(@NonNull ServiceItemEntity entity, boolean reverseAdd) {
		if (!this.serviceItems.contains(entity)) {
			this.serviceItems.add(entity);
			if (reverseAdd) {
				entity.addServices(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addServiceItems(@NonNull Collection<ServiceItemEntity> entities) {
		addServiceItems(entities, true);
	}

	/**
	 * Add new collection of ServiceItemEntity to serviceItems in this entity.
	 *
	 * @param entities the given entities to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServiceItems(@NonNull Collection<ServiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addServiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServiceItems(ServiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemEntity to be set to this entity
	 */
	public void removeServiceItems(@NonNull ServiceItemEntity entity) {
		this.removeServiceItems(entity, true);
	}

	/**
	 * Remove the given ServiceItemEntity from this entity.
	 *
	 * @param entity the give ServiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServiceItems(@NonNull ServiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeServices(this, false);
		}
		this.serviceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeServiceItems(@NonNull Collection<ServiceItemEntity> entities) {
		this.removeServiceItems(entities, true);
	}

	/**
	 * Remove the given collection of ServiceItemEntity in serviceItems from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeServiceItems(@NonNull Collection<ServiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeServiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setServiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setServiceItems(@NonNull Collection<ServiceItemEntity> entities) {
		this.setServiceItems(entities, true);
	}

	/**
	 * Replace the current entities in serviceItems with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServiceItems(@NonNull Collection<ServiceItemEntity> entities, boolean reverseAdd) {
		this.unsetServiceItems();
		this.serviceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.serviceItems.forEach(entity -> entity.addServices(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetServiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetServiceItems() {
		this.unsetServiceItems(true);
	}

	/**
	 * Remove all entities in serviceItems from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetServiceItems(boolean doReverse) {
		if (doReverse) {
			this.serviceItems.forEach(entity -> entity.removeServices(this, false));
		}
		this.serviceItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDefaultMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDefaultMedicalStaff(StaffEntity entity) {
		setDefaultMedicalStaff(entity, true);
	}

	/**
	 * Set or update the defaultMedicalStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to defaultMedicalStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDefaultMedicalStaff(StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDefaultMedicalStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDefaultMedicalStaff here] end

		if (sameAsFormer(this.defaultMedicalStaff, entity)) {
			return;
		}

		if (this.defaultMedicalStaff != null) {
			this.defaultMedicalStaff.unsetService(false);
		}

		this.defaultMedicalStaff = entity;
		if (reverseAdd) {
			this.defaultMedicalStaff.setService(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDefaultMedicalStaff incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDefaultMedicalStaff incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDefaultMedicalStaff(boolean)} but default to true.
	 */
	public void unsetDefaultMedicalStaff() {
		this.unsetDefaultMedicalStaff(true);
	}

	/**
	 * Remove the StaffEntity of defaultMedicalStaff from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDefaultMedicalStaff(boolean reverse) {
		if (reverse && this.defaultMedicalStaff != null) {
			this.defaultMedicalStaff.unsetService();
		}
		this.defaultMedicalStaff = null;
	}
	/**
	 * Similar to {@link this#addAssignedMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be added to assignedMedicalStaff
	 */
	public void addAssignedMedicalStaff(@NonNull StaffEntity entity) {
		this.addAssignedMedicalStaff(entity, true);
	}

	/**
	 * Add a new StaffEntity to assignedMedicalStaff in this entity.
	 *
	 * @param entity the given StaffEntity to be added to assignedMedicalStaff
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAssignedMedicalStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		if (!this.assignedMedicalStaff.contains(entity)) {
			this.assignedMedicalStaff.add(entity);
			if (reverseAdd) {
				entity.addServices(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAssignedMedicalStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StaffEntity to be added into assignedMedicalStaff
	 */
	public void addAssignedMedicalStaff(@NonNull Collection<StaffEntity> entities) {
		this.addAssignedMedicalStaff(entities, true);
	}

	/**
	 * Add new collection of StaffEntity to assignedMedicalStaff in this entity.
	 *
	 * @param entities the given collection of StaffEntity to be added into assignedMedicalStaff in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAssignedMedicalStaff(@NonNull Collection<StaffEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addAssignedMedicalStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAssignedMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to assignedMedicalStaff in this entity
	 */
	public void removeAssignedMedicalStaff(@NonNull StaffEntity entity) {
		this.removeAssignedMedicalStaff(entity, true);
	}

	/**
	 * Remove the given StaffEntity from assignedMedicalStaff in this entity.
	 *
	 * @param entity the given StaffEntity to be removed from assignedMedicalStaff
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAssignedMedicalStaff(@NonNull StaffEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeServices(this, false);
		}
		this.assignedMedicalStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAssignedMedicalStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StaffEntity to be removed from assignedMedicalStaff in this entity
	 */
	public void removeAssignedMedicalStaff(@NonNull Collection<StaffEntity> entities) {
		this.removeAssignedMedicalStaff(entities, true);
	}

	/**
	 * Remove the given collection of StaffEntity from assignedMedicalStaff in this entity.
	 *
	 * @param entities the given collection of StaffEntity to be removed from assignedMedicalStaff
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeAssignedMedicalStaff(@NonNull Collection<StaffEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeAssignedMedicalStaff(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setAssignedMedicalStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StaffEntity to replace the old ones in assignedMedicalStaff
	 */
	public void setAssignedMedicalStaff(@NonNull Collection<StaffEntity> entities) {
		this.setAssignedMedicalStaff(entities, true);
	}

	/**
	 * Replace the current collection of StaffEntity in assignedMedicalStaff with the given ones.
	 *
	 * @param entities the given collection of StaffEntity to replace the old ones in assignedMedicalStaff
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAssignedMedicalStaff(@NonNull Collection<StaffEntity> entities, boolean reverseAdd) {
		unsetAssignedMedicalStaff();
		this.assignedMedicalStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.assignedMedicalStaff.forEach(assignedMedicalStaffEntity -> assignedMedicalStaffEntity.addServices(this, false));
		}
	}

	/**
	 * Remove all entities in Assigned Medical Staff from this entity.
	 */
	public void unsetAssignedMedicalStaff() {
		this.assignedMedicalStaff.forEach(entity -> entity.removeServices(this, false));
		this.assignedMedicalStaff.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
