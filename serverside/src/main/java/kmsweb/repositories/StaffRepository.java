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

import kmsweb.entities.StaffEntity;
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
public interface StaffRepository extends AbstractRepository<StaffEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Staff Number.
	 *
	 * @param staffNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Number
	 */
	Optional<StaffEntity> findByStaffNumber(@NotNull String staffNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute First Name.
	 *
	 * @param firstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Name
	 */
	List<StaffEntity> findByFirstName(@NotNull String firstName);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	List<StaffEntity> findByLastName(@NotNull String lastName);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	List<StaffEntity> findByDateOfBirth(@NotNull OffsetDateTime dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Staff Type.
	 *
	 * @param staffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Type
	 */
	List<StaffEntity> findByStaffType(@NotNull String staffType);
	/**
	 * Return an entity or a list of entities that have the given attribute Specialization.
	 *
	 * @param specialization the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specialization
	 */
	List<StaffEntity> findBySpecialization(@NotNull String specialization);
	/**
	 * Return an entity or a list of entities that have the given attribute Education.
	 *
	 * @param education the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Education
	 */
	List<StaffEntity> findByEducation(@NotNull String education);
	/**
	 * Return an entity or a list of entities that have the given attribute License No.
	 *
	 * @param licenseNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute License No
	 */
	List<StaffEntity> findByLicenseNo(@NotNull String licenseNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Letter of Reg.
	 *
	 * @param letterOfReg the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Letter of Reg
	 */
	List<StaffEntity> findByLetterOfReg(@NotNull String letterOfReg);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<StaffEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Employee ID.
	 *
	 * @param employeeID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employee ID
	 */
	List<StaffEntity> findByEmployeeID(@NotNull String employeeID);
	/**
	 * Return an entity or a list of entities that have the given attribute Title.
	 *
	 * @param title the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Title
	 */
	List<StaffEntity> findByTitle(@NotNull String title);
	/**
	 * Return an entity or a list of entities that have the given attribute Default Service Number.
	 *
	 * @param defaultServiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Default Service Number
	 */
	List<StaffEntity> findByDefaultServiceNumber(@NotNull String defaultServiceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Place of birth.
	 *
	 * @param placeOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Place of birth
	 */
	List<StaffEntity> findByPlaceOfBirth(@NotNull String placeOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Religion.
	 *
	 * @param religion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Religion
	 */
	List<StaffEntity> findByReligion(@NotNull String religion);
	/**
	 * Return an entity or a list of entities that have the given attribute Blood Type.
	 *
	 * @param bloodType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Type
	 */
	List<StaffEntity> findByBloodType(@NotNull BloodTypeEnum bloodType);
	/**
	 * Return an entity or a list of entities that have the given attribute Rhesus.
	 *
	 * @param rhesus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rhesus
	 */
	List<StaffEntity> findByRhesus(@NotNull RhesusEnum rhesus);
	/**
	 * Return an entity or a list of entities that have the given attribute address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute address
	 */
	List<StaffEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute Country.
	 *
	 * @param country the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Country
	 */
	List<StaffEntity> findByCountry(@NotNull String country);
	/**
	 * Return an entity or a list of entities that have the given attribute State.
	 *
	 * @param state the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute State
	 */
	List<StaffEntity> findByState(@NotNull String state);
	/**
	 * Return an entity or a list of entities that have the given attribute Regency.
	 *
	 * @param regency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Regency
	 */
	List<StaffEntity> findByRegency(@NotNull String regency);
	/**
	 * Return an entity or a list of entities that have the given attribute District.
	 *
	 * @param district the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute District
	 */
	List<StaffEntity> findByDistrict(@NotNull String district);
	/**
	 * Return an entity or a list of entities that have the given attribute Home phone no.
	 *
	 * @param homePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Home phone no
	 */
	List<StaffEntity> findByHomePhoneNo(@NotNull String homePhoneNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Village.
	 *
	 * @param village the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Village
	 */
	List<StaffEntity> findByVillage(@NotNull String village);
	/**
	 * Return an entity or a list of entities that have the given attribute Postcode.
	 *
	 * @param postcode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postcode
	 */
	List<StaffEntity> findByPostcode(@NotNull String postcode);
	/**
	 * Return an entity or a list of entities that have the given attribute Office Phone Number.
	 *
	 * @param officePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Office Phone Number
	 */
	List<StaffEntity> findByOfficePhoneNumber(@NotNull String officePhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Identification No.
	 *
	 * @param taxIdentificationNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Identification No
	 */
	List<StaffEntity> findByTaxIdentificationNo(@NotNull String taxIdentificationNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone No.
	 *
	 * @param mobilePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone No
	 */
	List<StaffEntity> findByMobilePhoneNo(@NotNull String mobilePhoneNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Notes.
	 *
	 * @param otherNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Notes
	 */
	List<StaffEntity> findByOtherNotes(@NotNull String otherNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Training.
	 *
	 * @param training the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Training
	 */
	List<StaffEntity> findByTraining(@NotNull String training);
	/**
	 * Return an entity or a list of entities that have the given attribute Nationality.
	 *
	 * @param nationality the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nationality
	 */
	List<StaffEntity> findByNationality(@NotNull String nationality);
	/**
	 * Return an entity or a list of entities that have the given attribute Certification.
	 *
	 * @param certification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Certification
	 */
	List<StaffEntity> findByCertification(@NotNull String certification);
	/**
	 * Return an entity or a list of entities that have the given attribute Ext No.
	 *
	 * @param extNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ext No
	 */
	List<StaffEntity> findByExtNo(@NotNull String extNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Marital Status.
	 *
	 * @param maritalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Marital Status
	 */
	List<StaffEntity> findByMaritalStatus(@NotNull String maritalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute email
	 */
	List<StaffEntity> findByEmail(@NotNull String email);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StaffEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StaffEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}