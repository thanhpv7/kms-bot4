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
import kmsweb.entities.BpjsDiagnosePRBEntity;
import kmsweb.services.BpjsDiagnosePRBService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsPRBService;
import kmsweb.entities.BpjsPRBEntity;
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
public class BpjsDiagnosePRBMutationResolver implements GraphQLMutationResolver {

	private final BpjsDiagnosePRBService bpjsDiagnosePRBService;

	private final BpjsPRBService bpjsPRBService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsDiagnosePRBMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsPRBService bpjsPRBService,
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			BpjsDiagnosePRBService bpjsDiagnosePRBService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bpjsDiagnosePRBService = bpjsDiagnosePRBService;

		this.bpjsPRBService = bpjsPRBService;

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
	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'create')")
	public BpjsDiagnosePRBEntity createBpjsDiagnosePRB(@NonNull BpjsDiagnosePRBEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Set<BpjsPRBEntity> bpjsPRBs = new HashSet<>();
		rawEntity.getBpjsPRBs().forEach(entity -> {
			bpjsPRBs.add(bpjsPRBService.updateOldData(entity));
		});
		rawEntity.setBpjsPRBs(bpjsPRBs);

		BpjsDiagnosePRBEntity newEntity = bpjsDiagnosePRBService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsDiagnosePRBMutationResolver#createBpjsDiagnosePRB(BpjsDiagnosePRBEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'create')")
	public List<BpjsDiagnosePRBEntity> createAllBpjsDiagnosePRB(@NonNull List<BpjsDiagnosePRBEntity> rawEntities) {
		List<BpjsDiagnosePRBEntity> newEntities = Lists.newArrayList(bpjsDiagnosePRBService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'update')")
	public BpjsDiagnosePRBEntity updateBpjsDiagnosePRB(@NonNull BpjsDiagnosePRBEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Set<BpjsPRBEntity> bpjsPRBs = new HashSet<>();
		rawEntity.getBpjsPRBs().forEach(entity -> {
			bpjsPRBs.add(bpjsPRBService.updateOldData(entity));
		});
		rawEntity.setBpjsPRBs(bpjsPRBs);

		BpjsDiagnosePRBEntity entityFromDb = bpjsDiagnosePRBService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BpjsDiagnosePRBEntity newEntity = bpjsDiagnosePRBService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsDiagnosePRBMutationResolver#updateBpjsDiagnosePRB(BpjsDiagnosePRBEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'update')")
	public List<BpjsDiagnosePRBEntity> updateAllBpjsDiagnosePRB(@NonNull List<BpjsDiagnosePRBEntity> rawEntities) {
		List<BpjsDiagnosePRBEntity> newEntities = Lists.newArrayList(bpjsDiagnosePRBService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'delete')")
	public String deleteBpjsDiagnosePRBById(@NonNull String id) {
		bpjsDiagnosePRBService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BpjsDiagnosePRBMutationResolver#deleteBpjsDiagnosePRBById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'delete')")
	public List<String> deleteAllBpjsDiagnosePRBByIds(@NonNull List<String> ids) {
		bpjsDiagnosePRBService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'delete')")
	public List<String> deleteBpjsDiagnosePRBExcludingIds(@NonNull List<String> ids) {
		bpjsDiagnosePRBService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
