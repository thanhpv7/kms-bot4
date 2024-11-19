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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.services.MedicalExaminationRecordService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.AmendmentDetailService;
import kmsweb.entities.AmendmentDetailEntity;
import kmsweb.services.BirthHistoryService;
import kmsweb.entities.BirthHistoryEntity;
import kmsweb.services.BodyChartExaminationService;
import kmsweb.entities.BodyChartExaminationEntity;
import kmsweb.services.CoTreatingDoctorService;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.services.DailyCareCPPTService;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.services.DeliveryMedicalExaminationRecordService;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.services.DiagnosisExaminationRecordService;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.services.DiagnosisNandaService;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.services.EntExaminationService;
import kmsweb.entities.EntExaminationEntity;
import kmsweb.services.EmergencyMedicalExaminationRecordService;
import kmsweb.entities.EmergencyMedicalExaminationRecordEntity;
import kmsweb.services.FormulirKonselingTesHivService;
import kmsweb.entities.FormulirKonselingTesHivEntity;
import kmsweb.services.HemodialysisExaminationService;
import kmsweb.entities.HemodialysisExaminationEntity;
import kmsweb.services.InpatientMedicalExaminationRecordService;
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import kmsweb.services.MedicalExaminationRecordDischargeSummaryService;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.services.MedicalRecordInitialChecklistService;
import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import kmsweb.services.MedicalRecordNextVerificationChecklistService;
import kmsweb.entities.MedicalRecordNextVerificationChecklistEntity;
import kmsweb.services.NurseVitalSignMeasurementService;
import kmsweb.entities.NurseVitalSignMeasurementEntity;
import kmsweb.services.ObstetricAndGynecologyHistoryService;
import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;
import kmsweb.services.OdontogramExaminationService;
import kmsweb.entities.OdontogramExaminationEntity;
import kmsweb.services.OperatingTheaterMedicalExaminationRecordService;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.services.OphthalmologyExaminationService;
import kmsweb.entities.OphthalmologyExaminationEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.RoomTransferService;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class MedicalExaminationRecordMutationResolver implements GraphQLMutationResolver {

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final AmendmentDetailService amendmentDetailService;

	private final BirthHistoryService birthHistoryService;

	private final BodyChartExaminationService bodyChartExaminationService;

	private final CoTreatingDoctorService coTreatingDoctorService;

	private final DailyCareCPPTService dailyCareCPPTService;

	private final DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final DiagnosisExaminationRecordService diagnosisExaminationRecordService;

	private final DiagnosisNandaService diagnosisNandaService;

	private final EntExaminationService entExaminationService;

	private final EmergencyMedicalExaminationRecordService emergencyMedicalExaminationRecordService;

	private final FormulirKonselingTesHivService formulirKonselingTesHivService;

	private final HemodialysisExaminationService hemodialysisExaminationService;

	private final InpatientMedicalExaminationRecordService inpatientMedicalExaminationRecordService;

	private final MedicalExaminationRecordDischargeSummaryService medicalExaminationRecordDischargeSummaryService;

	private final MedicalRecordInitialChecklistService medicalRecordInitialChecklistService;

	private final MedicalRecordNextVerificationChecklistService medicalRecordNextVerificationChecklistService;

	private final NurseVitalSignMeasurementService nurseVitalSignMeasurementService;

	private final ObstetricAndGynecologyHistoryService obstetricAndGynecologyHistoryService;

	private final OdontogramExaminationService odontogramExaminationService;

	private final OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	private final OphthalmologyExaminationService ophthalmologyExaminationService;

	private final RegistrationService registrationService;

	private final RoomTransferService roomTransferService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicalExaminationRecordMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			AmendmentDetailService amendmentDetailService,
			BirthHistoryService birthHistoryService,
			BodyChartExaminationService bodyChartExaminationService,
			CoTreatingDoctorService coTreatingDoctorService,
			DailyCareCPPTService dailyCareCPPTService,
			DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService,
			DiagnosisExaminationRecordService diagnosisExaminationRecordService,
			DiagnosisNandaService diagnosisNandaService,
			EntExaminationService entExaminationService,
			EmergencyMedicalExaminationRecordService emergencyMedicalExaminationRecordService,
			FormulirKonselingTesHivService formulirKonselingTesHivService,
			HemodialysisExaminationService hemodialysisExaminationService,
			InpatientMedicalExaminationRecordService inpatientMedicalExaminationRecordService,
			MedicalExaminationRecordDischargeSummaryService medicalExaminationRecordDischargeSummaryService,
			MedicalRecordInitialChecklistService medicalRecordInitialChecklistService,
			MedicalRecordNextVerificationChecklistService medicalRecordNextVerificationChecklistService,
			NurseVitalSignMeasurementService nurseVitalSignMeasurementService,
			ObstetricAndGynecologyHistoryService obstetricAndGynecologyHistoryService,
			OdontogramExaminationService odontogramExaminationService,
			OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService,
			OphthalmologyExaminationService ophthalmologyExaminationService,
			RegistrationService registrationService,
			RoomTransferService roomTransferService,
			StaffService staffService,
			MedicalExaminationRecordService medicalExaminationRecordService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		this.amendmentDetailService = amendmentDetailService;

		this.birthHistoryService = birthHistoryService;

		this.bodyChartExaminationService = bodyChartExaminationService;

		this.coTreatingDoctorService = coTreatingDoctorService;

		this.dailyCareCPPTService = dailyCareCPPTService;

		this.deliveryMedicalExaminationRecordService = deliveryMedicalExaminationRecordService;

		this.diagnosisExaminationRecordService = diagnosisExaminationRecordService;

		this.diagnosisNandaService = diagnosisNandaService;

		this.entExaminationService = entExaminationService;

		this.emergencyMedicalExaminationRecordService = emergencyMedicalExaminationRecordService;

		this.formulirKonselingTesHivService = formulirKonselingTesHivService;

		this.hemodialysisExaminationService = hemodialysisExaminationService;

		this.inpatientMedicalExaminationRecordService = inpatientMedicalExaminationRecordService;

		this.medicalExaminationRecordDischargeSummaryService = medicalExaminationRecordDischargeSummaryService;

		this.medicalRecordInitialChecklistService = medicalRecordInitialChecklistService;

		this.medicalRecordNextVerificationChecklistService = medicalRecordNextVerificationChecklistService;

		this.nurseVitalSignMeasurementService = nurseVitalSignMeasurementService;

		this.obstetricAndGynecologyHistoryService = obstetricAndGynecologyHistoryService;

		this.odontogramExaminationService = odontogramExaminationService;

		this.operatingTheaterMedicalExaminationRecordService = operatingTheaterMedicalExaminationRecordService;

		this.ophthalmologyExaminationService = ophthalmologyExaminationService;

		this.registrationService = registrationService;

		this.roomTransferService = roomTransferService;

		this.staffService = staffService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create')")
	public MedicalExaminationRecordEntity createMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInpatientMedicalExaminationRecord() != null) {
			rawEntity.setInpatientMedicalExaminationRecord(inpatientMedicalExaminationRecordService.updateOldData(rawEntity.getInpatientMedicalExaminationRecord()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getBirthHistory() != null) {
			rawEntity.setBirthHistory(birthHistoryService.updateOldData(rawEntity.getBirthHistory()));
		}

		if (rawEntity.getBodyChartExamination() != null) {
			rawEntity.setBodyChartExamination(bodyChartExaminationService.updateOldData(rawEntity.getBodyChartExamination()));
		}

		if (rawEntity.getDeliveryMedicalExaminationRecord() != null) {
			rawEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getDeliveryMedicalExaminationRecord()));
		}

		if (rawEntity.getEntExamination() != null) {
			rawEntity.setEntExamination(entExaminationService.updateOldData(rawEntity.getEntExamination()));
		}

		if (rawEntity.getEmergencyMedicationExaminationRecord() != null) {
			rawEntity.setEmergencyMedicationExaminationRecord(emergencyMedicalExaminationRecordService.updateOldData(rawEntity.getEmergencyMedicationExaminationRecord()));
		}

		if (rawEntity.getFormulirKonselingTesHiv() != null) {
			rawEntity.setFormulirKonselingTesHiv(formulirKonselingTesHivService.updateOldData(rawEntity.getFormulirKonselingTesHiv()));
		}

		if (rawEntity.getHemodialysisExamination() != null) {
			rawEntity.setHemodialysisExamination(hemodialysisExaminationService.updateOldData(rawEntity.getHemodialysisExamination()));
		}

		if (rawEntity.getMedicalExaminationRecordDischargeSummary() != null) {
			rawEntity.setMedicalExaminationRecordDischargeSummary(medicalExaminationRecordDischargeSummaryService.updateOldData(rawEntity.getMedicalExaminationRecordDischargeSummary()));
		}

		if (rawEntity.getMedicalRecordInitialChecklist() != null) {
			rawEntity.setMedicalRecordInitialChecklist(medicalRecordInitialChecklistService.updateOldData(rawEntity.getMedicalRecordInitialChecklist()));
		}

		if (rawEntity.getMedicalRecordNextVerificationChecklist() != null) {
			rawEntity.setMedicalRecordNextVerificationChecklist(medicalRecordNextVerificationChecklistService.updateOldData(rawEntity.getMedicalRecordNextVerificationChecklist()));
		}

		if (rawEntity.getNurseVitalSignMeasurement() != null) {
			rawEntity.setNurseVitalSignMeasurement(nurseVitalSignMeasurementService.updateOldData(rawEntity.getNurseVitalSignMeasurement()));
		}

		if (rawEntity.getObstetricAndGynecologyHistory() != null) {
			rawEntity.setObstetricAndGynecologyHistory(obstetricAndGynecologyHistoryService.updateOldData(rawEntity.getObstetricAndGynecologyHistory()));
		}

		if (rawEntity.getOdontogramExamination() != null) {
			rawEntity.setOdontogramExamination(odontogramExaminationService.updateOldData(rawEntity.getOdontogramExamination()));
		}

		if (rawEntity.getOperatingTheaterMedicalExaminationRecord() != null) {
			rawEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordService.updateOldData(rawEntity.getOperatingTheaterMedicalExaminationRecord()));
		}

		if (rawEntity.getOphthalmologyExamination() != null) {
			rawEntity.setOphthalmologyExamination(ophthalmologyExaminationService.updateOldData(rawEntity.getOphthalmologyExamination()));
		}

		if (rawEntity.getDoctor() != null) {
			rawEntity.setDoctor(staffService.updateOldData(rawEntity.getDoctor()));
		}

		if (rawEntity.getMedicalTranscriber() != null) {
			rawEntity.setMedicalTranscriber(staffService.updateOldData(rawEntity.getMedicalTranscriber()));
		}

		if (rawEntity.getNurse() != null) {
			rawEntity.setNurse(staffService.updateOldData(rawEntity.getNurse()));
		}

		Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();
		rawEntity.getAmendmentDetails().forEach(entity -> {
			amendmentDetails.add(amendmentDetailService.updateOldData(entity));
		});
		rawEntity.setAmendmentDetails(amendmentDetails);

		Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();
		rawEntity.getCoTreatingDoctors().forEach(entity -> {
			coTreatingDoctors.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingDoctors(coTreatingDoctors);

		Set<DailyCareCPPTEntity> dailyCareCPPTs = new HashSet<>();
		rawEntity.getDailyCareCPPTs().forEach(entity -> {
			dailyCareCPPTs.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTs(dailyCareCPPTs);

		Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();
		rawEntity.getDiagnosisExaminationRecords().forEach(entity -> {
			diagnosisExaminationRecords.add(diagnosisExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setDiagnosisExaminationRecords(diagnosisExaminationRecords);

		Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();
		rawEntity.getDiagnosisNandas().forEach(entity -> {
			diagnosisNandas.add(diagnosisNandaService.updateOldData(entity));
		});
		rawEntity.setDiagnosisNandas(diagnosisNandas);

		Set<RoomTransferEntity> roomTransfers = new HashSet<>();
		rawEntity.getRoomTransfers().forEach(entity -> {
			roomTransfers.add(roomTransferService.updateOldData(entity));
		});
		rawEntity.setRoomTransfers(roomTransfers);

		MedicalExaminationRecordEntity newEntity = medicalExaminationRecordService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link MedicalExaminationRecordMutationResolver#createMedicalExaminationRecord(MedicalExaminationRecordEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create')")
	public List<MedicalExaminationRecordEntity> createAllMedicalExaminationRecord(@NonNull List<MedicalExaminationRecordEntity> rawEntities) {
		List<MedicalExaminationRecordEntity> newEntities = Lists.newArrayList(medicalExaminationRecordService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'update')")
	public MedicalExaminationRecordEntity updateMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInpatientMedicalExaminationRecord() != null) {
			rawEntity.setInpatientMedicalExaminationRecord(inpatientMedicalExaminationRecordService.updateOldData(rawEntity.getInpatientMedicalExaminationRecord()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getBirthHistory() != null) {
			rawEntity.setBirthHistory(birthHistoryService.updateOldData(rawEntity.getBirthHistory()));
		}

		if (rawEntity.getBodyChartExamination() != null) {
			rawEntity.setBodyChartExamination(bodyChartExaminationService.updateOldData(rawEntity.getBodyChartExamination()));
		}

		if (rawEntity.getDeliveryMedicalExaminationRecord() != null) {
			rawEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getDeliveryMedicalExaminationRecord()));
		}

		if (rawEntity.getEntExamination() != null) {
			rawEntity.setEntExamination(entExaminationService.updateOldData(rawEntity.getEntExamination()));
		}

		if (rawEntity.getEmergencyMedicationExaminationRecord() != null) {
			rawEntity.setEmergencyMedicationExaminationRecord(emergencyMedicalExaminationRecordService.updateOldData(rawEntity.getEmergencyMedicationExaminationRecord()));
		}

		if (rawEntity.getFormulirKonselingTesHiv() != null) {
			rawEntity.setFormulirKonselingTesHiv(formulirKonselingTesHivService.updateOldData(rawEntity.getFormulirKonselingTesHiv()));
		}

		if (rawEntity.getHemodialysisExamination() != null) {
			rawEntity.setHemodialysisExamination(hemodialysisExaminationService.updateOldData(rawEntity.getHemodialysisExamination()));
		}

		if (rawEntity.getMedicalExaminationRecordDischargeSummary() != null) {
			rawEntity.setMedicalExaminationRecordDischargeSummary(medicalExaminationRecordDischargeSummaryService.updateOldData(rawEntity.getMedicalExaminationRecordDischargeSummary()));
		}

		if (rawEntity.getMedicalRecordInitialChecklist() != null) {
			rawEntity.setMedicalRecordInitialChecklist(medicalRecordInitialChecklistService.updateOldData(rawEntity.getMedicalRecordInitialChecklist()));
		}

		if (rawEntity.getMedicalRecordNextVerificationChecklist() != null) {
			rawEntity.setMedicalRecordNextVerificationChecklist(medicalRecordNextVerificationChecklistService.updateOldData(rawEntity.getMedicalRecordNextVerificationChecklist()));
		}

		if (rawEntity.getNurseVitalSignMeasurement() != null) {
			rawEntity.setNurseVitalSignMeasurement(nurseVitalSignMeasurementService.updateOldData(rawEntity.getNurseVitalSignMeasurement()));
		}

		if (rawEntity.getObstetricAndGynecologyHistory() != null) {
			rawEntity.setObstetricAndGynecologyHistory(obstetricAndGynecologyHistoryService.updateOldData(rawEntity.getObstetricAndGynecologyHistory()));
		}

		if (rawEntity.getOdontogramExamination() != null) {
			rawEntity.setOdontogramExamination(odontogramExaminationService.updateOldData(rawEntity.getOdontogramExamination()));
		}

		if (rawEntity.getOperatingTheaterMedicalExaminationRecord() != null) {
			rawEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordService.updateOldData(rawEntity.getOperatingTheaterMedicalExaminationRecord()));
		}

		if (rawEntity.getOphthalmologyExamination() != null) {
			rawEntity.setOphthalmologyExamination(ophthalmologyExaminationService.updateOldData(rawEntity.getOphthalmologyExamination()));
		}

		if (rawEntity.getDoctor() != null) {
			rawEntity.setDoctor(staffService.updateOldData(rawEntity.getDoctor()));
		}

		if (rawEntity.getMedicalTranscriber() != null) {
			rawEntity.setMedicalTranscriber(staffService.updateOldData(rawEntity.getMedicalTranscriber()));
		}

		if (rawEntity.getNurse() != null) {
			rawEntity.setNurse(staffService.updateOldData(rawEntity.getNurse()));
		}

		Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();
		rawEntity.getAmendmentDetails().forEach(entity -> {
			amendmentDetails.add(amendmentDetailService.updateOldData(entity));
		});
		rawEntity.setAmendmentDetails(amendmentDetails);

		Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();
		rawEntity.getCoTreatingDoctors().forEach(entity -> {
			coTreatingDoctors.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingDoctors(coTreatingDoctors);

		Set<DailyCareCPPTEntity> dailyCareCPPTs = new HashSet<>();
		rawEntity.getDailyCareCPPTs().forEach(entity -> {
			dailyCareCPPTs.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTs(dailyCareCPPTs);

		Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();
		rawEntity.getDiagnosisExaminationRecords().forEach(entity -> {
			diagnosisExaminationRecords.add(diagnosisExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setDiagnosisExaminationRecords(diagnosisExaminationRecords);

		Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();
		rawEntity.getDiagnosisNandas().forEach(entity -> {
			diagnosisNandas.add(diagnosisNandaService.updateOldData(entity));
		});
		rawEntity.setDiagnosisNandas(diagnosisNandas);

		Set<RoomTransferEntity> roomTransfers = new HashSet<>();
		rawEntity.getRoomTransfers().forEach(entity -> {
			roomTransfers.add(roomTransferService.updateOldData(entity));
		});
		rawEntity.setRoomTransfers(roomTransfers);

		MedicalExaminationRecordEntity entityFromDb = medicalExaminationRecordService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		MedicalExaminationRecordEntity newEntity = medicalExaminationRecordService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link MedicalExaminationRecordMutationResolver#updateMedicalExaminationRecord(MedicalExaminationRecordEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'update')")
	public List<MedicalExaminationRecordEntity> updateAllMedicalExaminationRecord(@NonNull List<MedicalExaminationRecordEntity> rawEntities) {
		List<MedicalExaminationRecordEntity> newEntities = Lists.newArrayList(medicalExaminationRecordService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'delete')")
	public String deleteMedicalExaminationRecordById(@NonNull String id) {
		medicalExaminationRecordService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link MedicalExaminationRecordMutationResolver#deleteMedicalExaminationRecordById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'delete')")
	public List<String> deleteAllMedicalExaminationRecordByIds(@NonNull List<String> ids) {
		medicalExaminationRecordService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'delete')")
	public List<String> deleteMedicalExaminationRecordExcludingIds(@NonNull List<String> ids) {
		medicalExaminationRecordService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
