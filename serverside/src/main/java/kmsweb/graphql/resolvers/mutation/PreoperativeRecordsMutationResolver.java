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
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.services.PreoperativeRecordsService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BedFacilityService;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.services.CoTreatingDoctorService;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.services.DiagnosesAndProceduresService;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.services.OperatingTheaterMedicalExaminationRecordService;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.services.RoomFacilityService;
import kmsweb.entities.RoomFacilityEntity;
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
public class PreoperativeRecordsMutationResolver implements GraphQLMutationResolver {

	private final PreoperativeRecordsService preoperativeRecordsService;

	private final BedFacilityService bedFacilityService;

	private final CoTreatingDoctorService coTreatingDoctorService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;

	private final OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	private final RoomFacilityService roomFacilityService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PreoperativeRecordsMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BedFacilityService bedFacilityService,
			CoTreatingDoctorService coTreatingDoctorService,
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService,
			RoomFacilityService roomFacilityService,
			StaffService staffService,
			PreoperativeRecordsService preoperativeRecordsService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.preoperativeRecordsService = preoperativeRecordsService;

		this.bedFacilityService = bedFacilityService;

		this.coTreatingDoctorService = coTreatingDoctorService;

		this.diagnosesAndProceduresService = diagnosesAndProceduresService;

		this.operatingTheaterMedicalExaminationRecordService = operatingTheaterMedicalExaminationRecordService;

		this.roomFacilityService = roomFacilityService;

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create')")
	public PreoperativeRecordsEntity createPreoperativeRecords(@NonNull PreoperativeRecordsEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getOperatingTheaterMedicalExaminationRecord() != null) {
			rawEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordService.updateOldData(rawEntity.getOperatingTheaterMedicalExaminationRecord()));
		}

		if (rawEntity.getAnesthesiaMedicalTranscriber() != null) {
			rawEntity.setAnesthesiaMedicalTranscriber(staffService.updateOldData(rawEntity.getAnesthesiaMedicalTranscriber()));
		}

		if (rawEntity.getAnesthesiologist() != null) {
			rawEntity.setAnesthesiologist(staffService.updateOldData(rawEntity.getAnesthesiologist()));
		}

		if (rawEntity.getAnesthesiologyNurse() != null) {
			rawEntity.setAnesthesiologyNurse(staffService.updateOldData(rawEntity.getAnesthesiologyNurse()));
		}

		if (rawEntity.getPreSurgeryICD10() != null) {
			rawEntity.setPreSurgeryICD10(diagnosesAndProceduresService.updateOldData(rawEntity.getPreSurgeryICD10()));
		}

		if (rawEntity.getPreSurgeryICD9CM() != null) {
			rawEntity.setPreSurgeryICD9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getPreSurgeryICD9CM()));
		}

		if (rawEntity.getPreoperativeRooms() != null) {
			rawEntity.setPreoperativeRooms(roomFacilityService.updateOldData(rawEntity.getPreoperativeRooms()));
		}

		if (rawEntity.getSurgeon() != null) {
			rawEntity.setSurgeon(staffService.updateOldData(rawEntity.getSurgeon()));
		}

		if (rawEntity.getSurgicalMedicalTranscriber() != null) {
			rawEntity.setSurgicalMedicalTranscriber(staffService.updateOldData(rawEntity.getSurgicalMedicalTranscriber()));
		}

		if (rawEntity.getSurgicalNurse() != null) {
			rawEntity.setSurgicalNurse(staffService.updateOldData(rawEntity.getSurgicalNurse()));
		}

		Set<CoTreatingDoctorEntity> additionalAnesthesiologists = new HashSet<>();
		rawEntity.getAdditionalAnesthesiologists().forEach(entity -> {
			additionalAnesthesiologists.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setAdditionalAnesthesiologists(additionalAnesthesiologists);

		Set<CoTreatingDoctorEntity> additionalSurgeryNurses = new HashSet<>();
		rawEntity.getAdditionalSurgeryNurses().forEach(entity -> {
			additionalSurgeryNurses.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setAdditionalSurgeryNurses(additionalSurgeryNurses);

		Set<BedFacilityEntity> bedFacilities = new HashSet<>();
		rawEntity.getBedFacilities().forEach(entity -> {
			bedFacilities.add(bedFacilityService.updateOldData(entity));
		});
		rawEntity.setBedFacilities(bedFacilities);

		Set<CoTreatingDoctorEntity> coTreatingAnesthesiologists = new HashSet<>();
		rawEntity.getCoTreatingAnesthesiologists().forEach(entity -> {
			coTreatingAnesthesiologists.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingAnesthesiologists(coTreatingAnesthesiologists);

		Set<CoTreatingDoctorEntity> coTreatingSurgeons = new HashSet<>();
		rawEntity.getCoTreatingSurgeons().forEach(entity -> {
			coTreatingSurgeons.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingSurgeons(coTreatingSurgeons);

		PreoperativeRecordsEntity newEntity = preoperativeRecordsService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PreoperativeRecordsMutationResolver#createPreoperativeRecords(PreoperativeRecordsEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create')")
	public List<PreoperativeRecordsEntity> createAllPreoperativeRecords(@NonNull List<PreoperativeRecordsEntity> rawEntities) {
		List<PreoperativeRecordsEntity> newEntities = Lists.newArrayList(preoperativeRecordsService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'update')")
	public PreoperativeRecordsEntity updatePreoperativeRecords(@NonNull PreoperativeRecordsEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getOperatingTheaterMedicalExaminationRecord() != null) {
			rawEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordService.updateOldData(rawEntity.getOperatingTheaterMedicalExaminationRecord()));
		}

		if (rawEntity.getAnesthesiaMedicalTranscriber() != null) {
			rawEntity.setAnesthesiaMedicalTranscriber(staffService.updateOldData(rawEntity.getAnesthesiaMedicalTranscriber()));
		}

		if (rawEntity.getAnesthesiologist() != null) {
			rawEntity.setAnesthesiologist(staffService.updateOldData(rawEntity.getAnesthesiologist()));
		}

		if (rawEntity.getAnesthesiologyNurse() != null) {
			rawEntity.setAnesthesiologyNurse(staffService.updateOldData(rawEntity.getAnesthesiologyNurse()));
		}

		if (rawEntity.getPreSurgeryICD10() != null) {
			rawEntity.setPreSurgeryICD10(diagnosesAndProceduresService.updateOldData(rawEntity.getPreSurgeryICD10()));
		}

		if (rawEntity.getPreSurgeryICD9CM() != null) {
			rawEntity.setPreSurgeryICD9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getPreSurgeryICD9CM()));
		}

		if (rawEntity.getPreoperativeRooms() != null) {
			rawEntity.setPreoperativeRooms(roomFacilityService.updateOldData(rawEntity.getPreoperativeRooms()));
		}

		if (rawEntity.getSurgeon() != null) {
			rawEntity.setSurgeon(staffService.updateOldData(rawEntity.getSurgeon()));
		}

		if (rawEntity.getSurgicalMedicalTranscriber() != null) {
			rawEntity.setSurgicalMedicalTranscriber(staffService.updateOldData(rawEntity.getSurgicalMedicalTranscriber()));
		}

		if (rawEntity.getSurgicalNurse() != null) {
			rawEntity.setSurgicalNurse(staffService.updateOldData(rawEntity.getSurgicalNurse()));
		}

		Set<CoTreatingDoctorEntity> additionalAnesthesiologists = new HashSet<>();
		rawEntity.getAdditionalAnesthesiologists().forEach(entity -> {
			additionalAnesthesiologists.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setAdditionalAnesthesiologists(additionalAnesthesiologists);

		Set<CoTreatingDoctorEntity> additionalSurgeryNurses = new HashSet<>();
		rawEntity.getAdditionalSurgeryNurses().forEach(entity -> {
			additionalSurgeryNurses.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setAdditionalSurgeryNurses(additionalSurgeryNurses);

		Set<BedFacilityEntity> bedFacilities = new HashSet<>();
		rawEntity.getBedFacilities().forEach(entity -> {
			bedFacilities.add(bedFacilityService.updateOldData(entity));
		});
		rawEntity.setBedFacilities(bedFacilities);

		Set<CoTreatingDoctorEntity> coTreatingAnesthesiologists = new HashSet<>();
		rawEntity.getCoTreatingAnesthesiologists().forEach(entity -> {
			coTreatingAnesthesiologists.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingAnesthesiologists(coTreatingAnesthesiologists);

		Set<CoTreatingDoctorEntity> coTreatingSurgeons = new HashSet<>();
		rawEntity.getCoTreatingSurgeons().forEach(entity -> {
			coTreatingSurgeons.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingSurgeons(coTreatingSurgeons);

		PreoperativeRecordsEntity entityFromDb = preoperativeRecordsService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PreoperativeRecordsEntity newEntity = preoperativeRecordsService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PreoperativeRecordsMutationResolver#updatePreoperativeRecords(PreoperativeRecordsEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'update')")
	public List<PreoperativeRecordsEntity> updateAllPreoperativeRecords(@NonNull List<PreoperativeRecordsEntity> rawEntities) {
		List<PreoperativeRecordsEntity> newEntities = Lists.newArrayList(preoperativeRecordsService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'delete')")
	public String deletePreoperativeRecordsById(@NonNull String id) {
		preoperativeRecordsService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PreoperativeRecordsMutationResolver#deletePreoperativeRecordsById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'delete')")
	public List<String> deleteAllPreoperativeRecordsByIds(@NonNull List<String> ids) {
		preoperativeRecordsService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'delete')")
	public List<String> deletePreoperativeRecordsExcludingIds(@NonNull List<String> ids) {
		preoperativeRecordsService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
