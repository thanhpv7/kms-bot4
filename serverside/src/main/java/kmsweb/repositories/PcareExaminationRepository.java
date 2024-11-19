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

import kmsweb.entities.PcareExaminationEntity;
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
public interface PcareExaminationRepository extends AbstractRepository<PcareExaminationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Visit Type.
	 *
	 * @param visitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Type
	 */
	List<PcareExaminationEntity> findByVisitType(@NotNull String visitType);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment.
	 *
	 * @param treatment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment
	 */
	List<PcareExaminationEntity> findByTreatment(@NotNull String treatment);
	/**
	 * Return an entity or a list of entities that have the given attribute Destination Polyclinic.
	 *
	 * @param destinationPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Destination Polyclinic
	 */
	List<PcareExaminationEntity> findByDestinationPolyclinic(@NotNull String destinationPolyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Disease.
	 *
	 * @param disease the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Disease
	 */
	List<PcareExaminationEntity> findByDisease(@NotNull String disease);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnosis.
	 *
	 * @param diagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnosis
	 */
	List<PcareExaminationEntity> findByDiagnosis(@NotNull String diagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnosis 2.
	 *
	 * @param diagnosis2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnosis 2
	 */
	List<PcareExaminationEntity> findByDiagnosis2(@NotNull String diagnosis2);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnosis 3.
	 *
	 * @param diagnosis3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnosis 3
	 */
	List<PcareExaminationEntity> findByDiagnosis3(@NotNull String diagnosis3);
	/**
	 * Return an entity or a list of entities that have the given attribute Therapy.
	 *
	 * @param therapy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Therapy
	 */
	List<PcareExaminationEntity> findByTherapy(@NotNull String therapy);
	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	List<PcareExaminationEntity> findByConsciousness(@NotNull String consciousness);
	/**
	 * Return an entity or a list of entities that have the given attribute Discharge Status.
	 *
	 * @param dischargeStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharge Status
	 */
	List<PcareExaminationEntity> findByDischargeStatus(@NotNull String dischargeStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Internal Referral Polyclinic.
	 *
	 * @param internalReferralPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Internal Referral Polyclinic
	 */
	List<PcareExaminationEntity> findByInternalReferralPolyclinic(@NotNull String internalReferralPolyclinic);
	/**
	 * Return an entity or a list of entities that have the given attribute Referring Date.
	 *
	 * @param referringDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Date
	 */
	List<PcareExaminationEntity> findByReferringDate(@NotNull OffsetDateTime referringDate);
	/**
	 * Return an entity or a list of entities that have the given attribute PKK.
	 *
	 * @param pkk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PKK
	 */
	List<PcareExaminationEntity> findByPkk(@NotNull String pkk);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Specialist.
	 *
	 * @param subSpecialist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Specialist
	 */
	List<PcareExaminationEntity> findBySubSpecialist(@NotNull String subSpecialist);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility.
	 *
	 * @param facility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility
	 */
	List<PcareExaminationEntity> findByFacility(@NotNull String facility);
	/**
	 * Return an entity or a list of entities that have the given attribute TACC.
	 *
	 * @param tacc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute TACC
	 */
	List<PcareExaminationEntity> findByTacc(@NotNull String tacc);
	/**
	 * Return an entity or a list of entities that have the given attribute TACC Reason.
	 *
	 * @param taccReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute TACC Reason
	 */
	List<PcareExaminationEntity> findByTaccReason(@NotNull String taccReason);
	/**
	 * Return an entity or a list of entities that have the given attribute Special.
	 *
	 * @param special the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Special
	 */
	List<PcareExaminationEntity> findBySpecial(@NotNull String special);
	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	List<PcareExaminationEntity> findByHeight(@NotNull Double height);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<PcareExaminationEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	List<PcareExaminationEntity> findByWaistCircumference(@NotNull Double waistCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute BMI.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BMI
	 */
	List<PcareExaminationEntity> findByBmi(@NotNull Double bmi);
	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	List<PcareExaminationEntity> findBySystole(@NotNull Integer systole);
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<PcareExaminationEntity> findByDiastole(@NotNull Integer diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory Rate.
	 *
	 * @param respiratoryRate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory Rate
	 */
	List<PcareExaminationEntity> findByRespiratoryRate(@NotNull Double respiratoryRate);
	/**
	 * Return an entity or a list of entities that have the given attribute Heart Rate.
	 *
	 * @param heartRate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heart Rate
	 */
	List<PcareExaminationEntity> findByHeartRate(@NotNull Double heartRate);
	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff.
	 *
	 * @param medicalStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff
	 */
	List<PcareExaminationEntity> findByMedicalStaff(@NotNull String medicalStaff);
	/**
	 * Return an entity or a list of entities that have the given attribute tglPulang.
	 *
	 * @param tglpulang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglPulang
	 */
	List<PcareExaminationEntity> findByTglpulang(@NotNull String tglpulang);
	/**
	 * Return an entity or a list of entities that have the given attribute kdSubSpesialis1.
	 *
	 * @param kdsubspesialis1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdSubSpesialis1
	 */
	List<PcareExaminationEntity> findByKdsubspesialis1(@NotNull String kdsubspesialis1);
	/**
	 * Return an entity or a list of entities that have the given attribute rujukLanjut.
	 *
	 * @param rujuklanjut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute rujukLanjut
	 */
	List<PcareExaminationEntity> findByRujuklanjut(@NotNull String rujuklanjut);
	/**
	 * Return an entity or a list of entities that have the given attribute catatan.
	 *
	 * @param catatan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute catatan
	 */
	List<PcareExaminationEntity> findByCatatan(@NotNull String catatan);
	/**
	 * Return an entity or a list of entities that have the given attribute noKunjungan.
	 *
	 * @param nokunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKunjungan
	 */
	List<PcareExaminationEntity> findByNokunjungan(@NotNull String nokunjungan);
	/**
	 * Return an entity or a list of entities that have the given attribute JsonInsert.
	 *
	 * @param jsoninsert the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute JsonInsert
	 */
	List<PcareExaminationEntity> findByJsoninsert(@NotNull String jsoninsert);
	/**
	 * Return an entity or a list of entities that have the given attribute JsonUpdate.
	 *
	 * @param jsonupdate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute JsonUpdate
	 */
	List<PcareExaminationEntity> findByJsonupdate(@NotNull String jsonupdate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareExaminationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PcareExaminationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}