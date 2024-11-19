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
import kmsweb.entities.ChartOfAccountEntity;
import kmsweb.services.ChartOfAccountService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.ChartOfAccountMappingService;
import kmsweb.entities.ChartOfAccountMappingEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class ChartOfAccountMutationResolver implements GraphQLMutationResolver {

	private final ChartOfAccountService chartOfAccountService;

	private final ChartOfAccountMappingService chartOfAccountMappingService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ChartOfAccountMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			ChartOfAccountMappingService chartOfAccountMappingService,
			ChartOfAccountService chartOfAccountService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.chartOfAccountService = chartOfAccountService;

		this.chartOfAccountMappingService = chartOfAccountMappingService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'create')")
	public ChartOfAccountEntity createChartOfAccount(@NonNull ChartOfAccountEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<ChartOfAccountMappingEntity> chartOfAccountMappings = new HashSet<>();
		rawEntity.getChartOfAccountMappings().forEach(entity -> {
			chartOfAccountMappings.add(chartOfAccountMappingService.updateOldData(entity));
		});
		rawEntity.setChartOfAccountMappings(chartOfAccountMappings);

		ChartOfAccountEntity newEntity = chartOfAccountService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ChartOfAccountMutationResolver#createChartOfAccount(ChartOfAccountEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'create')")
	public List<ChartOfAccountEntity> createAllChartOfAccount(@NonNull List<ChartOfAccountEntity> rawEntities) {
		List<ChartOfAccountEntity> newEntities = Lists.newArrayList(chartOfAccountService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'update')")
	public ChartOfAccountEntity updateChartOfAccount(@NonNull ChartOfAccountEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<ChartOfAccountMappingEntity> chartOfAccountMappings = new HashSet<>();
		rawEntity.getChartOfAccountMappings().forEach(entity -> {
			chartOfAccountMappings.add(chartOfAccountMappingService.updateOldData(entity));
		});
		rawEntity.setChartOfAccountMappings(chartOfAccountMappings);

		ChartOfAccountEntity entityFromDb = chartOfAccountService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		ChartOfAccountEntity newEntity = chartOfAccountService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link ChartOfAccountMutationResolver#updateChartOfAccount(ChartOfAccountEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'update')")
	public List<ChartOfAccountEntity> updateAllChartOfAccount(@NonNull List<ChartOfAccountEntity> rawEntities) {
		List<ChartOfAccountEntity> newEntities = Lists.newArrayList(chartOfAccountService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'delete')")
	public String deleteChartOfAccountById(@NonNull String id) {
		chartOfAccountService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link ChartOfAccountMutationResolver#deleteChartOfAccountById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'delete')")
	public List<String> deleteAllChartOfAccountByIds(@NonNull List<String> ids) {
		chartOfAccountService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('ChartOfAccountEntity', 'delete')")
	public List<String> deleteChartOfAccountExcludingIds(@NonNull List<String> ids) {
		chartOfAccountService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
