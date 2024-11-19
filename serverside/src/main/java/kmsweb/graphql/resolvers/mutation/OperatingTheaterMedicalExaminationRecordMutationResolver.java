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
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.services.OperatingTheaterMedicalExaminationRecordService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.DiagnosisNandaService;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.services.IntraoperativeRecordsService;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.services.PostOperativeDetailsService;
import kmsweb.entities.PostOperativeDetailsEntity;
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
public class OperatingTheaterMedicalExaminationRecordMutationResolver implements GraphQLMutationResolver {

	private final OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	private final DiagnosisNandaService diagnosisNandaService;

	private final IntraoperativeRecordsService intraoperativeRecordsService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final PostOperativeDetailsService postOperativeDetailsService;

	private final PreoperativeRecordsService preoperativeRecordsService;

	private final StaffService staffService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public OperatingTheaterMedicalExaminationRecordMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DiagnosisNandaService diagnosisNandaService,
			IntraoperativeRecordsService intraoperativeRecordsService,
			MedicalExaminationRecordService medicalExaminationRecordService,
			PostOperativeDetailsService postOperativeDetailsService,
			PreoperativeRecordsService preoperativeRecordsService,
			StaffService staffService,
			OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.operatingTheaterMedicalExaminationRecordService = operatingTheaterMedicalExaminationRecordService;

		this.diagnosisNandaService = diagnosisNandaService;

		this.intraoperativeRecordsService = intraoperativeRecordsService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		this.postOperativeDetailsService = postOperativeDetailsService;

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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create')")
	public OperatingTheaterMedicalExaminationRecordEntity createOperatingTheaterMedicalExaminationRecord(@NonNull OperatingTheaterMedicalExaminationRecordEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getIntraoperativeRecords() != null) {
			rawEntity.setIntraoperativeRecords(intraoperativeRecordsService.updateOldData(rawEntity.getIntraoperativeRecords()));
		}

		if (rawEntity.getPostOperativeDetails() != null) {
			rawEntity.setPostOperativeDetails(postOperativeDetailsService.updateOldData(rawEntity.getPostOperativeDetails()));
		}

		if (rawEntity.getPreoperativeRecords() != null) {
			rawEntity.setPreoperativeRecords(preoperativeRecordsService.updateOldData(rawEntity.getPreoperativeRecords()));
		}

		if (rawEntity.getNursingAnesthesiaDetail() != null) {
			rawEntity.setNursingAnesthesiaDetail(diagnosisNandaService.updateOldData(rawEntity.getNursingAnesthesiaDetail()));
		}

		if (rawEntity.getNursingDetailSurgicalNursings() != null) {
			rawEntity.setNursingDetailSurgicalNursings(staffService.updateOldData(rawEntity.getNursingDetailSurgicalNursings()));
		}

		if (rawEntity.getNursingDetailsAnesthesiaNursings() != null) {
			rawEntity.setNursingDetailsAnesthesiaNursings(staffService.updateOldData(rawEntity.getNursingDetailsAnesthesiaNursings()));
		}

		if (rawEntity.getNursingSurgicalDetail() != null) {
			rawEntity.setNursingSurgicalDetail(diagnosisNandaService.updateOldData(rawEntity.getNursingSurgicalDetail()));
		}

		OperatingTheaterMedicalExaminationRecordEntity newEntity = operatingTheaterMedicalExaminationRecordService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link OperatingTheaterMedicalExaminationRecordMutationResolver#createOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> createAllOperatingTheaterMedicalExaminationRecord(@NonNull List<OperatingTheaterMedicalExaminationRecordEntity> rawEntities) {
		List<OperatingTheaterMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(operatingTheaterMedicalExaminationRecordService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public OperatingTheaterMedicalExaminationRecordEntity updateOperatingTheaterMedicalExaminationRecord(@NonNull OperatingTheaterMedicalExaminationRecordEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getIntraoperativeRecords() != null) {
			rawEntity.setIntraoperativeRecords(intraoperativeRecordsService.updateOldData(rawEntity.getIntraoperativeRecords()));
		}

		if (rawEntity.getPostOperativeDetails() != null) {
			rawEntity.setPostOperativeDetails(postOperativeDetailsService.updateOldData(rawEntity.getPostOperativeDetails()));
		}

		if (rawEntity.getPreoperativeRecords() != null) {
			rawEntity.setPreoperativeRecords(preoperativeRecordsService.updateOldData(rawEntity.getPreoperativeRecords()));
		}

		if (rawEntity.getNursingAnesthesiaDetail() != null) {
			rawEntity.setNursingAnesthesiaDetail(diagnosisNandaService.updateOldData(rawEntity.getNursingAnesthesiaDetail()));
		}

		if (rawEntity.getNursingDetailSurgicalNursings() != null) {
			rawEntity.setNursingDetailSurgicalNursings(staffService.updateOldData(rawEntity.getNursingDetailSurgicalNursings()));
		}

		if (rawEntity.getNursingDetailsAnesthesiaNursings() != null) {
			rawEntity.setNursingDetailsAnesthesiaNursings(staffService.updateOldData(rawEntity.getNursingDetailsAnesthesiaNursings()));
		}

		if (rawEntity.getNursingSurgicalDetail() != null) {
			rawEntity.setNursingSurgicalDetail(diagnosisNandaService.updateOldData(rawEntity.getNursingSurgicalDetail()));
		}

		OperatingTheaterMedicalExaminationRecordEntity entityFromDb = operatingTheaterMedicalExaminationRecordService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		OperatingTheaterMedicalExaminationRecordEntity newEntity = operatingTheaterMedicalExaminationRecordService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link OperatingTheaterMedicalExaminationRecordMutationResolver#updateOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> updateAllOperatingTheaterMedicalExaminationRecord(@NonNull List<OperatingTheaterMedicalExaminationRecordEntity> rawEntities) {
		List<OperatingTheaterMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(operatingTheaterMedicalExaminationRecordService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'delete')")
	public String deleteOperatingTheaterMedicalExaminationRecordById(@NonNull String id) {
		operatingTheaterMedicalExaminationRecordService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link OperatingTheaterMedicalExaminationRecordMutationResolver#deleteOperatingTheaterMedicalExaminationRecordById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'delete')")
	public List<String> deleteAllOperatingTheaterMedicalExaminationRecordByIds(@NonNull List<String> ids) {
		operatingTheaterMedicalExaminationRecordService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'delete')")
	public List<String> deleteOperatingTheaterMedicalExaminationRecordExcludingIds(@NonNull List<String> ids) {
		operatingTheaterMedicalExaminationRecordService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
