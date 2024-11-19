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
import kmsweb.entities.PcareClubProlanisEntity;
import kmsweb.entities.PcareClubProlanisEntityAudit;
import kmsweb.services.PcareClubProlanisService;
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
public class PcareClubProlanisQueryResolver implements GraphQLQueryResolver {

	private final PcareClubProlanisService pcareClubProlanisService;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PcareClubProlanisQueryResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PcareClubProlanisService pcareClubProlanisService
	) {
		this.pcareClubProlanisService = pcareClubProlanisService;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Count the number of PCare Club Prolanis records in the data with the given conditions.
	 *
	 * @param conditions the conditions with which the query will be run
	 * @return the number of records in the database that matches the conditions
	 */
	@PreAuthorize("hasPermission('PcareClubProlanisEntity', 'read')")
	public int countPcareClubProlaniss(List<List<Where>> conditions) {
		return (int) pcareClubProlanisService.count(conditions);
	}

	/**
	 * Return the PCare Club Prolanis with the given ID.
	 *
	 * @param id the ID of the entity being queried
	 * @return the entity with the given ID
	 */
	@PreAuthorize("hasPermission('PcareClubProlanisEntity', 'read')")
	public PcareClubProlanisEntity pcareClubProlanisById(String id) {
		PcareClubProlanisEntity entity = pcareClubProlanisService.findById(UUID.fromString(id)).orElse(null);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	/**
	 * Return a list of PCare Club Prolanis records with the given predicates.
	 *
	 * @param pageIndex  window number that captures the records to be fetched in the database
	 * @param pageSize   how many records in the window
	 * @param orders     the orders of the returned list
	 * @param conditions the conditions to filter the records
	 * @return the list with the given predicates
	 */
	@PreAuthorize("hasPermission('PcareClubProlanisEntity', 'read')")
	public List<PcareClubProlanisEntity> pcareClubProlaniss(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		// % protected region % [Add any additional logic for findWithQuery before main logic here] off begin
		// % protected region % [Add any additional logic for findWithQuery before main logic here] end

		List<PcareClubProlanisEntity> entities = Lists.newArrayList(pcareClubProlanisService.findSortedPageWithQuery(
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
	 * Similar to {@link PcareClubProlanisQueryResolver#pcareClubProlaniss(int,int,List,List)} but the page index starts
	 * from the tail end.
	 */
	@PreAuthorize("hasPermission('PcareClubProlanisEntity', 'read')")
	public List<PcareClubProlanisEntity> lastPcareClubProlaniss(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		long count = pcareClubProlanisService.count();

		// Can be risky since overflow may happen
		int lastPageIndex = (int) (count / pageSize);

		// Reverse the index to get the k-last page.
		int reversedIndex = lastPageIndex - pageIndex;

		List<PcareClubProlanisEntity> entities = Lists.newArrayList(pcareClubProlanisService.findSortedPageWithQuery(
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
	 * Return a list of {@link PcareClubProlanisEntityAudit} entities.
	 *
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('PcareClubProlanisEntity', 'read')")
	public List<PcareClubProlanisEntityAudit> pcareClubProlanisAudits() {
		List<PcareClubProlanisEntityAudit> audits = pcareClubProlanisService.getAudits();

		// % protected region % [Add any additional logic for PcareClubProlanisAudits before returning the audits here] off begin
		// % protected region % [Add any additional logic for PcareClubProlanisAudits before returning the audits here] end

		return audits;
	}

	/**
	 * Return a list of {@link PcareClubProlanisEntityAudit} entities filtered by a given entity id.
	 *
	 * @param id The id of the entity to filter by.
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('PcareClubProlanisEntity', 'read')")
	public List<PcareClubProlanisEntityAudit> pcareClubProlanisAuditsByEntityId(@NonNull UUID id) {
		List<PcareClubProlanisEntityAudit> audits = pcareClubProlanisService.getAuditsByEntityId(id);

		// % protected region % [Add any additional logic for PcareClubProlanisAuditsByEntityId before returning the audits here] off begin
		// % protected region % [Add any additional logic for PcareClubProlanisAuditsByEntityId before returning the audits here] end

		return audits;
	}




	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
