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
public class BpjsAccidentMasterEntity extends AbstractEntity {

	public BpjsAccidentMasterEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientPaymentBPJSOneMany = new EntityReference();
			PatientPaymentBPJSOneMany.entityName = "PatientPaymentBPJS";
			PatientPaymentBPJSOneMany.oppositeName = "PatientPaymentBPJS";
			PatientPaymentBPJSOneMany.name = "BpjsAccidentMasters";
			PatientPaymentBPJSOneMany.optional = true;
			PatientPaymentBPJSOneMany.type = "One";
			PatientPaymentBPJSOneMany.oppositeType = "Many";

		References.add(PatientPaymentBPJSOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for noSEP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noSEP here] end
	private String nosep;

	// % protected region % [Modify attribute annotation for tglKejadian here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglKejadian here] end
	private String tglkejadian;

	// % protected region % [Modify attribute annotation for ppkPelSEP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ppkPelSEP here] end
	private String ppkpelsep;

	// % protected region % [Modify attribute annotation for kdProp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProp here] end
	private String kdprop;

	// % protected region % [Modify attribute annotation for kdKab here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdKab here] end
	private String kdkab;

	// % protected region % [Modify attribute annotation for kdKec here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdKec here] end
	private String kdkec;

	// % protected region % [Modify attribute annotation for ketKejadian here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ketKejadian here] end
	private String ketkejadian;

	// % protected region % [Modify attribute annotation for noSEPSuplesi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noSEPSuplesi here] end
	private String nosepsuplesi;

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

	private PatientPaymentBPJSEntity patientPaymentBPJS;

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
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update the patientPaymentBPJS in this entity with single PatientPaymentBPJSEntity.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set or updated to patientPaymentBPJS
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsAccidentMasters(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsAccidentMasters(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove Patient Payment BPJS in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsAccidentMasters(this, false);
		}
		this.patientPaymentBPJS = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
