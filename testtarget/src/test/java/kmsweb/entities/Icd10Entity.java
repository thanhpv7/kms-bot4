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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Icd10Entity extends AbstractEntity {

	public Icd10Entity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DiagnosesAndProceduresOneOne = new EntityReference();
			DiagnosesAndProceduresOneOne.entityName = "DiagnosesAndProcedures";
			DiagnosesAndProceduresOneOne.oppositeName = "DiagnosesAndProcedures";
			DiagnosesAndProceduresOneOne.name = "MasterICD10";
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

	// % protected region % [Modify attribute annotation for Classification Disease here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Disease here] end
	private Boolean classificationDisease;

	// % protected region % [Modify attribute annotation for Classification Infectious here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Infectious here] end
	private Boolean classificationInfectious;

	// % protected region % [Modify attribute annotation for Classification Chronic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Chronic here] end
	private Boolean classificationChronic;

	// % protected region % [Modify attribute annotation for Classification Top Disease here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Top Disease here] end
	private Boolean classificationTopDisease;

	// % protected region % [Modify attribute annotation for Classification Restricted Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Restricted Case here] end
	private Boolean classificationRestrictedCase;

	// % protected region % [Modify attribute annotation for Classification Reportable Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Reportable Case here] end
	private Boolean classificationReportableCase;

	// % protected region % [Modify attribute annotation for Classification Acute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification Acute here] end
	private Boolean classificationAcute;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

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

	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

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
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update the diagnosesAndProcedures in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to diagnosesAndProcedures
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetMasterICD10(false);
		}

		this.diagnosesAndProcedures = entity;
		if (reverseAdd) {
			this.diagnosesAndProcedures.setMasterICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosesAndProcedures(boolean)} but default to true.
	 */
	public void unsetDiagnosesAndProcedures() {
		this.unsetDiagnosesAndProcedures(true);
	}

	/**
	 * Remove the DiagnosesAndProceduresEntity of diagnosesAndProcedures from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosesAndProcedures(boolean reverse) {
		if (reverse && this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetMasterICD10();
		}
		this.diagnosesAndProcedures = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
