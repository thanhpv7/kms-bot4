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
public class PatientConsentEntity extends AbstractEntity {

	public PatientConsentEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientGeneralInfoOneMany = new EntityReference();
			PatientGeneralInfoOneMany.entityName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.oppositeName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.name = "PatientConsents";
			PatientGeneralInfoOneMany.optional = true;
			PatientGeneralInfoOneMany.type = "One";
			PatientGeneralInfoOneMany.oppositeType = "Many";

		References.add(PatientGeneralInfoOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "PatientConsents";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Consent Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consent Date Time here] end
	private OffsetDateTime consentDateTime;

	// % protected region % [Modify attribute annotation for Consent On Payment Terms here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consent On Payment Terms here] end
	private String consentOnPaymentTerms;

	// % protected region % [Modify attribute annotation for Consent On Rights And Obligations here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consent On Rights And Obligations here] end
	private String consentOnRightsAndObligations;

	// % protected region % [Modify attribute annotation for Consent On Hospital Regulations here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consent On Hospital Regulations here] end
	private String consentOnHospitalRegulations;

	// % protected region % [Modify attribute annotation for Need Interpreter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Need Interpreter here] end
	private String needInterpreter;

	// % protected region % [Modify attribute annotation for Need Religious Counselor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Need Religious Counselor here] end
	private String needReligiousCounselor;

	// % protected region % [Modify attribute annotation for Dgs Results Released To Insurer here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dgs Results Released To Insurer here] end
	private String dgsResultsReleasedToInsurer;

	// % protected region % [Modify attribute annotation for Dgs Results Released To Students here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dgs Results Released To Students here] end
	private String dgsResultsReleasedToStudents;

	// % protected region % [Modify attribute annotation for Record Released To Family Member here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Record Released To Family Member here] end
	private String recordReleasedToFamilyMember;

	// % protected region % [Modify attribute annotation for Record Released To Certain Health Facilities here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Record Released To Certain Health Facilities here] end
	private String recordReleasedToCertainHealthFacilities;

	// % protected region % [Modify attribute annotation for Staff Signature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Staff Signature here] end
	private String staffSignature;

	// % protected region % [Modify attribute annotation for Consenting Party Signature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consenting Party Signature here] end
	private String consentingPartySignature;

	// % protected region % [Modify attribute annotation for Consenting Party Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consenting Party Type here] end
	private String consentingPartyType;

	// % protected region % [Modify attribute annotation for Consenting Party Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consenting Party Name here] end
	private String consentingPartyName;

	// % protected region % [Modify attribute annotation for Read And Sign Satusehat here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Read And Sign Satusehat here] end
	private Boolean readAndSignSatusehat;

	// % protected region % [Modify attribute annotation for Information Released To Satusehat here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Information Released To Satusehat here] end
	private String informationReleasedToSatusehat;

	// % protected region % [Modify attribute annotation for Emr Released To Satusehat here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Emr Released To Satusehat here] end
	private String emrReleasedToSatusehat;

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

	private PatientGeneralInfoEntity patientGeneralInfo;

	private StaffEntity staff;

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
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(@NonNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(@NonNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removePatientConsents(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addPatientConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove Patient General Info in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removePatientConsents(this, false);
		}
		this.patientGeneralInfo = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NonNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removePatientConsents(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addPatientConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removePatientConsents(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
