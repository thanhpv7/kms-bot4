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

package kmsweb.graphql.resolvers.query;

import kmsweb.graphql.utils.*;
import kmsweb.entities.SupplierBankAccountEntity;
import kmsweb.entities.SupplierBankAccountEntityAudit;
import kmsweb.services.SupplierBankAccountService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class SupplierBankAccountQueryResolver implements GraphQLQueryResolver {

	private final SupplierBankAccountService supplierBankAccountService;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SupplierBankAccountQueryResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			SupplierBankAccountService supplierBankAccountService
	) {
		this.supplierBankAccountService = supplierBankAccountService;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Count the number of Supplier Bank Account records in the data with the given conditions.
	 *
	 * @param conditions the conditions with which the query will be run
	 * @return the number of records in the database that matches the conditions
	 */
	@PreAuthorize("hasPermission('SupplierBankAccountEntity', 'read')")
	public int countSupplierBankAccounts(List<List<Where>> conditions) {
		return (int) supplierBankAccountService.count(conditions);
	}

	/**
	 * Return the Supplier Bank Account with the given ID.
	 *
	 * @param id the ID of the entity being queried
	 * @return the entity with the given ID
	 */
	@PreAuthorize("hasPermission('SupplierBankAccountEntity', 'read')")
	public SupplierBankAccountEntity supplierBankAccountById(String id) {
		SupplierBankAccountEntity entity = supplierBankAccountService.findById(UUID.fromString(id)).orElse(null);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	/**
	 * Return a list of Supplier Bank Account records with the given predicates.
	 *
	 * @param pageIndex  window number that captures the records to be fetched in the database
	 * @param pageSize   how many records in the window
	 * @param orders     the orders of the returned list
	 * @param conditions the conditions to filter the records
	 * @return the list with the given predicates
	 */
	@PreAuthorize("hasPermission('SupplierBankAccountEntity', 'read')")
	public List<SupplierBankAccountEntity> supplierBankAccounts(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		// % protected region % [Add any additional logic for findWithQuery before main logic here] off begin
		// % protected region % [Add any additional logic for findWithQuery before main logic here] end

		List<SupplierBankAccountEntity> entities = Lists.newArrayList(supplierBankAccountService.findSortedPageWithQuery(
				pageIndex,
				pageSize,
				conditions,
				Sort.by(OrderBy.toSortOrders(orders))
		));

		// % protected region % [Add any additional logic for findWithQuery after main logic here] off begin
		// % protected region % [Add any additional logic for findWithQuery after main logic here] end

		return entities;
	}

	/**
	 * Similar to {@link SupplierBankAccountQueryResolver#supplierBankAccounts(int,int,List,List)} but the page index starts
	 * from the tail end.
	 */
	@PreAuthorize("hasPermission('SupplierBankAccountEntity', 'read')")
	public List<SupplierBankAccountEntity> lastSupplierBankAccounts(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		long count = supplierBankAccountService.count();

		// Can be risky since overflow may happen
		int lastPageIndex = (int) (count / pageSize);

		// Reverse the index to get the k-last page.
		int reversedIndex = lastPageIndex - pageIndex;

		List<SupplierBankAccountEntity> entities = Lists.newArrayList(supplierBankAccountService.findSortedPageWithQuery(
				reversedIndex,
				pageSize,
				conditions,
				Sort.by(OrderBy.toSortOrders(orders))
		));

		// % protected region % [Add any additional logic for findAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAll before returning the entities here] end

		return entities;
	}

	/**
	 * Return a list of {@link SupplierBankAccountEntityAudit} entities.
	 *
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('SupplierBankAccountEntity', 'read')")
	public List<SupplierBankAccountEntityAudit> supplierBankAccountAudits() {
		List<SupplierBankAccountEntityAudit> audits = supplierBankAccountService.getAudits();

		// % protected region % [Add any additional logic for SupplierBankAccountAudits before returning the audits here] off begin
		// % protected region % [Add any additional logic for SupplierBankAccountAudits before returning the audits here] end

		return audits;
	}

	/**
	 * Return a list of {@link SupplierBankAccountEntityAudit} entities filtered by a given entity id.
	 *
	 * @param id The id of the entity to filter by.
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('SupplierBankAccountEntity', 'read')")
	public List<SupplierBankAccountEntityAudit> supplierBankAccountAuditsByEntityId(@NonNull UUID id) {
		List<SupplierBankAccountEntityAudit> audits = supplierBankAccountService.getAuditsByEntityId(id);

		// % protected region % [Add any additional logic for SupplierBankAccountAuditsByEntityId before returning the audits here] off begin
		// % protected region % [Add any additional logic for SupplierBankAccountAuditsByEntityId before returning the audits here] end

		return audits;
	}




	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
