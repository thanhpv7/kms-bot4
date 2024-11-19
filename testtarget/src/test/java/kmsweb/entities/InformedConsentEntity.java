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
public class InformedConsentEntity extends AbstractEntity {

	public InformedConsentEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AccompanyingStaffOneMany = new EntityReference();
			AccompanyingStaffOneMany.entityName = "Staff";
			AccompanyingStaffOneMany.oppositeName = "AccompanyingStaff";
			AccompanyingStaffOneMany.name = "AccompanyingConsents";
			AccompanyingStaffOneMany.optional = true;
			AccompanyingStaffOneMany.type = "One";
			AccompanyingStaffOneMany.oppositeType = "Many";

		References.add(AccompanyingStaffOneMany);

		var PatientGeneralInfoOneMany = new EntityReference();
			PatientGeneralInfoOneMany.entityName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.oppositeName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.name = "InformedConsents";
			PatientGeneralInfoOneMany.optional = true;
			PatientGeneralInfoOneMany.type = "One";
			PatientGeneralInfoOneMany.oppositeType = "Many";

		References.add(PatientGeneralInfoOneMany);

		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "InformedConsents";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var InformingStaffOneMany = new EntityReference();
			InformingStaffOneMany.entityName = "Staff";
			InformingStaffOneMany.oppositeName = "InformingStaff";
			InformingStaffOneMany.name = "InformingConsents";
			InformingStaffOneMany.optional = true;
			InformingStaffOneMany.type = "One";
			InformingStaffOneMany.oppositeType = "Many";

		References.add(InformingStaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Patient Family Guardian Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Family Guardian Name here] end
	private String patientFamilyGuardianName;

	// % protected region % [Modify attribute annotation for Patient Family Guardian Relationship here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Family Guardian Relationship here] end
	private String patientFamilyGuardianRelationship;

	// % protected region % [Modify attribute annotation for Procedure To Be Performed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Procedure To Be Performed here] end
	private String procedureToBePerformed;

	// % protected region % [Modify attribute annotation for Consequence Of Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consequence Of Procedure here] end
	private String consequenceOfProcedure;

	// % protected region % [Modify attribute annotation for Consent On Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consent On Procedure here] end
	private String consentOnProcedure;

	// % protected region % [Modify attribute annotation for Consent Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consent Date Time here] end
	private OffsetDateTime consentDateTime;

	// % protected region % [Modify attribute annotation for Informing Staff Signature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Informing Staff Signature here] end
	private String informingStaffSignature;

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

	// % protected region % [Modify attribute annotation for Witness Signature 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Witness Signature 1 here] end
	private String witnessSignature1;

	// % protected region % [Modify attribute annotation for Witness Name 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Witness Name 1 here] end
	private String witnessName1;

	// % protected region % [Modify attribute annotation for Witness Signature 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Witness Signature 2 here] end
	private String witnessSignature2;

	// % protected region % [Modify attribute annotation for Witness Name 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Witness Name 2 here] end
	private String witnessName2;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	private StaffEntity accompanyingStaff;

	private PatientGeneralInfoEntity patientGeneralInfo;

	private RegistrationEntity registration;

	private StaffEntity informingStaff;

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
	 * Similar to {@link this#setAccompanyingStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAccompanyingStaff(@NonNull StaffEntity entity) {
		setAccompanyingStaff(entity, true);
	}

	/**
	 * Set or update the accompanyingStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to accompanyingStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAccompanyingStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAccompanyingStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAccompanyingStaff here] end

		if (sameAsFormer(this.accompanyingStaff, entity)) {
			return;
		}

		if (this.accompanyingStaff != null) {
			this.accompanyingStaff.removeAccompanyingConsents(this, false);
		}
		this.accompanyingStaff = entity;
		if (reverseAdd) {
			this.accompanyingStaff.addAccompanyingConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAccompanyingStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAccompanyingStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAccompanyingStaff(boolean)} but default to true.
	 */
	public void unsetAccompanyingStaff() {
		this.unsetAccompanyingStaff(true);
	}

	/**
	 * Remove Accompanying Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAccompanyingStaff(boolean reverse) {
		if (reverse && this.accompanyingStaff != null) {
			this.accompanyingStaff.removeAccompanyingConsents(this, false);
		}
		this.accompanyingStaff = null;
	}
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
			this.patientGeneralInfo.removeInformedConsents(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addInformedConsents(this, false);
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
			this.patientGeneralInfo.removeInformedConsents(this, false);
		}
		this.patientGeneralInfo = null;
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
			this.registration.removeInformedConsents(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addInformedConsents(this, false);
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
			this.registration.removeInformedConsents(this, false);
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setInformingStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setInformingStaff(@NonNull StaffEntity entity) {
		setInformingStaff(entity, true);
	}

	/**
	 * Set or update the informingStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to informingStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInformingStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInformingStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInformingStaff here] end

		if (sameAsFormer(this.informingStaff, entity)) {
			return;
		}

		if (this.informingStaff != null) {
			this.informingStaff.removeInformingConsents(this, false);
		}
		this.informingStaff = entity;
		if (reverseAdd) {
			this.informingStaff.addInformingConsents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInformingStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInformingStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInformingStaff(boolean)} but default to true.
	 */
	public void unsetInformingStaff() {
		this.unsetInformingStaff(true);
	}

	/**
	 * Remove Informing Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInformingStaff(boolean reverse) {
		if (reverse && this.informingStaff != null) {
			this.informingStaff.removeInformingConsents(this, false);
		}
		this.informingStaff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
