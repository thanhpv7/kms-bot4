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

import kmsweb.entities.SampleCollectionItemsEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface SampleCollectionItemsRepository extends AbstractRepository<SampleCollectionItemsEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Type.
	 *
	 * @param sampleType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Type
	 */
	List<SampleCollectionItemsEntity> findBySampleType(@NotNull String sampleType);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Number.
	 *
	 * @param sampleNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Number
	 */
	List<SampleCollectionItemsEntity> findBySampleNumber(@NotNull String sampleNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Taking Location.
	 *
	 * @param sampleTakingLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Taking Location
	 */
	List<SampleCollectionItemsEntity> findBySampleTakingLocation(@NotNull String sampleTakingLocation);
	/**
	 * Return an entity or a list of entities that have the given attribute Volume.
	 *
	 * @param volume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Volume
	 */
	List<SampleCollectionItemsEntity> findByVolume(@NotNull String volume);
	/**
	 * Return an entity or a list of entities that have the given attribute Container.
	 *
	 * @param container the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Container
	 */
	List<SampleCollectionItemsEntity> findByContainer(@NotNull String container);
	/**
	 * Return an entity or a list of entities that have the given attribute Transport.
	 *
	 * @param transport the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transport
	 */
	List<SampleCollectionItemsEntity> findByTransport(@NotNull String transport);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Collection Date Time.
	 *
	 * @param sampleCollectionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Collection Date Time
	 */
	List<SampleCollectionItemsEntity> findBySampleCollectionDateTime(@NotNull OffsetDateTime sampleCollectionDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Processing Date Time.
	 *
	 * @param sampleProcessingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Processing Date Time
	 */
	List<SampleCollectionItemsEntity> findBySampleProcessingDateTime(@NotNull OffsetDateTime sampleProcessingDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample Delivery Date Time.
	 *
	 * @param sampleDeliveryDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Delivery Date Time
	 */
	List<SampleCollectionItemsEntity> findBySampleDeliveryDateTime(@NotNull OffsetDateTime sampleDeliveryDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<SampleCollectionItemsEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SampleCollectionItemsEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SampleCollectionItemsEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}