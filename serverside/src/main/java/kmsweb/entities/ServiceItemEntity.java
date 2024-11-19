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
import kmsweb.dtos.ServiceItemEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.ServiceItemEntityListener;
import kmsweb.serializers.ServiceItemSerializer;
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
@EntityListeners({ServiceItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ServiceItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ServiceItemEntity extends AbstractEntity {

	/**
	 * Takes a ServiceItemEntityDto and converts it into a ServiceItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param serviceItemEntityDto
	 */
	public ServiceItemEntity(ServiceItemEntityDto serviceItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (serviceItemEntityDto.getId() != null) {
			this.setId(serviceItemEntityDto.getId());
		}

		if (serviceItemEntityDto.getServiceItemCode() != null) {
			this.setServiceItemCode(serviceItemEntityDto.getServiceItemCode());
		}

		if (serviceItemEntityDto.getServiceItemName() != null) {
			this.setServiceItemName(serviceItemEntityDto.getServiceItemName());
		}

		if (serviceItemEntityDto.getClassification() != null) {
			this.setClassification(serviceItemEntityDto.getClassification());
		}

		if (serviceItemEntityDto.getApplyToAllService() != null) {
			this.setApplyToAllService(serviceItemEntityDto.getApplyToAllService());
		}

		if (serviceItemEntityDto.getApplyTo() != null) {
			this.setApplyTo(serviceItemEntityDto.getApplyTo());
		}

		if (serviceItemEntityDto.getCoaCOGS() != null) {
			this.setCoaCOGS(serviceItemEntityDto.getCoaCOGS());
		}

		if (serviceItemEntityDto.getCoaSell() != null) {
			this.setCoaSell(serviceItemEntityDto.getCoaSell());
		}

		if (serviceItemEntityDto.getCoaInventory() != null) {
			this.setCoaInventory(serviceItemEntityDto.getCoaInventory());
		}

		if (serviceItemEntityDto.getExaminationItems() != null) {
			this.setExaminationItems(serviceItemEntityDto.getExaminationItems());
		}

		if (serviceItemEntityDto.getServiceItemAssignments() != null) {
			this.setServiceItemAssignments(serviceItemEntityDto.getServiceItemAssignments());
		}

		if (serviceItemEntityDto.getServices() != null) {
			this.setServices(serviceItemEntityDto.getServices());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Service Item Code here] off begin
	@CsvBindByName(column = "SERVICE_ITEM_CODE", required = true)
	@NotNull(message = "Service Item Code must not be empty")
	@Column(name = "service_item_code")
	@Schema(description = "The Service Item Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Item Code here] end
	private String serviceItemCode;

	// % protected region % [Modify attribute annotation for Service Item Name here] off begin
	@CsvBindByName(column = "SERVICE_ITEM_NAME", required = true)
	@NotNull(message = "Service Item Name must not be empty")
	@Column(name = "service_item_name")
	@Schema(description = "The Service Item Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Item Name here] end
	private String serviceItemName;

	// % protected region % [Modify attribute annotation for Classification here] off begin
	@CsvBindByName(column = "CLASSIFICATION", required = true)
	@NotNull(message = "Classification must not be empty")
	@Column(name = "classification")
	@Schema(description = "The Classification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification here] end
	private String classification;

	// % protected region % [Modify attribute annotation for Apply to all Service here] off begin
	@CsvBindByName(column = "APPLY_TO_ALL_SERVICE", required = false)
	@Nullable
	@Column(name = "apply_to_all_service")
	@Schema(description = "The Apply to all Service of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Apply to all Service here] end
	private Boolean applyToAllService = false ;

	// % protected region % [Modify attribute annotation for Apply To here] off begin
	@CsvCustomBindByName(column = "APPLY_TO", required = false, converter = ApplyToEnumConverter.class)
	@Nullable
	@Column(name = "apply_to")
	@Schema(description = "The Apply To of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Apply To here] end
	private ApplyToEnum applyTo;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@CsvBindByName(column = "COA_COGS", required = false)
	@Nullable
	@Column(name = "coa_cogs")
	@Schema(description = "The COA COGS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@CsvBindByName(column = "COA_SELL", required = false)
	@Nullable
	@Column(name = "coa_sell")
	@Schema(description = "The COA Sell of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@CsvBindByName(column = "COA_INVENTORY", required = false)
	@Nullable
	@Column(name = "coa_inventory")
	@Schema(description = "The COA Inventory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Examination Items here] off begin
	@Schema(description = "The Examination Item entities that are related to this entity.")
	@OneToMany(mappedBy = "serviceItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Items here] end
	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	// % protected region % [Update the annotation for examinationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationItemsIds here] end
	private Set<UUID> examinationItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Service Item Assignments here] off begin
	@Schema(description = "The Service Item Assignment entities that are related to this entity.")
	@OneToMany(mappedBy = "serviceItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Item Assignments here] end
	private Set<ServiceItemAssignmentEntity> serviceItemAssignments = new HashSet<>();

	// % protected region % [Update the annotation for serviceItemAssignmentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ITEM_ASSIGNMENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for serviceItemAssignmentsIds here] end
	private Set<UUID> serviceItemAssignmentsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Services here] off begin
	@Schema(description = "The Services entities that are related to this entity.")
	@ManyToMany(mappedBy = "serviceItems", fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Services here] end
	private Set<ServiceEntity> services = new HashSet<>();

	// % protected region % [Update the annotation for servicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for servicesIds here] end
	private Set<UUID> servicesIds = new HashSet<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be added to this entity
	 */
	public void addExaminationItems(@NotNull ExaminationItemEntity entity) {
		addExaminationItems(entity, true);
	}

	/**
	 * Add a new ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverseAdd) {
		if (!this.examinationItems.contains(entity)) {
			examinationItems.add(entity);
			if (reverseAdd) {
				entity.setServiceItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added to this entity
	 */
	public void addExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		addExaminationItems(entities, true);
	}

	/**
	 * Add a new collection of ExaminationItemEntity to Examination Items in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to this entity
	 */
	public void removeExaminationItems(@NotNull ExaminationItemEntity entity) {
		this.removeExaminationItems(entity, true);
	}

	/**
	 * Remove the given ExaminationItemEntity from this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItems(@NotNull ExaminationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetServiceItem(false);
		}
		this.examinationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed to this entity
	 */
	public void removeExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		this.removeExaminationItems(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationItemEntity from  to this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be set to this entity
	 */
	public void setExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		setExaminationItems(entities, true);
	}

	/**
	 * Replace the current entities in Examination Items with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItems(@NotNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {

		this.unsetExaminationItems();
		this.examinationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.setServiceItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetExaminationItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetExaminationItems() {
		this.unsetExaminationItems(true);
	}

	/**
	 * Remove all the entities in Examination Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetExaminationItems(boolean doReverse) {
		if (doReverse) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.unsetServiceItem(false));
		}
		this.examinationItems.clear();
	}

/**
	 * Similar to {@link this#addServiceItemAssignments(ServiceItemAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemAssignmentEntity to be added to this entity
	 */
	public void addServiceItemAssignments(@NotNull ServiceItemAssignmentEntity entity) {
		addServiceItemAssignments(entity, true);
	}

	/**
	 * Add a new ServiceItemAssignmentEntity to serviceItemAssignments in this entity.
	 *
	 * @param entity the given ServiceItemAssignmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServiceItemAssignments(@NonNull ServiceItemAssignmentEntity entity, boolean reverseAdd) {
		if (!this.serviceItemAssignments.contains(entity)) {
			serviceItemAssignments.add(entity);
			if (reverseAdd) {
				entity.setServiceItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServiceItemAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be added to this entity
	 */
	public void addServiceItemAssignments(@NotNull Collection<ServiceItemAssignmentEntity> entities) {
		addServiceItemAssignments(entities, true);
	}

	/**
	 * Add a new collection of ServiceItemAssignmentEntity to Service Item Assignments in this entity.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addServiceItemAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServiceItemAssignments(ServiceItemAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemAssignmentEntity to be set to this entity
	 */
	public void removeServiceItemAssignments(@NotNull ServiceItemAssignmentEntity entity) {
		this.removeServiceItemAssignments(entity, true);
	}

	/**
	 * Remove the given ServiceItemAssignmentEntity from this entity.
	 *
	 * @param entity the given ServiceItemAssignmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServiceItemAssignments(@NotNull ServiceItemAssignmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetServiceItem(false);
		}
		this.serviceItemAssignments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServiceItemAssignments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be removed to this entity
	 */
	public void removeServiceItemAssignments(@NotNull Collection<ServiceItemAssignmentEntity> entities) {
		this.removeServiceItemAssignments(entities, true);
	}

	/**
	 * Remove the given collection of ServiceItemAssignmentEntity from  to this entity.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeServiceItemAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setServiceItemAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be set to this entity
	 */
	public void setServiceItemAssignments(@NotNull Collection<ServiceItemAssignmentEntity> entities) {
		setServiceItemAssignments(entities, true);
	}

	/**
	 * Replace the current entities in Service Item Assignments with the given ones.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServiceItemAssignments(@NotNull Collection<ServiceItemAssignmentEntity> entities, boolean reverseAdd) {

		this.unsetServiceItemAssignments();
		this.serviceItemAssignments = new HashSet<>(entities);
		if (reverseAdd) {
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.setServiceItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetServiceItemAssignments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetServiceItemAssignments() {
		this.unsetServiceItemAssignments(true);
	}

	/**
	 * Remove all the entities in Service Item Assignments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetServiceItemAssignments(boolean doReverse) {
		if (doReverse) {
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.unsetServiceItem(false));
		}
		this.serviceItemAssignments.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#addServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be added to services
	 */
	public void addServices(@NotNull ServiceEntity entity) {
		this.addServices(entity, true);
	}

	/**
	 * Add a new ServiceEntity to services in this entity.
	 *
	 * @param entity the given ServiceEntity to be added to services
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServices(@NotNull ServiceEntity entity, boolean reverseAdd) {
		if (!this.services.contains(entity)) {
			this.services.add(entity);
			if (reverseAdd) {
				entity.addServiceItems(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceEntity to be added into services
	 */
	public void addServices(@NotNull Collection<ServiceEntity> entities) {
		this.addServices(entities, true);
	}

	/**
	 * Add new collection of ServiceEntity to services in this entity.
	 *
	 * @param entities the given collection of ServiceEntity to be added into services in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addServices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to services in this entity
	 */
	public void removeServices(@NotNull ServiceEntity entity) {
		this.removeServices(entity, true);
	}

	/**
	 * Remove the given ServiceEntity from services in this entity.
	 *
	 * @param entity the given ServiceEntity to be removed from services
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServices(@NotNull ServiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeServiceItems(this, false);
		}
		this.services.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceEntity to be removed from services in this entity
	 */
	public void removeServices(@NotNull Collection<ServiceEntity> entities) {
		this.removeServices(entities, true);
	}

	/**
	 * Remove the given collection of ServiceEntity from services in this entity.
	 *
	 * @param entities the given collection of ServiceEntity to be removed from services
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeServices(@NonNull Collection<ServiceEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeServices(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceEntity to replace the old ones in services
	 */
	public void setServices(@NotNull Collection<ServiceEntity> entities) {
		this.setServices(entities, true);
	}

	/**
	 * Replace the current collection of ServiceEntity in services with the given ones.
	 *
	 * @param entities the given collection of ServiceEntity to replace the old ones in services
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServices(@NotNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		unsetServices();
		this.services = new HashSet<>(entities);
		if (reverseAdd) {
			this.services.forEach(servicesEntity -> servicesEntity.addServiceItems(this, false));
		}
	}

	/**
	 * Remove all entities in Services from this entity.
	 */
	public void unsetServices() {
		this.services.forEach(entity -> entity.removeServiceItems(this, false));
		this.services.clear();
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
		return "SERVICE_ITEM_CODE,SERVICE_ITEM_NAME,CLASSIFICATION,APPLY_TO_ALL_SERVICE,APPLY_TO,COA_COGS,COA_SELL,COA_INVENTORY,SERVICES_IDS,EXAMINATION_ITEMS_IDS,SERVICE_ITEM_ASSIGNMENTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.servicesIds = new HashSet<>();
		for (ServiceEntity services: this.services) {
			this.servicesIds.add(services.getId());
		}

		this.examinationItemsIds = new HashSet<>();
		for (ExaminationItemEntity examinationItems: this.examinationItems) {
			this.examinationItemsIds.add(examinationItems.getId());
		}

		this.serviceItemAssignmentsIds = new HashSet<>();
		for (ServiceItemAssignmentEntity serviceItemAssignments: this.serviceItemAssignments) {
			this.serviceItemAssignmentsIds.add(serviceItemAssignments.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object serviceItem) {
		if (this == serviceItem) {
			return true;
		}
		if (serviceItem == null || this.getClass() != serviceItem.getClass()) {
			return false;
		}
		if (!super.equals(serviceItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ServiceItemEntity that = (ServiceItemEntity) serviceItem;
		return
			Objects.equals(this.serviceItemCode, that.serviceItemCode) &&
			Objects.equals(this.serviceItemName, that.serviceItemName) &&
			Objects.equals(this.classification, that.classification) &&
			Objects.equals(this.applyToAllService, that.applyToAllService) &&
			Objects.equals(this.applyTo, that.applyTo) &&
			Objects.equals(this.coaCOGS, that.coaCOGS) &&
			Objects.equals(this.coaSell, that.coaSell) &&
			Objects.equals(this.coaInventory, that.coaInventory) &&
			Objects.equals(this.examinationItemsIds, that.examinationItemsIds) &&
			Objects.equals(this.serviceItemAssignmentsIds, that.serviceItemAssignmentsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
