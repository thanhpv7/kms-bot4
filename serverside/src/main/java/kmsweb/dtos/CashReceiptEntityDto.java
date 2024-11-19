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
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for CashReceiptEntity")
@EqualsAndHashCode(callSuper = false)
public class CashReceiptEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private ReceiptTypeEnum receiptType;

	private String receiptNumber;

	private OffsetDateTime paymentDate;

	private String description;

	private String paymentType;

	private Double receiveAmount;

	private Boolean isvoid;

	private String cashierLocation;

	private OffsetDateTime voidDateTime;

	private CashChangeTypeEnum cashChangeType;

	private Double changeAmount;

	private Double allocatedAmount;

	private Double roundingAmount;

	private Double availableAmount;

	private String bankName;

	private String cardType;

	private String cardNo;

	private String cardHolder;

	private String referenceNumber;

	private String hospitalBankAccount;

	private Double surchargeAmount;

	private Double outstandingAmount;

	private String receivedFrom;

	private String patientOrCustomerName;

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

	private MerchantEntity merchant;

	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	private StaffEntity cashierStaff;

	private PatientGeneralInfoEntity patient;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
