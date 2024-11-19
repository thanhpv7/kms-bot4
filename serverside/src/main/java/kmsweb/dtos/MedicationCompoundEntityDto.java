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
@Schema(description = "The Dto for MedicationCompoundEntity")
@EqualsAndHashCode(callSuper = false)
public class MedicationCompoundEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String compoundCode;

	private String compoundName;

	private Double requestedQty;

	private Double outstandingQty;

	private Double returnedQty;

	private Double issuedQty;

	private Double administeredQty;

	private Double takenHomeQty;

	private Double dosageFrequency;

	private Double dosageQty;

	private Double dose;

	private String frequency;

	private String consumptionMethod;

	private String instruction;

	private String notes;

	private Double totalPrice;

	private Boolean isDtd;

	private Integer totalAdministeredQuantity;

	private Double totalIssuedQuantity;

	private Integer totalTakenHomeQuantity;

	private Integer totalReturnedQuantity;

	private String externalCompoundName;

	private String approvalStatus;

	private Double inventoryRoundingValue;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHistories = new HashSet<>();

	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicationHeaderEntity medicationHeader;

	private UnitOfMeasurementEntity unitOfMeasurement;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
