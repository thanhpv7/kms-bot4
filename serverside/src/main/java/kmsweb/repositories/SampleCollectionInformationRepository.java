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

import kmsweb.entities.SampleCollectionInformationEntity;
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
public interface SampleCollectionInformationRepository extends AbstractRepository<SampleCollectionInformationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Informed.
	 *
	 * @param patientInformed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Informed
	 */
	List<SampleCollectionInformationEntity> findByPatientInformed(@NotNull Boolean patientInformed);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Consented.
	 *
	 * @param patientConsented the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Consented
	 */
	List<SampleCollectionInformationEntity> findByPatientConsented(@NotNull Boolean patientConsented);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Fasted Enough.
	 *
	 * @param patientFastedEnough the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Fasted Enough
	 */
	List<SampleCollectionInformationEntity> findByPatientFastedEnough(@NotNull Boolean patientFastedEnough);
	/**
	 * Return an entity or a list of entities that have the given attribute Medication Taken In 24 Hours.
	 *
	 * @param medicationTakenIn24Hours the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Taken In 24 Hours
	 */
	List<SampleCollectionInformationEntity> findByMedicationTakenIn24Hours(@NotNull Boolean medicationTakenIn24Hours);
	/**
	 * Return an entity or a list of entities that have the given attribute Medication Taken In 72 Hours.
	 *
	 * @param medicationTakenIn72Hours the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Taken In 72 Hours
	 */
	List<SampleCollectionInformationEntity> findByMedicationTakenIn72Hours(@NotNull Boolean medicationTakenIn72Hours);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SampleCollectionInformationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SampleCollectionInformationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}