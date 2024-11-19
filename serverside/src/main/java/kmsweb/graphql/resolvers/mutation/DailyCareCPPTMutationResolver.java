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
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.services.DailyCareCPPTService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.DiagnosesAndProceduresService;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;
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
public class DailyCareCPPTMutationResolver implements GraphQLMutationResolver {

	private final DailyCareCPPTService dailyCareCPPTService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DailyCareCPPTMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			MedicalExaminationRecordService medicalExaminationRecordService,
			StaffService staffService,
			DailyCareCPPTService dailyCareCPPTService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.dailyCareCPPTService = dailyCareCPPTService;

		this.diagnosesAndProceduresService = diagnosesAndProceduresService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create')")
	public DailyCareCPPTEntity createDailyCareCPPT(@NonNull DailyCareCPPTEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getIcd10() != null) {
			rawEntity.setIcd10(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd10()));
		}

		if (rawEntity.getIcd9CM() != null) {
			rawEntity.setIcd9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd9CM()));
		}

		if (rawEntity.getCreatedByStaff() != null) {
			rawEntity.setCreatedByStaff(staffService.updateOldData(rawEntity.getCreatedByStaff()));
		}

		if (rawEntity.getDoctorInCharge() != null) {
			rawEntity.setDoctorInCharge(staffService.updateOldData(rawEntity.getDoctorInCharge()));
		}

		if (rawEntity.getMedicalTranscriber() != null) {
			rawEntity.setMedicalTranscriber(staffService.updateOldData(rawEntity.getMedicalTranscriber()));
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		DailyCareCPPTEntity newEntity = dailyCareCPPTService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DailyCareCPPTMutationResolver#createDailyCareCPPT(DailyCareCPPTEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create')")
	public List<DailyCareCPPTEntity> createAllDailyCareCPPT(@NonNull List<DailyCareCPPTEntity> rawEntities) {
		List<DailyCareCPPTEntity> newEntities = Lists.newArrayList(dailyCareCPPTService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'update')")
	public DailyCareCPPTEntity updateDailyCareCPPT(@NonNull DailyCareCPPTEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getIcd10() != null) {
			rawEntity.setIcd10(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd10()));
		}

		if (rawEntity.getIcd9CM() != null) {
			rawEntity.setIcd9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getIcd9CM()));
		}

		if (rawEntity.getCreatedByStaff() != null) {
			rawEntity.setCreatedByStaff(staffService.updateOldData(rawEntity.getCreatedByStaff()));
		}

		if (rawEntity.getDoctorInCharge() != null) {
			rawEntity.setDoctorInCharge(staffService.updateOldData(rawEntity.getDoctorInCharge()));
		}

		if (rawEntity.getMedicalTranscriber() != null) {
			rawEntity.setMedicalTranscriber(staffService.updateOldData(rawEntity.getMedicalTranscriber()));
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		DailyCareCPPTEntity entityFromDb = dailyCareCPPTService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		DailyCareCPPTEntity newEntity = dailyCareCPPTService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DailyCareCPPTMutationResolver#updateDailyCareCPPT(DailyCareCPPTEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'update')")
	public List<DailyCareCPPTEntity> updateAllDailyCareCPPT(@NonNull List<DailyCareCPPTEntity> rawEntities) {
		List<DailyCareCPPTEntity> newEntities = Lists.newArrayList(dailyCareCPPTService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'delete')")
	public String deleteDailyCareCPPTById(@NonNull String id) {
		dailyCareCPPTService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link DailyCareCPPTMutationResolver#deleteDailyCareCPPTById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'delete')")
	public List<String> deleteAllDailyCareCPPTByIds(@NonNull List<String> ids) {
		dailyCareCPPTService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'delete')")
	public List<String> deleteDailyCareCPPTExcludingIds(@NonNull List<String> ids) {
		dailyCareCPPTService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
