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

import kmsweb.entities.BpjsSearchControlLetterEntity;
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
public interface BpjsSearchControlLetterRepository extends AbstractRepository<BpjsSearchControlLetterEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Control Letter No.
	 *
	 * @param controlLetterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Letter No
	 */
	List<BpjsSearchControlLetterEntity> findByControlLetterNo(@NotNull String controlLetterNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Control Plan Date.
	 *
	 * @param controlPlanDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Plan Date
	 */
	List<BpjsSearchControlLetterEntity> findByControlPlanDate(@NotNull String controlPlanDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Date.
	 *
	 * @param date the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date
	 */
	List<BpjsSearchControlLetterEntity> findByDate(@NotNull String date);
	/**
	 * Return an entity or a list of entities that have the given attribute Control Type.
	 *
	 * @param controlType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Type
	 */
	List<BpjsSearchControlLetterEntity> findByControlType(@NotNull String controlType);
	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic.
	 *
	 * @param polyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic
	 */
	List<BpjsSearchControlLetterEntity> findByPolyclinic(@NotNull String polyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor.
	 *
	 * @param doctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor
	 */
	List<BpjsSearchControlLetterEntity> findByDoctor(@NotNull String doctor);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsSearchControlLetterEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsSearchControlLetterEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic Destination.
	 *
	 * @param polyclinicDestination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic Destination
	 */
	List<BpjsSearchControlLetterEntity> findByPolyclinicDestination(@NotNull String polyclinicDestination);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Destination.
	 *
	 * @param doctorDestination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Destination
	 */
	List<BpjsSearchControlLetterEntity> findByDoctorDestination(@NotNull String doctorDestination);
	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic Source.
	 *
	 * @param polyclinicSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic Source
	 */
	List<BpjsSearchControlLetterEntity> findByPolyclinicSource(@NotNull String polyclinicSource);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Source.
	 *
	 * @param doctorSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Source
	 */
	List<BpjsSearchControlLetterEntity> findByDoctorSource(@NotNull String doctorSource);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	List<BpjsSearchControlLetterEntity> findBySepDate(@NotNull String sepDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	List<BpjsSearchControlLetterEntity> findByTreatmentType(@NotNull String treatmentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BpjsSearchControlLetterEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	List<BpjsSearchControlLetterEntity> findByName(@NotNull String name);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<BpjsSearchControlLetterEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	List<BpjsSearchControlLetterEntity> findByDateOfBirth(@NotNull String dateOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Provider.
	 *
	 * @param provider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider
	 */
	List<BpjsSearchControlLetterEntity> findByProvider(@NotNull String provider);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Provider.
	 *
	 * @param referralProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Provider
	 */
	List<BpjsSearchControlLetterEntity> findByReferralProvider(@NotNull String referralProvider);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Source.
	 *
	 * @param referralSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Source
	 */
	List<BpjsSearchControlLetterEntity> findByReferralSource(@NotNull String referralSource);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	List<BpjsSearchControlLetterEntity> findByReferralNo(@NotNull String referralNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Date.
	 *
	 * @param referralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Date
	 */
	List<BpjsSearchControlLetterEntity> findByReferralDate(@NotNull String referralDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	List<BpjsSearchControlLetterEntity> findByDiagnose(@NotNull String diagnose);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSearchControlLetterEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsSearchControlLetterEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}