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
import kmsweb.entities.Icd10Entity;
import kmsweb.services.Icd10Service;
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
public class Icd10MutationResolver implements GraphQLMutationResolver {

	private final Icd10Service icd10Service;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public Icd10MutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			Icd10Service icd10Service
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.icd10Service = icd10Service;

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
	@PreAuthorize("hasPermission('Icd10Entity', 'create')")
	public Icd10Entity createIcd10(@NonNull Icd10Entity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Icd10Entity newEntity = icd10Service.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link Icd10MutationResolver#createIcd10(Icd10Entity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('Icd10Entity', 'create')")
	public List<Icd10Entity> createAllIcd10(@NonNull List<Icd10Entity> rawEntities) {
		List<Icd10Entity> newEntities = Lists.newArrayList(icd10Service.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('Icd10Entity', 'update')")
	public Icd10Entity updateIcd10(@NonNull Icd10Entity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosesAndProcedures() != null) {
			rawEntity.setDiagnosesAndProcedures(diagnosesAndProceduresService.updateOldData(rawEntity.getDiagnosesAndProcedures()));
		}

		Icd10Entity entityFromDb = icd10Service.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		Icd10Entity newEntity = icd10Service.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link Icd10MutationResolver#updateIcd10(Icd10Entity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('Icd10Entity', 'update')")
	public List<Icd10Entity> updateAllIcd10(@NonNull List<Icd10Entity> rawEntities) {
		List<Icd10Entity> newEntities = Lists.newArrayList(icd10Service.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('Icd10Entity', 'delete')")
	public String deleteIcd10ById(@NonNull String id) {
		icd10Service.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link Icd10MutationResolver#deleteIcd10ById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('Icd10Entity', 'delete')")
	public List<String> deleteAllIcd10ByIds(@NonNull List<String> ids) {
		icd10Service.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('Icd10Entity', 'delete')")
	public List<String> deleteIcd10ExcludingIds(@NonNull List<String> ids) {
		icd10Service.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
