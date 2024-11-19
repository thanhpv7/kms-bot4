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

import kmsweb.entities.BpjsJasaRaharjaEntity;
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
public interface BpjsJasaRaharjaRepository extends AbstractRepository<BpjsJasaRaharjaEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Initial SEP No.
	 *
	 * @param initialSEPNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Initial SEP No
	 */
	List<BpjsJasaRaharjaEntity> findByInitialSEPNo(@NotNull String initialSEPNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Guarantee Letter No.
	 *
	 * @param guaranteeLetterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Guarantee Letter No
	 */
	List<BpjsJasaRaharjaEntity> findByGuaranteeLetterNo(@NotNull String guaranteeLetterNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Incident Date.
	 *
	 * @param incidentDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Incident Date
	 */
	List<BpjsJasaRaharjaEntity> findByIncidentDate(@NotNull OffsetDateTime incidentDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Registration No.
	 *
	 * @param registrationNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration No
	 */
	List<BpjsJasaRaharjaEntity> findByRegistrationNo(@NotNull String registrationNo);
	/**
	 * Return an entity or a list of entities that have the given attribute No SEP Suplesi.
	 *
	 * @param noSEPSuplesi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute No SEP Suplesi
	 */
	List<BpjsJasaRaharjaEntity> findByNoSEPSuplesi(@NotNull String noSEPSuplesi);
	/**
	 * Return an entity or a list of entities that have the given attribute Tanggal SEP Suplesi.
	 *
	 * @param tanggalSEPSuplesi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tanggal SEP Suplesi
	 */
	List<BpjsJasaRaharjaEntity> findByTanggalSEPSuplesi(@NotNull OffsetDateTime tanggalSEPSuplesi);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsJasaRaharjaEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsJasaRaharjaEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}