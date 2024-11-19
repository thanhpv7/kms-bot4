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
public class DiagnosticExaminationResultsEntity extends AbstractEntity {

	public DiagnosticExaminationResultsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ExaminationItemOneMany = new EntityReference();
			ExaminationItemOneMany.entityName = "ExaminationItem";
			ExaminationItemOneMany.oppositeName = "ExaminationItem";
			ExaminationItemOneMany.name = "DiagnosticExaminationResults";
			ExaminationItemOneMany.optional = true;
			ExaminationItemOneMany.type = "One";
			ExaminationItemOneMany.oppositeType = "Many";

		References.add(ExaminationItemOneMany);

		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "DiagnosticExaminationResults";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Result here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Result here] end
	private String result;

	// % protected region % [Modify attribute annotation for Outside Range here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Outside Range here] end
	private Boolean outsideRange;

	// % protected region % [Modify attribute annotation for Low here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Low here] end
	private Double low;

	// % protected region % [Modify attribute annotation for High here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for High here] end
	private Double high;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Sample No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample No here] end
	private String sampleNo;

	// % protected region % [Modify attribute annotation for Sample Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Type here] end
	private String sampleType;

	// % protected region % [Modify attribute annotation for repeated here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for repeated here] end
	private Boolean repeated;

	// % protected region % [Modify attribute annotation for status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for status here] end
	private String status;

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

	private ExaminationItemEntity examinationItem;

	private RegistrationEntity registration;

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
	 * Similar to {@link this#setExaminationItem(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to this entity
	 */
	public void setExaminationItem(@NonNull ExaminationItemEntity entity) {
		setExaminationItem(entity, true);
	}

	/**
	 * Set or update the examinationItem in this entity with single ExaminationItemEntity.
	 *
	 * @param entity the given ExaminationItemEntity to be set or updated to examinationItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setExaminationItem(@NonNull ExaminationItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] end

		if (sameAsFormer(this.examinationItem, entity)) {
			return;
		}

		if (this.examinationItem != null) {
			this.examinationItem.removeDiagnosticExaminationResults(this, false);
		}
		this.examinationItem = entity;
		if (reverseAdd) {
			this.examinationItem.addDiagnosticExaminationResults(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetExaminationItem(boolean)} but default to true.
	 */
	public void unsetExaminationItem() {
		this.unsetExaminationItem(true);
	}

	/**
	 * Remove Examination Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetExaminationItem(boolean reverse) {
		if (reverse && this.examinationItem != null) {
			this.examinationItem.removeDiagnosticExaminationResults(this, false);
		}
		this.examinationItem = null;
	}
	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeDiagnosticExaminationResults(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addDiagnosticExaminationResults(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeDiagnosticExaminationResults(this, false);
		}
		this.registration = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
