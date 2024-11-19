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
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.services.PrescriptionCompoundService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.PrescriptionItemService;
import kmsweb.entities.PrescriptionItemEntity;
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
public class PrescriptionCompoundMutationResolver implements GraphQLMutationResolver {

	private final PrescriptionCompoundService prescriptionCompoundService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final PrescriptionItemService prescriptionItemService;

	private final UnitOfMeasurementService unitOfMeasurementService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PrescriptionCompoundMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PrescriptionHeaderService prescriptionHeaderService,
			PrescriptionItemService prescriptionItemService,
			UnitOfMeasurementService unitOfMeasurementService,
			PrescriptionCompoundService prescriptionCompoundService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.prescriptionCompoundService = prescriptionCompoundService;

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.prescriptionItemService = prescriptionItemService;

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
	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'create')")
	public PrescriptionCompoundEntity createPrescriptionCompound(@NonNull PrescriptionCompoundEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getUnit() != null) {
			rawEntity.setUnit(unitOfMeasurementService.updateOldData(rawEntity.getUnit()));
		}

		if (rawEntity.getPrescriptionHeader() != null) {
			rawEntity.setPrescriptionHeader(prescriptionHeaderService.updateOldData(rawEntity.getPrescriptionHeader()));
		}

		Set<PrescriptionItemEntity> compoundItems = new HashSet<>();
		rawEntity.getCompoundItems().forEach(entity -> {
			compoundItems.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setCompoundItems(compoundItems);

		PrescriptionCompoundEntity newEntity = prescriptionCompoundService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PrescriptionCompoundMutationResolver#createPrescriptionCompound(PrescriptionCompoundEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'create')")
	public List<PrescriptionCompoundEntity> createAllPrescriptionCompound(@NonNull List<PrescriptionCompoundEntity> rawEntities) {
		List<PrescriptionCompoundEntity> newEntities = Lists.newArrayList(prescriptionCompoundService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'update')")
	public PrescriptionCompoundEntity updatePrescriptionCompound(@NonNull PrescriptionCompoundEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getUnit() != null) {
			rawEntity.setUnit(unitOfMeasurementService.updateOldData(rawEntity.getUnit()));
		}

		if (rawEntity.getPrescriptionHeader() != null) {
			rawEntity.setPrescriptionHeader(prescriptionHeaderService.updateOldData(rawEntity.getPrescriptionHeader()));
		}

		Set<PrescriptionItemEntity> compoundItems = new HashSet<>();
		rawEntity.getCompoundItems().forEach(entity -> {
			compoundItems.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setCompoundItems(compoundItems);

		PrescriptionCompoundEntity entityFromDb = prescriptionCompoundService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PrescriptionCompoundEntity newEntity = prescriptionCompoundService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PrescriptionCompoundMutationResolver#updatePrescriptionCompound(PrescriptionCompoundEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'update')")
	public List<PrescriptionCompoundEntity> updateAllPrescriptionCompound(@NonNull List<PrescriptionCompoundEntity> rawEntities) {
		List<PrescriptionCompoundEntity> newEntities = Lists.newArrayList(prescriptionCompoundService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'delete')")
	public String deletePrescriptionCompoundById(@NonNull String id) {
		prescriptionCompoundService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PrescriptionCompoundMutationResolver#deletePrescriptionCompoundById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'delete')")
	public List<String> deleteAllPrescriptionCompoundByIds(@NonNull List<String> ids) {
		prescriptionCompoundService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PrescriptionCompoundEntity', 'delete')")
	public List<String> deletePrescriptionCompoundExcludingIds(@NonNull List<String> ids) {
		prescriptionCompoundService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
