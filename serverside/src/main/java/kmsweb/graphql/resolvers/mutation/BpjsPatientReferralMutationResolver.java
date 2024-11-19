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
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.services.BpjsPatientReferralService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsDiagnoseService;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.services.BpjsHealthFacilityService;
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.services.BpjsServiceMappingService;
import kmsweb.entities.BpjsServiceMappingEntity;
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
public class BpjsPatientReferralMutationResolver implements GraphQLMutationResolver {

	private final BpjsPatientReferralService bpjsPatientReferralService;

	private final BpjsDiagnoseService bpjsDiagnoseService;

	private final BpjsHealthFacilityService bpjsHealthFacilityService;

	private final BpjsServiceMappingService bpjsServiceMappingService;

	private final PatientPaymentBPJSService patientPaymentBPJSService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsPatientReferralMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsDiagnoseService bpjsDiagnoseService,
			BpjsHealthFacilityService bpjsHealthFacilityService,
			BpjsServiceMappingService bpjsServiceMappingService,
			PatientPaymentBPJSService patientPaymentBPJSService,
			BpjsPatientReferralService bpjsPatientReferralService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bpjsPatientReferralService = bpjsPatientReferralService;

		this.bpjsDiagnoseService = bpjsDiagnoseService;

		this.bpjsHealthFacilityService = bpjsHealthFacilityService;

		this.bpjsServiceMappingService = bpjsServiceMappingService;

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
	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'create')")
	public BpjsPatientReferralEntity createBpjsPatientReferral(@NonNull BpjsPatientReferralEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDiagnose() != null) {
			rawEntity.setBpjsDiagnose(bpjsDiagnoseService.updateOldData(rawEntity.getBpjsDiagnose()));
		}

		if (rawEntity.getBpjsHealthFacility() != null) {
			rawEntity.setBpjsHealthFacility(bpjsHealthFacilityService.updateOldData(rawEntity.getBpjsHealthFacility()));
		}

		if (rawEntity.getBpjsServiceMapping() != null) {
			rawEntity.setBpjsServiceMapping(bpjsServiceMappingService.updateOldData(rawEntity.getBpjsServiceMapping()));
		}

		if (rawEntity.getPatientPaymentBPJS() != null) {
			rawEntity.setPatientPaymentBPJS(patientPaymentBPJSService.updateOldData(rawEntity.getPatientPaymentBPJS()));
		}

		BpjsPatientReferralEntity newEntity = bpjsPatientReferralService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsPatientReferralMutationResolver#createBpjsPatientReferral(BpjsPatientReferralEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'create')")
	public List<BpjsPatientReferralEntity> createAllBpjsPatientReferral(@NonNull List<BpjsPatientReferralEntity> rawEntities) {
		List<BpjsPatientReferralEntity> newEntities = Lists.newArrayList(bpjsPatientReferralService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'update')")
	public BpjsPatientReferralEntity updateBpjsPatientReferral(@NonNull BpjsPatientReferralEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDiagnose() != null) {
			rawEntity.setBpjsDiagnose(bpjsDiagnoseService.updateOldData(rawEntity.getBpjsDiagnose()));
		}

		if (rawEntity.getBpjsHealthFacility() != null) {
			rawEntity.setBpjsHealthFacility(bpjsHealthFacilityService.updateOldData(rawEntity.getBpjsHealthFacility()));
		}

		if (rawEntity.getBpjsServiceMapping() != null) {
			rawEntity.setBpjsServiceMapping(bpjsServiceMappingService.updateOldData(rawEntity.getBpjsServiceMapping()));
		}

		if (rawEntity.getPatientPaymentBPJS() != null) {
			rawEntity.setPatientPaymentBPJS(patientPaymentBPJSService.updateOldData(rawEntity.getPatientPaymentBPJS()));
		}

		BpjsPatientReferralEntity entityFromDb = bpjsPatientReferralService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BpjsPatientReferralEntity newEntity = bpjsPatientReferralService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsPatientReferralMutationResolver#updateBpjsPatientReferral(BpjsPatientReferralEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'update')")
	public List<BpjsPatientReferralEntity> updateAllBpjsPatientReferral(@NonNull List<BpjsPatientReferralEntity> rawEntities) {
		List<BpjsPatientReferralEntity> newEntities = Lists.newArrayList(bpjsPatientReferralService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'delete')")
	public String deleteBpjsPatientReferralById(@NonNull String id) {
		bpjsPatientReferralService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BpjsPatientReferralMutationResolver#deleteBpjsPatientReferralById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'delete')")
	public List<String> deleteAllBpjsPatientReferralByIds(@NonNull List<String> ids) {
		bpjsPatientReferralService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'delete')")
	public List<String> deleteBpjsPatientReferralExcludingIds(@NonNull List<String> ids) {
		bpjsPatientReferralService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
