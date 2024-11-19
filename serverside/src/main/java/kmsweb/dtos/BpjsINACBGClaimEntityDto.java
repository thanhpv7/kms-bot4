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
@Schema(description = "The Dto for BpjsINACBGClaimEntity")
@EqualsAndHashCode(callSuper = false)
public class BpjsINACBGClaimEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String claimNo;

	private String patientID;

	private String invoiceNumber;

	private String bpjsCardNo;

	private String sepNo;

	private String treatmentType;

	private String treatmentClass;

	private OffsetDateTime admissionDate;

	private OffsetDateTime dismissalDate;

	private String los;

	private String dismissal;

	private String responsibleDoctor;

	private Double weight;

	private Integer adl;

	private String claimStatus;

	private String sepStatus;

	private Double hospitalTariff;

	private String referralLetter;

	private String thirdSelLevel;

	private String staffName;

	private OffsetDateTime dateGrouping;

	private String inacbgTariff;

	private String description;

	private String cbgType;

	private Double tariff;

	private String subAcute;

	private String subAcuteCode;

	private Double subAcuteTariff;

	private String chronic;

	private String chronicCode;

	private Double chronicTariff;

	private String resultSpecProcedure;

	private String resultSpecDrug;

	private String resultSpecInvestigation;

	private String resultSpecProsthesis;

	private String hospitalClass;

	private String tariffType;

	private Double totalTariff;

	private OffsetDateTime visitDate;

	private Double specProcedureTariff;

	private Double specDrugTariff;

	private Double specInvestigationTariff;

	private Double specProsthesisTariff;

	private Boolean upgradeFlag;

	private Boolean hcuFlag;

	private Boolean grouperFlag;

	private Double nonSurgeryProcedure;

	private Double surgeryProcedure;

	private Double consultation;

	private Double specialist;

	private Double nursing;

	private Double diagnostic;

	private Double radiology;

	private Double laboratory;

	private Double bloodService;

	private Double rehabilitation;

	private Double bedAccomodation;

	private Double intensiveCare;

	private Double drugs;

	private Double medicalEquipment;

	private Double dispensedDisposable;

	private Double equipmentRental;

	private String icd10Code;

	private String icd10Desc;

	private Double icd10Tariff;

	private String icd9cmCode;

	private String icd9cmDesc;

	private Double icd9cmTariff;

	private Double chronicDrugs;

	private Double chemotherapyDrugs;

	private String classUpgrade;

	private String highCareUnit;

	private Boolean inacbgClaimCreated;

	private String inacbgResponse;

	private Double totalInvoice;

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
