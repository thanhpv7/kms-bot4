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
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.services.CoTreatingDoctorService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.DeliveryMedicalExaminationRecordService;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.services.PreoperativeRecordsService;
import kmsweb.entities.PreoperativeRecordsEntity;
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
public class CoTreatingDoctorMutationResolver implements GraphQLMutationResolver {

	private final CoTreatingDoctorService coTreatingDoctorService;

	private final DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final PreoperativeRecordsService preoperativeRecordsService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public CoTreatingDoctorMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService,
			MedicalExaminationRecordService medicalExaminationRecordService,
			PreoperativeRecordsService preoperativeRecordsService,
			StaffService staffService,
			CoTreatingDoctorService coTreatingDoctorService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.coTreatingDoctorService = coTreatingDoctorService;

		this.deliveryMedicalExaminationRecordService = deliveryMedicalExaminationRecordService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		this.preoperativeRecordsService = preoperativeRecordsService;

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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create')")
	public CoTreatingDoctorEntity createCoTreatingDoctor(@NonNull CoTreatingDoctorEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getAdditionalAnesthesiologist() != null) {
			rawEntity.setAdditionalAnesthesiologist(preoperativeRecordsService.updateOldData(rawEntity.getAdditionalAnesthesiologist()));
		}

		if (rawEntity.getAdditionalMidwife() != null) {
			rawEntity.setAdditionalMidwife(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getAdditionalMidwife()));
		}

		if (rawEntity.getAdditionalSurgeryNurse() != null) {
			rawEntity.setAdditionalSurgeryNurse(preoperativeRecordsService.updateOldData(rawEntity.getAdditionalSurgeryNurse()));
		}

		if (rawEntity.getCoTreatingAnesthesiologist() != null) {
			rawEntity.setCoTreatingAnesthesiologist(preoperativeRecordsService.updateOldData(rawEntity.getCoTreatingAnesthesiologist()));
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		if (rawEntity.getCoTreatingSurgeon() != null) {
			rawEntity.setCoTreatingSurgeon(preoperativeRecordsService.updateOldData(rawEntity.getCoTreatingSurgeon()));
		}

		CoTreatingDoctorEntity newEntity = coTreatingDoctorService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link CoTreatingDoctorMutationResolver#createCoTreatingDoctor(CoTreatingDoctorEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create')")
	public List<CoTreatingDoctorEntity> createAllCoTreatingDoctor(@NonNull List<CoTreatingDoctorEntity> rawEntities) {
		List<CoTreatingDoctorEntity> newEntities = Lists.newArrayList(coTreatingDoctorService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'update')")
	public CoTreatingDoctorEntity updateCoTreatingDoctor(@NonNull CoTreatingDoctorEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getAdditionalAnesthesiologist() != null) {
			rawEntity.setAdditionalAnesthesiologist(preoperativeRecordsService.updateOldData(rawEntity.getAdditionalAnesthesiologist()));
		}

		if (rawEntity.getAdditionalMidwife() != null) {
			rawEntity.setAdditionalMidwife(deliveryMedicalExaminationRecordService.updateOldData(rawEntity.getAdditionalMidwife()));
		}

		if (rawEntity.getAdditionalSurgeryNurse() != null) {
			rawEntity.setAdditionalSurgeryNurse(preoperativeRecordsService.updateOldData(rawEntity.getAdditionalSurgeryNurse()));
		}

		if (rawEntity.getCoTreatingAnesthesiologist() != null) {
			rawEntity.setCoTreatingAnesthesiologist(preoperativeRecordsService.updateOldData(rawEntity.getCoTreatingAnesthesiologist()));
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		if (rawEntity.getCoTreatingSurgeon() != null) {
			rawEntity.setCoTreatingSurgeon(preoperativeRecordsService.updateOldData(rawEntity.getCoTreatingSurgeon()));
		}

		CoTreatingDoctorEntity entityFromDb = coTreatingDoctorService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		CoTreatingDoctorEntity newEntity = coTreatingDoctorService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link CoTreatingDoctorMutationResolver#updateCoTreatingDoctor(CoTreatingDoctorEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'update')")
	public List<CoTreatingDoctorEntity> updateAllCoTreatingDoctor(@NonNull List<CoTreatingDoctorEntity> rawEntities) {
		List<CoTreatingDoctorEntity> newEntities = Lists.newArrayList(coTreatingDoctorService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'delete')")
	public String deleteCoTreatingDoctorById(@NonNull String id) {
		coTreatingDoctorService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link CoTreatingDoctorMutationResolver#deleteCoTreatingDoctorById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'delete')")
	public List<String> deleteAllCoTreatingDoctorByIds(@NonNull List<String> ids) {
		coTreatingDoctorService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'delete')")
	public List<String> deleteCoTreatingDoctorExcludingIds(@NonNull List<String> ids) {
		coTreatingDoctorService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
