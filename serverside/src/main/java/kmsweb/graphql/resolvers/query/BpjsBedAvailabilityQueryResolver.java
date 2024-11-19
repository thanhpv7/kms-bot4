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
import kmsweb.entities.BpjsBedAvailabilityEntity;
import kmsweb.entities.BpjsBedAvailabilityEntityAudit;
import kmsweb.services.BpjsBedAvailabilityService;
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
public class BpjsBedAvailabilityQueryResolver implements GraphQLQueryResolver {

	private final BpjsBedAvailabilityService bpjsBedAvailabilityService;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsBedAvailabilityQueryResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsBedAvailabilityService bpjsBedAvailabilityService
	) {
		this.bpjsBedAvailabilityService = bpjsBedAvailabilityService;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Count the number of BPJS Bed Availability records in the data with the given conditions.
	 *
	 * @param conditions the conditions with which the query will be run
	 * @return the number of records in the database that matches the conditions
	 */
	@PreAuthorize("hasPermission('BpjsBedAvailabilityEntity', 'read')")
	public int countBpjsBedAvailabilitys(List<List<Where>> conditions) {
		return (int) bpjsBedAvailabilityService.count(conditions);
	}

	/**
	 * Return the BPJS Bed Availability with the given ID.
	 *
	 * @param id the ID of the entity being queried
	 * @return the entity with the given ID
	 */
	@PreAuthorize("hasPermission('BpjsBedAvailabilityEntity', 'read')")
	public BpjsBedAvailabilityEntity bpjsBedAvailabilityById(String id) {
		BpjsBedAvailabilityEntity entity = bpjsBedAvailabilityService.findById(UUID.fromString(id)).orElse(null);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	/**
	 * Return a list of BPJS Bed Availability records with the given predicates.
	 *
	 * @param pageIndex  window number that captures the records to be fetched in the database
	 * @param pageSize   how many records in the window
	 * @param orders     the orders of the returned list
	 * @param conditions the conditions to filter the records
	 * @return the list with the given predicates
	 */
	@PreAuthorize("hasPermission('BpjsBedAvailabilityEntity', 'read')")
	public List<BpjsBedAvailabilityEntity> bpjsBedAvailabilitys(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		// % protected region % [Add any additional logic for findWithQuery before main logic here] off begin
		// % protected region % [Add any additional logic for findWithQuery before main logic here] end

		List<BpjsBedAvailabilityEntity> entities = Lists.newArrayList(bpjsBedAvailabilityService.findSortedPageWithQuery(
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
	 * Similar to {@link BpjsBedAvailabilityQueryResolver#bpjsBedAvailabilitys(int,int,List,List)} but the page index starts
	 * from the tail end.
	 */
	@PreAuthorize("hasPermission('BpjsBedAvailabilityEntity', 'read')")
	public List<BpjsBedAvailabilityEntity> lastBpjsBedAvailabilitys(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		long count = bpjsBedAvailabilityService.count();

		// Can be risky since overflow may happen
		int lastPageIndex = (int) (count / pageSize);

		// Reverse the index to get the k-last page.
		int reversedIndex = lastPageIndex - pageIndex;

		List<BpjsBedAvailabilityEntity> entities = Lists.newArrayList(bpjsBedAvailabilityService.findSortedPageWithQuery(
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
	 * Return a list of {@link BpjsBedAvailabilityEntityAudit} entities.
	 *
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('BpjsBedAvailabilityEntity', 'read')")
	public List<BpjsBedAvailabilityEntityAudit> bpjsBedAvailabilityAudits() {
		List<BpjsBedAvailabilityEntityAudit> audits = bpjsBedAvailabilityService.getAudits();

		// % protected region % [Add any additional logic for BpjsBedAvailabilityAudits before returning the audits here] off begin
		// % protected region % [Add any additional logic for BpjsBedAvailabilityAudits before returning the audits here] end

		return audits;
	}

	/**
	 * Return a list of {@link BpjsBedAvailabilityEntityAudit} entities filtered by a given entity id.
	 *
	 * @param id The id of the entity to filter by.
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('BpjsBedAvailabilityEntity', 'read')")
	public List<BpjsBedAvailabilityEntityAudit> bpjsBedAvailabilityAuditsByEntityId(@NonNull UUID id) {
		List<BpjsBedAvailabilityEntityAudit> audits = bpjsBedAvailabilityService.getAuditsByEntityId(id);

		// % protected region % [Add any additional logic for BpjsBedAvailabilityAuditsByEntityId before returning the audits here] off begin
		// % protected region % [Add any additional logic for BpjsBedAvailabilityAuditsByEntityId before returning the audits here] end

		return audits;
	}




	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
