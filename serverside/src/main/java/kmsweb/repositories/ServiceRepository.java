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
package kmsweb.repositories;

import kmsweb.entities.ServiceEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface ServiceRepository extends AbstractRepository<ServiceEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Service Number.
	 *
	 * @param serviceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Number
	 */
	Optional<ServiceEntity> findByServiceNumber(@NotNull String serviceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Name.
	 *
	 * @param serviceName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Name
	 */
	List<ServiceEntity> findByServiceName(@NotNull String serviceName);
	/**
	 * Return an entity or a list of entities that have the given attribute Section Code.
	 *
	 * @param sectionCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Section Code
	 */
	List<ServiceEntity> findBySectionCode(@NotNull String sectionCode);
	/**
	 * Return an entity or a list of entities that have the given attribute By pass Doctor Assignment.
	 *
	 * @param byPassDoctorAssignment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute By pass Doctor Assignment
	 */
	List<ServiceEntity> findByByPassDoctorAssignment(@NotNull Boolean byPassDoctorAssignment);
	/**
	 * Return an entity or a list of entities that have the given attribute Has Examination Item.
	 *
	 * @param hasExaminationItem the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Examination Item
	 */
	List<ServiceEntity> findByHasExaminationItem(@NotNull Boolean hasExaminationItem);
	/**
	 * Return an entity or a list of entities that have the given attribute Revenue Center.
	 *
	 * @param revenueCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revenue Center
	 */
	List<ServiceEntity> findByRevenueCenter(@NotNull String revenueCenter);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Code.
	 *
	 * @param serviceCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Code
	 */
	List<ServiceEntity> findByServiceCode(@NotNull String serviceCode);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ServiceEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ServiceEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}