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
import lombok.*;
import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for BedFacilityEntity")
@EqualsAndHashCode(callSuper = false)
public class BedFacilityEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String bedNumber;

	private String bedName;

	private String treatmentClass;

	private String availability;

	private String notes;

	private String coaCOGS;

	private String coaSell;

	private String coaInventory;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BedReserveEntity> bedReserves = new HashSet<>();

	private Set<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecords = new HashSet<>();

	private Set<InvoiceEntity> invoices = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private IntraoperativeRecordsEntity intraoperativeRecords;

	private PostOperativeDetailsEntity postOperativeDetails;

	private PreoperativeRecordsEntity preoperativeRecords;

	private RoomFacilityEntity roomFacility;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
