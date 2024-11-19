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
@Schema(description = "The Dto for InvoiceEntity")
@EqualsAndHashCode(callSuper = false)
public class InvoiceEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String invoiceNumber;

	private Integer revisionNumber;

	private String invoiceStatus;

	private InvoiceTypeEnum invoiceType;

	private OffsetDateTime invoiceDate;

	private OffsetDateTime cancelDate;

	private String billingLocation;

	private String notes;

	private String patientPaymentType;

	private OffsetDateTime verificationDate;

	private Boolean displayDoctorOnPrint;

	private Boolean displayICD10OnPrint;

	private Boolean displayICD9CMOnPrint;

	private String doctorCode;

	private String treatmentClass;

	private OffsetDateTime admissionDate;

	private OffsetDateTime dischargedDate;

	private String claimNo;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();

	private InvoicePaymentOtherEntity invoicePaymentOther;

	private InvoicePaymentSelfPayingEntity invoicePaymentSelfPaying;

	private InvoiceSummaryEntity invoiceSummary;

	private PrescriptionHeaderEntity prescriptionHeader;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicationHeaderEntity medicationHeader;

	private DiagnosesAndProceduresEntity icd10;

	private DiagnosesAndProceduresEntity icd9CM;

	private BedFacilityEntity bedFacility;

	private PatientVisitEntity patientVisit;

	private TariffSchemaEntity tariffSchema;

	private StaffEntity verifiedBy;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
