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
public class PatientCaseHistoryEntity extends AbstractEntity {

	public PatientCaseHistoryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientGeneralInformationOneMany = new EntityReference();
			PatientGeneralInformationOneMany.entityName = "PatientGeneralInfo";
			PatientGeneralInformationOneMany.oppositeName = "PatientGeneralInformation";
			PatientGeneralInformationOneMany.name = "PatientCaseHistories";
			PatientGeneralInformationOneMany.optional = true;
			PatientGeneralInformationOneMany.type = "One";
			PatientGeneralInformationOneMany.oppositeType = "Many";

		References.add(PatientGeneralInformationOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Allergy here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Allergy here] end
	private String allergy;

	// % protected region % [Modify attribute annotation for Disability Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Disability Notes here] end
	private String disabilityNotes;

	// % protected region % [Modify attribute annotation for History of Disease here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for History of Disease here] end
	private String historyOfDisease;

	// % protected region % [Modify attribute annotation for Case History Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Case History Date Time here] end
	private OffsetDateTime caseHistoryDateTime;

	// % protected region % [Modify attribute annotation for Patient Habits here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Habits here] end
	private String patientHabits;

	// % protected region % [Modify attribute annotation for Nutrition HIstory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nutrition HIstory here] end
	private String nutritionHIstory;

	// % protected region % [Modify attribute annotation for Family History here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Family History here] end
	private String familyHistory;

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

	private PatientGeneralInfoEntity patientGeneralInformation;

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
	 * Similar to {@link this#setPatientGeneralInformation(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInformation(@NonNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(@NonNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.removePatientCaseHistories(this, false);
		}
		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.addPatientCaseHistories(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove Patient General Information in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.removePatientCaseHistories(this, false);
		}
		this.patientGeneralInformation = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
