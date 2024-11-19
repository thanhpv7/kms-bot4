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
import kmsweb.dtos.PatientVitalInformationEntityDto;
import kmsweb.entities.listeners.PatientVitalInformationEntityListener;
import kmsweb.serializers.PatientVitalInformationSerializer;
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
@EntityListeners({PatientVitalInformationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientVitalInformationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientVitalInformationEntity extends AbstractEntity {

	/**
	 * Takes a PatientVitalInformationEntityDto and converts it into a PatientVitalInformationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientVitalInformationEntityDto
	 */
	public PatientVitalInformationEntity(PatientVitalInformationEntityDto patientVitalInformationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientVitalInformationEntityDto.getId() != null) {
			this.setId(patientVitalInformationEntityDto.getId());
		}

		if (patientVitalInformationEntityDto.getRecordDateTime() != null) {
			this.setRecordDateTime(patientVitalInformationEntityDto.getRecordDateTime());
		}

		if (patientVitalInformationEntityDto.getSystole() != null) {
			this.setSystole(patientVitalInformationEntityDto.getSystole());
		}

		if (patientVitalInformationEntityDto.getDiastole() != null) {
			this.setDiastole(patientVitalInformationEntityDto.getDiastole());
		}

		if (patientVitalInformationEntityDto.getTemperature() != null) {
			this.setTemperature(patientVitalInformationEntityDto.getTemperature());
		}

		if (patientVitalInformationEntityDto.getTemperatureScale() != null) {
			this.setTemperatureScale(patientVitalInformationEntityDto.getTemperatureScale());
		}

		if (patientVitalInformationEntityDto.getConsciousness() != null) {
			this.setConsciousness(patientVitalInformationEntityDto.getConsciousness());
		}

		if (patientVitalInformationEntityDto.getPulse() != null) {
			this.setPulse(patientVitalInformationEntityDto.getPulse());
		}

		if (patientVitalInformationEntityDto.getPulseRhythm() != null) {
			this.setPulseRhythm(patientVitalInformationEntityDto.getPulseRhythm());
		}

		if (patientVitalInformationEntityDto.getStrength() != null) {
			this.setStrength(patientVitalInformationEntityDto.getStrength());
		}

		if (patientVitalInformationEntityDto.getGcsEyes() != null) {
			this.setGcsEyes(patientVitalInformationEntityDto.getGcsEyes());
		}

		if (patientVitalInformationEntityDto.getGcsVerbal() != null) {
			this.setGcsVerbal(patientVitalInformationEntityDto.getGcsVerbal());
		}

		if (patientVitalInformationEntityDto.getGcsMotor() != null) {
			this.setGcsMotor(patientVitalInformationEntityDto.getGcsMotor());
		}

		if (patientVitalInformationEntityDto.getTotalGcsScore() != null) {
			this.setTotalGcsScore(patientVitalInformationEntityDto.getTotalGcsScore());
		}

		if (patientVitalInformationEntityDto.getRespiratory() != null) {
			this.setRespiratory(patientVitalInformationEntityDto.getRespiratory());
		}

		if (patientVitalInformationEntityDto.getHeight() != null) {
			this.setHeight(patientVitalInformationEntityDto.getHeight());
		}

		if (patientVitalInformationEntityDto.getHeightScale() != null) {
			this.setHeightScale(patientVitalInformationEntityDto.getHeightScale());
		}

		if (patientVitalInformationEntityDto.getWeight() != null) {
			this.setWeight(patientVitalInformationEntityDto.getWeight());
		}

		if (patientVitalInformationEntityDto.getWeightScale() != null) {
			this.setWeightScale(patientVitalInformationEntityDto.getWeightScale());
		}

		if (patientVitalInformationEntityDto.getBmi() != null) {
			this.setBmi(patientVitalInformationEntityDto.getBmi());
		}

		if (patientVitalInformationEntityDto.getOxygenSaturation() != null) {
			this.setOxygenSaturation(patientVitalInformationEntityDto.getOxygenSaturation());
		}

		if (patientVitalInformationEntityDto.getNutritionStatus() != null) {
			this.setNutritionStatus(patientVitalInformationEntityDto.getNutritionStatus());
		}

		if (patientVitalInformationEntityDto.getWaistCircumference() != null) {
			this.setWaistCircumference(patientVitalInformationEntityDto.getWaistCircumference());
		}

		if (patientVitalInformationEntityDto.getWaistCircumferenceUnit() != null) {
			this.setWaistCircumferenceUnit(patientVitalInformationEntityDto.getWaistCircumferenceUnit());
		}

		if (patientVitalInformationEntityDto.getPainScale() != null) {
			this.setPainScale(patientVitalInformationEntityDto.getPainScale());
		}

		if (patientVitalInformationEntityDto.getPainScaleUsed() != null) {
			this.setPainScaleUsed(patientVitalInformationEntityDto.getPainScaleUsed());
		}

		if (patientVitalInformationEntityDto.getRiskFallScale() != null) {
			this.setRiskFallScale(patientVitalInformationEntityDto.getRiskFallScale());
		}

		if (patientVitalInformationEntityDto.getRiskFallScaleUsed() != null) {
			this.setRiskFallScaleUsed(patientVitalInformationEntityDto.getRiskFallScaleUsed());
		}

		if (patientVitalInformationEntityDto.getNotes() != null) {
			this.setNotes(patientVitalInformationEntityDto.getNotes());
		}

		if (patientVitalInformationEntityDto.getRegistration() != null) {
			this.setRegistration(patientVitalInformationEntityDto.getRegistration());
		}

		if (patientVitalInformationEntityDto.getStaff() != null) {
			this.setStaff(patientVitalInformationEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Record Date Time here] off begin
	@CsvCustomBindByName(column = "RECORD_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "record_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Record Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Record Date Time here] end
	private OffsetDateTime recordDateTime;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@CsvBindByName(column = "SYSTOLE", required = false)
	@Nullable
	@Column(name = "systole")
	@Schema(description = "The Systole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Systole here] end
	private Double systole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The Diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Double diastole;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@CsvBindByName(column = "TEMPERATURE", required = false)
	@Nullable
	@Column(name = "temperature")
	@Schema(description = "The Temperature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Scale here] off begin
	@CsvBindByName(column = "TEMPERATURE_SCALE", required = false)
	@Nullable
	@Column(name = "temperature_scale")
	@Schema(description = "The Temperature Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature Scale here] end
	private String temperatureScale;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@CsvBindByName(column = "CONSCIOUSNESS", required = false)
	@Nullable
	@Column(name = "consciousness")
	@Schema(description = "The Consciousness of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@CsvBindByName(column = "PULSE", required = false)
	@Nullable
	@Column(name = "pulse")
	@Schema(description = "The Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Double pulse;

	// % protected region % [Modify attribute annotation for Pulse Rhythm here] off begin
	@CsvBindByName(column = "PULSE_RHYTHM", required = false)
	@Nullable
	@Column(name = "pulse_rhythm")
	@Schema(description = "The Pulse Rhythm of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse Rhythm here] end
	private String pulseRhythm;

	// % protected region % [Modify attribute annotation for Strength here] off begin
	@CsvBindByName(column = "STRENGTH", required = false)
	@Nullable
	@Column(name = "strength")
	@Schema(description = "The Strength of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Strength here] end
	private String strength;

	// % protected region % [Modify attribute annotation for Gcs Eyes here] off begin
	@CsvBindByName(column = "GCS_EYES", required = false)
	@Nullable
	@Column(name = "gcs_eyes")
	@Schema(description = "The Gcs Eyes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gcs Eyes here] end
	private String gcsEyes;

	// % protected region % [Modify attribute annotation for Gcs Verbal here] off begin
	@CsvBindByName(column = "GCS_VERBAL", required = false)
	@Nullable
	@Column(name = "gcs_verbal")
	@Schema(description = "The Gcs Verbal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gcs Verbal here] end
	private String gcsVerbal;

	// % protected region % [Modify attribute annotation for Gcs Motor here] off begin
	@CsvBindByName(column = "GCS_MOTOR", required = false)
	@Nullable
	@Column(name = "gcs_motor")
	@Schema(description = "The Gcs Motor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gcs Motor here] end
	private String gcsMotor;

	// % protected region % [Modify attribute annotation for Total Gcs Score here] off begin
	@CsvBindByName(column = "TOTAL_GCS_SCORE", required = false)
	@Nullable
	@Column(name = "total_gcs_score")
	@Schema(description = "The Total Gcs Score of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Gcs Score here] end
	private Double totalGcsScore;

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@CsvBindByName(column = "RESPIRATORY", required = false)
	@Nullable
	@Column(name = "respiratory")
	@Schema(description = "The Respiratory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private String respiratory;

	// % protected region % [Modify attribute annotation for Height here] off begin
	@CsvBindByName(column = "HEIGHT", required = false)
	@Nullable
	@Column(name = "height")
	@Schema(description = "The Height of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Height here] end
	private Double height;

	// % protected region % [Modify attribute annotation for Height Scale here] off begin
	@CsvBindByName(column = "HEIGHT_SCALE", required = false)
	@Nullable
	@Column(name = "height_scale")
	@Schema(description = "The Height Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Height Scale here] end
	private String heightScale;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Scale here] off begin
	@CsvBindByName(column = "WEIGHT_SCALE", required = false)
	@Nullable
	@Column(name = "weight_scale")
	@Schema(description = "The Weight Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Scale here] end
	private String weightScale;

	// % protected region % [Modify attribute annotation for Bmi here] off begin
	@CsvBindByName(column = "BMI", required = false)
	@Nullable
	@Column(name = "bmi")
	@Schema(description = "The Bmi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bmi here] end
	private Double bmi;

	// % protected region % [Modify attribute annotation for Oxygen Saturation here] off begin
	@CsvBindByName(column = "OXYGEN_SATURATION", required = false)
	@Nullable
	@Column(name = "oxygen_saturation")
	@Schema(description = "The Oxygen Saturation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Oxygen Saturation here] end
	private Double oxygenSaturation;

	// % protected region % [Modify attribute annotation for Nutrition Status here] off begin
	@CsvBindByName(column = "NUTRITION_STATUS", required = false)
	@Nullable
	@Column(name = "nutrition_status")
	@Schema(description = "The Nutrition Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nutrition Status here] end
	private String nutritionStatus;

	// % protected region % [Modify attribute annotation for Waist Circumference here] off begin
	@CsvBindByName(column = "WAIST_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "waist_circumference")
	@Schema(description = "The Waist Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waist Circumference here] end
	private Double waistCircumference;

	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] off begin
	@CsvBindByName(column = "WAIST_CIRCUMFERENCE_UNIT", required = false)
	@Nullable
	@Column(name = "waist_circumference_unit")
	@Schema(description = "The Waist Circumference Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] end
	private String waistCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Pain Scale here] off begin
	@CsvBindByName(column = "PAIN_SCALE", required = false)
	@Nullable
	@Column(name = "pain_scale")
	@Schema(description = "The Pain Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pain Scale here] end
	private Double painScale;

	// % protected region % [Modify attribute annotation for Pain Scale Used here] off begin
	@CsvBindByName(column = "PAIN_SCALE_USED", required = false)
	@Nullable
	@Column(name = "pain_scale_used")
	@Schema(description = "The Pain Scale Used of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pain Scale Used here] end
	private String painScaleUsed;

	// % protected region % [Modify attribute annotation for Risk Fall Scale here] off begin
	@CsvBindByName(column = "RISK_FALL_SCALE", required = false)
	@Nullable
	@Column(name = "risk_fall_scale")
	@Schema(description = "The Risk Fall Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Risk Fall Scale here] end
	private Double riskFallScale;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@CsvBindByName(column = "RISK_FALL_SCALE_USED", required = false)
	@Nullable
	@Column(name = "risk_fall_scale_used")
	@Schema(description = "The Risk Fall Scale Used of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

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
	public void setRegistration(@NotNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removePatientVitalInformations(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addPatientVitalInformations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removePatientVitalInformations(this, false);
		}
		this.registration = null;
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
			this.staff.removePatientVitalInformations(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addPatientVitalInformations(this, false);
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
			this.staff.removePatientVitalInformations(this, false);
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
		return "RECORD_DATE_TIME,SYSTOLE,DIASTOLE,TEMPERATURE,TEMPERATURE_SCALE,CONSCIOUSNESS,PULSE,PULSE_RHYTHM,STRENGTH,GCS_EYES,GCS_VERBAL,GCS_MOTOR,TOTAL_GCS_SCORE,RESPIRATORY,HEIGHT,HEIGHT_SCALE,WEIGHT,WEIGHT_SCALE,BMI,OXYGEN_SATURATION,NUTRITION_STATUS,WAIST_CIRCUMFERENCE,WAIST_CIRCUMFERENCE_UNIT,PAIN_SCALE,PAIN_SCALE_USED,RISK_FALL_SCALE,RISK_FALL_SCALE_USED,NOTES,REGISTRATION_ID,STAFF_ID,ID";
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

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientVitalInformation) {
		if (this == patientVitalInformation) {
			return true;
		}
		if (patientVitalInformation == null || this.getClass() != patientVitalInformation.getClass()) {
			return false;
		}
		if (!super.equals(patientVitalInformation)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientVitalInformationEntity that = (PatientVitalInformationEntity) patientVitalInformation;
		return
			Objects.equals(
			     this.recordDateTime != null ? this.recordDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.recordDateTime != null ? that.recordDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.systole, that.systole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.temperature, that.temperature) &&
			Objects.equals(this.temperatureScale, that.temperatureScale) &&
			Objects.equals(this.consciousness, that.consciousness) &&
			Objects.equals(this.pulse, that.pulse) &&
			Objects.equals(this.pulseRhythm, that.pulseRhythm) &&
			Objects.equals(this.strength, that.strength) &&
			Objects.equals(this.gcsEyes, that.gcsEyes) &&
			Objects.equals(this.gcsVerbal, that.gcsVerbal) &&
			Objects.equals(this.gcsMotor, that.gcsMotor) &&
			Objects.equals(this.totalGcsScore, that.totalGcsScore) &&
			Objects.equals(this.respiratory, that.respiratory) &&
			Objects.equals(this.height, that.height) &&
			Objects.equals(this.heightScale, that.heightScale) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.weightScale, that.weightScale) &&
			Objects.equals(this.bmi, that.bmi) &&
			Objects.equals(this.oxygenSaturation, that.oxygenSaturation) &&
			Objects.equals(this.nutritionStatus, that.nutritionStatus) &&
			Objects.equals(this.waistCircumference, that.waistCircumference) &&
			Objects.equals(this.waistCircumferenceUnit, that.waistCircumferenceUnit) &&
			Objects.equals(this.painScale, that.painScale) &&
			Objects.equals(this.painScaleUsed, that.painScaleUsed) &&
			Objects.equals(this.riskFallScale, that.riskFallScale) &&
			Objects.equals(this.riskFallScaleUsed, that.riskFallScaleUsed) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
