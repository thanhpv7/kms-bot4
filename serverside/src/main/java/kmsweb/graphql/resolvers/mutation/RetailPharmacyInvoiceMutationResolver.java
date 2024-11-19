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
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.services.RetailPharmacyInvoiceService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.CashReceiptService;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.services.InvoiceItemService;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.services.InvoiceSummaryService;
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.services.RetailPharmacyService;
import kmsweb.entities.RetailPharmacyEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class RetailPharmacyInvoiceMutationResolver implements GraphQLMutationResolver {

	private final RetailPharmacyInvoiceService retailPharmacyInvoiceService;

	private final CashReceiptService cashReceiptService;

	private final InvoiceItemService invoiceItemService;

	private final InvoiceSummaryService invoiceSummaryService;

	private final RetailPharmacyService retailPharmacyService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RetailPharmacyInvoiceMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			CashReceiptService cashReceiptService,
			InvoiceItemService invoiceItemService,
			InvoiceSummaryService invoiceSummaryService,
			RetailPharmacyService retailPharmacyService,
			RetailPharmacyInvoiceService retailPharmacyInvoiceService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.retailPharmacyInvoiceService = retailPharmacyInvoiceService;

		this.cashReceiptService = cashReceiptService;

		this.invoiceItemService = invoiceItemService;

		this.invoiceSummaryService = invoiceSummaryService;

		this.retailPharmacyService = retailPharmacyService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create')")
	public RetailPharmacyInvoiceEntity createRetailPharmacyInvoice(@NonNull RetailPharmacyInvoiceEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoiceSummary() != null) {
			rawEntity.setInvoiceSummary(invoiceSummaryService.updateOldData(rawEntity.getInvoiceSummary()));
		}

		if (rawEntity.getRetailPharmacy() != null) {
			rawEntity.setRetailPharmacy(retailPharmacyService.updateOldData(rawEntity.getRetailPharmacy()));
		}

		Set<CashReceiptEntity> cashReceipts = new HashSet<>();
		rawEntity.getCashReceipts().forEach(entity -> {
			cashReceipts.add(cashReceiptService.updateOldData(entity));
		});
		rawEntity.setCashReceipts(cashReceipts);

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		RetailPharmacyInvoiceEntity newEntity = retailPharmacyInvoiceService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RetailPharmacyInvoiceMutationResolver#createRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create')")
	public List<RetailPharmacyInvoiceEntity> createAllRetailPharmacyInvoice(@NonNull List<RetailPharmacyInvoiceEntity> rawEntities) {
		List<RetailPharmacyInvoiceEntity> newEntities = Lists.newArrayList(retailPharmacyInvoiceService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public RetailPharmacyInvoiceEntity updateRetailPharmacyInvoice(@NonNull RetailPharmacyInvoiceEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoiceSummary() != null) {
			rawEntity.setInvoiceSummary(invoiceSummaryService.updateOldData(rawEntity.getInvoiceSummary()));
		}

		if (rawEntity.getRetailPharmacy() != null) {
			rawEntity.setRetailPharmacy(retailPharmacyService.updateOldData(rawEntity.getRetailPharmacy()));
		}

		Set<CashReceiptEntity> cashReceipts = new HashSet<>();
		rawEntity.getCashReceipts().forEach(entity -> {
			cashReceipts.add(cashReceiptService.updateOldData(entity));
		});
		rawEntity.setCashReceipts(cashReceipts);

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		RetailPharmacyInvoiceEntity entityFromDb = retailPharmacyInvoiceService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		RetailPharmacyInvoiceEntity newEntity = retailPharmacyInvoiceService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RetailPharmacyInvoiceMutationResolver#updateRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public List<RetailPharmacyInvoiceEntity> updateAllRetailPharmacyInvoice(@NonNull List<RetailPharmacyInvoiceEntity> rawEntities) {
		List<RetailPharmacyInvoiceEntity> newEntities = Lists.newArrayList(retailPharmacyInvoiceService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'delete')")
	public String deleteRetailPharmacyInvoiceById(@NonNull String id) {
		retailPharmacyInvoiceService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link RetailPharmacyInvoiceMutationResolver#deleteRetailPharmacyInvoiceById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'delete')")
	public List<String> deleteAllRetailPharmacyInvoiceByIds(@NonNull List<String> ids) {
		retailPharmacyInvoiceService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'delete')")
	public List<String> deleteRetailPharmacyInvoiceExcludingIds(@NonNull List<String> ids) {
		retailPharmacyInvoiceService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
