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
import kmsweb.dtos.HemodialysisExaminationEntityDto;
import kmsweb.entities.listeners.HemodialysisExaminationEntityListener;
import kmsweb.serializers.HemodialysisExaminationSerializer;
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
@EntityListeners({HemodialysisExaminationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = HemodialysisExaminationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class HemodialysisExaminationEntity extends AbstractEntity {

	/**
	 * Takes a HemodialysisExaminationEntityDto and converts it into a HemodialysisExaminationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param hemodialysisExaminationEntityDto
	 */
	public HemodialysisExaminationEntity(HemodialysisExaminationEntityDto hemodialysisExaminationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (hemodialysisExaminationEntityDto.getId() != null) {
			this.setId(hemodialysisExaminationEntityDto.getId());
		}

		if (hemodialysisExaminationEntityDto.getFirstDialysis() != null) {
			this.setFirstDialysis(hemodialysisExaminationEntityDto.getFirstDialysis());
		}

		if (hemodialysisExaminationEntityDto.getDialysisFrequency() != null) {
			this.setDialysisFrequency(hemodialysisExaminationEntityDto.getDialysisFrequency());
		}

		if (hemodialysisExaminationEntityDto.getDialysisNo() != null) {
			this.setDialysisNo(hemodialysisExaminationEntityDto.getDialysisNo());
		}

		if (hemodialysisExaminationEntityDto.getHemodialysisType() != null) {
			this.setHemodialysisType(hemodialysisExaminationEntityDto.getHemodialysisType());
		}

		if (hemodialysisExaminationEntityDto.getCondition() != null) {
			this.setCondition(hemodialysisExaminationEntityDto.getCondition());
		}

		if (hemodialysisExaminationEntityDto.getVascularAccess() != null) {
			this.setVascularAccess(hemodialysisExaminationEntityDto.getVascularAccess());
		}

		if (hemodialysisExaminationEntityDto.getHeparinization() != null) {
			this.setHeparinization(hemodialysisExaminationEntityDto.getHeparinization());
		}

		if (hemodialysisExaminationEntityDto.getHeparinizationInitialDose() != null) {
			this.setHeparinizationInitialDose(hemodialysisExaminationEntityDto.getHeparinizationInitialDose());
		}

		if (hemodialysisExaminationEntityDto.getHeparinizationFollowUpDose() != null) {
			this.setHeparinizationFollowUpDose(hemodialysisExaminationEntityDto.getHeparinizationFollowUpDose());
		}

		if (hemodialysisExaminationEntityDto.getDialyzer() != null) {
			this.setDialyzer(hemodialysisExaminationEntityDto.getDialyzer());
		}

		if (hemodialysisExaminationEntityDto.getDialyzerType() != null) {
			this.setDialyzerType(hemodialysisExaminationEntityDto.getDialyzerType());
		}

		if (hemodialysisExaminationEntityDto.getDialysisFluid() != null) {
			this.setDialysisFluid(hemodialysisExaminationEntityDto.getDialysisFluid());
		}

		if (hemodialysisExaminationEntityDto.getDryWeight() != null) {
			this.setDryWeight(hemodialysisExaminationEntityDto.getDryWeight());
		}

		if (hemodialysisExaminationEntityDto.getDryWeightUnit() != null) {
			this.setDryWeightUnit(hemodialysisExaminationEntityDto.getDryWeightUnit());
		}

		if (hemodialysisExaminationEntityDto.getWeightUponArrival() != null) {
			this.setWeightUponArrival(hemodialysisExaminationEntityDto.getWeightUponArrival());
		}

		if (hemodialysisExaminationEntityDto.getWeightUponArrivalUnit() != null) {
			this.setWeightUponArrivalUnit(hemodialysisExaminationEntityDto.getWeightUponArrivalUnit());
		}

		if (hemodialysisExaminationEntityDto.getWeightDuringPreviousHemodialysis() != null) {
			this.setWeightDuringPreviousHemodialysis(hemodialysisExaminationEntityDto.getWeightDuringPreviousHemodialysis());
		}

		if (hemodialysisExaminationEntityDto.getWeightDuringPreviousHemodialysisUnit() != null) {
			this.setWeightDuringPreviousHemodialysisUnit(hemodialysisExaminationEntityDto.getWeightDuringPreviousHemodialysisUnit());
		}

		if (hemodialysisExaminationEntityDto.getAntiHIV() != null) {
			this.setAntiHIV(hemodialysisExaminationEntityDto.getAntiHIV());
		}

		if (hemodialysisExaminationEntityDto.getHbsag() != null) {
			this.setHbsag(hemodialysisExaminationEntityDto.getHbsag());
		}

		if (hemodialysisExaminationEntityDto.getAntiHCV() != null) {
			this.setAntiHCV(hemodialysisExaminationEntityDto.getAntiHCV());
		}

		if (hemodialysisExaminationEntityDto.getHemodialysisStartTime() != null) {
			this.setHemodialysisStartTime(hemodialysisExaminationEntityDto.getHemodialysisStartTime());
		}

		if (hemodialysisExaminationEntityDto.getHemodialysisEndTime() != null) {
			this.setHemodialysisEndTime(hemodialysisExaminationEntityDto.getHemodialysisEndTime());
		}

		if (hemodialysisExaminationEntityDto.getTarget() != null) {
			this.setTarget(hemodialysisExaminationEntityDto.getTarget());
		}

		if (hemodialysisExaminationEntityDto.getPrimingVolume() != null) {
			this.setPrimingVolume(hemodialysisExaminationEntityDto.getPrimingVolume());
		}

		if (hemodialysisExaminationEntityDto.getRemainingPriming() != null) {
			this.setRemainingPriming(hemodialysisExaminationEntityDto.getRemainingPriming());
		}

		if (hemodialysisExaminationEntityDto.getComplication() != null) {
			this.setComplication(hemodialysisExaminationEntityDto.getComplication());
		}

		if (hemodialysisExaminationEntityDto.getHemodialysisDetails() != null) {
			this.setHemodialysisDetails(hemodialysisExaminationEntityDto.getHemodialysisDetails());
		}

		if (hemodialysisExaminationEntityDto.getWeightUponDismissal() != null) {
			this.setWeightUponDismissal(hemodialysisExaminationEntityDto.getWeightUponDismissal());
		}

		if (hemodialysisExaminationEntityDto.getWeightUponDismissalUnit() != null) {
			this.setWeightUponDismissalUnit(hemodialysisExaminationEntityDto.getWeightUponDismissalUnit());
		}

		if (hemodialysisExaminationEntityDto.getPriming() != null) {
			this.setPriming(hemodialysisExaminationEntityDto.getPriming());
		}

		if (hemodialysisExaminationEntityDto.getBlood() != null) {
			this.setBlood(hemodialysisExaminationEntityDto.getBlood());
		}

		if (hemodialysisExaminationEntityDto.getIvLine() != null) {
			this.setIvLine(hemodialysisExaminationEntityDto.getIvLine());
		}

		if (hemodialysisExaminationEntityDto.getOral() != null) {
			this.setOral(hemodialysisExaminationEntityDto.getOral());
		}

		if (hemodialysisExaminationEntityDto.getWashOut() != null) {
			this.setWashOut(hemodialysisExaminationEntityDto.getWashOut());
		}

		if (hemodialysisExaminationEntityDto.getTotalFluidIntake() != null) {
			this.setTotalFluidIntake(hemodialysisExaminationEntityDto.getTotalFluidIntake());
		}

		if (hemodialysisExaminationEntityDto.getUrine() != null) {
			this.setUrine(hemodialysisExaminationEntityDto.getUrine());
		}

		if (hemodialysisExaminationEntityDto.getOthers() != null) {
			this.setOthers(hemodialysisExaminationEntityDto.getOthers());
		}

		if (hemodialysisExaminationEntityDto.getTotalFluidOutput() != null) {
			this.setTotalFluidOutput(hemodialysisExaminationEntityDto.getTotalFluidOutput());
		}

		if (hemodialysisExaminationEntityDto.getFluidBalance() != null) {
			this.setFluidBalance(hemodialysisExaminationEntityDto.getFluidBalance());
		}

		if (hemodialysisExaminationEntityDto.getPostHemodialysisEvaluation() != null) {
			this.setPostHemodialysisEvaluation(hemodialysisExaminationEntityDto.getPostHemodialysisEvaluation());
		}

		if (hemodialysisExaminationEntityDto.getHemodialysisMonitorings() != null) {
			this.setHemodialysisMonitorings(hemodialysisExaminationEntityDto.getHemodialysisMonitorings());
		}

		if (hemodialysisExaminationEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(hemodialysisExaminationEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for First Dialysis here] off begin
	@CsvCustomBindByName(column = "FIRST_DIALYSIS", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "first_dialysis")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The First Dialysis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for First Dialysis here] end
	private OffsetDateTime firstDialysis;

	// % protected region % [Modify attribute annotation for Dialysis Frequency here] off begin
	@CsvBindByName(column = "DIALYSIS_FREQUENCY", required = false)
	@Nullable
	@Column(name = "dialysis_frequency")
	@Schema(description = "The Dialysis Frequency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dialysis Frequency here] end
	private String dialysisFrequency;

	// % protected region % [Modify attribute annotation for Dialysis No here] off begin
	@CsvBindByName(column = "DIALYSIS_NO", required = false)
	@Nullable
	@Column(name = "dialysis_no")
	@Schema(description = "The Dialysis No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dialysis No here] end
	private String dialysisNo;

	// % protected region % [Modify attribute annotation for Hemodialysis Type here] off begin
	@CsvBindByName(column = "HEMODIALYSIS_TYPE", required = false)
	@Nullable
	@Column(name = "hemodialysis_type")
	@Schema(description = "The Hemodialysis Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hemodialysis Type here] end
	private String hemodialysisType;

	// % protected region % [Modify attribute annotation for Condition here] off begin
	@CsvBindByName(column = "CONDITION", required = false)
	@Nullable
	@Column(name = "condition")
	@Schema(description = "The Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Condition here] end
	private String condition;

	// % protected region % [Modify attribute annotation for Vascular Access here] off begin
	@CsvBindByName(column = "VASCULAR_ACCESS", required = false)
	@Nullable
	@Column(name = "vascular_access")
	@Schema(description = "The Vascular Access of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vascular Access here] end
	private String vascularAccess;

	// % protected region % [Modify attribute annotation for Heparinization here] off begin
	@CsvBindByName(column = "HEPARINIZATION", required = false)
	@Nullable
	@Column(name = "heparinization")
	@Schema(description = "The Heparinization of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Heparinization here] end
	private String heparinization;

	// % protected region % [Modify attribute annotation for Heparinization Initial Dose here] off begin
	@CsvBindByName(column = "HEPARINIZATION_INITIAL_DOSE", required = false)
	@Nullable
	@Column(name = "heparinization_initial_dose")
	@Schema(description = "The Heparinization Initial Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Heparinization Initial Dose here] end
	private String heparinizationInitialDose;

	// % protected region % [Modify attribute annotation for Heparinization Follow Up Dose here] off begin
	@CsvBindByName(column = "HEPARINIZATION_FOLLOW_UP_DOSE", required = false)
	@Nullable
	@Column(name = "heparinization_follow_up_dose")
	@Schema(description = "The Heparinization Follow Up Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Heparinization Follow Up Dose here] end
	private String heparinizationFollowUpDose;

	// % protected region % [Modify attribute annotation for Dialyzer here] off begin
	@CsvBindByName(column = "DIALYZER", required = false)
	@Nullable
	@Column(name = "dialyzer")
	@Schema(description = "The Dialyzer of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dialyzer here] end
	private String dialyzer;

	// % protected region % [Modify attribute annotation for Dialyzer Type here] off begin
	@CsvBindByName(column = "DIALYZER_TYPE", required = false)
	@Nullable
	@Column(name = "dialyzer_type")
	@Schema(description = "The Dialyzer Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dialyzer Type here] end
	private String dialyzerType;

	// % protected region % [Modify attribute annotation for Dialysis Fluid here] off begin
	@CsvBindByName(column = "DIALYSIS_FLUID", required = false)
	@Nullable
	@Column(name = "dialysis_fluid")
	@Schema(description = "The Dialysis Fluid of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dialysis Fluid here] end
	private String dialysisFluid;

	// % protected region % [Modify attribute annotation for Dry Weight here] off begin
	@CsvBindByName(column = "DRY_WEIGHT", required = false)
	@Nullable
	@Column(name = "dry_weight")
	@Schema(description = "The Dry Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dry Weight here] end
	private Double dryWeight;

	// % protected region % [Modify attribute annotation for Dry Weight Unit here] off begin
	@CsvBindByName(column = "DRY_WEIGHT_UNIT", required = false)
	@Nullable
	@Column(name = "dry_weight_unit")
	@Schema(description = "The Dry Weight Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dry Weight Unit here] end
	private String dryWeightUnit;

	// % protected region % [Modify attribute annotation for Weight Upon Arrival here] off begin
	@CsvBindByName(column = "WEIGHT_UPON_ARRIVAL", required = false)
	@Nullable
	@Column(name = "weight_upon_arrival")
	@Schema(description = "The Weight Upon Arrival of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Upon Arrival here] end
	private Double weightUponArrival;

	// % protected region % [Modify attribute annotation for Weight Upon Arrival Unit here] off begin
	@CsvBindByName(column = "WEIGHT_UPON_ARRIVAL_UNIT", required = false)
	@Nullable
	@Column(name = "weight_upon_arrival_unit")
	@Schema(description = "The Weight Upon Arrival Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Upon Arrival Unit here] end
	private String weightUponArrivalUnit;

	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis here] off begin
	@CsvBindByName(column = "WEIGHT_DURING_PREVIOUS_HEMODIALYSIS", required = false)
	@Nullable
	@Column(name = "weight_during_previous_hemodialysis")
	@Schema(description = "The Weight During Previous Hemodialysis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis here] end
	private Double weightDuringPreviousHemodialysis;

	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis Unit here] off begin
	@CsvBindByName(column = "WEIGHT_DURING_PREVIOUS_HEMODIALYSIS_UNIT", required = false)
	@Nullable
	@Column(name = "weight_during_previous_hemodialysis_unit")
	@Schema(description = "The Weight During Previous Hemodialysis Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis Unit here] end
	private String weightDuringPreviousHemodialysisUnit;

	// % protected region % [Modify attribute annotation for Anti HIV here] off begin
	@CsvBindByName(column = "ANTI_HIV", required = false)
	@Nullable
	@Column(name = "anti_hiv")
	@Schema(description = "The Anti HIV of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anti HIV here] end
	private Boolean antiHIV = false ;

	// % protected region % [Modify attribute annotation for HbsAg here] off begin
	@CsvBindByName(column = "HBSAG", required = false)
	@Nullable
	@Column(name = "hbsag")
	@Schema(description = "The HbsAg of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for HbsAg here] end
	private Boolean hbsag = false ;

	// % protected region % [Modify attribute annotation for Anti HCV here] off begin
	@CsvBindByName(column = "ANTI_HCV", required = false)
	@Nullable
	@Column(name = "anti_hcv")
	@Schema(description = "The Anti HCV of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anti HCV here] end
	private Boolean antiHCV = false ;

	// % protected region % [Modify attribute annotation for Hemodialysis Start Time here] off begin
	@CsvCustomBindByName(column = "HEMODIALYSIS_START_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "hemodialysis_start_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Hemodialysis Start Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hemodialysis Start Time here] end
	private OffsetDateTime hemodialysisStartTime;

	// % protected region % [Modify attribute annotation for Hemodialysis End Time here] off begin
	@CsvCustomBindByName(column = "HEMODIALYSIS_END_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "hemodialysis_end_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Hemodialysis End Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hemodialysis End Time here] end
	private OffsetDateTime hemodialysisEndTime;

	// % protected region % [Modify attribute annotation for Target here] off begin
	@CsvBindByName(column = "TARGET", required = false)
	@Nullable
	@Column(name = "target")
	@Schema(description = "The Target of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Target here] end
	private String target;

	// % protected region % [Modify attribute annotation for Priming Volume here] off begin
	@CsvBindByName(column = "PRIMING_VOLUME", required = false)
	@Nullable
	@Column(name = "priming_volume")
	@Schema(description = "The Priming Volume of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Priming Volume here] end
	private String primingVolume;

	// % protected region % [Modify attribute annotation for Remaining Priming here] off begin
	@CsvBindByName(column = "REMAINING_PRIMING", required = false)
	@Nullable
	@Column(name = "remaining_priming")
	@Schema(description = "The Remaining Priming of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Remaining Priming here] end
	private String remainingPriming;

	// % protected region % [Modify attribute annotation for Complication here] off begin
	@CsvBindByName(column = "COMPLICATION", required = false)
	@Nullable
	@Column(name = "complication")
	@Schema(description = "The Complication of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Complication here] end
	private String complication;

	// % protected region % [Modify attribute annotation for Hemodialysis Details here] off begin
	@CsvBindByName(column = "HEMODIALYSIS_DETAILS", required = false)
	@Nullable
	@Column(name = "hemodialysis_details")
	@Schema(description = "The Hemodialysis Details of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hemodialysis Details here] end
	private String hemodialysisDetails;

	// % protected region % [Modify attribute annotation for Weight Upon Dismissal here] off begin
	@CsvBindByName(column = "WEIGHT_UPON_DISMISSAL", required = false)
	@Nullable
	@Column(name = "weight_upon_dismissal")
	@Schema(description = "The Weight Upon Dismissal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Upon Dismissal here] end
	private Double weightUponDismissal;

	// % protected region % [Modify attribute annotation for Weight Upon Dismissal Unit here] off begin
	@CsvBindByName(column = "WEIGHT_UPON_DISMISSAL_UNIT", required = false)
	@Nullable
	@Column(name = "weight_upon_dismissal_unit")
	@Schema(description = "The Weight Upon Dismissal Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Upon Dismissal Unit here] end
	private String weightUponDismissalUnit;

	// % protected region % [Modify attribute annotation for Priming here] off begin
	@CsvBindByName(column = "PRIMING", required = false)
	@Nullable
	@Column(name = "priming")
	@Schema(description = "The Priming of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Priming here] end
	private Double priming;

	// % protected region % [Modify attribute annotation for Blood here] off begin
	@CsvBindByName(column = "BLOOD", required = false)
	@Nullable
	@Column(name = "blood")
	@Schema(description = "The Blood of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Blood here] end
	private Double blood;

	// % protected region % [Modify attribute annotation for IV Line here] off begin
	@CsvBindByName(column = "IV_LINE", required = false)
	@Nullable
	@Column(name = "iv_line")
	@Schema(description = "The IV Line of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for IV Line here] end
	private Double ivLine;

	// % protected region % [Modify attribute annotation for Oral here] off begin
	@CsvBindByName(column = "ORAL", required = false)
	@Nullable
	@Column(name = "oral")
	@Schema(description = "The Oral of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Oral here] end
	private Double oral;

	// % protected region % [Modify attribute annotation for Wash Out here] off begin
	@CsvBindByName(column = "WASH_OUT", required = false)
	@Nullable
	@Column(name = "wash_out")
	@Schema(description = "The Wash Out of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Wash Out here] end
	private Double washOut;

	// % protected region % [Modify attribute annotation for Total Fluid Intake here] off begin
	@CsvBindByName(column = "TOTAL_FLUID_INTAKE", required = false)
	@Nullable
	@Column(name = "total_fluid_intake")
	@Schema(description = "The Total Fluid Intake of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Fluid Intake here] end
	private Double totalFluidIntake;

	// % protected region % [Modify attribute annotation for Urine here] off begin
	@CsvBindByName(column = "URINE", required = false)
	@Nullable
	@Column(name = "urine")
	@Schema(description = "The Urine of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Urine here] end
	private Double urine;

	// % protected region % [Modify attribute annotation for Others here] off begin
	@CsvBindByName(column = "OTHERS", required = false)
	@Nullable
	@Column(name = "others")
	@Schema(description = "The Others of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Others here] end
	private Double others;

	// % protected region % [Modify attribute annotation for Total Fluid Output here] off begin
	@CsvBindByName(column = "TOTAL_FLUID_OUTPUT", required = false)
	@Nullable
	@Column(name = "total_fluid_output")
	@Schema(description = "The Total Fluid Output of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Fluid Output here] end
	private Double totalFluidOutput;

	// % protected region % [Modify attribute annotation for Fluid Balance here] off begin
	@CsvBindByName(column = "FLUID_BALANCE", required = false)
	@Nullable
	@Column(name = "fluid_balance")
	@Schema(description = "The Fluid Balance of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fluid Balance here] end
	private Double fluidBalance;

	// % protected region % [Modify attribute annotation for Post Hemodialysis Evaluation here] off begin
	@CsvBindByName(column = "POST_HEMODIALYSIS_EVALUATION", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 500", max = 500)
	@Column(name = "post_hemodialysis_evaluation")
	@Schema(description = "The Post Hemodialysis Evaluation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Post Hemodialysis Evaluation here] end
	private String postHemodialysisEvaluation;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Hemodialysis Monitorings here] off begin
	@Schema(description = "The Hemodialysis Monitoring entities that are related to this entity.")
	@OneToMany(mappedBy = "hemodialysisExamination", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hemodialysis Monitorings here] end
	private Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();

	// % protected region % [Update the annotation for hemodialysisMonitoringsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "HEMODIALYSIS_MONITORINGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for hemodialysisMonitoringsIds here] end
	private Set<UUID> hemodialysisMonitoringsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NotNull HemodialysisMonitoringEntity entity) {
		addHemodialysisMonitorings(entity, true);
	}

	/**
	 * Add a new HemodialysisMonitoringEntity to hemodialysisMonitorings in this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity, boolean reverseAdd) {
		if (!this.hemodialysisMonitorings.contains(entity)) {
			hemodialysisMonitorings.add(entity);
			if (reverseAdd) {
				entity.setHemodialysisExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities) {
		addHemodialysisMonitorings(entities, true);
	}

	/**
	 * Add a new collection of HemodialysisMonitoringEntity to Hemodialysis Monitorings in this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be set to this entity
	 */
	public void removeHemodialysisMonitorings(@NotNull HemodialysisMonitoringEntity entity) {
		this.removeHemodialysisMonitorings(entity, true);
	}

	/**
	 * Remove the given HemodialysisMonitoringEntity from this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHemodialysisMonitorings(@NotNull HemodialysisMonitoringEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetHemodialysisExamination(false);
		}
		this.hemodialysisMonitorings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 */
	public void removeHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities) {
		this.removeHemodialysisMonitorings(entities, true);
	}

	/**
	 * Remove the given collection of HemodialysisMonitoringEntity from  to this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be set to this entity
	 */
	public void setHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities) {
		setHemodialysisMonitorings(entities, true);
	}

	/**
	 * Replace the current entities in Hemodialysis Monitorings with the given ones.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHemodialysisMonitorings(@NotNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {

		this.unsetHemodialysisMonitorings();
		this.hemodialysisMonitorings = new HashSet<>(entities);
		if (reverseAdd) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.setHemodialysisExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHemodialysisMonitorings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHemodialysisMonitorings() {
		this.unsetHemodialysisMonitorings(true);
	}

	/**
	 * Remove all the entities in Hemodialysis Monitorings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHemodialysisMonitorings(boolean doReverse) {
		if (doReverse) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.unsetHemodialysisExamination(false));
		}
		this.hemodialysisMonitorings.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetHemodialysisExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setHemodialysisExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetHemodialysisExamination();
		}
		this.medicalExaminationRecord = null;
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
		return "FIRST_DIALYSIS,DIALYSIS_FREQUENCY,DIALYSIS_NO,HEMODIALYSIS_TYPE,CONDITION,VASCULAR_ACCESS,HEPARINIZATION,HEPARINIZATION_INITIAL_DOSE,HEPARINIZATION_FOLLOW_UP_DOSE,DIALYZER,DIALYZER_TYPE,DIALYSIS_FLUID,DRY_WEIGHT,DRY_WEIGHT_UNIT,WEIGHT_UPON_ARRIVAL,WEIGHT_UPON_ARRIVAL_UNIT,WEIGHT_DURING_PREVIOUS_HEMODIALYSIS,WEIGHT_DURING_PREVIOUS_HEMODIALYSIS_UNIT,ANTI_HIV,HBSAG,ANTI_HCV,HEMODIALYSIS_START_TIME,HEMODIALYSIS_END_TIME,TARGET,PRIMING_VOLUME,REMAINING_PRIMING,COMPLICATION,HEMODIALYSIS_DETAILS,WEIGHT_UPON_DISMISSAL,WEIGHT_UPON_DISMISSAL_UNIT,PRIMING,BLOOD,IV_LINE,ORAL,WASH_OUT,TOTAL_FLUID_INTAKE,URINE,OTHERS,TOTAL_FLUID_OUTPUT,FLUID_BALANCE,POST_HEMODIALYSIS_EVALUATION,MEDICAL_EXAMINATION_RECORD_ID,HEMODIALYSIS_MONITORINGS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		this.hemodialysisMonitoringsIds = new HashSet<>();
		for (HemodialysisMonitoringEntity hemodialysisMonitorings: this.hemodialysisMonitorings) {
			this.hemodialysisMonitoringsIds.add(hemodialysisMonitorings.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object hemodialysisExamination) {
		if (this == hemodialysisExamination) {
			return true;
		}
		if (hemodialysisExamination == null || this.getClass() != hemodialysisExamination.getClass()) {
			return false;
		}
		if (!super.equals(hemodialysisExamination)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		HemodialysisExaminationEntity that = (HemodialysisExaminationEntity) hemodialysisExamination;
		return
			Objects.equals(
			     this.firstDialysis != null ? this.firstDialysis.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.firstDialysis != null ? that.firstDialysis.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.dialysisFrequency, that.dialysisFrequency) &&
			Objects.equals(this.dialysisNo, that.dialysisNo) &&
			Objects.equals(this.hemodialysisType, that.hemodialysisType) &&
			Objects.equals(this.condition, that.condition) &&
			Objects.equals(this.vascularAccess, that.vascularAccess) &&
			Objects.equals(this.heparinization, that.heparinization) &&
			Objects.equals(this.heparinizationInitialDose, that.heparinizationInitialDose) &&
			Objects.equals(this.heparinizationFollowUpDose, that.heparinizationFollowUpDose) &&
			Objects.equals(this.dialyzer, that.dialyzer) &&
			Objects.equals(this.dialyzerType, that.dialyzerType) &&
			Objects.equals(this.dialysisFluid, that.dialysisFluid) &&
			Objects.equals(this.dryWeight, that.dryWeight) &&
			Objects.equals(this.dryWeightUnit, that.dryWeightUnit) &&
			Objects.equals(this.weightUponArrival, that.weightUponArrival) &&
			Objects.equals(this.weightUponArrivalUnit, that.weightUponArrivalUnit) &&
			Objects.equals(this.weightDuringPreviousHemodialysis, that.weightDuringPreviousHemodialysis) &&
			Objects.equals(this.weightDuringPreviousHemodialysisUnit, that.weightDuringPreviousHemodialysisUnit) &&
			Objects.equals(this.antiHIV, that.antiHIV) &&
			Objects.equals(this.hbsag, that.hbsag) &&
			Objects.equals(this.antiHCV, that.antiHCV) &&
			Objects.equals(
			     this.hemodialysisStartTime != null ? this.hemodialysisStartTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.hemodialysisStartTime != null ? that.hemodialysisStartTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.hemodialysisEndTime != null ? this.hemodialysisEndTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.hemodialysisEndTime != null ? that.hemodialysisEndTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.target, that.target) &&
			Objects.equals(this.primingVolume, that.primingVolume) &&
			Objects.equals(this.remainingPriming, that.remainingPriming) &&
			Objects.equals(this.complication, that.complication) &&
			Objects.equals(this.hemodialysisDetails, that.hemodialysisDetails) &&
			Objects.equals(this.weightUponDismissal, that.weightUponDismissal) &&
			Objects.equals(this.weightUponDismissalUnit, that.weightUponDismissalUnit) &&
			Objects.equals(this.priming, that.priming) &&
			Objects.equals(this.blood, that.blood) &&
			Objects.equals(this.ivLine, that.ivLine) &&
			Objects.equals(this.oral, that.oral) &&
			Objects.equals(this.washOut, that.washOut) &&
			Objects.equals(this.totalFluidIntake, that.totalFluidIntake) &&
			Objects.equals(this.urine, that.urine) &&
			Objects.equals(this.others, that.others) &&
			Objects.equals(this.totalFluidOutput, that.totalFluidOutput) &&
			Objects.equals(this.fluidBalance, that.fluidBalance) &&
			Objects.equals(this.postHemodialysisEvaluation, that.postHemodialysisEvaluation) &&
			Objects.equals(this.hemodialysisMonitoringsIds, that.hemodialysisMonitoringsIds) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
