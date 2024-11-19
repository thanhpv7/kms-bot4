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
import kmsweb.entities.Icd9CMEntity;
import kmsweb.services.Icd9CMService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
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
public class Icd9CMMutationResolver implements GraphQLMutationResolver {

	private final Icd9CMService icd9CMService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public Icd9CMMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			Icd9CMService icd9CMService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.icd9CMService = icd9CMService;

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
	@PreAuthorize("hasPermission('Icd9CMEntity', 'create')")
	public Icd9CMEntity createIcd9CM(@NonNull Icd9CMEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Icd9CMEntity newEntity = icd9CMService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link Icd9CMMutationResolver#createIcd9CM(Icd9CMEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('Icd9CMEntity', 'create')")
	public List<Icd9CMEntity> createAllIcd9CM(@NonNull List<Icd9CMEntity> rawEntities) {
		List<Icd9CMEntity> newEntities = Lists.newArrayList(icd9CMService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('Icd9CMEntity', 'update')")
	public Icd9CMEntity updateIcd9CM(@NonNull Icd9CMEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Icd9CMEntity entityFromDb = icd9CMService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		Icd9CMEntity newEntity = icd9CMService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link Icd9CMMutationResolver#updateIcd9CM(Icd9CMEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('Icd9CMEntity', 'update')")
	public List<Icd9CMEntity> updateAllIcd9CM(@NonNull List<Icd9CMEntity> rawEntities) {
		List<Icd9CMEntity> newEntities = Lists.newArrayList(icd9CMService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('Icd9CMEntity', 'delete')")
	public String deleteIcd9CMById(@NonNull String id) {
		icd9CMService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link Icd9CMMutationResolver#deleteIcd9CMById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('Icd9CMEntity', 'delete')")
	public List<String> deleteAllIcd9CMByIds(@NonNull List<String> ids) {
		icd9CMService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('Icd9CMEntity', 'delete')")
	public List<String> deleteIcd9CMExcludingIds(@NonNull List<String> ids) {
		icd9CMService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
