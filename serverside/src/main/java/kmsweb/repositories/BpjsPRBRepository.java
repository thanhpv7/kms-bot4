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

import kmsweb.entities.BpjsPRBEntity;
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
public interface BpjsPRBRepository extends AbstractRepository<BpjsPRBEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute SRB No.
	 *
	 * @param srbNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SRB No
	 */
	List<BpjsPRBEntity> findBySrbNo(@NotNull String srbNo);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsPRBEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsPRBEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<BpjsPRBEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<BpjsPRBEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute PRB Program Code.
	 *
	 * @param prbProgramCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PRB Program Code
	 */
	List<BpjsPRBEntity> findByPrbProgramCode(@NotNull String prbProgramCode);
	/**
	 * Return an entity or a list of entities that have the given attribute PRB Program Name.
	 *
	 * @param prbProgramName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PRB Program Name
	 */
	List<BpjsPRBEntity> findByPrbProgramName(@NotNull String prbProgramName);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Code.
	 *
	 * @param doctorCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Code
	 */
	List<BpjsPRBEntity> findByDoctorCode(@NotNull String doctorCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Name.
	 *
	 * @param doctorName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Name
	 */
	List<BpjsPRBEntity> findByDoctorName(@NotNull String doctorName);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<BpjsPRBEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Recommendation.
	 *
	 * @param recommendation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Recommendation
	 */
	List<BpjsPRBEntity> findByRecommendation(@NotNull String recommendation);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPRBEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsPRBEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}