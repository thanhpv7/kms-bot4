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
public class FacilityHistoryEntity extends AbstractEntity {

	public FacilityHistoryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Change Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Change Date here] end
	private OffsetDateTime changeDate;

	// % protected region % [Modify attribute annotation for Facility No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility No here] end
	private String facilityNo;

	// % protected region % [Modify attribute annotation for Current Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Current Qty here] end
	private Integer currentQty;

	// % protected region % [Modify attribute annotation for Changed Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Changed Qty here] end
	private Integer changedQty;

	// % protected region % [Modify attribute annotation for Facility Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility Status here] end
	private String facilityStatus;

	// % protected region % [Modify attribute annotation for Facility Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility Class here] end
	private String facilityClass;

	// % protected region % [Modify attribute annotation for Facility Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility Type here] end
	private String facilityType;

	// % protected region % [Modify attribute annotation for Facility Service here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility Service here] end
	private String facilityService;

	// % protected region % [Modify attribute annotation for Bed Facility Id here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bed Facility Id here] end
	private String bedFacilityId;

	// % protected region % [Modify attribute annotation for Registration Id here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Registration Id here] end
	private String registrationId;

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
