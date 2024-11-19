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

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class MedicalExaminationRecordEntity extends AbstractEntity {

	public MedicalExaminationRecordEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AmendmentDetailsOneMany = new EntityReference();
			AmendmentDetailsOneMany.entityName = "AmendmentDetail";
			AmendmentDetailsOneMany.oppositeName = "MedicalExaminationRecord";
			AmendmentDetailsOneMany.name = "AmendmentDetails";
			AmendmentDetailsOneMany.optional = true;
			AmendmentDetailsOneMany.type = "One";
			AmendmentDetailsOneMany.oppositeType = "Many";

		References.add(AmendmentDetailsOneMany);

		var BirthHistoryOneOne = new EntityReference();
			BirthHistoryOneOne.entityName = "BirthHistory";
			BirthHistoryOneOne.oppositeName = "MedicalExaminationRecord";
			BirthHistoryOneOne.name = "BirthHistory";
			BirthHistoryOneOne.optional = true;
			BirthHistoryOneOne.type = "One";
			BirthHistoryOneOne.oppositeType = "One";

		References.add(BirthHistoryOneOne);

		var BodyChartExaminationOneOne = new EntityReference();
			BodyChartExaminationOneOne.entityName = "BodyChartExamination";
			BodyChartExaminationOneOne.oppositeName = "MedicalExaminationRecord";
			BodyChartExaminationOneOne.name = "BodyChartExamination";
			BodyChartExaminationOneOne.optional = true;
			BodyChartExaminationOneOne.type = "One";
			BodyChartExaminationOneOne.oppositeType = "One";

		References.add(BodyChartExaminationOneOne);

		var CoTreatingDoctorsOneMany = new EntityReference();
			CoTreatingDoctorsOneMany.entityName = "CoTreatingDoctor";
			CoTreatingDoctorsOneMany.oppositeName = "MedicalExaminationRecord";
			CoTreatingDoctorsOneMany.name = "CoTreatingDoctors";
			CoTreatingDoctorsOneMany.optional = true;
			CoTreatingDoctorsOneMany.type = "One";
			CoTreatingDoctorsOneMany.oppositeType = "Many";

		References.add(CoTreatingDoctorsOneMany);

		var DailyCareCPPTsOneMany = new EntityReference();
			DailyCareCPPTsOneMany.entityName = "DailyCareCPPT";
			DailyCareCPPTsOneMany.oppositeName = "MedicalExaminationRecord";
			DailyCareCPPTsOneMany.name = "DailyCareCPPTs";
			DailyCareCPPTsOneMany.optional = true;
			DailyCareCPPTsOneMany.type = "One";
			DailyCareCPPTsOneMany.oppositeType = "Many";

		References.add(DailyCareCPPTsOneMany);

		var DeliveryMedicalExaminationRecordOneOne = new EntityReference();
			DeliveryMedicalExaminationRecordOneOne.entityName = "DeliveryMedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneOne.name = "DeliveryMedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneOne.optional = true;
			DeliveryMedicalExaminationRecordOneOne.type = "One";
			DeliveryMedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(DeliveryMedicalExaminationRecordOneOne);

		var DiagnosisExaminationRecordsOneMany = new EntityReference();
			DiagnosisExaminationRecordsOneMany.entityName = "DiagnosisExaminationRecord";
			DiagnosisExaminationRecordsOneMany.oppositeName = "MedicalExaminationRecord";
			DiagnosisExaminationRecordsOneMany.name = "DiagnosisExaminationRecords";
			DiagnosisExaminationRecordsOneMany.optional = true;
			DiagnosisExaminationRecordsOneMany.type = "One";
			DiagnosisExaminationRecordsOneMany.oppositeType = "Many";

		References.add(DiagnosisExaminationRecordsOneMany);

		var DiagnosisNandasOneMany = new EntityReference();
			DiagnosisNandasOneMany.entityName = "DiagnosisNanda";
			DiagnosisNandasOneMany.oppositeName = "MedicalExaminationRecord";
			DiagnosisNandasOneMany.name = "DiagnosisNandas";
			DiagnosisNandasOneMany.optional = true;
			DiagnosisNandasOneMany.type = "One";
			DiagnosisNandasOneMany.oppositeType = "Many";

		References.add(DiagnosisNandasOneMany);

		var DoctorOneMany = new EntityReference();
			DoctorOneMany.entityName = "Staff";
			DoctorOneMany.oppositeName = "Doctor";
			DoctorOneMany.name = "DoctorOnExamination";
			DoctorOneMany.optional = true;
			DoctorOneMany.type = "One";
			DoctorOneMany.oppositeType = "Many";

		References.add(DoctorOneMany);

		var EntExaminationOneOne = new EntityReference();
			EntExaminationOneOne.entityName = "EntExamination";
			EntExaminationOneOne.oppositeName = "MedicalExaminationRecord";
			EntExaminationOneOne.name = "EntExamination";
			EntExaminationOneOne.optional = true;
			EntExaminationOneOne.type = "One";
			EntExaminationOneOne.oppositeType = "One";

		References.add(EntExaminationOneOne);

		var EmergencyMedicationExaminationRecordOneOne = new EntityReference();
			EmergencyMedicationExaminationRecordOneOne.entityName = "EmergencyMedicalExaminationRecord";
			EmergencyMedicationExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			EmergencyMedicationExaminationRecordOneOne.name = "EmergencyMedicationExaminationRecord";
			EmergencyMedicationExaminationRecordOneOne.optional = true;
			EmergencyMedicationExaminationRecordOneOne.type = "One";
			EmergencyMedicationExaminationRecordOneOne.oppositeType = "One";

		References.add(EmergencyMedicationExaminationRecordOneOne);

		var FormulirKonselingTesHivOneOne = new EntityReference();
			FormulirKonselingTesHivOneOne.entityName = "FormulirKonselingTesHiv";
			FormulirKonselingTesHivOneOne.oppositeName = "MedicalExaminationRecord";
			FormulirKonselingTesHivOneOne.name = "FormulirKonselingTesHiv";
			FormulirKonselingTesHivOneOne.optional = true;
			FormulirKonselingTesHivOneOne.type = "One";
			FormulirKonselingTesHivOneOne.oppositeType = "One";

		References.add(FormulirKonselingTesHivOneOne);

		var HemodialysisExaminationOneOne = new EntityReference();
			HemodialysisExaminationOneOne.entityName = "HemodialysisExamination";
			HemodialysisExaminationOneOne.oppositeName = "MedicalExaminationRecord";
			HemodialysisExaminationOneOne.name = "HemodialysisExamination";
			HemodialysisExaminationOneOne.optional = true;
			HemodialysisExaminationOneOne.type = "One";
			HemodialysisExaminationOneOne.oppositeType = "One";

		References.add(HemodialysisExaminationOneOne);

		var MedicalExaminationRecordDischargeSummaryOneOne = new EntityReference();
			MedicalExaminationRecordDischargeSummaryOneOne.entityName = "MedicalExaminationRecordDischargeSummary";
			MedicalExaminationRecordDischargeSummaryOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordDischargeSummaryOneOne.name = "MedicalExaminationRecordDischargeSummary";
			MedicalExaminationRecordDischargeSummaryOneOne.optional = true;
			MedicalExaminationRecordDischargeSummaryOneOne.type = "One";
			MedicalExaminationRecordDischargeSummaryOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordDischargeSummaryOneOne);

		var InpatientMedicalExaminationRecordOneOne = new EntityReference();
			InpatientMedicalExaminationRecordOneOne.entityName = "InpatientMedicalExaminationRecord";
			InpatientMedicalExaminationRecordOneOne.oppositeName = "InpatientMedicalExaminationRecord";
			InpatientMedicalExaminationRecordOneOne.name = "MedicalExaminationRecord";
			InpatientMedicalExaminationRecordOneOne.optional = true;
			InpatientMedicalExaminationRecordOneOne.type = "One";
			InpatientMedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(InpatientMedicalExaminationRecordOneOne);

		var RegistrationOneOne = new EntityReference();
			RegistrationOneOne.entityName = "Registration";
			RegistrationOneOne.oppositeName = "Registration";
			RegistrationOneOne.name = "MedicalExaminationRecord";
			RegistrationOneOne.optional = true;
			RegistrationOneOne.type = "One";
			RegistrationOneOne.oppositeType = "One";

		References.add(RegistrationOneOne);

		var MedicalRecordInitialChecklistOneOne = new EntityReference();
			MedicalRecordInitialChecklistOneOne.entityName = "MedicalRecordInitialChecklist";
			MedicalRecordInitialChecklistOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalRecordInitialChecklistOneOne.name = "MedicalRecordInitialChecklist";
			MedicalRecordInitialChecklistOneOne.optional = true;
			MedicalRecordInitialChecklistOneOne.type = "One";
			MedicalRecordInitialChecklistOneOne.oppositeType = "One";

		References.add(MedicalRecordInitialChecklistOneOne);

		var MedicalRecordNextVerificationChecklistOneOne = new EntityReference();
			MedicalRecordNextVerificationChecklistOneOne.entityName = "MedicalRecordNextVerificationChecklist";
			MedicalRecordNextVerificationChecklistOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalRecordNextVerificationChecklistOneOne.name = "MedicalRecordNextVerificationChecklist";
			MedicalRecordNextVerificationChecklistOneOne.optional = true;
			MedicalRecordNextVerificationChecklistOneOne.type = "One";
			MedicalRecordNextVerificationChecklistOneOne.oppositeType = "One";

		References.add(MedicalRecordNextVerificationChecklistOneOne);

		var MedicalTranscriberOneMany = new EntityReference();
			MedicalTranscriberOneMany.entityName = "Staff";
			MedicalTranscriberOneMany.oppositeName = "MedicalTranscriber";
			MedicalTranscriberOneMany.name = "MedicalRecordTranscriber";
			MedicalTranscriberOneMany.optional = true;
			MedicalTranscriberOneMany.type = "One";
			MedicalTranscriberOneMany.oppositeType = "Many";

		References.add(MedicalTranscriberOneMany);

		var NurseVitalSignMeasurementOneOne = new EntityReference();
			NurseVitalSignMeasurementOneOne.entityName = "NurseVitalSignMeasurement";
			NurseVitalSignMeasurementOneOne.oppositeName = "MedicalExaminationRecord";
			NurseVitalSignMeasurementOneOne.name = "NurseVitalSignMeasurement";
			NurseVitalSignMeasurementOneOne.optional = true;
			NurseVitalSignMeasurementOneOne.type = "One";
			NurseVitalSignMeasurementOneOne.oppositeType = "One";

		References.add(NurseVitalSignMeasurementOneOne);

		var NurseOneMany = new EntityReference();
			NurseOneMany.entityName = "Staff";
			NurseOneMany.oppositeName = "Nurse";
			NurseOneMany.name = "Nurse";
			NurseOneMany.optional = true;
			NurseOneMany.type = "One";
			NurseOneMany.oppositeType = "Many";

		References.add(NurseOneMany);

		var ObstetricAndGynecologyHistoryOneOne = new EntityReference();
			ObstetricAndGynecologyHistoryOneOne.entityName = "ObstetricAndGynecologyHistory";
			ObstetricAndGynecologyHistoryOneOne.oppositeName = "MedicalExaminationRecord";
			ObstetricAndGynecologyHistoryOneOne.name = "ObstetricAndGynecologyHistory";
			ObstetricAndGynecologyHistoryOneOne.optional = true;
			ObstetricAndGynecologyHistoryOneOne.type = "One";
			ObstetricAndGynecologyHistoryOneOne.oppositeType = "One";

		References.add(ObstetricAndGynecologyHistoryOneOne);

		var OdontogramExaminationOneOne = new EntityReference();
			OdontogramExaminationOneOne.entityName = "OdontogramExamination";
			OdontogramExaminationOneOne.oppositeName = "MedicalExaminationRecord";
			OdontogramExaminationOneOne.name = "OdontogramExamination";
			OdontogramExaminationOneOne.optional = true;
			OdontogramExaminationOneOne.type = "One";
			OdontogramExaminationOneOne.oppositeType = "One";

		References.add(OdontogramExaminationOneOne);

		var OperatingTheaterMedicalExaminationRecordOneOne = new EntityReference();
			OperatingTheaterMedicalExaminationRecordOneOne.entityName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.name = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.optional = true;
			OperatingTheaterMedicalExaminationRecordOneOne.type = "One";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(OperatingTheaterMedicalExaminationRecordOneOne);

		var OphthalmologyExaminationOneOne = new EntityReference();
			OphthalmologyExaminationOneOne.entityName = "OphthalmologyExamination";
			OphthalmologyExaminationOneOne.oppositeName = "MedicalExaminationRecord";
			OphthalmologyExaminationOneOne.name = "OphthalmologyExamination";
			OphthalmologyExaminationOneOne.optional = true;
			OphthalmologyExaminationOneOne.type = "One";
			OphthalmologyExaminationOneOne.oppositeType = "One";

		References.add(OphthalmologyExaminationOneOne);

		var RoomTransfersOneMany = new EntityReference();
			RoomTransfersOneMany.entityName = "RoomTransfer";
			RoomTransfersOneMany.oppositeName = "MedicalExaminationRecord";
			RoomTransfersOneMany.name = "RoomTransfers";
			RoomTransfersOneMany.optional = true;
			RoomTransfersOneMany.type = "One";
			RoomTransfersOneMany.oppositeType = "Many";

		References.add(RoomTransfersOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Integer diastole;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Systole here] end
	private Integer systole;

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Integer pulse;

	// % protected region % [Modify attribute annotation for BP Standing Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BP Standing Systole here] end
	private Integer bpStandingSystole;

	// % protected region % [Modify attribute annotation for BP Standing Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BP Standing Diastole here] end
	private Integer bpStandingDiastole;

	// % protected region % [Modify attribute annotation for Pulse Regularity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse Regularity here] end
	private String pulseRegularity;

	// % protected region % [Modify attribute annotation for Pulse Strength here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse Strength here] end
	private String pulseStrength;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature scale here] end
	private String temperatureScale;

	// % protected region % [Modify attribute annotation for GCS Eyes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for GCS Eyes here] end
	private String gcsEyes;

	// % protected region % [Modify attribute annotation for GCS Verbal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for GCS Verbal here] end
	private String gcsVerbal;

	// % protected region % [Modify attribute annotation for GCS Motor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for GCS Motor here] end
	private String gcsMotor;

	// % protected region % [Modify attribute annotation for Total GCS Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total GCS Score here] end
	private Double totalGCSScore;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

	// % protected region % [Modify attribute annotation for Height here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Height here] end
	private Double height;

	// % protected region % [Modify attribute annotation for Height Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Height Scale here] end
	private String heightScale;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Scale here] end
	private String weightScale;

	// % protected region % [Modify attribute annotation for BMI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BMI here] end
	private Double bmi;

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private Double respiratory;

	// % protected region % [Modify attribute annotation for Oxygen Saturation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Oxygen Saturation here] end
	private Double oxygenSaturation;

	// % protected region % [Modify attribute annotation for Waist Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waist Circumference here] end
	private Double waistCircumference;

	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] end
	private String waistCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Nutrition Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nutrition Status here] end
	private String nutritionStatus;

	// % protected region % [Modify attribute annotation for Pain Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pain Scale here] end
	private Integer painScale;

	// % protected region % [Modify attribute annotation for Pain Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pain Scale Used here] end
	private String painScaleUsed;

	// % protected region % [Modify attribute annotation for Risk Fall Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale here] end
	private Integer riskFallScale;

	// % protected region % [Modify attribute annotation for Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Objective here] end
	private String objective;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

	// % protected region % [Modify attribute annotation for Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Subjective here] end
	private String subjective;

	// % protected region % [Modify attribute annotation for Plan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Plan here] end
	private String plan;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

	// % protected region % [Modify attribute annotation for Examination Sub Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Examination Sub Case here] end
	private String examinationSubCase;

	// % protected region % [Modify attribute annotation for Accidental Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accidental Type here] end
	private String accidentalType;

	// % protected region % [Modify attribute annotation for Service Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Case here] end
	private String serviceCase;

	// % protected region % [Modify attribute annotation for Accidental Sub Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accidental Sub Type here] end
	private String accidentalSubType;

	// % protected region % [Modify attribute annotation for Additional Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Additional Notes here] end
	private String additionalNotes;

	// % protected region % [Modify attribute annotation for Dental Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dental Procedure here] end
	private String dentalProcedure;

	// % protected region % [Modify attribute annotation for Psychiatry Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Psychiatry Case here] end
	private String psychiatryCase;

	// % protected region % [Modify attribute annotation for Therapy here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Therapy here] end
	private String therapy;

	// % protected region % [Modify attribute annotation for Family Planning here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Family Planning here] end
	private Boolean familyPlanning;

	// % protected region % [Modify attribute annotation for Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Condition here] end
	private String condition;

	// % protected region % [Modify attribute annotation for Family Planning Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Family Planning Case here] end
	private String familyPlanningCase;

	// % protected region % [Modify attribute annotation for Previous Contraceptive Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Previous Contraceptive Method here] end
	private String previousContraceptiveMethod;

	// % protected region % [Modify attribute annotation for Side Effects here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Side Effects here] end
	private String sideEffects;

	// % protected region % [Modify attribute annotation for Complication here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Complication here] end
	private String complication;

	// % protected region % [Modify attribute annotation for Contraseptive Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contraseptive Method here] end
	private String contraseptiveMethod;

	// % protected region % [Modify attribute annotation for Visit Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Type here] end
	private String visitType;

	// % protected region % [Modify attribute annotation for Hearing Test Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hearing Test Method here] end
	private String hearingTestMethod;

	// % protected region % [Modify attribute annotation for Hearing Test Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hearing Test Notes here] end
	private String hearingTestNotes;

	// % protected region % [Modify attribute annotation for Hearing Loss Category here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hearing Loss Category here] end
	private String hearingLossCategory;

	// % protected region % [Modify attribute annotation for Hearing Loss Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hearing Loss Notes here] end
	private String hearingLossNotes;

	// % protected region % [Modify attribute annotation for Eye Position Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Eye Position Right Eye here] end
	private String eyePositionRightEye;

	// % protected region % [Modify attribute annotation for Eye Position Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Eye Position Left Eye here] end
	private String eyePositionLeftEye;

	// % protected region % [Modify attribute annotation for Muscle Balance Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Muscle Balance Right Eye here] end
	private String muscleBalanceRightEye;

	// % protected region % [Modify attribute annotation for Muscle Balance Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Muscle Balance Left Eye here] end
	private String muscleBalanceLeftEye;

	// % protected region % [Modify attribute annotation for Visual Field Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visual Field Right Eye here] end
	private String visualFieldRightEye;

	// % protected region % [Modify attribute annotation for Visual Field Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visual Field Left Eye here] end
	private String visualFieldLeftEye;

	// % protected region % [Modify attribute annotation for Ocular Funduscopy Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ocular Funduscopy Right Eye here] end
	private String ocularFunduscopyRightEye;

	// % protected region % [Modify attribute annotation for Ocular Funduscopy Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ocular Funduscopy Left Eye here] end
	private String ocularFunduscopyLeftEye;

	// % protected region % [Modify attribute annotation for Intraocular Pressure Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intraocular Pressure Right Eye here] end
	private String intraocularPressureRightEye;

	// % protected region % [Modify attribute annotation for Intraocular Pressure Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intraocular Pressure Left Eye here] end
	private String intraocularPressureLeftEye;

	// % protected region % [Modify attribute annotation for Color Blindness here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Color Blindness here] end
	private String colorBlindness;

	// % protected region % [Modify attribute annotation for Visual Acuity Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visual Acuity Right Eye here] end
	private String visualAcuityRightEye;

	// % protected region % [Modify attribute annotation for Visual Acuity Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visual Acuity Left Eye here] end
	private String visualAcuityLeftEye;

	// % protected region % [Modify attribute annotation for Correction Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Correction Right Eye here] end
	private String correctionRightEye;

	// % protected region % [Modify attribute annotation for Correction Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Correction Left Eye here] end
	private String correctionLeftEye;

	// % protected region % [Modify attribute annotation for Addition Right Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Addition Right Eye here] end
	private String additionRightEye;

	// % protected region % [Modify attribute annotation for Addition Left Eye here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Addition Left Eye here] end
	private String additionLeftEye;

	// % protected region % [Modify attribute annotation for Occlusion here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Occlusion here] end
	private String occlusion;

	// % protected region % [Modify attribute annotation for Torus Palatinus here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Torus Palatinus here] end
	private String torusPalatinus;

	// % protected region % [Modify attribute annotation for Torus Mandibularis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Torus Mandibularis here] end
	private String torusMandibularis;

	// % protected region % [Modify attribute annotation for Palatum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Palatum here] end
	private String palatum;

	// % protected region % [Modify attribute annotation for Diastema here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastema here] end
	private Boolean diastema;

	// % protected region % [Modify attribute annotation for Diastema Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastema Notes here] end
	private String diastemaNotes;

	// % protected region % [Modify attribute annotation for Tooth Anomaly here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tooth Anomaly here] end
	private Boolean toothAnomaly;

	// % protected region % [Modify attribute annotation for Tooth Anomaly Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tooth Anomaly Notes here] end
	private String toothAnomalyNotes;

	// % protected region % [Modify attribute annotation for Other Dental Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Dental Notes here] end
	private String otherDentalNotes;

	// % protected region % [Modify attribute annotation for Decayed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Decayed here] end
	private String decayed;

	// % protected region % [Modify attribute annotation for Missing here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Missing here] end
	private String missing;

	// % protected region % [Modify attribute annotation for Filled here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Filled here] end
	private String filled;

	// % protected region % [Modify attribute annotation for Total Photograph here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Photograph here] end
	private String totalPhotograph;

	// % protected region % [Modify attribute annotation for Photograph Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Photograph Type here] end
	private String photographType;

	// % protected region % [Modify attribute annotation for Total Rontgen Photograph here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Rontgen Photograph here] end
	private String totalRontgenPhotograph;

	// % protected region % [Modify attribute annotation for Rontgen Photograph Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rontgen Photograph Type here] end
	private String rontgenPhotographType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BirthHistoryEntity birthHistory;

	private BodyChartExaminationEntity bodyChartExamination;

	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecord;

	private RegistrationEntity registration;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();

	private Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTs = new HashSet<>();

	private Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();

	private Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();

	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity doctor;

	private StaffEntity medicalTranscriber;

	private StaffEntity nurse;

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

/**
	 * Similar to {@link this#addAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NonNull AmendmentDetailEntity entity) {
		addAmendmentDetails(entity, true);
	}

	/**
	 * Add a new AmendmentDetailEntity to amendmentDetails in this entity.
	 *
	 * @param entity the given AmendmentDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAmendmentDetails(@NonNull AmendmentDetailEntity entity, boolean reverseAdd) {
		if (!this.amendmentDetails.contains(entity)) {
			amendmentDetails.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities) {
		addAmendmentDetails(entities, true);
	}

	/**
	 * Add a new collection of AmendmentDetailEntity to Amendment Details in this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be set to this entity
	 */
	public void removeAmendmentDetails(@NonNull AmendmentDetailEntity entity) {
		this.removeAmendmentDetails(entity, true);
	}

	/**
	 * Remove the given AmendmentDetailEntity from this entity.
	 *
	 * @param entity the given AmendmentDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAmendmentDetails(@NonNull AmendmentDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.amendmentDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 */
	public void removeAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities) {
		this.removeAmendmentDetails(entities, true);
	}

	/**
	 * Remove the given collection of AmendmentDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be set to this entity
	 */
	public void setAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities) {
		setAmendmentDetails(entities, true);
	}

	/**
	 * Replace the current entities in Amendment Details with the given ones.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {

		this.unsetAmendmentDetails();
		this.amendmentDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAmendmentDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAmendmentDetails() {
		this.unsetAmendmentDetails(true);
	}

	/**
	 * Remove all the entities in Amendment Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAmendmentDetails(boolean doReverse) {
		if (doReverse) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.unsetMedicalExaminationRecord(false));
		}
		this.amendmentDetails.clear();
	}

	/**
	 * Similar to {@link this#setBirthHistory(BirthHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setBirthHistory(@NonNull BirthHistoryEntity entity) {
		setBirthHistory(entity, true);
	}

	/**
	 * Set or update birthHistory with the given BirthHistoryEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBirthHistory(@NonNull BirthHistoryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBirthHistory here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBirthHistory here] end

		if (sameAsFormer(this.birthHistory, entity)) {
			return;
		}

		if (this.birthHistory != null) {
			this.birthHistory.unsetMedicalExaminationRecord();
		}

		this.birthHistory = entity;

		if (reverseAdd) {
			this.birthHistory.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBirthHistory outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBirthHistory outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBirthHistory(boolean)} but default to true.
	 */
	public void unsetBirthHistory() {
		this.unsetBirthHistory(true);
	}

	/**
	 * Remove the BirthHistoryEntity in Birth History from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBirthHistory(boolean reverse) {
		if (reverse && this.birthHistory != null) {
			this.birthHistory.unsetMedicalExaminationRecord(false);
		}
		this.birthHistory = null;
	}

	/**
	 * Similar to {@link this#setBodyChartExamination(BodyChartExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setBodyChartExamination(@NonNull BodyChartExaminationEntity entity) {
		setBodyChartExamination(entity, true);
	}

	/**
	 * Set or update bodyChartExamination with the given BodyChartExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBodyChartExamination(@NonNull BodyChartExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBodyChartExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBodyChartExamination here] end

		if (sameAsFormer(this.bodyChartExamination, entity)) {
			return;
		}

		if (this.bodyChartExamination != null) {
			this.bodyChartExamination.unsetMedicalExaminationRecord();
		}

		this.bodyChartExamination = entity;

		if (reverseAdd) {
			this.bodyChartExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBodyChartExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBodyChartExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBodyChartExamination(boolean)} but default to true.
	 */
	public void unsetBodyChartExamination() {
		this.unsetBodyChartExamination(true);
	}

	/**
	 * Remove the BodyChartExaminationEntity in Body Chart Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBodyChartExamination(boolean reverse) {
		if (reverse && this.bodyChartExamination != null) {
			this.bodyChartExamination.unsetMedicalExaminationRecord(false);
		}
		this.bodyChartExamination = null;
	}

/**
	 * Similar to {@link this#addCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity) {
		addCoTreatingDoctors(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingDoctors in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingDoctors.contains(entity)) {
			coTreatingDoctors.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingDoctors(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Doctors in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingDoctors(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.coTreatingDoctors.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingDoctors(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingDoctors(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Doctors with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingDoctors();
		this.coTreatingDoctors = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingDoctors(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingDoctors() {
		this.unsetCoTreatingDoctors(true);
	}

	/**
	 * Remove all the entities in Co Treating Doctors from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingDoctors(boolean doReverse) {
		if (doReverse) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.unsetMedicalExaminationRecord(false));
		}
		this.coTreatingDoctors.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTs(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTs(@NonNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTs(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTs in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTs(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTs.contains(entity)) {
			dailyCareCPPTs.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTs(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTs(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTs(@NonNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTs(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTs(@NonNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.dailyCareCPPTs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTs(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTs(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTs();
		this.dailyCareCPPTs = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTs.forEach(dailyCareCPPTsEntity -> dailyCareCPPTsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTs() {
		this.unsetDailyCareCPPTs(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTs(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTs.forEach(dailyCareCPPTsEntity -> dailyCareCPPTsEntity.unsetMedicalExaminationRecord(false));
		}
		this.dailyCareCPPTs.clear();
	}

	/**
	 * Similar to {@link this#setDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NonNull DeliveryMedicalExaminationRecordEntity entity) {
		setDeliveryMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update deliveryMedicalExaminationRecord with the given DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NonNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] end

		if (sameAsFormer(this.deliveryMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.unsetMedicalExaminationRecord();
		}

		this.deliveryMedicalExaminationRecord = entity;

		if (reverseAdd) {
			this.deliveryMedicalExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDeliveryMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDeliveryMedicalExaminationRecord() {
		this.unsetDeliveryMedicalExaminationRecord(true);
	}

	/**
	 * Remove the DeliveryMedicalExaminationRecordEntity in Delivery Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDeliveryMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.unsetMedicalExaminationRecord(false);
		}
		this.deliveryMedicalExaminationRecord = null;
	}

/**
	 * Similar to {@link this#addDiagnosisExaminationRecords(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity) {
		addDiagnosisExaminationRecords(entity, true);
	}

	/**
	 * Add a new DiagnosisExaminationRecordEntity to diagnosisExaminationRecords in this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.diagnosisExaminationRecords.contains(entity)) {
			diagnosisExaminationRecords.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosisExaminationRecords(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		addDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Add a new collection of DiagnosisExaminationRecordEntity to Diagnosis Examination Records in this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosisExaminationRecords(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosisExaminationRecords(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void removeDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity) {
		this.removeDiagnosisExaminationRecords(entity, true);
	}

	/**
	 * Remove the given DiagnosisExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.diagnosisExaminationRecords.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosisExaminationRecords(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 */
	public void removeDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		this.removeDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosisExaminationRecords(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosisExaminationRecords(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		setDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Replace the current entities in Diagnosis Examination Records with the given ones.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosisExaminationRecords();
		this.diagnosisExaminationRecords = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosisExaminationRecords.forEach(diagnosisExaminationRecordsEntity -> diagnosisExaminationRecordsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosisExaminationRecords(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosisExaminationRecords() {
		this.unsetDiagnosisExaminationRecords(true);
	}

	/**
	 * Remove all the entities in Diagnosis Examination Records from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosisExaminationRecords(boolean doReverse) {
		if (doReverse) {
			this.diagnosisExaminationRecords.forEach(diagnosisExaminationRecordsEntity -> diagnosisExaminationRecordsEntity.unsetMedicalExaminationRecord(false));
		}
		this.diagnosisExaminationRecords.clear();
	}

/**
	 * Similar to {@link this#addDiagnosisNandas(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be added to this entity
	 */
	public void addDiagnosisNandas(@NonNull DiagnosisNandaEntity entity) {
		addDiagnosisNandas(entity, true);
	}

	/**
	 * Add a new DiagnosisNandaEntity to diagnosisNandas in this entity.
	 *
	 * @param entity the given DiagnosisNandaEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosisNandas(@NonNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		if (!this.diagnosisNandas.contains(entity)) {
			diagnosisNandas.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be added to this entity
	 */
	public void addDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities) {
		addDiagnosisNandas(entities, true);
	}

	/**
	 * Add a new collection of DiagnosisNandaEntity to Diagnosis Nandas in this entity.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosisNandas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosisNandas(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void removeDiagnosisNandas(@NonNull DiagnosisNandaEntity entity) {
		this.removeDiagnosisNandas(entity, true);
	}

	/**
	 * Remove the given DiagnosisNandaEntity from this entity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosisNandas(@NonNull DiagnosisNandaEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.diagnosisNandas.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be removed to this entity
	 */
	public void removeDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities) {
		this.removeDiagnosisNandas(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisNandaEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosisNandas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be set to this entity
	 */
	public void setDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities) {
		setDiagnosisNandas(entities, true);
	}

	/**
	 * Replace the current entities in Diagnosis Nandas with the given ones.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosisNandas();
		this.diagnosisNandas = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosisNandas.forEach(diagnosisNandasEntity -> diagnosisNandasEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosisNandas(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosisNandas() {
		this.unsetDiagnosisNandas(true);
	}

	/**
	 * Remove all the entities in Diagnosis Nandas from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosisNandas(boolean doReverse) {
		if (doReverse) {
			this.diagnosisNandas.forEach(diagnosisNandasEntity -> diagnosisNandasEntity.unsetMedicalExaminationRecord(false));
		}
		this.diagnosisNandas.clear();
	}

	/**
	 * Similar to {@link this#setEntExamination(EntExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setEntExamination(@NonNull EntExaminationEntity entity) {
		setEntExamination(entity, true);
	}

	/**
	 * Set or update entExamination with the given EntExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setEntExamination(@NonNull EntExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setEntExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setEntExamination here] end

		if (sameAsFormer(this.entExamination, entity)) {
			return;
		}

		if (this.entExamination != null) {
			this.entExamination.unsetMedicalExaminationRecord();
		}

		this.entExamination = entity;

		if (reverseAdd) {
			this.entExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setEntExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setEntExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetEntExamination(boolean)} but default to true.
	 */
	public void unsetEntExamination() {
		this.unsetEntExamination(true);
	}

	/**
	 * Remove the EntExaminationEntity in ENT Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetEntExamination(boolean reverse) {
		if (reverse && this.entExamination != null) {
			this.entExamination.unsetMedicalExaminationRecord(false);
		}
		this.entExamination = null;
	}

	/**
	 * Similar to {@link this#setEmergencyMedicationExaminationRecord(EmergencyMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setEmergencyMedicationExaminationRecord(@NonNull EmergencyMedicalExaminationRecordEntity entity) {
		setEmergencyMedicationExaminationRecord(entity, true);
	}

	/**
	 * Set or update emergencyMedicationExaminationRecord with the given EmergencyMedicalExaminationRecordEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setEmergencyMedicationExaminationRecord(@NonNull EmergencyMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setEmergencyMedicationExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setEmergencyMedicationExaminationRecord here] end

		if (sameAsFormer(this.emergencyMedicationExaminationRecord, entity)) {
			return;
		}

		if (this.emergencyMedicationExaminationRecord != null) {
			this.emergencyMedicationExaminationRecord.unsetMedicalExaminationRecord();
		}

		this.emergencyMedicationExaminationRecord = entity;

		if (reverseAdd) {
			this.emergencyMedicationExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setEmergencyMedicationExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setEmergencyMedicationExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetEmergencyMedicationExaminationRecord(boolean)} but default to true.
	 */
	public void unsetEmergencyMedicationExaminationRecord() {
		this.unsetEmergencyMedicationExaminationRecord(true);
	}

	/**
	 * Remove the EmergencyMedicalExaminationRecordEntity in Emergency Medication Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetEmergencyMedicationExaminationRecord(boolean reverse) {
		if (reverse && this.emergencyMedicationExaminationRecord != null) {
			this.emergencyMedicationExaminationRecord.unsetMedicalExaminationRecord(false);
		}
		this.emergencyMedicationExaminationRecord = null;
	}

	/**
	 * Similar to {@link this#setFormulirKonselingTesHiv(FormulirKonselingTesHivEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setFormulirKonselingTesHiv(@NonNull FormulirKonselingTesHivEntity entity) {
		setFormulirKonselingTesHiv(entity, true);
	}

	/**
	 * Set or update formulirKonselingTesHiv with the given FormulirKonselingTesHivEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setFormulirKonselingTesHiv(@NonNull FormulirKonselingTesHivEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setFormulirKonselingTesHiv here] off begin
		// % protected region % [Add any additional logic here before the main logic for setFormulirKonselingTesHiv here] end

		if (sameAsFormer(this.formulirKonselingTesHiv, entity)) {
			return;
		}

		if (this.formulirKonselingTesHiv != null) {
			this.formulirKonselingTesHiv.unsetMedicalExaminationRecord();
		}

		this.formulirKonselingTesHiv = entity;

		if (reverseAdd) {
			this.formulirKonselingTesHiv.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setFormulirKonselingTesHiv outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setFormulirKonselingTesHiv outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetFormulirKonselingTesHiv(boolean)} but default to true.
	 */
	public void unsetFormulirKonselingTesHiv() {
		this.unsetFormulirKonselingTesHiv(true);
	}

	/**
	 * Remove the FormulirKonselingTesHivEntity in Formulir Konseling Tes Hiv from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetFormulirKonselingTesHiv(boolean reverse) {
		if (reverse && this.formulirKonselingTesHiv != null) {
			this.formulirKonselingTesHiv.unsetMedicalExaminationRecord(false);
		}
		this.formulirKonselingTesHiv = null;
	}

	/**
	 * Similar to {@link this#setHemodialysisExamination(HemodialysisExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setHemodialysisExamination(@NonNull HemodialysisExaminationEntity entity) {
		setHemodialysisExamination(entity, true);
	}

	/**
	 * Set or update hemodialysisExamination with the given HemodialysisExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setHemodialysisExamination(@NonNull HemodialysisExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] end

		if (sameAsFormer(this.hemodialysisExamination, entity)) {
			return;
		}

		if (this.hemodialysisExamination != null) {
			this.hemodialysisExamination.unsetMedicalExaminationRecord();
		}

		this.hemodialysisExamination = entity;

		if (reverseAdd) {
			this.hemodialysisExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetHemodialysisExamination(boolean)} but default to true.
	 */
	public void unsetHemodialysisExamination() {
		this.unsetHemodialysisExamination(true);
	}

	/**
	 * Remove the HemodialysisExaminationEntity in Hemodialysis Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetHemodialysisExamination(boolean reverse) {
		if (reverse && this.hemodialysisExamination != null) {
			this.hemodialysisExamination.unsetMedicalExaminationRecord(false);
		}
		this.hemodialysisExamination = null;
	}

	/**
	 * Similar to {@link this#setMedicalExaminationRecordDischargeSummary(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		setMedicalExaminationRecordDischargeSummary(entity, true);
	}

	/**
	 * Set or update medicalExaminationRecordDischargeSummary with the given MedicalExaminationRecordDischargeSummaryEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] end

		if (sameAsFormer(this.medicalExaminationRecordDischargeSummary, entity)) {
			return;
		}

		if (this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.unsetMedicalExaminationRecord();
		}

		this.medicalExaminationRecordDischargeSummary = entity;

		if (reverseAdd) {
			this.medicalExaminationRecordDischargeSummary.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecordDischargeSummary(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecordDischargeSummary() {
		this.unsetMedicalExaminationRecordDischargeSummary(true);
	}

	/**
	 * Remove the MedicalExaminationRecordDischargeSummaryEntity in Medical Examination Record Discharge Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecordDischargeSummary(boolean reverse) {
		if (reverse && this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.unsetMedicalExaminationRecord(false);
		}
		this.medicalExaminationRecordDischargeSummary = null;
	}

	/**
	 * Similar to {@link this#setMedicalRecordInitialChecklist(MedicalRecordInitialChecklistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalRecordInitialChecklist(@NonNull MedicalRecordInitialChecklistEntity entity) {
		setMedicalRecordInitialChecklist(entity, true);
	}

	/**
	 * Set or update medicalRecordInitialChecklist with the given MedicalRecordInitialChecklistEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalRecordInitialChecklist(@NonNull MedicalRecordInitialChecklistEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordInitialChecklist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordInitialChecklist here] end

		if (sameAsFormer(this.medicalRecordInitialChecklist, entity)) {
			return;
		}

		if (this.medicalRecordInitialChecklist != null) {
			this.medicalRecordInitialChecklist.unsetMedicalExaminationRecord();
		}

		this.medicalRecordInitialChecklist = entity;

		if (reverseAdd) {
			this.medicalRecordInitialChecklist.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordInitialChecklist outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordInitialChecklist outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordInitialChecklist(boolean)} but default to true.
	 */
	public void unsetMedicalRecordInitialChecklist() {
		this.unsetMedicalRecordInitialChecklist(true);
	}

	/**
	 * Remove the MedicalRecordInitialChecklistEntity in Medical Record Initial Checklist from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalRecordInitialChecklist(boolean reverse) {
		if (reverse && this.medicalRecordInitialChecklist != null) {
			this.medicalRecordInitialChecklist.unsetMedicalExaminationRecord(false);
		}
		this.medicalRecordInitialChecklist = null;
	}

	/**
	 * Similar to {@link this#setMedicalRecordNextVerificationChecklist(MedicalRecordNextVerificationChecklistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalRecordNextVerificationChecklist(@NonNull MedicalRecordNextVerificationChecklistEntity entity) {
		setMedicalRecordNextVerificationChecklist(entity, true);
	}

	/**
	 * Set or update medicalRecordNextVerificationChecklist with the given MedicalRecordNextVerificationChecklistEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalRecordNextVerificationChecklist(@NonNull MedicalRecordNextVerificationChecklistEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordNextVerificationChecklist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordNextVerificationChecklist here] end

		if (sameAsFormer(this.medicalRecordNextVerificationChecklist, entity)) {
			return;
		}

		if (this.medicalRecordNextVerificationChecklist != null) {
			this.medicalRecordNextVerificationChecklist.unsetMedicalExaminationRecord();
		}

		this.medicalRecordNextVerificationChecklist = entity;

		if (reverseAdd) {
			this.medicalRecordNextVerificationChecklist.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordNextVerificationChecklist outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordNextVerificationChecklist outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordNextVerificationChecklist(boolean)} but default to true.
	 */
	public void unsetMedicalRecordNextVerificationChecklist() {
		this.unsetMedicalRecordNextVerificationChecklist(true);
	}

	/**
	 * Remove the MedicalRecordNextVerificationChecklistEntity in Medical Record Next Verification Checklist from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalRecordNextVerificationChecklist(boolean reverse) {
		if (reverse && this.medicalRecordNextVerificationChecklist != null) {
			this.medicalRecordNextVerificationChecklist.unsetMedicalExaminationRecord(false);
		}
		this.medicalRecordNextVerificationChecklist = null;
	}

	/**
	 * Similar to {@link this#setNurseVitalSignMeasurement(NurseVitalSignMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNurseVitalSignMeasurement(@NonNull NurseVitalSignMeasurementEntity entity) {
		setNurseVitalSignMeasurement(entity, true);
	}

	/**
	 * Set or update nurseVitalSignMeasurement with the given NurseVitalSignMeasurementEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNurseVitalSignMeasurement(@NonNull NurseVitalSignMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNurseVitalSignMeasurement here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNurseVitalSignMeasurement here] end

		if (sameAsFormer(this.nurseVitalSignMeasurement, entity)) {
			return;
		}

		if (this.nurseVitalSignMeasurement != null) {
			this.nurseVitalSignMeasurement.unsetMedicalExaminationRecord();
		}

		this.nurseVitalSignMeasurement = entity;

		if (reverseAdd) {
			this.nurseVitalSignMeasurement.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNurseVitalSignMeasurement outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNurseVitalSignMeasurement outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetNurseVitalSignMeasurement(boolean)} but default to true.
	 */
	public void unsetNurseVitalSignMeasurement() {
		this.unsetNurseVitalSignMeasurement(true);
	}

	/**
	 * Remove the NurseVitalSignMeasurementEntity in Nurse Vital Sign Measurement from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNurseVitalSignMeasurement(boolean reverse) {
		if (reverse && this.nurseVitalSignMeasurement != null) {
			this.nurseVitalSignMeasurement.unsetMedicalExaminationRecord(false);
		}
		this.nurseVitalSignMeasurement = null;
	}

	/**
	 * Similar to {@link this#setObstetricAndGynecologyHistory(ObstetricAndGynecologyHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setObstetricAndGynecologyHistory(@NonNull ObstetricAndGynecologyHistoryEntity entity) {
		setObstetricAndGynecologyHistory(entity, true);
	}

	/**
	 * Set or update obstetricAndGynecologyHistory with the given ObstetricAndGynecologyHistoryEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setObstetricAndGynecologyHistory(@NonNull ObstetricAndGynecologyHistoryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setObstetricAndGynecologyHistory here] off begin
		// % protected region % [Add any additional logic here before the main logic for setObstetricAndGynecologyHistory here] end

		if (sameAsFormer(this.obstetricAndGynecologyHistory, entity)) {
			return;
		}

		if (this.obstetricAndGynecologyHistory != null) {
			this.obstetricAndGynecologyHistory.unsetMedicalExaminationRecord();
		}

		this.obstetricAndGynecologyHistory = entity;

		if (reverseAdd) {
			this.obstetricAndGynecologyHistory.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setObstetricAndGynecologyHistory outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setObstetricAndGynecologyHistory outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetObstetricAndGynecologyHistory(boolean)} but default to true.
	 */
	public void unsetObstetricAndGynecologyHistory() {
		this.unsetObstetricAndGynecologyHistory(true);
	}

	/**
	 * Remove the ObstetricAndGynecologyHistoryEntity in Obstetric And Gynecology History from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetObstetricAndGynecologyHistory(boolean reverse) {
		if (reverse && this.obstetricAndGynecologyHistory != null) {
			this.obstetricAndGynecologyHistory.unsetMedicalExaminationRecord(false);
		}
		this.obstetricAndGynecologyHistory = null;
	}

	/**
	 * Similar to {@link this#setOdontogramExamination(OdontogramExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOdontogramExamination(@NonNull OdontogramExaminationEntity entity) {
		setOdontogramExamination(entity, true);
	}

	/**
	 * Set or update odontogramExamination with the given OdontogramExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOdontogramExamination(@NonNull OdontogramExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOdontogramExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOdontogramExamination here] end

		if (sameAsFormer(this.odontogramExamination, entity)) {
			return;
		}

		if (this.odontogramExamination != null) {
			this.odontogramExamination.unsetMedicalExaminationRecord();
		}

		this.odontogramExamination = entity;

		if (reverseAdd) {
			this.odontogramExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOdontogramExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOdontogramExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOdontogramExamination(boolean)} but default to true.
	 */
	public void unsetOdontogramExamination() {
		this.unsetOdontogramExamination(true);
	}

	/**
	 * Remove the OdontogramExaminationEntity in Odontogram Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOdontogramExamination(boolean reverse) {
		if (reverse && this.odontogramExamination != null) {
			this.odontogramExamination.unsetMedicalExaminationRecord(false);
		}
		this.odontogramExamination = null;
	}

	/**
	 * Similar to {@link this#setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		setOperatingTheaterMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update operatingTheaterMedicalExaminationRecord with the given OperatingTheaterMedicalExaminationRecordEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] end

		if (sameAsFormer(this.operatingTheaterMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetMedicalExaminationRecord();
		}

		this.operatingTheaterMedicalExaminationRecord = entity;

		if (reverseAdd) {
			this.operatingTheaterMedicalExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOperatingTheaterMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord() {
		this.unsetOperatingTheaterMedicalExaminationRecord(true);
	}

	/**
	 * Remove the OperatingTheaterMedicalExaminationRecordEntity in Operating Theater Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetMedicalExaminationRecord(false);
		}
		this.operatingTheaterMedicalExaminationRecord = null;
	}

	/**
	 * Similar to {@link this#setOphthalmologyExamination(OphthalmologyExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOphthalmologyExamination(@NonNull OphthalmologyExaminationEntity entity) {
		setOphthalmologyExamination(entity, true);
	}

	/**
	 * Set or update ophthalmologyExamination with the given OphthalmologyExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOphthalmologyExamination(@NonNull OphthalmologyExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOphthalmologyExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOphthalmologyExamination here] end

		if (sameAsFormer(this.ophthalmologyExamination, entity)) {
			return;
		}

		if (this.ophthalmologyExamination != null) {
			this.ophthalmologyExamination.unsetMedicalExaminationRecord();
		}

		this.ophthalmologyExamination = entity;

		if (reverseAdd) {
			this.ophthalmologyExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOphthalmologyExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOphthalmologyExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOphthalmologyExamination(boolean)} but default to true.
	 */
	public void unsetOphthalmologyExamination() {
		this.unsetOphthalmologyExamination(true);
	}

	/**
	 * Remove the OphthalmologyExaminationEntity in Ophthalmology Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOphthalmologyExamination(boolean reverse) {
		if (reverse && this.ophthalmologyExamination != null) {
			this.ophthalmologyExamination.unsetMedicalExaminationRecord(false);
		}
		this.ophthalmologyExamination = null;
	}

/**
	 * Similar to {@link this#addRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity) {
		addRoomTransfers(entity, true);
	}

	/**
	 * Add a new RoomTransferEntity to roomTransfers in this entity.
	 *
	 * @param entity the given RoomTransferEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverseAdd) {
		if (!this.roomTransfers.contains(entity)) {
			roomTransfers.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		addRoomTransfers(entities, true);
	}

	/**
	 * Add a new collection of RoomTransferEntity to Room Transfers in this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be set to this entity
	 */
	public void removeRoomTransfers(@NonNull RoomTransferEntity entity) {
		this.removeRoomTransfers(entity, true);
	}

	/**
	 * Remove the given RoomTransferEntity from this entity.
	 *
	 * @param entity the given RoomTransferEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.roomTransfers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		this.removeRoomTransfers(entities, true);
	}

	/**
	 * Remove the given collection of RoomTransferEntity from  to this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be set to this entity
	 */
	public void setRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		setRoomTransfers(entities, true);
	}

	/**
	 * Replace the current entities in Room Transfers with the given ones.
	 *
	 * @param entities the given collection of RoomTransferEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {

		this.unsetRoomTransfers();
		this.roomTransfers = new HashSet<>(entities);
		if (reverseAdd) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRoomTransfers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRoomTransfers() {
		this.unsetRoomTransfers(true);
	}

	/**
	 * Remove all the entities in Room Transfers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRoomTransfers(boolean doReverse) {
		if (doReverse) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.unsetMedicalExaminationRecord(false));
		}
		this.roomTransfers.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDoctor(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDoctor(@NonNull StaffEntity entity) {
		setDoctor(entity, true);
	}

	/**
	 * Set or update the doctor in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to doctor
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDoctor(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDoctor here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDoctor here] end

		if (sameAsFormer(this.doctor, entity)) {
			return;
		}

		if (this.doctor != null) {
			this.doctor.removeDoctorOnExamination(this, false);
		}
		this.doctor = entity;
		if (reverseAdd) {
			this.doctor.addDoctorOnExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDoctor incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDoctor incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDoctor(boolean)} but default to true.
	 */
	public void unsetDoctor() {
		this.unsetDoctor(true);
	}

	/**
	 * Remove Doctor in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDoctor(boolean reverse) {
		if (reverse && this.doctor != null) {
			this.doctor.removeDoctorOnExamination(this, false);
		}
		this.doctor = null;
	}
	/**
	 * Similar to {@link this#setInpatientMedicalExaminationRecord(InpatientMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setInpatientMedicalExaminationRecord(InpatientMedicalExaminationRecordEntity entity) {
		setInpatientMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the inpatientMedicalExaminationRecord in this entity with single InpatientMedicalExaminationRecordEntity.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set or updated to inpatientMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInpatientMedicalExaminationRecord(InpatientMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInpatientMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInpatientMedicalExaminationRecord here] end

		if (sameAsFormer(this.inpatientMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.inpatientMedicalExaminationRecord != null) {
			this.inpatientMedicalExaminationRecord.unsetMedicalExaminationRecord(false);
		}

		this.inpatientMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.inpatientMedicalExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInpatientMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInpatientMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInpatientMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetInpatientMedicalExaminationRecord() {
		this.unsetInpatientMedicalExaminationRecord(true);
	}

	/**
	 * Remove the InpatientMedicalExaminationRecordEntity of inpatientMedicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInpatientMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.inpatientMedicalExaminationRecord != null) {
			this.inpatientMedicalExaminationRecord.unsetMedicalExaminationRecord();
		}
		this.inpatientMedicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetMedicalExaminationRecord(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetMedicalExaminationRecord();
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalTranscriber(@NonNull StaffEntity entity) {
		setMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the medicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalTranscriber(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] end

		if (sameAsFormer(this.medicalTranscriber, entity)) {
			return;
		}

		if (this.medicalTranscriber != null) {
			this.medicalTranscriber.removeMedicalRecordTranscriber(this, false);
		}
		this.medicalTranscriber = entity;
		if (reverseAdd) {
			this.medicalTranscriber.addMedicalRecordTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetMedicalTranscriber() {
		this.unsetMedicalTranscriber(true);
	}

	/**
	 * Remove Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalTranscriber(boolean reverse) {
		if (reverse && this.medicalTranscriber != null) {
			this.medicalTranscriber.removeMedicalRecordTranscriber(this, false);
		}
		this.medicalTranscriber = null;
	}
	/**
	 * Similar to {@link this#setNurse(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setNurse(@NonNull StaffEntity entity) {
		setNurse(entity, true);
	}

	/**
	 * Set or update the nurse in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to nurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNurse(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNurse here] end

		if (sameAsFormer(this.nurse, entity)) {
			return;
		}

		if (this.nurse != null) {
			this.nurse.removeNurse(this, false);
		}
		this.nurse = entity;
		if (reverseAdd) {
			this.nurse.addNurse(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNurse(boolean)} but default to true.
	 */
	public void unsetNurse() {
		this.unsetNurse(true);
	}

	/**
	 * Remove Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNurse(boolean reverse) {
		if (reverse && this.nurse != null) {
			this.nurse.removeNurse(this, false);
		}
		this.nurse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
