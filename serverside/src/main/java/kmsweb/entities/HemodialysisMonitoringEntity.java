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
import kmsweb.dtos.HemodialysisMonitoringEntityDto;
import kmsweb.entities.listeners.HemodialysisMonitoringEntityListener;
import kmsweb.serializers.HemodialysisMonitoringSerializer;
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
@EntityListeners({HemodialysisMonitoringEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = HemodialysisMonitoringSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class HemodialysisMonitoringEntity extends AbstractEntity {

	/**
	 * Takes a HemodialysisMonitoringEntityDto and converts it into a HemodialysisMonitoringEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param hemodialysisMonitoringEntityDto
	 */
	public HemodialysisMonitoringEntity(HemodialysisMonitoringEntityDto hemodialysisMonitoringEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (hemodialysisMonitoringEntityDto.getId() != null) {
			this.setId(hemodialysisMonitoringEntityDto.getId());
		}

		if (hemodialysisMonitoringEntityDto.getDatetime() != null) {
			this.setDatetime(hemodialysisMonitoringEntityDto.getDatetime());
		}

		if (hemodialysisMonitoringEntityDto.getSystole() != null) {
			this.setSystole(hemodialysisMonitoringEntityDto.getSystole());
		}

		if (hemodialysisMonitoringEntityDto.getDiastole() != null) {
			this.setDiastole(hemodialysisMonitoringEntityDto.getDiastole());
		}

		if (hemodialysisMonitoringEntityDto.getHeartRate() != null) {
			this.setHeartRate(hemodialysisMonitoringEntityDto.getHeartRate());
		}

		if (hemodialysisMonitoringEntityDto.getTemperature() != null) {
			this.setTemperature(hemodialysisMonitoringEntityDto.getTemperature());
		}

		if (hemodialysisMonitoringEntityDto.getTemperatureUnit() != null) {
			this.setTemperatureUnit(hemodialysisMonitoringEntityDto.getTemperatureUnit());
		}

		if (hemodialysisMonitoringEntityDto.getRespiratory() != null) {
			this.setRespiratory(hemodialysisMonitoringEntityDto.getRespiratory());
		}

		if (hemodialysisMonitoringEntityDto.getQb() != null) {
			this.setQb(hemodialysisMonitoringEntityDto.getQb());
		}

		if (hemodialysisMonitoringEntityDto.getQd() != null) {
			this.setQd(hemodialysisMonitoringEntityDto.getQd());
		}

		if (hemodialysisMonitoringEntityDto.getVenousPressure() != null) {
			this.setVenousPressure(hemodialysisMonitoringEntityDto.getVenousPressure());
		}

		if (hemodialysisMonitoringEntityDto.getTmp() != null) {
			this.setTmp(hemodialysisMonitoringEntityDto.getTmp());
		}

		if (hemodialysisMonitoringEntityDto.getUfg() != null) {
			this.setUfg(hemodialysisMonitoringEntityDto.getUfg());
		}

		if (hemodialysisMonitoringEntityDto.getUfr() != null) {
			this.setUfr(hemodialysisMonitoringEntityDto.getUfr());
		}

		if (hemodialysisMonitoringEntityDto.getUf() != null) {
			this.setUf(hemodialysisMonitoringEntityDto.getUf());
		}

		if (hemodialysisMonitoringEntityDto.getHemodialysisExamination() != null) {
			this.setHemodialysisExamination(hemodialysisMonitoringEntityDto.getHemodialysisExamination());
		}

		if (hemodialysisMonitoringEntityDto.getMedicalStaff() != null) {
			this.setMedicalStaff(hemodialysisMonitoringEntityDto.getMedicalStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for DateTime here] off begin
	@CsvCustomBindByName(column = "DATETIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "datetime")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The DateTime of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DateTime here] end
	private OffsetDateTime datetime;

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

	// % protected region % [Modify attribute annotation for Heart Rate here] off begin
	@CsvBindByName(column = "HEART_RATE", required = false)
	@Nullable
	@Column(name = "heart_rate")
	@Schema(description = "The Heart Rate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Heart Rate here] end
	private Double heartRate;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@CsvBindByName(column = "TEMPERATURE", required = false)
	@Nullable
	@Column(name = "temperature")
	@Schema(description = "The Temperature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Unit here] off begin
	@CsvBindByName(column = "TEMPERATURE_UNIT", required = false)
	@Nullable
	@Column(name = "temperature_unit")
	@Schema(description = "The Temperature Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature Unit here] end
	private String temperatureUnit;

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@CsvBindByName(column = "RESPIRATORY", required = false)
	@Nullable
	@Column(name = "respiratory")
	@Schema(description = "The Respiratory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private Double respiratory;

	// % protected region % [Modify attribute annotation for QB here] off begin
	@CsvBindByName(column = "QB", required = false)
	@Nullable
	@Column(name = "qb")
	@Schema(description = "The QB of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for QB here] end
	private Double qb;

	// % protected region % [Modify attribute annotation for QD here] off begin
	@CsvBindByName(column = "QD", required = false)
	@Nullable
	@Column(name = "qd")
	@Schema(description = "The QD of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for QD here] end
	private Double qd;

	// % protected region % [Modify attribute annotation for Venous Pressure here] off begin
	@CsvBindByName(column = "VENOUS_PRESSURE", required = false)
	@Nullable
	@Column(name = "venous_pressure")
	@Schema(description = "The Venous Pressure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Venous Pressure here] end
	private Double venousPressure;

	// % protected region % [Modify attribute annotation for TMP here] off begin
	@CsvBindByName(column = "TMP", required = false)
	@Nullable
	@Column(name = "tmp")
	@Schema(description = "The TMP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for TMP here] end
	private Double tmp;

	// % protected region % [Modify attribute annotation for UFG here] off begin
	@CsvBindByName(column = "UFG", required = false)
	@Nullable
	@Column(name = "ufg")
	@Schema(description = "The UFG of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UFG here] end
	private Double ufg;

	// % protected region % [Modify attribute annotation for UFR here] off begin
	@CsvBindByName(column = "UFR", required = false)
	@Nullable
	@Column(name = "ufr")
	@Schema(description = "The UFR of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UFR here] end
	private Double ufr;

	// % protected region % [Modify attribute annotation for UF here] off begin
	@CsvBindByName(column = "UF", required = false)
	@Nullable
	@Column(name = "uf")
	@Schema(description = "The UF of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UF here] end
	private Double uf;

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

	// % protected region % [Update the annotation for Hemodialysis Examination here] off begin
	@Schema(description = "The Hemodialysis Examination entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hemodialysis Examination here] end
	private HemodialysisExaminationEntity hemodialysisExamination;

	// % protected region % [Update the annotation for hemodialysisExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "HEMODIALYSIS_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for hemodialysisExaminationId here] end
	private UUID hemodialysisExaminationId;

	// % protected region % [Update the annotation for Medical Staff here] off begin
	@Schema(description = "The Medical Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Staff here] end
	private StaffEntity medicalStaff;

	// % protected region % [Update the annotation for medicalStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalStaffId here] end
	private UUID medicalStaffId;

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
	 * Similar to {@link this#setHemodialysisExamination(HemodialysisExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisExaminationEntity to be set to this entity
	 */
	public void setHemodialysisExamination(@NotNull HemodialysisExaminationEntity entity) {
		setHemodialysisExamination(entity, true);
	}

	/**
	 * Set or update the hemodialysisExamination in this entity with single HemodialysisExaminationEntity.
	 *
	 * @param entity the given HemodialysisExaminationEntity to be set or updated to hemodialysisExamination
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setHemodialysisExamination(@NotNull HemodialysisExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] end

		if (sameAsFormer(this.hemodialysisExamination, entity)) {
			return;
		}

		if (this.hemodialysisExamination != null) {
			this.hemodialysisExamination.removeHemodialysisMonitorings(this, false);
		}
		this.hemodialysisExamination = entity;
		if (reverseAdd) {
			this.hemodialysisExamination.addHemodialysisMonitorings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetHemodialysisExamination(boolean)} but default to true.
	 */
	public void unsetHemodialysisExamination() {
		this.unsetHemodialysisExamination(true);
	}

	/**
	 * Remove Hemodialysis Examination in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetHemodialysisExamination(boolean reverse) {
		if (reverse && this.hemodialysisExamination != null) {
			this.hemodialysisExamination.removeHemodialysisMonitorings(this, false);
		}
		this.hemodialysisExamination = null;
	}
	/**
	 * Similar to {@link this#setMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalStaff(@NotNull StaffEntity entity) {
		setMedicalStaff(entity, true);
	}

	/**
	 * Set or update the medicalStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] end

		if (sameAsFormer(this.medicalStaff, entity)) {
			return;
		}

		if (this.medicalStaff != null) {
			this.medicalStaff.removeHemodialysisMonitorings(this, false);
		}
		this.medicalStaff = entity;
		if (reverseAdd) {
			this.medicalStaff.addHemodialysisMonitorings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalStaff(boolean)} but default to true.
	 */
	public void unsetMedicalStaff() {
		this.unsetMedicalStaff(true);
	}

	/**
	 * Remove Medical Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalStaff(boolean reverse) {
		if (reverse && this.medicalStaff != null) {
			this.medicalStaff.removeHemodialysisMonitorings(this, false);
		}
		this.medicalStaff = null;
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
		return "DATETIME,SYSTOLE,DIASTOLE,HEART_RATE,TEMPERATURE,TEMPERATURE_UNIT,RESPIRATORY,QB,QD,VENOUS_PRESSURE,TMP,UFG,UFR,UF,HEMODIALYSIS_EXAMINATION_ID,MEDICAL_STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<HemodialysisExaminationEntity> hemodialysisExaminationRelation = Optional.ofNullable(this.hemodialysisExamination);
		hemodialysisExaminationRelation.ifPresent(entity -> this.hemodialysisExaminationId = entity.getId());

		Optional<StaffEntity> medicalStaffRelation = Optional.ofNullable(this.medicalStaff);
		medicalStaffRelation.ifPresent(entity -> this.medicalStaffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object hemodialysisMonitoring) {
		if (this == hemodialysisMonitoring) {
			return true;
		}
		if (hemodialysisMonitoring == null || this.getClass() != hemodialysisMonitoring.getClass()) {
			return false;
		}
		if (!super.equals(hemodialysisMonitoring)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		HemodialysisMonitoringEntity that = (HemodialysisMonitoringEntity) hemodialysisMonitoring;
		return
			Objects.equals(
			     this.datetime != null ? this.datetime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.datetime != null ? that.datetime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.systole, that.systole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.heartRate, that.heartRate) &&
			Objects.equals(this.temperature, that.temperature) &&
			Objects.equals(this.temperatureUnit, that.temperatureUnit) &&
			Objects.equals(this.respiratory, that.respiratory) &&
			Objects.equals(this.qb, that.qb) &&
			Objects.equals(this.qd, that.qd) &&
			Objects.equals(this.venousPressure, that.venousPressure) &&
			Objects.equals(this.tmp, that.tmp) &&
			Objects.equals(this.ufg, that.ufg) &&
			Objects.equals(this.ufr, that.ufr) &&
			Objects.equals(this.uf, that.uf) &&
			Objects.equals(this.hemodialysisExaminationId, that.hemodialysisExaminationId) &&
			Objects.equals(this.medicalStaffId, that.medicalStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
