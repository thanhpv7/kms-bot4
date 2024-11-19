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
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.services.RetailPharmacyService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.PatientGeneralInfoService;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.services.RetailPharmacyInvoiceService;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.services.RetailPharmacyStockDetailService;
import kmsweb.entities.RetailPharmacyStockDetailEntity;
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
public class RetailPharmacyMutationResolver implements GraphQLMutationResolver {

	private final RetailPharmacyService retailPharmacyService;

	private final PatientGeneralInfoService patientGeneralInfoService;

	private final RetailPharmacyInvoiceService retailPharmacyInvoiceService;

	private final RetailPharmacyStockDetailService retailPharmacyStockDetailService;

	private final WarehouseService warehouseService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RetailPharmacyMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PatientGeneralInfoService patientGeneralInfoService,
			RetailPharmacyInvoiceService retailPharmacyInvoiceService,
			RetailPharmacyStockDetailService retailPharmacyStockDetailService,
			WarehouseService warehouseService,
			RetailPharmacyService retailPharmacyService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.retailPharmacyService = retailPharmacyService;

		this.patientGeneralInfoService = patientGeneralInfoService;

		this.retailPharmacyInvoiceService = retailPharmacyInvoiceService;

		this.retailPharmacyStockDetailService = retailPharmacyStockDetailService;

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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create')")
	public RetailPharmacyEntity createRetailPharmacy(@NonNull RetailPharmacyEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<RetailPharmacyInvoiceEntity> retailPharmacyInvoices = new HashSet<>();
		rawEntity.getRetailPharmacyInvoices().forEach(entity -> {
			retailPharmacyInvoices.add(retailPharmacyInvoiceService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacyInvoices(retailPharmacyInvoices);

		Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();
		rawEntity.getRetailPharmacyStockDetails().forEach(entity -> {
			retailPharmacyStockDetails.add(retailPharmacyStockDetailService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacyStockDetails(retailPharmacyStockDetails);

		RetailPharmacyEntity newEntity = retailPharmacyService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RetailPharmacyMutationResolver#createRetailPharmacy(RetailPharmacyEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create')")
	public List<RetailPharmacyEntity> createAllRetailPharmacy(@NonNull List<RetailPharmacyEntity> rawEntities) {
		List<RetailPharmacyEntity> newEntities = Lists.newArrayList(retailPharmacyService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'update')")
	public RetailPharmacyEntity updateRetailPharmacy(@NonNull RetailPharmacyEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientGeneralInfo() != null) {
			rawEntity.setPatientGeneralInfo(patientGeneralInfoService.updateOldData(rawEntity.getPatientGeneralInfo()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<RetailPharmacyInvoiceEntity> retailPharmacyInvoices = new HashSet<>();
		rawEntity.getRetailPharmacyInvoices().forEach(entity -> {
			retailPharmacyInvoices.add(retailPharmacyInvoiceService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacyInvoices(retailPharmacyInvoices);

		Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();
		rawEntity.getRetailPharmacyStockDetails().forEach(entity -> {
			retailPharmacyStockDetails.add(retailPharmacyStockDetailService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacyStockDetails(retailPharmacyStockDetails);

		RetailPharmacyEntity entityFromDb = retailPharmacyService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		RetailPharmacyEntity newEntity = retailPharmacyService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RetailPharmacyMutationResolver#updateRetailPharmacy(RetailPharmacyEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'update')")
	public List<RetailPharmacyEntity> updateAllRetailPharmacy(@NonNull List<RetailPharmacyEntity> rawEntities) {
		List<RetailPharmacyEntity> newEntities = Lists.newArrayList(retailPharmacyService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'delete')")
	public String deleteRetailPharmacyById(@NonNull String id) {
		retailPharmacyService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link RetailPharmacyMutationResolver#deleteRetailPharmacyById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'delete')")
	public List<String> deleteAllRetailPharmacyByIds(@NonNull List<String> ids) {
		retailPharmacyService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'delete')")
	public List<String> deleteRetailPharmacyExcludingIds(@NonNull List<String> ids) {
		retailPharmacyService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
