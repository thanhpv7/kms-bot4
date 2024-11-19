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
public class PcareCompoundDrugEntity extends AbstractEntity {

	public PcareCompoundDrugEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PcareCompoundDrugItemsOneMany = new EntityReference();
			PcareCompoundDrugItemsOneMany.entityName = "PcareCompoundDrugItem";
			PcareCompoundDrugItemsOneMany.oppositeName = "PcareCompoundDrug";
			PcareCompoundDrugItemsOneMany.name = "PcareCompoundDrugItems";
			PcareCompoundDrugItemsOneMany.optional = true;
			PcareCompoundDrugItemsOneMany.type = "One";
			PcareCompoundDrugItemsOneMany.oppositeType = "Many";

		References.add(PcareCompoundDrugItemsOneMany);

		var PcareExaminationOneMany = new EntityReference();
			PcareExaminationOneMany.entityName = "PcareExamination";
			PcareExaminationOneMany.oppositeName = "PcareExamination";
			PcareExaminationOneMany.name = "PcareCompoundDrugs";
			PcareExaminationOneMany.optional = true;
			PcareExaminationOneMany.type = "One";
			PcareExaminationOneMany.oppositeType = "Many";

		References.add(PcareExaminationOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Compound Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Compound Name here] end
	private String compoundName;

	// % protected region % [Modify attribute annotation for Signa Days here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Signa Days here] end
	private Double signaDays;

	// % protected region % [Modify attribute annotation for Signa Times here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Signa Times here] end
	private Integer signaTimes;

	// % protected region % [Modify attribute annotation for Package Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Package Qty here] end
	private Double packageQty;

	// % protected region % [Modify attribute annotation for Day here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Day here] end
	private Double day;

	// % protected region % [Modify attribute annotation for Request Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Request Qty here] end
	private Integer requestQty;

	// % protected region % [Modify attribute annotation for Kd Obat SK here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kd Obat SK here] end
	private String kdObatSK;

	// % protected region % [Modify attribute annotation for Racikan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Racikan here] end
	private Boolean racikan;

	// % protected region % [Modify attribute annotation for Kd Racikan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kd Racikan here] end
	private String kdRacikan;

	// % protected region % [Modify attribute annotation for Nama Obat Non DPHO here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Obat Non DPHO here] end
	private String namaObatNonDPHO;

	// % protected region % [Modify attribute annotation for Drug Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Qty here] end
	private Double drugQty;

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

	private Set<PcareCompoundDrugItemEntity> pcareCompoundDrugItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PcareExaminationEntity pcareExamination;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addPcareCompoundDrugItems(PcareCompoundDrugItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity to be added to this entity
	 */
	public void addPcareCompoundDrugItems(@NonNull PcareCompoundDrugItemEntity entity) {
		addPcareCompoundDrugItems(entity, true);
	}

	/**
	 * Add a new PcareCompoundDrugItemEntity to pcareCompoundDrugItems in this entity.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareCompoundDrugItems(@NonNull PcareCompoundDrugItemEntity entity, boolean reverseAdd) {
		if (!this.pcareCompoundDrugItems.contains(entity)) {
			pcareCompoundDrugItems.add(entity);
			if (reverseAdd) {
				entity.setPcareCompoundDrug(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareCompoundDrugItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be added to this entity
	 */
	public void addPcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities) {
		addPcareCompoundDrugItems(entities, true);
	}

	/**
	 * Add a new collection of PcareCompoundDrugItemEntity to PCare Compound Drug Items in this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareCompoundDrugItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugItems(PcareCompoundDrugItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity to be set to this entity
	 */
	public void removePcareCompoundDrugItems(@NonNull PcareCompoundDrugItemEntity entity) {
		this.removePcareCompoundDrugItems(entity, true);
	}

	/**
	 * Remove the given PcareCompoundDrugItemEntity from this entity.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareCompoundDrugItems(@NonNull PcareCompoundDrugItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareCompoundDrug(false);
		}
		this.pcareCompoundDrugItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be removed to this entity
	 */
	public void removePcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities) {
		this.removePcareCompoundDrugItems(entities, true);
	}

	/**
	 * Remove the given collection of PcareCompoundDrugItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareCompoundDrugItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareCompoundDrugItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be set to this entity
	 */
	public void setPcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities) {
		setPcareCompoundDrugItems(entities, true);
	}

	/**
	 * Replace the current entities in PCare Compound Drug Items with the given ones.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities, boolean reverseAdd) {

		this.unsetPcareCompoundDrugItems();
		this.pcareCompoundDrugItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareCompoundDrugItems.forEach(pcareCompoundDrugItemsEntity -> pcareCompoundDrugItemsEntity.setPcareCompoundDrug(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareCompoundDrugItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareCompoundDrugItems() {
		this.unsetPcareCompoundDrugItems(true);
	}

	/**
	 * Remove all the entities in PCare Compound Drug Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareCompoundDrugItems(boolean doReverse) {
		if (doReverse) {
			this.pcareCompoundDrugItems.forEach(pcareCompoundDrugItemsEntity -> pcareCompoundDrugItemsEntity.unsetPcareCompoundDrug(false));
		}
		this.pcareCompoundDrugItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPcareExamination(PcareExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareExaminationEntity to be set to this entity
	 */
	public void setPcareExamination(@NonNull PcareExaminationEntity entity) {
		setPcareExamination(entity, true);
	}

	/**
	 * Set or update the pcareExamination in this entity with single PcareExaminationEntity.
	 *
	 * @param entity the given PcareExaminationEntity to be set or updated to pcareExamination
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareExamination(@NonNull PcareExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] end

		if (sameAsFormer(this.pcareExamination, entity)) {
			return;
		}

		if (this.pcareExamination != null) {
			this.pcareExamination.removePcareCompoundDrugs(this, false);
		}
		this.pcareExamination = entity;
		if (reverseAdd) {
			this.pcareExamination.addPcareCompoundDrugs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareExamination incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareExamination incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPcareExamination(boolean)} but default to true.
	 */
	public void unsetPcareExamination() {
		this.unsetPcareExamination(true);
	}

	/**
	 * Remove PCare Examination in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareExamination(boolean reverse) {
		if (reverse && this.pcareExamination != null) {
			this.pcareExamination.removePcareCompoundDrugs(this, false);
		}
		this.pcareExamination = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
