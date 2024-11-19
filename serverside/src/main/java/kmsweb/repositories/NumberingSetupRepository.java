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

import kmsweb.entities.NumberingSetupEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
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
public interface NumberingSetupRepository extends AbstractRepository<NumberingSetupEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Numbering Type.
	 *
	 * @param numberingType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Numbering Type
	 */
	List<NumberingSetupEntity> findByNumberingType(@NotNull NumberingTypeEnum numberingType);
	/**
	 * Return an entity or a list of entities that have the given attribute Prefix.
	 *
	 * @param prefix the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prefix
	 */
	Optional<NumberingSetupEntity> findByPrefix(@NotNull String prefix);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Format.
	 *
	 * @param dateFormat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Format
	 */
	List<NumberingSetupEntity> findByDateFormat(@NotNull DateFormatEnum dateFormat);
	/**
	 * Return an entity or a list of entities that have the given attribute Sufix.
	 *
	 * @param sufix the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sufix
	 */
	List<NumberingSetupEntity> findBySufix(@NotNull String sufix);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Counter.
	 *
	 * @param lastCounter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Counter
	 */
	List<NumberingSetupEntity> findByLastCounter(@NotNull Integer lastCounter);
	/**
	 * Return an entity or a list of entities that have the given attribute Editable.
	 *
	 * @param editable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Editable
	 */
	List<NumberingSetupEntity> findByEditable(@NotNull Boolean editable);
	/**
	 * Return an entity or a list of entities that have the given attribute Reset per Day.
	 *
	 * @param resetPerDay the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reset per Day
	 */
	List<NumberingSetupEntity> findByResetPerDay(@NotNull Boolean resetPerDay);
	/**
	 * Return an entity or a list of entities that have the given attribute Counter Length.
	 *
	 * @param counterLength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Counter Length
	 */
	List<NumberingSetupEntity> findByCounterLength(@NotNull Integer counterLength);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Updated.
	 *
	 * @param lastUpdated the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Updated
	 */
	List<NumberingSetupEntity> findByLastUpdated(@NotNull OffsetDateTime lastUpdated);
	/**
	 * Return an entity or a list of entities that have the given attribute Preview.
	 *
	 * @param preview the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preview
	 */
	List<NumberingSetupEntity> findByPreview(@NotNull String preview);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NumberingSetupEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NumberingSetupEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}