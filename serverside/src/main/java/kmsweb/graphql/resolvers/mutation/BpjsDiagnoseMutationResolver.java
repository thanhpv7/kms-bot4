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
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.services.BpjsDiagnoseService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsClaimSubmissionService;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.services.BpjsPatientReferralService;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.services.BpjsSpecialReferralService;
import kmsweb.entities.BpjsSpecialReferralEntity;
import kmsweb.services.DiagnosesAndProceduresService;
import kmsweb.entities.DiagnosesAndProceduresEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class BpjsDiagnoseMutationResolver implements GraphQLMutationResolver {

	private final BpjsDiagnoseService bpjsDiagnoseService;

	private final BpjsClaimSubmissionService bpjsClaimSubmissionService;

	private final BpjsPatientReferralService bpjsPatientReferralService;

	private final BpjsSpecialReferralService bpjsSpecialReferralService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsDiagnoseMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsClaimSubmissionService bpjsClaimSubmissionService,
			BpjsPatientReferralService bpjsPatientReferralService,
			BpjsSpecialReferralService bpjsSpecialReferralService,
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			BpjsDiagnoseService bpjsDiagnoseService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bpjsDiagnoseService = bpjsDiagnoseService;

		this.bpjsClaimSubmissionService = bpjsClaimSubmissionService;

		this.bpjsPatientReferralService = bpjsPatientReferralService;

		this.bpjsSpecialReferralService = bpjsSpecialReferralService;

		this.diagnosesAndProceduresService = diagnosesAndProceduresService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'create')")
	public BpjsDiagnoseEntity createBpjsDiagnose(@NonNull BpjsDiagnoseEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Set<BpjsSpecialReferralEntity> additionalDiagnose = new HashSet<>();
		rawEntity.getAdditionalDiagnose().forEach(entity -> {
			additionalDiagnose.add(bpjsSpecialReferralService.updateOldData(entity));
		});
		rawEntity.setAdditionalDiagnose(additionalDiagnose);

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();
		rawEntity.getBpjsPatientReferrals().forEach(entity -> {
			bpjsPatientReferrals.add(bpjsPatientReferralService.updateOldData(entity));
		});
		rawEntity.setBpjsPatientReferrals(bpjsPatientReferrals);

		Set<BpjsSpecialReferralEntity> primaryDiagnose = new HashSet<>();
		rawEntity.getPrimaryDiagnose().forEach(entity -> {
			primaryDiagnose.add(bpjsSpecialReferralService.updateOldData(entity));
		});
		rawEntity.setPrimaryDiagnose(primaryDiagnose);

		BpjsDiagnoseEntity newEntity = bpjsDiagnoseService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsDiagnoseMutationResolver#createBpjsDiagnose(BpjsDiagnoseEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'create')")
	public List<BpjsDiagnoseEntity> createAllBpjsDiagnose(@NonNull List<BpjsDiagnoseEntity> rawEntities) {
		List<BpjsDiagnoseEntity> newEntities = Lists.newArrayList(bpjsDiagnoseService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'update')")
	public BpjsDiagnoseEntity updateBpjsDiagnose(@NonNull BpjsDiagnoseEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Set<BpjsSpecialReferralEntity> additionalDiagnose = new HashSet<>();
		rawEntity.getAdditionalDiagnose().forEach(entity -> {
			additionalDiagnose.add(bpjsSpecialReferralService.updateOldData(entity));
		});
		rawEntity.setAdditionalDiagnose(additionalDiagnose);

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();
		rawEntity.getBpjsPatientReferrals().forEach(entity -> {
			bpjsPatientReferrals.add(bpjsPatientReferralService.updateOldData(entity));
		});
		rawEntity.setBpjsPatientReferrals(bpjsPatientReferrals);

		Set<BpjsSpecialReferralEntity> primaryDiagnose = new HashSet<>();
		rawEntity.getPrimaryDiagnose().forEach(entity -> {
			primaryDiagnose.add(bpjsSpecialReferralService.updateOldData(entity));
		});
		rawEntity.setPrimaryDiagnose(primaryDiagnose);

		BpjsDiagnoseEntity entityFromDb = bpjsDiagnoseService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BpjsDiagnoseEntity newEntity = bpjsDiagnoseService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsDiagnoseMutationResolver#updateBpjsDiagnose(BpjsDiagnoseEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'update')")
	public List<BpjsDiagnoseEntity> updateAllBpjsDiagnose(@NonNull List<BpjsDiagnoseEntity> rawEntities) {
		List<BpjsDiagnoseEntity> newEntities = Lists.newArrayList(bpjsDiagnoseService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'delete')")
	public String deleteBpjsDiagnoseById(@NonNull String id) {
		bpjsDiagnoseService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BpjsDiagnoseMutationResolver#deleteBpjsDiagnoseById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'delete')")
	public List<String> deleteAllBpjsDiagnoseByIds(@NonNull List<String> ids) {
		bpjsDiagnoseService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'delete')")
	public List<String> deleteBpjsDiagnoseExcludingIds(@NonNull List<String> ids) {
		bpjsDiagnoseService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
