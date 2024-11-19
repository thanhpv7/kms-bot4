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
public class NhisClaimEntity extends AbstractEntity {

	public NhisClaimEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for System Claim ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for System Claim ID here] end
	private String systemClaimID;

	// % protected region % [Modify attribute annotation for Ref Invoice No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Invoice No here] end
	private String refInvoiceNo;

	// % protected region % [Modify attribute annotation for Form No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Form No here] end
	private String formNo;

	// % protected region % [Modify attribute annotation for Claim ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim ID here] end
	private String claimID;

	// % protected region % [Modify attribute annotation for Claim Check Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim Check Code here] end
	private String claimCheckCode;

	// % protected region % [Modify attribute annotation for Batch Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Batch Number here] end
	private String batchNumber;

	// % protected region % [Modify attribute annotation for Surname here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surname here] end
	private String surname;

	// % protected region % [Modify attribute annotation for Other Names here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Names here] end
	private String otherNames;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Date Of Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Member No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Member No here] end
	private String memberNo;

	// % protected region % [Modify attribute annotation for Hospital Record No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Record No here] end
	private String hospitalRecordNo;

	// % protected region % [Modify attribute annotation for Card Serial Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Card Serial Number here] end
	private String cardSerialNumber;

	// % protected region % [Modify attribute annotation for Dependant here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dependant here] end
	private Boolean dependant;

	// % protected region % [Modify attribute annotation for Unbundled here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unbundled here] end
	private Boolean unbundled;

	// % protected region % [Modify attribute annotation for Includes Pharmacy here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Includes Pharmacy here] end
	private Boolean includesPharmacy;

	// % protected region % [Modify attribute annotation for Type Of Attendance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Type Of Attendance here] end
	private String typeOfAttendance;

	// % protected region % [Modify attribute annotation for First Visit Admission here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for First Visit Admission here] end
	private OffsetDateTime firstVisitAdmission;

	// % protected region % [Modify attribute annotation for Second Visit Discharge here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Second Visit Discharge here] end
	private OffsetDateTime secondVisitDischarge;

	// % protected region % [Modify attribute annotation for Third Visit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Third Visit here] end
	private OffsetDateTime thirdVisit;

	// % protected region % [Modify attribute annotation for Fourth Visit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fourth Visit here] end
	private OffsetDateTime fourthVisit;

	// % protected region % [Modify attribute annotation for Physician Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Physician Name here] end
	private String physicianName;

	// % protected region % [Modify attribute annotation for Physician Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Physician Code here] end
	private String physicianCode;

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



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
