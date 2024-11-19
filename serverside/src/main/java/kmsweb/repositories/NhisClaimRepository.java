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

import kmsweb.entities.NhisClaimEntity;
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
public interface NhisClaimRepository extends AbstractRepository<NhisClaimEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute System Claim ID.
	 *
	 * @param systemClaimID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute System Claim ID
	 */
	List<NhisClaimEntity> findBySystemClaimID(@NotNull String systemClaimID);
	/**
	 * Return an entity or a list of entities that have the given attribute Ref Invoice No.
	 *
	 * @param refInvoiceNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ref Invoice No
	 */
	List<NhisClaimEntity> findByRefInvoiceNo(@NotNull String refInvoiceNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Form No.
	 *
	 * @param formNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Form No
	 */
	List<NhisClaimEntity> findByFormNo(@NotNull String formNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Claim ID.
	 *
	 * @param claimID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim ID
	 */
	List<NhisClaimEntity> findByClaimID(@NotNull String claimID);
	/**
	 * Return an entity or a list of entities that have the given attribute Claim Check Code.
	 *
	 * @param claimCheckCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim Check Code
	 */
	List<NhisClaimEntity> findByClaimCheckCode(@NotNull String claimCheckCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Number.
	 *
	 * @param batchNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Number
	 */
	List<NhisClaimEntity> findByBatchNumber(@NotNull String batchNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Surname.
	 *
	 * @param surname the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surname
	 */
	List<NhisClaimEntity> findBySurname(@NotNull String surname);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Names.
	 *
	 * @param otherNames the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Names
	 */
	List<NhisClaimEntity> findByOtherNames(@NotNull String otherNames);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<NhisClaimEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Of Birth
	 */
	List<NhisClaimEntity> findByDateOfBirth(@NotNull OffsetDateTime dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Member No.
	 *
	 * @param memberNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Member No
	 */
	List<NhisClaimEntity> findByMemberNo(@NotNull String memberNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Record No.
	 *
	 * @param hospitalRecordNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Record No
	 */
	List<NhisClaimEntity> findByHospitalRecordNo(@NotNull String hospitalRecordNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Card Serial Number.
	 *
	 * @param cardSerialNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Serial Number
	 */
	List<NhisClaimEntity> findByCardSerialNumber(@NotNull String cardSerialNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Dependant.
	 *
	 * @param dependant the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependant
	 */
	List<NhisClaimEntity> findByDependant(@NotNull Boolean dependant);
	/**
	 * Return an entity or a list of entities that have the given attribute Unbundled.
	 *
	 * @param unbundled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unbundled
	 */
	List<NhisClaimEntity> findByUnbundled(@NotNull Boolean unbundled);
	/**
	 * Return an entity or a list of entities that have the given attribute Includes Pharmacy.
	 *
	 * @param includesPharmacy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Includes Pharmacy
	 */
	List<NhisClaimEntity> findByIncludesPharmacy(@NotNull Boolean includesPharmacy);
	/**
	 * Return an entity or a list of entities that have the given attribute Type Of Attendance.
	 *
	 * @param typeOfAttendance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Type Of Attendance
	 */
	List<NhisClaimEntity> findByTypeOfAttendance(@NotNull String typeOfAttendance);
	/**
	 * Return an entity or a list of entities that have the given attribute First Visit Admission.
	 *
	 * @param firstVisitAdmission the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Visit Admission
	 */
	List<NhisClaimEntity> findByFirstVisitAdmission(@NotNull OffsetDateTime firstVisitAdmission);
	/**
	 * Return an entity or a list of entities that have the given attribute Second Visit Discharge.
	 *
	 * @param secondVisitDischarge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Second Visit Discharge
	 */
	List<NhisClaimEntity> findBySecondVisitDischarge(@NotNull OffsetDateTime secondVisitDischarge);
	/**
	 * Return an entity or a list of entities that have the given attribute Third Visit.
	 *
	 * @param thirdVisit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Third Visit
	 */
	List<NhisClaimEntity> findByThirdVisit(@NotNull OffsetDateTime thirdVisit);
	/**
	 * Return an entity or a list of entities that have the given attribute Fourth Visit.
	 *
	 * @param fourthVisit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fourth Visit
	 */
	List<NhisClaimEntity> findByFourthVisit(@NotNull OffsetDateTime fourthVisit);
	/**
	 * Return an entity or a list of entities that have the given attribute Physician Name.
	 *
	 * @param physicianName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physician Name
	 */
	List<NhisClaimEntity> findByPhysicianName(@NotNull String physicianName);
	/**
	 * Return an entity or a list of entities that have the given attribute Physician Code.
	 *
	 * @param physicianCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physician Code
	 */
	List<NhisClaimEntity> findByPhysicianCode(@NotNull String physicianCode);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NhisClaimEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NhisClaimEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}