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
import kmsweb.dtos.ExaminationItemEntityDto;
import kmsweb.entities.listeners.ExaminationItemEntityListener;
import kmsweb.serializers.ExaminationItemSerializer;
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
@EntityListeners({ExaminationItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ExaminationItemSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"item_code"}, name = "item_code"),
	}
)
public class ExaminationItemEntity extends AbstractEntity {

	/**
	 * Takes a ExaminationItemEntityDto and converts it into a ExaminationItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param examinationItemEntityDto
	 */
	public ExaminationItemEntity(ExaminationItemEntityDto examinationItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (examinationItemEntityDto.getId() != null) {
			this.setId(examinationItemEntityDto.getId());
		}

		if (examinationItemEntityDto.getItemCode() != null) {
			this.setItemCode(examinationItemEntityDto.getItemCode());
		}

		if (examinationItemEntityDto.getDescription() != null) {
			this.setDescription(examinationItemEntityDto.getDescription());
		}

		if (examinationItemEntityDto.getSample() != null) {
			this.setSample(examinationItemEntityDto.getSample());
		}

		if (examinationItemEntityDto.getExaminationLevel() != null) {
			this.setExaminationLevel(examinationItemEntityDto.getExaminationLevel());
		}

		if (examinationItemEntityDto.getExaminationType() != null) {
			this.setExaminationType(examinationItemEntityDto.getExaminationType());
		}

		if (examinationItemEntityDto.getDiagnosticExaminationResults() != null) {
			this.setDiagnosticExaminationResults(examinationItemEntityDto.getDiagnosticExaminationResults());
		}

		if (examinationItemEntityDto.getExaminationItemDetails() != null) {
			this.setExaminationItemDetails(examinationItemEntityDto.getExaminationItemDetails());
		}

		if (examinationItemEntityDto.getExaminationItemOfMCUItem() != null) {
			this.setExaminationItemOfMCUItem(examinationItemEntityDto.getExaminationItemOfMCUItem());
		}

		if (examinationItemEntityDto.getRegistrations() != null) {
			this.setRegistrations(examinationItemEntityDto.getRegistrations());
		}

		if (examinationItemEntityDto.getExaminationGroup() != null) {
			this.setExaminationGroup(examinationItemEntityDto.getExaminationGroup());
		}

		if (examinationItemEntityDto.getServiceItem() != null) {
			this.setServiceItem(examinationItemEntityDto.getServiceItem());
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

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = true)
	@NotNull(message = "Description must not be empty")
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Sample here] off begin
	@CsvBindByName(column = "SAMPLE", required = false)
	@Nullable
	@Column(name = "sample")
	@Schema(description = "The Sample of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample here] end
	private String sample;

	// % protected region % [Modify attribute annotation for Examination Level here] off begin
	@CsvBindByName(column = "EXAMINATION_LEVEL", required = false)
	@Nullable
	@Column(name = "examination_level")
	@Schema(description = "The Examination Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Examination Level here] end
	private String examinationLevel;

	// % protected region % [Modify attribute annotation for Examination Type here] off begin
	@CsvBindByName(column = "EXAMINATION_TYPE", required = false)
	@Nullable
	@Column(name = "examination_type")
	@Schema(description = "The Examination Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Examination Type here] end
	private String examinationType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Diagnostic Examination Results here] off begin
	@Schema(description = "The Diagnostic Examination Results entities that are related to this entity.")
	@OneToMany(mappedBy = "examinationItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnostic Examination Results here] end
	private Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();

	// % protected region % [Update the annotation for diagnosticExaminationResultsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSTIC_EXAMINATION_RESULTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for diagnosticExaminationResultsIds here] end
	private Set<UUID> diagnosticExaminationResultsIds = new HashSet<>();

	// % protected region % [Update the annotation for Examination Item Details here] off begin
	@Schema(description = "The Examination Item Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "examinationItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Item Details here] end
	private Set<ExaminationItemDetailEntity> examinationItemDetails = new HashSet<>();

	// % protected region % [Update the annotation for examinationItemDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEM_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationItemDetailsIds here] end
	private Set<UUID> examinationItemDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Examination Item of MCU Item here] off begin
	@Schema(description = "The MCU Package Item entities that are related to this entity.")
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Item of MCU Item here] end
	private Set<McuPackageItemEntity> examinationItemOfMCUItem = new HashSet<>();

	// % protected region % [Update the annotation for examinationItemOfMCUItemIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEM_OF_MCU_ITEM_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationItemOfMCUItemIds here] end
	private Set<UUID> examinationItemOfMCUItemIds = new HashSet<>();

	// % protected region % [Update the annotation for Registrations here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registrations here] end
	private Set<RegistrationEntity> registrations = new HashSet<>();

	// % protected region % [Update the annotation for registrationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for registrationsIds here] end
	private Set<UUID> registrationsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Examination Group here] off begin
	@Schema(description = "The Examination Group entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Group here] end
	private ExaminationGroupEntity examinationGroup;

	// % protected region % [Update the annotation for examinationGroupId here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_GROUP_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for examinationGroupId here] end
	private UUID examinationGroupId;

	// % protected region % [Update the annotation for Service Item here] off begin
	@Schema(description = "The Service Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Item here] end
	private ServiceItemEntity serviceItem;

	// % protected region % [Update the annotation for serviceItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceItemId here] end
	private UUID serviceItemId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addDiagnosticExaminationResults(DiagnosticExaminationResultsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be added to this entity
	 */
	public void addDiagnosticExaminationResults(@NotNull DiagnosticExaminationResultsEntity entity) {
		addDiagnosticExaminationResults(entity, true);
	}

	/**
	 * Add a new DiagnosticExaminationResultsEntity to diagnosticExaminationResults in this entity.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity, boolean reverseAdd) {
		if (!this.diagnosticExaminationResults.contains(entity)) {
			diagnosticExaminationResults.add(entity);
			if (reverseAdd) {
				entity.setExaminationItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosticExaminationResults(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be added to this entity
	 */
	public void addDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities) {
		addDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Add a new collection of DiagnosticExaminationResultsEntity to Diagnostic Examination Results in this entity.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosticExaminationResults(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosticExaminationResults(DiagnosticExaminationResultsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be set to this entity
	 */
	public void removeDiagnosticExaminationResults(@NotNull DiagnosticExaminationResultsEntity entity) {
		this.removeDiagnosticExaminationResults(entity, true);
	}

	/**
	 * Remove the given DiagnosticExaminationResultsEntity from this entity.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosticExaminationResults(@NotNull DiagnosticExaminationResultsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetExaminationItem(false);
		}
		this.diagnosticExaminationResults.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosticExaminationResults(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be removed to this entity
	 */
	public void removeDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities) {
		this.removeDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosticExaminationResultsEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosticExaminationResults(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosticExaminationResults(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be set to this entity
	 */
	public void setDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities) {
		setDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Replace the current entities in Diagnostic Examination Results with the given ones.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosticExaminationResults();
		this.diagnosticExaminationResults = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosticExaminationResults.forEach(diagnosticExaminationResultsEntity -> diagnosticExaminationResultsEntity.setExaminationItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosticExaminationResults(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosticExaminationResults() {
		this.unsetDiagnosticExaminationResults(true);
	}

	/**
	 * Remove all the entities in Diagnostic Examination Results from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosticExaminationResults(boolean doReverse) {
		if (doReverse) {
			this.diagnosticExaminationResults.forEach(diagnosticExaminationResultsEntity -> diagnosticExaminationResultsEntity.unsetExaminationItem(false));
		}
		this.diagnosticExaminationResults.clear();
	}

/**
	 * Similar to {@link this#addExaminationItemDetails(ExaminationItemDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemDetailEntity to be added to this entity
	 */
	public void addExaminationItemDetails(@NotNull ExaminationItemDetailEntity entity) {
		addExaminationItemDetails(entity, true);
	}

	/**
	 * Add a new ExaminationItemDetailEntity to examinationItemDetails in this entity.
	 *
	 * @param entity the given ExaminationItemDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItemDetails(@NonNull ExaminationItemDetailEntity entity, boolean reverseAdd) {
		if (!this.examinationItemDetails.contains(entity)) {
			examinationItemDetails.add(entity);
			if (reverseAdd) {
				entity.setExaminationItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItemDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to be added to this entity
	 */
	public void addExaminationItemDetails(@NotNull Collection<ExaminationItemDetailEntity> entities) {
		addExaminationItemDetails(entities, true);
	}

	/**
	 * Add a new collection of ExaminationItemDetailEntity to Examination Item Details in this entity.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItemDetails(@NonNull Collection<ExaminationItemDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addExaminationItemDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItemDetails(ExaminationItemDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemDetailEntity to be set to this entity
	 */
	public void removeExaminationItemDetails(@NotNull ExaminationItemDetailEntity entity) {
		this.removeExaminationItemDetails(entity, true);
	}

	/**
	 * Remove the given ExaminationItemDetailEntity from this entity.
	 *
	 * @param entity the given ExaminationItemDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItemDetails(@NotNull ExaminationItemDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetExaminationItem(false);
		}
		this.examinationItemDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItemDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to be removed to this entity
	 */
	public void removeExaminationItemDetails(@NotNull Collection<ExaminationItemDetailEntity> entities) {
		this.removeExaminationItemDetails(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationItemDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeExaminationItemDetails(@NonNull Collection<ExaminationItemDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeExaminationItemDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setExaminationItemDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to be set to this entity
	 */
	public void setExaminationItemDetails(@NotNull Collection<ExaminationItemDetailEntity> entities) {
		setExaminationItemDetails(entities, true);
	}

	/**
	 * Replace the current entities in Examination Item Details with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItemDetails(@NotNull Collection<ExaminationItemDetailEntity> entities, boolean reverseAdd) {

		this.unsetExaminationItemDetails();
		this.examinationItemDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItemDetails.forEach(examinationItemDetailsEntity -> examinationItemDetailsEntity.setExaminationItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetExaminationItemDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetExaminationItemDetails() {
		this.unsetExaminationItemDetails(true);
	}

	/**
	 * Remove all the entities in Examination Item Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetExaminationItemDetails(boolean doReverse) {
		if (doReverse) {
			this.examinationItemDetails.forEach(examinationItemDetailsEntity -> examinationItemDetailsEntity.unsetExaminationItem(false));
		}
		this.examinationItemDetails.clear();
	}

	/**
	 * Similar to {@link this#addExaminationItemOfMCUItem(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be added to this entity
	 */
	public void addExaminationItemOfMCUItem(@NotNull McuPackageItemEntity entity) {
		addExaminationItemOfMCUItem(entity, true);
	}

	/**
	 * Add a new McuPackageItemEntity to Examination Item of MCU Item in this entity.
	 *
	 * @param entity the given McuPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItemOfMCUItem(@NonNull McuPackageItemEntity entity, boolean reverseAdd) {
		if (!this.examinationItemOfMCUItem.contains(entity)) {
			this.examinationItemOfMCUItem.add(entity);
			if (reverseAdd) {
				entity.addExaminationItems(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItemOfMCUItem(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addExaminationItemOfMCUItem(@NotNull Collection<McuPackageItemEntity> entities) {
		addExaminationItemOfMCUItem(entities, true);
	}

	/**
	 * Add new collection of McuPackageItemEntity to examinationItemOfMCUItem in this entity.
	 *
	 * @param entities the given entities to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItemOfMCUItem(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addExaminationItemOfMCUItem(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItemOfMCUItem(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be set to this entity
	 */
	public void removeExaminationItemOfMCUItem(@NotNull McuPackageItemEntity entity) {
		this.removeExaminationItemOfMCUItem(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the give McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItemOfMCUItem(@NotNull McuPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeExaminationItems(this, false);
		}
		this.examinationItemOfMCUItem.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItemOfMCUItem(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeExaminationItemOfMCUItem(@NotNull Collection<McuPackageItemEntity> entities) {
		this.removeExaminationItemOfMCUItem(entities, true);
	}

	/**
	 * Remove the given collection of McuPackageItemEntity in examinationItemOfMCUItem from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeExaminationItemOfMCUItem(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeExaminationItemOfMCUItem(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setExaminationItemOfMCUItem(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setExaminationItemOfMCUItem(@NotNull Collection<McuPackageItemEntity> entities) {
		this.setExaminationItemOfMCUItem(entities, true);
	}

	/**
	 * Replace the current entities in examinationItemOfMCUItem with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItemOfMCUItem(@NotNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		this.unsetExaminationItemOfMCUItem();
		this.examinationItemOfMCUItem = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItemOfMCUItem.forEach(entity -> entity.addExaminationItems(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetExaminationItemOfMCUItem(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetExaminationItemOfMCUItem() {
		this.unsetExaminationItemOfMCUItem(true);
	}

	/**
	 * Remove all entities in examinationItemOfMCUItem from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetExaminationItemOfMCUItem(boolean doReverse) {
		if (doReverse) {
			this.examinationItemOfMCUItem.forEach(entity -> entity.removeExaminationItems(this, false));
		}
		this.examinationItemOfMCUItem.clear();
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
	 * Add a new RegistrationEntity to Registrations in this entity.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.registrations.contains(entity)) {
			this.registrations.add(entity);
			if (reverseAdd) {
				entity.addExaminationItems(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		addRegistrations(entities, true);
	}

	/**
	 * Add new collection of RegistrationEntity to registrations in this entity.
	 *
	 * @param entities the given entities to be added to this entity
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
	 * @param entity the give RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeExaminationItems(this, false);
		}
		this.registrations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRegistrations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		this.removeRegistrations(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity in registrations from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		this.setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in registrations with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		this.unsetRegistrations();
		this.registrations = new HashSet<>(entities);
		if (reverseAdd) {
			this.registrations.forEach(entity -> entity.addExaminationItems(this, false));
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
	 * Remove all entities in registrations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRegistrations(boolean doReverse) {
		if (doReverse) {
			this.registrations.forEach(entity -> entity.removeExaminationItems(this, false));
		}
		this.registrations.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setExaminationGroup(ExaminationGroupEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationGroupEntity to be set to this entity
	 */
	public void setExaminationGroup(@NotNull ExaminationGroupEntity entity) {
		setExaminationGroup(entity, true);
	}

	/**
	 * Set or update the examinationGroup in this entity with single ExaminationGroupEntity.
	 *
	 * @param entity the given ExaminationGroupEntity to be set or updated to examinationGroup
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setExaminationGroup(@NotNull ExaminationGroupEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setExaminationGroup here] off begin
		// % protected region % [Add any additional logic here before the main logic for setExaminationGroup here] end

		if (sameAsFormer(this.examinationGroup, entity)) {
			return;
		}

		if (this.examinationGroup != null) {
			this.examinationGroup.removeExaminationItems(this, false);
		}
		this.examinationGroup = entity;
		if (reverseAdd) {
			this.examinationGroup.addExaminationItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setExaminationGroup incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setExaminationGroup incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetExaminationGroup(boolean)} but default to true.
	 */
	public void unsetExaminationGroup() {
		this.unsetExaminationGroup(true);
	}

	/**
	 * Remove Examination Group in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetExaminationGroup(boolean reverse) {
		if (reverse && this.examinationGroup != null) {
			this.examinationGroup.removeExaminationItems(this, false);
		}
		this.examinationGroup = null;
	}
	/**
	 * Similar to {@link this#setServiceItem(ServiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemEntity to be set to this entity
	 */
	public void setServiceItem(@NotNull ServiceItemEntity entity) {
		setServiceItem(entity, true);
	}

	/**
	 * Set or update the serviceItem in this entity with single ServiceItemEntity.
	 *
	 * @param entity the given ServiceItemEntity to be set or updated to serviceItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setServiceItem(@NotNull ServiceItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setServiceItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setServiceItem here] end

		if (sameAsFormer(this.serviceItem, entity)) {
			return;
		}

		if (this.serviceItem != null) {
			this.serviceItem.removeExaminationItems(this, false);
		}
		this.serviceItem = entity;
		if (reverseAdd) {
			this.serviceItem.addExaminationItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setServiceItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setServiceItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetServiceItem(boolean)} but default to true.
	 */
	public void unsetServiceItem() {
		this.unsetServiceItem(true);
	}

	/**
	 * Remove Service Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetServiceItem(boolean reverse) {
		if (reverse && this.serviceItem != null) {
			this.serviceItem.removeExaminationItems(this, false);
		}
		this.serviceItem = null;
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
		return "ITEM_CODE,DESCRIPTION,SAMPLE,EXAMINATION_LEVEL,EXAMINATION_TYPE,EXAMINATION_GROUP_ID,SERVICE_ITEM_ID,DIAGNOSTIC_EXAMINATION_RESULTS_IDS,EXAMINATION_ITEM_DETAILS_IDS,EXAMINATION_ITEM_OF_MCU_ITEM_IDS,REGISTRATIONS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<ExaminationGroupEntity> examinationGroupRelation = Optional.ofNullable(this.examinationGroup);
		examinationGroupRelation.ifPresent(entity -> this.examinationGroupId = entity.getId());

		Optional<ServiceItemEntity> serviceItemRelation = Optional.ofNullable(this.serviceItem);
		serviceItemRelation.ifPresent(entity -> this.serviceItemId = entity.getId());

		this.diagnosticExaminationResultsIds = new HashSet<>();
		for (DiagnosticExaminationResultsEntity diagnosticExaminationResults: this.diagnosticExaminationResults) {
			this.diagnosticExaminationResultsIds.add(diagnosticExaminationResults.getId());
		}

		this.examinationItemDetailsIds = new HashSet<>();
		for (ExaminationItemDetailEntity examinationItemDetails: this.examinationItemDetails) {
			this.examinationItemDetailsIds.add(examinationItemDetails.getId());
		}

		this.examinationItemOfMCUItemIds = new HashSet<>();
		for (McuPackageItemEntity examinationItemOfMCUItem: this.examinationItemOfMCUItem) {
			this.examinationItemOfMCUItemIds.add(examinationItemOfMCUItem.getId());
		}

		this.registrationsIds = new HashSet<>();
		for (RegistrationEntity registrations: this.registrations) {
			this.registrationsIds.add(registrations.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object examinationItem) {
		if (this == examinationItem) {
			return true;
		}
		if (examinationItem == null || this.getClass() != examinationItem.getClass()) {
			return false;
		}
		if (!super.equals(examinationItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ExaminationItemEntity that = (ExaminationItemEntity) examinationItem;
		return
			Objects.equals(this.itemCode, that.itemCode) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.sample, that.sample) &&
			Objects.equals(this.examinationLevel, that.examinationLevel) &&
			Objects.equals(this.examinationType, that.examinationType) &&
			Objects.equals(this.diagnosticExaminationResultsIds, that.diagnosticExaminationResultsIds) &&
			Objects.equals(this.examinationItemDetailsIds, that.examinationItemDetailsIds) &&
			Objects.equals(this.examinationGroupId, that.examinationGroupId) &&
			Objects.equals(this.serviceItemId, that.serviceItemId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
