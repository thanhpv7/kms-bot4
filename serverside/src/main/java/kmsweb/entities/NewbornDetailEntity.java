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
import kmsweb.dtos.NewbornDetailEntityDto;
import kmsweb.entities.listeners.NewbornDetailEntityListener;
import kmsweb.serializers.NewbornDetailSerializer;
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
@EntityListeners({NewbornDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NewbornDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class NewbornDetailEntity extends AbstractEntity {

	/**
	 * Takes a NewbornDetailEntityDto and converts it into a NewbornDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param newbornDetailEntityDto
	 */
	public NewbornDetailEntity(NewbornDetailEntityDto newbornDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (newbornDetailEntityDto.getId() != null) {
			this.setId(newbornDetailEntityDto.getId());
		}

		if (newbornDetailEntityDto.getNewbornFirstName() != null) {
			this.setNewbornFirstName(newbornDetailEntityDto.getNewbornFirstName());
		}

		if (newbornDetailEntityDto.getNewbornLastName() != null) {
			this.setNewbornLastName(newbornDetailEntityDto.getNewbornLastName());
		}

		if (newbornDetailEntityDto.getDateTimeOfBirth() != null) {
			this.setDateTimeOfBirth(newbornDetailEntityDto.getDateTimeOfBirth());
		}

		if (newbornDetailEntityDto.getGender() != null) {
			this.setGender(newbornDetailEntityDto.getGender());
		}

		if (newbornDetailEntityDto.getDeliveryType() != null) {
			this.setDeliveryType(newbornDetailEntityDto.getDeliveryType());
		}

		if (newbornDetailEntityDto.getDeliveryTypeIndication() != null) {
			this.setDeliveryTypeIndication(newbornDetailEntityDto.getDeliveryTypeIndication());
		}

		if (newbornDetailEntityDto.getWeight() != null) {
			this.setWeight(newbornDetailEntityDto.getWeight());
		}

		if (newbornDetailEntityDto.getLength() != null) {
			this.setLength(newbornDetailEntityDto.getLength());
		}

		if (newbornDetailEntityDto.getWeightOfGestationalAge() != null) {
			this.setWeightOfGestationalAge(newbornDetailEntityDto.getWeightOfGestationalAge());
		}

		if (newbornDetailEntityDto.getHeadCircumference() != null) {
			this.setHeadCircumference(newbornDetailEntityDto.getHeadCircumference());
		}

		if (newbornDetailEntityDto.getChestCircumference() != null) {
			this.setChestCircumference(newbornDetailEntityDto.getChestCircumference());
		}

		if (newbornDetailEntityDto.getBirthCondition() != null) {
			this.setBirthCondition(newbornDetailEntityDto.getBirthCondition());
		}

		if (newbornDetailEntityDto.getNeonatalCase() != null) {
			this.setNeonatalCase(newbornDetailEntityDto.getNeonatalCase());
		}

		if (newbornDetailEntityDto.getCongenitalCondition() != null) {
			this.setCongenitalCondition(newbornDetailEntityDto.getCongenitalCondition());
		}

		if (newbornDetailEntityDto.getPhysicalExamination() != null) {
			this.setPhysicalExamination(newbornDetailEntityDto.getPhysicalExamination());
		}

		if (newbornDetailEntityDto.getApgar1MinuteAppearance() != null) {
			this.setApgar1MinuteAppearance(newbornDetailEntityDto.getApgar1MinuteAppearance());
		}

		if (newbornDetailEntityDto.getApgar5MinuteAppearance() != null) {
			this.setApgar5MinuteAppearance(newbornDetailEntityDto.getApgar5MinuteAppearance());
		}

		if (newbornDetailEntityDto.getApgar10MinuteAppearance() != null) {
			this.setApgar10MinuteAppearance(newbornDetailEntityDto.getApgar10MinuteAppearance());
		}

		if (newbornDetailEntityDto.getApgar1MinutePulse() != null) {
			this.setApgar1MinutePulse(newbornDetailEntityDto.getApgar1MinutePulse());
		}

		if (newbornDetailEntityDto.getApgar5MinutePulse() != null) {
			this.setApgar5MinutePulse(newbornDetailEntityDto.getApgar5MinutePulse());
		}

		if (newbornDetailEntityDto.getApgar10MinutePulse() != null) {
			this.setApgar10MinutePulse(newbornDetailEntityDto.getApgar10MinutePulse());
		}

		if (newbornDetailEntityDto.getApgar1MinuteGrimace() != null) {
			this.setApgar1MinuteGrimace(newbornDetailEntityDto.getApgar1MinuteGrimace());
		}

		if (newbornDetailEntityDto.getApgar5MinuteGrimace() != null) {
			this.setApgar5MinuteGrimace(newbornDetailEntityDto.getApgar5MinuteGrimace());
		}

		if (newbornDetailEntityDto.getApgar10MinuteGrimace() != null) {
			this.setApgar10MinuteGrimace(newbornDetailEntityDto.getApgar10MinuteGrimace());
		}

		if (newbornDetailEntityDto.getApgar1MinuteActivity() != null) {
			this.setApgar1MinuteActivity(newbornDetailEntityDto.getApgar1MinuteActivity());
		}

		if (newbornDetailEntityDto.getApgar5MinuteActivity() != null) {
			this.setApgar5MinuteActivity(newbornDetailEntityDto.getApgar5MinuteActivity());
		}

		if (newbornDetailEntityDto.getApgar10MinuteActivity() != null) {
			this.setApgar10MinuteActivity(newbornDetailEntityDto.getApgar10MinuteActivity());
		}

		if (newbornDetailEntityDto.getApgar1MinuteRespiration() != null) {
			this.setApgar1MinuteRespiration(newbornDetailEntityDto.getApgar1MinuteRespiration());
		}

		if (newbornDetailEntityDto.getApgar5MinuteRespiration() != null) {
			this.setApgar5MinuteRespiration(newbornDetailEntityDto.getApgar5MinuteRespiration());
		}

		if (newbornDetailEntityDto.getApgar10MinuteRespiration() != null) {
			this.setApgar10MinuteRespiration(newbornDetailEntityDto.getApgar10MinuteRespiration());
		}

		if (newbornDetailEntityDto.getApgar1MinuteScore() != null) {
			this.setApgar1MinuteScore(newbornDetailEntityDto.getApgar1MinuteScore());
		}

		if (newbornDetailEntityDto.getApgar5MinuteScore() != null) {
			this.setApgar5MinuteScore(newbornDetailEntityDto.getApgar5MinuteScore());
		}

		if (newbornDetailEntityDto.getApgar10MinuteScore() != null) {
			this.setApgar10MinuteScore(newbornDetailEntityDto.getApgar10MinuteScore());
		}

		if (newbornDetailEntityDto.getPediatricNurse() != null) {
			this.setPediatricNurse(newbornDetailEntityDto.getPediatricNurse());
		}

		if (newbornDetailEntityDto.getPatientId() != null) {
			this.setPatientId(newbornDetailEntityDto.getPatientId());
		}

		if (newbornDetailEntityDto.getRegistrationId() != null) {
			this.setRegistrationId(newbornDetailEntityDto.getRegistrationId());
		}

		if (newbornDetailEntityDto.getVitalSigns() != null) {
			this.setVitalSigns(newbornDetailEntityDto.getVitalSigns());
		}

		if (newbornDetailEntityDto.getDeliveryMedicalExaminationRecord() != null) {
			this.setDeliveryMedicalExaminationRecord(newbornDetailEntityDto.getDeliveryMedicalExaminationRecord());
		}

		if (newbornDetailEntityDto.getStaff() != null) {
			this.setStaff(newbornDetailEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Newborn First Name here] off begin
	@CsvBindByName(column = "NEWBORN_FIRST_NAME", required = false)
	@Nullable
	@Column(name = "newborn_first_name")
	@Schema(description = "The Newborn First Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Newborn First Name here] end
	private String newbornFirstName;

	// % protected region % [Modify attribute annotation for Newborn Last Name here] off begin
	@CsvBindByName(column = "NEWBORN_LAST_NAME", required = false)
	@Nullable
	@Column(name = "newborn_last_name")
	@Schema(description = "The Newborn Last Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Newborn Last Name here] end
	private String newbornLastName;

	// % protected region % [Modify attribute annotation for Date Time Of Birth here] off begin
	@CsvCustomBindByName(column = "DATE_TIME_OF_BIRTH", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_time_of_birth")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date Time Of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Time Of Birth here] end
	private OffsetDateTime dateTimeOfBirth;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = false)
	@Nullable
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Delivery Type here] off begin
	@CsvBindByName(column = "DELIVERY_TYPE", required = false)
	@Nullable
	@Column(name = "delivery_type")
	@Schema(description = "The Delivery Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Delivery Type here] end
	private String deliveryType;

	// % protected region % [Modify attribute annotation for Delivery Type Indication here] off begin
	@CsvBindByName(column = "DELIVERY_TYPE_INDICATION", required = false)
	@Nullable
	@Column(name = "delivery_type_indication")
	@Schema(description = "The Delivery Type Indication of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Delivery Type Indication here] end
	private String deliveryTypeIndication;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Integer weight;

	// % protected region % [Modify attribute annotation for Length here] off begin
	@CsvBindByName(column = "LENGTH", required = false)
	@Nullable
	@Column(name = "length")
	@Schema(description = "The Length of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Length here] end
	private Integer length;

	// % protected region % [Modify attribute annotation for Weight Of Gestational Age here] off begin
	@CsvBindByName(column = "WEIGHT_OF_GESTATIONAL_AGE", required = false)
	@Nullable
	@Column(name = "weight_of_gestational_age")
	@Schema(description = "The Weight Of Gestational Age of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Of Gestational Age here] end
	private String weightOfGestationalAge;

	// % protected region % [Modify attribute annotation for Head Circumference here] off begin
	@CsvBindByName(column = "HEAD_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "head_circumference")
	@Schema(description = "The Head Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Head Circumference here] end
	private Integer headCircumference;

	// % protected region % [Modify attribute annotation for Chest Circumference here] off begin
	@CsvBindByName(column = "CHEST_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "chest_circumference")
	@Schema(description = "The Chest Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chest Circumference here] end
	private Integer chestCircumference;

	// % protected region % [Modify attribute annotation for Birth Condition here] off begin
	@CsvBindByName(column = "BIRTH_CONDITION", required = false)
	@Nullable
	@Column(name = "birth_condition")
	@Schema(description = "The Birth Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Birth Condition here] end
	private String birthCondition;

	// % protected region % [Modify attribute annotation for Neonatal Case here] off begin
	@CsvBindByName(column = "NEONATAL_CASE", required = false)
	@Nullable
	@Column(name = "neonatal_case")
	@Schema(description = "The Neonatal Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Neonatal Case here] end
	private String neonatalCase;

	// % protected region % [Modify attribute annotation for Congenital Condition here] off begin
	@CsvBindByName(column = "CONGENITAL_CONDITION", required = false)
	@Nullable
	@Column(name = "congenital_condition")
	@Schema(description = "The Congenital Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Congenital Condition here] end
	private String congenitalCondition;

	// % protected region % [Modify attribute annotation for Physical Examination here] off begin
	@CsvBindByName(column = "PHYSICAL_EXAMINATION", required = false)
	@Nullable
	@Column(name = "physical_examination")
	@Schema(description = "The Physical Examination of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Physical Examination here] end
	private String physicalExamination;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Appearance here] off begin
	@CsvBindByName(column = "APGAR_1_MINUTE_APPEARANCE", required = false)
	@Nullable
	@Column(name = "apgar_1_minute_appearance")
	@Schema(description = "The APGAR 1 Minute Appearance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Appearance here] end
	private String apgar1MinuteAppearance;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Appearance here] off begin
	@CsvBindByName(column = "APGAR_5_MINUTE_APPEARANCE", required = false)
	@Nullable
	@Column(name = "apgar_5_minute_appearance")
	@Schema(description = "The APGAR 5 Minute Appearance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Appearance here] end
	private String apgar5MinuteAppearance;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Appearance here] off begin
	@CsvBindByName(column = "APGAR_10_MINUTE_APPEARANCE", required = false)
	@Nullable
	@Column(name = "apgar_10_minute_appearance")
	@Schema(description = "The APGAR 10 Minute Appearance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Appearance here] end
	private String apgar10MinuteAppearance;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Pulse here] off begin
	@CsvBindByName(column = "APGAR_1_MINUTE_PULSE", required = false)
	@Nullable
	@Column(name = "apgar_1_minute_pulse")
	@Schema(description = "The APGAR 1 Minute Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Pulse here] end
	private String apgar1MinutePulse;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Pulse here] off begin
	@CsvBindByName(column = "APGAR_5_MINUTE_PULSE", required = false)
	@Nullable
	@Column(name = "apgar_5_minute_pulse")
	@Schema(description = "The APGAR 5 Minute Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Pulse here] end
	private String apgar5MinutePulse;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Pulse here] off begin
	@CsvBindByName(column = "APGAR_10_MINUTE_PULSE", required = false)
	@Nullable
	@Column(name = "apgar_10_minute_pulse")
	@Schema(description = "The APGAR 10 Minute Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Pulse here] end
	private String apgar10MinutePulse;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Grimace here] off begin
	@CsvBindByName(column = "APGAR_1_MINUTE_GRIMACE", required = false)
	@Nullable
	@Column(name = "apgar_1_minute_grimace")
	@Schema(description = "The APGAR 1 Minute Grimace of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Grimace here] end
	private String apgar1MinuteGrimace;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Grimace here] off begin
	@CsvBindByName(column = "APGAR_5_MINUTE_GRIMACE", required = false)
	@Nullable
	@Column(name = "apgar_5_minute_grimace")
	@Schema(description = "The APGAR 5 Minute Grimace of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Grimace here] end
	private String apgar5MinuteGrimace;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Grimace here] off begin
	@CsvBindByName(column = "APGAR_10_MINUTE_GRIMACE", required = false)
	@Nullable
	@Column(name = "apgar_10_minute_grimace")
	@Schema(description = "The APGAR 10 Minute Grimace of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Grimace here] end
	private String apgar10MinuteGrimace;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Activity here] off begin
	@CsvBindByName(column = "APGAR_1_MINUTE_ACTIVITY", required = false)
	@Nullable
	@Column(name = "apgar_1_minute_activity")
	@Schema(description = "The APGAR 1 Minute Activity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Activity here] end
	private String apgar1MinuteActivity;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Activity here] off begin
	@CsvBindByName(column = "APGAR_5_MINUTE_ACTIVITY", required = false)
	@Nullable
	@Column(name = "apgar_5_minute_activity")
	@Schema(description = "The APGAR 5 Minute Activity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Activity here] end
	private String apgar5MinuteActivity;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Activity here] off begin
	@CsvBindByName(column = "APGAR_10_MINUTE_ACTIVITY", required = false)
	@Nullable
	@Column(name = "apgar_10_minute_activity")
	@Schema(description = "The APGAR 10 Minute Activity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Activity here] end
	private String apgar10MinuteActivity;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Respiration here] off begin
	@CsvBindByName(column = "APGAR_1_MINUTE_RESPIRATION", required = false)
	@Nullable
	@Column(name = "apgar_1_minute_respiration")
	@Schema(description = "The APGAR 1 Minute Respiration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Respiration here] end
	private String apgar1MinuteRespiration;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Respiration here] off begin
	@CsvBindByName(column = "APGAR_5_MINUTE_RESPIRATION", required = false)
	@Nullable
	@Column(name = "apgar_5_minute_respiration")
	@Schema(description = "The APGAR 5 Minute Respiration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Respiration here] end
	private String apgar5MinuteRespiration;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Respiration here] off begin
	@CsvBindByName(column = "APGAR_10_MINUTE_RESPIRATION", required = false)
	@Nullable
	@Column(name = "apgar_10_minute_respiration")
	@Schema(description = "The APGAR 10 Minute Respiration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Respiration here] end
	private String apgar10MinuteRespiration;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Score here] off begin
	@CsvBindByName(column = "APGAR_1_MINUTE_SCORE", required = false)
	@Nullable
	@Column(name = "apgar_1_minute_score")
	@Schema(description = "The APGAR 1 Minute Score of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Score here] end
	private String apgar1MinuteScore;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Score here] off begin
	@CsvBindByName(column = "APGAR_5_MINUTE_SCORE", required = false)
	@Nullable
	@Column(name = "apgar_5_minute_score")
	@Schema(description = "The APGAR 5 Minute Score of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Score here] end
	private String apgar5MinuteScore;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Score here] off begin
	@CsvBindByName(column = "APGAR_10_MINUTE_SCORE", required = false)
	@Nullable
	@Column(name = "apgar_10_minute_score")
	@Schema(description = "The APGAR 10 Minute Score of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Score here] end
	private String apgar10MinuteScore;

	// % protected region % [Modify attribute annotation for Pediatric Nurse here] off begin
	@CsvBindByName(column = "PEDIATRIC_NURSE", required = false)
	@Nullable
	@Column(name = "pediatric_nurse")
	@Schema(description = "The Pediatric Nurse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pediatric Nurse here] end
	private String pediatricNurse;

	// % protected region % [Modify attribute annotation for Patient Id here] off begin
	@CsvBindByName(column = "PATIENT_ID", required = false)
	@Nullable
	@Column(name = "patient_id")
	@Schema(description = "The Patient Id of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Id here] end
	private String patientId;

	// % protected region % [Modify attribute annotation for Registration Id here] off begin
	@CsvBindByName(column = "REGISTRATION_ID", required = false)
	@Nullable
	@Column(name = "registration_id")
	@Schema(description = "The Registration Id of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration Id here] end
	private String registrationId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Vital Signs here] off begin
	@Schema(description = "The Vital Signs entities that are related to this entity.")
	@OneToMany(mappedBy = "newbornDetail", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Vital Signs here] end
	private Set<VitalSignsEntity> vitalSigns = new HashSet<>();

	// % protected region % [Update the annotation for vitalSignsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "VITAL_SIGNS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for vitalSignsIds here] end
	private Set<UUID> vitalSignsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Delivery Medical Examination Record here] off begin
	@Schema(description = "The Delivery Medical Examination Record entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Delivery Medical Examination Record here] end
	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

	// % protected region % [Update the annotation for deliveryMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DELIVERY_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for deliveryMedicalExaminationRecordId here] end
	private UUID deliveryMedicalExaminationRecordId;

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addVitalSigns(VitalSignsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VitalSignsEntity to be added to this entity
	 */
	public void addVitalSigns(@NotNull VitalSignsEntity entity) {
		addVitalSigns(entity, true);
	}

	/**
	 * Add a new VitalSignsEntity to vitalSigns in this entity.
	 *
	 * @param entity the given VitalSignsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVitalSigns(@NonNull VitalSignsEntity entity, boolean reverseAdd) {
		if (!this.vitalSigns.contains(entity)) {
			vitalSigns.add(entity);
			if (reverseAdd) {
				entity.setNewbornDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVitalSigns(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VitalSignsEntity to be added to this entity
	 */
	public void addVitalSigns(@NotNull Collection<VitalSignsEntity> entities) {
		addVitalSigns(entities, true);
	}

	/**
	 * Add a new collection of VitalSignsEntity to Vital Signs in this entity.
	 *
	 * @param entities the given collection of VitalSignsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVitalSigns(@NonNull Collection<VitalSignsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVitalSigns(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVitalSigns(VitalSignsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VitalSignsEntity to be set to this entity
	 */
	public void removeVitalSigns(@NotNull VitalSignsEntity entity) {
		this.removeVitalSigns(entity, true);
	}

	/**
	 * Remove the given VitalSignsEntity from this entity.
	 *
	 * @param entity the given VitalSignsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVitalSigns(@NotNull VitalSignsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNewbornDetail(false);
		}
		this.vitalSigns.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVitalSigns(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VitalSignsEntity to be removed to this entity
	 */
	public void removeVitalSigns(@NotNull Collection<VitalSignsEntity> entities) {
		this.removeVitalSigns(entities, true);
	}

	/**
	 * Remove the given collection of VitalSignsEntity from  to this entity.
	 *
	 * @param entities the given collection of VitalSignsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVitalSigns(@NonNull Collection<VitalSignsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVitalSigns(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVitalSigns(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VitalSignsEntity to be set to this entity
	 */
	public void setVitalSigns(@NotNull Collection<VitalSignsEntity> entities) {
		setVitalSigns(entities, true);
	}

	/**
	 * Replace the current entities in Vital Signs with the given ones.
	 *
	 * @param entities the given collection of VitalSignsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVitalSigns(@NotNull Collection<VitalSignsEntity> entities, boolean reverseAdd) {

		this.unsetVitalSigns();
		this.vitalSigns = new HashSet<>(entities);
		if (reverseAdd) {
			this.vitalSigns.forEach(vitalSignsEntity -> vitalSignsEntity.setNewbornDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVitalSigns(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVitalSigns() {
		this.unsetVitalSigns(true);
	}

	/**
	 * Remove all the entities in Vital Signs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVitalSigns(boolean doReverse) {
		if (doReverse) {
			this.vitalSigns.forEach(vitalSignsEntity -> vitalSignsEntity.unsetNewbornDetail(false));
		}
		this.vitalSigns.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NotNull DeliveryMedicalExaminationRecordEntity entity) {
		setDeliveryMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the deliveryMedicalExaminationRecord in this entity with single DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set or updated to deliveryMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NotNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] end

		if (sameAsFormer(this.deliveryMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.removeNewbornDetails(this, false);
		}
		this.deliveryMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.deliveryMedicalExaminationRecord.addNewbornDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDeliveryMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDeliveryMedicalExaminationRecord() {
		this.unsetDeliveryMedicalExaminationRecord(true);
	}

	/**
	 * Remove Delivery Medical Examination Record in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDeliveryMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.removeNewbornDetails(this, false);
		}
		this.deliveryMedicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removePediatricianInCharge(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addPediatricianInCharge(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removePediatricianInCharge(this, false);
		}
		this.staff = null;
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
		return "NEWBORN_FIRST_NAME,NEWBORN_LAST_NAME,DATE_TIME_OF_BIRTH,GENDER,DELIVERY_TYPE,DELIVERY_TYPE_INDICATION,WEIGHT,LENGTH,WEIGHT_OF_GESTATIONAL_AGE,HEAD_CIRCUMFERENCE,CHEST_CIRCUMFERENCE,BIRTH_CONDITION,NEONATAL_CASE,CONGENITAL_CONDITION,PHYSICAL_EXAMINATION,APGAR_1_MINUTE_APPEARANCE,APGAR_5_MINUTE_APPEARANCE,APGAR_10_MINUTE_APPEARANCE,APGAR_1_MINUTE_PULSE,APGAR_5_MINUTE_PULSE,APGAR_10_MINUTE_PULSE,APGAR_1_MINUTE_GRIMACE,APGAR_5_MINUTE_GRIMACE,APGAR_10_MINUTE_GRIMACE,APGAR_1_MINUTE_ACTIVITY,APGAR_5_MINUTE_ACTIVITY,APGAR_10_MINUTE_ACTIVITY,APGAR_1_MINUTE_RESPIRATION,APGAR_5_MINUTE_RESPIRATION,APGAR_10_MINUTE_RESPIRATION,APGAR_1_MINUTE_SCORE,APGAR_5_MINUTE_SCORE,APGAR_10_MINUTE_SCORE,PEDIATRIC_NURSE,PATIENT_ID,REGISTRATION_ID,DELIVERY_MEDICAL_EXAMINATION_RECORD_ID,STAFF_ID,VITAL_SIGNS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordRelation = Optional.ofNullable(this.deliveryMedicalExaminationRecord);
		deliveryMedicalExaminationRecordRelation.ifPresent(entity -> this.deliveryMedicalExaminationRecordId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		this.vitalSignsIds = new HashSet<>();
		for (VitalSignsEntity vitalSigns: this.vitalSigns) {
			this.vitalSignsIds.add(vitalSigns.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object newbornDetail) {
		if (this == newbornDetail) {
			return true;
		}
		if (newbornDetail == null || this.getClass() != newbornDetail.getClass()) {
			return false;
		}
		if (!super.equals(newbornDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NewbornDetailEntity that = (NewbornDetailEntity) newbornDetail;
		return
			Objects.equals(this.newbornFirstName, that.newbornFirstName) &&
			Objects.equals(this.newbornLastName, that.newbornLastName) &&
			Objects.equals(
			     this.dateTimeOfBirth != null ? this.dateTimeOfBirth.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dateTimeOfBirth != null ? that.dateTimeOfBirth.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.deliveryType, that.deliveryType) &&
			Objects.equals(this.deliveryTypeIndication, that.deliveryTypeIndication) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.length, that.length) &&
			Objects.equals(this.weightOfGestationalAge, that.weightOfGestationalAge) &&
			Objects.equals(this.headCircumference, that.headCircumference) &&
			Objects.equals(this.chestCircumference, that.chestCircumference) &&
			Objects.equals(this.birthCondition, that.birthCondition) &&
			Objects.equals(this.neonatalCase, that.neonatalCase) &&
			Objects.equals(this.congenitalCondition, that.congenitalCondition) &&
			Objects.equals(this.physicalExamination, that.physicalExamination) &&
			Objects.equals(this.apgar1MinuteAppearance, that.apgar1MinuteAppearance) &&
			Objects.equals(this.apgar5MinuteAppearance, that.apgar5MinuteAppearance) &&
			Objects.equals(this.apgar10MinuteAppearance, that.apgar10MinuteAppearance) &&
			Objects.equals(this.apgar1MinutePulse, that.apgar1MinutePulse) &&
			Objects.equals(this.apgar5MinutePulse, that.apgar5MinutePulse) &&
			Objects.equals(this.apgar10MinutePulse, that.apgar10MinutePulse) &&
			Objects.equals(this.apgar1MinuteGrimace, that.apgar1MinuteGrimace) &&
			Objects.equals(this.apgar5MinuteGrimace, that.apgar5MinuteGrimace) &&
			Objects.equals(this.apgar10MinuteGrimace, that.apgar10MinuteGrimace) &&
			Objects.equals(this.apgar1MinuteActivity, that.apgar1MinuteActivity) &&
			Objects.equals(this.apgar5MinuteActivity, that.apgar5MinuteActivity) &&
			Objects.equals(this.apgar10MinuteActivity, that.apgar10MinuteActivity) &&
			Objects.equals(this.apgar1MinuteRespiration, that.apgar1MinuteRespiration) &&
			Objects.equals(this.apgar5MinuteRespiration, that.apgar5MinuteRespiration) &&
			Objects.equals(this.apgar10MinuteRespiration, that.apgar10MinuteRespiration) &&
			Objects.equals(this.apgar1MinuteScore, that.apgar1MinuteScore) &&
			Objects.equals(this.apgar5MinuteScore, that.apgar5MinuteScore) &&
			Objects.equals(this.apgar10MinuteScore, that.apgar10MinuteScore) &&
			Objects.equals(this.pediatricNurse, that.pediatricNurse) &&
			Objects.equals(this.patientId, that.patientId) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.vitalSignsIds, that.vitalSignsIds) &&
			Objects.equals(this.deliveryMedicalExaminationRecordId, that.deliveryMedicalExaminationRecordId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
