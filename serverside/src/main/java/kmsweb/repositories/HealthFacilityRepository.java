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

import kmsweb.entities.HealthFacilityEntity;
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
public interface HealthFacilityRepository extends AbstractRepository<HealthFacilityEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility ID.
	 *
	 * @param healthFacilityID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility ID
	 */
	Optional<HealthFacilityEntity> findByHealthFacilityID(@NotNull String healthFacilityID);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Name.
	 *
	 * @param healthFacilityName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Name
	 */
	List<HealthFacilityEntity> findByHealthFacilityName(@NotNull String healthFacilityName);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<HealthFacilityEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute City.
	 *
	 * @param city the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City
	 */
	List<HealthFacilityEntity> findByCity(@NotNull String city);
	/**
	 * Return an entity or a list of entities that have the given attribute Post Code.
	 *
	 * @param postCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Post Code
	 */
	List<HealthFacilityEntity> findByPostCode(@NotNull String postCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Province.
	 *
	 * @param province the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Province
	 */
	List<HealthFacilityEntity> findByProvince(@NotNull String province);
	/**
	 * Return an entity or a list of entities that have the given attribute Country.
	 *
	 * @param country the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Country
	 */
	List<HealthFacilityEntity> findByCountry(@NotNull String country);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<HealthFacilityEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number.
	 *
	 * @param mobilePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number
	 */
	List<HealthFacilityEntity> findByMobilePhoneNumber(@NotNull String mobilePhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute website
	 */
	List<HealthFacilityEntity> findByWebsite(@NotNull String website);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<HealthFacilityEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Salutation.
	 *
	 * @param salutation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Salutation
	 */
	List<HealthFacilityEntity> findBySalutation(@NotNull String salutation);
	/**
	 * Return an entity or a list of entities that have the given attribute First Name.
	 *
	 * @param firstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Name
	 */
	List<HealthFacilityEntity> findByFirstName(@NotNull String firstName);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	List<HealthFacilityEntity> findByLastName(@NotNull String lastName);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number POC.
	 *
	 * @param phoneNumberPOC the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number POC
	 */
	List<HealthFacilityEntity> findByPhoneNumberPOC(@NotNull String phoneNumberPOC);
	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number POC.
	 *
	 * @param mobilePhoneNumberPOC the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number POC
	 */
	List<HealthFacilityEntity> findByMobilePhoneNumberPOC(@NotNull String mobilePhoneNumberPOC);
	/**
	 * Return an entity or a list of entities that have the given attribute Email POC.
	 *
	 * @param emailPOC the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email POC
	 */
	List<HealthFacilityEntity> findByEmailPOC(@NotNull String emailPOC);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Type.
	 *
	 * @param healthFacilityType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Type
	 */
	List<HealthFacilityEntity> findByHealthFacilityType(@NotNull String healthFacilityType);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HealthFacilityEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HealthFacilityEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}