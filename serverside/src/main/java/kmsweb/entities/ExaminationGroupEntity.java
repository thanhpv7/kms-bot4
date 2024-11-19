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
import kmsweb.dtos.ExaminationGroupEntityDto;
import kmsweb.entities.listeners.ExaminationGroupEntityListener;
import kmsweb.serializers.ExaminationGroupSerializer;
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
@EntityListeners({ExaminationGroupEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ExaminationGroupSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"diagnostic_group_code"}, name = "diagnostic_group_code"),
	}
)
public class ExaminationGroupEntity extends AbstractEntity {

	/**
	 * Takes a ExaminationGroupEntityDto and converts it into a ExaminationGroupEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param examinationGroupEntityDto
	 */
	public ExaminationGroupEntity(ExaminationGroupEntityDto examinationGroupEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (examinationGroupEntityDto.getId() != null) {
			this.setId(examinationGroupEntityDto.getId());
		}

		if (examinationGroupEntityDto.getDiagnosticGroupCode() != null) {
			this.setDiagnosticGroupCode(examinationGroupEntityDto.getDiagnosticGroupCode());
		}

		if (examinationGroupEntityDto.getDescription() != null) {
			this.setDescription(examinationGroupEntityDto.getDescription());
		}

		if (examinationGroupEntityDto.getSequence() != null) {
			this.setSequence(examinationGroupEntityDto.getSequence());
		}

		if (examinationGroupEntityDto.getExaminationItems() != null) {
			this.setExaminationItems(examinationGroupEntityDto.getExaminationItems());
		}

		if (examinationGroupEntityDto.getService() != null) {
			this.setService(examinationGroupEntityDto.getService());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diagnostic Group Code here] off begin
	@CsvBindByName(column = "DIAGNOSTIC_GROUP_CODE", required = true)
	@NotNull(message = "Diagnostic Group Code must not be empty")
	@Column(name = "diagnostic_group_code")
	@Schema(description = "The Diagnostic Group Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnostic Group Code here] end
	private String diagnosticGroupCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = true)
	@NotNull(message = "Description must not be empty")
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

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

	// % protected region % [Update the annotation for Examination Items here] off begin
	@Schema(description = "The Examination Item entities that are related to this entity.")
	@OneToMany(mappedBy = "examinationGroup", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Items here] end
	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	// % protected region % [Update the annotation for examinationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationItemsIds here] end
	private Set<UUID> examinationItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
				entity.setExaminationGroup(this, false);
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
			entity.unsetExaminationGroup(false);
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
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.setExaminationGroup(this, false));
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
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.unsetExaminationGroup(false));
		}
		this.examinationItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.service.removeExaminationGroups(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addExaminationGroups(this, false);
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
			this.service.removeExaminationGroups(this, false);
		}
		this.service = null;
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
		return "DIAGNOSTIC_GROUP_CODE,DESCRIPTION,SEQUENCE,SERVICE_ID,EXAMINATION_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		this.examinationItemsIds = new HashSet<>();
		for (ExaminationItemEntity examinationItems: this.examinationItems) {
			this.examinationItemsIds.add(examinationItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object examinationGroup) {
		if (this == examinationGroup) {
			return true;
		}
		if (examinationGroup == null || this.getClass() != examinationGroup.getClass()) {
			return false;
		}
		if (!super.equals(examinationGroup)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ExaminationGroupEntity that = (ExaminationGroupEntity) examinationGroup;
		return
			Objects.equals(this.diagnosticGroupCode, that.diagnosticGroupCode) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.sequence, that.sequence) &&
			Objects.equals(this.examinationItemsIds, that.examinationItemsIds) &&
			Objects.equals(this.serviceId, that.serviceId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
