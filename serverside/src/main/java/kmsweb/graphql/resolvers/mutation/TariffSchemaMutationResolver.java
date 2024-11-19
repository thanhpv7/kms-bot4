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
import kmsweb.entities.TariffSchemaEntity;
import kmsweb.services.TariffSchemaService;
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
import kmsweb.services.TariffDefinitionService;
import kmsweb.entities.TariffDefinitionEntity;
import kmsweb.services.TariffFormulaService;
import kmsweb.entities.TariffFormulaEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class TariffSchemaMutationResolver implements GraphQLMutationResolver {

	private final TariffSchemaService tariffSchemaService;

	private final InvoiceService invoiceService;

	private final InvoiceItemService invoiceItemService;

	private final TariffDefinitionService tariffDefinitionService;

	private final TariffFormulaService tariffFormulaService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TariffSchemaMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InvoiceService invoiceService,
			InvoiceItemService invoiceItemService,
			TariffDefinitionService tariffDefinitionService,
			TariffFormulaService tariffFormulaService,
			TariffSchemaService tariffSchemaService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.tariffSchemaService = tariffSchemaService;

		this.invoiceService = invoiceService;

		this.invoiceItemService = invoiceItemService;

		this.tariffDefinitionService = tariffDefinitionService;

		this.tariffFormulaService = tariffFormulaService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create')")
	public TariffSchemaEntity createTariffSchema(@NonNull TariffSchemaEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<TariffFormulaEntity> baseScheme = new HashSet<>();
		rawEntity.getBaseScheme().forEach(entity -> {
			baseScheme.add(tariffFormulaService.updateOldData(entity));
		});
		rawEntity.setBaseScheme(baseScheme);

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<InvoiceEntity> invoices = new HashSet<>();
		rawEntity.getInvoices().forEach(entity -> {
			invoices.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoices(invoices);

		Set<TariffDefinitionEntity> tariffDefinitions = new HashSet<>();
		rawEntity.getTariffDefinitions().forEach(entity -> {
			tariffDefinitions.add(tariffDefinitionService.updateOldData(entity));
		});
		rawEntity.setTariffDefinitions(tariffDefinitions);

		Set<TariffFormulaEntity> tariffScheme = new HashSet<>();
		rawEntity.getTariffScheme().forEach(entity -> {
			tariffScheme.add(tariffFormulaService.updateOldData(entity));
		});
		rawEntity.setTariffScheme(tariffScheme);

		TariffSchemaEntity newEntity = tariffSchemaService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link TariffSchemaMutationResolver#createTariffSchema(TariffSchemaEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create')")
	public List<TariffSchemaEntity> createAllTariffSchema(@NonNull List<TariffSchemaEntity> rawEntities) {
		List<TariffSchemaEntity> newEntities = Lists.newArrayList(tariffSchemaService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'update')")
	public TariffSchemaEntity updateTariffSchema(@NonNull TariffSchemaEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<TariffFormulaEntity> baseScheme = new HashSet<>();
		rawEntity.getBaseScheme().forEach(entity -> {
			baseScheme.add(tariffFormulaService.updateOldData(entity));
		});
		rawEntity.setBaseScheme(baseScheme);

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<InvoiceEntity> invoices = new HashSet<>();
		rawEntity.getInvoices().forEach(entity -> {
			invoices.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoices(invoices);

		Set<TariffDefinitionEntity> tariffDefinitions = new HashSet<>();
		rawEntity.getTariffDefinitions().forEach(entity -> {
			tariffDefinitions.add(tariffDefinitionService.updateOldData(entity));
		});
		rawEntity.setTariffDefinitions(tariffDefinitions);

		Set<TariffFormulaEntity> tariffScheme = new HashSet<>();
		rawEntity.getTariffScheme().forEach(entity -> {
			tariffScheme.add(tariffFormulaService.updateOldData(entity));
		});
		rawEntity.setTariffScheme(tariffScheme);

		TariffSchemaEntity entityFromDb = tariffSchemaService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		TariffSchemaEntity newEntity = tariffSchemaService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link TariffSchemaMutationResolver#updateTariffSchema(TariffSchemaEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'update')")
	public List<TariffSchemaEntity> updateAllTariffSchema(@NonNull List<TariffSchemaEntity> rawEntities) {
		List<TariffSchemaEntity> newEntities = Lists.newArrayList(tariffSchemaService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'delete')")
	public String deleteTariffSchemaById(@NonNull String id) {
		tariffSchemaService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link TariffSchemaMutationResolver#deleteTariffSchemaById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'delete')")
	public List<String> deleteAllTariffSchemaByIds(@NonNull List<String> ids) {
		tariffSchemaService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('TariffSchemaEntity', 'delete')")
	public List<String> deleteTariffSchemaExcludingIds(@NonNull List<String> ids) {
		tariffSchemaService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
