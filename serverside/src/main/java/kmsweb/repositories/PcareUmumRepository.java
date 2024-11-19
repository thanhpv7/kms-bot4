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

import kmsweb.entities.PcareUmumEntity;
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
public interface PcareUmumRepository extends AbstractRepository<PcareUmumEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Cons ID.
	 *
	 * @param consID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cons ID
	 */
	List<PcareUmumEntity> findByConsID(@NotNull String consID);
	/**
	 * Return an entity or a list of entities that have the given attribute Secret Key.
	 *
	 * @param secretKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Secret Key
	 */
	List<PcareUmumEntity> findBySecretKey(@NotNull String secretKey);
	/**
	 * Return an entity or a list of entities that have the given attribute Web Service URL.
	 *
	 * @param webServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Web Service URL
	 */
	List<PcareUmumEntity> findByWebServiceURL(@NotNull String webServiceURL);
	/**
	 * Return an entity or a list of entities that have the given attribute Auth Username.
	 *
	 * @param authUsername the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Auth Username
	 */
	List<PcareUmumEntity> findByAuthUsername(@NotNull String authUsername);
	/**
	 * Return an entity or a list of entities that have the given attribute Auth Password.
	 *
	 * @param authPassword the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Auth Password
	 */
	List<PcareUmumEntity> findByAuthPassword(@NotNull String authPassword);
	/**
	 * Return an entity or a list of entities that have the given attribute Kode Aplikasi.
	 *
	 * @param kodeAplikasi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kode Aplikasi
	 */
	List<PcareUmumEntity> findByKodeAplikasi(@NotNull String kodeAplikasi);
	/**
	 * Return an entity or a list of entities that have the given attribute User Key.
	 *
	 * @param userKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute User Key
	 */
	List<PcareUmumEntity> findByUserKey(@NotNull String userKey);
	/**
	 * Return an entity or a list of entities that have the given attribute Regional Division.
	 *
	 * @param regionalDivision the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Regional Division
	 */
	List<PcareUmumEntity> findByRegionalDivision(@NotNull String regionalDivision);
	/**
	 * Return an entity or a list of entities that have the given attribute Branch Office.
	 *
	 * @param branchOffice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Branch Office
	 */
	List<PcareUmumEntity> findByBranchOffice(@NotNull String branchOffice);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareUmumEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareUmumEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}