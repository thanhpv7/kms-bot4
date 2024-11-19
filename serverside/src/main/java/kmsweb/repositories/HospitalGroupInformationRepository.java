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

import kmsweb.entities.HospitalGroupInformationEntity;
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
public interface HospitalGroupInformationRepository extends AbstractRepository<HospitalGroupInformationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Group Code.
	 *
	 * @param hospitalGroupCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Group Code
	 */
	List<HospitalGroupInformationEntity> findByHospitalGroupCode(@NotNull String hospitalGroupCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Group Name.
	 *
	 * @param hospitalGroupName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Group Name
	 */
	List<HospitalGroupInformationEntity> findByHospitalGroupName(@NotNull String hospitalGroupName);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Group Corporation Name.
	 *
	 * @param hospitalGroupCorporationName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Group Corporation Name
	 */
	List<HospitalGroupInformationEntity> findByHospitalGroupCorporationName(@NotNull String hospitalGroupCorporationName);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Group Director.
	 *
	 * @param hospitalGroupDirector the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Group Director
	 */
	List<HospitalGroupInformationEntity> findByHospitalGroupDirector(@NotNull String hospitalGroupDirector);
	/**
	 * Return an entity or a list of entities that have the given attribute Operational License No.
	 *
	 * @param operationalLicenseNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Operational License No
	 */
	List<HospitalGroupInformationEntity> findByOperationalLicenseNo(@NotNull String operationalLicenseNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Group Corporation Status.
	 *
	 * @param hospitalGroupCorporationStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Group Corporation Status
	 */
	List<HospitalGroupInformationEntity> findByHospitalGroupCorporationStatus(@NotNull String hospitalGroupCorporationStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<HospitalGroupInformationEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute City.
	 *
	 * @param city the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City
	 */
	List<HospitalGroupInformationEntity> findByCity(@NotNull String city);
	/**
	 * Return an entity or a list of entities that have the given attribute Postcode.
	 *
	 * @param postcode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postcode
	 */
	List<HospitalGroupInformationEntity> findByPostcode(@NotNull String postcode);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<HospitalGroupInformationEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Fax.
	 *
	 * @param fax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fax
	 */
	List<HospitalGroupInformationEntity> findByFax(@NotNull String fax);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<HospitalGroupInformationEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Website
	 */
	List<HospitalGroupInformationEntity> findByWebsite(@NotNull String website);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person.
	 *
	 * @param contactPerson the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person
	 */
	List<HospitalGroupInformationEntity> findByContactPerson(@NotNull String contactPerson);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person Phone Number.
	 *
	 * @param contactPersonPhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person Phone Number
	 */
	List<HospitalGroupInformationEntity> findByContactPersonPhoneNumber(@NotNull String contactPersonPhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person Email.
	 *
	 * @param contactPersonEmail the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person Email
	 */
	List<HospitalGroupInformationEntity> findByContactPersonEmail(@NotNull String contactPersonEmail);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HospitalGroupInformationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HospitalGroupInformationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}