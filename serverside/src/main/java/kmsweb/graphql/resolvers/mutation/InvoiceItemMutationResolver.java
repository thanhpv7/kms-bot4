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
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.services.InvoiceItemService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.InvoiceItemComponentService;
import kmsweb.entities.InvoiceItemComponentEntity;
import kmsweb.services.MedicalFeeService;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.services.MedicationHeaderService;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.RetailPharmacyInvoiceService;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.services.TariffSchemaService;
import kmsweb.entities.TariffSchemaEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class InvoiceItemMutationResolver implements GraphQLMutationResolver {

	private final InvoiceItemService invoiceItemService;

	private final InvoiceService invoiceService;

	private final InvoiceItemComponentService invoiceItemComponentService;

	private final MedicalFeeService medicalFeeService;

	private final MedicationHeaderService medicationHeaderService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final RegistrationService registrationService;

	private final RetailPharmacyInvoiceService retailPharmacyInvoiceService;

	private final TariffSchemaService tariffSchemaService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InvoiceItemMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InvoiceService invoiceService,
			InvoiceItemComponentService invoiceItemComponentService,
			MedicalFeeService medicalFeeService,
			MedicationHeaderService medicationHeaderService,
			PrescriptionHeaderService prescriptionHeaderService,
			RegistrationService registrationService,
			RetailPharmacyInvoiceService retailPharmacyInvoiceService,
			TariffSchemaService tariffSchemaService,
			InvoiceItemService invoiceItemService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.invoiceItemService = invoiceItemService;

		this.invoiceService = invoiceService;

		this.invoiceItemComponentService = invoiceItemComponentService;

		this.medicalFeeService = medicalFeeService;

		this.medicationHeaderService = medicationHeaderService;

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.registrationService = registrationService;

		this.retailPharmacyInvoiceService = retailPharmacyInvoiceService;

		this.tariffSchemaService = tariffSchemaService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create')")
	public InvoiceItemEntity createInvoiceItem(@NonNull InvoiceItemEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoice() != null) {
			rawEntity.setInvoice(invoiceService.updateOldData(rawEntity.getInvoice()));
		}

		if (rawEntity.getMedicalFee() != null) {
			rawEntity.setMedicalFee(medicalFeeService.updateOldData(rawEntity.getMedicalFee()));
		}

		if (rawEntity.getMedicationHeader() != null) {
			rawEntity.setMedicationHeader(medicationHeaderService.updateOldData(rawEntity.getMedicationHeader()));
		}

		if (rawEntity.getPrescription() != null) {
			rawEntity.setPrescription(prescriptionHeaderService.updateOldData(rawEntity.getPrescription()));
		}

		if (rawEntity.getRetailPharmacyInvoice() != null) {
			rawEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceService.updateOldData(rawEntity.getRetailPharmacyInvoice()));
		}

		if (rawEntity.getServiceNumber() != null) {
			rawEntity.setServiceNumber(registrationService.updateOldData(rawEntity.getServiceNumber()));
		}

		if (rawEntity.getTariffSchema() != null) {
			rawEntity.setTariffSchema(tariffSchemaService.updateOldData(rawEntity.getTariffSchema()));
		}

		Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();
		rawEntity.getInvoiceItemComponents().forEach(entity -> {
			invoiceItemComponents.add(invoiceItemComponentService.updateOldData(entity));
		});
		rawEntity.setInvoiceItemComponents(invoiceItemComponents);

		InvoiceItemEntity newEntity = invoiceItemService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InvoiceItemMutationResolver#createInvoiceItem(InvoiceItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'create')")
	public List<InvoiceItemEntity> createAllInvoiceItem(@NonNull List<InvoiceItemEntity> rawEntities) {
		List<InvoiceItemEntity> newEntities = Lists.newArrayList(invoiceItemService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'update')")
	public InvoiceItemEntity updateInvoiceItem(@NonNull InvoiceItemEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoice() != null) {
			rawEntity.setInvoice(invoiceService.updateOldData(rawEntity.getInvoice()));
		}

		if (rawEntity.getMedicalFee() != null) {
			rawEntity.setMedicalFee(medicalFeeService.updateOldData(rawEntity.getMedicalFee()));
		}

		if (rawEntity.getMedicationHeader() != null) {
			rawEntity.setMedicationHeader(medicationHeaderService.updateOldData(rawEntity.getMedicationHeader()));
		}

		if (rawEntity.getPrescription() != null) {
			rawEntity.setPrescription(prescriptionHeaderService.updateOldData(rawEntity.getPrescription()));
		}

		if (rawEntity.getRetailPharmacyInvoice() != null) {
			rawEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceService.updateOldData(rawEntity.getRetailPharmacyInvoice()));
		}

		if (rawEntity.getServiceNumber() != null) {
			rawEntity.setServiceNumber(registrationService.updateOldData(rawEntity.getServiceNumber()));
		}

		if (rawEntity.getTariffSchema() != null) {
			rawEntity.setTariffSchema(tariffSchemaService.updateOldData(rawEntity.getTariffSchema()));
		}

		Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();
		rawEntity.getInvoiceItemComponents().forEach(entity -> {
			invoiceItemComponents.add(invoiceItemComponentService.updateOldData(entity));
		});
		rawEntity.setInvoiceItemComponents(invoiceItemComponents);

		InvoiceItemEntity entityFromDb = invoiceItemService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		InvoiceItemEntity newEntity = invoiceItemService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InvoiceItemMutationResolver#updateInvoiceItem(InvoiceItemEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'update')")
	public List<InvoiceItemEntity> updateAllInvoiceItem(@NonNull List<InvoiceItemEntity> rawEntities) {
		List<InvoiceItemEntity> newEntities = Lists.newArrayList(invoiceItemService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'delete')")
	public String deleteInvoiceItemById(@NonNull String id) {
		invoiceItemService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link InvoiceItemMutationResolver#deleteInvoiceItemById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceItemEntity', 'delete')")
	public List<String> deleteAllInvoiceItemByIds(@NonNull List<String> ids) {
		invoiceItemService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('InvoiceItemEntity', 'delete')")
	public List<String> deleteInvoiceItemExcludingIds(@NonNull List<String> ids) {
		invoiceItemService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
