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
import kmsweb.entities.enums.*;
import kmsweb.entities.*;
import lombok.*;
import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for InvoiceItemEntity")
@EqualsAndHashCode(callSuper = false)
public class InvoiceItemEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private OffsetDateTime transactionDate;

	private String tariffCode;

	private TariffTypeEnum tariffType;

	private String name;

	private String medicalStaffCode;

	private Double price;

	private Double hospitalPrice;

	private Double totalOtherComponentPrice;

	private Double quantity;

	private String unit;

	private Double discount;

	private Boolean tax;

	private Double itemTotal;

	private String treatmentClass;

	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoiceEntity invoice;

	private MedicalFeeEntity medicalFee;

	private MedicationHeaderEntity medicationHeader;

	private PrescriptionHeaderEntity prescription;

	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	private RegistrationEntity serviceNumber;

	private TariffSchemaEntity tariffSchema;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
