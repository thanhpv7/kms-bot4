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

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for OperatingTheaterMedicalExaminationRecordEntity")
@EqualsAndHashCode(callSuper = false)
public class OperatingTheaterMedicalExaminationRecordEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Boolean hasConfirmedIdentity;

	private Boolean anesthesiaSafetyCheckCompleted;

	private Boolean pulseOxymeterFunctioning;

	private String siteMarked;

	private String hasKnownAllergy;

	private String hasDifficultAirwayRisk;

	private String hasRiskOfBloodLoss;

	private Boolean teamMemberIntroduced;

	private Boolean professionalConfirmedPatient;

	private String antibioticProphylaxisGiven;

	private String essentialImagingDisplayed;

	private Boolean whareAreCriticalSteps;

	private Boolean howLongCaseTake;

	private Boolean whatIsAnticipatedBloodLoss;

	private Boolean anyPatientSpecificConcerns;

	private Boolean sterlityBeenConfirmed;

	private Boolean equipmentIssuesAnyConcern;

	private Boolean nameOfProcedure;

	private Boolean instrumentsNeedCountCorrect;

	private Boolean specimenIsLabeled;

	private Boolean equipmentProblemsAddressed;

	private Boolean keyConcernsForRecovery;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private IntraoperativeRecordsEntity intraoperativeRecords;

	private PostOperativeDetailsEntity postOperativeDetails;

	private PreoperativeRecordsEntity preoperativeRecords;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosisNandaEntity nursingAnesthesiaDetail;

	private StaffEntity nursingDetailSurgicalNursings;

	private StaffEntity nursingDetailsAnesthesiaNursings;

	private DiagnosisNandaEntity nursingSurgicalDetail;

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
