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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class MedicalExaminationRecordResolver implements GraphQLResolver<MedicalExaminationRecordEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('AmendmentDetailEntity', 'read')")
	public Set<AmendmentDetailEntity> amendmentDetails(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getAmendmentDetails();
	}

	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	public BirthHistoryEntity birthHistory(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getBirthHistory();
	}

	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	public BodyChartExaminationEntity bodyChartExamination(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getBodyChartExamination();
	}

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public Set<CoTreatingDoctorEntity> coTreatingDoctors(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getCoTreatingDoctors();
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public Set<DailyCareCPPTEntity> dailyCareCPPTs(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getDailyCareCPPTs();
	}

	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	public DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getDeliveryMedicalExaminationRecord();
	}

	@PreAuthorize("hasPermission('DiagnosisExaminationRecordEntity', 'read')")
	public Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getDiagnosisExaminationRecords();
	}

	@PreAuthorize("hasPermission('DiagnosisNandaEntity', 'read')")
	public Set<DiagnosisNandaEntity> diagnosisNandas(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getDiagnosisNandas();
	}

	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	public EntExaminationEntity entExamination(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getEntExamination();
	}

	@PreAuthorize("hasPermission('EmergencyMedicalExaminationRecordEntity', 'read')")
	public EmergencyMedicalExaminationRecordEntity emergencyMedicationExaminationRecord(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getEmergencyMedicationExaminationRecord();
	}

	@PreAuthorize("hasPermission('FormulirKonselingTesHivEntity', 'read')")
	public FormulirKonselingTesHivEntity formulirKonselingTesHiv(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getFormulirKonselingTesHiv();
	}

	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	public HemodialysisExaminationEntity hemodialysisExamination(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getHemodialysisExamination();
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordDischargeSummaryEntity', 'read')")
	public MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummary(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getMedicalExaminationRecordDischargeSummary();
	}

	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	public MedicalRecordInitialChecklistEntity medicalRecordInitialChecklist(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getMedicalRecordInitialChecklist();
	}

	@PreAuthorize("hasPermission('MedicalRecordNextVerificationChecklistEntity', 'read')")
	public MedicalRecordNextVerificationChecklistEntity medicalRecordNextVerificationChecklist(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getMedicalRecordNextVerificationChecklist();
	}

	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	public NurseVitalSignMeasurementEntity nurseVitalSignMeasurement(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getNurseVitalSignMeasurement();
	}

	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	public ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistory(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getObstetricAndGynecologyHistory();
	}

	@PreAuthorize("hasPermission('OdontogramExaminationEntity', 'read')")
	public OdontogramExaminationEntity odontogramExamination(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getOdontogramExamination();
	}

	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	public OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getOperatingTheaterMedicalExaminationRecord();
	}

	@PreAuthorize("hasPermission('OphthalmologyExaminationEntity', 'read')")
	public OphthalmologyExaminationEntity ophthalmologyExamination(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getOphthalmologyExamination();
	}

	@PreAuthorize("hasPermission('RoomTransferEntity', 'read')")
	public Set<RoomTransferEntity> roomTransfers(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getRoomTransfers();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity doctor(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getDoctor();
	}

	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	public InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecord(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getInpatientMedicalExaminationRecord();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public RegistrationEntity registration(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getRegistration();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity medicalTranscriber(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getMedicalTranscriber();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity nurse(MedicalExaminationRecordEntity medicalExaminationRecord) {
		return medicalExaminationRecord.getNurse();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
