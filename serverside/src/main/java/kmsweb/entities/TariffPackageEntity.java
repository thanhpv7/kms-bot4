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
import kmsweb.dtos.TariffPackageEntityDto;
import kmsweb.entities.listeners.TariffPackageEntityListener;
import kmsweb.serializers.TariffPackageSerializer;
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
@EntityListeners({TariffPackageEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TariffPackageSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"tariff_package_code"}, name = "tariff_package_code"),
	}
)
public class TariffPackageEntity extends AbstractEntity {

	/**
	 * Takes a TariffPackageEntityDto and converts it into a TariffPackageEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param tariffPackageEntityDto
	 */
	public TariffPackageEntity(TariffPackageEntityDto tariffPackageEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (tariffPackageEntityDto.getId() != null) {
			this.setId(tariffPackageEntityDto.getId());
		}

		if (tariffPackageEntityDto.getTariffPackageCode() != null) {
			this.setTariffPackageCode(tariffPackageEntityDto.getTariffPackageCode());
		}

		if (tariffPackageEntityDto.getTariffPackageName() != null) {
			this.setTariffPackageName(tariffPackageEntityDto.getTariffPackageName());
		}

		if (tariffPackageEntityDto.getTariffPackageClassification() != null) {
			this.setTariffPackageClassification(tariffPackageEntityDto.getTariffPackageClassification());
		}

		if (tariffPackageEntityDto.getCoaSell() != null) {
			this.setCoaSell(tariffPackageEntityDto.getCoaSell());
		}

		if (tariffPackageEntityDto.getTariffPackageDescription() != null) {
			this.setTariffPackageDescription(tariffPackageEntityDto.getTariffPackageDescription());
		}

		if (tariffPackageEntityDto.getApplyToAllServices() != null) {
			this.setApplyToAllServices(tariffPackageEntityDto.getApplyToAllServices());
		}

		if (tariffPackageEntityDto.getServiceItemAssignments() != null) {
			this.setServiceItemAssignments(tariffPackageEntityDto.getServiceItemAssignments());
		}

		if (tariffPackageEntityDto.getTariffPackageItems() != null) {
			this.setTariffPackageItems(tariffPackageEntityDto.getTariffPackageItems());
		}

		if (tariffPackageEntityDto.getTariffPackageServiceAssignments() != null) {
			this.setTariffPackageServiceAssignments(tariffPackageEntityDto.getTariffPackageServiceAssignments());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Package Code here] off begin
	@CsvBindByName(column = "TARIFF_PACKAGE_CODE", required = false)
	@Nullable
	@Column(name = "tariff_package_code")
	@Schema(description = "The Tariff Package Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Package Code here] end
	private String tariffPackageCode;

	// % protected region % [Modify attribute annotation for Tariff Package Name here] off begin
	@CsvBindByName(column = "TARIFF_PACKAGE_NAME", required = false)
	@Nullable
	@Column(name = "tariff_package_name")
	@Schema(description = "The Tariff Package Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Package Name here] end
	private String tariffPackageName;

	// % protected region % [Modify attribute annotation for Tariff Package Classification here] off begin
	@CsvBindByName(column = "TARIFF_PACKAGE_CLASSIFICATION", required = false)
	@Nullable
	@Column(name = "tariff_package_classification")
	@Schema(description = "The Tariff Package Classification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Package Classification here] end
	private String tariffPackageClassification;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@CsvBindByName(column = "COA_SELL", required = false)
	@Nullable
	@Column(name = "coa_sell")
	@Schema(description = "The COA Sell of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for Tariff Package Description here] off begin
	@CsvBindByName(column = "TARIFF_PACKAGE_DESCRIPTION", required = false)
	@Nullable
	@Column(name = "tariff_package_description")
	@Schema(description = "The Tariff Package Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Package Description here] end
	private String tariffPackageDescription;

	// % protected region % [Modify attribute annotation for Apply To All Services here] off begin
	@CsvBindByName(column = "APPLY_TO_ALL_SERVICES", required = false)
	@Nullable
	@Column(name = "apply_to_all_services")
	@Schema(description = "The Apply To All Services of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Apply To All Services here] end
	private Boolean applyToAllServices = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Service Item Assignments here] off begin
	@Schema(description = "The Service Item Assignment entities that are related to this entity.")
	@OneToMany(mappedBy = "tariffPackage", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Item Assignments here] end
	private Set<ServiceItemAssignmentEntity> serviceItemAssignments = new HashSet<>();

	// % protected region % [Update the annotation for serviceItemAssignmentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ITEM_ASSIGNMENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for serviceItemAssignmentsIds here] end
	private Set<UUID> serviceItemAssignmentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Tariff Package Items here] off begin
	@Schema(description = "The Tariff Package Item entities that are related to this entity.")
	@OneToMany(mappedBy = "tariffPackage", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Package Items here] end
	private Set<TariffPackageItemEntity> tariffPackageItems = new HashSet<>();

	// % protected region % [Update the annotation for tariffPackageItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_PACKAGE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for tariffPackageItemsIds here] end
	private Set<UUID> tariffPackageItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Tariff Package Service Assignments here] off begin
	@Schema(description = "The Tariff Package Service Assignment entities that are related to this entity.")
	@OneToMany(mappedBy = "tariffPackage", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Package Service Assignments here] end
	private Set<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignments = new HashSet<>();

	// % protected region % [Update the annotation for tariffPackageServiceAssignmentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_PACKAGE_SERVICE_ASSIGNMENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for tariffPackageServiceAssignmentsIds here] end
	private Set<UUID> tariffPackageServiceAssignmentsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
				entity.setTariffPackage(this, false);
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
			entity.unsetTariffPackage(false);
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
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.setTariffPackage(this, false));
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
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.unsetTariffPackage(false));
		}
		this.serviceItemAssignments.clear();
	}

/**
	 * Similar to {@link this#addTariffPackageItems(TariffPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageItemEntity to be added to this entity
	 */
	public void addTariffPackageItems(@NotNull TariffPackageItemEntity entity) {
		addTariffPackageItems(entity, true);
	}

	/**
	 * Add a new TariffPackageItemEntity to tariffPackageItems in this entity.
	 *
	 * @param entity the given TariffPackageItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffPackageItems(@NonNull TariffPackageItemEntity entity, boolean reverseAdd) {
		if (!this.tariffPackageItems.contains(entity)) {
			tariffPackageItems.add(entity);
			if (reverseAdd) {
				entity.setTariffPackage(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be added to this entity
	 */
	public void addTariffPackageItems(@NotNull Collection<TariffPackageItemEntity> entities) {
		addTariffPackageItems(entities, true);
	}

	/**
	 * Add a new collection of TariffPackageItemEntity to Tariff Package Items in this entity.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffPackageItems(TariffPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageItemEntity to be set to this entity
	 */
	public void removeTariffPackageItems(@NotNull TariffPackageItemEntity entity) {
		this.removeTariffPackageItems(entity, true);
	}

	/**
	 * Remove the given TariffPackageItemEntity from this entity.
	 *
	 * @param entity the given TariffPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffPackageItems(@NotNull TariffPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffPackage(false);
		}
		this.tariffPackageItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffPackageItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be removed to this entity
	 */
	public void removeTariffPackageItems(@NotNull Collection<TariffPackageItemEntity> entities) {
		this.removeTariffPackageItems(entities, true);
	}

	/**
	 * Remove the given collection of TariffPackageItemEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be set to this entity
	 */
	public void setTariffPackageItems(@NotNull Collection<TariffPackageItemEntity> entities) {
		setTariffPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Package Items with the given ones.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffPackageItems(@NotNull Collection<TariffPackageItemEntity> entities, boolean reverseAdd) {

		this.unsetTariffPackageItems();
		this.tariffPackageItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffPackageItems.forEach(tariffPackageItemsEntity -> tariffPackageItemsEntity.setTariffPackage(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffPackageItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffPackageItems() {
		this.unsetTariffPackageItems(true);
	}

	/**
	 * Remove all the entities in Tariff Package Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffPackageItems(boolean doReverse) {
		if (doReverse) {
			this.tariffPackageItems.forEach(tariffPackageItemsEntity -> tariffPackageItemsEntity.unsetTariffPackage(false));
		}
		this.tariffPackageItems.clear();
	}

/**
	 * Similar to {@link this#addTariffPackageServiceAssignments(TariffPackageServiceAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity to be added to this entity
	 */
	public void addTariffPackageServiceAssignments(@NotNull TariffPackageServiceAssignmentEntity entity) {
		addTariffPackageServiceAssignments(entity, true);
	}

	/**
	 * Add a new TariffPackageServiceAssignmentEntity to tariffPackageServiceAssignments in this entity.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffPackageServiceAssignments(@NonNull TariffPackageServiceAssignmentEntity entity, boolean reverseAdd) {
		if (!this.tariffPackageServiceAssignments.contains(entity)) {
			tariffPackageServiceAssignments.add(entity);
			if (reverseAdd) {
				entity.setTariffPackage(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffPackageServiceAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be added to this entity
	 */
	public void addTariffPackageServiceAssignments(@NotNull Collection<TariffPackageServiceAssignmentEntity> entities) {
		addTariffPackageServiceAssignments(entities, true);
	}

	/**
	 * Add a new collection of TariffPackageServiceAssignmentEntity to Tariff Package Service Assignments in this entity.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffPackageServiceAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffPackageServiceAssignments(TariffPackageServiceAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity to be set to this entity
	 */
	public void removeTariffPackageServiceAssignments(@NotNull TariffPackageServiceAssignmentEntity entity) {
		this.removeTariffPackageServiceAssignments(entity, true);
	}

	/**
	 * Remove the given TariffPackageServiceAssignmentEntity from this entity.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffPackageServiceAssignments(@NotNull TariffPackageServiceAssignmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffPackage(false);
		}
		this.tariffPackageServiceAssignments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffPackageServiceAssignments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be removed to this entity
	 */
	public void removeTariffPackageServiceAssignments(@NotNull Collection<TariffPackageServiceAssignmentEntity> entities) {
		this.removeTariffPackageServiceAssignments(entities, true);
	}

	/**
	 * Remove the given collection of TariffPackageServiceAssignmentEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffPackageServiceAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffPackageServiceAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be set to this entity
	 */
	public void setTariffPackageServiceAssignments(@NotNull Collection<TariffPackageServiceAssignmentEntity> entities) {
		setTariffPackageServiceAssignments(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Package Service Assignments with the given ones.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffPackageServiceAssignments(@NotNull Collection<TariffPackageServiceAssignmentEntity> entities, boolean reverseAdd) {

		this.unsetTariffPackageServiceAssignments();
		this.tariffPackageServiceAssignments = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffPackageServiceAssignments.forEach(tariffPackageServiceAssignmentsEntity -> tariffPackageServiceAssignmentsEntity.setTariffPackage(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffPackageServiceAssignments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffPackageServiceAssignments() {
		this.unsetTariffPackageServiceAssignments(true);
	}

	/**
	 * Remove all the entities in Tariff Package Service Assignments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffPackageServiceAssignments(boolean doReverse) {
		if (doReverse) {
			this.tariffPackageServiceAssignments.forEach(tariffPackageServiceAssignmentsEntity -> tariffPackageServiceAssignmentsEntity.unsetTariffPackage(false));
		}
		this.tariffPackageServiceAssignments.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "TARIFF_PACKAGE_CODE,TARIFF_PACKAGE_NAME,TARIFF_PACKAGE_CLASSIFICATION,COA_SELL,TARIFF_PACKAGE_DESCRIPTION,APPLY_TO_ALL_SERVICES,SERVICE_ITEM_ASSIGNMENTS_IDS,TARIFF_PACKAGE_ITEMS_IDS,TARIFF_PACKAGE_SERVICE_ASSIGNMENTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.serviceItemAssignmentsIds = new HashSet<>();
		for (ServiceItemAssignmentEntity serviceItemAssignments: this.serviceItemAssignments) {
			this.serviceItemAssignmentsIds.add(serviceItemAssignments.getId());
		}

		this.tariffPackageItemsIds = new HashSet<>();
		for (TariffPackageItemEntity tariffPackageItems: this.tariffPackageItems) {
			this.tariffPackageItemsIds.add(tariffPackageItems.getId());
		}

		this.tariffPackageServiceAssignmentsIds = new HashSet<>();
		for (TariffPackageServiceAssignmentEntity tariffPackageServiceAssignments: this.tariffPackageServiceAssignments) {
			this.tariffPackageServiceAssignmentsIds.add(tariffPackageServiceAssignments.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object tariffPackage) {
		if (this == tariffPackage) {
			return true;
		}
		if (tariffPackage == null || this.getClass() != tariffPackage.getClass()) {
			return false;
		}
		if (!super.equals(tariffPackage)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TariffPackageEntity that = (TariffPackageEntity) tariffPackage;
		return
			Objects.equals(this.tariffPackageCode, that.tariffPackageCode) &&
			Objects.equals(this.tariffPackageName, that.tariffPackageName) &&
			Objects.equals(this.tariffPackageClassification, that.tariffPackageClassification) &&
			Objects.equals(this.coaSell, that.coaSell) &&
			Objects.equals(this.tariffPackageDescription, that.tariffPackageDescription) &&
			Objects.equals(this.applyToAllServices, that.applyToAllServices) &&
			Objects.equals(this.serviceItemAssignmentsIds, that.serviceItemAssignmentsIds) &&
			Objects.equals(this.tariffPackageItemsIds, that.tariffPackageItemsIds) &&
			Objects.equals(this.tariffPackageServiceAssignmentsIds, that.tariffPackageServiceAssignmentsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
