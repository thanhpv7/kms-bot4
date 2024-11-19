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

import kmsweb.entities.PatientEmergencyContactDetailEntity;
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
public interface PatientEmergencyContactDetailRepository extends AbstractRepository<PatientEmergencyContactDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Title.
	 *
	 * @param title the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Title
	 */
	List<PatientEmergencyContactDetailEntity> findByTitle(@NotNull String title);
	/**
	 * Return an entity or a list of entities that have the given attribute Given Name.
	 *
	 * @param givenName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Given Name
	 */
	List<PatientEmergencyContactDetailEntity> findByGivenName(@NotNull String givenName);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	List<PatientEmergencyContactDetailEntity> findByLastName(@NotNull String lastName);
	/**
	 * Return an entity or a list of entities that have the given attribute Relationship.
	 *
	 * @param relationship the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Relationship
	 */
	List<PatientEmergencyContactDetailEntity> findByRelationship(@NotNull String relationship);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Of Birth
	 */
	List<PatientEmergencyContactDetailEntity> findByDateOfBirth(@NotNull OffsetDateTime dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<PatientEmergencyContactDetailEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute Home Phone No.
	 *
	 * @param homePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Home Phone No
	 */
	List<PatientEmergencyContactDetailEntity> findByHomePhoneNo(@NotNull String homePhoneNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone No.
	 *
	 * @param mobilePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone No
	 */
	List<PatientEmergencyContactDetailEntity> findByMobilePhoneNo(@NotNull String mobilePhoneNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Office Phone No.
	 *
	 * @param officePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Office Phone No
	 */
	List<PatientEmergencyContactDetailEntity> findByOfficePhoneNo(@NotNull String officePhoneNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Extension No.
	 *
	 * @param extensionNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extension No
	 */
	List<PatientEmergencyContactDetailEntity> findByExtensionNo(@NotNull String extensionNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Email Address.
	 *
	 * @param emailAddress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email Address
	 */
	List<PatientEmergencyContactDetailEntity> findByEmailAddress(@NotNull String emailAddress);
	/**
	 * Return an entity or a list of entities that have the given attribute ID Card.
	 *
	 * @param idCard the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ID Card
	 */
	List<PatientEmergencyContactDetailEntity> findByIdCard(@NotNull String idCard);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientEmergencyContactDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientEmergencyContactDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}