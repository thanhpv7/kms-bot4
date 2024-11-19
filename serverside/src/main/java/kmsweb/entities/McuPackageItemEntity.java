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
import kmsweb.dtos.McuPackageItemEntityDto;
import kmsweb.entities.listeners.McuPackageItemEntityListener;
import kmsweb.serializers.McuPackageItemSerializer;
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
@EntityListeners({McuPackageItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = McuPackageItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class McuPackageItemEntity extends AbstractEntity {

	/**
	 * Takes a McuPackageItemEntityDto and converts it into a McuPackageItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param mcuPackageItemEntityDto
	 */
	public McuPackageItemEntity(McuPackageItemEntityDto mcuPackageItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (mcuPackageItemEntityDto.getId() != null) {
			this.setId(mcuPackageItemEntityDto.getId());
		}

		if (mcuPackageItemEntityDto.getItemCode() != null) {
			this.setItemCode(mcuPackageItemEntityDto.getItemCode());
		}

		if (mcuPackageItemEntityDto.getDuration() != null) {
			this.setDuration(mcuPackageItemEntityDto.getDuration());
		}

		if (mcuPackageItemEntityDto.getSequence() != null) {
			this.setSequence(mcuPackageItemEntityDto.getSequence());
		}

		if (mcuPackageItemEntityDto.getExaminationItems() != null) {
			this.setExaminationItems(mcuPackageItemEntityDto.getExaminationItems());
		}

		if (mcuPackageItemEntityDto.getMcuPackage() != null) {
			this.setMcuPackage(mcuPackageItemEntityDto.getMcuPackage());
		}

		if (mcuPackageItemEntityDto.getService() != null) {
			this.setService(mcuPackageItemEntityDto.getService());
		}

		if (mcuPackageItemEntityDto.getStaff() != null) {
			this.setStaff(mcuPackageItemEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Item Code here] off begin
	@CsvBindByName(column = "ITEM_CODE", required = true)
	@NotNull(message = "Item Code must not be empty")
	@Column(name = "item_code")
	@Schema(description = "The Item Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Code here] end
	private String itemCode;

	// % protected region % [Modify attribute annotation for Duration here] off begin
	@CsvBindByName(column = "DURATION", required = false)
	@Nullable
	@Column(name = "duration")
	@Schema(description = "The Duration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Duration here] end
	private Integer duration;

	// % protected region % [Modify attribute annotation for Sequence here] off begin
	@CsvBindByName(column = "SEQUENCE", required = false)
	@Nullable
	@Column(name = "sequence")
	@Schema(description = "The Sequence of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sequence here] end
	private Integer sequence;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Examination Items here] off begin
	@Schema(description = "The Examination Items entities that are related to this entity.")
	@ManyToMany(mappedBy = "examinationItemOfMCUItem", fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Items here] end
	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	// % protected region % [Update the annotation for examinationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationItemsIds here] end
	private Set<UUID> examinationItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for MCU Package here] off begin
	@Schema(description = "The MCU Package entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for MCU Package here] end
	private McuPackageEntity mcuPackage;

	// % protected region % [Update the annotation for mcuPackageId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MCU_PACKAGE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for mcuPackageId here] end
	private UUID mcuPackageId;

	// % protected region % [Update the annotation for Service here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service here] end
	private ServiceEntity service;

	// % protected region % [Update the annotation for serviceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceId here] end
	private UUID serviceId;

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#addExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 */
	public void addExaminationItems(@NotNull ExaminationItemEntity entity) {
		this.addExaminationItems(entity, true);
	}

	/**
	 * Add a new ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItems(@NotNull ExaminationItemEntity entity, boolean reverseAdd) {
		if (!this.examinationItems.contains(entity)) {
			this.examinationItems.add(entity);
			if (reverseAdd) {
				entity.addExaminationItemOfMCUItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added into examinationItems
	 */
	public void addExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		this.addExaminationItems(entities, true);
	}

	/**
	 * Add new collection of ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added into examinationItems in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to examinationItems in this entity
	 */
	public void removeExaminationItems(@NotNull ExaminationItemEntity entity) {
		this.removeExaminationItems(entity, true);
	}

	/**
	 * Remove the given ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be removed from examinationItems
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItems(@NotNull ExaminationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeExaminationItemOfMCUItem(this, false);
		}
		this.examinationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed from examinationItems in this entity
	 */
	public void removeExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		this.removeExaminationItems(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed from examinationItems
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeExaminationItems(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 */
	public void setExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		this.setExaminationItems(entities, true);
	}

	/**
	 * Replace the current collection of ExaminationItemEntity in examinationItems with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItems(@NotNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		unsetExaminationItems();
		this.examinationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.addExaminationItemOfMCUItem(this, false));
		}
	}

	/**
	 * Remove all entities in Examination Items from this entity.
	 */
	public void unsetExaminationItems() {
		this.examinationItems.forEach(entity -> entity.removeExaminationItemOfMCUItem(this, false));
		this.examinationItems.clear();
	}
	/**
	 * Similar to {@link this#setMcuPackage(McuPackageEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageEntity to be set to this entity
	 */
	public void setMcuPackage(@NotNull McuPackageEntity entity) {
		setMcuPackage(entity, true);
	}

	/**
	 * Set or update the mcuPackage in this entity with single McuPackageEntity.
	 *
	 * @param entity the given McuPackageEntity to be set or updated to mcuPackage
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMcuPackage(@NotNull McuPackageEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMcuPackage here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMcuPackage here] end

		if (sameAsFormer(this.mcuPackage, entity)) {
			return;
		}

		if (this.mcuPackage != null) {
			this.mcuPackage.removeMcuPackageItems(this, false);
		}
		this.mcuPackage = entity;
		if (reverseAdd) {
			this.mcuPackage.addMcuPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMcuPackage incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMcuPackage incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMcuPackage(boolean)} but default to true.
	 */
	public void unsetMcuPackage() {
		this.unsetMcuPackage(true);
	}

	/**
	 * Remove MCU Package in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMcuPackage(boolean reverse) {
		if (reverse && this.mcuPackage != null) {
			this.mcuPackage.removeMcuPackageItems(this, false);
		}
		this.mcuPackage = null;
	}
	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(@NotNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NotNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.removeMcuPackageItems(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addMcuPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove Service in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.removeMcuPackageItems(this, false);
		}
		this.service = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeMcuPackageItems(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addMcuPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeMcuPackageItems(this, false);
		}
		this.staff = null;
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
		return "ITEM_CODE,DURATION,SEQUENCE,EXAMINATION_ITEMS_IDS,MCU_PACKAGE_ID,SERVICE_ID,STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.examinationItemsIds = new HashSet<>();
		for (ExaminationItemEntity examinationItems: this.examinationItems) {
			this.examinationItemsIds.add(examinationItems.getId());
		}

		Optional<McuPackageEntity> mcuPackageRelation = Optional.ofNullable(this.mcuPackage);
		mcuPackageRelation.ifPresent(entity -> this.mcuPackageId = entity.getId());

		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object mcuPackageItem) {
		if (this == mcuPackageItem) {
			return true;
		}
		if (mcuPackageItem == null || this.getClass() != mcuPackageItem.getClass()) {
			return false;
		}
		if (!super.equals(mcuPackageItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		McuPackageItemEntity that = (McuPackageItemEntity) mcuPackageItem;
		return
			Objects.equals(this.itemCode, that.itemCode) &&
			Objects.equals(this.duration, that.duration) &&
			Objects.equals(this.sequence, that.sequence) &&
			Objects.equals(this.mcuPackageId, that.mcuPackageId) &&
			Objects.equals(this.serviceId, that.serviceId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
