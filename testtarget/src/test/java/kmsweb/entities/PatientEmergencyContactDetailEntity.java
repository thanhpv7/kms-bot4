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
public class PatientEmergencyContactDetailEntity extends AbstractEntity {

	public PatientEmergencyContactDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientGeneralInformationOneOne = new EntityReference();
			PatientGeneralInformationOneOne.entityName = "PatientGeneralInfo";
			PatientGeneralInformationOneOne.oppositeName = "PatientGeneralInformation";
			PatientGeneralInformationOneOne.name = "PatientEmergencyContactDetail";
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

	// % protected region % [Modify attribute annotation for Title here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Title here] end
	private String title;

	// % protected region % [Modify attribute annotation for Given Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Given Name here] end
	private String givenName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Relationship here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Relationship here] end
	private String relationship;

	// % protected region % [Modify attribute annotation for Date Of Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Home Phone No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Home Phone No here] end
	private String homePhoneNo;

	// % protected region % [Modify attribute annotation for Mobile Phone No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Mobile Phone No here] end
	private String mobilePhoneNo;

	// % protected region % [Modify attribute annotation for Office Phone No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Office Phone No here] end
	private String officePhoneNo;

	// % protected region % [Modify attribute annotation for Extension No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extension No here] end
	private String extensionNo;

	// % protected region % [Modify attribute annotation for Email Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email Address here] end
	private String emailAddress;

	// % protected region % [Modify attribute annotation for ID Card here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ID Card here] end
	private String idCard;

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
			this.patientGeneralInformation.unsetPatientEmergencyContactDetail(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientEmergencyContactDetail(this, false);
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
			this.patientGeneralInformation.unsetPatientEmergencyContactDetail();
		}
		this.patientGeneralInformation = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
