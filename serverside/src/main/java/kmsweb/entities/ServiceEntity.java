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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.ServiceEntityDto;
import kmsweb.entities.listeners.ServiceEntityListener;
import kmsweb.serializers.ServiceSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({ServiceEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ServiceSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"service_number"}, name = "service_number"),
	}
)
public class ServiceEntity extends AbstractEntity {

	/**
	 * Takes a ServiceEntityDto and converts it into a ServiceEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param serviceEntityDto
	 */
	public ServiceEntity(ServiceEntityDto serviceEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (serviceEntityDto.getId() != null) {
			this.setId(serviceEntityDto.getId());
		}

		if (serviceEntityDto.getServiceNumber() != null) {
			this.setServiceNumber(serviceEntityDto.getServiceNumber());
		}

		if (serviceEntityDto.getServiceName() != null) {
			this.setServiceName(serviceEntityDto.getServiceName());
		}

		if (serviceEntityDto.getSectionCode() != null) {
			this.setSectionCode(serviceEntityDto.getSectionCode());
		}

		if (serviceEntityDto.getByPassDoctorAssignment() != null) {
			this.setByPassDoctorAssignment(serviceEntityDto.getByPassDoctorAssignment());
		}

		if (serviceEntityDto.getHasExaminationItem() != null) {
			this.setHasExaminationItem(serviceEntityDto.getHasExaminationItem());
		}

		if (serviceEntityDto.getRevenueCenter() != null) {
			this.setRevenueCenter(serviceEntityDto.getRevenueCenter());
		}

		if (serviceEntityDto.getServiceCode() != null) {
			this.setServiceCode(serviceEntityDto.getServiceCode());
		}

		if (serviceEntityDto.getBpjsPcarePoli() != null) {
			this.setBpjsPcarePoli(serviceEntityDto.getBpjsPcarePoli());
		}

		if (serviceEntityDto.getBpjsServiceMapping() != null) {
			this.setBpjsServiceMapping(serviceEntityDto.getBpjsServiceMapping());
		}

		if (serviceEntityDto.getDoctorSchedules() != null) {
			this.setDoctorSchedules(serviceEntityDto.getDoctorSchedules());
		}

		if (serviceEntityDto.getExaminationGroups() != null) {
			this.setExaminationGroups(serviceEntityDto.getExaminationGroups());
		}

		if (serviceEntityDto.getMcuPackageItems() != null) {
			this.setMcuPackageItems(serviceEntityDto.getMcuPackageItems());
		}

		if (serviceEntityDto.getReferringUnit() != null) {
			this.setReferringUnit(serviceEntityDto.getReferringUnit());
		}

		if (serviceEntityDto.getRegistrations() != null) {
			this.setRegistrations(serviceEntityDto.getRegistrations());
		}

		if (serviceEntityDto.getServiceFacilityCategories() != null) {
			this.setServiceFacilityCategories(serviceEntityDto.getServiceFacilityCategories());
		}

		if (serviceEntityDto.getServiceItems() != null) {
			this.setServiceItems(serviceEntityDto.getServiceItems());
		}

		if (serviceEntityDto.getDefaultMedicalStaff() != null) {
			this.setDefaultMedicalStaff(serviceEntityDto.getDefaultMedicalStaff());
		}

		if (serviceEntityDto.getAssignedMedicalStaff() != null) {
			this.setAssignedMedicalStaff(serviceEntityDto.getAssignedMedicalStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Service Number here] off begin
	@CsvBindByName(column = "SERVICE_NUMBER", required = false)
	@Nullable
	@Column(name = "service_number")
	@Schema(description = "The Service Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Number here] end
	private String serviceNumber;

	// % protected region % [Modify attribute annotation for Service Name here] off begin
	@CsvBindByName(column = "SERVICE_NAME", required = true)
	@NotNull(message = "Service Name must not be empty")
	@Column(name = "service_name")
	@Schema(description = "The Service Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Name here] end
	private String serviceName;

	// % protected region % [Modify attribute annotation for Section Code here] off begin
	@CsvBindByName(column = "SECTION_CODE", required = false)
	@Nullable
	@Column(name = "section_code")
	@Schema(description = "The Section Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Section Code here] end
	private String sectionCode;

	// % protected region % [Modify attribute annotation for By pass Doctor Assignment here] off begin
	@CsvBindByName(column = "BY_PASS_DOCTOR_ASSIGNMENT", required = false)
	@Nullable
	@Column(name = "by_pass_doctor_assignment")
	@Schema(description = "The By pass Doctor Assignment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for By pass Doctor Assignment here] end
	private Boolean byPassDoctorAssignment = false ;

	// % protected region % [Modify attribute annotation for Has Examination Item here] off begin
	@CsvBindByName(column = "HAS_EXAMINATION_ITEM", required = false)
	@Nullable
	@Column(name = "has_examination_item")
	@Schema(description = "The Has Examination Item of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Has Examination Item here] end
	private Boolean hasExaminationItem = false ;

	// % protected region % [Modify attribute annotation for Revenue Center here] off begin
	@CsvBindByName(column = "REVENUE_CENTER", required = false)
	@Nullable
	@Column(name = "revenue_center")
	@Schema(description = "The Revenue Center of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Revenue Center here] end
	private String revenueCenter;

	// % protected region % [Modify attribute annotation for Service Code here] off begin
	@CsvBindByName(column = "SERVICE_CODE", required = false)
	@Nullable
	@Column(name = "service_code")
	@Schema(description = "The Service Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Code here] end
	private String serviceCode;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Pcare Poli here] off begin
	@Schema(description = "The BPJS Pcare Poli entities that are related to this entity.")
	@OneToOne(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Pcare Poli here] end
	private BpjsPcarePoliEntity bpjsPcarePoli;

	// % protected region % [Update the annotation for bpjsPcarePoliId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PCARE_POLI_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsPcarePoliId here] end
	private UUID bpjsPcarePoliId;

	// % protected region % [Update the annotation for BPJS Service Mapping here] off begin
	@Schema(description = "The BPJS Service Mapping entities that are related to this entity.")
	@OneToOne(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Service Mapping here] end
	private BpjsServiceMappingEntity bpjsServiceMapping;

	// % protected region % [Update the annotation for bpjsServiceMappingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_SERVICE_MAPPING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsServiceMappingId here] end
	private UUID bpjsServiceMappingId;

	// % protected region % [Update the annotation for Doctor Schedules here] off begin
	@Schema(description = "The Doctor Schedule entities that are related to this entity.")
	@OneToMany(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Doctor Schedules here] end
	private Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();

	// % protected region % [Update the annotation for doctorSchedulesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DOCTOR_SCHEDULES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for doctorSchedulesIds here] end
	private Set<UUID> doctorSchedulesIds = new HashSet<>();

	// % protected region % [Update the annotation for Examination Groups here] off begin
	@Schema(description = "The Examination Group entities that are related to this entity.")
	@OneToMany(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Groups here] end
	private Set<ExaminationGroupEntity> examinationGroups = new HashSet<>();

	// % protected region % [Update the annotation for examinationGroupsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_GROUPS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationGroupsIds here] end
	private Set<UUID> examinationGroupsIds = new HashSet<>();

	// % protected region % [Update the annotation for MCU Package Items here] off begin
	@Schema(description = "The MCU Package Item entities that are related to this entity.")
	@OneToMany(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for MCU Package Items here] end
	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	// % protected region % [Update the annotation for mcuPackageItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MCU_PACKAGE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for mcuPackageItemsIds here] end
	private Set<UUID> mcuPackageItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Referring Unit here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "referringUnit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Referring Unit here] end
	private Set<RegistrationEntity> referringUnit = new HashSet<>();

	// % protected region % [Update the annotation for referringUnitIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REFERRING_UNIT_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for referringUnitIds here] end
	private Set<UUID> referringUnitIds = new HashSet<>();

	// % protected region % [Update the annotation for Registrations here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registrations here] end
	private Set<RegistrationEntity> registrations = new HashSet<>();

	// % protected region % [Update the annotation for registrationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for registrationsIds here] end
	private Set<UUID> registrationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Service Facility Categories here] off begin
	@Schema(description = "The Service Facility Category entities that are related to this entity.")
	@OneToMany(mappedBy = "service", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Facility Categories here] end
	private Set<ServiceFacilityCategoryEntity> serviceFacilityCategories = new HashSet<>();

	// % protected region % [Update the annotation for serviceFacilityCategoriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_FACILITY_CATEGORIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for serviceFacilityCategoriesIds here] end
	private Set<UUID> serviceFacilityCategoriesIds = new HashSet<>();

	// % protected region % [Update the annotation for Service Items here] off begin
	@Schema(description = "The Service Item entities that are related to this entity.")
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Items here] end
	private Set<ServiceItemEntity> serviceItems = new HashSet<>();

	// % protected region % [Update the annotation for serviceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for serviceItemsIds here] end
	private Set<UUID> serviceItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Default Medical Staff here] off begin
	@Schema(description = "The Default Medical Staff entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Default Medical Staff here] end
	private StaffEntity defaultMedicalStaff;

	// % protected region % [Update the annotation for defaultMedicalStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DEFAULT_MEDICAL_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for defaultMedicalStaffId here] end
	private UUID defaultMedicalStaffId;

	// % protected region % [Update the annotation for Assigned Medical Staff here] off begin
	@Schema(description = "The Assigned Medical Staff entities that are related to this entity.")
	@ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Assigned Medical Staff here] end
	private Set<StaffEntity> assignedMedicalStaff = new HashSet<>();

	// % protected region % [Update the annotation for assignedMedicalStaffIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ASSIGNED_MEDICAL_STAFF_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for assignedMedicalStaffIds here] end
	private Set<UUID> assignedMedicalStaffIds = new HashSet<>();

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
	public void setBpjsPcarePoli(@NotNull BpjsPcarePoliEntity entity) {
		setBpjsPcarePoli(entity, true);
	}

	/**
	 * Set or update bpjsPcarePoli with the given BpjsPcarePoliEntity.
	 *
	 * @param entity the ServiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcarePoli(@NotNull BpjsPcarePoliEntity entity, boolean reverseAdd) {
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
	public void setBpjsServiceMapping(@NotNull BpjsServiceMappingEntity entity) {
		setBpjsServiceMapping(entity, true);
	}

	/**
	 * Set or update bpjsServiceMapping with the given BpjsServiceMappingEntity.
	 *
	 * @param entity the ServiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsServiceMapping(@NotNull BpjsServiceMappingEntity entity, boolean reverseAdd) {
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
	public void addDoctorSchedules(@NotNull DoctorScheduleEntity entity) {
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
	public void addDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities) {
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
	public void removeDoctorSchedules(@NotNull DoctorScheduleEntity entity) {
		this.removeDoctorSchedules(entity, true);
	}

	/**
	 * Remove the given DoctorScheduleEntity from this entity.
	 *
	 * @param entity the given DoctorScheduleEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDoctorSchedules(@NotNull DoctorScheduleEntity entity, boolean reverse) {
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
	public void removeDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities) {
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
	public void setDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities) {
		setDoctorSchedules(entities, true);
	}

	/**
	 * Replace the current entities in Doctor Schedules with the given ones.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDoctorSchedules(@NotNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {

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
	public void addExaminationGroups(@NotNull ExaminationGroupEntity entity) {
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
	public void addExaminationGroups(@NotNull Collection<ExaminationGroupEntity> entities) {
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
	public void removeExaminationGroups(@NotNull ExaminationGroupEntity entity) {
		this.removeExaminationGroups(entity, true);
	}

	/**
	 * Remove the given ExaminationGroupEntity from this entity.
	 *
	 * @param entity the given ExaminationGroupEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationGroups(@NotNull ExaminationGroupEntity entity, boolean reverse) {
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
	public void removeExaminationGroups(@NotNull Collection<ExaminationGroupEntity> entities) {
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
	public void setExaminationGroups(@NotNull Collection<ExaminationGroupEntity> entities) {
		setExaminationGroups(entities, true);
	}

	/**
	 * Replace the current entities in Examination Groups with the given ones.
	 *
	 * @param entities the given collection of ExaminationGroupEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationGroups(@NotNull Collection<ExaminationGroupEntity> entities, boolean reverseAdd) {

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
	public void addMcuPackageItems(@NotNull McuPackageItemEntity entity) {
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
	public void addMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities) {
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
	public void removeMcuPackageItems(@NotNull McuPackageItemEntity entity) {
		this.removeMcuPackageItems(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the given McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMcuPackageItems(@NotNull McuPackageItemEntity entity, boolean reverse) {
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
	public void removeMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities) {
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
	public void setMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities) {
		setMcuPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in MCU Package Items with the given ones.
	 *
	 * @param entities the given collection of McuPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMcuPackageItems(@NotNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {

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
	public void addReferringUnit(@NotNull RegistrationEntity entity) {
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
	public void addReferringUnit(@NotNull Collection<RegistrationEntity> entities) {
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
	public void removeReferringUnit(@NotNull RegistrationEntity entity) {
		this.removeReferringUnit(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReferringUnit(@NotNull RegistrationEntity entity, boolean reverse) {
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
	public void removeReferringUnit(@NotNull Collection<RegistrationEntity> entities) {
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
	public void setReferringUnit(@NotNull Collection<RegistrationEntity> entities) {
		setReferringUnit(entities, true);
	}

	/**
	 * Replace the current entities in Referring Unit with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReferringUnit(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

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
	public void addRegistrations(@NotNull RegistrationEntity entity) {
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
	public void addRegistrations(@NotNull Collection<RegistrationEntity> entities) {
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
	public void removeRegistrations(@NotNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity, boolean reverse) {
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
	public void removeRegistrations(@NotNull Collection<RegistrationEntity> entities) {
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
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

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
	public void addServiceFacilityCategories(@NotNull ServiceFacilityCategoryEntity entity) {
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
	public void addServiceFacilityCategories(@NotNull Collection<ServiceFacilityCategoryEntity> entities) {
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
	public void removeServiceFacilityCategories(@NotNull ServiceFacilityCategoryEntity entity) {
		this.removeServiceFacilityCategories(entity, true);
	}

	/**
	 * Remove the given ServiceFacilityCategoryEntity from this entity.
	 *
	 * @param entity the given ServiceFacilityCategoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServiceFacilityCategories(@NotNull ServiceFacilityCategoryEntity entity, boolean reverse) {
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
	public void removeServiceFacilityCategories(@NotNull Collection<ServiceFacilityCategoryEntity> entities) {
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
	public void setServiceFacilityCategories(@NotNull Collection<ServiceFacilityCategoryEntity> entities) {
		setServiceFacilityCategories(entities, true);
	}

	/**
	 * Replace the current entities in Service Facility Categories with the given ones.
	 *
	 * @param entities the given collection of ServiceFacilityCategoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServiceFacilityCategories(@NotNull Collection<ServiceFacilityCategoryEntity> entities, boolean reverseAdd) {

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
	public void addServiceItems(@NotNull ServiceItemEntity entity) {
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
	public void addServiceItems(@NotNull Collection<ServiceItemEntity> entities) {
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
	public void removeServiceItems(@NotNull ServiceItemEntity entity) {
		this.removeServiceItems(entity, true);
	}

	/**
	 * Remove the given ServiceItemEntity from this entity.
	 *
	 * @param entity the give ServiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServiceItems(@NotNull ServiceItemEntity entity, boolean reverse) {
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
	public void removeServiceItems(@NotNull Collection<ServiceItemEntity> entities) {
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
	public void setServiceItems(@NotNull Collection<ServiceItemEntity> entities) {
		this.setServiceItems(entities, true);
	}

	/**
	 * Replace the current entities in serviceItems with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServiceItems(@NotNull Collection<ServiceItemEntity> entities, boolean reverseAdd) {
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
	public void addAssignedMedicalStaff(@NotNull StaffEntity entity) {
		this.addAssignedMedicalStaff(entity, true);
	}

	/**
	 * Add a new StaffEntity to assignedMedicalStaff in this entity.
	 *
	 * @param entity the given StaffEntity to be added to assignedMedicalStaff
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAssignedMedicalStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
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
	public void addAssignedMedicalStaff(@NotNull Collection<StaffEntity> entities) {
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
	public void removeAssignedMedicalStaff(@NotNull StaffEntity entity) {
		this.removeAssignedMedicalStaff(entity, true);
	}

	/**
	 * Remove the given StaffEntity from assignedMedicalStaff in this entity.
	 *
	 * @param entity the given StaffEntity to be removed from assignedMedicalStaff
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAssignedMedicalStaff(@NotNull StaffEntity entity, boolean reverse) {
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
	public void removeAssignedMedicalStaff(@NotNull Collection<StaffEntity> entities) {
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
	public void setAssignedMedicalStaff(@NotNull Collection<StaffEntity> entities) {
		this.setAssignedMedicalStaff(entities, true);
	}

	/**
	 * Replace the current collection of StaffEntity in assignedMedicalStaff with the given ones.
	 *
	 * @param entities the given collection of StaffEntity to replace the old ones in assignedMedicalStaff
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAssignedMedicalStaff(@NotNull Collection<StaffEntity> entities, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "SERVICE_NUMBER,SERVICE_NAME,SECTION_CODE,BY_PASS_DOCTOR_ASSIGNMENT,HAS_EXAMINATION_ITEM,REVENUE_CENTER,SERVICE_CODE,DEFAULT_MEDICAL_STAFF_ID,ASSIGNED_MEDICAL_STAFF_IDS,BPJS_PCARE_POLI_ID,BPJS_SERVICE_MAPPING_ID,DOCTOR_SCHEDULES_IDS,EXAMINATION_GROUPS_IDS,MCU_PACKAGE_ITEMS_IDS,REFERRING_UNIT_IDS,REGISTRATIONS_IDS,SERVICE_FACILITY_CATEGORIES_IDS,SERVICE_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<StaffEntity> defaultMedicalStaffRelation = Optional.ofNullable(this.defaultMedicalStaff);
		defaultMedicalStaffRelation.ifPresent(entity -> this.defaultMedicalStaffId = entity.getId());

		this.assignedMedicalStaffIds = new HashSet<>();
		for (StaffEntity assignedMedicalStaff: this.assignedMedicalStaff) {
			this.assignedMedicalStaffIds.add(assignedMedicalStaff.getId());
		}

		Optional<BpjsPcarePoliEntity> bpjsPcarePoliRelation = Optional.ofNullable(this.bpjsPcarePoli);
		bpjsPcarePoliRelation.ifPresent(entity -> this.bpjsPcarePoliId = entity.getId());

		Optional<BpjsServiceMappingEntity> bpjsServiceMappingRelation = Optional.ofNullable(this.bpjsServiceMapping);
		bpjsServiceMappingRelation.ifPresent(entity -> this.bpjsServiceMappingId = entity.getId());

		this.doctorSchedulesIds = new HashSet<>();
		for (DoctorScheduleEntity doctorSchedules: this.doctorSchedules) {
			this.doctorSchedulesIds.add(doctorSchedules.getId());
		}

		this.examinationGroupsIds = new HashSet<>();
		for (ExaminationGroupEntity examinationGroups: this.examinationGroups) {
			this.examinationGroupsIds.add(examinationGroups.getId());
		}

		this.mcuPackageItemsIds = new HashSet<>();
		for (McuPackageItemEntity mcuPackageItems: this.mcuPackageItems) {
			this.mcuPackageItemsIds.add(mcuPackageItems.getId());
		}

		this.referringUnitIds = new HashSet<>();
		for (RegistrationEntity referringUnit: this.referringUnit) {
			this.referringUnitIds.add(referringUnit.getId());
		}

		this.registrationsIds = new HashSet<>();
		for (RegistrationEntity registrations: this.registrations) {
			this.registrationsIds.add(registrations.getId());
		}

		this.serviceFacilityCategoriesIds = new HashSet<>();
		for (ServiceFacilityCategoryEntity serviceFacilityCategories: this.serviceFacilityCategories) {
			this.serviceFacilityCategoriesIds.add(serviceFacilityCategories.getId());
		}

		this.serviceItemsIds = new HashSet<>();
		for (ServiceItemEntity serviceItems: this.serviceItems) {
			this.serviceItemsIds.add(serviceItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object service) {
		if (this == service) {
			return true;
		}
		if (service == null || this.getClass() != service.getClass()) {
			return false;
		}
		if (!super.equals(service)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ServiceEntity that = (ServiceEntity) service;
		return
			Objects.equals(this.serviceNumber, that.serviceNumber) &&
			Objects.equals(this.serviceName, that.serviceName) &&
			Objects.equals(this.sectionCode, that.sectionCode) &&
			Objects.equals(this.byPassDoctorAssignment, that.byPassDoctorAssignment) &&
			Objects.equals(this.hasExaminationItem, that.hasExaminationItem) &&
			Objects.equals(this.revenueCenter, that.revenueCenter) &&
			Objects.equals(this.serviceCode, that.serviceCode) &&
			Objects.equals(this.bpjsPcarePoliId, that.bpjsPcarePoliId) &&
			Objects.equals(this.bpjsServiceMappingId, that.bpjsServiceMappingId) &&
			Objects.equals(this.doctorSchedulesIds, that.doctorSchedulesIds) &&
			Objects.equals(this.examinationGroupsIds, that.examinationGroupsIds) &&
			Objects.equals(this.mcuPackageItemsIds, that.mcuPackageItemsIds) &&
			Objects.equals(this.referringUnitIds, that.referringUnitIds) &&
			Objects.equals(this.registrationsIds, that.registrationsIds) &&
			Objects.equals(this.serviceFacilityCategoriesIds, that.serviceFacilityCategoriesIds) &&
			Objects.equals(this.defaultMedicalStaffId, that.defaultMedicalStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
