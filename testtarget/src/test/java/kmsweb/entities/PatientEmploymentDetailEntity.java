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
public class PatientEmploymentDetailEntity extends AbstractEntity {

	public PatientEmploymentDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientGeneralInfoOneOne = new EntityReference();
			PatientGeneralInfoOneOne.entityName = "PatientGeneralInfo";
			PatientGeneralInfoOneOne.oppositeName = "PatientGeneralInfo";
			PatientGeneralInfoOneOne.name = "PatientEmploymentDetail";
			PatientGeneralInfoOneOne.optional = true;
			PatientGeneralInfoOneOne.type = "One";
			PatientGeneralInfoOneOne.oppositeType = "One";

		References.add(PatientGeneralInfoOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Employee ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Employee ID here] end
	private String employeeID;

	// % protected region % [Modify attribute annotation for Universal ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Universal ID here] end
	private String universalID;

	// % protected region % [Modify attribute annotation for Employee Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Employee Type here] end
	private String employeeType;

	// % protected region % [Modify attribute annotation for Onsite Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Onsite Status here] end
	private String onsiteStatus;

	// % protected region % [Modify attribute annotation for Occupational Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Occupational Type here] end
	private String occupationalType;

	// % protected region % [Modify attribute annotation for Dependant ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dependant ID here] end
	private String dependantID;

	// % protected region % [Modify attribute annotation for Dependant Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dependant Type here] end
	private String dependantType;

	// % protected region % [Modify attribute annotation for Sponsor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sponsor here] end
	private String sponsor;

	// % protected region % [Modify attribute annotation for Relationship here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Relationship here] end
	private String relationship;

	// % protected region % [Modify attribute annotation for Company here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Company here] end
	private String company;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Department here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Department here] end
	private String department;

	// % protected region % [Modify attribute annotation for Position here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Position here] end
	private String position;

	// % protected region % [Modify attribute annotation for Cost Center here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cost Center here] end
	private String costCenter;

	// % protected region % [Modify attribute annotation for District here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for District here] end
	private String district;

	// % protected region % [Modify attribute annotation for Designated Work Place here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Designated Work Place here] end
	private String designatedWorkPlace;

	// % protected region % [Modify attribute annotation for Bureau No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bureau No here] end
	private String bureauNo;

	// % protected region % [Modify attribute annotation for Industry No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Industry No here] end
	private String industryNo;

	// % protected region % [Modify attribute annotation for Employment Start Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Employment Start Date here] end
	private OffsetDateTime employmentStartDate;

	// % protected region % [Modify attribute annotation for Passport No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Passport No here] end
	private String passportNo;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Passport Country here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Passport Country here] end
	private String passportCountry;

	// % protected region % [Modify attribute annotation for Postal Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postal Address here] end
	private String postalAddress;

	// % protected region % [Modify attribute annotation for Forwarding Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Forwarding Address here] end
	private String forwardingAddress;

	// % protected region % [Modify attribute annotation for Legal DIsability here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Legal DIsability here] end
	private String legalDIsability;

	// % protected region % [Modify attribute annotation for Legal Disability Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Legal Disability Notes here] end
	private String legalDisabilityNotes;

	// % protected region % [Modify attribute annotation for Worker Insurance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Worker Insurance here] end
	private String workerInsurance;

	// % protected region % [Modify attribute annotation for Worker Insurance No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Worker Insurance No here] end
	private String workerInsuranceNo;

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

	private PatientGeneralInfoEntity patientGeneralInfo;

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
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.unsetPatientEmploymentDetail(false);
		}

		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.setPatientEmploymentDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInfo from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.unsetPatientEmploymentDetail();
		}
		this.patientGeneralInfo = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
