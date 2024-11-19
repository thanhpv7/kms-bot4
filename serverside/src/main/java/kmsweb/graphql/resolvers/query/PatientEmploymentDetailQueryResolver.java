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
import kmsweb.entities.PatientEmploymentDetailEntity;
import kmsweb.entities.PatientEmploymentDetailEntityAudit;
import kmsweb.services.PatientEmploymentDetailService;
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
public class PatientEmploymentDetailQueryResolver implements GraphQLQueryResolver {

	private final PatientEmploymentDetailService patientEmploymentDetailService;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientEmploymentDetailQueryResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			PatientEmploymentDetailService patientEmploymentDetailService
	) {
		this.patientEmploymentDetailService = patientEmploymentDetailService;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Count the number of Patient Employment Detail  records in the data with the given conditions.
	 *
	 * @param conditions the conditions with which the query will be run
	 * @return the number of records in the database that matches the conditions
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public int countPatientEmploymentDetails(List<List<Where>> conditions) {
		return (int) patientEmploymentDetailService.count(conditions);
	}

	/**
	 * Return the Patient Employment Detail  with the given ID.
	 *
	 * @param id the ID of the entity being queried
	 * @return the entity with the given ID
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public PatientEmploymentDetailEntity patientEmploymentDetailById(String id) {
		PatientEmploymentDetailEntity entity = patientEmploymentDetailService.findById(UUID.fromString(id)).orElse(null);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	/**
	 * Return a list of Patient Employment Detail  records with the given predicates.
	 *
	 * @param pageIndex  window number that captures the records to be fetched in the database
	 * @param pageSize   how many records in the window
	 * @param orders     the orders of the returned list
	 * @param conditions the conditions to filter the records
	 * @return the list with the given predicates
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public List<PatientEmploymentDetailEntity> patientEmploymentDetails(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		// % protected region % [Add any additional logic for findWithQuery before main logic here] off begin
		// % protected region % [Add any additional logic for findWithQuery before main logic here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(patientEmploymentDetailService.findSortedPageWithQuery(
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
	 * Similar to {@link PatientEmploymentDetailQueryResolver#patientEmploymentDetails(int,int,List,List)} but the page index starts
	 * from the tail end.
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public List<PatientEmploymentDetailEntity> lastPatientEmploymentDetails(
			int pageIndex,
			int pageSize,
			List<OrderBy> orders,
			List<List<Where>> conditions
	) {
		long count = patientEmploymentDetailService.count();

		// Can be risky since overflow may happen
		int lastPageIndex = (int) (count / pageSize);

		// Reverse the index to get the k-last page.
		int reversedIndex = lastPageIndex - pageIndex;

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(patientEmploymentDetailService.findSortedPageWithQuery(
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
	 * Return a list of {@link PatientEmploymentDetailEntityAudit} entities.
	 *
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public List<PatientEmploymentDetailEntityAudit> patientEmploymentDetailAudits() {
		List<PatientEmploymentDetailEntityAudit> audits = patientEmploymentDetailService.getAudits();

		// % protected region % [Add any additional logic for PatientEmploymentDetailAudits before returning the audits here] off begin
		// % protected region % [Add any additional logic for PatientEmploymentDetailAudits before returning the audits here] end

		return audits;
	}

	/**
	 * Return a list of {@link PatientEmploymentDetailEntityAudit} entities filtered by a given entity id.
	 *
	 * @param id The id of the entity to filter by.
	 * @return a list of audit entities
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public List<PatientEmploymentDetailEntityAudit> patientEmploymentDetailAuditsByEntityId(@NonNull UUID id) {
		List<PatientEmploymentDetailEntityAudit> audits = patientEmploymentDetailService.getAuditsByEntityId(id);

		// % protected region % [Add any additional logic for PatientEmploymentDetailAuditsByEntityId before returning the audits here] off begin
		// % protected region % [Add any additional logic for PatientEmploymentDetailAuditsByEntityId before returning the audits here] end

		return audits;
	}




	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
