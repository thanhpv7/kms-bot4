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
package kmsweb.services;

import kmsweb.entities.AbstractEntity;
import kmsweb.entities.AbstractEntityAudit;
import kmsweb.graphql.utils.Where;
import kmsweb.repositories.AbstractRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.data.domain.Sort;
import com.querydsl.core.types.Predicate;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import java.util.Set;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Base class of all service classes. It provides a handful of common operations out-of-the-box.
 */
public abstract class AbstractService<E extends AbstractEntity, R extends AbstractRepository<E>, T extends AbstractEntityAudit<E>> {
	protected final R repository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	protected AbstractService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			R repository
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.repository = repository;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Given the id of the entity to be retrieved, return that entity if exists or null otherwise.
	 *
	 * @param id the id of the entity to be retrieved if exists
	 * @return the entity whose id matches the given id, or null otherwise
	 */
	public abstract Optional<E> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	;

	/**
	 * Return a paginated list of entities of type {@link E}.
	 *
	 * @param pageIndex the page index
	 * @param pageSize  how many entities are contained in the page
	 * @return a paginated list of entities of type {@link E}.
	 */
	public abstract Iterable<E> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	;

	/**
	 * Return a paginated and sorted list of entities of type {@link E}.
	 *
	 * @param pageIndex the page index
	 * @param pageSize  how many entities are contained in the page
	 * @param sortBy    how to sort the page
	 * @return a paginated and sorted list of entities of type {@link E}.
	 */
	public abstract Iterable<E> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	;

	/**
	 * Return a paginated and sorted list of entities of type{@link E} with query conditions
	 *
	 * @param pageIndex the page index
	 * @param pageSize  how many entities are contained in the page
	 * @param conditions the conditions to be used in the query
	 * @param sortBy the orders to used for sorting
	 * @return a paginated and list of entities of type {@link E} after filtering
	 */
	public abstract Iterable<E> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	;

	/**
	 * Create the entity into the database and return it.
	 *
	 * @param entity the new entity to be persisted into the database
	 * @return the new entity after persisted
	 */
	public abstract E create(E entity)
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	;

	/**
	 * Create the new entities into the database and return them.
	 *
	 * @param entities the new entities to be persisted into the database
	 * @return the new entities after persisted
	 */
	public abstract Iterable<E> createAll(Iterable<E> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	;

	/**
	 * Update the entity into the database and return it.
	 *
	 * @param entity the entity to be updated into the database
	 * @return the new entity after persisted
	 */
	public abstract E update(E entity)
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	;

	/**
	 * Update the new entities into the database and return them.
	 *
	 * @param entities the entities to be updated in database
	 * @return the new entities after persisted
	 */
	public abstract Iterable<E> updateAll(Iterable<E> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	;

	/**
	 * Persist the entity into the database and return it.
	 *
	 * @param entity the new entity to be persisted into the database
	 * @return the new entity after persisted
	 */
	public abstract E save(E entity)
	// % protected region % [Add any throwables, implementations, or extensions for save here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for save here] end
	;

	/**
	 * Persist the new entities into the database and return them.
	 *
	 * @param entities the new entities to be persisted into the database
	 * @return the new entities after persisted
	 */
	public abstract Iterable<E> saveAll(Iterable<E> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	;

	/**
	 * Delete an entity with the given ID.
	 *
	 * @param id the ID of the entity to be deleted
	 */
	public abstract void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	;

	/**
	 * Delete the given entities from the database.
	 *
	 * @param ids the IDs of the entities to be deleted
	 */
	public abstract void deleteAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] end
	;

	/**
	 * Delete all entities of the relevant type from the database excluding the provided ids
	 *
	 * @param ids the IDs of the entities to exclude from deletion
	 */
	public abstract void deleteAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] end
	;


	public abstract List<E> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	;

	public abstract List<E> findAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] end
	;

	/**
	 * Return a list of entities to be used for auditing.
	 *
	 * @return a list of entities to be used for auditing
	 */
	public abstract List<T> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	;

	/**
	 * Return a list of audit entities filtered by a given entity by id.
	 *
	 * @param id The id of the entity to filter the audits for
	 * @return a list of entities to be used for auditing
	 */
	public abstract List<T> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	;

	/**
	 * Create the predicate for the querydsl based on one condition
	 *
	 * @param condition Single condition used in the query
	 * @return querydsl predicate
	 */
	protected abstract Predicate processCondition(Where condition)
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] end
	;

	/**
	 * Create the predicate for the querydsl based on one single List of Where
	 * The List are connect with 'and' statement
	 *
	 * @param conditions Single list of where statement. The conditions are connected with 'or'
	 * @return querydsl predicate
	 */
	protected abstract Predicate processConditionList(List<Where> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] end
	;

	/**
	 * Transfer lists of conditions
	 * The lists are connected with 'or' statement
	 *
	 * @param conditions A list of conditions
	 * @return a single query dsl predicate
	 */
	protected abstract Predicate getQueryConditions(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] end
	;

	/**
	 * Update old data if there is already an entity in the database.
	 *
	 * @param entity The entity to be updated
	 */
	public abstract E updateOldData(E entity)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	;

	/**
	 * Validate the entity
	 * @param entity The entity to validate
	 * @throws ConstraintViolationException Throw ConstraintViolationException when entity is invalid
	 */
	public abstract void validateEntity(E entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	;

	public abstract Set<String> validateEntityRelations(E entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	;

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
