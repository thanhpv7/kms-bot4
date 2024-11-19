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
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.services.BpjsHealthFacilityService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsClaimSubmissionService;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.services.BpjsFacilityListService;
import kmsweb.entities.BpjsFacilityListEntity;
import kmsweb.services.BpjsPatientReferralService;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.services.BpjsReferralSpecialistService;
import kmsweb.entities.BpjsReferralSpecialistEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class BpjsHealthFacilityMutationResolver implements GraphQLMutationResolver {

	private final BpjsHealthFacilityService bpjsHealthFacilityService;

	private final BpjsClaimSubmissionService bpjsClaimSubmissionService;

	private final BpjsFacilityListService bpjsFacilityListService;

	private final BpjsPatientReferralService bpjsPatientReferralService;

	private final BpjsReferralSpecialistService bpjsReferralSpecialistService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsHealthFacilityMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsClaimSubmissionService bpjsClaimSubmissionService,
			BpjsFacilityListService bpjsFacilityListService,
			BpjsPatientReferralService bpjsPatientReferralService,
			BpjsReferralSpecialistService bpjsReferralSpecialistService,
			BpjsHealthFacilityService bpjsHealthFacilityService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bpjsHealthFacilityService = bpjsHealthFacilityService;

		this.bpjsClaimSubmissionService = bpjsClaimSubmissionService;

		this.bpjsFacilityListService = bpjsFacilityListService;

		this.bpjsPatientReferralService = bpjsPatientReferralService;

		this.bpjsReferralSpecialistService = bpjsReferralSpecialistService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'create')")
	public BpjsHealthFacilityEntity createBpjsHealthFacility(@NonNull BpjsHealthFacilityEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<BpjsFacilityListEntity> bpjsFacilityLists = new HashSet<>();
		rawEntity.getBpjsFacilityLists().forEach(entity -> {
			bpjsFacilityLists.add(bpjsFacilityListService.updateOldData(entity));
		});
		rawEntity.setBpjsFacilityLists(bpjsFacilityLists);

		Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();
		rawEntity.getBpjsPatientReferrals().forEach(entity -> {
			bpjsPatientReferrals.add(bpjsPatientReferralService.updateOldData(entity));
		});
		rawEntity.setBpjsPatientReferrals(bpjsPatientReferrals);

		Set<BpjsReferralSpecialistEntity> bpjsReferralSpecialists = new HashSet<>();
		rawEntity.getBpjsReferralSpecialists().forEach(entity -> {
			bpjsReferralSpecialists.add(bpjsReferralSpecialistService.updateOldData(entity));
		});
		rawEntity.setBpjsReferralSpecialists(bpjsReferralSpecialists);

		BpjsHealthFacilityEntity newEntity = bpjsHealthFacilityService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsHealthFacilityMutationResolver#createBpjsHealthFacility(BpjsHealthFacilityEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'create')")
	public List<BpjsHealthFacilityEntity> createAllBpjsHealthFacility(@NonNull List<BpjsHealthFacilityEntity> rawEntities) {
		List<BpjsHealthFacilityEntity> newEntities = Lists.newArrayList(bpjsHealthFacilityService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'update')")
	public BpjsHealthFacilityEntity updateBpjsHealthFacility(@NonNull BpjsHealthFacilityEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<BpjsFacilityListEntity> bpjsFacilityLists = new HashSet<>();
		rawEntity.getBpjsFacilityLists().forEach(entity -> {
			bpjsFacilityLists.add(bpjsFacilityListService.updateOldData(entity));
		});
		rawEntity.setBpjsFacilityLists(bpjsFacilityLists);

		Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();
		rawEntity.getBpjsPatientReferrals().forEach(entity -> {
			bpjsPatientReferrals.add(bpjsPatientReferralService.updateOldData(entity));
		});
		rawEntity.setBpjsPatientReferrals(bpjsPatientReferrals);

		Set<BpjsReferralSpecialistEntity> bpjsReferralSpecialists = new HashSet<>();
		rawEntity.getBpjsReferralSpecialists().forEach(entity -> {
			bpjsReferralSpecialists.add(bpjsReferralSpecialistService.updateOldData(entity));
		});
		rawEntity.setBpjsReferralSpecialists(bpjsReferralSpecialists);

		BpjsHealthFacilityEntity entityFromDb = bpjsHealthFacilityService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BpjsHealthFacilityEntity newEntity = bpjsHealthFacilityService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsHealthFacilityMutationResolver#updateBpjsHealthFacility(BpjsHealthFacilityEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'update')")
	public List<BpjsHealthFacilityEntity> updateAllBpjsHealthFacility(@NonNull List<BpjsHealthFacilityEntity> rawEntities) {
		List<BpjsHealthFacilityEntity> newEntities = Lists.newArrayList(bpjsHealthFacilityService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'delete')")
	public String deleteBpjsHealthFacilityById(@NonNull String id) {
		bpjsHealthFacilityService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BpjsHealthFacilityMutationResolver#deleteBpjsHealthFacilityById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'delete')")
	public List<String> deleteAllBpjsHealthFacilityByIds(@NonNull List<String> ids) {
		bpjsHealthFacilityService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BpjsHealthFacilityEntity', 'delete')")
	public List<String> deleteBpjsHealthFacilityExcludingIds(@NonNull List<String> ids) {
		bpjsHealthFacilityService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
