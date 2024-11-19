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

import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class HospitalBranchInformationEntity extends AbstractEntity {

	public HospitalBranchInformationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var HospitalGroupOneMany = new EntityReference();
			HospitalGroupOneMany.entityName = "HospitalGroupInformation";
			HospitalGroupOneMany.oppositeName = "HospitalGroup";
			HospitalGroupOneMany.name = "HospitalBranchInformations";
			HospitalGroupOneMany.optional = true;
			HospitalGroupOneMany.type = "One";
			HospitalGroupOneMany.oppositeType = "Many";

		References.add(HospitalGroupOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "HospitalBranchInformations";
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

	// % protected region % [Modify attribute annotation for Hospital Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Code here] end
	private String hospitalCode;

	// % protected region % [Modify attribute annotation for Hospital Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Name here] end
	private String hospitalName;

	// % protected region % [Modify attribute annotation for Hospital Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Type here] end
	private String hospitalType;

	// % protected region % [Modify attribute annotation for Hospital Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Class here] end
	private String hospitalClass;

	// % protected region % [Modify attribute annotation for Hospital Director Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Director Name here] end
	private String hospitalDirectorName;

	// % protected region % [Modify attribute annotation for Date of Registration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date of Registration here] end
	private OffsetDateTime dateOfRegistration;

	// % protected region % [Modify attribute annotation for Hospital Corporation Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Corporation Name here] end
	private String hospitalCorporationName;

	// % protected region % [Modify attribute annotation for Is BPJS Facility here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is BPJS Facility here] end
	private Boolean isBPJSFacility;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for City here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Postcode here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postcode here] end
	private String postcode;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Fax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fax here] end
	private String fax;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Website here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Contact Person here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person here] end
	private String contactPerson;

	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] end
	private String contactPersonPhoneNumber;

	// % protected region % [Modify attribute annotation for Contact Person Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person Email here] end
	private String contactPersonEmail;

	// % protected region % [Modify attribute annotation for Land Size here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Land Size here] end
	private String landSize;

	// % protected region % [Modify attribute annotation for Building Size here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Building Size here] end
	private String buildingSize;

	// % protected region % [Modify attribute annotation for Permit Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Permit Number here] end
	private String permitNumber;

	// % protected region % [Modify attribute annotation for Permit Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Permit Date here] end
	private OffsetDateTime permitDate;

	// % protected region % [Modify attribute annotation for Authorized By here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Authorized By here] end
	private String authorizedBy;

	// % protected region % [Modify attribute annotation for Permit Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Permit Type here] end
	private String permitType;

	// % protected region % [Modify attribute annotation for Valid Until here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Valid Until here] end
	private OffsetDateTime validUntil;

	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Name here] end
	private String hospitalBranchCorporationName;

	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Branch Corporation Status here] end
	private String hospitalBranchCorporationStatus;

	// % protected region % [Modify attribute annotation for Accreditation Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accreditation Type here] end
	private String accreditationType;

	// % protected region % [Modify attribute annotation for Accreditation Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accreditation Level here] end
	private String accreditationLevel;

	// % protected region % [Modify attribute annotation for Accreditation Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accreditation Date here] end
	private OffsetDateTime accreditationDate;

	// % protected region % [Modify attribute annotation for Bed Perinatology here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bed Perinatology here] end
	private String bedPerinatology;

	// % protected region % [Modify attribute annotation for Suite Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Suite Class here] end
	private String suiteClass;

	// % protected region % [Modify attribute annotation for VVIP Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for VVIP Class here] end
	private String vvipClass;

	// % protected region % [Modify attribute annotation for VIP A Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for VIP A Class here] end
	private String vipAClass;

	// % protected region % [Modify attribute annotation for VIP B Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for VIP B Class here] end
	private String vipBClass;

	// % protected region % [Modify attribute annotation for VIP C Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for VIP C Class here] end
	private String vipCClass;

	// % protected region % [Modify attribute annotation for Main Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Main Class here] end
	private String mainClass;

	// % protected region % [Modify attribute annotation for Class I here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Class I here] end
	private String classI;

	// % protected region % [Modify attribute annotation for II Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for II Class here] end
	private String iiClass;

	// % protected region % [Modify attribute annotation for III A Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for III A Class here] end
	private String iiiAClass;

	// % protected region % [Modify attribute annotation for III B Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for III B Class here] end
	private String iiiBClass;

	// % protected region % [Modify attribute annotation for Special Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Special Class here] end
	private String specialClass;

	// % protected region % [Modify attribute annotation for ICU here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICU here] end
	private String icu;

	// % protected region % [Modify attribute annotation for PICU here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for PICU here] end
	private String picu;

	// % protected region % [Modify attribute annotation for NICU here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for NICU here] end
	private String nicu;

	// % protected region % [Modify attribute annotation for HCU here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for HCU here] end
	private String hcu;

	// % protected region % [Modify attribute annotation for ICCU here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICCU here] end
	private String iccu;

	// % protected region % [Modify attribute annotation for Isolation Room here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Isolation Room here] end
	private String isolationRoom;

	// % protected region % [Modify attribute annotation for Emergency Room here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Emergency Room here] end
	private String emergencyRoom;

	// % protected region % [Modify attribute annotation for Maternity Room here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Maternity Room here] end
	private String maternityRoom;

	// % protected region % [Modify attribute annotation for Operating Room here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Operating Room here] end
	private String operatingRoom;

	// % protected region % [Modify attribute annotation for Doctor SpA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpA here] end
	private String doctorSpA;

	// % protected region % [Modify attribute annotation for Doctor SpOG here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpOG here] end
	private String doctorSpOG;

	// % protected region % [Modify attribute annotation for Doctor SpPD here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpPD here] end
	private String doctorSpPD;

	// % protected region % [Modify attribute annotation for Doctor SpB here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpB here] end
	private String doctorSpB;

	// % protected region % [Modify attribute annotation for Doctor SpRad here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpRad here] end
	private String doctorSpRad;

	// % protected region % [Modify attribute annotation for Doctor SpRm here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpRm here] end
	private String doctorSpRm;

	// % protected region % [Modify attribute annotation for Doctor SpAn here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpAn here] end
	private String doctorSpAn;

	// % protected region % [Modify attribute annotation for Doctor SpJp here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpJp here] end
	private String doctorSpJp;

	// % protected region % [Modify attribute annotation for Doctor SpM here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpM here] end
	private String doctorSpM;

	// % protected region % [Modify attribute annotation for Doctor SpTHT here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpTHT here] end
	private String doctorSpTHT;

	// % protected region % [Modify attribute annotation for Doctor SpKj here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpKj here] end
	private String doctorSpKj;

	// % protected region % [Modify attribute annotation for Doctor SpP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpP here] end
	private String doctorSpP;

	// % protected region % [Modify attribute annotation for Doctor SpPK here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpPK here] end
	private String doctorSpPK;

	// % protected region % [Modify attribute annotation for Doctor SpS here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor SpS here] end
	private String doctorSpS;

	// % protected region % [Modify attribute annotation for Sub Specialist Doctor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Specialist Doctor here] end
	private String subSpecialistDoctor;

	// % protected region % [Modify attribute annotation for Other Specialist Doctor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Specialist Doctor here] end
	private String otherSpecialistDoctor;

	// % protected region % [Modify attribute annotation for General Practice here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for General Practice here] end
	private String generalPractice;

	// % protected region % [Modify attribute annotation for Dentist here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dentist here] end
	private String dentist;

	// % protected region % [Modify attribute annotation for Specialist Dentist here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Specialist Dentist here] end
	private String specialistDentist;

	// % protected region % [Modify attribute annotation for Nurse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nurse here] end
	private String nurse;

	// % protected region % [Modify attribute annotation for Midwife here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Midwife here] end
	private String midwife;

	// % protected region % [Modify attribute annotation for Pharmacist here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pharmacist here] end
	private String pharmacist;

	// % protected region % [Modify attribute annotation for Other Medical Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Medical Staff here] end
	private String otherMedicalStaff;

	// % protected region % [Modify attribute annotation for Non Medical Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Non Medical Staff here] end
	private String nonMedicalStaff;

	// % protected region % [Modify attribute annotation for Timezone here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Timezone here] end
	private String timezone;

	// % protected region % [Modify attribute annotation for Health Facility Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Health Facility Level here] end
	private String healthFacilityLevel;

	// % protected region % [Modify attribute annotation for Satu Sehat Integration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Satu Sehat Integration here] end
	private Boolean satuSehatIntegration;

	// % protected region % [Modify attribute annotation for Tax Identification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Identification here] end
	private String taxIdentification;

	private Set<FileEntity> leftLogo = new HashSet<>();

	private Set<FileEntity> rightLogo = new HashSet<>();

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

	private HospitalGroupInformationEntity hospitalGroup;

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
	 * Similar to {@link this#setHospitalGroup(HospitalGroupInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalGroupInformationEntity to be set to this entity
	 */
	public void setHospitalGroup(@NonNull HospitalGroupInformationEntity entity) {
		setHospitalGroup(entity, true);
	}

	/**
	 * Set or update the hospitalGroup in this entity with single HospitalGroupInformationEntity.
	 *
	 * @param entity the given HospitalGroupInformationEntity to be set or updated to hospitalGroup
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setHospitalGroup(@NonNull HospitalGroupInformationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setHospitalGroup here] off begin
		// % protected region % [Add any additional logic here before the main logic for setHospitalGroup here] end

		if (sameAsFormer(this.hospitalGroup, entity)) {
			return;
		}

		if (this.hospitalGroup != null) {
			this.hospitalGroup.removeHospitalBranchInformations(this, false);
		}
		this.hospitalGroup = entity;
		if (reverseAdd) {
			this.hospitalGroup.addHospitalBranchInformations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setHospitalGroup incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setHospitalGroup incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetHospitalGroup(boolean)} but default to true.
	 */
	public void unsetHospitalGroup() {
		this.unsetHospitalGroup(true);
	}

	/**
	 * Remove Hospital Group in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetHospitalGroup(boolean reverse) {
		if (reverse && this.hospitalGroup != null) {
			this.hospitalGroup.removeHospitalBranchInformations(this, false);
		}
		this.hospitalGroup = null;
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
			this.staff.removeHospitalBranchInformations(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addHospitalBranchInformations(this, false);
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
			this.staff.removeHospitalBranchInformations(this, false);
		}
		this.staff = null;
	}

	public void addLeftLogo(FileEntity newFile) {
		leftLogo.add(newFile);
	}

	public void addAllLeftLogo(Collection<FileEntity> newFiles) {
		leftLogo.addAll(newFiles);
	}

	public void removeLeftLogo(FileEntity newFile) {
		leftLogo.remove(newFile);
	}

	public boolean containsLeftLogo(FileEntity newFile) {
		return leftLogo.contains(newFile);
	}

	public void clearAllLeftLogo() {
		leftLogo.clear();
	}

	public void addRightLogo(FileEntity newFile) {
		rightLogo.add(newFile);
	}

	public void addAllRightLogo(Collection<FileEntity> newFiles) {
		rightLogo.addAll(newFiles);
	}

	public void removeRightLogo(FileEntity newFile) {
		rightLogo.remove(newFile);
	}

	public boolean containsRightLogo(FileEntity newFile) {
		return rightLogo.contains(newFile);
	}

	public void clearAllRightLogo() {
		rightLogo.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
