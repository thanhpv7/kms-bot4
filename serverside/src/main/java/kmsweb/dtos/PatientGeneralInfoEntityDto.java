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
@Schema(description = "The Dto for PatientGeneralInfoEntity")
@EqualsAndHashCode(callSuper = false)
public class PatientGeneralInfoEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String patientID;

	private String title;

	private String givenName;

	private String lastName;

	private String placeOfBirth;

	private OffsetDateTime dateOfBirth;

	private String gender;

	private String address;

	private String patientPaymentType;

	private String importantNotes;

	private Boolean hasOutstandingPayment;

	private Set<FileEntity> patientPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<CashRefundEntity> cashRefunds = new HashSet<>();

	private Set<InformedConsentEntity> informedConsents = new HashSet<>();

	private Set<CashReceiptEntity> invoiceReceipts = new HashSet<>();

	private Set<PatientCaseHistoryEntity> patientCaseHistories = new HashSet<>();

	private Set<PatientConsentEntity> patientConsents = new HashSet<>();

	private PatientContactInfoEntity patientContactInformation;

	private PatientDetailAddressEntity patientDetailAddress;

	private PatientDetailEntity patientDetail;

	private PatientEmergencyContactDetailEntity patientEmergencyContactDetail;

	private PatientEmploymentDetailEntity patientEmploymentDetail;

	private Set<PatientSupportingDocumentEntity> patientFinalizeProfiles = new HashSet<>();

	private PatientPaymentBPJSEntity patientPaymentBPJS;

	private PatientPaymentInsuranceEntity patientPaymentTypeInsurance;

	private PatientPaymentOthersEntity patientPaymentTypeOthers;

	private PatientPersonalInfoEntity patientPersonalInformation;

	private PatientPaymentSelfPayingEntity patientSelfPaying;

	private Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();

	private Set<PatientVisitEntity> visits = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
