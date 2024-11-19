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
public class ExaminationItemEntity extends AbstractEntity {

	public ExaminationItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DiagnosticExaminationResultsOneMany = new EntityReference();
			DiagnosticExaminationResultsOneMany.entityName = "DiagnosticExaminationResults";
			DiagnosticExaminationResultsOneMany.oppositeName = "ExaminationItem";
			DiagnosticExaminationResultsOneMany.name = "DiagnosticExaminationResults";
			DiagnosticExaminationResultsOneMany.optional = true;
			DiagnosticExaminationResultsOneMany.type = "One";
			DiagnosticExaminationResultsOneMany.oppositeType = "Many";

		References.add(DiagnosticExaminationResultsOneMany);

		var ExaminationItemDetailsOneMany = new EntityReference();
			ExaminationItemDetailsOneMany.entityName = "ExaminationItemDetail";
			ExaminationItemDetailsOneMany.oppositeName = "ExaminationItem";
			ExaminationItemDetailsOneMany.name = "ExaminationItemDetails";
			ExaminationItemDetailsOneMany.optional = true;
			ExaminationItemDetailsOneMany.type = "One";
			ExaminationItemDetailsOneMany.oppositeType = "Many";

		References.add(ExaminationItemDetailsOneMany);

		var ExaminationItemOfMCUItemManyMany = new EntityReference();
			ExaminationItemOfMCUItemManyMany.entityName = "McuPackageItem";
			ExaminationItemOfMCUItemManyMany.oppositeName = "ExaminationItems";
			ExaminationItemOfMCUItemManyMany.name = "ExaminationItemOfMCUItem";
			ExaminationItemOfMCUItemManyMany.optional = true;
			ExaminationItemOfMCUItemManyMany.type = "Many";
			ExaminationItemOfMCUItemManyMany.oppositeType = "Many";

		References.add(ExaminationItemOfMCUItemManyMany);

		var ExaminationGroupOneMany = new EntityReference();
			ExaminationGroupOneMany.entityName = "ExaminationGroup";
			ExaminationGroupOneMany.oppositeName = "ExaminationGroup";
			ExaminationGroupOneMany.name = "ExaminationItems";
			ExaminationGroupOneMany.optional = true;
			ExaminationGroupOneMany.type = "One";
			ExaminationGroupOneMany.oppositeType = "Many";

		References.add(ExaminationGroupOneMany);

		var ServiceItemOneMany = new EntityReference();
			ServiceItemOneMany.entityName = "ServiceItem";
			ServiceItemOneMany.oppositeName = "ServiceItem";
			ServiceItemOneMany.name = "ExaminationItems";
			ServiceItemOneMany.optional = true;
			ServiceItemOneMany.type = "One";
			ServiceItemOneMany.oppositeType = "Many";

		References.add(ServiceItemOneMany);

		var RegistrationsManyMany = new EntityReference();
			RegistrationsManyMany.entityName = "Registration";
			RegistrationsManyMany.oppositeName = "ExaminationItems";
			RegistrationsManyMany.name = "Registrations";
			RegistrationsManyMany.optional = true;
			RegistrationsManyMany.type = "Many";
			RegistrationsManyMany.oppositeType = "Many";

		References.add(RegistrationsManyMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Item Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Code here] end
	private String itemCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Sample here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample here] end
	private String sample;

	// % protected region % [Modify attribute annotation for Examination Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Examination Level here] end
	private String examinationLevel;

	// % protected region % [Modify attribute annotation for Examination Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Examination Type here] end
	private String examinationType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();

	private Set<ExaminationItemDetailEntity> examinationItemDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private ExaminationGroupEntity examinationGroup;

	private ServiceItemEntity serviceItem;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<McuPackageItemEntity> examinationItemOfMCUItem = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
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
	 * Similar to {@link this#addDiagnosticExaminationResults(DiagnosticExaminationResultsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be added to this entity
	 */
	public void addDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity) {
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
	public void addDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities) {
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
	public void removeDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity) {
		this.removeDiagnosticExaminationResults(entity, true);
	}

	/**
	 * Remove the given DiagnosticExaminationResultsEntity from this entity.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity, boolean reverse) {
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
	public void removeDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities) {
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
	public void setDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities) {
		setDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Replace the current entities in Diagnostic Examination Results with the given ones.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {

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
	public void addExaminationItemDetails(@NonNull ExaminationItemDetailEntity entity) {
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
	public void addExaminationItemDetails(@NonNull Collection<ExaminationItemDetailEntity> entities) {
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
	public void removeExaminationItemDetails(@NonNull ExaminationItemDetailEntity entity) {
		this.removeExaminationItemDetails(entity, true);
	}

	/**
	 * Remove the given ExaminationItemDetailEntity from this entity.
	 *
	 * @param entity the given ExaminationItemDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItemDetails(@NonNull ExaminationItemDetailEntity entity, boolean reverse) {
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
	public void removeExaminationItemDetails(@NonNull Collection<ExaminationItemDetailEntity> entities) {
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
	public void setExaminationItemDetails(@NonNull Collection<ExaminationItemDetailEntity> entities) {
		setExaminationItemDetails(entities, true);
	}

	/**
	 * Replace the current entities in Examination Item Details with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItemDetails(@NonNull Collection<ExaminationItemDetailEntity> entities, boolean reverseAdd) {

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
	public void addExaminationItemOfMCUItem(@NonNull McuPackageItemEntity entity) {
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
	public void addExaminationItemOfMCUItem(@NonNull Collection<McuPackageItemEntity> entities) {
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
	public void removeExaminationItemOfMCUItem(@NonNull McuPackageItemEntity entity) {
		this.removeExaminationItemOfMCUItem(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the give McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItemOfMCUItem(@NonNull McuPackageItemEntity entity, boolean reverse) {
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
	public void removeExaminationItemOfMCUItem(@NonNull Collection<McuPackageItemEntity> entities) {
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
	public void setExaminationItemOfMCUItem(@NonNull Collection<McuPackageItemEntity> entities) {
		this.setExaminationItemOfMCUItem(entities, true);
	}

	/**
	 * Replace the current entities in examinationItemOfMCUItem with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItemOfMCUItem(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
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
	public void addRegistrations(@NonNull RegistrationEntity entity) {
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
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities) {
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
	public void removeRegistrations(@NonNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the give RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity, boolean reverse) {
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
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities) {
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
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		this.setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in registrations with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
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
	public void setExaminationGroup(@NonNull ExaminationGroupEntity entity) {
		setExaminationGroup(entity, true);
	}

	/**
	 * Set or update the examinationGroup in this entity with single ExaminationGroupEntity.
	 *
	 * @param entity the given ExaminationGroupEntity to be set or updated to examinationGroup
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setExaminationGroup(@NonNull ExaminationGroupEntity entity, boolean reverseAdd) {
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
	public void setServiceItem(@NonNull ServiceItemEntity entity) {
		setServiceItem(entity, true);
	}

	/**
	 * Set or update the serviceItem in this entity with single ServiceItemEntity.
	 *
	 * @param entity the given ServiceItemEntity to be set or updated to serviceItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setServiceItem(@NonNull ServiceItemEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
