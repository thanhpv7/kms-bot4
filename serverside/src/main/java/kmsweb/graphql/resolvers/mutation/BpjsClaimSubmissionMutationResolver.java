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
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.services.BpjsClaimSubmissionService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsDiagnoseService;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.services.BpjsDismissalConditionService;
import kmsweb.entities.BpjsDismissalConditionEntity;
import kmsweb.services.BpjsDismissalMappingService;
import kmsweb.entities.BpjsDismissalMappingEntity;
import kmsweb.services.BpjsDoctorMappingService;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.services.BpjsHealthFacilityService;
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.services.BpjsProcedureService;
import kmsweb.entities.BpjsProcedureEntity;
import kmsweb.services.BpjsServiceMappingService;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.services.BpjsTreatmentRoomService;
import kmsweb.entities.BpjsTreatmentRoomEntity;
import kmsweb.services.PatientGeneralInfoService;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.services.PatientPaymentBPJSService;
import kmsweb.entities.PatientPaymentBPJSEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class BpjsClaimSubmissionMutationResolver implements GraphQLMutationResolver {

	private final BpjsClaimSubmissionService bpjsClaimSubmissionService;

	private final BpjsDiagnoseService bpjsDiagnoseService;

	private final BpjsDismissalConditionService bpjsDismissalConditionService;

	private final BpjsDismissalMappingService bpjsDismissalMappingService;

	private final BpjsDoctorMappingService bpjsDoctorMappingService;

	private final BpjsHealthFacilityService bpjsHealthFacilityService;

	private final BpjsProcedureService bpjsProcedureService;

	private final BpjsServiceMappingService bpjsServiceMappingService;

	private final BpjsTreatmentRoomService bpjsTreatmentRoomService;

	private final PatientGeneralInfoService patientGeneralInfoService;

	private final PatientPaymentBPJSService patientPaymentBPJSService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsClaimSubmissionMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsDiagnoseService bpjsDiagnoseService,
			BpjsDismissalConditionService bpjsDismissalConditionService,
			BpjsDismissalMappingService bpjsDismissalMappingService,
			BpjsDoctorMappingService bpjsDoctorMappingService,
			BpjsHealthFacilityService bpjsHealthFacilityService,
			BpjsProcedureService bpjsProcedureService,
			BpjsServiceMappingService bpjsServiceMappingService,
			BpjsTreatmentRoomService bpjsTreatmentRoomService,
			PatientGeneralInfoService patientGeneralInfoService,
			PatientPaymentBPJSService patientPaymentBPJSService,
			BpjsClaimSubmissionService bpjsClaimSubmissionService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bpjsClaimSubmissionService = bpjsClaimSubmissionService;

		this.bpjsDiagnoseService = bpjsDiagnoseService;

		this.bpjsDismissalConditionService = bpjsDismissalConditionService;

		this.bpjsDismissalMappingService = bpjsDismissalMappingService;

		this.bpjsDoctorMappingService = bpjsDoctorMappingService;

		this.bpjsHealthFacilityService = bpjsHealthFacilityService;

		this.bpjsProcedureService = bpjsProcedureService;

		this.bpjsServiceMappingService = bpjsServiceMappingService;

		this.bpjsTreatmentRoomService = bpjsTreatmentRoomService;

		this.patientGeneralInfoService = patientGeneralInfoService;

		this.patientPaymentBPJSService = patientPaymentBPJSService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create')")
	public BpjsClaimSubmissionEntity createBpjsClaimSubmission(@NonNull BpjsClaimSubmissionEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDiagnose() != null) {
			rawEntity.setBpjsDiagnose(bpjsDiagnoseService.updateOldData(rawEntity.getBpjsDiagnose()));
		}

		if (rawEntity.getBpjsDoctorMapping() != null) {
			rawEntity.setBpjsDoctorMapping(bpjsDoctorMappingService.updateOldData(rawEntity.getBpjsDoctorMapping()));
		}

		if (rawEntity.getBpjsHealthFacility() != null) {
			rawEntity.setBpjsHealthFacility(bpjsHealthFacilityService.updateOldData(rawEntity.getBpjsHealthFacility()));
		}

		if (rawEntity.getBpjsProcedure() != null) {
			rawEntity.setBpjsProcedure(bpjsProcedureService.updateOldData(rawEntity.getBpjsProcedure()));
		}

		if (rawEntity.getBpjsServiceMapping() != null) {
			rawEntity.setBpjsServiceMapping(bpjsServiceMappingService.updateOldData(rawEntity.getBpjsServiceMapping()));
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		if (rawEntity.getPatientPaymentBPJS() != null) {
			rawEntity.setPatientPaymentBPJS(patientPaymentBPJSService.updateOldData(rawEntity.getPatientPaymentBPJS()));
		}

		Set<BpjsDismissalConditionEntity> bpjsDismissalConditions = new HashSet<>();
		rawEntity.getBpjsDismissalConditions().forEach(entity -> {
			bpjsDismissalConditions.add(bpjsDismissalConditionService.updateOldData(entity));
		});
		rawEntity.setBpjsDismissalConditions(bpjsDismissalConditions);

		Set<BpjsDismissalMappingEntity> bpjsDismissalMappings = new HashSet<>();
		rawEntity.getBpjsDismissalMappings().forEach(entity -> {
			bpjsDismissalMappings.add(bpjsDismissalMappingService.updateOldData(entity));
		});
		rawEntity.setBpjsDismissalMappings(bpjsDismissalMappings);

		Set<BpjsTreatmentRoomEntity> bpjsTreatmentRooms = new HashSet<>();
		rawEntity.getBpjsTreatmentRooms().forEach(entity -> {
			bpjsTreatmentRooms.add(bpjsTreatmentRoomService.updateOldData(entity));
		});
		rawEntity.setBpjsTreatmentRooms(bpjsTreatmentRooms);

		BpjsClaimSubmissionEntity newEntity = bpjsClaimSubmissionService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsClaimSubmissionMutationResolver#createBpjsClaimSubmission(BpjsClaimSubmissionEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create')")
	public List<BpjsClaimSubmissionEntity> createAllBpjsClaimSubmission(@NonNull List<BpjsClaimSubmissionEntity> rawEntities) {
		List<BpjsClaimSubmissionEntity> newEntities = Lists.newArrayList(bpjsClaimSubmissionService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public BpjsClaimSubmissionEntity updateBpjsClaimSubmission(@NonNull BpjsClaimSubmissionEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDiagnose() != null) {
			rawEntity.setBpjsDiagnose(bpjsDiagnoseService.updateOldData(rawEntity.getBpjsDiagnose()));
		}

		if (rawEntity.getBpjsDoctorMapping() != null) {
			rawEntity.setBpjsDoctorMapping(bpjsDoctorMappingService.updateOldData(rawEntity.getBpjsDoctorMapping()));
		}

		if (rawEntity.getBpjsHealthFacility() != null) {
			rawEntity.setBpjsHealthFacility(bpjsHealthFacilityService.updateOldData(rawEntity.getBpjsHealthFacility()));
		}

		if (rawEntity.getBpjsProcedure() != null) {
			rawEntity.setBpjsProcedure(bpjsProcedureService.updateOldData(rawEntity.getBpjsProcedure()));
		}

		if (rawEntity.getBpjsServiceMapping() != null) {
			rawEntity.setBpjsServiceMapping(bpjsServiceMappingService.updateOldData(rawEntity.getBpjsServiceMapping()));
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		if (rawEntity.getPatientPaymentBPJS() != null) {
			rawEntity.setPatientPaymentBPJS(patientPaymentBPJSService.updateOldData(rawEntity.getPatientPaymentBPJS()));
		}

		Set<BpjsDismissalConditionEntity> bpjsDismissalConditions = new HashSet<>();
		rawEntity.getBpjsDismissalConditions().forEach(entity -> {
			bpjsDismissalConditions.add(bpjsDismissalConditionService.updateOldData(entity));
		});
		rawEntity.setBpjsDismissalConditions(bpjsDismissalConditions);

		Set<BpjsDismissalMappingEntity> bpjsDismissalMappings = new HashSet<>();
		rawEntity.getBpjsDismissalMappings().forEach(entity -> {
			bpjsDismissalMappings.add(bpjsDismissalMappingService.updateOldData(entity));
		});
		rawEntity.setBpjsDismissalMappings(bpjsDismissalMappings);

		Set<BpjsTreatmentRoomEntity> bpjsTreatmentRooms = new HashSet<>();
		rawEntity.getBpjsTreatmentRooms().forEach(entity -> {
			bpjsTreatmentRooms.add(bpjsTreatmentRoomService.updateOldData(entity));
		});
		rawEntity.setBpjsTreatmentRooms(bpjsTreatmentRooms);

		BpjsClaimSubmissionEntity entityFromDb = bpjsClaimSubmissionService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BpjsClaimSubmissionEntity newEntity = bpjsClaimSubmissionService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsClaimSubmissionMutationResolver#updateBpjsClaimSubmission(BpjsClaimSubmissionEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public List<BpjsClaimSubmissionEntity> updateAllBpjsClaimSubmission(@NonNull List<BpjsClaimSubmissionEntity> rawEntities) {
		List<BpjsClaimSubmissionEntity> newEntities = Lists.newArrayList(bpjsClaimSubmissionService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'delete')")
	public String deleteBpjsClaimSubmissionById(@NonNull String id) {
		bpjsClaimSubmissionService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BpjsClaimSubmissionMutationResolver#deleteBpjsClaimSubmissionById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'delete')")
	public List<String> deleteAllBpjsClaimSubmissionByIds(@NonNull List<String> ids) {
		bpjsClaimSubmissionService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'delete')")
	public List<String> deleteBpjsClaimSubmissionExcludingIds(@NonNull List<String> ids) {
		bpjsClaimSubmissionService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
