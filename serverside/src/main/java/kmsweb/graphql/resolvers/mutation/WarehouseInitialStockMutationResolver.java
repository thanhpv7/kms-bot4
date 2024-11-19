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
import kmsweb.entities.WarehouseInitialStockEntity;
import kmsweb.services.WarehouseInitialStockService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.LocationService;
import kmsweb.entities.LocationEntity;
import kmsweb.services.StockCatalogueService;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.services.WarehouseService;
import kmsweb.entities.WarehouseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class WarehouseInitialStockMutationResolver implements GraphQLMutationResolver {

	private final WarehouseInitialStockService warehouseInitialStockService;

	private final LocationService locationService;

	private final StockCatalogueService stockCatalogueService;

	private final WarehouseService warehouseService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public WarehouseInitialStockMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			LocationService locationService,
			StockCatalogueService stockCatalogueService,
			WarehouseService warehouseService,
			WarehouseInitialStockService warehouseInitialStockService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.warehouseInitialStockService = warehouseInitialStockService;

		this.locationService = locationService;

		this.stockCatalogueService = stockCatalogueService;

		this.warehouseService = warehouseService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'create')")
	public WarehouseInitialStockEntity createWarehouseInitialStock(@NonNull WarehouseInitialStockEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getLocation() != null) {
			rawEntity.setLocation(locationService.updateOldData(rawEntity.getLocation()));
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		WarehouseInitialStockEntity newEntity = warehouseInitialStockService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link WarehouseInitialStockMutationResolver#createWarehouseInitialStock(WarehouseInitialStockEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'create')")
	public List<WarehouseInitialStockEntity> createAllWarehouseInitialStock(@NonNull List<WarehouseInitialStockEntity> rawEntities) {
		List<WarehouseInitialStockEntity> newEntities = Lists.newArrayList(warehouseInitialStockService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'update')")
	public WarehouseInitialStockEntity updateWarehouseInitialStock(@NonNull WarehouseInitialStockEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getLocation() != null) {
			rawEntity.setLocation(locationService.updateOldData(rawEntity.getLocation()));
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		WarehouseInitialStockEntity entityFromDb = warehouseInitialStockService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		WarehouseInitialStockEntity newEntity = warehouseInitialStockService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link WarehouseInitialStockMutationResolver#updateWarehouseInitialStock(WarehouseInitialStockEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'update')")
	public List<WarehouseInitialStockEntity> updateAllWarehouseInitialStock(@NonNull List<WarehouseInitialStockEntity> rawEntities) {
		List<WarehouseInitialStockEntity> newEntities = Lists.newArrayList(warehouseInitialStockService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'delete')")
	public String deleteWarehouseInitialStockById(@NonNull String id) {
		warehouseInitialStockService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link WarehouseInitialStockMutationResolver#deleteWarehouseInitialStockById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'delete')")
	public List<String> deleteAllWarehouseInitialStockByIds(@NonNull List<String> ids) {
		warehouseInitialStockService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'delete')")
	public List<String> deleteWarehouseInitialStockExcludingIds(@NonNull List<String> ids) {
		warehouseInitialStockService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
