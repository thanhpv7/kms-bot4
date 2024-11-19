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

import kmsweb.entities.PatientEmploymentDetailEntity;
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
public interface PatientEmploymentDetailRepository extends AbstractRepository<PatientEmploymentDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Employee ID.
	 *
	 * @param employeeID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employee ID
	 */
	List<PatientEmploymentDetailEntity> findByEmployeeID(@NotNull String employeeID);
	/**
	 * Return an entity or a list of entities that have the given attribute Universal ID.
	 *
	 * @param universalID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Universal ID
	 */
	List<PatientEmploymentDetailEntity> findByUniversalID(@NotNull String universalID);
	/**
	 * Return an entity or a list of entities that have the given attribute Employee Type.
	 *
	 * @param employeeType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employee Type
	 */
	List<PatientEmploymentDetailEntity> findByEmployeeType(@NotNull String employeeType);
	/**
	 * Return an entity or a list of entities that have the given attribute Onsite Status.
	 *
	 * @param onsiteStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Onsite Status
	 */
	List<PatientEmploymentDetailEntity> findByOnsiteStatus(@NotNull String onsiteStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Occupational Type.
	 *
	 * @param occupationalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Occupational Type
	 */
	List<PatientEmploymentDetailEntity> findByOccupationalType(@NotNull String occupationalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Dependant ID.
	 *
	 * @param dependantID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependant ID
	 */
	List<PatientEmploymentDetailEntity> findByDependantID(@NotNull String dependantID);
	/**
	 * Return an entity or a list of entities that have the given attribute Dependant Type.
	 *
	 * @param dependantType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependant Type
	 */
	List<PatientEmploymentDetailEntity> findByDependantType(@NotNull String dependantType);
	/**
	 * Return an entity or a list of entities that have the given attribute Sponsor.
	 *
	 * @param sponsor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sponsor
	 */
	List<PatientEmploymentDetailEntity> findBySponsor(@NotNull String sponsor);
	/**
	 * Return an entity or a list of entities that have the given attribute Relationship.
	 *
	 * @param relationship the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Relationship
	 */
	List<PatientEmploymentDetailEntity> findByRelationship(@NotNull String relationship);
	/**
	 * Return an entity or a list of entities that have the given attribute Company.
	 *
	 * @param company the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Company
	 */
	List<PatientEmploymentDetailEntity> findByCompany(@NotNull String company);
	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff Code.
	 *
	 * @param medicalStaffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff Code
	 */
	List<PatientEmploymentDetailEntity> findByMedicalStaffCode(@NotNull String medicalStaffCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Department.
	 *
	 * @param department the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Department
	 */
	List<PatientEmploymentDetailEntity> findByDepartment(@NotNull String department);
	/**
	 * Return an entity or a list of entities that have the given attribute Position.
	 *
	 * @param position the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Position
	 */
	List<PatientEmploymentDetailEntity> findByPosition(@NotNull String position);
	/**
	 * Return an entity or a list of entities that have the given attribute Cost Center.
	 *
	 * @param costCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cost Center
	 */
	List<PatientEmploymentDetailEntity> findByCostCenter(@NotNull String costCenter);
	/**
	 * Return an entity or a list of entities that have the given attribute District.
	 *
	 * @param district the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute District
	 */
	List<PatientEmploymentDetailEntity> findByDistrict(@NotNull String district);
	/**
	 * Return an entity or a list of entities that have the given attribute Designated Work Place.
	 *
	 * @param designatedWorkPlace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Designated Work Place
	 */
	List<PatientEmploymentDetailEntity> findByDesignatedWorkPlace(@NotNull String designatedWorkPlace);
	/**
	 * Return an entity or a list of entities that have the given attribute Bureau No.
	 *
	 * @param bureauNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bureau No
	 */
	List<PatientEmploymentDetailEntity> findByBureauNo(@NotNull String bureauNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Industry No.
	 *
	 * @param industryNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Industry No
	 */
	List<PatientEmploymentDetailEntity> findByIndustryNo(@NotNull String industryNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Employment Start Date.
	 *
	 * @param employmentStartDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employment Start Date
	 */
	List<PatientEmploymentDetailEntity> findByEmploymentStartDate(@NotNull OffsetDateTime employmentStartDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Passport No.
	 *
	 * @param passportNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Passport No
	 */
	List<PatientEmploymentDetailEntity> findByPassportNo(@NotNull String passportNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<PatientEmploymentDetailEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute Passport Country.
	 *
	 * @param passportCountry the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Passport Country
	 */
	List<PatientEmploymentDetailEntity> findByPassportCountry(@NotNull String passportCountry);
	/**
	 * Return an entity or a list of entities that have the given attribute Postal Address.
	 *
	 * @param postalAddress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postal Address
	 */
	List<PatientEmploymentDetailEntity> findByPostalAddress(@NotNull String postalAddress);
	/**
	 * Return an entity or a list of entities that have the given attribute Forwarding Address.
	 *
	 * @param forwardingAddress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Forwarding Address
	 */
	List<PatientEmploymentDetailEntity> findByForwardingAddress(@NotNull String forwardingAddress);
	/**
	 * Return an entity or a list of entities that have the given attribute Legal DIsability.
	 *
	 * @param legalDIsability the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Legal DIsability
	 */
	List<PatientEmploymentDetailEntity> findByLegalDIsability(@NotNull String legalDIsability);
	/**
	 * Return an entity or a list of entities that have the given attribute Legal Disability Notes.
	 *
	 * @param legalDisabilityNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Legal Disability Notes
	 */
	List<PatientEmploymentDetailEntity> findByLegalDisabilityNotes(@NotNull String legalDisabilityNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Worker Insurance.
	 *
	 * @param workerInsurance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Worker Insurance
	 */
	List<PatientEmploymentDetailEntity> findByWorkerInsurance(@NotNull String workerInsurance);
	/**
	 * Return an entity or a list of entities that have the given attribute Worker Insurance No.
	 *
	 * @param workerInsuranceNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Worker Insurance No
	 */
	List<PatientEmploymentDetailEntity> findByWorkerInsuranceNo(@NotNull String workerInsuranceNo);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientEmploymentDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientEmploymentDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}