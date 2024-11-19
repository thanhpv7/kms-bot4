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
@Schema(description = "The Dto for MedicalExaminationRecordDischargeSummaryEntity")
@EqualsAndHashCode(callSuper = false)
public class MedicalExaminationRecordDischargeSummaryEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Integer diastole;

	private Integer systole;

	private Integer pulse;

	private Integer bpStandingSystole;

	private Integer bpStandingDiastole;

	private String pulseRegularity;

	private String pulseStrength;

	private Double temperature;

	private String temperatureScale;

	private String gcsEyes;

	private String gcsVerbal;

	private String gcsMotor;

	private Double totalGCSScore;

	private String consciousness;

	private Double height;

	private String heightScale;

	private Double weight;

	private String weightScale;

	private Double bmi;

	private Double respiratory;

	private Double oxygenSaturation;

	private Double waistCircumference;

	private String waistCircumferenceUnit;

	private String nutritionStatus;

	private Integer painScale;

	private String painScaleUsed;

	private Integer riskFallScale;

	private String objective;

	private String riskFallScaleUsed;

	private String subjective;

	private String plan;

	private String purpose;

	private String examinationSubCase;

	private String accidentalType;

	private String serviceCase;

	private String accidentalSubType;

	private String additionalNotes;

	private String dischargeSummary;

	private String conditionUponDischarge;

	private String escortedBy;

	private String dischargeReason;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	private StaffEntity dischargingDoctor;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
