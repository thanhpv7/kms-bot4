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
@Schema(description = "The Dto for MedicalExaminationRecordEntity")
@EqualsAndHashCode(callSuper = false)
public class MedicalExaminationRecordEntityDto extends AbstractEntityDto {
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

	private String dentalProcedure;

	private String psychiatryCase;

	private String therapy;

	private Boolean familyPlanning;

	private String condition;

	private String familyPlanningCase;

	private String previousContraceptiveMethod;

	private String sideEffects;

	private String complication;

	private String contraseptiveMethod;

	private String visitType;

	private String hearingTestMethod;

	private String hearingTestNotes;

	private String hearingLossCategory;

	private String hearingLossNotes;

	private String eyePositionRightEye;

	private String eyePositionLeftEye;

	private String muscleBalanceRightEye;

	private String muscleBalanceLeftEye;

	private String visualFieldRightEye;

	private String visualFieldLeftEye;

	private String ocularFunduscopyRightEye;

	private String ocularFunduscopyLeftEye;

	private String intraocularPressureRightEye;

	private String intraocularPressureLeftEye;

	private String colorBlindness;

	private String visualAcuityRightEye;

	private String visualAcuityLeftEye;

	private String correctionRightEye;

	private String correctionLeftEye;

	private String additionRightEye;

	private String additionLeftEye;

	private String occlusion;

	private String torusPalatinus;

	private String torusMandibularis;

	private String palatum;

	private Boolean diastema;

	private String diastemaNotes;

	private Boolean toothAnomaly;

	private String toothAnomalyNotes;

	private String otherDentalNotes;

	private String decayed;

	private String missing;

	private String filled;

	private String totalPhotograph;

	private String photographType;

	private String totalRontgenPhotograph;

	private String rontgenPhotographType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();

	private BirthHistoryEntity birthHistory;

	private BodyChartExaminationEntity bodyChartExamination;

	private Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTs = new HashSet<>();

	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

	private Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();

	private Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();

	private EntExaminationEntity entExamination;

	private EmergencyMedicalExaminationRecordEntity emergencyMedicationExaminationRecord;

	private FormulirKonselingTesHivEntity formulirKonselingTesHiv;

	private HemodialysisExaminationEntity hemodialysisExamination;

	private MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummary;

	private MedicalRecordInitialChecklistEntity medicalRecordInitialChecklist;

	private MedicalRecordNextVerificationChecklistEntity medicalRecordNextVerificationChecklist;

	private NurseVitalSignMeasurementEntity nurseVitalSignMeasurement;

	private ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistory;

	private OdontogramExaminationEntity odontogramExamination;

	private OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord;

	private OphthalmologyExaminationEntity ophthalmologyExamination;

	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity doctor;

	private InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecord;

	private RegistrationEntity registration;

	private StaffEntity medicalTranscriber;

	private StaffEntity nurse;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
