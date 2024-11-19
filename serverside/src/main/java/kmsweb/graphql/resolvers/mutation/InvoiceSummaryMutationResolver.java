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
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.services.InvoiceSummaryService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.RetailPharmacyInvoiceService;
import kmsweb.entities.RetailPharmacyInvoiceEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class InvoiceSummaryMutationResolver implements GraphQLMutationResolver {

	private final InvoiceSummaryService invoiceSummaryService;

	private final InvoiceService invoiceService;

	private final RetailPharmacyInvoiceService retailPharmacyInvoiceService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InvoiceSummaryMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InvoiceService invoiceService,
			RetailPharmacyInvoiceService retailPharmacyInvoiceService,
			InvoiceSummaryService invoiceSummaryService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.invoiceSummaryService = invoiceSummaryService;

		this.invoiceService = invoiceService;

		this.retailPharmacyInvoiceService = retailPharmacyInvoiceService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create')")
	public InvoiceSummaryEntity createInvoiceSummary(@NonNull InvoiceSummaryEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoice() != null) {
			rawEntity.setInvoice(invoiceService.updateOldData(rawEntity.getInvoice()));
		}

		if (rawEntity.getRetailPharmacyInvoice() != null) {
			rawEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceService.updateOldData(rawEntity.getRetailPharmacyInvoice()));
		}

		InvoiceSummaryEntity newEntity = invoiceSummaryService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InvoiceSummaryMutationResolver#createInvoiceSummary(InvoiceSummaryEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create')")
	public List<InvoiceSummaryEntity> createAllInvoiceSummary(@NonNull List<InvoiceSummaryEntity> rawEntities) {
		List<InvoiceSummaryEntity> newEntities = Lists.newArrayList(invoiceSummaryService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'update')")
	public InvoiceSummaryEntity updateInvoiceSummary(@NonNull InvoiceSummaryEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getInvoice() != null) {
			rawEntity.setInvoice(invoiceService.updateOldData(rawEntity.getInvoice()));
		}

		if (rawEntity.getRetailPharmacyInvoice() != null) {
			rawEntity.setRetailPharmacyInvoice(retailPharmacyInvoiceService.updateOldData(rawEntity.getRetailPharmacyInvoice()));
		}

		InvoiceSummaryEntity entityFromDb = invoiceSummaryService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		InvoiceSummaryEntity newEntity = invoiceSummaryService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InvoiceSummaryMutationResolver#updateInvoiceSummary(InvoiceSummaryEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'update')")
	public List<InvoiceSummaryEntity> updateAllInvoiceSummary(@NonNull List<InvoiceSummaryEntity> rawEntities) {
		List<InvoiceSummaryEntity> newEntities = Lists.newArrayList(invoiceSummaryService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'delete')")
	public String deleteInvoiceSummaryById(@NonNull String id) {
		invoiceSummaryService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link InvoiceSummaryMutationResolver#deleteInvoiceSummaryById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'delete')")
	public List<String> deleteAllInvoiceSummaryByIds(@NonNull List<String> ids) {
		invoiceSummaryService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'delete')")
	public List<String> deleteInvoiceSummaryExcludingIds(@NonNull List<String> ids) {
		invoiceSummaryService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
