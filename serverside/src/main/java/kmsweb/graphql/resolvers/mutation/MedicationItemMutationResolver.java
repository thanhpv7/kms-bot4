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
import kmsweb.entities.MedicationItemEntity;
import kmsweb.services.MedicationItemService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.MedicationAdministeredHistoryService;
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.services.MedicationCompoundService;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.services.MedicationHeaderService;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.services.StockCatalogueService;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.services.UnitOfMeasurementService;
import kmsweb.entities.UnitOfMeasurementEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class MedicationItemMutationResolver implements GraphQLMutationResolver {

	private final MedicationItemService medicationItemService;

	private final MedicationAdministeredHistoryService medicationAdministeredHistoryService;

	private final MedicationCompoundService medicationCompoundService;

	private final MedicationHeaderService medicationHeaderService;

	private final StockCatalogueService stockCatalogueService;

	private final UnitOfMeasurementService unitOfMeasurementService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicationItemMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			MedicationAdministeredHistoryService medicationAdministeredHistoryService,
			MedicationCompoundService medicationCompoundService,
			MedicationHeaderService medicationHeaderService,
			StockCatalogueService stockCatalogueService,
			UnitOfMeasurementService unitOfMeasurementService,
			MedicationItemService medicationItemService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.medicationItemService = medicationItemService;

		this.medicationAdministeredHistoryService = medicationAdministeredHistoryService;

		this.medicationCompoundService = medicationCompoundService;

		this.medicationHeaderService = medicationHeaderService;

		this.stockCatalogueService = stockCatalogueService;

		this.unitOfMeasurementService = unitOfMeasurementService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('MedicationItemEntity', 'create')")
	public MedicationItemEntity createMedicationItem(@NonNull MedicationItemEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicationCompound() != null) {
			rawEntity.setMedicationCompound(medicationCompoundService.updateOldData(rawEntity.getMedicationCompound()));
		}

		if (rawEntity.getMedicationHeader() != null) {
			rawEntity.setMedicationHeader(medicationHeaderService.updateOldData(rawEntity.getMedicationHeader()));
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getUnitOfMeasurement() != null) {
			rawEntity.setUnitOfMeasurement(unitOfMeasurementService.updateOldData(rawEntity.getUnitOfMeasurement()));
		}

		Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();
		rawEntity.getMedicationAdministeredHisotries().forEach(entity -> {
			medicationAdministeredHisotries.add(medicationAdministeredHistoryService.updateOldData(entity));
		});
		rawEntity.setMedicationAdministeredHisotries(medicationAdministeredHisotries);

		MedicationItemEntity newEntity = medicationItemService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link MedicationItemMutationResolver#createMedicationItem(MedicationItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicationItemEntity', 'create')")
	public List<MedicationItemEntity> createAllMedicationItem(@NonNull List<MedicationItemEntity> rawEntities) {
		List<MedicationItemEntity> newEntities = Lists.newArrayList(medicationItemService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('MedicationItemEntity', 'update')")
	public MedicationItemEntity updateMedicationItem(@NonNull MedicationItemEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getMedicationCompound() != null) {
			rawEntity.setMedicationCompound(medicationCompoundService.updateOldData(rawEntity.getMedicationCompound()));
		}

		if (rawEntity.getMedicationHeader() != null) {
			rawEntity.setMedicationHeader(medicationHeaderService.updateOldData(rawEntity.getMedicationHeader()));
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getUnitOfMeasurement() != null) {
			rawEntity.setUnitOfMeasurement(unitOfMeasurementService.updateOldData(rawEntity.getUnitOfMeasurement()));
		}

		Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();
		rawEntity.getMedicationAdministeredHisotries().forEach(entity -> {
			medicationAdministeredHisotries.add(medicationAdministeredHistoryService.updateOldData(entity));
		});
		rawEntity.setMedicationAdministeredHisotries(medicationAdministeredHisotries);

		MedicationItemEntity entityFromDb = medicationItemService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		MedicationItemEntity newEntity = medicationItemService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link MedicationItemMutationResolver#updateMedicationItem(MedicationItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicationItemEntity', 'update')")
	public List<MedicationItemEntity> updateAllMedicationItem(@NonNull List<MedicationItemEntity> rawEntities) {
		List<MedicationItemEntity> newEntities = Lists.newArrayList(medicationItemService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('MedicationItemEntity', 'delete')")
	public String deleteMedicationItemById(@NonNull String id) {
		medicationItemService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link MedicationItemMutationResolver#deleteMedicationItemById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('MedicationItemEntity', 'delete')")
	public List<String> deleteAllMedicationItemByIds(@NonNull List<String> ids) {
		medicationItemService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('MedicationItemEntity', 'delete')")
	public List<String> deleteMedicationItemExcludingIds(@NonNull List<String> ids) {
		medicationItemService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
