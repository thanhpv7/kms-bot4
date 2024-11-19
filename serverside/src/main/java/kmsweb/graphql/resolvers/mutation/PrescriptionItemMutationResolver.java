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
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.services.PrescriptionItemService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.PrescriptionCompoundService;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
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
public class PrescriptionItemMutationResolver implements GraphQLMutationResolver {

	private final PrescriptionItemService prescriptionItemService;

	private final PrescriptionCompoundService prescriptionCompoundService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final StockCatalogueService stockCatalogueService;

	private final UnitOfMeasurementService unitOfMeasurementService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PrescriptionItemMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PrescriptionCompoundService prescriptionCompoundService,
			PrescriptionHeaderService prescriptionHeaderService,
			StockCatalogueService stockCatalogueService,
			UnitOfMeasurementService unitOfMeasurementService,
			PrescriptionItemService prescriptionItemService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.prescriptionItemService = prescriptionItemService;

		this.prescriptionCompoundService = prescriptionCompoundService;

		this.prescriptionHeaderService = prescriptionHeaderService;

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
	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'create')")
	public PrescriptionItemEntity createPrescriptionItem(@NonNull PrescriptionItemEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getCompound() != null) {
			rawEntity.setCompound(prescriptionCompoundService.updateOldData(rawEntity.getCompound()));
		}

		if (rawEntity.getStockCatalogueId() != null) {
			rawEntity.setStockCatalogueId(stockCatalogueService.updateOldData(rawEntity.getStockCatalogueId()));
		}

		if (rawEntity.getPrescription() != null) {
			rawEntity.setPrescription(prescriptionHeaderService.updateOldData(rawEntity.getPrescription()));
		}

		if (rawEntity.getUnit() != null) {
			rawEntity.setUnit(unitOfMeasurementService.updateOldData(rawEntity.getUnit()));
		}

		PrescriptionItemEntity newEntity = prescriptionItemService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PrescriptionItemMutationResolver#createPrescriptionItem(PrescriptionItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'create')")
	public List<PrescriptionItemEntity> createAllPrescriptionItem(@NonNull List<PrescriptionItemEntity> rawEntities) {
		List<PrescriptionItemEntity> newEntities = Lists.newArrayList(prescriptionItemService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'update')")
	public PrescriptionItemEntity updatePrescriptionItem(@NonNull PrescriptionItemEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getCompound() != null) {
			rawEntity.setCompound(prescriptionCompoundService.updateOldData(rawEntity.getCompound()));
		}

		if (rawEntity.getStockCatalogueId() != null) {
			rawEntity.setStockCatalogueId(stockCatalogueService.updateOldData(rawEntity.getStockCatalogueId()));
		}

		if (rawEntity.getPrescription() != null) {
			rawEntity.setPrescription(prescriptionHeaderService.updateOldData(rawEntity.getPrescription()));
		}

		if (rawEntity.getUnit() != null) {
			rawEntity.setUnit(unitOfMeasurementService.updateOldData(rawEntity.getUnit()));
		}

		PrescriptionItemEntity entityFromDb = prescriptionItemService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PrescriptionItemEntity newEntity = prescriptionItemService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PrescriptionItemMutationResolver#updatePrescriptionItem(PrescriptionItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'update')")
	public List<PrescriptionItemEntity> updateAllPrescriptionItem(@NonNull List<PrescriptionItemEntity> rawEntities) {
		List<PrescriptionItemEntity> newEntities = Lists.newArrayList(prescriptionItemService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'delete')")
	public String deletePrescriptionItemById(@NonNull String id) {
		prescriptionItemService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PrescriptionItemMutationResolver#deletePrescriptionItemById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'delete')")
	public List<String> deleteAllPrescriptionItemByIds(@NonNull List<String> ids) {
		prescriptionItemService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'delete')")
	public List<String> deletePrescriptionItemExcludingIds(@NonNull List<String> ids) {
		prescriptionItemService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
