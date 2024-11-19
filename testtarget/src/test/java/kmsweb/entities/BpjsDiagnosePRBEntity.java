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
public class BpjsDiagnosePRBEntity extends AbstractEntity {

	public BpjsDiagnosePRBEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsPRBsOneMany = new EntityReference();
			BpjsPRBsOneMany.entityName = "BpjsPRB";
			BpjsPRBsOneMany.oppositeName = "BpjsDiagnosePRB";
			BpjsPRBsOneMany.name = "BpjsPRBs";
			BpjsPRBsOneMany.optional = true;
			BpjsPRBsOneMany.type = "One";
			BpjsPRBsOneMany.oppositeType = "Many";

		References.add(BpjsPRBsOneMany);

		var DiagnosesAndProceduresOneOne = new EntityReference();
			DiagnosesAndProceduresOneOne.entityName = "DiagnosesAndProcedures";
			DiagnosesAndProceduresOneOne.oppositeName = "BpjsDiagnosePRB";
			DiagnosesAndProceduresOneOne.name = "DiagnosesAndProcedures";
			DiagnosesAndProceduresOneOne.optional = true;
			DiagnosesAndProceduresOneOne.type = "One";
			DiagnosesAndProceduresOneOne.oppositeType = "One";

		References.add(DiagnosesAndProceduresOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Ref Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Code here] end
	private String refCode;

	// % protected region % [Modify attribute annotation for Ref Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Name here] end
	private String refName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

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

	private Set<BpjsPRBEntity> bpjsPRBs = new HashSet<>();

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
	 * Similar to {@link this#addBpjsPRBs(BpjsPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBEntity to be added to this entity
	 */
	public void addBpjsPRBs(@NonNull BpjsPRBEntity entity) {
		addBpjsPRBs(entity, true);
	}

	/**
	 * Add a new BpjsPRBEntity to bpjsPRBs in this entity.
	 *
	 * @param entity the given BpjsPRBEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPRBs(@NonNull BpjsPRBEntity entity, boolean reverseAdd) {
		if (!this.bpjsPRBs.contains(entity)) {
			bpjsPRBs.add(entity);
			if (reverseAdd) {
				entity.setBpjsDiagnosePRB(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be added to this entity
	 */
	public void addBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities) {
		addBpjsPRBs(entities, true);
	}

	/**
	 * Add a new collection of BpjsPRBEntity to BPJS PRBs in this entity.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPRBs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPRBs(BpjsPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBEntity to be set to this entity
	 */
	public void removeBpjsPRBs(@NonNull BpjsPRBEntity entity) {
		this.removeBpjsPRBs(entity, true);
	}

	/**
	 * Remove the given BpjsPRBEntity from this entity.
	 *
	 * @param entity the given BpjsPRBEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPRBs(@NonNull BpjsPRBEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDiagnosePRB(false);
		}
		this.bpjsPRBs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be removed to this entity
	 */
	public void removeBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities) {
		this.removeBpjsPRBs(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPRBEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPRBs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be set to this entity
	 */
	public void setBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities) {
		setBpjsPRBs(entities, true);
	}

	/**
	 * Replace the current entities in BPJS PRBs with the given ones.
	 *
	 * @param entities the given collection of BpjsPRBEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPRBs();
		this.bpjsPRBs = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.setBpjsDiagnosePRB(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPRBs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPRBs() {
		this.unsetBpjsPRBs(true);
	}

	/**
	 * Remove all the entities in BPJS PRBs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPRBs(boolean doReverse) {
		if (doReverse) {
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.unsetBpjsDiagnosePRB(false));
		}
		this.bpjsPRBs.clear();
	}

	/**
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(@NonNull DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update diagnosesAndProcedures with the given DiagnosesAndProceduresEntity.
	 *
	 * @param entity the BpjsDiagnosePRBEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnosePRB();
		}

		this.diagnosesAndProcedures = entity;

		if (reverseAdd) {
			this.diagnosesAndProcedures.setBpjsDiagnosePRB(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosesAndProcedures(boolean)} but default to true.
	 */
	public void unsetDiagnosesAndProcedures() {
		this.unsetDiagnosesAndProcedures(true);
	}

	/**
	 * Remove the DiagnosesAndProceduresEntity in Diagnoses and Procedures from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosesAndProcedures(boolean reverse) {
		if (reverse && this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnosePRB(false);
		}
		this.diagnosesAndProcedures = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
