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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for HospitalBranchInformationEntity")
@EqualsAndHashCode(callSuper = false)
public class HospitalBranchInformationEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String hospitalCode;

	private String hospitalName;

	private String hospitalType;

	private String hospitalClass;

	private String hospitalDirectorName;

	private OffsetDateTime dateOfRegistration;

	private String hospitalCorporationName;

	private Boolean isBPJSFacility;

	private String address;

	private String city;

	private String postcode;

	private String phoneNumber;

	private String fax;

	private String email;

	private String website;

	private String contactPerson;

	private String contactPersonPhoneNumber;

	private String contactPersonEmail;

	private String landSize;

	private String buildingSize;

	private String permitNumber;

	private OffsetDateTime permitDate;

	private String authorizedBy;

	private String permitType;

	private OffsetDateTime validUntil;

	private String hospitalBranchCorporationName;

	private String hospitalBranchCorporationStatus;

	private String accreditationType;

	private String accreditationLevel;

	private OffsetDateTime accreditationDate;

	private String bedPerinatology;

	private String suiteClass;

	private String vvipClass;

	private String vipAClass;

	private String vipBClass;

	private String vipCClass;

	private String mainClass;

	private String classI;

	private String iiClass;

	private String iiiAClass;

	private String iiiBClass;

	private String specialClass;

	private String icu;

	private String picu;

	private String nicu;

	private String hcu;

	private String iccu;

	private String isolationRoom;

	private String emergencyRoom;

	private String maternityRoom;

	private String operatingRoom;

	private String doctorSpA;

	private String doctorSpOG;

	private String doctorSpPD;

	private String doctorSpB;

	private String doctorSpRad;

	private String doctorSpRm;

	private String doctorSpAn;

	private String doctorSpJp;

	private String doctorSpM;

	private String doctorSpTHT;

	private String doctorSpKj;

	private String doctorSpP;

	private String doctorSpPK;

	private String doctorSpS;

	private String subSpecialistDoctor;

	private String otherSpecialistDoctor;

	private String generalPractice;

	private String dentist;

	private String specialistDentist;

	private String nurse;

	private String midwife;

	private String pharmacist;

	private String otherMedicalStaff;

	private String nonMedicalStaff;

	private String timezone;

	private String healthFacilityLevel;

	private Boolean satuSehatIntegration;

	private String taxIdentification;

	private Set<FileEntity> leftLogo = new HashSet<>();

	private Set<FileEntity> rightLogo = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private HospitalGroupInformationEntity hospitalGroup;

	private StaffEntity staff;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
