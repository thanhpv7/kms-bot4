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
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.PrescriptionHeaderService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.InvoiceItemService;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.services.PrescriptionCompoundService;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.services.PrescriptionItemService;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;
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
public class PrescriptionHeaderMutationResolver implements GraphQLMutationResolver {

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final InvoiceService invoiceService;

	private final InvoiceItemService invoiceItemService;

	private final PrescriptionCompoundService prescriptionCompoundService;

	private final PrescriptionItemService prescriptionItemService;

	private final RegistrationService registrationService;

	private final StaffService staffService;

	private final WarehouseService warehouseService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PrescriptionHeaderMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InvoiceService invoiceService,
			InvoiceItemService invoiceItemService,
			PrescriptionCompoundService prescriptionCompoundService,
			PrescriptionItemService prescriptionItemService,
			RegistrationService registrationService,
			StaffService staffService,
			WarehouseService warehouseService,
			PrescriptionHeaderService prescriptionHeaderService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.invoiceService = invoiceService;

		this.invoiceItemService = invoiceItemService;

		this.prescriptionCompoundService = prescriptionCompoundService;

		this.prescriptionItemService = prescriptionItemService;

		this.registrationService = registrationService;

		this.staffService = staffService;

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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create')")
	public PrescriptionHeaderEntity createPrescriptionHeader(@NonNull PrescriptionHeaderEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoice() != null) {
			rawEntity.setInvoice(invoiceService.updateOldData(rawEntity.getInvoice()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getRequestedBy() != null) {
			rawEntity.setRequestedBy(staffService.updateOldData(rawEntity.getRequestedBy()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<PrescriptionCompoundEntity> prescriptionCompounds = new HashSet<>();
		rawEntity.getPrescriptionCompounds().forEach(entity -> {
			prescriptionCompounds.add(prescriptionCompoundService.updateOldData(entity));
		});
		rawEntity.setPrescriptionCompounds(prescriptionCompounds);

		Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();
		rawEntity.getPrescriptionItems().forEach(entity -> {
			prescriptionItems.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setPrescriptionItems(prescriptionItems);

		PrescriptionHeaderEntity newEntity = prescriptionHeaderService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PrescriptionHeaderMutationResolver#createPrescriptionHeader(PrescriptionHeaderEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create')")
	public List<PrescriptionHeaderEntity> createAllPrescriptionHeader(@NonNull List<PrescriptionHeaderEntity> rawEntities) {
		List<PrescriptionHeaderEntity> newEntities = Lists.newArrayList(prescriptionHeaderService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'update')")
	public PrescriptionHeaderEntity updatePrescriptionHeader(@NonNull PrescriptionHeaderEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoice() != null) {
			rawEntity.setInvoice(invoiceService.updateOldData(rawEntity.getInvoice()));
		}

		if (rawEntity.getRegistration() != null) {
			rawEntity.setRegistration(registrationService.updateOldData(rawEntity.getRegistration()));
		}

		if (rawEntity.getRequestedBy() != null) {
			rawEntity.setRequestedBy(staffService.updateOldData(rawEntity.getRequestedBy()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<PrescriptionCompoundEntity> prescriptionCompounds = new HashSet<>();
		rawEntity.getPrescriptionCompounds().forEach(entity -> {
			prescriptionCompounds.add(prescriptionCompoundService.updateOldData(entity));
		});
		rawEntity.setPrescriptionCompounds(prescriptionCompounds);

		Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();
		rawEntity.getPrescriptionItems().forEach(entity -> {
			prescriptionItems.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setPrescriptionItems(prescriptionItems);

		PrescriptionHeaderEntity entityFromDb = prescriptionHeaderService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PrescriptionHeaderEntity newEntity = prescriptionHeaderService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PrescriptionHeaderMutationResolver#updatePrescriptionHeader(PrescriptionHeaderEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'update')")
	public List<PrescriptionHeaderEntity> updateAllPrescriptionHeader(@NonNull List<PrescriptionHeaderEntity> rawEntities) {
		List<PrescriptionHeaderEntity> newEntities = Lists.newArrayList(prescriptionHeaderService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'delete')")
	public String deletePrescriptionHeaderById(@NonNull String id) {
		prescriptionHeaderService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PrescriptionHeaderMutationResolver#deletePrescriptionHeaderById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'delete')")
	public List<String> deleteAllPrescriptionHeaderByIds(@NonNull List<String> ids) {
		prescriptionHeaderService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'delete')")
	public List<String> deletePrescriptionHeaderExcludingIds(@NonNull List<String> ids) {
		prescriptionHeaderService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] on begin
	// add new method
	public void updatePrescriptionHeader() {
		System.out.println("updating...");
	}
	// % protected region % [Import any additional class methods here] end
}
