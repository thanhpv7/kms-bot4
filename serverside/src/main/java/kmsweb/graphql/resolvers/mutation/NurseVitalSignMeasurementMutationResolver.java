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
import kmsweb.entities.NurseVitalSignMeasurementEntity;
import kmsweb.services.NurseVitalSignMeasurementService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class NurseVitalSignMeasurementMutationResolver implements GraphQLMutationResolver {

	private final NurseVitalSignMeasurementService nurseVitalSignMeasurementService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public NurseVitalSignMeasurementMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			MedicalExaminationRecordService medicalExaminationRecordService,
			NurseVitalSignMeasurementService nurseVitalSignMeasurementService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.nurseVitalSignMeasurementService = nurseVitalSignMeasurementService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create')")
	public NurseVitalSignMeasurementEntity createNurseVitalSignMeasurement(@NonNull NurseVitalSignMeasurementEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		NurseVitalSignMeasurementEntity newEntity = nurseVitalSignMeasurementService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link NurseVitalSignMeasurementMutationResolver#createNurseVitalSignMeasurement(NurseVitalSignMeasurementEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create')")
	public List<NurseVitalSignMeasurementEntity> createAllNurseVitalSignMeasurement(@NonNull List<NurseVitalSignMeasurementEntity> rawEntities) {
		List<NurseVitalSignMeasurementEntity> newEntities = Lists.newArrayList(nurseVitalSignMeasurementService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public NurseVitalSignMeasurementEntity updateNurseVitalSignMeasurement(@NonNull NurseVitalSignMeasurementEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		NurseVitalSignMeasurementEntity entityFromDb = nurseVitalSignMeasurementService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		NurseVitalSignMeasurementEntity newEntity = nurseVitalSignMeasurementService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link NurseVitalSignMeasurementMutationResolver#updateNurseVitalSignMeasurement(NurseVitalSignMeasurementEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public List<NurseVitalSignMeasurementEntity> updateAllNurseVitalSignMeasurement(@NonNull List<NurseVitalSignMeasurementEntity> rawEntities) {
		List<NurseVitalSignMeasurementEntity> newEntities = Lists.newArrayList(nurseVitalSignMeasurementService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'delete')")
	public String deleteNurseVitalSignMeasurementById(@NonNull String id) {
		nurseVitalSignMeasurementService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link NurseVitalSignMeasurementMutationResolver#deleteNurseVitalSignMeasurementById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'delete')")
	public List<String> deleteAllNurseVitalSignMeasurementByIds(@NonNull List<String> ids) {
		nurseVitalSignMeasurementService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'delete')")
	public List<String> deleteNurseVitalSignMeasurementExcludingIds(@NonNull List<String> ids) {
		nurseVitalSignMeasurementService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
