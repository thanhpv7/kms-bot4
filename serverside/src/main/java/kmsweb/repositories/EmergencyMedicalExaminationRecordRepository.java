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

import kmsweb.entities.EmergencyMedicalExaminationRecordEntity;
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
public interface EmergencyMedicalExaminationRecordRepository extends AbstractRepository<EmergencyMedicalExaminationRecordEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Case Specification.
	 *
	 * @param caseSpecification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Case Specification
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByCaseSpecification(@NotNull String caseSpecification);
	/**
	 * Return an entity or a list of entities that have the given attribute Accident Type.
	 *
	 * @param accidentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accident Type
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByAccidentType(@NotNull String accidentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Accident Cause.
	 *
	 * @param accidentCause the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accident Cause
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByAccidentCause(@NotNull String accidentCause);
	/**
	 * Return an entity or a list of entities that have the given attribute Emergency Level.
	 *
	 * @param emergencyLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Emergency Level
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByEmergencyLevel(@NotNull String emergencyLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Time of Instructions.
	 *
	 * @param dateTimeOfInstructions the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Time of Instructions
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByDateTimeOfInstructions(@NotNull OffsetDateTime dateTimeOfInstructions);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Doctor Taking Over.
	 *
	 * @param isDoctorTakingOver the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Doctor Taking Over
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByIsDoctorTakingOver(@NotNull Boolean isDoctorTakingOver);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Time of Drug Administration.
	 *
	 * @param dateTimeOfDrugAdministration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Time of Drug Administration
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByDateTimeOfDrugAdministration(@NotNull OffsetDateTime dateTimeOfDrugAdministration);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Autopay.
	 *
	 * @param isAutopay the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Autopay
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByIsAutopay(@NotNull Boolean isAutopay);
	/**
	 * Return an entity or a list of entities that have the given attribute Response Time.
	 *
	 * @param responseTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Response Time
	 */
	List<EmergencyMedicalExaminationRecordEntity> findByResponseTime(@NotNull Integer responseTime);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<EmergencyMedicalExaminationRecordEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<EmergencyMedicalExaminationRecordEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}