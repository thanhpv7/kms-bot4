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
public class BpjsINACBGClaimEntity extends AbstractEntity {

	public BpjsINACBGClaimEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Claim No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim No here] end
	private String claimNo;

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Invoice Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Number here] end
	private String invoiceNumber;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Admission Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Admission Date here] end
	private OffsetDateTime admissionDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for LOS here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for LOS here] end
	private String los;

	// % protected region % [Modify attribute annotation for Dismissal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal here] end
	private String dismissal;

	// % protected region % [Modify attribute annotation for Responsible Doctor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Responsible Doctor here] end
	private String responsibleDoctor;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for ADL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ADL here] end
	private Integer adl;

	// % protected region % [Modify attribute annotation for Claim Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim Status here] end
	private String claimStatus;

	// % protected region % [Modify attribute annotation for SEP Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP Status here] end
	private String sepStatus;

	// % protected region % [Modify attribute annotation for Hospital Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Tariff here] end
	private Double hospitalTariff;

	// % protected region % [Modify attribute annotation for Referral Letter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral Letter here] end
	private String referralLetter;

	// % protected region % [Modify attribute annotation for Third Sel Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Third Sel Level here] end
	private String thirdSelLevel;

	// % protected region % [Modify attribute annotation for Staff Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Staff Name here] end
	private String staffName;

	// % protected region % [Modify attribute annotation for Date Grouping here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Grouping here] end
	private OffsetDateTime dateGrouping;

	// % protected region % [Modify attribute annotation for INACBG Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for INACBG Tariff here] end
	private String inacbgTariff;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for CBG Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for CBG Type here] end
	private String cbgType;

	// % protected region % [Modify attribute annotation for Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff here] end
	private Double tariff;

	// % protected region % [Modify attribute annotation for Sub Acute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Acute here] end
	private String subAcute;

	// % protected region % [Modify attribute annotation for Sub Acute Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Acute Code here] end
	private String subAcuteCode;

	// % protected region % [Modify attribute annotation for Sub Acute Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Acute Tariff here] end
	private Double subAcuteTariff;

	// % protected region % [Modify attribute annotation for Chronic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chronic here] end
	private String chronic;

	// % protected region % [Modify attribute annotation for Chronic Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chronic Code here] end
	private String chronicCode;

	// % protected region % [Modify attribute annotation for Chronic Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chronic Tariff here] end
	private Double chronicTariff;

	// % protected region % [Modify attribute annotation for Result Spec Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Result Spec Procedure here] end
	private String resultSpecProcedure;

	// % protected region % [Modify attribute annotation for Result Spec Drug here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Result Spec Drug here] end
	private String resultSpecDrug;

	// % protected region % [Modify attribute annotation for Result Spec Investigation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Result Spec Investigation here] end
	private String resultSpecInvestigation;

	// % protected region % [Modify attribute annotation for Result Spec Prosthesis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Result Spec Prosthesis here] end
	private String resultSpecProsthesis;

	// % protected region % [Modify attribute annotation for Hospital Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Class here] end
	private String hospitalClass;

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private String tariffType;

	// % protected region % [Modify attribute annotation for Total Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Tariff here] end
	private Double totalTariff;

	// % protected region % [Modify attribute annotation for Visit Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Date here] end
	private OffsetDateTime visitDate;

	// % protected region % [Modify attribute annotation for Spec Procedure Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Spec Procedure Tariff here] end
	private Double specProcedureTariff;

	// % protected region % [Modify attribute annotation for Spec Drug Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Spec Drug Tariff here] end
	private Double specDrugTariff;

	// % protected region % [Modify attribute annotation for Spec Investigation Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Spec Investigation Tariff here] end
	private Double specInvestigationTariff;

	// % protected region % [Modify attribute annotation for Spec Prosthesis Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Spec Prosthesis Tariff here] end
	private Double specProsthesisTariff;

	// % protected region % [Modify attribute annotation for Upgrade Flag here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Upgrade Flag here] end
	private Boolean upgradeFlag;

	// % protected region % [Modify attribute annotation for HCU Flag here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for HCU Flag here] end
	private Boolean hcuFlag;

	// % protected region % [Modify attribute annotation for Grouper Flag here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Grouper Flag here] end
	private Boolean grouperFlag;

	// % protected region % [Modify attribute annotation for Non Surgery Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Non Surgery Procedure here] end
	private Double nonSurgeryProcedure;

	// % protected region % [Modify attribute annotation for Surgery Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery Procedure here] end
	private Double surgeryProcedure;

	// % protected region % [Modify attribute annotation for Consultation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consultation here] end
	private Double consultation;

	// % protected region % [Modify attribute annotation for Specialist here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Specialist here] end
	private Double specialist;

	// % protected region % [Modify attribute annotation for Nursing here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nursing here] end
	private Double nursing;

	// % protected region % [Modify attribute annotation for Diagnostic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnostic here] end
	private Double diagnostic;

	// % protected region % [Modify attribute annotation for Radiology here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Radiology here] end
	private Double radiology;

	// % protected region % [Modify attribute annotation for Laboratory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Laboratory here] end
	private Double laboratory;

	// % protected region % [Modify attribute annotation for Blood Service here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Blood Service here] end
	private Double bloodService;

	// % protected region % [Modify attribute annotation for Rehabilitation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rehabilitation here] end
	private Double rehabilitation;

	// % protected region % [Modify attribute annotation for Bed Accomodation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bed Accomodation here] end
	private Double bedAccomodation;

	// % protected region % [Modify attribute annotation for Intensive Care here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intensive Care here] end
	private Double intensiveCare;

	// % protected region % [Modify attribute annotation for Drugs here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drugs here] end
	private Double drugs;

	// % protected region % [Modify attribute annotation for Medical Equipment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Equipment here] end
	private Double medicalEquipment;

	// % protected region % [Modify attribute annotation for Dispensed Disposable here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dispensed Disposable here] end
	private Double dispensedDisposable;

	// % protected region % [Modify attribute annotation for Equipment Rental here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Equipment Rental here] end
	private Double equipmentRental;

	// % protected region % [Modify attribute annotation for ICD10 Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICD10 Code here] end
	private String icd10Code;

	// % protected region % [Modify attribute annotation for ICD10 Desc here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICD10 Desc here] end
	private String icd10Desc;

	// % protected region % [Modify attribute annotation for ICD10 Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICD10 Tariff here] end
	private Double icd10Tariff;

	// % protected region % [Modify attribute annotation for ICD9CM Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICD9CM Code here] end
	private String icd9cmCode;

	// % protected region % [Modify attribute annotation for ICD9CM Desc here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICD9CM Desc here] end
	private String icd9cmDesc;

	// % protected region % [Modify attribute annotation for ICD9CM Tariff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for ICD9CM Tariff here] end
	private Double icd9cmTariff;

	// % protected region % [Modify attribute annotation for Chronic Drugs here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chronic Drugs here] end
	private Double chronicDrugs;

	// % protected region % [Modify attribute annotation for Chemotherapy Drugs here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chemotherapy Drugs here] end
	private Double chemotherapyDrugs;

	// % protected region % [Modify attribute annotation for Class Upgrade here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Class Upgrade here] end
	private String classUpgrade;

	// % protected region % [Modify attribute annotation for High Care Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for High Care Unit here] end
	private String highCareUnit;

	// % protected region % [Modify attribute annotation for Inacbg Claim Created here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inacbg Claim Created here] end
	private Boolean inacbgClaimCreated;

	// % protected region % [Modify attribute annotation for Inacbg Response here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inacbg Response here] end
	private String inacbgResponse;

	// % protected region % [Modify attribute annotation for Total Invoice here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Invoice here] end
	private Double totalInvoice;

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
