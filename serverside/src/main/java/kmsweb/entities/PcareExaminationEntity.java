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

package kmsweb.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.PcareExaminationEntityDto;
import kmsweb.entities.listeners.PcareExaminationEntityListener;
import kmsweb.serializers.PcareExaminationSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({PcareExaminationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareExaminationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareExaminationEntity extends AbstractEntity {

	/**
	 * Takes a PcareExaminationEntityDto and converts it into a PcareExaminationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareExaminationEntityDto
	 */
	public PcareExaminationEntity(PcareExaminationEntityDto pcareExaminationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareExaminationEntityDto.getId() != null) {
			this.setId(pcareExaminationEntityDto.getId());
		}

		if (pcareExaminationEntityDto.getVisitType() != null) {
			this.setVisitType(pcareExaminationEntityDto.getVisitType());
		}

		if (pcareExaminationEntityDto.getTreatment() != null) {
			this.setTreatment(pcareExaminationEntityDto.getTreatment());
		}

		if (pcareExaminationEntityDto.getDestinationPolyclinic() != null) {
			this.setDestinationPolyclinic(pcareExaminationEntityDto.getDestinationPolyclinic());
		}

		if (pcareExaminationEntityDto.getDisease() != null) {
			this.setDisease(pcareExaminationEntityDto.getDisease());
		}

		if (pcareExaminationEntityDto.getDiagnosis() != null) {
			this.setDiagnosis(pcareExaminationEntityDto.getDiagnosis());
		}

		if (pcareExaminationEntityDto.getDiagnosis2() != null) {
			this.setDiagnosis2(pcareExaminationEntityDto.getDiagnosis2());
		}

		if (pcareExaminationEntityDto.getDiagnosis3() != null) {
			this.setDiagnosis3(pcareExaminationEntityDto.getDiagnosis3());
		}

		if (pcareExaminationEntityDto.getTherapy() != null) {
			this.setTherapy(pcareExaminationEntityDto.getTherapy());
		}

		if (pcareExaminationEntityDto.getConsciousness() != null) {
			this.setConsciousness(pcareExaminationEntityDto.getConsciousness());
		}

		if (pcareExaminationEntityDto.getDischargeStatus() != null) {
			this.setDischargeStatus(pcareExaminationEntityDto.getDischargeStatus());
		}

		if (pcareExaminationEntityDto.getInternalReferralPolyclinic() != null) {
			this.setInternalReferralPolyclinic(pcareExaminationEntityDto.getInternalReferralPolyclinic());
		}

		if (pcareExaminationEntityDto.getReferringDate() != null) {
			this.setReferringDate(pcareExaminationEntityDto.getReferringDate());
		}

		if (pcareExaminationEntityDto.getPkk() != null) {
			this.setPkk(pcareExaminationEntityDto.getPkk());
		}

		if (pcareExaminationEntityDto.getSubSpecialist() != null) {
			this.setSubSpecialist(pcareExaminationEntityDto.getSubSpecialist());
		}

		if (pcareExaminationEntityDto.getFacility() != null) {
			this.setFacility(pcareExaminationEntityDto.getFacility());
		}

		if (pcareExaminationEntityDto.getTacc() != null) {
			this.setTacc(pcareExaminationEntityDto.getTacc());
		}

		if (pcareExaminationEntityDto.getTaccReason() != null) {
			this.setTaccReason(pcareExaminationEntityDto.getTaccReason());
		}

		if (pcareExaminationEntityDto.getSpecial() != null) {
			this.setSpecial(pcareExaminationEntityDto.getSpecial());
		}

		if (pcareExaminationEntityDto.getHeight() != null) {
			this.setHeight(pcareExaminationEntityDto.getHeight());
		}

		if (pcareExaminationEntityDto.getWeight() != null) {
			this.setWeight(pcareExaminationEntityDto.getWeight());
		}

		if (pcareExaminationEntityDto.getWaistCircumference() != null) {
			this.setWaistCircumference(pcareExaminationEntityDto.getWaistCircumference());
		}

		if (pcareExaminationEntityDto.getBmi() != null) {
			this.setBmi(pcareExaminationEntityDto.getBmi());
		}

		if (pcareExaminationEntityDto.getSystole() != null) {
			this.setSystole(pcareExaminationEntityDto.getSystole());
		}

		if (pcareExaminationEntityDto.getDiastole() != null) {
			this.setDiastole(pcareExaminationEntityDto.getDiastole());
		}

		if (pcareExaminationEntityDto.getRespiratoryRate() != null) {
			this.setRespiratoryRate(pcareExaminationEntityDto.getRespiratoryRate());
		}

		if (pcareExaminationEntityDto.getHeartRate() != null) {
			this.setHeartRate(pcareExaminationEntityDto.getHeartRate());
		}

		if (pcareExaminationEntityDto.getMedicalStaff() != null) {
			this.setMedicalStaff(pcareExaminationEntityDto.getMedicalStaff());
		}

		if (pcareExaminationEntityDto.getTglpulang() != null) {
			this.setTglpulang(pcareExaminationEntityDto.getTglpulang());
		}

		if (pcareExaminationEntityDto.getKdsubspesialis1() != null) {
			this.setKdsubspesialis1(pcareExaminationEntityDto.getKdsubspesialis1());
		}

		if (pcareExaminationEntityDto.getRujuklanjut() != null) {
			this.setRujuklanjut(pcareExaminationEntityDto.getRujuklanjut());
		}

		if (pcareExaminationEntityDto.getCatatan() != null) {
			this.setCatatan(pcareExaminationEntityDto.getCatatan());
		}

		if (pcareExaminationEntityDto.getNokunjungan() != null) {
			this.setNokunjungan(pcareExaminationEntityDto.getNokunjungan());
		}

		if (pcareExaminationEntityDto.getJsoninsert() != null) {
			this.setJsoninsert(pcareExaminationEntityDto.getJsoninsert());
		}

		if (pcareExaminationEntityDto.getJsonupdate() != null) {
			this.setJsonupdate(pcareExaminationEntityDto.getJsonupdate());
		}

		if (pcareExaminationEntityDto.getPcareActionExaminations() != null) {
			this.setPcareActionExaminations(pcareExaminationEntityDto.getPcareActionExaminations());
		}

		if (pcareExaminationEntityDto.getPcareCompoundDrugs() != null) {
			this.setPcareCompoundDrugs(pcareExaminationEntityDto.getPcareCompoundDrugs());
		}

		if (pcareExaminationEntityDto.getPcareNonCompoundDrugs() != null) {
			this.setPcareNonCompoundDrugs(pcareExaminationEntityDto.getPcareNonCompoundDrugs());
		}

		if (pcareExaminationEntityDto.getRegistration() != null) {
			this.setRegistration(pcareExaminationEntityDto.getRegistration());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Visit Type here] off begin
	@CsvBindByName(column = "VISIT_TYPE", required = false)
	@Nullable
	@Column(name = "visit_type")
	@Schema(description = "The Visit Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Type here] end
	private String visitType;

	// % protected region % [Modify attribute annotation for Treatment here] off begin
	@CsvBindByName(column = "TREATMENT", required = false)
	@Nullable
	@Column(name = "treatment")
	@Schema(description = "The Treatment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment here] end
	private String treatment;

	// % protected region % [Modify attribute annotation for Destination Polyclinic here] off begin
	@CsvBindByName(column = "DESTINATION_POLYCLINIC", required = false)
	@Nullable
	@Column(name = "destination_polyclinic")
	@Schema(description = "The Destination Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Destination Polyclinic here] end
	private String destinationPolyclinic;

	// % protected region % [Modify attribute annotation for Disease here] off begin
	@CsvBindByName(column = "DISEASE", required = false)
	@Nullable
	@Column(name = "disease")
	@Schema(description = "The Disease of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Disease here] end
	private String disease;

	// % protected region % [Modify attribute annotation for Diagnosis here] off begin
	@CsvBindByName(column = "DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "diagnosis")
	@Schema(description = "The Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnosis here] end
	private String diagnosis;

	// % protected region % [Modify attribute annotation for Diagnosis 2 here] off begin
	@CsvBindByName(column = "DIAGNOSIS_2", required = false)
	@Nullable
	@Column(name = "diagnosis_2")
	@Schema(description = "The Diagnosis 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnosis 2 here] end
	private String diagnosis2;

	// % protected region % [Modify attribute annotation for Diagnosis 3 here] off begin
	@CsvBindByName(column = "DIAGNOSIS_3", required = false)
	@Nullable
	@Column(name = "diagnosis_3")
	@Schema(description = "The Diagnosis 3 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diagnosis 3 here] end
	private String diagnosis3;

	// % protected region % [Modify attribute annotation for Therapy here] off begin
	@CsvBindByName(column = "THERAPY", required = false)
	@Nullable
	@Column(name = "therapy")
	@Schema(description = "The Therapy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Therapy here] end
	private String therapy;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@CsvBindByName(column = "CONSCIOUSNESS", required = false)
	@Nullable
	@Column(name = "consciousness")
	@Schema(description = "The Consciousness of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

	// % protected region % [Modify attribute annotation for Discharge Status here] off begin
	@CsvBindByName(column = "DISCHARGE_STATUS", required = false)
	@Nullable
	@Column(name = "discharge_status")
	@Schema(description = "The Discharge Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discharge Status here] end
	private String dischargeStatus;

	// % protected region % [Modify attribute annotation for Internal Referral Polyclinic here] off begin
	@CsvBindByName(column = "INTERNAL_REFERRAL_POLYCLINIC", required = false)
	@Nullable
	@Column(name = "internal_referral_polyclinic")
	@Schema(description = "The Internal Referral Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Internal Referral Polyclinic here] end
	private String internalReferralPolyclinic;

	// % protected region % [Modify attribute annotation for Referring Date here] off begin
	@CsvCustomBindByName(column = "REFERRING_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "referring_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Referring Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referring Date here] end
	private OffsetDateTime referringDate;

	// % protected region % [Modify attribute annotation for PKK here] off begin
	@CsvBindByName(column = "PKK", required = false)
	@Nullable
	@Column(name = "pkk")
	@Schema(description = "The PKK of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for PKK here] end
	private String pkk;

	// % protected region % [Modify attribute annotation for Sub Specialist here] off begin
	@CsvBindByName(column = "SUB_SPECIALIST", required = false)
	@Nullable
	@Column(name = "sub_specialist")
	@Schema(description = "The Sub Specialist of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Specialist here] end
	private String subSpecialist;

	// % protected region % [Modify attribute annotation for Facility here] off begin
	@CsvBindByName(column = "FACILITY", required = false)
	@Nullable
	@Column(name = "facility")
	@Schema(description = "The Facility of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility here] end
	private String facility;

	// % protected region % [Modify attribute annotation for TACC here] off begin
	@CsvBindByName(column = "TACC", required = false)
	@Nullable
	@Column(name = "tacc")
	@Schema(description = "The TACC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for TACC here] end
	private String tacc;

	// % protected region % [Modify attribute annotation for TACC Reason here] off begin
	@CsvBindByName(column = "TACC_REASON", required = false)
	@Nullable
	@Column(name = "tacc_reason")
	@Schema(description = "The TACC Reason of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for TACC Reason here] end
	private String taccReason;

	// % protected region % [Modify attribute annotation for Special here] off begin
	@CsvBindByName(column = "SPECIAL", required = false)
	@Nullable
	@Column(name = "special")
	@Schema(description = "The Special of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Special here] end
	private String special;

	// % protected region % [Modify attribute annotation for Height here] off begin
	@CsvBindByName(column = "HEIGHT", required = false)
	@Nullable
	@Column(name = "height")
	@Schema(description = "The Height of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Height here] end
	private Double height;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Waist Circumference here] off begin
	@CsvBindByName(column = "WAIST_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "waist_circumference")
	@Schema(description = "The Waist Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waist Circumference here] end
	private Double waistCircumference;

	// % protected region % [Modify attribute annotation for BMI here] off begin
	@CsvBindByName(column = "BMI", required = false)
	@Nullable
	@Column(name = "bmi")
	@Schema(description = "The BMI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BMI here] end
	private Double bmi;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@CsvBindByName(column = "SYSTOLE", required = false)
	@Nullable
	@Column(name = "systole")
	@Schema(description = "The Systole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Systole here] end
	private Integer systole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The Diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Integer diastole;

	// % protected region % [Modify attribute annotation for Respiratory Rate here] off begin
	@CsvBindByName(column = "RESPIRATORY_RATE", required = false)
	@Nullable
	@Column(name = "respiratory_rate")
	@Schema(description = "The Respiratory Rate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Respiratory Rate here] end
	private Double respiratoryRate;

	// % protected region % [Modify attribute annotation for Heart Rate here] off begin
	@CsvBindByName(column = "HEART_RATE", required = false)
	@Nullable
	@Column(name = "heart_rate")
	@Schema(description = "The Heart Rate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Heart Rate here] end
	private Double heartRate;

	// % protected region % [Modify attribute annotation for Medical Staff here] off begin
	@CsvBindByName(column = "MEDICAL_STAFF", required = false)
	@Nullable
	@Column(name = "medical_staff")
	@Schema(description = "The Medical Staff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Staff here] end
	private String medicalStaff;

	// % protected region % [Modify attribute annotation for tglPulang here] off begin
	@CsvBindByName(column = "TGLPULANG", required = false)
	@Nullable
	@Column(name = "tglpulang")
	@Schema(description = "The tglPulang of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglPulang here] end
	private String tglpulang;

	// % protected region % [Modify attribute annotation for kdSubSpesialis1 here] off begin
	@CsvBindByName(column = "KDSUBSPESIALIS1", required = false)
	@Nullable
	@Column(name = "kdsubspesialis1")
	@Schema(description = "The kdSubSpesialis1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdSubSpesialis1 here] end
	private String kdsubspesialis1;

	// % protected region % [Modify attribute annotation for rujukLanjut here] off begin
	@CsvBindByName(column = "RUJUKLANJUT", required = false)
	@Nullable
	@Column(name = "rujuklanjut")
	@Schema(description = "The rujukLanjut of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for rujukLanjut here] end
	private String rujuklanjut;

	// % protected region % [Modify attribute annotation for catatan here] off begin
	@CsvBindByName(column = "CATATAN", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 1000", max = 1000)
	@Column(name = "catatan")
	@Schema(description = "The catatan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for catatan here] end
	private String catatan;

	// % protected region % [Modify attribute annotation for noKunjungan here] off begin
	@CsvBindByName(column = "NOKUNJUNGAN", required = false)
	@Nullable
	@Column(name = "nokunjungan")
	@Schema(description = "The noKunjungan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noKunjungan here] end
	private String nokunjungan;

	// % protected region % [Modify attribute annotation for JsonInsert here] off begin
	@CsvBindByName(column = "JSONINSERT", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "jsoninsert")
	@Schema(description = "The JsonInsert of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for JsonInsert here] end
	private String jsoninsert;

	// % protected region % [Modify attribute annotation for JsonUpdate here] off begin
	@CsvBindByName(column = "JSONUPDATE", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "jsonupdate")
	@Schema(description = "The JsonUpdate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for JsonUpdate here] end
	private String jsonupdate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for PCare Action Examinations here] off begin
	@Schema(description = "The PCare Action Examination entities that are related to this entity.")
	@OneToMany(mappedBy = "pcareExamination", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Action Examinations here] end
	private Set<PcareActionExaminationEntity> pcareActionExaminations = new HashSet<>();

	// % protected region % [Update the annotation for pcareActionExaminationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_ACTION_EXAMINATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for pcareActionExaminationsIds here] end
	private Set<UUID> pcareActionExaminationsIds = new HashSet<>();

	// % protected region % [Update the annotation for PCare Compound Drugs here] off begin
	@Schema(description = "The PCare Compound Drug entities that are related to this entity.")
	@OneToMany(mappedBy = "pcareExamination", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Compound Drugs here] end
	private Set<PcareCompoundDrugEntity> pcareCompoundDrugs = new HashSet<>();

	// % protected region % [Update the annotation for pcareCompoundDrugsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_COMPOUND_DRUGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for pcareCompoundDrugsIds here] end
	private Set<UUID> pcareCompoundDrugsIds = new HashSet<>();

	// % protected region % [Update the annotation for PCare NonCompound Drugs here] off begin
	@Schema(description = "The PCare NonCompound Drug entities that are related to this entity.")
	@OneToMany(mappedBy = "pcareExamination", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare NonCompound Drugs here] end
	private Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugs = new HashSet<>();

	// % protected region % [Update the annotation for pcareNonCompoundDrugsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_NONCOMPOUND_DRUGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for pcareNonCompoundDrugsIds here] end
	private Set<UUID> pcareNonCompoundDrugsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addPcareActionExaminations(PcareActionExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareActionExaminationEntity to be added to this entity
	 */
	public void addPcareActionExaminations(@NotNull PcareActionExaminationEntity entity) {
		addPcareActionExaminations(entity, true);
	}

	/**
	 * Add a new PcareActionExaminationEntity to pcareActionExaminations in this entity.
	 *
	 * @param entity the given PcareActionExaminationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareActionExaminations(@NonNull PcareActionExaminationEntity entity, boolean reverseAdd) {
		if (!this.pcareActionExaminations.contains(entity)) {
			pcareActionExaminations.add(entity);
			if (reverseAdd) {
				entity.setPcareExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareActionExaminations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be added to this entity
	 */
	public void addPcareActionExaminations(@NotNull Collection<PcareActionExaminationEntity> entities) {
		addPcareActionExaminations(entities, true);
	}

	/**
	 * Add a new collection of PcareActionExaminationEntity to PCare Action Examinations in this entity.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareActionExaminations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareActionExaminations(PcareActionExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareActionExaminationEntity to be set to this entity
	 */
	public void removePcareActionExaminations(@NotNull PcareActionExaminationEntity entity) {
		this.removePcareActionExaminations(entity, true);
	}

	/**
	 * Remove the given PcareActionExaminationEntity from this entity.
	 *
	 * @param entity the given PcareActionExaminationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareActionExaminations(@NotNull PcareActionExaminationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareExamination(false);
		}
		this.pcareActionExaminations.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareActionExaminations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be removed to this entity
	 */
	public void removePcareActionExaminations(@NotNull Collection<PcareActionExaminationEntity> entities) {
		this.removePcareActionExaminations(entities, true);
	}

	/**
	 * Remove the given collection of PcareActionExaminationEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareActionExaminations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareActionExaminations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be set to this entity
	 */
	public void setPcareActionExaminations(@NotNull Collection<PcareActionExaminationEntity> entities) {
		setPcareActionExaminations(entities, true);
	}

	/**
	 * Replace the current entities in PCare Action Examinations with the given ones.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareActionExaminations(@NotNull Collection<PcareActionExaminationEntity> entities, boolean reverseAdd) {

		this.unsetPcareActionExaminations();
		this.pcareActionExaminations = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareActionExaminations.forEach(pcareActionExaminationsEntity -> pcareActionExaminationsEntity.setPcareExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareActionExaminations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareActionExaminations() {
		this.unsetPcareActionExaminations(true);
	}

	/**
	 * Remove all the entities in PCare Action Examinations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareActionExaminations(boolean doReverse) {
		if (doReverse) {
			this.pcareActionExaminations.forEach(pcareActionExaminationsEntity -> pcareActionExaminationsEntity.unsetPcareExamination(false));
		}
		this.pcareActionExaminations.clear();
	}

/**
	 * Similar to {@link this#addPcareCompoundDrugs(PcareCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be added to this entity
	 */
	public void addPcareCompoundDrugs(@NotNull PcareCompoundDrugEntity entity) {
		addPcareCompoundDrugs(entity, true);
	}

	/**
	 * Add a new PcareCompoundDrugEntity to pcareCompoundDrugs in this entity.
	 *
	 * @param entity the given PcareCompoundDrugEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareCompoundDrugs(@NonNull PcareCompoundDrugEntity entity, boolean reverseAdd) {
		if (!this.pcareCompoundDrugs.contains(entity)) {
			pcareCompoundDrugs.add(entity);
			if (reverseAdd) {
				entity.setPcareExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be added to this entity
	 */
	public void addPcareCompoundDrugs(@NotNull Collection<PcareCompoundDrugEntity> entities) {
		addPcareCompoundDrugs(entities, true);
	}

	/**
	 * Add a new collection of PcareCompoundDrugEntity to PCare Compound Drugs in this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugs(PcareCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be set to this entity
	 */
	public void removePcareCompoundDrugs(@NotNull PcareCompoundDrugEntity entity) {
		this.removePcareCompoundDrugs(entity, true);
	}

	/**
	 * Remove the given PcareCompoundDrugEntity from this entity.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareCompoundDrugs(@NotNull PcareCompoundDrugEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareExamination(false);
		}
		this.pcareCompoundDrugs.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be removed to this entity
	 */
	public void removePcareCompoundDrugs(@NotNull Collection<PcareCompoundDrugEntity> entities) {
		this.removePcareCompoundDrugs(entities, true);
	}

	/**
	 * Remove the given collection of PcareCompoundDrugEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be set to this entity
	 */
	public void setPcareCompoundDrugs(@NotNull Collection<PcareCompoundDrugEntity> entities) {
		setPcareCompoundDrugs(entities, true);
	}

	/**
	 * Replace the current entities in PCare Compound Drugs with the given ones.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareCompoundDrugs(@NotNull Collection<PcareCompoundDrugEntity> entities, boolean reverseAdd) {

		this.unsetPcareCompoundDrugs();
		this.pcareCompoundDrugs = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareCompoundDrugs.forEach(pcareCompoundDrugsEntity -> pcareCompoundDrugsEntity.setPcareExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareCompoundDrugs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareCompoundDrugs() {
		this.unsetPcareCompoundDrugs(true);
	}

	/**
	 * Remove all the entities in PCare Compound Drugs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareCompoundDrugs(boolean doReverse) {
		if (doReverse) {
			this.pcareCompoundDrugs.forEach(pcareCompoundDrugsEntity -> pcareCompoundDrugsEntity.unsetPcareExamination(false));
		}
		this.pcareCompoundDrugs.clear();
	}

/**
	 * Similar to {@link this#addPcareNonCompoundDrugs(PcareNonCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity to be added to this entity
	 */
	public void addPcareNonCompoundDrugs(@NotNull PcareNonCompoundDrugEntity entity) {
		addPcareNonCompoundDrugs(entity, true);
	}

	/**
	 * Add a new PcareNonCompoundDrugEntity to pcareNonCompoundDrugs in this entity.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareNonCompoundDrugs(@NonNull PcareNonCompoundDrugEntity entity, boolean reverseAdd) {
		if (!this.pcareNonCompoundDrugs.contains(entity)) {
			pcareNonCompoundDrugs.add(entity);
			if (reverseAdd) {
				entity.setPcareExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareNonCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be added to this entity
	 */
	public void addPcareNonCompoundDrugs(@NotNull Collection<PcareNonCompoundDrugEntity> entities) {
		addPcareNonCompoundDrugs(entities, true);
	}

	/**
	 * Add a new collection of PcareNonCompoundDrugEntity to PCare NonCompound Drugs in this entity.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareNonCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareNonCompoundDrugs(PcareNonCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity to be set to this entity
	 */
	public void removePcareNonCompoundDrugs(@NotNull PcareNonCompoundDrugEntity entity) {
		this.removePcareNonCompoundDrugs(entity, true);
	}

	/**
	 * Remove the given PcareNonCompoundDrugEntity from this entity.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareNonCompoundDrugs(@NotNull PcareNonCompoundDrugEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareExamination(false);
		}
		this.pcareNonCompoundDrugs.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareNonCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be removed to this entity
	 */
	public void removePcareNonCompoundDrugs(@NotNull Collection<PcareNonCompoundDrugEntity> entities) {
		this.removePcareNonCompoundDrugs(entities, true);
	}

	/**
	 * Remove the given collection of PcareNonCompoundDrugEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareNonCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareNonCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be set to this entity
	 */
	public void setPcareNonCompoundDrugs(@NotNull Collection<PcareNonCompoundDrugEntity> entities) {
		setPcareNonCompoundDrugs(entities, true);
	}

	/**
	 * Replace the current entities in PCare NonCompound Drugs with the given ones.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareNonCompoundDrugs(@NotNull Collection<PcareNonCompoundDrugEntity> entities, boolean reverseAdd) {

		this.unsetPcareNonCompoundDrugs();
		this.pcareNonCompoundDrugs = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareNonCompoundDrugs.forEach(pcareNonCompoundDrugsEntity -> pcareNonCompoundDrugsEntity.setPcareExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareNonCompoundDrugs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareNonCompoundDrugs() {
		this.unsetPcareNonCompoundDrugs(true);
	}

	/**
	 * Remove all the entities in PCare NonCompound Drugs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareNonCompoundDrugs(boolean doReverse) {
		if (doReverse) {
			this.pcareNonCompoundDrugs.forEach(pcareNonCompoundDrugsEntity -> pcareNonCompoundDrugsEntity.unsetPcareExamination(false));
		}
		this.pcareNonCompoundDrugs.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetPcareExamination(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setPcareExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetPcareExamination();
		}
		this.registration = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "VISIT_TYPE,TREATMENT,DESTINATION_POLYCLINIC,DISEASE,DIAGNOSIS,DIAGNOSIS_2,DIAGNOSIS_3,THERAPY,CONSCIOUSNESS,DISCHARGE_STATUS,INTERNAL_REFERRAL_POLYCLINIC,REFERRING_DATE,PKK,SUB_SPECIALIST,FACILITY,TACC,TACC_REASON,SPECIAL,HEIGHT,WEIGHT,WAIST_CIRCUMFERENCE,BMI,SYSTOLE,DIASTOLE,RESPIRATORY_RATE,HEART_RATE,MEDICAL_STAFF,TGLPULANG,KDSUBSPESIALIS1,RUJUKLANJUT,CATATAN,NOKUNJUNGAN,JSONINSERT,JSONUPDATE,REGISTRATION_ID,PCARE_ACTION_EXAMINATIONS_IDS,PCARE_COMPOUND_DRUGS_IDS,PCARE_NONCOMPOUND_DRUGS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		this.pcareActionExaminationsIds = new HashSet<>();
		for (PcareActionExaminationEntity pcareActionExaminations: this.pcareActionExaminations) {
			this.pcareActionExaminationsIds.add(pcareActionExaminations.getId());
		}

		this.pcareCompoundDrugsIds = new HashSet<>();
		for (PcareCompoundDrugEntity pcareCompoundDrugs: this.pcareCompoundDrugs) {
			this.pcareCompoundDrugsIds.add(pcareCompoundDrugs.getId());
		}

		this.pcareNonCompoundDrugsIds = new HashSet<>();
		for (PcareNonCompoundDrugEntity pcareNonCompoundDrugs: this.pcareNonCompoundDrugs) {
			this.pcareNonCompoundDrugsIds.add(pcareNonCompoundDrugs.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object pcareExamination) {
		if (this == pcareExamination) {
			return true;
		}
		if (pcareExamination == null || this.getClass() != pcareExamination.getClass()) {
			return false;
		}
		if (!super.equals(pcareExamination)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareExaminationEntity that = (PcareExaminationEntity) pcareExamination;
		return
			Objects.equals(this.visitType, that.visitType) &&
			Objects.equals(this.treatment, that.treatment) &&
			Objects.equals(this.destinationPolyclinic, that.destinationPolyclinic) &&
			Objects.equals(this.disease, that.disease) &&
			Objects.equals(this.diagnosis, that.diagnosis) &&
			Objects.equals(this.diagnosis2, that.diagnosis2) &&
			Objects.equals(this.diagnosis3, that.diagnosis3) &&
			Objects.equals(this.therapy, that.therapy) &&
			Objects.equals(this.consciousness, that.consciousness) &&
			Objects.equals(this.dischargeStatus, that.dischargeStatus) &&
			Objects.equals(this.internalReferralPolyclinic, that.internalReferralPolyclinic) &&
			Objects.equals(
			     this.referringDate != null ? this.referringDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.referringDate != null ? that.referringDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.pkk, that.pkk) &&
			Objects.equals(this.subSpecialist, that.subSpecialist) &&
			Objects.equals(this.facility, that.facility) &&
			Objects.equals(this.tacc, that.tacc) &&
			Objects.equals(this.taccReason, that.taccReason) &&
			Objects.equals(this.special, that.special) &&
			Objects.equals(this.height, that.height) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.waistCircumference, that.waistCircumference) &&
			Objects.equals(this.bmi, that.bmi) &&
			Objects.equals(this.systole, that.systole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.respiratoryRate, that.respiratoryRate) &&
			Objects.equals(this.heartRate, that.heartRate) &&
			Objects.equals(this.medicalStaff, that.medicalStaff) &&
			Objects.equals(this.tglpulang, that.tglpulang) &&
			Objects.equals(this.kdsubspesialis1, that.kdsubspesialis1) &&
			Objects.equals(this.rujuklanjut, that.rujuklanjut) &&
			Objects.equals(this.catatan, that.catatan) &&
			Objects.equals(this.nokunjungan, that.nokunjungan) &&
			Objects.equals(this.jsoninsert, that.jsoninsert) &&
			Objects.equals(this.jsonupdate, that.jsonupdate) &&
			Objects.equals(this.pcareActionExaminationsIds, that.pcareActionExaminationsIds) &&
			Objects.equals(this.pcareCompoundDrugsIds, that.pcareCompoundDrugsIds) &&
			Objects.equals(this.pcareNonCompoundDrugsIds, that.pcareNonCompoundDrugsIds) &&
			Objects.equals(this.registrationId, that.registrationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
