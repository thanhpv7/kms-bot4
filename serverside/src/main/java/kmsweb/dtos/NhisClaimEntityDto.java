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
import lombok.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for NhisClaimEntity")
@EqualsAndHashCode(callSuper = false)
public class NhisClaimEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String systemClaimID;

	private String refInvoiceNo;

	private String formNo;

	private String claimID;

	private String claimCheckCode;

	private String batchNumber;

	private String surname;

	private String otherNames;

	private String gender;

	private OffsetDateTime dateOfBirth;

	private String memberNo;

	private String hospitalRecordNo;

	private String cardSerialNumber;

	private Boolean dependant;

	private Boolean unbundled;

	private Boolean includesPharmacy;

	private String typeOfAttendance;

	private OffsetDateTime firstVisitAdmission;

	private OffsetDateTime secondVisitDischarge;

	private OffsetDateTime thirdVisit;

	private OffsetDateTime fourthVisit;

	private String physicianName;

	private String physicianCode;

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

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
