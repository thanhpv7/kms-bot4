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
import kmsweb.entities.BpjsINACBGVariableEntity;
import kmsweb.services.BpjsINACBGVariableService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class BpjsINACBGVariableMutationResolver implements GraphQLMutationResolver {

	private final BpjsINACBGVariableService bpjsINACBGVariableService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsINACBGVariableMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsINACBGVariableService bpjsINACBGVariableService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.bpjsINACBGVariableService = bpjsINACBGVariableService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'create')")
	public BpjsINACBGVariableEntity createBpjsINACBGVariable(@NonNull BpjsINACBGVariableEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		BpjsINACBGVariableEntity newEntity = bpjsINACBGVariableService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsINACBGVariableMutationResolver#createBpjsINACBGVariable(BpjsINACBGVariableEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'create')")
	public List<BpjsINACBGVariableEntity> createAllBpjsINACBGVariable(@NonNull List<BpjsINACBGVariableEntity> rawEntities) {
		List<BpjsINACBGVariableEntity> newEntities = Lists.newArrayList(bpjsINACBGVariableService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'update')")
	public BpjsINACBGVariableEntity updateBpjsINACBGVariable(@NonNull BpjsINACBGVariableEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		BpjsINACBGVariableEntity entityFromDb = bpjsINACBGVariableService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BpjsINACBGVariableEntity newEntity = bpjsINACBGVariableService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BpjsINACBGVariableMutationResolver#updateBpjsINACBGVariable(BpjsINACBGVariableEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'update')")
	public List<BpjsINACBGVariableEntity> updateAllBpjsINACBGVariable(@NonNull List<BpjsINACBGVariableEntity> rawEntities) {
		List<BpjsINACBGVariableEntity> newEntities = Lists.newArrayList(bpjsINACBGVariableService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'delete')")
	public String deleteBpjsINACBGVariableById(@NonNull String id) {
		bpjsINACBGVariableService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BpjsINACBGVariableMutationResolver#deleteBpjsINACBGVariableById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'delete')")
	public List<String> deleteAllBpjsINACBGVariableByIds(@NonNull List<String> ids) {
		bpjsINACBGVariableService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BpjsINACBGVariableEntity', 'delete')")
	public List<String> deleteBpjsINACBGVariableExcludingIds(@NonNull List<String> ids) {
		bpjsINACBGVariableService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
