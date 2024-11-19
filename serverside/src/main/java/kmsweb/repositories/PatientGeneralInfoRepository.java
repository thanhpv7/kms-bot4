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

import kmsweb.entities.PatientGeneralInfoEntity;
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
public interface PatientGeneralInfoRepository extends AbstractRepository<PatientGeneralInfoEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	Optional<PatientGeneralInfoEntity> findByPatientID(@NotNull String patientID);
	/**
	 * Return an entity or a list of entities that have the given attribute Title.
	 *
	 * @param title the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Title
	 */
	List<PatientGeneralInfoEntity> findByTitle(@NotNull String title);
	/**
	 * Return an entity or a list of entities that have the given attribute Given Name.
	 *
	 * @param givenName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Given Name
	 */
	List<PatientGeneralInfoEntity> findByGivenName(@NotNull String givenName);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	List<PatientGeneralInfoEntity> findByLastName(@NotNull String lastName);
	/**
	 * Return an entity or a list of entities that have the given attribute Place of Birth.
	 *
	 * @param placeOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Place of Birth
	 */
	List<PatientGeneralInfoEntity> findByPlaceOfBirth(@NotNull String placeOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	List<PatientGeneralInfoEntity> findByDateOfBirth(@NotNull OffsetDateTime dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<PatientGeneralInfoEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<PatientGeneralInfoEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Payment Type.
	 *
	 * @param patientPaymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Payment Type
	 */
	List<PatientGeneralInfoEntity> findByPatientPaymentType(@NotNull String patientPaymentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Important Notes.
	 *
	 * @param importantNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Important Notes
	 */
	List<PatientGeneralInfoEntity> findByImportantNotes(@NotNull String importantNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Has Outstanding Payment.
	 *
	 * @param hasOutstandingPayment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Outstanding Payment
	 */
	List<PatientGeneralInfoEntity> findByHasOutstandingPayment(@NotNull Boolean hasOutstandingPayment);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientGeneralInfoEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientGeneralInfoEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}