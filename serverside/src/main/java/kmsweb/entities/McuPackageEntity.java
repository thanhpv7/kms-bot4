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
import kmsweb.dtos.McuPackageEntityDto;
import kmsweb.entities.listeners.McuPackageEntityListener;
import kmsweb.serializers.McuPackageSerializer;
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
@EntityListeners({McuPackageEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = McuPackageSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"mcu_package_code"}, name = "mcu_package_code"),
	}
)
public class McuPackageEntity extends AbstractEntity {

	/**
	 * Takes a McuPackageEntityDto and converts it into a McuPackageEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param mcuPackageEntityDto
	 */
	public McuPackageEntity(McuPackageEntityDto mcuPackageEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (mcuPackageEntityDto.getId() != null) {
			this.setId(mcuPackageEntityDto.getId());
		}

		if (mcuPackageEntityDto.getMcuPackageCode() != null) {
			this.setMcuPackageCode(mcuPackageEntityDto.getMcuPackageCode());
		}

		if (mcuPackageEntityDto.getDescription() != null) {
			this.setDescription(mcuPackageEntityDto.getDescription());
		}

		if (mcuPackageEntityDto.getPackageType() != null) {
			this.setPackageType(mcuPackageEntityDto.getPackageType());
		}

		if (mcuPackageEntityDto.getSequence() != null) {
			this.setSequence(mcuPackageEntityDto.getSequence());
		}

		if (mcuPackageEntityDto.getMcuPackageItems() != null) {
			this.setMcuPackageItems(mcuPackageEntityDto.getMcuPackageItems());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for MCU Package Code here] off begin
	@CsvBindByName(column = "MCU_PACKAGE_CODE", required = true)
	@NotNull(message = "MCU Package Code must not be empty")
	@Column(name = "mcu_package_code")
	@Schema(description = "The MCU Package Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for MCU Package Code here] end
	private String mcuPackageCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = true)
	@NotNull(message = "Description must not be empty")
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Package Type here] off begin
	@CsvBindByName(column = "PACKAGE_TYPE", required = true)
	@NotNull(message = "Package Type must not be empty")
	@Column(name = "package_type")
	@Schema(description = "The Package Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Package Type here] end
	private String packageType;

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

	// % protected region % [Update the annotation for MCU Package Items here] off begin
	@Schema(description = "The MCU Package Item entities that are related to this entity.")
	@OneToMany(mappedBy = "mcuPackage", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for MCU Package Items here] end
	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	// % protected region % [Update the annotation for mcuPackageItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MCU_PACKAGE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for mcuPackageItemsIds here] end
	private Set<UUID> mcuPackageItemsIds = new HashSet<>();

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
				entity.setMcuPackage(this, false);
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
			entity.unsetMcuPackage(false);
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
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.setMcuPackage(this, false));
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
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.unsetMcuPackage(false));
		}
		this.mcuPackageItems.clear();
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
		return "MCU_PACKAGE_CODE,DESCRIPTION,PACKAGE_TYPE,SEQUENCE,MCU_PACKAGE_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.mcuPackageItemsIds = new HashSet<>();
		for (McuPackageItemEntity mcuPackageItems: this.mcuPackageItems) {
			this.mcuPackageItemsIds.add(mcuPackageItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object mcuPackage) {
		if (this == mcuPackage) {
			return true;
		}
		if (mcuPackage == null || this.getClass() != mcuPackage.getClass()) {
			return false;
		}
		if (!super.equals(mcuPackage)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		McuPackageEntity that = (McuPackageEntity) mcuPackage;
		return
			Objects.equals(this.mcuPackageCode, that.mcuPackageCode) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.packageType, that.packageType) &&
			Objects.equals(this.sequence, that.sequence) &&
			Objects.equals(this.mcuPackageItemsIds, that.mcuPackageItemsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
