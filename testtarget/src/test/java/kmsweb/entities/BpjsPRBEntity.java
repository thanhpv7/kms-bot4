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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class BpjsPRBEntity extends AbstractEntity {

	public BpjsPRBEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsDiagnosePRBOneMany = new EntityReference();
			BpjsDiagnosePRBOneMany.entityName = "BpjsDiagnosePRB";
			BpjsDiagnosePRBOneMany.oppositeName = "BpjsDiagnosePRB";
			BpjsDiagnosePRBOneMany.name = "BpjsPRBs";
			BpjsDiagnosePRBOneMany.optional = true;
			BpjsDiagnosePRBOneMany.type = "One";
			BpjsDiagnosePRBOneMany.oppositeType = "Many";

		References.add(BpjsDiagnosePRBOneMany);

		var BpjsDoctorMappingOneMany = new EntityReference();
			BpjsDoctorMappingOneMany.entityName = "BpjsDoctorMapping";
			BpjsDoctorMappingOneMany.oppositeName = "BpjsDoctorMapping";
			BpjsDoctorMappingOneMany.name = "BpjsPRBs";
			BpjsDoctorMappingOneMany.optional = true;
			BpjsDoctorMappingOneMany.type = "One";
			BpjsDoctorMappingOneMany.oppositeType = "Many";

		References.add(BpjsDoctorMappingOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SRB No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SRB No here] end
	private String srbNo;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for PRB Program Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for PRB Program Code here] end
	private String prbProgramCode;

	// % protected region % [Modify attribute annotation for PRB Program Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for PRB Program Name here] end
	private String prbProgramName;

	// % protected region % [Modify attribute annotation for Doctor Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor Code here] end
	private String doctorCode;

	// % protected region % [Modify attribute annotation for Doctor Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor Name here] end
	private String doctorName;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Recommendation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Recommendation here] end
	private String recommendation;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsDiagnosePRBEntity bpjsDiagnosePRB;

	private BpjsDoctorMappingEntity bpjsDoctorMapping;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsDiagnosePRB(BpjsDiagnosePRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set to this entity
	 */
	public void setBpjsDiagnosePRB(@NonNull BpjsDiagnosePRBEntity entity) {
		setBpjsDiagnosePRB(entity, true);
	}

	/**
	 * Set or update the bpjsDiagnosePRB in this entity with single BpjsDiagnosePRBEntity.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set or updated to bpjsDiagnosePRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDiagnosePRB(@NonNull BpjsDiagnosePRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnosePRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnosePRB here] end

		if (sameAsFormer(this.bpjsDiagnosePRB, entity)) {
			return;
		}

		if (this.bpjsDiagnosePRB != null) {
			this.bpjsDiagnosePRB.removeBpjsPRBs(this, false);
		}
		this.bpjsDiagnosePRB = entity;
		if (reverseAdd) {
			this.bpjsDiagnosePRB.addBpjsPRBs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnosePRB incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnosePRB incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDiagnosePRB(boolean)} but default to true.
	 */
	public void unsetBpjsDiagnosePRB() {
		this.unsetBpjsDiagnosePRB(true);
	}

	/**
	 * Remove BPJS Diagnose PRB in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDiagnosePRB(boolean reverse) {
		if (reverse && this.bpjsDiagnosePRB != null) {
			this.bpjsDiagnosePRB.removeBpjsPRBs(this, false);
		}
		this.bpjsDiagnosePRB = null;
	}
	/**
	 * Similar to {@link this#setBpjsDoctorMapping(BpjsDoctorMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set to this entity
	 */
	public void setBpjsDoctorMapping(@NonNull BpjsDoctorMappingEntity entity) {
		setBpjsDoctorMapping(entity, true);
	}

	/**
	 * Set or update the bpjsDoctorMapping in this entity with single BpjsDoctorMappingEntity.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set or updated to bpjsDoctorMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDoctorMapping(@NonNull BpjsDoctorMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] end

		if (sameAsFormer(this.bpjsDoctorMapping, entity)) {
			return;
		}

		if (this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsPRBs(this, false);
		}
		this.bpjsDoctorMapping = entity;
		if (reverseAdd) {
			this.bpjsDoctorMapping.addBpjsPRBs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDoctorMapping(boolean)} but default to true.
	 */
	public void unsetBpjsDoctorMapping() {
		this.unsetBpjsDoctorMapping(true);
	}

	/**
	 * Remove BPJS Doctor Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDoctorMapping(boolean reverse) {
		if (reverse && this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsPRBs(this, false);
		}
		this.bpjsDoctorMapping = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
