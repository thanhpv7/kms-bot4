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
import kmsweb.entities.UnitOfMeasurementEntity;
import kmsweb.services.UnitOfMeasurementService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.CatalogueUOMService;
import kmsweb.entities.CatalogueUOMEntity;
import kmsweb.services.CompoundPrescriptionDetailService;
import kmsweb.entities.CompoundPrescriptionDetailEntity;
import kmsweb.services.CompoundPrescriptionItemService;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.services.MedicationCompoundService;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.services.MedicationItemService;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.services.PrescriptionCompoundService;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.services.PrescriptionItemService;
import kmsweb.entities.PrescriptionItemEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class UnitOfMeasurementMutationResolver implements GraphQLMutationResolver {

	private final UnitOfMeasurementService unitOfMeasurementService;

	private final CatalogueUOMService catalogueUOMService;

	private final CompoundPrescriptionDetailService compoundPrescriptionDetailService;

	private final CompoundPrescriptionItemService compoundPrescriptionItemService;

	private final MedicationCompoundService medicationCompoundService;

	private final MedicationItemService medicationItemService;

	private final PrescriptionCompoundService prescriptionCompoundService;

	private final PrescriptionItemService prescriptionItemService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public UnitOfMeasurementMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			CatalogueUOMService catalogueUOMService,
			CompoundPrescriptionDetailService compoundPrescriptionDetailService,
			CompoundPrescriptionItemService compoundPrescriptionItemService,
			MedicationCompoundService medicationCompoundService,
			MedicationItemService medicationItemService,
			PrescriptionCompoundService prescriptionCompoundService,
			PrescriptionItemService prescriptionItemService,
			UnitOfMeasurementService unitOfMeasurementService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.unitOfMeasurementService = unitOfMeasurementService;

		this.catalogueUOMService = catalogueUOMService;

		this.compoundPrescriptionDetailService = compoundPrescriptionDetailService;

		this.compoundPrescriptionItemService = compoundPrescriptionItemService;

		this.medicationCompoundService = medicationCompoundService;

		this.medicationItemService = medicationItemService;

		this.prescriptionCompoundService = prescriptionCompoundService;

		this.prescriptionItemService = prescriptionItemService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create')")
	public UnitOfMeasurementEntity createUnitOfMeasurement(@NonNull UnitOfMeasurementEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getCatalogueUOM() != null) {
			rawEntity.setCatalogueUOM(catalogueUOMService.updateOldData(rawEntity.getCatalogueUOM()));
		}

		Set<CompoundPrescriptionDetailEntity> compoundPrescriptionDetails = new HashSet<>();
		rawEntity.getCompoundPrescriptionDetails().forEach(entity -> {
			compoundPrescriptionDetails.add(compoundPrescriptionDetailService.updateOldData(entity));
		});
		rawEntity.setCompoundPrescriptionDetails(compoundPrescriptionDetails);

		Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();
		rawEntity.getCompoundPrescriptionItems().forEach(entity -> {
			compoundPrescriptionItems.add(compoundPrescriptionItemService.updateOldData(entity));
		});
		rawEntity.setCompoundPrescriptionItems(compoundPrescriptionItems);

		Set<PrescriptionCompoundEntity> compoundsUnit = new HashSet<>();
		rawEntity.getCompoundsUnit().forEach(entity -> {
			compoundsUnit.add(prescriptionCompoundService.updateOldData(entity));
		});
		rawEntity.setCompoundsUnit(compoundsUnit);

		Set<MedicationCompoundEntity> medicationCompounds = new HashSet<>();
		rawEntity.getMedicationCompounds().forEach(entity -> {
			medicationCompounds.add(medicationCompoundService.updateOldData(entity));
		});
		rawEntity.setMedicationCompounds(medicationCompounds);

		Set<MedicationItemEntity> medicationItems = new HashSet<>();
		rawEntity.getMedicationItems().forEach(entity -> {
			medicationItems.add(medicationItemService.updateOldData(entity));
		});
		rawEntity.setMedicationItems(medicationItems);

		Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();
		rawEntity.getPrescriptionItems().forEach(entity -> {
			prescriptionItems.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setPrescriptionItems(prescriptionItems);

		UnitOfMeasurementEntity newEntity = unitOfMeasurementService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link UnitOfMeasurementMutationResolver#createUnitOfMeasurement(UnitOfMeasurementEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create')")
	public List<UnitOfMeasurementEntity> createAllUnitOfMeasurement(@NonNull List<UnitOfMeasurementEntity> rawEntities) {
		List<UnitOfMeasurementEntity> newEntities = Lists.newArrayList(unitOfMeasurementService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'update')")
	public UnitOfMeasurementEntity updateUnitOfMeasurement(@NonNull UnitOfMeasurementEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getCatalogueUOM() != null) {
			rawEntity.setCatalogueUOM(catalogueUOMService.updateOldData(rawEntity.getCatalogueUOM()));
		}

		Set<CompoundPrescriptionDetailEntity> compoundPrescriptionDetails = new HashSet<>();
		rawEntity.getCompoundPrescriptionDetails().forEach(entity -> {
			compoundPrescriptionDetails.add(compoundPrescriptionDetailService.updateOldData(entity));
		});
		rawEntity.setCompoundPrescriptionDetails(compoundPrescriptionDetails);

		Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();
		rawEntity.getCompoundPrescriptionItems().forEach(entity -> {
			compoundPrescriptionItems.add(compoundPrescriptionItemService.updateOldData(entity));
		});
		rawEntity.setCompoundPrescriptionItems(compoundPrescriptionItems);

		Set<PrescriptionCompoundEntity> compoundsUnit = new HashSet<>();
		rawEntity.getCompoundsUnit().forEach(entity -> {
			compoundsUnit.add(prescriptionCompoundService.updateOldData(entity));
		});
		rawEntity.setCompoundsUnit(compoundsUnit);

		Set<MedicationCompoundEntity> medicationCompounds = new HashSet<>();
		rawEntity.getMedicationCompounds().forEach(entity -> {
			medicationCompounds.add(medicationCompoundService.updateOldData(entity));
		});
		rawEntity.setMedicationCompounds(medicationCompounds);

		Set<MedicationItemEntity> medicationItems = new HashSet<>();
		rawEntity.getMedicationItems().forEach(entity -> {
			medicationItems.add(medicationItemService.updateOldData(entity));
		});
		rawEntity.setMedicationItems(medicationItems);

		Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();
		rawEntity.getPrescriptionItems().forEach(entity -> {
			prescriptionItems.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setPrescriptionItems(prescriptionItems);

		UnitOfMeasurementEntity entityFromDb = unitOfMeasurementService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		UnitOfMeasurementEntity newEntity = unitOfMeasurementService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link UnitOfMeasurementMutationResolver#updateUnitOfMeasurement(UnitOfMeasurementEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'update')")
	public List<UnitOfMeasurementEntity> updateAllUnitOfMeasurement(@NonNull List<UnitOfMeasurementEntity> rawEntities) {
		List<UnitOfMeasurementEntity> newEntities = Lists.newArrayList(unitOfMeasurementService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'delete')")
	public String deleteUnitOfMeasurementById(@NonNull String id) {
		unitOfMeasurementService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link UnitOfMeasurementMutationResolver#deleteUnitOfMeasurementById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'delete')")
	public List<String> deleteAllUnitOfMeasurementByIds(@NonNull List<String> ids) {
		unitOfMeasurementService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'delete')")
	public List<String> deleteUnitOfMeasurementExcludingIds(@NonNull List<String> ids) {
		unitOfMeasurementService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
