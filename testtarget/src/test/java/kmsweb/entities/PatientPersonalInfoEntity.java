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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PatientPersonalInfoEntity extends AbstractEntity {

	public PatientPersonalInfoEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientGeneralInformationOneOne = new EntityReference();
			PatientGeneralInformationOneOne.entityName = "PatientGeneralInfo";
			PatientGeneralInformationOneOne.oppositeName = "PatientGeneralInformation";
			PatientGeneralInformationOneOne.name = "PatientPersonalInformation";
			PatientGeneralInformationOneOne.optional = true;
			PatientGeneralInformationOneOne.type = "One";
			PatientGeneralInformationOneOne.oppositeType = "One";

		References.add(PatientGeneralInformationOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Religion here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Religion here] end
	private String religion;

	// % protected region % [Modify attribute annotation for Nationality here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nationality here] end
	private String nationality;

	// % protected region % [Modify attribute annotation for Ethnicity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ethnicity here] end
	private String ethnicity;

	// % protected region % [Modify attribute annotation for Blood Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Blood Type here] end
	private BloodTypeEnum bloodType;

	// % protected region % [Modify attribute annotation for Rhesus here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rhesus here] end
	private RhesusEnum rhesus;

	// % protected region % [Modify attribute annotation for ID Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ID Number here] end
	private String idNumber;

	// % protected region % [Modify attribute annotation for Occupation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Occupation here] end
	private String occupation;

	// % protected region % [Modify attribute annotation for External Patient here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Patient here] end
	private Boolean externalPatient;

	// % protected region % [Modify attribute annotation for Is Dead here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Dead here] end
	private Boolean isDead;

	// % protected region % [Modify attribute annotation for External Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Notes here] end
	private String externalNotes;

	// % protected region % [Modify attribute annotation for Other ID Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other ID Number here] end
	private String otherIDNumber;

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

	private PatientGeneralInfoEntity patientGeneralInformation;

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
	 * Similar to {@link this#setPatientGeneralInformation(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientPersonalInformation(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientPersonalInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInformation from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientPersonalInformation();
		}
		this.patientGeneralInformation = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
