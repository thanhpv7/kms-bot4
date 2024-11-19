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
public class BpjsPcareRegistrationsEntity extends AbstractEntity {

	public BpjsPcareRegistrationsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PatientVisitOneOne = new EntityReference();
			PatientVisitOneOne.entityName = "PatientVisit";
			PatientVisitOneOne.oppositeName = "PatientVisit";
			PatientVisitOneOne.name = "BpjsPcareRegistrations";
			PatientVisitOneOne.optional = true;
			PatientVisitOneOne.type = "One";
			PatientVisitOneOne.oppositeType = "One";

		References.add(PatientVisitOneOne);

		var RegistrationOneOne = new EntityReference();
			RegistrationOneOne.entityName = "Registration";
			RegistrationOneOne.oppositeName = "Registration";
			RegistrationOneOne.name = "BpjsPcareRegistrations";
			RegistrationOneOne.optional = true;
			RegistrationOneOne.type = "One";
			RegistrationOneOne.oppositeType = "One";

		References.add(RegistrationOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for kdProviderPeserta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdProviderPeserta here] end
	private String kdproviderpeserta;

	// % protected region % [Modify attribute annotation for tglDaftar here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglDaftar here] end
	private String tgldaftar;

	// % protected region % [Modify attribute annotation for noKartu here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noKartu here] end
	private String nokartu;

	// % protected region % [Modify attribute annotation for kdPoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdPoli here] end
	private String kdpoli;

	// % protected region % [Modify attribute annotation for keluhan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for keluhan here] end
	private String keluhan;

	// % protected region % [Modify attribute annotation for kunjSakit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kunjSakit here] end
	private String kunjsakit;

	// % protected region % [Modify attribute annotation for sistole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for sistole here] end
	private String sistole;

	// % protected region % [Modify attribute annotation for diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for diastole here] end
	private String diastole;

	// % protected region % [Modify attribute annotation for beratBadan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for beratBadan here] end
	private String beratbadan;

	// % protected region % [Modify attribute annotation for tinggiBadan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tinggiBadan here] end
	private String tinggibadan;

	// % protected region % [Modify attribute annotation for respRate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for respRate here] end
	private String resprate;

	// % protected region % [Modify attribute annotation for lingkarPerut here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for lingkarPerut here] end
	private String lingkarperut;

	// % protected region % [Modify attribute annotation for rujukInternal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for rujukInternal here] end
	private String rujukinternal;

	// % protected region % [Modify attribute annotation for heartRate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for heartRate here] end
	private String heartrate;

	// % protected region % [Modify attribute annotation for rujukBalik here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for rujukBalik here] end
	private String rujukbalik;

	// % protected region % [Modify attribute annotation for kdTkp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdTkp here] end
	private String kdtkp;

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

	private PatientVisitEntity patientVisit;

	private RegistrationEntity registration;

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
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.unsetBpjsPcareRegistrations(false);
		}

		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.setBpjsPcareRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove the PatientVisitEntity of patientVisit from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.unsetBpjsPcareRegistrations();
		}
		this.patientVisit = null;
	}
	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetBpjsPcareRegistrations(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setBpjsPcareRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetBpjsPcareRegistrations();
		}
		this.registration = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
